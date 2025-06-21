package com.anythink.basead.d;

/* loaded from: classes12.dex */
public final class a extends com.anythink.basead.d.b {
    com.anythink.basead.ui.BaseBannerATView a;
    private final java.lang.String k;
    private com.anythink.expressad.out.h l;

    /* renamed from: com.anythink.basead.d.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.out.h {

        /* renamed from: com.anythink.basead.d.a$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01321 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.foundation.d.c a;

            public RunnableC01321(com.anythink.expressad.foundation.d.c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.d.a.this.a(this.a, "");
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.out.h
        public final void a() {
        }

        @Override // com.anythink.expressad.out.h
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.d.a.AnonymousClass1.RunnableC01321(cVar), 2, true);
        }

        @Override // com.anythink.expressad.out.h
        public final void a(java.lang.String str) {
        }

        @Override // com.anythink.expressad.out.h
        public final void b() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.a.this.h;
            if (aVar != null) {
                aVar.onAdShow(new com.anythink.basead.e.i());
            }
        }

        @Override // com.anythink.expressad.out.h
        public final void c() {
        }

        @Override // com.anythink.expressad.out.h
        public final void d() {
        }

        @Override // com.anythink.expressad.out.h
        public final void e() {
        }

        @Override // com.anythink.expressad.out.h
        public final void f() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.a.this.h;
            if (aVar != null) {
                aVar.onAdClosed();
            }
            com.anythink.basead.d.a.this.e();
        }
    }

    public a(android.content.Context context, com.anythink.basead.d.b.EnumC0136b enumC0136b, com.anythink.core.common.f.m mVar) {
        super(context, enumC0136b, mVar);
        this.k = com.anythink.basead.d.a.class.getSimpleName();
        this.l = new com.anythink.basead.d.a.AnonymousClass1();
    }

    public final android.view.View a() {
        com.anythink.core.common.a.h hVar = this.f;
        if ((hVar instanceof com.anythink.expressad.out.TemplateBannerView) && hVar != null) {
            ((com.anythink.expressad.out.TemplateBannerView) hVar).setBannerAdListener(this.l);
            return (com.anythink.expressad.out.TemplateBannerView) this.f;
        }
        if (this.a == null && super.c()) {
            if (this.e.j()) {
                this.a = new com.anythink.basead.ui.MraidBannerATView(this.b, this.c, this.e, this.h);
            } else {
                this.a = new com.anythink.basead.ui.SdkBannerATView(this.b, this.c, this.e, this.h);
            }
        }
        return this.a;
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        super.b();
        com.anythink.core.common.a.h hVar = this.f;
        if (hVar instanceof com.anythink.expressad.out.TemplateBannerView) {
            ((com.anythink.expressad.out.TemplateBannerView) hVar).release();
        }
        com.anythink.basead.ui.BaseBannerATView baseBannerATView = this.a;
        if (baseBannerATView != null) {
            baseBannerATView.destroy();
        }
        this.f = null;
        this.h = null;
    }
}
