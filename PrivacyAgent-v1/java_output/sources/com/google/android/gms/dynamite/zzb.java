package com.google.android.gms.dynamite;

/* loaded from: classes22.dex */
final class zzb implements com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
    public final int zza(android.content.Context context, java.lang.String str) {
        return com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(context, str);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb
    public final int zza(android.content.Context context, java.lang.String str, boolean z) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        return com.google.android.gms.dynamite.DynamiteModule.zza(context, str, z);
    }
}
