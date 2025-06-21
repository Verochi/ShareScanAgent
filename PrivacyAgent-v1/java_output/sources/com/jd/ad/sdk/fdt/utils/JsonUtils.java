package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class JsonUtils {
    public static org.json.JSONObject getJSONObject(java.lang.String str, android.content.Context context) {
        return new org.json.JSONObject(getJson(str, context));
    }

    public static java.lang.String getJson(java.lang.String str, android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(context.getAssets().open(str)));
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(readLine);
        }
    }

    public static org.json.JSONObject parse2JSONObject(java.lang.String str) {
        if (str != null) {
            try {
                return new org.json.JSONObject(str);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return new org.json.JSONObject();
    }

    public static org.json.JSONObject put(org.json.JSONObject jSONObject, java.lang.String str, java.lang.Object obj) {
        if (jSONObject != null && obj != null) {
            try {
                if (!(obj instanceof java.lang.String) && !(obj instanceof java.lang.Integer) && (obj instanceof java.lang.Double) && java.lang.Double.isNaN(((java.lang.Double) obj).doubleValue())) {
                    obj = -1;
                }
                jSONObject.put(str, obj);
                return jSONObject;
            } catch (org.json.JSONException e) {
                com.jd.ad.sdk.logger.Logger.w("Json error: ", e.getMessage());
            }
        }
        return jSONObject;
    }
}
