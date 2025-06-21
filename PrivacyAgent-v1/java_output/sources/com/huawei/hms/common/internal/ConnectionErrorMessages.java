package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class ConnectionErrorMessages {
    public static java.lang.String getErrorDialogButtonMessage(android.app.Activity activity, int i) {
        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        return com.huawei.hms.utils.ResourceLoaderUtil.getString("hms_confirm");
    }

    public static java.lang.String getErrorMessage(android.app.Activity activity, int i) {
        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1 || i == 2) {
            return activity.getString(com.huawei.hms.utils.ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), com.huawei.hms.update.ui.NotInstalledHmsDialogHelper.getAppName(activity));
        }
        return null;
    }

    public static java.lang.String getErrorTitle(android.app.Activity activity, int i) {
        if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1 || i == 2) {
            return null;
        }
        if (i == 3) {
            return com.huawei.hms.utils.ResourceLoaderUtil.getString("hms_bindfaildlg_message");
        }
        if (i == 9) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
            return null;
        }
        com.huawei.hms.support.log.HMSLog.e("HuaweiApiAvailability", "Unexpected error code " + i);
        return null;
    }
}
