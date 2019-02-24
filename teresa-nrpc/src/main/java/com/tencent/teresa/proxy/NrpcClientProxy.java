package com.tencent.teresa.proxy;

import com.tencent.teresa.client.AbstractRpcClientService;
import com.tencent.teresa.client.TcpRpcClient;
import com.tencent.teresa.client.spring.ClientProxy;
import com.tencent.teresa.packet.NrpcPacket;
import com.tencent.teresa.route.RouterInfo;
import com.tencent.teresa.serializer.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

@Component
public class NrpcClientProxy extends ClientProxy {
    private static final Logger logger = LoggerFactory.getLogger(NrpcClientProxy.class);

    @Autowired
    public NrpcClientProxy(Serializer serializer) {
        super(serializer);
    }

    public NrpcClientProxy(String bigCmd, Map<String, Map<String, Object>> methodAttrMap, TcpRpcClient tcpRpcClient) {
        super(bigCmd, methodAttrMap, tcpRpcClient);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args, Map<String, Object> attrMap) throws Throwable {
        NrpcPacket request = (NrpcPacket) args[1];
        //todo
//        request.getHead().setServiceName();
//        request.getHead().setServiceCmd();
        request.setCmd(bigCmd);
        String subCmd = (String)attrMap.get("subCmd");
        int timeout = (int)attrMap.get("timeout");
        request.setSubcmd(subCmd);
        request.setSeq(seq.getAndIncrement());
        request.setContent(args[0],serializer);
        RouterInfo routerInfo = ((AbstractRpcClientService)rpcClientService).getRouterService().route(bigCmd);
        request.setRouterAddr(routerInfo.getSocketAddress());

        try {
            NrpcPacket rsp = (NrpcPacket)rpcClientService.sync(request,timeout);
            byte[] bytes = rsp.getBody().toByteArray();
            return serializer.deserialize(method.getReturnType(),bytes);
        } catch (Exception e) {
            logger.error("do client rpc method err: ",e);
            throw e;
        }
    }
}