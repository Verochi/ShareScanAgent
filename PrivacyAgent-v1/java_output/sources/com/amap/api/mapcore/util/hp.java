package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class hp {
    static int a = 1000;
    static boolean b = false;
    static int c = 20;
    static int d = 0;
    private static java.lang.ref.WeakReference<com.amap.api.mapcore.util.hl> e = null;
    private static int f = 10;

    public static class a extends com.amap.api.mapcore.util.ij {
        private int a;
        private android.content.Context b;
        private com.amap.api.mapcore.util.ho c;

        public a(android.content.Context context, int i) {
            this.b = context;
            this.a = i;
        }

        public a(android.content.Context context, com.amap.api.mapcore.util.ho hoVar) {
            this(context, 1);
            this.c = hoVar;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            int i = this.a;
            if (i == 1) {
                try {
                    synchronized (com.amap.api.mapcore.util.hp.class) {
                        java.lang.String l = java.lang.Long.toString(java.lang.System.currentTimeMillis());
                        com.amap.api.mapcore.util.hl a = com.amap.api.mapcore.util.hs.a(com.amap.api.mapcore.util.hp.e);
                        com.amap.api.mapcore.util.hs.a(this.b, a, com.amap.api.mapcore.util.gb.i, com.amap.api.mapcore.util.hp.a, 2097152, "6");
                        if (a.e == null) {
                            a.e = new com.amap.api.mapcore.util.gt(new com.amap.api.mapcore.util.gv(new com.amap.api.mapcore.util.gw(new com.amap.api.mapcore.util.gv())));
                        }
                        com.amap.api.mapcore.util.hm.a(l, this.c.a(), a);
                    }
                    return;
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.gd.c(th, "ofm", "aple");
                    return;
                }
            }
            if (i == 2) {
                try {
                    com.amap.api.mapcore.util.hl a2 = com.amap.api.mapcore.util.hs.a(com.amap.api.mapcore.util.hp.e);
                    com.amap.api.mapcore.util.hs.a(this.b, a2, com.amap.api.mapcore.util.gb.i, com.amap.api.mapcore.util.hp.a, 2097152, "6");
                    a2.h = 14400000;
                    if (a2.g == null) {
                        a2.g = new com.amap.api.mapcore.util.hw(new com.amap.api.mapcore.util.hv(this.b, new com.amap.api.mapcore.util.ia(), new com.amap.api.mapcore.util.gt(new com.amap.api.mapcore.util.gv(new com.amap.api.mapcore.util.gw())), new java.lang.String(com.amap.api.mapcore.util.fx.a(10)), com.amap.api.mapcore.util.ev.f(this.b), com.amap.api.mapcore.util.ez.s(this.b), com.amap.api.mapcore.util.ez.k(this.b), com.amap.api.mapcore.util.ez.h(this.b), com.amap.api.mapcore.util.ez.a(), android.os.Build.MANUFACTURER, android.os.Build.DEVICE, com.amap.api.mapcore.util.ez.v(this.b), com.amap.api.mapcore.util.ev.c(this.b), android.os.Build.MODEL, com.amap.api.mapcore.util.ev.d(this.b), com.amap.api.mapcore.util.ev.b(this.b), com.amap.api.mapcore.util.ez.g(this.b), com.amap.api.mapcore.util.ez.a(this.b), java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT)));
                    }
                    if (android.text.TextUtils.isEmpty(a2.i)) {
                        a2.i = "fKey";
                    }
                    android.content.Context context = this.b;
                    a2.f = new com.amap.api.mapcore.util.ie(context, a2.h, a2.i, new com.amap.api.mapcore.util.ic(context, com.amap.api.mapcore.util.hp.b, com.amap.api.mapcore.util.hp.f * 1024, com.amap.api.mapcore.util.hp.c * 1024, "offLocKey", com.amap.api.mapcore.util.hp.d * 1024));
                    com.amap.api.mapcore.util.hm.a(a2);
                } catch (java.lang.Throwable th2) {
                    com.amap.api.mapcore.util.gd.c(th2, "ofm", "uold");
                }
            }
        }
    }

    @java.lang.Deprecated
    public static synchronized void a(int i, boolean z) {
        synchronized (com.amap.api.mapcore.util.hp.class) {
            a = i;
            b = z;
        }
    }

    public static void a(android.content.Context context) {
        com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.hp.a(context, 2));
    }

    public static synchronized void a(com.amap.api.mapcore.util.ho hoVar, android.content.Context context) {
        synchronized (com.amap.api.mapcore.util.hp.class) {
            com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.hp.a(context, hoVar));
        }
    }
}
