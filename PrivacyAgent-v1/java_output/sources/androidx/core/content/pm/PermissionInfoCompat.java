package androidx.core.content.pm;

/* loaded from: classes.dex */
public final class PermissionInfoCompat {

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public @interface Protection {
    }

    @android.annotation.SuppressLint({"UniqueConstants"})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static int getProtection(@androidx.annotation.NonNull android.content.pm.PermissionInfo permissionInfo) {
        int protection;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return permissionInfo.protectionLevel & 15;
        }
        protection = permissionInfo.getProtection();
        return protection;
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static int getProtectionFlags(@androidx.annotation.NonNull android.content.pm.PermissionInfo permissionInfo) {
        int protectionFlags;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return permissionInfo.protectionLevel & (-16);
        }
        protectionFlags = permissionInfo.getProtectionFlags();
        return protectionFlags;
    }
}
