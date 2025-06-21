package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class q extends com.anythink.core.common.f.o implements java.lang.Comparable<com.anythink.core.common.f.q> {
    public int a;
    public java.lang.String b;
    public java.lang.String c;
    public int d;
    public long e;
    public long f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public double l;
    public java.lang.String m;
    public int n;
    public double o;
    public java.lang.String p;
    public double q;
    public com.anythink.core.b.c.a r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f175s;
    public java.util.List<com.anythink.core.common.f.p> t;
    public com.anythink.core.common.f.bb u;
    private final java.lang.String v;
    private boolean w;
    private java.lang.String x;
    private com.anythink.core.common.f.q.a y;

    public interface a {
        void a();
    }

    public q(boolean z, double d, double d2, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        super(z, d2, str, str2, str3, str4, str5, com.anythink.core.api.ATAdConst.CURRENCY.USD);
        this.v = com.anythink.core.common.f.q.class.getSimpleName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
        this.sortPrice = d;
    }

    public q(boolean z, double d, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        super(z, d, str, str2, str3, str4, str5, com.anythink.core.api.ATAdConst.CURRENCY.USD);
        this.v = com.anythink.core.common.f.q.class.getSimpleName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
    }

    private int a(com.anythink.core.common.f.q qVar) {
        if (qVar == null) {
            return -1;
        }
        double d = this.sortPrice;
        double d2 = qVar.sortPrice;
        if (d > d2) {
            return -1;
        }
        return d == d2 ? 0 : 1;
    }

    public static com.anythink.core.common.f.q a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.anythink.core.common.f.q qVar = new com.anythink.core.common.f.q(jSONObject.optInt("is_success") == 1, jSONObject.has(com.anythink.core.c.b.d.a.h) ? jSONObject.optDouble(com.anythink.core.c.b.d.a.h, 0.0d) : 0.0d, jSONObject.optString(com.anythink.core.common.c.k.a.c), jSONObject.optString("nurl"), jSONObject.optString("lurl"), jSONObject.optString("burl"), jSONObject.optString("err_msg"));
            qVar.b = jSONObject.optString("cur");
            qVar.c = jSONObject.optString("unit_id");
            qVar.d = jSONObject.optInt("nw_firm_id");
            qVar.a = jSONObject.optInt("err_code");
            qVar.e = jSONObject.optLong("expire");
            qVar.f = jSONObject.optLong("out_data_time");
            qVar.w = jSONObject.optBoolean("is_send_winurl");
            qVar.i = jSONObject.optString(com.anythink.core.common.c.k.a.g);
            qVar.g = jSONObject.optString("tp_bid_id");
            qVar.j = jSONObject.optString("burl_win");
            qVar.k = jSONObject.optString("ad_source_id");
            qVar.l = jSONObject.optDouble("cur_rate", 0.0d);
            qVar.m = jSONObject.optString("bid_response");
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("ctrl");
            if (optJSONObject != null) {
                qVar.n = optJSONObject.optInt(com.anythink.core.common.j.ag);
            }
            qVar.o = jSONObject.optDouble("ecpm_api", 0.0d);
            qVar.p = jSONObject.optString(com.anythink.core.common.j.R);
            qVar.q = jSONObject.optDouble("second_price", 0.0d);
            qVar.h = jSONObject.optString("req_url", "");
            qVar.useType = jSONObject.optInt("bd_type", 1);
            double optDouble = jSONObject.optDouble(com.anythink.core.common.j.ao, qVar.price);
            qVar.sortPrice = optDouble;
            qVar.originPrice = jSONObject.optDouble("origin_price", optDouble);
            if (qVar.d == 1) {
                double d = qVar.o;
                if (d > 0.0d) {
                    qVar.price = d;
                    qVar.sortPrice = d;
                }
            }
            java.lang.Object opt = jSONObject.opt("request_id");
            if (opt != null) {
                qVar.x = opt.toString();
            }
            return qVar;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private void a(double d) {
        this.q = d;
    }

    private void a(com.anythink.core.common.f.bb bbVar) {
        this.u = bbVar;
    }

    private com.anythink.core.common.f.bb h() {
        return this.u;
    }

    public final synchronized void a(com.anythink.core.common.f.p pVar) {
        if (pVar == null) {
            return;
        }
        if (this.t == null) {
            this.t = java.util.Collections.synchronizedList(new java.util.ArrayList(4));
        }
        if (!this.t.contains(pVar)) {
            this.t.add(pVar);
        }
    }

    public final boolean a() {
        return this.f < java.lang.System.currentTimeMillis();
    }

    public final java.lang.String b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.anythink.core.common.c.k.a.c, this.token);
            jSONObject.put("cur", this.b);
            jSONObject.put("origin_price", this.originPrice);
            jSONObject.put(com.anythink.core.c.b.d.a.h, this.price);
            jSONObject.put("nurl", this.winNoticeUrl);
            jSONObject.put("lurl", this.loseNoticeUrl);
            jSONObject.put("unit_id", this.c);
            jSONObject.put("nw_firm_id", this.d);
            jSONObject.put("is_success", this.isSuccess ? 1 : 0);
            jSONObject.put("err_code", this.a);
            jSONObject.put("err_msg", this.errorMsg);
            jSONObject.put("expire", this.e);
            jSONObject.put("out_data_time", this.f);
            jSONObject.put("is_send_winurl", this.w);
            jSONObject.put("tp_bid_id", this.g);
            jSONObject.put("burl", this.displayNoticeUrl);
            jSONObject.put("ad_source_id", this.k);
            jSONObject.put("cur_rate", this.l);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.anythink.core.common.j.ag, this.n);
            jSONObject.put("ctrl", jSONObject2);
            if (!android.text.TextUtils.isEmpty(this.m)) {
                jSONObject.put("bid_response", this.m);
            }
            jSONObject.put("ecpm_api", this.o);
            jSONObject.put(com.anythink.core.common.j.R, this.p);
            jSONObject.put("second_price", this.q);
            jSONObject.put("req_url", this.h);
            jSONObject.put("bd_type", this.useType);
            jSONObject.put(com.anythink.core.common.j.ao, this.sortPrice);
            jSONObject.put("request_id", this.x);
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject.toString();
    }

    public final void b(java.lang.String str) {
        this.x = str;
    }

    public final java.lang.String c() {
        return this.x;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(com.anythink.core.common.f.q qVar) {
        com.anythink.core.common.f.q qVar2 = qVar;
        if (qVar2 == null) {
            return -1;
        }
        double d = this.sortPrice;
        double d2 = qVar2.sortPrice;
        if (d > d2) {
            return -1;
        }
        return d == d2 ? 0 : 1;
    }

    public final synchronized boolean d() {
        if (this.w) {
            return true;
        }
        this.w = true;
        return false;
    }

    public final synchronized void e() {
        this.biddingNotice = null;
    }

    public final synchronized com.anythink.core.common.f.au f() {
        com.anythink.core.common.f.au auVar;
        java.util.List<com.anythink.core.common.f.p> list = this.t;
        auVar = null;
        if (list != null) {
            java.util.Iterator<com.anythink.core.common.f.p> it = list.iterator();
            while (it.hasNext()) {
                com.anythink.core.common.f.au a2 = it.next().a();
                if (a2 != null && com.anythink.core.common.o.h.a(a2) > com.anythink.core.common.o.h.a(auVar)) {
                    auVar = a2;
                }
            }
        }
        return auVar;
    }

    public final synchronized void g() {
        java.util.List<com.anythink.core.common.f.p> list = this.t;
        if (list != null) {
            list.clear();
        }
    }
}
