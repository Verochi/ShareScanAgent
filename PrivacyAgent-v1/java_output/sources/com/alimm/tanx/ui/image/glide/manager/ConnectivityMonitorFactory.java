package com.alimm.tanx.ui.image.glide.manager;

/* loaded from: classes.dex */
public class ConnectivityMonitorFactory {
    public com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor build(android.content.Context context, com.alimm.tanx.ui.image.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? new com.alimm.tanx.ui.image.glide.manager.DefaultConnectivityMonitor(context, connectivityListener) : new com.alimm.tanx.ui.image.glide.manager.NullConnectivityMonitor();
    }
}
