package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public class c implements java.io.Serializable {
    public static final java.lang.String a = "2000077";
    protected static final java.lang.String b = "CampaignDownLoadTask";
    private static final long d = -510642107992871538L;
    private static final int e = 1;
    private static final int f = 2000;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 4;
    private static final int l = 5;
    private static final java.lang.String m = "errorMsg";
    private static final int p = 10010;
    private java.lang.Object A;
    private java.lang.Class B;
    private java.lang.Object C;
    private com.anythink.expressad.foundation.d.c D;
    private java.lang.String E;
    private android.content.Context G;
    private long H;
    private java.lang.String I;
    private java.lang.String L;
    private long O;
    private com.anythink.expressad.videocommon.d.b P;
    private com.anythink.expressad.videocommon.d.b Q;
    private java.lang.String U;
    private com.anythink.expressad.foundation.g.f.d.b.a V;
    private int Z;
    com.anythink.expressad.videocommon.b.b c;
    private boolean o;
    private int q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f283s;
    private java.lang.Runnable t;
    private com.anythink.expressad.videocommon.b.f w;
    private java.util.concurrent.ExecutorService x;
    private com.anythink.expressad.videocommon.b.o y;
    private java.lang.Class z;
    private boolean g = false;
    private int n = 1;
    private volatile int u = 0;
    private java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.videocommon.b.f> v = new java.util.concurrent.CopyOnWriteArrayList<>();
    private boolean F = false;
    private long J = 0;
    private int K = 0;
    private boolean M = false;
    private boolean N = false;
    private int R = 100;
    private boolean S = false;
    private boolean T = false;
    private int W = 1;
    private com.anythink.expressad.videocommon.b.f X = new com.anythink.expressad.videocommon.b.c.AnonymousClass1();
    private android.os.Handler Y = new com.anythink.expressad.videocommon.b.c.AnonymousClass2(android.os.Looper.getMainLooper());

    /* renamed from: com.anythink.expressad.videocommon.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.videocommon.b.f {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.videocommon.b.f
        public final void a(long j, int i) {
            if (com.anythink.expressad.videocommon.b.c.this.F) {
                return;
            }
            com.anythink.expressad.videocommon.b.c.a(com.anythink.expressad.videocommon.b.c.this, j, i);
        }
    }

    /* renamed from: com.anythink.expressad.videocommon.b.c$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.Handler {
        public AnonymousClass2(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                com.anythink.expressad.videocommon.b.c cVar = com.anythink.expressad.videocommon.b.c.this;
                com.anythink.expressad.videocommon.b.c.a(cVar, cVar.J, com.anythink.expressad.videocommon.b.c.this.u);
                return;
            }
            if (i == 2) {
                if (com.anythink.expressad.videocommon.b.c.this.u != 2) {
                    com.anythink.expressad.videocommon.b.c.this.u = 2;
                    com.anythink.expressad.videocommon.b.c cVar2 = com.anythink.expressad.videocommon.b.c.this;
                    com.anythink.expressad.videocommon.b.c.a(cVar2, cVar2.J, com.anythink.expressad.videocommon.b.c.this.u);
                    return;
                }
                return;
            }
            if (i == 3) {
                if (com.anythink.expressad.videocommon.b.c.this.u == 4 || com.anythink.expressad.videocommon.b.c.this.u == 2 || com.anythink.expressad.videocommon.b.c.this.u == 5) {
                    return;
                }
                com.anythink.expressad.videocommon.b.c.this.u = 4;
                com.anythink.expressad.videocommon.b.c cVar3 = com.anythink.expressad.videocommon.b.c.this;
                com.anythink.expressad.videocommon.b.c.a(cVar3, cVar3.J, com.anythink.expressad.videocommon.b.c.this.u);
                return;
            }
            if (i == 4) {
                com.anythink.expressad.videocommon.b.c.this.u = 5;
                com.anythink.expressad.videocommon.b.c.d(com.anythink.expressad.videocommon.b.c.this);
                com.anythink.expressad.videocommon.b.c cVar4 = com.anythink.expressad.videocommon.b.c.this;
                com.anythink.expressad.videocommon.b.c.a(cVar4, cVar4.J, com.anythink.expressad.videocommon.b.c.this.u);
                return;
            }
            if (i == 5) {
                com.anythink.expressad.videocommon.b.c.this.h();
            } else if (i == 10010 && message.obj != null) {
                com.anythink.expressad.videocommon.b.c.s();
            }
        }
    }

    /* renamed from: com.anythink.expressad.videocommon.b.c$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.core.common.res.a.a.AbstractC0171a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.core.common.res.a.a.AbstractC0171a
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.videocommon.b.c.a(com.anythink.expressad.videocommon.b.c.this, "errorCode:" + str + ",errorMsg:" + str2);
        }

        @Override // com.anythink.core.common.res.a.a.AbstractC0171a
        public final boolean a(int i, long j, long j2) {
            if (com.anythink.expressad.videocommon.b.c.this.H != j2) {
                com.anythink.expressad.videocommon.b.c.this.H = j2;
            }
            com.anythink.expressad.videocommon.b.c cVar = com.anythink.expressad.videocommon.b.c.this;
            com.anythink.expressad.videocommon.b.c.a(cVar, j, cVar.u);
            if (i >= com.anythink.expressad.videocommon.b.c.this.R) {
                com.anythink.expressad.videocommon.b.c.this.g();
                com.anythink.expressad.videocommon.b.c.this.q();
                return true;
            }
            if (com.anythink.expressad.videocommon.b.c.this.u != 2 && com.anythink.expressad.videocommon.b.c.this.u != 4) {
                return false;
            }
            int i2 = com.anythink.expressad.videocommon.b.c.this.u == 4 ? 3 : 2;
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = i2;
            com.anythink.expressad.videocommon.b.c.this.Y.sendMessage(obtain);
            return true;
        }
    }

    public c(android.content.Context context, com.anythink.expressad.foundation.d.c cVar, java.util.concurrent.ExecutorService executorService, java.lang.String str) {
        this.o = false;
        if (context == null && cVar == null) {
            return;
        }
        this.O = java.lang.System.currentTimeMillis();
        this.G = com.anythink.expressad.foundation.b.a.b().d();
        this.D = cVar;
        this.E = str;
        this.x = executorService;
        if (cVar != null) {
            this.I = cVar.S();
        }
        this.U = com.anythink.expressad.foundation.h.m.d(this.I);
        com.anythink.expressad.videocommon.b.a.a();
        this.L = com.anythink.expressad.videocommon.b.a.a(this.I);
        this.o = false;
        try {
            if (!android.text.TextUtils.isEmpty(this.I) && this.n != 3) {
                x();
            }
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    private void A() {
        try {
            if (this.z == null || this.A == null) {
                int i2 = com.anythink.expressad.reward.b.a.a;
                this.z = com.anythink.expressad.reward.b.a.class;
                this.A = com.anythink.expressad.reward.b.a.class.newInstance();
                this.z.getMethod("insertExcludeId", java.lang.String.class, com.anythink.expressad.foundation.d.c.class).invoke(this.A, this.E, this.D);
            }
            if (this.B == null || this.C == null) {
                java.lang.Class<?> cls = java.lang.Class.forName("com.anythink.expressad.atnative.controller.NativeController");
                this.B = cls;
                this.C = cls.newInstance();
                this.B.getMethod("insertExcludeId", java.lang.String.class, com.anythink.expressad.foundation.d.c.class).invoke(this.C, this.E, this.D);
            }
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    private static void B() {
    }

    private void C() {
        java.lang.String str;
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 10010;
        if (this.D == null || android.text.TextUtils.isEmpty(this.E) || android.text.TextUtils.isEmpty(this.D.Z()) || android.text.TextUtils.isEmpty(this.D.S())) {
            str = "";
        } else {
            str = "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + java.net.URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.q + "&cid=" + this.D.aZ() + "&type=" + this.u;
        }
        obtain.obj = str;
        this.Y.sendMessage(obtain);
    }

    private static void D() {
        com.anythink.expressad.foundation.b.a.b().d();
    }

    private java.lang.String E() {
        if (this.D == null || android.text.TextUtils.isEmpty(this.E) || android.text.TextUtils.isEmpty(this.D.Z()) || android.text.TextUtils.isEmpty(this.D.S())) {
            return "";
        }
        return "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + java.net.URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.q + "&cid=" + this.D.aZ() + "&type=" + this.u;
    }

    private static double a(double d2, double d3, int i2) {
        if (i2 >= 0) {
            return new java.math.BigDecimal(java.lang.Double.toString(d2)).divide(new java.math.BigDecimal(java.lang.Double.toString(d3)), i2, 4).doubleValue();
        }
        throw new java.lang.IllegalAccessException("Accuracy cannot be less than 0");
    }

    private void a(long j2, int i2) {
        this.J = j2;
        int i3 = this.R;
        if (100 * j2 >= i3 * this.H && !this.S && i2 != 4) {
            if (i3 == 100 && i2 != 5) {
                this.u = 5;
                return;
            }
            v();
        }
        if (this.F) {
            java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.videocommon.b.f> copyOnWriteArrayList = this.v;
            if (copyOnWriteArrayList != null) {
                java.util.Iterator<com.anythink.expressad.videocommon.b.f> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.videocommon.b.f next = it.next();
                    if (next != null) {
                        next.a(j2, i2);
                    }
                }
            }
            if (this.w != null) {
                if (this.u == 5 || this.u == 4 || this.u == 2 || this.u == 6) {
                    this.w.a(j2, i2);
                    this.w = null;
                }
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.videocommon.b.c cVar, long j2, int i2) {
        cVar.J = j2;
        int i3 = cVar.R;
        if (100 * j2 >= i3 * cVar.H && !cVar.S && i2 != 4) {
            if (i3 == 100 && i2 != 5) {
                cVar.u = 5;
                return;
            }
            cVar.v();
        }
        if (cVar.F) {
            java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.videocommon.b.f> copyOnWriteArrayList = cVar.v;
            if (copyOnWriteArrayList != null) {
                java.util.Iterator<com.anythink.expressad.videocommon.b.f> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.videocommon.b.f next = it.next();
                    if (next != null) {
                        next.a(j2, i2);
                    }
                }
            }
            if (cVar.w != null) {
                if (cVar.u == 5 || cVar.u == 4 || cVar.u == 2 || cVar.u == 6) {
                    cVar.w.a(j2, i2);
                    cVar.w = null;
                }
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.videocommon.b.c cVar, java.lang.String str) {
        cVar.K++;
        try {
            android.content.Context context = cVar.G;
            if (context != null) {
                java.lang.Object systemService = context.getSystemService("connectivity");
                android.net.ConnectivityManager connectivityManager = systemService instanceof android.net.ConnectivityManager ? (android.net.ConnectivityManager) systemService : null;
                if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                    if (!connectivityManager.getActiveNetworkInfo().isAvailable()) {
                        return;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (cVar.K <= 1) {
            cVar.Y.sendEmptyMessageDelayed(5, 2000L);
            return;
        }
        cVar.A();
        com.anythink.expressad.videocommon.d.b bVar = cVar.P;
        if (bVar != null) {
            bVar.a(str, cVar.I);
        }
        com.anythink.expressad.videocommon.d.b bVar2 = cVar.Q;
        if (bVar2 != null) {
            bVar2.a(str, cVar.I);
        }
        cVar.u = 4;
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 3;
        cVar.Y.sendMessage(obtain);
    }

    private void b(com.anythink.expressad.videocommon.b.f fVar) {
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.videocommon.b.f> copyOnWriteArrayList = this.v;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(fVar);
        }
    }

    private void b(com.anythink.expressad.videocommon.d.b bVar) {
        this.Q = bVar;
    }

    private void b(java.lang.String str) {
        com.anythink.expressad.videocommon.d.b bVar = this.P;
        if (bVar != null) {
            bVar.a(str, this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar2 = this.Q;
        if (bVar2 != null) {
            bVar2.a(str, this.I);
        }
        this.u = 4;
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 3;
        this.Y.sendMessage(obtain);
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private void c(java.lang.String str) {
        this.K++;
        try {
            android.content.Context context = this.G;
            if (context != null) {
                java.lang.Object systemService = context.getSystemService("connectivity");
                android.net.ConnectivityManager connectivityManager = systemService instanceof android.net.ConnectivityManager ? (android.net.ConnectivityManager) systemService : null;
                if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                    if (!connectivityManager.getActiveNetworkInfo().isAvailable()) {
                        return;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (this.K <= 1) {
            this.Y.sendEmptyMessageDelayed(5, 2000L);
            return;
        }
        A();
        com.anythink.expressad.videocommon.d.b bVar = this.P;
        if (bVar != null) {
            bVar.a(str, this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar2 = this.Q;
        if (bVar2 != null) {
            bVar2.a(str, this.I);
        }
        this.u = 4;
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 3;
        this.Y.sendMessage(obtain);
    }

    public static /* synthetic */ boolean d(com.anythink.expressad.videocommon.b.c cVar) {
        cVar.g = false;
        return false;
    }

    public static /* synthetic */ void s() {
        com.anythink.expressad.foundation.b.a.b().d();
    }

    private void t() {
        try {
            if (!android.text.TextUtils.isEmpty(this.I) && this.n != 3) {
                x();
            }
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    private void u() {
        if (this.c == null) {
            com.anythink.expressad.videocommon.b.b bVar = new com.anythink.expressad.videocommon.b.b(this.I, this.R, this.W);
            this.c = bVar;
            bVar.a(new com.anythink.expressad.videocommon.b.c.AnonymousClass3());
        }
    }

    private void v() {
        if (this.S) {
            return;
        }
        this.S = true;
        com.anythink.expressad.videocommon.d.b bVar = this.P;
        if (bVar != null) {
            bVar.a(this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar2 = this.Q;
        if (bVar2 != null) {
            bVar2.a(this.I);
        }
    }

    private boolean w() {
        return this.F;
    }

    private void x() {
        com.anythink.core.common.a.j a2;
        com.anythink.expressad.videocommon.b.a.a();
        this.L = com.anythink.expressad.videocommon.b.a.a(this.I);
        java.io.File file = new java.io.File(this.L);
        if (file.length() > 0) {
            this.J = file.length();
        } else {
            this.J = 0L;
        }
        if (this.H != 0 || (a2 = com.anythink.core.common.a.k.a().a(this.I)) == null) {
            return;
        }
        this.H = a2.d();
    }

    private com.anythink.expressad.videocommon.b.f y() {
        return this.X;
    }

    private static void z() {
    }

    public final java.lang.String a() {
        return this.I;
    }

    public final void a(int i2) {
        this.n = i2;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.D = cVar;
    }

    public final void a(com.anythink.expressad.videocommon.b.f fVar) {
        this.w = fVar;
    }

    public final void a(com.anythink.expressad.videocommon.d.b bVar) {
        this.P = bVar;
    }

    public final void a(java.lang.String str) {
        this.r = str;
    }

    public final void a(boolean z) {
        if (!z) {
            this.o = false;
        }
        this.T = z;
    }

    public final void b(int i2) {
        this.q = i2;
    }

    public final void b(boolean z) {
        this.N = z;
    }

    public final boolean b() {
        return this.T;
    }

    public final long c() {
        return this.O;
    }

    public final void c(int i2) {
        this.W = i2;
    }

    public final void d(int i2) {
        this.R = i2;
    }

    public final boolean d() {
        return this.N;
    }

    public final java.lang.String e() {
        return this.L;
    }

    public final void e(int i2) {
        this.Z = i2;
    }

    public final long f() {
        return this.H;
    }

    public final void g() {
        android.os.Message obtain = android.os.Message.obtain();
        this.u = 5;
        obtain.what = 4;
        this.Y.sendMessage(obtain);
    }

    public final void h() {
        if (android.text.TextUtils.isEmpty(this.I)) {
            return;
        }
        if (this.u == 5) {
            v();
            return;
        }
        if (this.n == 3) {
            g();
            return;
        }
        if (this.R == 0) {
            g();
            return;
        }
        x();
        u();
        if (this.c != null) {
            this.u = 1;
            this.F = true;
            this.c.a();
        }
    }

    public final void i() {
        x();
        u();
        if (this.c != null) {
            this.u = 1;
            this.F = true;
            this.c.b();
        }
    }

    public final void j() {
        A();
        this.u = 4;
    }

    public final int k() {
        return this.u;
    }

    public final void l() {
        this.u = 0;
    }

    public final java.lang.String m() {
        if (this.n == 3) {
            return "";
        }
        java.io.File file = new java.io.File(this.L);
        try {
            return file.length() > 0 ? file.canRead() ? file.length() > 0 ? "" : "file length is 0 " : "file can not read " : "file is not exist ";
        } catch (java.lang.Throwable th) {
            java.lang.String message = th.getMessage();
            if (!com.anythink.expressad.a.a) {
                return message;
            }
            th.printStackTrace();
            return message;
        }
    }

    public final com.anythink.expressad.foundation.d.c n() {
        return this.D;
    }

    public final void o() {
        if (this.v != null) {
            this.v = null;
        }
    }

    public final long p() {
        return this.J;
    }

    public final void q() {
        java.lang.String str;
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 10010;
        if (this.D == null || android.text.TextUtils.isEmpty(this.E) || android.text.TextUtils.isEmpty(this.D.Z()) || android.text.TextUtils.isEmpty(this.D.S())) {
            str = "";
        } else {
            str = "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + java.net.URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.q + "&cid=" + this.D.aZ() + "&type=" + this.u;
        }
        obtain.obj = str;
        this.Y.sendMessage(obtain);
    }

    public final java.lang.String r() {
        return this.r;
    }
}
