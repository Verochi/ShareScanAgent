package com.google.android.gms.common;

/* loaded from: classes22.dex */
abstract class zzf extends com.google.android.gms.common.zzd {
    private static final java.lang.ref.WeakReference<byte[]> zzb = new java.lang.ref.WeakReference<>(null);
    private java.lang.ref.WeakReference<byte[]> zza;

    public zzf(byte[] bArr) {
        super(bArr);
        this.zza = zzb;
    }

    @Override // com.google.android.gms.common.zzd
    public final byte[] zza() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zza.get();
            if (bArr == null) {
                bArr = zzd();
                this.zza = new java.lang.ref.WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] zzd();
}
