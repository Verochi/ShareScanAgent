package com.anythink.expressad.videocommon.e;

/* loaded from: classes12.dex */
public class d {
    public static final int a = 2;
    private static com.anythink.expressad.foundation.c.c ak = null;
    public static final int b = 4;
    public static final int c = 5;
    public static final int d = 6;
    public static final int e = 7;
    public static final int f = -2;
    public static final int g = 1;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 0;
    public static final int l = -1;
    public static final int m = 5;
    public static final int n = 0;
    public static final int o = 2;
    public static final int p = 2;
    public static final int q = -1;
    public static final int r = -2;

    /* renamed from: s, reason: collision with root package name */
    public static final int f285s = -3;
    public static final int t = 1;
    public static final int u = -1;
    public static final int v = 1;
    public static final int w = 2;
    public static java.lang.String x;
    private java.util.List<com.anythink.expressad.videocommon.c.b> A;
    private long B;
    private java.util.ArrayList<java.lang.Integer> V;
    private int ai;
    private int al;
    private java.lang.String y;
    private java.lang.String z;
    private int C = -1;
    private int D = 0;
    private int E = 0;
    private int F = 1;
    private int G = 1;
    private int H = 1;
    private int I = 1;
    private double J = 1.0d;
    private int K = 2;
    private int L = 5;
    private int M = 1;
    private int N = 3;
    private int O = 80;
    private int P = 100;
    private int Q = 0;
    private double R = 1.0d;
    private int S = -1;
    private int T = 2;
    private double U = 1.0d;
    private int W = 3;
    private int X = 1;
    private int Y = 0;
    private int Z = 10;
    private int aa = 60;
    private java.lang.String ab = "";
    private int ac = 0;
    private int ad = 70;
    private int ae = 0;
    private int af = -1;
    private int ag = -1;
    private int ah = -1;
    private int aj = 20;
    private int am = 0;
    private int an = 1;
    private java.lang.String ao = "";
    private int ap = 1;
    private java.lang.String aq = "";
    private int ar = 1;
    private java.lang.String as = "Virtual Item";
    private int at = 0;
    private int au = 1;
    private int av = 60;

    public static java.lang.String J() {
        return x;
    }

    private java.lang.String W() {
        return this.ab;
    }

    private int X() {
        return this.Z;
    }

    private int Y() {
        return this.aa;
    }

    private java.util.ArrayList<java.lang.Integer> Z() {
        return this.V;
    }

