package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzb implements com.google.android.gms.tasks.OnSuccessListener<java.lang.Void> {
    public final /* synthetic */ com.google.android.gms.tasks.OnTokenCanceledListener a;

    public zzb(com.google.android.gms.tasks.zza zzaVar, com.google.android.gms.tasks.OnTokenCanceledListener onTokenCanceledListener) {
        this.a = onTokenCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(java.lang.Void r1) {
        this.a.onCanceled();
    }
}
