package com.bytedance.pangle.provider;

/* loaded from: classes12.dex */
public final class b {
    public static java.lang.String a(java.lang.String str, java.lang.String str2, android.net.Uri uri) {
        if (str2 == null || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.bytedance.pangle.provider.ContentProviderManager.PLUGIN_PROCESS_NAME, str);
            jSONObject.put("plugin_pkg_name", str2);
            jSONObject.put("uri", uri != null ? uri.toString() : "");
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject.toString();
    }
}
