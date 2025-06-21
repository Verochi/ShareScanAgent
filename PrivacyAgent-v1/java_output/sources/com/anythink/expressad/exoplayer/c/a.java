package com.anythink.expressad.exoplayer.c;

/* loaded from: classes12.dex */
public abstract class a {
    private int a;

    private void d(int i) {
        this.a = (~i) & this.a;
    }

    public void a() {
        this.a = 0;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void b(int i) {
        this.a = i | this.a;
    }

    public final boolean b() {
        return c(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return c(4);
    }

    public final boolean c(int i) {
        return (this.a & i) == i;
    }

    public final boolean d() {
        return c(1);
    }
}
