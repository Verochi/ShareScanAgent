package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class MediaLoadData {
    public final int dataType;
    public final long mediaEndTimeMs;
    public final long mediaStartTimeMs;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.Format trackFormat;

    @androidx.annotation.Nullable
    public final java.lang.Object trackSelectionData;
    public final int trackSelectionReason;
    public final int trackType;

    public MediaLoadData(int i) {
        this(i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public MediaLoadData(int i, int i2, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format, int i3, @androidx.annotation.Nullable java.lang.Object obj, long j, long j2) {
        this.dataType = i;
        this.trackType = i2;
        this.trackFormat = format;
        this.trackSelectionReason = i3;
        this.trackSelectionData = obj;
        this.mediaStartTimeMs = j;
        this.mediaEndTimeMs = j2;
    }
}
