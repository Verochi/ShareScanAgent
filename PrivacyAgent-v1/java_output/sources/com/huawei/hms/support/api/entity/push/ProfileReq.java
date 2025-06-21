package com.huawei.hms.support.api.entity.push;

/* loaded from: classes22.dex */
public class ProfileReq implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public int operation;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String pkgName;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String profileId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String subjectId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public int type;

    public int getOperation() {
        return this.operation;
    }

    public java.lang.String getPkgName() {
        return this.pkgName;
    }

    public java.lang.String getProfileId() {
        return this.profileId;
    }

    public java.lang.String getSubjectId() {
        return this.subjectId;
    }

    public int getType() {
        return this.type;
    }

    public void setOperation(int i) {
        this.operation = i;
    }

    public void setPkgName(java.lang.String str) {
        this.pkgName = str;
    }

    public void setProfileId(java.lang.String str) {
        this.profileId = str;
    }

    public void setSubjectId(java.lang.String str) {
        this.subjectId = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public java.lang.String toString() {
        return com.huawei.hms.support.api.entity.push.ProfileReq.class.getName() + "{ pkgName: " + this.pkgName + ",subjectId: " + this.subjectId + ",operation: " + this.operation + " type: " + this.type + com.alipay.sdk.m.u.i.d;
    }
}
