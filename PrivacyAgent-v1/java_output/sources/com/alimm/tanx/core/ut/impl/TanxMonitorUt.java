package com.alimm.tanx.core.ut.impl;

/* loaded from: classes.dex */
public class TanxMonitorUt extends com.alimm.tanx.core.ut.impl.TanxBaseUt {
    private static final java.lang.String TAG = "TanxMonitorUt";

    public static boolean isOpen(java.lang.String str) {
        java.lang.Boolean bool;
        com.alimm.tanx.core.orange.bean.OrangeBean orangeBean = com.alimm.tanx.core.orange.OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null) {
            return true;
        }
        com.alimm.tanx.core.orange.bean.OrangeUtBean orangeUtBean = orangeBean.ut;
        if (orangeUtBean != null && (bool = orangeUtBean.utSwitch) != null && !bool.booleanValue()) {
            return false;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = orangeBean.commonSwitch;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return true;
        }
        return com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(orangeBean.commonSwitch.get(str));
    }

    public static boolean isOpenFeedMonitor() {
        return isOpen(com.alimm.tanx.core.ut.AdUtConstants.FLOW_VIEW_EXPOSURE_MONITOR.arg1);
    }

    public static boolean isOpenSplashMonitor() {
        return isOpen(com.alimm.tanx.core.ut.AdUtConstants.SCREEN_VIEW_EXPOSURE_MONITOR.arg1);
    }

    public static void sendFeedMonitor(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str4) {
        if (map == null) {
            map = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str, str3, str2);
        } else {
            map.putAll(com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str, str3, str2));
        }
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.FLOW_VIEW_EXPOSURE_MONITOR;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), str, adUtConstants.arg1, map, str4);
    }

    public static void sendImageMonitor(int i, int i2, java.lang.String str, boolean z) {
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.IMAGE_MONITOR;
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("imgType", str);
        if (z) {
            hashMap.put("loadPoint", "1");
        } else {
            hashMap.put("loadPoint", "-1");
        }
        java.lang.String str2 = adUtConstants.arg1;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(str2, adUtConstants.eventId, null, null, str2, i + "", i2 + "", hashMap, null);
    }

    public static void sendSplashMonitor(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str4) {
        if (map == null) {
            map = com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str, str3, str2);
        } else {
            map.putAll(com.alimm.tanx.core.ut.impl.TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str, str3, str2));
        }
        java.util.Map<java.lang.String, java.lang.Object> map2 = map;
        map2.put(com.alimm.tanx.core.ut.impl.TanxSplashUt.FROM_TYPE, java.lang.String.valueOf(i));
        map2.put("close_type", java.lang.String.valueOf(i2));
        com.alimm.tanx.core.ut.AdUtConstants adUtConstants = com.alimm.tanx.core.ut.AdUtConstants.SCREEN_VIEW_EXPOSURE_MONITOR;
        com.alimm.tanx.core.ut.impl.TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), str, adUtConstants.arg1, map2, str4);
    }
}