    public static com.anythink.expressad.videocommon.e.d a(org.json.JSONObject jSONObject) {
        com.anythink.expressad.videocommon.e.d dVar;
        int i2;
        com.anythink.expressad.videocommon.e.d dVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            dVar = new com.anythink.expressad.videocommon.e.d();
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        try {
            dVar.A = com.anythink.expressad.videocommon.c.b.a(jSONObject.optJSONArray("adSourceList"));
            dVar.F = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.g);
            int optInt = jSONObject.optInt("aqn", 1);
            if (optInt <= 0) {
                optInt = 1;
            }
            dVar.G = optInt;
            int optInt2 = jSONObject.optInt("acn", 1);
            if (optInt2 < 0) {
                optInt2 = 1;
            }
            dVar.H = optInt2;
            dVar.I = jSONObject.optInt("vcn", 5);
            dVar.J = jSONObject.optDouble("cbp", 1.0d);
            dVar.K = jSONObject.optInt("ttc_type", 2);
            dVar.L = jSONObject.optInt("offset", 5);
            dVar.M = jSONObject.optInt("dlnet", 2);
            dVar.al = jSONObject.optInt("endscreen_type", 2);
            dVar.N = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.J, 3);
            dVar.O = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.K, 80);
            dVar.P = jSONObject.optInt("ready_rate", 100);
            dVar.B = jSONObject.optLong("current_time");
            dVar.ac = jSONObject.optInt("orientation", 0);
            dVar.ae = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.O, 0);
            dVar.af = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.P, -1);
            dVar.ag = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.Q, 2);
            dVar.ah = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.R, -1);
            dVar.ai = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.S, 1);
            dVar.C = jSONObject.optInt("playclosebtn_tm", -1);
            dVar.D = jSONObject.optInt("play_ctdown", 0);
            dVar.E = jSONObject.optInt("close_alert", 0);
            dVar.aj = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.I, 20);
            dVar.S = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.ac, -1);
            dVar.R = jSONObject.optDouble(com.anythink.expressad.videocommon.e.b.aa, 1.0d);
            dVar.T = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.ar, 2);
            dVar.U = jSONObject.optDouble(com.anythink.expressad.videocommon.e.b.as, 1.0d);
            dVar.ad = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.aC, 70);
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray(com.anythink.expressad.videocommon.e.b.ao);
            java.util.ArrayList<java.lang.Integer> arrayList = new java.util.ArrayList<>();
            try {
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList.add(java.lang.Integer.valueOf(optJSONArray.getInt(i3)));
                    }
                } else {
                    arrayList.add(4);
                    arrayList.add(6);
                }
                dVar.V = arrayList;
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
            }
            dVar.W = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.ap, 3);
            int optInt3 = jSONObject.optInt("tmorl", 1);
            if (optInt3 > 2 || optInt3 <= 0) {
                optInt3 = 1;
            }
            dVar.X = optInt3;
            if (dVar.J != 1.0d && new java.util.Random().nextDouble() > dVar.J) {
                i2 = 1;
                dVar.Y = i2;
                dVar.z = jSONObject.optString("placementid");
                dVar.Z = jSONObject.optInt("ltafemty", 10);
                dVar.aa = jSONObject.optInt("ltorwc", 60);
                dVar.ab = jSONObject.optString(com.anythink.expressad.d.a.b.dI);
                dVar.am = jSONObject.optInt("amount_max", 0);
                dVar.an = jSONObject.optInt("callback_rule", 1);
                dVar.ao = jSONObject.optString("virtual_currency", "");
                dVar.i(jSONObject.optInt("amount", 1));
                dVar.aq = jSONObject.optString("icon", "");
                dVar.ar = jSONObject.optInt("currency_id", 1);
                dVar.g(jSONObject.optString("name", "Virtual Item"));
                dVar.au = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.aN, 1);
                dVar.av = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.aO, 60);
                return dVar;
            }
            i2 = 0;
            dVar.Y = i2;
            dVar.z = jSONObject.optString("placementid");
            dVar.Z = jSONObject.optInt("ltafemty", 10);
            dVar.aa = jSONObject.optInt("ltorwc", 60);
            dVar.ab = jSONObject.optString(com.anythink.expressad.d.a.b.dI);
            dVar.am = jSONObject.optInt("amount_max", 0);
            dVar.an = jSONObject.optInt("callback_rule", 1);
            dVar.ao = jSONObject.optString("virtual_currency", "");
            dVar.i(jSONObject.optInt("amount", 1));
            dVar.aq = jSONObject.optString("icon", "");
            dVar.ar = jSONObject.optInt("currency_id", 1);
            dVar.g(jSONObject.optString("name", "Virtual Item"));
            dVar.au = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.aN, 1);
            dVar.av = jSONObject.optInt(com.anythink.expressad.videocommon.e.b.aO, 60);
            return dVar;
        } catch (java.lang.Exception e4) {
            e = e4;
            dVar2 = dVar;
            e.printStackTrace();
            return dVar2;
        }
    }

    private void a(double d2) {
        this.J = d2;
    }

    private void a(long j2) {
        this.B = j2;
    }

    private int aa() {
        return this.ae;
    }

    private int ab() {
        return this.D;
    }

    private int ac() {
        return this.am;
    }

    private int ad() {
        return this.an;
    }

    private java.lang.String ae() {
        return this.ao;
    }

    private java.lang.String af() {
        return this.aq;
    }

    private int ag() {
        return this.ar;
    }

    private int ah() {
        return this.N;
    }

    private int ai() {
        return this.O;
    }

    private int aj() {
        return this.G;
    }

    private int ak() {
        return this.I;
    }

    private double al() {
        return this.J;
    }

    private int am() {
        return this.K;
    }

    private int an() {
        return this.F;
    }

    private long ao() {
        return this.B;
    }

    private java.lang.String ap() {
        return this.y;
    }

    private double aq() {
        return this.R;
    }

    private int ar() {
        return this.W;
    }

    private java.util.Queue<java.lang.Integer> as() {
        java.util.LinkedList linkedList;
        java.lang.Exception e2;
        java.util.List<com.anythink.expressad.videocommon.c.b> list;
        try {
            list = this.A;
        } catch (java.lang.Exception e3) {
            linkedList = null;
            e2 = e3;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        linkedList = new java.util.LinkedList();
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            try {
                linkedList.add(java.lang.Integer.valueOf(this.A.get(i2).a()));
            } catch (java.lang.Exception e4) {
                e2 = e4;
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
                return linkedList;
            }
        }
        return linkedList;
    }

    private int at() {
        return this.at;
    }

    private void b(double d2) {
        this.R = d2;
    }

    private void b(int i2) {
        this.Z = i2;
    }

    public static com.anythink.expressad.videocommon.e.d c(java.lang.String str) {
        org.json.JSONObject optJSONObject;
        int i2;
        if (ak == null) {
            ak = com.anythink.expressad.foundation.c.c.a(com.anythink.core.common.b.o.a().f());
        }
        com.anythink.expressad.videocommon.e.d dVar = null;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                org.json.JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                java.lang.String optString = optJSONObject.optString("unitId");
                if (android.text.TextUtils.isEmpty(optString)) {
                    return null;
                }
                com.anythink.expressad.videocommon.e.d dVar2 = new com.anythink.expressad.videocommon.e.d();
                try {
                    java.util.List<com.anythink.expressad.videocommon.c.b> a2 = com.anythink.expressad.videocommon.c.b.a(optJSONObject.optJSONArray("adSourceList"));
                    dVar2.y = optString;
                    dVar2.A = a2;
                    dVar2.F = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.g);
                    int optInt = optJSONObject.optInt("aqn", 1);
                    if (optInt <= 0) {
                        optInt = 1;
                    }
                    dVar2.G = optInt;
                    int optInt2 = optJSONObject.optInt("acn", 1);
                    if (optInt2 < 0) {
                        optInt2 = 1;
                    }
                    dVar2.H = optInt2;
                    dVar2.I = optJSONObject.optInt("vcn", 5);
                    dVar2.J = optJSONObject.optDouble("cbp", 1.0d);
                    dVar2.K = optJSONObject.optInt("ttc_type", 2);
                    dVar2.L = optJSONObject.optInt("offset", 5);
                    dVar2.M = optJSONObject.optInt("dlnet", 1);
                    dVar2.al = optJSONObject.optInt("endscreen_type", 2);
                    dVar2.N = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.J, 3);
                    dVar2.O = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.K, 80);
                    dVar2.P = optJSONObject.optInt("ready_rate", 100);
                    dVar2.Q = optJSONObject.optInt("cd_rate", 0);
                    dVar2.B = jSONObject.optLong("current_time");
                    dVar2.ac = optJSONObject.optInt("orientation", 0);
                    dVar2.ae = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.O, 0);
                    dVar2.af = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.P, -1);
                    dVar2.ag = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.Q, 2);
                    dVar2.ah = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.R, -1);
                    dVar2.ai = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.S, 1);
                    dVar2.C = optJSONObject.optInt("playclosebtn_tm", -1);
                    dVar2.D = optJSONObject.optInt("play_ctdown", 0);
                    dVar2.E = optJSONObject.optInt("close_alert", 0);
                    dVar2.aj = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.I, 20);
                    dVar2.ad = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.aC, 70);
                    dVar2.S = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.ac, -1);
                    dVar2.R = optJSONObject.optDouble(com.anythink.expressad.videocommon.e.b.aa, 1.0d);
                    dVar2.T = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.ar, 2);
                    dVar2.U = optJSONObject.optDouble(com.anythink.expressad.videocommon.e.b.as, 1.0d);
                    x = optJSONObject.optString("atzu");
                    org.json.JSONArray optJSONArray2 = optJSONObject.optJSONArray(com.anythink.expressad.videocommon.e.b.ao);
                    java.util.ArrayList<java.lang.Integer> arrayList = new java.util.ArrayList<>();
                    try {
                        if (optJSONArray2 != null) {
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                arrayList.add(java.lang.Integer.valueOf(optJSONArray2.getInt(i3)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        dVar2.V = arrayList;
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                    int optInt3 = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.ap, 0);
                    dVar2.W = optInt3 > 0 ? optInt3 : 3;
                    int optInt4 = optJSONObject.optInt("tmorl", 1);
                    if (optInt4 > 2 || optInt4 <= 0) {
                        optInt4 = 1;
                    }
                    dVar2.X = optInt4;
                    if (dVar2.J != 1.0d && new java.util.Random().nextDouble() > dVar2.J) {
                        i2 = 1;
                        dVar2.Y = i2;
                        dVar2.z = optJSONObject.optString("placementid");
                        dVar2.Z = optJSONObject.optInt("ltafemty", 10);
                        dVar2.aa = optJSONObject.optInt("ltorwc", 60);
                        dVar2.ab = optJSONObject.optString(com.anythink.expressad.d.a.b.dI);
                        dVar2.am = optJSONObject.optInt("amount_max", 0);
                        dVar2.an = optJSONObject.optInt("callback_rule", 1);
                        dVar2.ao = optJSONObject.optString("virtual_currency", "");
                        dVar2.i(optJSONObject.optInt("amount", 1));
                        dVar2.aq = optJSONObject.optString("icon", "");
                        dVar2.ar = optJSONObject.optInt("currency_id", 1);
                        dVar2.g(optJSONObject.optString("name", "Virtual Item"));
                        dVar2.au = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.aN, 1);
                        dVar2.av = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.aO, 60);
                        return dVar2;
                    }
                    i2 = 0;
                    dVar2.Y = i2;
                    dVar2.z = optJSONObject.optString("placementid");
                    dVar2.Z = optJSONObject.optInt("ltafemty", 10);
                    dVar2.aa = optJSONObject.optInt("ltorwc", 60);
                    dVar2.ab = optJSONObject.optString(com.anythink.expressad.d.a.b.dI);
                    dVar2.am = optJSONObject.optInt("amount_max", 0);
                    dVar2.an = optJSONObject.optInt("callback_rule", 1);
                    dVar2.ao = optJSONObject.optString("virtual_currency", "");
                    dVar2.i(optJSONObject.optInt("amount", 1));
                    dVar2.aq = optJSONObject.optString("icon", "");
                    dVar2.ar = optJSONObject.optInt("currency_id", 1);
                    dVar2.g(optJSONObject.optString("name", "Virtual Item"));
                    dVar2.au = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.aN, 1);
                    dVar2.av = optJSONObject.optInt(com.anythink.expressad.videocommon.e.b.aO, 60);
                    return dVar2;
                } catch (java.lang.Exception e3) {
                    e = e3;
                    dVar = dVar2;
                    e.printStackTrace();
                    return dVar;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
            }
        }
        return dVar;
    }

    private void c(double d2) {
        this.U = d2;
    }

    private void c(int i2) {
        this.aa = i2;
    }

    private void d(int i2) {
        this.Y = i2;
    }

    private void d(java.lang.String str) {
        this.ab = str;
    }

    private void e(int i2) {
        this.C = i2;
    }

    private void e(java.lang.String str) {
        this.ao = str;
    }

    private void f(int i2) {
        this.D = i2;
    }

    private void f(java.lang.String str) {
        this.aq = str;
    }

    private void g(int i2) {
        this.am = i2;
    }

    private void g(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            this.as = this.ao;
        } else {
            this.as = str;
        }
    }

    private void h(int i2) {
        this.an = i2;
    }

    private static void h(java.lang.String str) {
        x = str;
    }

    private void i(int i2) {
        if (i2 <= 0) {
            this.ap = 1;
        } else {
            this.ap = i2;
        }
    }

    private void j(int i2) {
        this.ar = i2;
    }

    private void k(int i2) {
        this.aj = i2;
    }

    private void l(int i2) {
        this.K = i2;
    }

    private int m(int i2) {
        int i3 = this.S;
        if (i3 == -1) {
            if (i2 == 94) {
                return 2;
            }
            if (i2 == 287) {
                return 3;
            }
        }
        return i3;
    }

    private void n(int i2) {
        this.T = i2;
    }

    private boolean o(int i2) {
        java.util.ArrayList<java.lang.Integer> arrayList = this.V;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.V.contains(java.lang.Integer.valueOf(i2));
    }

    private void p(int i2) {
        this.S = i2;
    }

    private void q(int i2) {
        this.at = i2;
    }

    private void r(int i2) {
        this.au = i2;
    }

    private void s(int i2) {
        this.av = i2;
    }

    public final int A() {
        return this.H;
    }

    public final void B() {
        this.H = 1;
    }

    public final void C() {
        this.I = 1;
    }

    public final int D() {
        return this.L;
    }

    public final void E() {
        this.L = 1;
    }

    public final int F() {
        return this.M;
    }

    public final void G() {
        this.M = 1;
    }

    public final void H() {
        this.F = 1;
    }

    public final java.util.List<com.anythink.expressad.videocommon.c.b> I() {
        return this.A;
    }

    public final int K() {
        return this.T;
    }

    public final double L() {
        return this.U;
    }

    public final int M() {
        return this.X;
    }

    public final void N() {
        this.X = 1;
    }

    public final java.lang.String O() {
        return this.z;
    }

    public final void P() {
        this.W = 3;
    }

    public final java.util.Queue<java.lang.Integer> Q() {
        java.util.LinkedList linkedList;
        java.lang.Exception e2;
        java.util.List<com.anythink.expressad.videocommon.c.b> list;
        try {
            list = this.A;
        } catch (java.lang.Exception e3) {
            linkedList = null;
            e2 = e3;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        linkedList = new java.util.LinkedList();
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            try {
                linkedList.add(java.lang.Integer.valueOf(this.A.get(i2).b()));
            } catch (java.lang.Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                return linkedList;
            }
        }
        return linkedList;
    }

    public final org.json.JSONObject R() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("unitId", this.y);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.g, this.F);
            java.util.List<com.anythink.expressad.videocommon.c.b> list = this.A;
            if (list != null && list.size() > 0) {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                for (com.anythink.expressad.videocommon.c.b bVar : this.A) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.G);
            jSONObject.put("acn", this.H);
            jSONObject.put("vcn", this.I);
            jSONObject.put("cbp", this.J);
            jSONObject.put("ttc_type", this.K);
            jSONObject.put("offset", this.L);
            jSONObject.put("dlnet", this.M);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.J, this.N);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.K, this.O);
            jSONObject.put("ready_rate", this.P);
            jSONObject.put("endscreen_type", this.al);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.O, this.ae);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.P, this.af);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.Q, this.ag);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.R, this.ah);
            jSONObject.put("orientation", this.ac);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.S, this.ai);
            jSONObject.put("playclosebtn_tm", this.C);
            jSONObject.put("play_ctdown", this.D);
            jSONObject.put("close_alert", this.E);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.ac, this.S);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.aa, this.R);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.ar, this.T);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.as, this.U);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            java.util.ArrayList<java.lang.Integer> arrayList = this.V;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    java.util.Iterator<java.lang.Integer> it = this.V.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put(com.anythink.expressad.videocommon.e.b.ao, jSONArray2);
            }
            jSONObject.put(com.anythink.expressad.videocommon.e.b.ap, this.W);
            jSONObject.put("tmorl", this.X);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.ax, this.Y);
            jSONObject.put("placementid", this.z);
            jSONObject.put("ltafemty", this.Z);
            jSONObject.put("ltorwc", this.aa);
            jSONObject.put("amount_max", this.am);
            jSONObject.put("callback_rule", this.an);
            jSONObject.put("virtual_currency", this.ao);
            jSONObject.put("amount", this.ap);
            jSONObject.put("icon", this.aq);
            jSONObject.put("currency_id", this.ar);
            jSONObject.put("name", this.as);
            jSONObject.put("isDefault", this.at);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.aN, this.au);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.aO, this.av);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final int S() {
        return this.ad;
    }

    public final void T() {
        this.ad = 70;
    }

    public final int U() {
        return this.au;
    }

    public final int V() {
        return this.av;
    }

    public final int a() {
        return this.Y;
    }

    public final void a(int i2) {
        this.af = i2;
    }

    public final void a(java.lang.String str) {
        this.y = str;
    }

    public final void a(java.util.ArrayList<java.lang.Integer> arrayList) {
        this.V = arrayList;
    }

    public final void a(java.util.List<com.anythink.expressad.videocommon.c.b> list) {
        this.A = list;
    }

    public final int b() {
        return this.ac;
    }

    public final void b(java.lang.String str) {
        this.z = str;
    }

    public final void c() {
        this.ac = 0;
    }

    public final void d() {
        this.ae = 0;
    }

    public final int e() {
        return this.af;
    }

    public final int f() {
        return this.ag;
    }

    public final void g() {
        this.ag = 2;
    }

    public final int h() {
        return this.ah;
    }

    public final void i() {
        this.ah = -1;
    }

    public final int j() {
        return this.C;
    }

    public final int k() {
        return this.E;
    }

    public final void l() {
        this.E = 1;
    }

    public final int m() {
        return this.ap;
    }

    public final java.lang.String n() {
        return this.as;
    }

    public final int o() {
        return this.aj;
    }

    public final int p() {
        return this.ai;
    }

    public final void q() {
        this.ai = 1;
    }

    public final int r() {
        return this.al;
    }

    public final void s() {
        this.al = 2;
    }

    public final void t() {
        this.N = 3;
    }

    public final void u() {
        this.O = 80;
    }

    public final int v() {
        return this.P;
    }

    public final void w() {
        this.P = 100;
    }

    public final int x() {
        return this.Q;
    }

    public final void y() {
        this.Q = 0;
    }

    public final void z() {
        this.G = 1;
    }
}
