package androidx.core.app;

/* loaded from: classes.dex */
public final class ServiceCompat {
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void stopForeground(@androidx.annotation.NonNull android.app.Service service, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            service.stopForeground(i);
        } else {
            service.stopForeground((i & 1) != 0);
        }
    }
}
