package com.google.android.gms.common.providers;

@com.google.android.gms.common.annotation.KeepForSdk
@java.lang.Deprecated
/* loaded from: classes22.dex */
public class PooledExecutorsProvider {
    public static com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory a;

    public interface PooledExecutorFactory {
        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        @java.lang.Deprecated
        java.util.concurrent.ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static synchronized com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory getInstance() {
        com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory pooledExecutorFactory;
        synchronized (com.google.android.gms.common.providers.PooledExecutorsProvider.class) {
            if (a == null) {
                a = new com.google.android.gms.common.providers.zza();
            }
            pooledExecutorFactory = a;
        }
        return pooledExecutorFactory;
    }
}
