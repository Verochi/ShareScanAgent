package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class w extends com.vivo.push.util.b {
    private static com.vivo.push.util.w b;

    public static synchronized com.vivo.push.util.w b() {
        com.vivo.push.util.w wVar;
        synchronized (com.vivo.push.util.w.class) {
            if (b == null) {
                b = new com.vivo.push.util.w();
            }
            wVar = b;
        }
        return wVar;
    }

    private static byte[] c(java.lang.String str) {
        int i;
        byte[] bArr = null;
        try {
            java.lang.String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i = split.length;
            } else {
                i = 0;
            }
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = java.lang.Byte.parseByte(split[i2].trim());
            }
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
        }
        return bArr;
    }

    public final synchronized void a(android.content.Context context) {
        if (this.a == null) {
            this.a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] c = c(b("com.vivo.push.secure_cache_iv", ""));
        return (c == null || c.length <= 0) ? new byte[]{34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32} : c;
    }

    public final byte[] d() {
        byte[] c = c(b("com.vivo.push.secure_cache_key", ""));
        return (c == null || c.length <= 0) ? new byte[]{33, 34, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, 35, 34, 33} : c;
    }
}
