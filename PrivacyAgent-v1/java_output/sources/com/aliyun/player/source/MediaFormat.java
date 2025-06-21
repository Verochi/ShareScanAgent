package com.aliyun.player.source;

/* loaded from: classes.dex */
public enum MediaFormat {
    mp4("mp4"),
    m3u8("m3u8"),
    flv("flv"),
    mp3("mp3");

    private java.lang.String mFormat;

    MediaFormat(java.lang.String str) {
        this.mFormat = str;
    }

    public java.lang.String getFormat() {
        return this.mFormat;
    }
}
