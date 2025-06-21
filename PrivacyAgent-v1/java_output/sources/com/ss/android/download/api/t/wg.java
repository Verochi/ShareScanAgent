package com.ss.android.download.api.t;

/* loaded from: classes19.dex */
public class wg {
    public static long vw(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return java.lang.Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (java.lang.NumberFormatException unused) {
            return 0L;
        }
    }

    public static java.lang.String vw(java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (!android.text.TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    @androidx.annotation.NonNull
    public static org.json.JSONObject vw(org.json.JSONObject jSONObject) {
        return vw(jSONObject, new org.json.JSONObject());
    }

    public static org.json.JSONObject vw(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    @androidx.annotation.NonNull
    public static org.json.JSONObject vw(org.json.JSONObject... jSONObjectArr) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (jSONObjectArr != null && jSONObjectArr.length != 0) {
            for (org.json.JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    vw(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    public static boolean vw(com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, java.lang.String str) {
        if (downloadSetting == null || downloadSetting.optInt("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }
}
