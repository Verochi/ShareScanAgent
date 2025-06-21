package com.igexin.sdk.message;

/* loaded from: classes23.dex */
public class BaseMessage implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    private java.lang.String appid = com.igexin.push.core.e.a;
    private java.lang.String pkgName = com.igexin.push.core.e.g;
    private java.lang.String clientId = com.igexin.push.core.e.A;

    public java.lang.String getAppid() {
        return this.appid;
    }

    public java.lang.String getClientId() {
        return this.clientId;
    }

    public java.lang.String getPkgName() {
        return this.pkgName;
    }

    public void setAppid(java.lang.String str) {
        this.appid = str;
    }

    public void setClientId(java.lang.String str) {
        this.clientId = str;
    }

    public void setPkgName(java.lang.String str) {
        this.pkgName = str;
    }
}
