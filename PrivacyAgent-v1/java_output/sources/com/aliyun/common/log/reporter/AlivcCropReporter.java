package com.aliyun.common.log.reporter;

/* loaded from: classes.dex */
public class AlivcCropReporter extends com.aliyun.common.log.reporter.AlivcReporterBase {
    private static final int CROP_CANCEL = 8002;
    private static final int CROP_COMPLETE = 8004;
    private static final int CROP_ERROR = 8003;
    private static final java.lang.String CROP_MODULE_NAME = "crop";

    public AlivcCropReporter(android.content.Context context, java.lang.String str) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter createAlivcReporter = com.aliyun.common.log.reporter.AlivcReporterManager.createAlivcReporter(context);
        this.mAlivcReporter = createAlivcReporter;
        if (createAlivcReporter != null) {
            createAlivcReporter.setSessionId(str);
            this.mAlivcReporter.setSubModuleName(CROP_MODULE_NAME);
        }
    }

    public int sendCancelEvent() {
        sendEvent(8002, new java.util.HashMap<>());
        return 0;
    }

    public int sendCompleteEvent(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        sendEvent(8004, hashMap);
        return 0;
    }

    public int sendErrorEvent(int i) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("errorCode", java.lang.String.valueOf(i));
        sendEvent(8003, hashMap);
        return 0;
    }
}
