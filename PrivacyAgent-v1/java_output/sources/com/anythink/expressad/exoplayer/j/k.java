package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class k {
    public static final int a = 1;
    public static final int b = 2;
    public final android.net.Uri c;

    @androidx.annotation.Nullable
    public final byte[] d;
    public final long e;
    public final long f;
    public final long g;

    @androidx.annotation.Nullable
    public final java.lang.String h;
    public final int i;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    public k(android.net.Uri uri) {
        this(uri, 0);
    }

    public k(android.net.Uri uri, int i) {
        this(uri, 0L, -1L, null, i);
    }

    public k(android.net.Uri uri, long j, long j2, long j3, @androidx.annotation.Nullable java.lang.String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public k(android.net.Uri uri, long j, long j2, @androidx.annotation.Nullable java.lang.String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    public k(android.net.Uri uri, long j, @androidx.annotation.Nullable java.lang.String str) {
        this(uri, j, j, -1L, str, 0);
    }

    public k(android.net.Uri uri, @androidx.annotation.Nullable byte[] bArr, long j, long j2, long j3, @androidx.annotation.Nullable java.lang.String str, int i) {
        boolean z = true;
        com.anythink.expressad.exoplayer.k.a.a(j >= 0);
        com.anythink.expressad.exoplayer.k.a.a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        com.anythink.expressad.exoplayer.k.a.a(z);
        this.c = uri;
        this.d = bArr;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = str;
        this.i = i;
    }

    private com.anythink.expressad.exoplayer.j.k a(long j, long j2) {
        return (j == 0 && this.g == j2) ? this : new com.anythink.expressad.exoplayer.j.k(this.c, this.d, this.e + j, this.f + j, j2, this.h, this.i);
    }

    private com.anythink.expressad.exoplayer.j.k a(android.net.Uri uri) {
        return new com.anythink.expressad.exoplayer.j.k(uri, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public final com.anythink.expressad.exoplayer.j.k a(long j) {
        long j2 = this.g;
        long j3 = j2 != -1 ? j2 - j : -1L;
        return (j == 0 && j2 == j3) ? this : new com.anythink.expressad.exoplayer.j.k(this.c, this.d, this.e + j, this.f + j, j3, this.h, this.i);
    }

    public final boolean a(int i) {
        return (this.i & i) == i;
    }

    public final java.lang.String toString() {
        return "DataSpec[" + this.c + ", " + java.util.Arrays.toString(this.d) + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + ", " + this.i + "]";
    }
}
