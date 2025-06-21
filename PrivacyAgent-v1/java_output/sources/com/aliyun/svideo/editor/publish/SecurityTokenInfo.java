package com.aliyun.svideo.editor.publish;

/* loaded from: classes12.dex */
public class SecurityTokenInfo {
    private java.lang.String AccessKeyId;
    private java.lang.String AccessKeySecret;
    private java.lang.String Expiration;
    private java.lang.String SecurityToken;

    public java.lang.String getAccessKeyId() {
        return this.AccessKeyId;
    }

    public java.lang.String getAccessKeySecret() {
        return this.AccessKeySecret;
    }

    public java.lang.String getExpiration() {
        return this.Expiration;
    }

    public java.lang.String getSecurityToken() {
        return this.SecurityToken;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.AccessKeyId = str;
    }

    public void setAccessKeySecret(java.lang.String str) {
        this.AccessKeySecret = str;
    }

    public void setExpiration(java.lang.String str) {
        this.Expiration = str;
    }

    public void setSecurityToken(java.lang.String str) {
        this.SecurityToken = str;
    }

    public java.lang.String toString() {
        return "SecurityTokenInfo{AccessKeySecret='" + this.AccessKeySecret + "', SecurityToken='" + this.SecurityToken + "', Expiration='" + this.Expiration + "', AccessKeyId='" + this.AccessKeyId + "'}";
    }
}
