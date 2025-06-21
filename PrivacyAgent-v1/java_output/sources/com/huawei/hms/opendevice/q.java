package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public final class q {
    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        return com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportEntry(context, str, 60300305);
    }

    public static void a(android.content.Context context, java.lang.String str, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode) {
        com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 60300305);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(context, str, str2, com.huawei.hms.support.api.client.Status.SUCCESS.getStatusCode(), i, 60300305);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.huawei.hms.aaid.constant.ErrorEnum errorEnum) {
        com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(context, str, str2, com.huawei.hms.support.api.client.Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 60300305);
    }
}
