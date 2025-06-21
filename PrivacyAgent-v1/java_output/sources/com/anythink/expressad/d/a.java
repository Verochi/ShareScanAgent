package com.anythink.expressad.d;

/* loaded from: classes12.dex */
public final class a {
    private int A;
    private java.lang.String B;
    private long C;
    private int D;
    private long E;
    private long F;
    private int G;
    private int H;
    private int I;
    private java.lang.String J;
    private java.lang.String K;
    private int L;
    private java.util.List<com.anythink.expressad.foundation.d.c> M;
    private java.util.List<com.anythink.expressad.foundation.d.b> N;
    private int R;
    private java.util.LinkedList<java.lang.String> S;
    private int Y;
    private java.util.List<java.lang.String> Z;
    private int aE;
    private long aG;
    private long aH;
    private int aI;
    private int aJ;
    private long aK;
    private int aM;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private java.lang.String ae;
    private java.lang.String af;
    private java.lang.String ao;
    private java.lang.String b;
    private java.util.Map<java.lang.String, com.anythink.expressad.d.a.C0182a> be;
    private com.anythink.expressad.d.a.b bg;
    private java.lang.String bl;
    private java.lang.String bm;
    private long c;
    private int d;
    private int f;
    private boolean g;
    private java.util.Map<java.lang.String, java.lang.String> h;
    private boolean i;
    private long j;
    private java.util.List<com.anythink.expressad.d.c> l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private boolean q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f198s;
    private int t;
    private long u;
    private java.util.List<java.lang.String> v;
    private int w;
    private int x;
    private int y;
    private int z;
    private int a = 0;
    private long e = com.anythink.expressad.d.a.b.aT;
    private java.lang.String k = "";
    private boolean O = false;
    private int P = 3;
    private boolean Q = true;
    private int T = 0;
    private int U = com.anythink.expressad.d.a.b.ck;
    private int V = 10;
    private int W = 120;
    private java.lang.String X = "";
    private int ag = 1;
    private int ah = 1;
    private int ai = 1;
    private int aj = 0;
    private int ak = 1;
    private java.lang.String al = "";
    private int am = 0;
    private int an = 2;
    private int ap = 86400;
    private java.lang.String aq = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKAJ7eXHM==";
    private java.lang.String ar = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKsYFh=";
    private int as = 1;
    private int at = 30;
    private int au = 5;
    private int av = 0;
    private int aw = 0;
    private int ax = 9377;
    private int ay = 0;
    private int az = 0;
    private int aA = 0;
    private int aB = 2;
    private int aC = 10;
    private java.util.List<java.lang.Integer> aD = new java.util.ArrayList();
    private int aF = 1;
    private int aL = 3;
    private java.lang.String aN = "";
    private java.lang.String aO = "";
    private java.lang.String aP = "";
    private java.lang.String aQ = "";
    private java.lang.String aR = "";
    private int aS = 0;
    private int aT = 21600;
    private int aU = 2;
    private int aV = 0;
    private int aW = 0;
    private int aX = 604800;
    private int aY = 0;
    private java.lang.String aZ = "";
    private java.lang.String ba = "";
    private java.lang.String bb = "";
    private java.lang.String bc = "";
    private java.lang.String bd = "";
    private int bf = 0;
    private int bh = 0;
    private java.lang.String bi = "";
    private int bj = 2;
    private int bk = 7200;
    private int bn = 0;
    private boolean bo = false;
    private int bp = 1;
    private int bq = 0;
    private int br = 0;
    private int bs = 0;
    private int bt = 3;
    private int bu = 600;
    private int bv = 10;

    /* renamed from: com.anythink.expressad.d.a$a, reason: collision with other inner class name */
    public static class C0182a {
        private java.util.List<java.lang.String> a;
        private java.util.List<java.lang.String> b;
        private java.util.List<java.lang.String> c;
        private java.util.List<java.lang.String> d;

        private java.util.List<java.lang.String> a() {
            return this.a;
        }

        private void a(java.util.List<java.lang.String> list) {
            this.a = list;
        }

        private java.util.List<java.lang.String> b() {
            return this.b;
        }

        private void b(java.util.List<java.lang.String> list) {
            this.b = list;
        }

        private java.util.List<java.lang.String> c() {
            return this.c;
        }

        private void c(java.util.List<java.lang.String> list) {
            this.c = list;
        }

        private java.util.List<java.lang.String> d() {
            return this.d;
        }

        private void d(java.util.List<java.lang.String> list) {
            this.d = list;
        }

