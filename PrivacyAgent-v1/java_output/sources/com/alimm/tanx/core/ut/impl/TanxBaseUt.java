package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxBaseUt implements com.alimm.tanx.core.utils.NotConfused {
    public static void biddingResult(java.util.List<com.alimm.tanx.core.ad.ITanxAd> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        sb.append(list.get(0).getScene());
        sb.append("");
        hashMap.put("scenes", sb.toString());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str = "";
        java.lang.String str2 = str;
        int i2 = 0;
        for (com.alimm.tanx.core.ad.ITanxAd iTanxAd : list) {
            com.alimm.tanx.core.ut.BiddingBean biddingBean = new com.alimm.tanx.core.ut.BiddingBean();
            if (iTanxAd != null) {
                str = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
                biddingBean.setPid(str);
                str2 = iTanxAd.getRequestId();
                if (iTanxAd.getBidInfo() != null) {
                    biddingBean.setReqId(iTanxAd.getRequestId());
                    biddingBean.setCreative_id(iTanxAd.getBidInfo().getCreativeId());
                    biddingBean.setTemplate_id(iTanxAd.getBidInfo().getTemplateId());
                    biddingBean.setSessionId(iTanxAd.getBidInfo().getSessionId());
                }
                if (iTanxAd.getBiddingInfo() != null) {
                    if (iTanxAd.getBiddingInfo().isBidResult()) {
                        i++;
                    } else {
                        i2++;
                    }
                    biddingBean.setIs_suc(iTanxAd.getBiddingInfo().isBidResult() ? "1" : "0");
                    biddingBean.setPrice(iTanxAd.getBiddingInfo().getAdPrice() + "");
                }
            }
            arrayList.add(biddingBean);
        }
        hashMap.put("createList", arrayList);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.BIDDING_CHECK;
        java.lang.String str3 = adUtConstants.arg1;
        send(str3, adUtConstants.eventId, str, str2, str3, i + "", i2 + "", hashMap, "");
    }

    public static java.util.Map<java.lang.String, java.lang.Object> buildAntiCheatParam(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (com.alimm.tanx.core.orange.OrangeManager.getInstance().getCommonSwitch("antiCheatingSwitch")) {
            com.alimm.tanx.core.ut.bean.UtAntiCheat utAntiCheat = new com.alimm.tanx.core.ut.bean.UtAntiCheat();
            utAntiCheat.currentVolume = com.alimm.tanx.core.utils.AntiCheatUtil.getInstance().getCurrentVolume(com.alimm.tanx.core.TanxCoreSdk.getApplication());
            utAntiCheat.battery = com.alimm.tanx.core.utils.AntiCheatUtil.getInstance().getBatteryPercentage(com.alimm.tanx.core.TanxCoreSdk.getApplication());
            utAntiCheat.charge = com.alimm.tanx.core.utils.AntiCheatUtil.getInstance().isCharging(com.alimm.tanx.core.TanxCoreSdk.getApplication());
            utAntiCheat.systemAlertPermissions = com.alimm.tanx.core.utils.AntiCheatUtil.getInstance().isSystemAlertPermissions(com.alimm.tanx.core.TanxCoreSdk.getApplication());
            utAntiCheat.accessibilityEnabled = com.alimm.tanx.core.utils.AntiCheatUtil.getInstance().accessibilityEnabled(com.alimm.tanx.core.TanxCoreSdk.getApplication());
            if (map == null) {
                map = new java.util.HashMap<>();
            }
            map.put(com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_FORMAT, com.alibaba.fastjson.JSON.toJSONString(utAntiCheat));
        }
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> buildArgs(java.lang.String str) {
        return buildArgs(str, null, null, null);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> buildArgs(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, str4);
        hashMap.put("creative_id", str3);
        return hashMap;
    }

    public static void h5Ut(com.alimm.tanx.core.ut.bean.UtItemH5Bean utItemH5Bean) {
        track(utItemH5Bean.page, utItemH5Bean.pid, utItemH5Bean.reqId, utItemH5Bean.eventId, utItemH5Bean.eventStatus, utItemH5Bean.arg1, utItemH5Bean.arg2, utItemH5Bean.arg3, utItemH5Bean.args, "");
    }

    public static void send(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str7) {
        track(str, str2, str3, i, i2, str4, str5, str6, map, str7);
    }

    public static void send(java.lang.String str, int i, int i2, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3) {
        track(str, "", "", i, i2, str2, null, null, map, str3);
    }

    public static void send(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, int i2, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str7) {
        track(str, str2, str3, i, i2, str4, str5, str6, map, str7);
    }

    public static void send(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, int i2, java.lang.String str4, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str5) {
        track(str, str2, str3, i, i2, str4, null, null, map, str5);
    }

    public static void send(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str7) {
        track(str, str2, str3, i, 0, str4, str5, str6, map, str7);
    }

    public static void send(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str5) {
        track(str, str2, str3, i, 0, str4, null, null, map, str5);
    }

    public static void shake(java.lang.String str, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap2;
        java.lang.String str2;
        java.lang.String str3;
        if (bidInfo != null) {
            java.lang.String str4 = bidInfo.getId() + "";
            java.lang.String creativeId = bidInfo.getCreativeId();
            java.lang.String str5 = bidInfo.getOpenType() + "";
            java.lang.String templateId = bidInfo.getTemplateId();
            java.lang.String sessionId = bidInfo.getSessionId();
            java.util.Map<java.lang.String, java.lang.Object> buildArgs = buildArgs("", str4, creativeId, templateId);
            if (hashMap == null) {
                hashMap = new java.util.HashMap<>();
            }
            hashMap.putAll(buildArgs);
            hashMap.put(com.anythink.expressad.videocommon.e.b.u, com.alimm.tanx.core.TanxCoreSdk.getConfig() != null ? com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppId() : "");
            hashMap.put("reqId", str4);
            hashMap.put("openType", str5);
            hashMap.put("creativeId", creativeId);
            str3 = sessionId;
            hashMap2 = hashMap;
            str2 = str4;
        } else {
            hashMap2 = hashMap;
            str2 = "";
            str3 = str2;
        }
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.SHAKE;
        java.lang.String str6 = adUtConstants.arg1;
        send(str6, adUtConstants.eventId, "", str2, str6, null, str, hashMap2, str3);
    }

    public static void track(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str7) {
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do userTracker = com.alimm.tanx.core.TanxCoreManager.getInstance().getUserTracker();
        com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker tanxUserTracker = com.alimm.tanx.core.TanxCoreManager.getInstance().getTanxUserTracker();
        if (userTracker != null) {
            userTracker.track(str, i, str4, str5, str6, map);
        } else if (tanxUserTracker != null) {
            tanxUserTracker.track(str, str2, str3, i, i2, str4, str5, str6, map, str7);
        }
    }

    public static void utClick(com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo, boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (adClickInfo != null) {
            java.lang.String pid = adClickInfo.getPid();
            java.lang.String str4 = adClickInfo.getAdType() + "";
            java.lang.String reqId = adClickInfo.getReqId();
            java.lang.String creativeId = adClickInfo.getCreativeId();
            java.lang.String str5 = adClickInfo.getOpenType() + "";
            java.lang.String templateId = adClickInfo.getTemplateId();
            java.lang.String sessionId = adClickInfo.getSessionId();
            java.lang.String pidStyleId = adClickInfo.getPidStyleId();
            java.util.Map<java.lang.String, java.lang.Object> buildArgs = buildArgs(pid, reqId, creativeId, templateId);
            buildArgs.putAll(adClickInfo.getUtArgs());
            buildArgs.put("adType", str4);
            buildArgs.put("dpUrlNull", java.lang.Integer.valueOf(android.text.TextUtils.isEmpty(str2) ? 1 : 0));
            buildArgs.put("h5UrlNull", java.lang.Integer.valueOf(android.text.TextUtils.isEmpty(str3) ? 1 : 0));
            buildArgs.put("openType", str5);
            buildArgs.put("pidStyleId", pidStyleId);
            java.lang.String obj = com.alimm.tanx.core.utils.SysUtils.getInstallStatus().toString();
            if (z) {
                com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.DEEP_LINK_OPEN;
                java.lang.String str6 = adUtConstants.arg1;
                send(str6, adUtConstants.eventId, pid, reqId, str6, obj, "", buildArgs, sessionId);
                return;
            }
            buildArgs.put("dpUrl", str2 + "");
            buildArgs.put("h5Url", str3 + "");
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants2 = com.alimm.tanx.core.ut.AdUtConstants.LANDING_H5;
            java.lang.String str7 = adUtConstants2.arg1;
            send(str7, adUtConstants2.eventId, pid, reqId, str7, obj, "", buildArgs, sessionId);
        }
    }

    public static void utError(int i, java.lang.Exception exc) {
        utError(i, exc, "");
    }

    public static void utError(int i, java.lang.Exception exc, java.lang.String str) {
        utError(i, "", exc, str);
    }

    public static void utError(int i, java.lang.String str, java.lang.Exception exc, java.lang.String str2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "main";
        }
        hashMap.put("taskName", str2);
        hashMap.put("msg", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(exc));
        hashMap.put("tag", str);
        if (hashMap.get("msg") == null || !hashMap.get("msg").toString().contains("Unable to resolve host")) {
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.EXCEPTION_MSG;
            java.lang.String str3 = adUtConstants.arg1;
            send(str3, adUtConstants.eventId, "", "", i, str3, hashMap, "");
        }
    }

    public static void utError(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        utError(i, str, str2, str3, "", "", "", "");
    }

    public static void utError(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("taskName", android.text.TextUtils.isEmpty(str3) ? "main" : str3);
        hashMap.put("msg", str2);
        hashMap.put("tag", str);
        if (hashMap.get("msg") == null || !hashMap.get("msg").toString().contains("Unable to resolve host")) {
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.EXCEPTION_MSG;
            java.lang.String str8 = adUtConstants.arg1;
            send(str8, adUtConstants.eventId, str4, str5, i, str8, str6, str7, hashMap, "");
        }
    }

    public static void utErrorCode(com.alimm.tanx.core.ad.ITanxAd iTanxAd, com.alimm.tanx.core.ut.UtErrorCode utErrorCode) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        if (utErrorCode == null) {
            return;
        }
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
        java.util.Map<java.lang.String, java.lang.Object> buildArgs = buildArgs(str3, str4, str, str2);
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.SDK_ERROR_CODE;
        send(adUtConstants.arg1, adUtConstants.eventId, str3, str4, utErrorCode.getIntCode(), utErrorCode.getMsg(), buildArgs, str5);
    }

    public static void utNavigate(com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (adClickInfo != null) {
            java.lang.String pid = adClickInfo.getPid();
            java.lang.String reqId = adClickInfo.getReqId();
            java.lang.String creativeId = adClickInfo.getCreativeId();
            java.lang.String str5 = adClickInfo.getOpenType() + "";
            java.lang.String templateId = adClickInfo.getTemplateId();
            java.lang.String sessionId = adClickInfo.getSessionId();
            java.lang.String pidStyleId = adClickInfo.getPidStyleId();
            java.util.Map<java.lang.String, java.lang.Object> buildArgs = buildArgs(pid, reqId, creativeId, templateId);
            buildArgs.putAll(adClickInfo.getUtArgs());
            buildArgs.put("dpUrlNull", java.lang.Integer.valueOf(android.text.TextUtils.isEmpty(str3) ? 1 : 0));
            buildArgs.put("h5UrlNull", java.lang.Integer.valueOf(android.text.TextUtils.isEmpty(str4) ? 1 : 0));
            buildArgs.put("openType", str5);
            buildArgs.put("pidStyleId", pidStyleId);
            send(adClickInfo.getAdUtConstants().arg1, adClickInfo.getAdUtConstants().eventId, pid, reqId, adClickInfo.getAdUtConstants().arg1, com.alimm.tanx.core.utils.SysUtils.getInstallStatus().toString(), str, buildArgs, sessionId);
        }
    }

    public static void utNetError(int i, java.lang.String str, com.alimm.tanx.core.ut.bean.UtErrorBean utErrorBean, java.lang.String str2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "main";
        }
        hashMap.put("taskName", str2);
        hashMap.put("msg", utErrorBean.toString());
        hashMap.put("tag", str);
        if (hashMap.get("msg") == null || !hashMap.get("msg").toString().contains("Unable to resolve host")) {
            com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.EXCEPTION_MSG;
            java.lang.String str3 = adUtConstants.arg1;
            send(str3, adUtConstants.eventId, "", "", i, str3, hashMap, "");
        }
    }
}
