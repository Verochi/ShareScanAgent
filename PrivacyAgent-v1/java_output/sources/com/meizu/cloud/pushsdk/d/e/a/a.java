package com.meizu.cloud.pushsdk.d.e.a;

/* loaded from: classes23.dex */
public class a extends com.meizu.cloud.pushsdk.d.e.a {
    private static final java.lang.String n = "a";
    private static java.util.concurrent.ScheduledExecutorService o;

    /* renamed from: com.meizu.cloud.pushsdk.d.e.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.meizu.cloud.pushsdk.d.e.b a;

        public AnonymousClass1(com.meizu.cloud.pushsdk.d.e.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.d.e.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.meizu.cloud.pushsdk.d.c.b a;
        final /* synthetic */ boolean b;

        public AnonymousClass2(com.meizu.cloud.pushsdk.d.c.b bVar, boolean z) {
            this.a = bVar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.meizu.cloud.pushsdk.d.e.a.a.super.a(this.a, this.b);
        }
    }

    public a(com.meizu.cloud.pushsdk.d.e.a.C0427a c0427a) {
        super(c0427a);
        com.meizu.cloud.pushsdk.d.b.a.b.a(this.k);
        c();
    }

    @Override // com.meizu.cloud.pushsdk.d.e.a
    public void a(com.meizu.cloud.pushsdk.d.c.b bVar, boolean z) {
        com.meizu.cloud.pushsdk.d.b.a.b.a(new com.meizu.cloud.pushsdk.d.e.a.a.AnonymousClass2(bVar, z));
    }

    public void c() {
        if (o == null && this.i) {
            com.meizu.cloud.pushsdk.d.f.c.b(n, "Session checking has been resumed.", new java.lang.Object[0]);
            com.meizu.cloud.pushsdk.d.e.b bVar = this.d;
            java.util.concurrent.ScheduledExecutorService newSingleThreadScheduledExecutor = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
            o = newSingleThreadScheduledExecutor;
            com.meizu.cloud.pushsdk.d.e.a.a.AnonymousClass1 anonymousClass1 = new com.meizu.cloud.pushsdk.d.e.a.a.AnonymousClass1(bVar);
            long j = this.j;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(anonymousClass1, j, j, this.l);
        }
    }
}
