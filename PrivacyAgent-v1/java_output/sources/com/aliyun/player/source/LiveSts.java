package com.aliyun.player.source;

/* loaded from: classes.dex */
public class LiveSts extends com.aliyun.player.source.SourceBase {
    private java.lang.String mAccessKeyId;
    private java.lang.String mAccessKeySecret;
    private java.lang.String mApp;
    private java.lang.String mDomain;
    private com.aliyun.player.source.LiveSts.LiveEncryptionType mEncryptionType;
    private java.lang.String mRegion;
    private java.lang.String mSecurityToken;
    private java.lang.String mStream;
    private java.lang.String mUrl;

    public enum LiveEncryptionType {
        NoEncryption,
        AliEncryption,
        WideVine_FairPlay
    }

    public java.lang.String getAccessKeyId() {
        return this.mAccessKeyId;
    }

    public java.lang.String getAccessKeySecret() {
        return this.mAccessKeySecret;
    }

    public java.lang.String getApp() {
        return this.mApp;
    }

    public java.lang.String getDomain() {
        return this.mDomain;
    }

    public int getEncryptionTypeValue() {
        com.aliyun.player.source.LiveSts.LiveEncryptionType liveEncryptionType = this.mEncryptionType;
        return liveEncryptionType == null ? com.aliyun.player.source.LiveSts.LiveEncryptionType.NoEncryption.ordinal() : liveEncryptionType.ordinal();
    }

    public java.lang.String getRegion() {
        return this.mRegion;
    }

    public java.lang.String getSecurityToken() {
        return this.mSecurityToken;
    }

    public java.lang.String getStream() {
        return this.mStream;
    }

    public java.lang.String getUrl() {
        return this.mUrl;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.mAccessKeyId = str;
    }

    public void setAccessKeySecret(java.lang.String str) {
        this.mAccessKeySecret = str;
    }

    public void setApp(java.lang.String str) {
        this.mApp = str;
    }

    public void setDomain(java.lang.String str) {
        this.mDomain = str;
    }

    public void setEncryptionType(com.aliyun.player.source.LiveSts.LiveEncryptionType liveEncryptionType) {
        this.mEncryptionType = liveEncryptionType;
    }

    public void setRegion(java.lang.String str) {
        this.mRegion = str;
    }

    public void setSecurityToken(java.lang.String str) {
        this.mSecurityToken = str;
    }

    public void setStream(java.lang.String str) {
        this.mStream = str;
    }

    public void setUrl(java.lang.String str) {
        this.mUrl = str;
    }
}
