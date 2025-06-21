package cn.fly.verify;

/* loaded from: classes.dex */
public class dx {
    private java.util.concurrent.ScheduledExecutorService a = java.util.concurrent.Executors.newScheduledThreadPool(0);

    /* renamed from: cn.fly.verify.dx$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass1(boolean[] zArr, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = zArr;
            this.b = countDownLatch;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            cn.fly.verify.ed.a().a("[PRE] ckDb: " + bVar.E() + ", db: " + bVar.v() + ", iRt: " + bVar.a(), new java.lang.Object[0]);
            if (bVar.E() || bVar.v() || bVar.a()) {
                this.a[0] = true;
            }
            this.b.countDown();
        }
    }

    /* renamed from: cn.fly.verify.dx$2, reason: invalid class name */
    public class AnonymousClass2 extends cn.fly.verify.fy {
        public AnonymousClass2() {
        }

        @Override // cn.fly.verify.fy
        public void a() {
            try {
                java.util.ArrayList<cn.fly.verify.fa<java.lang.String>> arrayList = new java.util.ArrayList<>();
                arrayList.add(new cn.fly.verify.fa<>(cn.fly.verify.ba.a("004lifk"), "1"));
                arrayList.add(new cn.fly.verify.fa<>(cn.fly.verify.ba.a("006fll5fn%hSfm"), cn.fly.verify.dv.a()));
                arrayList.add(new cn.fly.verify.fa<>(cn.fly.verify.ba.a("006Thjfmhjff.h+fl"), java.lang.String.valueOf(cn.fly.verify.fh.d.g())));
                arrayList.add(new cn.fly.verify.fa<>(cn.fly.verify.ba.a("007'ghVfek>gfflfm"), cn.fly.verify.fh.d.k()));
                arrayList.add(new cn.fly.verify.fa<>(cn.fly.verify.ba.a("005=fhgffeXhi"), cn.fly.verify.fh.d.j()));
                arrayList.add(new cn.fly.verify.fa<>(cn.fly.verify.ba.a("006flllDfngg"), cn.fly.verify.fh.d.c()));
                java.lang.String b = cn.fly.verify.bl.a().b("key_ched_od", (java.lang.String) null);
                if (!android.text.TextUtils.isEmpty(b)) {
                    try {
                        arrayList.add(new cn.fly.verify.fa<>(cn.fly.verify.ba.a("004Cfhgffkfe"), android.util.Base64.encodeToString(cn.fly.verify.fi.a(cn.fly.verify.fi.b(cn.fly.verify.fh.d.k()), b), 2)));
                    } catch (java.lang.Throwable th) {
                        cn.fly.verify.ed.a().a(th);
                    }
                }
                java.lang.String b2 = cn.fly.verify.df.b();
                if (!android.text.TextUtils.isEmpty(b2)) {
                    arrayList.add(new cn.fly.verify.fa<>(cn.fly.verify.ba.a("004(fefifkfe"), b2));
                }
                cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
                aVar.b = 5000;
                aVar.a = 3000;
                java.lang.String a = new cn.fly.verify.fc().a(cn.fly.verify.dj.a().a("gcfg") + cn.fly.verify.ba.a("007nlfnLggVe8gh"), arrayList, (java.util.ArrayList<cn.fly.verify.fa<java.lang.String>>) null, aVar);
                java.util.HashMap a2 = cn.fly.verify.fm.a(a);
                if (!com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(java.lang.String.valueOf(a2.get(cn.fly.verify.ba.a("004e7gffeFh"))))) {
                    throw new java.lang.Throwable("response is illegal: " + a);
                }
                java.util.HashMap hashMap = (java.util.HashMap) a2.get(cn.fly.verify.ba.a("004Zfe)fkf"));
                if (hashMap == null || hashMap.isEmpty()) {
                    throw new java.lang.Throwable("data is illegal: " + hashMap);
                }
                cn.fly.verify.bl.a().a(java.lang.System.currentTimeMillis());
                cn.fly.verify.bl.a().a(0);
                java.lang.Object obj = hashMap.get("wd");
                int intValue = obj != null ? ((java.lang.Integer) obj).intValue() : 0;
                java.lang.Object obj2 = hashMap.get("wf");
                int intValue2 = obj2 != null ? ((java.lang.Integer) obj2).intValue() : 0;
                java.lang.Object obj3 = hashMap.get("ds");
                boolean booleanValue = obj3 != null ? ((java.lang.Boolean) obj3).booleanValue() : false;
                cn.fly.verify.bl.a().c(intValue);
                cn.fly.verify.bl.a().e(intValue2);
                cn.fly.verify.bl.a().a(booleanValue);
                if (booleanValue) {
                    cn.fly.verify.ed.a().a("[PRE] ds", new java.lang.Object[0]);
                    cn.fly.verify.dx.this.g();
                }
            } catch (java.lang.Throwable th2) {
                cn.fly.verify.ed.a().a(th2);
            }
        }
    }

