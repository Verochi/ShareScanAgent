package com.loc;

/* loaded from: classes23.dex */
public class ax {
    private static java.lang.ref.WeakReference<com.loc.bx> a = null;
    private static boolean b = true;
    private static java.lang.ref.WeakReference<com.loc.cq> c;
    private static java.lang.ref.WeakReference<com.loc.cq> d;
    private static java.lang.String[] e = new java.lang.String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static com.loc.x i;

    /* renamed from: com.loc.ax$1, reason: invalid class name */
    public class AnonymousClass1 extends com.loc.cu {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.loc.cq c;

        public AnonymousClass1(android.content.Context context, java.lang.String str, com.loc.cq cqVar) {
            this.a = context;
            this.b = str;
            this.c = cqVar;
        }

        @Override // com.loc.cu
        public final void a() {
            try {
                synchronized (com.loc.ax.class) {
                    com.loc.bx a = com.loc.cd.a(com.loc.ax.a);
                    com.loc.cd.a(this.a, a, this.b, 1000, 4096000, "1");
                    a.f = this.c;
                    if (a.g == null) {
                        a.g = new com.loc.ch(new com.loc.cg(this.a, new com.loc.cl(), new com.loc.bh(new com.loc.bj(new com.loc.bk())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", com.loc.m.f(this.a), com.loc.p.k(), com.loc.p.p(this.a), com.loc.m.c(this.a), android.os.Build.MODEL, com.loc.m.b(this.a), com.loc.m.d(this.a), android.os.Build.VERSION.RELEASE));
                    }
                    a.h = 3600000;
                    com.loc.by.a(a);
                }
            } catch (java.lang.Throwable th) {
                com.loc.aw.b(th, "lg", "pul");
            }
        }
    }

    private static com.loc.x a(java.lang.String str) {
        java.util.List<com.loc.x> a2 = com.loc.au.a();
        if (a2 == null) {
            a2 = new java.util.ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (com.loc.x xVar : a2) {
                if (com.loc.au.a(xVar.f(), str)) {
                    return xVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return com.loc.y.a();
                } catch (com.loc.l e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    com.loc.x b2 = com.loc.y.b();
                    b2.a(true);
                    return b2;
                } catch (com.loc.l e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0103 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x00f7 -> B:28:0x00fa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String a(java.util.List<com.loc.x> list) {
        com.loc.bn bnVar;
        java.io.FileInputStream fileInputStream;
        java.io.File file;
        try {
            try {
                file = new java.io.File("/data/anr/traces.txt");
            } catch (java.lang.Throwable th) {
                com.loc.aw.b(th, "alg", "getA");
            }
        } catch (java.io.FileNotFoundException unused) {
            bnVar = null;
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            bnVar = null;
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
            bnVar = new com.loc.bn(fileInputStream, com.loc.bm.b);
            boolean z = false;
            while (true) {
                try {
                    java.lang.String trim = bnVar.a().trim();
                    if (trim.contains("pid")) {
                        while (!trim.startsWith("\"main\"")) {
                            trim = bnVar.a();
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
                                com.loc.aw.b(th3, "alg", "aDa");
                            }
                            int i3 = h;
                            if (i3 == 5) {
                                break;
                            }
                            if (g) {
                                h = i3 + 1;
                            } else {
                                java.util.Iterator<com.loc.x> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        com.loc.x next = it.next();
                                        boolean b2 = com.loc.au.b(next.f(), trim);
                                        g = b2;
                                        if (b2) {
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
                    if (bnVar != null) {
                        try {
                            bnVar.close();
                        } catch (java.lang.Throwable th4) {
                            com.loc.aw.b(th4, "alg", "getA");
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
                        com.loc.aw.b(th, "alg", "getA");
                        if (bnVar != null) {
                            try {
                                bnVar.close();
                            } catch (java.lang.Throwable th6) {
                                com.loc.aw.b(th6, "alg", "getA");
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
                bnVar.close();
            } catch (java.lang.Throwable th7) {
                com.loc.aw.b(th7, "alg", "getA");
            }
            fileInputStream.close();
            break;
        } catch (java.io.FileNotFoundException unused4) {
            bnVar = null;
        } catch (java.lang.Throwable th8) {
            th = th8;
            bnVar = null;
        }
        if (g) {
            return b();
        }
        return null;
    }

    public static void a(android.content.Context context) {
        java.lang.String a2;
        com.loc.x xVar;
        java.util.List<com.loc.x> a3 = com.loc.au.a();
        if (a3 == null || a3.size() == 0 || (a2 = a(a3)) == null || "".equals(a2) || (xVar = i) == null) {
            return;
        }
        a(context, xVar, 2, "ANR", a2);
    }

    private static void a(android.content.Context context, com.loc.cq cqVar, java.lang.String str) {
        com.loc.ct.a().b(new com.loc.ax.AnonymousClass1(context, str, cqVar));
    }

    private static void a(android.content.Context context, com.loc.x xVar, int i2, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String a2 = com.loc.cd.a();
        java.lang.String a3 = com.loc.cd.a(context, xVar);
        com.loc.m.a(context);
        java.lang.String a4 = com.loc.cd.a(a3, a2, i2, str, str2);
        if (a4 == null || "".equals(a4)) {
            return;
        }
        java.lang.String b2 = com.loc.t.b(str2);
        if (i2 == 1) {
            str3 = com.loc.au.b;
        } else if (i2 == 2) {
            str3 = com.loc.au.d;
        } else if (i2 != 0) {
            return;
        } else {
            str3 = com.loc.au.c;
        }
        java.lang.String str4 = str3;
        com.loc.bx a5 = com.loc.cd.a(a);
        com.loc.cd.a(context, a5, str4, 1000, 4096000, "1");
        if (a5.e == null) {
            a5.e = new com.loc.bg(new com.loc.bh(new com.loc.bj(new com.loc.bk())));
        }
        try {
            com.loc.by.a(b2, com.loc.y.a(a4.replaceAll("\n", "<br/>")), a5);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, java.lang.Throwable th, int i2, java.lang.String str, java.lang.String str2) {
        java.lang.String a2 = com.loc.y.a(th);
        com.loc.x a3 = a(a2);
        if (a(a3)) {
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
            a(context, a3, i2, th2, sb.toString());
        }
    }

    public static void a(com.loc.x xVar, android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!a(xVar) || str == null || "".equals(str)) {
            return;
        }
        a(context, xVar, 1, str, str2);
    }

    private static boolean a(com.loc.x xVar) {
        return xVar != null && xVar.e();
    }

    private static java.lang.String b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            for (int i2 = f; i2 < 10 && i2 <= 9; i2++) {
                sb.append(e[i2]);
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "alg", "gLI");
        }
        return sb.toString();
    }

    public static void b(android.content.Context context) {
        com.loc.co coVar = new com.loc.co(b);
        b = false;
        a(context, coVar, com.loc.au.c);
    }

    public static void c(android.content.Context context) {
        java.lang.ref.WeakReference<com.loc.cq> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new java.lang.ref.WeakReference<>(new com.loc.cp(context, 3600000, "hKey", new com.loc.cr(context)));
        }
        a(context, c.get(), com.loc.au.d);
    }

    public static void d(android.content.Context context) {
        java.lang.ref.WeakReference<com.loc.cq> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new java.lang.ref.WeakReference<>(new com.loc.cp(context, 3600000, "gKey", new com.loc.cr(context)));
        }
        a(context, d.get(), com.loc.au.b);
    }
}
