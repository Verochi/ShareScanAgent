package com.anythink.expressad.foundation.g.f;

/* loaded from: classes12.dex */
public class j {
    private static final java.lang.String a = "j";
    private android.content.Context b;
    private java.util.Set<com.anythink.expressad.foundation.g.f.i> d = new java.util.HashSet();
    private java.util.concurrent.ExecutorService e = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue());
    private java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger();
    private com.anythink.expressad.foundation.g.f.c c = new com.anythink.expressad.foundation.g.f.d(new android.os.Handler(android.os.Looper.getMainLooper()));

    /* renamed from: com.anythink.expressad.foundation.g.f.j$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.f.j.a {
        final /* synthetic */ java.lang.Object a;

        public AnonymousClass1(java.lang.Object obj) {
            this.a = obj;
        }

        @Override // com.anythink.expressad.foundation.g.f.j.a
        public final boolean a(com.anythink.expressad.foundation.g.f.i<?> iVar) {
            return iVar.b() == this.a;
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.f.j$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.f.i a;

        public AnonymousClass2(com.anythink.expressad.foundation.g.f.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.content.Context unused = com.anythink.expressad.foundation.g.f.j.this.b;
            new com.anythink.expressad.foundation.g.f.h(null, com.anythink.expressad.foundation.g.f.j.this.c).a(this.a);
        }
    }

    public interface a {
        boolean a(com.anythink.expressad.foundation.g.f.i<?> iVar);
    }

    public j(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    private int a() {
        return this.f.incrementAndGet();
    }

    private void a(com.anythink.expressad.foundation.g.f.j.a aVar) {
        synchronized (this) {
            for (com.anythink.expressad.foundation.g.f.i iVar : this.d) {
                if (aVar.a(iVar)) {
                    iVar.e();
                }
            }
        }
    }

    private void a(java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        a((com.anythink.expressad.foundation.g.f.j.a) new com.anythink.expressad.foundation.g.f.j.AnonymousClass1(obj));
    }

    public final void a(com.anythink.expressad.foundation.g.f.i iVar) {
        iVar.a(this);
        synchronized (this) {
            this.d.add(iVar);
        }
        iVar.a(this.f.incrementAndGet());
        this.e.execute(new com.anythink.expressad.foundation.g.f.j.AnonymousClass2(iVar));
    }

    public final void b(com.anythink.expressad.foundation.g.f.i iVar) {
        synchronized (this) {
            this.d.remove(iVar);
        }
    }
}
