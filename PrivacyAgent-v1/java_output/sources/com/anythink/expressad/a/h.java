package com.anythink.expressad.a;

/* loaded from: classes12.dex */
public final class h extends com.anythink.expressad.a.d implements com.anythink.expressad.foundation.g.g.a.b {
    public static final int a = 1;
    public static final int i = 2;
    private static final java.lang.String j = "302";
    private com.anythink.expressad.a.e m;
    private com.anythink.expressad.a.c.b n;
    private boolean p;
    private android.content.Context q;
    private com.anythink.expressad.foundation.g.g.c r;

    /* renamed from: s, reason: collision with root package name */
    private com.anythink.expressad.a.f.a f195s;
    private boolean k = false;
    private long l = 0;
    private boolean o = true;
    private android.os.Handler t = new android.os.Handler(android.os.Looper.getMainLooper());
    private boolean u = true;

    /* renamed from: com.anythink.expressad.a.h$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.a.h.this.m != null) {
                if (com.anythink.expressad.a.h.this.n.g()) {
                    com.anythink.expressad.a.e unused = com.anythink.expressad.a.h.this.m;
                    com.anythink.expressad.a.c.b unused2 = com.anythink.expressad.a.h.this.n;
                } else {
                    com.anythink.expressad.a.e unused3 = com.anythink.expressad.a.h.this.m;
                    com.anythink.expressad.a.c.b unused4 = com.anythink.expressad.a.h.this.n;
                    com.anythink.expressad.a.h.this.n.h();
                }
            }
        }
    }

    public class a extends com.anythink.expressad.foundation.g.g.a {
        private static final int h = 10;
        private final android.content.Context f;
        private java.lang.String g;
        private java.lang.String i;
        private java.lang.String j;
        private java.lang.String k;
        private com.anythink.expressad.c.b l;
        private com.anythink.expressad.foundation.d.c m;
        private boolean n;
        private boolean o;
        private int p;
        private final java.util.concurrent.Semaphore e = new java.util.concurrent.Semaphore(0);
        private com.anythink.expressad.a.g.a q = new com.anythink.expressad.a.h.a.AnonymousClass1();

        /* renamed from: com.anythink.expressad.a.h$a$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.expressad.a.g.a {
            public AnonymousClass1() {
            }

            private void b() {
                synchronized (com.anythink.expressad.a.h.this) {
                    com.anythink.expressad.a.h.this.n.a(true);
                    com.anythink.expressad.a.h.a.a(com.anythink.expressad.a.h.a.this);
                }
            }

            @Override // com.anythink.expressad.a.g.a
            public final void a(java.lang.String str, java.lang.String str2) {
                com.anythink.expressad.a.h.a.this.a(str);
                com.anythink.expressad.a.h.this.n.c(str2);
                com.anythink.expressad.a.h.a.a(com.anythink.expressad.a.h.a.this, true, false);
                b();
            }

            @Override // com.anythink.expressad.a.g.a
            public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    com.anythink.expressad.a.h.this.n.b(str2);
                }
                if (!android.text.TextUtils.isEmpty(str3)) {
                    com.anythink.expressad.a.h.this.n.c(str3);
                }
                com.anythink.expressad.a.h.a.this.a(str);
                com.anythink.expressad.a.h.a.a(com.anythink.expressad.a.h.a.this, true, false);
                b();
            }

            @Override // com.anythink.expressad.a.g.a
            public final boolean a() {
                com.anythink.expressad.a.h.a.a(com.anythink.expressad.a.h.a.this, false, false);
                return false;
            }

            @Override // com.anythink.expressad.a.g.a
            public final boolean a(java.lang.String str) {
                boolean a = com.anythink.expressad.a.h.a.this.a(str);
                com.anythink.expressad.a.h.a.a(com.anythink.expressad.a.h.a.this, false, true);
                if (a) {
                    b();
                }
                return a;
            }

            @Override // com.anythink.expressad.a.g.a
            public final boolean b(java.lang.String str) {
                boolean a = com.anythink.expressad.a.h.a.this.a(str);
                com.anythink.expressad.a.h.a.a(com.anythink.expressad.a.h.a.this, false, true);
                if (a) {
                    com.anythink.expressad.a.h.a.a(com.anythink.expressad.a.h.a.this, true, true);
                    b();
                }
                return a;
            }
        }

        public a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.anythink.expressad.c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z, boolean z2, int i) {
            this.f = context;
            this.g = str;
            this.i = str2;
            this.j = str3;
            this.k = str4;
            this.l = bVar;
            this.m = cVar;
            this.n = z;
            this.o = z2;
            this.p = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x0220 A[EDGE_INSN: B:104:0x0220->B:63:0x0220 BREAK  A[LOOP:0: B:18:0x0055->B:59:0x01cc], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private com.anythink.expressad.a.c.b a(java.lang.String str, boolean z, boolean z2, com.anythink.expressad.foundation.d.c cVar, int i) {
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String str4;
            int i2;
            java.lang.String str5;
            java.lang.String str6 = str;
            java.lang.String str7 = "";
            if (com.anythink.expressad.a.h.this.p) {
                java.lang.String a = com.anythink.expressad.d.a.a(this.f, str6);
                if (!android.text.TextUtils.isEmpty(a)) {
                    str6 = str6 + a;
                }
            }
            com.anythink.expressad.foundation.d.c cVar2 = this.m;
            if (cVar2 != null) {
                str6 = cVar2.u(str6);
            }
            com.anythink.expressad.a.c.b bVar = new com.anythink.expressad.a.c.b();
            com.anythink.expressad.a.f fVar = new com.anythink.expressad.a.f();
            try {
            } catch (java.lang.Exception unused) {
                str2 = "";
            }
            if (b(str6)) {
                str3 = "";
                str4 = str6;
                i2 = 0;
                while (true) {
                    if (i2 < 10) {
                    }
                    str4 = str5;
                    i2++;
                }
                return bVar;
            }
            java.net.URI create = java.net.URI.create(str6);
            str2 = create.getScheme();
            try {
                str7 = create.getHost();
            } catch (java.lang.Exception unused2) {
            }
            str3 = str7;
            str7 = str2;
            str4 = str6;
            i2 = 0;
            while (true) {
                if (i2 < 10) {
                    break;
                }
                if (!com.anythink.expressad.a.h.this.o) {
                    return null;
                }
                java.lang.System.currentTimeMillis();
                com.anythink.expressad.a.h.this.f195s = fVar.a(str4, z, z2, cVar);
                java.lang.System.currentTimeMillis();
                if (com.anythink.expressad.a.h.this.f195s == null) {
                    bVar.e(str4);
                    bVar.a(false);
                    if (this.l != null) {
                        int i3 = com.anythink.expressad.c.a.a;
                    }
                } else if (android.text.TextUtils.isEmpty(com.anythink.expressad.a.h.this.f195s.h)) {
                    bVar.a(true);
                    if (this.l != null) {
                        int i4 = com.anythink.expressad.c.a.a;
                        com.anythink.expressad.a.f.a unused3 = com.anythink.expressad.a.h.this.f195s;
                        com.anythink.expressad.a.f.a unused4 = com.anythink.expressad.a.h.this.f195s;
                        com.anythink.expressad.a.f.a unused5 = com.anythink.expressad.a.h.this.f195s;
                    }
                    int i5 = com.anythink.expressad.a.h.this.f195s.f;
                    if (i5 == 301 || i5 == 302 || i5 == 307) {
                        bVar.b();
                        if (android.text.TextUtils.isEmpty(com.anythink.expressad.a.h.this.f195s.a)) {
                            bVar.b(true);
                            bVar.e(str4);
                            break;
                        }
                        str5 = com.anythink.expressad.a.h.this.f195s.a;
                        if (b(str5)) {
                            if (!str5.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || android.text.TextUtils.isEmpty(str7) || android.text.TextUtils.isEmpty(str3)) {
                                break;
                            }
                            str5 = str7 + "://" + str3 + str5;
                            str7 = null;
                            str3 = null;
                        } else if (!b(str5)) {
                            try {
                                java.net.URI create2 = java.net.URI.create(str5);
                                str7 = create2.getScheme();
                                str3 = create2.getHost();
                            } catch (java.lang.Exception unused6) {
                            }
                        }
                        if (com.anythink.expressad.foundation.h.s.a.a(str5)) {
                            bVar.b(true);
                            bVar.e(str5);
                            break;
                        }
                        if (com.anythink.expressad.a.h.this.p) {
                            java.lang.String a2 = com.anythink.expressad.d.a.a(this.f, str5);
                            if (!android.text.TextUtils.isEmpty(a2)) {
                                str5 = str5 + a2;
                            }
                        }
                        com.anythink.expressad.foundation.d.c cVar3 = this.m;
                        if (cVar3 != null) {
                            str5 = cVar3.u(str5);
                        }
                        str4 = str5;
                        i2++;
                    } else {
                        if (com.anythink.expressad.a.h.this.f195s.f == 200) {
                            bVar.b(true);
                            bVar.e(str4);
                            bVar.c(com.anythink.expressad.a.h.this.f195s.g != null ? com.anythink.expressad.a.h.this.f195s.g : null);
                        } else {
                            bVar.b(false);
                            bVar.e(str4);
                            if (i2 == 0) {
                                com.anythink.expressad.a.a.a.a().a(str4, com.anythink.expressad.a.h.this.f195s.h, cVar, this.k, z, z2, i);
                            }
                        }
                    }
                } else {
                    bVar.e(str4);
                    bVar.b(com.anythink.expressad.a.h.this.f195s.h);
                    bVar.b(1);
                    bVar.a(com.anythink.expressad.a.h.this.f195s.a());
                    bVar.a(false);
                    if (i2 == 0) {
                        com.anythink.expressad.a.a.a.a().a(str4, com.anythink.expressad.a.h.this.f195s.h, cVar, this.k, z, z2, i);
                    }
                    if (this.l != null) {
                        int i6 = com.anythink.expressad.c.a.a;
                        com.anythink.expressad.a.f.a unused7 = com.anythink.expressad.a.h.this.f195s;
                        com.anythink.expressad.a.f.a unused8 = com.anythink.expressad.a.h.this.f195s;
                        com.anythink.expressad.a.f.a unused9 = com.anythink.expressad.a.h.this.f195s;
                    }
                }
            }
            return bVar;
        }

        public static /* synthetic */ void a(com.anythink.expressad.a.h.a aVar) {
            aVar.e.release();
        }

