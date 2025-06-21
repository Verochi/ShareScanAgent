package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public class p {
    static final java.lang.String a = "reqId";
    static final java.lang.String b = "hasShow";
    static final java.lang.String c = "hasClick";
    static final java.lang.String d = "price";
    static final java.lang.String e = "networkFirmId";
    static final java.lang.String f = "isHB";
    static final java.lang.String g = "adsListType";
    static final java.lang.String h = "tpBidId";
    private static java.lang.String i = "p";
    private boolean j;
    private java.lang.String k;
    private boolean l;
    private boolean m;
    private com.anythink.core.common.f.au n;
    private int o;
    private double p;
    private boolean q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f174s;

    public p(java.lang.String str) {
        this.k = str;
    }

    private static int a(int i2) {
        if (i2 == 2) {
            return 3;
        }
        if (i2 != 3) {
            if (i2 == 4 || i2 == 5) {
                return 4;
            }
            if (i2 == 7) {
                return 3;
            }
            if (i2 != 8 && i2 != 11) {
                return 1;
            }
        }
        return 2;
    }

    public static com.anythink.core.common.f.p a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.anythink.core.common.f.p pVar = new com.anythink.core.common.f.p(jSONObject.getString(a));
            pVar.j = true;
            pVar.l = jSONObject.optBoolean(b);
            pVar.m = jSONObject.optBoolean(c);
            pVar.p = jSONObject.optDouble("price", -1.0d);
            pVar.o = jSONObject.optInt(e);
            pVar.q = jSONObject.optBoolean(f);
            pVar.r = jSONObject.optInt(g);
            pVar.f174s = jSONObject.optString(h);
            return pVar;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private boolean k() {
        return this.j;
    }

    public final synchronized com.anythink.core.common.f.au a() {
        return this.n;
    }

    public final synchronized void a(com.anythink.core.common.f.au auVar) {
        java.util.Objects.toString(auVar);
        this.n = auVar;
    }

    public final java.lang.String b() {
        return this.k;
    }

    public final void c() {
        this.l = true;
    }

    public final void d() {
        this.m = true;
    }

    public final boolean e() {
        return this.l;
    }

    public final java.lang.String f() {
        double a2;
        int d2;
        int i2;
        java.lang.String str;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            int i3 = 1;
            int i4 = this.l ? 1 : 0;
            if (!this.m) {
                i3 = 0;
            }
            if (this.j) {
                a2 = this.p;
                d2 = this.o;
                i2 = a(this.r);
                str = this.f174s;
            } else {
                a2 = com.anythink.core.common.o.h.a(this.n);
                d2 = this.n.d();
                com.anythink.core.common.f.q M = this.n.M();
                int a3 = a(this.n.a());
                if (M == null || android.text.TextUtils.isEmpty(M.g)) {
                    i2 = a3;
                    str = "";
                } else {
                    str = M.g;
                    i2 = a3;
                }
            }
            jSONObject.put("price", a2);
            jSONObject.put(e, d2);
            jSONObject.put("demandType", i2);
            if (!android.text.TextUtils.isEmpty(str)) {
                jSONObject.put("tp_bid_id", str);
            }
            jSONObject.put(com.umeng.analytics.pro.ay.c, i4);
            jSONObject.put(com.anythink.expressad.foundation.d.c.ca, i3);
            return jSONObject.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public final synchronized org.json.JSONObject g() {
        org.json.JSONObject jSONObject;
        jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(a, this.k);
            jSONObject.put(b, this.l);
            jSONObject.put(c, this.m);
            com.anythink.core.common.f.au auVar = this.n;
            if (auVar != null) {
                jSONObject.put("price", com.anythink.core.common.o.h.a(auVar));
                jSONObject.put(e, this.n.d());
                jSONObject.put(f, this.n.k());
                jSONObject.put(g, this.n.a());
                com.anythink.core.common.f.q M = this.n.M();
                if (M != null && !android.text.TextUtils.isEmpty(M.g)) {
                    jSONObject.put(h, M.g);
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public final double h() {
        if (this.j) {
            return this.p;
        }
        com.anythink.core.common.f.au auVar = this.n;
        if (auVar != null) {
            return com.anythink.core.common.o.h.a(auVar);
        }
        return -1.0d;
    }

    public final int i() {
        if (this.j) {
            return this.o;
        }
        com.anythink.core.common.f.au auVar = this.n;
        if (auVar != null) {
            return auVar.d();
        }
        return 0;
    }

    public final boolean j() {
        if (this.j) {
            return this.q;
        }
        com.anythink.core.common.f.au auVar = this.n;
        if (auVar != null) {
            return auVar.k();
        }
        return false;
    }

    public java.lang.String toString() {
        java.lang.String str;
        if (this.j) {
            str = ", priceInDisk=" + this.p + ", networkFirmIdInDisk=" + this.o + ", winnerIsHBInDisk=" + this.q + ", adsListTypeInDisk=" + this.r + ", tpBidIdInDisk=" + this.f174s;
        } else {
            str = null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("BiddingRecorder{fromLocalDisk=");
        sb.append(this.j);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(", requestId=");
        sb.append(this.k);
        sb.append(", hasShow=");
        sb.append(this.l);
        sb.append(", hasClick=");
        sb.append(this.m);
        sb.append(", loadedMaxPriceUgInMemory=");
        sb.append(this.n);
        sb.append('}');
        return sb.toString();
    }
}
