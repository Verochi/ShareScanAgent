package com.uc.crashsdk.a;

/* loaded from: classes19.dex */
public final class a {
    public static void a(java.lang.String str) {
        com.uc.crashsdk.g.P();
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        com.uc.crashsdk.g.P();
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.uc.crashsdk.g.P();
    }

    public static void b(java.lang.String str) {
        com.uc.crashsdk.g.P();
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (com.uc.crashsdk.b.d) {
            com.uc.crashsdk.JNIBridge.nativeLog(4, str, str2);
        }
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        if (com.uc.crashsdk.b.d) {
            com.uc.crashsdk.JNIBridge.nativeLog(5, str, str2);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (com.uc.crashsdk.b.d) {
            com.uc.crashsdk.JNIBridge.nativeLog(6, str, str2);
        }
    }
}
