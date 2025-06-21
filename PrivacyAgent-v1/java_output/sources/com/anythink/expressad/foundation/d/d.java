package com.anythink.expressad.foundation.d;

/* loaded from: classes12.dex */
public class d implements com.anythink.expressad.e.b, java.io.Serializable {
    public static final java.lang.String A = "cam_tpl_url";
    public static final java.lang.String B = "cam_html";
    public static final java.lang.String C = "cam_tpl_url";
    public static final java.lang.String D = "cam_html";
    public static final java.lang.String E = "nscpt";
    public static final java.lang.String F = "mof_template_url";
    public static final java.lang.String G = "mof_tplid";
    public static final java.lang.String H = "req_ext_data";
    public static final java.lang.String I = "replace_tmp";
    private static final java.lang.String K = "d";
    private static final long L = 1;
    public static final java.lang.String a = "a";
    public static final java.lang.String b = "pv_urls";
    public static final java.lang.String c = "parent_session_id";
    public static final java.lang.String d = "ad_type";
    public static final java.lang.String e = "unit_size";
    public static final java.lang.String f = "html_url";
    public static final java.lang.String g = "only_impression_url";
    public static final java.lang.String h = "ads";
    public static final java.lang.String i = "template";
    public static final java.lang.String j = "frames";
    public static final java.lang.String k = "end_screen_url";
    public static final java.lang.String l = "jm_do";
    public static final java.lang.String m = "rks";
    public static final java.lang.String n = "vcn";
    public static final java.lang.String o = "token_r";
    public static final java.lang.String p = "encrypt_p";
    public static final java.lang.String q = "irlfa";
    public static final java.lang.String r = "csp";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f238s = "do";
    public static final java.lang.String t = "sh";
    public static final java.lang.String u = "ia_icon";
    public static final java.lang.String v = "ia_rst";
    public static final java.lang.String w = "ia_url";
    public static final java.lang.String x = "ia_ori";
    public static final java.lang.String y = "ia_all_ext1";
    public static final java.lang.String z = "ia_all_ext2";
    public java.util.ArrayList<com.anythink.expressad.foundation.d.c> J;
    private java.lang.String N;
    private java.lang.String O;
    private java.lang.String P;
    private java.lang.String Q;
    private java.lang.String R;
    private int S;
    private java.lang.String T;
    private int U;
    private java.lang.String V;
    private java.lang.String W;
    private java.lang.String X;
    private java.lang.String Y;
    private int Z;
    private java.lang.String aa;
    private java.lang.String ab;
    private java.lang.String ac;
    private int ad;
    private java.util.List<com.anythink.expressad.out.l> ae;
    private java.util.HashMap<java.lang.String, java.lang.String> ag;
    private java.util.HashMap<java.lang.String, java.lang.String> ah;
    private java.lang.String ai;
    private java.lang.String aj;
    private java.lang.String ak;
    private int al;
    private int am;
    private int ao;
    private java.lang.String ap;
    private java.lang.String M = "";
    private java.lang.StringBuffer af = new java.lang.StringBuffer();
    private java.lang.String an = "";

    private java.lang.String A() {
        return this.aa;
    }

    private java.lang.String B() {
        return this.ab;
    }

    private java.lang.String C() {
        return this.ac;
    }

    private java.util.ArrayList<com.anythink.expressad.foundation.d.c> D() {
        return this.J;
    }

    private int E() {
        return this.ad;
    }

