package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final class MediaDrmCallbackException extends java.io.IOException {
    public final long bytesLoaded;
    public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaders;
    public final android.net.Uri uriAfterRedirects;

    public MediaDrmCallbackException(com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, long j, java.lang.Throwable th) {
        super(th);
        this.dataSpec = dataSpec;
        this.uriAfterRedirects = uri;
        this.responseHeaders = map;
        this.bytesLoaded = j;
    }
}
