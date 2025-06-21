package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxInterfaceUt extends com.alimm.tanx.core.ut.impl.TanxBaseUt {
    public static final java.lang.String CALLBACK_ERROR = "error";
    public static final java.lang.String CALLBACK_SUCCESS = "success";
    public static final java.lang.String CALLBACK_TIMEOUT = "time_out";
    public static final java.lang.String REQUEST_FEED = "flow_request_invoke";
    public static final java.lang.String REQUEST_REWARD_VIDEO = "reward_request_invoke";
    public static final java.lang.String REQUEST_TABLE_SCREEN = "table_screen_request_invoke";
    public static final java.lang.String REWARD_VIDEO_START_CACHE = "reward_video_start_cache";
    public static final java.lang.String SPLASH_PRELOAD = "splash_preload";
    public static final java.lang.String TEMPLATE_FEED = "flow_template_invoke";
    public static final java.lang.String TEMPLATE_REWARD = "reward_video_template_invoke";
    public static final java.lang.String TEMPLATE_SPLASH = "splash_template_invoke";
    public static final java.lang.String TEMPLATE_TABLE_SCREEN = "table_screen_template_invoke";

    public static void sendMethodCallback(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str, java.lang.String str2) {
        sendMethodCallback(tanxAdSlot, str, str2, -1L);
    }

    public static void sendMethodCallback(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str, java.lang.String str2, long j) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(tanxAdSlot.getPid());
        buildArgs.put("method", str);
        buildArgs.put("callback", str2);
        if (j != -1) {
            buildArgs.put("timeConsuming", j + "");
        }
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.METHOD_INVOKE_CALLBACK;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), tanxAdSlot.getReqId(), adUtConstants.arg1, buildArgs, "");
    }

    public static void sendMethodInvoke(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str);
        buildArgs.put("method", str2);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.METHOD_INVOKE;
        java.lang.String str3 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str3, adUtConstants.eventId, str, null, str3, buildArgs, "");
    }
}
