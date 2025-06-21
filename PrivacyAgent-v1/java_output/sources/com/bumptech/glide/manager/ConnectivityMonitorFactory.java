package com.bumptech.glide.manager;

/* loaded from: classes.dex */
public interface ConnectivityMonitorFactory {
    @androidx.annotation.NonNull
    com.bumptech.glide.manager.ConnectivityMonitor build(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener);
}
