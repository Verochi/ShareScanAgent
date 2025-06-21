package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
final class zzi implements android.content.ServiceConnection, com.google.android.gms.common.internal.zzk {
    public final java.util.Map<android.content.ServiceConnection, android.content.ServiceConnection> n = new java.util.HashMap();
    public int t = 2;
    public boolean u;

    @androidx.annotation.Nullable
    public android.os.IBinder v;
    public final com.google.android.gms.common.internal.GmsClientSupervisor.zza w;
    public android.content.ComponentName x;
    public final /* synthetic */ com.google.android.gms.common.internal.zzg y;

    public zzi(com.google.android.gms.common.internal.zzg zzgVar, com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar) {
        this.y = zzgVar;
        this.w = zzaVar;
    }

    public final void a(android.content.ServiceConnection serviceConnection, android.content.ServiceConnection serviceConnection2, java.lang.String str) {
        this.n.put(serviceConnection, serviceConnection2);
    }

    public final void b(android.content.ServiceConnection serviceConnection, java.lang.String str) {
        this.n.remove(serviceConnection);
    }

    public final void c(java.lang.String str) {
        com.google.android.gms.common.stats.ConnectionTracker connectionTracker;
        android.content.Context context;
        android.content.Context context2;
        com.google.android.gms.common.stats.ConnectionTracker connectionTracker2;
        android.content.Context context3;
        android.os.Handler handler;
        android.os.Handler handler2;
        long j;
        this.t = 3;
        connectionTracker = this.y.g;
        context = this.y.e;
        com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar = this.w;
        context2 = this.y.e;
        boolean zza = connectionTracker.zza(context, str, zzaVar.zza(context2), this, this.w.zzc());
        this.u = zza;
        if (zza) {
            handler = this.y.f;
            android.os.Message obtainMessage = handler.obtainMessage(1, this.w);
            handler2 = this.y.f;
            j = this.y.i;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.t = 2;
        try {
            connectionTracker2 = this.y.g;
            context3 = this.y.e;
            connectionTracker2.unbindService(context3, this);
        } catch (java.lang.IllegalArgumentException unused) {
        }
    }

    public final boolean d() {
        return this.u;
    }

    public final boolean e(android.content.ServiceConnection serviceConnection) {
        return this.n.containsKey(serviceConnection);
    }

    public final int f() {
        return this.t;
    }

    public final void g(java.lang.String str) {
        android.os.Handler handler;
        com.google.android.gms.common.stats.ConnectionTracker connectionTracker;
        android.content.Context context;
        handler = this.y.f;
        handler.removeMessages(1, this.w);
        connectionTracker = this.y.g;
        context = this.y.e;
        connectionTracker.unbindService(context, this);
        this.u = false;
        this.t = 2;
    }

    public final boolean h() {
        return this.n.isEmpty();
    }

    @androidx.annotation.Nullable
    public final android.os.IBinder i() {
        return this.v;
    }

    public final android.content.ComponentName j() {
        return this.x;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        java.util.HashMap hashMap;
        android.os.Handler handler;
        hashMap = this.y.d;
        synchronized (hashMap) {
            handler = this.y.f;
            handler.removeMessages(1, this.w);
            this.v = iBinder;
            this.x = componentName;
            java.util.Iterator<android.content.ServiceConnection> it = this.n.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.t = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        java.util.HashMap hashMap;
        android.os.Handler handler;
        hashMap = this.y.d;
        synchronized (hashMap) {
            handler = this.y.f;
            handler.removeMessages(1, this.w);
            this.v = null;
            this.x = componentName;
            java.util.Iterator<android.content.ServiceConnection> it = this.n.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.t = 2;
        }
    }
}
