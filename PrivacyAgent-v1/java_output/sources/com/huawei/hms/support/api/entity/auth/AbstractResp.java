package com.huawei.hms.support.api.entity.auth;

/* loaded from: classes22.dex */
public abstract class AbstractResp implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String errorReason;

    @com.huawei.hms.core.aidl.annotation.Packed
    private int rtnCode = 0;

    public java.lang.String getErrorReason() {
        return this.errorReason;
    }

    public int getRtnCode() {
        return this.rtnCode;
    }

    public void setErrorReason(java.lang.String str) {
        this.errorReason = str;
    }

    public void setRtnCode(int i) {
        this.rtnCode = i;
    }
}
