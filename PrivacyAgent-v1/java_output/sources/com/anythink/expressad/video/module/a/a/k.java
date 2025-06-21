package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public class k extends com.anythink.expressad.video.module.a.a.f {
    public static final int V = 2;
    public static final int a = 1;
    private static final java.lang.String ag = "camp_position";
    protected boolean W;
    protected com.anythink.expressad.foundation.d.c X;
    protected java.util.List<com.anythink.expressad.foundation.d.c> Y;
    protected boolean Z;
    protected com.anythink.expressad.videocommon.b.c aa;
    protected com.anythink.expressad.videocommon.c.c ab;
    protected java.lang.String ac;
    protected java.lang.String ad;
    protected com.anythink.expressad.video.module.a.a ae;
    protected int af;
    private boolean ah = false;
    private boolean ai = false;
    private boolean aj = false;

    public k(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.b.c cVar2, com.anythink.expressad.videocommon.c.c cVar3, java.lang.String str, java.lang.String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        this.Z = false;
        this.ae = new com.anythink.expressad.video.module.a.a.f();
        this.af = 1;
        if (!z && cVar != null && com.anythink.expressad.foundation.h.w.b(str2) && cVar2 != null && aVar != null) {
            this.X = cVar;
            this.ad = str;
            this.ac = str2;
            this.aa = cVar2;
            this.ab = cVar3;
            this.ae = aVar;
            this.W = true;
            this.af = i;
            this.Z = false;
            return;
        }
        if (!z || cVar == null || !com.anythink.expressad.foundation.h.w.b(str2) || aVar == null) {
            return;
        }
        this.X = cVar;
        this.ad = str;
        this.ac = str2;
        this.aa = cVar2;
        this.ab = cVar3;
        this.ae = aVar;
        this.W = true;
        this.af = i;
        this.Z = true;
    }

    private static void g() {
    }

    private static void h() {
    }

    private static void i() {
        com.anythink.expressad.videocommon.b.e.a().a(false);
    }

    private static void j() {
    }

    private void k() {
        if (!this.W || com.anythink.expressad.foundation.g.a.f.k == null || android.text.TextUtils.isEmpty(this.X.aZ())) {
            return;
        }
        com.anythink.expressad.foundation.g.a.f.a(this.ac, this.X, "reward");
    }

    private static void l() {
    }

    private static void m() {
    }

    private static void n() {
    }

    public final void a() {
        if (!this.W || this.X == null) {
            return;
        }
        com.anythink.core.common.b.o.a().f();
        new com.anythink.expressad.foundation.d.r(com.anythink.expressad.foundation.d.r.q, this.X.aZ(), this.X.Z(), this.X.aa(), this.ac, com.anythink.expressad.foundation.h.k.a()).a(this.X.H() ? com.anythink.expressad.foundation.d.r.aQ : com.anythink.expressad.foundation.d.r.aR);
    }

    public final void a(int i) {
        if (this.X != null) {
            if (i == 1 || i == 2) {
                com.anythink.expressad.video.module.b.a.a(com.anythink.core.common.b.o.a().f(), this.X, i, this.af);
            }
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public void a(int i, java.lang.Object obj) {
        super.a(i, obj);
        this.ae.a(i, obj);
    }

    public final void a(int i, java.lang.String str) {
        if (this.X != null) {
            com.anythink.core.common.b.o.a().f();
            new com.anythink.expressad.foundation.d.r(com.anythink.expressad.foundation.d.r.r, this.X.aZ(), this.X.Z(), this.X.aa(), this.ac, com.anythink.expressad.foundation.h.k.a(), i, str);
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.X = cVar;
    }

    public final void a(java.lang.String str) {
        java.util.List<com.anythink.expressad.foundation.d.c> list;
        if (this.X == null || (list = this.Y) == null || list.size() == 0) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has(ag)) {
                this.X = this.Y.get(jSONObject.getInt(ag));
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public final void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.Y = list;
    }

    public final void b() {
        com.anythink.expressad.videocommon.b.c cVar = this.aa;
        if (cVar != null) {
            cVar.b(true);
        }
    }

    public final void b(int i) {
        com.anythink.expressad.foundation.d.c cVar = this.X;
        if (cVar != null) {
            java.lang.String ah = cVar.ah();
            if (android.text.TextUtils.isEmpty(ah)) {
                return;
            }
            if (i == 1 || i == 2) {
                if (!ah.contains("endscreen_type")) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(ah);
                    if (ah.contains("?")) {
                        sb.append("&endscreen_type=");
                        sb.append(i);
                    } else {
                        sb.append("?endscreen_type=");
                        sb.append(i);
                    }
                    ah = sb.toString();
                } else if (i == 2) {
                    if (ah.contains("endscreen_type=1")) {
                        ah = ah.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (ah.contains("endscreen_type=2")) {
                    ah = ah.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.X.q(ah);
            }
        }
    }

    public final void c() {
        java.util.Map<java.lang.String, java.lang.Long> map;
        java.lang.String str;
        try {
            com.anythink.expressad.foundation.d.c cVar = this.X;
            if (cVar != null && cVar.j() && this.Z && !this.X.l()) {
                this.ai = true;
                return;
            }
            if (!this.W || android.text.TextUtils.isEmpty(this.X.ai()) || (map = com.anythink.expressad.foundation.g.a.f.h) == null || map.containsKey(this.X.ai()) || this.ai) {
                return;
            }
            com.anythink.expressad.foundation.g.a.f.h.put(this.X.ai(), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            java.lang.String ai = this.X.ai();
            if (this.X.n() == 1) {
                str = ai + "&to=1&cbt=" + this.X.az() + "&tmorl=" + this.af;
            } else {
                str = ai + "&to=0&cbt=" + this.X.az() + "&tmorl=" + this.af;
            }
            java.lang.String str2 = str;
            if (!this.Z) {
                com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), this.X, this.ac, str2, true);
            } else if (this.X.l()) {
                com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), this.X, this.ac, str2, false, true, com.anythink.expressad.a.a.a.j);
            }
            this.ai = true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public final void d() {
        java.lang.String str;
        try {
            if (!this.W || this.ah || android.text.TextUtils.isEmpty(this.X.ag())) {
                return;
            }
            this.ah = true;
            this.X.A();
            java.lang.String ag2 = this.X.ag();
            if (this.X.n() == 1) {
                str = ag2 + "&to=1&cbt=" + this.X.az() + "&tmorl=" + this.af;
            } else {
                str = ag2 + "&to=0&cbt=" + this.X.az() + "&tmorl=" + this.af;
            }
            com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), this.X, this.ac, str, false, true, com.anythink.expressad.a.a.a.i);
            com.anythink.expressad.video.module.b.a.a(com.anythink.core.common.b.o.a().f(), this.X);
            if (!this.W || com.anythink.expressad.foundation.g.a.f.k == null || android.text.TextUtils.isEmpty(this.X.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.a.f.a(this.ac, this.X, "reward");
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public final void e() {
        com.anythink.expressad.foundation.d.c cVar;
        java.util.List<java.lang.String> e;
        try {
            if (!this.W || this.aj || (cVar = this.X) == null) {
                return;
            }
            this.aj = true;
            if ((cVar.j() && this.Z && !this.X.l()) || this.Z || (e = this.X.e()) == null || e.size() <= 0) {
                return;
            }
            java.util.Iterator<java.lang.String> it = e.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), this.X, this.ac, it.next(), true);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public final void f() {
        com.anythink.expressad.foundation.d.c cVar = this.X;
        if (cVar == null || android.text.TextUtils.isEmpty(cVar.K()) || this.X.L() == null || this.X.L().n() == null) {
            return;
        }
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        com.anythink.expressad.foundation.d.c cVar2 = this.X;
        com.anythink.expressad.a.a.a(f, cVar2, cVar2.K(), this.X.L().n(), false);
    }
}
