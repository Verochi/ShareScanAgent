package com.anythink.core.common.i;

/* loaded from: classes12.dex */
public final class a {
    private static final int a = 100;
    private static long b;
    private static long c = android.os.SystemClock.uptimeMillis();
    private static final java.io.File d = new java.io.File(com.anythink.core.common.o.d.b("L3Byb2Mv") + android.os.Process.myPid() + com.anythink.core.common.o.d.b("L3N0YXQ="));

    public static int a() {
        java.io.InputStreamReader inputStreamReader;
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        try {
            fileInputStream = new java.io.FileInputStream(d);
            try {
                inputStreamReader = new java.io.InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new java.io.BufferedReader(inputStreamReader);
                } catch (java.lang.Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                bufferedReader = null;
                th = th3;
                inputStreamReader = null;
            }
        } catch (java.lang.Throwable th4) {
            inputStreamReader = null;
            bufferedReader = null;
            th = th4;
            fileInputStream = null;
        }
        try {
            java.lang.String[] split = bufferedReader.readLine().split(" ");
            long parseLong = java.lang.Long.parseLong(split[13]) + java.lang.Long.parseLong(split[14]);
            long j = parseLong - b;
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            float f = ((uptimeMillis - c) / 1000.0f) * 100.0f;
            b = parseLong;
            c = uptimeMillis;
            int availableProcessors = (int) (((j / f) * 100.0f) / java.lang.Runtime.getRuntime().availableProcessors());
            try {
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
            } catch (java.lang.Throwable unused) {
            }
            return availableProcessors;
        } catch (java.lang.Throwable th5) {
            th = th5;
            try {
                th.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Throwable unused2) {
                        return 0;
                    }
                }
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Throwable unused3) {
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        }
    }
}
