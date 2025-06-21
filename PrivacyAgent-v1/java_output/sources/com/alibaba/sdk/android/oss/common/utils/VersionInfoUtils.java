package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class VersionInfoUtils {
    private static java.lang.String userAgent;

    private static java.lang.String getSystemInfo() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        sb.append(java.lang.System.getProperty("os.name"));
        sb.append("/Android " + android.os.Build.VERSION.RELEASE);
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(android.os.Build.MODEL, "utf-8") + com.alipay.sdk.m.u.i.b + com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(android.os.Build.ID, "utf-8"));
        sb.append(")");
        java.lang.String sb2 = sb.toString();
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("user agent : " + sb2);
        return com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(sb2) ? java.lang.System.getProperty("http.agent").replaceAll("[^\\p{ASCII}]", "?") : sb2;
    }

    public static java.lang.String getUserAgent(java.lang.String str) {
        if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(userAgent)) {
            userAgent = "aliyun-sdk-android/" + getVersion() + getSystemInfo();
        }
        if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(str)) {
            return userAgent;
        }
        return userAgent + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str;
    }

    public static java.lang.String getVersion() {
        return "2.9.21";
    }
}
