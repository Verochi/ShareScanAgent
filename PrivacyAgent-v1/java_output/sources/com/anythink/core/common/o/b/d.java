package com.anythink.core.common.o.b;

/* loaded from: classes12.dex */
public abstract class d implements java.lang.Runnable {
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    protected com.anythink.core.common.o.b.e h;
    protected boolean g = true;
    protected int i = 1;
    private long a = 0;
    private java.lang.String b = "anythink_default_thread";

    private void a(com.anythink.core.common.o.b.e eVar) {
        this.h = eVar;
    }

    private java.lang.String c() {
        return this.b;
    }

    public abstract void a();

    public final void a(long j) {
        this.a = j;
    }

    public final void a(java.lang.String str) {
        this.b = str;
    }

    public final long b() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.Thread.currentThread().setName(this.b);
        a();
    }
}
