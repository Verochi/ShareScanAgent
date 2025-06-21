package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
final class k {
    private static com.meizu.cloud.pushsdk.c.g.j a;
    private static long b;

    private k() {
    }

    public static com.meizu.cloud.pushsdk.c.g.j a() {
        synchronized (com.meizu.cloud.pushsdk.c.g.k.class) {
            com.meizu.cloud.pushsdk.c.g.j jVar = a;
            if (jVar == null) {
                return new com.meizu.cloud.pushsdk.c.g.j();
            }
            a = jVar.f;
            jVar.f = null;
            b -= 2048;
            return jVar;
        }
    }

    public static void a(com.meizu.cloud.pushsdk.c.g.j jVar) {
        if (jVar.f != null || jVar.g != null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (jVar.d) {
            return;
        }
        synchronized (com.meizu.cloud.pushsdk.c.g.k.class) {
            long j = b;
            if (j + 2048 > 65536) {
                return;
            }
            b = j + 2048;
            jVar.f = a;
            jVar.c = 0;
            jVar.b = 0;
            a = jVar;
        }
    }
}
