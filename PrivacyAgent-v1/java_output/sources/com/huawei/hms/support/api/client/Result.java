package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public abstract class Result implements com.huawei.hms.core.aidl.IMessageEntity {
    private com.huawei.hms.support.api.client.Status status = com.huawei.hms.support.api.client.Status.FAILURE;

    public com.huawei.hms.support.api.client.Status getStatus() {
        return this.status;
    }

    public void setStatus(com.huawei.hms.support.api.client.Status status) {
        if (status == null) {
            return;
        }
        this.status = status;
    }
}
