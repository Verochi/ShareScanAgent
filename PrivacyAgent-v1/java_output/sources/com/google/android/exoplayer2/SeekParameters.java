package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class SeekParameters {
    public static final com.google.android.exoplayer2.SeekParameters CLOSEST_SYNC;
    public static final com.google.android.exoplayer2.SeekParameters DEFAULT;
    public static final com.google.android.exoplayer2.SeekParameters EXACT;
    public static final com.google.android.exoplayer2.SeekParameters NEXT_SYNC;
    public static final com.google.android.exoplayer2.SeekParameters PREVIOUS_SYNC;
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    static {
        com.google.android.exoplayer2.SeekParameters seekParameters = new com.google.android.exoplayer2.SeekParameters(0L, 0L);
        EXACT = seekParameters;
        CLOSEST_SYNC = new com.google.android.exoplayer2.SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
        PREVIOUS_SYNC = new com.google.android.exoplayer2.SeekParameters(Long.MAX_VALUE, 0L);
        NEXT_SYNC = new com.google.android.exoplayer2.SeekParameters(0L, Long.MAX_VALUE);
        DEFAULT = seekParameters;
    }

    public SeekParameters(long j, long j2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(j2 >= 0);
        this.toleranceBeforeUs = j;
        this.toleranceAfterUs = j2;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.SeekParameters.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.SeekParameters seekParameters = (com.google.android.exoplayer2.SeekParameters) obj;
        return this.toleranceBeforeUs == seekParameters.toleranceBeforeUs && this.toleranceAfterUs == seekParameters.toleranceAfterUs;
    }

    public int hashCode() {
        return (((int) this.toleranceBeforeUs) * 31) + ((int) this.toleranceAfterUs);
    }

    public long resolveSeekPositionUs(long j, long j2, long j3) {
        long j4 = this.toleranceBeforeUs;
        if (j4 == 0 && this.toleranceAfterUs == 0) {
            return j;
        }
        long subtractWithOverflowDefault = com.google.android.exoplayer2.util.Util.subtractWithOverflowDefault(j, j4, Long.MIN_VALUE);
        long addWithOverflowDefault = com.google.android.exoplayer2.util.Util.addWithOverflowDefault(j, this.toleranceAfterUs, Long.MAX_VALUE);
        boolean z = subtractWithOverflowDefault <= j2 && j2 <= addWithOverflowDefault;
        boolean z2 = subtractWithOverflowDefault <= j3 && j3 <= addWithOverflowDefault;
        return (z && z2) ? java.lang.Math.abs(j2 - j) <= java.lang.Math.abs(j3 - j) ? j2 : j3 : z ? j2 : z2 ? j3 : subtractWithOverflowDefault;
    }
}
