package cn.fly.verify;

/* loaded from: classes31.dex */
public class bo {
    private static java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.util.concurrent.atomic.AtomicBoolean d = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static volatile java.util.HashMap<java.lang.String, java.lang.Object> e = null;
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> f = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> g = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.CountDownLatch h = new java.util.concurrent.CountDownLatch(1);
    private static java.util.concurrent.CountDownLatch i = new java.util.concurrent.CountDownLatch(1);
    public static volatile boolean a = false;
    private static volatile boolean j = false;
    private static final java.util.concurrent.atomic.AtomicBoolean k = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static volatile boolean l = false;

    /* renamed from: cn.fly.verify.bo$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends cn.fly.verify.fz {
        final /* synthetic */ java.lang.String a;

        /* renamed from: cn.fly.verify.bo$1$1, reason: invalid class name and collision with other inner class name */
        public class C00061 implements cn.fly.verify.dp {
            public C00061() {
            }

            @Override // cn.fly.verify.dp
            public boolean a(cn.fly.verify.fj fjVar) {
                synchronized (cn.fly.verify.bo.f) {
                    cn.fly.verify.bo.d(cn.fly.verify.bo.AnonymousClass1.this.a);
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, java.lang.String str2) {
            super(str);
            this.a = str2;
        }

        @Override // cn.fly.verify.fz
        public void a() {
            cn.fly.verify.dq.a(cn.fly.verify.dq.a(cn.fly.verify.dq.d), false, new cn.fly.verify.bo.AnonymousClass1.C00061());
        }
    }

    /* renamed from: cn.fly.verify.bo$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends cn.fly.verify.fz {
        final /* synthetic */ java.lang.String a;

        /* renamed from: cn.fly.verify.bo$2$1, reason: invalid class name */
        public class AnonymousClass1 implements cn.fly.verify.dp {
            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.dp
            public boolean a(cn.fly.verify.fj fjVar) {
                synchronized (cn.fly.verify.bo.g) {
                    cn.fly.verify.bo.e(cn.fly.verify.bo.AnonymousClass2.this.a);
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.String str, java.lang.String str2) {
            super(str);
            this.a = str2;
        }

        @Override // cn.fly.verify.fz
        public void a() {
            cn.fly.verify.dq.a(cn.fly.verify.dq.a(cn.fly.verify.dq.e), false, new cn.fly.verify.bo.AnonymousClass2.AnonymousClass1());
        }
    }

    /* renamed from: cn.fly.verify.bo$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 extends cn.fly.verify.fz {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ int d;

        /* renamed from: cn.fly.verify.bo$3$1, reason: invalid class name */
        public class AnonymousClass1 implements cn.fly.verify.dp {
            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.dp
            public boolean a(cn.fly.verify.fj fjVar) {
                boolean unused = cn.fly.verify.bo.j = true;
                cn.fly.verify.ed.a().a("b lk: " + android.os.Process.myPid() + ", proc st", new java.lang.Object[0]);
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                cn.fly.verify.bo.c(cn.fly.verify.bo.AnonymousClass3.this.b);
                cn.fly.verify.bo.AnonymousClass3 anonymousClass3 = cn.fly.verify.bo.AnonymousClass3.this;
                if (!anonymousClass3.a || anonymousClass3.c) {
                    cn.fly.verify.bo.b(anonymousClass3.d);
                }
                cn.fly.verify.ed.a().a("b lk: " + android.os.Process.myPid() + ", proc ed, dur: " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + ", release: n", new java.lang.Object[0]);
                android.os.Looper.prepare();
                android.os.Looper.loop();
                return true;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(java.lang.String str, boolean z, boolean z2, boolean z3, int i) {
            super(str);
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.d = i;
        }

        @Override // cn.fly.verify.fz
        public void a() {
            cn.fly.verify.ed.a().a("b enter:" + android.os.Process.myPid() + ", lbms: " + cn.fly.verify.bo.j + ", fc" + this.a + ", ol: " + this.b + ", gf: " + this.c + ", in: " + this.d, new java.lang.Object[0]);
            if (!cn.fly.verify.bo.j) {
                cn.fly.verify.ed.a().a("b lk st: " + android.os.Process.myPid(), new java.lang.Object[0]);
                cn.fly.verify.dq.a(cn.fly.verify.dq.a(cn.fly.verify.dq.f), new cn.fly.verify.bo.AnonymousClass3.AnonymousClass1());
                return;
            }
            cn.fly.verify.ed.a().a("b lked already: " + android.os.Process.myPid(), new java.lang.Object[0]);
            cn.fly.verify.bo.c(this.b);
            if (!this.a || this.c) {
                cn.fly.verify.bo.b(this.d);
            }
        }
    }

