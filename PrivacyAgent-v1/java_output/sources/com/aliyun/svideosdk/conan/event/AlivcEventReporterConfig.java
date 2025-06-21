package com.aliyun.svideosdk.conan.event;

@com.aliyun.svideosdk.conan.DoNotProguard
/* loaded from: classes12.dex */
public class AlivcEventReporterConfig {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private boolean d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private com.aliyun.svideosdk.conan.AlivcConanBusinessType l;
    private com.aliyun.svideosdk.conan.AlivcSDKEnvironment m;

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getAccessKey() {
        return this.f;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getApplicationName() {
        return this.j;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getApplicationVersion() {
        return this.k;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public com.aliyun.svideosdk.conan.AlivcConanBusinessType getBusinessType() {
        com.aliyun.svideosdk.conan.AlivcConanBusinessType alivcConanBusinessType = this.l;
        return alivcConanBusinessType == null ? com.aliyun.svideosdk.conan.AlivcConanBusinessType.AlivcConanBusinessNone : alivcConanBusinessType;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getEndPoint() {
        return this.e;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getExpireTime() {
        return this.i;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getHost() {
        return this.a;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getLogStore() {
        return this.c;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getProjectName() {
        return this.b;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public com.aliyun.svideosdk.conan.AlivcSDKEnvironment getSDKEnvironment() {
        return this.m;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getSecretKey() {
        return this.g;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public java.lang.String getSecurityToken() {
        return this.h;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public boolean isUseExternalAuth() {
        return this.d;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setAccessKey(java.lang.String str) {
        this.f = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setApplicationName(java.lang.String str) {
        this.j = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setApplicationVersion(java.lang.String str) {
        this.k = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setBusinessType(com.aliyun.svideosdk.conan.AlivcConanBusinessType alivcConanBusinessType) {
        this.l = alivcConanBusinessType;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setEndPoint(java.lang.String str) {
        this.e = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setExpireTime(java.lang.String str) {
        this.i = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setHost(java.lang.String str) {
        this.a = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setLogStore(java.lang.String str) {
        this.c = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setProjectName(java.lang.String str) {
        this.b = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setSDKEnvironment(com.aliyun.svideosdk.conan.AlivcSDKEnvironment alivcSDKEnvironment) {
        this.m = alivcSDKEnvironment;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setSecretKey(java.lang.String str) {
        this.g = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setSecurityToken(java.lang.String str) {
        this.h = str;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public void setUseExternalAuth(boolean z) {
        this.d = z;
    }
}
