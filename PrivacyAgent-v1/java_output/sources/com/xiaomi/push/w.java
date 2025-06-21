package com.xiaomi.push;

/* loaded from: classes19.dex */
final class w {
    private static volatile boolean a;

    public static boolean a(android.content.Context context) {
        try {
            java.lang.Class<?> a2 = com.xiaomi.push.jc.a(context, "com.bun.miitmdid.core.JLibrary");
            if (a2 != null) {
                if (!a) {
                    try {
                        a = true;
                        a2.getDeclaredMethod("InitEntry", android.content.Context.class).invoke(a2, context);
                    } catch (java.lang.Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.a("mdid:load lib error ".concat(java.lang.String.valueOf(th)));
                    }
                }
                return true;
            }
        } catch (java.lang.Throwable th2) {
            com.xiaomi.channel.commonutils.logger.b.a("mdid:check error ".concat(java.lang.String.valueOf(th2)));
        }
        return false;
    }
}
