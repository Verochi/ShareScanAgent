package com.loc;

/* loaded from: classes23.dex */
public final class fu {
    private static volatile boolean i = false;
    private static boolean j = true;
    private static int k = 1000;
    private static int l = 200;
    private static boolean m = false;
    private static int n = 20;
    private static int o = 0;
    private static volatile int p = 0;
    private static boolean q = true;
    private static boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    private static int f410s = -1;
    private static long t;
    private static java.util.ArrayList<java.lang.String> u = new java.util.ArrayList<>();
    private static java.util.ArrayList<java.lang.String> v = new java.util.ArrayList<>();
    private static volatile boolean w = false;
    private static boolean x = true;
    private static long y = 300000;
    private static boolean z = false;
    private static double A = 0.618d;
    private static boolean B = true;
    private static int C = 80;
    private static int D = 5;
    static long a = 3600000;
    private static boolean E = false;
    private static boolean F = true;
    private static boolean G = false;
    public static volatile long b = 0;
    static boolean c = false;
    private static boolean H = true;
    private static long I = -1;
    private static boolean J = true;
    private static int K = 1;
    private static boolean L = false;
    private static int M = 5;
    private static boolean N = false;
    private static java.lang.String O = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long P = 0;
    public static boolean d = false;
    public static boolean e = false;
    public static int f = 20480;
    public static int g = 10800000;
    public static boolean h = false;