    /* renamed from: cn.fly.verify.bo$4, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass4 extends cn.fly.verify.fy {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;

        /* renamed from: cn.fly.verify.bo$4$1, reason: invalid class name */
        public class AnonymousClass1 extends cn.fly.verify.fv<java.util.HashMap<java.lang.String, java.lang.Object>> {
            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.fv
            public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
                try {
                    cn.fly.verify.bo.b(hashMap, cn.fly.verify.bo.AnonymousClass4.this.b);
                } finally {
                    cn.fly.verify.bo.d.set(false);
                }
            }
        }

        public AnonymousClass4(java.lang.String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // cn.fly.verify.fy
        public void a() {
            cn.fly.verify.er.b.set(java.lang.Boolean.TRUE);
            if (!android.text.TextUtils.isEmpty("M-")) {
                java.lang.Thread.currentThread().setName("M-" + this.a);
            }
            cn.fly.verify.bo.b(new cn.fly.verify.bo.AnonymousClass4.AnonymousClass1());
            cn.fly.verify.er.b.set(java.lang.Boolean.FALSE);
        }
    }

    /* renamed from: cn.fly.verify.bo$5, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass5 implements cn.fly.verify.fh.a {
        final /* synthetic */ cn.fly.verify.fv a;

        public AnonymousClass5(cn.fly.verify.fv fvVar) {
            this.a = fvVar;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            cn.fly.verify.er.b.set(java.lang.Boolean.TRUE);
            try {
                java.util.HashMap b = cn.fly.verify.bo.b(bVar);
                long j = 2;
                long j2 = 1;
                while (true) {
                    if (b != null && !b.isEmpty()) {
                        break;
                    }
                    try {
                        java.lang.Thread.sleep(1000 * j2);
                    } catch (java.lang.Throwable th) {
                        cn.fly.verify.ed.a().a(th);
                    }
                    b = cn.fly.verify.bo.b(bVar);
                    if (b == null || b.isEmpty()) {
                        if (j <= 0) {
                            break;
                        }
                        j--;
                        j2 *= 2;
                        if (j2 > 300) {
                            j2 = 8;
                        }
                    }
                }
                this.a.a(b);
            } catch (java.lang.Throwable th2) {
                cn.fly.verify.ed.a().a(th2);
                this.a.a(null);
            }
        }
    }

    /* renamed from: cn.fly.verify.bo$6, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass6 extends java.io.ByteArrayOutputStream {
        final /* synthetic */ byte[][] a;
        final /* synthetic */ int[] b;

        public AnonymousClass6(byte[][] bArr, int[] iArr) {
            this.a = bArr;
            this.b = iArr;
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            super.close();
            this.a[0] = ((java.io.ByteArrayOutputStream) this).buf;
            this.b[0] = ((java.io.ByteArrayOutputStream) this).count;
        }
    }

    private static cn.fly.verify.fy a(java.lang.String str, int i2) {
        return new cn.fly.verify.bo.AnonymousClass4(str, i2);
    }

    public static <T> T a(java.lang.String str, T t) {
        if (android.text.TextUtils.isEmpty(str) || e == null) {
            return t;
        }
        if (b(e)) {
            e.clear();
            e = new java.util.HashMap<>();
            c(2);
        }
        return (T) cn.fly.verify.fq.a(e.get(str), t);
    }

