package com.google.android.gms.dynamite;

/* loaded from: classes22.dex */
public final class zzl extends com.google.android.gms.internal.common.zzb implements com.google.android.gms.dynamite.zzm {
    public zzl(android.os.IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzm
    public final com.google.android.gms.dynamic.IObjectWrapper zza(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper, java.lang.String str, int i, com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper2) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper2);
        android.os.Parcel zza = zza(2, a_);
        com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzm
    public final com.google.android.gms.dynamic.IObjectWrapper zzb(com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper, java.lang.String str, int i, com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper2) throws android.os.RemoteException {
        android.os.Parcel a_ = a_();
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        com.google.android.gms.internal.common.zzd.zza(a_, iObjectWrapper2);
        android.os.Parcel zza = zza(3, a_);
        com.google.android.gms.dynamic.IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }
}
