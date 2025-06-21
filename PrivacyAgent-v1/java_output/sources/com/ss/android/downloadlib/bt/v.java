package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class v {
    public static java.lang.String vw(java.lang.String str, java.lang.String str2, boolean z, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("extra", str);
            if (!android.text.TextUtils.isEmpty(str2)) {
                jSONObject.put("notification_jump_url", str2);
            }
            jSONObject.put("show_toast", z);
            jSONObject.put(com.anythink.core.common.f.u.h, str3);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
