package com.anythink.expressad.foundation.d;

/* loaded from: classes12.dex */
public final class a implements com.anythink.expressad.e.b, java.io.Serializable {
    private static final java.lang.String a = "https://img.toponad.com/sdk/app-permissions.html?key=";
    private static java.lang.String b = "app_name";
    private static java.lang.String c = "perm_desc";
    private static java.lang.String d = "ori_perm_desc";
    private static java.lang.String e = "ori_perm_all";
    private static java.lang.String f = "pri_url";
    private static java.lang.String g = "upd_time";
    private static java.lang.String h = "app_ver";
    private static java.lang.String i = "dev_name";
    private java.lang.String j;
    private java.lang.String k;
    private java.util.ArrayList<java.lang.String> l = new java.util.ArrayList<>(3);
    private java.util.ArrayList<java.lang.String> m = new java.util.ArrayList<>(3);
    private java.util.ArrayList<java.lang.String> n = new java.util.ArrayList<>(3);
    private java.lang.String o;
    private java.lang.String p;
    private java.lang.String q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f233s;

    private static com.anythink.expressad.foundation.d.a a(com.anythink.expressad.foundation.d.a aVar) {
        return aVar == null ? new com.anythink.expressad.foundation.d.a() : aVar;
    }

    public static com.anythink.expressad.foundation.d.a a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return a(new org.json.JSONObject(str));
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static com.anythink.expressad.foundation.d.a a(org.json.JSONObject jSONObject) {
        com.anythink.expressad.foundation.d.a aVar = null;
        if (jSONObject.has(b)) {
            aVar = a((com.anythink.expressad.foundation.d.a) null);
            aVar.k = jSONObject.optString(b);
        }
        if (jSONObject.has(c)) {
            aVar = a(aVar);
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray(c);
            if (optJSONArray != null) {
                aVar.l = a(optJSONArray);
                java.util.ArrayList<java.lang.String> arrayList = aVar.n;
                java.lang.String str = a;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        if (optJSONArray.get(i2) instanceof java.lang.String) {
                            str = i2 == 0 ? str + optJSONArray.optString(i2) : str + "," + optJSONArray.optString(i2);
                        }
                    } catch (org.json.JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                aVar.o = str;
                aVar.n = arrayList;
            }
        }
        if (jSONObject.has(d)) {
            aVar = a(aVar);
            org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray(d);
            if (optJSONArray2 != null) {
                aVar.m = a(optJSONArray2);
                java.util.ArrayList<java.lang.String> arrayList2 = aVar.n;
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    try {
                        java.lang.Object obj = optJSONArray2.get(i3);
                        if (obj instanceof java.lang.String) {
                            arrayList2.add((java.lang.String) obj);
                        }
                    } catch (org.json.JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                aVar.n = arrayList2;
            }
        }
        if (jSONObject.has(f)) {
            aVar = a(aVar);
            aVar.p = jSONObject.optString(f);
        }
        if (jSONObject.has(g)) {
            aVar = a(aVar);
            aVar.q = jSONObject.optString(g);
        }
        if (jSONObject.has(h)) {
            aVar = a(aVar);
            aVar.r = jSONObject.optString(h);
        }
        if (jSONObject.has(i)) {
            aVar = a(aVar);
            aVar.f233s = jSONObject.optString(i);
        }
        if (aVar != null) {
            aVar.j = jSONObject.toString();
        }
        return aVar;
    }

    private static java.util.ArrayList<java.lang.String> a(org.json.JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        return arrayList;
    }

    private void a(java.util.ArrayList<java.lang.String> arrayList) {
        this.l = arrayList;
    }

    private void b(java.lang.String str) {
        this.j = str;
    }

    private void b(java.util.ArrayList<java.lang.String> arrayList) {
        this.m = arrayList;
    }

    private void c(java.lang.String str) {
        this.o = str;
    }

    private void c(java.util.ArrayList<java.lang.String> arrayList) {
        this.n = arrayList;
    }

    private static org.json.JSONArray d(java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        return jSONArray;
    }

    private void d(java.lang.String str) {
        this.k = str;
    }

    private void e(java.lang.String str) {
        this.p = str;
    }

    private void f(java.lang.String str) {
        this.q = str;
    }

    private void g(java.lang.String str) {
        this.r = str;
    }

    private java.lang.String h() {
        return this.j;
    }

    private void h(java.lang.String str) {
        this.f233s = str;
    }

    private java.util.ArrayList<java.lang.String> i() {
        return this.l;
    }

    private java.util.ArrayList<java.lang.String> j() {
        return this.m;
    }

    private java.util.ArrayList<java.lang.String> k() {
        return this.n;
    }

    public final java.lang.String a() {
        return this.o;
    }

    public final java.lang.String b() {
        return this.k;
    }

    public final java.lang.String c() {
        return this.p;
    }

    public final java.lang.String d() {
        return this.q;
    }

    public final java.lang.String e() {
        return this.r;
    }

    public final java.lang.String f() {
        return this.f233s;
    }

    public final org.json.JSONObject g() {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(this.j);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final java.lang.String toString() {
        return "ApkDisplayInfo{appName='" + this.k + "', permDescJArray=" + this.l + ", permDescOriJArray=" + this.m + ", permDescAll=" + this.n + ", priUrl='" + this.p + "', updateTime='" + this.q + "', appVersion='" + this.r + "', devName='" + this.f233s + "'}";
    }
}
