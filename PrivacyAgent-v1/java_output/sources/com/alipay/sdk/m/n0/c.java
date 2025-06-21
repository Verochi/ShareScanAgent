package com.alipay.sdk.m.n0;

/* loaded from: classes.dex */
public class c {
    public static com.alipay.sdk.m.n0.b a;
    public static final java.lang.Object b = new java.lang.Object();

    public static long a(com.alipay.sdk.m.n0.b bVar) {
        if (bVar == null) {
            return 0L;
        }
        java.lang.String format = java.lang.String.format("%s%s%s%s%s", bVar.c(), bVar.d(), java.lang.Long.valueOf(bVar.a()), bVar.e(), bVar.b());
        if (com.alipay.sdk.m.l0.f.m12a(format)) {
            return 0L;
        }
        java.util.zip.Adler32 adler32 = new java.util.zip.Adler32();
        adler32.reset();
        adler32.update(format.getBytes());
        return adler32.getValue();
    }

    public static com.alipay.sdk.m.n0.b a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        synchronized (b) {
            java.lang.String b2 = com.alipay.sdk.m.n0.d.a(context).b();
            if (com.alipay.sdk.m.l0.f.m12a(b2)) {
                return null;
            }
            if (b2.endsWith("\n")) {
                b2 = b2.substring(0, b2.length() - 1);
            }
            com.alipay.sdk.m.n0.b bVar = new com.alipay.sdk.m.n0.b();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String a2 = com.alipay.sdk.m.l0.d.a(context);
            java.lang.String b3 = com.alipay.sdk.m.l0.d.b(context);
            bVar.c(a2);
            bVar.a(a2);
            bVar.b(currentTimeMillis);
            bVar.b(b3);
            bVar.d(b2);
            bVar.a(a(bVar));
            return bVar;
        }
    }

    public static synchronized com.alipay.sdk.m.n0.b b(android.content.Context context) {
        synchronized (com.alipay.sdk.m.n0.c.class) {
            com.alipay.sdk.m.n0.b bVar = a;
            if (bVar != null) {
                return bVar;
            }
            if (context == null) {
                return null;
            }
            com.alipay.sdk.m.n0.b a2 = a(context);
            a = a2;
            return a2;
        }
    }
}
