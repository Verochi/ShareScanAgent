package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class ab extends com.anythink.expressad.exoplayer.ae {
    private static final java.lang.Object b = new java.lang.Object();
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final boolean i;
    private final boolean j;

    @androidx.annotation.Nullable
    private final java.lang.Object k;

    private ab(long j, long j2, boolean z, boolean z2, @androidx.annotation.Nullable java.lang.Object obj) {
        this.c = -9223372036854775807L;
        this.d = -9223372036854775807L;
        this.e = j;
        this.f = j2;
        this.g = 0L;
        this.h = 0L;
        this.i = z;
        this.j = z2;
        this.k = obj;
    }

    private ab(long j, long j2, boolean z, boolean z2, @androidx.annotation.Nullable java.lang.Object obj, byte b2) {
        this(j, j2, z, z2, obj);
    }

    private ab(long j, boolean z, boolean z2) {
        this(j, z, z2, null);
    }

    public ab(long j, boolean z, boolean z2, @androidx.annotation.Nullable java.lang.Object obj) {
        this(j, j, z, z2, obj, (byte) 0);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(java.lang.Object obj) {
        return b.equals(obj) ? 0 : -1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar, boolean z) {
        com.anythink.expressad.exoplayer.k.a.a(i, 1);
        return aVar.a(null, z ? b : null, this.e, -this.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r1 > r4) goto L12;
     */
    @Override // com.anythink.expressad.exoplayer.ae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar, boolean z, long j) {
        long j2;
        com.anythink.expressad.exoplayer.k.a.a(i, 1);
        java.lang.Object obj = z ? this.k : null;
        long j3 = this.h;
        boolean z2 = this.j;
        if (z2 && j != 0) {
            long j4 = this.f;
            if (j4 != -9223372036854775807L) {
                j3 += j;
            }
            j2 = -9223372036854775807L;
            return bVar.a(obj, this.c, this.d, this.i, z2, j2, this.f, this.g);
        }
        j2 = j3;
        return bVar.a(obj, this.c, this.d, this.i, z2, j2, this.f, this.g);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b() {
        return 1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int c() {
        return 1;
    }
}
