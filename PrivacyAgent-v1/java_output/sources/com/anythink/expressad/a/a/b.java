package com.anythink.expressad.a.a;

/* loaded from: classes12.dex */
public final class b {
    public static int a = 0;
    public static int b = 1;
    private java.lang.String c;
    private int d;
    private java.util.HashSet<java.lang.String> e = new java.util.HashSet<>();
    private long f = java.lang.System.currentTimeMillis();
    private com.anythink.expressad.foundation.d.c g;
    private java.lang.String h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;

    public b(java.lang.String str, java.lang.String str2) {
        this.c = str;
        b(str2);
    }

    private java.lang.String i() {
        return this.c;
    }

    private java.util.HashSet<java.lang.String> j() {
        return this.e;
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.g = cVar;
    }

    public final void a(java.lang.String str) {
        this.h = str;
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final boolean a() {
        return this.j;
    }

    public final void b(int i) {
        this.i = i;
    }

    public final void b(java.lang.String str) {
        this.d++;
        this.e.add(str);
    }

    public final void b(boolean z) {
        this.k = z;
    }

    public final boolean b() {
        return this.k;
    }

    public final int c() {
        return this.l;
    }

    public final int d() {
        return this.i;
    }

    public final java.lang.String e() {
        return this.h;
    }

    public final com.anythink.expressad.foundation.d.c f() {
        return this.g;
    }

    public final int g() {
        return this.d;
    }

    public final long h() {
        return this.f;
    }
}
