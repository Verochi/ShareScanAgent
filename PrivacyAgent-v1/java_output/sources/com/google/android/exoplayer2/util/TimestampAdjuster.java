package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    public long a;
    public long b;
    public volatile long c = -9223372036854775807L;

    public TimestampAdjuster(long j) {
        setFirstSampleTimestampUs(j);
    }

    public static long ptsToUs(long j) {
        return (j * 1000000) / 90000;
    }

    public static long usToNonWrappedPts(long j) {
        return (j * 90000) / 1000000;
    }

    public static long usToWrappedPts(long j) {
        return usToNonWrappedPts(j) % tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
    }

    public long adjustSampleTimestamp(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            this.c = j;
        } else {
            long j2 = this.a;
            if (j2 != Long.MAX_VALUE) {
                this.b = j2 - j;
            }
            synchronized (this) {
                this.c = j;
                notifyAll();
            }
        }
        return j + this.b;
    }

    public long adjustTsTimestamp(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            long usToNonWrappedPts = usToNonWrappedPts(this.c);
            long j2 = (tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_RIGHT + usToNonWrappedPts) / tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            long j3 = ((j2 - 1) * tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            j += j2 * tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            if (java.lang.Math.abs(j3 - usToNonWrappedPts) < java.lang.Math.abs(j - usToNonWrappedPts)) {
                j = j3;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j));
    }

    public long getFirstSampleTimestampUs() {
        return this.a;
    }

    public long getLastAdjustedTimestampUs() {
        if (this.c != -9223372036854775807L) {
            return this.b + this.c;
        }
        long j = this.a;
        if (j != Long.MAX_VALUE) {
            return j;
        }
        return -9223372036854775807L;
    }

    public long getTimestampOffsetUs() {
        if (this.a == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.b;
    }

    public void reset() {
        this.c = -9223372036854775807L;
    }

    public synchronized void setFirstSampleTimestampUs(long j) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.c == -9223372036854775807L);
        this.a = j;
    }

    public synchronized void waitUntilInitialized() throws java.lang.InterruptedException {
        while (this.c == -9223372036854775807L) {
            wait();
        }
    }
}
