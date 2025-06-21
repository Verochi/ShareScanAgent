package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class SettingUtil {
    private static final java.lang.String TAG = "SettingUtil";

    public static int getSecureInt(android.content.ContentResolver contentResolver, java.lang.String str, int i) {
        try {
            return android.provider.Settings.Secure.getInt(contentResolver, str, i);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", e);
            return i;
        }
    }

    public static int getSystemInt(android.content.ContentResolver contentResolver, java.lang.String str, int i) {
        try {
            return android.provider.Settings.System.getInt(contentResolver, str, i);
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "Settings System getInt throwFromSystemServer:", e);
            return i;
        }
    }
}
