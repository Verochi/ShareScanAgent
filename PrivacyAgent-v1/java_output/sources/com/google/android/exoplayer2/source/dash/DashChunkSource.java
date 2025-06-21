package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
public interface DashChunkSource extends com.google.android.exoplayer2.source.chunk.ChunkSource {

    public interface Factory {
        com.google.android.exoplayer2.source.dash.DashChunkSource createDashChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i, int[] iArr, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, int i2, long j, boolean z, java.util.List<com.google.android.exoplayer2.Format> list, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener);
    }

    void updateManifest(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i);

    void updateTrackSelection(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection);
}
