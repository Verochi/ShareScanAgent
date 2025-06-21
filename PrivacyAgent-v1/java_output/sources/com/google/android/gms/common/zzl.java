package com.google.android.gms.common;

@javax.annotation.CheckReturnValue
/* loaded from: classes22.dex */
class zzl {
    public static final com.google.android.gms.common.zzl d = new com.google.android.gms.common.zzl(true, null, null);
    public final boolean a;

    @javax.annotation.Nullable
    public final java.lang.String b;

    @javax.annotation.Nullable
    public final java.lang.Throwable c;

    public zzl(boolean z, @javax.annotation.Nullable java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th) {
        this.a = z;
        this.b = str;
        this.c = th;
    }

    public static com.google.android.gms.common.zzl a() {
        return d;
    }

    public static com.google.android.gms.common.zzl b(@androidx.annotation.NonNull java.lang.String str) {
        return new com.google.android.gms.common.zzl(false, str, null);
    }

    public static com.google.android.gms.common.zzl c(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Throwable th) {
        return new com.google.android.gms.common.zzl(false, str, th);
    }

    public static com.google.android.gms.common.zzl d(java.util.concurrent.Callable<java.lang.String> callable) {
        return new com.google.android.gms.common.zzn(callable, null);
    }

    public static java.lang.String e(java.lang.String str, com.google.android.gms.common.zzd zzdVar, boolean z, boolean z2) {
        java.lang.String str2 = z2 ? "debug cert rejected" : "not allowed";
        java.lang.StringBuilder sb = new java.lang.StringBuilder(14);
        sb.append("12451009.false");
        return java.lang.String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", str2, str, com.google.android.gms.common.util.Hex.bytesToStringLowercase(((java.security.MessageDigest) com.google.android.gms.common.internal.Preconditions.checkNotNull(com.google.android.gms.common.util.AndroidUtilsLight.zza("SHA-1"))).digest(zzdVar.zza())), java.lang.Boolean.valueOf(z), sb.toString());
    }

    @javax.annotation.Nullable
    public java.lang.String f() {
        return this.b;
    }

    public final void g() {
        if (this.a || !android.util.Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.c != null) {
            f();
        } else {
            f();
        }
    }
}
