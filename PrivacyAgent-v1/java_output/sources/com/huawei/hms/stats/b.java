package com.huawei.hms.stats;

/* loaded from: classes22.dex */
public class b {
    public static com.huawei.hianalytics.process.HiAnalyticsInstance a;

    public static com.huawei.hianalytics.process.HiAnalyticsInstance a(android.content.Context context) {
        com.huawei.hianalytics.process.HiAnalyticsInstance analyticsInstance = com.huawei.hms.utils.HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        a = analyticsInstance;
        return analyticsInstance;
    }

    public static void a(android.content.Context context, int i) {
        if (a(context) != null) {
            a.onReport(i);
        }
    }

    public static void a(android.content.Context context, int i, java.lang.String str, java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap) {
        if (a(context) != null) {
            a.onEvent(i, str, linkedHashMap);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (a(context) != null) {
            a.onEvent(context, str, str2);
        }
    }
}
