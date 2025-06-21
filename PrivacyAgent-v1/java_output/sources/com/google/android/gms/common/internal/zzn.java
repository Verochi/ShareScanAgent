package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public final class zzn extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.common.internal.zzm {
    public zzn(android.os.IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final com.google.android.gms.dynamic.IObjectWrapper zzb() throws android.os.RemoteException {
        android.os.Parcel zza = zza(1, a_());
        com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final int zzc() throws android.os.RemoteException {
        android.os.Parcel zza = zza(2, a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
