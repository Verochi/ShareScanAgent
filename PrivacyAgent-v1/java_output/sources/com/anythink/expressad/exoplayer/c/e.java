package com.anythink.expressad.exoplayer.c;

/* loaded from: classes12.dex */
public class e extends com.anythink.expressad.exoplayer.c.a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public final com.anythink.expressad.exoplayer.c.b d = new com.anythink.expressad.exoplayer.c.b();
    public java.nio.ByteBuffer e;
    public long f;
    private final int g;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    public e(int i) {
        this.g = i;
    }

    public static com.anythink.expressad.exoplayer.c.e e() {
        return new com.anythink.expressad.exoplayer.c.e(0);
    }

    private java.nio.ByteBuffer e(int i) {
        int i2 = this.g;
        if (i2 == 1) {
            return java.nio.ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return java.nio.ByteBuffer.allocateDirect(i);
        }
        java.nio.ByteBuffer byteBuffer = this.e;
        throw new java.lang.IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i + ")");
    }

    @Override // com.anythink.expressad.exoplayer.c.a
    public final void a() {
        super.a();
        java.nio.ByteBuffer byteBuffer = this.e;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final void d(int i) {
        java.nio.ByteBuffer byteBuffer = this.e;
        if (byteBuffer == null) {
            this.e = e(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.e.position();
        int i2 = i + position;
        if (capacity >= i2) {
            return;
        }
        java.nio.ByteBuffer e = e(i2);
        if (position > 0) {
            this.e.position(0);
            this.e.limit(position);
            e.put(this.e);
        }
        this.e = e;
    }

    public final boolean f() {
        return this.e == null && this.g == 0;
    }

    public final boolean g() {
        return c(1073741824);
    }

    public final void h() {
        this.e.flip();
    }
}
