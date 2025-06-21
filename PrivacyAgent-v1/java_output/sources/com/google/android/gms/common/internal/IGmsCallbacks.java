package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public interface IGmsCallbacks extends android.os.IInterface {

    public static abstract class zza extends com.google.android.gms.internal.common.zza implements com.google.android.gms.common.internal.IGmsCallbacks {
        public zza() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // com.google.android.gms.internal.common.zza
        public final boolean zza(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (android.os.Bundle) com.google.android.gms.internal.common.zzd.zza(parcel, android.os.Bundle.CREATOR));
            } else if (i == 2) {
                zza(parcel.readInt(), (android.os.Bundle) com.google.android.gms.internal.common.zzd.zza(parcel, android.os.Bundle.CREATOR));
            } else {
                if (i != 3) {
                    return false;
                }
                zza(parcel.readInt(), parcel.readStrongBinder(), (com.google.android.gms.common.internal.zzc) com.google.android.gms.internal.common.zzd.zza(parcel, com.google.android.gms.common.internal.zzc.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onPostInitComplete(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.IBinder iBinder, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle) throws android.os.RemoteException;

    void zza(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle) throws android.os.RemoteException;

    void zza(int i, android.os.IBinder iBinder, com.google.android.gms.common.internal.zzc zzcVar) throws android.os.RemoteException;
}
