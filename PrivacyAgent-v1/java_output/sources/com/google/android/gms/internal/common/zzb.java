package com.google.android.gms.internal.common;

/* loaded from: classes22.dex */
public class zzb implements android.os.IInterface {
    private final android.os.IBinder zza;
    private final java.lang.String zzb;

    public zzb(android.os.IBinder iBinder, java.lang.String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    public final android.os.Parcel a_() {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        return obtain;
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this.zza;
    }

    public final android.os.Parcel zza(int i, android.os.Parcel parcel) throws android.os.RemoteException {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        try {
            try {
                this.zza.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (java.lang.RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    public final void zzb(int i, android.os.Parcel parcel) throws android.os.RemoteException {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        try {
            this.zza.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void zzc(int i, android.os.Parcel parcel) throws android.os.RemoteException {
        try {
            this.zza.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
