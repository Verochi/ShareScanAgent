package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public interface AnyClient {

    public interface CallBack {
        void onCallback(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.String str);
    }

    void connect(int i);

    void connect(int i, boolean z);

    void disconnect();

    java.lang.String getSessionId();

    boolean isConnected();

    boolean isConnecting();

    void post(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.String str, com.huawei.hms.common.internal.AnyClient.CallBack callBack);
}
