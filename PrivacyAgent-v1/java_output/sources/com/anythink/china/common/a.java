package com.anythink.china.common;

/* loaded from: classes12.dex */
public class a implements com.anythink.china.common.a.g {
    public static final java.lang.String a = "a";
    public static final java.lang.String b = "action_offer_download_start";
    public static final java.lang.String c = "action_offer_download_end";
    public static final java.lang.String d = "action_offer_install_start";
    public static final java.lang.String e = "action_offer_install_successful";
    public static final java.lang.String f = "receiver_extra_offer_id";
    public static final java.lang.String g = "receiver_extra_click_id";
    private static volatile com.anythink.china.common.a h;
    private android.content.Context i;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> n;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> o;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> p;
    private java.util.Map<java.lang.String, com.anythink.china.common.a.e> q;
    private android.content.BroadcastReceiver t;
    private com.anythink.china.common.service.ApkDownloadService.a u;
    private android.content.BroadcastReceiver v;
    private final int r = 1;

    /* renamed from: s, reason: collision with root package name */
    private long f155s = 604800000;
    private android.content.ServiceConnection w = new com.anythink.china.common.a.AnonymousClass1();
    private java.util.List<com.anythink.china.common.a.e> j = java.util.Collections.synchronizedList(new java.util.LinkedList());
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> k = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> l = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.a.InterfaceC0157a> m = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: com.anythink.china.common.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            java.lang.String str = com.anythink.china.common.a.a;
            try {
                com.anythink.china.common.a.this.u = (com.anythink.china.common.service.ApkDownloadService.a) iBinder;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            java.lang.String str = com.anythink.china.common.a.a;
            com.anythink.china.common.a.this.u = null;
        }
    }

    /* renamed from: com.anythink.china.common.a$2, reason: invalid class name */
    public class AnonymousClass2 extends android.content.BroadcastReceiver {
        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || !com.anythink.core.common.o.i.a("android.permission.ACCESS_NETWORK_STATE", context)) {
                    return;
                }
                android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (com.anythink.core.common.o.i.a(context) && activeNetworkInfo.getType() == 1) {
                    com.anythink.china.common.a.a(com.anythink.china.common.a.this);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.anythink.china.common.a$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.china.common.a.a.InterfaceC0157a {

        /* renamed from: com.anythink.china.common.a$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ long a;
            final /* synthetic */ long b;
            final /* synthetic */ com.anythink.china.common.a.e c;

            public AnonymousClass1(long j, long j2, com.anythink.china.common.a.e eVar) {
                this.a = j;
                this.b = j2;
                this.c = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.a < this.b) {
                    com.anythink.china.common.a.this.d("正在下载： " + this.c.c);
                    com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).c(this.c);
                    com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).a(this.c, this.a, this.b);
                }
                android.content.Intent intent = new android.content.Intent();
                intent.setAction(com.anythink.china.common.a.b);
                intent.setPackage(com.anythink.china.common.a.this.i.getPackageName());
                intent.putExtra(com.anythink.china.common.a.f, this.c.f);
                intent.putExtra(com.anythink.china.common.a.g, this.c.m);
                com.anythink.core.common.k.a(com.anythink.china.common.a.this.i).a(intent);
                com.anythink.china.common.a.e eVar = this.c;
                com.anythink.core.common.n.c.a(eVar.a, eVar.f, eVar.b, 1, (java.lang.String) null, 0L, this.b);
            }
        }

        /* renamed from: com.anythink.china.common.a$3$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.china.common.a.e a;
            final /* synthetic */ long b;

            public AnonymousClass2(com.anythink.china.common.a.e eVar, long j) {
                this.a = eVar;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.china.common.a.this.m.remove(this.a.n);
                com.anythink.china.common.a.this.k.remove(this.a.n);
                if (com.anythink.china.common.a.this.n == null) {
                    com.anythink.china.common.a.this.n = new java.util.concurrent.ConcurrentHashMap();
                }
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = com.anythink.china.common.a.this.n;
                com.anythink.china.common.a.e eVar = this.a;
                concurrentHashMap.put(eVar.n, eVar);
                android.content.Intent intent = new android.content.Intent();
                intent.setAction(com.anythink.china.common.a.c);
                intent.setPackage(com.anythink.china.common.a.this.i.getPackageName());
                intent.putExtra(com.anythink.china.common.a.f, this.a.f);
                intent.putExtra(com.anythink.china.common.a.g, this.a.m);
                com.anythink.core.common.k.a(com.anythink.china.common.a.this.i).a(intent);
                com.anythink.china.common.a.this.b(this.a);
                com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).c(this.a);
                com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).a(this.a);
                com.anythink.china.common.a.e eVar2 = this.a;
                com.anythink.core.common.n.c.a(eVar2.a, eVar2.f, eVar2.b, 2, (java.lang.String) null, this.b, eVar2.h);
                com.anythink.china.common.a.this.b();
            }
        }

        /* renamed from: com.anythink.china.common.a$3$3, reason: invalid class name and collision with other inner class name */
        public class RunnableC01563 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.china.common.a.e a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            public RunnableC01563(com.anythink.china.common.a.e eVar, long j, long j2) {
                this.a = eVar;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).a(this.a, this.b, this.c);
            }
        }

        /* renamed from: com.anythink.china.common.a$3$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.china.common.a.e a;
            final /* synthetic */ java.lang.String b;

            public AnonymousClass4(com.anythink.china.common.a.e eVar, java.lang.String str) {
                this.a = eVar;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.china.common.a.this.d("下载失败： " + this.a.c);
                com.anythink.china.common.a.this.m.remove(this.a.n);
                com.anythink.china.common.a.this.k.remove(this.a.n);
                if (com.anythink.china.common.a.this.q == null) {
                    com.anythink.china.common.a.this.q = java.util.Collections.synchronizedMap(new java.util.HashMap());
                }
                java.util.Map map = com.anythink.china.common.a.this.q;
                com.anythink.china.common.a.e eVar = this.a;
                map.put(eVar.n, eVar);
                com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).c(this.a);
                com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).a(this.a, 0L, 100L);
                com.anythink.china.common.a.e eVar2 = this.a;
                com.anythink.core.common.n.c.a(eVar2.a, eVar2.f, eVar2.b, 3, this.b, 0L, eVar2.h);
                com.anythink.china.common.a.this.b();
            }
        }

        /* renamed from: com.anythink.china.common.a$3$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.china.common.a.e a;
            final /* synthetic */ int b;
            final /* synthetic */ long c;
            final /* synthetic */ long d;

            public AnonymousClass5(com.anythink.china.common.a.e eVar, int i, long j, long j2) {
                this.a = eVar;
                this.b = i;
                this.c = j;
                this.d = j2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.china.common.a.this.k.remove(this.a.n);
                com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).c(this.a);
                int i = this.b;
                if (i == 2) {
                    java.lang.String str = com.anythink.china.common.a.a;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
                    sb.append(this.a.c);
                    sb.append(") pause download");
                    com.anythink.china.common.b.a.a(com.anythink.china.common.a.this.i).a(this.a, this.c, this.d);
                    com.anythink.china.common.a.this.b();
                    return;
                }
                if (i == 3) {
                    java.lang.String str2 = com.anythink.china.common.a.a;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("(");
                    sb2.append(this.a.c);
                    sb2.append(") stop download");
                }
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void a(com.anythink.china.common.a.e eVar, long j) {
            java.lang.String str = com.anythink.china.common.a.a;
            new java.lang.StringBuilder("onSuccess: ").append(eVar.c);
            com.anythink.core.common.b.o.a().b(new com.anythink.china.common.a.AnonymousClass3.AnonymousClass2(eVar, j));
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void a(com.anythink.china.common.a.e eVar, long j, long j2) {
            java.lang.String str = com.anythink.china.common.a.a;
            java.lang.String str2 = eVar.b;
            com.anythink.core.common.b.o.a().b(new com.anythink.china.common.a.AnonymousClass3.AnonymousClass1(j, j2, eVar));
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void a(com.anythink.china.common.a.e eVar, long j, long j2, int i) {
            java.lang.String str = com.anythink.china.common.a.a;
            com.anythink.core.common.b.o.a().b(new com.anythink.china.common.a.AnonymousClass3.AnonymousClass5(eVar, i, j, j2));
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void a(com.anythink.china.common.a.e eVar, java.lang.String str) {
            java.lang.String str2 = com.anythink.china.common.a.a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
            sb.append(eVar.c);
            sb.append(") download fail: ");
            sb.append(str);
            com.anythink.core.common.b.o.a().b(new com.anythink.china.common.a.AnonymousClass3.AnonymousClass4(eVar, str));
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void b(com.anythink.china.common.a.e eVar, long j, long j2) {
            com.anythink.core.common.b.o.a().b(new com.anythink.china.common.a.AnonymousClass3.RunnableC01563(eVar, j, j2));
        }
    }

    /* renamed from: com.anythink.china.common.a$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.china.common.a.this.q != null) {
                synchronized (com.anythink.china.common.a.this.q) {
                    java.util.Iterator it = com.anythink.china.common.a.this.q.entrySet().iterator();
                    while (it.hasNext()) {
                        com.anythink.china.common.a.e eVar = (com.anythink.china.common.a.e) ((java.util.Map.Entry) it.next()).getValue();
                        java.lang.String str = com.anythink.china.common.a.a;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
                        sb.append(eVar.c);
                        sb.append(") retry to download");
                        eVar.e();
                        com.anythink.china.common.a.this.d(eVar);
                        it.remove();
                    }
                }
            }
        }
    }

    /* renamed from: com.anythink.china.common.a$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass5(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.widget.Toast.makeText(com.anythink.china.common.a.this.i, this.a, 0).show();
        }
    }

    private a(android.content.Context context) {
        this.i = context.getApplicationContext();
        java.lang.String a2 = com.anythink.china.common.c.b.a();
        if (!android.text.TextUtils.isEmpty(a2)) {
            java.io.File file = new java.io.File(a2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        try {
            this.v = new com.anythink.china.common.a.AnonymousClass2();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            this.i.registerReceiver(this.v, intentFilter);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static com.anythink.china.common.a a(android.content.Context context) {
        if (h == null) {
            synchronized (com.anythink.china.common.a.class) {
                if (h == null) {
                    h = new com.anythink.china.common.a(context);
                }
            }
        }
        return h;
    }

    private void a(long j) {
        if (j > 0) {
            this.f155s = j;
        }
    }

    private static void a(com.anythink.china.common.a.e eVar, boolean z) {
        com.anythink.core.common.g.b bVar = eVar.l;
        if (bVar != null) {
            bVar.a(eVar.j, eVar.a, eVar.b, z);
        }
    }

    public static /* synthetic */ void a(com.anythink.china.common.a aVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) aVar.new AnonymousClass4(), 2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(java.lang.String str) {
        com.anythink.core.common.b.o.a().b(new com.anythink.china.common.a.AnonymousClass5(str));
    }

    private void e(com.anythink.china.common.a.e eVar) {
        this.k.put(eVar.n, eVar);
        this.m.put(eVar.n, new com.anythink.china.common.a.AnonymousClass3());
        try {
            com.anythink.china.common.service.ApkDownloadService.a aVar = this.u;
            if (aVar != null) {
                aVar.a(eVar.n);
                return;
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setClass(this.i, com.anythink.china.common.service.ApkDownloadService.class);
            intent.putExtra(com.anythink.china.common.service.ApkDownloadService.a, eVar.n);
            this.i.bindService(intent, this.w, 1);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static java.lang.String f(com.anythink.china.common.a.e eVar) {
        return com.anythink.china.common.c.b.a(eVar.n) + com.anythink.china.common.a.a.g;
    }

    private void g() {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.common.a.AnonymousClass4(), 2, true);
    }

    private void h() {
        try {
            if (this.t != null) {
                return;
            }
            this.t = new com.anythink.china.common.b();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            this.i.registerReceiver(this.t, intentFilter);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void i() {
        try {
            android.content.BroadcastReceiver broadcastReceiver = this.t;
            if (broadcastReceiver != null) {
                this.i.unregisterReceiver(broadcastReceiver);
                this.t = null;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.china.common.a.g
    public final int a() {
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0134 A[Catch: all -> 0x016d, TryCatch #1 {all -> 0x016d, blocks: (B:41:0x00e5, B:46:0x00f1, B:48:0x00fc, B:51:0x0101, B:53:0x0110, B:55:0x011e, B:57:0x0122, B:59:0x012c, B:61:0x0134, B:63:0x0144, B:65:0x0138, B:67:0x0141, B:71:0x0147, B:73:0x014d), top: B:40:0x00e5 }] */
    @Override // com.anythink.china.common.a.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, java.lang.String str2, java.lang.Runnable runnable, com.anythink.core.common.g.b bVar) {
        java.io.File[] listFiles;
        boolean z;
        if (com.anythink.china.common.c.a.a(context, lVar.E())) {
            try {
                android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(lVar.E());
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    return;
                }
                return;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        com.anythink.china.common.a.e eVar = new com.anythink.china.common.a.e();
        eVar.n = com.anythink.core.common.o.h.a(lVar);
        eVar.a = mVar.d;
        eVar.f = lVar.s();
        eVar.b = str;
        eVar.m = str2;
        eVar.e = lVar.E();
        eVar.c = lVar.u();
        eVar.j = lVar;
        com.anythink.core.common.f.n nVar = mVar.n;
        if (nVar != null) {
            eVar.o = nVar.j() == 1;
            eVar.q = mVar.n.P();
            eVar.p = mVar.n.O();
        }
        int applyDimension = (int) android.util.TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
        eVar.d = com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(1, lVar.w()), applyDimension, applyDimension);
        if (lVar.C() != null) {
            java.lang.String C = lVar.C();
            java.lang.String str3 = mVar.d;
            if (str3 == null) {
                str3 = "";
            }
            eVar.k = C.replaceAll("\\{req_id\\}", str3);
        }
        eVar.l = bVar;
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap = this.p;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(eVar.n);
        }
        java.util.Map<java.lang.String, com.anythink.china.common.a.e> map = this.q;
        if (map != null) {
            map.remove(eVar.n);
        }
        com.anythink.china.common.a a2 = a(context);
        long G = mVar.n.G();
        if (G > 0) {
            a2.f155s = G;
        }
        com.anythink.china.common.a a3 = a(context);
        try {
            java.lang.String a4 = com.anythink.china.common.c.b.a();
            if (!android.text.TextUtils.isEmpty(a4) && ((listFiles = new java.io.File(a4).listFiles()) == null || listFiles.length != 0)) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                long j = a3.f155s;
                for (java.io.File file : listFiles) {
                    if (file.getName().endsWith(com.anythink.china.common.a.a.g)) {
                        android.content.Context context2 = a3.i;
                        if (context2 != null) {
                            java.lang.String a5 = com.anythink.china.common.c.a.a(context2, file);
                            if (!android.text.TextUtils.isEmpty(a5)) {
                                z = com.anythink.china.common.c.a.a(context2, a5);
                                if (z) {
                                    arrayList.add(file);
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    if (file.lastModified() + j < currentTimeMillis) {
                        arrayList.add(file);
                    }
                }
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    new java.lang.StringBuilder("clean expired file -> ").append(((java.io.File) arrayList.get(i)).getName());
                    ((java.io.File) arrayList.get(i)).delete();
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        a(context).d(eVar);
    }

    @Override // com.anythink.china.common.a.g
    public final void a(com.anythink.china.common.a.e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.k.containsKey(eVar.n)) {
            java.io.File file = new java.io.File(com.anythink.china.common.c.b.a(eVar.n) + com.anythink.china.common.a.a.e);
            java.io.File file2 = new java.io.File(com.anythink.china.common.c.b.a(eVar.n) + com.anythink.china.common.a.a.f);
            if (file.exists() && file2.exists()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
                sb.append(eVar.c);
                sb.append(") is downloading, do nothing");
                d("正在下载中： " + eVar.c);
                return;
            }
            this.k.remove(eVar.n);
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (android.text.TextUtils.equals(eVar.n, this.j.get(i).n)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("(");
                sb2.append(eVar.c);
                sb2.append(") is waiting for downloading, do nothing");
                d("等待下载： " + eVar.c);
                return;
            }
        }
        this.j.add(eVar);
        com.anythink.china.common.b.a.a(this.i).c(eVar);
        com.anythink.china.common.b.a.a(this.i).a(eVar, 0L, 100L, true);
    }

    @Override // com.anythink.china.common.a.g
    public final void a(java.lang.String str, java.lang.String str2) {
        com.anythink.china.common.a.e eVar;
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap;
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap2;
        java.util.Map<java.lang.String, com.anythink.china.common.a.e> map;
        try {
            if (str2.equals(com.anythink.china.common.a.e.a.FAIL.toString()) && (map = this.q) != null && map.containsKey(str)) {
                com.anythink.china.common.a.e eVar2 = this.q.get(str);
                java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
                sb.append(eVar2.c);
                sb.append(") onCleanNotification: download fail");
                com.anythink.china.common.b.a.a(this.i).c(eVar2);
                this.q.remove(str);
            }
            if (str2.equals(com.anythink.china.common.a.e.a.FINISH.toString()) && (concurrentHashMap2 = this.n) != null && concurrentHashMap2.containsKey(str)) {
                com.anythink.china.common.a.e eVar3 = this.n.get(str);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("(");
                sb2.append(eVar3.c);
                sb2.append(") onCleanNotification: download success");
                com.anythink.china.common.b.a.a(this.i).c(eVar3);
                this.n.remove(str);
            }
            if (str2.equals(com.anythink.china.common.a.e.a.INSTALLED.toString()) && (concurrentHashMap = this.p) != null && concurrentHashMap.containsKey(str)) {
                com.anythink.china.common.a.e eVar4 = this.p.get(str);
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder("(");
                sb3.append(eVar4.c);
                sb3.append(") onCleanNotification: install success");
                com.anythink.china.common.b.a.a(this.i).c(eVar4);
                this.p.remove(str);
            }
            if (!str2.equals(com.anythink.china.common.a.e.a.PAUSE.toString()) || (eVar = this.l.get(str)) == null) {
                return;
            }
            com.anythink.china.common.service.ApkDownloadService.a aVar = this.u;
            if (aVar != null) {
                aVar.c(eVar.n);
            }
            this.l.remove(str);
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder("(");
            sb4.append(eVar.c);
            sb4.append(") onCleanNotification: stop download");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void a(java.lang.String str, java.lang.String str2, int i) {
        com.anythink.china.common.a.e eVar;
        try {
            if (str2.equals(com.anythink.china.common.a.e.a.FAIL.toString())) {
                java.util.Map<java.lang.String, com.anythink.china.common.a.e> map = this.q;
                if (map != null) {
                    com.anythink.china.common.a.e remove = map.remove(str);
                    if (remove == null) {
                        com.anythink.china.common.b.a.a(this.i).a(i);
                        return;
                    }
                    remove.e();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
                    sb.append(remove.c);
                    sb.append(") onClickNotification: download fail to retry");
                    d(remove);
                    return;
                }
                return;
            }
            if (str2.equals(com.anythink.china.common.a.e.a.FINISH.toString())) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap = this.n;
                if (concurrentHashMap != null) {
                    com.anythink.china.common.a.e eVar2 = concurrentHashMap.get(str);
                    if (eVar2 == null) {
                        com.anythink.china.common.b.a.a(this.i).a(i);
                        return;
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("(");
                    sb2.append(eVar2.c);
                    sb2.append(") onClickNotification: start intall");
                    com.anythink.china.common.b.a.a(this.i).c(eVar2);
                    com.anythink.china.common.b.a.a(this.i).a(eVar2);
                    b(eVar2);
                    return;
                }
                return;
            }
            if (str2.equals(com.anythink.china.common.a.e.a.INSTALLED.toString())) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap2 = this.p;
                if (concurrentHashMap2 != null) {
                    com.anythink.china.common.a.e eVar3 = concurrentHashMap2.get(str);
                    if (eVar3 == null) {
                        com.anythink.china.common.b.a.a(this.i).a(i);
                        return;
                    }
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder("(");
                    sb3.append(eVar3.c);
                    sb3.append(") onClickNotification: start open");
                    com.anythink.china.common.b.a.a(this.i).c(eVar3);
                    a(eVar3, true);
                    return;
                }
                return;
            }
            if (str2.equals(com.anythink.china.common.a.e.a.LOADING.toString())) {
                com.anythink.china.common.a.e eVar4 = this.k.get(str);
                if (eVar4 == null) {
                    com.anythink.china.common.b.a.a(this.i).a(i);
                    return;
                }
                if (!eVar4.d() || eVar4.q == 2) {
                    return;
                }
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder("(");
                sb4.append(eVar4.c);
                sb4.append(") onClickNotification: pause download");
                com.anythink.china.common.service.ApkDownloadService.a aVar = this.u;
                if (aVar != null) {
                    aVar.b(eVar4.n);
                }
                this.l.put(eVar4.n, eVar4);
                return;
            }
            if (str2.equals(com.anythink.china.common.a.e.a.PAUSE.toString())) {
                com.anythink.china.common.a.e eVar5 = this.l.get(str);
                if (eVar5 == null) {
                    com.anythink.china.common.b.a.a(this.i).a(i);
                    return;
                }
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder("(");
                sb5.append(eVar5.c);
                sb5.append(") onClickNotification: resume download");
                d(eVar5);
                return;
            }
            if (str2.equals(com.anythink.china.common.a.e.a.IDLE.toString())) {
                synchronized (this.j) {
                    java.util.Iterator<com.anythink.china.common.a.e> it = this.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            eVar = null;
                            break;
                        }
                        eVar = it.next();
                        if (eVar.n.equals(str)) {
                            if (eVar.q == 2) {
                                return;
                            }
                            java.lang.StringBuilder sb6 = new java.lang.StringBuilder("(");
                            sb6.append(eVar.c);
                            sb6.append(") onClickNotification: pause download");
                            this.j.remove(eVar);
                        }
                    }
                    com.anythink.china.common.a.e eVar6 = eVar;
                    if (eVar6 == null) {
                        com.anythink.china.common.b.a.a(this.i).a(i);
                        return;
                    }
                    eVar6.k();
                    this.l.put(eVar6.n, eVar6);
                    com.anythink.china.common.b.a.a(this.i).c(eVar6);
                    com.anythink.china.common.b.a.a(this.i).a(eVar6, 0L, 100L, true);
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean a(com.anythink.core.common.f.l lVar) {
        java.lang.String a2 = com.anythink.core.common.o.h.a(lVar);
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap = this.k;
        return concurrentHashMap != null && concurrentHashMap.containsKey(a2);
    }

    @Override // com.anythink.china.common.a.g
    public final boolean a(java.lang.String str) {
        java.lang.String str2 = com.anythink.china.common.c.b.a(str) + com.anythink.china.common.a.a.g;
        if (android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        return new java.io.File(str2).exists();
    }

    public final int b(com.anythink.core.common.f.l lVar) {
        java.lang.String a2 = com.anythink.core.common.o.h.a(lVar);
        synchronized (this.j) {
            for (int i = 0; i < this.j.size(); i++) {
                com.anythink.china.common.a.e eVar = this.j.get(i);
                if (eVar != null && eVar.n.equals(a2)) {
                    return 0;
                }
            }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap = this.k;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(a2)) {
                return 0;
            }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap2 = this.l;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(a2)) {
                return 6;
            }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap3 = this.n;
            if ((concurrentHashMap3 == null || !concurrentHashMap3.containsKey(a2)) && !a(a2)) {
                return com.anythink.china.common.c.a.a(this.i, lVar.E()) ? 5 : 1;
            }
            return 4;
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void b() {
        synchronized (this.j) {
            int size = this.j.size();
            if (size == 0) {
                return;
            }
            int size2 = this.k.size();
            if (size2 > 0) {
                return;
            }
            int min = java.lang.Math.min(1 - size2, size);
            for (int i = 0; i < min && this.j.size() > 0; i++) {
                com.anythink.china.common.a.e remove = this.j.remove(0);
                this.k.put(remove.n, remove);
                this.m.put(remove.n, new com.anythink.china.common.a.AnonymousClass3());
                try {
                    com.anythink.china.common.service.ApkDownloadService.a aVar = this.u;
                    if (aVar != null) {
                        aVar.a(remove.n);
                    } else {
                        android.content.Intent intent = new android.content.Intent();
                        intent.setClass(this.i, com.anythink.china.common.service.ApkDownloadService.class);
                        intent.putExtra(com.anythink.china.common.service.ApkDownloadService.a, remove.n);
                        this.i.bindService(intent, this.w, 1);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void b(com.anythink.china.common.a.e eVar) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(d);
        intent.setPackage(this.i.getPackageName());
        intent.putExtra(f, eVar.f);
        intent.putExtra(g, eVar.m);
        com.anythink.core.common.k.a(this.i).a(intent);
        if (this.o == null) {
            this.o = new java.util.concurrent.ConcurrentHashMap<>();
        }
        if (android.text.TextUtils.isEmpty(eVar.e)) {
            java.lang.String f2 = f(eVar);
            if (!android.text.TextUtils.isEmpty(f2)) {
                eVar.e = com.anythink.china.common.c.a.a(this.i, new java.io.File(f2));
            }
        }
        this.o.put(eVar.e, eVar);
        try {
            if (this.t == null) {
                this.t = new com.anythink.china.common.b();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addDataScheme("package");
                this.i.registerReceiver(this.t, intentFilter);
            }
        } catch (java.lang.Throwable unused) {
        }
        java.lang.String f3 = f(eVar);
        if (android.text.TextUtils.isEmpty(f3)) {
            return;
        }
        java.io.File file = new java.io.File(f3);
        try {
            android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW");
            intent2.setFlags(268435456);
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                intent2.addFlags(1);
                intent2.setDataAndType(androidx.core.content.FileProvider.getUriForFile(this.i, this.i.getPackageName() + ".anythink.fileProvider", file), "application/vnd.android.package-archive");
            } else {
                intent2.setDataAndType(android.net.Uri.parse(org.apache.tools.ant.taskdefs.XSLTLiaison.FILE_PROTOCOL_PREFIX.concat(java.lang.String.valueOf(f3))), "application/vnd.android.package-archive");
            }
            this.i.startActivity(intent2);
            com.anythink.core.common.n.c.a(eVar.a, eVar.f, eVar.b, 4, (java.lang.String) null, 0L, file.length());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.anythink.core.common.n.c.a(eVar.a, eVar.f, eVar.b, 10, th.getMessage(), 0L, file.length());
        }
    }

    public final void b(java.lang.String str) {
        com.anythink.china.common.a.e eVar;
        try {
            if (this.o.containsKey(str) && (eVar = this.o.get(str)) != null) {
                java.lang.String f2 = f(eVar);
                if (!android.text.TextUtils.isEmpty(f2)) {
                    new java.io.File(f2).delete();
                }
                eVar.m();
                this.o.remove(str);
                if (this.p == null) {
                    this.p = new java.util.concurrent.ConcurrentHashMap<>();
                }
                this.p.put(eVar.n, eVar);
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.china.common.a.e> concurrentHashMap = this.n;
                if (concurrentHashMap != null) {
                    concurrentHashMap.remove(eVar.n);
                }
                com.anythink.china.common.b.a.a(this.i).c(eVar);
                com.anythink.china.common.b.a.a(this.i).a(eVar, 0L, 100L, true);
                android.content.Intent intent = new android.content.Intent();
                intent.setAction(e);
                intent.setPackage(this.i.getPackageName());
                intent.putExtra(f, eVar.f);
                intent.putExtra(g, eVar.m);
                com.anythink.core.common.k.a(this.i).a(intent);
                com.anythink.core.common.n.c.a(eVar.a, eVar.f, eVar.b, 5, (java.lang.String) null, 0L, 0L);
                if (this.o.size() == 0) {
                    try {
                        android.content.BroadcastReceiver broadcastReceiver = this.t;
                        if (broadcastReceiver != null) {
                            this.i.unregisterReceiver(broadcastReceiver);
                            this.t = null;
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                }
                a(eVar, false);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final com.anythink.china.common.a.a.InterfaceC0157a c(java.lang.String str) {
        return this.m.get(str);
    }

    @Override // com.anythink.china.common.a.g
    public final void c(com.anythink.china.common.a.e eVar) {
        java.lang.String f2 = f(eVar);
        if (android.text.TextUtils.isEmpty(f2)) {
            return;
        }
        java.lang.String str = eVar.c;
        java.io.File file = new java.io.File(f2);
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
                intent.setDataAndType(androidx.core.content.FileProvider.getUriForFile(this.i, this.i.getPackageName() + ".anythink.fileProvider", file), "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(android.net.Uri.parse(org.apache.tools.ant.taskdefs.XSLTLiaison.FILE_PROTOCOL_PREFIX.concat(java.lang.String.valueOf(f2))), "application/vnd.android.package-archive");
            }
            this.i.startActivity(intent);
            com.anythink.core.common.n.c.a(eVar.a, eVar.f, eVar.b, 4, (java.lang.String) null, 0L, file.length());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.anythink.core.common.n.c.a(eVar.a, eVar.f, eVar.b, 10, th.getMessage(), 0L, file.length());
        }
    }

    @Override // com.anythink.china.common.a.g
    public final boolean c() {
        boolean canRequestPackageInstalls;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return true;
        }
        canRequestPackageInstalls = this.i.getPackageManager().canRequestPackageInstalls();
        return canRequestPackageInstalls;
    }

    @Override // com.anythink.china.common.a.g
    @android.annotation.TargetApi(26)
    public final void d() {
        android.content.Intent intent = new android.content.Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", android.net.Uri.parse("package:" + this.i.getPackageName()));
        intent.addFlags(268435456);
        this.i.startActivity(intent);
    }

    @Override // com.anythink.china.common.a.g
    public final void d(com.anythink.china.common.a.e eVar) {
        try {
            if (a(eVar.n)) {
                eVar.l();
                b(eVar);
                return;
            }
            com.anythink.china.common.a.e eVar2 = this.l.get(eVar.n);
            if (eVar2 != null) {
                this.l.remove(eVar.n);
                eVar2.e();
                a(eVar2);
            } else {
                a(eVar);
            }
            b();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[Catch: all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:2:0x0000, B:6:0x000b, B:8:0x0016, B:11:0x001a, B:13:0x002a, B:15:0x0038, B:17:0x003c, B:19:0x0046, B:21:0x004e, B:23:0x005e, B:25:0x0052, B:27:0x005b, B:31:0x0061, B:33:0x0067), top: B:1:0x0000 }] */
    @Override // com.anythink.china.common.a.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() {
        boolean z;
        try {
            java.lang.String a2 = com.anythink.china.common.c.b.a();
            if (android.text.TextUtils.isEmpty(a2)) {
                return;
            }
            java.io.File[] listFiles = new java.io.File(a2).listFiles();
            if (listFiles == null || listFiles.length != 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                long j = this.f155s;
                for (java.io.File file : listFiles) {
                    if (file.getName().endsWith(com.anythink.china.common.a.a.g)) {
                        android.content.Context context = this.i;
                        if (context != null) {
                            java.lang.String a3 = com.anythink.china.common.c.a.a(context, file);
                            if (!android.text.TextUtils.isEmpty(a3)) {
                                z = com.anythink.china.common.c.a.a(context, a3);
                                if (z) {
                                    arrayList.add(file);
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    if (file.lastModified() + j < currentTimeMillis) {
                        arrayList.add(file);
                    }
                }
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    new java.lang.StringBuilder("clean expired file -> ").append(((java.io.File) arrayList.get(i)).getName());
                    ((java.io.File) arrayList.get(i)).delete();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final java.util.Map<java.lang.String, com.anythink.china.common.a.e> f() {
        return this.k;
    }
}
