package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes22.dex */
public abstract class HlsPlaylist implements com.google.android.exoplayer2.offline.FilterableManifest<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> {
    public final java.lang.String baseUri;
    public final boolean hasIndependentSegments;
    public final java.util.List<java.lang.String> tags;

    public HlsPlaylist(java.lang.String str, java.util.List<java.lang.String> list, boolean z) {
        this.baseUri = str;
        this.tags = java.util.Collections.unmodifiableList(list);
        this.hasIndependentSegments = z;
    }
}
