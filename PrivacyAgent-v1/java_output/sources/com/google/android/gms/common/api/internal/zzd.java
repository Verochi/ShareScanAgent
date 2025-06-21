package com.google.android.gms.common.api.internal;

/* loaded from: classes22.dex */
final class zzd implements java.lang.Runnable {
    public final /* synthetic */ com.google.android.gms.common.api.internal.LifecycleCallback n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ com.google.android.gms.common.api.internal.zzc u;

    public zzd(com.google.android.gms.common.api.internal.zzc zzcVar, com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback, java.lang.String str) {
        this.u = zzcVar;
        this.n = lifecycleCallback;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        android.os.Bundle bundle;
        android.os.Bundle bundle2;
        android.os.Bundle bundle3;
        i = this.u.u;
        if (i > 0) {
            com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback = this.n;
            bundle = this.u.v;
            if (bundle != null) {
                bundle3 = this.u.v;
                bundle2 = bundle3.getBundle(this.t);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i2 = this.u.u;
        if (i2 >= 2) {
            this.n.onStart();
        }
        i3 = this.u.u;
        if (i3 >= 3) {
            this.n.onResume();
        }
        i4 = this.u.u;
        if (i4 >= 4) {
            this.n.onStop();
        }
        i5 = this.u.u;
        if (i5 >= 5) {
            this.n.onDestroy();
        }
    }
}
