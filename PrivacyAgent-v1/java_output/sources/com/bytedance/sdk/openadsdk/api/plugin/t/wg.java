package com.bytedance.sdk.openadsdk.api.plugin.t;

/* loaded from: classes22.dex */
public class wg {
    private static java.security.SecureRandom t() {
        java.security.SecureRandom instanceStrong;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return new java.security.SecureRandom();
        }
        try {
            instanceStrong = java.security.SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (java.lang.Throwable unused) {
            return new java.security.SecureRandom();
        }
    }

    public static java.lang.String vw() {
        java.lang.String vw = vw(16);
        if (vw == null || vw.length() != 32) {
            return null;
        }
        return vw;
    }

    public static java.lang.String vw(int i) {
        try {
            byte[] bArr = new byte[i];
            t().nextBytes(bArr);
            return com.bytedance.sdk.openadsdk.api.plugin.t.t.vw(bArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @com.bytedance.JProtect
    public static java.lang.String vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String vw = vw();
        java.lang.String vw2 = vw(vw, 32);
        java.lang.String wg = wg();
        return 3 + vw + wg + ((vw2 == null || wg == null) ? null : com.bytedance.sdk.openadsdk.api.plugin.t.vw.vw(str, wg, vw2));
    }

    public static java.lang.String vw(java.lang.String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    @com.bytedance.JProtect
    public static org.json.JSONObject vw(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                java.lang.String vw = vw(jSONObject.toString());
                if (android.text.TextUtils.isEmpty(vw)) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                } else {
                    jSONObject2.put("message", vw);
                    jSONObject2.put("cypher", 3);
                }
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static java.lang.String wg() {
        java.lang.String vw = vw(8);
        if (vw == null || vw.length() != 16) {
            return null;
        }
        return vw;
    }
}
