package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
final class h implements com.meizu.cloud.pushsdk.c.g.c {
    private final com.meizu.cloud.pushsdk.c.g.b a;
    private final com.meizu.cloud.pushsdk.c.g.l b;
    private boolean c;

    public h(com.meizu.cloud.pushsdk.c.g.l lVar) {
        this(lVar, new com.meizu.cloud.pushsdk.c.g.b());
    }

    public h(com.meizu.cloud.pushsdk.c.g.l lVar, com.meizu.cloud.pushsdk.c.g.b bVar) {
        if (lVar == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        this.a = bVar;
        this.b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(com.meizu.cloud.pushsdk.c.g.m mVar) throws java.io.IOException {
        if (mVar == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = mVar.b(this.a, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
            a();
        }
    }

    public com.meizu.cloud.pushsdk.c.g.c a() throws java.io.IOException {
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        long e = this.a.e();
        if (e > 0) {
            this.b.a(this.a, e);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws java.io.IOException {
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public com.meizu.cloud.pushsdk.c.g.b b() {
        return this.a;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public com.meizu.cloud.pushsdk.c.g.c b(com.meizu.cloud.pushsdk.c.g.e eVar) throws java.io.IOException {
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public com.meizu.cloud.pushsdk.c.g.c b(java.lang.String str) throws java.io.IOException {
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public com.meizu.cloud.pushsdk.c.g.c c(byte[] bArr) throws java.io.IOException {
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public com.meizu.cloud.pushsdk.c.g.c c(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() {
        if (this.c) {
            return;
        }
        try {
            com.meizu.cloud.pushsdk.c.g.b bVar = this.a;
            long j = bVar.b;
            if (j > 0) {
                this.b.a(bVar, j);
            }
            th = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            this.b.close();
        } catch (java.lang.Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            com.meizu.cloud.pushsdk.c.g.o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public com.meizu.cloud.pushsdk.c.g.c e(long j) throws java.io.IOException {
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() throws java.io.IOException {
        if (this.c) {
            throw new java.lang.IllegalStateException("closed");
        }
        com.meizu.cloud.pushsdk.c.g.b bVar = this.a;
        long j = bVar.b;
        if (j > 0) {
            this.b.a(bVar, j);
        }
        this.b.flush();
    }

    public java.lang.String toString() {
        return "buffer(" + this.b + ")";
    }
}
