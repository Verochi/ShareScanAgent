package com.xiaomi.push;

/* loaded from: classes19.dex */
final class el {
    private static final boolean a = android.util.Log.isLoggable("BCompressed", 3);

    public static byte[] a(com.xiaomi.push.ek ekVar, byte[] bArr) {
        try {
            byte[] a2 = com.xiaomi.push.eo.a.a(bArr);
            if (a) {
                com.xiaomi.channel.commonutils.logger.b.a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + ekVar);
                if (ekVar.d == 1) {
                    com.xiaomi.channel.commonutils.logger.b.a("BCompressed", "decompress not support upStream");
                }
            }
            return a2;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("BCompressed", "decompress error ".concat(java.lang.String.valueOf(e)));
            return bArr;
        }
    }
}
