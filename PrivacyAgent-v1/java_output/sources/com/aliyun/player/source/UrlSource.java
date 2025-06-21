package com.aliyun.player.source;

/* loaded from: classes.dex */
public class UrlSource extends com.aliyun.player.source.SourceBase {
    private long mOriginSize;
    private java.lang.String mUri = null;
    private java.lang.String mCacheFilePath = null;

    public UrlSource() {
        this.mQuality = "AUTO";
        this.mForceQuality = true;
        this.mOriginSize = 0L;
    }

    public java.lang.String getCacheFilePath() {
        return this.mCacheFilePath;
    }

    public long getOriginSize() {
        return this.mOriginSize;
    }

    public java.lang.String getUri() {
        return this.mUri;
    }

    public void setCacheFilePath(java.lang.String str) {
        this.mCacheFilePath = str;
    }

    public void setOriginSize(long j) {
        this.mOriginSize = j;
    }

    public void setUri(java.lang.String str) {
        this.mUri = str;
    }
}
