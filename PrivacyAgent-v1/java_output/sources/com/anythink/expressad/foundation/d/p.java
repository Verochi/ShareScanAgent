package com.anythink.expressad.foundation.d;

/* loaded from: classes12.dex */
public final class p implements com.anythink.expressad.e.b, java.io.Serializable {
    public static final java.lang.String a = "amount_max";
    public static final java.lang.String b = "callback_rule";
    public static final java.lang.String c = "virtual_currency";
    public static final java.lang.String d = "amount";
    public static final java.lang.String e = "icon";
    public static final java.lang.String f = "currency_id";
    public static final java.lang.String g = "name";
    private int h = 0;
    private int i = 1;
    private java.lang.String j = "";
    private int k = 1;
    private java.lang.String l = "";
    private int m = 1;
    private java.lang.String n = "Virtual Item";

    public static com.anythink.expressad.foundation.d.p a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.anythink.expressad.foundation.d.p pVar = new com.anythink.expressad.foundation.d.p();
            pVar.h = jSONObject.optInt("amount_max", 0);
            pVar.i = jSONObject.optInt("callback_rule", 1);
            pVar.j = jSONObject.optString("virtual_currency", "");
            pVar.l = jSONObject.optString("icon", "");
            pVar.m = jSONObject.optInt("currency_id", 1);
            if (jSONObject.has("amount")) {
                pVar.k = jSONObject.optInt("amount", 1);
            }
            if (jSONObject.has("name")) {
                pVar.n = jSONObject.optString("name", "Virtual Item");
            }
            return pVar;
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static com.anythink.expressad.foundation.d.p a(org.json.JSONObject jSONObject) {
        com.anythink.expressad.foundation.d.p pVar = new com.anythink.expressad.foundation.d.p();
        pVar.h = jSONObject.optInt("amount_max", 0);
        pVar.i = jSONObject.optInt("callback_rule", 1);
        pVar.j = jSONObject.optString("virtual_currency", "");
        pVar.l = jSONObject.optString("icon", "");
        pVar.m = jSONObject.optInt("currency_id", 1);
        if (jSONObject.has("amount")) {
            pVar.k = jSONObject.optInt("amount", 1);
        }
        if (jSONObject.has("name")) {
            pVar.n = jSONObject.optString("name", "Virtual Item");
        }
        return pVar;
    }

    private void a(int i) {
        this.h = i;
    }

    private void b(int i) {
        this.i = i;
    }

    private void b(java.lang.String str) {
        this.j = str;
    }

    private void c(int i) {
        this.k = i;
    }

    private void c(java.lang.String str) {
        this.l = str;
    }

    private int d() {
        return this.h;
    }

    private void d(int i) {
        this.m = i;
    }

    private void d(java.lang.String str) {
        this.n = str;
    }

    private int e() {
        return this.i;
    }

    private java.lang.String f() {
        return this.j;
    }

    private java.lang.String g() {
        return this.l;
    }

    private int h() {
        return this.m;
    }

    public final int a() {
        return this.k;
    }

    public final java.lang.String b() {
        return this.n;
    }

    public final org.json.JSONObject c() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("amount_max", this.h);
            jSONObject.put("callback_rule", this.i);
            jSONObject.put("virtual_currency", this.j);
            jSONObject.put("amount", this.k);
            jSONObject.put("icon", this.l);
            jSONObject.put("currency_id", this.m);
            jSONObject.put("name", this.n);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
