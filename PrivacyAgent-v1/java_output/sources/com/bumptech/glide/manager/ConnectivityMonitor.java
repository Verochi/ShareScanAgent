package com.bumptech.glide.manager;

/* loaded from: classes.dex */
public interface ConnectivityMonitor extends com.bumptech.glide.manager.LifecycleListener {

    public interface ConnectivityListener {
        void onConnectivityChanged(boolean z);
    }
}
