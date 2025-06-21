package com.anythink.expressad.a;

/* loaded from: classes12.dex */
public class d {
    protected static final int b = 1;
    protected static final int c = 2;
    protected static final int d = 4;
    protected static final int e = 8;
    protected static final int f = 16;
    protected static final int g = 32;
    private int a = 1;
    protected com.anythink.expressad.a.e h;

    private int a() {
        return this.a;
    }

    private void a(int i) {
        this.a = i;
    }

    private void a(com.anythink.expressad.a.e eVar) {
        this.h = eVar;
    }

    private boolean c() {
        int i = this.a;
        return i == 8 || i == 16;
    }

    private boolean d() {
        return this.a == 2;
    }

    private boolean e() {
        return this.a == 32;
    }

    private boolean f() {
        return this.a == 4;
    }

    public void b() {
        this.a = 8;
    }
}