        public final void a(org.json.JSONObject jSONObject) {
            try {
                org.json.JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.a = com.anythink.expressad.foundation.h.h.a(optJSONArray);
                }
                org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.b = com.anythink.expressad.foundation.h.h.a(optJSONArray2);
                }
                org.json.JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.c = com.anythink.expressad.foundation.h.h.a(optJSONArray3);
                }
                org.json.JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.d = com.anythink.expressad.foundation.h.h.a(optJSONArray4);
                }
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class b {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private org.json.JSONArray d;

        public static com.anythink.expressad.d.a.b a(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new org.json.JSONObject();
            }
            com.anythink.expressad.d.a.b bVar = new com.anythink.expressad.d.a.b();
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            bVar.a = jSONObject.optString("title", f.getString(com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_dialog_title", com.anythink.expressad.foundation.h.i.g)));
            bVar.b = jSONObject.optString(com.anythink.expressad.d.a.b.dO, f.getString(com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_dialog_close_close", com.anythink.expressad.foundation.h.i.g)));
            bVar.c = jSONObject.optString(com.anythink.expressad.d.a.b.dP, f.getString(com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_dialog_close_submit", com.anythink.expressad.foundation.h.i.g)));
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("content");
            bVar.d = optJSONArray;
            if (optJSONArray == null) {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                bVar.d = jSONArray;
                jSONArray.put(f.getString(com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_dialog_content_stuck", com.anythink.expressad.foundation.h.i.g)));
                bVar.d.put(f.getString(com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_dialog_content_cnr", com.anythink.expressad.foundation.h.i.g)));
                bVar.d.put(f.getString(com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_dialog_content_balck_screen", com.anythink.expressad.foundation.h.i.g)));
                bVar.d.put(f.getString(com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_dialog_content_other", com.anythink.expressad.foundation.h.i.g)));
            }
            return bVar;
        }

        private void a(java.lang.String str) {
            this.a = str;
        }

        private void a(org.json.JSONArray jSONArray) {
            this.d = jSONArray;
        }

        private void b(java.lang.String str) {
            this.b = str;
        }

        private void c(java.lang.String str) {
            this.c = str;
        }

        public final java.lang.String a() {
            return this.a;
        }

        public final java.lang.String b() {
            return this.b;
        }

        public final java.lang.String c() {
            return this.c;
        }

        public final org.json.JSONArray d() {
            return this.d;
        }
    }

    private void A(int i) {
        this.t = i;
    }

    private void A(java.lang.String str) {
        this.bm = str;
    }

    private void B(int i) {
        this.A = i;
    }

    private void C(int i) {
        this.x = i;
    }

    private void D(int i) {
        this.y = i;
    }

    private void E(int i) {
        this.z = i;
    }

    private void F(int i) {
        this.aL = i;
    }

    private void G(int i) {
        this.aI = i;
    }

    private void H(int i) {
        this.aJ = i;
    }

    private void I(int i) {
        this.f = i;
    }

    private void J(int i) {
        this.r = i;
    }

    private void K(int i) {
        this.f198s = i;
    }

    private void L(int i) {
        this.aY = i;
    }

    private void M(int i) {
        this.aS = i;
    }

    private void N(int i) {
        this.aT = i;
    }

    private void O(int i) {
        this.aU = i;
    }

    private void P(int i) {
        this.aV = i;
    }

    private void Q(int i) {
        this.aW = i;
    }

    private void R(int i) {
        this.aX = i;
    }

    private void S(int i) {
        this.at = i;
    }

    private void T(int i) {
        this.au = i;
    }

    private void U(int i) {
        this.av = i;
    }

    private void V(int i) {
        this.aw = i;
    }

    private void W(int i) {
        this.ax = i;
    }

    private int X() {
        return this.R;
    }

    private void X(int i) {
        this.P = i;
    }

    private java.util.List<com.anythink.expressad.foundation.d.b> Y() {
        return this.N;
    }

    private void Y(int i) {
        this.bf = i;
    }

    private java.lang.String Z() {
        return this.X;
    }

    private void Z(int i) {
        this.bh = i;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        com.anythink.expressad.d.a b2;
        java.lang.String str2 = "";
        try {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.foundation.b.a.b().e();
            b2 = com.anythink.expressad.d.b.b();
        } catch (java.lang.Throwable unused) {
        }
        if (b2 != null && b2.h != null) {
            java.lang.String host = android.net.Uri.parse(str).getHost();
            java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = b2.h.entrySet().iterator();
            while (it.hasNext()) {
                java.lang.String key = it.next().getKey();
                if (!android.text.TextUtils.isEmpty(host) && host.contains(key)) {
                    java.lang.String str3 = b2.h.get(key);
                    if (android.text.TextUtils.isEmpty(str3)) {
                        return "";
                    }
                    java.lang.String replace = str3.replace("{gaid}", com.anythink.core.common.o.e.f());
                    if (replace.contains(com.anythink.expressad.d.a.b.I)) {
                        if (com.anythink.core.common.o.e.d(context) != null) {
                            str2 = replace.replace(com.anythink.expressad.d.a.b.I, com.anythink.core.common.o.e.d(context));
                        }
                        str2 = replace;
                    } else {
                        if (replace.contains(com.anythink.expressad.d.a.b.H) && com.anythink.core.common.o.e.e(context) != null) {
                            str2 = replace.replace(com.anythink.expressad.d.a.b.H, com.anythink.core.common.o.e.e(context));
                        }
                        str2 = replace;
                    }
                    return str2;
                }
            }
        }
        return str2;
    }

    private void a(long j) {
        this.E = j;
    }

    private void a(com.anythink.expressad.d.a.b bVar) {
        this.bg = bVar;
    }

    private void a(java.util.LinkedList<java.lang.String> linkedList) {
        this.S = linkedList;
    }

    private void a(java.util.List<com.anythink.expressad.foundation.d.b> list) {
        this.N = list;
    }

    private void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.h = map;
    }

    private void a(boolean z) {
        this.g = z;
    }

    private int aA() {
        return this.aE;
    }

    private int aB() {
        return this.Y;
    }

    private java.util.List<java.lang.String> aC() {
        return this.Z;
    }

    private int aD() {
        return this.aa;
    }

    private int aE() {
        return this.ab;
    }

    private int aF() {
        return this.ac;
    }

    private int aG() {
        return this.ad;
    }

    private java.lang.String aH() {
        return this.ae;
    }

    private int aI() {
        return this.G;
    }

    private int aJ() {
        return this.H;
    }

    private java.util.List<com.anythink.expressad.foundation.d.c> aK() {
        return this.M;
    }

    private int aL() {
        return this.I;
    }

    private java.lang.String aM() {
        return this.J;
    }

    private int aN() {
        return this.D;
    }

    private long aO() {
        return this.E;
    }

    private long aP() {
        return this.F;
    }

    private long aQ() {
        return this.C * 1000;
    }

    private int aR() {
        return this.t;
    }

    private java.lang.String aS() {
        return this.B;
    }

    private int aT() {
        return this.x;
    }

    private int aU() {
        return this.y;
    }

    private int aV() {
        return this.z;
    }

    private int aW() {
        return this.aL;
    }

    private long aX() {
        return this.aK;
    }

    private int aY() {
        return this.aI;
    }

    private int aZ() {
        return this.aJ;
    }

    private int aa() {
        return this.V;
    }

    private void aa(int i) {
        this.bj = i;
    }

    private java.util.LinkedList<java.lang.String> ab() {
        return this.S;
    }

    private void ab(int i) {
        this.bk = i;
    }

    private int ac() {
        return this.a;
    }

    private void ac(int i) {
        this.bp = i;
    }

    private int ad() {
        return this.T;
    }

    private void ad(int i) {
        this.br = i;
    }

    private int ae() {
        return this.U * 1000;
    }

    private void ae(int i) {
        this.bs = i;
    }

    private int af() {
        return this.aC;
    }

    private void af(int i) {
        this.bt = i;
    }

    private int ag() {
        return this.ay;
    }

    private void ag(int i) {
        this.bu = i;
    }

    private int ah() {
        return this.az;
    }

    private void ah(int i) {
        this.bv = i;
    }

    private int ai() {
        return this.aA;
    }

    private int aj() {
        return this.aB;
    }

    private int ak() {
        return this.as;
    }

    private java.lang.String al() {
        return this.aq;
    }

    private java.lang.String am() {
        return this.ar;
    }

    private int an() {
        return this.ap;
    }

    private int ao() {
        return this.an;
    }

    private java.lang.String ap() {
        return this.ao;
    }

    private int aq() {
        return this.ag;
    }

    private int ar() {
        return this.ah;
    }

    private int as() {
        return this.ai;
    }

    private int at() {
        return this.aj;
    }

    private int au() {
        return this.ak;
    }

    private java.lang.String av() {
        return this.al;
    }

    private int aw() {
        return this.am;
    }

    private int ax() {
        return this.L;
    }

    private java.lang.String ay() {
        return this.K;
    }

    private int az() {
        return this.aF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.anythink.expressad.d.a b(java.lang.String str) {
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2 = null;
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                com.anythink.expressad.d.a aVar = new com.anythink.expressad.d.a();
                try {
                    aVar.b = jSONObject.optString("cc");
                    aVar.K = jSONObject.optString(com.anythink.expressad.d.a.b.j, "anythink");
                    aVar.c = jSONObject.optLong(com.anythink.expressad.d.a.b.l);
                    aVar.d = jSONObject.optInt(com.anythink.expressad.d.a.b.m);
                    aVar.e = jSONObject.optLong("getpf");
                    aVar.f = jSONObject.optInt(com.anythink.expressad.d.a.b.p);
                    aVar.g = jSONObject.optBoolean(com.anythink.expressad.d.a.b.w);
                    aVar.j = jSONObject.optLong("current_time");
                    aVar.i = jSONObject.optBoolean(com.anythink.expressad.d.a.b.o);
                    aVar.o = jSONObject.optLong(com.anythink.expressad.d.a.b.B);
                    aVar.n = jSONObject.optLong("plct") == 0 ? com.anythink.expressad.d.a.b.P : jSONObject.optLong("plct");
                    aVar.m = jSONObject.optBoolean(com.anythink.expressad.d.a.b.C);
                    aVar.p = jSONObject.optLong(com.anythink.expressad.d.a.b.F);
                    aVar.q = jSONObject.optBoolean(com.anythink.expressad.d.a.b.G);
                    aVar.r = jSONObject.optInt(com.anythink.expressad.d.a.b.X);
                    aVar.f198s = jSONObject.optInt(com.anythink.expressad.d.a.b.Y);
                    aVar.L = jSONObject.optInt(com.anythink.expressad.d.a.b.k);
                    aVar.t = jSONObject.optInt(com.anythink.expressad.d.a.b.Z, 1800);
                    aVar.x = jSONObject.optInt(com.anythink.expressad.d.a.b.aa);
                    aVar.u = jSONObject.optLong("plctb") == 0 ? com.anythink.expressad.d.a.b.Q : jSONObject.optLong("plctb");
                    aVar.aI = jSONObject.optInt(com.anythink.expressad.d.a.b.ad);
                    aVar.aJ = jSONObject.optInt(com.anythink.expressad.d.a.b.ae);
                    aVar.x = jSONObject.optInt(com.anythink.expressad.d.a.b.aa, 100);
                    aVar.y = jSONObject.optInt(com.anythink.expressad.d.a.b.af, 2);
                    aVar.z = jSONObject.optInt(com.anythink.expressad.d.a.b.ag, 2);
                    boolean z = true;
                    aVar.A = jSONObject.optInt(com.anythink.expressad.d.a.b.ah, 1);
                    aVar.aK = jSONObject.optLong(com.anythink.expressad.d.a.b.ai, com.anythink.expressad.d.a.b.aC);
                    aVar.B = jSONObject.optString(com.anythink.expressad.d.a.b.aj);
                    aVar.C = jSONObject.optLong(com.anythink.expressad.d.a.b.ak, com.anythink.expressad.d.a.b.aD);
                    aVar.D = jSONObject.optInt(com.anythink.expressad.d.a.b.aE, 1);
                    aVar.E = jSONObject.optInt(com.anythink.expressad.d.a.b.aF, 604800);
                    aVar.F = jSONObject.optInt(com.anythink.expressad.d.a.b.aG, com.anythink.expressad.d.a.b.aK);
                    aVar.aL = jSONObject.optInt(com.anythink.expressad.d.a.b.bn, 3);
                    aVar.aF = jSONObject.optInt(com.anythink.expressad.d.a.b.bv, 1);
                    aVar.af = jSONObject.optString(com.anythink.expressad.d.a.b.aH, "");
                    aVar.aE = jSONObject.optInt(com.anythink.expressad.d.a.b.al, 1);
                    aVar.ah = jSONObject.optInt(com.anythink.expressad.d.a.b.bE, 1);
                    aVar.ag = jSONObject.optInt(com.anythink.expressad.d.a.b.bF, 1);
                    aVar.ai = jSONObject.optInt(com.anythink.expressad.d.a.b.bG, 1);
                    int i = 0;
                    aVar.aj = jSONObject.optInt("sc", 0);
                    aVar.ak = jSONObject.optInt(com.anythink.expressad.d.a.b.bI, 1);
                    aVar.am = jSONObject.optInt(com.anythink.expressad.d.a.b.bK, -1);
                    aVar.an = jSONObject.optInt(com.anythink.expressad.d.a.b.bV, 2);
                    aVar.ap = jSONObject.optInt(com.anythink.expressad.d.a.b.bY, 86400);
                    aVar.ao = jSONObject.optString(com.anythink.expressad.d.a.b.bW);
                    aVar.ar = jSONObject.optString(com.anythink.expressad.d.a.b.cG);
                    aVar.aq = jSONObject.optString(com.anythink.expressad.d.a.b.cF);
                    aVar.as = jSONObject.optInt(com.anythink.expressad.d.a.b.cN);
                    aVar.U = jSONObject.optInt(com.anythink.expressad.d.a.b.ci, com.anythink.expressad.d.a.b.ck);
                    aVar.T = jSONObject.optInt(com.anythink.expressad.d.a.b.ch, 0);
                    try {
                        org.json.JSONArray optJSONArray = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.cg);
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            java.util.LinkedList<java.lang.String> linkedList = new java.util.LinkedList<>();
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                linkedList.add(optJSONArray.optString(i2));
                            }
                            aVar.S = linkedList;
                        }
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    long optLong = jSONObject.optLong(com.anythink.expressad.d.a.b.ab);
                    if (optLong == 0) {
                        aVar.aG = 20L;
                    } else {
                        aVar.aG = optLong;
                    }
                    long optLong2 = jSONObject.optLong(com.anythink.expressad.d.a.b.ac);
                    if (optLong2 == 0) {
                        aVar.aH = 10L;
                    } else {
                        aVar.aH = optLong2;
                        org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.v);
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            java.util.HashMap hashMap = new java.util.HashMap();
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                org.json.JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                                hashMap.put(optJSONObject.optString("domain"), optJSONObject.optString("format"));
                            }
                            aVar.h = hashMap;
                        }
                    }
                    aVar.G = jSONObject.optInt(com.anythink.expressad.d.a.b.ao, 3);
                    aVar.H = jSONObject.optInt(com.anythink.expressad.d.a.b.ap, 86400);
                    aVar.I = jSONObject.optInt("iex", 1);
                    org.json.JSONArray optJSONArray3 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.ar);
                    if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new java.util.ArrayList();
                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                            java.lang.String optString = optJSONArray3.optString(i4);
                            if (com.anythink.expressad.foundation.h.w.b(optString)) {
                                arrayList.add(com.anythink.expressad.foundation.d.c.a(new org.json.JSONObject(optString)));
                            }
                        }
                    }
                    if (arrayList != null) {
                        aVar.M = arrayList;
                    }
                    try {
                        org.json.JSONArray optJSONArray4 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.as);
                        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                            arrayList2 = new java.util.ArrayList();
                            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                                java.lang.String optString2 = optJSONArray4.optString(i5);
                                if (com.anythink.expressad.foundation.h.w.b(optString2)) {
                                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(optString2);
                                    arrayList2.add(new com.anythink.expressad.foundation.d.b(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                                }
                            }
                        }
                        if (arrayList2 != null) {
                            aVar.N = arrayList2;
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    aVar.aM = jSONObject.optInt(com.anythink.expressad.d.a.b.at, com.anythink.expressad.d.a.b.bx);
                    aVar.Y = jSONObject.optInt("pf", 900);
                    aVar.aa = jSONObject.optInt(com.anythink.expressad.d.a.b.aA, 20);
                    aVar.ae = jSONObject.optString("pid");
                    org.json.JSONArray optJSONArray5 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.av);
                    if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                        java.util.ArrayList arrayList3 = new java.util.ArrayList();
                        for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                            arrayList3.add(optJSONArray5.optString(i6));
                        }
                        aVar.Z = arrayList3;
                    }
                    org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject(com.anythink.expressad.d.a.b.aw);
                    if (optJSONObject2 != null) {
                        aVar.ab = optJSONObject2.optInt("full", 1);
                        aVar.ac = optJSONObject2.optInt(com.anythink.expressad.d.a.b.ay, 1);
                        aVar.ad = optJSONObject2.optInt("delete", 1);
                    }
                    aVar.aN = jSONObject.optString(com.anythink.expressad.d.a.b.ct, "");
                    aVar.aO = jSONObject.optString(com.anythink.expressad.d.a.b.cu, "");
                    aVar.aP = jSONObject.optString(com.anythink.expressad.d.a.b.cv, "");
                    aVar.aQ = jSONObject.optString(com.anythink.expressad.d.a.b.cw, "");
                    aVar.aR = jSONObject.optString(com.anythink.expressad.d.a.b.cx, "");
                    aVar.aS = jSONObject.optInt(com.anythink.expressad.d.a.b.cy, 0);
                    aVar.aT = jSONObject.optInt(com.anythink.expressad.d.a.b.cz, 21600);
                    aVar.aU = jSONObject.optInt(com.anythink.expressad.d.a.b.cA, 2);
                    aVar.aV = jSONObject.optInt(com.anythink.expressad.d.a.b.cB, 0);
                    aVar.aW = jSONObject.optInt(com.anythink.expressad.d.a.b.cC, 0);
                    aVar.aX = jSONObject.optInt(com.anythink.expressad.d.a.b.cD, 604800);
                    aVar.aY = jSONObject.optInt(com.anythink.expressad.d.a.b.cE, 0);
                    aVar.aZ = jSONObject.optString("adchoice_icon", "");
                    aVar.bb = jSONObject.optString("adchoice_link", "");
                    aVar.ba = jSONObject.optString("adchoice_size", "");
                    aVar.bd = jSONObject.optString("platform_logo", "");
                    aVar.bc = jSONObject.optString("platform_name", "");
                    aVar.be = y(jSONObject.optString(com.anythink.expressad.d.a.b.cM, ""));
                    aVar.a = jSONObject.optInt(com.anythink.expressad.d.a.b.cO, 0);
                    aVar.bh = jSONObject.optInt(com.anythink.expressad.d.a.b.cQ, 0);
                    aVar.W = jSONObject.optInt(com.anythink.expressad.d.a.b.di, 120);
                    aVar.V = jSONObject.optInt(com.anythink.expressad.d.a.b.dg, 10);
                    aVar.X = jSONObject.optString(com.anythink.expressad.d.a.b.dI, "");
                    aVar.bi = jSONObject.optString(com.anythink.expressad.d.a.b.cT, "");
                    aVar.bj = jSONObject.optInt(com.anythink.expressad.d.a.b.cU, 2);
                    aVar.bk = jSONObject.optInt(com.anythink.expressad.d.a.b.cV, 7200);
                    aVar.bm = jSONObject.optString(com.anythink.expressad.d.a.b.ds);
                    aVar.bl = jSONObject.optString(com.anythink.expressad.d.a.b.dA);
                    int optInt = jSONObject.optInt(com.anythink.expressad.d.a.b.dt, 0);
                    if (optInt > 2 || optInt < 0) {
                        optInt = 0;
                    }
                    aVar.bn = optInt;
                    aVar.bo = jSONObject.optBoolean(com.anythink.expressad.d.a.b.dw, false);
                    org.json.JSONArray optJSONArray6 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.dr);
                    if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                        for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                            org.json.JSONObject jSONObject3 = optJSONArray6.getJSONObject(i7);
                            java.util.Iterator<java.lang.String> keys = jSONObject3.keys();
                            while (keys.hasNext()) {
                                java.lang.String next = keys.next();
                                if (!android.text.TextUtils.isEmpty(next) && jSONObject3.getBoolean(next)) {
                                    aVar.aD.add(java.lang.Integer.valueOf(java.lang.Integer.parseInt(next)));
                                }
                            }
                        }
                    }
                    try {
                        int optInt2 = jSONObject.optInt("lqcnt", 30);
                        int optInt3 = jSONObject.optInt("lqto", 5);
                        int optInt4 = jSONObject.optInt("lqswt", 0);
                        int optInt5 = jSONObject.optInt("lqtype", 0);
                        aVar.au = optInt3;
                        aVar.at = optInt2;
                        aVar.av = optInt4;
                        aVar.aw = optInt5;
                        int parseInt = java.lang.Integer.parseInt(com.anythink.expressad.foundation.h.j.b(jSONObject.optString("lqpt")));
                        if (parseInt > 0 && parseInt < 65535) {
                            aVar.ax = parseInt;
                        }
                    } catch (java.lang.Exception unused) {
                    }
                    aVar.bp = jSONObject.optInt(com.anythink.expressad.d.a.b.dB, 0);
                    try {
                        int optInt6 = jSONObject.optInt("l", 3);
                        boolean z2 = jSONObject.optInt("k", 0) == 1;
                        if (jSONObject.optInt(com.anythink.expressad.d.a.b.dH, 1) != 1) {
                            z = false;
                        }
                        aVar.P = optInt6;
                        aVar.O = z2;
                        aVar.Q = z;
                    } catch (java.lang.Exception e2) {
                        e2.getMessage();
                    }
                    aVar.bf = jSONObject.optInt(com.anythink.expressad.d.a.b.dK, 0);
                    aVar.bg = com.anythink.expressad.d.a.b.a(jSONObject.optJSONObject(com.anythink.expressad.d.a.b.dL));
                    try {
                        int optInt7 = jSONObject.optInt(com.anythink.expressad.d.a.b.dQ, com.anythink.expressad.foundation.g.a.cH);
                        int optInt8 = jSONObject.optInt(com.anythink.expressad.d.a.b.dR, com.anythink.expressad.foundation.g.a.cI);
                        int optInt9 = jSONObject.optInt(com.anythink.expressad.d.a.b.dS, com.anythink.expressad.foundation.g.a.cJ);
                        int optInt10 = jSONObject.optInt(com.anythink.expressad.d.a.b.dU, com.anythink.expressad.foundation.g.a.cO);
                        if (optInt7 <= 0) {
                            optInt7 = com.anythink.expressad.foundation.g.a.cH;
                        }
                        if (optInt8 <= 0) {
                            optInt8 = com.anythink.expressad.foundation.g.a.cI;
                        }
                        if (optInt9 <= 0) {
                            optInt9 = com.anythink.expressad.foundation.g.a.cJ;
                        }
                        if (optInt10 < 0) {
                            optInt10 = com.anythink.expressad.foundation.g.a.cO;
                        }
                        aVar.aA = optInt7;
                        aVar.ay = optInt8;
                        aVar.az = optInt9;
                        aVar.aB = optInt10;
                        int optInt11 = jSONObject.optInt(com.anythink.expressad.d.a.b.dT, 0);
                        if (optInt11 >= 0) {
                            i = optInt11;
                        }
                        aVar.R = i;
                        aVar.b(jSONObject.optInt(com.anythink.expressad.d.a.b.dV, 10));
                        return aVar;
                    } catch (java.lang.Exception unused2) {
                        arrayList2 = aVar;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    arrayList2 = aVar;
                    e.printStackTrace();
                    return arrayList2;
                }
            }
        } catch (java.lang.Exception e4) {
            e = e4;
        }
        return arrayList2;
    }

    private void b(long j) {
        this.C = j;
    }

    private void b(java.util.List<java.lang.String> list) {
        this.Z = list;
    }

    private void b(java.util.Map<java.lang.String, com.anythink.expressad.d.a.C0182a> map) {
        this.be = map;
    }

    private void b(boolean z) {
        this.O = z;
    }

    private int bA() {
        return this.aX;
    }

    private java.lang.String bB() {
        return this.bc;
    }

    private java.lang.String bC() {
        return this.bd;
    }

    private java.util.Map<java.lang.String, com.anythink.expressad.d.a.C0182a> bD() {
        return this.be;
    }

    private boolean bE() {
        return (android.text.TextUtils.isEmpty(this.aZ) || android.text.TextUtils.isEmpty(this.bb) || android.text.TextUtils.isEmpty(this.ba)) ? false : true;
    }

    private int bF() {
        return this.at;
    }

    private int bG() {
        return this.au;
    }

    private int bH() {
        return this.av;
    }

    private int bI() {
        return this.aw;
    }

    private int bJ() {
        return this.ax;
    }

    private boolean bK() {
        return this.O;
    }

    private int bL() {
        return this.P;
    }

    private boolean bM() {
        return this.Q;
    }

    private int bN() {
        return this.bh;
    }

    private java.lang.String bO() {
        return this.bi;
    }

    private int bP() {
        return this.bj;
    }

    private int bQ() {
        return this.bk;
    }

    private java.lang.String bR() {
        return this.bm;
    }

    private int bS() {
        return this.bn;
    }

    private boolean bT() {
        return this.bo;
    }

    private int bU() {
        return this.bq;
    }

    private long ba() {
        return this.p;
    }

    private long bb() {
        return this.o;
    }

    private java.lang.String bc() {
        return this.b;
    }

    private long bd() {
        return this.c;
    }

    private int be() {
        return this.d;
    }

    private long bf() {
        return this.e;
    }

    private int bg() {
        return this.f;
    }

    private java.util.List<com.anythink.expressad.d.c> bh() {
        return this.l;
    }

    private java.lang.String bi() {
        return this.af;
    }

    private java.lang.String bj() {
        return this.k;
    }

    private long bk() {
        return this.j;
    }

    private java.util.Map<java.lang.String, java.lang.String> bl() {
        return this.h;
    }

    private boolean bm() {
        return this.g;
    }

    private boolean bn() {
        return this.i;
    }

    private int bo() {
        return this.r;
    }

    private int bp() {
        return this.f198s;
    }

    private static boolean bq() {
        try {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
            if (b2 != null) {
                return b2.g;
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private java.lang.String br() {
        return this.aQ;
    }

    private boolean bs() {
        return (android.text.TextUtils.isEmpty(this.aN) || android.text.TextUtils.isEmpty(this.aO) || android.text.TextUtils.isEmpty(this.aP) || android.text.TextUtils.isEmpty(this.aQ)) ? false : true;
    }

    private boolean bt() {
        return (android.text.TextUtils.isEmpty(this.aN) || android.text.TextUtils.isEmpty(this.aO) || android.text.TextUtils.isEmpty(this.aP) || android.text.TextUtils.isEmpty(this.aR)) ? false : true;
    }

    private int bu() {
        return this.aY;
    }

    private int bv() {
        return this.aS;
    }

    private int bw() {
        return this.aT;
    }

    private int bx() {
        return this.aU;
    }

    private int by() {
        return this.aV;
    }

    private int bz() {
        return this.aW;
    }

    private void c(long j) {
        this.aG = j;
    }

    private void c(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.M = list;
    }

    private void c(boolean z) {
        this.Q = z;
    }

    private void d(long j) {
        this.p = j;
    }

    private void d(java.lang.String str) {
        this.X = str;
    }

    private void d(java.util.List<com.anythink.expressad.d.c> list) {
        this.l = list;
    }

    private void e(long j) {
        this.c = j;
    }

    private void e(java.lang.String str) {
        this.aq = str;
    }

    private void f(long j) {
        this.e = j;
    }

    private void f(java.lang.String str) {
        this.ar = str;
    }

    private void g(int i) {
        this.V = i;
    }

    private void g(long j) {
        this.j = j;
    }

    private void g(java.lang.String str) {
        this.ao = str;
    }

    private void h(int i) {
        this.T = i;
    }

    private void h(java.lang.String str) {
        this.al = str;
    }

    private void i(int i) {
        this.U = i;
    }

    private void i(java.lang.String str) {
        this.ae = str;
    }

    private void j(int i) {
        this.aD.add(java.lang.Integer.valueOf(i));
    }

    private void j(java.lang.String str) {
        this.J = str;
    }

    private void k(java.lang.String str) {
        this.B = str;
    }

    private boolean k(int i) {
        return this.aD.contains(java.lang.Integer.valueOf(i));
    }

    private void l(int i) {
        this.as = i;
    }

    private void l(java.lang.String str) {
        this.b = str;
    }

    private void m(int i) {
        this.ap = i;
    }

    private void m(java.lang.String str) {
        this.af = str;
    }

    private void n(int i) {
        this.an = i;
    }

    private void n(java.lang.String str) {
        this.k = str;
    }

    private void o(int i) {
        this.aF = i;
    }

    private void o(java.lang.String str) {
        this.aN = str;
    }

    private void p(int i) {
        this.aE = i;
    }

    private void p(java.lang.String str) {
        this.aO = str;
    }

    private void q(int i) {
        this.Y = i;
    }

    private void q(java.lang.String str) {
        this.aP = str;
    }

    private void r(int i) {
        this.aa = i;
    }

    private void r(java.lang.String str) {
        this.aQ = str;
    }

    private void s(int i) {
        this.ab = i;
    }

    private void s(java.lang.String str) {
        this.aR = str;
    }

    private void t(int i) {
        this.ac = i;
    }

    private void t(java.lang.String str) {
        this.aZ = str;
    }

    private void u(int i) {
        this.ad = i;
    }

    private void u(java.lang.String str) {
        this.ba = str;
    }

    private void v(int i) {
        this.G = i;
    }

    private void v(java.lang.String str) {
        this.bb = str;
    }

    private void w(int i) {
        this.H = i;
    }

    private void w(java.lang.String str) {
        this.bc = str;
    }

    private void x(int i) {
        this.I = i;
    }

    private void x(java.lang.String str) {
        this.bd = str;
    }

    private static java.util.Map<java.lang.String, com.anythink.expressad.d.a.C0182a> y(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                com.anythink.expressad.d.a.C0182a c0182a = new com.anythink.expressad.d.a.C0182a();
                org.json.JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    c0182a.a(optJSONObject);
                }
                hashMap.put(next, c0182a);
            }
            return hashMap;
        } catch (org.json.JSONException e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
            return null;
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    private void y(int i) {
        this.D = i;
    }

    private void z(int i) {
        this.F = i;
    }

    private void z(java.lang.String str) {
        this.bl = str;
    }

    public final void A() {
        this.d = 1;
    }

    public final void B() {
        this.i = true;
    }

    public final java.lang.String C() {
        return this.aN;
    }

    public final java.lang.String D() {
        return this.aO;
    }

    public final java.lang.String E() {
        return this.aP;
    }

    public final java.lang.String F() {
        return this.aR;
    }

    public final void G() {
        java.util.Locale.getDefault().getLanguage();
        if (!((android.text.TextUtils.isEmpty(this.aN) || android.text.TextUtils.isEmpty(this.aO) || android.text.TextUtils.isEmpty(this.aP) || android.text.TextUtils.isEmpty(this.aQ)) ? false : true)) {
            this.aN = "Confirm to close? ";
            this.aO = "You will not be rewarded after closing the window";
            this.aP = "Close it";
            this.aQ = "Continue";
        }
        if ((android.text.TextUtils.isEmpty(this.aN) || android.text.TextUtils.isEmpty(this.aO) || android.text.TextUtils.isEmpty(this.aP) || android.text.TextUtils.isEmpty(this.aR)) ? false : true) {
            return;
        }
        this.aN = "Confirm to close? ";
        this.aO = "You will not be rewarded after closing the window";
        this.aP = "Close it";
        this.aR = "Continue";
    }

    public final java.lang.String H() {
        return this.aZ;
    }

    public final java.lang.String I() {
        return this.ba;
    }

    public final java.lang.String J() {
        return this.bb;
    }

    public final int K() {
        return this.bf;
    }

    public final com.anythink.expressad.d.a.b L() {
        return this.bg;
    }

    public final java.lang.String M() {
        return this.bl;
    }

    public final void N() {
        this.bn = 0;
    }

    public final void O() {
        this.bo = false;
    }

    public final int P() {
        return this.bp;
    }

    public final void Q() {
        this.bq = 1;
    }

    public final java.lang.String R() {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("cc", this.b);
            jSONObject.put(com.anythink.expressad.d.a.b.l, this.c);
            jSONObject.put(com.anythink.expressad.d.a.b.m, this.d);
            jSONObject.put(com.anythink.expressad.d.a.b.p, this.f);
            jSONObject.put(com.anythink.expressad.d.a.b.w, this.g);
            jSONObject.put(com.anythink.expressad.d.a.b.o, this.i);
            jSONObject.put("plct", this.n);
            jSONObject.put(com.anythink.expressad.d.a.b.B, this.o);
            jSONObject.put(com.anythink.expressad.d.a.b.C, this.m);
            jSONObject.put(com.anythink.expressad.d.a.b.G, this.q);
            jSONObject.put("plctb", this.u);
            jSONObject.put(com.anythink.expressad.d.a.b.ab, this.aG);
            jSONObject.put(com.anythink.expressad.d.a.b.ac, this.aH);
            jSONObject.put(com.anythink.expressad.d.a.b.af, this.y);
            jSONObject.put(com.anythink.expressad.d.a.b.ag, this.z);
            jSONObject.put(com.anythink.expressad.d.a.b.i, this.J);
            jSONObject.put(com.anythink.expressad.d.a.b.j, this.K);
            jSONObject.put(com.anythink.expressad.d.a.b.k, this.L);
            jSONObject.put(com.anythink.expressad.d.a.b.ai, this.aK);
            jSONObject.put(com.anythink.expressad.d.a.b.aa, this.x);
            jSONObject.put(com.anythink.expressad.d.a.b.aG, this.F);
            jSONObject.put(com.anythink.expressad.d.a.b.aE, this.D);
            jSONObject.put(com.anythink.expressad.d.a.b.aF, this.E);
            jSONObject.put(com.anythink.expressad.d.a.b.ae, this.aJ);
            jSONObject.put(com.anythink.expressad.d.a.b.bn, this.aL);
            jSONObject.put(com.anythink.expressad.d.a.b.bv, this.aF);
            jSONObject.put("iex", this.I);
            jSONObject.put(com.anythink.expressad.d.a.b.ao, this.G);
            jSONObject.put(com.anythink.expressad.d.a.b.ap, this.H);
            jSONObject.put(com.anythink.expressad.d.a.b.at, this.aM);
            jSONObject.put(com.anythink.expressad.d.a.b.al, this.aE);
            jSONObject.put("pf", this.Y);
            jSONObject.put(com.anythink.expressad.d.a.b.aA, this.aa);
            jSONObject.put("pid", this.ae);
            jSONObject.put("full", this.ab);
            jSONObject.put(com.anythink.expressad.d.a.b.ay, this.ac);
            jSONObject.put("delete", this.ad);
            jSONObject.put(com.anythink.expressad.d.a.b.ad, this.aI);
            jSONObject.put(com.anythink.expressad.d.a.b.bE, this.ah);
            jSONObject.put(com.anythink.expressad.d.a.b.bF, this.ag);
            jSONObject.put(com.anythink.expressad.d.a.b.bG, this.ai);
            jSONObject.put("sc", this.aj);
            jSONObject.put(com.anythink.expressad.d.a.b.bI, this.ak);
            jSONObject.put(com.anythink.expressad.d.a.b.bK, this.am);
            jSONObject.put(com.anythink.expressad.d.a.b.bJ, this.al);
            jSONObject.put(com.anythink.expressad.d.a.b.bV, this.an);
            jSONObject.put(com.anythink.expressad.d.a.b.bY, this.ap);
            jSONObject.put(com.anythink.expressad.d.a.b.cO, this.a);
            jSONObject.put(com.anythink.expressad.d.a.b.cT, this.bi);
            jSONObject.put(com.anythink.expressad.d.a.b.di, this.W);
            jSONObject.put(com.anythink.expressad.d.a.b.dg, this.V);
            jSONObject.put(com.anythink.expressad.d.a.b.dw, this.bo);
            jSONObject.put(com.anythink.expressad.d.a.b.dt, this.bn);
            jSONObject.put("isDefault", this.bq);
            return jSONObject.toString();
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public final int S() {
        return this.br;
    }

    public final int T() {
        return this.bs;
    }

    public final int U() {
        return this.bt;
    }

    public final int V() {
        return this.bu;
    }

    public final int W() {
        return this.bv;
    }

    public final void a() {
        this.R = 10;
    }

    public final void a(int i) {
        this.W = i;
    }

    public final void a(java.lang.String str) {
        this.K = str;
    }

    public final int b() {
        return this.W;
    }

    public final void b(int i) {
        if (i > 0) {
            this.aC = i;
        }
    }

    public final void c() {
        this.a = 0;
    }

    public final void c(int i) {
        this.ay = i;
    }

    public final void c(java.lang.String str) {
        this.bi = str;
    }

    public final void d() {
        this.ag = 1;
    }

    public final void d(int i) {
        this.az = i;
    }

    public final void e() {
        this.ah = 1;
    }

    public final void e(int i) {
        this.aA = i;
    }

    public final void f() {
        this.ai = 1;
    }

    public final void f(int i) {
        this.aB = i;
    }

    public final void g() {
        this.aj = 0;
    }

    public final void h() {
        this.ak = 1;
    }

    public final void i() {
        this.am = -1;
    }

    public final void j() {
        this.L = 1;
    }

    public final int k() {
        return this.A;
    }

    public final long l() {
        if (this.u <= 0) {
            this.u = com.anythink.expressad.d.a.b.Q;
        }
        return this.u;
    }

    public final void m() {
        this.u = com.anythink.expressad.d.a.b.Q;
    }

    public final int n() {
        return this.aM;
    }

    public final void o() {
        this.aM = com.anythink.expressad.d.a.b.bx;
    }

    public final void p() {
        this.aK = com.anythink.expressad.d.a.b.aC;
    }

    public final long q() {
        return this.aG * 1000;
    }

    public final long r() {
        return this.aH * 1000;
    }

    public final void s() {
        this.aH = 10L;
    }

    public final boolean t() {
        return this.q;
    }

    public final java.lang.String toString() {
        return "cc=" + this.b + " upal=" + this.c + " cfc=" + this.d + " getpf=" + this.e + " uplc=" + this.f + " rurl=" + this.m;
    }

    public final void u() {
        this.q = false;
    }

    public final boolean v() {
        return this.m;
    }

    public final void w() {
        this.m = false;
    }

    public final long x() {
        return this.n;
    }

    public final void y() {
        this.n = com.anythink.expressad.d.a.b.P;
    }

    public final void z() {
        this.o = 0L;
    }
}
