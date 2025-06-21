package com.huawei.hms.support.hianalytics;

/* loaded from: classes22.dex */
public class b extends com.huawei.hms.support.hianalytics.a {
    public static void a(android.content.Context context, com.huawei.hms.common.internal.ResponseHeader responseHeader, java.lang.String str) {
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance();
        java.util.Map<java.lang.String, java.lang.String> mapFromRequestHeader = com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.RESPONSE);
        if (!android.text.TextUtils.isEmpty(str)) {
            mapFromRequestHeader.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(str));
        }
        mapFromRequestHeader.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(context, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, mapFromRequestHeader);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.Map<java.lang.String, java.lang.String> mapForBi = com.huawei.hms.support.hianalytics.a.getMapForBi(context, str);
        mapForBi.put("appid", str2);
        if (android.text.TextUtils.isEmpty(str3)) {
            str3 = com.huawei.hms.common.internal.TransactionIdCreater.getId(str2, str);
        }
        mapForBi.put("transId", str3);
        mapForBi.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.REQUEST);
        if (!android.text.TextUtils.isEmpty(str4)) {
            mapForBi.put("version", com.huawei.hms.support.hianalytics.HiAnalyticsUtil.versionCodeToName(str4));
        }
        mapForBi.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onNewEvent(context, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, mapForBi);
    }
}
