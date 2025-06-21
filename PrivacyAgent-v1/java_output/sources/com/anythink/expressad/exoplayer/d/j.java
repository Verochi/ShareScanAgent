package com.anythink.expressad.exoplayer.d;

/* loaded from: classes12.dex */
public interface j<T extends com.anythink.expressad.exoplayer.d.i> {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 1;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;

    public static final class a implements com.anythink.expressad.exoplayer.d.j.d {
        private final byte[] a;
        private final java.lang.String b;

        public a(byte[] bArr, java.lang.String str) {
            this.a = bArr;
            this.b = str;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.d
        public final byte[] a() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.d
        public final java.lang.String b() {
            return this.b;
        }
    }

    public static final class b implements com.anythink.expressad.exoplayer.d.j.e {
        private final int a;
        private final byte[] b;

        public b(int i, byte[] bArr) {
            this.a = i;
            this.b = bArr;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.e
        public final int a() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.e
        public final byte[] b() {
            return this.b;
        }
    }

    public static final class c implements com.anythink.expressad.exoplayer.d.j.h {
        private final byte[] a;
        private final java.lang.String b;

        public c(byte[] bArr, java.lang.String str) {
            this.a = bArr;
            this.b = str;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.h
        public final byte[] a() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.d.j.h
        public final java.lang.String b() {
            return this.b;
        }
    }

    public interface d {
        byte[] a();

        java.lang.String b();
    }

    public interface e {
        int a();

        byte[] b();
    }

    public interface f<T extends com.anythink.expressad.exoplayer.d.i> {
        void a(byte[] bArr, int i);
    }

    public interface g<T extends com.anythink.expressad.exoplayer.d.i> {
        void a();
    }

    public interface h {
        byte[] a();

        java.lang.String b();
    }

    com.anythink.expressad.exoplayer.d.j.d a(byte[] bArr, byte[] bArr2, java.lang.String str, int i, java.util.HashMap<java.lang.String, java.lang.String> hashMap);

    java.lang.String a(java.lang.String str);

    void a(com.anythink.expressad.exoplayer.d.j.f<? super T> fVar);

    void a(com.anythink.expressad.exoplayer.d.j.g<? super T> gVar);

    void a(java.lang.String str, java.lang.String str2);

    void a(java.lang.String str, byte[] bArr);

    void a(byte[] bArr);

    byte[] a();

    byte[] a(byte[] bArr, byte[] bArr2);

    com.anythink.expressad.exoplayer.d.j.h b();

    void b(byte[] bArr);

    void b(byte[] bArr, byte[] bArr2);

    byte[] b(java.lang.String str);

    java.util.Map<java.lang.String, java.lang.String> c(byte[] bArr);

    void c();

    T d(byte[] bArr);
}
