package com.google.android.gms.dynamite;

/* loaded from: classes22.dex */
final class zzf implements com.google.android.gms.dynamite.DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza zza(android.content.Context context, java.lang.String str, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb zzbVar) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza zzaVar = new com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza();
        zzaVar.zza = zzbVar.zza(context, str);
        int zza = zzbVar.zza(context, str, true);
        zzaVar.zzb = zza;
        int i = zzaVar.zza;
        if (i == 0 && zza == 0) {
            zzaVar.zzc = 0;
        } else if (i >= zza) {
            zzaVar.zzc = -1;
        } else {
            zzaVar.zzc = 1;
        }
        return zzaVar;
    }
}
