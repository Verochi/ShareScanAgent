package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public interface f {
    public static final java.nio.ByteBuffer a = java.nio.ByteBuffer.allocateDirect(0).order(java.nio.ByteOrder.nativeOrder());

    public static final class a extends java.lang.Exception {
        public a(int i, int i2, int i3) {
            super("Unhandled format: " + i + " Hz, " + i2 + " channels in encoding " + i3);
        }
    }

    void a(java.nio.ByteBuffer byteBuffer);

    boolean a();

    boolean a(int i, int i2, int i3);

    int b();

    int c();

    int d();

    void e();

    java.nio.ByteBuffer f();

    boolean g();

    void h();

    void i();
}
