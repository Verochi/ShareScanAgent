package com.anythink.basead.a;

/* loaded from: classes12.dex */
public final class h implements com.anythink.core.common.g.b {
    com.anythink.core.common.m.c a;
    android.content.Context b = com.anythink.core.common.b.o.a().f();

    /* renamed from: com.anythink.basead.a.h$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.basead.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(android.app.Activity activity) {
            super.onActivityPaused(activity);
            com.anythink.core.common.m.c cVar = com.anythink.basead.a.h.this.a;
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(android.app.Activity activity) {
            super.onActivityResumed(activity);
            com.anythink.core.common.m.c cVar = com.anythink.basead.a.h.this.a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* renamed from: com.anythink.basead.a.h$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.basead.a a;
        final /* synthetic */ com.anythink.core.common.f.l b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass2(com.anythink.basead.a aVar, com.anythink.core.common.f.l lVar, java.lang.String str, java.lang.String str2) {
            this.a = aVar;
            this.b = lVar;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((android.app.Application) com.anythink.basead.a.h.this.b).unregisterActivityLifecycleCallbacks(this.a);
            if (com.anythink.basead.a.a.a(com.anythink.basead.a.h.this.b, this.b)) {
                com.anythink.core.common.n.c.a(this.c, this.b.s(), this.d, 6, (java.lang.String) null, 0L, 0L);
            }
        }
    }

    @Override // com.anythink.core.common.g.b
    public final void a(com.anythink.core.common.f.l lVar, java.lang.String str, java.lang.String str2, boolean z) {
        if (z) {
            com.anythink.basead.a.a.a(this.b, lVar);
            return;
        }
        com.anythink.core.common.f.n n = lVar.n();
        if (n == null) {
            return;
        }
        int L = n.L();
        int M = n.M();
        if (L != 1) {
            if (L != 3) {
                return;
            }
            com.anythink.core.common.b.a().a("1", new com.anythink.basead.c.g(lVar, str2, str));
        } else {
            com.anythink.basead.a.h.AnonymousClass1 anonymousClass1 = new com.anythink.basead.a.h.AnonymousClass1();
            this.a = new com.anythink.core.common.m.c(M, new com.anythink.basead.a.h.AnonymousClass2(anonymousClass1, lVar, str, str2));
            try {
                ((android.app.Application) this.b).registerActivityLifecycleCallbacks(anonymousClass1);
            } catch (java.lang.Exception unused) {
                com.anythink.core.common.n.c.a("Error", "Error, cannot registerActivityLifecycleCallbacks here!", com.anythink.core.common.b.o.a().q());
            }
        }
    }
}
