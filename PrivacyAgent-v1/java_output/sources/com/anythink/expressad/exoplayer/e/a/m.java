package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
final class m {
    public final com.anythink.expressad.exoplayer.e.a.j a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public m(com.anythink.expressad.exoplayer.e.a.j jVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        com.anythink.expressad.exoplayer.k.a.a(iArr.length == jArr2.length);
        com.anythink.expressad.exoplayer.k.a.a(jArr.length == jArr2.length);
        com.anythink.expressad.exoplayer.k.a.a(iArr2.length == jArr2.length);
        this.a = jVar;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = jArr.length;
    }

    public final int a(long j) {
        for (int a = com.anythink.expressad.exoplayer.k.af.a(this.f, j, false); a >= 0; a--) {
            if ((this.g[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }

    public final int b(long j) {
        for (int a = com.anythink.expressad.exoplayer.k.af.a(this.f, j, true, false); a < this.f.length; a++) {
            if ((this.g[a] & 1) != 0) {
                return a;
            }
        }
        return -1;
    }
}
