package com.google.android.gms.dynamite;

/* loaded from: classes22.dex */
public final class zzj extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.dynamite.zzk {
    public zzj(android.os.IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zza(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper, java.lang.String str, boolean z) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        com.google.android.gms.internal.common.zzd.zza(a_, z);
        android.os.Parcel zza = zza(3, a_);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final com.google.android.gms.dynamic.IObjectWrapper zza(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper, java.lang.String str, int i) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        android.os.Parcel zza = zza(2, a_);
        com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final com.google.android.gms.dynamic.IObjectWrapper zza(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper, java.lang.String str, int i, com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper2) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper2);
        android.os.Parcel zza = zza(8, a_);
        com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zzb() throws android.os.RemoteException {
        android.os.Parcel zza = zza(6, a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zzb(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper, java.lang.String str, boolean z) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        com.google.android.gms.internal.common.zzd.zza(a_, z);
        android.os.Parcel zza = zza(5, a_);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final com.google.android.gms.dynamic.IObjectWrapper zzb(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper, java.lang.String str, int i) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        android.os.Parcel zza = zza(4, a_);
        com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final com.google.android.gms.dynamic.IObjectWrapper zzc(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper, java.lang.String str, boolean z) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        com.google.android.gms.internal.common.zzd.zza(a_, z);
        android.os.Parcel zza = zza(7, a_);
        com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }
}
