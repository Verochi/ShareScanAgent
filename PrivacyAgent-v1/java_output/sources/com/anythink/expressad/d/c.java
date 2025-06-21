package com.anythink.expressad.d;

/* loaded from: classes12.dex */
public final class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 3;
    private java.lang.String A;
    private int B;
    private long C;
    private long D;
    private int F;
    private int G;
    private int H;
    private int N;
    private int P;
    private int Q;
    private int e;
    private int f;
    private int g;
    private java.lang.String i;
    private java.lang.String j;
    private java.util.List<java.lang.Integer> k;
    private long l;
    private int n;
    private java.util.List<java.lang.Integer> o;
    private int p;
    private int q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f201s;
    private java.lang.String t;
    private int u;
    private int x;
    private int y;
    private long z;
    private int h = 30;
    private int m = 1;
    private int v = 1;
    private int w = 5000;
    private int E = 60;
    private java.lang.String I = "";
    private int J = 10;
    private int K = 60;
    private double L = 1.0d;
    private int M = 1;
    private int O = 0;

    private int A() {
        return this.H;
    }

    private int B() {
        return this.M;
    }

    private int C() {
        return this.Q;
    }

    private java.lang.String D() {
        return this.t;
    }

    private int E() {
        return this.u;
    }

    private int F() {
        return this.P;
    }

    private long G() {
        return this.C;
    }

    private long H() {
        return this.D;
    }

    private java.lang.String I() {
        return this.A;
    }

    private int J() {
        return this.B;
    }

    private int K() {
        return this.e;
    }

    private int L() {
        return this.f;
    }

    private int M() {
        return this.g;
    }

    private int N() {
        int i = this.h;
        if (i <= 0 || i > 100) {
            this.h = 30;
        }
        return this.h;
    }

    private static com.anythink.expressad.d.c O() {
        return new com.anythink.expressad.d.c();
    }

    private int P() {
        return this.f201s;
    }

    private int Q() {
        return this.v;
    }

    private int R() {
        return this.w;
    }

    private int S() {
        return this.p;
    }

    private int T() {
        return this.q;
    }

    private int U() {
        return this.r;
    }

    private java.lang.String V() {
        return this.i;
    }

    private java.util.List<java.lang.Integer> W() {
        return this.k;
    }

    private java.util.List<java.lang.Integer> X() {
        return this.o;
    }

    private long Y() {
        return this.l;
    }

    private int Z() {
        return this.n;
    }

    private void a(double d2) {
        this.L = d2;
    }

    private void a(long j) {
        this.C = j;
    }

    private java.lang.String aa() {
        return this.I;
    }

    private int ab() {
        return this.J;
    }

    private int ac() {
        return this.K;
    }

    public static com.anythink.expressad.d.c b(java.lang.String str) {
        com.anythink.expressad.d.c cVar = null;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            com.anythink.expressad.d.c cVar2 = new com.anythink.expressad.d.c();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                cVar2.i = jSONObject.optString("unitId");
                org.json.JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(java.lang.Integer.valueOf(optJSONArray.optInt(i)));
                    }
                    cVar2.k = arrayList;
                }
                org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList2.add(java.lang.Integer.valueOf(optJSONArray2.optInt(i2)));
                    }
                    cVar2.o = arrayList2;
                }
                cVar2.p = jSONObject.optInt(com.anythink.expressad.d.a.b.J);
                cVar2.q = jSONObject.optInt("aqn");
                cVar2.r = jSONObject.optInt("acn");
                cVar2.f201s = jSONObject.optInt(com.anythink.expressad.d.a.b.R);
                int i3 = 1;
                cVar2.v = jSONObject.optInt(com.anythink.expressad.d.a.b.S, 1);
                cVar2.w = jSONObject.optInt(com.anythink.expressad.d.a.b.T, 5000);
                cVar2.l = jSONObject.optLong("current_time");
                cVar2.m = jSONObject.optInt("offset");
                cVar2.z = jSONObject.optLong("dlct", com.anythink.expressad.d.a.b.P);
                cVar2.x = jSONObject.optInt(com.anythink.expressad.d.a.b.aX, 0);
                cVar2.y = jSONObject.optInt("dlnet", 2);
                cVar2.A = jSONObject.optString(com.anythink.expressad.d.a.b.aL);
                cVar2.B = jSONObject.optInt(com.anythink.expressad.d.a.b.aM);
                cVar2.C = jSONObject.optLong(com.anythink.expressad.d.a.b.aN, com.anythink.expressad.d.a.b.aT);
                cVar2.D = jSONObject.optLong(com.anythink.expressad.d.a.b.aO, 300L);
                cVar2.c(jSONObject.optInt("ready_rate", 100));
                cVar2.d(jSONObject.optInt("cd_rate", 0));
                cVar2.P = jSONObject.optInt("content", 1);
                cVar2.Q = jSONObject.optInt(com.anythink.expressad.d.a.b.bC, 0);
                cVar2.u = jSONObject.optInt(com.anythink.expressad.d.a.b.cf, 1);
                cVar2.t = jSONObject.optString(com.anythink.expressad.d.a.b.cd, "");
                cVar2.e = jSONObject.optInt("playclosebtn_tm", -1);
                cVar2.f = jSONObject.optInt("play_ctdown", 0);
                cVar2.g = jSONObject.optInt("close_alert", 0);
                cVar2.h = jSONObject.optInt(com.anythink.expressad.d.a.b.cr, 30);
                cVar2.E = jSONObject.optInt(com.anythink.expressad.d.a.b.db, 60);
                cVar2.F = jSONObject.optInt(com.anythink.expressad.d.a.b.dd, 0);
                int optInt = jSONObject.optInt("tmorl", 1);
                if (optInt <= 2 && optInt > 0) {
                    i3 = optInt;
                }
                cVar2.M = i3;
                cVar2.I = jSONObject.optString("placementid", "");
                cVar2.J = jSONObject.optInt("ltafemty", 10);
                cVar2.K = jSONObject.optInt("ltorwc", 60);
                return cVar2;
            } catch (java.lang.Exception e) {
                e = e;
                cVar = cVar2;
                e.printStackTrace();
                return cVar;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    private void b(long j) {
        this.D = j;
    }

    public static com.anythink.expressad.d.c c(java.lang.String str) {
        com.anythink.expressad.d.c cVar = new com.anythink.expressad.d.c();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(1);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        cVar.m = 1;
        cVar.i = str;
        cVar.k = arrayList;
        cVar.o = arrayList2;
        cVar.p = 1;
        cVar.r = -2;
        cVar.q = -2;
        cVar.f201s = 5;
        cVar.z = com.anythink.expressad.d.a.b.P;
        cVar.y = 2;
        cVar.x = 1;
        cVar.c(100);
        cVar.d(0);
        cVar.P = 1;
        cVar.Q = 0;
        cVar.E = 60;
        cVar.J = 10;
        cVar.K = 60;
        return cVar;
    }

    private static java.util.Queue<java.lang.Integer> c(java.util.List<java.lang.Integer> list) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (java.lang.Integer num : list) {
                        if (num != null) {
                            linkedList.add(num);
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return linkedList;
    }

    private void c(long j) {
        this.l = j;
    }

    public static com.anythink.expressad.d.c d(java.lang.String str) {
        com.anythink.expressad.d.c cVar = new com.anythink.expressad.d.c();
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(1);
            cVar.k = arrayList;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            arrayList2.add(30);
            cVar.o = arrayList2;
            cVar.i = str;
            cVar.m = 1;
            cVar.p = 1;
            cVar.r = -2;
            cVar.q = -2;
            cVar.f201s = 5;
            cVar.z = com.anythink.expressad.d.a.b.P;
            cVar.y = 2;
            cVar.x = 3;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }

    private java.util.Queue<java.lang.Integer> d(java.util.List<java.lang.Integer> list) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        try {
            java.util.List<java.lang.Integer> list2 = this.k;
            if (list2 != null && list2.size() > 0) {
                for (java.lang.Integer num : list) {
                    if (num != null) {
                        linkedList.add(java.lang.Integer.valueOf(num.intValue() * 1000));
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return linkedList;
    }

    private void e(int i) {
        this.M = i;
    }

    private void f(int i) {
        this.F = i;
    }

    private void f(java.lang.String str) {
        this.t = str;
    }

    private void g(int i) {
        this.u = i;
    }

    private void g(java.lang.String str) {
        this.A = str;
    }

    private void h(int i) {
        this.B = i;
    }

    private void i(int i) {
        this.e = i;
    }

    private void j(int i) {
        this.f = i;
    }

    private void k(int i) {
        this.g = i;
    }

    private void l(int i) {
        this.h = i;
    }

    private void m(int i) {
        this.v = i;
    }

    private void n(int i) {
        this.w = i;
    }

    public static com.anythink.expressad.d.c y() {
        com.anythink.expressad.d.c cVar = new com.anythink.expressad.d.c();
        cVar.x = 0;
        return cVar;
    }

    private int z() {
        return this.G;
    }

    public final double a() {
        return this.L;
    }

    public final void a(int i) {
        this.G = i;
    }

    public final void a(java.lang.String str) {
        this.i = str;
    }

    public final void a(java.util.List<java.lang.Integer> list) {
        this.k = list;
    }

    public final int b() {
        return this.E;
    }

    public final void b(int i) {
        this.H = i;
    }

    public final void b(java.util.List<java.lang.Integer> list) {
        this.o = list;
    }

    public final void c() {
        this.E = 60;
    }

    public final void c(int i) {
        try {
            this.N = i;
        } catch (java.lang.Exception unused) {
            this.N = 100;
        }
    }

    public final int d() {
        return this.F;
    }

    public final void d(int i) {
        try {
            this.O = i;
        } catch (java.lang.Exception unused) {
            this.O = 0;
        }
    }

    public final void e() {
        this.Q = 0;
    }

    public final void e(java.lang.String str) {
        this.I = str;
    }

    public final int f() {
        return this.N;
    }

    public final int g() {
        return this.O;
    }

    public final void h() {
        this.P = 1;
    }

    public final long i() {
        return this.z;
    }

    public final void j() {
        this.y = 2;
    }

    public final int k() {
        return this.x;
    }

    public final void l() {
        this.x = 1;
    }

    public final int m() {
        return this.y;
    }

    public final void n() {
        this.z = com.anythink.expressad.d.a.b.P;
    }

    public final void o() {
        this.f201s = 5;
    }

    public final void p() {
        this.p = 1;
    }

    public final void q() {
        this.q = -2;
    }

    public final void r() {
        this.r = -2;
    }

    public final org.json.JSONObject s() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.util.List<java.lang.Integer> list = this.k;
            if (list != null && list.size() > 0) {
                int size = this.k.size();
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.k.get(i));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            java.util.List<java.lang.Integer> list2 = this.o;
            if (list2 != null && list2.size() > 0) {
                int size2 = this.o.size();
                org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                for (int i2 = 0; i2 < size2; i2++) {
                    jSONArray2.put(this.o.get(i2));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put(com.anythink.expressad.d.a.b.J, this.p);
            jSONObject.put("aqn", this.q);
            jSONObject.put("acn", this.r);
            jSONObject.put(com.anythink.expressad.d.a.b.R, this.f201s);
            jSONObject.put("current_time", this.l);
            jSONObject.put("offset", this.m);
            jSONObject.put("dlct", this.z);
            jSONObject.put(com.anythink.expressad.d.a.b.aX, this.x);
            jSONObject.put("dlnet", this.y);
            jSONObject.put(com.anythink.expressad.d.a.b.aL, this.A);
            jSONObject.put(com.anythink.expressad.d.a.b.aM, this.B);
            jSONObject.put(com.anythink.expressad.d.a.b.aN, this.C);
            jSONObject.put(com.anythink.expressad.d.a.b.aO, this.D);
            jSONObject.put("ready_rate", this.N);
            jSONObject.put("content", this.P);
            jSONObject.put(com.anythink.expressad.d.a.b.bC, this.Q);
            jSONObject.put(com.anythink.expressad.d.a.b.cf, this.u);
            jSONObject.put(com.anythink.expressad.d.a.b.cd, this.t);
            jSONObject.put("playclosebtn_tm", this.e);
            jSONObject.put("play_ctdown", this.f);
            jSONObject.put("close_alert", this.g);
            jSONObject.put(com.anythink.expressad.d.a.b.dd, this.F);
            jSONObject.put(com.anythink.expressad.d.a.b.db, this.E);
            jSONObject.put(com.anythink.expressad.d.a.b.dk, this.H);
            jSONObject.put(com.anythink.expressad.d.a.b.dm, this.G);
            jSONObject.put("tmorl", this.M);
            jSONObject.put("unitId", this.i);
            jSONObject.put("placementid", this.I);
            jSONObject.put("ltafemty", this.J);
            jSONObject.put("ltorwc", this.K);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final int t() {
        return this.m;
    }

    public final java.lang.String toString() {
        java.util.List<java.lang.Integer> list = this.k;
        java.lang.String str = "";
        if (list != null && list.size() > 0) {
            java.util.Iterator<java.lang.Integer> it = this.k.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
        }
        return "offset = " + this.m + " unitId = " + this.i + " fbPlacementId = " + this.j + str;
    }

    public final void u() {
        this.m = 1;
    }

    public final void v() {
        this.n = 2;
    }

    public final void w() {
        this.J = 10;
    }

    public final void x() {
        this.K = 60;
    }
}
