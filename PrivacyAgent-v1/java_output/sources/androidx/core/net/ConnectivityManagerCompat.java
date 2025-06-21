package androidx.core.net;

/* loaded from: classes.dex */
public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface RestrictBackgroundStatus {
    }

    private ConnectivityManagerCompat() {
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    @android.annotation.SuppressLint({"ReferencesDeprecated"})
    public static android.net.NetworkInfo getNetworkInfoFromBroadcast(@androidx.annotation.NonNull android.net.ConnectivityManager connectivityManager, @androidx.annotation.NonNull android.content.Intent intent) {
        android.net.NetworkInfo networkInfo = (android.net.NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    public static int getRestrictBackgroundStatus(@androidx.annotation.NonNull android.net.ConnectivityManager connectivityManager) {
        int restrictBackgroundStatus;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return 3;
        }
        restrictBackgroundStatus = connectivityManager.getRestrictBackgroundStatus();
        return restrictBackgroundStatus;
    }

    @androidx.annotation.RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean isActiveNetworkMetered(@androidx.annotation.NonNull android.net.ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
