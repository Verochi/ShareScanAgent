package com.google.android.gms.common;

/* loaded from: classes22.dex */
abstract class zzd extends com.google.android.gms.common.internal.zzo {
    private int zza;

    public zzd(byte[] bArr) {
        com.google.android.gms.common.internal.Preconditions.checkArgument(bArr.length == 25);
        this.zza = java.util.Arrays.hashCode(bArr);
    }

    public static byte[] zza(java.lang.String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        com.google.android.gms.dynamic.IObjectWrapper zzb;
        if (obj != null && (obj instanceof com.google.android.gms.common.internal.zzm)) {
            try {
                com.google.android.gms.common.internal.zzm zzmVar = (com.google.android.gms.common.internal.zzm) obj;
                if (zzmVar.zzc() == hashCode() && (zzb = zzmVar.zzb()) != null) {
                    return java.util.Arrays.equals(zza(), (byte[]) com.google.android.gms.dynamic.ObjectWrapper.unwrap(zzb));
                }
                return false;
            } catch (android.os.RemoteException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return this.zza;
    }

    public abstract byte[] zza();

    @Override // com.google.android.gms.common.internal.zzm
    public final com.google.android.gms.dynamic.IObjectWrapper zzb() {
        return com.google.android.gms.dynamic.ObjectWrapper.wrap(zza());
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final int zzc() {
        return hashCode();
    }
}