    /* renamed from: com.loc.fu$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.loc.n.a {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.loc.n.a
        public final void a(com.loc.n.b bVar) {
            com.loc.fu.a(this.a, bVar);
        }
    }

    public static void a(android.content.Context context) {
        if (i) {
            return;
        }
        i = true;
        com.loc.n.a(context, com.loc.fv.c(), com.loc.fv.d(), new com.loc.fu.AnonymousClass1(context));
    }

    private static void a(android.content.Context context, org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                try {
                    long optInt = optJSONObject.optInt("at", 123) * 60 * 1000;
                    a = optInt;
                    com.loc.gc.a(editor, "13S_at", optInt);
                } catch (java.lang.Throwable th) {
                    com.loc.fv.a(th, "AuthUtil", "requestSdkAuthInterval");
                }
                e(optJSONObject, editor);
                try {
                    boolean a2 = com.loc.n.a(optJSONObject.optString("nla"), true);
                    F = a2;
                    com.loc.gc.a(editor, "13S_nla", a2);
                } catch (java.lang.Throwable unused) {
                }
                try {
                    boolean a3 = com.loc.n.a(optJSONObject.optString("asw"), true);
                    H = a3;
                    com.loc.gc.a(editor, "asw", a3);
                } catch (java.lang.Throwable unused2) {
                }
                try {
                    org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray == null || optJSONArray.length() <= 0 || context == null) {
                        G = false;
                        com.loc.gc.a(editor, "13S_mlpl");
                    } else {
                        com.loc.gc.a(editor, "13S_mlpl", com.loc.y.b(optJSONArray.toString()));
                        G = a(context, optJSONArray);
                    }
                } catch (java.lang.Throwable unused3) {
                }
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static void a(com.loc.n.b bVar, android.content.SharedPreferences.Editor editor) {
        try {
            com.loc.n.b.a aVar = bVar.g;
            if (aVar != null) {
                boolean z2 = aVar.a;
                j = z2;
                com.loc.gc.a(editor, "exception", z2);
                org.json.JSONObject jSONObject = aVar.c;
                if (jSONObject != null) {
                    k = jSONObject.optInt("fn", k);
                    int optInt = jSONObject.optInt("mpn", l);
                    l = optInt;
                    if (optInt > 500) {
                        l = 500;
                    }
                    if (l < 30) {
                        l = 30;
                    }
                    m = com.loc.n.a(jSONObject.optString("igu"), false);
                    n = jSONObject.optInt("ms", n);
                    p = jSONObject.optInt("rot", 0);
                    o = jSONObject.optInt("pms", 0);
                }
                com.loc.ca.a(k, m, n, o);
                com.loc.cc.a(m, o);
                com.loc.gc.a(editor, "fn", k);
                com.loc.gc.a(editor, "mpn", l);
                com.loc.gc.a(editor, "igu", m);
                com.loc.gc.a(editor, "ms", n);
                com.loc.gc.a(editor, "rot", p);
                com.loc.gc.a(editor, "pms", o);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    private static void a(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean a2 = com.loc.n.a(optJSONObject.optString("able"), true);
                x = a2;
                if (a2) {
                    y = optJSONObject.optInt("c", 300) * 1000;
                }
                z = com.loc.n.a(optJSONObject.optString("fa"), false);
                A = java.lang.Math.min(1.0d, java.lang.Math.max(0.2d, optJSONObject.optDouble("ms", 0.618d)));
                com.loc.gc.a(editor, "ca", x);
                com.loc.gc.a(editor, com.anythink.expressad.d.a.b.dx, y);
                com.loc.gc.a(editor, "11G_fa", z);
                com.loc.gc.a(editor, "11G_ms", java.lang.String.valueOf(A));
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    public static boolean a() {
        return j;
    }

    public static boolean a(long j2) {
        if (!x) {
            return false;
        }
        long a2 = com.loc.gd.a() - j2;
        long j3 = y;
        return j3 < 0 || a2 < j3;
    }

    public static boolean a(android.content.Context context, com.loc.n.b bVar) {
        android.content.SharedPreferences.Editor editor;
        try {
            editor = com.loc.gc.a(context, "pref");
        } catch (java.lang.Throwable unused) {
            editor = null;
        }
        try {
            a(bVar, editor);
            c(context);
            org.json.JSONObject jSONObject = bVar.f;
            if (jSONObject == null) {
                if (editor != null) {
                    try {
                        com.loc.gc.a(editor);
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                return true;
            }
            a(context, jSONObject, editor);
            a(jSONObject, editor);
            d(jSONObject, editor);
            f(jSONObject, editor);
            h(jSONObject, editor);
            g(jSONObject, editor);
            i(jSONObject, editor);
            b(jSONObject, editor);
            c(jSONObject, editor);
            if (editor != null) {
                try {
                    com.loc.gc.a(editor);
                } catch (java.lang.Throwable unused3) {
                }
            }
            return true;
        } catch (java.lang.Throwable unused4) {
            if (editor == null) {
                return false;
            }
            try {
                com.loc.gc.a(editor);
                return false;
            } catch (java.lang.Throwable unused5) {
                return false;
            }
        }
    }

    private static boolean a(android.content.Context context, org.json.JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (com.loc.gd.b(context, jSONArray.getString(i2))) {
                            return true;
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return false;
    }

    public static int b() {
        return l;
    }

    public static void b(android.content.Context context) {
        if (w) {
            return;
        }
        w = true;
        try {
            j = com.loc.gc.a(context, "pref", "exception", j);
            c(context);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            k = com.loc.gc.a(context, "pref", "fn", k);
            l = com.loc.gc.a(context, "pref", "mpn", l);
            m = com.loc.gc.a(context, "pref", "igu", m);
            n = com.loc.gc.a(context, "pref", "ms", n);
            p = com.loc.gc.a(context, "pref", "rot", 0);
            int a2 = com.loc.gc.a(context, "pref", "pms", 0);
            o = a2;
            com.loc.ca.a(k, m, n, a2);
            com.loc.cc.a(m, o);
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            x = com.loc.gc.a(context, "pref", "ca", x);
            y = com.loc.gc.a(context, "pref", com.anythink.expressad.d.a.b.dx, y);
            z = com.loc.gc.a(context, "pref", "11G_fa", z);
            double doubleValue = java.lang.Double.valueOf(com.loc.gc.a(context, "pref", "11G_ms", java.lang.String.valueOf(A))).doubleValue();
            A = doubleValue;
            A = java.lang.Math.max(0.2d, doubleValue);
        } catch (java.lang.Throwable th3) {
            com.loc.fv.a(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            c = com.loc.gc.a(context, "pref", com.anythink.expressad.video.dynview.a.a.U, c);
        } catch (java.lang.Throwable th4) {
            com.loc.fv.a(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            H = com.loc.gc.a(context, "pref", "asw", H);
        } catch (java.lang.Throwable th5) {
            com.loc.fv.a(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            I = com.loc.gc.a(context, "pref", "awsi", I);
        } catch (java.lang.Throwable th6) {
            com.loc.fv.a(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            J = com.loc.gc.a(context, "pref", "15ua", J);
            K = com.loc.gc.a(context, "pref", "15un", K);
            P = com.loc.gc.a(context, "pref", "15ust", P);
        } catch (java.lang.Throwable th7) {
            com.loc.fv.a(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            L = com.loc.gc.a(context, "pref", "ok9", L);
            M = com.loc.gc.a(context, "pref", "ok10", M);
            O = com.loc.gc.a(context, "pref", "ok11", O);
        } catch (java.lang.Throwable th8) {
            com.loc.fv.a(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            d = com.loc.gc.a(context, "pref", "17ya", false);
            e = com.loc.gc.a(context, "pref", "17ym", false);
            g = com.loc.gc.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
            f = com.loc.gc.a(context, "pref", "17yx", 100) * 1024;
        } catch (java.lang.Throwable th9) {
            com.loc.fv.a(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            b = com.loc.gd.b();
            a = com.loc.gc.a(context, "pref", "13S_at", a);
            F = com.loc.gc.a(context, "pref", "13S_nla", F);
            B = com.loc.gc.a(context, "pref", "13J_able", B);
            C = com.loc.gc.a(context, "pref", "13J_c", C);
            D = com.loc.gc.a(context, "pref", "13J_t", D);
        } catch (java.lang.Throwable th10) {
            com.loc.fv.a(th10, "AuthUtil", "loadLastAbleState p10");
        }
        com.loc.n.b(context);
        try {
            java.lang.String a3 = com.loc.gc.a(context, "pref", "13S_mlpl", (java.lang.String) null);
            if (!android.text.TextUtils.isEmpty(a3)) {
                G = a(context, new org.json.JSONArray(com.loc.y.c(a3)));
            }
        } catch (java.lang.Throwable th11) {
            com.loc.fv.a(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean a4 = com.loc.gc.a(context, "pref", "197a", false);
            java.lang.String a5 = com.loc.gc.a(context, "pref", "197dv", "");
            java.lang.String a6 = com.loc.gc.a(context, "pref", "197tv", "");
            if (a4 && com.loc.fv.a.equals(a5)) {
                for (java.lang.String str : com.loc.fv.b) {
                    if (str.equals(a6)) {
                        com.loc.fv.a = a6;
                    }
                }
            }
        } catch (java.lang.Throwable th12) {
            com.loc.fv.a(th12, "AuthUtil", "loadLastAbleState p12");
        }
        try {
            h = com.loc.gc.a(context, "pref", "1A6", h);
        } catch (java.lang.Throwable th13) {
            com.loc.fv.a(th13, "AuthUtil", "loadSdkEnableConfig p13");
        }
    }

    private static void b(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean a2 = com.loc.n.a(jSONObject2.optString("able"), false);
                com.loc.gc.a(editor, "197a", a2);
                if (a2) {
                    com.loc.gc.a(editor, "197dv", jSONObject2.optString("sv", ""));
                    com.loc.gc.a(editor, "197tv", jSONObject2.optString("tv", ""));
                } else {
                    com.loc.gc.a(editor, "197dv", "");
                    com.loc.gc.a(editor, "197tv", "");
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static int c() {
        if (p < 0) {
            p = 0;
        }
        return p;
    }

    public static void c(android.content.Context context) {
        try {
            com.loc.x c2 = com.loc.fv.c();
            c2.a(j);
            com.loc.aw.a(context, c2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void c(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("1A6");
            if (jSONObject2 != null) {
                boolean a2 = com.loc.n.a(jSONObject2.optString("ic"), false);
                com.loc.gc.a(editor, "1A6", a2);
                h = a2;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static long d() {
        return y;
    }

    private static void d(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean a2 = com.loc.n.a(optJSONObject.optString("able"), true);
                B = a2;
                if (a2) {
                    C = optJSONObject.optInt("c", C);
                    D = optJSONObject.optInt("t", D);
                }
                com.loc.gc.a(editor, "13J_able", B);
                com.loc.gc.a(editor, "13J_c", C);
                com.loc.gc.a(editor, "13J_t", D);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    private static void e(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean a2 = com.loc.n.a(jSONObject.optString("re"), false);
            c = a2;
            com.loc.gc.a(editor, com.anythink.expressad.video.dynview.a.a.U, a2);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AuthUtil", "checkReLocationAble");
        }
    }

    public static boolean e() {
        return x;
    }

    private static void f(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        org.json.JSONArray optJSONArray;
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (com.loc.n.a(optJSONObject.optString("able"), false) && ((optJSONArray = optJSONObject.optJSONArray("fl")) == null || optJSONArray.length() <= 0 || optJSONArray.toString().contains(android.os.Build.MANUFACTURER))) {
                    I = optJSONObject.optInt("iv", 30) * 1000;
                } else {
                    I = -1L;
                }
                com.loc.gc.a(editor, "awsi", I);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean f() {
        return z;
    }

    public static double g() {
        return A;
    }

    private static void g(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean a2 = com.loc.n.a(jSONObject2.optString("able"), false);
                d = a2;
                com.loc.gc.a(editor, "17ya", a2);
                boolean a3 = com.loc.n.a(jSONObject2.optString("mup"), false);
                e = a3;
                com.loc.gc.a(editor, "17ym", a3);
                int optInt = jSONObject2.optInt(org.apache.tools.ant.types.selectors.DepthSelector.MAX_KEY, 20);
                if (optInt > 0) {
                    com.loc.gc.a(editor, "17yx", optInt);
                    f = optInt * 1024;
                }
                int optInt2 = jSONObject2.optInt("inv", 3);
                if (optInt2 > 0) {
                    com.loc.gc.a(editor, "17yi", optInt2);
                    g = optInt2 * 60 * 60 * 1000;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void h(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
                boolean a2 = com.loc.n.a(optJSONObject.optString("able"), true);
                int optInt = optJSONObject.optInt("yn", K);
                P = optJSONObject.optLong("sysTime", P);
                com.loc.gc.a(editor, "15ua", a2);
                com.loc.gc.a(editor, "15un", optInt);
                com.loc.gc.a(editor, "15ust", P);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean h() {
        return B;
    }

    public static int i() {
        return C;
    }

    private static void i(org.json.JSONObject jSONObject, android.content.SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject == null) {
            return;
        }
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("17J");
            if (optJSONObject != null) {
                boolean a2 = com.loc.n.a(optJSONObject.optString("able"), false);
                L = a2;
                com.loc.gc.a(editor, "ok9", a2);
                if (a2) {
                    java.lang.String optString = optJSONObject.optString(com.alipay.sdk.m.k.b.n);
                    java.lang.String optString2 = optJSONObject.optString("ht");
                    O = optString2;
                    com.loc.gc.a(editor, "ok11", optString2);
                    com.loc.n.a(optString, false);
                    N = com.loc.n.a(optJSONObject.optString("nr"), false);
                    java.lang.String optString3 = optJSONObject.optString("tm");
                    if (android.text.TextUtils.isEmpty(optString3) || (parseInt = java.lang.Integer.parseInt(optString3)) <= 0 || parseInt >= 20) {
                        return;
                    }
                    M = parseInt;
                    com.loc.gc.a(editor, "ok10", parseInt);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static int j() {
        return D;
    }

    public static boolean k() {
        return F;
    }

    public static boolean l() {
        return G;
    }

    public static boolean m() {
        return c;
    }

    public static boolean n() {
        return H;
    }

    public static long o() {
        return I;
    }

    public static boolean p() {
        return N;
    }

    public static boolean q() {
        return L;
    }

    public static java.lang.String r() {
        return com.loc.y.c(O);
    }

    public static boolean s() {
        return J && K > 0;
    }

    public static int t() {
        return K;
    }

    public static long u() {
        return P;
    }
}
