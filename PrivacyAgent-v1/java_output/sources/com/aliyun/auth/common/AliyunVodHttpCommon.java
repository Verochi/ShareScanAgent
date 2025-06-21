package com.aliyun.auth.common;

/* loaded from: classes.dex */
public class AliyunVodHttpCommon {
    public static final java.lang.String COMMON_API_VERSION = "2017-03-21";
    public static final java.lang.String COMMON_SIGNATURE = "HMAC-SHA1";
    public static final java.lang.String COMMON_SIGNATUREVERSION = "1.0";
    public static final java.lang.String COMMON_SIGNATURE_METHOD = "HMAC-SHA1";
    public static final java.lang.String COMON_FAST_TRANSCODEMODE = "FastTranscode";
    public static final java.lang.String COMON_NO_TRANSCODEMODE = "NoTranscode";
    public static final java.lang.String HTTP_METHOD = "GET";
    public static final java.lang.String VOD_DOMAIN = "https://vod.cn-shanghai.aliyuncs.com/";
    private static final java.lang.String VOD_DOMAIN_PREFIX = "https://vod.";
    private static final java.lang.String VOD_DOMAIN_REGION = "cn-shanghai";
    private static final java.lang.String VOD_DOMAIN_SUFFIX = ".aliyuncs.com/";
    public static final java.lang.String COMMON_TIMESTAMP = generateTimestamp();
    public static final java.lang.String COMMON_SIGNATURE_NONCE = generateRandom();

    public static class Action {
        public static final java.lang.String CREATE_UPLOAD_IMAGE = "CreateUploadImage";
        public static final java.lang.String CREATE_UPLOAD_VIDEO = "CreateUploadVideo";
        public static final java.lang.String REFRESH_UPLOAD_VIDEO = "RefreshUploadVideo";
    }

    public static class Format {
        public static final java.lang.String FORMAT_JSON = "json";
        public static final java.lang.String FORMAT_XML = "xml";
    }

    public static class ImageExt {
        public static final java.lang.String IMAGEEXT_JPEG = "jpeg";
        public static final java.lang.String IMAGEEXT_JPG = "jpg";
        public static final java.lang.String IMAGEEXT_PNG = "png";
    }

    public static class ImageType {
        public static final java.lang.String IMAGETYPE_COVER = "cover";
        public static final java.lang.String IMAGETYPE_DEFAULT = "default";
    }

    public static java.lang.String generateRandom() {
        return java.util.UUID.randomUUID().toString();
    }

    public static java.lang.String generateTimestamp() {
        java.util.Date date = new java.util.Date(java.lang.System.currentTimeMillis());
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }

    public static final java.lang.String generateVodDomain(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(VOD_DOMAIN_PREFIX);
        if (android.text.TextUtils.isEmpty(str)) {
            str = VOD_DOMAIN_REGION;
        }
        sb.append(str);
        sb.append(VOD_DOMAIN_SUFFIX);
        return sb.toString();
    }
}
