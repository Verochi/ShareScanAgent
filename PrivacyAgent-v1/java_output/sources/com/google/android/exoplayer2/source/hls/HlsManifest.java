package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class HlsManifest {
    public final com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist masterPlaylist;
    public final com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist mediaPlaylist;

    public HlsManifest(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        this.masterPlaylist = hlsMasterPlaylist;
        this.mediaPlaylist = hlsMediaPlaylist;
    }
}
