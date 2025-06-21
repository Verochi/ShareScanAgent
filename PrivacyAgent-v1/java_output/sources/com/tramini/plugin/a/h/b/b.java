package com.tramini.plugin.a.h.b;

/* loaded from: classes19.dex */
public abstract class b implements java.lang.Runnable {
    private int a = 0;
    protected com.tramini.plugin.a.h.b.c d;

    private int b() {
        return this.a;
    }

    public abstract void a();

    public final void a(int i) {
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}
