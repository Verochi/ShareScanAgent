package com.alipay.sdk.app;

/* loaded from: classes.dex */
public class AuthTask {
    public static final java.lang.Object c = com.alipay.sdk.m.u.h.class;
    public android.app.Activity a;
    public com.alipay.sdk.m.x.a b;

    public class a implements com.alipay.sdk.m.u.h.g {
        public a() {
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void a() {
            com.alipay.sdk.app.AuthTask.this.a();
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void b() {
        }
    }

    public AuthTask(android.app.Activity activity) {
        this.a = activity;
        com.alipay.sdk.m.s.b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.k);
    }

    private java.lang.String a(android.app.Activity activity, java.lang.String str, com.alipay.sdk.m.s.a aVar) {
        java.lang.String a2 = aVar.a(str);
        java.util.List<com.alipay.sdk.m.m.a.b> l = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().h || l == null) {
            l = com.alipay.sdk.m.j.a.d;
        }
        if (!com.alipay.sdk.m.u.n.a(aVar, (android.content.Context) this.a, l, true)) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
            return b(activity, a2, aVar);
        }
        com.alipay.sdk.m.u.h hVar = new com.alipay.sdk.m.u.h(activity, aVar, b());
        java.lang.String a3 = hVar.a(a2, false);
        hVar.a();
        if (!android.text.TextUtils.equals(a3, com.alipay.sdk.m.u.h.j) && !android.text.TextUtils.equals(a3, com.alipay.sdk.m.u.h.k)) {
            return android.text.TextUtils.isEmpty(a3) ? com.alipay.sdk.m.j.b.a() : a3;
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
        return b(activity, a2, aVar);
    }

    private java.lang.String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        java.lang.String[] c2 = bVar.c();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("url", c2[0]);
        android.content.Intent intent = new android.content.Intent(this.a, (java.lang.Class<?>) com.alipay.sdk.app.H5AuthActivity.class);
        intent.putExtras(bundle);
        com.alipay.sdk.m.s.a.C0043a.a(aVar, intent);
        this.a.startActivity(intent);
        java.lang.Object obj = c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (java.lang.InterruptedException unused) {
                return com.alipay.sdk.m.j.b.a();
            }
        }
        java.lang.String d = com.alipay.sdk.m.j.b.d();
        return android.text.TextUtils.isEmpty(d) ? com.alipay.sdk.m.j.b.a() : d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private com.alipay.sdk.m.u.h.g b() {
        return new com.alipay.sdk.app.AuthTask.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String b(android.app.Activity activity, java.lang.String str, com.alipay.sdk.m.s.a aVar) {
        c();
        com.alipay.sdk.m.j.c cVar = null;
        try {
            try {
                java.util.List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(new com.alipay.sdk.m.q.a().a(aVar, activity, str).c().optJSONObject(com.alipay.sdk.m.l.c.c).optJSONObject(com.alipay.sdk.m.l.c.d));
                a();
                for (int i = 0; i < a2.size(); i++) {
                    if (a2.get(i).a() == com.alipay.sdk.m.r.a.WapPay) {
                        return a(aVar, a2.get(i));
                    }
                }
                a();
            } finally {
                a();
            }
        } catch (java.io.IOException e) {
            com.alipay.sdk.m.j.c b = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.k, e);
            cVar = b;
            if (cVar == null) {
            }
            return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.C, th);
            if (cVar == null) {
            }
            return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        }
        if (cVar == null) {
            cVar = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
        }
        return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
    }

    private void c() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public synchronized java.lang.String auth(java.lang.String str, boolean z) {
        return innerAuth(new com.alipay.sdk.m.s.a(this.a, str, com.alipay.sdk.m.k.b.n), str, z);
    }

    public synchronized java.util.Map<java.lang.String, java.lang.String> authV2(java.lang.String str, boolean z) {
        com.alipay.sdk.m.s.a aVar;
        aVar = new com.alipay.sdk.m.s.a(this.a, str, "authV2");
        return com.alipay.sdk.m.u.l.a(aVar, innerAuth(aVar, str, z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x006c, code lost:
    
        if (com.alipay.sdk.m.m.a.D().s() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized java.lang.String innerAuth(com.alipay.sdk.m.s.a aVar, java.lang.String str, boolean z) {
        java.lang.String a2;
        if (z) {
            c();
        }
        com.alipay.sdk.m.s.b.d().a(this.a);
        a2 = com.alipay.sdk.m.j.b.a();
        com.alipay.sdk.m.j.a.a("");
        try {
            try {
                a2 = a(this.a, str, aVar);
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + android.os.SystemClock.elapsedRealtime());
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, com.alipay.sdk.m.u.l.a(a2, com.alipay.sdk.m.u.l.a) + "|" + com.alipay.sdk.m.u.l.a(a2, com.alipay.sdk.m.u.l.b));
            } catch (java.lang.Exception e) {
                com.alipay.sdk.m.u.e.a(e);
            }
        } finally {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + android.os.SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, com.alipay.sdk.m.u.l.a(a2, com.alipay.sdk.m.u.l.a) + "|" + com.alipay.sdk.m.u.l.a(a2, com.alipay.sdk.m.u.l.b));
            if (!com.alipay.sdk.m.m.a.D().s()) {
                com.alipay.sdk.m.m.a.D().a(aVar, this.a, false, 1);
            }
            a();
            com.alipay.sdk.m.k.a.b(this.a, aVar, str, aVar.d);
        }
        return a2;
    }
}
