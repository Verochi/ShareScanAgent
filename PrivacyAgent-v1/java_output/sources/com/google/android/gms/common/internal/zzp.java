package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public final class zzp extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.common.internal.IGmsCallbacks {
    public zzp(android.os.IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int i, android.os.IBinder iBinder, android.os.Bundle bundle) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        a_.writeInt(i);
        a_.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.zzd.zza(a_, bundle);
        zzb(1, a_);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zza(int i, android.os.Bundle bundle) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        a_.writeInt(i);
        com.google.android.gms.internal.common.zzd.zza(a_, bundle);
        zzb(2, a_);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zza(int i, android.os.IBinder iBinder, com.google.android.gms.common.internal.zzc zzcVar) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        a_.writeInt(i);
        a_.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.zzd.zza(a_, zzcVar);
        zzb(3, a_);
    }
}
