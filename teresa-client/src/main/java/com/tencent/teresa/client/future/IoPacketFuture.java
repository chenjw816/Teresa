package com.tencent.teresa.client.future;

import com.tencent.teresa.codec.IoPacket;
import com.tencent.teresa.exception.RpcTimeoutException;

import java.util.concurrent.Future;

public interface IoPacketFuture<V> extends IoPacket {
    IoPacket getIoPacket();
    void setResult(V result);
    V get() throws Exception;
    boolean isDone();
}