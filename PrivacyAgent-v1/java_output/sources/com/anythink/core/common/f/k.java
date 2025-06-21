package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class k extends com.anythink.core.common.f.x {
    public java.lang.String A;
    public java.lang.String B;
    public java.lang.String C;
    public java.lang.String D;
    public org.json.JSONObject E;
    public java.lang.String F;
    public int G = -1;
    public int H = -1;
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public java.lang.String l;
    public java.lang.String m;
    public java.lang.String n;
    public java.lang.String o;
    public java.lang.String p;
    public java.lang.String q;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public java.lang.String f171s;
    public java.lang.String t;
    public java.lang.String u;
    public java.lang.String v;
    public java.lang.String w;
    public java.lang.String x;
    public java.lang.String y;
    public java.lang.String z;

    private k() {
    }

    public k(java.lang.String str, java.lang.String str2) {
        this.A = str;
        this.B = str2;
    }

    public static com.anythink.core.common.f.k a(java.lang.String str) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k();
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (jSONObject.has("key")) {
                    kVar.a = jSONObject.optString("key", "");
                }
                if (jSONObject.has("requestid")) {
                    kVar.b = jSONObject.optString("requestid", "");
                }
                if (jSONObject.has("unitid")) {
                    kVar.d = jSONObject.optString("unitid", "");
                }
                if (jSONObject.has(com.anythink.core.common.b.e.c)) {
                    kVar.e = jSONObject.optString(com.anythink.core.common.b.e.c, "");
                }
                if (jSONObject.has("sessionid")) {
                    kVar.f = jSONObject.optString("sessionid", "");
                }
                if (jSONObject.has("groupid")) {
                    kVar.g = jSONObject.optString("groupid", "");
                }
                if (jSONObject.has("unitgroupid")) {
                    kVar.h = jSONObject.optString("unitgroupid", "");
                }
                if (jSONObject.has("timestamp")) {
                    kVar.i = jSONObject.optString("timestamp", "");
                }
                if (jSONObject.has("asid")) {
                    kVar.j = jSONObject.optString("asid", "");
                }
                if (jSONObject.has(com.alipay.sdk.m.x.d.w)) {
                    kVar.k = jSONObject.optString(com.alipay.sdk.m.x.d.w, "");
                }
                if (jSONObject.has("traffic_group_id")) {
                    kVar.l = jSONObject.optString("traffic_group_id", "");
                }
                if (jSONObject.has("msg")) {
                    kVar.m = jSONObject.optString("msg", "");
                }
                if (jSONObject.has("msg1")) {
                    kVar.n = jSONObject.optString("msg1", "");
                }
                if (jSONObject.has("msg2")) {
                    kVar.o = jSONObject.optString("msg2", "");
                }
                if (jSONObject.has("msg3")) {
                    kVar.p = jSONObject.optString("msg3", "");
                }
                if (jSONObject.has("msg4")) {
                    kVar.q = jSONObject.optString("msg4", "");
                }
                if (jSONObject.has("msg5")) {
                    kVar.r = jSONObject.optString("msg5", "");
                }
                if (jSONObject.has("msg6")) {
                    kVar.f171s = jSONObject.optString("msg6", "");
                }
                if (jSONObject.has("msg7")) {
                    kVar.t = jSONObject.optString("msg7", "");
                }
                if (jSONObject.has("msg8")) {
                    kVar.u = jSONObject.optString("msg8", "");
                }
                if (jSONObject.has("msg9")) {
                    kVar.v = jSONObject.optString("msg9", "");
                }
                if (jSONObject.has("msg10")) {
                    kVar.w = jSONObject.optString("msg10", "");
                }
                if (jSONObject.has("msg11")) {
                    kVar.x = jSONObject.optString("msg11", "");
                }
                if (jSONObject.has("msg12")) {
                    kVar.y = jSONObject.optString("msg12", "");
                }
                if (jSONObject.has("msg13")) {
                    kVar.z = jSONObject.optString("msg13", "");
                }
                if (jSONObject.has(com.anythink.core.d.e.a.U)) {
                    kVar.C = jSONObject.optString(com.anythink.core.d.e.a.U, "");
                }
                if (jSONObject.has(com.anythink.core.common.h.c.am)) {
                    kVar.D = jSONObject.optString(com.anythink.core.common.h.c.am, "");
                }
                if (jSONObject.has(com.anythink.core.d.e.a.ab)) {
                    kVar.E = jSONObject.optJSONObject(com.anythink.core.d.e.a.ab);
                }
                kVar.F = jSONObject.optString("real_p", "");
                kVar.G = jSONObject.optInt("real_g", -1);
                kVar.H = jSONObject.optInt("real_t", -1);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return kVar;
    }

    @Override // com.anythink.core.common.f.x
    public final org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("key", this.a);
            jSONObject.put("requestid", this.b);
            jSONObject.put("unitid", this.d);
            jSONObject.put(com.anythink.core.common.b.e.c, this.e);
            jSONObject.put("sessionid", this.f);
            jSONObject.put("groupid", this.g);
            jSONObject.put("unitgroupid", this.h);
            jSONObject.put("timestamp", this.i);
            jSONObject.put("asid", this.j);
            jSONObject.put(com.alipay.sdk.m.x.d.w, this.k);
            jSONObject.put("traffic_group_id", this.l);
            jSONObject.put("msg", this.m);
            jSONObject.put("msg1", this.n);
            jSONObject.put("msg2", this.o);
            jSONObject.put("msg3", this.p);
            jSONObject.put("msg4", this.q);
            jSONObject.put("msg5", this.r);
            jSONObject.put("msg6", this.f171s);
            jSONObject.put("msg7", this.t);
            jSONObject.put("msg8", this.u);
            jSONObject.put("msg9", this.v);
            jSONObject.put("msg10", this.w);
            jSONObject.put("msg11", this.x);
            jSONObject.put("msg12", this.y);
            jSONObject.put("msg13", this.z);
            jSONObject.put(com.anythink.core.d.e.a.U, this.C);
            jSONObject.put(com.anythink.core.common.h.c.am, this.D);
            org.json.JSONObject jSONObject2 = this.E;
            if (jSONObject2 != null) {
                jSONObject.put(com.anythink.core.d.e.a.ab, jSONObject2);
            }
            jSONObject.put("real_p", this.F);
            int i = this.G;
            if (i != -1) {
                jSONObject.put("real_g", i);
            }
            int i2 = this.H;
            if (i2 != -1) {
                jSONObject.put("real_t", i2);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
