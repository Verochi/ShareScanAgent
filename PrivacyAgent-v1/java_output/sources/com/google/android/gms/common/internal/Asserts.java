package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class Asserts {
    public Asserts() {
        throw new java.lang.AssertionError("Uninstantiable");
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkMainThread(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread()) {
            return;
        }
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.Thread.currentThread());
        java.lang.String valueOf2 = java.lang.String.valueOf(android.os.Looper.getMainLooper().getThread());
        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 57 + valueOf2.length());
        sb.append("checkMainThread: current thread ");
        sb.append(valueOf);
        sb.append(" IS NOT the main thread ");
        sb.append(valueOf2);
        sb.append("!");
        throw new java.lang.IllegalStateException(str);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkNotMainThread(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        if (android.os.Looper.getMainLooper().getThread() != java.lang.Thread.currentThread()) {
            return;
        }
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.Thread.currentThread());
        java.lang.String valueOf2 = java.lang.String.valueOf(android.os.Looper.getMainLooper().getThread());
        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 56 + valueOf2.length());
        sb.append("checkNotMainThread: current thread ");
        sb.append(valueOf);
        sb.append(" IS the main thread ");
        sb.append(valueOf2);
        sb.append("!");
        throw new java.lang.IllegalStateException(str);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkNotNull(@androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("null reference");
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkNotNull(@androidx.annotation.RecentlyNonNull java.lang.Object obj, @androidx.annotation.RecentlyNonNull java.lang.Object obj2) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj2));
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void checkNull(@androidx.annotation.RecentlyNonNull java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.IllegalArgumentException("non-null reference");
        }
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
}
