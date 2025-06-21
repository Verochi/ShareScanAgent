package com.aliyun.common.log.reporter;

/* loaded from: classes.dex */
public class AlivcImportReporter extends com.aliyun.common.log.reporter.AlivcReporterBase {
    private static final int EVENT_ID_ADD_IMAGE = 9002;
    private static final int EVENT_ID_ADD_VIDEO = 9001;
    private static final int EVENT_ID_IMPORT_COMPLETE = 9003;
    private static final java.lang.String IMPORT_MODULE_NAME = "import";
    protected static final java.lang.String KEY_FADE_DURATION = "fadeDuration";
    private static final java.lang.String TAG = "com.aliyun.common.log.reporter.AlivcImportReporter";

    /* renamed from: com.aliyun.common.log.reporter.AlivcImportReporter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.HashMap val$args;
        final /* synthetic */ com.aliyun.svideosdk.transcode.NativeParser val$nativeParser;
        final /* synthetic */ java.lang.String val$path;

        public AnonymousClass1(java.lang.String str, com.aliyun.svideosdk.transcode.NativeParser nativeParser, java.util.HashMap hashMap) {
            this.val$path = str;
            this.val$nativeParser = nativeParser;
            this.val$args = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.io.File file = new java.io.File(this.val$path);
            if (file.exists()) {
                this.val$nativeParser.init(this.val$path);
                try {
                    this.val$args.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, java.lang.String.valueOf(file.length()));
                    java.lang.String value = this.val$nativeParser.getValue(6);
                    java.util.HashMap hashMap = this.val$args;
                    if (value.equals("unknown")) {
                        value = "0";
                    }
                    hashMap.put("width", value);
                    java.lang.String value2 = this.val$nativeParser.getValue(7);
                    java.util.HashMap hashMap2 = this.val$args;
                    if (value2.equals("unknown")) {
                        value2 = "0";
                    }
                    hashMap2.put("height", value2);
                    java.lang.String value3 = this.val$nativeParser.getValue(13);
                    java.util.HashMap hashMap3 = this.val$args;
                    if (value3.equals("unknown")) {
                        value3 = "0";
                    }
                    hashMap3.put("fps", value3);
                    java.lang.String value4 = this.val$nativeParser.getValue(5);
                    java.util.HashMap hashMap4 = this.val$args;
                    if (value4.equals("unknown")) {
                        value4 = "0";
                    }
                    hashMap4.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, value4);
                    this.val$args.put("format", this.val$nativeParser.getValue(10));
                    java.lang.String value5 = this.val$nativeParser.getValue(28);
                    java.util.HashMap hashMap5 = this.val$args;
                    if (value5.equals("unknown")) {
                        value5 = "0";
                    }
                    hashMap5.put("duration", value5);
                    java.lang.String value6 = this.val$nativeParser.getValue(3);
                    java.util.HashMap hashMap6 = this.val$args;
                    if (value6.equals("unknown")) {
                        value6 = "0";
                    }
                    hashMap6.put(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, value6);
                    java.lang.String value7 = this.val$nativeParser.getValue(18);
                    java.util.HashMap hashMap7 = this.val$args;
                    if (value7.equals("unknown")) {
                        value7 = "0";
                    }
                    hashMap7.put("audioDuration", value7);
                } catch (java.lang.Exception unused) {
                    this.val$args.put("width", "0");
                    this.val$args.put("height", "0");
                    this.val$args.put("fps", "0");
                    this.val$args.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, "0");
                    this.val$args.put("format", "unknown");
                    this.val$args.put("duration", "0");
                    this.val$args.put(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "0");
                    this.val$args.put("audioDuration", "0");
                }
                this.val$nativeParser.release();
                this.val$nativeParser.dispose();
            }
            com.aliyun.common.log.reporter.AlivcImportReporter.this.sendEvent(9001, this.val$args);
        }
    }

    /* renamed from: com.aliyun.common.log.reporter.AlivcImportReporter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Thread.UncaughtExceptionHandler {
        public AnonymousClass2() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
            java.lang.String unused = com.aliyun.common.log.reporter.AlivcImportReporter.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("parse File failed, msg is ");
            sb.append(th.getMessage());
        }
    }

    public AlivcImportReporter(android.content.Context context, java.lang.String str) {
        com.aliyun.svideosdk.conan.event.AlivcEventReporter createAlivcReporter = com.aliyun.common.log.reporter.AlivcReporterManager.createAlivcReporter(context);
        this.mAlivcReporter = createAlivcReporter;
        if (createAlivcReporter != null) {
            createAlivcReporter.setSessionId(str);
            this.mAlivcReporter.setSubModuleName(IMPORT_MODULE_NAME);
        }
    }

    public void sendAddImageEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "addImage");
        sendEvent(9002, hashMap);
    }

    public void sendAddVideoEvent(java.lang.String str, long j, long j2, long j3) {
        if (str == null || str.isEmpty()) {
            return;
        }
        com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("_interface", "addVideo");
        hashMap.put("path", str);
        hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, java.lang.String.valueOf(j));
        hashMap.put("endTime", java.lang.String.valueOf(j2));
        hashMap.put(KEY_FADE_DURATION, java.lang.String.valueOf(j3));
        java.lang.Thread thread = new java.lang.Thread(new com.aliyun.common.log.reporter.AlivcImportReporter.AnonymousClass1(str, nativeParser, hashMap));
        thread.setUncaughtExceptionHandler(new com.aliyun.common.log.reporter.AlivcImportReporter.AnonymousClass2());
        thread.start();
    }

    public void sendImportCompleteEvent() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("_interface", "importComplete");
        sendEvent(9003, hashMap);
    }
}
