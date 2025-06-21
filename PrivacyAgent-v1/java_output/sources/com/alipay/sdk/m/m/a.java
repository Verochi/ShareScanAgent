package com.alipay.sdk.m.m;

/* loaded from: classes.dex */
public final class a {
    public static final java.lang.String A0 = "cfg_max_time";
    public static final java.lang.String B0 = "get_oa_id";
    public static final java.lang.String C0 = "notifyFailApp";
    public static final java.lang.String D0 = "startactivity_in_ui_thread";
    public static final java.lang.String E = "DynCon";
    public static final java.lang.String E0 = "scheme_pay_2";
    public static final int F = 10000;
    public static final java.lang.String F0 = "intercept_batch";
    public static final java.lang.String G = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final java.lang.String G0 = "bind_with_startActivity";
    public static final int H = 10;
    public static final java.lang.String H0 = "startActivity_InsteadOf_Scheme";
    public static final boolean I = true;
    public static final java.lang.String I0 = "enableStartActivityFallback";
    public static final boolean J = true;
    public static final java.lang.String J0 = "enableBindExFallback";
    public static final boolean K = false;
    public static com.alipay.sdk.m.m.a K0 = null;
    public static final boolean L = true;
    public static final boolean M = true;
    public static final java.lang.String N = "";
    public static final boolean O = false;
    public static final boolean P = false;
    public static final boolean Q = false;
    public static final boolean R = false;
    public static final boolean S = true;
    public static final java.lang.String T = "";
    public static final boolean U = false;
    public static final boolean V = false;
    public static final boolean W = false;
    public static final int X = 1000;
    public static final boolean Y = true;
    public static final java.lang.String Z = "";
    public static final boolean a0 = false;
    public static final boolean b0 = false;
    public static final boolean c0 = false;
    public static final int d0 = 1000;
    public static final int e0 = 20000;
    public static final boolean f0 = false;
    public static final java.lang.String g0 = "alipay_cashier_dynamic_config";
    public static final java.lang.String h0 = "timeout";
    public static final java.lang.String i0 = "h5_port_degrade";
    public static final java.lang.String j0 = "st_sdk_config";
    public static final java.lang.String k0 = "tbreturl";
    public static final java.lang.String l0 = "launchAppSwitch";
    public static final java.lang.String m0 = "configQueryInterval";
    public static final java.lang.String n0 = "deg_log_mcgw";
    public static final java.lang.String o0 = "deg_start_srv_first";
    public static final java.lang.String p0 = "prev_jump_dual";
    public static final java.lang.String q0 = "use_sc_only";
    public static final java.lang.String r0 = "retry_aidl_activity_not_start";
    public static final java.lang.String s0 = "bind_use_imp";
    public static final java.lang.String t0 = "retry_bnd_once";
    public static final java.lang.String u0 = "skip_trans";
    public static final java.lang.String v0 = "start_trans";
    public static final java.lang.String w0 = "up_before_pay";
    public static final java.lang.String x0 = "lck_k";
    public static final java.lang.String y0 = "use_sc_lck_a";
    public static final java.lang.String z0 = "utdid_factor";
    public org.json.JSONObject A;
    public int a = 10000;
    public boolean b = false;
    public java.lang.String c = G;
    public int d = 10;
    public boolean e = true;
    public boolean f = true;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = true;
    public boolean k = true;
    public java.lang.String l = "";
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = true;
    public java.lang.String r = "";

    /* renamed from: s, reason: collision with root package name */
    public java.lang.String f83s = "";
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public int y = 1000;
    public boolean z = false;
    public boolean B = true;
    public java.util.List<com.alipay.sdk.m.m.a.b> C = null;
    public int D = -1;

