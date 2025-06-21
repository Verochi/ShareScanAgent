package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class ge {
    private static java.lang.ref.WeakReference<com.amap.api.mapcore.util.hl> a = null;
    private static boolean b = true;
    private static java.lang.ref.WeakReference<com.amap.api.mapcore.util.Cif> c;
    private static java.lang.ref.WeakReference<com.amap.api.mapcore.util.Cif> d;
    private static java.lang.String[] e = new java.lang.String[10];
    private static int f;
    private static boolean g;
    private static int h;
    private static com.amap.api.mapcore.util.fh i;

    /* renamed from: com.amap.api.mapcore.util.ge$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.amap.api.mapcore.util.fh b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.amap.api.mapcore.util.hl e;

        public AnonymousClass1(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2, com.amap.api.mapcore.util.hl hlVar) {
            this.a = context;
            this.b = fhVar;
            this.c = str;
            this.d = str2;
            this.e = hlVar;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            java.lang.String a = com.amap.api.mapcore.util.ge.a(this.a, this.b, this.c, this.d);
            com.amap.api.mapcore.util.hl hlVar = this.e;
            if (hlVar.e == null) {
                hlVar.e = new com.amap.api.mapcore.util.gs(new com.amap.api.mapcore.util.gt(new com.amap.api.mapcore.util.gv(new com.amap.api.mapcore.util.gw())));
            }
            try {
                com.amap.api.mapcore.util.hm.a(com.amap.api.mapcore.util.fd.c(a), com.amap.api.mapcore.util.fi.a(a), this.e);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.ge$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.amap.api.mapcore.util.Cif c;

        public AnonymousClass2(android.content.Context context, java.lang.String str, com.amap.api.mapcore.util.Cif cif) {
            this.a = context;
            this.b = str;
            this.c = cif;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            try {
                synchronized (com.amap.api.mapcore.util.ge.class) {
                    com.amap.api.mapcore.util.hl a = com.amap.api.mapcore.util.hs.a(com.amap.api.mapcore.util.ge.a);
                    com.amap.api.mapcore.util.hs.a(this.a, a, this.b, 1000, 4096000, "1");
                    a.f = this.c;
                    if (a.g == null) {
                        a.g = new com.amap.api.mapcore.util.hw(new com.amap.api.mapcore.util.hv(this.a, new com.amap.api.mapcore.util.ia(), new com.amap.api.mapcore.util.gt(new com.amap.api.mapcore.util.gv(new com.amap.api.mapcore.util.gw())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", com.amap.api.mapcore.util.ev.f(this.a), com.amap.api.mapcore.util.ez.s(this.a), com.amap.api.mapcore.util.ez.r(this.a), com.amap.api.mapcore.util.ev.c(this.a), android.os.Build.MODEL, com.amap.api.mapcore.util.ev.b(this.a), com.amap.api.mapcore.util.ev.d(this.a), android.os.Build.VERSION.RELEASE));
                    }
                    a.h = 3600000;
                    com.amap.api.mapcore.util.hm.a(a);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "lg", "pul");
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.ge$3, reason: invalid class name */
    public static class AnonymousClass3 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ com.amap.api.mapcore.util.hl a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ com.amap.api.mapcore.util.ge.a c;

        public AnonymousClass3(com.amap.api.mapcore.util.hl hlVar, android.content.Context context, com.amap.api.mapcore.util.ge.a aVar) {
            this.a = hlVar;
            this.b = context;
            this.c = aVar;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            try {
                synchronized (com.amap.api.mapcore.util.ge.class) {
                    com.amap.api.mapcore.util.hl hlVar = this.a;
                    if (hlVar.g == null) {
                        hlVar.g = new com.amap.api.mapcore.util.hw(new com.amap.api.mapcore.util.hv(this.b, new com.amap.api.mapcore.util.ia(), new com.amap.api.mapcore.util.gt(new com.amap.api.mapcore.util.gv(new com.amap.api.mapcore.util.gw())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", com.amap.api.mapcore.util.ev.f(this.b), com.amap.api.mapcore.util.ez.s(this.b), com.amap.api.mapcore.util.ez.r(this.b), com.amap.api.mapcore.util.ev.c(this.b), android.os.Build.MODEL, com.amap.api.mapcore.util.ev.b(this.b), com.amap.api.mapcore.util.ev.d(this.b), android.os.Build.VERSION.RELEASE));
                    }
                    int a = com.amap.api.mapcore.util.hm.a(this.a);
                    com.amap.api.mapcore.util.ge.a aVar = this.c;
                    if (aVar != null) {
                        aVar.a(a);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "lg", "pul");
            }
        }
    }

    public interface a {
        void a(int i);
    }

    private static com.amap.api.mapcore.util.fh a(java.lang.String str) {
        java.util.List<com.amap.api.mapcore.util.fh> a2 = com.amap.api.mapcore.util.gb.a();
        if (a2 == null) {
            a2 = new java.util.ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (com.amap.api.mapcore.util.fh fhVar : a2) {
                if (com.amap.api.mapcore.util.gb.a(fhVar.g(), str)) {
                    return fhVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return com.amap.api.mapcore.util.fi.a();
                } catch (com.amap.api.mapcore.util.eu e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    com.amap.api.mapcore.util.fh b2 = com.amap.api.mapcore.util.fi.b();
                    b2.a(true);
                    return b2;
                } catch (com.amap.api.mapcore.util.eu e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    public static /* synthetic */ java.lang.String a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2) {
        java.lang.String a2 = com.amap.api.mapcore.util.hs.a();
        java.lang.String a3 = com.amap.api.mapcore.util.hs.a(context, fhVar);
        com.amap.api.mapcore.util.ev.a(context);
        return com.amap.api.mapcore.util.hs.a(a3, a2, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x00b0 -> B:28:0x00f6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String a(java.util.List<com.amap.api.mapcore.util.fh> list) {
        com.amap.api.mapcore.util.gz gzVar;
        java.io.FileInputStream fileInputStream;
        java.io.File file;
        try {
            try {
                file = new java.io.File("/data/anr/traces.txt");
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "alg", "getA");
            }
        } catch (java.io.FileNotFoundException unused) {
            gzVar = null;
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            gzVar = null;
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
            gzVar = new com.amap.api.mapcore.util.gz(fileInputStream, com.amap.api.mapcore.util.gy.b);
            boolean z = false;
            while (true) {
                try {
                    java.lang.String trim = gzVar.a().trim();
                    if (trim.contains("pid")) {
                        while (!trim.startsWith("\"main\"")) {
                            trim = gzVar.a();
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
                                com.amap.api.mapcore.util.gd.c(th3, "alg", "aDa");
                            }
                            int i3 = h;
                            if (i3 == 5) {
                                break;
                            }
                            if (g) {
                                h = i3 + 1;
                            } else {
                                java.util.Iterator<com.amap.api.mapcore.util.fh> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        com.amap.api.mapcore.util.fh next = it.next();
                                        boolean b2 = com.amap.api.mapcore.util.gb.b(next.g(), trim);
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
                    if (gzVar != null) {
                        try {
                            gzVar.close();
                        } catch (java.lang.Throwable th4) {
                            com.amap.api.mapcore.util.gd.c(th4, "alg", "getA");
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
                        com.amap.api.mapcore.util.gd.c(th, "alg", "getA");
                        if (gzVar != null) {
                            try {
                                gzVar.close();
                            } catch (java.lang.Throwable th6) {
                                com.amap.api.mapcore.util.gd.c(th6, "alg", "getA");
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
                gzVar.close();
            } catch (java.lang.Throwable th7) {
                com.amap.api.mapcore.util.gd.c(th7, "alg", "getA");
            }
            fileInputStream.close();
            break;
        } catch (java.io.FileNotFoundException unused4) {
            gzVar = null;
        } catch (java.lang.Throwable th8) {
            th = th8;
            gzVar = null;
        }
        if (g) {
            return b();
        }
        return null;
    }

    public static void a(android.content.Context context) {
        java.lang.String a2;
        com.amap.api.mapcore.util.fh fhVar;
        java.util.List<com.amap.api.mapcore.util.fh> a3 = com.amap.api.mapcore.util.gb.a();
        if (a3 == null || a3.size() == 0 || (a2 = a(a3)) == null || "".equals(a2) || (fhVar = i) == null) {
            return;
        }
        a(context, fhVar, 2, "ANR", a2);
    }

    private static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, int i2, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String a2 = com.amap.api.mapcore.util.hs.a();
        java.lang.String a3 = com.amap.api.mapcore.util.hs.a(context, fhVar);
        com.amap.api.mapcore.util.ev.a(context);
        java.lang.String a4 = com.amap.api.mapcore.util.hs.a(a3, a2, i2, str, str2);
        if (a4 == null || "".equals(a4)) {
            return;
        }
        java.lang.String c2 = com.amap.api.mapcore.util.fd.c(str2);
        if (i2 == 1) {
            str3 = com.amap.api.mapcore.util.gb.b;
        } else if (i2 == 2) {
            str3 = com.amap.api.mapcore.util.gb.d;
        } else if (i2 != 0) {
            return;
        } else {
            str3 = com.amap.api.mapcore.util.gb.c;
        }
        java.lang.String str4 = str3;
        com.amap.api.mapcore.util.hl a5 = com.amap.api.mapcore.util.hs.a(a);
        com.amap.api.mapcore.util.hs.a(context, a5, str4, 1000, 4096000, "1");
        if (a5.e == null) {
            a5.e = new com.amap.api.mapcore.util.gs(new com.amap.api.mapcore.util.gt(new com.amap.api.mapcore.util.gv(new com.amap.api.mapcore.util.gw())));
        }
        try {
            com.amap.api.mapcore.util.hm.a(c2, com.amap.api.mapcore.util.fi.a(a4.replaceAll("\n", "<br/>")), a5);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, int i2, java.lang.String str2, java.lang.String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("class:");
        sb.append(str2);
        if (str3 != null) {
            sb.append(" method:");
            sb.append(str3);
            sb.append("$<br/>");
        }
        sb.append(str);
        a(context, fhVar, i2, str2, sb.toString());
    }

    public static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, com.amap.api.mapcore.util.hl hlVar, java.lang.String str2) {
        try {
            com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.ge.AnonymousClass1(context, fhVar, str, str2, hlVar));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, com.amap.api.mapcore.util.hl hlVar, com.amap.api.mapcore.util.ge.a aVar) {
        try {
            com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.ge.AnonymousClass3(hlVar, context, aVar));
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(android.content.Context context, com.amap.api.mapcore.util.Cif cif, java.lang.String str) {
        com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.ge.AnonymousClass2(context, str, cif));
    }

    public static void a(android.content.Context context, java.lang.Throwable th, int i2, java.lang.String str, java.lang.String str2) {
        java.lang.String a2 = com.amap.api.mapcore.util.fi.a(th);
        com.amap.api.mapcore.util.fh a3 = a(a2);
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

    public static void a(com.amap.api.mapcore.util.fh fhVar, android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!a(fhVar) || str == null || "".equals(str)) {
            return;
        }
        a(context, fhVar, 1, str, str2);
    }

    private static boolean a(com.amap.api.mapcore.util.fh fhVar) {
        return fhVar != null && fhVar.f();
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
            com.amap.api.mapcore.util.gd.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    public static void b(android.content.Context context) {
        com.amap.api.mapcore.util.id idVar = new com.amap.api.mapcore.util.id(b);
        b = false;
        a(context, idVar, com.amap.api.mapcore.util.gb.c);
    }

    public static void c(android.content.Context context) {
        java.lang.ref.WeakReference<com.amap.api.mapcore.util.Cif> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new java.lang.ref.WeakReference<>(new com.amap.api.mapcore.util.ie(context, 3600000, "hKey", new com.amap.api.mapcore.util.ig(context, false)));
        }
        a(context, c.get(), com.amap.api.mapcore.util.gb.d);
    }

    public static void d(android.content.Context context) {
        java.lang.ref.WeakReference<com.amap.api.mapcore.util.Cif> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new java.lang.ref.WeakReference<>(new com.amap.api.mapcore.util.ie(context, 3600000, "gKey", new com.amap.api.mapcore.util.ig(context, false)));
        }
        a(context, d.get(), com.amap.api.mapcore.util.gb.b);
    }
}
