package com.aliyun.player.source;

/* loaded from: classes.dex */
public class SourceBase {
    private java.lang.String mCoverPath;
    protected boolean mForceQuality = false;
    protected java.lang.String mQuality;
    private java.lang.String mTitle;

    public java.lang.String getCoverPath() {
        return this.mCoverPath;
    }

    public java.lang.String getQuality() {
        return this.mQuality;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public boolean isForceQuality() {
        return this.mForceQuality;
    }

    public void setCoverPath(java.lang.String str) {
        this.mCoverPath = str;
    }

    public void setTitle(java.lang.String str) {
        this.mTitle = str;
    }
}
