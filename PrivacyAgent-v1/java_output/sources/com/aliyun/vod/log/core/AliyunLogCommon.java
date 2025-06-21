package com.aliyun.vod.log.core;

/* loaded from: classes12.dex */
public class AliyunLogCommon {
    private static final java.lang.String DOMAIN_PREFIX = "https://videocloud.";
    private static final java.lang.String DOMAIN_REGION = "cn-hangzhou";
    private static final java.lang.String DOMAIN_SUFFIX = ".log.aliyuncs.com/logstores/";
    public static final java.lang.String LOG_LEVEL = "1";
    public static final java.lang.String LOG_PUSH_TRACK_APIVERSION = "/track?APIVersion=0.6.0";
    public static final java.lang.String MODULE = "upload";
    public static final java.lang.String OPERATION_SYSTEM = "android";
    public static final java.lang.String PRODUCT = "svideo";
    public static final java.lang.String TERMINAL_TYPE = "phone";
    public static final java.lang.String DEVICE_MODEL = android.os.Build.MODEL;
    public static final java.lang.String OS_VERSION = android.os.Build.VERSION.RELEASE;
    public static java.lang.String APPLICATION_ID = null;
    public static java.lang.String APPLICATION_NAME = null;
    public static java.lang.String UUID = null;
    public static java.lang.String NetWorkType = "WiFi";

    public static class LogLevel {
        public static final java.lang.String DEBUG = "debug";
        public static final java.lang.String ERROR = "error";
        public static final java.lang.String INFO = "info";
        public static final java.lang.String WARN = "warn";
    }

    public static class LogStores {
        public static final java.lang.String SVIDEO = "svideo";
        public static final java.lang.String UPLOAD = "upload";
        public static final java.lang.String UPLOAD_TEST = "uploadtest";
    }

    public static class Module {
        public static final java.lang.String BASE = "svideo_basic";
        public static final java.lang.String MIXER = "mixer";
        public static final java.lang.String PAAS_PLAYER = "paas_player";
        public static final java.lang.String PRO = "svideo_pro";
        public static final java.lang.String PUBLISHER = "publisher";
        public static final java.lang.String SAAS_PLAYER = "saas_player";
        public static final java.lang.String STANDARD = "svideo_standard";
        public static final java.lang.String UPLOADER = "uploader";
    }

    public static class Product {
        public static final java.lang.String VIDEO_MIXER = "mixer";
        public static final java.lang.String VIDEO_PLAYER = "player";
        public static final java.lang.String VIDEO_PUSHER = "pusher";
        public static final java.lang.String VIDEO_SVIDEO = "svideo";
        public static final java.lang.String VIDEO_UPLOAD = "upload";
    }

    public static class SubModule {
        public static final java.lang.String CUT = "cut";
        public static final java.lang.String EDIT = "edit";
        public static final java.lang.String RECORD = "record";
        public static final java.lang.String UPLOAD = "upload";
        public static final java.lang.String download = "download";
        public static final java.lang.String play = "play";
    }

    public static final java.lang.String generateDomainWithRegion(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(DOMAIN_PREFIX);
        if (android.text.TextUtils.isEmpty(str)) {
            str = DOMAIN_REGION;
        }
        sb.append(str);
        sb.append(DOMAIN_SUFFIX);
        return sb.toString();
    }
}
