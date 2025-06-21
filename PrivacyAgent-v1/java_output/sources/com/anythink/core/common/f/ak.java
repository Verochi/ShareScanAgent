package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class ak implements java.io.Serializable {
    java.lang.String[] A;
    java.lang.String[] B;
    java.lang.String[] C;
    java.lang.String[] D;
    java.lang.String[] E;
    java.util.Map<java.lang.Integer, java.lang.String[]> F;
    java.lang.String[] G;
    java.lang.String[] H;
    java.lang.String I;
    java.lang.String J;
    java.lang.String K;
    java.lang.String L;
    java.lang.String M;
    java.lang.String N;
    java.lang.String O;
    java.lang.String P;
    java.lang.String Q;
    java.lang.String R;
    java.lang.String S;
    java.lang.String T;
    java.lang.String U;
    java.lang.String V;
    java.lang.String W;
    java.lang.String X;
    java.lang.String Y;
    java.lang.String Z;
    java.lang.String a;
    java.lang.String aa;
    java.lang.String ab;
    java.lang.String ac;
    java.lang.String ad;
    java.lang.String ae;
    java.lang.String af;
    java.lang.String ag;
    java.lang.String ah;
    java.lang.String ai;
    java.lang.String aj;
    java.lang.String ak;
    java.lang.String al;
    java.lang.String am;
    java.lang.String an;
    java.lang.String[] ao;
    java.lang.String ap;
    java.lang.String[] b;
    java.lang.String[] c;
    java.lang.String[] d;
    java.lang.String[] e;
    java.lang.String[] f;
    java.lang.String[] g;
    java.lang.String[] h;
    java.lang.String[] i;
    java.lang.String[] j;
    java.lang.String[] k;
    java.lang.String[] l;
    java.lang.String[] m;
    java.lang.String[] n;
    java.lang.String[] o;
    java.lang.String[] p;
    java.lang.String[] q;
    java.lang.String[] r;

    /* renamed from: s, reason: collision with root package name */
    java.lang.String[] f168s;
    java.lang.String[] t;
    java.lang.String[] u;
    java.lang.String[] v;
    java.lang.String[] w;
    java.lang.String[] x;
    java.lang.String[] y;
    java.lang.String[] z;

    public static final com.anythink.core.common.f.ak a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.anythink.core.common.f.ak akVar = new com.anythink.core.common.f.ak();
            akVar.a = jSONObject.optString(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_KS);
            akVar.b = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("nurl"));
            akVar.c = com.anythink.core.common.o.i.a(jSONObject.optJSONArray(com.umeng.analytics.pro.ay.c));
            akVar.d = com.anythink.core.common.o.i.a(jSONObject.optJSONArray(com.anythink.expressad.foundation.d.c.ca));
            akVar.e = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vstart"));
            akVar.f = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("v25"));
            akVar.g = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("v50"));
            akVar.h = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("v75"));
            akVar.i = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("v100"));
            akVar.j = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vpaused"));
            akVar.k = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vclick"));
            akVar.l = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vmute"));
            akVar.m = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vunmute"));
            akVar.n = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("ec_show"));
            akVar.o = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("ec_close"));
            akVar.p = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("apk_dl_star"));
            akVar.q = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("apk_dl_end"));
            akVar.r = com.anythink.core.common.o.i.a(jSONObject.optJSONArray(com.anythink.expressad.foundation.d.h.cM));
            akVar.f168s = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vresumed"));
            akVar.t = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vskip"));
            akVar.u = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vfail"));
            akVar.v = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("apk_start_install"));
            akVar.w = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("dp_start"));
            akVar.x = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("dp_succ"));
            akVar.y = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("app_install"));
            akVar.z = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("app_uninstall"));
            akVar.A = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("app_unknow"));
            akVar.C = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("dp_inst_fail"));
            akVar.B = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("dp_uninst_fail"));
            akVar.D = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vd_succ"));
            akVar.E = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vrewarded"));
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("v_p_tracking");
            if (optJSONArray != null) {
                akVar.F = new java.util.HashMap();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    int optInt = optJSONObject.optInt("play_sec");
                    akVar.F.put(java.lang.Integer.valueOf(optInt), com.anythink.core.common.o.i.a(optJSONObject.optJSONArray(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST)));
                }
            }
            akVar.G = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("load_success"));
            akVar.H = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("load_fail"));
            akVar.I = jSONObject.optString("tp_nurl");
            akVar.J = jSONObject.optString("tp_imp");
            akVar.K = jSONObject.optString("tp_click");
            akVar.L = jSONObject.optString("tp_vstart");
            akVar.M = jSONObject.optString("tp_v25");
            akVar.N = jSONObject.optString("tp_v50");
            akVar.O = jSONObject.optString("tp_v75");
            akVar.P = jSONObject.optString("tp_v100");
            akVar.Q = jSONObject.optString("tp_vpaused");
            akVar.R = jSONObject.optString("tp_vclick");
            akVar.S = jSONObject.optString("tp_vmute");
            akVar.T = jSONObject.optString("tp_vunmute");
            akVar.U = jSONObject.optString("tp_ec_show");
            akVar.V = jSONObject.optString("tp_ec_close");
            akVar.W = jSONObject.optString("tp_apk_dl_star");
            akVar.X = jSONObject.optString("tp_apk_dl_end");
            akVar.Y = jSONObject.optString("tp_apk_install");
            akVar.Z = jSONObject.optString("tp_vresumed");
            akVar.aa = jSONObject.optString("tp_vskip");
            akVar.ab = jSONObject.optString("tp_vfail");
            akVar.ac = jSONObject.optString("tp_apk_start_install");
            akVar.ad = jSONObject.optString("tp_dp_start");
            akVar.ae = jSONObject.optString("tp_dp_succ");
            akVar.af = jSONObject.optString("tp_app_install");
            akVar.ag = jSONObject.optString("tp_app_uninstall");
            akVar.ah = jSONObject.optString("tp_app_unknow");
            akVar.aj = jSONObject.optString("tp_dp_inst_fail");
            akVar.ai = jSONObject.optString("tp_dp_uninst_fail");
            akVar.ak = jSONObject.optString("tp_vd_succ");
            akVar.al = jSONObject.optString("tp_vrewarded");
            akVar.am = jSONObject.optString("tp_load_success");
            akVar.an = jSONObject.optString("tp_load_fail");
            akVar.ao = com.anythink.core.common.o.i.a(jSONObject.optJSONArray("vready"));
            akVar.ap = jSONObject.optString("tp_ready");
            return akVar;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final java.lang.String A() {
        return this.J;
    }

    public final java.lang.String B() {
        return this.K;
    }

    public final java.lang.String C() {
        return this.L;
    }

    public final java.lang.String D() {
        return this.M;
    }

    public final java.lang.String E() {
        return this.N;
    }

    public final java.lang.String F() {
        return this.O;
    }

    public final java.lang.String G() {
        return this.P;
    }

    public final java.lang.String H() {
        return this.Q;
    }

    public final java.lang.String I() {
        return this.R;
    }

    public final java.lang.String J() {
        return this.S;
    }

    public final java.lang.String K() {
        return this.T;
    }

    public final java.lang.String L() {
        return this.U;
    }

    public final java.lang.String M() {
        return this.V;
    }

    public final java.lang.String N() {
        return this.W;
    }

    public final java.lang.String O() {
        return this.X;
    }

    public final java.lang.String P() {
        return this.Y;
    }

    public final java.lang.String[] Q() {
        return this.f168s;
    }

    public final java.lang.String[] R() {
        return this.t;
    }

    public final java.lang.String[] S() {
        return this.u;
    }

    public final java.lang.String[] T() {
        return this.v;
    }

    public final java.lang.String[] U() {
        return this.w;
    }

    public final java.lang.String[] V() {
        return this.x;
    }

    public final java.lang.String[] W() {
        return this.y;
    }

    public final java.lang.String[] X() {
        return this.z;
    }

    public final java.lang.String[] Y() {
        return this.A;
    }

    public final java.lang.String Z() {
        return this.Z;
    }

    public final void a(java.lang.String[] strArr) {
        this.d = strArr;
    }

    public final java.lang.String[] a() {
        return this.G;
    }

    public final java.lang.String aa() {
        return this.aa;
    }

    public final java.lang.String ab() {
        return this.ab;
    }

    public final java.lang.String ac() {
        return this.ac;
    }

    public final java.lang.String ad() {
        return this.ad;
    }

    public final java.lang.String ae() {
        return this.ae;
    }

    public final java.lang.String af() {
        return this.af;
    }

    public final java.lang.String ag() {
        return this.ag;
    }

    public final java.lang.String ah() {
        return this.ah;
    }

    public final java.lang.String ai() {
        return this.ai;
    }

    public final java.lang.String aj() {
        return this.aj;
    }

    public final java.lang.String ak() {
        return this.ak;
    }

    public final java.lang.String al() {
        return this.al;
    }

    public final java.lang.String am() {
        return this.am;
    }

    public final java.lang.String an() {
        return this.an;
    }

    public final java.lang.String[] ao() {
        return this.ao;
    }

    public final java.lang.String ap() {
        return this.ap;
    }

    public final void b(java.lang.String[] strArr) {
        this.p = strArr;
    }

    public final java.lang.String[] b() {
        return this.H;
    }

    public final java.lang.String c() {
        return this.a;
    }

    public final void c(java.lang.String[] strArr) {
        this.q = strArr;
    }

    public final void d(java.lang.String[] strArr) {
        this.r = strArr;
    }

    public final java.lang.String[] d() {
        return this.b;
    }

    public final java.lang.String[] e() {
        return this.c;
    }

    public final java.lang.String[] f() {
        return this.d;
    }

    public final java.lang.String[] g() {
        return this.e;
    }

    public final java.lang.String[] h() {
        return this.f;
    }

    public final java.lang.String[] i() {
        return this.g;
    }

    public final java.lang.String[] j() {
        return this.h;
    }

    public final java.lang.String[] k() {
        return this.i;
    }

    public final java.lang.String[] l() {
        return this.j;
    }

    public final java.lang.String[] m() {
        return this.k;
    }

    public final java.lang.String[] n() {
        return this.l;
    }

    public final java.lang.String[] o() {
        return this.m;
    }

    public final java.lang.String[] p() {
        return this.n;
    }

    public final java.lang.String[] q() {
        return this.o;
    }

    public final java.lang.String[] r() {
        return this.p;
    }

    public final java.lang.String[] s() {
        return this.q;
    }

    public final java.lang.String[] t() {
        return this.r;
    }

    public final java.lang.String[] u() {
        return this.B;
    }

    public final java.lang.String[] v() {
        return this.C;
    }

    public final java.lang.String[] w() {
        return this.D;
    }

    public final java.lang.String[] x() {
        return this.E;
    }

    public final java.util.Map<java.lang.Integer, java.lang.String[]> y() {
        return this.F;
    }

    public final java.lang.String z() {
        return this.I;
    }
}
