package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public abstract class at {
    public static final java.lang.String N = "ofm_tid_key";
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 6;
    public static final int U = 7;
    public static final int V = 8;
    public static final int W = 10;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public static final int aa = 3;
    public static final int ab = 4;
    public static final int ac = 5;
    public static final int ad = 8;
    public static final java.lang.String ae = "0";
    public static final java.lang.String af = "1";
    public static final java.lang.String ag = "2";
    public static final java.lang.String ah = "3";
    public static final java.lang.String ai = "4";
    private java.lang.String a;
    protected java.lang.String aj;
    protected java.lang.String ak;
    protected java.lang.String al;
    protected java.lang.String am;
    public java.lang.String an;
    public int ao;
    public int ap;
    protected java.lang.String aq;
    protected int ar;
    protected int as;
    protected int at;
    protected int au = -1;
    private java.lang.String b;
    private int c;
    private org.json.JSONObject d;
    private int e;
    private java.lang.Object f;

    private org.json.JSONObject a() {
        return this.d;
    }

    private void a(int i) {
        this.ao = i;
    }

    private void a(java.lang.String str) {
        this.an = str;
    }

    private int b() {
        return this.at;
    }

    private void b(int i) {
        this.ap = i;
    }

    private int c() {
        return this.ar;
    }

    private java.lang.String d() {
        return this.an;
    }

    private int e() {
        return this.ao;
    }

    private int f() {
        return this.ap;
    }

    public org.json.JSONObject F(int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("type", i);
            jSONObject.put("pl_id", this.aj);
            jSONObject.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, this.ak);
            if (!android.text.TextUtils.isEmpty(this.al)) {
                jSONObject.put("format", java.lang.Integer.parseInt(this.al));
            }
            jSONObject.put("ps_id", com.anythink.core.common.b.o.a().q());
            java.lang.String g = com.anythink.core.common.b.o.a().g(this.aj);
            if (!android.text.TextUtils.isEmpty(g)) {
                jSONObject.put("sessionid", g);
            }
            int i2 = this.au;
            if (i2 != -1) {
                jSONObject.put("traffic_group_id", i2);
            }
            if (this.at == 1) {
                jSONObject.put("ofm_tid", this.as);
                jSONObject.put("ofm_system", this.ar);
                jSONObject.put(com.anythink.core.common.h.c.M, this.at);
            }
            jSONObject.put("asid", this.am);
            jSONObject.put(com.anythink.core.d.e.a.U, this.a);
            jSONObject.put(com.anythink.core.common.h.c.am, this.b);
            org.json.JSONObject jSONObject2 = this.d;
            if (jSONObject2 != null) {
                jSONObject.put(com.anythink.core.d.e.a.ab, jSONObject2);
            }
            jSONObject.put("wf2_mode", this.e);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final void I(int i) {
        this.e = i;
    }

    public final void J(int i) {
        this.c = i;
    }

    public final void K(int i) {
        this.at = i;
    }

    public final void L(int i) {
        this.as = i;
    }

    public final void M(int i) {
        this.au = i;
    }

    public final java.lang.Object T() {
        return this.f;
    }

    public final int U() {
        return this.c;
    }

    public final java.lang.String V() {
        return this.a;
    }

    public final java.lang.String W() {
        return this.b;
    }

    public final void X() {
        this.ar = 1;
    }

    public final int Y() {
        return this.as;
    }

    public final java.lang.String Z() {
        return this.aq;
    }

    public final void a(java.lang.Object obj) {
        this.f = obj;
    }

    public final void a(org.json.JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public final int aa() {
        return this.au;
    }

    public final java.lang.String ab() {
        return this.am;
    }

    public final java.lang.String ac() {
        return this.aj;
    }

    public final java.lang.String ad() {
        return this.ak;
    }

    public final java.lang.String ae() {
        return this.al;
    }

    public final java.lang.String af() {
        java.lang.String str = this.al;
        str.hashCode();
        switch (str) {
            case "0":
                return com.anythink.expressad.foundation.g.a.f.a;
            case "1":
                return "reward";
            case "2":
                return "banner";
            case "3":
                return "inter";
            case "4":
                return "splash";
            default:
                return "none";
        }
    }

    public final void s(java.lang.String str) {
        this.a = str;
    }

    public final void t(java.lang.String str) {
        this.b = str;
    }

    public final void u(java.lang.String str) {
        this.aq = str;
    }

    public final void v(java.lang.String str) {
        this.am = str;
    }

    public final void w(java.lang.String str) {
        this.aj = str;
    }

    public final void x(java.lang.String str) {
        this.ak = str;
    }

    public final void y(java.lang.String str) {
        this.al = str;
    }
}
