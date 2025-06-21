package com.anythink.expressad.foundation.g.f;

/* loaded from: classes12.dex */
public class d implements com.anythink.expressad.foundation.g.f.c {
    private final java.lang.String a = com.anythink.expressad.foundation.g.f.d.class.getSimpleName();
    private final java.util.concurrent.Executor b;

    /* renamed from: com.anythink.expressad.foundation.g.f.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Executor {
        final /* synthetic */ android.os.Handler a;

        public AnonymousClass1(android.os.Handler handler) {
            this.a = handler;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(java.lang.Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.f.d$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.f.i a;

        public AnonymousClass2(com.anythink.expressad.foundation.g.f.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.o();
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.f.d$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.f.i a;

        public AnonymousClass3(com.anythink.expressad.foundation.g.f.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.m();
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.f.d$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.f.i a;

        public AnonymousClass4(com.anythink.expressad.foundation.g.f.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.n();
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.f.d$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.f.i a;

        public AnonymousClass5(com.anythink.expressad.foundation.g.f.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.f.d$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.f.i a;

        public AnonymousClass6(com.anythink.expressad.foundation.g.f.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.f.d$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.f.i a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        public AnonymousClass7(com.anythink.expressad.foundation.g.f.i iVar, long j, long j2) {
            this.a = iVar;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.b, this.c);
        }
    }

    public class a implements java.lang.Runnable {
        private final com.anythink.expressad.foundation.g.f.i b;
        private final com.anythink.expressad.foundation.g.f.k c;

        public a(com.anythink.expressad.foundation.g.f.i iVar, com.anythink.expressad.foundation.g.f.k kVar) {
            this.b = iVar;
            this.c = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.f()) {
                this.b.c();
                this.b.m();
                return;
            }
            com.anythink.expressad.foundation.g.f.k kVar = this.c;
            com.anythink.expressad.foundation.g.f.a.a aVar = kVar.b;
            if (aVar == null) {
                this.b.a(kVar);
            } else {
                this.b.b(aVar);
            }
            this.b.c();
            this.b.o();
        }
    }

    public d(android.os.Handler handler) {
        this.b = new com.anythink.expressad.foundation.g.f.d.AnonymousClass1(handler);
    }

    @Override // com.anythink.expressad.foundation.g.f.c
    public final void a(com.anythink.expressad.foundation.g.f.i<?> iVar) {
        java.util.concurrent.Executor executor = this.b;
        if (executor != null) {
            executor.execute(new com.anythink.expressad.foundation.g.f.d.AnonymousClass2(iVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.c
    public final void a(com.anythink.expressad.foundation.g.f.i<?> iVar, long j, long j2) {
        java.util.concurrent.Executor executor = this.b;
        if (executor != null) {
            executor.execute(new com.anythink.expressad.foundation.g.f.d.AnonymousClass7(iVar, j, j2));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.c
    public final void a(com.anythink.expressad.foundation.g.f.i<?> iVar, com.anythink.expressad.foundation.g.f.a.a aVar) {
        if (this.b != null) {
            this.b.execute(new com.anythink.expressad.foundation.g.f.d.a(iVar, com.anythink.expressad.foundation.g.f.k.a(aVar)));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.c
    public final void a(com.anythink.expressad.foundation.g.f.i<?> iVar, com.anythink.expressad.foundation.g.f.k<?> kVar) {
        java.util.concurrent.Executor executor = this.b;
        if (executor != null) {
            executor.execute(new com.anythink.expressad.foundation.g.f.d.a(iVar, kVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.c
    public final void b(com.anythink.expressad.foundation.g.f.i<?> iVar) {
        java.util.concurrent.Executor executor = this.b;
        if (executor != null) {
            executor.execute(new com.anythink.expressad.foundation.g.f.d.AnonymousClass3(iVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.c
    public final void c(com.anythink.expressad.foundation.g.f.i<?> iVar) {
        java.util.concurrent.Executor executor = this.b;
        if (executor != null) {
            executor.execute(new com.anythink.expressad.foundation.g.f.d.AnonymousClass4(iVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.c
    public final void d(com.anythink.expressad.foundation.g.f.i<?> iVar) {
        java.util.concurrent.Executor executor = this.b;
        if (executor != null) {
            executor.execute(new com.anythink.expressad.foundation.g.f.d.AnonymousClass5(iVar));
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.c
    public final void e(com.anythink.expressad.foundation.g.f.i<?> iVar) {
        java.util.concurrent.Executor executor = this.b;
        if (executor != null) {
            executor.execute(new com.anythink.expressad.foundation.g.f.d.AnonymousClass6(iVar));
        }
    }
}
