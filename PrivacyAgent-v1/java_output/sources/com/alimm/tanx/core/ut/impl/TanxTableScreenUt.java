package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxTableScreenUt extends com.alimm.tanx.core.ut.impl.TanxBaseUt {
    public static void utRewardExposureTime(com.alimm.tanx.core.ad.ITanxAd iTanxAd, long j) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5 = "";
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str5 = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                str4 = iTanxAd.getBidInfo().getSessionId();
            } else {
                str = "";
                str4 = str;
            }
            str2 = pid;
            str3 = requestId;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str2, str3, str5, str);
        buildArgs.put("exposure_time", java.lang.Long.valueOf(j));
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.TABLE_SCREEN_EXPOSURE_MONITOR;
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, 0, str6, buildArgs, str4);
    }

    public static void utViewDraw(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                java.lang.String creativeId = iTanxAd.getBidInfo().getCreativeId();
                java.lang.String templateId = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                str3 = creativeId;
                str = pid;
                str2 = requestId;
                str4 = templateId;
            } else {
                str3 = "";
                str4 = str3;
                str5 = str4;
                str = pid;
                str2 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        utViewDraw(str, str2, str3, str4, i, str5);
    }

    public static void utViewDraw(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.String str5) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str, str2, str3, str4);
        buildArgs.put("is_suc", i + "");
        int i2 = i == 1 ? 0 : 1;
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.TABLE_SCREEN_VIEW_CREATE;
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str, str2, i2, str6, buildArgs, str5);
    }
}
