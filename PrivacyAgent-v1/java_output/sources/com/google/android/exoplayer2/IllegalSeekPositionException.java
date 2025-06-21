package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class IllegalSeekPositionException extends java.lang.IllegalStateException {
    public final long positionMs;
    public final com.google.android.exoplayer2.Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(com.google.android.exoplayer2.Timeline timeline, int i, long j) {
        this.timeline = timeline;
        this.windowIndex = i;
        this.positionMs = j;
    }
}
