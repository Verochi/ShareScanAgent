package com.huawei.hms.push.utils;

/* loaded from: classes22.dex */
public final class PushBiUtil {
    public static java.lang.String reportEntry(android.content.Context context, java.lang.String str) {
        return com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportEntry(context, str, 60500300);
    }

    public static void reportExit(android.content.Context context, java.lang.String str, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode) {
        com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 60500300);
    }

    public static void reportExit(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(context, str, str2, com.huawei.hms.support.api.client.Status.SUCCESS.getStatusCode(), i, 60500300);
    }

    public static void reportExit(android.content.Context context, java.lang.String str, java.lang.String str2, com.huawei.hms.aaid.constant.ErrorEnum errorEnum) {
        com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(context, str, str2, com.huawei.hms.support.api.client.Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 60500300);
    }
}