    /* renamed from: com.alipay.sdk.m.m.a$a, reason: collision with other inner class name */
    public class RunnableC0038a implements java.lang.Runnable {
        public final /* synthetic */ com.alipay.sdk.m.s.a a;
        public final /* synthetic */ android.content.Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public RunnableC0038a(com.alipay.sdk.m.s.a aVar, android.content.Context context, boolean z, int i) {
            this.a = aVar;
            this.b = context;
            this.c = z;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alipay.sdk.m.p.b a = new com.alipay.sdk.m.q.b().a(this.a, this.b);
                if (a != null) {
                    com.alipay.sdk.m.m.a.this.a(this.a, a.a());
                    com.alipay.sdk.m.m.a.this.a(com.alipay.sdk.m.s.a.h());
                    com.alipay.sdk.m.k.a.a(this.a, com.alipay.sdk.m.k.b.l, "offcfg|" + this.c + "|" + this.d);
                }
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
            }
        }
    }

    public static final class b {
        public final java.lang.String a;
        public final int b;
        public final java.lang.String c;

        public b(java.lang.String str, int i, java.lang.String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        public static com.alipay.sdk.m.m.a.b a(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new com.alipay.sdk.m.m.a.b(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public static java.util.List<com.alipay.sdk.m.m.a.b> a(org.json.JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                com.alipay.sdk.m.m.a.b a = a(jSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }

        public static org.json.JSONArray a(java.util.List<com.alipay.sdk.m.m.a.b> list) {
            if (list == null) {
                return null;
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            java.util.Iterator<com.alipay.sdk.m.m.a.b> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            return jSONArray;
        }

        public static org.json.JSONObject a(com.alipay.sdk.m.m.a.b bVar) {
            if (bVar == null) {
                return null;
            }
            try {
                return new org.json.JSONObject().put("pn", bVar.a).put("v", bVar.b).put("pk", bVar.c);
            } catch (org.json.JSONException e) {
                com.alipay.sdk.m.u.e.a(e);
                return null;
            }
        }

        public java.lang.String toString() {
            return java.lang.String.valueOf(a(this));
        }
    }

    private int C() {
        return this.y;
    }

    public static com.alipay.sdk.m.m.a D() {
        if (K0 == null) {
            com.alipay.sdk.m.m.a aVar = new com.alipay.sdk.m.m.a();
            K0 = aVar;
            aVar.t();
        }
        return K0;
    }

    private org.json.JSONObject E() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("timeout", k());
        jSONObject.put(i0, y());
        jSONObject.put(k0, r());
        jSONObject.put(m0, d());
        jSONObject.put(l0, com.alipay.sdk.m.m.a.b.a(l()));
        jSONObject.put(E0, i());
        jSONObject.put(F0, h());
        jSONObject.put(n0, e());
        jSONObject.put(o0, f());
        jSONObject.put(p0, m());
        jSONObject.put(q0, g());
        jSONObject.put(s0, b());
        jSONObject.put(t0, n());
        jSONObject.put(u0, p());
        jSONObject.put(v0, B());
        jSONObject.put(w0, s());
        jSONObject.put(y0, o());
        jSONObject.put(x0, j());
        jSONObject.put(G0, c());
        jSONObject.put(H0, q());
        jSONObject.put(r0, A());
        jSONObject.put(A0, C());
        jSONObject.put(B0, x());
        jSONObject.put(C0, v());
        jSONObject.put(I0, w());
        jSONObject.put(J0, u());
        jSONObject.put(D0, z());
        jSONObject.put(com.alipay.sdk.m.u.a.b, a());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.m.s.a aVar) {
        try {
            org.json.JSONObject E2 = E();
            com.alipay.sdk.m.u.j.b(aVar, com.alipay.sdk.m.s.b.d().b(), g0, E2.toString());
        } catch (java.lang.Exception e) {
            com.alipay.sdk.m.u.e.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(j0);
            com.alipay.sdk.m.u.a.a(aVar, optJSONObject, com.alipay.sdk.m.u.a.a(aVar, jSONObject));
            if (optJSONObject != null) {
                a(optJSONObject);
            } else {
                com.alipay.sdk.m.u.e.e(E, "empty config");
            }
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
        }
    }

    private void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
        }
    }

    private void a(org.json.JSONObject jSONObject) {
        this.a = jSONObject.optInt("timeout", 10000);
        this.b = jSONObject.optBoolean(i0, false);
        this.c = jSONObject.optString(k0, G).trim();
        this.d = jSONObject.optInt(m0, 10);
        this.C = com.alipay.sdk.m.m.a.b.a(jSONObject.optJSONArray(l0));
        this.e = jSONObject.optBoolean(E0, true);
        this.f = jSONObject.optBoolean(F0, true);
        this.i = jSONObject.optBoolean(n0, false);
        this.j = jSONObject.optBoolean(o0, true);
        this.k = jSONObject.optBoolean(p0, true);
        this.l = jSONObject.optString(q0, "");
        this.m = jSONObject.optBoolean(s0, false);
        this.n = jSONObject.optBoolean(t0, false);
        this.o = jSONObject.optBoolean(u0, false);
        this.p = jSONObject.optBoolean(v0, false);
        this.q = jSONObject.optBoolean(w0, true);
        this.r = jSONObject.optString(x0, "");
        this.w = jSONObject.optBoolean(y0, false);
        this.x = jSONObject.optBoolean(r0, false);
        this.z = jSONObject.optBoolean(C0, false);
        this.f83s = jSONObject.optString(G0, "");
        this.t = jSONObject.optBoolean(H0, false);
        this.y = jSONObject.optInt(A0, 1000);
        this.B = jSONObject.optBoolean(B0, true);
        this.u = jSONObject.optBoolean(I0, false);
        this.v = jSONObject.optBoolean(J0, false);
        this.g = jSONObject.optBoolean(D0, false);
        this.A = jSONObject.optJSONObject(com.alipay.sdk.m.u.a.b);
    }

    public boolean A() {
        return this.x;
    }

    public boolean B() {
        return this.p;
    }

    public org.json.JSONObject a() {
        return this.A;
    }

    public void a(com.alipay.sdk.m.s.a aVar, android.content.Context context, boolean z, int i) {
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "oncfg|" + z + "|" + i);
        com.alipay.sdk.m.m.a.RunnableC0038a runnableC0038a = new com.alipay.sdk.m.m.a.RunnableC0038a(aVar, context, z, i);
        if (!z || com.alipay.sdk.m.u.n.h()) {
            java.lang.Thread thread = new java.lang.Thread(runnableC0038a);
            thread.setName("AlipayDCP");
            thread.start();
            return;
        }
        int C = C();
        if (com.alipay.sdk.m.u.n.a(C, runnableC0038a, "AlipayDCPBlok")) {
            return;
        }
        com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.m0, "" + C);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean a(android.content.Context context, int i) {
        if (this.D == -1) {
            this.D = com.alipay.sdk.m.u.n.a();
            com.alipay.sdk.m.u.j.b(com.alipay.sdk.m.s.a.h(), context, z0, java.lang.String.valueOf(this.D));
        }
        return this.D < i;
    }

    public boolean b() {
        return this.m;
    }

    public java.lang.String c() {
        return this.f83s;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public java.lang.String g() {
        return this.l;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.e;
    }

    public java.lang.String j() {
        return this.r;
    }

    public int k() {
        int i = this.a;
        if (i < 1000 || i > 20000) {
            com.alipay.sdk.m.u.e.b(E, "time(def) = 10000");
            return 10000;
        }
        com.alipay.sdk.m.u.e.b(E, "time = " + this.a);
        return this.a;
    }

    public java.util.List<com.alipay.sdk.m.m.a.b> l() {
        return this.C;
    }

    public boolean m() {
        return this.k;
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.w;
    }

    public boolean p() {
        return this.o;
    }

    public boolean q() {
        return this.t;
    }

    public java.lang.String r() {
        return this.c;
    }

    public boolean s() {
        return this.q;
    }

    public void t() {
        android.content.Context b2 = com.alipay.sdk.m.s.b.d().b();
        java.lang.String a = com.alipay.sdk.m.u.j.a(com.alipay.sdk.m.s.a.h(), b2, g0, null);
        try {
            this.D = java.lang.Integer.parseInt(com.alipay.sdk.m.u.j.a(com.alipay.sdk.m.s.a.h(), b2, z0, "-1"));
        } catch (java.lang.Exception unused) {
        }
        a(a);
    }

    public boolean u() {
        return this.v;
    }

    public boolean v() {
        return this.z;
    }

    public boolean w() {
        return this.u;
    }

    public boolean x() {
        return this.B;
    }

    public boolean y() {
        return this.b;
    }

    public boolean z() {
        return this.g;
    }
}
