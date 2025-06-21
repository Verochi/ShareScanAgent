package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
public abstract class f implements com.meizu.cloud.pushsdk.c.g.l {
    private final com.meizu.cloud.pushsdk.c.g.l a;

    public f(com.meizu.cloud.pushsdk.c.g.l lVar) {
        if (lVar == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.a = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws java.io.IOException {
        this.a.a(bVar, j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() throws java.io.IOException {
        this.a.close();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.a.flush();
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
