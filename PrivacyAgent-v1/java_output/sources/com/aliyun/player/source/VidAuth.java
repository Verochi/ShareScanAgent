package com.aliyun.player.source;

/* loaded from: classes.dex */
public class VidAuth extends com.aliyun.player.source.VidSourceBase {
    private java.lang.String mPlayAuth;
    private java.lang.String mRegion;
    private java.lang.String mVid;

    public java.lang.String getPlayAuth() {
        return this.mPlayAuth;
    }

    public java.lang.String getRegion() {
        return this.mRegion;
    }

    public java.lang.String getVid() {
        return this.mVid;
    }

    public void setPlayAuth(java.lang.String str) {
        this.mPlayAuth = str;
    }

    public void setQuality(java.lang.String str, boolean z) {
        this.mQuality = str;
        this.mForceQuality = z;
    }

    public void setRegion(java.lang.String str) {
        this.mRegion = str;
    }

    public void setVid(java.lang.String str) {
        this.mVid = str;
    }
}
