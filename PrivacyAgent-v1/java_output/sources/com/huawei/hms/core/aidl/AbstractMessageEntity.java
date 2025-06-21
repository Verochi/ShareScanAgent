package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public class AbstractMessageEntity implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    private com.huawei.hms.support.api.client.Status commonStatus;

    public com.huawei.hms.support.api.client.Status getCommonStatus() {
        return this.commonStatus;
    }

    public void setCommonStatus(com.huawei.hms.support.api.client.Status status) {
        this.commonStatus = status;
    }
}
