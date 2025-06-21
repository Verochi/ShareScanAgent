package com.anythink.expressad.foundation.d;

/* loaded from: classes12.dex */
public class h extends com.anythink.expressad.out.j {
    public static final java.lang.String cA = "adv_id";
    public static final java.lang.String cB = "ttc_type";
    public static final java.lang.String cC = "ttc_ct2";
    public static final java.lang.String cD = "gh_id";
    public static final java.lang.String cE = "gh_path";
    public static final java.lang.String cF = "bind_id";
    public static final java.lang.String cG = "mark";
    public static final java.lang.String cH = "isPost";
    public static final int cI = 604800;
    public static final int cJ = 1800;
    public static final java.lang.String cK = "apk_download_start";
    public static final java.lang.String cL = "apk_download_end";
    public static final java.lang.String cM = "apk_install";
    public static final java.lang.String cN = "loopback";
    public static final java.lang.String cO = "domain";
    public static final java.lang.String cP = "key";
    public static final java.lang.String cQ = "value";
    public static final java.lang.String co = "h";
    public static final java.lang.String cp = "apk_alt";
    public static final java.lang.String cq = "disableApkAlt";
    public static final java.lang.String cr = "apk_info";
    public static final java.lang.String cs = "ntbarpt";
    public static final java.lang.String ct = "ntbarpasbl";
    public static final java.lang.String cu = "atat_type";
    public static final java.lang.String cv = "akdlui";
    public static final java.lang.String cw = "ttc";
    public static final java.lang.String cx = "ttc_ct";
    public static final java.lang.String cy = "ttc_pe";
    public static final java.lang.String cz = "ttc_po";
    private static final long l = 1;
    private com.anythink.expressad.foundation.d.a d;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private int n;
    private java.lang.String o;
    private int p;
    private java.util.Map<java.lang.String, java.lang.String> q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f240s;
    private int t;
    private int u;
    private com.anythink.expressad.a.c.b v;
    private int a = 0;
    private int b = 0;
    private java.lang.String c = "";
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private java.lang.String h = "";
    private boolean m = false;

    public static com.anythink.expressad.foundation.d.c a(org.json.JSONObject jSONObject, com.anythink.expressad.foundation.d.c cVar) {
        if (jSONObject == null) {
            return null;
        }
        try {
            ((com.anythink.expressad.foundation.d.h) cVar).m = jSONObject.optBoolean(cw);
            ((com.anythink.expressad.foundation.d.h) cVar).n = jSONObject.optInt(cx, 604800);
            ((com.anythink.expressad.foundation.d.h) cVar).f240s = jSONObject.optString(cA);
            ((com.anythink.expressad.foundation.d.h) cVar).t = jSONObject.optInt("ttc_type", 3);
            ((com.anythink.expressad.foundation.d.h) cVar).u = jSONObject.optInt(cC, 1800);
            cVar.a(java.lang.System.currentTimeMillis());
            cVar.m(jSONObject.optString(com.anythink.expressad.foundation.d.d.f));
            cVar.n(jSONObject.optString(com.anythink.expressad.foundation.d.d.k));
            ((com.anythink.expressad.foundation.d.h) cVar).o = jSONObject.optString(cG);
            ((com.anythink.expressad.foundation.d.h) cVar).p = jSONObject.optInt(cH);
            try {
                if (jSONObject.has(cN)) {
                    java.lang.String optString = jSONObject.optString(cN);
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        ((com.anythink.expressad.foundation.d.h) cVar).r = optString;
                        ((com.anythink.expressad.foundation.d.h) cVar).q = h(optString);
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            java.lang.String optString2 = jSONObject.optString(cD);
            if (!android.text.TextUtils.isEmpty(optString2)) {
                ((com.anythink.expressad.foundation.d.h) cVar).i = optString2;
                java.lang.String optString3 = jSONObject.optString(cE);
                if (!android.text.TextUtils.isEmpty(optString3)) {
                    ((com.anythink.expressad.foundation.d.h) cVar).j = com.anythink.expressad.foundation.h.j.b(optString3);
                }
                ((com.anythink.expressad.foundation.d.h) cVar).k = jSONObject.optString(cF);
            }
            ((com.anythink.expressad.foundation.d.h) cVar).a = jSONObject.optInt(cp, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).b = jSONObject.optInt(cq, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).d = com.anythink.expressad.foundation.d.a.a(jSONObject.optString(cr));
            ((com.anythink.expressad.foundation.d.h) cVar).f = jSONObject.optInt(ct, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).e = jSONObject.optInt(cs, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).g = jSONObject.optInt(cu, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).h = jSONObject.optString(cv, "");
            return cVar;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            return cVar;
        }
    }

    public static java.lang.String a(com.anythink.expressad.foundation.d.d dVar, com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
        if (dVar != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                java.util.HashMap<java.lang.String, java.lang.String> a = dVar.a();
                if (a != null) {
                    a.entrySet().iterator();
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : a.entrySet()) {
                        java.lang.String key = entry.getKey();
                        str = str.replaceAll("\\{" + key + "\\}", entry.getValue());
                    }
                }
                java.util.HashMap<java.lang.String, java.lang.String> z = cVar.z();
                if (z != null) {
                    z.entrySet().iterator();
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : z.entrySet()) {
                        java.lang.String key2 = entry2.getKey();
                        str = str.replaceAll("\\{" + key2 + "\\}", entry2.getValue());
                    }
                }
                java.util.HashMap<java.lang.String, java.lang.String> b = dVar.b();
                if (b != null) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry3 : b.entrySet()) {
                        java.lang.String key3 = entry3.getKey();
                        str = str.replaceAll("\\{" + key3 + "\\}", entry3.getValue());
                    }
                }
                str = str.replaceAll("\\{c\\}", java.net.URLEncoder.encode(dVar.e(), "utf-8"));
                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("=\\{.*?\\}").matcher(str);
                while (matcher.find()) {
                    str = str.replace(matcher.group(0), com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        return str;
    }

    private java.util.Map<java.lang.String, java.lang.String> a() {
        return this.q;
    }

    private void a(int i) {
        this.b = i;
    }

    private void a(com.anythink.expressad.foundation.d.a aVar) {
        this.d = aVar;
    }

    private void a(java.lang.String str) {
        this.h = str;
    }

    private void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.q = map;
    }

