package com.google.android.gms.common;

@javax.annotation.CheckReturnValue
/* loaded from: classes22.dex */
final class zzc {
    public static volatile com.google.android.gms.common.internal.zzr a;
    public static final java.lang.Object b = new java.lang.Object();
    public static android.content.Context c;

    public static com.google.android.gms.common.zzl a(java.lang.String str, com.google.android.gms.common.zzd zzdVar, boolean z, boolean z2) {
        android.os.StrictMode.ThreadPolicy allowThreadDiskReads = android.os.StrictMode.allowThreadDiskReads();
        try {
            return d(str, zzdVar, z, z2);
        } finally {
            android.os.StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static final /* synthetic */ java.lang.String b(boolean z, java.lang.String str, com.google.android.gms.common.zzd zzdVar) throws java.lang.Exception {
        boolean z2 = false;
        if (!z && d(str, zzdVar, true, false).a) {
            z2 = true;
        }
        return com.google.android.gms.common.zzl.e(str, zzdVar, z, z2);
    }

    public static synchronized void c(android.content.Context context) {
        synchronized (com.google.android.gms.common.zzc.class) {
            if (c != null || context == null) {
                return;
            }
            c = context.getApplicationContext();
        }
    }

    public static com.google.android.gms.common.zzl d(java.lang.String str, com.google.android.gms.common.zzd zzdVar, boolean z, boolean z2) {
        try {
            if (a == null) {
                com.google.android.gms.common.internal.Preconditions.checkNotNull(c);
                synchronized (b) {
                    if (a == null) {
                        a = com.google.android.gms.common.internal.zzq.zza(com.google.android.gms.dynamite.DynamiteModule.load(c, com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(c);
            try {
                return a.zza(new com.google.android.gms.common.zzj(str, zzdVar, z, z2), com.google.android.gms.dynamic.ObjectWrapper.wrap(c.getPackageManager())) ? com.google.android.gms.common.zzl.a() : com.google.android.gms.common.zzl.d(new com.google.android.gms.common.zze(z, str, zzdVar));
            } catch (android.os.RemoteException e) {
                return com.google.android.gms.common.zzl.c("module call", e);
            }
        } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException e2) {
            java.lang.String valueOf = java.lang.String.valueOf(e2.getMessage());
            return com.google.android.gms.common.zzl.c(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new java.lang.String("module init: "), e2);
        }
    }
}
