package com.igexin.push.core.i.a;

/* loaded from: classes23.dex */
public interface d {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 0;

    public interface a {
        android.graphics.Bitmap a(int i, int i2, android.graphics.Bitmap.Config config, int i3);

        void a();

        void a(android.graphics.Bitmap bitmap);

        byte[] a(int i);

        void b();

        int[] b(int i);

        void c();
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    int a();

    int a(int i);

    int a(java.io.InputStream inputStream, int i);

    int a(byte[] bArr);

    void a(android.graphics.Bitmap.Config config);

    void a(com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer);

    void a(com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer, int i);

    void a(com.igexin.push.core.i.a.i iVar, byte[] bArr);

    int b();

    java.nio.ByteBuffer c();

    int d();

    void e();

    int f();

    int g();

    int h();

    void i();

    @java.lang.Deprecated
    int j();

    int k();

    int l();

    int m();

    android.graphics.Bitmap n();

    void o();
}
