package com.amap.api.col.s;

/* loaded from: classes12.dex */
public class di {
    public static int a = 1000;
    public static boolean b = false;
    public static java.lang.ref.WeakReference<com.amap.api.col.s.df> c = null;
    public static int d = 20;
    public static int e = 10;
    public static int f;

    public static class a extends com.amap.api.col.s.ec {
        public int t = 2;
        public android.content.Context u;
        public com.amap.api.col.s.dh v;

        public a(android.content.Context context) {
            this.u = context;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            int i = this.t;
            if (i == 1) {
                try {
                    synchronized (com.amap.api.col.s.di.class) {
                        java.lang.String l = java.lang.Long.toString(java.lang.System.currentTimeMillis());
                        com.amap.api.col.s.df a = com.amap.api.col.s.dl.a(com.amap.api.col.s.di.c);
                        com.amap.api.col.s.dl.a(this.u, a, com.amap.api.col.s.ch.i, com.amap.api.col.s.di.a, 2097152, "6");
                        if (a.e == null) {
                            a.e = new com.amap.api.col.s.cp(new com.amap.api.col.s.cr(new com.amap.api.col.s.cs(new com.amap.api.col.s.cr())));
                        }
                        com.amap.api.col.s.dg.a(l, this.v.b(), a);
                    }
                    return;
                } catch (java.lang.Throwable th) {
                    com.amap.api.col.s.cj.c(th, "ofm", "aple");
                    return;
                }
            }
            if (i == 2) {
                try {
                    com.amap.api.col.s.df a2 = com.amap.api.col.s.dl.a(com.amap.api.col.s.di.c);
                    com.amap.api.col.s.dl.a(this.u, a2, com.amap.api.col.s.ch.i, com.amap.api.col.s.di.a, 2097152, "6");
                    a2.h = 14400000;
                    if (a2.g == null) {
                        a2.g = new com.amap.api.col.s.dp(new com.amap.api.col.s.Cdo(this.u, new com.amap.api.col.s.dt(), new com.amap.api.col.s.cp(new com.amap.api.col.s.cr(new com.amap.api.col.s.cs())), new java.lang.String(com.amap.api.col.s.cd.a(10)), com.amap.api.col.s.bi.f(this.u), com.amap.api.col.s.bm.r(this.u), com.amap.api.col.s.bm.k(this.u), com.amap.api.col.s.bm.h(this.u), com.amap.api.col.s.bm.a(), android.os.Build.MANUFACTURER, android.os.Build.DEVICE, com.amap.api.col.s.bm.t(this.u), com.amap.api.col.s.bi.c(this.u), android.os.Build.MODEL, com.amap.api.col.s.bi.d(this.u), com.amap.api.col.s.bi.b(this.u), com.amap.api.col.s.bm.g(this.u), com.amap.api.col.s.bm.a(this.u), java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT)));
                    }
                    if (android.text.TextUtils.isEmpty(a2.i)) {
                        a2.i = "fKey";
                    }
                    android.content.Context context = this.u;
                    a2.f = new com.amap.api.col.s.dx(context, a2.h, a2.i, new com.amap.api.col.s.dv(context, com.amap.api.col.s.di.b, com.amap.api.col.s.di.e * 1024, com.amap.api.col.s.di.d * 1024, "offLocKey", com.amap.api.col.s.di.f * 1024));
                    com.amap.api.col.s.dg.a(a2);
                } catch (java.lang.Throwable th2) {
                    com.amap.api.col.s.cj.c(th2, "ofm", "uold");
                }
            }
        }
    }

    public static void a(android.content.Context context) {
        com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.di.a(context));
    }
}
