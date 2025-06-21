package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public final class h extends com.meizu.cloud.pushsdk.c.c.j {
    public static final com.meizu.cloud.pushsdk.c.c.g a = com.meizu.cloud.pushsdk.c.c.g.a("multipart/mixed");
    public static final com.meizu.cloud.pushsdk.c.c.g b = com.meizu.cloud.pushsdk.c.c.g.a("multipart/alternative");
    public static final com.meizu.cloud.pushsdk.c.c.g c = com.meizu.cloud.pushsdk.c.c.g.a("multipart/digest");
    public static final com.meizu.cloud.pushsdk.c.c.g d = com.meizu.cloud.pushsdk.c.c.g.a("multipart/parallel");
    public static final com.meizu.cloud.pushsdk.c.c.g e = com.meizu.cloud.pushsdk.c.c.g.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final com.meizu.cloud.pushsdk.c.g.e i;
    private final com.meizu.cloud.pushsdk.c.c.g j;
    private final com.meizu.cloud.pushsdk.c.c.g k;
    private final java.util.List<com.meizu.cloud.pushsdk.c.c.h.b> l;
    private long m = -1;

    public static final class a {
        private final com.meizu.cloud.pushsdk.c.g.e a;
        private com.meizu.cloud.pushsdk.c.c.g b;
        private final java.util.List<com.meizu.cloud.pushsdk.c.c.h.b> c;

        public a() {
            this(java.util.UUID.randomUUID().toString());
        }

        public a(java.lang.String str) {
            this.b = com.meizu.cloud.pushsdk.c.c.h.a;
            this.c = new java.util.ArrayList();
            this.a = com.meizu.cloud.pushsdk.c.g.e.a(str);
        }

        public com.meizu.cloud.pushsdk.c.c.h.a a(com.meizu.cloud.pushsdk.c.c.c cVar, com.meizu.cloud.pushsdk.c.c.j jVar) {
            return a(com.meizu.cloud.pushsdk.c.c.h.b.a(cVar, jVar));
        }

        public com.meizu.cloud.pushsdk.c.c.h.a a(com.meizu.cloud.pushsdk.c.c.g gVar) {
            if (gVar == null) {
                throw new java.lang.NullPointerException("type == null");
            }
            if ("multipart".equals(gVar.a())) {
                this.b = gVar;
                return this;
            }
            throw new java.lang.IllegalArgumentException("multipart != " + gVar);
        }

        public com.meizu.cloud.pushsdk.c.c.h.a a(com.meizu.cloud.pushsdk.c.c.h.b bVar) {
            if (bVar == null) {
                throw new java.lang.NullPointerException("part == null");
            }
            this.c.add(bVar);
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.h a() {
            if (this.c.isEmpty()) {
                throw new java.lang.IllegalStateException("Multipart body must have at least one part.");
            }
            return new com.meizu.cloud.pushsdk.c.c.h(this.a, this.b, this.c);
        }
    }

    public static final class b {
        private final com.meizu.cloud.pushsdk.c.c.c a;
        private final com.meizu.cloud.pushsdk.c.c.j b;

        private b(com.meizu.cloud.pushsdk.c.c.c cVar, com.meizu.cloud.pushsdk.c.c.j jVar) {
            this.a = cVar;
            this.b = jVar;
        }

        public static com.meizu.cloud.pushsdk.c.c.h.b a(com.meizu.cloud.pushsdk.c.c.c cVar, com.meizu.cloud.pushsdk.c.c.j jVar) {
            if (jVar == null) {
                throw new java.lang.NullPointerException("body == null");
            }
            if (cVar != null && cVar.a("Content-Type") != null) {
                throw new java.lang.IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (cVar == null || cVar.a("Content-Length") == null) {
                return new com.meizu.cloud.pushsdk.c.c.h.b(cVar, jVar);
            }
            throw new java.lang.IllegalArgumentException("Unexpected header: Content-Length");
        }
    }

    public h(com.meizu.cloud.pushsdk.c.g.e eVar, com.meizu.cloud.pushsdk.c.c.g gVar, java.util.List<com.meizu.cloud.pushsdk.c.c.h.b> list) {
        this.i = eVar;
        this.j = gVar;
        this.k = com.meizu.cloud.pushsdk.c.c.g.a(gVar + "; boundary=" + eVar.a());
        this.l = com.meizu.cloud.pushsdk.c.c.m.a(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(com.meizu.cloud.pushsdk.c.g.c cVar, boolean z) throws java.io.IOException {
        com.meizu.cloud.pushsdk.c.g.b bVar;
        if (z) {
            cVar = new com.meizu.cloud.pushsdk.c.g.b();
            bVar = cVar;
        } else {
            bVar = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            com.meizu.cloud.pushsdk.c.c.h.b bVar2 = this.l.get(i);
            com.meizu.cloud.pushsdk.c.c.c cVar2 = bVar2.a;
            com.meizu.cloud.pushsdk.c.c.j jVar = bVar2.b;
            cVar.c(h);
            cVar.b(this.i);
            cVar.c(g);
            if (cVar2 != null) {
                int a2 = cVar2.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    cVar.b(cVar2.a(i2)).c(f).b(cVar2.b(i2)).c(g);
                }
            }
            com.meizu.cloud.pushsdk.c.c.g a3 = jVar.a();
            if (a3 != null) {
                cVar.b("Content-Type: ").b(a3.toString()).c(g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                cVar.b("Content-Length: ").e(b2).c(g);
            } else if (z) {
                bVar.j();
                return -1L;
            }
            byte[] bArr = g;
            cVar.c(bArr);
            if (z) {
                j += b2;
            } else {
                jVar.a(cVar);
            }
            cVar.c(bArr);
        }
        byte[] bArr2 = h;
        cVar.c(bArr2);
        cVar.b(this.i);
        cVar.c(bArr2);
        cVar.c(g);
        if (!z) {
            return j;
        }
        long a4 = j + bVar.a();
        bVar.j();
        return a4;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public com.meizu.cloud.pushsdk.c.c.g a() {
        return this.k;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) throws java.io.IOException {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() throws java.io.IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((com.meizu.cloud.pushsdk.c.g.c) null, true);
        this.m = a2;
        return a2;
    }
}
