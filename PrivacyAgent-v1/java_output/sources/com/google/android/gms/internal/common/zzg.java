package com.google.android.gms.internal.common;

/* loaded from: classes22.dex */
final class zzg implements com.google.android.gms.internal.common.zzf {
    public zzg() {
    }

    public /* synthetic */ zzg(com.google.android.gms.internal.common.zzh zzhVar) {
        this();
    }

    @Override // com.google.android.gms.internal.common.zzf
    public final java.util.concurrent.ScheduledExecutorService zza(int i, int i2) {
        return java.util.concurrent.Executors.unconfigurableScheduledExecutorService(java.util.concurrent.Executors.newScheduledThreadPool(1));
    }
}
