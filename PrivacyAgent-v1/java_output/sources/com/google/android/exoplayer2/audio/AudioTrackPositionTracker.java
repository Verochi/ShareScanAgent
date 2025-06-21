package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
final class AudioTrackPositionTracker {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public final com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener a;
    public final long[] b;

    @androidx.annotation.Nullable
    public android.media.AudioTrack c;
    public int d;
    public int e;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.audio.AudioTimestampPoller f;
    public int g;
    public boolean h;
    public long i;
    public float j;
    public boolean k;
    public long l;
    public long m;

    @androidx.annotation.Nullable
    public java.lang.reflect.Method n;
    public long o;
    public boolean p;
    public boolean q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public long f342s;
    public long t;
    public long u;
    public int v;
    public int w;
    public long x;
    public long y;
    public long z;

    public interface Listener {
        void onInvalidLatency(long j);

        void onPositionAdvancing(long j);

        void onPositionFramesMismatch(long j, long j2, long j3, long j4);

        void onSystemTimeUsMismatch(long j, long j2, long j3, long j4);

        void onUnderrun(int i, long j);
    }

    public AudioTrackPositionTracker(com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener listener) {
        this.a = (com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener) com.google.android.exoplayer2.util.Assertions.checkNotNull(listener);
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 18) {
            try {
                this.n = android.media.AudioTrack.class.getMethod("getLatency", null);
            } catch (java.lang.NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    public static boolean p(int i) {
        return com.google.android.exoplayer2.util.Util.SDK_INT < 23 && (i == 5 || i == 6);
    }

    public final boolean a() {
        return this.h && ((android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c)).getPlayState() == 2 && f() == 0;
    }

    public final long b(long j) {
        return (j * 1000000) / this.g;
    }

    public int c(long j) {
        return this.e - ((int) (j - (f() * this.d)));
    }

    public long d(boolean z) {
        long g;
        if (((android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c)).getPlayState() == 3) {
            n();
        }
        long nanoTime = java.lang.System.nanoTime() / 1000;
        com.google.android.exoplayer2.audio.AudioTimestampPoller audioTimestampPoller = (com.google.android.exoplayer2.audio.AudioTimestampPoller) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f);
        boolean d = audioTimestampPoller.d();
        if (d) {
            g = b(audioTimestampPoller.b()) + com.google.android.exoplayer2.util.Util.getMediaDurationForPlayoutDuration(nanoTime - audioTimestampPoller.c(), this.j);
        } else {
            g = this.w == 0 ? g() : this.l + nanoTime;
            if (!z) {
                g = java.lang.Math.max(0L, g - this.o);
            }
        }
        if (this.D != d) {
            this.F = this.C;
            this.E = this.B;
        }
        long j = nanoTime - this.F;
        if (j < 1000000) {
            long mediaDurationForPlayoutDuration = this.E + com.google.android.exoplayer2.util.Util.getMediaDurationForPlayoutDuration(j, this.j);
            long j2 = (j * 1000) / 1000000;
            g = ((g * j2) + ((1000 - j2) * mediaDurationForPlayoutDuration)) / 1000;
        }
        if (!this.k) {
            long j3 = this.B;
            if (g > j3) {
                this.k = true;
                this.a.onPositionAdvancing(java.lang.System.currentTimeMillis() - com.google.android.exoplayer2.C.usToMs(com.google.android.exoplayer2.util.Util.getPlayoutDurationForMediaDuration(com.google.android.exoplayer2.C.usToMs(g - j3), this.j)));
            }
        }
        this.C = nanoTime;
        this.B = g;
        this.D = d;
        return g;
    }

    public long e(long j) {
        return com.google.android.exoplayer2.C.usToMs(b(j - f()));
    }

    public final long f() {
        android.media.AudioTrack audioTrack = (android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c);
        if (this.x != -9223372036854775807L) {
            return java.lang.Math.min(this.A, this.z + ((((android.os.SystemClock.elapsedRealtime() * 1000) - this.x) * this.g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        if (this.h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.u = this.f342s;
            }
            playbackHeadPosition += this.u;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.f342s > 0 && playState == 3) {
                if (this.y == -9223372036854775807L) {
                    this.y = android.os.SystemClock.elapsedRealtime();
                }
                return this.f342s;
            }
            this.y = -9223372036854775807L;
        }
        if (this.f342s > playbackHeadPosition) {
            this.t++;
        }
        this.f342s = playbackHeadPosition;
        return playbackHeadPosition + (this.t << 32);
    }

    public final long g() {
        return b(f());
    }

    public void h(long j) {
        this.z = f();
        this.x = android.os.SystemClock.elapsedRealtime() * 1000;
        this.A = j;
    }

    public boolean i(long j) {
        return j > f() || a();
    }

    public boolean j() {
        return ((android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c)).getPlayState() == 3;
    }

    public boolean k(long j) {
        return this.y != -9223372036854775807L && j > 0 && android.os.SystemClock.elapsedRealtime() - this.y >= 200;
    }

    public boolean l(long j) {
        int playState = ((android.media.AudioTrack) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c)).getPlayState();
        if (this.h) {
            if (playState == 2) {
                this.p = false;
                return false;
            }
            if (playState == 1 && f() == 0) {
                return false;
            }
        }
        boolean z = this.p;
        boolean i = i(j);
        this.p = i;
        if (z && !i && playState != 1) {
            this.a.onUnderrun(this.e, com.google.android.exoplayer2.C.usToMs(this.i));
        }
        return true;
    }

    public final void m(long j, long j2) {
        com.google.android.exoplayer2.audio.AudioTimestampPoller audioTimestampPoller = (com.google.android.exoplayer2.audio.AudioTimestampPoller) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f);
        if (audioTimestampPoller.e(j)) {
            long c = audioTimestampPoller.c();
            long b = audioTimestampPoller.b();
            if (java.lang.Math.abs(c - j) > 5000000) {
                this.a.onSystemTimeUsMismatch(b, c, j, j2);
                audioTimestampPoller.f();
            } else if (java.lang.Math.abs(b(b) - j2) <= 5000000) {
                audioTimestampPoller.a();
            } else {
                this.a.onPositionFramesMismatch(b, c, j, j2);
                audioTimestampPoller.f();
            }
        }
    }

    public final void n() {
        long g = g();
        if (g == 0) {
            return;
        }
        long nanoTime = java.lang.System.nanoTime() / 1000;
        if (nanoTime - this.m >= 30000) {
            long[] jArr = this.b;
            int i = this.v;
            jArr[i] = g - nanoTime;
            this.v = (i + 1) % 10;
            int i2 = this.w;
            if (i2 < 10) {
                this.w = i2 + 1;
            }
            this.m = nanoTime;
            this.l = 0L;
            int i3 = 0;
            while (true) {
                int i4 = this.w;
                if (i3 >= i4) {
                    break;
                }
                this.l += this.b[i3] / i4;
                i3++;
            }
        }
        if (this.h) {
            return;
        }
        m(nanoTime, g);
        o(nanoTime);
    }

    public final void o(long j) {
        java.lang.reflect.Method method;
        if (!this.q || (method = this.n) == null || j - this.r < 500000) {
            return;
        }
        try {
            long intValue = (((java.lang.Integer) com.google.android.exoplayer2.util.Util.castNonNull((java.lang.Integer) method.invoke(com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c), new java.lang.Object[0]))).intValue() * 1000) - this.i;
            this.o = intValue;
            long max = java.lang.Math.max(intValue, 0L);
            this.o = max;
            if (max > 5000000) {
                this.a.onInvalidLatency(max);
                this.o = 0L;
            }
        } catch (java.lang.Exception unused) {
            this.n = null;
        }
        this.r = j;
    }

