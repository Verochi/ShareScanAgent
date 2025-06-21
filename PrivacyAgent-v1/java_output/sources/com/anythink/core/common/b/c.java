package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public class c {
    java.lang.ref.WeakReference<com.anythink.core.api.ATAdSourceStatusListener> a;

    /* renamed from: com.anythink.core.common.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATAdInfo a;

        public AnonymousClass1(com.anythink.core.api.ATAdInfo aTAdInfo) {
            this.a = aTAdInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.api.ATAdSourceStatusListener a = com.anythink.core.common.b.c.a(com.anythink.core.common.b.c.this);
            if (a != null) {
                a.onAdSourceBiddingAttempt(this.a);
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATAdInfo a;

        public AnonymousClass2(com.anythink.core.api.ATAdInfo aTAdInfo) {
            this.a = aTAdInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.api.ATAdSourceStatusListener a = com.anythink.core.common.b.c.a(com.anythink.core.common.b.c.this);
            if (a != null) {
                a.onAdSourceBiddingFilled(this.a);
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.c$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATAdInfo a;
        final /* synthetic */ com.anythink.core.api.AdError b;

        public AnonymousClass3(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.core.api.AdError adError) {
            this.a = aTAdInfo;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.api.ATAdSourceStatusListener a = com.anythink.core.common.b.c.a(com.anythink.core.common.b.c.this);
            if (a != null) {
                a.onAdSourceBiddingFail(this.a, this.b);
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.c$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATAdInfo a;

        public AnonymousClass4(com.anythink.core.api.ATAdInfo aTAdInfo) {
            this.a = aTAdInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.api.ATAdSourceStatusListener a = com.anythink.core.common.b.c.a(com.anythink.core.common.b.c.this);
            if (a != null) {
                a.onAdSourceAttempt(this.a);
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.c$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATAdInfo a;

        public AnonymousClass5(com.anythink.core.api.ATAdInfo aTAdInfo) {
            this.a = aTAdInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.api.ATAdSourceStatusListener a = com.anythink.core.common.b.c.a(com.anythink.core.common.b.c.this);
            if (a != null) {
                a.onAdSourceLoadFilled(this.a);
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.c$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATAdInfo a;
        final /* synthetic */ com.anythink.core.api.AdError b;

        public AnonymousClass6(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.core.api.AdError adError) {
            this.a = aTAdInfo;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.api.ATAdSourceStatusListener a = com.anythink.core.common.b.c.a(com.anythink.core.common.b.c.this);
            if (a != null) {
                a.onAdSourceLoadFail(this.a, this.b);
            }
        }
    }

    private com.anythink.core.api.ATAdSourceStatusListener a() {
        java.lang.ref.WeakReference<com.anythink.core.api.ATAdSourceStatusListener> weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static /* synthetic */ com.anythink.core.api.ATAdSourceStatusListener a(com.anythink.core.common.b.c cVar) {
        java.lang.ref.WeakReference<com.anythink.core.api.ATAdSourceStatusListener> weakReference = cVar.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void a(com.anythink.core.api.ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (aTAdSourceStatusListener == null) {
            return;
        }
        this.a = new java.lang.ref.WeakReference<>(aTAdSourceStatusListener);
    }

    public final void a(com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.b.o.a().b(new com.anythink.core.common.b.c.AnonymousClass1(com.anythink.core.common.b.k.a(hVar, (com.anythink.core.common.b.a) null)));
    }

    public final void a(com.anythink.core.common.f.h hVar, com.anythink.core.api.AdError adError) {
        com.anythink.core.common.b.o.a().b(new com.anythink.core.common.b.c.AnonymousClass3(com.anythink.core.common.b.k.a(hVar, (com.anythink.core.common.b.a) null), adError));
    }

    public final void b(com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.b.o.a().b(new com.anythink.core.common.b.c.AnonymousClass2(com.anythink.core.common.b.k.a(hVar, (com.anythink.core.common.b.a) null)));
    }

    public final void b(com.anythink.core.common.f.h hVar, com.anythink.core.api.AdError adError) {
        com.anythink.core.common.b.o.a().b(new com.anythink.core.common.b.c.AnonymousClass6(com.anythink.core.common.b.k.a(hVar, (com.anythink.core.common.b.a) null), adError));
    }

    public final void c(com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.b.o.a().b(new com.anythink.core.common.b.c.AnonymousClass4(com.anythink.core.common.b.k.a(hVar, (com.anythink.core.common.b.a) null)));
    }

    public final void d(com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.b.o.a().b(new com.anythink.core.common.b.c.AnonymousClass5(com.anythink.core.common.b.k.a(hVar, (com.anythink.core.common.b.a) null)));
    }
}
