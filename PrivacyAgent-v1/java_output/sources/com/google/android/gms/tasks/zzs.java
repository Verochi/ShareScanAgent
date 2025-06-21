package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzs implements com.google.android.gms.tasks.OnTokenCanceledListener {
    public final /* synthetic */ com.google.android.gms.tasks.TaskCompletionSource a;

    public zzs(com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        com.google.android.gms.tasks.zzu zzuVar;
        zzuVar = this.a.a;
        zzuVar.c();
    }
}
