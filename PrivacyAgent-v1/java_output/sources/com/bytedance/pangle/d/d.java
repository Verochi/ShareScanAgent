package com.bytedance.pangle.d;

/* loaded from: classes12.dex */
public final class d {
    private static java.lang.String a;
    private static java.util.List<java.lang.String> b = new java.util.concurrent.CopyOnWriteArrayList();

    public static java.lang.String a() {
        java.lang.String processName;
        if (!android.text.TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                processName = android.app.Application.getProcessName();
                if (!android.text.TextUtils.isEmpty(processName)) {
                    a = processName;
                }
                return a;
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.Object invokeStaticMethod = com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(java.lang.Class.forName("android.app.ActivityThread"), "currentProcessName", new java.lang.Object[0]);
            if (!android.text.TextUtils.isEmpty((java.lang.String) invokeStaticMethod)) {
                a = (java.lang.String) invokeStaticMethod;
            }
            return a;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            java.lang.String b2 = b();
            a = b2;
            return b2;
        }
    }

    public static java.lang.String a(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || !str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) ? "main" : str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1];
    }

    public static boolean a(android.content.Context context) {
        java.lang.String a2 = a();
        return (a2 == null || !a2.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) && a2 != null && a2.equals(context.getPackageName());
    }

    private static java.lang.String b() {
        java.io.BufferedReader bufferedReader;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("/proc/" + android.os.Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (java.lang.Throwable unused) {
            bufferedReader = null;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (com.bytedance.pangle.log.ZeusLogger.isDebug()) {
                com.bytedance.pangle.log.ZeusLogger.d("Process", "get processName = " + sb.toString());
            }
            java.lang.String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (java.lang.Exception unused2) {
            }
            return sb2;
        } catch (java.lang.Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (java.lang.Exception unused4) {
                }
            }
            return null;
        }
    }
}
