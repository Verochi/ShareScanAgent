package com.getui.gtc.extension.distribution.gbd.a.b;

/* loaded from: classes22.dex */
public final class d implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String c = "GBD_117";
    private static final java.lang.String d = "_services._dns-sd._udp";
    private static final java.lang.String e = "_raop._tcp";
    private static final java.lang.String f = "_rc._tcp";
    private static final java.lang.String g = "_rdlink._tcp";
    private static final java.lang.String h = "_apple-mobdev2._tcp";
    private static final java.lang.String i = "_airplay._tcp";
    private static final java.lang.String j = "_airkan._tcp";
    private static final java.lang.String k = "_leboremote._tcp";
    private static final java.lang.String l = "_mi-connect._udp";
    private static final java.lang.String m = "_ipp._tcp";
    private static final java.lang.String n = "_airdrop._tcp";
    private static final java.lang.String o = "_companion-link._tcp";
    private static final java.lang.String p = "_dosvc._tcp";
    private static final java.lang.String q = "_smb._tcp";
    private static final int r = 0;

    /* renamed from: s, reason: collision with root package name */
    private static final int f315s = 1;
    private static final int t = 2;
    private static final int u = 3;
    final android.net.nsd.NsdManager a;
    final java.util.concurrent.ThreadPoolExecutor b;
    private final android.content.Context v;
    private final java.util.concurrent.ThreadPoolExecutor w;
    private final java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.l>> x;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ java.util.concurrent.CountDownLatch c;

        public AnonymousClass1(java.lang.String str, boolean z, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = str;
            this.b = z;
            this.c = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.StringBuilder sb;
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "exec " + this.a);
            com.getui.gtc.extension.distribution.gbd.a.b.d dVar = com.getui.gtc.extension.distribution.gbd.a.b.d.this;
            java.lang.String str = this.a;
            boolean z = this.b;
            java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
            java.util.concurrent.locks.Condition newCondition = reentrantLock.newCondition();
            com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass4 anonymousClass4 = dVar.new AnonymousClass4(reentrantLock, newCondition, new java.util.concurrent.atomic.AtomicInteger(0), str, z, dVar.new AnonymousClass3());
            reentrantLock.lock();
            try {
                dVar.a.discoverServices(str, 1, anonymousClass4);
                newCondition.await(com.getui.gtc.extension.distribution.gbd.a.b.d.h.equalsIgnoreCase(str) ? moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME : 2500L, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.Throwable th) {
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "4: " + th.toString());
                    try {
                        dVar.a.stopServiceDiscovery(anonymousClass4);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        sb = new java.lang.StringBuilder("5: ");
                        sb.append(th.toString());
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, sb.toString());
                        reentrantLock.unlock();
                        this.c.countDown();
                    }
                } catch (java.lang.Throwable th3) {
                    try {
                        dVar.a.stopServiceDiscovery(anonymousClass4);
                    } catch (java.lang.Throwable th4) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "5: " + th4.toString());
                    }
                    reentrantLock.unlock();
                    throw th3;
                }
            }
            try {
                dVar.a.stopServiceDiscovery(anonymousClass4);
            } catch (java.lang.Throwable th5) {
                th = th5;
                sb = new java.lang.StringBuilder("5: ");
                sb.append(th.toString());
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, sb.toString());
                reentrantLock.unlock();
                this.c.countDown();
            }
            reentrantLock.unlock();
            this.c.countDown();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.d$2, reason: invalid class name */
    public class AnonymousClass2 implements android.net.nsd.NsdManager.DiscoveryListener {
        final /* synthetic */ java.util.List a;

        public AnonymousClass2(java.util.List list) {
            this.a = list;
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onDiscoveryStarted(java.lang.String str) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onDiscoveryStopped(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "onDiscoveryStopped: ".concat(java.lang.String.valueOf(str)));
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onServiceFound(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
            java.lang.String serviceName = nsdServiceInfo.getServiceName();
            java.lang.String serviceType = nsdServiceInfo.getServiceType();
            if (android.text.TextUtils.isEmpty(serviceName) || android.text.TextUtils.isEmpty(serviceType)) {
                return;
            }
            java.lang.String str = serviceName + "." + serviceType.replace(".local", "").replace(".", "");
            if (this.a.contains(str)) {
                return;
            }
            this.a.add(str);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onServiceLost(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "onServiceLost: ".concat(java.lang.String.valueOf(nsdServiceInfo)));
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onStartDiscoveryFailed(java.lang.String str, int i) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "onStartDiscoveryFailed: " + str + ", errorCode = " + i);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onStopDiscoveryFailed(java.lang.String str, int i) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "onStopDiscoveryFailed: " + str + ", errorCode = " + i);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.d$3, reason: invalid class name */
    public class AnonymousClass3 implements android.net.nsd.NsdManager.ResolveListener {
        public AnonymousClass3() {
        }

        @Override // android.net.nsd.NsdManager.ResolveListener
        public final void onResolveFailed(android.net.nsd.NsdServiceInfo nsdServiceInfo, int i) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "onResolveFailed: " + nsdServiceInfo + ", errorCode = " + i);
        }

        @Override // android.net.nsd.NsdManager.ResolveListener
        public final void onServiceResolved(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
            if (nsdServiceInfo != null) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "onServiceResolved: ".concat(java.lang.String.valueOf(nsdServiceInfo)));
                com.getui.gtc.extension.distribution.gbd.a.b.d.a(com.getui.gtc.extension.distribution.gbd.a.b.d.this, nsdServiceInfo);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.d$4, reason: invalid class name */
    public class AnonymousClass4 implements android.net.nsd.NsdManager.DiscoveryListener {
        final /* synthetic */ java.util.concurrent.locks.ReentrantLock a;
        final /* synthetic */ java.util.concurrent.locks.Condition b;
        final /* synthetic */ java.util.concurrent.atomic.AtomicInteger c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ boolean e;
        final /* synthetic */ android.net.nsd.NsdManager.ResolveListener f;

        /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.d$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.net.nsd.NsdServiceInfo a;

            public AnonymousClass1(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
                this.a = nsdServiceInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass4 anonymousClass4 = com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass4.this;
                    com.getui.gtc.extension.distribution.gbd.a.b.d.this.a.resolveService(this.a, anonymousClass4.f);
                    java.lang.Thread.sleep(com.getui.gtc.extension.distribution.gbd.d.d.db);
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "6: " + th.toString());
                }
            }
        }

        public AnonymousClass4(java.util.concurrent.locks.ReentrantLock reentrantLock, java.util.concurrent.locks.Condition condition, java.util.concurrent.atomic.AtomicInteger atomicInteger, java.lang.String str, boolean z, android.net.nsd.NsdManager.ResolveListener resolveListener) {
            this.a = reentrantLock;
            this.b = condition;
            this.c = atomicInteger;
            this.d = str;
            this.e = z;
            this.f = resolveListener;
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onDiscoveryStarted(java.lang.String str) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onDiscoveryStopped(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "onDiscoveryStopped: ".concat(java.lang.String.valueOf(str)));
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onServiceFound(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
            if (this.c.getAndIncrement() >= 20 || nsdServiceInfo == null) {
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, this.d + ", discover: " + nsdServiceInfo.toString());
            com.getui.gtc.extension.distribution.gbd.a.b.d.a(com.getui.gtc.extension.distribution.gbd.a.b.d.this, nsdServiceInfo);
            if (this.e) {
                com.getui.gtc.extension.distribution.gbd.a.b.d.this.b.execute(new com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass4.AnonymousClass1(nsdServiceInfo));
            }
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onServiceLost(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onStartDiscoveryFailed(java.lang.String str, int i) {
            this.a.lock();
            try {
                this.b.signal();
            } finally {
                this.a.unlock();
            }
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onStopDiscoveryFailed(java.lang.String str, int i) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.d.c, "onStopDiscoveryFailed: ".concat(java.lang.String.valueOf(str)));
        }
    }

    public static class a {
        private static final com.getui.gtc.extension.distribution.gbd.a.b.d a = new com.getui.gtc.extension.distribution.gbd.a.b.d((byte) 0);

        private a() {
        }
    }

    private d() {
        this.x = new java.util.concurrent.ConcurrentHashMap();
        android.content.Context context = com.getui.gtc.extension.distribution.gbd.d.c.d;
        this.v = context;
        this.a = (android.net.nsd.NsdManager) context.getSystemService("servicediscovery");
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(5, 10, 4L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(256));
        this.w = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor2 = new java.util.concurrent.ThreadPoolExecutor(1, 1, 1L, timeUnit, new java.util.concurrent.LinkedBlockingQueue(256));
        this.b = threadPoolExecutor2;
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    private java.lang.String a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String replace = str.replace(".", "");
        if (this.x.containsKey(replace)) {
            for (com.getui.gtc.extension.distribution.gbd.c.l lVar : this.x.get(replace).values()) {
                java.lang.String replace2 = lVar.a.replace("#", "");
                java.lang.String replace3 = lVar.b.replace("#", "");
                sb.append(replace2);
                sb.append("#");
                sb.append(replace3);
                sb.append("#");
                if (!android.text.TextUtils.isEmpty(lVar.c)) {
                    sb.append(lVar.c.replace("#", "").replace("\n", ""));
                }
                sb.append(com.alipay.sdk.m.u.i.b);
            }
            if (sb.toString().endsWith(com.alipay.sdk.m.u.i.b)) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    private void a(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
        java.lang.String replace = nsdServiceInfo.getServiceType().replace(".local", "").replace(".", "");
        java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.l> map = this.x.get(replace);
        if (map != null && (map instanceof java.util.concurrent.ConcurrentHashMap)) {
            map.put(nsdServiceInfo.getServiceName(), new com.getui.gtc.extension.distribution.gbd.c.l(nsdServiceInfo));
            return;
        }
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
        concurrentHashMap.put(nsdServiceInfo.getServiceName(), new com.getui.gtc.extension.distribution.gbd.c.l(nsdServiceInfo));
        this.x.put(replace, concurrentHashMap);
    }

    public static /* synthetic */ void a(com.getui.gtc.extension.distribution.gbd.a.b.d dVar, android.net.nsd.NsdServiceInfo nsdServiceInfo) {
        java.lang.String replace = nsdServiceInfo.getServiceType().replace(".local", "").replace(".", "");
        java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.l> map = dVar.x.get(replace);
        if (map != null && (map instanceof java.util.concurrent.ConcurrentHashMap)) {
            map.put(nsdServiceInfo.getServiceName(), new com.getui.gtc.extension.distribution.gbd.c.l(nsdServiceInfo));
            return;
        }
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
        concurrentHashMap.put(nsdServiceInfo.getServiceName(), new com.getui.gtc.extension.distribution.gbd.c.l(nsdServiceInfo));
        dVar.x.put(replace, concurrentHashMap);
    }

    private static void a(java.lang.String str, int i2) {
        java.lang.String str2;
        if (com.getui.gtc.extension.distribution.gbd.d.d.cZ) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append(i2);
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(sb.toString(), 117);
            str2 = "save type = 117, data = " + sb.toString();
        } else {
            str2 = "not r empty.";
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, str2);
    }

    private void a(java.lang.String str, java.lang.String str2, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "package data, 117");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.getui.gtc.extension.distribution.gbd.c.t a2 = com.getui.gtc.extension.distribution.gbd.n.o.a();
        java.lang.String b = com.getui.gtc.extension.distribution.gbd.n.o.b();
        sb.append(str);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb.append("|");
        sb.append(a2.b);
        sb.append("#");
        sb.append(a2.a);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.o.d());
        sb.append("|");
        sb.append(b);
        sb.append("|");
        sb.append(str2);
        sb.append("|");
        sb.append(a(str2));
        sb.append("|");
        if (d.equalsIgnoreCase(str2)) {
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(com.alipay.sdk.m.u.i.b);
            }
            if (sb.toString().endsWith(com.alipay.sdk.m.u.i.b)) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append("|");
        if (d.equalsIgnoreCase(str2)) {
            for (java.lang.String str3 : list2) {
                if (!d.equals(str3)) {
                    sb.append(str3);
                    sb.append(com.alipay.sdk.m.u.i.b);
                }
            }
            if (sb.toString().endsWith(com.alipay.sdk.m.u.i.b)) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append("|");
        sb.append(0);
        com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(sb.toString(), 117);
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "save type = 117, data = " + sb.toString());
    }

    private void a(java.lang.String str, boolean z) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        java.util.concurrent.locks.Condition newCondition = reentrantLock.newCondition();
        com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass4 anonymousClass4 = new com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass4(reentrantLock, newCondition, new java.util.concurrent.atomic.AtomicInteger(0), str, z, new com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass3());
        reentrantLock.lock();
        try {
            this.a.discoverServices(str, 1, anonymousClass4);
            newCondition.await(h.equalsIgnoreCase(str) ? moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME : 2500L, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "4: " + th.toString());
                try {
                    this.a.stopServiceDiscovery(anonymousClass4);
                } catch (java.lang.Throwable th2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "5: " + th2.toString());
                }
                reentrantLock.unlock();
            } finally {
                try {
                    this.a.stopServiceDiscovery(anonymousClass4);
                } catch (java.lang.Throwable th3) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "5: " + th3.toString());
                }
                reentrantLock.unlock();
            }
        }
    }

    private static void a(java.util.List<java.lang.String> list) {
        if (list.contains(e)) {
            list.remove(i);
            list.remove(k);
        } else if (list.contains(i)) {
            list.remove(k);
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.a.b.d f() {
        return com.getui.gtc.extension.distribution.gbd.a.b.d.a.a;
    }

    private java.util.List<java.lang.String> g() {
        java.lang.StringBuilder sb;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        java.util.concurrent.locks.Condition newCondition = reentrantLock.newCondition();
        com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass2 anonymousClass2 = new com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass2(arrayList);
        reentrantLock.lock();
        try {
            this.a.discoverServices(d, 1, anonymousClass2);
            newCondition.await(500L, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "2: " + th.toString());
                try {
                    this.a.stopServiceDiscovery(anonymousClass2);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    sb = new java.lang.StringBuilder("3: ");
                    sb.append(th.toString());
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, sb.toString());
                    reentrantLock.unlock();
                    return arrayList;
                }
            } catch (java.lang.Throwable th3) {
                try {
                    this.a.stopServiceDiscovery(anonymousClass2);
                } catch (java.lang.Throwable th4) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "3: " + th4.toString());
                }
                reentrantLock.unlock();
                throw th3;
            }
        }
        try {
            this.a.stopServiceDiscovery(anonymousClass2);
        } catch (java.lang.Throwable th5) {
            th = th5;
            sb = new java.lang.StringBuilder("3: ");
            sb.append(th.toString());
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, sb.toString());
            reentrantLock.unlock();
            return arrayList;
        }
        reentrantLock.unlock();
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f4, code lost:
    
        if (r5.contains(com.getui.gtc.extension.distribution.gbd.a.b.d.i) != false) goto L26;
     */
    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "report 117.");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(currentTimeMillis));
        if (!com.getui.gtc.extension.distribution.gbd.n.l.g(this.v)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "not wifi.");
            a(format, 1);
            return;
        }
        if (!com.getui.gtc.extension.distribution.gbd.n.l.o(this.v)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "not s.");
            a(format, 2);
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "dy: " + com.getui.gtc.extension.distribution.gbd.d.d.cW);
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cW)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "dy list empty.");
            a(format, 3);
            return;
        }
        java.util.List<java.lang.String> g2 = g();
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "support protocol: ".concat(java.lang.String.valueOf(g2)));
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.cW.split(",")) {
            java.lang.String[] split = str.trim().split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            if (split.length >= 2) {
                try {
                    hashMap.put(split[0].trim(), java.lang.Boolean.valueOf(split[1]));
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "1: " + th.toString());
                }
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(hashMap.keySet());
        arrayList.retainAll(g2);
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "retainList before: ".concat(java.lang.String.valueOf(arrayList)));
        if (arrayList.contains(e)) {
            arrayList.remove(i);
        }
        arrayList.remove(k);
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "retainList after: ".concat(java.lang.String.valueOf(arrayList)));
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(arrayList.size());
        for (java.lang.String str2 : arrayList) {
            this.w.execute(new com.getui.gtc.extension.distribution.gbd.a.b.d.AnonymousClass1(str2, ((java.lang.Boolean) hashMap.get(str2)).booleanValue(), countDownLatch));
            try {
                java.lang.Thread.sleep(com.getui.gtc.extension.distribution.gbd.d.d.da);
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, th2.toString());
            }
        }
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "cdl begin.");
            countDownLatch.await(8000L, java.util.concurrent.TimeUnit.MILLISECONDS);
            java.lang.Thread.sleep(1000L);
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "cdl end.");
        } catch (java.lang.Throwable th3) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, th3.toString());
        }
        arrayList.add(0, d);
        java.util.Iterator<java.lang.String> it = arrayList.iterator();
        while (it.hasNext()) {
            a(format, it.next(), g2, arrayList);
        }
        com.getui.gtc.extension.distribution.gbd.k.a.k.e().a(currentTimeMillis);
        com.getui.gtc.extension.distribution.gbd.k.a.k.e().a();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 117;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return null;
    }
}
