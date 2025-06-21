package com.google.android.gms.common.providers;

/* loaded from: classes22.dex */
final class zza implements com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory {
    @Override // com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory
    public final java.util.concurrent.ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return com.google.android.gms.internal.common.zze.zza().zza(1, com.google.android.gms.internal.common.zzj.zza);
    }
}
