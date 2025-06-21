package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ft {
    private android.content.Context a;
    private com.amap.api.mapcore.util.fh b;
    private boolean c = true;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private java.util.List<java.lang.String> g = new java.util.ArrayList();
    private com.amap.api.mapcore.util.fv h = new com.amap.api.mapcore.util.fv((byte) 0);
    private com.amap.api.mapcore.util.fv i = new com.amap.api.mapcore.util.fv();
    private com.amap.api.mapcore.util.ge.a j = new com.amap.api.mapcore.util.ft.AnonymousClass1();
    private com.amap.api.mapcore.util.ge.a k = new com.amap.api.mapcore.util.ft.AnonymousClass2();
    private android.os.Handler l = null;
    private com.amap.api.mapcore.util.hl m = null;
    private com.amap.api.mapcore.util.hl n = null;

    /* renamed from: com.amap.api.mapcore.util.ft$1, reason: invalid class name */
    public class AnonymousClass1 implements com.amap.api.mapcore.util.ge.a {

        /* renamed from: com.amap.api.mapcore.util.ft$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01231 implements java.lang.Runnable {
            public RunnableC01231() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.amap.api.mapcore.util.ft.this.c(false);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.amap.api.mapcore.util.ge.a
        public final void a(int i) {
            if (i > 0 && com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.ft.this) != null) {
                ((com.amap.api.mapcore.util.fu) com.amap.api.mapcore.util.ft.this.c().f).a(i);
                com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.ft.this, "error", java.lang.String.valueOf(((com.amap.api.mapcore.util.fu) com.amap.api.mapcore.util.ft.this.c().f).b()));
                com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.ft.this).postDelayed(new com.amap.api.mapcore.util.ft.AnonymousClass1.RunnableC01231(), 660000L);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.ft$2, reason: invalid class name */
    public class AnonymousClass2 implements com.amap.api.mapcore.util.ge.a {

        /* renamed from: com.amap.api.mapcore.util.ft$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.amap.api.mapcore.util.ft.this.d(false);
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.amap.api.mapcore.util.ge.a
        public final void a(int i) {
            if (i <= 0) {
                return;
            }
            ((com.amap.api.mapcore.util.fu) com.amap.api.mapcore.util.ft.this.e().f).a(i);
            com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.ft.this, "info", java.lang.String.valueOf(((com.amap.api.mapcore.util.fu) com.amap.api.mapcore.util.ft.this.e().f).b()));
            if (com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.ft.this) == null) {
                return;
            }
            com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.ft.this).postDelayed(new com.amap.api.mapcore.util.ft.AnonymousClass2.AnonymousClass1(), 660000L);
        }
    }

    public static class a {
        public static java.util.Map<java.lang.String, com.amap.api.mapcore.util.ft> a = new java.util.HashMap();
    }

    private ft(com.amap.api.mapcore.util.fh fhVar) {
        this.b = fhVar;
    }

    private long a(java.lang.String str) {
        try {
            java.lang.String format = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
            return java.lang.Long.parseLong(com.amap.api.mapcore.util.fw.a(this.b).a(this.a, "", "", format + str));
        } catch (java.lang.Throwable unused) {
            return 0L;
        }
    }

    public static /* synthetic */ android.os.Handler a(com.amap.api.mapcore.util.ft ftVar) {
        android.content.Context context = ftVar.a;
        if (context == null || context == null) {
            return null;
        }
        if (ftVar.l == null) {
            ftVar.l = new android.os.Handler(ftVar.a.getMainLooper());
        }
        return ftVar.l;
    }

    public static com.amap.api.mapcore.util.ft a(com.amap.api.mapcore.util.fh fhVar) {
        if (fhVar == null || android.text.TextUtils.isEmpty(fhVar.a())) {
            return null;
        }
        if (com.amap.api.mapcore.util.ft.a.a.get(fhVar.a()) == null) {
            com.amap.api.mapcore.util.ft.a.a.put(fhVar.a(), new com.amap.api.mapcore.util.ft(fhVar));
        }
        return com.amap.api.mapcore.util.ft.a.a.get(fhVar.a());
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str, com.amap.api.mapcore.util.fh fhVar) {
        java.lang.String b;
        if (context == null) {
            return null;
        }
        if (fhVar != null) {
            try {
                if (!android.text.TextUtils.isEmpty(fhVar.a())) {
                    b = com.amap.api.mapcore.util.fd.b(fhVar.a());
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(context.getFilesDir().getAbsolutePath());
                    java.lang.String str2 = java.io.File.separator;
                    sb.append(str2);
                    sb.append("EBDEC84EF205FEA2DF0719DEB822869E");
                    sb.append(str2);
                    sb.append(str);
                    sb.append(str2);
                    sb.append(b);
                    return sb.toString();
                }
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }
        b = "a";
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(context.getFilesDir().getAbsolutePath());
        java.lang.String str22 = java.io.File.separator;
        sb2.append(str22);
        sb2.append("EBDEC84EF205FEA2DF0719DEB822869E");
        sb2.append(str22);
        sb2.append(str);
        sb2.append(str22);
        sb2.append(b);
        return sb2.toString();
    }

    private void a(int i) {
        android.content.Context context;
        com.amap.api.mapcore.util.fv b = b(i);
        java.lang.String a2 = com.amap.api.mapcore.util.fs.a(b.a());
        if (android.text.TextUtils.isEmpty(a2) || "[]".equals(a2) || (context = this.a) == null) {
            return;
        }
        com.amap.api.mapcore.util.ge.a(context, this.b, com.amap.api.mapcore.util.fs.a(i), c(i), a2);
        b.b();
    }

    public static /* synthetic */ void a(com.amap.api.mapcore.util.ft ftVar, java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String format = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
            com.amap.api.mapcore.util.fw.a(ftVar.b).a(ftVar.a, "", "", format + str, str2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private com.amap.api.mapcore.util.fv b(int i) {
        return i == com.amap.api.mapcore.util.fs.b ? this.i : this.h;
    }

    private void b(boolean z) {
        c(z);
        d(z);
    }

    private boolean b() {
        return this.a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.amap.api.mapcore.util.hl c() {
        com.amap.api.mapcore.util.hl hlVar = this.n;
        if (hlVar != null) {
            return hlVar;
        }
        d();
        return this.n;
    }

    private com.amap.api.mapcore.util.hl c(int i) {
        if (i == com.amap.api.mapcore.util.fs.b) {
            if (this.n == null) {
                this.n = c();
            }
            return this.n;
        }
        if (this.m == null) {
            this.m = e();
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        com.amap.api.mapcore.util.hl c = c(com.amap.api.mapcore.util.fs.b);
        if (z) {
            ((com.amap.api.mapcore.util.fu) c.f).a(z);
        }
        android.content.Context context = this.a;
        if (context == null) {
            return;
        }
        com.amap.api.mapcore.util.ge.a(context, c, this.j);
    }

    private com.amap.api.mapcore.util.hl d() {
        if (this.a == null) {
            return null;
        }
        com.amap.api.mapcore.util.hl hlVar = new com.amap.api.mapcore.util.hl();
        this.n = hlVar;
        hlVar.a = h();
        com.amap.api.mapcore.util.hl hlVar2 = this.n;
        hlVar2.b = 512000000L;
        hlVar2.d = 12500;
        hlVar2.c = "1";
        hlVar2.h = -1;
        hlVar2.i = "elkey";
        long a2 = a("error");
        this.n.f = new com.amap.api.mapcore.util.fu(true, new com.amap.api.mapcore.util.ig(this.a, this.d), a2, com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION);
        com.amap.api.mapcore.util.hl hlVar3 = this.n;
        hlVar3.g = null;
        return hlVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        com.amap.api.mapcore.util.hl c = c(com.amap.api.mapcore.util.fs.a);
        if (z) {
            ((com.amap.api.mapcore.util.fu) c.f).a(z);
        }
        android.content.Context context = this.a;
        if (context == null) {
            return;
        }
        com.amap.api.mapcore.util.ge.a(context, c, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.amap.api.mapcore.util.hl e() {
        com.amap.api.mapcore.util.hl hlVar = this.m;
        if (hlVar != null) {
            return hlVar;
        }
        f();
        return this.m;
    }

    private com.amap.api.mapcore.util.hl f() {
        if (this.a == null) {
            return null;
        }
        com.amap.api.mapcore.util.hl hlVar = new com.amap.api.mapcore.util.hl();
        this.m = hlVar;
        hlVar.a = g();
        com.amap.api.mapcore.util.hl hlVar2 = this.m;
        hlVar2.b = 512000000L;
        hlVar2.d = 12500;
        hlVar2.c = "1";
        hlVar2.h = -1;
        hlVar2.i = "inlkey";
        long a2 = a("info");
        this.m.f = new com.amap.api.mapcore.util.fu(this.f, new com.amap.api.mapcore.util.ig(this.a, this.d), a2, 30000000);
        com.amap.api.mapcore.util.hl hlVar3 = this.m;
        hlVar3.g = null;
        return hlVar3;
    }

    private java.lang.String g() {
        android.content.Context context = this.a;
        if (context == null) {
            return null;
        }
        return a(context, "CAF9B6B99962BF5C2264824231D7A40C", this.b);
    }

    private java.lang.String h() {
        android.content.Context context = this.a;
        if (context == null) {
            return null;
        }
        return a(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.b);
    }

    public final void a() {
        if (b()) {
            a(com.amap.api.mapcore.util.fs.b);
            a(com.amap.api.mapcore.util.fs.a);
        }
    }

    public final void a(android.content.Context context) {
        this.a = context.getApplicationContext();
    }

    public final void a(com.amap.api.mapcore.util.fs fsVar) {
        if (b() && this.c && com.amap.api.mapcore.util.fs.a(fsVar)) {
            boolean z = true;
            if (fsVar != null) {
                java.util.List<java.lang.String> list = this.g;
                if (list != null && list.size() != 0) {
                    for (int i = 0; i < this.g.size(); i++) {
                        if (!android.text.TextUtils.isEmpty(this.g.get(i)) && fsVar.b().contains(this.g.get(i))) {
                            break;
                        }
                    }
                }
                z = false;
            }
            if (z) {
                return;
            }
            if (this.e || fsVar.a() != com.amap.api.mapcore.util.fs.a) {
                com.amap.api.mapcore.util.fv b = b(fsVar.a());
                if (b.a(fsVar.b())) {
                    java.lang.String a2 = com.amap.api.mapcore.util.fs.a(b.a());
                    if (this.a == null || android.text.TextUtils.isEmpty(a2) || "[]".equals(a2)) {
                        return;
                    }
                    com.amap.api.mapcore.util.ge.a(this.a, this.b, fsVar.c(), c(fsVar.a()), a2);
                    b(false);
                    b.b();
                }
                b.a(fsVar);
            }
        }
    }

    public final void a(boolean z) {
        if (b()) {
            b(z);
        }
    }

    public final void a(boolean z, boolean z2, boolean z3, boolean z4, java.util.List<java.lang.String> list) {
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = list;
        d();
        f();
    }
}
