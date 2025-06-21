package com.meizu.cloud.pushinternal;

/* loaded from: classes23.dex */
public class DebugLogger {
    public static boolean debug;

    public static void d(java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushsdk.b.g.b().a(str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushsdk.b.g.b().d(str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.meizu.cloud.pushsdk.b.g.b().a(str, str2, th);
    }

    public static void flush() {
        com.meizu.cloud.pushsdk.b.g.b().a(false);
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushsdk.b.g.b().b(str, str2);
    }

    public static void init(android.content.Context context) {
        com.meizu.cloud.pushsdk.b.g.b().a(context);
    }

    public static void init(android.content.Context context, java.lang.String str) {
        com.meizu.cloud.pushsdk.b.g.b().a(context, str);
    }

    public static boolean isDebuggable() {
        return com.meizu.cloud.pushsdk.b.g.b().a();
    }

    public static void switchDebug(boolean z) {
        com.meizu.cloud.pushsdk.b.g.b().b(z);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushsdk.b.g.b().c(str, str2);
    }
}
