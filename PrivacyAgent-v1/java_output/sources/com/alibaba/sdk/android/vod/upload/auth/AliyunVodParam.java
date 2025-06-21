package com.alibaba.sdk.android.vod.upload.auth;

/* loaded from: classes.dex */
public class AliyunVodParam {
    public static java.lang.String generateOpenAPIURL(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, java.lang.String str2) {
        return generateURL(com.aliyun.auth.common.AliyunVodHttpCommon.generateVodDomain(str), "GET", map, map2, str2);
    }

    public static java.lang.String generateOpenAPIURL(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, java.lang.String str) {
        return generateURL(com.aliyun.auth.common.AliyunVodHttpCommon.VOD_DOMAIN, "GET", map, map2, str);
    }

    public static java.util.Map<java.lang.String, java.lang.String> generatePrivateParamtersToReUploadVideo(java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_ACTION, com.aliyun.auth.common.AliyunVodHttpCommon.Action.REFRESH_UPLOAD_VIDEO);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_VIDEOID, str);
        return hashMap;
    }

    public static java.util.Map<java.lang.String, java.lang.String> generatePrivateParamtersToUploadImage(com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo, java.lang.String str, java.lang.String str2, boolean z) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_ACTION, com.aliyun.auth.common.AliyunVodHttpCommon.Action.CREATE_UPLOAD_IMAGE);
        if (z) {
            hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_IMAGETYPE, com.aliyun.auth.common.AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER);
        } else {
            hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_IMAGETYPE, "default");
        }
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_IMAGEEXT, com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TITLE, vodInfo.getTitle());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TAGS, generateTags(vodInfo.getTags()));
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_CATEID, java.lang.String.valueOf(vodInfo.getCateId()));
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DESCRIPTION, vodInfo.getDesc());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_STORAGELOCATION, str);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_USERDATA, vodInfo.getUserData());
        hashMap.put("AppId", str2);
        return hashMap;
    }

    public static java.util.Map<java.lang.String, java.lang.String> generatePrivateParamtersToUploadVideo(com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo, boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_ACTION, com.aliyun.auth.common.AliyunVodHttpCommon.Action.CREATE_UPLOAD_VIDEO);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TITLE, vodInfo.getTitle());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_FILENAME, vodInfo.getFileName());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_FILESIZE, vodInfo.getFileSize());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DESCRIPTION, vodInfo.getDesc());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COVERURL, vodInfo.getCoverUrl());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_CATEID, java.lang.String.valueOf(vodInfo.getCateId()));
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TAGS, generateTags(vodInfo.getTags()));
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_STORAGELOCATION, str2);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_USERDATA, vodInfo.getUserData());
        if (android.text.TextUtils.isEmpty(str)) {
            hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TRANSCODEMODE, z ? com.aliyun.auth.common.AliyunVodHttpCommon.COMON_FAST_TRANSCODEMODE : com.aliyun.auth.common.AliyunVodHttpCommon.COMON_NO_TRANSCODEMODE);
        } else {
            hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_TEMPLATEGROUPID, str);
        }
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_WORKFLOWLD, str3);
        hashMap.put("AppId", str4);
        return hashMap;
    }

    public static java.util.Map<java.lang.String, java.lang.String> generatePublicParamters(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_FORMAT, com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
        hashMap.put("Version", com.aliyun.auth.common.AliyunVodHttpCommon.COMMON_API_VERSION);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID, str);
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_METHOD, "HMAC-SHA1");
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_VERSION, "1.0");
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SIGNATURE_NONCE, com.aliyun.auth.common.AliyunVodHttpCommon.generateRandom());
        hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID, str3);
        if (str2 != null && str2.length() > 0) {
            hashMap.put(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN, str2);
        }
        return hashMap;
    }

    private static java.lang.String generateTags(java.util.List<java.lang.String> list) {
        java.lang.String str = "";
        if (list == null || list.size() <= 0) {
            return "";
        }
        for (int i = 0; i < list.size(); i++) {
            str = str + "," + list.get(i).toString();
        }
        return trimFirstAndLastChar(str, ',');
    }

    private static java.lang.String generateURL(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, java.lang.String str3) {
        java.lang.String cqs = com.aliyun.auth.common.AliyunVodSignature.getCQS(com.aliyun.auth.common.AliyunVodSignature.getAllParams(map, map2));
        java.lang.System.out.print("CanonicalizedQueryString = " + cqs);
        java.lang.String str4 = str2 + "&" + com.aliyun.auth.common.AliyunVodSignature.percentEncode(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + "&" + com.aliyun.auth.common.AliyunVodSignature.percentEncode(cqs);
        java.lang.System.out.print("StringtoSign = " + str4);
        java.lang.String hmacSHA1Signature = com.aliyun.auth.common.AliyunVodSignature.hmacSHA1Signature(str3, str4);
        java.lang.System.out.print("Signature = " + hmacSHA1Signature);
        return str + "?" + cqs + "&" + com.aliyun.auth.common.AliyunVodSignature.percentEncode("Signature") + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.aliyun.auth.common.AliyunVodSignature.percentEncode(hmacSHA1Signature);
    }

    public static java.lang.String trimFirstAndLastChar(java.lang.String str, char c) {
        while (true) {
            str = str.substring(str.indexOf(c) == 0 ? 1 : 0, str.lastIndexOf(c) + 1 == str.length() ? str.lastIndexOf(c) : str.length());
            boolean z = str.indexOf(c) == 0;
            boolean z2 = str.lastIndexOf(c) + 1 == str.length();
            if (!z && !z2) {
                return str;
            }
        }
    }
}
