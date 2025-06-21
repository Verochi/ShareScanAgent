package com.loc;

/* loaded from: classes23.dex */
public class ca {
    static int a = 1000;
    static boolean b = false;
    static int c = 20;
    static int d = 0;
    private static java.lang.ref.WeakReference<com.loc.bx> e = null;
    private static int f = 10;

    public static class a extends com.loc.cu {
        private int a;
        private android.content.Context b;
        private com.loc.bz c;

        public a(android.content.Context context, int i) {
            this.b = context;
            this.a = i;
        }

        public a(android.content.Context context, com.loc.bz bzVar) {
            this(context, 1);
            this.c = bzVar;
        }

        @Override // com.loc.cu
        public final void a() {
            int i = this.a;
            if (i == 1) {
                try {
                    synchronized (com.loc.ca.class) {
                        java.lang.String l = java.lang.Long.toString(java.lang.System.currentTimeMillis());
                        com.loc.bx a = com.loc.cd.a(com.loc.ca.e);
                        com.loc.cd.a(this.b, a, com.loc.au.i, com.loc.ca.a, 2097152, "6");
                        if (a.e == null) {
                            a.e = new com.loc.bh(new com.loc.bj(new com.loc.bk(new com.loc.bj())));
                        }
                        com.loc.by.a(l, this.c.a(), a);
                    }
                    return;
                } catch (java.lang.Throwable th) {
                    com.loc.aw.b(th, "ofm", "aple");
                    return;
                }
            }
            if (i == 2) {
                try {
                    com.loc.bx a2 = com.loc.cd.a(com.loc.ca.e);
                    com.loc.cd.a(this.b, a2, com.loc.au.i, com.loc.ca.a, 2097152, "6");
                    a2.h = 14400000;
                    if (a2.g == null) {
                        a2.g = new com.loc.ch(new com.loc.cg(this.b, new com.loc.cl(), new com.loc.bh(new com.loc.bj(new com.loc.bk())), new java.lang.String(com.loc.ah.a()), com.loc.m.f(this.b), com.loc.p.k(), com.loc.p.h(), com.loc.p.f(this.b), com.loc.p.a(), android.os.Build.MANUFACTURER, android.os.Build.DEVICE, com.loc.p.n(), com.loc.m.c(this.b), android.os.Build.MODEL, com.loc.m.d(this.b), com.loc.m.b(this.b), com.loc.p.e(this.b), com.loc.p.a(this.b), java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT), com.loc.ad.a(this.b).a()));
                    }
                    if (android.text.TextUtils.isEmpty(a2.i)) {
                        a2.i = "fKey";
                    }
                    android.content.Context context = this.b;
                    a2.f = new com.loc.cp(context, a2.h, a2.i, new com.loc.cn(context, com.loc.ca.b, com.loc.ca.f * 1024, com.loc.ca.c * 1024, "offLocKey", com.loc.ca.d * 1024));
                    com.loc.by.a(a2);
                } catch (java.lang.Throwable th2) {
                    com.loc.aw.b(th2, "ofm", "uold");
                }
            }
        }
    }

    public static synchronized void a(int i, boolean z, int i2, int i3) {
        synchronized (com.loc.ca.class) {
            a = i;
            b = z;
            if (i2 < 10 || i2 > 100) {
                i2 = 20;
            }
            c = i2;
            if (i2 / 5 > f) {
                f = i2 / 5;
            }
            d = i3;
        }
    }

    public static void a(android.content.Context context) {
        com.loc.ct.a().b(new com.loc.ca.a(context, 2));
    }

    public static synchronized void a(com.loc.bz bzVar, android.content.Context context) {
        synchronized (com.loc.ca.class) {
            com.loc.ct.a().b(new com.loc.ca.a(context, bzVar));
        }
    }
}
