package com.huawei.hms.support.api.entity.push;

/* loaded from: classes22.dex */
public class EnableNotifyReq implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public boolean enable;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String packageName;

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public java.lang.String toString() {
        return "EnableNotifyReq{packageName='" + this.packageName + "', enable=" + this.enable + '}';
    }
}
