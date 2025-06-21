package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
class bt {
    public static void vw(int i, long j) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("error_code", java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().wg("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j));
    }

    public static void vw(int i, com.ss.android.downloadlib.addownload.wg.yl ylVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("error_code", java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.v.vw.vw().wg("lp_compliance_error", jSONObject, ylVar);
    }

    public static void vw(java.lang.String str, long j) {
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        if (yl.iq()) {
            return;
        }
        yl.t.setRefer(str);
        com.ss.android.downloadlib.v.vw.vw().wg("lp_app_dialog_click", yl);
    }

    public static void vw(java.lang.String str, com.ss.android.downloadlib.addownload.wg.yl ylVar) {
        com.ss.android.downloadlib.v.vw.vw().wg(str, ylVar);
    }

    public static void vw(java.lang.String str, org.json.JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.v.vw.vw().wg(str, jSONObject, com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j));
    }

    public static void wg(java.lang.String str, long j) {
        vw(str, null, j);
    }
}
