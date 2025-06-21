package com.huawei.hms.api;

/* loaded from: classes22.dex */
public abstract class HuaweiMobileServicesUtil {
    public static final java.lang.String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";
    private static final int HMS_VERSION_CODE_NOMDM = 20500000;
    private static final java.lang.String TAG = "HuaweiMobileServicesUtil";

    public static android.app.Dialog getErrorDialog(int i, android.app.Activity activity, int i2) {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().getErrorDialog(activity, i, i2, null);
    }

    public static android.app.Dialog getErrorDialog(int i, android.app.Activity activity, int i2, android.content.DialogInterface.OnCancelListener onCancelListener) {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
    }

    public static java.lang.String getErrorString(int i) {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().getErrorString(i);
    }

    @java.lang.Deprecated
    public static java.lang.String getOpenSourceSoftwareLicenseInfo(android.content.Context context) {
        return "";
    }

    public static android.content.Context getRemoteContext(android.content.Context context) {
        try {
            return context.createPackageContext(com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHMSPackageName(), 2);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static android.content.res.Resources getRemoteResource(android.content.Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHMSPackageName());
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int isHuaweiMobileServicesAvailable(android.content.Context context) {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
    }

    public static int isHuaweiMobileServicesAvailable(android.content.Context context, int i) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "context must not be null.");
        com.huawei.hms.utils.PackageManagerHelper packageManagerHelper = new com.huawei.hms.utils.PackageManagerHelper(context);
        java.lang.String hMSPackageNameForMultiService = com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService();
        com.huawei.hms.support.log.HMSLog.i(TAG, "hmsPackageName is " + hMSPackageNameForMultiService);
        com.huawei.hms.utils.PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
        com.huawei.hms.utils.PackageManagerHelper.PackageStates packageStates = com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED;
        if (packageStates.equals(hMSPackageStatesForMultiService)) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "HMS is not installed");
            return 1;
        }
        java.lang.String hmsPath = com.huawei.hms.utils.ReadApkFileUtil.getHmsPath(context);
        if (com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT < 5 && packageManagerHelper.getPackageVersionCode(hMSPackageNameForMultiService) < HMS_VERSION_CODE_NOMDM && com.huawei.hms.utils.ReadApkFileUtil.isCertFound(hmsPath)) {
            java.lang.String packageSignature = packageManagerHelper.getPackageSignature(hMSPackageNameForMultiService);
            return ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(packageSignature) || "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature) || "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature)) ? 2 : 9;
        }
        if (com.huawei.hms.utils.PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "HMS is spoofed");
            return 9;
        }
        if (com.huawei.hms.utils.PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "HMS is disabled");
            return 3;
        }
        if (packageStates.equals(hMSPackageStatesForMultiService)) {
            java.lang.String packageSignature2 = packageManagerHelper.getPackageSignature(hMSPackageNameForMultiService);
            if (!"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(packageSignature2) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature2) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(packageSignature2)) {
                return 9;
            }
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "connect versionCode:" + com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHmsMultiServiceVersion());
        if (!com.huawei.hms.utils.HMSPackageManager.getInstance(context).isApkUpdateNecessary(i)) {
            return 0;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "The current version does not meet the minimum version requirements");
        return 2;
    }

    public static boolean isUserRecoverableError(int i) {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().isUserResolvableError(i);
    }

    public static boolean popupErrDlgFragment(int i, android.app.Activity activity, int i2, android.content.DialogInterface.OnCancelListener onCancelListener) {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, i2, onCancelListener);
    }

    public static boolean popupErrDlgFragment(int i, android.app.Activity activity, android.app.Fragment fragment, int i2, android.content.DialogInterface.OnCancelListener onCancelListener) {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, fragment, i2, onCancelListener);
    }

    public static void setApplication(android.app.Application application) {
        com.huawei.hms.support.common.ActivityMgr.INST.init(application);
    }

    public static boolean showErrorDialogFragment(int i, android.app.Activity activity, int i2) {
        return com.huawei.hms.api.HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, i, i2, null);
    }

    public static void showErrorNotification(int i, android.content.Context context) {
        com.huawei.hms.api.HuaweiApiAvailability.getInstance().showErrorNotification(context, i);
    }
}
