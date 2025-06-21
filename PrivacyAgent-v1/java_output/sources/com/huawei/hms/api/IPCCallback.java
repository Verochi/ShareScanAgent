package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class IPCCallback extends com.huawei.hms.core.aidl.IAIDLCallback.Stub {
    private static final java.lang.String TAG = "IPCCallback";
    private final com.huawei.hms.support.api.transport.DatagramTransport.a mCallback;
    private final java.lang.Class<? extends com.huawei.hms.core.aidl.IMessageEntity> mResponseClass;

    public IPCCallback(java.lang.Class<? extends com.huawei.hms.core.aidl.IMessageEntity> cls, com.huawei.hms.support.api.transport.DatagramTransport.a aVar) {
        this.mResponseClass = cls;
        this.mCallback = aVar;
    }

    @Override // com.huawei.hms.core.aidl.IAIDLCallback
    public void call(com.huawei.hms.core.aidl.DataBuffer dataBuffer) throws android.os.RemoteException {
        com.huawei.hms.core.aidl.IMessageEntity iMessageEntity;
        if (dataBuffer == null || android.text.TextUtils.isEmpty(dataBuffer.URI)) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In call, URI cannot be empty.");
            throw new android.os.RemoteException();
        }
        com.huawei.hms.core.aidl.MessageCodec find = com.huawei.hms.core.aidl.CodecLookup.find(dataBuffer.getProtocol());
        if (dataBuffer.getBodySize() > 0) {
            iMessageEntity = newResponseInstance();
            if (iMessageEntity != null) {
                find.decode(dataBuffer.getBody(), iMessageEntity);
            }
        } else {
            iMessageEntity = null;
        }
        if (dataBuffer.header == null) {
            this.mCallback.a(0, iMessageEntity);
            return;
        }
        com.huawei.hms.core.aidl.ResponseHeader responseHeader = new com.huawei.hms.core.aidl.ResponseHeader();
        find.decode(dataBuffer.header, responseHeader);
        this.mCallback.a(responseHeader.getStatusCode(), iMessageEntity);
    }

    public com.huawei.hms.core.aidl.IMessageEntity newResponseInstance() {
        java.lang.Class<? extends com.huawei.hms.core.aidl.IMessageEntity> cls = this.mResponseClass;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "In newResponseInstance, instancing exception." + e.getMessage());
            return null;
        }
    }
}
