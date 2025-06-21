package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class CrashUtils {
    public static final java.lang.String[] a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    @androidx.annotation.Nullable
    public static android.os.DropBoxManager b = null;
    public static boolean c = false;
    public static int d = -1;

    @javax.annotation.concurrent.GuardedBy("CrashUtils.class")
    public static int e = 0;

    @javax.annotation.concurrent.GuardedBy("CrashUtils.class")
    public static int f = 0;

    public static boolean a(android.content.Context context, java.lang.Throwable th, int i) {
        try {
            com.google.android.gms.common.internal.Preconditions.checkNotNull(context);
            com.google.android.gms.common.internal.Preconditions.checkNotNull(th);
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean addDynamiteErrorToDropBox(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        return a(context, th, 536870912);
    }
}
