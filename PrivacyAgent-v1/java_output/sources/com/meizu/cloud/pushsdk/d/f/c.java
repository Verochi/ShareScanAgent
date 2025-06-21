package com.meizu.cloud.pushsdk.d.f;

/* loaded from: classes23.dex */
public class c {
    private static int a;

    private static java.lang.String a() {
        return java.lang.Thread.currentThread().getName();
    }

    private static java.lang.String a(java.lang.String str) {
        return "PushTracker->" + str;
    }

    private static java.lang.String a(java.lang.String str, java.lang.Object... objArr) {
        return a() + "|" + java.lang.String.format(str, objArr);
    }

    public static void a(com.meizu.cloud.pushsdk.d.f.b bVar) {
        a = bVar.a();
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (a >= com.meizu.cloud.pushsdk.d.f.b.ERROR.a()) {
            com.meizu.cloud.pushinternal.DebugLogger.e(a(str), a(str2, objArr));
        }
    }

    public static void b(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (a >= com.meizu.cloud.pushsdk.d.f.b.DEBUG.a()) {
            com.meizu.cloud.pushinternal.DebugLogger.d(a(str), a(str2, objArr));
        }
    }

    public static void c(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (a >= com.meizu.cloud.pushsdk.d.f.b.VERBOSE.a()) {
            com.meizu.cloud.pushinternal.DebugLogger.i(a(str), a(str2, objArr));
        }
    }
}
