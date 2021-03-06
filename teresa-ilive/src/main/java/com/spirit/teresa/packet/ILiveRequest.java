// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from ilive.proto

package com.spirit.teresa.packet;

import com.dyuproject.protostuff.*;
import com.spirit.teresa.serializer.Serializer;
import com.spirit.teresa.utils.U;
import com.spirit.teresa.codec.AbstractIoPacket;
import com.spirit.teresa.codec.IoPacket;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class ILiveRequest extends AbstractIoPacket implements Externalizable, Message<ILiveRequest>, Schema<ILiveRequest>
{

    public static Schema<ILiveRequest> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static ILiveRequest getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final ILiveRequest DEFAULT_INSTANCE = new ILiveRequest();

    
    private Integer version;
//    private Integer subCmd;
//    private Integer subCmd;
//    private Long seq;
    private Long uid;
    private ByteString binaryBody;
    private ByteString ex;
    private Integer clientType;
    private Integer clientIp;
    private Integer serviceIp;
    private String business;
    private ByteString authKey;
    private Integer authType;
    private Integer authIp;
    private Long authAppid;
    private Long tinyid;
    private Integer clientPort;
    private Integer flag;
    private String originalId;
    private String originalKey;
    private Integer originalKeyType;
    private Integer originalIdType;
    private Long originalAuthAppid;

    public ILiveRequest()
    {
        
    }

    // getters and setters

    // version

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    @Override
    public IoPacket newResponsePacket(IoPacket reqPacket, int ec, String message, Object body, Serializer serializer) {
        ILiveRequest request = (ILiveRequest) reqPacket;
        byte[] bytes = U.EMPTY_BYTES;
        if (body != null && serializer != null) {
            bytes = serializer.serialize(body);
        }
        ILiveResponse response = new ILiveResponse();
        response.setRouterAddr(request.getRouterAddr());
        response.setErrCode(ec);
        response.setErrMsg(message);
        response.setSeq(request.getSeq());
        response.setUid(request.getUid());
        response.setEx(ByteString.copyFrom(bytes));
        return response;
    }

    @Override
    public void setBizContentBytes(byte[] bizContentBytes) {
        setEx(ByteString.copyFrom(bizContentBytes));
    }

    @Override
    public byte[] getBizContentBytes() {
        return getEx().toByteArray();
    }

    // uid

    public Long getUid()
    {
        return uid;
    }

    public void setUid(Long uid)
    {
        this.uid = uid;
    }

    // binaryBody

    public ByteString getBinaryBody()
    {
        return binaryBody;
    }

    public void setBinaryBody(ByteString binaryBody)
    {
        this.binaryBody = binaryBody;
    }

    // ex

    public ByteString getEx()
    {
        return ex;
    }

    public void setEx(ByteString ex)
    {
        this.ex = ex;
    }

    // clientType

    public Integer getClientType()
    {
        return clientType;
    }

    public void setClientType(Integer clientType)
    {
        this.clientType = clientType;
    }

    // clientIp

    public Integer getClientIp()
    {
        return clientIp;
    }

    public void setClientIp(Integer clientIp)
    {
        this.clientIp = clientIp;
    }

    // serviceIp

    public Integer getServiceIp()
    {
        return serviceIp;
    }

    public void setServiceIp(Integer serviceIp)
    {
        this.serviceIp = serviceIp;
    }

    // business

    public String getBusiness()
    {
        return business;
    }

    public void setBusiness(String business)
    {
        this.business = business;
    }

    // authKey

    public ByteString getAuthKey()
    {
        return authKey;
    }

    public void setAuthKey(ByteString authKey)
    {
        this.authKey = authKey;
    }

    // authType

    public Integer getAuthType()
    {
        return authType;
    }

    public void setAuthType(Integer authType)
    {
        this.authType = authType;
    }

    // authIp

    public Integer getAuthIp()
    {
        return authIp;
    }

    public void setAuthIp(Integer authIp)
    {
        this.authIp = authIp;
    }

    // authAppid

    public Long getAuthAppid()
    {
        return authAppid;
    }

    public void setAuthAppid(Long authAppid)
    {
        this.authAppid = authAppid;
    }

    // tinyid

    public Long getTinyid()
    {
        return tinyid;
    }

    public void setTinyid(Long tinyid)
    {
        this.tinyid = tinyid;
    }

    // clientPort

    public Integer getClientPort()
    {
        return clientPort;
    }

    public void setClientPort(Integer clientPort)
    {
        this.clientPort = clientPort;
    }

    // flag

    public Integer getFlag()
    {
        return flag;
    }

    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }

    // originalId

    public String getOriginalId()
    {
        return originalId;
    }

    public void setOriginalId(String originalId)
    {
        this.originalId = originalId;
    }

    // originalKey

    public String getOriginalKey()
    {
        return originalKey;
    }

    public void setOriginalKey(String originalKey)
    {
        this.originalKey = originalKey;
    }

    // originalKeyType

    public Integer getOriginalKeyType()
    {
        return originalKeyType;
    }

    public void setOriginalKeyType(Integer originalKeyType)
    {
        this.originalKeyType = originalKeyType;
    }

    // originalIdType

    public Integer getOriginalIdType()
    {
        return originalIdType;
    }

    public void setOriginalIdType(Integer originalIdType)
    {
        this.originalIdType = originalIdType;
    }

    // originalAuthAppid

    public Long getOriginalAuthAppid()
    {
        return originalAuthAppid;
    }

    public void setOriginalAuthAppid(Long originalAuthAppid)
    {
        this.originalAuthAppid = originalAuthAppid;
    }

    @Override
    public boolean isRequest() {
        return true;
    }

    @Override
    public void setRequest(boolean isRequest) {

    }
    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<ILiveRequest> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public ILiveRequest newMessage()
    {
        return new ILiveRequest();
    }

    public Class<ILiveRequest> typeClass()
    {
        return ILiveRequest.class;
    }

    public String messageName()
    {
        return ILiveRequest.class.getSimpleName();
    }

    public String messageFullName()
    {
        return ILiveRequest.class.getName();
    }

    public boolean isInitialized(ILiveRequest message)
    {
        return true;
    }

    public void mergeFrom(Input input, ILiveRequest message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                case 1:
                    message.version = input.readUInt32();
                    break;
                case 2:
                    message.cmd = input.readUInt32();
                    break;
                case 3:
                    message.subCmd = input.readUInt32();
                    break;
                case 4:
                    message.seq = input.readUInt64();
                    break;
                case 5:
                    message.uid = input.readUInt64();
                    break;
                case 6:
                    message.binaryBody = input.readBytes();
                    break;
                case 7:
                    message.ex = input.readBytes();
                    break;
                case 8:
                    message.clientType = input.readUInt32();
                    break;
                case 9:
                    message.clientIp = input.readUInt32();
                    break;
                case 10:
                    message.serviceIp = input.readUInt32();
                    break;
                case 11:
                    message.business = input.readString();
                    break;
                case 12:
                    message.authKey = input.readBytes();
                    break;
                case 13:
                    message.authType = input.readUInt32();
                    break;
                case 14:
                    message.authIp = input.readUInt32();
                    break;
                case 15:
                    message.authAppid = input.readUInt64();
                    break;
                case 16:
                    message.tinyid = input.readUInt64();
                    break;
                case 17:
                    message.clientPort = input.readUInt32();
                    break;
                case 18:
                    message.flag = input.readUInt32();
                    break;
                case 19:
                    message.originalId = input.readString();
                    break;
                case 20:
                    message.originalKey = input.readString();
                    break;
                case 21:
                    message.originalKeyType = input.readUInt32();
                    break;
                case 22:
                    message.originalIdType = input.readUInt32();
                    break;
                case 23:
                    message.originalAuthAppid = input.readUInt64();
                    break;
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, ILiveRequest message) throws IOException
    {
        if(message.version != null)
            output.writeUInt32(1, message.version, false);

        if(message.cmd != null) {
            int cmd = Integer.valueOf((String)message.cmd);
            output.writeUInt32(2, cmd, false);
        }

        if(message.subCmd != null) {
            int subCmd = Integer.valueOf((String)message.subCmd);
            output.writeUInt32(3, subCmd, false);
        }

        if(message.seq != null)
            output.writeUInt64(4, message.seq, false);

        if(message.uid != null)
            output.writeUInt64(5, message.uid, false);

        if(message.binaryBody != null)
            output.writeBytes(6, message.binaryBody, false);

        if(message.ex != null)
            output.writeBytes(7, message.ex, false);

        if(message.clientType != null)
            output.writeUInt32(8, message.clientType, false);

        if(message.clientIp != null)
            output.writeUInt32(9, message.clientIp, false);

        if(message.serviceIp != null)
            output.writeUInt32(10, message.serviceIp, false);

        if(message.business != null)
            output.writeString(11, message.business, false);

        if(message.authKey != null)
            output.writeBytes(12, message.authKey, false);

        if(message.authType != null)
            output.writeUInt32(13, message.authType, false);

        if(message.authIp != null)
            output.writeUInt32(14, message.authIp, false);

        if(message.authAppid != null)
            output.writeUInt64(15, message.authAppid, false);

        if(message.tinyid != null)
            output.writeUInt64(16, message.tinyid, false);

        if(message.clientPort != null)
            output.writeUInt32(17, message.clientPort, false);

        if(message.flag != null)
            output.writeUInt32(18, message.flag, false);

        if(message.originalId != null)
            output.writeString(19, message.originalId, false);

        if(message.originalKey != null)
            output.writeString(20, message.originalKey, false);

        if(message.originalKeyType != null)
            output.writeUInt32(21, message.originalKeyType, false);

        if(message.originalIdType != null)
            output.writeUInt32(22, message.originalIdType, false);

        if(message.originalAuthAppid != null)
            output.writeUInt64(23, message.originalAuthAppid, false);
    }

    public String getFieldName(int number)
    {
        switch(number)
        {
            case 1: return "version";
            case 2: return "subCmd";
            case 3: return "subCmd";
            case 4: return "seq";
            case 5: return "uid";
            case 6: return "binaryBody";
            case 7: return "ex";
            case 8: return "clientType";
            case 9: return "clientIp";
            case 10: return "serviceIp";
            case 11: return "business";
            case 12: return "authKey";
            case 13: return "authType";
            case 14: return "authIp";
            case 15: return "authAppid";
            case 16: return "tinyid";
            case 17: return "clientPort";
            case 18: return "flag";
            case 19: return "originalId";
            case 20: return "originalKey";
            case 21: return "originalKeyType";
            case 22: return "originalIdType";
            case 23: return "originalAuthAppid";
            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
        __fieldMap.put("version", 1);
        __fieldMap.put("subCmd", 2);
        __fieldMap.put("subCmd", 3);
        __fieldMap.put("seq", 4);
        __fieldMap.put("uid", 5);
        __fieldMap.put("binaryBody", 6);
        __fieldMap.put("ex", 7);
        __fieldMap.put("clientType", 8);
        __fieldMap.put("clientIp", 9);
        __fieldMap.put("serviceIp", 10);
        __fieldMap.put("business", 11);
        __fieldMap.put("authKey", 12);
        __fieldMap.put("authType", 13);
        __fieldMap.put("authIp", 14);
        __fieldMap.put("authAppid", 15);
        __fieldMap.put("tinyid", 16);
        __fieldMap.put("clientPort", 17);
        __fieldMap.put("flag", 18);
        __fieldMap.put("originalId", 19);
        __fieldMap.put("originalKey", 20);
        __fieldMap.put("originalKeyType", 21);
        __fieldMap.put("originalIdType", 22);
        __fieldMap.put("originalAuthAppid", 23);
    }
    
}
