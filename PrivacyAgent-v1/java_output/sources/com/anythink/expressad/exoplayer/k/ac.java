package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class ac {
    public static final long a = Long.MAX_VALUE;
    private static final long b = 8589934592L;
    private long c;
    private long d;
    private volatile long e = -9223372036854775807L;

    public ac(long j) {
        c(j);
    }

    private long b() {
        return this.c;
    }

    private long c() {
        if (this.e != -9223372036854775807L) {
            return this.e + this.d;
        }
        long j = this.c;
        if (j != Long.MAX_VALUE) {
            return j;
        }
        return -9223372036854775807L;
    }

    private synchronized void c(long j) {
        com.anythink.expressad.exoplayer.k.a.b(this.e == -9223372036854775807L);
        this.c = j;
    }

    private static long d(long j) {
        return (j * 1000000) / 90000;
    }

    private void d() {
        this.e = -9223372036854775807L;
    }

    private static long e(long j) {
        return (j * 90000) / 1000000;
    }

    private synchronized void e() {
        while (this.e == -9223372036854775807L) {
            wait();
        }
    }

    public final long a() {
        if (this.c == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.e == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.d;
    }

    public final long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.e != -9223372036854775807L) {
            long j2 = (this.e * 90000) / 1000000;
            long j3 = (tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_RIGHT + j2) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (java.lang.Math.abs(j4 - j2) < java.lang.Math.abs(j - j2)) {
                j = j4;
            }
        }
        return b((j * 1000000) / 90000);
    }

    public final long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.e != -9223372036854775807L) {
            this.e = j;
        } else {
            long j2 = this.c;
            if (j2 != Long.MAX_VALUE) {
                this.d = j2 - j;
            }
            synchronized (this) {
                this.e = j;
                notifyAll();
            }
        }
        return j + this.d;
    }
}
