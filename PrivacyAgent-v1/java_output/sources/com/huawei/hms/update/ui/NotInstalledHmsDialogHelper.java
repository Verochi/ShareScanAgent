package com.huawei.hms.update.ui;

/* loaded from: classes22.dex */
public class NotInstalledHmsDialogHelper {
    public static int a(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        if (context == null) {
            com.huawei.hms.support.log.HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, context is null.");
            return "";
        }
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            com.huawei.hms.support.log.HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            java.lang.CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (android.util.AndroidException | java.lang.RuntimeException unused) {
            com.huawei.hms.support.log.HMSLog.e("NotInstalledHmsDialogHelper", "In getAppName, Failed to get app name.");
            return "";
        }
    }

    public static void b(android.content.Context context) {
        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context.getApplicationContext());
        }
    }

    public static java.lang.String getAppName(android.app.Activity activity) {
        return a(activity, activity.getPackageName());
    }

    public static int getConfirmResId(android.app.Activity activity) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "activity must not be null");
        b(activity);
        return com.huawei.hms.utils.ResourceLoaderUtil.getStringId("hms_confirm");
    }

    public static android.app.AlertDialog.Builder getDialogBuilder(android.app.Activity activity) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "activity must not be null");
        b(activity);
        return new android.app.AlertDialog.Builder(activity, getDialogThemeId(activity)).setMessage(activity.getString(com.huawei.hms.utils.ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), a(activity, activity.getPackageName())));
    }

    public static int getDialogThemeId(android.app.Activity activity) {
        if (a(activity) != 0) {
            return 0;
        }
        return (activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32) ? 2 : 3;
    }
}
