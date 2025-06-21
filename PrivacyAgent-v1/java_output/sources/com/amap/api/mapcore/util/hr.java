package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class hr {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static java.lang.ref.WeakReference<com.amap.api.mapcore.util.hl> d;
    private static int e;

    public static class a extends com.amap.api.mapcore.util.ij {
        static int a = 1;
        static int b = 2;
        static int c = 3;
        private android.content.Context d;
        private com.amap.api.mapcore.util.hq e;
        private int g;
        private java.util.List<com.amap.api.mapcore.util.hq> h;

        public a(android.content.Context context, int i) {
            this.d = context;
            this.g = i;
        }

        public a(android.content.Context context, int i, com.amap.api.mapcore.util.hq hqVar) {
            this(context, i);
            this.e = hqVar;
        }

        public a(android.content.Context context, int i, java.util.List<com.amap.api.mapcore.util.hq> list) {
            this(context, i);
            this.h = list;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.amap.api.mapcore.util.hq hqVar;
            java.lang.Throwable th;
            int i = this.g;
            if (i == 1) {
                try {
                    if (this.d != null && this.e != null) {
                        synchronized (com.amap.api.mapcore.util.hr.class) {
                            android.content.Context context = this.d;
                            if (context != null && (hqVar = this.e) != null) {
                                com.amap.api.mapcore.util.hr.a(context, hqVar.a());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (java.lang.Throwable th2) {
                    com.amap.api.mapcore.util.gd.c(th2, "stm", "as");
                    return;
                }
            }
            if (i != 2) {
                if (i == 3) {
                    try {
                        if (this.d == null) {
                            return;
                        }
                        com.amap.api.mapcore.util.hl a2 = com.amap.api.mapcore.util.hs.a(com.amap.api.mapcore.util.hr.d);
                        com.amap.api.mapcore.util.hs.a(this.d, a2, com.amap.api.mapcore.util.gb.h, 1000, 307200, "2");
                        if (a2.g == null) {
                            a2.g = new com.amap.api.mapcore.util.ht(new com.amap.api.mapcore.util.hx(this.d, new com.amap.api.mapcore.util.hu(new com.amap.api.mapcore.util.hy(new com.amap.api.mapcore.util.ia()))));
                        }
                        a2.h = 3600000;
                        if (android.text.TextUtils.isEmpty(a2.i)) {
                            a2.i = "cKey";
                        }
                        if (a2.f == null) {
                            android.content.Context context2 = this.d;
                            a2.f = new com.amap.api.mapcore.util.ie(context2, a2.h, a2.i, new com.amap.api.mapcore.util.ib(a2.a, new com.amap.api.mapcore.util.ic(context2, com.amap.api.mapcore.util.hr.a, com.amap.api.mapcore.util.hr.c * 1024, com.amap.api.mapcore.util.hr.b * 1024, "staticUpdate", com.amap.api.mapcore.util.hr.e * 1024)));
                        }
                        com.amap.api.mapcore.util.hm.a(a2);
                        return;
                    } catch (java.lang.Throwable th3) {
                        com.amap.api.mapcore.util.gd.c(th3, "stm", "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (com.amap.api.mapcore.util.hr.class) {
                    if (this.h != null && this.d != null) {
                        byte[] bArr = new byte[0];
                        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
                        try {
                            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                            try {
                                for (com.amap.api.mapcore.util.hq hqVar2 : this.h) {
                                    if (hqVar2 != null) {
                                        byteArrayOutputStream2.write(hqVar2.a());
                                    }
                                }
                                bArr = byteArrayOutputStream2.toByteArray();
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (java.lang.Throwable th4) {
                                    th = th4;
                                    th.printStackTrace();
                                    com.amap.api.mapcore.util.hr.a(this.d, bArr);
                                }
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    com.amap.api.mapcore.util.gd.c(th, "stm", "aStB");
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (java.lang.Throwable th6) {
                                            th = th6;
                                            th.printStackTrace();
                                            com.amap.api.mapcore.util.hr.a(this.d, bArr);
                                        }
                                    }
                                    com.amap.api.mapcore.util.hr.a(this.d, bArr);
                                } finally {
                                }
                            }
                        } catch (java.lang.Throwable th7) {
                            th = th7;
                        }
                        com.amap.api.mapcore.util.hr.a(this.d, bArr);
                    }
                }
            } catch (java.lang.Throwable th8) {
                com.amap.api.mapcore.util.gd.c(th8, "stm", "apb");
            }
        }
    }

    public static void a(android.content.Context context) {
        com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.hr.a(context, com.amap.api.mapcore.util.hr.a.c));
    }

    public static /* synthetic */ void a(android.content.Context context, byte[] bArr) throws java.io.IOException {
        com.amap.api.mapcore.util.hl a2 = com.amap.api.mapcore.util.hs.a(d);
        com.amap.api.mapcore.util.hs.a(context, a2, com.amap.api.mapcore.util.gb.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new com.amap.api.mapcore.util.gr();
        }
        try {
            com.amap.api.mapcore.util.hm.a(java.lang.Integer.toString(new java.util.Random().nextInt(100)) + java.lang.Long.toString(java.lang.System.nanoTime()), bArr, a2);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "stm", "wts");
        }
    }

    public static synchronized void a(com.amap.api.mapcore.util.hq hqVar, android.content.Context context) {
        synchronized (com.amap.api.mapcore.util.hr.class) {
            com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.hr.a(context, com.amap.api.mapcore.util.hr.a.a, hqVar));
        }
    }

    public static synchronized void a(java.util.List<com.amap.api.mapcore.util.hq> list, android.content.Context context) {
        synchronized (com.amap.api.mapcore.util.hr.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.hr.a(context, com.amap.api.mapcore.util.hr.a.b, list));
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }
}
