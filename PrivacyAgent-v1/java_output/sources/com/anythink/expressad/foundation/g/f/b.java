package com.anythink.expressad.foundation.g.f;

/* loaded from: classes12.dex */
public final class b implements com.anythink.expressad.foundation.g.f.l {
    private int a;
    private int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.a = 30000;
        this.c = 0;
    }

    private b(int i, int i2, int i3, int i4, int i5) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.e = java.lang.Math.max(i, 0);
        this.f = java.lang.Math.max(i2, 0);
        this.g = java.lang.Math.max(i3, 0);
        this.h = java.lang.Math.max(i4, 0);
        this.c = java.lang.Math.max(i5, 0);
    }

    private b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.e = java.lang.Math.max(i, 0);
        this.f = java.lang.Math.max(i2, 0);
        this.g = java.lang.Math.max(i3, 0);
        this.h = java.lang.Math.max(i4, 0);
        this.c = java.lang.Math.max(i5, 0);
        this.d = i6;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int a() {
        return this.c;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int b() {
        return this.a;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int c() {
        return this.b;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final boolean d() {
        int i = this.b + 1;
        this.b = i;
        return i <= this.c;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int e() {
        return this.e;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int f() {
        return this.f;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int g() {
        return this.g;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int h() {
        return this.h;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int i() {
        return this.d;
    }
}
