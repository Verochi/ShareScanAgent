package com.amap.api.col.s;

/* loaded from: classes12.dex */
public class ck {
    public static java.lang.ref.WeakReference<com.amap.api.col.s.df> a = null;
    public static boolean b = true;
    public static java.lang.ref.WeakReference<com.amap.api.col.s.dy> c;
    public static java.lang.ref.WeakReference<com.amap.api.col.s.dy> d;
    public static java.lang.String[] e = new java.lang.String[10];
    public static int f;
    public static boolean g;
    public static int h;
    public static com.amap.api.col.s.bt i;

    /* renamed from: com.amap.api.col.s.ck$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.col.s.ec {
        public final /* synthetic */ android.content.Context t;
        public final /* synthetic */ java.lang.String u;
        public final /* synthetic */ com.amap.api.col.s.dy v;

        public AnonymousClass1(android.content.Context context, java.lang.String str, com.amap.api.col.s.dy dyVar) {
            this.t = context;
            this.u = str;
            this.v = dyVar;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            try {
                synchronized (com.amap.api.col.s.ck.class) {
                    com.amap.api.col.s.df a = com.amap.api.col.s.dl.a(com.amap.api.col.s.ck.a);
                    com.amap.api.col.s.dl.a(this.t, a, this.u, 1000, 4096000, "1");
                    a.f = this.v;
                    if (a.g == null) {
                        a.g = new com.amap.api.col.s.dp(new com.amap.api.col.s.Cdo(this.t, new com.amap.api.col.s.dt(), new com.amap.api.col.s.cp(new com.amap.api.col.s.cr(new com.amap.api.col.s.cs())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", com.amap.api.col.s.bi.f(this.t), com.amap.api.col.s.bm.r(this.t), com.amap.api.col.s.bm.q(this.t), com.amap.api.col.s.bi.c(this.t), android.os.Build.MODEL, com.amap.api.col.s.bi.b(this.t), com.amap.api.col.s.bi.d(this.t), android.os.Build.VERSION.RELEASE));
                    }
                    a.h = 3600000;
                    com.amap.api.col.s.dg.a(a);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cj.c(th, "lg", "pul");
            }
        }
    }

    public static com.amap.api.col.s.bt a(java.lang.String str) {
        java.util.List<com.amap.api.col.s.bt> b2 = com.amap.api.col.s.ch.b();
        if (b2 == null) {
            b2 = new java.util.ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (com.amap.api.col.s.bt btVar : b2) {
                if (com.amap.api.col.s.ch.c(btVar.g(), str)) {
                    return btVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return com.amap.api.col.s.bu.a();
                } catch (com.amap.api.col.s.bh e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    com.amap.api.col.s.bt b3 = com.amap.api.col.s.bu.b();
                    b3.a();
                    return b3;
                } catch (com.amap.api.col.s.bh e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void a(android.content.Context context, java.lang.Throwable th, int i2, java.lang.String str, java.lang.String str2) {
        java.lang.String a2 = com.amap.api.col.s.bu.a(th);
        com.amap.api.col.s.bt a3 = a(a2);
        if (h(a3)) {
            java.lang.String replaceAll = a2.replaceAll("\n", "<br/>");
            java.lang.String th2 = th.toString();
            if (th2 == null || "".equals(th2)) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (str != null) {
                sb.append("class:");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append(" method:");
                sb.append(str2);
                sb.append("$<br/>");
            }
            sb.append(replaceAll);
            e(context, a3, i2, th2, sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x00b0 -> B:28:0x00f6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String b(java.util.List<com.amap.api.col.s.bt> list) {
        com.amap.api.col.s.cv cvVar;
        java.io.FileInputStream fileInputStream;
        java.io.File file;
        try {
            try {
                file = new java.io.File("/data/anr/traces.txt");
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cj.c(th, "alg", "getA");
            }
        } catch (java.io.FileNotFoundException unused) {
            cvVar = null;
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            cvVar = null;
            fileInputStream = null;
        }
        if (!file.exists()) {
            return null;
        }
        fileInputStream = new java.io.FileInputStream(file);
        try {
            if (fileInputStream.available() > 1024000) {
                fileInputStream.skip(r3 - 1024000);
            }
            cvVar = new com.amap.api.col.s.cv(fileInputStream, com.amap.api.col.s.cu.b);
            boolean z = false;
            while (true) {
                try {
                    java.lang.String trim = cvVar.a().trim();
                    if (trim.contains("pid")) {
                        while (!trim.startsWith("\"main\"")) {
                            trim = cvVar.a();
                        }
                        z = true;
                    }
                    if (!trim.equals("") || !z) {
                        if (z) {
                            try {
                                if (f > 9) {
                                    f = 0;
                                }
                                java.lang.String[] strArr = e;
                                int i2 = f;
                                strArr[i2] = trim;
                                f = i2 + 1;
                            } catch (java.lang.Throwable th3) {
                                com.amap.api.col.s.cj.c(th3, "alg", "aDa");
                            }
                            int i3 = h;
                            if (i3 == 5) {
                                break;
                            }
                            if (g) {
                                h = i3 + 1;
                            } else {
                                java.util.Iterator<com.amap.api.col.s.bt> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        com.amap.api.col.s.bt next = it.next();
                                        boolean d2 = com.amap.api.col.s.ch.d(next.g(), trim);
                                        g = d2;
                                        if (d2) {
                                            i = next;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (java.io.EOFException unused2) {
                } catch (java.io.FileNotFoundException unused3) {
                    if (cvVar != null) {
                        try {
                            cvVar.close();
                        } catch (java.lang.Throwable th4) {
                            com.amap.api.col.s.cj.c(th4, "alg", "getA");
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (g) {
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    try {
                        com.amap.api.col.s.cj.c(th, "alg", "getA");
                        if (cvVar != null) {
                            try {
                                cvVar.close();
                            } catch (java.lang.Throwable th6) {
                                com.amap.api.col.s.cj.c(th6, "alg", "getA");
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (g) {
                        }
                    } finally {
                    }
                }
            }
            try {
                cvVar.close();
            } catch (java.lang.Throwable th7) {
                com.amap.api.col.s.cj.c(th7, "alg", "getA");
            }
            fileInputStream.close();
            break;
        } catch (java.io.FileNotFoundException unused4) {
            cvVar = null;
        } catch (java.lang.Throwable th8) {
            th = th8;
            cvVar = null;
        }
        if (g) {
            return i();
        }
        return null;
    }

    public static void d(android.content.Context context) {
        java.lang.String b2;
        com.amap.api.col.s.bt btVar;
        java.util.List<com.amap.api.col.s.bt> b3 = com.amap.api.col.s.ch.b();
        if (b3 == null || b3.size() == 0 || (b2 = b(b3)) == null || "".equals(b2) || (btVar = i) == null) {
            return;
        }
        e(context, btVar, 2, "ANR", b2);
    }

    public static void e(android.content.Context context, com.amap.api.col.s.bt btVar, int i2, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String a2 = com.amap.api.col.s.dl.a();
        java.lang.String a3 = com.amap.api.col.s.dl.a(context, btVar);
        com.amap.api.col.s.bi.a(context);
        java.lang.String a4 = com.amap.api.col.s.dl.a(a3, a2, i2, str, str2);
        if (a4 == null || "".equals(a4)) {
            return;
        }
        java.lang.String b2 = com.amap.api.col.s.bq.b(str2);
        if (i2 == 1) {
            str3 = com.amap.api.col.s.ch.b;
        } else if (i2 == 2) {
            str3 = com.amap.api.col.s.ch.d;
        } else if (i2 != 0) {
            return;
        } else {
            str3 = com.amap.api.col.s.ch.c;
        }
        java.lang.String str4 = str3;
        com.amap.api.col.s.df a5 = com.amap.api.col.s.dl.a(a);
        com.amap.api.col.s.dl.a(context, a5, str4, 1000, 4096000, "1");
        if (a5.e == null) {
            a5.e = new com.amap.api.col.s.co(new com.amap.api.col.s.cp(new com.amap.api.col.s.cr(new com.amap.api.col.s.cs())));
        }
        try {
            com.amap.api.col.s.dg.a(b2, com.amap.api.col.s.bu.a(a4.replaceAll("\n", "<br/>")), a5);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void f(android.content.Context context, com.amap.api.col.s.dy dyVar, java.lang.String str) {
        com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.ck.AnonymousClass1(context, str, dyVar));
    }

    public static void g(com.amap.api.col.s.bt btVar, android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!h(btVar) || str == null || "".equals(str)) {
            return;
        }
        e(context, btVar, 1, str, str2);
    }

    public static boolean h(com.amap.api.col.s.bt btVar) {
        return btVar != null && btVar.f();
    }

    public static java.lang.String i() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            for (int i2 = f; i2 < 10 && i2 <= 9; i2++) {
                sb.append(e[i2]);
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    public static void j(android.content.Context context) {
        com.amap.api.col.s.dw dwVar = new com.amap.api.col.s.dw(b);
        b = false;
        f(context, dwVar, com.amap.api.col.s.ch.c);
    }

    public static void k(android.content.Context context) {
        java.lang.ref.WeakReference<com.amap.api.col.s.dy> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new java.lang.ref.WeakReference<>(new com.amap.api.col.s.dx(context, 3600000, "hKey", new com.amap.api.col.s.dz(context)));
        }
        f(context, c.get(), com.amap.api.col.s.ch.d);
    }

    public static void l(android.content.Context context) {
        java.lang.ref.WeakReference<com.amap.api.col.s.dy> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new java.lang.ref.WeakReference<>(new com.amap.api.col.s.dx(context, 3600000, "gKey", new com.amap.api.col.s.dz(context)));
        }
        f(context, d.get(), com.amap.api.col.s.ch.b);
    }
}
