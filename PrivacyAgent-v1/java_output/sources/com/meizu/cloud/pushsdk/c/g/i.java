package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
final class i implements com.meizu.cloud.pushsdk.c.g.d {
    private final com.meizu.cloud.pushsdk.c.g.b a;
    private final com.meizu.cloud.pushsdk.c.g.m b;
    private boolean c;

    /* renamed from: com.meizu.cloud.pushsdk.c.g.i$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.InputStream {
        public AnonymousClass1() {
        }

        @Override // java.io.InputStream
        public int available() throws java.io.IOException {
            if (com.meizu.cloud.pushsdk.c.g.i.this.c) {
                throw new java.io.IOException("closed");
            }
            return (int) java.lang.Math.min(com.meizu.cloud.pushsdk.c.g.i.this.a.b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            com.meizu.cloud.pushsdk.c.g.i.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws java.io.IOException {
            if (com.meizu.cloud.pushsdk.c.g.i.this.c) {
                throw new java.io.IOException("closed");
            }
            if (com.meizu.cloud.pushsdk.c.g.i.this.a.b == 0 && com.meizu.cloud.pushsdk.c.g.i.this.b.b(com.meizu.cloud.pushsdk.c.g.i.this.a, 2048L) == -1) {
                return -1;
            }
            return com.meizu.cloud.pushsdk.c.g.i.this.a.f() & 255;
        }

        @Override // java.io.InputStream
        public int read(@androidx.annotation.NonNull byte[] bArr, int i, int i2) throws java.io.IOException {
            if (com.meizu.cloud.pushsdk.c.g.i.this.c) {
                throw new java.io.IOException("closed");
            }
            com.meizu.cloud.pushsdk.c.g.o.a(bArr.length, i, i2);
            if (com.meizu.cloud.pushsdk.c.g.i.this.a.b == 0 && com.meizu.cloud.pushsdk.c.g.i.this.b.b(com.meizu.cloud.pushsdk.c.g.i.this.a, 2048L) == -1) {
                return -1;
            }
            return com.meizu.cloud.pushsdk.c.g.i.this.a.a(bArr, i, i2);
        }

        public java.lang.String toString() {
            return com.meizu.cloud.pushsdk.c.g.i.this + ".inputStream()";
        }
    }

    public i(com.meizu.cloud.pushsdk.c.g.m mVar) {
        this(mVar, new com.meizu.cloud.pushsdk.c.g.b());
    }

    public i(com.meizu.cloud.pushsdk.c.g.m mVar, com.meizu.cloud.pushsdk.c.g.b bVar) {
        if (mVar == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        this.a = bVar;
        this.b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m
    public long b(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws java.io.IOException {
        if (bVar == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        com.meizu.cloud.pushsdk.c.g.b bVar2 = this.a;
        if (bVar2.b == 0 && this.b.b(bVar2, 2048L) == -1) {
            return -1L;
        }
        return this.a.b(bVar, java.lang.Math.min(j, this.a.b));
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.j();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public java.io.InputStream d() {
        return new com.meizu.cloud.pushsdk.c.g.i.AnonymousClass1();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public java.lang.String h() throws java.io.IOException {
        this.a.a(this.b);
        return this.a.h();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public byte[] i() throws java.io.IOException {
        this.a.a(this.b);
        return this.a.i();
    }

    public java.lang.String toString() {
        return "buffer(" + this.b + ")";
    }
}