    public boolean q() {
        s();
        if (this.x != -9223372036854775807L) {
            return false;
        }
        ((com.google.android.exoplayer2.audio.AudioTimestampPoller) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f)).g();
        return true;
    }

    public void r() {
        s();
        this.c = null;
        this.f = null;
    }

    public final void s() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
    }

    public void t(android.media.AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.c = audioTrack;
        this.d = i2;
        this.e = i3;
        this.f = new com.google.android.exoplayer2.audio.AudioTimestampPoller(audioTrack);
        this.g = audioTrack.getSampleRate();
        this.h = z && p(i);
        boolean isEncodingLinearPcm = com.google.android.exoplayer2.util.Util.isEncodingLinearPcm(i);
        this.q = isEncodingLinearPcm;
        this.i = isEncodingLinearPcm ? b(i3 / i2) : -9223372036854775807L;
        this.f342s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.p = false;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.r = 0L;
        this.o = 0L;
        this.j = 1.0f;
    }

    public void u(float f) {
        this.j = f;
        com.google.android.exoplayer2.audio.AudioTimestampPoller audioTimestampPoller = this.f;
        if (audioTimestampPoller != null) {
            audioTimestampPoller.g();
        }
    }

    public void v() {
        ((com.google.android.exoplayer2.audio.AudioTimestampPoller) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f)).g();
    }
}
