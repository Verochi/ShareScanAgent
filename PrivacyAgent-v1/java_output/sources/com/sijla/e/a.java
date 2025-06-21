package com.sijla.e;

/* loaded from: classes19.dex */
public final class a {
    private static long a;

    public static void a(android.content.Context context) {
        if (java.lang.System.currentTimeMillis() - a < 60000) {
            return;
        }
        a = java.lang.System.currentTimeMillis();
        com.sijla.h.c.a(context, "cpn", new com.sijla.e.b());
    }
}