        public static /* synthetic */ void a(com.anythink.expressad.a.h.a aVar, boolean z, boolean z2) {
            if (com.anythink.expressad.a.h.this.l == 0) {
                com.anythink.expressad.a.h.this.l = java.lang.System.currentTimeMillis();
            } else {
                com.anythink.expressad.a.h.this.l = java.lang.System.currentTimeMillis();
            }
            if (!z) {
                if (aVar.l != null) {
                    int i = com.anythink.expressad.c.a.a;
                }
            } else {
                if (z2) {
                    if (aVar.l == null || com.anythink.expressad.a.h.this.k) {
                        return;
                    }
                    com.anythink.expressad.a.h.f(com.anythink.expressad.a.h.this);
                    int i2 = com.anythink.expressad.c.a.a;
                    return;
                }
                if (aVar.l == null || com.anythink.expressad.a.h.this.k) {
                    return;
                }
                com.anythink.expressad.a.h.f(com.anythink.expressad.a.h.this);
                int i3 = com.anythink.expressad.c.a.a;
            }
        }

        private void a(boolean z, boolean z2) {
            if (com.anythink.expressad.a.h.this.l == 0) {
                com.anythink.expressad.a.h.this.l = java.lang.System.currentTimeMillis();
            } else {
                com.anythink.expressad.a.h.this.l = java.lang.System.currentTimeMillis();
            }
            if (!z) {
                if (this.l != null) {
                    int i = com.anythink.expressad.c.a.a;
                }
            } else {
                if (z2) {
                    if (this.l == null || com.anythink.expressad.a.h.this.k) {
                        return;
                    }
                    com.anythink.expressad.a.h.f(com.anythink.expressad.a.h.this);
                    int i2 = com.anythink.expressad.c.a.a;
                    return;
                }
                if (this.l == null || com.anythink.expressad.a.h.this.k) {
                    return;
                }
                com.anythink.expressad.a.h.f(com.anythink.expressad.a.h.this);
                int i3 = com.anythink.expressad.c.a.a;
            }
        }

