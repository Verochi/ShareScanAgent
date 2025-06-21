package com.tanx.exposer.achieve;

/* loaded from: classes19.dex */
public enum AdMonitorType {
    CLICK("点击"),
    EXPOSE("曝光"),
    INTERACT("互动"),
    INTERACT_DEDUPLICATION("互动,带去重能力");

    java.lang.String description;

    AdMonitorType(java.lang.String str) {
        this.description = str;
    }

    public static boolean inSystemTypes(com.tanx.exposer.achieve.AdMonitorType adMonitorType) {
        if (adMonitorType != null) {
            return adMonitorType == CLICK || adMonitorType == EXPOSE || adMonitorType == INTERACT || adMonitorType == INTERACT_DEDUPLICATION;
        }
        return false;
    }
}