    private static <T> T a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.lang.String str, T t) {
        return (android.text.TextUtils.isEmpty(str) || b(hashMap) || !a(hashMap)) ? t : (T) cn.fly.verify.fq.a(hashMap.get(str), t);
    }

    private static void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2, java.util.HashMap<java.lang.String, java.lang.Object> hashMap3, java.util.HashMap<java.lang.String, java.lang.Object> hashMap4, java.util.HashMap<java.lang.String, java.lang.Object> hashMap5, java.lang.Integer num, java.util.concurrent.CountDownLatch countDownLatch) {
        if (num != null && num.intValue() == 2) {
            cn.fly.verify.er.b.set(java.lang.Boolean.FALSE);
            try {
                countDownLatch.await(3500L, java.util.concurrent.TimeUnit.MILLISECONDS);
                cn.fly.verify.ed.a().a("dhs wt geot.2 ovr", new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        boolean a2 = cn.fly.verify.dk.a().a(true);
        cn.fly.verify.dk.a().c().put(cn.fly.verify.dt.a("006fJdfdhdj[f+fh"), java.lang.Boolean.valueOf(a2));
        if (hashMap3 != null && hashMap3.size() > 0 && !a2) {
            cn.fly.verify.ed.a().a("dhs em dg", new java.lang.Object[0]);
            hashMap2.clear();
            hashMap2.putAll(hashMap);
            hashMap2.putAll(hashMap3);
            return;
        }
        if (hashMap4 == null || hashMap4.size() <= 0 || cn.fly.verify.dk.a().a(hashMap5)) {
            hashMap2.remove(cn.fly.verify.dt.a("002SeeSj"));
            hashMap2.remove(cn.fly.verify.dt.a("002fTdf"));
        } else {
            cn.fly.verify.ed.a().a("dhs gpe dg", new java.lang.Object[0]);
            hashMap2.clear();
            hashMap2.putAll(hashMap);
            hashMap2.putAll(hashMap4);
        }
    }

    private static void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, boolean z) {
        java.util.concurrent.CountDownLatch countDownLatch;
        e = new java.util.HashMap<>();
        if (hashMap != null) {
            e.putAll(hashMap);
        }
        try {
            if (z) {
                h.countDown();
                countDownLatch = i;
            } else {
                countDownLatch = h;
            }
            countDownLatch.countDown();
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.util.concurrent.CountDownLatch countDownLatch) {
        b(countDownLatch);
    }

    private static void a(boolean z, boolean z2, boolean z3, int i2) {
        new cn.fly.verify.bo.AnonymousClass3("PY-B" + i2, z, z2, z3, i2).start();
    }

    private static void a(java.lang.String... strArr) {
        java.io.File filesDir = cn.fly.verify.ax.g().getFilesDir();
        for (java.lang.String str : strArr) {
            try {
                cn.fly.verify.dw.a(new java.io.File(filesDir, str));
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
    }

    public static boolean a() {
        return ((java.lang.Integer) a(cn.fly.verify.dt.a("002i)ed"), 0)).intValue() == 0;
    }

    public static boolean a(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && a() && b() && ((java.lang.Integer) a(str, 0)).intValue() != 0;
    }

    private static boolean a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        return hashMap == null || ((java.lang.Integer) cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.dt.a("002iGed")), 0)).intValue() == 0;
    }

    public static <T> T b(java.lang.String str, T t) {
        if (android.text.TextUtils.isEmpty(str)) {
            return t;
        }
        return (T) a(e != null ? e : cn.fly.verify.fm.a(cn.fly.verify.bl.a().d()), str, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.HashMap<java.lang.String, java.lang.Object> b(cn.fly.verify.fh.b bVar) {
        try {
            java.lang.String c2 = cn.fly.verify.fh.d.c();
            java.lang.String a2 = cn.fly.verify.dv.a();
            java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
            hashMap.put(cn.fly.verify.dt.a("003Tdl_fYdk"), a2);
            hashMap.put(cn.fly.verify.dt.a("013$egfh-fVdjhkeidc^feiVdiOiYdk"), cn.fly.verify.bk.f());
            hashMap.put(cn.fly.verify.dt.a("004Rdfeddidc"), bVar.A());
            java.util.HashMap<java.lang.String, java.lang.Object> a3 = cn.fly.verify.dv.a(bVar.g());
            a3.put(cn.fly.verify.dt.a("002i=fh"), java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            int i2 = 1;
            a3.put("nbs", 1);
            int i3 = cn.fly.verify.ax.i();
            if (i3 != -1) {
                a3.put(cn.fly.verify.dt.a("009,difheleedj7ff(glDj"), java.lang.String.valueOf(i3 == 1));
            }
            java.lang.String a4 = cn.fly.verify.dt.a("002Cddhh");
            if (!cn.fly.verify.ax.c()) {
                i2 = -1;
            }
            a3.put(a4, java.lang.String.valueOf(i2));
            a3.put("ait", java.lang.Long.valueOf(cn.fly.verify.bl.a().t()));
            java.lang.String b2 = cn.fly.verify.df.b();
            if (!android.text.TextUtils.isEmpty(b2)) {
                a3.put(com.anythink.core.common.b.e.c, b2 + c2);
            }
            java.lang.String a5 = new cn.fly.verify.fc().a(cn.fly.verify.dj.a().a("gcfg") + "/v6/gcf", a3, hashMap);
            java.util.HashMap a6 = cn.fly.verify.fm.a(a5);
            if (a6.isEmpty()) {
                return null;
            }
            if (!com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(java.lang.String.valueOf(a6.get(cn.fly.verify.dt.a("006$fhJidi2dgfh"))))) {
                throw new java.lang.Throwable("RS is illegal: " + a5);
            }
            byte[] e2 = cn.fly.verify.fi.e((a2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + c2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + a6.get(cn.fly.verify.dt.a("009i[didf,fWfhQidEdf?j"))).getBytes("utf-8"));
            java.lang.String str = (java.lang.String) cn.fly.verify.fq.a(a6.get(cn.fly.verify.dt.a("002Mfh]c")));
            if (str == null) {
                throw new java.lang.Throwable("RS is illegal: " + a5);
            }
            java.lang.String str2 = new java.lang.String(cn.fly.verify.fi.b(e2, android.util.Base64.decode(str, 2)), "utf-8");
            cn.fly.verify.ed.a().a("sw: " + str2, new java.lang.Object[0]);
            java.util.HashMap<java.lang.String, java.lang.Object> a7 = cn.fly.verify.fm.a(str2);
            if (!a7.isEmpty()) {
                a7.put(cn.fly.verify.dt.a("010Tdc7f8dddi]cfUekdidfOf"), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
                cn.fly.verify.bl.a().c(cn.fly.verify.fm.a((java.util.HashMap) a7));
                return a7;
            }
            throw new java.lang.Throwable("RS is illegal: " + a5);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2) {
        cn.fly.verify.ed.a().a("b ob st", new java.lang.Object[0]);
        if (!a() || !b()) {
            if (i2 == 3 || cn.fly.verify.dy.b()) {
                o();
            }
            n();
            return;
        }
        java.lang.String str = (java.lang.String) a(cn.fly.verify.dt.a("003Hef%ec"), (java.lang.Object) null);
        if (android.text.TextUtils.isEmpty(str)) {
            if (i2 == 3 || cn.fly.verify.dy.b()) {
                o();
            }
            n();
        } else if (i2 == 3 || b.compareAndSet(false, true)) {
            new cn.fly.verify.bo.AnonymousClass1(cn.fly.verify.dt.a("003@fkikhk") + i2, str).start();
        }
        if (!a() || !b()) {
            p();
            m();
            return;
        }
        java.lang.String str2 = (java.lang.String) a(com.aliyun.common.log.struct.AliyunLogKey.KEY_SRC_BITRATE, (java.lang.Object) null);
        if (android.text.TextUtils.isEmpty(str2)) {
            m();
            p();
        } else if (i2 == 3 || c.compareAndSet(false, true)) {
            new cn.fly.verify.bo.AnonymousClass2("DS-" + i2, str2).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(cn.fly.verify.fv<java.util.HashMap<java.lang.String, java.lang.Object>> fvVar) {
        cn.fly.verify.er.b.set(java.lang.Boolean.TRUE);
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).g().B().a(new cn.fly.verify.bo.AnonymousClass5(fvVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, int i2) {
        if (hashMap == null) {
            java.util.HashMap<java.lang.String, java.lang.Object> a2 = cn.fly.verify.fm.a(cn.fly.verify.bl.a().e());
            if (!b(a2)) {
                hashMap = a2;
            }
            cn.fly.verify.bl.a().f();
        }
        java.util.concurrent.CountDownLatch c2 = (hashMap == null || hashMap.isEmpty()) ? null : c(hashMap);
        a(hashMap, true);
        cn.fly.verify.er.b.set(java.lang.Boolean.FALSE);
        if (!l) {
            q();
        }
        if (c2 == null) {
            c2 = cn.fly.verify.ei.a(cn.fly.verify.ax.g()).a();
        }
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            cn.fly.verify.ed.a().a("ge dhs_w cdl: " + c2, new java.lang.Object[0]);
            c2.await(3500L, java.util.concurrent.TimeUnit.MILLISECONDS);
            cn.fly.verify.ed.a().a("ge dhs_w end, dur: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        a(false, true, true, i2);
    }

    private static void b(java.util.concurrent.CountDownLatch countDownLatch) {
        java.util.HashMap a2 = cn.fly.verify.fm.a(cn.fly.verify.bl.a().d());
        if (b((java.util.HashMap<java.lang.String, java.lang.Object>) a2)) {
            cn.fly.verify.bl.a().b((java.lang.String) null);
            a2 = null;
        }
        if (a()) {
            a((java.util.HashMap<java.lang.String, java.lang.Object>) a2, false);
            if (a2 == null || a2.isEmpty()) {
                cn.fly.verify.ed.a().a("g ch: n", new java.lang.Object[0]);
                c(1);
                return;
            }
            cn.fly.verify.ed.a().a("g ch: y", new java.lang.Object[0]);
            boolean z = java.lang.System.currentTimeMillis() - cn.fly.verify.bl.a().b(cn.fly.verify.bl.m, 0L) < 2000;
            cn.fly.verify.ed.a().a("g ch fre: " + z, new java.lang.Object[0]);
            if (!z) {
                c(2);
            }
            if (countDownLatch != null) {
                try {
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    cn.fly.verify.ed.a().a("g dhs_w cdl: " + countDownLatch, new java.lang.Object[0]);
                    countDownLatch.await(3500L, java.util.concurrent.TimeUnit.MILLISECONDS);
                    cn.fly.verify.ed.a().a("g dhs_w end, dur: " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                }
            }
            a(true, false, z, 2);
        }
    }

    public static boolean b() {
        return ((java.lang.Integer) a(cn.fly.verify.dt.a("004cNedLee"), 0)).intValue() == 1;
    }

    private static boolean b(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        if (hashMap == null) {
            return false;
        }
        long longValue = ((java.lang.Long) cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.dt.a("010<dcNf>dddiOcfMekdidfWf")), 0L)).longValue();
        return longValue != 0 && android.os.SystemClock.elapsedRealtime() - longValue >= 86400000;
    }

    private static java.util.concurrent.CountDownLatch c(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        java.util.concurrent.CountDownLatch countDownLatch;
        java.lang.String str = (java.lang.String) cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.dt.a("002Mfhfh")), (java.lang.Object) null);
        java.util.concurrent.CountDownLatch a2 = cn.fly.verify.ei.a(cn.fly.verify.ax.g()).a(str);
        try {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = (java.util.HashMap) hashMap.get(cn.fly.verify.dt.a("002f4df"));
            java.lang.String str2 = (java.lang.String) cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.dt.a("002cSdc")), cn.fly.verify.dt.a("006!hehehfhfhfhf"));
            long longValue = ((java.lang.Long) cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.dt.a("004fcf(ec")), 5L)).longValue();
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap3 = (java.util.HashMap) hashMap.get(cn.fly.verify.dt.a("0022ee_j"));
            countDownLatch = a2;
            try {
                java.util.HashMap hashMap4 = (java.util.HashMap) hashMap.get(cn.fly.verify.dt.a("004Tee:jcXdc"));
                java.lang.Integer num = (java.lang.Integer) hashMap.get(cn.fly.verify.dt.a("004$ee4f ed]i"));
                java.util.HashMap hashMap5 = new java.util.HashMap();
                hashMap5.put(cn.fly.verify.dt.a("0025edRh"), hashMap.get(cn.fly.verify.dt.a("0025edRh")));
                hashMap5.put(cn.fly.verify.dt.a("0023fhfh"), str);
                hashMap5.put(cn.fly.verify.dt.a("002f)df"), hashMap2);
                hashMap5.put(cn.fly.verify.dt.a("002cFdc"), str2);
                hashMap5.put(cn.fly.verify.dt.a("004fcf:ec"), java.lang.Long.valueOf(longValue));
                hashMap5.put(cn.fly.verify.dt.a("004+eeWfGedIi"), num);
                hashMap5.put(cn.fly.verify.dt.a("003!djdidc"), cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.dt.a("003!djdidc")), (java.lang.Object) null));
                hashMap5.put(cn.fly.verify.dt.a("0033fhed*c"), hashMap.get(cn.fly.verify.dt.a("0033fhed*c")));
                hashMap5.put(cn.fly.verify.dt.a("003@fhdi.i"), hashMap.get(cn.fly.verify.dt.a("003@fhdi.i")));
                hashMap5.put("aps", hashMap.get("aps"));
                hashMap5.put(cn.fly.verify.dt.a("005(fh5g-di,iVfh"), hashMap.get(cn.fly.verify.dt.a("005(fh5g-di,iVfh")));
                hashMap5.put(cn.fly.verify.dt.a("003Ydj0ji"), hashMap.get(cn.fly.verify.dt.a("003Ydj0ji")));
                hashMap5.put("sti", hashMap.get("sti"));
                if ((hashMap2 != null && hashMap2.size() > 0 && !android.text.TextUtils.isEmpty(str2)) || (hashMap3 != null && hashMap3.size() > 0 && hashMap4 != null && hashMap4.size() > 0)) {
                    a(hashMap5, hashMap, hashMap2, hashMap3, hashMap4, num, countDownLatch);
                    cn.fly.verify.dk.a().a(hashMap, hashMap2, hashMap3);
                }
                hashMap.put(cn.fly.verify.dt.a("010!dc^fEdddi6cfIekdidf3f"), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
                cn.fly.verify.bl.a().b(cn.fly.verify.fm.a((java.util.HashMap) hashMap));
            } catch (java.lang.Throwable th) {
                th = th;
                cn.fly.verify.ed.a().a(th);
                return countDownLatch;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            countDownLatch = a2;
        }
        return countDownLatch;
    }

    private static void c(int i2) {
        if (d.compareAndSet(false, true)) {
            java.lang.String format = java.lang.String.format(cn.fly.verify.dt.a("005 gkflhkjkfh"), java.lang.Integer.valueOf(i2));
            if (i2 == 2) {
                cn.fly.verify.ea.c.execute(a(format, i2));
            } else {
                a(format, i2).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(boolean z) {
        if (b()) {
            cn.fly.verify.ed.a().a("b db st", new java.lang.Object[0]);
            cn.fly.verify.df.a((cn.fly.verify.bd) null);
            if (z) {
                cn.fly.verify.bg.a().b();
            }
        }
    }

    public static boolean c() {
        return (((java.lang.Integer) a(cn.fly.verify.dt.a("002eTdj"), 0)).intValue() == 1) || cn.fly.verify.dy.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v17, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r13v24, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v20, types: [cn.fly.verify.fc] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v7, types: [cn.fly.verify.bo$6, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v7, types: [cn.fly.verify.fc] */
    public static void d(java.lang.String str) {
        java.lang.String b2;
        java.io.File file;
        java.io.File file2 = null;
        try {
            cn.fly.verify.di.a().a(0);
            b2 = cn.fly.verify.dw.b(str);
            file = new java.io.File(cn.fly.verify.ax.g().getFilesDir(), cn.fly.verify.dt.a("003;fhEcc"));
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            if (!cn.fly.verify.dk.a().b()) {
                cn.fly.verify.di.a().a(18);
                n();
                return;
            }
            if (android.text.TextUtils.isEmpty(b2)) {
                cn.fly.verify.di.a().a(1);
                return;
            }
            try {
                if (c()) {
                    cn.fly.verify.di.a().a(2);
                    java.util.HashMap hashMap = (java.util.HashMap) new cn.fly.verify.fb(1024, "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9", "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1").a(cn.fly.verify.dv.d(), b2, false);
                    cn.fly.verify.di.a().a(3);
                    java.lang.String str2 = (java.lang.String) hashMap.get(cn.fly.verify.dt.a("002Wef-g"));
                    java.lang.String str3 = (java.lang.String) hashMap.get(com.anythink.expressad.d.a.b.dH);
                    java.lang.Boolean bool = (java.lang.Boolean) hashMap.get(cn.fly.verify.dt.a("002d.fh"));
                    boolean booleanValue = bool != null ? bool.booleanValue() : false;
                    java.lang.String str4 = (java.lang.String) hashMap.get(cn.fly.verify.dt.a("002d=dl"));
                    java.lang.String str5 = (java.lang.String) hashMap.get(cn.fly.verify.dt.a("002ce"));
                    java.lang.String str6 = (java.lang.String) hashMap.get(cn.fly.verify.dt.a("002Ref e"));
                    if (!android.text.TextUtils.isEmpty(str3) && !android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str4)) {
                        synchronized (cn.fly.verify.dq.i) {
                            f.clear();
                            f.put("h", str3);
                            f.put("k", str4);
                            f.put(cn.fly.verify.dt.a("002ce"), str5);
                            f.put(cn.fly.verify.dt.a("002Xef e"), str6);
                            java.lang.String a2 = cn.fly.verify.fb.a(str2);
                            if (booleanValue) {
                                cn.fly.verify.di.a().a(5);
                                java.io.File file3 = new java.io.File(file, cn.fly.verify.dt.a("008cVed0eNeffdfh!cc"));
                                if (!file3.exists() || !str3.equals(cn.fly.verify.fi.a(file3))) {
                                    cn.fly.verify.di.a().a(6);
                                    cn.fly.verify.fq.a(file);
                                    file.mkdirs();
                                    try {
                                        ?? fileOutputStream = new java.io.FileOutputStream(file3);
                                        try {
                                            new cn.fly.verify.fc().a(a2, fileOutputStream, null);
                                            cn.fly.verify.di.a().a(7);
                                            cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{fileOutputStream});
                                        } catch (java.lang.Throwable th2) {
                                            th = th2;
                                            file2 = fileOutputStream;
                                            cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{file2});
                                            throw th;
                                        }
                                    } catch (java.lang.Throwable th3) {
                                        th = th3;
                                    }
                                }
                            } else {
                                cn.fly.verify.di.a().a(8);
                                cn.fly.verify.fq.a(file);
                                byte[][] bArr = new byte[1][];
                                int[] iArr = new int[1];
                                try {
                                    ?? anonymousClass6 = new cn.fly.verify.bo.AnonymousClass6(bArr, iArr);
                                    try {
                                        new cn.fly.verify.fc().a(a2, anonymousClass6, null);
                                        cn.fly.verify.di.a().a(9);
                                        cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{anonymousClass6});
                                        f.put(cn.fly.verify.dt.a("001Zfe"), bArr[0]);
                                        f.put("s", java.lang.Integer.valueOf(iArr[0]));
                                    } catch (java.lang.Throwable th4) {
                                        th = th4;
                                        file2 = anonymousClass6;
                                        cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{file2});
                                        throw th;
                                    }
                                } catch (java.lang.Throwable th5) {
                                    th = th5;
                                }
                            }
                        }
                        o();
                    }
                    cn.fly.verify.di.a().a(4);
                    cn.fly.verify.fq.a(file);
                    o();
                }
            } finally {
                o();
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            file2 = file;
            cn.fly.verify.fq.a(file2);
            cn.fly.verify.di.a().a(2, th);
        }
    }

    public static boolean d() {
        return c();
    }

    public static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> e() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(java.lang.String str) {
        java.lang.Throwable th;
        java.io.File file;
        try {
            java.lang.String b2 = cn.fly.verify.dw.b(str);
            file = new java.io.File(cn.fly.verify.ax.g().getFilesDir(), cn.fly.verify.dt.a("003=fhfeAg"));
            try {
                java.io.File file2 = new java.io.File(cn.fly.verify.ax.g().getFilesDir(), cn.fly.verify.dt.a("007?fddjfh$g fedj+c"));
                if (!cn.fly.verify.dk.a().b()) {
                    cn.fly.verify.fq.a(file);
                    cn.fly.verify.fq.a(file2);
                } else {
                    if (!android.text.TextUtils.isEmpty(b2)) {
                        if (c()) {
                            java.util.HashMap<java.lang.String, java.lang.Object> d2 = cn.fly.verify.dv.d();
                            d2.put(cn.fly.verify.dt.a("007'ddZf=djfhdied8e"), java.lang.String.valueOf(cn.fly.verify.ce.a()));
                            java.util.ArrayList arrayList = (java.util.ArrayList) ((java.util.HashMap) new cn.fly.verify.fb(1024, "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9", "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1").b(false, cn.fly.verify.fb.a(), d2, b2, true)).get(cn.fly.verify.dt.a("004g=difh:i"));
                            if (arrayList != null && !arrayList.isEmpty()) {
                                synchronized (cn.fly.verify.dq.j) {
                                    g.clear();
                                    g.put(cn.fly.verify.dt.a("002gi"), arrayList);
                                }
                            }
                            cn.fly.verify.fq.a(file);
                            cn.fly.verify.fq.a(file2);
                            return;
                        }
                        return;
                    }
                    cn.fly.verify.fq.a(file);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                try {
                    cn.fly.verify.dh.a().a(9, -1, th, "-1");
                    cn.fly.verify.fq.a(file);
                } finally {
                    p();
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            file = null;
        }
    }

    public static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> f() {
        return g;
    }

    public static void g() {
        if (a()) {
            c(3);
        }
    }

    public static void h() {
        l = true;
    }

    private static void m() {
        a(cn.fly.verify.dt.a("003OfhfeNg"), cn.fly.verify.dt.a("007SfddjfhIg4fedj c"));
    }

    private static void n() {
        a(cn.fly.verify.dt.a("003Jfh6cc"), cn.fly.verify.dt.a("009ChcedfeYl+fddfdfRcc"), cn.fly.verify.dt.a("016Hhcedfe%lcReddfdf7l!dcfefh]l$dfdcKc"), cn.fly.verify.dt.a("005%hcdgfk=g$dd"), cn.fly.verify.dt.a("0129fddl[iIhfhhhdijhehiijfghd"));
    }

    private static void o() {
        java.lang.Object obj = cn.fly.verify.dq.i;
        synchronized (obj) {
            cn.fly.verify.di.a().a(10);
            obj.notifyAll();
        }
    }

    private static void p() {
        java.lang.Object obj = cn.fly.verify.dq.j;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    private static void q() {
        if (cn.fly.verify.dy.h()) {
            k.compareAndSet(false, true);
        }
    }
}
