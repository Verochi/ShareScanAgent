package com.anythink.basead.f;

/* loaded from: classes12.dex */
public class d extends com.anythink.basead.f.c {
    public static final java.lang.String a = "d";
    private com.anythink.basead.e.j k;

    /* renamed from: com.anythink.basead.f.d$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.b.InterfaceC0141b {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a() {
            java.lang.String str = com.anythink.basead.f.d.a;
            if (com.anythink.basead.f.d.this.k != null) {
                com.anythink.basead.f.d.this.k.onVideoAdPlayStart();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(com.anythink.basead.c.e eVar) {
            java.lang.String str = com.anythink.basead.f.d.a;
            eVar.c();
            if (com.anythink.basead.f.d.this.k != null) {
                com.anythink.basead.f.d.this.k.onShowFailed(eVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(com.anythink.basead.e.i iVar) {
            java.lang.String str = com.anythink.basead.f.d.a;
            if (com.anythink.basead.f.d.this.k != null) {
                com.anythink.basead.f.d.this.k.onAdShow(iVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(boolean z) {
            java.lang.String str = com.anythink.basead.f.d.a;
            if (com.anythink.basead.f.d.this.k != null) {
                com.anythink.basead.f.d.this.k.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void b() {
            java.lang.String str = com.anythink.basead.f.d.a;
            if (com.anythink.basead.f.d.this.k != null) {
                com.anythink.basead.f.d.this.k.onVideoAdPlayEnd();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void b(com.anythink.basead.e.i iVar) {
            java.lang.String str = com.anythink.basead.f.d.a;
            if (com.anythink.basead.f.d.this.k != null) {
                com.anythink.basead.f.d.this.k.onAdClick(iVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void c() {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void d() {
            java.lang.String str = com.anythink.basead.f.d.a;
            if (com.anythink.basead.f.d.this.k != null) {
                com.anythink.basead.f.d.this.k.onAdClosed();
            }
            com.anythink.basead.e.b.a().b(this.a);
        }
    }

    public d(android.content.Context context, com.anythink.core.common.f.m mVar, java.lang.String str, boolean z) {
        super(context, mVar, str, z);
    }

    @Override // com.anythink.basead.f.a
    public final void a(android.app.Activity activity, java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            if (this.c == null) {
                com.anythink.basead.e.j jVar = this.k;
                if (jVar != null) {
                    jVar.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.C));
                    return;
                }
                return;
            }
            map.get(com.anythink.basead.f.c.h);
            java.lang.String obj = map.get("extra_scenario").toString();
            int intValue = ((java.lang.Integer) map.get(com.anythink.basead.f.c.j)).intValue();
            java.lang.String str = this.d.b + this.e + java.lang.System.currentTimeMillis();
            com.anythink.basead.e.b.a().a(str, new com.anythink.basead.f.d.AnonymousClass1(str));
            com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
            cVar.c = this.g;
            cVar.d = str;
            cVar.a = 3;
            cVar.h = this.d;
            cVar.e = intValue;
            cVar.b = obj;
            com.anythink.basead.ui.BaseATActivity.a(activity, cVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.anythink.basead.e.j jVar2 = this.k;
            if (jVar2 != null) {
                jVar2.onShowFailed(com.anythink.basead.c.f.a("-9999", e.getMessage()));
            }
        }
    }

    public final void a(com.anythink.basead.e.j jVar) {
        this.k = jVar;
    }
}
