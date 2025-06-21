package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
public final class g {
    private static final java.util.logging.Logger a = java.util.logging.Logger.getLogger(com.meizu.cloud.pushsdk.c.g.g.class.getName());

    /* renamed from: com.meizu.cloud.pushsdk.c.g.g$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.meizu.cloud.pushsdk.c.g.l {
        final /* synthetic */ com.meizu.cloud.pushsdk.c.g.n a;
        final /* synthetic */ java.io.OutputStream b;

        public AnonymousClass1(com.meizu.cloud.pushsdk.c.g.n nVar, java.io.OutputStream outputStream) {
            this.a = nVar;
            this.b = outputStream;
        }

        @Override // com.meizu.cloud.pushsdk.c.g.l
        public void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws java.io.IOException {
            com.meizu.cloud.pushsdk.c.g.o.a(bVar.b, 0L, j);
            while (j > 0) {
                this.a.a();
                com.meizu.cloud.pushsdk.c.g.j jVar = bVar.a;
                int min = (int) java.lang.Math.min(j, jVar.c - jVar.b);
                this.b.write(jVar.a, jVar.b, min);
                int i = jVar.b + min;
                jVar.b = i;
                long j2 = min;
                j -= j2;
                bVar.b -= j2;
                if (i == jVar.c) {
                    bVar.a = jVar.a();
                    com.meizu.cloud.pushsdk.c.g.k.a(jVar);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
        public void close() throws java.io.IOException {
            this.b.close();
        }

        @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
        public void flush() throws java.io.IOException {
            this.b.flush();
        }

        public java.lang.String toString() {
            return "sink(" + this.b + ")";
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.g.g$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.meizu.cloud.pushsdk.c.g.m {
        final /* synthetic */ com.meizu.cloud.pushsdk.c.g.n a;
        final /* synthetic */ java.io.InputStream b;

        public AnonymousClass2(com.meizu.cloud.pushsdk.c.g.n nVar, java.io.InputStream inputStream) {
            this.a = nVar;
            this.b = inputStream;
        }

        @Override // com.meizu.cloud.pushsdk.c.g.m
        public long b(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws java.io.IOException {
            if (j < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            this.a.a();
            com.meizu.cloud.pushsdk.c.g.j c = bVar.c(1);
            int read = this.b.read(c.a, c.c, (int) java.lang.Math.min(j, 2048 - c.c));
            if (read == -1) {
                return -1L;
            }
            c.c += read;
            long j2 = read;
            bVar.b += j2;
            return j2;
        }

        @Override // com.meizu.cloud.pushsdk.c.g.m, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.b.close();
        }

        public java.lang.String toString() {
            return "source(" + this.b + ")";
        }
    }

    private g() {
    }

    public static com.meizu.cloud.pushsdk.c.g.c a(com.meizu.cloud.pushsdk.c.g.l lVar) {
        if (lVar != null) {
            return new com.meizu.cloud.pushsdk.c.g.h(lVar);
        }
        throw new java.lang.IllegalArgumentException("sink == null");
    }

    public static com.meizu.cloud.pushsdk.c.g.d a(com.meizu.cloud.pushsdk.c.g.m mVar) {
        if (mVar != null) {
            return new com.meizu.cloud.pushsdk.c.g.i(mVar);
        }
        throw new java.lang.IllegalArgumentException("source == null");
    }

    public static com.meizu.cloud.pushsdk.c.g.l a(java.io.OutputStream outputStream) {
        return a(outputStream, new com.meizu.cloud.pushsdk.c.g.n());
    }

    private static com.meizu.cloud.pushsdk.c.g.l a(java.io.OutputStream outputStream, com.meizu.cloud.pushsdk.c.g.n nVar) {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        if (nVar != null) {
            return new com.meizu.cloud.pushsdk.c.g.g.AnonymousClass1(nVar, outputStream);
        }
        throw new java.lang.IllegalArgumentException("timeout == null");
    }

    public static com.meizu.cloud.pushsdk.c.g.m a(java.io.File file) throws java.io.FileNotFoundException {
        if (file != null) {
            return a(new java.io.FileInputStream(file));
        }
        throw new java.lang.IllegalArgumentException("file == null");
    }

    public static com.meizu.cloud.pushsdk.c.g.m a(java.io.InputStream inputStream) {
        return a(inputStream, new com.meizu.cloud.pushsdk.c.g.n());
    }

    private static com.meizu.cloud.pushsdk.c.g.m a(java.io.InputStream inputStream, com.meizu.cloud.pushsdk.c.g.n nVar) {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("in == null");
        }
        if (nVar != null) {
            return new com.meizu.cloud.pushsdk.c.g.g.AnonymousClass2(nVar, inputStream);
        }
        throw new java.lang.IllegalArgumentException("timeout == null");
    }
}
