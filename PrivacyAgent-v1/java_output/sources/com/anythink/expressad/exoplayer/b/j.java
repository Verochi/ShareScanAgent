package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
final class j {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static final long d = 5000000;
    private static final long e = 5000000;
    private static final long f = 200;
    private static final int g = 10;
    private static final int h = 30000;
    private static final int i = 500000;
    private long A;
    private long B;
    private int C;
    private int D;
    private long E;
    private long F;
    private long G;
    private long H;
    private final com.anythink.expressad.exoplayer.b.j.a j;
    private final long[] k;
    private android.media.AudioTrack l;
    private int m;
    private int n;
    private com.anythink.expressad.exoplayer.b.i o;
    private int p;
    private boolean q;
    private long r;

    /* renamed from: s, reason: collision with root package name */
    private long f204s;
    private long t;
    private java.lang.reflect.Method u;
    private long v;
    private boolean w;
    private boolean x;
    private long y;
    private long z;

    public interface a {
        void a(int i, long j);

        void a(long j);

        void a(long j, long j2, long j3, long j4);

        void b(long j, long j2, long j3, long j4);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    public j(com.anythink.expressad.exoplayer.b.j.a aVar) {
        this.j = (com.anythink.expressad.exoplayer.b.j.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        if (com.anythink.expressad.exoplayer.k.af.a >= 18) {
            try {
                this.u = android.media.AudioTrack.class.getMethod("getLatency", null);
            } catch (java.lang.NoSuchMethodException unused) {
            }
        }
        this.k = new long[10];
    }

    private void a(long j, long j2) {
        if (this.o.a(j)) {
            long f2 = this.o.f();
            long g2 = this.o.g();
            if (java.lang.Math.abs(f2 - j) > 5000000) {
                this.j.b(g2, f2, j, j2);
                this.o.a();
            } else if (java.lang.Math.abs(g(g2) - j2) <= 5000000) {
                this.o.b();
            } else {
                this.j.a(g2, f2, j, j2);
                this.o.a();
            }
        }
    }

    private static boolean a(int i2) {
        if (com.anythink.expressad.exoplayer.k.af.a < 23) {
            return i2 == 5 || i2 == 6;
        }
        return false;
    }

    private void e() {
        long h2 = h();
        if (h2 == 0) {
            return;
        }
        long nanoTime = java.lang.System.nanoTime() / 1000;
        if (nanoTime - this.t >= 30000) {
            long[] jArr = this.k;
            int i2 = this.C;
            jArr[i2] = h2 - nanoTime;
            this.C = (i2 + 1) % 10;
            int i3 = this.D;
            if (i3 < 10) {
                this.D = i3 + 1;
            }
            this.t = nanoTime;
            this.f204s = 0L;
            int i4 = 0;
            while (true) {
                int i5 = this.D;
                if (i4 >= i5) {
                    break;
                }
                this.f204s += this.k[i4] / i5;
                i4++;
            }
        }
        if (this.q) {
            return;
        }
        if (this.o.a(nanoTime)) {
            long f2 = this.o.f();
            long g2 = this.o.g();
            if (java.lang.Math.abs(f2 - nanoTime) > 5000000) {
                this.j.b(g2, f2, nanoTime, h2);
                this.o.a();
            } else if (java.lang.Math.abs(g(g2) - h2) > 5000000) {
                this.j.a(g2, f2, nanoTime, h2);
                this.o.a();
            } else {
                this.o.b();
            }
        }
        f(nanoTime);
    }

    private void f() {
        this.f204s = 0L;
        this.D = 0;
        this.C = 0;
        this.t = 0L;
    }

    private void f(long j) {
        java.lang.reflect.Method method;
        if (!this.x || (method = this.u) == null || j - this.y < 500000) {
            return;
        }
        try {
            long intValue = (((java.lang.Integer) method.invoke(this.l, null)).intValue() * 1000) - this.r;
            this.v = intValue;
            long max = java.lang.Math.max(intValue, 0L);
            this.v = max;
            if (max > 5000000) {
                this.j.a(max);
                this.v = 0L;
            }
        } catch (java.lang.Exception unused) {
            this.u = null;
        }
        this.y = j;
    }

    private long g(long j) {
        return (j * 1000000) / this.p;
    }

    private boolean g() {
        return this.q && this.l.getPlayState() == 2 && i() == 0;
    }

    private long h() {
        return g(i());
    }

    private long i() {
        if (this.E != -9223372036854775807L) {
            return java.lang.Math.min(this.H, this.G + ((((android.os.SystemClock.elapsedRealtime() * 1000) - this.E) * this.p) / 1000000));
        }
        int playState = this.l.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = this.l.getPlaybackHeadPosition() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        if (this.q) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.B = this.z;
            }
            playbackHeadPosition += this.B;
        }
        if (com.anythink.expressad.exoplayer.k.af.a <= 28) {
            if (playbackHeadPosition == 0 && this.z > 0 && playState == 3) {
                if (this.F == -9223372036854775807L) {
                    this.F = android.os.SystemClock.elapsedRealtime();
                }
                return this.z;
            }
            this.F = -9223372036854775807L;
        }
        if (this.z > playbackHeadPosition) {
            this.A++;
        }
        this.z = playbackHeadPosition;
        return playbackHeadPosition + (this.A << 32);
    }

