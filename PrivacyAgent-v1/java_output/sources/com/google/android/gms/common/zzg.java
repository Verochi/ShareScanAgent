package com.google.android.gms.common;

/* loaded from: classes22.dex */
final class zzg extends com.google.android.gms.common.zzd {
    private final byte[] zza;

    public zzg(byte[] bArr) {
        super(java.util.Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    @Override // com.google.android.gms.common.zzd
    public final byte[] zza() {
        return this.zza;
    }
}
