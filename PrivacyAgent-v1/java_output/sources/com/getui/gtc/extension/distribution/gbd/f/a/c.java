package com.getui.gtc.extension.distribution.gbd.f.a;

/* loaded from: classes22.dex */
public final class c {
    public static com.getui.gtc.extension.distribution.gbd.f.a.c b = null;
    private static final java.lang.String c = "GBD_SPM";
    private static final java.lang.String d = "true";
    private static final java.lang.String e = "false";
    private static final java.lang.String f = "result";
    private static final java.lang.String g = "ok";
    private static final java.lang.String h = "services";
    private static final java.lang.String i = "gx_sp";
    private static final java.lang.String j = "sp_guard_services";
    public android.content.SharedPreferences a = com.getui.gtc.extension.distribution.gbd.d.c.d.getSharedPreferences(i, 0);

    private static com.getui.gtc.extension.distribution.gbd.f.a.c a() {
        if (b == null) {
            b = new com.getui.gtc.extension.distribution.gbd.f.a.c();
        }
        return b;
    }

    private void a(byte[] bArr) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr));
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "parseServiceConfig : ".concat(java.lang.String.valueOf(jSONObject)));
            com.getui.gtc.extension.distribution.gbd.n.j.a(c, "parseServiceConfig : ".concat(java.lang.String.valueOf(jSONObject)));
            if (jSONObject.has("result") && jSONObject.has(h)) {
                java.lang.String string = jSONObject.getString(h);
                if (android.text.TextUtils.isEmpty(string)) {
                    return;
                }
                android.content.SharedPreferences.Editor edit = this.a.edit();
                edit.putString(j, com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.n.t.b(string.getBytes("UTF-8"), com.getui.gtc.extension.distribution.gbd.d.g.V), 0));
                edit.apply();
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private java.lang.String b() {
        try {
            java.lang.String string = this.a.getString(j, "");
            if (android.text.TextUtils.isEmpty(string)) {
                return string;
            }
            java.lang.String str = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.t.a(com.getui.gtc.extension.distribution.gbd.n.e.a(string.toCharArray(), 0), com.getui.gtc.extension.distribution.gbd.d.g.V), "utf-8");
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "readServiceConfig : ".concat(str));
            return str;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }
}
