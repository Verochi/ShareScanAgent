package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public class SourceInfo {
    public final long length;
    public final java.lang.String mime;
    public final java.lang.String url;

    public SourceInfo(java.lang.String str, long j, java.lang.String str2) {
        this.url = str;
        this.length = j;
        this.mime = str2;
    }

    public java.lang.String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.length + ", mime='" + this.mime + "'}";
    }
}
