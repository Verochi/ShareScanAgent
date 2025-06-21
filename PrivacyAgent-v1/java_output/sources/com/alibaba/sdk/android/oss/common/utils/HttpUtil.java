package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class HttpUtil {
    private static final java.lang.String[] ENCODED_CHARACTERS_WITH_SLASHES = {"+", "*", "%7E", "%2F"};
    private static final java.lang.String[] ENCODED_CHARACTERS_WITH_SLASHES_REPLACEMENTS = {"%20", "%2A", com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR, net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR};
    private static final java.lang.String[] ENCODED_CHARACTERS_WITHOUT_SLASHES = {"+", "*", "%7E"};
    private static final java.lang.String[] ENCODED_CHARACTERS_WITHOUT_SLASHES_REPLACEMENTS = {"%20", "%2A", com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR};

    public static java.lang.String paramToQueryString(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String value = entry.getValue();
            if (!z) {
                sb.append("&");
            }
            sb.append(urlEncode(key, str));
            if (value != null) {
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(urlEncode(value, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static java.lang.String urlEncode(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return "";
        }
        try {
            return java.net.URLEncoder.encode(str, str2).replace("+", "%20").replace("*", "%2A").replace("%7E", com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR).replace("%2F", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        } catch (java.lang.Exception e) {
            throw new java.lang.IllegalArgumentException("failed to encode url!", e);
        }
    }

    public static java.lang.String urlEncode(java.lang.String str, boolean z) {
        if (str == null) {
            return "";
        }
        try {
            java.lang.String encode = java.net.URLEncoder.encode(str, "utf-8");
            return !z ? com.alibaba.sdk.android.oss.common.utils.StringUtils.replaceEach(encode, ENCODED_CHARACTERS_WITHOUT_SLASHES, ENCODED_CHARACTERS_WITHOUT_SLASHES_REPLACEMENTS) : com.alibaba.sdk.android.oss.common.utils.StringUtils.replaceEach(encode, ENCODED_CHARACTERS_WITH_SLASHES, ENCODED_CHARACTERS_WITH_SLASHES_REPLACEMENTS);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.IllegalArgumentException("FailedToEncodeUri", e);
        }
    }
}
