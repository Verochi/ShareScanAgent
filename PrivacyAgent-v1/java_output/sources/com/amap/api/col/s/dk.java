package com.amap.api.col.s;

/* loaded from: classes12.dex */
public class dk {
    public static boolean a = false;
    public static int b = 20;
    public static int c = 20;
    public static java.lang.ref.WeakReference<com.amap.api.col.s.df> d;
    public static int e;

    public static class a extends com.amap.api.col.s.ec {
        public static int x = 1;
        public static int y = 2;
        public static int z = 3;
        public android.content.Context t;
        public com.amap.api.col.s.dj u;
        public int v;
        public java.util.List<com.amap.api.col.s.dj> w;

        public a(android.content.Context context, int i) {
            this.t = context;
            this.v = i;
        }

        public a(android.content.Context context, int i, com.amap.api.col.s.dj djVar) {
            this(context, i);
            this.u = djVar;
        }

        public a(android.content.Context context, int i, java.util.List<com.amap.api.col.s.dj> list) {
            this(context, i);
            this.w = list;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            com.amap.api.col.s.dj djVar;
            java.lang.Throwable th;
            int i = this.v;
            if (i == 1) {
                try {
                    if (this.t != null && this.u != null) {
                        synchronized (com.amap.api.col.s.dk.class) {
                            android.content.Context context = this.t;
                            if (context != null && (djVar = this.u) != null) {
                                com.amap.api.col.s.dk.b(context, djVar.a());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (java.lang.Throwable th2) {
                    com.amap.api.col.s.cj.c(th2, "stm", "as");
                    return;
                }
            }
            if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.t == null) {
                            return;
                        }
                        com.amap.api.col.s.df a = com.amap.api.col.s.dl.a(com.amap.api.col.s.dk.d);
                        com.amap.api.col.s.dl.a(this.t, a, com.amap.api.col.s.ch.h, 1000, 307200, "2");
                        if (a.g == null) {
                            a.g = new com.amap.api.col.s.dm(new com.amap.api.col.s.dq(this.t, new com.amap.api.col.s.dn(new com.amap.api.col.s.dr(new com.amap.api.col.s.dt()))));
                        }
                        a.h = 3600000;
                        if (android.text.TextUtils.isEmpty(a.i)) {
                            a.i = "cKey";
                        }
                        if (a.f == null) {
                            android.content.Context context2 = this.t;
                            a.f = new com.amap.api.col.s.dx(context2, a.h, a.i, new com.amap.api.col.s.du(a.a, new com.amap.api.col.s.dv(context2, com.amap.api.col.s.dk.a, com.amap.api.col.s.dk.c * 1024, com.amap.api.col.s.dk.b * 1024, "staticUpdate", com.amap.api.col.s.dk.e * 1024)));
                        }
                        com.amap.api.col.s.dg.a(a);
                        return;
                    } catch (java.lang.Throwable th3) {
                        com.amap.api.col.s.cj.c(th3, "stm", "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (com.amap.api.col.s.dk.class) {
                    if (this.w != null && this.t != null) {
                        byte[] bArr = new byte[0];
                        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
                        try {
                            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                            try {
                                for (com.amap.api.col.s.dj djVar2 : this.w) {
                                    if (djVar2 != null) {
                                        byteArrayOutputStream2.write(djVar2.a());
                                    }
                                }
                                bArr = byteArrayOutputStream2.toByteArray();
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (java.lang.Throwable th4) {
                                    th = th4;
                                    th.printStackTrace();
                                    com.amap.api.col.s.dk.b(this.t, bArr);
                                }
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    com.amap.api.col.s.cj.c(th, "stm", "aStB");
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (java.lang.Throwable th6) {
                                            th = th6;
                                            th.printStackTrace();
                                            com.amap.api.col.s.dk.b(this.t, bArr);
                                        }
                                    }
                                    com.amap.api.col.s.dk.b(this.t, bArr);
                                } finally {
                                }
                            }
                        } catch (java.lang.Throwable th7) {
                            th = th7;
                        }
                        com.amap.api.col.s.dk.b(this.t, bArr);
                    }
                }
            } catch (java.lang.Throwable th8) {
                com.amap.api.col.s.cj.c(th8, "stm", "apb");
            }
        }
    }

    public static void a(android.content.Context context) {
        com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.dk.a(context, com.amap.api.col.s.dk.a.z));
    }

    public static synchronized void a(com.amap.api.col.s.dj djVar, android.content.Context context) {
        synchronized (com.amap.api.col.s.dk.class) {
            com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.dk.a(context, com.amap.api.col.s.dk.a.x, djVar));
        }
    }

    public static synchronized void a(java.util.List<com.amap.api.col.s.dj> list, android.content.Context context) {
        synchronized (com.amap.api.col.s.dk.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.dk.a(context, com.amap.api.col.s.dk.a.y, list));
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    public static /* synthetic */ void b(android.content.Context context, byte[] bArr) throws java.io.IOException {
        com.amap.api.col.s.df a2 = com.amap.api.col.s.dl.a(d);
        com.amap.api.col.s.dl.a(context, a2, com.amap.api.col.s.ch.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new com.amap.api.col.s.cn();
        }
        try {
            com.amap.api.col.s.dg.a(java.lang.Integer.toString(new java.util.Random().nextInt(100)) + java.lang.Long.toString(java.lang.System.nanoTime()), bArr, a2);
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "stm", "wts");
        }
    }
}
