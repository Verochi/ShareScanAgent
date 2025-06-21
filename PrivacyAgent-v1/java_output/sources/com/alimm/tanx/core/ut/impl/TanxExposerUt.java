package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxExposerUt extends com.alimm.tanx.core.ut.impl.TanxBaseUt {
    public static void sendMonitorFail(com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.lang.String str, int i, java.lang.String str2, org.json.JSONObject jSONObject) {
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        if (jSONObject != null) {
            java.lang.String optString = jSONObject.optString("pid");
            str4 = jSONObject.optString(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId);
            str6 = jSONObject.optString("session_id");
            str5 = jSONObject.optString(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.interactType);
            str3 = optString;
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        java.util.Map tanxc_do = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(jSONObject);
        if (tanxc_do == null) {
            tanxc_do = new java.util.HashMap();
        }
        tanxc_do.put("params", str);
        tanxc_do.put("code", java.lang.String.valueOf(i));
        tanxc_do.put("msg", str2);
        if (adMonitorType == com.tanx.exposer.achieve.AdMonitorType.CLICK) {
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.CLICK_REQUEST;
            java.lang.String str7 = adUtConstants.arg1;
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str7, adUtConstants.eventId, str3, str4, i, str7, str5, "", new java.util.HashMap(tanxc_do), str6);
        } else if (adMonitorType == com.tanx.exposer.achieve.AdMonitorType.EXPOSE) {
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants2 = com.alimm.tanx.core.ut.AdUtConstants.IMP_REQUEST;
            java.lang.String str8 = adUtConstants2.arg1;
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str8, adUtConstants2.eventId, str3, str4, i, str8, str5, "", new java.util.HashMap(tanxc_do), str6);
        }
    }

    public static void sendMonitorSuc(com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.lang.String str, org.json.JSONObject jSONObject) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        if (jSONObject != null) {
            java.lang.String optString = jSONObject.optString("pid");
            str3 = jSONObject.optString(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId);
            str5 = jSONObject.optString("session_id");
            str4 = jSONObject.optString(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.interactType);
            str2 = optString;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
        }
        java.util.Map tanxc_do = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(jSONObject);
        if (tanxc_do == null) {
            tanxc_do = new java.util.HashMap();
        }
        if (adMonitorType == com.tanx.exposer.achieve.AdMonitorType.CLICK) {
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.CLICK_REQUEST;
            java.lang.String str6 = adUtConstants.arg1;
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, 0, str6, str4, "", new java.util.HashMap(tanxc_do), str5);
        } else if (adMonitorType == com.tanx.exposer.achieve.AdMonitorType.EXPOSE) {
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants2 = com.alimm.tanx.core.ut.AdUtConstants.IMP_REQUEST;
            java.lang.String str7 = adUtConstants2.arg1;
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str7, adUtConstants2.eventId, str2, str3, 0, str7, str4, "", new java.util.HashMap(tanxc_do), str5);
        } else if (adMonitorType == com.tanx.exposer.achieve.AdMonitorType.INTERACT_DEDUPLICATION) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("ut imp_video_3s_request", new java.lang.String[0]);
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants3 = com.alimm.tanx.core.ut.AdUtConstants.IMP_VIDEO_3S_REQUEST;
            java.lang.String str8 = adUtConstants3.arg1;
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str8, adUtConstants3.eventId, str2, str3, 0, str8, str4, "", new java.util.HashMap(tanxc_do), str5);
        }
    }
}
