package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class DateUtil {
    public static java.lang.String generateTimestamp() {
        return generateTimestamp(java.lang.System.currentTimeMillis());
    }

    public static java.lang.String generateTimestamp(long j) {
        java.util.Date date = new java.util.Date(j);
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }
}
