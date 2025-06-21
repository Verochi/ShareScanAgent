package com.meizu.cloud.pushsdk.c.a;

/* loaded from: classes23.dex */
public class a {
    private static boolean a = false;
    private static java.lang.String b = "AndroidNetworking";

    public static void a() {
        a = true;
    }

    public static void a(java.lang.String str) {
        if (a) {
            com.meizu.cloud.pushinternal.DebugLogger.d(b, str);
        }
    }

    public static void b(java.lang.String str) {
        if (a) {
            com.meizu.cloud.pushinternal.DebugLogger.i(b, str);
        }
    }
}
