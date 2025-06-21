package com.alipay.sdk.m.z;

/* loaded from: classes.dex */
public final class b {
    /* JADX WARN: Can't wrap try/catch for region: R(2:(3:9|10|(1:12)(0))|13) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.Throwable th;
        java.io.File file;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = null;
        try {
            file = new java.io.File(str, str2);
        } catch (java.io.IOException unused) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        if (!file.exists()) {
            return null;
        }
        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), "UTF-8"));
        while (true) {
            try {
                java.lang.String readLine = bufferedReader2.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                }
            } catch (java.io.IOException unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader2 = bufferedReader;
                    break;
                    bufferedReader2.close();
                }
                return sb.toString();
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                if (bufferedReader == null) {
                    throw th;
                }
                try {
                    bufferedReader.close();
                    throw th;
                } catch (java.lang.Throwable unused3) {
                    throw th;
                }
            }
            break;
        }
        bufferedReader2.close();
        return sb.toString();
    }
}
