package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public final class zzs extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.common.internal.zzr {
    public zzs(android.os.IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzr
    public final boolean zza(com.google.android.gms.common.zzj zzjVar, com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, zzjVar);
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        android.os.Parcel zza = zza(5, a_);
        boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
        zza.recycle();
        return zza2;
    }
}
