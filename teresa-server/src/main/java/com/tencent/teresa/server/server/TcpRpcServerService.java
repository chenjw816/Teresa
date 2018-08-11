package com.tencent.teresa.server.server;

import com.tencent.teresa.codec.IoPacketCodec;
import com.tencent.teresa.serializer.Serializer;
import com.tencent.teresa.server.ServerRpcHandler;
import com.tencent.teresa.worker.WorkerService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TcpRpcServerService extends AbstractRpcServerService {
    private static final Logger logger = LoggerFactory.getLogger(TcpRpcServerService.class);

    @Override
    public void start() throws Exception {
        String[] array = serverAddress.split(":");
        String host = array[0];
        int port = Integer.parseInt(array[1]);

        ServerBootstrap bootstrap = new ServerBootstrap();
        ChannelFuture future = bootstrap.group(new NioEventLoopGroup(1), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline()
                                .addLast("d", ioPacketCodec.getDecoder(channel))
                                .addLast("e", ioPacketCodec.getEncoder(channel))
                                .addLast(new ServerRpcHandler(workerService,methodHanlerMap,serializer));
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .bind(host,port);
        try {
            future.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (!future.isSuccess()) {
            throw new IllegalStateException("bind failed, addr has been used? addr: " + serverAddress, future.cause());
        }
        logger.info("tcp server start! ip:" + serverAddress);
    }

    @Override
    public void stop() {

    }


}
