package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cy {
    public static java.lang.String a(java.lang.String str) {
        return android.util.Base64.encodeToString(com.xiaomi.push.ao.c(str), 2);
    }

    public static java.lang.String a(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        if (hashMap == null) {
            return "";
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            for (java.lang.String str : hashMap.keySet()) {
                jSONObject.put(str, hashMap.get(str));
            }
        } catch (org.json.JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return jSONObject.toString();
    }

    public static java.lang.String b(java.lang.String str) {
        return com.xiaomi.push.ao.b(android.util.Base64.decode(str, 2));
    }

    public static java.lang.String b(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        java.util.HashMap hashMap2 = new java.util.HashMap();
        if (hashMap != null) {
            hashMap2.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, hashMap.get(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE));
            hashMap2.put("description", hashMap.get("description"));
            java.lang.String str = hashMap.get("awake_info");
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                    hashMap2.put("__planId__", java.lang.String.valueOf(jSONObject.opt("__planId__")));
                    hashMap2.put("flow_id", java.lang.String.valueOf(jSONObject.opt("flow_id")));
                    hashMap2.put("jobkey", java.lang.String.valueOf(jSONObject.opt("jobkey")));
                    hashMap2.put(com.hihonor.push.sdk.common.constants.PushApiKeys.MSG_ID, java.lang.String.valueOf(jSONObject.opt(com.hihonor.push.sdk.common.constants.PushApiKeys.MSG_ID)));
                    hashMap2.put(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, java.lang.String.valueOf(jSONObject.opt("awake_app")));
                    hashMap2.put("B", java.lang.String.valueOf(jSONObject.opt("awakened_app")));
                    hashMap2.put(com.umeng.analytics.pro.bo.e, java.lang.String.valueOf(jSONObject.opt("awake_type")));
                } catch (org.json.JSONException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
        return a((java.util.HashMap<java.lang.String, java.lang.String>) hashMap2);
    }
}
