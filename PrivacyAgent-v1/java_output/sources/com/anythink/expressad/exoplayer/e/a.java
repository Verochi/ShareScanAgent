package com.anythink.expressad.exoplayer.e;

/* loaded from: classes12.dex */
public final class a implements com.anythink.expressad.exoplayer.e.k {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    private int b(long j) {
        return com.anythink.expressad.exoplayer.k.af.a(this.e, j, true);
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final com.anythink.expressad.exoplayer.e.k.a a(long j) {
        int a = com.anythink.expressad.exoplayer.k.af.a(this.e, j, true);
        com.anythink.expressad.exoplayer.e.l lVar = new com.anythink.expressad.exoplayer.e.l(this.e[a], this.c[a]);
        if (lVar.b >= j || a == this.a - 1) {
            return new com.anythink.expressad.exoplayer.e.k.a(lVar);
        }
        int i = a + 1;
        return new com.anythink.expressad.exoplayer.e.k.a(lVar, new com.anythink.expressad.exoplayer.e.l(this.e[i], this.c[i]));
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final boolean a() {
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final long b() {
        return this.f;
    }

    public final java.lang.String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + java.util.Arrays.toString(this.b) + ", offsets=" + java.util.Arrays.toString(this.c) + ", timeUs=" + java.util.Arrays.toString(this.e) + ", durationsUs=" + java.util.Arrays.toString(this.d) + ")";
    }
}
