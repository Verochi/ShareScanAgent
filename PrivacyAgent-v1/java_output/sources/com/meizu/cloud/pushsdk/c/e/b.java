package com.meizu.cloud.pushsdk.c.e;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.j {
    private final com.meizu.cloud.pushsdk.c.c.j a;
    private com.meizu.cloud.pushsdk.c.g.c b;
    private com.meizu.cloud.pushsdk.c.e.d c;

    /* renamed from: com.meizu.cloud.pushsdk.c.e.b$1, reason: invalid class name */
    public class AnonymousClass1 extends com.meizu.cloud.pushsdk.c.g.f {
        long a;
        long b;

        public AnonymousClass1(com.meizu.cloud.pushsdk.c.g.l lVar) {
            super(lVar);
            this.a = 0L;
            this.b = 0L;
        }

        @Override // com.meizu.cloud.pushsdk.c.g.f, com.meizu.cloud.pushsdk.c.g.l
        public void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws java.io.IOException {
            super.a(bVar, j);
            if (this.b == 0) {
                this.b = com.meizu.cloud.pushsdk.c.e.b.this.b();
            }
            this.a += j;
            if (com.meizu.cloud.pushsdk.c.e.b.this.c != null) {
                com.meizu.cloud.pushsdk.c.e.b.this.c.obtainMessage(1, new com.meizu.cloud.pushsdk.c.f.a(this.a, this.b)).sendToTarget();
            }
        }
    }

    public b(com.meizu.cloud.pushsdk.c.c.j jVar, com.meizu.cloud.pushsdk.c.d.a aVar) {
        this.a = jVar;
        if (aVar != null) {
            this.c = new com.meizu.cloud.pushsdk.c.e.d(aVar);
        }
    }

    private com.meizu.cloud.pushsdk.c.g.l a(com.meizu.cloud.pushsdk.c.g.l lVar) {
        return new com.meizu.cloud.pushsdk.c.e.b.AnonymousClass1(lVar);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public com.meizu.cloud.pushsdk.c.c.g a() {
        return this.a.a();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) throws java.io.IOException {
        if (this.b == null) {
            this.b = com.meizu.cloud.pushsdk.c.g.g.a(a((com.meizu.cloud.pushsdk.c.g.l) cVar));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() throws java.io.IOException {
        return this.a.b();
    }
}
