package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class j {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final long h;

    private j(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = j;
    }

    private j(byte[] bArr, int i) {
        com.anythink.expressad.exoplayer.k.r rVar = new com.anythink.expressad.exoplayer.k.r(bArr);
        rVar.a(i * 8);
        this.a = rVar.c(16);
        this.b = rVar.c(16);
        this.c = rVar.c(24);
        this.d = rVar.c(24);
        this.e = rVar.c(20);
        this.f = rVar.c(3) + 1;
        this.g = rVar.c(5) + 1;
        this.h = ((rVar.c(4) & 15) << 32) | (rVar.c(32) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
    }

    private int a() {
        return this.b * this.f * (this.g / 8);
    }

    private long a(long j) {
        return com.anythink.expressad.exoplayer.k.af.a((j * this.e) / 1000000, this.h - 1);
    }

    private int b() {
        return this.g * this.e;
    }

    private long c() {
        return (this.h * 1000000) / this.e;
    }

    private long d() {
        long j;
        long j2;
        int i = this.d;
        if (i > 0) {
            j = (i + this.c) / 2;
            j2 = 1;
        } else {
            int i2 = this.a;
            j = ((((i2 != this.b || i2 <= 0) ? 4096L : i2) * this.f) * this.g) / 8;
            j2 = 64;
        }
        return j + j2;
    }
}
