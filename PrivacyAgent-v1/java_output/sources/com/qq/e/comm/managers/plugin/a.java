package com.qq.e.comm.managers.plugin;

/* loaded from: classes19.dex */
public class a {
    private static java.lang.reflect.Method a;
    private static boolean b;

    public static void a(java.lang.Throwable th, java.lang.String str) {
        try {
            java.lang.Exception exc = new java.lang.Exception("插件错误：" + str, th);
            if (b) {
                return;
            }
            if (a == null) {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", java.lang.Throwable.class);
                a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            a.invoke(null, exc);
        } catch (java.lang.Throwable unused) {
            b = true;
        }
    }
}
