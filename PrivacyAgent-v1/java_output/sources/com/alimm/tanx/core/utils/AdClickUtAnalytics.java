package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class AdClickUtAnalytics implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "ClickUtAnalytics";
    public static final java.lang.String UT_LOSS_NO_INITED = "no_init";
    private static final java.lang.String XAD_UT_CLICK = "xad_click";

    public static void recordActivityCreateFail(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.lang.String str2) {
    }

    public static void recordClickUt(com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo, com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
        recordUt(XAD_UT_CLICK, adClickInfo, bidInfo);
    }

    public static void recordDeepLinkBackTime(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, long j) {
    }

    public static void recordDeepLinkError(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, int i) {
    }

    public static void recordDeepLinkResult(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, boolean z) {
    }

    public static void recordNavResult(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, java.util.Map<java.lang.String, java.lang.String> map) {
    }

    private static void recordUt(java.lang.String str, com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo, com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
    }

    public static void recordWebSecondHop(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.lang.String str, java.lang.String str2) {
    }

    public static void sendClickUt(java.lang.String str, com.alimm.tanx.core.ad.bean.BidInfo bidInfo) {
    }

    public static void sendUt(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.String> map) {
    }

    public static void sendUt(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        sendUt(null, str, str2, str3, map);
    }
}
