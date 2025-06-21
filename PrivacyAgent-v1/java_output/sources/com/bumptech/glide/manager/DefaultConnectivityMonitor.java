package com.bumptech.glide.manager;

/* loaded from: classes.dex */
final class DefaultConnectivityMonitor implements com.bumptech.glide.manager.ConnectivityMonitor {
    private static final java.lang.String TAG = "ConnectivityMonitor";
    private final android.content.BroadcastReceiver connectivityReceiver = new com.bumptech.glide.manager.DefaultConnectivityMonitor.AnonymousClass1();
    private final android.content.Context context;
    boolean isConnected;
    private boolean isRegistered;
    final com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener listener;

    /* renamed from: com.bumptech.glide.manager.DefaultConnectivityMonitor$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@androidx.annotation.NonNull android.content.Context context, android.content.Intent intent) {
            com.bumptech.glide.manager.DefaultConnectivityMonitor defaultConnectivityMonitor = com.bumptech.glide.manager.DefaultConnectivityMonitor.this;
            boolean z = defaultConnectivityMonitor.isConnected;
            defaultConnectivityMonitor.isConnected = defaultConnectivityMonitor.isConnected(context);
            if (z != com.bumptech.glide.manager.DefaultConnectivityMonitor.this.isConnected) {
                if (android.util.Log.isLoggable(com.bumptech.glide.manager.DefaultConnectivityMonitor.TAG, 3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("connectivity changed, isConnected: ");
                    sb.append(com.bumptech.glide.manager.DefaultConnectivityMonitor.this.isConnected);
                }
                com.bumptech.glide.manager.DefaultConnectivityMonitor defaultConnectivityMonitor2 = com.bumptech.glide.manager.DefaultConnectivityMonitor.this;
                defaultConnectivityMonitor2.listener.onConnectivityChanged(defaultConnectivityMonitor2.isConnected);
            }
        }
    }

    public DefaultConnectivityMonitor(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.context = context.getApplicationContext();
        this.listener = connectivityListener;
    }

    private void register() {
        if (this.isRegistered) {
            return;
        }
        this.isConnected = isConnected(this.context);
        try {
            this.context.registerReceiver(this.connectivityReceiver, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
            this.isRegistered = true;
        } catch (java.lang.SecurityException unused) {
        }
    }

    private void unregister() {
        if (this.isRegistered) {
            this.context.unregisterReceiver(this.connectivityReceiver);
            this.isRegistered = false;
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public boolean isConnected(@androidx.annotation.NonNull android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) com.bumptech.glide.util.Preconditions.checkNotNull((android.net.ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (java.lang.RuntimeException unused) {
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        register();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        unregister();
    }
}
