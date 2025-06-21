package com.huawei.hms.push.utils;

/* loaded from: classes22.dex */
public class DateUtil {
    public static java.lang.String parseMilliSecondToString(java.lang.Long l) {
        if (l == null) {
            return null;
        }
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(l);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", e);
            return null;
        }
    }

    public static long parseUtcToMillisecond(java.lang.String str) throws java.text.ParseException, java.lang.StringIndexOutOfBoundsException {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", java.util.Locale.US);
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.parse(str.substring(0, str.indexOf(".")) + (str.substring(str.indexOf(".")).substring(0, 4) + "Z")).getTime();
    }
}
