package com.aliyun.player.source;

/* loaded from: classes.dex */
public class VidSts extends com.aliyun.player.source.VidSourceBase {
    private java.lang.String mAccessKeyId;
    private java.lang.String mAccessKeySecret;
    private java.lang.String mRegion;
    private java.lang.String mSecurityToken;
    private java.lang.String mVid;

    public java.lang.String getAccessKeyId() {
        return this.mAccessKeyId;
    }

    public java.lang.String getAccessKeySecret() {
        return this.mAccessKeySecret;
    }

    public java.lang.String getRegion() {
        return this.mRegion;
    }

    public java.lang.String getSecurityToken() {
        return this.mSecurityToken;
    }

    public java.lang.String getVid() {
        return this.mVid;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.mAccessKeyId = str;
    }

    public void setAccessKeySecret(java.lang.String str) {
        this.mAccessKeySecret = str;
    }

    public void setQuality(java.lang.String str, boolean z) {
        this.mQuality = str;
        this.mForceQuality = z;
    }

    public void setRegion(java.lang.String str) {
        this.mRegion = str;
    }

    public void setSecurityToken(java.lang.String str) {
        this.mSecurityToken = str;
    }

    public void setVid(java.lang.String str) {
        this.mVid = str;
    }
}
