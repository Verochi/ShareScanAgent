package com.aliyun.vod.log.report;

/* loaded from: classes12.dex */
public class AliyunReportParam {
    private static final java.lang.String DOMAIN_PREFIX = "http://vod.";
    private static final java.lang.String DOMAIN_REGION = "cn-hangzhou";
    private static final java.lang.String DOMAIN_SUFFIX = ".aliyuncs.com/";
    static final java.lang.String UP_ACTION = "Action";
    static final java.lang.String UP_APPVERSION = "AppVersion";
    static final java.lang.String UP_AUTHINFO = "AuthInfo";
    static final java.lang.String UP_AUTHTIMESTAMP = "AuthTimestamp";
    static final java.lang.String UP_BUSINESSTYPE = "BusinessType";
    static final java.lang.String UP_CLIENTID = "ClientId";
    static final java.lang.String UP_DEVICEMODEL = "DeviceModel";
    static final java.lang.String UP_DONEPARTSCOUNT = "DonePartsCount";
    static final java.lang.String UP_FILECREATETIME = "FileCreateTime";
    static final java.lang.String UP_FILEHASH = "FileHash";
    static final java.lang.String UP_FILENAME = "FileName";
    static final java.lang.String UP_FILESIZE = "FileSize";
    static final java.lang.String UP_PARTSIZE = "PartSize";
    static final java.lang.String UP_SOURCE = "Source";
    static final java.lang.String UP_TERMINALTYPE = "TerminalType";
    static final java.lang.String UP_TOTALPART = "TotalPart";
    static final java.lang.String UP_UPLOADADRESS = "UploadAddress";
    static final java.lang.String UP_UPLOADID = "UploadId";
    static final java.lang.String UP_UPLOADPOINT = "UploadPoint";
    static final java.lang.String UP_UPLOADRATIO = "UploadRatio";
    static final java.lang.String UP_USERID = "UserId";
    static final java.lang.String UP_VIDEOID = "VideoId";

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

    public static final java.lang.String generateUploadProgressParams(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_FORMAT, "JSON");
        hashMap.put("Version", "2017-03-14");
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_METHOD, "HMAC-SHA1");
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_NONCE, com.aliyun.vod.log.util.UUIDGenerator.generateRequestID());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_VERSION, "1.0");
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_TIMESTAMP, com.aliyun.vod.common.utils.DateUtil.generateTimestamp());
        java.lang.String cqs = com.aliyun.vod.log.core.AliyunLogSignature.getCQS(com.aliyun.vod.log.core.AliyunLogSignature.getAllParams(map, hashMap));
        return "?" + cqs + "&" + com.aliyun.vod.log.core.AliyunLogSignature.percentEncode("Signature") + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.vod.log.core.AliyunLogSignature.percentEncode(com.aliyun.vod.log.core.AliyunLogSignature.hmacSHA1Signature(str, "POST&" + com.aliyun.vod.log.core.AliyunLogSignature.percentEncode(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + "&" + com.aliyun.vod.log.core.AliyunLogSignature.percentEncode(cqs)));
    }
}