        private static boolean a(int i) {
            return i == 200;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(java.lang.String str) {
            com.anythink.expressad.foundation.d.c cVar = this.m;
            if (cVar != null) {
                cVar.Q();
            }
            if (com.anythink.expressad.foundation.h.s.a.a(str)) {
                com.anythink.expressad.a.h.this.n.c(1);
                com.anythink.expressad.a.h.this.n.e(str);
                com.anythink.expressad.a.h.this.n.b(true);
                return true;
            }
            if (!e(str)) {
                com.anythink.expressad.a.h.this.n.c(2);
                com.anythink.expressad.a.h.this.n.e(str);
                return false;
            }
            com.anythink.expressad.a.h.this.n.c(3);
            com.anythink.expressad.a.h.this.n.e(str);
            com.anythink.expressad.a.h.this.n.b(true);
            return true;
        }

        private static boolean b(int i) {
            return i == 301 || i == 302 || i == 307;
        }

        private static boolean b(java.lang.String str) {
            return !android.webkit.URLUtil.isNetworkUrl(str);
        }

        private static boolean c(java.lang.String str) {
            return str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        }

        private void d() {
            this.e.acquireUninterruptibly();
        }

        private static boolean d(java.lang.String str) {
            return com.anythink.expressad.foundation.h.s.a.a(str);
        }

        private static boolean e(java.lang.String str) {
            return !android.text.TextUtils.isEmpty(str) && str.toLowerCase().contains("apk");
        }

        private void h() {
            this.e.release();
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void a() {
            if (com.anythink.expressad.a.h.this.m != null) {
                com.anythink.expressad.a.e unused = com.anythink.expressad.a.h.this.m;
            }
            com.anythink.expressad.a.h.this.n = new com.anythink.expressad.a.c.b();
            com.anythink.expressad.a.h.this.n.e(this.g);
            com.anythink.expressad.a.h.this.n = a(this.g, this.n, this.o, this.m, this.p);
            if (!android.text.TextUtils.isEmpty(com.anythink.expressad.a.h.this.n.e())) {
                com.anythink.expressad.a.h.this.n.a(true);
            }
            if (com.anythink.expressad.a.h.this.o && com.anythink.expressad.a.h.this.n.g()) {
                if (com.anythink.expressad.a.h.this.f195s != null) {
                    com.anythink.expressad.a.h.this.n.a(com.anythink.expressad.a.h.this.f195s.f);
                }
                if (!e(com.anythink.expressad.a.h.this.n.j()) && !com.anythink.expressad.foundation.h.s.a.a(com.anythink.expressad.a.h.this.n.j()) && 200 == com.anythink.expressad.a.h.this.f195s.f && !android.text.TextUtils.isEmpty(com.anythink.expressad.a.h.this.n.f()) && !com.anythink.expressad.a.h.this.n.f().contains(com.anythink.expressad.foundation.g.a.bU)) {
                    com.anythink.expressad.a.h.this.n.b(2);
                    if (android.text.TextUtils.isEmpty(com.anythink.expressad.a.h.this.n.f())) {
                        try {
                            new com.anythink.expressad.a.g(com.anythink.expressad.a.h.this.u).a(this.i, this.j, this.k, this.f, com.anythink.expressad.a.h.this.n.j(), this.q);
                        } catch (java.lang.Exception unused2) {
                        }
                    } else {
                        new com.anythink.expressad.a.g(com.anythink.expressad.a.h.this.u).a(this.i, this.j, this.k, this.f, com.anythink.expressad.a.h.this.n.j(), com.anythink.expressad.a.h.this.n.f(), this.q);
                    }
                    this.e.acquireUninterruptibly();
                    return;
                }
                if (this.l != null) {
                    com.anythink.expressad.a.h.this.n.j();
                    int i = com.anythink.expressad.c.a.a;
                }
                if (com.anythink.expressad.a.h.this.f195s != null) {
                    com.anythink.expressad.a.h.this.n.b(1);
                    com.anythink.expressad.a.h.this.n.b(com.anythink.expressad.a.h.this.f195s.h);
                    com.anythink.expressad.a.h.this.n.a(com.anythink.expressad.a.h.this.f195s.f);
                    com.anythink.expressad.a.h.this.n.a(com.anythink.expressad.a.h.this.f195s.a());
                    com.anythink.expressad.a.h.this.n.c(com.anythink.expressad.a.h.this.f195s.g);
                }
                a(com.anythink.expressad.a.h.this.n.j());
            }
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    public h(android.content.Context context) {
        this.q = context;
        this.r = new com.anythink.expressad.foundation.g.g.c(context, 2);
    }

    private boolean a() {
        return this.o;
    }

    public static /* synthetic */ boolean f(com.anythink.expressad.a.h hVar) {
        hVar.k = true;
        return true;
    }

    @Override // com.anythink.expressad.foundation.g.g.a.b
    public final void a(com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a) {
        if (enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.FINISH && this.o) {
            this.t.post(new com.anythink.expressad.a.h.AnonymousClass1());
        }
    }

    public final void a(java.lang.String str, com.anythink.expressad.a.e eVar, boolean z, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.anythink.expressad.c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z2, boolean z3, int i2) {
        this.m = eVar;
        this.p = z;
        this.r.a(new com.anythink.expressad.a.h.a(this.q, str, str2, str3, str4, bVar, cVar, z2, z3, i2), this);
    }

    @Override // com.anythink.expressad.a.d
    public final void b() {
        this.o = false;
    }
}
