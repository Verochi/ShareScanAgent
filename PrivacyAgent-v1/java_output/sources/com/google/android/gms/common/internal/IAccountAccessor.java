package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public interface IAccountAccessor extends android.os.IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements com.google.android.gms.common.internal.IAccountAccessor {

        public static class zza extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.common.internal.IAccountAccessor {
            public zza(android.os.IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.IAccountAccessor
            public final android.accounts.Account zza() throws android.os.RemoteException {
                android.os.Parcel zza = zza(2, a_());
                android.accounts.Account account = (android.accounts.Account) com.google.android.gms.internal.common.zzd.zza(zza, android.accounts.Account.CREATOR);
                zza.recycle();
                return account;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        @androidx.annotation.RecentlyNonNull
        public static com.google.android.gms.common.internal.IAccountAccessor asInterface(@androidx.annotation.RecentlyNonNull android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof com.google.android.gms.common.internal.IAccountAccessor ? (com.google.android.gms.common.internal.IAccountAccessor) queryLocalInterface : new com.google.android.gms.common.internal.IAccountAccessor.Stub.zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zza
        @androidx.annotation.RecentlyNonNull
        public final boolean zza(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull android.os.Parcel parcel2, @androidx.annotation.RecentlyNonNull int i2) throws android.os.RemoteException {
            if (i != 2) {
                return false;
            }
            android.accounts.Account zza2 = zza();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzd.zzb(parcel2, zza2);
            return true;
        }
    }

    @androidx.annotation.RecentlyNonNull
    android.accounts.Account zza() throws android.os.RemoteException;
}
