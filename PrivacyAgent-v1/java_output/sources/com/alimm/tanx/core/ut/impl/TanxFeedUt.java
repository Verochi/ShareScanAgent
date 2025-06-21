package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxFeedUt extends com.alimm.tanx.core.ut.impl.TanxBaseUt {
    public static void utClose(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            if (iTanxAd.getBidInfo() != null) {
                java.lang.String requestId = iTanxAd.getRequestId();
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                str3 = pid;
                str4 = requestId;
            } else {
                str = "";
                str2 = str;
                str4 = str2;
                str5 = str4;
                str3 = pid;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("option", i + "");
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.FLOW_VIEW_CANCEL;
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, str6, buildArgs, str5);
    }

    public static void utViewDraw(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                java.lang.String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null) {
                    str3 = pid;
                    str4 = requestId;
                    str6 = sessionId;
                    str5 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() != null ? iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() : "";
                } else {
                    str5 = "";
                    str3 = pid;
                    str4 = requestId;
                    str6 = sessionId;
                }
            } else {
                str = "";
                str2 = str;
                str5 = str2;
                str6 = str5;
                str3 = pid;
                str4 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("is_suc", i + "");
        int i2 = i == 1 ? 0 : 1;
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.FLOW_VIEW_CREATE;
        java.lang.String str7 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str7, adUtConstants.eventId, i2, str3, str4, str7, "", str5, buildArgs, str6);
    }
}
