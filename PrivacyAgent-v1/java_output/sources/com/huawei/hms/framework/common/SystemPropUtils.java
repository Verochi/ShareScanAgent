package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class SystemPropUtils {
    private static final java.lang.String TAG = "SystemPropUtils";

    public static java.lang.String getProperty(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.huawei.hms.framework.common.Logger.w(TAG, "reflect class for method has exception.");
            return str4;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str3);
            return (java.lang.String) cls.getMethod(str, java.lang.String.class, java.lang.String.class).invoke(cls, str2, str4);
        } catch (java.lang.Exception e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "getProperty catch exception: ", e);
            return str4;
        }
    }
}
