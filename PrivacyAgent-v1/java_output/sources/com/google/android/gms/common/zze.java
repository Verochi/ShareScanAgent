package com.google.android.gms.common;

/* loaded from: classes22.dex */
final /* synthetic */ class zze implements java.util.concurrent.Callable {
    public final boolean n;
    public final java.lang.String t;
    public final com.google.android.gms.common.zzd u;

    public zze(boolean z, java.lang.String str, com.google.android.gms.common.zzd zzdVar) {
        this.n = z;
        this.t = str;
        this.u = zzdVar;
    }

    @Override // java.util.concurrent.Callable
    public final java.lang.Object call() {
        return com.google.android.gms.common.zzc.b(this.n, this.t, this.u);
    }
}
