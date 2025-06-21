package com.huawei.hms.support.api.transport;

/* loaded from: classes22.dex */
public interface DatagramTransport {

    public interface a {
        void a(int i, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity);
    }

    void post(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.support.api.transport.DatagramTransport.a aVar);

    void send(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.support.api.transport.DatagramTransport.a aVar);
}
