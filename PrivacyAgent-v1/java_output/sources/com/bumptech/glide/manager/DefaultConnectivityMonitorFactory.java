package com.bumptech.glide.manager;

/* loaded from: classes.dex */
public class DefaultConnectivityMonitorFactory implements com.bumptech.glide.manager.ConnectivityMonitorFactory {
    private static final java.lang.String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final java.lang.String TAG = "ConnectivityMonitor";

    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    @androidx.annotation.NonNull
    public com.bumptech.glide.manager.ConnectivityMonitor build(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean z = androidx.core.content.ContextCompat.checkSelfPermission(context, NETWORK_PERMISSION) == 0;
        android.util.Log.isLoggable(TAG, 3);
        return z ? new com.bumptech.glide.manager.DefaultConnectivityMonitor(context, connectivityListener) : new com.bumptech.glide.manager.NullConnectivityMonitor();
    }
}
