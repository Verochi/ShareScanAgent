package com.aliyun.common.log.reporter;

/* loaded from: classes.dex */
public class AlivcReporterManager {
    private static boolean CLOSE_REPORTER;
    private static boolean sSendOnce;

    /* renamed from: com.aliyun.common.log.reporter.AlivcReporterManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideosdk.conan.event.AlivcEventReporter val$alivcEventReporter;

        public AnonymousClass1(com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter) {
            this.val$alivcEventReporter = alivcEventReporter;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = this.val$alivcEventReporter;
            if (alivcEventReporter != null) {
                alivcEventReporter.sendCodecInfoEvent();
            }
        }
    }

    public static com.aliyun.svideosdk.conan.event.AlivcEventReporter createAlivcReporter(android.content.Context context) {
        if (CLOSE_REPORTER || context == null || com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogClose == com.aliyun.svideosdk.AlivcSdkCore.getLogLevel()) {
            return null;
        }
        com.aliyun.svideosdk.conan.AlivcConan.initSDKContext(context);
        com.aliyun.svideosdk.conan.event.AlivcEventReporterConfig alivcEventReporterConfig = new com.aliyun.svideosdk.conan.event.AlivcEventReporterConfig();
        alivcEventReporterConfig.setApplicationName(context.getApplicationInfo().labelRes == 0 ? "unknown" : context.getString(context.getApplicationInfo().labelRes));
        alivcEventReporterConfig.setBusinessType(com.aliyun.svideosdk.conan.AlivcConanBusinessType.AlivcConanBusinessSvideo);
        alivcEventReporterConfig.setUseExternalAuth(false);
        com.aliyun.svideosdk.conan.event.AlivcEventReporter alivcEventReporter = new com.aliyun.svideosdk.conan.event.AlivcEventReporter(alivcEventReporterConfig);
        alivcEventReporter.setSDKVersion(com.aliyun.common.global.Version.VERSION);
        alivcEventReporter.setBuildIdCommitIdString("15462250 + 8bb55f7 + 0 + 2d04d4b");
        if (!sSendOnce) {
            sSendOnce = true;
            alivcEventReporter.sendOnceEvent();
            java.util.concurrent.Executors.newSingleThreadExecutor().submit(new com.aliyun.common.log.reporter.AlivcReporterManager.AnonymousClass1(alivcEventReporter));
        }
        return alivcEventReporter;
    }
}
