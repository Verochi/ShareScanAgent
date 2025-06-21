package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public interface h {
    public static final long a = Long.MIN_VALUE;

    public static final class a extends java.lang.Exception {
        public a(java.lang.String str) {
            super(str);
        }

        public a(java.lang.Throwable th) {
            super(th);
        }
    }

    public static final class b extends java.lang.Exception {
        public final int a;

        public b(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.a = i;
        }
    }

    public interface c {
        void a();

        void a(int i);

        void a(int i, long j, long j2);
    }

    public static final class d extends java.lang.Exception {
        public final int a;

        public d(int i) {
            super("AudioTrack write failed: ".concat(java.lang.String.valueOf(i)));
            this.a = i;
        }
    }

    long a(boolean z);

    com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar);

    void a();

    void a(float f);

    void a(int i, int i2, int i3, @androidx.annotation.Nullable int[] iArr, int i4, int i5);

    void a(com.anythink.expressad.exoplayer.b.b bVar);

    void a(com.anythink.expressad.exoplayer.b.h.c cVar);

    boolean a(int i);

    boolean a(java.nio.ByteBuffer byteBuffer, long j);

    void b();

    void b(int i);

    void c();

    void c(int i);

    boolean d();

    boolean e();

    com.anythink.expressad.exoplayer.v f();

    void g();

    void h();

    void i();

    void j();
}
