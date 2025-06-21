package com.aliyun.svideosdk.b;

/* loaded from: classes12.dex */
public class a {
    private com.aliyun.svideosdk.conan.event.AlivcEventReporter a;

    public a(android.content.Context context) {
        if (com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogClose == com.aliyun.svideosdk.AlivcSdkCore.getLogLevel()) {
            return;
        }
        com.aliyun.svideosdk.conan.AlivcConan.initSDKContext(context);
        com.aliyun.svideosdk.conan.event.AlivcEventReporterConfig alivcEventReporterConfig = new com.aliyun.svideosdk.conan.event.AlivcEventReporterConfig();
        alivcEventReporterConfig.setApplicationName(context.getApplicationInfo().labelRes == 0 ? "unknown" : context.getString(context.getApplicationInfo().labelRes));
        alivcEventReporterConfig.setBusinessType(com.aliyun.svideosdk.conan.AlivcConanBusinessType.AlivcConanBusinessSvideo);
        alivcEventReporterConfig.setUseExternalAuth(false);
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = new com.aliyun.svideosdk.conan.event.AlivcEventReporter(alivcEventReporterConfig);
        this.a = alivcEventReporter;
        alivcEventReporter.setSDKVersion(com.aliyun.common.global.Version.VERSION);
        this.a.setBuildIdCommitIdString("15462250 + 8bb55f7 + 0 + 2d04d4b");
        this.a.setSubModuleName("sdk");
    }

    private int a(int i, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.a;
        if (alivcEventReporter == null) {
            return -4;
        }
        int sendEvent = alivcEventReporter.sendEvent(i, hashMap);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("sendEvent ");
        sb.append(i);
        sb.append(" result is ");
        sb.append(sendEvent);
        return sendEvent;
    }

    public int a(boolean z) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("result", z ? "1" : "0");
        return a(com.alimm.tanx.core.constant.AdType.COMMON_AD, hashMap);
    }

    public long a() {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.a;
        if (alivcEventReporter != null) {
            return alivcEventReporter.getEventReporterId();
        }
        return -1L;
    }

    public void b() {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.a;
        if (alivcEventReporter != null) {
            alivcEventReporter.destory();
            this.a = null;
        }
    }
}
