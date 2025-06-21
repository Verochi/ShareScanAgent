package com.anythink.basead.f;

/* loaded from: classes12.dex */
public final class g extends com.anythink.basead.f.c {
    com.anythink.basead.e.a a;
    com.anythink.basead.ui.BaseSplashATView k;
    boolean l;

    /* renamed from: com.anythink.basead.f.g$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.view.ViewGroup a;

        public AnonymousClass1(android.view.ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.f.g gVar = com.anythink.basead.f.g.this;
            if (com.anythink.basead.ui.BaseSdkSplashATView.isSinglePicture(gVar.g, gVar.d.n)) {
                com.anythink.basead.f.g gVar2 = com.anythink.basead.f.g.this;
                android.content.Context context = this.a.getContext();
                com.anythink.basead.f.g gVar3 = com.anythink.basead.f.g.this;
                gVar2.k = new com.anythink.basead.ui.SinglePictureSplashATView(context, gVar3.d, gVar3.g, gVar3.a);
            } else {
                com.anythink.basead.f.g gVar4 = com.anythink.basead.f.g.this;
                android.content.Context context2 = this.a.getContext();
                com.anythink.basead.f.g gVar5 = com.anythink.basead.f.g.this;
                gVar4.k = new com.anythink.basead.ui.AsseblemSplashATView(context2, gVar5.d, gVar5.g, gVar5.a);
            }
            com.anythink.basead.f.g gVar6 = com.anythink.basead.f.g.this;
            gVar6.k.setDontCountDown(gVar6.l);
            this.a.addView(com.anythink.basead.f.g.this.k);
        }
    }

    public g(android.content.Context context, com.anythink.core.common.f.m mVar, java.lang.String str) {
        super(context, mVar, str, false);
    }

    @Override // com.anythink.basead.f.a
    public final void a(android.app.Activity activity, java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    public final void a(android.view.ViewGroup viewGroup) {
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.f.g.AnonymousClass1(viewGroup));
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.a = aVar;
    }

    @Override // com.anythink.basead.f.c, com.anythink.basead.f.a
    public final boolean a() {
        try {
            if (d()) {
                return com.anythink.basead.f.a.a.a(this.c).a(this.g, this.d, this.f);
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void b() {
        this.l = true;
    }

    public final void f() {
        this.a = null;
        com.anythink.basead.ui.BaseSplashATView baseSplashATView = this.k;
        if (baseSplashATView != null) {
            baseSplashATView.destroy();
            this.k = null;
        }
    }
}
