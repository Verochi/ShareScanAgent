package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxCommonUt extends com.alimm.tanx.core.ut.impl.TanxBaseUt {
    public static final java.lang.String IS_SUC = "is_suc";

    public static void cacheCheck(com.alimm.tanx.core.ad.ITanxAd iTanxAd, java.lang.String str, int i, java.lang.Exception exc) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("video_url", str);
        if (exc != null) {
            hashMap.put("error", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(exc));
        }
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.CACHE_CHECK, hashMap, i);
    }

    public static void fileSizeCheck(com.alimm.tanx.core.ad.ITanxAd iTanxAd, long j, int i, long j2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_FILE_SIZE, j + "");
        hashMap.put("file_size_m", ((((double) j) / 1024.0d) / 1024.0d) + "");
        hashMap.put("time", j2 + "");
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.FILE_SIZE_CHECK, hashMap, i);
    }

    public static void sendAdRqFail(java.lang.String str, java.lang.String str2, java.lang.String str3, long j, int i, java.lang.String str4, java.lang.String str5) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str2, str3, null, null);
        buildArgs.put("scenes", str);
        buildArgs.put("request_time", java.lang.String.valueOf(j));
        buildArgs.put("params", str5);
        buildArgs.put("msg", str4);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.AD_REQUEST;
        java.lang.String str6 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, i, str6, buildArgs, "");
    }

    public static void sendAdRqSuc(java.lang.String str, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str2, long j, int i, com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (adInfo != null && adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
            for (int i2 = 0; i2 < adInfo.getBidInfoList().size(); i2++) {
                arrayList.add(adInfo.getBidInfoList().get(i2).getTemplateId());
            }
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str2, null, null);
        buildArgs.put("scenes", str);
        buildArgs.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, arrayList.toString());
        buildArgs.put("ad_count", java.lang.String.valueOf(tanxAdSlot.getAdCount()));
        buildArgs.put("result_ad_count", java.lang.String.valueOf(i));
        buildArgs.put("request_time", java.lang.String.valueOf(j));
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.AD_REQUEST;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), str2, adInfo == null ? -1 : adInfo.getStatus(), adUtConstants.arg1, buildArgs, "");
    }

    public static void sendClickExposureFail(java.lang.String str, java.lang.String str2, com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, java.lang.String str3, int i, java.lang.String str4) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        buildArgs.put("params", str3);
        buildArgs.put("msg", str4);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.CLICK_REQUEST;
        java.lang.String str5 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str5, adUtConstants.eventId, str, str2, i, str5, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendClickExposureSuc(java.lang.String str, java.lang.String str2, com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, java.lang.String str3) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.CLICK_REQUEST;
        java.lang.String str4 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str4, adUtConstants.eventId, str, str2, 0, str4, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendDownH5ZipFail(java.lang.String str, int i, java.lang.String str2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("params", str);
        hashMap.put("code", i + "");
        hashMap.put("msg", str2);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.DOWN_H5_ZIP;
        java.lang.String str3 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str3, adUtConstants.eventId, i, str3, hashMap, "");
    }

    public static void sendExposureFail(java.lang.String str, java.lang.String str2, com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, java.lang.String str3, int i, java.lang.String str4) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        buildArgs.put("params", str3);
        buildArgs.put("code", i + "");
        buildArgs.put("msg", str4);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.IMP_REQUEST;
        java.lang.String str5 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str5, adUtConstants.eventId, str, str2, i, str5, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendExposureSuc(java.lang.String str, java.lang.String str2, com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, java.lang.String str3) {
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.IMP_REQUEST;
        java.lang.String str4 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str4, adUtConstants.eventId, str, str2, 0, str4, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendIntoMethod(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str, com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, java.lang.String str2, com.alimm.tanx.core.ut.AdUtConstants adUtConstants) {
        sendIntoMethod(tanxAdSlot, str, iBidInfo, str2, adUtConstants, new java.util.HashMap());
    }

    public static void sendIntoMethod(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str, com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, java.lang.String str2, com.alimm.tanx.core.ut.AdUtConstants adUtConstants, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(pid, str, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        if (map != null) {
            buildArgs.putAll(map);
        }
        buildArgs.put("method_name", str2);
        java.lang.String str3 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str3, adUtConstants.eventId, pid, str, str3, buildArgs, iBidInfo.getSessionId());
    }

    public static void sendNewConfigFail(java.lang.String str, long j, int i, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        java.lang.String str4 = str;
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("params", str3);
        hashMap.put("msg", str2);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.NEW_CONFIG_MONITOR;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, "", str4, i, java.lang.String.valueOf(j), hashMap, "");
    }

    public static void sendNewConfigSuc(java.lang.String str, long j) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String str2 = android.text.TextUtils.isEmpty(str) ? "" : str;
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.NEW_CONFIG_MONITOR;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, "", str2, 0, j + "", hashMap, "");
    }

    public static void sendRewardRqFail(java.lang.String str, long j, int i, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        java.lang.String str4 = str;
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("params", str3);
        hashMap.put("msg", str2);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.REWARD_REQUEST;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, "", str4, i, java.lang.String.valueOf(j), hashMap, "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r8 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void sendRewardRqSuc(java.lang.String str, long j, com.alimm.tanx.core.ad.bean.RewardResponse rewardResponse) {
        java.lang.String str2;
        java.lang.String pid;
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String str3 = android.text.TextUtils.isEmpty(str) ? "" : str;
        if (rewardResponse != null) {
            try {
                if (rewardResponse.getPidRewards() != null && rewardResponse.getPidRewards().size() > 0) {
                    pid = rewardResponse.getPidRewards().get(0).getPid();
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
                str2 = "";
            }
        }
        pid = "";
        str2 = pid;
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.REWARD_REQUEST;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, str2, str3, 0, j + "", hashMap, "");
    }

    public static void sendStartImp(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str, com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo, int i) {
        java.lang.String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(pid, str, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put("scenes", com.alimm.tanx.core.constant.TanxAdType.getAdTypeStr(i) + "");
        com.alimm.tanx.core.ut.impl.TanxBaseUt.buildAntiCheatParam(buildArgs);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.START_IMP;
        java.lang.String str2 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str2, adUtConstants.eventId, pid, str, str2, iBidInfo.getInteractType2Int() + "", null, buildArgs, iBidInfo.getSessionId());
    }

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
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, i, str6, "", "", buildArgs, str5);
    }

    public static void utShakeDestroy(com.alimm.tanx.core.ad.ITanxAd iTanxAd, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7 = "";
        if (iTanxAd != null) {
            try {
                java.lang.String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
                java.lang.String requestId = iTanxAd.getRequestId();
                if (iTanxAd.getBidInfo() != null) {
                    java.lang.String creativeId = iTanxAd.getBidInfo().getCreativeId();
                    str2 = iTanxAd.getBidInfo().getTemplateId();
                    java.lang.String sessionId = iTanxAd.getBidInfo().getSessionId();
                    if (iTanxAd.getBidInfo().getTemplateConf() != null && iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() != null) {
                        str7 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                    }
                    str3 = str7;
                    str6 = requestId;
                    str7 = creativeId;
                    str4 = sessionId;
                    str5 = pid;
                } else {
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    str5 = pid;
                    str6 = requestId;
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
                return;
            }
        } else {
            str6 = "";
            str5 = str6;
            str2 = str5;
            str3 = str2;
            str4 = str3;
        }
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(str5, str6, str7, str2);
        if (com.alimm.tanx.core.orange.OrangeManager.getInstance().getCommonSwitch("antiCheatingSwitch")) {
            buildArgs.put("sensor_list", str);
        }
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.SHAKE_DESTROY;
        java.lang.String str8 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str8, adUtConstants.eventId, 1, str5, str6, str8, "", str3, buildArgs, str4);
    }

    public static void utTimer(com.alimm.tanx.core.ad.ITanxAd iTanxAd, boolean z, int i) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("is_suc", z ? "1" : "0");
        sendUt(iTanxAd, com.alimm.tanx.core.ut.AdUtConstants.AD_TIMER, hashMap, i);
    }

    public static void utWebStartLoad(com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
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
                if (iTanxAd.getBidInfo().getTemplateConf() != null && iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() != null) {
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
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.WEB_START_LOAD;
        java.lang.String str7 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str7, adUtConstants.eventId, 1, str2, str3, str7, "", str4, buildArgs, str5);
    }
}
