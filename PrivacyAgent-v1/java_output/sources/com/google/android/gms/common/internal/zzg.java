package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
final class zzg extends com.google.android.gms.common.internal.GmsClientSupervisor {
    public final android.content.Context e;
    public final android.os.Handler f;

    @javax.annotation.concurrent.GuardedBy("connectionStatus")
    public final java.util.HashMap<com.google.android.gms.common.internal.GmsClientSupervisor.zza, com.google.android.gms.common.internal.zzi> d = new java.util.HashMap<>();
    public final com.google.android.gms.common.stats.ConnectionTracker g = com.google.android.gms.common.stats.ConnectionTracker.getInstance();
    public final long h = 5000;
    public final long i = 300000;

    public zzg(android.content.Context context) {
        this.e = context.getApplicationContext();
        this.f = new com.google.android.gms.internal.common.zzi(context.getMainLooper(), new com.google.android.gms.common.internal.zzh(this, null));
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zza(com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar, android.content.ServiceConnection serviceConnection, java.lang.String str) {
        boolean d;
        com.google.android.gms.common.internal.Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.d) {
            com.google.android.gms.common.internal.zzi zziVar = this.d.get(zzaVar);
            if (zziVar == null) {
                zziVar = new com.google.android.gms.common.internal.zzi(this, zzaVar);
                zziVar.a(serviceConnection, serviceConnection, str);
                zziVar.c(str);
                this.d.put(zzaVar, zziVar);
            } else {
                this.f.removeMessages(0, zzaVar);
                if (zziVar.e(serviceConnection)) {
                    java.lang.String valueOf = java.lang.String.valueOf(zzaVar);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new java.lang.IllegalStateException(sb.toString());
                }
                zziVar.a(serviceConnection, serviceConnection, str);
                int f = zziVar.f();
                if (f == 1) {
                    serviceConnection.onServiceConnected(zziVar.j(), zziVar.i());
                } else if (f == 2) {
                    zziVar.c(str);
                }
            }
            d = zziVar.d();
        }
        return d;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zzb(com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar, android.content.ServiceConnection serviceConnection, java.lang.String str) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.d) {
            com.google.android.gms.common.internal.zzi zziVar = this.d.get(zzaVar);
            if (zziVar == null) {
                java.lang.String valueOf = java.lang.String.valueOf(zzaVar);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new java.lang.IllegalStateException(sb.toString());
            }
            if (!zziVar.e(serviceConnection)) {
                java.lang.String valueOf2 = java.lang.String.valueOf(zzaVar);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(valueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new java.lang.IllegalStateException(sb2.toString());
            }
            zziVar.b(serviceConnection, str);
            if (zziVar.h()) {
                this.f.sendMessageDelayed(this.f.obtainMessage(0, zzaVar), this.h);
            }
        }
    }
}
