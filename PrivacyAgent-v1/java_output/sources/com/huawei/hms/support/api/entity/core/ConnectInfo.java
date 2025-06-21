package com.huawei.hms.support.api.entity.core;

/* loaded from: classes22.dex */
public class ConnectInfo implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.util.List<java.lang.String> a;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.util.List<com.huawei.hms.support.api.entity.auth.Scope> b;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String c;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String d;

    public ConnectInfo() {
    }

    public ConnectInfo(java.util.List<java.lang.String> list, java.util.List<com.huawei.hms.support.api.entity.auth.Scope> list2, java.lang.String str, java.lang.String str2) {
        this.a = list;
        this.b = list2;
        this.c = str;
        this.d = str2;
    }

    public java.util.List<java.lang.String> getApiNameList() {
        return this.a;
    }

    public java.lang.String getFingerprint() {
        return this.c;
    }

    public java.util.List<com.huawei.hms.support.api.entity.auth.Scope> getScopeList() {
        return this.b;
    }

    public java.lang.String getSubAppID() {
        return this.d;
    }

    public void setApiNameList(java.util.List<java.lang.String> list) {
        this.a = list;
    }

    public void setFingerprint(java.lang.String str) {
        this.c = str;
    }

    public void setScopeList(java.util.List<com.huawei.hms.support.api.entity.auth.Scope> list) {
        this.b = list;
    }

    public void setSubAppID(java.lang.String str) {
        this.d = str;
    }
}
