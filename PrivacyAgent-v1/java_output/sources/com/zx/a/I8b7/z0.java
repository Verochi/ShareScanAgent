package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public abstract class z0 {
    public com.zx.sdk.api.ZXID a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String trim;
        java.lang.String str4 = null;
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        com.zx.sdk.api.ZXID zxid = new com.zx.sdk.api.ZXID();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(jSONObject.getString("ext"));
            org.json.JSONObject optJSONObject = jSONObject2.optJSONObject("aids");
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
            if (optJSONObject2 == null) {
                try {
                    android.content.Context context = com.zx.a.I8b7.m3.a;
                    if (com.zx.a.I8b7.m3.e == null) {
                        com.zx.a.I8b7.x1.d(context);
                    }
                    if (!android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.e)) {
                        try {
                            str3 = com.zx.a.I8b7.x1.b(com.zx.a.I8b7.m3.a).getString("ZX_APPID");
                        } catch (java.lang.Exception e) {
                            com.zx.a.I8b7.r2.a(e);
                            str3 = null;
                        }
                        trim = str3.trim();
                    } else {
                        trim = com.zx.a.I8b7.x1.a(com.zx.a.I8b7.x1.c(com.zx.a.I8b7.m3.a)).trim();
                    }
                    optJSONObject2 = optJSONObject.optJSONObject(trim);
                } catch (java.lang.Throwable unused) {
                }
            }
            zxid.setAids(optJSONObject2 == null ? "" : optJSONObject2.toString());
            org.json.JSONArray optJSONArray = jSONObject2.optJSONArray(com.baidu.mobads.sdk.internal.bm.l);
            if (optJSONArray != null) {
                str4 = optJSONArray.toString();
            }
            zxid.setTags(str4);
            java.lang.String optString = jSONObject.optString(com.umeng.analytics.pro.bo.al);
            zxid.setValue(optString);
            java.lang.String[] split = optString.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            zxid.setVersion(split[0]);
            zxid.setExpiredTime(java.lang.Long.parseLong(split[1]) * 1000);
            java.lang.String optString2 = jSONObject2.optString("openid");
            if (!android.text.TextUtils.isEmpty(optString2) && !"OPENID_CLOSED".equals(optString2)) {
                zxid.setOpenid(optString2);
            }
            zxid.setOT(jSONObject2.optInt(com.anythink.expressad.foundation.g.a.J));
        } catch (java.lang.Exception e2) {
            try {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(str2);
                java.lang.String string = jSONObject3.getString("ext");
                zxid.setValue(jSONObject3.getString(com.umeng.analytics.pro.bo.al));
                zxid.setAids(string);
            } catch (java.lang.Throwable unused2) {
            }
            com.zx.a.I8b7.r2.a(e2);
        }
        return zxid;
    }

    public abstract void a(java.lang.String str);
}
