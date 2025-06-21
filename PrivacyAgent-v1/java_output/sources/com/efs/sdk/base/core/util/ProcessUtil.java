package com.efs.sdk.base.core.util;

/* loaded from: classes22.dex */
public class ProcessUtil {
    private static java.lang.String a = null;
    private static java.util.List<java.lang.Integer> b = null;
    private static long c = -1;

    public static java.lang.String getCurrentProcessName() {
        java.lang.String str = a;
        if (!android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String processName = getProcessName(android.os.Process.myPid());
        a = processName;
        return processName;
    }

    public static java.lang.String getProcessName(int i) {
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("/proc/" + i + "/cmdline")));
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while (true) {
                    int read = bufferedReader2.read();
                    if (read <= 0) {
                        sb.trimToSize();
                        java.lang.String sb2 = sb.toString();
                        try {
                            bufferedReader2.close();
                            return sb2;
                        } catch (java.lang.Throwable th) {
                            th.printStackTrace();
                            return sb2;
                        }
                    }
                    sb.append((char) read);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                try {
                    com.efs.sdk.base.core.util.Log.e("efs.base", "get process name error", th);
                    return "";
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = com.efs.sdk.base.core.util.ProcessUtil.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        r0.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (android.text.TextUtils.isEmpty(getProcessName(android.os.Process.myPid())) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        com.efs.sdk.base.core.util.ProcessUtil.b.add(java.lang.Integer.valueOf(android.os.Process.myPid()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        if (android.text.TextUtils.isEmpty(getProcessName(r7)) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        com.efs.sdk.base.core.util.ProcessUtil.b.add(java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        com.efs.sdk.base.core.util.ProcessUtil.c = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0033, code lost:
    
        com.efs.sdk.base.core.util.ProcessUtil.b = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isProcessExist(android.content.Context context, java.lang.String str) {
        try {
            int parseInt = java.lang.Integer.parseInt(str);
            java.util.List<java.lang.Integer> list = b;
            boolean z = false;
            if (list != null && !list.isEmpty() && c > 0 && java.lang.System.currentTimeMillis() - c <= 600000) {
                z = true;
            }
            return b.contains(java.lang.Integer.valueOf(parseInt));
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "Process exist judge error", th);
            return true;
        }
    }

    public static int myPid() {
        return android.os.Process.myPid();
    }
}
