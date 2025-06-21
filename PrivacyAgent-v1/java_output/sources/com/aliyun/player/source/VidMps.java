package com.aliyun.player.source;

/* loaded from: classes.dex */
public class VidMps extends com.aliyun.player.source.VidSourceBase {
    private java.lang.String mAccessKeyId;
    private java.lang.String mAccessKeySecret;
    private java.lang.String mAuthInfo;
    private java.lang.String mHlsUriToken;
    private java.lang.String mMediaId;
    private java.lang.String mPlayDomain;
    private java.lang.String mRegion;
    private java.lang.String mSecurityToken;

    public java.lang.String getAccessKeyId() {
        return this.mAccessKeyId;
    }

    public java.lang.String getAccessKeySecret() {
        return this.mAccessKeySecret;
    }

    public java.lang.String getAuthInfo() {
        return this.mAuthInfo;
    }

    public java.lang.String getHlsUriToken() {
        return this.mHlsUriToken;
    }

    public java.lang.String getMediaId() {
        return this.mMediaId;
    }

    public java.lang.String getPlayDomain() {
        return this.mPlayDomain;
    }

    public java.lang.String getRegion() {
        return this.mRegion;
    }

    public java.lang.String getSecurityToken() {
        return this.mSecurityToken;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.mAccessKeyId = str;
    }

    public void setAccessKeySecret(java.lang.String str) {
        this.mAccessKeySecret = str;
    }

    public void setAuthInfo(java.lang.String str) {
        this.mAuthInfo = str;
    }

    public void setHlsUriToken(java.lang.String str) {
        this.mHlsUriToken = str;
    }

    public void setMediaId(java.lang.String str) {
        this.mMediaId = str;
    }

    public void setPlayDomain(java.lang.String str) {
        this.mPlayDomain = str;
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
}
