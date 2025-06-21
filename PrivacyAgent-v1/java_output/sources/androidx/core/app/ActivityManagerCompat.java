package androidx.core.app;

/* loaded from: classes.dex */
public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean isLowRamDevice(@androidx.annotation.NonNull android.app.ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
