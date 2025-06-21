package com.google.android.gms.dynamite;

/* loaded from: classes22.dex */
final class zza implements com.google.android.gms.dynamite.DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza zza(android.content.Context context, java.lang.String str, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb zzbVar) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza zzaVar = new com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza();
        int zza = zzbVar.zza(context, str, true);
        zzaVar.zzb = zza;
        if (zza != 0) {
            zzaVar.zzc = 1;
        } else {
            int zza2 = zzbVar.zza(context, str);
            zzaVar.zza = zza2;
            if (zza2 != 0) {
                zzaVar.zzc = -1;
            }
        }
        return zzaVar;
    }
}
