package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public final class g extends java.lang.Exception {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public final int d;
    public final int e;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    private g(int i, java.lang.String str, java.lang.Throwable th, int i2) {
        super(str, th);
        this.d = i;
        this.e = i2;
    }

    public static com.anythink.expressad.exoplayer.g a(java.io.IOException iOException) {
        return new com.anythink.expressad.exoplayer.g(0, null, iOException, -1);
    }

    public static com.anythink.expressad.exoplayer.g a(java.lang.Exception exc, int i) {
        return new com.anythink.expressad.exoplayer.g(1, null, exc, i);
    }

    public static com.anythink.expressad.exoplayer.g a(java.lang.RuntimeException runtimeException) {
        return new com.anythink.expressad.exoplayer.g(2, null, runtimeException, -1);
    }

    private java.io.IOException a() {
        com.anythink.expressad.exoplayer.k.a.b(this.d == 0);
        return (java.io.IOException) getCause();
    }

    private java.lang.Exception b() {
        com.anythink.expressad.exoplayer.k.a.b(this.d == 1);
        return (java.lang.Exception) getCause();
    }

    private java.lang.RuntimeException c() {
        com.anythink.expressad.exoplayer.k.a.b(this.d == 2);
        return (java.lang.RuntimeException) getCause();
    }
}
