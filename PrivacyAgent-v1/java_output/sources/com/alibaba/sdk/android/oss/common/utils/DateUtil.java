package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class DateUtil {
    private static final java.lang.String ALTERNATIVE_ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final java.lang.String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final java.lang.String RFC822_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
    private static volatile long amendTimeSkewed;

    public static synchronized java.lang.String currentFixedSkewedTimeInRFC822Format() {
        java.lang.String formatRfc822Date;
        synchronized (com.alibaba.sdk.android.oss.common.utils.DateUtil.class) {
            formatRfc822Date = formatRfc822Date(new java.util.Date(getFixedSkewedTimeMillis()));
        }
        return formatRfc822Date;
    }

    public static java.lang.String formatAlternativeIso8601Date(java.util.Date date) {
        return getAlternativeIso8601DateFormat().format(date);
    }

    public static java.lang.String formatIso8601Date(java.util.Date date) {
        return getIso8601DateFormat().format(date);
    }

    public static java.lang.String formatRfc822Date(java.util.Date date) {
        return getRfc822DateFormat().format(date);
    }

    private static java.text.DateFormat getAlternativeIso8601DateFormat() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(ALTERNATIVE_ISO8601_DATE_FORMAT, java.util.Locale.US);
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat;
    }

    public static long getFixedSkewedTimeMillis() {
        return java.lang.System.currentTimeMillis() + amendTimeSkewed;
    }

    private static java.text.DateFormat getIso8601DateFormat() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(ISO8601_DATE_FORMAT, java.util.Locale.US);
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat;
    }

    private static java.text.DateFormat getRfc822DateFormat() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(RFC822_DATE_FORMAT, java.util.Locale.US);
        simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return simpleDateFormat;
    }

    public static java.util.Date parseIso8601Date(java.lang.String str) throws java.text.ParseException {
        try {
            return getIso8601DateFormat().parse(str);
        } catch (java.text.ParseException unused) {
            return getAlternativeIso8601DateFormat().parse(str);
        }
    }

    public static java.util.Date parseRfc822Date(java.lang.String str) throws java.text.ParseException {
        return getRfc822DateFormat().parse(str);
    }

    public static synchronized void setCurrentServerTime(long j) {
        synchronized (com.alibaba.sdk.android.oss.common.utils.DateUtil.class) {
            amendTimeSkewed = j - java.lang.System.currentTimeMillis();
        }
    }
}
