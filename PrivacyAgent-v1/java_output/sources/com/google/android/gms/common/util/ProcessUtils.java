package com.google.android.gms.common.util;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class ProcessUtils {

    @javax.annotation.Nullable
    public static java.lang.String a;
    public static int b;

    public static java.io.BufferedReader a(java.lang.String str) throws java.io.IOException {
        android.os.StrictMode.ThreadPolicy allowThreadDiskReads = android.os.StrictMode.allowThreadDiskReads();
        try {
            return new java.io.BufferedReader(new java.io.FileReader(str));
        } finally {
            android.os.StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @javax.annotation.Nullable
    public static java.lang.String b(int i) {
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader;
        java.lang.String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = a(sb.toString());
            try {
                str = ((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(bufferedReader.readLine())).trim();
                com.google.android.gms.common.util.IOUtils.closeQuietly(bufferedReader);
            } catch (java.io.IOException unused) {
                com.google.android.gms.common.util.IOUtils.closeQuietly(bufferedReader);
                return str;
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.google.android.gms.common.util.IOUtils.closeQuietly(bufferedReader);
                throw th;
            }
        } catch (java.io.IOException unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        return str;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static java.lang.String getMyProcessName() {
        if (a == null) {
            if (b == 0) {
                b = android.os.Process.myPid();
            }
            a = b(b);
        }
        return a;
    }
}
