package com.anythink.basead.d;

/* loaded from: classes12.dex */
public class d extends com.anythink.basead.d.b {
    public static final java.lang.String a = "d";

    /* renamed from: com.anythink.basead.d.d$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.videocommon.d.a {
        final /* synthetic */ java.lang.String a;

        /* renamed from: com.anythink.basead.d.d$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01371 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.foundation.d.c a;

            public RunnableC01371(com.anythink.expressad.foundation.d.c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.d.d.AnonymousClass1 anonymousClass1 = com.anythink.basead.d.d.AnonymousClass1.this;
                com.anythink.basead.d.d.this.a(this.a, anonymousClass1.a);
            }
        }

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void a() {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.d.d.AnonymousClass1.RunnableC01371(cVar), 2, true);
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void a(java.lang.String str) {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void a(boolean z, java.lang.String str, float f) {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar != null) {
                aVar.onAdClosed();
            }
            com.anythink.basead.d.d.this.e();
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void b() {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void b(java.lang.String str) {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar != null) {
                aVar.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, str));
            }
            com.anythink.basead.d.d.this.e = null;
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void c() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar != null) {
                aVar.onAdShow(new com.anythink.basead.e.i());
            }
            com.anythink.basead.d.d.this.e = null;
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void d() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar == null || !(aVar instanceof com.anythink.basead.e.j)) {
                return;
            }
            ((com.anythink.basead.e.j) aVar).onVideoAdPlayEnd();
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void e() {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void f() {
        }
    }

    /* renamed from: com.anythink.basead.d.d$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.b.InterfaceC0141b {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar == null || !(aVar instanceof com.anythink.basead.e.j)) {
                return;
            }
            ((com.anythink.basead.e.j) aVar).onVideoAdPlayStart();
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(com.anythink.basead.c.e eVar) {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar != null) {
                aVar.onShowFailed(eVar);
            }
            com.anythink.basead.d.d.this.e = null;
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(com.anythink.basead.e.i iVar) {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar != null) {
                aVar.onAdShow(iVar);
            }
            com.anythink.basead.d.d.this.e = null;
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(boolean z) {
            java.lang.String str = com.anythink.basead.d.d.a;
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar != null) {
                aVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void b() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar == null || !(aVar instanceof com.anythink.basead.e.j)) {
                return;
            }
            ((com.anythink.basead.e.j) aVar).onVideoAdPlayEnd();
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void b(com.anythink.basead.e.i iVar) {
            java.lang.String str = com.anythink.basead.d.d.a;
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar != null) {
                aVar.onAdClick(iVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void c() {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void d() {
            java.lang.String str = com.anythink.basead.d.d.a;
            com.anythink.basead.e.a aVar = com.anythink.basead.d.d.this.h;
            if (aVar != null) {
                aVar.onAdClosed();
            }
            com.anythink.basead.e.b.a().b(this.a);
        }
    }

    public d(android.content.Context context, com.anythink.basead.d.b.EnumC0136b enumC0136b, com.anythink.core.common.f.m mVar) {
        super(context, enumC0136b, mVar);
    }

    public final void a(android.app.Activity activity, java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            if (!c()) {
                com.anythink.basead.e.a aVar = this.h;
                if (aVar != null) {
                    aVar.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.y));
                }
                this.e = null;
                return;
            }
            java.lang.String obj = map.get("extra_scenario").toString();
            int intValue = ((java.lang.Integer) map.get(com.anythink.basead.f.c.j)).intValue();
            java.lang.String a2 = a(this.e);
            com.anythink.core.common.a.h hVar = this.f;
            if (hVar instanceof com.anythink.expressad.reward.b.a) {
                ((com.anythink.expressad.reward.b.a) hVar).a(new com.anythink.basead.d.d.AnonymousClass1(obj));
                ((com.anythink.expressad.reward.b.a) this.f).a(activity, "", "", "", this.c);
                return;
            }
            com.anythink.basead.e.b.a().a(a2, new com.anythink.basead.d.d.AnonymousClass2(a2));
            com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
            cVar.c = this.e;
            cVar.d = a2;
            cVar.a = 3;
            cVar.h = this.c;
            cVar.e = intValue;
            cVar.b = obj;
            com.anythink.basead.ui.BaseATActivity.a(activity, cVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.anythink.basead.e.a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.onShowFailed(com.anythink.basead.c.f.a("-9999", e.getMessage()));
            }
            this.e = null;
        }
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        super.b();
        this.h = null;
    }
}
