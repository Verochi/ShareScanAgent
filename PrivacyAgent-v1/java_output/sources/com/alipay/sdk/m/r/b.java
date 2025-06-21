package com.alipay.sdk.m.r;

/* loaded from: classes.dex */
public class b {
    public com.alipay.sdk.m.r.a a;
    public java.lang.String b;
    public java.lang.String[] c;

    public b(java.lang.String str) {
        this.b = str;
    }

    public b(java.lang.String str, com.alipay.sdk.m.r.a aVar) {
        this.b = str;
        this.a = aVar;
    }

    public static java.util.List<com.alipay.sdk.m.r.b> a(org.json.JSONObject jSONObject) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        java.lang.String[] a = a(jSONObject.optString("name", ""));
        for (int i = 0; i < a.length; i++) {
            com.alipay.sdk.m.r.a a2 = com.alipay.sdk.m.r.a.a(a[i]);
            if (a2 != com.alipay.sdk.m.r.a.None) {
                com.alipay.sdk.m.r.b bVar = new com.alipay.sdk.m.r.b(a[i], a2);
                bVar.c = b(a[i]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public static void a(com.alipay.sdk.m.r.b bVar) {
        java.lang.String[] c = bVar.c();
        if (c.length == 3 && android.text.TextUtils.equals("tid", c[0])) {
            com.alipay.sdk.m.t.a a = com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b());
            if (android.text.TextUtils.isEmpty(c[1]) || android.text.TextUtils.isEmpty(c[2])) {
                return;
            }
            a.a(c[1], c[2]);
        }
    }

    public static java.lang.String[] a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(com.alipay.sdk.m.u.i.b);
    }

    public static java.lang.String[] b(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (java.lang.String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[0]);
    }

    public com.alipay.sdk.m.r.a a() {
        return this.a;
    }

    public java.lang.String b() {
        return this.b;
    }

    public java.lang.String[] c() {
        return this.c;
    }
}
