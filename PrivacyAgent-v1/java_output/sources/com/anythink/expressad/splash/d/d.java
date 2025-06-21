package com.anythink.expressad.splash.d;

/* loaded from: classes12.dex */
public class d implements com.anythink.expressad.splash.b.d {
    private static final java.lang.String a = "SplashShowListenerImpl";
    private com.anythink.expressad.out.e b;
    private com.anythink.expressad.foundation.d.c c;
    private boolean d;
    private com.anythink.expressad.splash.d.c e;
    private java.lang.Runnable f = new com.anythink.expressad.splash.d.d.AnonymousClass1();

    /* renamed from: com.anythink.expressad.splash.d.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.splash.d.d.this.a("show timeout!");
        }
    }

    public d(com.anythink.expressad.splash.d.c cVar, com.anythink.expressad.out.e eVar, double d, com.anythink.expressad.foundation.d.c cVar2) {
        this.e = cVar;
        this.b = eVar;
        this.c = cVar2;
        this.d = a(d, cVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0018, B:10:0x002d, B:12:0x0033, B:15:0x0037, B:17:0x003c, B:22:0x0049), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(double d, com.anythink.expressad.foundation.d.c cVar) {
        long j;
        long j2;
        if (!android.text.TextUtils.isEmpty(com.anythink.expressad.foundation.b.a.b().e())) {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
            if (b != null) {
                j = b.l() * 1000;
                j2 = b.x() * 1000;
                if (cVar != null) {
                    if (cVar.a(j2, j)) {
                        cVar.e(1);
                        return true;
                    }
                    cVar.e(0);
                }
                return cVar == null && !cVar.A() && d != 1.0d && new java.util.Random().nextDouble() > d;
            }
        }
        j = 0;
        j2 = 0;
        if (cVar != null) {
        }
        if (cVar == null) {
        }
    }

    private static void e() {
    }

    private static void f() {
    }

    private void g() {
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void a() {
        if (this.f != null) {
            com.anythink.core.common.b.o.a().d(this.f);
        }
        com.anythink.expressad.splash.d.c cVar = this.e;
        if (cVar != null) {
            cVar.a = true;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("load_to=");
        stringBuffer.append(this.e.c());
        stringBuffer.append("&allow_skip=");
        stringBuffer.append(this.e.d() ? 1 : 0);
        stringBuffer.append("&countdown=");
        stringBuffer.append(this.e.e());
        stringBuffer.append("&");
        com.anythink.expressad.out.e eVar = this.b;
        if (eVar == null || this.d) {
            return;
        }
        eVar.a();
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.out.e eVar = this.b;
        if (eVar == null || this.d) {
            return;
        }
        eVar.a(cVar);
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void a(java.lang.String str) {
        com.anythink.expressad.splash.d.c cVar = this.e;
        if (cVar != null) {
            cVar.a = false;
        }
        com.anythink.expressad.out.e eVar = this.b;
        if (eVar != null) {
            eVar.a(str);
        }
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void b() {
        com.anythink.expressad.out.e eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
        com.anythink.expressad.splash.d.c cVar = this.e;
        if (cVar != null) {
            cVar.a = false;
        }
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void c() {
    }

    public final void d() {
        com.anythink.core.common.b.o.a().a(this.f, 10000L);
    }
}
