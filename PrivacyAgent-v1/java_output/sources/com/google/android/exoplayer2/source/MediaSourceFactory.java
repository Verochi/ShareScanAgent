package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public interface MediaSourceFactory {
    @java.lang.Deprecated
    com.google.android.exoplayer2.source.MediaSource createMediaSource(android.net.Uri uri);

    com.google.android.exoplayer2.source.MediaSource createMediaSource(com.google.android.exoplayer2.MediaItem mediaItem);

    int[] getSupportedTypes();

    com.google.android.exoplayer2.source.MediaSourceFactory setDrmHttpDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory);

    com.google.android.exoplayer2.source.MediaSourceFactory setDrmSessionManager(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager);

    com.google.android.exoplayer2.source.MediaSourceFactory setDrmUserAgent(@androidx.annotation.Nullable java.lang.String str);

    com.google.android.exoplayer2.source.MediaSourceFactory setLoadErrorHandlingPolicy(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    @java.lang.Deprecated
    com.google.android.exoplayer2.source.MediaSourceFactory setStreamKeys(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.offline.StreamKey> list);
}
