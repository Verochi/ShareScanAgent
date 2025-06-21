package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class bp {
    public static long a(java.lang.String str) {
        try {
            if (new java.io.File(str).exists()) {
                return android.system.Os.stat(str).st_size;
            }
            return 0L;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return 0L;
        }
    }
}
