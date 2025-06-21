package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class DateTimeUtils {
    public static java.lang.String formatMs(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / com.anythink.expressad.d.a.b.ck;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        if (i4 > 9) {
            sb.append(i4);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        } else if (i4 > 0) {
            sb.append("0");
            sb.append(i4);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        }
        if (i3 > 9) {
            sb.append(i3);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        } else if (i3 > 0) {
            sb.append("0");
            sb.append(i3);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        } else {
            sb.append(org.apache.tools.tar.TarConstants.VERSION_POSIX);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        }
        if (i2 > 9) {
            sb.append(i2);
        } else if (i2 > 0) {
            sb.append("0");
            sb.append(i2);
        } else {
            sb.append(org.apache.tools.tar.TarConstants.VERSION_POSIX);
        }
        return sb.toString();
    }

    public static java.lang.String getDateTimeFromMillisecond(java.lang.Long l) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd-HHmmssSSS").format(new java.util.Date(l.longValue()));
    }
}
