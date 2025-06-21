package com.efs.sdk.base.core.config.remote;

/* loaded from: classes22.dex */
public final class c {
    private static final java.text.SimpleDateFormat a = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss", java.util.Locale.CHINA);

    private static void a(java.util.Map<java.lang.String, java.lang.String> map, org.json.JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                org.json.JSONObject jSONObject = (org.json.JSONObject) jSONArray.get(i);
                if (jSONObject != null && jSONObject.length() >= 2) {
                    java.lang.String optString = jSONObject.optString("opt");
                    java.lang.Object opt = jSONObject.opt("set");
                    if (optString != null && opt != null) {
                        java.lang.String optString2 = jSONObject.optString("lt", null);
                        java.lang.String optString3 = jSONObject.optString(com.alipay.sdk.m.k.b.k, null);
                        if (optString2 != null) {
                            optString = optString + "_" + optString2;
                        }
                        if (optString3 != null) {
                            optString = optString + "_" + optString3;
                        }
                        map.put(optString, java.lang.String.valueOf(opt));
                    }
                }
            } catch (java.lang.Throwable th) {
                com.efs.sdk.base.core.util.Log.e("efs.config", "updateConfigCond error", th);
                return;
            }
        }
    }

    public static boolean a(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.efs.sdk.base.core.config.remote.RemoteConfig remoteConfig) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("config");
            int i = jSONObject.getInt("cver");
            java.lang.String str2 = "";
            if (optJSONObject != null && optJSONObject.length() > 0) {
                org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("common");
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    java.util.Iterator<java.lang.String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        java.lang.String next = keys.next();
                        hashMap.put(next, optJSONObject2.optString(next, ""));
                    }
                }
                org.json.JSONArray optJSONArray = optJSONObject.optJSONArray("app_configs");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        org.json.JSONObject jSONObject2 = (org.json.JSONObject) optJSONArray.get(i2);
                        if (jSONObject2 != null && jSONObject2.length() == 2) {
                            org.json.JSONArray optJSONArray2 = jSONObject2.optJSONArray("conditions");
                            org.json.JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_ACTIONS);
                            if (optJSONArray2 != null && optJSONArray3 != null && optJSONArray3.length() > 0) {
                                a(hashMap, optJSONArray3);
                            }
                        }
                    }
                }
                str2 = optJSONObject.optString("sign");
            }
            remoteConfig.a(hashMap);
            remoteConfig.mConfigVersion = i;
            remoteConfig.a(str2);
            return true;
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.config", "parseConfig error, data is ".concat(java.lang.String.valueOf(str)), th);
            return false;
        }
    }
}
