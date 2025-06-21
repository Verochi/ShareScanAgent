package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class fk {
    private static com.amap.api.mapcore.util.fk a;
    private final android.content.Context b;
    private final java.lang.String c = com.amap.api.mapcore.util.fr.a(com.amap.api.mapcore.util.fi.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private fk(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    public static com.amap.api.mapcore.util.fk a(android.content.Context context) {
        if (a == null) {
            synchronized (com.amap.api.mapcore.util.fk.class) {
                if (a == null) {
                    a = new com.amap.api.mapcore.util.fk(context);
                }
            }
        }
        return a;
    }

    public final synchronized void a() {
        try {
            if (com.amap.api.mapcore.util.ez.c() == null) {
                com.amap.api.mapcore.util.ez.a(com.amap.api.mapcore.util.fo.a());
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(java.lang.String str) {
        com.amap.api.mapcore.util.fl.a(this.b).a(this.c);
        com.amap.api.mapcore.util.fl.a(this.b).b(str);
    }
}
