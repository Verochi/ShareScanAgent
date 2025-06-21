package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class IPCTransport implements com.huawei.hms.support.api.transport.DatagramTransport {
    private static final java.lang.String TAG = "IPCTransport";
    private int apiLevel;
    private final com.huawei.hms.core.aidl.IMessageEntity mEntity;
    private final java.lang.Class<? extends com.huawei.hms.core.aidl.IMessageEntity> mResponseClass;
    private final java.lang.String mURI;

    public IPCTransport(java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.Class<? extends com.huawei.hms.core.aidl.IMessageEntity> cls) {
        this.mURI = str;
        this.mEntity = iMessageEntity;
        this.mResponseClass = cls;
    }

    public IPCTransport(java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.Class<? extends com.huawei.hms.core.aidl.IMessageEntity> cls, int i) {
        this.mURI = str;
        this.mEntity = iMessageEntity;
        this.mResponseClass = cls;
        this.apiLevel = i;
    }

    private int syncCall(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.core.aidl.IAIDLCallback iAIDLCallback) {
        if (!(apiClient instanceof com.huawei.hms.support.api.client.InnerApiClient)) {
            if (apiClient instanceof com.huawei.hms.support.api.client.AidlApiClient) {
                com.huawei.hms.support.api.client.AidlApiClient aidlApiClient = (com.huawei.hms.support.api.client.AidlApiClient) apiClient;
                com.huawei.hms.core.aidl.DataBuffer dataBuffer = new com.huawei.hms.core.aidl.DataBuffer(this.mURI, com.huawei.hms.api.ProtocolNegotiate.getInstance().getVersion());
                dataBuffer.addBody(com.huawei.hms.core.aidl.CodecLookup.find(dataBuffer.getProtocol()).encode(this.mEntity, new android.os.Bundle()));
                try {
                    aidlApiClient.getService().asyncCall(dataBuffer, iAIDLCallback);
                    return 0;
                } catch (java.lang.Exception e) {
                    com.huawei.hms.support.log.HMSLog.e(TAG, "sync call ex:" + e);
                }
            }
            return com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.INTERNAL_ERROR;
        }
        com.huawei.hms.core.aidl.DataBuffer dataBuffer2 = new com.huawei.hms.core.aidl.DataBuffer(this.mURI, com.huawei.hms.api.ProtocolNegotiate.getInstance().getVersion());
        com.huawei.hms.core.aidl.MessageCodec find = com.huawei.hms.core.aidl.CodecLookup.find(dataBuffer2.getProtocol());
        dataBuffer2.addBody(find.encode(this.mEntity, new android.os.Bundle()));
        com.huawei.hms.core.aidl.RequestHeader requestHeader = new com.huawei.hms.core.aidl.RequestHeader();
        requestHeader.setAppID(apiClient.getAppID());
        requestHeader.setPackageName(apiClient.getPackageName());
        requestHeader.setSdkVersion(60500300);
        requestHeader.setApiNameList(((com.huawei.hms.support.api.client.AidlApiClient) apiClient).getApiNameList());
        requestHeader.setSessionId(apiClient.getSessionId());
        requestHeader.setApiLevel(this.apiLevel);
        dataBuffer2.header = find.encode(requestHeader, new android.os.Bundle());
        try {
            com.huawei.hms.support.api.client.AidlApiClient aidlApiClient2 = (com.huawei.hms.support.api.client.AidlApiClient) apiClient;
            if (aidlApiClient2.getService() == null) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "HuaweiApiClient is not binded to service yet.");
                return com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.INTERNAL_ERROR;
            }
            aidlApiClient2.getService().asyncCall(dataBuffer2, iAIDLCallback);
            return 0;
        } catch (java.lang.Exception e2) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "sync call ex:" + e2);
            return com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.INTERNAL_ERROR;
        }
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void post(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.support.api.transport.DatagramTransport.a aVar) {
        send(apiClient, aVar);
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void send(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.support.api.transport.DatagramTransport.a aVar) {
        int syncCall = syncCall(apiClient, new com.huawei.hms.api.IPCCallback(this.mResponseClass, aVar));
        if (syncCall != 0) {
            aVar.a(syncCall, null);
        }
    }
}
