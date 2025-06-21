package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class TimeUtils {
    public static final java.lang.String YYYY_MM_DD = "yyyy-MM-dd";
    private static final java.lang.String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static java.util.Locale SDK_LOCALE = java.util.Locale.CHINA;
    private static java.util.Map<java.lang.String, java.lang.ThreadLocal<java.text.SimpleDateFormat>> formatMaps = new java.util.HashMap();

    /* renamed from: com.sensorsdata.analytics.android.sdk.util.TimeUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.ThreadLocal<java.text.SimpleDateFormat> {
        final /* synthetic */ java.util.Locale val$locale;
        final /* synthetic */ java.lang.String val$patten;

        public AnonymousClass1(java.util.Locale locale, java.lang.String str) {
            this.val$locale = locale;
            this.val$patten = str;
        }

        @Override // java.lang.ThreadLocal
        public java.text.SimpleDateFormat initialValue() {
            try {
                return this.val$locale == null ? new java.text.SimpleDateFormat(this.val$patten, com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE) : new java.text.SimpleDateFormat(this.val$patten, this.val$locale);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return null;
            }
        }
    }

    public static java.lang.Float duration(float f) {
        return java.lang.Float.valueOf(java.lang.Math.round(f) / 1000.0f);
    }

    public static java.lang.Float duration(long j, long j2) {
        long j3 = j2 - j;
        try {
            return (j3 < 0 || j3 > 86400000) ? java.lang.Float.valueOf(0.0f) : java.lang.Float.valueOf(java.lang.Math.round(j3) / 1000.0f);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return java.lang.Float.valueOf(0.0f);
        }
    }

    public static java.lang.String formatDate(java.util.Date date) {
        return formatDate(date, YYYY_MM_DD_HH_MM_SS_SSS);
    }

    public static java.lang.String formatDate(java.util.Date date, java.lang.String str) {
        return formatDate(date, str, SDK_LOCALE);
    }

    public static java.lang.String formatDate(java.util.Date date, java.lang.String str, java.util.Locale locale) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = YYYY_MM_DD_HH_MM_SS_SSS;
        }
        java.text.SimpleDateFormat dateFormat = getDateFormat(str, locale);
        if (dateFormat == null) {
            return "";
        }
        try {
            return dateFormat.format(date);
        } catch (java.lang.IllegalArgumentException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public static java.lang.String formatDate(java.util.Date date, java.util.Locale locale) {
        return formatDate(date, YYYY_MM_DD_HH_MM_SS_SSS, locale);
    }

    public static org.json.JSONObject formatDate(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return new org.json.JSONObject();
        }
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                java.lang.Object obj = jSONObject.get(next);
                if (obj instanceof java.util.Date) {
                    jSONObject.put(next, formatDate((java.util.Date) obj, SDK_LOCALE));
                }
            }
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    public static java.lang.String formatTime(long j) {
        return formatTime(j, SDK_LOCALE);
    }

    public static java.lang.String formatTime(long j, java.lang.String str) {
        return formatTime(j, str, SDK_LOCALE);
    }

    public static java.lang.String formatTime(long j, java.lang.String str, java.util.Locale locale) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = YYYY_MM_DD_HH_MM_SS_SSS;
        }
        java.text.SimpleDateFormat dateFormat = getDateFormat(str, locale);
        if (dateFormat == null) {
            return "";
        }
        try {
            return dateFormat.format(java.lang.Long.valueOf(j));
        } catch (java.lang.IllegalArgumentException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public static java.lang.String formatTime(long j, java.util.Locale locale) {
        return formatTime(j, null, locale);
    }

    private static synchronized java.text.SimpleDateFormat getDateFormat(java.lang.String str, java.util.Locale locale) {
        java.text.SimpleDateFormat simpleDateFormat;
        synchronized (com.sensorsdata.analytics.android.sdk.util.TimeUtils.class) {
            java.util.Map<java.lang.String, java.lang.ThreadLocal<java.text.SimpleDateFormat>> map = formatMaps;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(locale == null ? SDK_LOCALE.getCountry() : locale.getCountry());
            java.lang.ThreadLocal<java.text.SimpleDateFormat> threadLocal = map.get(sb.toString());
            if (threadLocal == null) {
                threadLocal = new com.sensorsdata.analytics.android.sdk.util.TimeUtils.AnonymousClass1(locale, str);
                if (threadLocal.get() != null) {
                    java.util.Map<java.lang.String, java.lang.ThreadLocal<java.text.SimpleDateFormat>> map2 = formatMaps;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(str);
                    sb2.append("_");
                    sb2.append(locale == null ? SDK_LOCALE.getCountry() : locale.getCountry());
                    map2.put(sb2.toString(), threadLocal);
                }
            }
            simpleDateFormat = threadLocal.get();
        }
        return simpleDateFormat;
    }

    public static java.lang.Integer getZoneOffset() {
        try {
            java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.Locale.getDefault());
            return java.lang.Integer.valueOf((-(calendar.get(15) + calendar.get(16))) / 60000);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public static boolean isDateValid(long j) {
        try {
            java.util.Date parse = getDateFormat(YYYY_MM_DD_HH_MM_SS_SSS, SDK_LOCALE).parse("2015-05-15 10:24:00.000");
            if (parse == null) {
                return false;
            }
            return parse.getTime() < j;
        } catch (java.text.ParseException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public static boolean isDateValid(java.util.Date date) {
        try {
            return date.after(getDateFormat(YYYY_MM_DD_HH_MM_SS_SSS, SDK_LOCALE).parse("2015-05-15 10:24:00.000"));
        } catch (java.text.ParseException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }
}
