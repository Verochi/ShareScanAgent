package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public interface LoadControl {
    com.google.android.exoplayer2.upstream.Allocator getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray);

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long j, long j2, float f);

    boolean shouldStartPlayback(long j, float f, boolean z);
}