    public final long a(boolean z) {
        if (this.l.getPlayState() == 3) {
            long h2 = h();
            if (h2 != 0) {
                long nanoTime = java.lang.System.nanoTime() / 1000;
                if (nanoTime - this.t >= 30000) {
                    long[] jArr = this.k;
                    int i2 = this.C;
                    jArr[i2] = h2 - nanoTime;
                    this.C = (i2 + 1) % 10;
                    int i3 = this.D;
                    if (i3 < 10) {
                        this.D = i3 + 1;
                    }
                    this.t = nanoTime;
                    this.f204s = 0L;
                    int i4 = 0;
                    while (true) {
                        int i5 = this.D;
                        if (i4 >= i5) {
                            break;
                        }
                        this.f204s += this.k[i4] / i5;
                        i4++;
                    }
                }
                if (!this.q) {
                    if (this.o.a(nanoTime)) {
                        long f2 = this.o.f();
                        long g2 = this.o.g();
                        if (java.lang.Math.abs(f2 - nanoTime) > 5000000) {
                            this.j.b(g2, f2, nanoTime, h2);
                            this.o.a();
                        } else if (java.lang.Math.abs(g(g2) - h2) > 5000000) {
                            this.j.a(g2, f2, nanoTime, h2);
                            this.o.a();
                        } else {
                            this.o.b();
                        }
                    }
                    f(nanoTime);
                }
            }
        }
        long nanoTime2 = java.lang.System.nanoTime() / 1000;
        if (this.o.c()) {
            long g3 = g(this.o.g());
            return !this.o.d() ? g3 : g3 + (nanoTime2 - this.o.f());
        }
        long h3 = this.D == 0 ? h() : nanoTime2 + this.f204s;
        return !z ? h3 - this.v : h3;
    }

    public final void a() {
        this.o.e();
    }

    public final void a(android.media.AudioTrack audioTrack, int i2, int i3, int i4) {
        this.l = audioTrack;
        this.m = i3;
        this.n = i4;
        this.o = new com.anythink.expressad.exoplayer.b.i(audioTrack);
        this.p = audioTrack.getSampleRate();
        this.q = com.anythink.expressad.exoplayer.k.af.a < 23 && (i2 == 5 || i2 == 6);
        boolean b2 = com.anythink.expressad.exoplayer.k.af.b(i2);
        this.x = b2;
        this.r = b2 ? g(i4 / i3) : -9223372036854775807L;
        this.z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.w = false;
        this.E = -9223372036854775807L;
        this.F = -9223372036854775807L;
        this.v = 0L;
    }

    public final boolean a(long j) {
        com.anythink.expressad.exoplayer.b.j.a aVar;
        int playState = this.l.getPlayState();
        if (this.q) {
            if (playState == 2) {
                this.w = false;
                return false;
            }
            if (playState == 1 && i() == 0) {
                return false;
            }
        }
        boolean z = this.w;
        boolean e2 = e(j);
        this.w = e2;
        if (z && !e2 && playState != 1 && (aVar = this.j) != null) {
            aVar.a(this.n, com.anythink.expressad.exoplayer.b.a(this.r));
        }
        return true;
    }

    public final int b(long j) {
        return this.n - ((int) (j - (i() * this.m)));
    }

    public final boolean b() {
        return this.l.getPlayState() == 3;
    }

    public final boolean c() {
        f();
        if (this.E != -9223372036854775807L) {
            return false;
        }
        this.o.e();
        return true;
    }

    public final boolean c(long j) {
        return this.F != -9223372036854775807L && j > 0 && android.os.SystemClock.elapsedRealtime() - this.F >= 200;
    }

    public final void d() {
        f();
        this.l = null;
        this.o = null;
    }

    public final void d(long j) {
        this.G = i();
        this.E = android.os.SystemClock.elapsedRealtime() * 1000;
        this.H = j;
    }

    public final boolean e(long j) {
        return j > i() || g();
    }
}
