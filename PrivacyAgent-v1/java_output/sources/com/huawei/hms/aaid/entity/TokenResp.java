package com.huawei.hms.aaid.entity;

/* loaded from: classes22.dex */
public class TokenResp implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String belongId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String subjectId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String token = "";

    @com.huawei.hms.core.aidl.annotation.Packed
    public int retCode = 0;

    public java.lang.String getBelongId() {
        return this.belongId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public java.lang.String getSubjectId() {
        return this.subjectId;
    }

    public java.lang.String getToken() {
        return this.token;
    }

    public void setBelongId(java.lang.String str) {
        this.belongId = str;
    }

    public void setRetCode(int i) {
        this.retCode = i;
    }

    public void setSubjectId(java.lang.String str) {
        this.subjectId = str;
    }

    public void setToken(java.lang.String str) {
        this.token = str;
    }
}
