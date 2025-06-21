package com.google.android.gms.dynamite;

/* loaded from: classes22.dex */
final class zze implements com.google.android.gms.dynamite.DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza zza(android.content.Context context, java.lang.String str, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zzb zzbVar) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza zzaVar = new com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza();
        int zza = zzbVar.zza(context, str);
        zzaVar.zza = zza;
        if (zza != 0) {
            zzaVar.zzb = zzbVar.zza(context, str, false);
        } else {
            zzaVar.zzb = zzbVar.zza(context, str, true);
        }
        int i = zzaVar.zza;
        if (i == 0 && zzaVar.zzb == 0) {
            zzaVar.zzc = 0;
        } else if (i >= zzaVar.zzb) {
            zzaVar.zzc = -1;
        } else {
            zzaVar.zzc = 1;
        }
        return zzaVar;
    }
}
