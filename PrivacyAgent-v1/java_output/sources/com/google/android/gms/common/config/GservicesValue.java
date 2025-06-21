package com.google.android.gms.common.config;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public abstract class GservicesValue<T> {
    public static final java.lang.Object b = new java.lang.Object();

    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"StaticFieldLeak"})
    public static android.content.Context c;

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public static java.util.Set<java.lang.String> d;

    @androidx.annotation.Nullable
    public T a = null;

    @androidx.annotation.RecentlyNonNull
    protected final java.lang.String zza;

    @androidx.annotation.RecentlyNonNull
    protected final T zzb;

    public interface zza {
        java.lang.Long a(java.lang.String str, java.lang.Long l);

        java.lang.String b(java.lang.String str, java.lang.String str2);

        java.lang.Integer c(java.lang.String str, java.lang.Integer num);

        java.lang.Float d(java.lang.String str, java.lang.Float f);

        java.lang.Boolean e(java.lang.String str, java.lang.Boolean bool);
    }

    public GservicesValue(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull T t) {
        this.zza = str;
        this.zzb = t;
    }

    public static boolean a() {
        synchronized (b) {
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isInitialized() {
        synchronized (b) {
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.config.GservicesValue<java.lang.Float> value(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Float f) {
        return new com.google.android.gms.common.config.zzc(str, f);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.config.GservicesValue<java.lang.Integer> value(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Integer num) {
        return new com.google.android.gms.common.config.zzd(str, num);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.config.GservicesValue<java.lang.Long> value(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Long l) {
        return new com.google.android.gms.common.config.zza(str, l);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.config.GservicesValue<java.lang.String> value(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        return new com.google.android.gms.common.config.zze(str, str2);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.config.GservicesValue<java.lang.Boolean> value(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull boolean z) {
        return new com.google.android.gms.common.config.zzb(str, java.lang.Boolean.valueOf(z));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final T get() {
        T t = this.a;
        if (t != null) {
            return t;
        }
        android.os.StrictMode.ThreadPolicy allowThreadDiskReads = android.os.StrictMode.allowThreadDiskReads();
        java.lang.Object obj = b;
        synchronized (obj) {
        }
        synchronized (obj) {
            d = null;
            c = null;
            try {
            } catch (java.lang.Throwable th) {
                android.os.StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th;
            }
        }
        try {
            T zza2 = zza(this.zza);
            android.os.StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zza2;
        } catch (java.lang.SecurityException unused) {
            long clearCallingIdentity = android.os.Binder.clearCallingIdentity();
            try {
                T zza3 = zza(this.zza);
                android.os.StrictMode.setThreadPolicy(allowThreadDiskReads);
                return zza3;
            } finally {
                android.os.Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public final T getBinderSafe() {
        return get();
    }

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public void override(@androidx.annotation.RecentlyNonNull T t) {
        this.a = t;
        synchronized (b) {
            a();
        }
    }

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public void resetOverride() {
        this.a = null;
    }

    @androidx.annotation.RecentlyNonNull
    public abstract T zza(@androidx.annotation.RecentlyNonNull java.lang.String str);
}
