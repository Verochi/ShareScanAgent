package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxSplashUt extends com.alimm.tanx.core.ut.impl.TanxBaseUt {
    public static final java.lang.String FROM_TYPE = "from_type";
    public static final java.lang.String IS_SUC = "is_suc";
    public static final int TYPE_FROM_CACHE = 0;
    public static final int TYPE_FROM_REQUEST = 1;

    public static void sendUt(com.alimm.tanx.core.ad.ITanxAd iTanxAd, com.alimm.tanx.core.ut.AdUtConstants adUtConstants, java.util.HashMap<java.lang.String, java.lang.String> hashMap, int i) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        str = "";
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            java.lang.String creativeId = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getCreativeId() : "";
            str2 = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getTemplateId() : "";
            str5 = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getSessionId() : "";
            str3 = pid;
            str4 = requestId;
            str = creativeId;
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.putAll(hashMap);
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, i, str6, buildArgs, str5);
    }

    public static void utSplashCacheExist(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i, boolean z, int i2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(FROM_TYPE, java.lang.String.valueOf(i));
        hashMap.put("is_suc", z ? "1" : "0");
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.SPLASH_CACHE_EXIT, hashMap, i2);
    }

    public static void utSplashJsonCheck(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i, boolean z, int i2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(FROM_TYPE, java.lang.String.valueOf(i));
        hashMap.put("is_suc", z ? "1" : "0");
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.SCREEN_JSON_CHECK, hashMap, i2);
    }

    public static void utSplashTimer(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i, boolean z, int i2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(FROM_TYPE, java.lang.String.valueOf(i));
        hashMap.put("is_suc", z ? "1" : "0");
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.AD_TIMER, hashMap, i2);
    }

    public static void utSplashViewClose(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(FROM_TYPE, java.lang.String.valueOf(i));
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.SCREEN_VIEW_CANCEL, hashMap, 0);
    }

    public static void utSplashViewCreate(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i, boolean z, int i2) {
        utSplashViewCreate(iTanxAd, i, z, i2, "");
    }

    public static void utSplashViewCreate(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i, boolean z, int i2, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(FROM_TYPE, java.lang.String.valueOf(i));
        hashMap.put("is_suc", z ? "1" : "0");
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.SCREEN_VIEW_CREATE, hashMap, i2);
    }

    public static void utSplashWebCreate(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i) {
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.WEB_DID_MOUNT, new java.util.HashMap(), i);
    }
}
