package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class az {
    private final java.lang.String a = com.anythink.core.common.f.az.class.getSimpleName();
    private com.anythink.core.d.e b;
    private com.anythink.core.common.f.v c;
    private boolean d;
    private long e;
    private boolean f;
    private int g;
    private int h;
    private boolean i;
    private long j;

    public az(com.anythink.core.common.f.v vVar, com.anythink.core.d.e eVar) {
        int i = vVar.d;
        this.c = vVar;
        this.b = eVar;
        this.d = eVar.v() == 1 && i != 8;
        this.e = eVar.h();
        this.f = eVar.f() != 1 && eVar.v() == 1;
        this.g = i == 9 ? eVar.d() : eVar.w();
        this.h = i == 9 ? eVar.e() : eVar.aj();
        this.i = eVar.f() != 1;
        this.j = -1L;
        toString();
    }

    private long p() {
        return this.b.A();
    }

    public final com.anythink.core.d.e a() {
        return this.b;
    }

    public final boolean b() {
        return this.d;
    }

    public final long c() {
        return this.e;
    }

    public final boolean d() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public final boolean g() {
        return this.i;
    }

    public final int h() {
        return this.b.av();
    }

    public final long i() {
        return this.b.ab();
    }

    public final long j() {
        if (!this.c.j) {
            return this.b.y();
        }
        long j = this.j;
        if (j >= 0) {
            return j;
        }
        long elapsedRealtime = (r0.h - (android.os.SystemClock.elapsedRealtime() - this.c.k)) - 100;
        this.j = elapsedRealtime;
        if (elapsedRealtime < 0) {
            this.j = 0L;
        }
        return this.j;
    }

    public final int k() {
        return this.b.m();
    }

    public final long l() {
        return this.b.R();
    }

    public final long m() {
        return this.b.L();
    }

    public final long n() {
        return this.b.ac();
    }

    public final long o() {
        return this.b.F();
    }

    public final java.lang.String toString() {
        return "WaterfallSetting{canLoadFailRetry=" + this.d + ", loadFailRetryDelayTime=" + this.e + ", cannBiddingFailRetry=" + this.f + ", requestType=" + this.g + ", requestNum=" + this.h + ", canBuyerIdOverTimeToBid=" + this.i + ", cacheNum:" + this.b.av() + '}';
    }
}
