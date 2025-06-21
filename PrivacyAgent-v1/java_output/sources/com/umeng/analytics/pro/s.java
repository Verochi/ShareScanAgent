package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class s {
    public static long a(org.json.JSONArray jSONArray) {
        return jSONArray.toString().getBytes().length;
    }

    public static long a(org.json.JSONObject jSONObject) {
        return jSONObject.toString().getBytes().length;
    }

    public static org.json.JSONObject a(android.content.Context context, long j, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            if (!jSONObject.has("content")) {
                return jSONObject2;
            }
            org.json.JSONObject jSONObject3 = jSONObject.getJSONObject("content");
            if (jSONObject3.has("analytics")) {
                org.json.JSONObject jSONObject4 = jSONObject3.getJSONObject("analytics");
                if (jSONObject4.has("ekv")) {
                    jSONObject4.remove("ekv");
                }
                if (jSONObject4.has(com.umeng.analytics.pro.f.Z)) {
                    jSONObject4.remove(com.umeng.analytics.pro.f.Z);
                }
                if (jSONObject4.has("error")) {
                    jSONObject4.remove("error");
                }
                jSONObject3.put("analytics", jSONObject4);
            }
            jSONObject2.put("content", jSONObject3);
            if (jSONObject.has("header")) {
                jSONObject2.put("header", jSONObject.getJSONObject("header"));
            }
            if (a(jSONObject2) <= j) {
                return jSONObject2;
            }
            jSONObject2 = null;
            com.umeng.analytics.pro.k.a(context).i();
            com.umeng.analytics.pro.k.a(context).h();
            com.umeng.analytics.pro.k.a(context).b(true, false);
            com.umeng.analytics.pro.k.a(context).a();
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> u-app packet overload !!! ");
            return null;
        } catch (java.lang.Throwable unused) {
            return jSONObject2;
        }
    }
}
