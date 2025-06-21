package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
final class zzh implements android.os.Handler.Callback {
    public final /* synthetic */ com.google.android.gms.common.internal.zzg n;

    public zzh(com.google.android.gms.common.internal.zzg zzgVar) {
        this.n = zzgVar;
    }

    public /* synthetic */ zzh(com.google.android.gms.common.internal.zzg zzgVar, com.google.android.gms.common.internal.zzf zzfVar) {
        this(zzgVar);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        java.util.HashMap hashMap;
        java.util.HashMap hashMap2;
        java.util.HashMap hashMap3;
        java.util.HashMap hashMap4;
        java.util.HashMap hashMap5;
        int i = message.what;
        if (i == 0) {
            hashMap = this.n.d;
            synchronized (hashMap) {
                com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar = (com.google.android.gms.common.internal.GmsClientSupervisor.zza) message.obj;
                hashMap2 = this.n.d;
                com.google.android.gms.common.internal.zzi zziVar = (com.google.android.gms.common.internal.zzi) hashMap2.get(zzaVar);
                if (zziVar != null && zziVar.h()) {
                    if (zziVar.d()) {
                        zziVar.g("GmsClientSupervisor");
                    }
                    hashMap3 = this.n.d;
                    hashMap3.remove(zzaVar);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        hashMap4 = this.n.d;
        synchronized (hashMap4) {
            com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar2 = (com.google.android.gms.common.internal.GmsClientSupervisor.zza) message.obj;
            hashMap5 = this.n.d;
            com.google.android.gms.common.internal.zzi zziVar2 = (com.google.android.gms.common.internal.zzi) hashMap5.get(zzaVar2);
            if (zziVar2 != null && zziVar2.f() == 3) {
                java.lang.String valueOf = java.lang.String.valueOf(zzaVar2);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(valueOf);
                new java.lang.Exception();
                android.content.ComponentName j = zziVar2.j();
                if (j == null) {
                    j = zzaVar2.zzb();
                }
                if (j == null) {
                    j = new android.content.ComponentName((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(zzaVar2.zza()), "unknown");
                }
                zziVar2.onServiceDisconnected(j);
            }
        }
        return true;
    }
}
