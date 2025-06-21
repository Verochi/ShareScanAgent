package androidx.core.content;

/* loaded from: classes.dex */
public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        return checkPermission(context, str, android.os.Binder.getCallingPid(), android.os.Binder.getCallingUid(), android.os.Binder.getCallingPid() == android.os.Process.myPid() ? context.getPackageName() : null);
    }

    public static int checkCallingPermission(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        if (android.os.Binder.getCallingPid() == android.os.Process.myPid()) {
            return -1;
        }
        return checkPermission(context, str, android.os.Binder.getCallingPid(), android.os.Binder.getCallingUid(), str2);
    }

    public static int checkPermission(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, int i, int i2, @androidx.annotation.Nullable java.lang.String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        java.lang.String permissionToOp = androidx.core.app.AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            java.lang.String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return androidx.core.app.AppOpsManagerCompat.noteProxyOpNoThrow(context, permissionToOp, str2) != 0 ? -2 : 0;
    }

    public static int checkSelfPermission(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        return checkPermission(context, str, android.os.Process.myPid(), android.os.Process.myUid(), context.getPackageName());
    }
}