    public static com.anythink.expressad.foundation.d.d a(java.lang.String str) {
        try {
            return b(new org.json.JSONObject(str), "");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static com.anythink.expressad.foundation.d.d a(org.json.JSONObject jSONObject) {
        return b(jSONObject, "");
    }

    private static com.anythink.expressad.foundation.d.d a(org.json.JSONObject jSONObject, java.lang.String str) {
        return b(jSONObject, str);
    }

    private static java.lang.Object a(java.lang.Object obj) {
        return obj == null ? "" : obj;
    }

    private void a(int i2) {
        this.S = i2;
    }

    private void a(java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList) {
        this.J = arrayList;
    }

    private void a(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        this.ag = hashMap;
    }

    private void a(java.util.List<com.anythink.expressad.out.l> list) {
        this.ae = list;
    }

    private static com.anythink.expressad.foundation.d.d b(org.json.JSONObject jSONObject) {
        return b(jSONObject, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.anythink.expressad.foundation.d.d] */
    private static com.anythink.expressad.foundation.d.d b(org.json.JSONObject jSONObject, java.lang.String str) {
        com.anythink.expressad.foundation.d.d dVar;
        com.anythink.expressad.foundation.d.d dVar2;
        int optInt;
        java.lang.String optString;
        java.lang.String str2;
        int i2;
        java.util.ArrayList arrayList;
        org.json.JSONArray optJSONArray;
        org.json.JSONArray optJSONArray2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        int i3;
        java.lang.String str6;
        org.json.JSONObject jSONObject2 = jSONObject;
        java.lang.String str7 = h;
        java.lang.String str8 = "template";
        ?? r5 = "a";
        java.lang.String str9 = g;
        java.lang.String str10 = f;
        if (jSONObject2 != null) {
            try {
                dVar = new com.anythink.expressad.foundation.d.d();
                try {
                    java.lang.String optString2 = jSONObject2.optString(m);
                    if (!android.text.TextUtils.isEmpty(optString2)) {
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject(optString2);
                        java.util.Iterator<java.lang.String> keys = jSONObject3.keys();
                        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
                        while (keys != null && keys.hasNext()) {
                            java.lang.String next = keys.next();
                            hashMap.put(next, jSONObject3.optString(next));
                        }
                        dVar.ag = hashMap;
                    }
                    if (!android.text.TextUtils.isEmpty(str)) {
                        java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
                        hashMap2.put("encrypt_p", "");
                        hashMap2.put(q, "");
                        dVar.ah = hashMap2;
                    }
                    org.json.JSONObject optJSONObject = jSONObject2.optJSONObject(H);
                    optInt = jSONObject2.optInt(E, 1);
                    optString = jSONObject2.optString(F, "");
                    int optInt2 = jSONObject2.optInt(G, 0);
                    java.lang.String jSONObject4 = optJSONObject != null ? optJSONObject.toString() : "";
                    new org.json.JSONArray();
                    org.json.JSONArray optJSONArray3 = jSONObject2.optJSONArray("pv_urls");
                    if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                        str2 = jSONObject4;
                        i2 = optInt2;
                        arrayList = null;
                    } else {
                        str2 = jSONObject4;
                        arrayList = new java.util.ArrayList(optJSONArray3.length());
                        i2 = optInt2;
                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                            arrayList.add(optJSONArray3.getString(i4));
                        }
                    }
                    com.anythink.expressad.foundation.c.a.a.a().a(jSONObject2.optJSONObject(I));
                    dVar.X = jSONObject2.optString("a");
                    dVar.Y = jSONObject2.optString("parent_session_id");
                    dVar.Z = jSONObject2.optInt("ad_type");
                    dVar.aa = jSONObject2.optString(e);
                    dVar.ab = jSONObject2.optString(f);
                    dVar.ac = jSONObject2.optString(g);
                    dVar.ad = jSONObject2.optInt("template");
                    dVar.ao = jSONObject2.optInt(l);
                    dVar.R = jSONObject2.optString("ia_icon");
                    dVar.S = jSONObject2.optInt("ia_rst");
                    dVar.T = jSONObject2.optString("ia_url");
                    dVar.U = jSONObject2.optInt("ia_ori");
                    dVar.V = jSONObject2.optString(y);
                    dVar.W = jSONObject2.optString(z);
                    dVar.al = jSONObject2.optInt("vcn");
                    dVar.am = jSONObject2.optInt("token_r");
                    dVar.an = jSONObject2.optString("encrypt_p");
                    optJSONArray = jSONObject2.optJSONArray(h);
                    optJSONArray2 = jSONObject2.optJSONArray(j);
                    str3 = k;
                } catch (java.lang.Exception unused) {
                    r5 = dVar;
                }
            } catch (java.lang.Exception unused2) {
            }
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                java.lang.String str11 = k;
                r5 = dVar;
                int i5 = optInt;
                java.lang.String str12 = str2;
                java.lang.String str13 = f;
                int i6 = i2;
                java.lang.String str14 = g;
                java.lang.String str15 = "parse campaign error ,campaign is null";
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList2 = new java.util.ArrayList<>();
                    int i7 = 0;
                    while (i7 < optJSONArray.length()) {
                        java.lang.String str16 = str14;
                        java.lang.String str17 = str13;
                        java.lang.String str18 = str15;
                        java.lang.String str19 = str11;
                        org.json.JSONArray jSONArray = optJSONArray;
                        java.lang.String str20 = str12;
                        str14 = str16;
                        int i8 = i5;
                        com.anythink.expressad.foundation.d.c a2 = com.anythink.expressad.foundation.d.c.a(optJSONArray.optJSONObject(i7), jSONObject2.optString(str16), jSONObject2.optString(str17), jSONObject2.optString(str19), false, r5, str);
                        if (a2 != null) {
                            a2.k(i6);
                            a2.r(optString);
                            a2.j(i8);
                            a2.a((java.util.List<java.lang.String>) arrayList);
                            str4 = str20;
                            a2.s(str4);
                            a2.d(r5.s());
                            a2.c(r5.t());
                            a2.c(((com.anythink.expressad.foundation.d.d) r5).an);
                            arrayList2.add(a2);
                        } else {
                            str4 = str20;
                            ((com.anythink.expressad.foundation.d.d) r5).M = str18;
                        }
                        i7++;
                        str15 = str18;
                        i5 = i8;
                        str12 = str4;
                        str11 = str19;
                        optJSONArray = jSONArray;
                        jSONObject2 = jSONObject;
                        str13 = str17;
                    }
                    r5.J = arrayList2;
                }
                dVar2 = r5;
                return dVar2;
            }
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            java.lang.String str21 = "parse campaign error ,campaign is null";
            java.lang.String str22 = optString;
            int i9 = 0;
            java.lang.String str23 = r5;
            while (i9 < optJSONArray2.length()) {
                org.json.JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i9);
                int i10 = i9;
                org.json.JSONArray jSONArray2 = optJSONObject2.getJSONArray(str7);
                java.lang.String str24 = str7;
                java.util.ArrayList arrayList4 = new java.util.ArrayList();
                java.lang.String str25 = str8;
                org.json.JSONObject jSONObject5 = optJSONObject2;
                int i11 = 0;
                java.lang.String str26 = str23;
                while (i11 < jSONArray2.length()) {
                    org.json.JSONObject optJSONObject3 = jSONArray2.optJSONObject(i11);
                    java.lang.String optString3 = jSONObject2.optString(str9);
                    java.lang.String optString4 = jSONObject2.optString(str10);
                    java.lang.String str27 = str3;
                    java.lang.String str28 = str21;
                    org.json.JSONObject jSONObject6 = jSONObject5;
                    org.json.JSONArray jSONArray3 = optJSONArray2;
                    java.lang.String str29 = str2;
                    java.lang.String str30 = str10;
                    int i12 = i2;
                    java.lang.String str31 = str9;
                    java.util.ArrayList arrayList5 = arrayList3;
                    java.lang.String str32 = str22;
                    int i13 = i10;
                    org.json.JSONArray jSONArray4 = jSONArray2;
                    int i14 = optInt;
                    java.lang.String str33 = str26;
                    com.anythink.expressad.foundation.d.d dVar3 = dVar;
                    com.anythink.expressad.foundation.d.c a3 = com.anythink.expressad.foundation.d.c.a(optJSONObject3, optString3, optString4, jSONObject2.optString(str3), false, dVar, str);
                    if (a3 != null) {
                        a3.i(dVar3.T);
                        a3.h(dVar3.U);
                        a3.g(dVar3.S);
                        a3.h(dVar3.R);
                        a3.f(jSONObject2.optInt("ad_type"));
                        a3.f(jSONObject2.optString(com.anythink.expressad.foundation.d.c.aS));
                        a3.g(jSONObject2.optString(com.anythink.expressad.foundation.d.c.aT));
                        a3.d(dVar3.s());
                        a3.c(dVar3.t());
                        a3.c(dVar3.an);
                        a3.k(i12);
                        a3.r(str32);
                        i3 = i14;
                        a3.j(i3);
                        a3.a((java.util.List<java.lang.String>) arrayList);
                        str5 = str29;
                        a3.s(str5);
                        arrayList4.add(a3);
                        str6 = str28;
                    } else {
                        str5 = str29;
                        i3 = i14;
                        str6 = str28;
                        dVar3.M = str6;
                    }
                    i11++;
                    optJSONArray2 = jSONArray3;
                    arrayList3 = arrayList5;
                    str3 = str27;
                    jSONObject5 = jSONObject6;
                    str21 = str6;
                    jSONArray2 = jSONArray4;
                    i10 = i13;
                    str22 = str32;
                    str9 = str31;
                    i2 = i12;
                    str10 = str30;
                    str2 = str5;
                    optInt = i3;
                    dVar = dVar3;
                    str26 = str33;
                }
                java.lang.String str34 = str26;
                com.anythink.expressad.foundation.d.d dVar4 = dVar;
                org.json.JSONObject jSONObject7 = jSONObject5;
                java.util.ArrayList arrayList6 = arrayList3;
                int i15 = optInt;
                java.lang.String str35 = str2;
                java.lang.String str36 = str10;
                int i16 = i2;
                com.anythink.expressad.out.l lVar = new com.anythink.expressad.out.l();
                lVar.b(jSONObject2.optString("parent_session_id"));
                lVar.a(jSONObject2.optString(str34));
                lVar.a(arrayList4);
                lVar.a(jSONObject7.optInt(str25));
                arrayList6.add(lVar);
                arrayList3 = arrayList6;
                str22 = str22;
                optJSONArray2 = optJSONArray2;
                str9 = str9;
                str7 = str24;
                i2 = i16;
                str21 = str21;
                str10 = str36;
                i9 = i10 + 1;
                str8 = str25;
                str2 = str35;
                optInt = i15;
                dVar = dVar4;
                str23 = str34;
                str3 = str3;
            }
            com.anythink.expressad.foundation.d.d dVar5 = dVar;
            dVar5.ae = arrayList3;
            return dVar5;
        }
        dVar2 = null;
        return dVar2;
    }

    private void b(int i2) {
        this.U = i2;
    }

    private void b(java.lang.String str) {
        this.M = str;
    }

    private void b(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        this.ah = hashMap;
    }

    private void c(int i2) {
        this.al = i2;
    }

    private void c(java.lang.String str) {
        this.N = str;
    }

    private void d(int i2) {
        this.am = i2;
    }

    private void d(java.lang.String str) {
        this.O = str;
    }

    private void e(int i2) {
        this.ao = i2;
    }

    private void e(java.lang.String str) {
        this.P = str;
    }

    private void f(int i2) {
        this.Z = i2;
    }

    private void f(java.lang.String str) {
        this.Q = str;
    }

    private java.lang.String g() {
        return this.M;
    }

    private void g(int i2) {
        this.ad = i2;
    }

    private void g(java.lang.String str) {
        this.R = str;
    }

    private java.lang.String h() {
        return this.N;
    }

    private void h(java.lang.String str) {
        this.T = str;
    }

    private java.lang.String i() {
        return this.O;
    }

    private void i(java.lang.String str) {
        this.V = str;
    }

    private java.lang.String j() {
        return this.P;
    }

    private void j(java.lang.String str) {
        this.W = str;
    }

    private java.lang.String k() {
        return this.Q;
    }

    private void k(java.lang.String str) {
        this.an = str;
    }

    private java.lang.String l() {
        return this.R;
    }

    private void l(java.lang.String str) {
        this.ai = str;
    }

    private int m() {
        return this.S;
    }

    private void m(java.lang.String str) {
        this.aj = str;
    }

    private java.lang.String n() {
        return this.T;
    }

    private void n(java.lang.String str) {
        this.ak = str;
    }

    private int o() {
        return this.U;
    }

    private void o(java.lang.String str) {
        this.X = str;
    }

    private java.lang.String p() {
        return this.V;
    }

    private void p(java.lang.String str) {
        this.Y = str;
    }

    private java.lang.String q() {
        return this.W;
    }

    private void q(java.lang.String str) {
        this.aa = str;
    }

    private java.lang.String r() {
        return this.an;
    }

    private void r(java.lang.String str) {
        this.ab = str;
    }

    private int s() {
        int i2 = this.al;
        if (i2 > 1) {
            return i2;
        }
        return 1;
    }

    private void s(java.lang.String str) {
        this.ac = str;
    }

    private int t() {
        int i2 = this.am;
        if (i2 == 1) {
            return i2;
        }
        return 0;
    }

    private java.lang.String u() {
        return this.ai;
    }

    private java.lang.String v() {
        return this.aj;
    }

    private java.lang.String w() {
        return this.ak;
    }

    private int x() {
        return this.ao;
    }

    private java.util.List<com.anythink.expressad.out.l> y() {
        return this.ae;
    }

    private java.lang.String z() {
        return this.Y;
    }

    public final java.util.HashMap<java.lang.String, java.lang.String> a() {
        return this.ag;
    }

    public final java.util.HashMap<java.lang.String, java.lang.String> b() {
        return this.ah;
    }

    public final java.lang.String c() {
        return this.X;
    }

    public final int d() {
        return this.Z;
    }

    public final java.lang.String e() {
        java.lang.StringBuffer stringBuffer = this.af;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.af.toString();
        }
        try {
            java.lang.String f2 = com.anythink.core.common.o.e.f();
            java.lang.String c2 = com.anythink.core.common.o.e.c(com.anythink.core.common.b.o.a().f());
            java.lang.String b2 = com.anythink.core.common.o.e.b(com.anythink.core.common.b.o.a().f());
            com.anythink.core.common.b.o.a().f();
            java.lang.String valueOf = java.lang.String.valueOf(com.anythink.expressad.foundation.h.k.a());
            java.lang.String str = com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.o.a().f()) + "x" + com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.o.a().f());
            java.lang.StringBuffer stringBuffer2 = this.af;
            stringBuffer2.append(this.Z);
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) "1"));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) android.os.Build.VERSION.RELEASE));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) com.anythink.expressad.out.b.a));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) com.anythink.core.common.o.e.a()));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) str));
            stringBuffer2.append("|");
            stringBuffer2.append(a(java.lang.Integer.valueOf(com.anythink.expressad.foundation.h.k.b(com.anythink.expressad.foundation.b.a.b().d()))));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) com.anythink.core.common.o.e.f(com.anythink.expressad.foundation.b.a.b().d())));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) valueOf));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) b2));
            stringBuffer2.append(a((java.lang.Object) c2));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) "at_device1"));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) "at_device2"));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) com.anythink.core.common.o.e.d(com.anythink.core.common.b.o.a().f())));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) f2));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) ""));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) com.anythink.core.common.o.e.b()));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) ""));
            stringBuffer2.append("||");
            stringBuffer2.append(a((java.lang.Object) ""));
            stringBuffer2.append("|");
            stringBuffer2.append(a((java.lang.Object) (com.anythink.core.common.b.o.a().y() + "," + com.anythink.core.common.b.o.a().z())));
            stringBuffer2.append("|");
            this.af = stringBuffer2;
            com.anythink.core.api.IExHandler b3 = com.anythink.core.common.b.o.a().b();
            if (b3 != null) {
                return b3.fillCDataParam(this.af.toString());
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        java.lang.String stringBuffer3 = this.af.toString();
        stringBuffer3.replaceAll("at_device1", "");
        stringBuffer3.replaceAll("at_device2", "");
        return stringBuffer3;
    }

    public final java.lang.String f() {
        try {
            if (!android.text.TextUtils.isEmpty(this.ap)) {
                return this.ap;
            }
            if (android.text.TextUtils.isEmpty(this.ac)) {
                return "";
            }
            android.net.Uri parse = android.net.Uri.parse(this.ac);
            if (parse != null) {
                this.ap = parse.getQueryParameter("k");
            }
            return this.ap;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
