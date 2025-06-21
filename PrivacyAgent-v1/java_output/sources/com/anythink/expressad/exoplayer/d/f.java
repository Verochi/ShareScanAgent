package com.anythink.expressad.exoplayer.d;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public interface f<T extends com.anythink.expressad.exoplayer.d.i> {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;

    public static class a extends java.lang.Exception {
        public a(java.lang.Throwable th) {
            super(th);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    int e();

    com.anythink.expressad.exoplayer.d.f.a f();

    T g();

    java.util.Map<java.lang.String, java.lang.String> h();

    byte[] i();
}
