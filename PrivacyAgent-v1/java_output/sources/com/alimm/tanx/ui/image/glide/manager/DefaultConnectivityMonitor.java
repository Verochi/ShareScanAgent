package com.alimm.tanx.ui.image.glide.manager;

/* loaded from: classes.dex */
class DefaultConnectivityMonitor implements com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor {
    private final android.content.BroadcastReceiver connectivityReceiver = new com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor.AnonymousClass1();
    private final android.content.Context context;
    private boolean isConnected;
    private boolean isRegistered;
    private final com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor.ConnectivityListener listener;

    /* renamed from: com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            boolean z = com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor.this.isConnected;
            com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor defaultConnectivityMonitor = com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor.this;
            defaultConnectivityMonitor.isConnected = defaultConnectivityMonitor.isConnected(context);
            if (z != com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor.this.isConnected) {
                com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor.this.listener.onConnectivityChanged(com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor.this.isConnected);
            }
        }
    }

    public DefaultConnectivityMonitor(android.content.Context context, com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.context = context.getApplicationContext();
        this.listener = connectivityListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void register() {
        if (this.isRegistered) {
            return;
        }
        this.isConnected = isConnected(this.context);
        this.context.registerReceiver(this.connectivityReceiver, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        this.isRegistered = true;
    }

    private void unregister() {
        if (this.isRegistered) {
            this.context.unregisterReceiver(this.connectivityReceiver);
            this.isRegistered = false;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStart() {
        register();
    }

    @Override // com.alimm.tanx.ui.image.glide.manager.LifecycleListener
    public void onStop() {
        unregister();
    }
}
