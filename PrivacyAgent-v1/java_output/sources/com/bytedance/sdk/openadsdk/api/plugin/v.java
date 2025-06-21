package com.bytedance.sdk.openadsdk.api.plugin;

/* loaded from: classes22.dex */
public class v {
    private long t;
    private java.util.Map<java.lang.String, java.lang.Long> v = new java.util.HashMap();
    private java.lang.String vw;
    private long wg;

    private v(java.lang.String str, long j) {
        this.vw = str;
        this.wg = j;
        this.t = j;
    }

    public static com.bytedance.sdk.openadsdk.api.plugin.v vw(java.lang.String str) {
        return new com.bytedance.sdk.openadsdk.api.plugin.v(str, android.os.SystemClock.elapsedRealtime());
    }

    public long vw() {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.wg;
        this.v.put(this.vw, java.lang.Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void vw(org.json.JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry : this.v.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.Long value = entry.getValue();
            if (!android.text.TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (org.json.JSONException unused) {
                }
            }
        }
    }

    public long wg() {
        return this.wg;
    }

    public long wg(java.lang.String str) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.t;
        this.t = android.os.SystemClock.elapsedRealtime();
        this.v.put(str, java.lang.Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }
}
