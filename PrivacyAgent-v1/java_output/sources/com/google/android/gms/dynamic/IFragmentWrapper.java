package com.google.android.gms.dynamic;

/* loaded from: classes22.dex */
public interface IFragmentWrapper extends android.os.IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements com.google.android.gms.dynamic.IFragmentWrapper {

        public static class zza extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.dynamic.IFragmentWrapper {
            public zza(android.os.IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final com.google.android.gms.dynamic.IObjectWrapper zza() throws android.os.RemoteException {
                android.os.Parcel zza = zza(2, a_());
                com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(android.content.Intent intent) throws android.os.RemoteException {
                android.os.Parcel a_ = a_();
                com.google.android.gms.internal.common.zzd.zza(a_, intent);
                zzb(25, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(android.content.Intent intent, int i) throws android.os.RemoteException {
                android.os.Parcel a_ = a_();
                com.google.android.gms.internal.common.zzd.zza(a_, intent);
                a_.writeInt(i);
                zzb(26, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper) throws android.os.RemoteException {
                android.os.Parcel a_ = a_();
                com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
                zzb(20, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(boolean z) throws android.os.RemoteException {
                android.os.Parcel a_ = a_();
                com.google.android.gms.internal.common.zzd.zza(a_, z);
                zzb(21, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final android.os.Bundle zzb() throws android.os.RemoteException {
                android.os.Parcel zza = zza(3, a_());
                android.os.Bundle bundle = (android.os.Bundle) com.google.android.gms.internal.common.zzd.zza(zza, android.os.Bundle.CREATOR);
                zza.recycle();
                return bundle;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzb(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper) throws android.os.RemoteException {
                android.os.Parcel a_ = a_();
                com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
                zzb(27, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzb(boolean z) throws android.os.RemoteException {
                android.os.Parcel a_ = a_();
                com.google.android.gms.internal.common.zzd.zza(a_, z);
                zzb(22, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int zzc() throws android.os.RemoteException {
                android.os.Parcel zza = zza(4, a_());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzc(boolean z) throws android.os.RemoteException {
                android.os.Parcel a_ = a_();
                com.google.android.gms.internal.common.zzd.zza(a_, z);
                zzb(23, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final com.google.android.gms.dynamic.IFragmentWrapper zzd() throws android.os.RemoteException {
                android.os.Parcel zza = zza(5, a_());
                com.google.android.gms.dynamic.IFragmentWrapper asInterface = com.google.android.gms.dynamic.IFragmentWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzd(boolean z) throws android.os.RemoteException {
                android.os.Parcel a_ = a_();
                com.google.android.gms.internal.common.zzd.zza(a_, z);
                zzb(24, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final com.google.android.gms.dynamic.IObjectWrapper zze() throws android.os.RemoteException {
                android.os.Parcel zza = zza(6, a_());
                com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzf() throws android.os.RemoteException {
                android.os.Parcel zza = zza(7, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final java.lang.String zzg() throws android.os.RemoteException {
                android.os.Parcel zza = zza(8, a_());
                java.lang.String readString = zza.readString();
                zza.recycle();
                return readString;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final com.google.android.gms.dynamic.IFragmentWrapper zzh() throws android.os.RemoteException {
                android.os.Parcel zza = zza(9, a_());
                com.google.android.gms.dynamic.IFragmentWrapper asInterface = com.google.android.gms.dynamic.IFragmentWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int zzi() throws android.os.RemoteException {
                android.os.Parcel zza = zza(10, a_());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzj() throws android.os.RemoteException {
                android.os.Parcel zza = zza(11, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final com.google.android.gms.dynamic.IObjectWrapper zzk() throws android.os.RemoteException {
                android.os.Parcel zza = zza(12, a_());
                com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzl() throws android.os.RemoteException {
                android.os.Parcel zza = zza(13, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzm() throws android.os.RemoteException {
                android.os.Parcel zza = zza(14, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzn() throws android.os.RemoteException {
                android.os.Parcel zza = zza(15, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzo() throws android.os.RemoteException {
                android.os.Parcel zza = zza(16, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzp() throws android.os.RemoteException {
                android.os.Parcel zza = zza(17, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzq() throws android.os.RemoteException {
                android.os.Parcel zza = zza(18, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzr() throws android.os.RemoteException {
                android.os.Parcel zza = zza(19, a_());
                boolean zza2 = com.google.android.gms.internal.common.zzd.zza(zza);
                zza.recycle();
                return zza2;
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @androidx.annotation.RecentlyNonNull
        public static com.google.android.gms.dynamic.IFragmentWrapper asInterface(@androidx.annotation.RecentlyNonNull android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof com.google.android.gms.dynamic.IFragmentWrapper ? (com.google.android.gms.dynamic.IFragmentWrapper) queryLocalInterface : new com.google.android.gms.dynamic.IFragmentWrapper.Stub.zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zza
        @androidx.annotation.RecentlyNonNull
        public final boolean zza(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.os.Parcel parcel, @androidx.annotation.RecentlyNonNull android.os.Parcel parcel2, @androidx.annotation.RecentlyNonNull int i2) throws android.os.RemoteException {
            switch (i) {
                case 2:
                    com.google.android.gms.dynamic.IObjectWrapper zza2 = zza();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zza2);
                    return true;
                case 3:
                    android.os.Bundle zzb = zzb();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zzb(parcel2, zzb);
                    return true;
                case 4:
                    int zzc = zzc();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzc);
                    return true;
                case 5:
                    com.google.android.gms.dynamic.IFragmentWrapper zzd = zzd();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzd);
                    return true;
                case 6:
                    com.google.android.gms.dynamic.IObjectWrapper zze = zze();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zze);
                    return true;
                case 7:
                    boolean zzf = zzf();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzf);
                    return true;
                case 8:
                    java.lang.String zzg = zzg();
                    parcel2.writeNoException();
                    parcel2.writeString(zzg);
                    return true;
                case 9:
                    com.google.android.gms.dynamic.IFragmentWrapper zzh = zzh();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzh);
                    return true;
                case 10:
                    int zzi = zzi();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzi);
                    return true;
                case 11:
                    boolean zzj = zzj();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzj);
                    return true;
                case 12:
                    com.google.android.gms.dynamic.IObjectWrapper zzk = zzk();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzk);
                    return true;
                case 13:
                    boolean zzl = zzl();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzl);
                    return true;
                case 14:
                    boolean zzm = zzm();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzm);
                    return true;
                case 15:
                    boolean zzn = zzn();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzn);
                    return true;
                case 16:
                    boolean zzo = zzo();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzo);
                    return true;
                case 17:
                    boolean zzp = zzp();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzp);
                    return true;
                case 18:
                    boolean zzq = zzq();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzq);
                    return true;
                case 19:
                    boolean zzr = zzr();
                    parcel2.writeNoException();
                    com.google.android.gms.internal.common.zzd.zza(parcel2, zzr);
                    return true;
                case 20:
                    zza(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    zza(com.google.android.gms.internal.common.zzd.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    zzb(com.google.android.gms.internal.common.zzd.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    zzc(com.google.android.gms.internal.common.zzd.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    zzd(com.google.android.gms.internal.common.zzd.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    zza((android.content.Intent) com.google.android.gms.internal.common.zzd.zza(parcel, android.content.Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    zza((android.content.Intent) com.google.android.gms.internal.common.zzd.zza(parcel, android.content.Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    zzb(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    @androidx.annotation.RecentlyNonNull
    com.google.android.gms.dynamic.IObjectWrapper zza() throws android.os.RemoteException;

    void zza(@androidx.annotation.RecentlyNonNull android.content.Intent intent) throws android.os.RemoteException;

    void zza(@androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull int i) throws android.os.RemoteException;

    void zza(@androidx.annotation.RecentlyNonNull com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper) throws android.os.RemoteException;

    void zza(@androidx.annotation.RecentlyNonNull boolean z) throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    android.os.Bundle zzb() throws android.os.RemoteException;

    void zzb(@androidx.annotation.RecentlyNonNull com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper) throws android.os.RemoteException;

    void zzb(@androidx.annotation.RecentlyNonNull boolean z) throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    int zzc() throws android.os.RemoteException;

    void zzc(@androidx.annotation.RecentlyNonNull boolean z) throws android.os.RemoteException;

    @androidx.annotation.RecentlyNullable
    com.google.android.gms.dynamic.IFragmentWrapper zzd() throws android.os.RemoteException;

    void zzd(@androidx.annotation.RecentlyNonNull boolean z) throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    com.google.android.gms.dynamic.IObjectWrapper zze() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzf() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNullable
    java.lang.String zzg() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNullable
    com.google.android.gms.dynamic.IFragmentWrapper zzh() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    int zzi() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzj() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    com.google.android.gms.dynamic.IObjectWrapper zzk() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzl() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzm() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzn() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzo() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzp() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzq() throws android.os.RemoteException;

    @androidx.annotation.RecentlyNonNull
    boolean zzr() throws android.os.RemoteException;
}
