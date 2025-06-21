package com.alimm.tanx.core.web.cache.utils;

/* loaded from: classes.dex */
public class TimeUtils {
    private static final java.lang.String STARD_FROMAT = "yyyy-MM-dd HH:mm:ss";

    public static boolean compare(java.util.Date date, java.util.Date date2) {
        return (date == null || date2 == null || date.getTime() - date2.getTime() <= 0) ? false : true;
    }

    public static java.util.Date formatGMT(java.lang.String str) {
        if (str.indexOf("GMT") < 0) {
            try {
                return new java.util.Date(java.lang.Long.valueOf(str).longValue() * 1000);
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
        try {
            return new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", java.util.Locale.US).parse(str.trim());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getCurrentTime() {
        return new java.text.SimpleDateFormat(STARD_FROMAT).format(new java.util.Date());
    }

    public static java.util.Date getStardTime(java.lang.Long l) {
        try {
            return new java.util.Date(l.longValue() * 1000);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.util.Date getStardTime(java.lang.String str) {
        try {
            return new java.text.SimpleDateFormat(STARD_FROMAT).parse(str);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