    private long a(long j) {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - j;
            if (currentTimeMillis > 0) {
                return ((currentTimeMillis / 1000) / com.anythink.expressad.d.a.b.P) / 24;
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        return 0L;
    }

    private void b(long j) {
        try {
            cn.fly.verify.dx.AnonymousClass2 anonymousClass2 = new cn.fly.verify.dx.AnonymousClass2();
            cn.fly.verify.ed.a().a("[PRE] dy: " + j, new java.lang.Object[0]);
            this.a.schedule(anonymousClass2, j, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    private boolean c() {
        boolean[] zArr = {false};
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).v().F().a().a(new cn.fly.verify.dx.AnonymousClass1(zArr, countDownLatch));
        try {
            countDownLatch.await(300L, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.Throwable unused) {
        }
        return zArr[0] || e() || d() || f();
    }

    private boolean d() {
        java.lang.String k = cn.fly.verify.fh.d.k();
        java.lang.String l = cn.fly.verify.fh.d.l();
        if (android.text.TextUtils.isEmpty(k) || !k.toLowerCase().contains(cn.fly.verify.ba.a("006UgggfgfggJih"))) {
            return !android.text.TextUtils.isEmpty(l) && l.toLowerCase().contains(cn.fly.verify.ba.a("006<gggfgfgg ih"));
        }
        return true;
    }

    private boolean e() {
        try {
            return java.lang.Class.forName(cn.fly.verify.ax.g().getPackageName() + cn.fly.verify.ba.a("012-hfhkfifkJi8feimgfZg7ghfkgg")).getField(cn.fly.verify.ba.a("005Bhmijhkgikf")).getBoolean(null);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private boolean f() {
        try {
            cn.fly.verify.ax.g().getClassLoader().loadClass(cn.fly.verify.ba.a("021ihf^fn efgfGflfmhfhe_hfJfnimDfgf>flfm"));
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            java.util.concurrent.CountDownLatch g = cn.fly.verify.dy.g();
            cn.fly.verify.ed.a().a(cn.fly.verify.fh.d.b() ? "[PRE] main" : "[PRE] sub", new java.lang.Object[0]);
            cn.fly.verify.bo.h();
            cn.fly.verify.dy.a(g);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    private int h() {
        return new java.security.SecureRandom().nextInt(61) + 270;
    }

    private int i() {
        try {
            int b = cn.fly.verify.bl.a().b(Integer.MIN_VALUE);
            if (b != Integer.MIN_VALUE) {
                return b;
            }
            return 45;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return 45;
        }
    }

    private int j() {
        try {
            int d = cn.fly.verify.bl.a().d(Integer.MIN_VALUE);
            if (d != Integer.MIN_VALUE) {
                return d;
            }
            return 2;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return 2;
        }
    }

    private boolean k() {
        try {
            int b = cn.fly.verify.bl.a().b(Integer.MIN_VALUE);
            int d = cn.fly.verify.bl.a().d(Integer.MIN_VALUE);
            return (b == Integer.MIN_VALUE || b >= 0) && (d == Integer.MIN_VALUE || d >= 0);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return false;
        }
    }

    public void a() {
        try {
            cn.fly.verify.dy.j();
            if (!k()) {
                cn.fly.verify.ed.a().a("[PRE] esc", new java.lang.Object[0]);
                return;
            }
            cn.fly.verify.ed.a().a("[PRE] mk", new java.lang.Object[0]);
            if (cn.fly.verify.bl.a().k() == 0) {
                cn.fly.verify.bl.a().a(java.lang.System.currentTimeMillis());
            }
            cn.fly.verify.bl.a().a(cn.fly.verify.bl.a().l() + 1);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    public void b() {
        try {
            if (k()) {
                cn.fly.verify.ed.a().a("[PRE] try", new java.lang.Object[0]);
                boolean z = true;
                boolean z2 = a(cn.fly.verify.bl.a().k()) >= ((long) i());
                if (cn.fly.verify.bl.a().l() < j()) {
                    z = false;
                }
                cn.fly.verify.eh.a(cn.fly.verify.ax.g()).b();
                boolean m = cn.fly.verify.bl.a().m();
                boolean c = c();
                cn.fly.verify.ed.a().a("[PRE] dCdt: " + z2 + ", ltCdt: " + z + ", isDng: " + c + ", isDs: " + m, new java.lang.Object[0]);
                if (z2 && z && !c) {
                    b(h());
                } else if (m) {
                    g();
                }
            } else {
                cn.fly.verify.ed.a().a("[PRE] esc", new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }
}
