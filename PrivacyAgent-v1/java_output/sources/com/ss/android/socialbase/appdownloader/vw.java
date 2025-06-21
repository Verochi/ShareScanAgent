package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class vw {
    public java.lang.String t;
    public java.lang.String v;
    public java.lang.String vw;
    public int wg = -1;
    public java.lang.String yl;

    public static com.ss.android.socialbase.appdownloader.vw vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.ss.android.socialbase.appdownloader.vw vwVar = new com.ss.android.socialbase.appdownloader.vw();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            vwVar.yl = jSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, null);
            vwVar.v = jSONObject.optString("real_device_plan", null);
            vwVar.t = jSONObject.optString("error_msg", null);
            vwVar.vw = jSONObject.optString("ah_plan_type", null);
            java.lang.String optString = jSONObject.optString("error_code");
            if (android.text.TextUtils.isEmpty(optString)) {
                vwVar.wg = -1;
            } else {
                vwVar.wg = java.lang.Integer.parseInt(optString);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return vwVar;
    }

    public java.lang.String vw() {
        return wg().toString();
    }

    public void vw(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.vw);
            jSONObject.put("error_code", java.lang.String.valueOf(this.wg));
            jSONObject.put("error_msg", this.t);
            jSONObject.put("real_device_plan", this.v);
            jSONObject.put(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, this.yl);
        } catch (java.lang.Throwable unused) {
        }
    }

    public org.json.JSONObject wg() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        vw(jSONObject);
        return jSONObject;
    }
}
