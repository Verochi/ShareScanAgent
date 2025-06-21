package com.huawei.hms.support.hianalytics;

/* loaded from: classes22.dex */
public class HiAnalyticsUtils {
    public static final java.lang.Object c = new java.lang.Object();
    public static final java.lang.Object d = new java.lang.Object();
    public static com.huawei.hms.support.hianalytics.HiAnalyticsUtils e;
    public int a = 0;
    public boolean b = com.huawei.hms.stats.c.a();

    public static java.util.LinkedHashMap<java.lang.String, java.lang.String> a(java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap = new java.util.LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static com.huawei.hms.support.hianalytics.HiAnalyticsUtils getInstance() {
        com.huawei.hms.support.hianalytics.HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (c) {
            if (e == null) {
                e = new com.huawei.hms.support.hianalytics.HiAnalyticsUtils();
            }
            hiAnalyticsUtils = e;
        }
        return hiAnalyticsUtils;
    }

    public static java.lang.String versionCodeToName(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                java.lang.Integer.parseInt(str);
                return java.lang.Integer.parseInt(str.substring(0, str.length() - 7)) + "." + java.lang.Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + java.lang.Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + java.lang.Integer.parseInt(str.substring(str.length() - 3));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return "";
    }

    public final void a(android.content.Context context) {
        synchronized (d) {
            int i = this.a;
            if (i < 60) {
                this.a = i + 1;
            } else {
                this.a = 0;
                if (this.b) {
                    com.huawei.hms.stats.b.a(context, 0);
                    com.huawei.hms.stats.b.a(context, 1);
                } else {
                    com.huawei.hms.hatool.HmsHiAnalyticsUtils.onReport();
                }
            }
        }
    }

    public void enableLog() {
        com.huawei.hms.support.log.HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (this.b) {
            com.huawei.hms.support.log.HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        } else {
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.enableLog();
        }
    }

    public void enableLog(android.content.Context context) {
        com.huawei.hms.support.log.HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (this.b) {
            com.huawei.hianalytics.util.HiAnalyticTools.enableLog(context);
        } else {
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.enableLog();
        }
    }

    public boolean getInitFlag() {
        return !this.b ? com.huawei.hms.hatool.HmsHiAnalyticsUtils.getInitFlag() : com.huawei.hianalytics.process.HiAnalyticsManager.getInitFlag(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public boolean hasError(android.content.Context context) {
        return com.huawei.hms.stats.a.c(context);
    }

    public void onBuoyEvent(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (hasError(context) || context == null) {
            return;
        }
        onEvent2(context, str, str2);
    }

    public void onEvent(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (hasError(context) || map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (this.b) {
            com.huawei.hms.stats.b.a(context, 0, str, a(map));
            com.huawei.hms.stats.b.a(context, 1, str, a(map));
        } else {
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(0, str, a(map));
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(1, str, a(map));
        }
        a(context);
    }

    public void onEvent2(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (hasError(context) || context == null || !getInitFlag()) {
            return;
        }
        if (this.b) {
            com.huawei.hms.stats.b.a(context, str, str2);
        } else {
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(context, str, str2);
        }
    }

    public void onNewEvent(android.content.Context context, java.lang.String str, java.util.Map map) {
        if (hasError(context) || map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (this.b) {
            com.huawei.hms.stats.b.a(context, 0, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
            com.huawei.hms.stats.b.a(context, 1, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
        } else {
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(0, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(1, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
        }
        a(context);
    }

    public void onNewEvent(android.content.Context context, java.lang.String str, java.util.Map map, int i) {
        if (hasError(context)) {
            return;
        }
        if (i != 0 && i != 1) {
            com.huawei.hms.support.log.HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
            return;
        }
        if (map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (this.b) {
            com.huawei.hms.stats.b.a(context, i, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
        } else {
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(i, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
        }
        a(context);
    }

    public void onReport(android.content.Context context, java.lang.String str, java.util.Map map) {
        if (hasError(context) || map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (!this.b) {
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(0, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(1, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onReport();
        } else {
            com.huawei.hms.stats.b.a(context, 0, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
            com.huawei.hms.stats.b.a(context, 1, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
            com.huawei.hms.stats.b.a(context, 0);
            com.huawei.hms.stats.b.a(context, 1);
        }
    }

    public void onReport(android.content.Context context, java.lang.String str, java.util.Map map, int i) {
        if (hasError(context)) {
            return;
        }
        if (i != 0 && i != 1) {
            com.huawei.hms.support.log.HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
            return;
        }
        if (map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (this.b) {
            com.huawei.hms.stats.b.a(context, i, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
            com.huawei.hms.stats.b.a(context, i);
        } else {
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onEvent(i, str, a((java.util.Map<java.lang.String, java.lang.String>) map));
            com.huawei.hms.hatool.HmsHiAnalyticsUtils.onReport();
        }
    }
}
