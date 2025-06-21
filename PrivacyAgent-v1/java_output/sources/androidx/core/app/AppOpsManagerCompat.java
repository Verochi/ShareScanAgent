package androidx.core.app;

/* loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
    }

    public static int noteOp(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2) {
        return ((android.app.AppOpsManager) context.getSystemService("appops")).noteOp(str, i, str2);
    }

    public static int noteOpNoThrow(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2) {
        return ((android.app.AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i, str2);
    }

    public static int noteProxyOp(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        java.lang.Object systemService;
        int noteProxyOp;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return 1;
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.app.AppOpsManager.class);
        noteProxyOp = ((android.app.AppOpsManager) systemService).noteProxyOp(str, str2);
        return noteProxyOp;
    }

    public static int noteProxyOpNoThrow(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        java.lang.Object systemService;
        int noteProxyOpNoThrow;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return 1;
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.app.AppOpsManager.class);
        noteProxyOpNoThrow = ((android.app.AppOpsManager) systemService).noteProxyOpNoThrow(str, str2);
        return noteProxyOpNoThrow;
    }

    @androidx.annotation.Nullable
    public static java.lang.String permissionToOp(@androidx.annotation.NonNull java.lang.String str) {
        java.lang.String permissionToOp;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return null;
        }
        permissionToOp = android.app.AppOpsManager.permissionToOp(str);
        return permissionToOp;
    }
}
