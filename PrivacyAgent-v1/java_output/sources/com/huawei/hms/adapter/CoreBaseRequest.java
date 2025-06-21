package com.huawei.hms.adapter;

/* loaded from: classes22.dex */
class CoreBaseRequest implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String jsonHeader;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String jsonObject;

    @com.huawei.hms.core.aidl.annotation.Packed
    private android.os.Parcelable parcelable;

    public java.lang.String getJsonHeader() {
        return this.jsonHeader;
    }

    public java.lang.String getJsonObject() {
        return this.jsonObject;
    }

    public android.os.Parcelable getParcelable() {
        return this.parcelable;
    }

    public void setJsonHeader(java.lang.String str) {
        this.jsonHeader = str;
    }

    public void setJsonObject(java.lang.String str) {
        this.jsonObject = str;
    }

    public void setParcelable(android.os.Parcelable parcelable) {
        this.parcelable = parcelable;
    }
}
