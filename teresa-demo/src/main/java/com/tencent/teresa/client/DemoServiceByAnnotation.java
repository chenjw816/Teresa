package com.tencent.teresa.client;

import com.tencent.teresa.client.spring.annotation.ClientMethod;
import com.tencent.teresa.client.spring.annotation.ClientService;
import com.tencent.teresa.packet.ILiveRequest;
import com.tencent.teresa.pb.AddExperienceReq;
import com.tencent.teresa.pb.AddExperienceRsp;

@ClientService(bigCmd = 0x123,proxy = "iliveClientProxy",client = "rpcClient")
public interface DemoServiceByAnnotation {
    @ClientMethod(cmd = 0x1,timeout = 100000)
    AddExperienceRsp addExp(AddExperienceReq req, ILiveRequest request);
}