package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class dj {
    private static volatile com.amap.api.mapcore.util.dj b;
    private com.amap.api.mapcore.util.ii a;

    private dj() {
        this.a = null;
        this.a = com.amap.api.mapcore.util.dk.a("AMapThreadUtil");
    }

    public static com.amap.api.mapcore.util.dj a() {
        if (b == null) {
            synchronized (com.amap.api.mapcore.util.dj.class) {
                if (b == null) {
                    b = new com.amap.api.mapcore.util.dj();
                }
            }
        }
        return b;
    }

    public static void b() {
        if (b != null) {
            try {
                if (b.a != null) {
                    b.a.d();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            b.a = null;
            b = null;
        }
    }

    public static void b(com.amap.api.mapcore.util.ij ijVar) {
        if (ijVar != null) {
            try {
                ijVar.cancelTask();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(com.amap.api.mapcore.util.ij ijVar) {
        try {
            this.a.a(ijVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
