package com.huawei.hms.support.hianalytics;

/* loaded from: classes22.dex */
public class HiAnalyticsClient extends com.huawei.hms.support.hianalytics.a {
    @java.lang.Deprecated
    public static java.lang.String reportEntry(android.content.Context context, java.lang.String str) {
        return reportEntry(context, str, com.huawei.hms.utils.Util.getAppId(context), 0);
    }

    public static java.lang.String reportEntry(android.content.Context context, java.lang.String str, int i) {
        return reportEntry(context, str, com.huawei.hms.utils.Util.getAppId(context), i);
    }

    public static java.lang.String reportEntry(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        java.lang.String id = com.huawei.hms.common.internal.TransactionIdCreater.getId(str2, str);
        java.util.Map<java.lang.String, java.lang.String> mapForBi = com.huawei.hms.support.hianalytics.a.getMapForBi(context, str);
        mapForBi.put("appid", str2);
        mapForBi.put("transId", id);
        mapForBi.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.REQUEST);
        mapForBi.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(i)));
        mapForBi.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(context, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, mapForBi);
        return id;
    }

    public static void reportExit(android.content.Context context, java.lang.String str, java.lang.String str2, int i, int i2) {
        reportExit(context, str, str2, com.huawei.hms.utils.Util.getAppId(context), i, i2, 0);
    }

    public static void reportExit(android.content.Context context, java.lang.String str, java.lang.String str2, int i, int i2, int i3) {
        reportExit(context, str, str2, com.huawei.hms.utils.Util.getAppId(context), i, i2, i3);
    }

    public static void reportExit(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, int i3) {
        java.util.Map<java.lang.String, java.lang.String> mapForBi = com.huawei.hms.support.hianalytics.a.getMapForBi(context, str);
        mapForBi.put("appid", str3);
        mapForBi.put("transId", str2);
        mapForBi.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.RESPONSE);
        mapForBi.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_RESULT, java.lang.String.valueOf(i));
        mapForBi.put("result", java.lang.String.valueOf(i2));
        mapForBi.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(java.lang.String.valueOf(i3)));
        mapForBi.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(context, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, mapForBi);
    }
}