    private void a(boolean z) {
        this.m = z;
    }

    public static com.anythink.expressad.foundation.d.c b(org.json.JSONObject jSONObject, com.anythink.expressad.foundation.d.c cVar) {
        if (jSONObject == null) {
            return null;
        }
        try {
            ((com.anythink.expressad.foundation.d.h) cVar).m = jSONObject.optBoolean(cw);
            ((com.anythink.expressad.foundation.d.h) cVar).n = jSONObject.optInt(cx, 604800);
            ((com.anythink.expressad.foundation.d.h) cVar).f240s = jSONObject.optString(cA);
            ((com.anythink.expressad.foundation.d.h) cVar).t = jSONObject.optInt("ttc_type", 3);
            ((com.anythink.expressad.foundation.d.h) cVar).u = jSONObject.optInt(cC, 1800);
            ((com.anythink.expressad.foundation.d.h) cVar).o = jSONObject.optString(cG);
            ((com.anythink.expressad.foundation.d.h) cVar).p = jSONObject.optInt(cH);
            try {
                if (jSONObject.has(cN)) {
                    java.lang.String optString = jSONObject.optString(cN);
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        ((com.anythink.expressad.foundation.d.h) cVar).r = optString;
                        ((com.anythink.expressad.foundation.d.h) cVar).q = h(optString);
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            java.lang.String optString2 = jSONObject.optString(cD);
            if (!android.text.TextUtils.isEmpty(optString2)) {
                ((com.anythink.expressad.foundation.d.h) cVar).i = optString2;
                java.lang.String optString3 = jSONObject.optString(cE);
                if (!android.text.TextUtils.isEmpty(optString3)) {
                    ((com.anythink.expressad.foundation.d.h) cVar).j = com.anythink.expressad.foundation.h.j.b(optString3);
                }
                ((com.anythink.expressad.foundation.d.h) cVar).k = jSONObject.optString(cF);
            }
            cVar.e(jSONObject.optString("cam_html"));
            cVar.b(jSONObject.optString("cam_html"));
            ((com.anythink.expressad.foundation.d.h) cVar).a = jSONObject.optInt(cp, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).b = jSONObject.optInt(cq, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).d = com.anythink.expressad.foundation.d.a.a(jSONObject.optString(cr));
            ((com.anythink.expressad.foundation.d.h) cVar).f = jSONObject.optInt(ct, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).e = jSONObject.optInt(cs, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).g = jSONObject.optInt(cu, 0);
            ((com.anythink.expressad.foundation.d.h) cVar).h = jSONObject.optString(cv, "");
            return cVar;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            return cVar;
        }
    }

    private java.lang.String b() {
        return this.r;
    }

    private void b(int i) {
        this.a = i;
    }

    private void b(java.lang.String str) {
        this.i = str;
    }

    private static org.json.JSONObject c(org.json.JSONObject jSONObject, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return jSONObject;
        }
        jSONObject.put(cw, ((com.anythink.expressad.foundation.d.h) cVar).m);
        jSONObject.put(cx, ((com.anythink.expressad.foundation.d.h) cVar).n);
        jSONObject.put(cA, ((com.anythink.expressad.foundation.d.h) cVar).f240s);
        jSONObject.put("ttc_type", ((com.anythink.expressad.foundation.d.h) cVar).t);
        jSONObject.put(cC, ((com.anythink.expressad.foundation.d.h) cVar).u);
        jSONObject.put(cD, ((com.anythink.expressad.foundation.d.h) cVar).i);
        jSONObject.put(cE, com.anythink.expressad.foundation.h.j.a(((com.anythink.expressad.foundation.d.h) cVar).j));
        jSONObject.put(cF, ((com.anythink.expressad.foundation.d.h) cVar).k);
        jSONObject.put(cp, ((com.anythink.expressad.foundation.d.h) cVar).a);
        jSONObject.put(cq, ((com.anythink.expressad.foundation.d.h) cVar).b);
        com.anythink.expressad.foundation.d.a aVar = ((com.anythink.expressad.foundation.d.h) cVar).d;
        if (aVar != null) {
            jSONObject.put(cr, aVar.g());
        }
        jSONObject.put(cG, ((com.anythink.expressad.foundation.d.h) cVar).o);
        jSONObject.put(cH, ((com.anythink.expressad.foundation.d.h) cVar).p);
        jSONObject.put(com.anythink.expressad.foundation.d.c.bc, cVar.x());
        jSONObject.put(ct, ((com.anythink.expressad.foundation.d.h) cVar).f);
        jSONObject.put(cs, ((com.anythink.expressad.foundation.d.h) cVar).e);
        jSONObject.put(cu, ((com.anythink.expressad.foundation.d.h) cVar).g);
        jSONObject.put(cv, ((com.anythink.expressad.foundation.d.h) cVar).h);
        return jSONObject;
    }

    private void c(int i) {
        this.e = i;
    }

    private void c(java.lang.String str) {
        this.j = str;
    }

    private void d(int i) {
        this.f = i;
    }

    private void d(java.lang.String str) {
        this.k = str;
    }

    private void e(int i) {
        this.g = i;
    }

    private void e(java.lang.String str) {
        this.r = str;
    }

    private void f(int i) {
        this.p = i;
    }

    private void f(java.lang.String str) {
        this.o = str;
    }

    private void g(int i) {
        this.u = i;
    }

    private void g(java.lang.String str) {
        this.f240s = str;
    }

    private static java.util.Map<java.lang.String, java.lang.String> h(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                hashMap.put("domain", jSONObject.getString("domain"));
                hashMap.put("key", jSONObject.getString("key"));
                hashMap.put("value", jSONObject.getString("value"));
            } catch (java.lang.Throwable unused) {
            }
            return hashMap;
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    private void h(int i) {
        this.t = i;
    }

    private void i(int i) {
        this.n = i;
    }

    public void a(com.anythink.expressad.a.c.b bVar) {
        this.v = bVar;
    }

    public final com.anythink.expressad.foundation.d.a aG() {
        return this.d;
    }

    public final int aH() {
        return this.b;
    }

    public final int aI() {
        return this.a;
    }

    public final int aJ() {
        return this.e;
    }

    public final int aK() {
        return this.f;
    }

    public final int aL() {
        return this.g;
    }

    public final java.lang.String aM() {
        return this.h;
    }

    public final java.lang.String aN() {
        return this.i;
    }

    public final java.lang.String aO() {
        return this.j;
    }

    @java.lang.Deprecated
    public final java.lang.String aP() {
        return this.k;
    }

    public final java.lang.String aQ() {
        return this.o;
    }

    public final int aR() {
        return this.p;
    }

    public final int aS() {
        return this.u;
    }

    public final int aT() {
        return this.t;
    }

    public final java.lang.String aU() {
        return this.f240s;
    }

    public final int aV() {
        return this.n;
    }

    public final boolean aW() {
        return this.m;
    }

    public com.anythink.expressad.a.c.b aj() {
        return this.v;
    }

    public final boolean b(com.anythink.expressad.foundation.d.c cVar) {
        boolean z = this.a == 1 && cVar.Q() == 3 && ((com.anythink.expressad.foundation.d.h) cVar).b != 1;
        if (!z) {
            return z;
        }
        try {
            return com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), ba()) ? false : z;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return z;
        }
    }

    public final java.lang.String u(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map;
        try {
            if (android.text.TextUtils.isEmpty(str) || (map = this.q) == null || map.size() <= 0) {
                return str;
            }
            android.net.Uri parse = android.net.Uri.parse(str);
            java.lang.String host = parse.getHost();
            java.lang.String str2 = map.get("domain");
            if (android.text.TextUtils.isEmpty(host) || !host.contains(str2)) {
                return str;
            }
            java.lang.String str3 = map.get("key");
            java.lang.String str4 = map.get("value");
            if (!str.contains(str3) && android.text.TextUtils.isEmpty(parse.getQueryParameter(str3)) && !android.text.TextUtils.isEmpty(str3) && !android.text.TextUtils.isEmpty(str4)) {
                return str + "&" + str3 + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str4;
            }
            if (android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str4)) {
                return str;
            }
            return str.replace(str3 + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + (android.text.TextUtils.isEmpty(parse.getQueryParameter(str3)) ? "" : parse.getQueryParameter(str3)), str3 + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str4);
        } catch (java.lang.Throwable unused) {
            return str;
        }
    }
}
