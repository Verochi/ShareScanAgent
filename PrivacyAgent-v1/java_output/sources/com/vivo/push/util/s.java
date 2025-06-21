package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class s {
    public static int a(com.vivo.push.b.c cVar) {
        com.vivo.push.util.w b = com.vivo.push.util.w.b();
        int b2 = cVar.b();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        int a = b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT");
        long b3 = currentTimeMillis - b.b("com.vivo.push_preferences.operate." + b2 + "START_TIME", 0L);
        if (b3 <= 86400000 && b3 >= 0) {
            if (a >= cVar.f()) {
                return 1001;
            }
            b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT", a + 1);
            return 0;
        }
        b.a("com.vivo.push_preferences.operate." + b2 + "START_TIME", java.lang.System.currentTimeMillis());
        b.a("com.vivo.push_preferences.operate." + b2 + "OPERATE_COUNT", 1);
        return 0;
    }
}
