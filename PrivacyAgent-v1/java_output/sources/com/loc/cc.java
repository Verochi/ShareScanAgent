package com.loc;

/* loaded from: classes23.dex */
public class cc {
    static boolean a = false;
    static int b = 20;
    private static int c = 20;
    private static java.lang.ref.WeakReference<com.loc.bx> d;
    private static int e;

    public static class a extends com.loc.cu {
        static int a = 1;
        static int b = 2;
        static int c = 3;
        private android.content.Context d;
        private com.loc.cb f;
        private int g;
        private java.util.List<com.loc.cb> h;

        public a(android.content.Context context, int i) {
            this.d = context;
            this.g = i;
        }

        public a(android.content.Context context, int i, com.loc.cb cbVar) {
            this(context, i);
            this.f = cbVar;
        }

        public a(android.content.Context context, int i, java.util.List<com.loc.cb> list) {
            this(context, i);
            this.h = list;
        }

        @Override // com.loc.cu
        public final void a() {
            java.lang.String str;
            java.lang.String str2;
            com.loc.cb cbVar;
            java.lang.Throwable th;
            int i = this.g;
            if (i == 1) {
                try {
                    if (this.d != null && this.f != null) {
                        synchronized (com.loc.cc.class) {
                            android.content.Context context = this.d;
                            if (context != null && (cbVar = this.f) != null) {
                                com.loc.cc.a(context, cbVar.a());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    str = "stm";
                    str2 = "as";
                }
            } else {
                if (i != 2) {
                    if (i == 3) {
                        try {
                            if (this.d == null) {
                                return;
                            }
                            com.loc.bx a2 = com.loc.cd.a(com.loc.cc.d);
                            com.loc.cd.a(this.d, a2, com.loc.au.h, 1000, 307200, "2");
                            if (a2.g == null) {
                                a2.g = new com.loc.ce(new com.loc.ci(this.d, new com.loc.cf(new com.loc.cj(new com.loc.cl()))));
                            }
                            a2.h = 3600000;
                            if (android.text.TextUtils.isEmpty(a2.i)) {
                                a2.i = "cKey";
                            }
                            if (a2.f == null) {
                                android.content.Context context2 = this.d;
                                a2.f = new com.loc.cp(context2, a2.h, a2.i, new com.loc.cm(a2.a, new com.loc.cn(context2, com.loc.cc.a, com.loc.cc.c * 1024, com.loc.cc.b * 1024, "staticUpdate", com.loc.cc.e * 1024)));
                            }
                            com.loc.by.a(a2);
                            return;
                        } catch (java.lang.Throwable th3) {
                            com.loc.aw.b(th3, "stm", "usd");
                            return;
                        }
                    }
                    return;
                }
                try {
                    synchronized (com.loc.cc.class) {
                        if (this.h != null && this.d != null) {
                            byte[] bArr = new byte[0];
                            java.io.ByteArrayOutputStream byteArrayOutputStream = null;
                            try {
                                java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                                try {
                                    for (com.loc.cb cbVar2 : this.h) {
                                        if (cbVar2 != null) {
                                            byteArrayOutputStream2.write(cbVar2.a());
                                        }
                                    }
                                    bArr = byteArrayOutputStream2.toByteArray();
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (java.lang.Throwable th4) {
                                        th = th4;
                                        th.printStackTrace();
                                        com.loc.cc.a(this.d, bArr);
                                        return;
                                    }
                                } catch (java.lang.Throwable th5) {
                                    th = th5;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    try {
                                        com.loc.aw.b(th, "stm", "aStB");
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (java.lang.Throwable th6) {
                                                th = th6;
                                                th.printStackTrace();
                                                com.loc.cc.a(this.d, bArr);
                                                return;
                                            }
                                        }
                                        com.loc.cc.a(this.d, bArr);
                                        return;
                                    } finally {
                                    }
                                }
                            } catch (java.lang.Throwable th7) {
                                th = th7;
                            }
                            com.loc.cc.a(this.d, bArr);
                            return;
                        }
                        return;
                    }
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    str = "stm";
                    str2 = "apb";
                }
            }
            com.loc.aw.b(th, str, str2);
        }
    }

    public static void a(android.content.Context context) {
        com.loc.ct.a().b(new com.loc.cc.a(context, com.loc.cc.a.c));
    }

    public static /* synthetic */ void a(android.content.Context context, byte[] bArr) throws java.io.IOException {
        com.loc.bx a2 = com.loc.cd.a(d);
        com.loc.cd.a(context, a2, com.loc.au.h, 1000, 307200, "2");
        if (a2.e == null) {
            a2.e = new com.loc.bf();
        }
        try {
            com.loc.by.a(java.lang.Integer.toString(new java.util.Random().nextInt(100)) + java.lang.Long.toString(java.lang.System.nanoTime()), bArr, a2);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "stm", "wts");
        }
    }

    public static synchronized void a(com.loc.cb cbVar, android.content.Context context) {
        synchronized (com.loc.cc.class) {
            com.loc.ct.a().b(new com.loc.cc.a(context, com.loc.cc.a.a, cbVar));
        }
    }

    public static synchronized void a(java.util.List<com.loc.cb> list, android.content.Context context) {
        synchronized (com.loc.cc.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        com.loc.ct.a().b(new com.loc.cc.a(context, com.loc.cc.a.b, list));
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(boolean z, int i) {
        synchronized (com.loc.cc.class) {
            a = z;
            e = java.lang.Math.max(0, i);
        }
    }

    public static synchronized void b(java.util.List<com.loc.cb> list, android.content.Context context) {
        synchronized (com.loc.cc.class) {
            try {
                java.util.List<com.loc.cb> b2 = com.loc.br.b();
                if (b2 != null && b2.size() > 0) {
                    list.addAll(b2);
                }
            } catch (java.lang.Throwable unused) {
            }
            a(list, context);
        }
    }
}
