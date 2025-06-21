package com.aliyun.utils;

/* loaded from: classes12.dex */
public class e {
    public static int a(org.json.JSONObject jSONObject, java.lang.String... strArr) {
        if (jSONObject == null) {
            return 0;
        }
        for (java.lang.String str : strArr) {
            try {
                return jSONObject.getInt(str);
            } catch (org.json.JSONException unused) {
            }
        }
        for (java.lang.String str2 : strArr) {
            com.cicada.player.utils.Logger.w("JsonUtil", "No json int value for " + str2);
        }
        return 0;
    }

    public static long b(org.json.JSONObject jSONObject, java.lang.String... strArr) {
        if (jSONObject == null) {
            return 0L;
        }
        for (java.lang.String str : strArr) {
            try {
                return jSONObject.getLong(str);
            } catch (org.json.JSONException unused) {
            }
        }
        for (java.lang.String str2 : strArr) {
            com.cicada.player.utils.Logger.w("JsonUtil", "No json long value for " + str2);
        }
        return 0L;
    }
}
