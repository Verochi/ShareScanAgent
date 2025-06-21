package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
public final class j {
    public static final int a = 0;
    public static final int b = 1;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final long g;
    public final com.anythink.expressad.exoplayer.m h;
    public final int i;

    @androidx.annotation.Nullable
    public final long[] j;

    @androidx.annotation.Nullable
    public final long[] k;
    public final int l;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.e.a.k[] m;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    public j(int i, int i2, long j, long j2, long j3, com.anythink.expressad.exoplayer.m mVar, int i3, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.e.a.k[] kVarArr, int i4, @androidx.annotation.Nullable long[] jArr, @androidx.annotation.Nullable long[] jArr2) {
        this.c = i;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = mVar;
        this.i = i3;
        this.m = kVarArr;
        this.l = i4;
        this.j = jArr;
        this.k = jArr2;
    }

    public final com.anythink.expressad.exoplayer.e.a.k a(int i) {
        com.anythink.expressad.exoplayer.e.a.k[] kVarArr = this.m;
        if (kVarArr == null) {
            return null;
        }
        return kVarArr[i];
    }
}
