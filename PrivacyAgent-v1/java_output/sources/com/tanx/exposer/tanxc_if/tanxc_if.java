package com.tanx.exposer.tanxc_if;

/* loaded from: classes19.dex */
public class tanxc_if {
    public static java.lang.String a;

    public static java.lang.String tanxc_do() {
        if (!android.text.TextUtils.isEmpty(a)) {
            return a;
        }
        com.tanx.exposer.tanxc_do tanxc_int = com.tanx.exposer.tanxc_for.tanxc_do().tanxc_int();
        if (tanxc_int == null) {
            return "";
        }
        java.lang.String tanxc_if = android.text.TextUtils.isEmpty(tanxc_int.tanxc_char()) ? tanxc_if(com.tanx.exposer.tanxc_for.tanxc_do().tanxc_for()) : tanxc_int.tanxc_char();
        java.lang.String tanxc_do = android.text.TextUtils.isEmpty(tanxc_int.tanxc_else()) ? tanxc_do(com.tanx.exposer.tanxc_for.tanxc_do().tanxc_for()) : tanxc_int.tanxc_else();
        if (android.text.TextUtils.isEmpty(tanxc_if) || android.text.TextUtils.isEmpty(tanxc_do)) {
            return "";
        }
        a = tanxc_if + com.alipay.sdk.m.u.i.b + tanxc_do + ";Android;" + android.os.Build.VERSION.RELEASE + com.alipay.sdk.m.u.i.b + android.os.Build.MODEL;
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("TANX_EXPOSE_UTIL", "getUserAgent: mUserAgent = " + a);
        }
        return a;
    }

    public static java.lang.String tanxc_do(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (java.lang.Exception e) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("TANX_EXPOSE_UTIL", "getVersionName: exception" + e.getMessage());
            return "";
        }
    }

    public static java.lang.String tanxc_do(java.lang.String str) {
        try {
            return java.lang.String.format("%032x", new java.math.BigInteger(1, java.security.MessageDigest.getInstance("MD5").digest(str.getBytes())));
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String tanxc_do(java.lang.String str, org.json.JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                java.lang.String optString = jSONObject.optString(next);
                if (!android.text.TextUtils.isEmpty(next) && !android.text.TextUtils.isEmpty(optString)) {
                    str = str.replace(next, optString);
                }
            }
        }
        return str;
    }

    public static java.lang.String tanxc_do(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null) {
            return null;
        }
        return new org.json.JSONObject(map).toString();
    }

    public static java.util.Map<java.lang.String, java.lang.Object> tanxc_do(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        java.util.HashMap hashMap = new java.util.HashMap();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            java.lang.Object opt = jSONObject.opt(next);
            if (!android.text.TextUtils.isEmpty(next) && opt != null) {
                hashMap.put(next, opt);
            }
        }
        return hashMap;
    }

    public static java.lang.String tanxc_if(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageName();
        } catch (java.lang.Exception e) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("TANX_EXPOSE_UTIL", "getVersionName: exception" + e.getMessage());
            return "";
        }
    }
}
