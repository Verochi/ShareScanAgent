package com.getui.gtc.extension.distribution.gbd.e;

/* loaded from: classes22.dex */
public class b {
    private static final java.lang.String g = "GBD_Logic";
    private static com.getui.gtc.extension.distribution.gbd.e.b h;
    com.getui.gtc.extension.distribution.gbd.i.c b;
    com.getui.gtc.extension.distribution.gbd.i.b c;
    com.getui.gtc.extension.distribution.gbd.i.d d;
    com.getui.gtc.extension.distribution.gbd.k.a f;
    private com.getui.gtc.extension.distribution.gbd.i.a j;
    private final java.util.concurrent.atomic.AtomicBoolean k = new java.util.concurrent.atomic.AtomicBoolean(false);
    final java.util.concurrent.atomic.AtomicBoolean e = new java.util.concurrent.atomic.AtomicBoolean(false);
    private com.getui.gtc.extension.distribution.gbd.e.c i = new com.getui.gtc.extension.distribution.gbd.e.c();
    android.content.Context a = com.getui.gtc.extension.distribution.gbd.d.c.d;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.e.b.g, "add gbd config task result start");
                com.getui.gtc.extension.distribution.gbd.k.a.f e = com.getui.gtc.extension.distribution.gbd.k.a.f.e();
                if (e.b()) {
                    e.a(java.lang.System.currentTimeMillis());
                    e.a();
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.e.b.g, "add gbd config task result success");
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.e.b.g, th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.getui.gtc.extension.distribution.gbd.d.d.x) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.e.b.g, "start to get 24 new req.");
                    java.lang.String c = com.getui.gtc.extension.distribution.gbd.n.b.c();
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    boolean equalsIgnoreCase = com.getui.gtc.extension.distribution.gbd.d.g.o.equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.P);
                    boolean equalsIgnoreCase2 = "both".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.P);
                    if ((equalsIgnoreCase || equalsIgnoreCase2) && currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.v >= com.getui.gtc.extension.distribution.gbd.d.d.ab * 1000) {
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.d.h.v = currentTimeMillis;
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a(262, java.lang.String.valueOf(currentTimeMillis));
                        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(new com.getui.gtc.extension.distribution.gbd.g.a.a(c)));
                    }
                    com.getui.gtc.extension.distribution.gbd.e.b.a(com.getui.gtc.extension.distribution.gbd.e.b.this);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.e.b.g, th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.getui.gtc.extension.distribution.gbd.d.d.f) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.e.b.g, "11 early policy.");
                com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.e.e());
                com.getui.gtc.extension.distribution.gbd.e.b.this.f.a();
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {

        /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.e.b.g, "255 early policy. delay time = " + com.getui.gtc.extension.distribution.gbd.d.d.ds);
                com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.j.e());
                com.getui.gtc.extension.distribution.gbd.e.b.this.f.a();
            }
        }

        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.d.h.b.postDelayed(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass4.AnonymousClass1(), (com.getui.gtc.extension.distribution.gbd.d.d.ds * 1000) - 2000);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ long a;

        public AnonymousClass5(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.e.b.g, "gbd dc task period=" + this.a + "ms");
            com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.f.e());
            com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.e.e());
            com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.q.e());
            com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.k.e());
            com.getui.gtc.extension.distribution.gbd.k.a aVar = com.getui.gtc.extension.distribution.gbd.e.b.this.f;
            if (com.getui.gtc.extension.distribution.gbd.k.a.m.c == null) {
                com.getui.gtc.extension.distribution.gbd.k.a.m.c = new com.getui.gtc.extension.distribution.gbd.k.a.m();
            }
            aVar.a(com.getui.gtc.extension.distribution.gbd.k.a.m.c);
            com.getui.gtc.extension.distribution.gbd.k.a aVar2 = com.getui.gtc.extension.distribution.gbd.e.b.this.f;
            if (com.getui.gtc.extension.distribution.gbd.k.a.a.c == null) {
                com.getui.gtc.extension.distribution.gbd.k.a.a.c = new com.getui.gtc.extension.distribution.gbd.k.a.a();
            }
            aVar2.a(com.getui.gtc.extension.distribution.gbd.k.a.a.c);
            com.getui.gtc.extension.distribution.gbd.k.a aVar3 = com.getui.gtc.extension.distribution.gbd.e.b.this.f;
            if (com.getui.gtc.extension.distribution.gbd.k.a.o.c == null) {
                com.getui.gtc.extension.distribution.gbd.k.a.o.c = new com.getui.gtc.extension.distribution.gbd.k.a.o();
            }
            aVar3.a(com.getui.gtc.extension.distribution.gbd.k.a.o.c);
            com.getui.gtc.extension.distribution.gbd.k.a aVar4 = com.getui.gtc.extension.distribution.gbd.e.b.this.f;
            if (com.getui.gtc.extension.distribution.gbd.k.a.l.c == null) {
                com.getui.gtc.extension.distribution.gbd.k.a.l.c = new com.getui.gtc.extension.distribution.gbd.k.a.l();
            }
            aVar4.a(com.getui.gtc.extension.distribution.gbd.k.a.l.c);
            com.getui.gtc.extension.distribution.gbd.k.a aVar5 = com.getui.gtc.extension.distribution.gbd.e.b.this.f;
            if (com.getui.gtc.extension.distribution.gbd.k.a.h.c == null) {
                com.getui.gtc.extension.distribution.gbd.k.a.h.c = new com.getui.gtc.extension.distribution.gbd.k.a.h();
            }
            aVar5.a(com.getui.gtc.extension.distribution.gbd.k.a.h.c);
            com.getui.gtc.extension.distribution.gbd.k.a aVar6 = com.getui.gtc.extension.distribution.gbd.e.b.this.f;
            if (com.getui.gtc.extension.distribution.gbd.k.a.g.c == null) {
                com.getui.gtc.extension.distribution.gbd.k.a.g.c = new com.getui.gtc.extension.distribution.gbd.k.a.g();
            }
            aVar6.a(com.getui.gtc.extension.distribution.gbd.k.a.g.c);
            com.getui.gtc.extension.distribution.gbd.k.a aVar7 = com.getui.gtc.extension.distribution.gbd.e.b.this.f;
            if (com.getui.gtc.extension.distribution.gbd.k.a.i.c == null) {
                com.getui.gtc.extension.distribution.gbd.k.a.i.c = new com.getui.gtc.extension.distribution.gbd.k.a.i();
            }
            aVar7.a(com.getui.gtc.extension.distribution.gbd.k.a.i.c);
            com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.b.e());
            com.getui.gtc.extension.distribution.gbd.k.a aVar8 = com.getui.gtc.extension.distribution.gbd.e.b.this.f;
            if (com.getui.gtc.extension.distribution.gbd.k.a.p.c == null) {
                com.getui.gtc.extension.distribution.gbd.k.a.p.c = new com.getui.gtc.extension.distribution.gbd.k.a.p();
            }
            aVar8.a(com.getui.gtc.extension.distribution.gbd.k.a.p.c);
            com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.d.e());
            com.getui.gtc.extension.distribution.gbd.e.b.this.f.a(com.getui.gtc.extension.distribution.gbd.k.a.j.e());
            com.getui.gtc.extension.distribution.gbd.e.b.this.f.a();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$6, reason: invalid class name */
    public class AnonymousClass6 implements com.getui.gtc.extension.distribution.gbd.g.c {
        public AnonymousClass6() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            java.util.Map map;
            java.util.List<java.lang.String> list;
            if (obj == null || !(obj instanceof java.util.HashMap)) {
                return;
            }
            java.util.HashMap hashMap = (java.util.HashMap) obj;
            if (hashMap.size() <= 0 || (map = (java.util.Map) hashMap.get("header")) == null || map.size() <= 0 || (list = (java.util.List) map.get("Date")) == null) {
                return;
            }
            for (java.lang.String str : list) {
                if (str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) && str.contains("GMT")) {
                    java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", java.util.Locale.ENGLISH);
                    simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
                    long time = simpleDateFormat.parse(str).getTime();
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    if (currentTimeMillis != time) {
                        com.getui.gtc.extension.distribution.gbd.d.h.an = time - currentTimeMillis;
                        com.getui.gtc.extension.distribution.gbd.f.h.a(time);
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.e.b.g, "localTimeByServerTimeDiff  = " + com.getui.gtc.extension.distribution.gbd.d.h.an);
                        com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.e.b.g, "localTimeByServerTimeDiff  = " + com.getui.gtc.extension.distribution.gbd.d.h.an);
                    }
                }
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$7, reason: invalid class name */
    public class AnonymousClass7 implements com.getui.gtc.extension.distribution.gbd.g.c {
        public AnonymousClass7() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            if (obj == null || !(obj instanceof java.util.HashMap)) {
                return;
            }
            java.util.HashMap hashMap = (java.util.HashMap) obj;
            if (hashMap.size() > 0) {
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.getui.gtc.extension.distribution.gbd.d.h.bl = currentTimeMillis;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(400, java.lang.String.valueOf(currentTimeMillis));
                java.lang.Object obj2 = hashMap.get("data");
                java.lang.StringBuilder sb = new java.lang.StringBuilder("net http r = ");
                sb.append(obj2 == null ? "" : (java.lang.String) obj2);
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.e.b.g, sb.toString());
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.b$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.e.b.g, "register 114 receiver ： " + com.getui.gtc.extension.distribution.gbd.d.d.B);
            if (com.getui.gtc.extension.distribution.gbd.d.d.B) {
                com.getui.gtc.extension.distribution.gbd.e.b.this.j = new com.getui.gtc.extension.distribution.gbd.i.a();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                com.getui.gtc.extension.distribution.gbd.e.b.this.a.registerReceiver(com.getui.gtc.extension.distribution.gbd.e.b.this.j, intentFilter);
            }
        }
    }

    private b() {
    }

    public static com.getui.gtc.extension.distribution.gbd.e.b a() {
        if (h == null) {
            synchronized (com.getui.gtc.extension.distribution.gbd.e.b.class) {
                if (h == null) {
                    h = new com.getui.gtc.extension.distribution.gbd.e.b();
                }
            }
        }
        return h;
    }

    public static /* synthetic */ void a(com.getui.gtc.extension.distribution.gbd.e.b bVar) {
        if (java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.bl < com.getui.gtc.extension.distribution.gbd.d.d.J * 1000) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "cn time not m.");
            return;
        }
        java.lang.String str = com.getui.gtc.extension.distribution.gbd.d.d.I;
        java.lang.String l = com.getui.gtc.extension.distribution.gbd.n.l.l("cnet");
        if (android.text.TextUtils.isEmpty(str) || "none".equalsIgnoreCase(str) || android.text.TextUtils.isEmpty(l)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "cn http u or a em.");
            return;
        }
        boolean a = com.getui.gtc.extension.distribution.gbd.n.l.a("cnet", com.getui.gtc.extension.distribution.gbd.d.d.K);
        if (!com.getui.gtc.extension.distribution.gbd.d.d.H || !a) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "cn not enable or hc failed.");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.g.a.c cVar = new com.getui.gtc.extension.distribution.gbd.g.a.c(bVar.new AnonymousClass7());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("?d=");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.p.a(com.getui.gtc.extension.distribution.gbd.n.p.a(l) + com.getui.gtc.extension.distribution.gbd.d.g.bu));
        cVar.e = sb.toString();
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(cVar));
    }

    private static void b(android.content.Context context) {
        android.content.pm.ApplicationInfo applicationInfo;
        android.os.Bundle bundle;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            applicationInfo = null;
        }
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return;
        }
        java.lang.String string = bundle.getString(com.getui.gtc.extension.distribution.gbd.d.g.M);
        if (!android.text.TextUtils.isEmpty(string)) {
            com.getui.gtc.extension.distribution.gbd.d.d.d = string;
        }
        java.lang.String string2 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.N);
        if (!android.text.TextUtils.isEmpty(string2)) {
            com.getui.gtc.extension.distribution.gbd.d.d.e = string2;
        }
        java.lang.String string3 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.O);
        if (!android.text.TextUtils.isEmpty(string3)) {
            com.getui.gtc.extension.distribution.gbd.d.i.a = string3;
        }
        java.lang.String string4 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.P);
        if (android.text.TextUtils.isEmpty(string4)) {
            return;
        }
        com.getui.gtc.extension.distribution.gbd.d.i.b = string4;
    }

    private void d() {
        android.content.pm.ApplicationInfo applicationInfo;
        long j;
        android.os.Bundle bundle;
        com.getui.gtc.extension.distribution.gbd.n.j.a(g, "gbd logic init ,GBD-2.10.5.2");
        com.getui.gtc.extension.distribution.gbd.d.h.ap = com.getui.gtc.extension.distribution.gbd.n.a.a();
        com.getui.gtc.extension.distribution.gbd.d.h.a = new com.getui.gtc.extension.distribution.gbd.f.a(this.a);
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.b();
        com.getui.gtc.extension.distribution.gbd.f.a.a.a().b();
        com.getui.gtc.extension.distribution.gbd.f.h.a();
        b();
        android.content.Context context = this.a;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            applicationInfo = null;
        }
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            java.lang.String string = bundle.getString(com.getui.gtc.extension.distribution.gbd.d.g.M);
            if (!android.text.TextUtils.isEmpty(string)) {
                com.getui.gtc.extension.distribution.gbd.d.d.d = string;
            }
            java.lang.String string2 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.N);
            if (!android.text.TextUtils.isEmpty(string2)) {
                com.getui.gtc.extension.distribution.gbd.d.d.e = string2;
            }
            java.lang.String string3 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.O);
            if (!android.text.TextUtils.isEmpty(string3)) {
                com.getui.gtc.extension.distribution.gbd.d.i.a = string3;
            }
            java.lang.String string4 = applicationInfo.metaData.getString(com.getui.gtc.extension.distribution.gbd.d.g.P);
            if (!android.text.TextUtils.isEmpty(string4)) {
                com.getui.gtc.extension.distribution.gbd.d.i.b = string4;
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(g, "gbd config task init");
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass1());
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass2(), 5000L);
        try {
            boolean B = com.getui.gtc.extension.distribution.gbd.n.l.B();
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "CAE  ".concat(java.lang.String.valueOf(B)));
            if (B) {
                if (com.getui.gtc.extension.distribution.gbd.d.h.ai.split(",").length >= 200) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(g, " CAD length > 200, clean. ");
                    com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                }
                long C = com.getui.gtc.extension.distribution.gbd.n.l.C();
                long j2 = C - (com.getui.gtc.extension.distribution.gbd.d.h.aj + com.getui.gtc.extension.distribution.gbd.d.h.ak);
                com.getui.gtc.extension.distribution.gbd.n.j.a(g, "initCAA: sdkLastStartTime  " + com.getui.gtc.extension.distribution.gbd.d.h.aj);
                com.getui.gtc.extension.distribution.gbd.n.j.a(g, "initCAA: sdkAliveTime  " + com.getui.gtc.extension.distribution.gbd.d.h.ak);
                if (com.getui.gtc.extension.distribution.gbd.d.h.aj == 0) {
                    com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
                    com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    j = com.getui.gtc.extension.distribution.gbd.d.h.ak;
                } else if (j2 <= com.getui.gtc.extension.distribution.gbd.d.d.bK * 1000) {
                    long j3 = C - com.getui.gtc.extension.distribution.gbd.d.h.aj;
                    com.getui.gtc.extension.distribution.gbd.d.h.ak = j3;
                    if (j3 < 0) {
                        com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
                        com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                    }
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    j = com.getui.gtc.extension.distribution.gbd.d.h.ak;
                } else {
                    if (com.getui.gtc.extension.distribution.gbd.d.h.ak >= 10000) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                        sb.append((com.getui.gtc.extension.distribution.gbd.d.h.aj / 1000) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + (com.getui.gtc.extension.distribution.gbd.d.h.ak / 1000) + ",");
                        com.getui.gtc.extension.distribution.gbd.d.h.ai = sb.toString();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                        com.getui.gtc.extension.distribution.gbd.n.j.b(g, "CAD update =  " + com.getui.gtc.extension.distribution.gbd.d.h.ai);
                    }
                    com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
                    com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    j = com.getui.gtc.extension.distribution.gbd.d.h.ak;
                }
                com.getui.gtc.extension.distribution.gbd.f.a.b.f(j);
            } else {
                com.getui.gtc.extension.distribution.gbd.d.h.aj = 0L;
                com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.ak);
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                com.getui.gtc.extension.distribution.gbd.n.j.b(g, "clean CAD. ");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (com.getui.gtc.extension.distribution.gbd.n.l.B()) {
            com.getui.gtc.extension.distribution.gbd.k.a.c.a(0L);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(g, "GBD E " + com.getui.gtc.extension.distribution.gbd.d.d.x);
        if (com.getui.gtc.extension.distribution.gbd.d.d.x) {
            this.f = new com.getui.gtc.extension.distribution.gbd.k.a();
            try {
                com.getui.gtc.extension.distribution.gbd.d.h.c = (android.net.wifi.WifiManager) this.a.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                if (this.a.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.a.getPackageName()) == 0) {
                    com.getui.gtc.extension.distribution.gbd.d.h.i = true;
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
            try {
                if (!this.e.getAndSet(true)) {
                    if (com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.ACCESS_WIFI_STATE") && com.getui.gtc.extension.distribution.gbd.d.d.q) {
                        this.c = new com.getui.gtc.extension.distribution.gbd.i.b();
                        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                        intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                        this.a.registerReceiver(this.c, intentFilter);
                    }
                    this.b = new com.getui.gtc.extension.distribution.gbd.i.c();
                    android.content.IntentFilter intentFilter2 = new android.content.IntentFilter();
                    intentFilter2.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT);
                    intentFilter2.addAction("android.intent.action.SCREEN_OFF");
                    this.a.registerReceiver(this.b, intentFilter2);
                    com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass8(), 500L);
                    this.d = new com.getui.gtc.extension.distribution.gbd.i.d();
                    android.content.IntentFilter intentFilter3 = new android.content.IntentFilter();
                    intentFilter3.addAction("android.intent.action.ACTION_SHUTDOWN");
                    this.a.registerReceiver(this.d, intentFilter3);
                }
            } catch (java.lang.Throwable th3) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
            }
            com.getui.gtc.extension.distribution.gbd.e.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
            if (aVar != null && this.f != null) {
                aVar.postDelayed(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass3(), com.getui.gtc.extension.distribution.gbd.d.d.g * 1000);
            }
            com.getui.gtc.extension.distribution.gbd.d.h.b.postDelayed(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass4(), 2000L);
            long nextInt = (com.getui.gtc.extension.distribution.gbd.d.d.ci + new java.util.Random().nextInt(5)) * 1000;
            long j4 = nextInt * 7;
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "gbd dc task delay= " + nextInt + "ms start");
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass5(j4), nextInt, j4);
            b();
        }
    }

    private void e() {
        com.getui.gtc.extension.distribution.gbd.d.h.a = new com.getui.gtc.extension.distribution.gbd.f.a(this.a);
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.b();
        com.getui.gtc.extension.distribution.gbd.f.a.a.a().b();
    }

    private static void f() {
        if (com.getui.gtc.extension.distribution.gbd.n.l.B()) {
            com.getui.gtc.extension.distribution.gbd.k.a.c.a(0L);
        }
    }

    private void g() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(g, "gbd config task init");
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass1());
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass2(), 5000L);
    }

    private void h() {
        com.getui.gtc.extension.distribution.gbd.e.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
        if (aVar == null || this.f == null) {
            return;
        }
        aVar.postDelayed(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass3(), com.getui.gtc.extension.distribution.gbd.d.d.g * 1000);
    }

    private void i() {
        com.getui.gtc.extension.distribution.gbd.d.h.b.postDelayed(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass4(), 2000L);
    }

    private void j() {
        long nextInt = (com.getui.gtc.extension.distribution.gbd.d.d.ci + new java.util.Random().nextInt(5)) * 1000;
        long j = nextInt * 7;
        com.getui.gtc.extension.distribution.gbd.n.j.b(g, "gbd dc task delay= " + nextInt + "ms start");
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass5(j), nextInt, j);
    }

    private void k() {
        try {
            if (this.e.getAndSet(true)) {
                return;
            }
            if (com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.ACCESS_WIFI_STATE") && com.getui.gtc.extension.distribution.gbd.d.d.q) {
                this.c = new com.getui.gtc.extension.distribution.gbd.i.b();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                this.a.registerReceiver(this.c, intentFilter);
            }
            this.b = new com.getui.gtc.extension.distribution.gbd.i.c();
            android.content.IntentFilter intentFilter2 = new android.content.IntentFilter();
            intentFilter2.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT);
            intentFilter2.addAction("android.intent.action.SCREEN_OFF");
            this.a.registerReceiver(this.b, intentFilter2);
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass8(), 500L);
            this.d = new com.getui.gtc.extension.distribution.gbd.i.d();
            android.content.IntentFilter intentFilter3 = new android.content.IntentFilter();
            intentFilter3.addAction("android.intent.action.ACTION_SHUTDOWN");
            this.a.registerReceiver(this.d, intentFilter3);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private void l() {
        if (java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.bl < com.getui.gtc.extension.distribution.gbd.d.d.J * 1000) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "cn time not m.");
            return;
        }
        java.lang.String str = com.getui.gtc.extension.distribution.gbd.d.d.I;
        java.lang.String l = com.getui.gtc.extension.distribution.gbd.n.l.l("cnet");
        if (android.text.TextUtils.isEmpty(str) || "none".equalsIgnoreCase(str) || android.text.TextUtils.isEmpty(l)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "cn http u or a em.");
            return;
        }
        boolean a = com.getui.gtc.extension.distribution.gbd.n.l.a("cnet", com.getui.gtc.extension.distribution.gbd.d.d.K);
        if (!com.getui.gtc.extension.distribution.gbd.d.d.H || !a) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "cn not enable or hc failed.");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.g.a.c cVar = new com.getui.gtc.extension.distribution.gbd.g.a.c(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass7());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("?d=");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.p.a(com.getui.gtc.extension.distribution.gbd.n.p.a(l) + com.getui.gtc.extension.distribution.gbd.d.g.bu));
        cVar.e = sb.toString();
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(cVar));
    }

    private void m() {
        try {
            com.getui.gtc.extension.distribution.gbd.d.h.c = (android.net.wifi.WifiManager) this.a.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
            if (this.a.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.a.getPackageName()) == 0) {
                com.getui.gtc.extension.distribution.gbd.d.h.i = true;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private void n() {
        if (com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.ACCESS_WIFI_STATE") && com.getui.gtc.extension.distribution.gbd.d.d.q) {
            this.c = new com.getui.gtc.extension.distribution.gbd.i.b();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            this.a.registerReceiver(this.c, intentFilter);
        }
    }

    private void o() {
        this.b = new com.getui.gtc.extension.distribution.gbd.i.c();
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT);
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.a.registerReceiver(this.b, intentFilter);
    }

    private void p() {
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass8(), 500L);
    }

    private void q() {
        this.d = new com.getui.gtc.extension.distribution.gbd.i.d();
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        this.a.registerReceiver(this.d, intentFilter);
    }

    private static void r() {
    }

    private static void s() {
        try {
            boolean B = com.getui.gtc.extension.distribution.gbd.n.l.B();
            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "CAE  ".concat(java.lang.String.valueOf(B)));
            if (!B) {
                com.getui.gtc.extension.distribution.gbd.d.h.aj = 0L;
                com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.ak);
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                com.getui.gtc.extension.distribution.gbd.n.j.b(g, "clean CAD. ");
                return;
            }
            if (com.getui.gtc.extension.distribution.gbd.d.h.ai.split(",").length >= 200) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(g, " CAD length > 200, clean. ");
                com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
            }
            long C = com.getui.gtc.extension.distribution.gbd.n.l.C();
            long j = C - (com.getui.gtc.extension.distribution.gbd.d.h.aj + com.getui.gtc.extension.distribution.gbd.d.h.ak);
            com.getui.gtc.extension.distribution.gbd.n.j.a(g, "initCAA: sdkLastStartTime  " + com.getui.gtc.extension.distribution.gbd.d.h.aj);
            com.getui.gtc.extension.distribution.gbd.n.j.a(g, "initCAA: sdkAliveTime  " + com.getui.gtc.extension.distribution.gbd.d.h.ak);
            if (com.getui.gtc.extension.distribution.gbd.d.h.aj == 0) {
                com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
                com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.ak);
                return;
            }
            if (j <= com.getui.gtc.extension.distribution.gbd.d.d.bK * 1000) {
                long j2 = C - com.getui.gtc.extension.distribution.gbd.d.h.aj;
                com.getui.gtc.extension.distribution.gbd.d.h.ak = j2;
                if (j2 < 0) {
                    com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
                    com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
                }
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.ak);
                return;
            }
            if (com.getui.gtc.extension.distribution.gbd.d.h.ak >= 10000) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                sb.append((com.getui.gtc.extension.distribution.gbd.d.h.aj / 1000) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + (com.getui.gtc.extension.distribution.gbd.d.h.ak / 1000) + ",");
                com.getui.gtc.extension.distribution.gbd.d.h.ai = sb.toString();
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                com.getui.gtc.extension.distribution.gbd.n.j.b(g, "CAD update =  " + com.getui.gtc.extension.distribution.gbd.d.h.ai);
            }
            com.getui.gtc.extension.distribution.gbd.d.h.aj = C;
            com.getui.gtc.extension.distribution.gbd.d.h.ak = 0L;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.aj);
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.ak);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private void t() {
        android.content.pm.PackageManager packageManager = this.a.getPackageManager();
        java.util.List<android.content.pm.PackageInfo> a = com.getui.gtc.extension.distribution.gbd.n.b.a();
        for (int i = 0; i < a.size(); i++) {
            try {
                android.content.pm.PackageInfo packageInfo = a.get(i);
                android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    com.getui.gtc.extension.distribution.gbd.c.a aVar = new com.getui.gtc.extension.distribution.gbd.c.a();
                    aVar.b = applicationInfo.loadLabel(packageManager).toString();
                    aVar.a = applicationInfo.packageName;
                    aVar.c = packageInfo.versionName;
                    aVar.d = java.lang.String.valueOf(packageInfo.versionCode);
                    com.getui.gtc.extension.distribution.gbd.d.h.F.put(applicationInfo.packageName, aVar);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    private void u() {
        if (this.a == null) {
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(g, "onDestroy");
        com.getui.gtc.extension.distribution.gbd.i.a aVar = this.j;
        if (aVar != null) {
            this.a.unregisterReceiver(aVar);
            this.j = null;
        }
        com.getui.gtc.extension.distribution.gbd.i.c cVar = this.b;
        if (cVar != null) {
            this.a.unregisterReceiver(cVar);
            this.b = null;
        }
        com.getui.gtc.extension.distribution.gbd.i.d dVar = this.d;
        if (dVar != null) {
            this.a.unregisterReceiver(dVar);
            this.d = null;
        }
    }

    public final void a(android.content.Context context) {
        if (this.k.getAndSet(true)) {
            return;
        }
        this.a = context;
        com.getui.gtc.extension.distribution.gbd.d.c.d = context;
        this.i.start();
    }

    public final void b() {
        try {
            if (com.getui.gtc.extension.distribution.gbd.n.l.l(this.a)) {
                return;
            }
            com.getui.gtc.extension.distribution.gbd.g.a.c cVar = new com.getui.gtc.extension.distribution.gbd.g.a.c(new com.getui.gtc.extension.distribution.gbd.e.b.AnonymousClass6());
            cVar.e = "http://sdk.open.phone.igexin.com/api/addr.htm";
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(cVar));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    public final boolean c() {
        android.content.pm.ServiceInfo[] serviceInfoArr;
        char c = 0;
        try {
            try {
                if ("none".equals(com.getui.gtc.extension.distribution.gbd.d.d.at)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(g, "checkSafeStatus wt a");
                    return false;
                }
                for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.at.split(",")) {
                    if (com.getui.gtc.extension.distribution.gbd.n.l.e(str)) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(g, "checkSafeStatus pn = ".concat(java.lang.String.valueOf(str)));
                        return false;
                    }
                }
                if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.az) && !"none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.az)) {
                    java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.az.split(",");
                    int length = split.length;
                    int i = 0;
                    while (i < length) {
                        java.lang.String str2 = split[i];
                        if (!android.text.TextUtils.isEmpty(str2)) {
                            java.lang.String[] split2 = str2.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                            if (split2.length != 3 || android.text.TextUtils.isEmpty(split2[c])) {
                                com.getui.gtc.extension.distribution.gbd.n.j.b(g, "11 rom format error,continue.");
                            } else {
                                java.lang.String str3 = split2[c];
                                java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(split2[1].split("#")));
                                java.util.ArrayList arrayList2 = new java.util.ArrayList(java.util.Arrays.asList(split2[2].split("#")));
                                java.lang.String w = com.getui.gtc.extension.distribution.gbd.n.l.w();
                                java.lang.String lowerCase = com.getui.gtc.extension.distribution.gbd.n.l.z().toLowerCase();
                                int i2 = android.os.Build.VERSION.SDK_INT;
                                java.lang.String valueOf = java.lang.String.valueOf(i2);
                                if (str3.equalsIgnoreCase(w)) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.b(g, "11 checkStatus brand match.");
                                    if (arrayList.size() != 1 || arrayList2.size() != 1) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.b(g, "checkSafeStatus R return false");
                                        return arrayList.contains(lowerCase) && arrayList2.contains(valueOf);
                                    }
                                    double doubleValue = java.lang.Double.valueOf((java.lang.String) arrayList.get(0)).doubleValue();
                                    int intValue = java.lang.Integer.valueOf((java.lang.String) arrayList2.get(0)).intValue();
                                    com.getui.gtc.extension.distribution.gbd.n.j.b(g, "checkSafeStatus R return false");
                                    return java.lang.Double.valueOf(lowerCase).doubleValue() >= doubleValue && i2 >= intValue;
                                }
                            }
                        }
                        i++;
                        c = 0;
                    }
                }
                if (com.getui.gtc.extension.distribution.gbd.d.d.ag) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(g, "11 check s allow wt s.");
                    com.getui.gtc.extension.distribution.gbd.n.j.b(g, "11 check s allow wt s.");
                    if (!"none".equals(com.getui.gtc.extension.distribution.gbd.d.d.aA) && com.getui.gtc.extension.distribution.gbd.n.l.d(this.a)) {
                        java.lang.String[] split3 = com.getui.gtc.extension.distribution.gbd.d.d.aA.split(",");
                        java.util.Iterator<android.content.pm.PackageInfo> it = com.getui.gtc.extension.distribution.gbd.n.b.a().iterator();
                        while (it.hasNext()) {
                            java.lang.String str4 = it.next().packageName;
                            java.lang.String str5 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                            android.content.pm.PackageInfo g2 = com.getui.gtc.extension.distribution.gbd.n.l.g(str4);
                            if (g2 != null && (serviceInfoArr = g2.services) != null && serviceInfoArr.length > 0) {
                                for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                                    for (java.lang.String str6 : split3) {
                                        if (str6.equals(serviceInfo.name)) {
                                            com.getui.gtc.extension.distribution.gbd.n.j.b(g, "checkSafeStatus wt s.");
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(g, "checkSafeStatus wt s.");
                    return false;
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(g, "11 check s not allow wt s.");
                return true;
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                com.getui.gtc.extension.distribution.gbd.n.j.b(g, "checkSafeStatus Throwable");
                return false;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
