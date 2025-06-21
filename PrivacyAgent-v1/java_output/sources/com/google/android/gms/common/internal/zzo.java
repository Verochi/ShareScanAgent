package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public abstract class zzo extends com.google.android.gms.internal.common.zza implements com.google.android.gms.common.internal.zzm {
    public zzo() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static com.google.android.gms.common.internal.zzm zza(android.os.IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof com.google.android.gms.common.internal.zzm ? (com.google.android.gms.common.internal.zzm) queryLocalInterface : new com.google.android.gms.common.internal.zzn(iBinder);
    }

    @Override // com.google.android.gms.internal.common.zza
    public final boolean zza(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        if (i == 1) {
            com.google.android.gms.dynamic.IObjectWrapper zzb = zzb();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzd.zza(parcel2, zzb);
        } else {
            if (i != 2) {
                return false;
            }
            int zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(zzc);
        }
        return true;
    }
}
