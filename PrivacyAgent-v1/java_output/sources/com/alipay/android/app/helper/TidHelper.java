package com.alipay.android.app.helper;

/* loaded from: classes.dex */
public class TidHelper extends com.alipay.sdk.tid.TidHelper {
    public static void clearTID(android.content.Context context) {
        com.alipay.sdk.tid.TidHelper.clearTID(context);
    }

    public static java.lang.String getIMEI(android.content.Context context) {
        return com.alipay.sdk.tid.TidHelper.getIMEI(context);
    }

    public static java.lang.String getIMSI(android.content.Context context) {
        return com.alipay.sdk.tid.TidHelper.getIMSI(context);
    }

    public static synchronized java.lang.String getTIDValue(android.content.Context context) {
        java.lang.String tIDValue;
        synchronized (com.alipay.android.app.helper.TidHelper.class) {
            tIDValue = com.alipay.sdk.tid.TidHelper.getTIDValue(context);
        }
        return tIDValue;
    }

    public static java.lang.String getVirtualImei(android.content.Context context) {
        return com.alipay.sdk.tid.TidHelper.getVirtualImei(context);
    }

    public static java.lang.String getVirtualImsi(android.content.Context context) {
        return com.alipay.sdk.tid.TidHelper.getVirtualImsi(context);
    }

    public static com.alipay.android.app.helper.Tid loadLocalTid(android.content.Context context) {
        return com.alipay.android.app.helper.Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadLocalTid(context));
    }

    public static synchronized com.alipay.android.app.helper.Tid loadOrCreateTID(android.content.Context context) {
        com.alipay.android.app.helper.Tid fromRealTidModel;
        synchronized (com.alipay.android.app.helper.TidHelper.class) {
            fromRealTidModel = com.alipay.android.app.helper.Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadOrCreateTID(context));
        }
        return fromRealTidModel;
    }

    public static com.alipay.android.app.helper.Tid loadTID(android.content.Context context) {
        return com.alipay.android.app.helper.Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadTID(context));
    }

    public static boolean resetTID(android.content.Context context) throws java.lang.Exception {
        return com.alipay.sdk.tid.TidHelper.resetTID(context);
    }
}
