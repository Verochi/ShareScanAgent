package com.anythink.china.common.a;

/* loaded from: classes12.dex */
public final class e {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public android.graphics.Bitmap d;
    public java.lang.String e;
    public java.lang.String f;
    public long g;
    public long h;
    public long i;
    public com.anythink.core.common.f.l j;
    public java.lang.String k;
    public com.anythink.core.common.g.b l;
    public java.lang.String m;
    public java.lang.String n;
    public int p;
    public int q;
    public boolean o = false;
    private volatile com.anythink.china.common.a.e.a r = com.anythink.china.common.a.e.a.IDLE;

    public enum a {
        IDLE,
        LOADING,
        PAUSE,
        STOP,
        FINISH,
        FAIL,
        INSTALLED
    }

    private boolean o() {
        return this.r == com.anythink.china.common.a.e.a.STOP;
    }

    public final com.anythink.china.common.a.e.a a() {
        return this.r;
    }

    public final boolean b() {
        return this.r == com.anythink.china.common.a.e.a.IDLE;
    }

    public final boolean c() {
        return this.r == com.anythink.china.common.a.e.a.PAUSE;
    }

    public final boolean d() {
        return this.r == com.anythink.china.common.a.e.a.LOADING;
    }

    public final void e() {
        this.r = com.anythink.china.common.a.e.a.IDLE;
    }

    public final boolean f() {
        return this.r == com.anythink.china.common.a.e.a.INSTALLED;
    }

    public final boolean g() {
        return this.r == com.anythink.china.common.a.e.a.FINISH;
    }

    public final boolean h() {
        return this.r == com.anythink.china.common.a.e.a.FAIL;
    }

    public final void i() {
        this.r = com.anythink.china.common.a.e.a.LOADING;
    }

    public final void j() {
        this.r = com.anythink.china.common.a.e.a.STOP;
    }

    public final void k() {
        this.r = com.anythink.china.common.a.e.a.PAUSE;
    }

    public final void l() {
        this.r = com.anythink.china.common.a.e.a.FINISH;
    }

    public final void m() {
        this.r = com.anythink.china.common.a.e.a.INSTALLED;
    }

    public final void n() {
        this.r = com.anythink.china.common.a.e.a.FAIL;
    }
}
