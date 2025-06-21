package cn.fly.verify;

/* loaded from: classes.dex */
public class dy {
    private static volatile boolean a = true;
    private static volatile java.lang.String f;
    private static java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(-1);
    private static java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.util.concurrent.atomic.AtomicBoolean d = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.util.concurrent.atomic.AtomicBoolean g = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static cn.fly.verify.dx e = new cn.fly.verify.dx();

    /* renamed from: cn.fly.verify.dy$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.fy {
        final /* synthetic */ boolean a;

        public AnonymousClass1(boolean z) {
            this.a = z;
        }

        @Override // cn.fly.verify.fy
        public void a() {
            cn.fly.verify.er.b.set(java.lang.Boolean.TRUE);
            cn.fly.verify.eq.a();
            if (!android.text.TextUtils.isEmpty("M-")) {
                java.lang.Thread.currentThread().setName("M-" + cn.fly.verify.ds.b("004)fkhjgjge"));
            }
            boolean b = cn.fly.verify.bl.b();
            cn.fly.verify.ed.a().a("[CPT] ck-sp: " + b, new java.lang.Object[0]);
            int b2 = b ? cn.fly.verify.bl.a().b(cn.fly.verify.bl.e, -1) : -1;
            if (!b) {
                boolean b3 = cn.fly.verify.bl.a.b();
                cn.fly.verify.ed.a().a("[CPT] ck-spc: " + b3, new java.lang.Object[0]);
                if (b3) {
                    b2 = cn.fly.verify.bl.a.a().a(cn.fly.verify.bl.e, -1);
                }
            }
            if (cn.fly.verify.dy.b.get() == -1) {
                cn.fly.verify.dy.b.set(b2);
            }
            if (cn.fly.verify.dy.b.get() == 1) {
                cn.fly.verify.dy.b(true, this.a);
            } else {
                cn.fly.verify.dy.b(false, this.a);
            }
            cn.fly.verify.eu a = cn.fly.verify.ed.a();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.a ? cn.fly.verify.ds.b("002=ci1e") : "");
            sb.append("init cfg over. py ");
            sb.append(cn.fly.verify.dy.b.get());
            a.a(sb.toString(), new java.lang.Object[0]);
            cn.fly.verify.er.b.set(java.lang.Boolean.FALSE);
        }
    }

    /* renamed from: cn.fly.verify.dy$2, reason: invalid class name */
    public class AnonymousClass2 extends cn.fly.verify.fz {
        final /* synthetic */ java.util.concurrent.CountDownLatch a;

        /* renamed from: cn.fly.verify.dy$2$1, reason: invalid class name */
        public class AnonymousClass1 implements cn.fly.verify.dp {
            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.dp
            public boolean a(cn.fly.verify.fj fjVar) {
                cn.fly.verify.ed.a().a("g lk pd: " + android.os.Process.myPid() + ", proc st", new java.lang.Object[0]);
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                cn.fly.verify.bl.u();
                cn.fly.verify.bo.a(cn.fly.verify.dy.AnonymousClass2.this.a);
                cn.fly.verify.ed.a().a("g lk pd: " + android.os.Process.myPid() + ", proc ed, dur: " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + ", release: y", new java.lang.Object[0]);
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch) {
            super(str);
            this.a = countDownLatch;
        }

        @Override // cn.fly.verify.fz
        public void a() {
            cn.fly.verify.er.b.set(java.lang.Boolean.TRUE);
            cn.fly.verify.ed.a().a("g lk st: " + android.os.Process.myPid(), new java.lang.Object[0]);
            boolean a = cn.fly.verify.dq.a(cn.fly.verify.dq.a(cn.fly.verify.dq.g), new cn.fly.verify.dy.AnonymousClass2.AnonymousClass1());
            cn.fly.verify.ed.a().a("g lk res: " + a + android.os.Process.myPid(), new java.lang.Object[0]);
            cn.fly.verify.er.b.set(java.lang.Boolean.FALSE);
        }
    }

    /* renamed from: cn.fly.verify.dy$3, reason: invalid class name */
    public class AnonymousClass3 implements cn.fly.verify.dl {
        @Override // cn.fly.verify.dl
        public void a(boolean z, boolean z2, long j) {
            if (z) {
                cn.fly.verify.ed.a().a("fg.", new java.lang.Object[0]);
                boolean unused = cn.fly.verify.dy.a = true;
            } else {
                cn.fly.verify.ed.a().a("bg.", new java.lang.Object[0]);
                boolean unused2 = cn.fly.verify.dy.a = false;
            }
        }
    }

    /* renamed from: cn.fly.verify.dy$4, reason: invalid class name */
    public class AnonymousClass4 extends cn.fly.verify.fz {
        final /* synthetic */ boolean a;

        /* renamed from: cn.fly.verify.dy$4$1, reason: invalid class name */
        public class AnonymousClass1 implements cn.fly.verify.fh.a {
            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.fh.a
            public void a(cn.fly.verify.fh.b bVar) {
                try {
                    cn.fly.verify.dy.b(cn.fly.verify.dy.AnonymousClass4.this.a, bVar.g());
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                    try {
                        cn.fly.verify.dy.b(cn.fly.verify.dy.AnonymousClass4.this.a, bVar.g());
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.ed.a().a(th2);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(java.lang.String str, boolean z) {
            super(str);
            this.a = z;
        }

        @Override // cn.fly.verify.fz
        public void a() {
            int e = cn.fly.verify.dy.e();
            cn.fly.verify.bl.a().a(cn.fly.verify.bl.e, this.a ? 1 : 0);
            if (!this.a || e == 1) {
                return;
            }
            java.util.concurrent.CountDownLatch g = cn.fly.verify.dy.g();
            cn.fly.verify.ed.a().a(cn.fly.verify.fh.d.b() ? "main" : "sub", new java.lang.Object[0]);
            cn.fly.verify.dy.a(g);
            cn.fly.verify.fh.a(cn.fly.verify.ax.g()).g().a(new cn.fly.verify.dy.AnonymousClass4.AnonymousClass1());
        }
    }

    public static void a(java.util.concurrent.CountDownLatch countDownLatch) {
        if (c.compareAndSet(false, true)) {
            if (cn.fly.verify.bl.a().t() == 0) {
                cn.fly.verify.bl.a().b(java.lang.System.currentTimeMillis());
            }
            cn.fly.verify.ds.a(cn.fly.verify.ax.g());
            l();
            m();
            cn.fly.verify.bk.a();
            cn.fly.verify.dj.a().b();
            cn.fly.verify.dr.a().b();
            new cn.fly.verify.dy.AnonymousClass2("PY-C", countDownLatch).start();
        }
    }

    public static void a(boolean z) {
        cn.fly.verify.ea.c.execute(new cn.fly.verify.dy.AnonymousClass1(z));
    }

    public static boolean a() {
        return a;
    }

    public static void b(boolean z) {
        b.set(z ? 1 : 0);
        cn.fly.verify.ed.a().a("submit py: " + z, new java.lang.Object[0]);
        new cn.fly.verify.dy.AnonymousClass4(cn.fly.verify.ds.b("004]fkhjgjgd"), z).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, java.lang.String str) throws java.lang.Throwable {
        java.util.HashMap<java.lang.String, java.lang.Object> a2 = cn.fly.verify.dv.a(str);
        a2.put(cn.fly.verify.ds.b("009Cchegdkddci+eeYfkPi"), java.lang.String.valueOf(z));
        java.lang.String str2 = cn.fly.verify.dj.a().a("gclg") + cn.fly.verify.ds.b("036kiJcichccUcb9cj@ki<dc5f.ch^bFcj6kc$cf;hg8dccichfb<ch+chdc$dk^eg=hchZcfeg");
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(cn.fly.verify.ds.b("003,ck;e[cj"), cn.fly.verify.dv.a());
        hashMap.put(cn.fly.verify.ds.b("0136dfegUe3cigjdhcb!edhVch(h@cj"), cn.fly.verify.bk.f());
        java.lang.String a3 = new cn.fly.verify.fc().a(str2, a2, hashMap);
        cn.fly.verify.ed.a().a("RS sp: " + a3, new java.lang.Object[0]);
        java.util.HashMap a4 = cn.fly.verify.fm.a(a3);
        if (a4 == null) {
            throw new java.lang.Throwable("RS is illegal: " + a3);
        }
        if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(java.lang.String.valueOf(a4.get(cn.fly.verify.ds.b("004bPdccb.e"))))) {
            return;
        }
        throw new java.lang.Throwable("RS code is not 200: " + a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, boolean z2) {
        if (!z2) {
            e.a();
        }
        if (android.text.TextUtils.isEmpty(cn.fly.verify.ds.a)) {
            java.lang.String n = cn.fly.verify.bl.a().n();
            if (android.text.TextUtils.isEmpty(n)) {
                n = i();
            }
            if (!android.text.TextUtils.isEmpty(n)) {
                cn.fly.verify.ds.c = n;
                cn.fly.verify.bl.a().d(n);
            }
        } else {
            cn.fly.verify.ds.c = cn.fly.verify.ds.a;
            cn.fly.verify.bl.a().d(cn.fly.verify.ds.a);
        }
        if (android.text.TextUtils.isEmpty(cn.fly.verify.ds.b)) {
            java.lang.String o = cn.fly.verify.bl.a().o();
            if (!android.text.TextUtils.isEmpty(o)) {
                cn.fly.verify.ds.d = o;
            }
        } else {
            cn.fly.verify.ds.d = cn.fly.verify.ds.b;
            cn.fly.verify.bl.a().e(cn.fly.verify.ds.b);
        }
        if (!z) {
            if (z2) {
                return;
            }
            e.b();
            return;
        }
        j();
        java.util.concurrent.CountDownLatch g2 = g();
        cn.fly.verify.ed.a().a(cn.fly.verify.fh.d.b() ? "main" : "sub", new java.lang.Object[0]);
        if (!z2) {
            a(g2);
        } else {
            cn.fly.verify.bk.a();
            cn.fly.verify.bo.g();
        }
    }

    public static boolean b() {
        return b.get() == 1;
    }

    public static int c() {
        cn.fly.verify.ed.a().a("get py grtd status mem: " + b.get(), new java.lang.Object[0]);
        return b.get();
    }

    public static int d() {
        int c2 = c();
        return c2 != -1 ? c2 : e();
    }

    public static int e() {
        int b2 = cn.fly.verify.bl.b() ? cn.fly.verify.bl.a().b(cn.fly.verify.bl.e, -1) : -1;
        cn.fly.verify.ed.a().a("get py grtd status cac: " + b2, new java.lang.Object[0]);
        return b2;
    }

    public static java.lang.String f() {
        return "ecpgnjvr<1fxsowakt{mzqihWPKUVCN0dy2uDJFH|LYZQGTXERO:43l87;/6MI>\"@A?9[\\)_]5=.(S'~盺朼-";
    }

    public static java.util.concurrent.CountDownLatch g() {
        return !d.getAndSet(true) ? cn.fly.verify.eh.a(cn.fly.verify.ax.g()).a() : new java.util.concurrent.CountDownLatch(0);
    }

    public static boolean h() {
        java.lang.String a2 = cn.fly.verify.dv.a();
        return (android.text.TextUtils.isEmpty(a2) || android.text.TextUtils.isEmpty(a2.trim()) || android.text.TextUtils.equals(a2, i())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041 A[Catch: all -> 0x0074, TryCatch #0 {all -> 0x0074, blocks: (B:7:0x0006, B:9:0x0018, B:11:0x002b, B:12:0x003b, B:14:0x0041, B:16:0x0052, B:18:0x0060), top: B:6:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String i() {
        java.lang.String str;
        if (f == null) {
            try {
                java.lang.String absolutePath = cn.fly.verify.ax.g().getFilesDir().getAbsolutePath();
                if (!android.text.TextUtils.isEmpty(absolutePath)) {
                    java.lang.String substring = absolutePath.substring(0, absolutePath.lastIndexOf(cn.fly.verify.ds.b("001k")));
                    if (!android.text.TextUtils.isEmpty(substring)) {
                        str = substring.substring(substring.lastIndexOf(cn.fly.verify.ds.b("001k")) + 1);
                        if (!android.text.TextUtils.isEmpty(str)) {
                            java.lang.String f2 = cn.fly.verify.fi.f(str.getBytes("utf-8"));
                            if (!android.text.TextUtils.isEmpty(f2)) {
                                java.lang.String b2 = cn.fly.verify.fi.b(f2.getBytes());
                                if (!android.text.TextUtils.isEmpty(b2)) {
                                    f = "s" + b2;
                                }
                            }
                        }
                    }
                }
                str = null;
                if (!android.text.TextUtils.isEmpty(str)) {
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        return f;
    }

    public static void j() {
        if (g.compareAndSet(false, true)) {
            boolean b2 = cn.fly.verify.bl.b();
            boolean b3 = cn.fly.verify.bl.a.b();
            cn.fly.verify.ed.a().a("[CPT] cpt, nest: " + b2 + ", oest: " + b3, new java.lang.Object[0]);
            if (b2 || !b3) {
                return;
            }
            try {
                java.io.File parentFile = cn.fly.verify.bl.c().getParentFile();
                if (parentFile != null) {
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (parentFile.exists()) {
                        cn.fly.verify.bl.a().a(cn.fly.verify.bl.a.a().d());
                        cn.fly.verify.ed.a().a("[CPT] cpt over: ", new java.lang.Object[0]);
                        cn.fly.verify.bl.a().a((java.util.ArrayList<java.lang.String>) null);
                    }
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().c(th);
            }
        }
    }

    private static void l() {
        try {
            java.nio.channels.ServerSocketChannel open = java.nio.channels.ServerSocketChannel.open();
            open.configureBlocking(false);
            try {
                open.socket().bind(new java.net.InetSocketAddress(37926));
                cn.fly.verify.dr.a = false;
                open.close();
            } catch (java.lang.Throwable unused) {
                cn.fly.verify.dr.a = true;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    private static void m() {
        cn.fly.verify.ba.a().a(new cn.fly.verify.dy.AnonymousClass3());
    }
}
