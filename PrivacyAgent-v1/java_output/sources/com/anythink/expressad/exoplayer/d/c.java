package com.anythink.expressad.exoplayer.d;

/* loaded from: classes12.dex */
public interface c {

    public static final class a {
        private final java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.exoplayer.d.c.a.C0188a> a = new java.util.concurrent.CopyOnWriteArrayList<>();

        /* renamed from: com.anythink.expressad.exoplayer.d.c$a$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.d.c a;

            public AnonymousClass1(com.anythink.expressad.exoplayer.d.c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.d.c$a$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.d.c a;
            final /* synthetic */ java.lang.Exception b;

            public AnonymousClass2(com.anythink.expressad.exoplayer.d.c cVar, java.lang.Exception exc) {
                this.a = cVar;
                this.b = exc;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.d.c$a$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.d.c a;

            public AnonymousClass3(com.anythink.expressad.exoplayer.d.c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.d.c$a$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.d.c a;

            public AnonymousClass4(com.anythink.expressad.exoplayer.d.c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.f();
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.d.c$a$a, reason: collision with other inner class name */
        public static final class C0188a {
            public final android.os.Handler a;
            public final com.anythink.expressad.exoplayer.d.c b;

            public C0188a(android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
                this.a = handler;
                this.b = cVar;
            }
        }

        public final void a() {
            java.util.Iterator<com.anythink.expressad.exoplayer.d.c.a.C0188a> it = this.a.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.exoplayer.d.c.a.C0188a next = it.next();
                next.a.post(new com.anythink.expressad.exoplayer.d.c.a.AnonymousClass1(next.b));
            }
        }

        public final void a(android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
            com.anythink.expressad.exoplayer.k.a.a((handler == null || cVar == null) ? false : true);
            this.a.add(new com.anythink.expressad.exoplayer.d.c.a.C0188a(handler, cVar));
        }

        public final void a(com.anythink.expressad.exoplayer.d.c cVar) {
            java.util.Iterator<com.anythink.expressad.exoplayer.d.c.a.C0188a> it = this.a.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.exoplayer.d.c.a.C0188a next = it.next();
                if (next.b == cVar) {
                    this.a.remove(next);
                }
            }
        }

        public final void a(java.lang.Exception exc) {
            java.util.Iterator<com.anythink.expressad.exoplayer.d.c.a.C0188a> it = this.a.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.exoplayer.d.c.a.C0188a next = it.next();
                next.a.post(new com.anythink.expressad.exoplayer.d.c.a.AnonymousClass2(next.b, exc));
            }
        }

        public final void b() {
            java.util.Iterator<com.anythink.expressad.exoplayer.d.c.a.C0188a> it = this.a.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.exoplayer.d.c.a.C0188a next = it.next();
                next.a.post(new com.anythink.expressad.exoplayer.d.c.a.AnonymousClass3(next.b));
            }
        }

        public final void c() {
            java.util.Iterator<com.anythink.expressad.exoplayer.d.c.a.C0188a> it = this.a.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.exoplayer.d.c.a.C0188a next = it.next();
                next.a.post(new com.anythink.expressad.exoplayer.d.c.a.AnonymousClass4(next.b));
            }
        }
    }

    void a(java.lang.Exception exc);

    void d();

    void e();

    void f();
}
