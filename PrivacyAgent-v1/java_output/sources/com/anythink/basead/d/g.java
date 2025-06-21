package com.anythink.basead.d;

/* loaded from: classes12.dex */
public final class g extends com.anythink.basead.d.b {
    com.anythink.basead.ui.BaseSplashATView a;
    boolean k;

    /* renamed from: com.anythink.basead.d.g$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.view.ViewGroup a;

        /* renamed from: com.anythink.basead.d.g$1$1, reason: invalid class name and collision with other inner class name */
        public class C01391 implements com.anythink.expressad.out.e {

            /* renamed from: com.anythink.basead.d.g$1$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC01401 implements java.lang.Runnable {
                final /* synthetic */ com.anythink.expressad.foundation.d.c a;

                public RunnableC01401(com.anythink.expressad.foundation.d.c cVar) {
                    this.a = cVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.basead.d.g.this.a(this.a, "");
                }
            }

            public C01391() {
            }

            @Override // com.anythink.expressad.out.e
            public final void a() {
                com.anythink.basead.e.a aVar = com.anythink.basead.d.g.this.h;
                if (aVar != null) {
                    aVar.onAdShow(new com.anythink.basead.e.i());
                }
            }

            @Override // com.anythink.expressad.out.e
            public final void a(com.anythink.expressad.foundation.d.c cVar) {
                com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.d.g.AnonymousClass1.C01391.RunnableC01401(cVar), 2, true);
            }

            @Override // com.anythink.expressad.out.e
            public final void a(java.lang.String str) {
                com.anythink.basead.e.a aVar = com.anythink.basead.d.g.this.h;
                if (aVar != null) {
                    aVar.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, str));
                }
            }

            @Override // com.anythink.expressad.out.e
            public final void b() {
                com.anythink.basead.e.a aVar = com.anythink.basead.d.g.this.h;
                if (aVar != null) {
                    aVar.onAdClosed();
                }
                com.anythink.basead.d.g.this.e();
            }

            @Override // com.anythink.expressad.out.e
            public final void c() {
            }

            @Override // com.anythink.expressad.out.e
            public final void d() {
            }

            @Override // com.anythink.expressad.out.e
            public final void e() {
            }
        }

        public AnonymousClass1(android.view.ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.d.g gVar = com.anythink.basead.d.g.this;
            com.anythink.core.common.a.h hVar = gVar.f;
            if (hVar instanceof com.anythink.expressad.splash.d.c) {
                ((com.anythink.expressad.splash.d.c) hVar).a(new com.anythink.basead.d.g.AnonymousClass1.C01391());
                ((com.anythink.expressad.splash.d.c) com.anythink.basead.d.g.this.f).a(this.a);
                return;
            }
            if (gVar.e.j()) {
                com.anythink.basead.d.g gVar2 = com.anythink.basead.d.g.this;
                android.content.Context context = this.a.getContext();
                com.anythink.basead.d.g gVar3 = com.anythink.basead.d.g.this;
                gVar2.a = new com.anythink.basead.ui.MraidSplashATView(context, gVar3.c, gVar3.e, gVar3.h);
            } else {
                com.anythink.basead.d.g gVar4 = com.anythink.basead.d.g.this;
                if (com.anythink.basead.ui.BaseSdkSplashATView.isSinglePicture(gVar4.e, gVar4.c.n)) {
                    com.anythink.basead.d.g gVar5 = com.anythink.basead.d.g.this;
                    android.content.Context context2 = this.a.getContext();
                    com.anythink.basead.d.g gVar6 = com.anythink.basead.d.g.this;
                    gVar5.a = new com.anythink.basead.ui.SinglePictureSplashATView(context2, gVar6.c, gVar6.e, gVar6.h);
                } else {
                    com.anythink.basead.d.g gVar7 = com.anythink.basead.d.g.this;
                    android.content.Context context3 = this.a.getContext();
                    com.anythink.basead.d.g gVar8 = com.anythink.basead.d.g.this;
                    gVar7.a = new com.anythink.basead.ui.AsseblemSplashATView(context3, gVar8.c, gVar8.e, gVar8.h);
                }
            }
            com.anythink.basead.d.g gVar9 = com.anythink.basead.d.g.this;
            gVar9.a.setDontCountDown(gVar9.k);
            this.a.addView(com.anythink.basead.d.g.this.a);
        }
    }

    public g(android.content.Context context, com.anythink.basead.d.b.EnumC0136b enumC0136b, com.anythink.core.common.f.m mVar) {
        super(context, enumC0136b, mVar);
    }

    public final void a() {
        this.k = true;
    }

    public final void a(android.view.ViewGroup viewGroup) {
        if (super.c()) {
            com.anythink.core.common.o.w.a(false);
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.d.g.AnonymousClass1(viewGroup));
        }
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        com.anythink.basead.ui.BaseSplashATView baseSplashATView = this.a;
        if (baseSplashATView != null) {
            baseSplashATView.destroy();
            this.a = null;
        }
        com.anythink.core.common.a.h hVar = this.f;
        if (hVar == null || !(hVar instanceof com.anythink.expressad.splash.d.c)) {
            return;
        }
        ((com.anythink.expressad.splash.d.c) hVar).g();
    }

    public final boolean g() {
        return this.f == null;
    }
}
