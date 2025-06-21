package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class PermissionUtil {
    public static boolean checkCallingPermission(android.content.Context context, java.lang.String str, java.lang.String str2) throws com.huawei.secure.android.common.exception.NoPermissionCheckerException {
        if (android.os.Binder.getCallingPid() == android.os.Process.myPid()) {
            return false;
        }
        return checkPermission(context, str, android.os.Binder.getCallingPid(), android.os.Binder.getCallingUid(), str2);
    }

    public static boolean checkPermission(android.content.Context context, java.lang.String str, int i, int i2, java.lang.String str2) throws com.huawei.secure.android.common.exception.NoPermissionCheckerException {
        try {
            return androidx.core.content.PermissionChecker.checkPermission(context, str, i, i2, str2) == 0;
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("checkPermission: ");
            sb.append(th.getMessage());
            sb.append(" , you should implementation support library or androidx library");
            throw new com.huawei.secure.android.common.exception.NoPermissionCheckerException("you should implementation support library or androidx library");
        }
    }

    public static boolean checkSelfPermission(android.content.Context context, java.lang.String str) throws com.huawei.secure.android.common.exception.NoPermissionCheckerException {
        return checkPermission(context, str, android.os.Process.myPid(), android.os.Process.myUid(), context.getPackageName());
    }
}
