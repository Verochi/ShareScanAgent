package com.huawei.hms.api;

/* loaded from: classes22.dex */
public abstract class HuaweiApiAvailability {
    public static final java.lang.String ACTIVITY_NAME = "com.huawei.hms.core.activity.JumpActivity";
    private static final java.util.Map<java.lang.String, java.lang.Integer> API_MAP;
    public static final java.lang.String APPID_HMS = "C10132067";
    public static final java.lang.String APPID_HMS_TV = "C100636709";
    public static final java.lang.String HMS_API_NAME_GAME = "HuaweiGame.API";
    public static final java.lang.String HMS_API_NAME_IAP = "HuaweiIap.API";
    public static final java.lang.String HMS_API_NAME_ID = "HuaweiID.API";
    public static final java.lang.String HMS_API_NAME_OD = "HuaweiOpenDevice.API";
    public static final java.lang.String HMS_API_NAME_PAY = "HuaweiPay.API";
    public static final java.lang.String HMS_API_NAME_PPS = "HuaweiPPSkit.API";
    public static final java.lang.String HMS_API_NAME_PUSH = "HuaweiPush.API";
    public static final java.lang.String HMS_API_NAME_SNS = "HuaweiSns.API";
    public static final int HMS_JSON_VERSION_MIN = 30000000;
    public static final int HMS_SDK_VERSION_CODE = 60500300;
    public static final java.lang.String HMS_SDK_VERSION_NAME = "6.5.0.300";
    public static final int HMS_VERSION_CODE_GAME = 20503000;
    public static final int HMS_VERSION_CODE_IAP = 20700300;
    public static final int HMS_VERSION_CODE_ID = 30000000;
    public static final int HMS_VERSION_CODE_MIN = 20503000;
    public static final int HMS_VERSION_CODE_OD = 20601000;
    public static final int HMS_VERSION_CODE_PAY = 20503000;
    public static final int HMS_VERSION_CODE_PPS = 20700300;
    public static final int HMS_VERSION_CODE_PUSH = 20503000;
    public static final int HMS_VERSION_CODE_SNS = 20503000;
    public static final int HMS_VERSION_MAX = 20600000;
    public static final int HMS_VERSION_MIN = 20503000;
    public static final int NOTICE_VERSION_CODE = 20600000;
    public static final java.lang.String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";

    @java.lang.Deprecated
    public static final java.lang.String SERVICES_PACKAGE = "com.huawei.hwid";

    @java.lang.Deprecated
    public static final java.lang.String SERVICES_PACKAGE_TV = "com.huawei.hwid.tv";

    @java.lang.Deprecated
    public static final java.lang.String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    @java.lang.Deprecated
    public static final java.lang.String SERVICES_SIGNATURE_CAR = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";

    @java.lang.Deprecated
    public static final java.lang.String SERVICES_SIGNATURE_TV = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public static int SERVICES_VERSION_CODE = 30000100;

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        API_MAP = hashMap;
        hashMap.put(HMS_API_NAME_ID, 30000000);
        hashMap.put(HMS_API_NAME_SNS, 20503000);
        hashMap.put(HMS_API_NAME_PAY, 20503000);
        hashMap.put(HMS_API_NAME_PUSH, 20503000);
        hashMap.put(HMS_API_NAME_GAME, 20503000);
        hashMap.put(HMS_API_NAME_OD, java.lang.Integer.valueOf(HMS_VERSION_CODE_OD));
        hashMap.put(HMS_API_NAME_IAP, 20700300);
        hashMap.put(HMS_API_NAME_PPS, 20700300);
    }

    public static java.util.Map<java.lang.String, java.lang.Integer> getApiMap() {
        return API_MAP;
    }

    public static com.huawei.hms.api.HuaweiApiAvailability getInstance() {
        return com.huawei.hms.api.b.getInstance();
    }

    public static int getServicesVersionCode() {
        return SERVICES_VERSION_CODE;
    }

    public static void setServicesVersionCode(int i) {
        SERVICES_VERSION_CODE = i;
    }

    public abstract com.huawei.hmf.tasks.Task<java.lang.Void> checkApiAccessible(com.huawei.hms.common.HuaweiApi<?> huaweiApi, com.huawei.hms.common.HuaweiApi<?>... huaweiApiArr);

    public abstract com.huawei.hmf.tasks.Task<java.lang.Void> checkApiAccessible(com.huawei.hms.common.api.HuaweiApiCallable huaweiApiCallable, com.huawei.hms.common.api.HuaweiApiCallable... huaweiApiCallableArr);

    public abstract android.app.PendingIntent getErrPendingIntent(android.content.Context context, int i, int i2);

    public abstract android.app.PendingIntent getErrPendingIntent(android.content.Context context, com.huawei.hms.api.ConnectionResult connectionResult);

    public abstract android.app.Dialog getErrorDialog(android.app.Activity activity, int i, int i2);

    public abstract android.app.Dialog getErrorDialog(android.app.Activity activity, int i, int i2, android.content.DialogInterface.OnCancelListener onCancelListener);

    public abstract java.lang.String getErrorString(int i);

    public abstract com.huawei.hmf.tasks.Task<java.lang.Void> getHuaweiServicesReady(android.app.Activity activity);

    public abstract android.content.Intent getResolveErrorIntent(android.app.Activity activity, int i);

    public abstract android.app.PendingIntent getResolveErrorPendingIntent(android.app.Activity activity, int i);

    public abstract int isHuaweiMobileNoticeAvailable(android.content.Context context);

    public abstract int isHuaweiMobileServicesAvailable(android.content.Context context);

    public abstract int isHuaweiMobileServicesAvailable(android.content.Context context, int i);

    public abstract boolean isUserResolvableError(int i);

    public abstract boolean isUserResolvableError(int i, android.app.PendingIntent pendingIntent);

    public abstract void popupErrNotification(android.content.Context context, com.huawei.hms.api.ConnectionResult connectionResult);

    public abstract void resolveError(android.app.Activity activity, int i, int i2);

    public abstract void resolveError(android.app.Activity activity, int i, int i2, android.app.PendingIntent pendingIntent);

    public abstract boolean showErrorDialogFragment(android.app.Activity activity, int i, int i2);

    public abstract boolean showErrorDialogFragment(android.app.Activity activity, int i, int i2, android.content.DialogInterface.OnCancelListener onCancelListener);

    public abstract boolean showErrorDialogFragment(android.app.Activity activity, int i, android.app.Fragment fragment, int i2, android.content.DialogInterface.OnCancelListener onCancelListener);

    public abstract void showErrorNotification(android.content.Context context, int i);
}
