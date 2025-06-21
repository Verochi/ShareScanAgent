package com.anythink.core.common.n;

/* loaded from: classes12.dex */
public final class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 4;
    public static final int o = 5;
    public static final int p = 0;
    private static java.lang.String q = "";

    /* renamed from: com.anythink.core.common.n.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.b a;
        final /* synthetic */ com.anythink.core.d.e b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ boolean e;
        final /* synthetic */ int f;
        final /* synthetic */ java.lang.String g;
        final /* synthetic */ java.lang.String h;
        final /* synthetic */ long i;
        final /* synthetic */ java.util.Map j;
        final /* synthetic */ com.anythink.core.common.f.c k;

        public AnonymousClass1(com.anythink.core.common.f.b bVar, com.anythink.core.d.e eVar, java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.String str3, java.lang.String str4, long j, java.util.Map map, com.anythink.core.common.f.c cVar) {
            this.a = bVar;
            this.b = eVar;
            this.c = str;
            this.d = str2;
            this.e = z;
            this.f = i;
            this.g = str3;
            this.h = str4;
            this.i = j;
            this.j = map;
            this.k = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.Object obj;
            com.anythink.core.common.f.b bVar = this.a;
            com.anythink.core.common.f.h h = bVar != null ? bVar.h() : null;
            com.anythink.core.d.e eVar = this.b;
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(eVar != null ? java.lang.String.valueOf(eVar.ag()) : "", h != null ? java.lang.String.valueOf(h.M()) : "");
            kVar.a = "1004632";
            kVar.b = this.c;
            kVar.d = this.d;
            if (h != null) {
                kVar.g = java.lang.String.valueOf(h.N());
            } else {
                com.anythink.core.d.e eVar2 = this.b;
                if (eVar2 != null) {
                    kVar.g = java.lang.String.valueOf(eVar2.an());
                } else {
                    kVar.g = "0";
                }
            }
            kVar.k = h != null ? java.lang.String.valueOf(h.K()) : "0";
            if (h != null) {
                kVar.l = java.lang.String.valueOf(h.aa());
            } else {
                com.anythink.core.d.e eVar3 = this.b;
                if (eVar3 != null) {
                    kVar.l = java.lang.String.valueOf(eVar3.Y());
                }
            }
            kVar.m = this.e ? "1" : "0";
            kVar.n = java.lang.String.valueOf(this.f);
            kVar.o = h != null ? java.lang.String.valueOf(h.F()) : "-1";
            kVar.p = h != null ? h.C() : "";
            kVar.q = h != null ? java.lang.String.valueOf(h.M()) : "";
            kVar.r = h != null ? h.u : "";
            kVar.f171s = this.g;
            kVar.t = h != null ? h.ad() : this.c;
            if (h == null || android.text.TextUtils.equals(this.c, h.ad())) {
                kVar.u = "0";
            } else {
                kVar.u = "1";
            }
            if (h != null) {
                kVar.v = h.q == 3 ? "1" : "0";
            } else {
                kVar.v = "0";
            }
            kVar.w = this.h;
            com.anythink.core.common.f.b bVar2 = this.a;
            if (bVar2 != null && bVar2.k() == "3") {
                kVar.y = "1";
            }
            long j = this.i;
            if (j > 0) {
                kVar.x = java.lang.String.valueOf(j);
            }
            com.anythink.core.d.e eVar4 = this.b;
            kVar.j = eVar4 != null ? eVar4.ad() : "";
            com.anythink.core.d.e eVar5 = this.b;
            kVar.A = eVar5 != null ? java.lang.String.valueOf(eVar5.ag()) : "";
            if (h != null) {
                kVar.C = h.V();
            } else {
                com.anythink.core.d.e eVar6 = this.b;
                if (eVar6 != null) {
                    kVar.C = eVar6.o();
                }
            }
            if (h != null) {
                kVar.D = h.W();
            } else {
                java.util.Map map = this.j;
                if (map != null && (obj = map.get(com.anythink.core.api.ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                    kVar.D = obj.toString();
                }
            }
            com.anythink.core.common.f.c cVar = this.k;
            if (cVar != null) {
                kVar.F = cVar.a();
                kVar.G = this.k.b();
                kVar.H = this.k.c();
            }
            com.anythink.core.common.n.c.a(kVar);
        }
    }

    /* renamed from: com.anythink.core.common.n.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;
        final /* synthetic */ java.lang.String h;
        final /* synthetic */ java.lang.String i;

        public AnonymousClass2(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i, boolean z, java.lang.String str6, java.lang.String str7) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = i;
            this.g = z;
            this.h = str6;
            this.i = str7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(this.a, this.b);
            kVar.a = "1004680";
            kVar.b = this.c;
            kVar.d = this.d;
            kVar.m = this.e;
            kVar.n = java.lang.String.valueOf(this.f);
            kVar.o = this.g ? "1" : "0";
            try {
                z = ((android.os.PowerManager) com.anythink.core.common.b.o.a().f().getSystemService("power")).isScreenOn();
            } catch (java.lang.Throwable unused) {
                z = true;
            }
            kVar.p = z ? "1" : "0";
            kVar.q = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f()) ? "1" : "0";
            kVar.r = this.h;
            kVar.f171s = this.i;
            com.anythink.core.common.n.c.a(kVar);
        }
    }

    /* renamed from: com.anythink.core.common.n.c$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ java.lang.String h;
        final /* synthetic */ java.lang.String i;
        final /* synthetic */ boolean j;
        final /* synthetic */ java.lang.String k;
        final /* synthetic */ long l;

        public AnonymousClass3(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i, int i2, java.lang.String str6, java.lang.String str7, boolean z, java.lang.String str8, long j) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = i;
            this.g = i2;
            this.h = str6;
            this.i = str7;
            this.j = z;
            this.k = str8;
            this.l = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(this.a, this.b);
            kVar.a = "1004687";
            com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
            if (b == null || !com.anythink.core.common.n.c.c(b, kVar)) {
                kVar.b = this.c;
                kVar.d = this.d;
                kVar.m = this.e;
                kVar.n = java.lang.String.valueOf(this.f);
                kVar.o = java.lang.String.valueOf(this.g);
                boolean z2 = true;
                try {
                    z = ((android.os.PowerManager) com.anythink.core.common.b.o.a().f().getSystemService("power")).isScreenOn();
                } catch (java.lang.Throwable unused) {
                    z = true;
                }
                boolean z3 = false;
                try {
                    android.app.KeyguardManager keyguardManager = (android.app.KeyguardManager) com.anythink.core.common.b.o.a().f().getSystemService("keyguard");
                    if (keyguardManager != null) {
                        z3 = keyguardManager.inKeyguardRestrictedInputMode();
                    }
                } catch (java.lang.Throwable unused2) {
                }
                kVar.p = (z3 || !z) ? (z3 || z) ? (z3 && z) ? "2" : "3" : "1" : "0";
                try {
                    z2 = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f());
                } catch (java.lang.Throwable unused3) {
                }
                kVar.q = z2 ? "1" : "0";
                kVar.r = this.h;
                kVar.f171s = this.i;
                kVar.t = this.j ? "1" : "2";
                if (android.text.TextUtils.isEmpty(com.anythink.core.common.n.c.q)) {
                    try {
                        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
                        long blockSize = statFs.getBlockSize();
                        java.lang.String unused4 = com.anythink.core.common.n.c.q = ((statFs.getAvailableBlocks() * blockSize) / 1048576) + "MB";
                        kVar.u = com.anythink.core.common.n.c.q;
                    } catch (java.lang.Throwable unused5) {
                    }
                } else {
                    kVar.u = com.anythink.core.common.n.c.q;
                }
                kVar.v = this.k;
                kVar.w = java.lang.String.valueOf(this.l);
                com.anythink.core.common.n.c.a(kVar);
            }
        }
    }

    /* renamed from: com.anythink.core.common.n.c$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ long f;
        final /* synthetic */ int g;

        public AnonymousClass4(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j, int i2) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = j;
            this.g = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(java.lang.String.valueOf(this.a), "");
            kVar.a = "1004691";
            com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
            if (b == null || b.O() || !b.c() || com.anythink.core.common.n.c.c(b, kVar)) {
                return;
            }
            kVar.b = this.b;
            kVar.d = this.c;
            kVar.m = this.d;
            kVar.n = this.e;
            long j = this.f;
            if (j >= 0) {
                kVar.o = java.lang.String.valueOf(j);
            }
            int i = this.g;
            if (i > 0) {
                kVar.p = java.lang.String.valueOf(i);
            }
            com.anythink.core.common.i.d b2 = com.anythink.core.common.i.e.a().b();
            if (b2 != null) {
                kVar.q = java.lang.String.valueOf(b2.a());
                kVar.r = java.lang.String.valueOf(b2.e());
                kVar.f171s = java.lang.String.valueOf(b2.f());
                kVar.t = java.lang.String.valueOf(b2.b());
                kVar.u = java.lang.String.valueOf(b2.g());
                kVar.v = java.lang.String.valueOf(b2.h());
                kVar.w = java.lang.String.valueOf(b2.c());
                kVar.x = java.lang.String.valueOf(b2.d());
            }
            kVar.y = java.lang.String.valueOf(com.anythink.core.common.i.e.a().e());
            com.anythink.core.common.n.c.a(kVar);
        }
    }

    /* renamed from: com.anythink.core.common.n.c$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.k a;

        public AnonymousClass5(com.anythink.core.common.f.k kVar) {
            this.a = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            if (android.text.TextUtils.isEmpty(this.a.e)) {
                this.a.e = com.anythink.core.common.b.o.a().q();
            }
            if (!android.text.TextUtils.isEmpty(this.a.d)) {
                this.a.f = com.anythink.core.common.b.o.a().g(this.a.d);
                com.anythink.core.common.n.c.c(this.a);
            }
            this.a.i = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
            if (b != null) {
                z = com.anythink.core.common.n.c.a(this.a, b);
                if (com.anythink.core.common.n.c.c(b, this.a)) {
                    return;
                }
                if (com.anythink.core.common.n.c.b(b, this.a)) {
                    com.anythink.core.common.n.d.a(com.anythink.core.common.b.o.a().f()).a(this.a, z);
                    return;
                }
            } else {
                z = false;
            }
            com.anythink.core.common.n.b.a().a(this.a, z);
        }
    }

    /* renamed from: com.anythink.core.common.n.c$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass6(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (android.text.TextUtils.isEmpty(this.a)) {
                return;
            }
            com.anythink.core.common.f.k a = com.anythink.core.common.f.k.a(this.a);
            if (android.text.TextUtils.isEmpty(a.a)) {
                return;
            }
            com.anythink.core.common.n.c.a(a);
        }
    }

    public static void a() {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004657";
        a(kVar);
    }

    public static void a(int i2, int i3, int i4, int i5) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, java.lang.String.valueOf(i5));
        kVar.a = "1004641";
        kVar.m = java.lang.String.valueOf(i2);
        kVar.n = java.lang.String.valueOf(i3);
        kVar.o = java.lang.String.valueOf(i4);
        kVar.p = java.lang.String.valueOf(i5);
        a(kVar);
    }

    public static void a(int i2, long j2, long j3, java.lang.String str) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004644";
        kVar.e = str;
        kVar.m = java.lang.String.valueOf(i2);
        kVar.n = java.lang.String.valueOf(j2);
        kVar.o = java.lang.String.valueOf(j3);
        kVar.p = java.lang.String.valueOf(j3 - j2);
        a(kVar);
    }

    private static void a(int i2, long j2, long j3, java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004651";
        kVar.e = str;
        kVar.m = java.lang.String.valueOf(i2);
        kVar.n = java.lang.String.valueOf(j3 - j2);
        kVar.o = str2;
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.a aVar, long j2, boolean z, boolean z2) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(java.lang.String.valueOf(aVar.f), java.lang.String.valueOf(auVar.d()));
        kVar.a = "1004660";
        com.anythink.core.common.f.az azVar = aVar.n;
        com.anythink.core.d.e a2 = azVar != null ? azVar.a() : null;
        kVar.b = aVar.d;
        kVar.d = aVar.e;
        java.lang.String str = "";
        kVar.g = java.lang.String.valueOf(a2 != null ? java.lang.Integer.valueOf(a2.an()) : "");
        kVar.l = java.lang.String.valueOf(a2 != null ? java.lang.Integer.valueOf(a2.Y()) : "");
        kVar.j = a2 != null ? a2.ad() : "";
        kVar.m = java.lang.String.valueOf(auVar.d());
        kVar.n = auVar.u();
        kVar.o = z ? "1" : "2";
        kVar.p = java.lang.String.valueOf(j2);
        kVar.q = z2 ? "1" : "2";
        if (a2 != null) {
            try {
                str = a2.o();
            } catch (java.lang.Throwable unused) {
            }
        }
        kVar.C = str;
        try {
            java.lang.Object obj = aVar.c.g.get(com.anythink.core.api.ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                kVar.D = obj.toString();
            }
        } catch (java.lang.Throwable unused2) {
        }
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.bb bbVar) {
        if (bbVar == null) {
            return;
        }
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(bbVar.p(), java.lang.String.valueOf(bbVar.m()));
        kVar.a = "1004667";
        kVar.m = java.lang.String.valueOf(bbVar.m());
        kVar.n = bbVar.n();
        kVar.o = bbVar.e();
        kVar.p = bbVar.f();
        kVar.q = bbVar.d();
        kVar.r = bbVar.c();
        kVar.f171s = bbVar.h();
        kVar.t = bbVar.g();
        kVar.u = java.lang.String.valueOf(bbVar.q());
        kVar.v = java.lang.String.valueOf(bbVar.r());
        kVar.w = java.lang.String.valueOf(bbVar.s());
        kVar.x = java.lang.String.valueOf(bbVar.t());
        kVar.y = java.lang.String.valueOf(bbVar.u());
        kVar.b = bbVar.i();
        kVar.g = bbVar.j();
        kVar.l = bbVar.k();
        kVar.d = bbVar.l();
        kVar.j = bbVar.o();
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.h hVar) {
        try {
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), java.lang.String.valueOf(hVar.M()));
            kVar.a = "1004640";
            kVar.b = hVar.ad();
            kVar.g = java.lang.String.valueOf(hVar.N());
            kVar.l = java.lang.String.valueOf(hVar.aa());
            kVar.d = hVar.ac();
            kVar.m = java.lang.String.valueOf(hVar.M());
            kVar.n = hVar.C();
            kVar.o = java.lang.String.valueOf(hVar.E());
            kVar.p = java.lang.String.valueOf(hVar.O());
            kVar.q = java.lang.String.valueOf(hVar.P());
            kVar.C = hVar.V();
            kVar.D = hVar.W();
            kVar.A = hVar.ae();
            a(kVar);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.f.h hVar, int i2, com.anythink.core.api.AdError adError) {
        try {
            a(hVar.ad(), hVar.ac(), hVar.N(), hVar.K(), hVar.M(), hVar.C(), hVar.ae(), -1, i2, adError, hVar.A(), hVar.B(), 0L, hVar.aa(), hVar.Q(), hVar.q, hVar.V(), hVar.W());
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.f.h hVar, int i2, com.anythink.core.api.AdError adError, long j2) {
        try {
            a(hVar.ad(), hVar.ac(), hVar.N(), hVar.K(), hVar.M(), hVar.C(), hVar.ae(), hVar.E(), i2, adError, hVar.A(), hVar.B(), j2, hVar.aa(), hVar.Q(), hVar.q, hVar.V(), hVar.W());
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.f.h hVar, int i2, java.lang.String str, double d2, java.lang.String str2, java.lang.String str3) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), java.lang.String.valueOf(i2));
        kVar.a = "1004668";
        kVar.d = hVar.ac();
        kVar.m = java.lang.String.valueOf(i2);
        kVar.n = str;
        kVar.o = java.lang.String.valueOf(d2);
        kVar.p = str2;
        kVar.q = str3;
        kVar.j = hVar.ab();
        kVar.g = java.lang.String.valueOf(hVar.N());
        kVar.l = java.lang.String.valueOf(hVar.aa());
        kVar.C = hVar.V();
        kVar.D = hVar.W();
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.h hVar, com.anythink.core.api.AdError adError) {
        try {
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), null);
            kVar.a = "1004630";
            kVar.b = hVar.ad();
            kVar.d = hVar.ac();
            kVar.l = java.lang.String.valueOf(hVar.aa());
            kVar.g = java.lang.String.valueOf(hVar.N());
            kVar.k = java.lang.String.valueOf(hVar.K());
            com.anythink.core.d.e a2 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(hVar.ac());
            kVar.j = a2 != null ? a2.ad() : "";
            if (adError != null) {
                kVar.m = adError.printStackTrace();
                kVar.n = adError.getCode();
            }
            kVar.C = hVar.V();
            kVar.D = hVar.W();
            a(kVar);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.f.h hVar, com.anythink.core.api.AdError adError, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), java.lang.String.valueOf(hVar.M()));
        kVar.a = "1004636";
        kVar.b = hVar.ad();
        kVar.d = hVar.ac();
        kVar.g = java.lang.String.valueOf(hVar.N());
        kVar.k = java.lang.String.valueOf(hVar.K());
        kVar.l = java.lang.String.valueOf(hVar.aa());
        kVar.m = java.lang.String.valueOf(hVar.M());
        kVar.n = hVar.C();
        kVar.o = java.lang.String.valueOf(hVar.F());
        if (adError != null) {
            kVar.p = adError.getCode();
            kVar.q = adError.getPlatformCode();
            kVar.r = adError.getPlatformMSG();
        }
        com.anythink.core.d.e a2 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(hVar.ac());
        kVar.j = a2 != null ? a2.ad() : "";
        kVar.A = hVar.ae();
        if (map != null) {
            try {
                if (map.containsKey("offer_id")) {
                    kVar.f171s = map.get("offer_id").toString();
                }
                if (map.containsKey(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.RV_ANIM_TYPE) && hVar.ae().equals("1")) {
                    kVar.t = map.get(com.anythink.core.api.ATAdConst.NETWORK_CUSTOM_KEY.RV_ANIM_TYPE).toString();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        kVar.C = hVar.V();
        kVar.D = hVar.W();
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.h hVar, com.anythink.core.d.e eVar, java.lang.String str, java.lang.String str2, java.lang.String str3, int i2) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004696";
        kVar.b = hVar.ad();
        kVar.d = hVar.ac();
        kVar.g = java.lang.String.valueOf(hVar.N());
        kVar.l = java.lang.String.valueOf(hVar.aa());
        if (eVar != null) {
            kVar.j = eVar.ad();
        }
        kVar.m = str;
        kVar.n = str2;
        kVar.o = str3;
        kVar.p = java.lang.String.valueOf(i2);
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.h hVar, com.anythink.core.d.e eVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, str);
        kVar.a = "1004695";
        kVar.b = hVar.ad();
        kVar.d = hVar.ac();
        kVar.g = java.lang.String.valueOf(hVar.N());
        kVar.l = java.lang.String.valueOf(hVar.aa());
        if (eVar != null) {
            kVar.j = eVar.ad();
        }
        kVar.m = str;
        kVar.n = str2;
        kVar.o = str3;
        kVar.p = str4;
        kVar.q = str5;
        a(kVar);
    }

    private static void a(com.anythink.core.common.f.h hVar, java.lang.String str) {
        try {
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), java.lang.String.valueOf(hVar.M()));
            kVar.a = "1004639";
            kVar.b = hVar.ad();
            kVar.d = hVar.ac();
            kVar.l = java.lang.String.valueOf(hVar.aa());
            kVar.g = java.lang.String.valueOf(hVar.N());
            kVar.m = java.lang.String.valueOf(hVar.M());
            kVar.n = hVar.C();
            kVar.o = java.lang.String.valueOf(hVar.E());
            kVar.p = str;
            kVar.A = hVar.ae();
            kVar.C = hVar.V();
            kVar.D = hVar.W();
            a(kVar);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.f.h hVar, java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), java.lang.String.valueOf(hVar.M()));
        kVar.a = "1004669";
        kVar.b = hVar.ad();
        kVar.d = hVar.ac();
        kVar.m = java.lang.String.valueOf(hVar.M());
        kVar.n = str;
        kVar.o = str2;
        kVar.j = hVar.ab();
        kVar.g = java.lang.String.valueOf(hVar.N());
        kVar.l = java.lang.String.valueOf(hVar.aa());
        kVar.C = hVar.V();
        kVar.D = hVar.W();
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.h hVar, boolean z) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), java.lang.String.valueOf(hVar.M()));
        kVar.a = "1004634";
        kVar.b = hVar.ad();
        kVar.d = hVar.ac();
        kVar.g = java.lang.String.valueOf(hVar.N());
        kVar.k = java.lang.String.valueOf(hVar.K());
        kVar.l = java.lang.String.valueOf(hVar.aa());
        kVar.m = java.lang.String.valueOf(hVar.M());
        kVar.n = hVar.C();
        kVar.o = java.lang.String.valueOf(hVar.F());
        kVar.p = z ? "1" : "0";
        kVar.q = java.lang.String.valueOf(hVar.y);
        com.anythink.core.d.e a2 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(hVar.ac());
        kVar.j = a2 != null ? a2.ad() : "";
        kVar.A = hVar.ae();
        kVar.C = hVar.V();
        kVar.D = hVar.W();
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.h hVar, boolean z, long j2, long j3, long j4) {
        try {
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), java.lang.String.valueOf(hVar.M()));
            kVar.a = "1004643";
            kVar.b = hVar.ad();
            kVar.d = hVar.ac();
            kVar.g = java.lang.String.valueOf(hVar.N());
            kVar.k = java.lang.String.valueOf(hVar.K());
            kVar.l = java.lang.String.valueOf(hVar.aa());
            kVar.m = hVar.ae();
            kVar.n = java.lang.String.valueOf(j2);
            kVar.o = java.lang.String.valueOf(j3);
            kVar.p = java.lang.String.valueOf(j4);
            kVar.q = java.lang.String.valueOf(hVar.M());
            kVar.r = hVar.C();
            kVar.f171s = java.lang.String.valueOf(hVar.F());
            kVar.t = java.lang.String.valueOf(hVar.y);
            kVar.u = z ? "1" : "0";
            com.anythink.core.d.e a2 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(hVar.ac());
            kVar.j = a2 != null ? a2.ad() : "";
            kVar.A = hVar.ae();
            kVar.C = hVar.V();
            kVar.D = hVar.W();
            a(kVar);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.f.k kVar) {
        if (kVar == null) {
            return;
        }
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.n.c.AnonymousClass5(kVar), 8, true);
    }

    public static void a(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, java.lang.String str, java.lang.String str2) {
        if (lVar == null || mVar == null) {
            return;
        }
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(java.lang.String.valueOf(mVar.j), java.lang.String.valueOf(mVar.f));
        kVar.a = "1004652";
        kVar.d = mVar.b;
        kVar.m = java.lang.String.valueOf(mVar.f);
        kVar.n = mVar.c;
        kVar.b = mVar.d;
        if (lVar instanceof com.anythink.core.common.f.z) {
            kVar.o = "1";
        } else if (lVar instanceof com.anythink.core.common.f.j) {
            kVar.o = "2";
        } else if (lVar instanceof com.anythink.core.common.f.ah) {
            kVar.o = "3";
        }
        kVar.p = str;
        if (android.text.TextUtils.equals("0", str)) {
            kVar.q = str2;
        }
        kVar.r = lVar.s();
        kVar.f171s = lVar.t();
        kVar.t = lVar.E();
        kVar.u = lVar.u();
        kVar.v = lVar.v();
        kVar.w = lVar.w();
        kVar.x = lVar.x();
        kVar.y = lVar.A();
        try {
            if (lVar instanceof com.anythink.core.common.f.ai) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.lang.String af = ((com.anythink.core.common.f.ai) lVar).af();
                if (!android.text.TextUtils.isEmpty(af)) {
                    org.json.JSONArray jSONArray = new org.json.JSONArray(af);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(jSONArray.optString(i2));
                        sb.append(",");
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    kVar.z = sb.toString();
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        if (lVar == null || mVar == null || !(lVar instanceof com.anythink.core.common.f.ai)) {
            return;
        }
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(java.lang.String.valueOf(mVar.j), java.lang.String.valueOf(mVar.f));
        kVar.a = "1004697";
        kVar.b = mVar.d;
        kVar.d = mVar.b;
        kVar.g = java.lang.String.valueOf(mVar.i);
        kVar.l = java.lang.String.valueOf(mVar.h);
        kVar.m = lVar.s();
        kVar.n = lVar.t();
        kVar.o = ((com.anythink.core.common.f.ai) lVar).Z();
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, int i2) {
        try {
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(java.lang.String.valueOf(mVar.j), java.lang.String.valueOf(mVar.f));
            kVar.a = "1004679";
            kVar.b = mVar.d;
            kVar.d = mVar.b;
            if (lVar instanceof com.anythink.core.common.f.j) {
                kVar.m = ((com.anythink.core.common.f.j) lVar).Z();
            }
            kVar.n = mVar.c;
            kVar.o = lVar.s();
            kVar.p = java.lang.String.valueOf(lVar.d());
            kVar.q = lVar.h();
            kVar.r = lVar.i();
            kVar.f171s = java.lang.String.valueOf(i2);
            a(kVar);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, java.lang.String str2, int i2) {
        if (mVar == null || lVar == null) {
            return;
        }
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(java.lang.String.valueOf(mVar.j), java.lang.String.valueOf(mVar.f));
        kVar.a = "1004650";
        kVar.d = mVar.b;
        kVar.m = lVar.s();
        kVar.n = java.lang.String.valueOf(lVar.d());
        kVar.o = str;
        kVar.p = str2;
        kVar.q = java.lang.String.valueOf(i2);
        kVar.b = mVar.d;
        kVar.t = java.lang.String.valueOf(mVar.j);
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (mVar == null || lVar == null) {
            return;
        }
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004648";
        kVar.d = mVar.b;
        kVar.m = lVar.s();
        kVar.n = java.lang.String.valueOf(lVar.d());
        kVar.o = str;
        kVar.p = str2;
        kVar.q = str3;
        kVar.r = str4;
        kVar.b = mVar.d;
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, boolean z, int i2, int i3, long j2, long j3) {
        if (mVar == null || lVar == null) {
            return;
        }
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004699";
        kVar.b = mVar.d;
        kVar.d = mVar.b;
        kVar.m = z ? "2" : "1";
        kVar.n = java.lang.String.valueOf(i2);
        kVar.o = java.lang.String.valueOf(j2);
        kVar.p = java.lang.String.valueOf(j3);
        kVar.q = java.lang.String.valueOf(mVar.j);
        kVar.r = java.lang.String.valueOf(i3);
        if (lVar instanceof com.anythink.core.common.f.j) {
            com.anythink.core.common.f.j jVar = (com.anythink.core.common.f.j) lVar;
            kVar.f171s = java.lang.String.valueOf(jVar.Z());
            kVar.t = java.lang.String.valueOf(jVar.s());
        }
        a(kVar);
    }

    public static void a(com.anythink.core.common.f.y yVar, double d2, java.lang.String str, double d3, double d4, double d5) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(java.lang.String.valueOf(yVar.k()), java.lang.String.valueOf(yVar.h()));
        kVar.a = "1004659";
        kVar.b = yVar.d();
        kVar.d = yVar.g();
        kVar.g = java.lang.String.valueOf(yVar.e());
        kVar.l = java.lang.String.valueOf(yVar.f());
        kVar.j = yVar.j();
        kVar.m = java.lang.String.valueOf(yVar.h());
        kVar.n = yVar.i();
        kVar.o = java.lang.String.valueOf(d2);
        kVar.p = str;
        kVar.C = yVar.l();
        kVar.D = yVar.m();
        kVar.q = java.lang.String.valueOf(d3);
        kVar.r = java.lang.String.valueOf(d4);
        kVar.f171s = yVar.o();
        kVar.t = java.lang.String.valueOf(yVar.p());
        kVar.u = java.lang.String.valueOf(yVar.c());
        kVar.v = java.lang.String.valueOf(d5);
        a(kVar);
    }

    private static void a(java.lang.Runnable runnable) {
        com.anythink.core.common.o.b.b.a().a(runnable, 13, true);
    }

    public static void a(java.lang.String str) {
        a(new com.anythink.core.common.n.c.AnonymousClass6(str));
    }

    public static void a(java.lang.String str, com.anythink.core.common.f.au auVar, boolean z, long j2, com.anythink.core.common.f.a aVar) {
        com.anythink.core.d.e a2 = aVar != null ? aVar.n.a() : null;
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(java.lang.String.valueOf(aVar.f), java.lang.String.valueOf(auVar.d()));
        kVar.a = "1004665";
        kVar.d = str;
        java.lang.String str2 = "";
        kVar.j = a2 != null ? a2.ad() : "";
        kVar.m = java.lang.String.valueOf(auVar.d());
        kVar.n = auVar.u();
        kVar.o = java.lang.String.valueOf(z ? 1 : 2);
        kVar.p = java.lang.String.valueOf(j2);
        if (a2 != null) {
            try {
                str2 = a2.o();
            } catch (java.lang.Throwable unused) {
            }
        }
        kVar.C = str2;
        try {
            java.lang.Object obj = aVar.c.g.get(com.anythink.core.api.ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                kVar.D = obj.toString();
            }
        } catch (java.lang.Throwable unused2) {
        }
        a(kVar);
    }

    public static void a(java.lang.String str, com.anythink.core.common.f.h hVar, java.lang.String str2, java.lang.Object obj) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004701";
        kVar.d = str;
        kVar.g = java.lang.String.valueOf(hVar.N());
        kVar.l = java.lang.String.valueOf(hVar.aa());
        kVar.m = hVar.ae();
        kVar.n = java.lang.String.valueOf(hVar.M());
        kVar.o = hVar.C();
        kVar.p = java.lang.String.valueOf(hVar.Q());
        kVar.q = str2;
        kVar.r = obj != null ? obj.toString() : "";
        a(kVar);
    }

    private static void a(java.lang.String str, java.lang.String str2, int i2, int i3, int i4, java.lang.String str3, java.lang.String str4, int i5, int i6, com.anythink.core.api.AdError adError, int i7, double d2, long j2, int i8, int i9, int i10, java.lang.String str5, java.lang.String str6) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(str4, java.lang.String.valueOf(i4));
        kVar.a = "1004631";
        kVar.b = str;
        kVar.d = str2;
        kVar.g = java.lang.String.valueOf(i2);
        kVar.k = java.lang.String.valueOf(i3);
        kVar.l = java.lang.String.valueOf(i8);
        kVar.m = java.lang.String.valueOf(i4);
        kVar.n = str3;
        kVar.o = java.lang.String.valueOf(i5);
        kVar.p = java.lang.String.valueOf(i6);
        kVar.q = adError != null ? adError.getPlatformCode() : "";
        kVar.r = adError != null ? adError.getPlatformMSG() : "";
        kVar.f171s = java.lang.String.valueOf(i7);
        kVar.t = java.lang.String.valueOf(d2);
        if (i6 == 0) {
            kVar.u = java.lang.String.valueOf(j2);
        }
        kVar.v = java.lang.String.valueOf(i9);
        kVar.w = java.lang.String.valueOf(i10);
        com.anythink.core.d.e a2 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(str2);
        kVar.j = a2 != null ? a2.ad() : "";
        kVar.C = str5;
        kVar.D = str6;
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, int i2, java.lang.String str3, java.util.Map<java.lang.String, org.json.JSONArray> map, int i3, int i4, int i5, java.lang.String str4, int i6, int i7, long j2, java.lang.String str5, int i8) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004675";
        kVar.b = str2;
        kVar.d = str;
        kVar.m = str3;
        kVar.n = java.lang.String.valueOf(i2);
        kVar.p = java.lang.String.valueOf(i3);
        kVar.q = java.lang.String.valueOf(i4);
        kVar.r = java.lang.String.valueOf(i5);
        kVar.f171s = str4;
        kVar.t = java.lang.String.valueOf(i6);
        if (i7 >= 0) {
            kVar.u = java.lang.String.valueOf(i7);
        }
        if (j2 > 0) {
            kVar.v = java.lang.String.valueOf(j2);
        }
        if (!android.text.TextUtils.isEmpty(str5)) {
            kVar.w = str5;
        }
        if (i8 > 0) {
            kVar.x = java.lang.String.valueOf(i8);
        }
        if (map != null && map.size() > 0) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                for (java.util.Map.Entry<java.lang.String, org.json.JSONArray> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                kVar.y = jSONObject.toString();
            } catch (java.lang.Throwable unused) {
            }
        }
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, int i2, java.lang.String str3, org.json.JSONArray jSONArray, java.lang.String str4, int i3) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004700";
        kVar.b = str2;
        kVar.d = str;
        kVar.m = str3;
        kVar.n = java.lang.String.valueOf(i2);
        kVar.o = jSONArray != null ? jSONArray.toString() : "";
        kVar.p = str4;
        kVar.q = java.lang.String.valueOf(i3);
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, long j2, long j3, long j4) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004635";
        if (!android.text.TextUtils.isEmpty(str2)) {
            kVar.d = str2;
        }
        kVar.m = str;
        kVar.n = java.lang.String.valueOf(j2);
        kVar.o = java.lang.String.valueOf(j3);
        kVar.p = java.lang.String.valueOf(j4);
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.h hVar, com.anythink.core.d.e eVar, java.lang.String str3, java.lang.String str4) {
        try {
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), java.lang.String.valueOf(hVar.M()));
            kVar.a = "1004658";
            kVar.b = hVar.ad();
            kVar.d = str;
            kVar.g = java.lang.String.valueOf(hVar.N());
            kVar.k = java.lang.String.valueOf(hVar.K());
            kVar.l = java.lang.String.valueOf(hVar.aa());
            kVar.j = eVar != null ? eVar.ad() : "";
            kVar.m = java.lang.String.valueOf(hVar.M());
            kVar.n = hVar.C();
            kVar.o = hVar.q();
            kVar.p = hVar.j();
            kVar.q = hVar.B;
            kVar.r = str3;
            kVar.f171s = str4;
            kVar.t = str2;
            kVar.C = hVar.V();
            kVar.D = hVar.W();
            a(kVar);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, int i2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        try {
            com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(eVar != null ? java.lang.String.valueOf(eVar.ag()) : "", "");
            kVar.a = "1004633";
            kVar.b = str;
            kVar.d = str2;
            kVar.g = java.lang.String.valueOf(eVar != null ? eVar.an() : 0);
            kVar.k = "0";
            kVar.l = java.lang.String.valueOf(eVar != null ? java.lang.Integer.valueOf(eVar.Y()) : "");
            kVar.m = java.lang.String.valueOf(i2);
            kVar.n = str3;
            kVar.q = str;
            kVar.r = "0";
            kVar.j = eVar != null ? eVar.ad() : "";
            kVar.C = eVar != null ? eVar.o() : "";
            if (map != null && (obj = map.get(com.anythink.core.api.ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                kVar.D = obj.toString();
            }
            a(kVar);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, java.lang.String str3) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004646";
        kVar.b = str;
        kVar.d = str2;
        kVar.g = java.lang.String.valueOf(eVar.an());
        kVar.l = java.lang.String.valueOf(eVar.Y());
        kVar.j = eVar.ad();
        kVar.t = java.lang.String.valueOf(str3);
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, java.lang.String str3, com.anythink.core.common.f.b bVar, long j2) {
        java.lang.String str4;
        if (bVar != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(bVar.h().M());
            str4 = sb.toString();
        } else {
            str4 = null;
        }
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k("4", str4);
        kVar.a = "1004690";
        kVar.b = str2;
        kVar.d = str;
        if (eVar != null) {
            kVar.l = java.lang.String.valueOf(eVar.Y());
            kVar.g = java.lang.String.valueOf(eVar.an());
            kVar.j = eVar.ad();
        }
        kVar.m = str3;
        if (bVar != null) {
            kVar.n = bVar.k();
            kVar.o = kVar.B;
            kVar.p = bVar.h() != null ? bVar.h().C() : "";
        }
        kVar.q = "1";
        kVar.r = java.lang.String.valueOf(j2);
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, boolean z, boolean z2, boolean z3, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, "");
        kVar.a = "1004694";
        kVar.b = str3;
        kVar.d = str;
        if (eVar != null) {
            kVar.g = java.lang.String.valueOf(eVar.an());
            kVar.l = java.lang.String.valueOf(eVar.Y());
            kVar.j = eVar.ad();
        }
        kVar.k = str5;
        kVar.m = z ? "1" : "0";
        kVar.n = z3 ? "1" : "0";
        kVar.o = z2 ? "1" : "0";
        kVar.p = str2;
        kVar.q = str4;
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        b(str, str2, str3, "");
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i2, java.lang.String str4, long j2, long j3) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004642";
        kVar.b = str;
        kVar.m = str2;
        kVar.n = str3;
        kVar.o = java.lang.String.valueOf(i2);
        if (i2 == 3 || i2 == 10) {
            kVar.p = str4;
        } else if (i2 == 2) {
            kVar.q = java.lang.String.valueOf(j2);
            kVar.r = java.lang.String.valueOf(j3 / 1024.0f);
        }
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004637";
        kVar.d = str;
        kVar.m = str2;
        kVar.n = str3;
        kVar.o = str4;
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i2, int i3, long j2) {
        a(new com.anythink.core.common.n.c.AnonymousClass4(i3, str2, str3, str, str4, j2, i2));
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j2, java.lang.String str5, long j3, long j4, int i2, long j5) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004638";
        kVar.d = str;
        kVar.m = str2;
        kVar.n = str3;
        kVar.o = str4;
        kVar.p = java.lang.String.valueOf(j2);
        kVar.q = str5;
        kVar.r = java.lang.String.valueOf(j3);
        kVar.f171s = java.lang.String.valueOf(j4);
        kVar.t = "1".equals(str4) ? java.lang.String.valueOf(j5) : null;
        kVar.u = java.lang.String.valueOf(i2);
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.anythink.core.d.e eVar, boolean z, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(str3, "");
        kVar.a = "1004693";
        kVar.b = str4;
        kVar.d = str;
        if (eVar != null) {
            kVar.g = java.lang.String.valueOf(eVar.an());
            kVar.l = java.lang.String.valueOf(eVar.Y());
            kVar.j = eVar.ad();
        }
        kVar.m = z ? "1" : "2";
        kVar.n = str5;
        kVar.o = str6;
        if (eVar != null) {
            kVar.p = eVar.m() != 1 ? "2" : "1";
        }
        kVar.q = str2;
        kVar.r = str7;
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004688";
        if (!android.text.TextUtils.isEmpty(str)) {
            kVar.d = str;
        }
        kVar.m = str2;
        kVar.n = str3;
        kVar.o = str4;
        kVar.p = str5;
        a(kVar);
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i2, boolean z, java.lang.String str6, java.lang.String str7) {
        a(new com.anythink.core.common.n.c.AnonymousClass2(str4, str5, str, str2, str3, i2, z, str7, str6));
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, int i2, int i3, java.lang.String str7, java.lang.String str8, boolean z, long j2) {
        a(new com.anythink.core.common.n.c.AnonymousClass3(str5, str6, str2, str3, str4, i2, i3, str8, str7, z, str, j2));
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004616";
        kVar.d = str5;
        kVar.m = str;
        kVar.n = str2;
        kVar.o = str3;
        kVar.p = str4;
        kVar.q = str6;
        kVar.r = str7;
        a(kVar);
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z, int i2, com.anythink.core.d.e eVar, com.anythink.core.common.f.b bVar, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.c cVar) {
        a(str, str2, z, i2, eVar, bVar, str3, str4, map, cVar, 0L);
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z, int i2, com.anythink.core.d.e eVar, com.anythink.core.common.f.b bVar, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.c cVar, long j2) {
        try {
            a(new com.anythink.core.common.n.c.AnonymousClass1(bVar, eVar, str, str2, z, i2, str3, str4, j2, map, cVar));
        } catch (java.lang.Exception unused) {
        }
    }

    public static /* synthetic */ boolean a(com.anythink.core.common.f.k kVar, com.anythink.core.d.a aVar) {
        java.util.Map<java.lang.String, java.lang.String> e2;
        if (android.text.TextUtils.isEmpty(kVar.a) || android.text.TextUtils.isEmpty(kVar.B) || android.text.TextUtils.isEmpty(kVar.A) || (e2 = aVar.e(kVar.a)) == null) {
            return false;
        }
        if (e2.containsKey("0")) {
            java.lang.String str = e2.get("0");
            if (android.text.TextUtils.isEmpty(str) || !str.contains(kVar.A)) {
                return false;
            }
        } else {
            if (!e2.containsKey(kVar.B)) {
                return false;
            }
            java.lang.String str2 = e2.get(kVar.B);
            if (android.text.TextUtils.isEmpty(str2) || !str2.contains(kVar.A)) {
                return false;
            }
        }
        return true;
    }

    public static void b(com.anythink.core.common.f.k kVar) {
        a(kVar);
    }

    public static void b(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, int i2) {
        if (mVar == null || lVar == null) {
            return;
        }
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004698";
        kVar.b = mVar.d;
        kVar.d = mVar.b;
        kVar.g = java.lang.String.valueOf(mVar.i);
        kVar.l = java.lang.String.valueOf(mVar.h);
        kVar.m = lVar.s();
        kVar.n = lVar.t();
        kVar.o = lVar instanceof com.anythink.core.common.f.j ? ((com.anythink.core.common.f.j) lVar).Z() : "";
        kVar.p = java.lang.String.valueOf(mVar.j);
        kVar.q = java.lang.String.valueOf(mVar.a);
        kVar.r = java.lang.String.valueOf(i2);
        kVar.f171s = java.lang.String.valueOf(mVar.k);
        a(kVar);
    }

    public static void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004666";
        kVar.m = str;
        kVar.n = str2;
        kVar.o = str3;
        a(kVar);
    }

    public static void b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(null, null);
        kVar.a = "1004647";
        kVar.e = str3;
        kVar.m = str2;
        kVar.n = str;
        kVar.o = str4;
        a(kVar);
    }

    private static boolean b(com.anythink.core.common.f.k kVar, com.anythink.core.d.a aVar) {
        java.util.Map<java.lang.String, java.lang.String> e2;
        if (android.text.TextUtils.isEmpty(kVar.a) || android.text.TextUtils.isEmpty(kVar.B) || android.text.TextUtils.isEmpty(kVar.A) || (e2 = aVar.e(kVar.a)) == null) {
            return false;
        }
        if (e2.containsKey("0")) {
            java.lang.String str = e2.get("0");
            if (android.text.TextUtils.isEmpty(str) || !str.contains(kVar.A)) {
                return false;
            }
        } else {
            if (!e2.containsKey(kVar.B)) {
                return false;
            }
            java.lang.String str2 = e2.get(kVar.B);
            if (android.text.TextUtils.isEmpty(str2) || !str2.contains(kVar.A)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean b(com.anythink.core.d.a aVar, com.anythink.core.common.f.k kVar) {
        java.util.Map<java.lang.String, java.lang.String> ar = aVar.ar();
        if (ar != null) {
            if (android.text.TextUtils.isEmpty(kVar.A)) {
                return ar.containsKey(kVar.a);
            }
            if (ar.containsKey(kVar.a)) {
                java.lang.String str = ar.get(kVar.a);
                if (!android.text.TextUtils.isEmpty(str) && str.contains(kVar.A)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void c(com.anythink.core.common.f.k kVar) {
        com.anythink.core.d.e b2 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).b(kVar.d);
        if (b2 != null) {
            kVar.E = b2.aH();
        }
    }

    public static void c(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k("", "");
        if (android.text.TextUtils.isEmpty(kVar.a)) {
            kVar.a = "1004685";
        }
        kVar.c = com.anythink.core.common.b.o.a().o();
        if (!android.text.TextUtils.isEmpty(str)) {
            kVar.m = str;
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            kVar.n = str2;
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            kVar.o = str3;
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            kVar.p = str4;
        }
        a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(com.anythink.core.d.a aVar, com.anythink.core.common.f.k kVar) {
        java.lang.String av = aVar.av();
        if (!android.text.TextUtils.isEmpty(av)) {
            java.lang.String str = kVar.B;
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONArray(av);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        if (android.text.TextUtils.equals(str, jSONArray.optString(i2))) {
                            return true;
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        java.util.Map<java.lang.String, java.lang.String> at = aVar.at();
        if (at == null) {
            return false;
        }
        if (android.text.TextUtils.isEmpty(kVar.A)) {
            return at.containsKey(kVar.a);
        }
        if (at.containsKey(kVar.a)) {
            java.lang.String str2 = at.get(kVar.a);
            if (!android.text.TextUtils.isEmpty(str2) && str2.contains(kVar.A)) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(com.anythink.core.d.a aVar, com.anythink.core.common.f.k kVar) {
        java.util.Map<java.lang.String, java.lang.String> ar = aVar.ar();
        if (ar != null) {
            if (android.text.TextUtils.isEmpty(kVar.A)) {
                return ar.containsKey(kVar.a);
            }
            if (ar.containsKey(kVar.a)) {
                java.lang.String str = ar.get(kVar.a);
                if (!android.text.TextUtils.isEmpty(str) && str.contains(kVar.A)) {
                    return true;
                }
            }
        }
        return false;
    }
}
