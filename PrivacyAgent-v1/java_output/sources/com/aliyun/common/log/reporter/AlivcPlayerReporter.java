package com.aliyun.common.log.reporter;

/* loaded from: classes.dex */
public class AlivcPlayerReporter extends com.aliyun.common.log.reporter.AlivcReporterBase {
    private static final int PLAYER_EVENT_ID = 3000;
    private static final java.lang.String PLAYER_MODULE_NAME = "svplayer";

    public AlivcPlayerReporter(android.content.Context context, java.lang.String str) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter createAlivcReporter = com.aliyun.common.log.reporter.AlivcReporterManager.createAlivcReporter(context);
        this.mAlivcReporter = createAlivcReporter;
        if (createAlivcReporter != null) {
            createAlivcReporter.setSessionId(str);
            this.mAlivcReporter.setSubModuleName(PLAYER_MODULE_NAME);
        }
        this.mEventId = 3000;
    }

    public void sendInitEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "init");
        sendEvent(hashMap);
    }

    public void sendPauseEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", com.anythink.expressad.foundation.d.c.cb);
        sendEvent(hashMap);
    }

    public void sendPlayEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", com.aliyun.vod.log.core.AliyunLogCommon.SubModule.play);
        sendEvent(hashMap);
    }

    public void sendReleaseEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "release");
        sendEvent(hashMap);
    }

    public void sendResumeEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", com.anythink.expressad.foundation.d.c.cc);
        sendEvent(hashMap);
    }

    public void sendSeekEvent(long j) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "seek");
        hashMap.put("timestamp", java.lang.String.valueOf(j));
        sendEvent(hashMap);
    }

    public void sendSetDisplayEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setDisplay");
        sendEvent(hashMap);
    }

    public void sendSetDisplaySizeEvent(int i, int i2) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setDisplaySize");
        hashMap.put("width", java.lang.String.valueOf(i));
        hashMap.put("height", java.lang.String.valueOf(i2));
        sendEvent(hashMap);
    }

    public void sendSetSourceEvent(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setSource");
        hashMap.put("path", str);
        sendEvent(hashMap);
    }

    public void sendSetSourcesEvent(java.lang.String[] strArr) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "setSources");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : strArr) {
            sb.append(str);
            sb.append(com.alipay.sdk.m.u.i.b);
        }
        hashMap.put("path", sb.length() > 1 ? sb.substring(0, sb.length() - 1) : sb.toString());
        sendEvent(hashMap);
    }

    public void sendStopEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "stop");
        sendEvent(hashMap);
    }
}
