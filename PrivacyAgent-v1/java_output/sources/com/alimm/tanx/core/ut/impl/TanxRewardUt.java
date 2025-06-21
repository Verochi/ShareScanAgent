package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxRewardUt extends com.alimm.tanx.core.ut.impl.TanxBaseUt {
    public static void utCloseAdVideoProgress(com.alimm.tanx.core.ad.ITanxAd iTanxAd, long j) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
            } else {
                str = "";
                str2 = str;
                str5 = str2;
            }
            str3 = pid;
            str4 = requestId;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, j + "");
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.CLOSE_AD_VIDEO_PROGRESS;
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, 0, str6, buildArgs, str5);
    }

    public static void utFeedbackPopImp(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6 = "";
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                java.lang.String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                java.lang.String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && android.text.TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                    str6 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str4 = str6;
                str2 = pid;
                str3 = requestId;
                str6 = creativeId;
                str5 = sessionId;
            } else {
                str = "";
                str4 = str;
                str5 = str4;
                str2 = pid;
                str3 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str2, str3, str6, str);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.FEEDBACK_POP_IMP;
        java.lang.String str7 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, str4, "", buildArgs, str5);
    }

    public static void utIsRewardValid(com.alimm.tanx.core.ad.ITanxAd iTanxAd, int i) {
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
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.IS_REWARD_VALID;
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, i, str6, buildArgs, str4);
    }

    public static void utPlayEndClickTime(com.alimm.tanx.core.ad.ITanxAd iTanxAd, long j, int i) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                str3 = pid;
                str4 = requestId;
                str5 = iTanxAd.getBidInfo().getSessionId();
            } else {
                str = "";
                str2 = str;
                str5 = str2;
                str3 = pid;
                str4 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("time", j + "");
        buildArgs.put(com.meizu.cloud.pushsdk.constants.PushConstants.CLICK_TYPE, i + "");
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.PLAY_END_CLICK_TIME;
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, 0, str6, buildArgs, str5);
    }

    public static void utSavePopCancel(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6 = "";
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                java.lang.String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                java.lang.String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && android.text.TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                    str6 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str4 = str6;
                str2 = pid;
                str3 = requestId;
                str6 = creativeId;
                str5 = sessionId;
            } else {
                str = "";
                str4 = str;
                str5 = str4;
                str2 = pid;
                str3 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str2, str3, str6, str);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.SAVE_POP_CANCEL;
        java.lang.String str7 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, str4, "", buildArgs, str5);
    }

    public static void utSavePopImp(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6 = "";
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                java.lang.String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                java.lang.String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && android.text.TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                    str6 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str4 = str6;
                str2 = pid;
                str3 = requestId;
                str6 = creativeId;
                str5 = sessionId;
            } else {
                str = "";
                str4 = str;
                str5 = str4;
                str2 = pid;
                str3 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str2, str3, str6, str);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.SAVE_POP_IMP;
        java.lang.String str7 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, str4, "", buildArgs, str5);
    }

    public static void utSavePopPresist(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6 = "";
        if (iTanxAd != null) {
            java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            java.lang.String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                java.lang.String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                java.lang.String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && !android.text.TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
                    str6 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str4 = str6;
                str2 = pid;
                str3 = requestId;
                str6 = creativeId;
                str5 = sessionId;
            } else {
                str = "";
                str4 = str;
                str5 = str4;
                str2 = pid;
                str3 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str2, str3, str6, str);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.SAVE_POP_PRESIST;
        java.lang.String str7 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, str4, "", buildArgs, str5);
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

    public static void utViewDraw(com.alimm.tanx.core.ad.bean.BidInfo bidInfo, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, int i) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        java.lang.String reqId = tanxAdSlot != null ? tanxAdSlot.getReqId() : "";
        if (bidInfo != null) {
            java.lang.String creativeId = bidInfo.getCreativeId();
            java.lang.String templateId = bidInfo.getTemplateId();
            str3 = bidInfo.getSessionId();
            str2 = templateId;
            str = creativeId;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        utViewDraw(pid, reqId, str, str2, i, str3);
    }

    public static void utViewDraw(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.String str5) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str, str2, str3, str4);
        buildArgs.put("is_suc", i + "");
        int i2 = i == 1 ? 0 : 1;
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.REWARD_VIDEO_VIEW_CREATE;
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str, str2, i2, str6, buildArgs, str5);
    }
}
