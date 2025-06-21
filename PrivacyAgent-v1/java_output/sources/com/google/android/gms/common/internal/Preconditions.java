package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class Preconditions {
    public Preconditions() {
        throw new java.lang.AssertionError("Uninstantiable");
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkArgument(@androidx.annotation.RecentlyNonNull boolean z) {
        if (!z) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkArgument(@androidx.annotation.RecentlyNonNull boolean z, @androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkArgument(@androidx.annotation.RecentlyNonNull boolean z, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Object... objArr) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format(str, objArr));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkHandlerThread(@androidx.annotation.RecentlyNonNull android.os.Handler handler) {
        android.os.Looper myLooper = android.os.Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            java.lang.String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            java.lang.String name2 = handler.getLooper().getThread().getName();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(name2).length() + 36 + java.lang.String.valueOf(name).length());
            sb.append("Must be called on ");
            sb.append(name2);
            sb.append(" thread, but got ");
            sb.append(name);
            sb.append(".");
            throw new java.lang.IllegalStateException(sb.toString());
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkHandlerThread(@androidx.annotation.RecentlyNonNull android.os.Handler handler, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (android.os.Looper.myLooper() != handler.getLooper()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkMainThread(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (!com.google.android.gms.common.util.zzb.zza()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String checkNotEmpty(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String checkNotEmpty(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
        return str;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkNotMainThread(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (com.google.android.gms.common.util.zzb.zza()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    @androidx.annotation.NonNull
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> T checkNotNull(@androidx.annotation.Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException("null reference");
    }

    @androidx.annotation.NonNull
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    @com.google.android.gms.common.annotation.KeepForSdk
    public static <T> T checkNotNull(@androidx.annotation.RecentlyNonNull T t, @androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int checkNotZero(@androidx.annotation.RecentlyNonNull int i) {
        if (i != 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException("Given Integer is zero");
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int checkNotZero(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        if (i != 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static long checkNotZero(@androidx.annotation.RecentlyNonNull long j) {
        if (j != 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException("Given Long is zero");
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static long checkNotZero(@androidx.annotation.RecentlyNonNull long j, @androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        if (j != 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkState(@androidx.annotation.RecentlyNonNull boolean z) {
        if (!z) {
            throw new java.lang.IllegalStateException();
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkState(@androidx.annotation.RecentlyNonNull boolean z, @androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkState(@androidx.annotation.RecentlyNonNull boolean z, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Object... objArr) {
        if (!z) {
            throw new java.lang.IllegalStateException(java.lang.String.format(str, objArr));
        }
    }
}
