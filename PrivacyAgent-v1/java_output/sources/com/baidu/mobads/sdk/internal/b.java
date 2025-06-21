package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class b {
    private int a = 0;
    private java.util.List<com.baidu.mobads.sdk.internal.a> b = new java.util.ArrayList();

    public static com.baidu.mobads.sdk.internal.b a(java.lang.String str) {
        com.baidu.mobads.sdk.internal.b bVar = new com.baidu.mobads.sdk.internal.b();
        if (android.text.TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            bVar.a = jSONObject.optInt(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, 0);
            int optInt = jSONObject.optInt("enc", 0);
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray(com.umeng.analytics.pro.bo.aC);
            if (optInt == 1) {
                java.lang.String optString = jSONObject.optString(com.umeng.analytics.pro.bo.aC);
                if (!android.text.TextUtils.isEmpty(optString)) {
                    java.lang.String b = com.baidu.mobads.sdk.internal.i.b(optString);
                    if (!android.text.TextUtils.isEmpty(b)) {
                        optJSONArray = new org.json.JSONArray(b);
                    }
                }
            }
            bVar.b = com.baidu.mobads.sdk.internal.a.a(optJSONArray);
            return bVar;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return bVar;
        }
    }

    public java.util.List<com.baidu.mobads.sdk.internal.a> a() {
        return this.b;
    }
}
