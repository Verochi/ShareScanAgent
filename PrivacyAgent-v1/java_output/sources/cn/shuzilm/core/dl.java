package cn.shuzilm.core;

/* loaded from: classes.dex */
public class dl {
    private static android.content.Context b;
    private static android.net.nsd.NsdManager c;
    private static java.util.LinkedList d = new java.util.LinkedList();
    private static org.json.JSONObject e = new org.json.JSONObject();
    private static org.json.JSONObject f = null;
    private static java.util.Timer g = null;
    private static int h = 0;
    private static int i = 0;
    private static java.lang.String j = "";
    private static java.lang.String k = "";
    private static java.lang.String l = "";
    private static java.lang.String m = "";
    private static int n = 0;
    private static int o = -1;
    private static int p = -1;
    private static int q = -1;
    private static int r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static java.lang.String f75s = null;
    private static java.lang.String t = null;
    private static int u = 0;
    private static java.lang.String v = "";
    static int a = 0;

    /* renamed from: cn.shuzilm.core.dl$1, reason: invalid class name */
    class AnonymousClass1 implements android.net.nsd.NsdManager.RegistrationListener {
        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onRegistrationFailed(android.net.nsd.NsdServiceInfo nsdServiceInfo, int i) {
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onServiceRegistered(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onServiceUnregistered(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
        }

        @Override // android.net.nsd.NsdManager.RegistrationListener
        public void onUnregistrationFailed(android.net.nsd.NsdServiceInfo nsdServiceInfo, int i) {
        }
    }

    /* renamed from: cn.shuzilm.core.dl$2, reason: invalid class name */
    class AnonymousClass2 implements android.net.nsd.NsdManager.DiscoveryListener {
        final /* synthetic */ int a;

        public AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onDiscoveryStarted(java.lang.String str) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onDiscoveryStopped(java.lang.String str) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onServiceFound(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
            java.lang.String serviceName = nsdServiceInfo.getServiceName();
            java.lang.String serviceType = nsdServiceInfo.getServiceType();
            int i = this.a;
            if (i == 1) {
                cn.shuzilm.core.dl.c(serviceName, serviceType);
            } else if (i == 2) {
                cn.shuzilm.core.dl.d(serviceName, serviceType);
            }
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onServiceLost(android.net.nsd.NsdServiceInfo nsdServiceInfo) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onStartDiscoveryFailed(java.lang.String str, int i) {
            cn.shuzilm.core.dl.b(cn.shuzilm.core.dl.c, this);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onStopDiscoveryFailed(java.lang.String str, int i) {
            cn.shuzilm.core.dl.b(cn.shuzilm.core.dl.c, this);
        }
    }

    /* renamed from: cn.shuzilm.core.dl$3, reason: invalid class name */
    class AnonymousClass3 extends android.net.wifi.rtt.RangingResultCallback {
        @Override // android.net.wifi.rtt.RangingResultCallback
        public void onRangingFailure(int i) {
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                cn.shuzilm.core.dl.e.put("wr", currentTimeMillis + ";err_" + i + com.alipay.sdk.m.u.i.b);
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // android.net.wifi.rtt.RangingResultCallback
        public void onRangingResults(java.util.List list) {
            int status;
            int distanceMm;
            int rssi;
            if (list == null) {
                return;
            }
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(java.lang.System.currentTimeMillis() + com.alipay.sdk.m.u.i.b);
                for (int i = 0; i < list.size(); i++) {
                    android.net.wifi.rtt.RangingResult rangingResult = (android.net.wifi.rtt.RangingResult) list.get(i);
                    status = rangingResult.getStatus();
                    if (status == 0) {
                        try {
                            java.lang.Object invoke = rangingResult.getClass().getMethod(cn.shuzilm.core.dl.h("\\ZiBVX6YYgZhh"), new java.lang.Class[0]).invoke(rangingResult, new java.lang.Object[0]);
                            if (invoke != null) {
                                sb.append(invoke.toString().replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, ""));
                            }
                        } catch (java.lang.Throwable unused) {
                        }
                        sb.append(",");
                        distanceMm = rangingResult.getDistanceMm();
                        rssi = rangingResult.getRssi();
                        sb.append(distanceMm + "," + rssi);
                        sb.append(com.alipay.sdk.m.u.i.b);
                    }
                }
                cn.shuzilm.core.dl.e.put("wr", sb.toString());
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    /* renamed from: cn.shuzilm.core.dl$4, reason: invalid class name */
    class AnonymousClass4 extends android.net.ConnectivityManager.NetworkCallback {
        final /* synthetic */ int a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass4(int i, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = i;
            this.b = countDownLatch;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            java.lang.String b = cn.shuzilm.core.dl.b(network, cn.shuzilm.core.DUHelper.c(cn.shuzilm.core.dl.b, 101, (java.lang.String) null), 0);
            java.lang.String unused = cn.shuzilm.core.dl.f75s = b;
            if (b == null) {
                b = "0";
            }
            if (this.a == 1) {
                cn.shuzilm.core.DUHelper.c(cn.shuzilm.core.dl.b, 201, b);
            }
            this.b.countDown();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            this.b.countDown();
        }
    }

    /* renamed from: cn.shuzilm.core.dl$5, reason: invalid class name */
    class AnonymousClass5 extends android.net.ConnectivityManager.NetworkCallback {
        final /* synthetic */ int a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass5(int i, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = i;
            this.b = countDownLatch;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            java.lang.String b = cn.shuzilm.core.dl.b(network, cn.shuzilm.core.DUHelper.c(cn.shuzilm.core.dl.b, 101, (java.lang.String) null), 0);
            java.lang.String unused = cn.shuzilm.core.dl.t = b;
            if (b == null) {
                b = "0";
            }
            if (this.a == 1) {
                cn.shuzilm.core.DUHelper.c(cn.shuzilm.core.dl.b, 202, b);
            }
            this.b.countDown();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            this.b.countDown();
        }
    }

    /* renamed from: cn.shuzilm.core.dl$6, reason: invalid class name */
    class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass6(int i, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = i;
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String b = cn.shuzilm.core.dl.b(null, cn.shuzilm.core.DUHelper.c(cn.shuzilm.core.dl.b, 101, (java.lang.String) null), 0);
            if (b == null) {
                b = "0";
            }
            if (this.a == 1) {
                cn.shuzilm.core.DUHelper.c(cn.shuzilm.core.dl.b, 203, b);
            }
            this.b.countDown();
        }
    }

    /* renamed from: cn.shuzilm.core.dl$7, reason: invalid class name */
    class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass7(boolean z, java.lang.String str) {
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                cn.shuzilm.core.dl.a++;
            } catch (java.lang.Throwable unused) {
            }
            if (this.a) {
                cn.shuzilm.core.dl.q();
                return;
            }
            int r = cn.shuzilm.core.dl.r();
            if (cn.shuzilm.core.t.i(cn.shuzilm.core.dl.b) && cn.shuzilm.core.dl.h <= 0) {
                java.lang.String str = this.b;
                java.lang.String unused2 = cn.shuzilm.core.dl.j = (str == null || str.length() <= 10) ? "a60c" : this.b.substring(2, 10).replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "Z").replace("_", "l");
                java.lang.String unused3 = cn.shuzilm.core.dl.k = java.lang.Integer.toHexString(cn.shuzilm.core.dl.b.getPackageName().hashCode());
                cn.shuzilm.core.dl.g(cn.shuzilm.core.dl.h("h#TYch\"hY#TjYe"));
                cn.shuzilm.core.dl.q();
                cn.shuzilm.core.dl.n();
            }
            cn.shuzilm.core.dl.c(1);
            try {
                java.lang.Thread.sleep(1000L);
            } catch (java.lang.Exception unused4) {
            }
            if (cn.shuzilm.core.dl.e.length() > 0) {
                cn.shuzilm.core.dl.e.put("wrs", "" + r);
            }
            if (cn.shuzilm.core.dl.e != null) {
                cn.shuzilm.core.dl.e.put("i", cn.shuzilm.core.dl.f75s + "," + cn.shuzilm.core.dl.t + com.alipay.sdk.m.u.i.b);
            }
            cn.shuzilm.core.dl.o();
        }
    }

    class sd extends java.util.TimerTask {
        android.net.nsd.NsdManager.DiscoveryListener a;
        android.net.nsd.NsdManager b;
        int c;
        java.lang.String d;

        public sd(android.net.nsd.NsdManager nsdManager, android.net.nsd.NsdManager.DiscoveryListener discoveryListener, int i, java.lang.String str) {
            this.a = discoveryListener;
            this.b = nsdManager;
            this.c = i;
            this.d = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            java.lang.String str;
            synchronized (this) {
                try {
                    cn.shuzilm.core.dl.b(this.b, this.a);
                    if (this.c == 2) {
                        int length = cn.shuzilm.core.dl.f.length();
                        if (cn.shuzilm.core.dl.f != null && length > 0 && cn.shuzilm.core.dl.e.length() + length < 4096) {
                            cn.shuzilm.core.dl.e.put(this.d, cn.shuzilm.core.dl.f);
                        }
                    }
                    if (cn.shuzilm.core.dl.d != null && cn.shuzilm.core.dl.d.size() > 0 && (str = (java.lang.String) cn.shuzilm.core.dl.d.poll()) != null) {
                        cn.shuzilm.core.dl.c(str, 2);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r3 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String b(android.net.Network network, java.lang.String str, int i2) {
        java.io.InputStream inputStream;
        java.lang.String str2;
        java.io.InputStream inputStream2 = null;
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            java.net.URLConnection openConnection = network != null ? network.openConnection(new java.net.URL(str)) : (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            if (openConnection == null) {
                return null;
            }
            openConnection.setConnectTimeout(5000);
            openConnection.setReadTimeout(5000);
            openConnection.setDoInput(true);
            openConnection.connect();
            if (((java.net.HttpURLConnection) openConnection).getResponseCode() == 200) {
                inputStream = openConnection.getInputStream();
                try {
                    str2 = new java.lang.String(cn.shuzilm.core.t.b(inputStream));
                    inputStream2 = inputStream;
                } catch (java.lang.Throwable unused) {
                    if (inputStream == null) {
                        return null;
                    }
                    str2 = null;
                    inputStream2 = inputStream;
                    try {
                        inputStream2.close();
                    } catch (java.lang.Exception unused2) {
                    }
                    return str2;
                }
            } else {
                str2 = null;
            }
        } catch (java.lang.Throwable unused3) {
            inputStream = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:8|(3:9|10|11)|(3:77|78|(17:80|(1:82)|18|19|20|(3:64|65|(12:67|(1:69)|25|26|27|28|29|(5:57|58|33|(1:36)|(1:43)(3:39|40|41))(1:31)|32|33|(1:36)|(1:43)(1:44)))|(7:63|29|(0)(0)|32|33|(0)|(0)(0))|25|26|27|28|29|(0)(0)|32|33|(0)|(0)(0)))|(11:75|76|(0)|(1:23)|63|29|(0)(0)|32|33|(0)|(0)(0))|18|19|20|(0)|(0)|63|29|(0)(0)|32|33|(0)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:80|(1:82)|18|19|20|(3:64|65|(12:67|(1:69)|25|26|27|28|29|(5:57|58|33|(1:36)|(1:43)(3:39|40|41))(1:31)|32|33|(1:36)|(1:43)(1:44)))|(7:63|29|(0)(0)|32|33|(0)|(0)(0))|25|26|27|28|29|(0)(0)|32|33|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0099, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a A[Catch: all -> 0x0076, TryCatch #1 {all -> 0x0076, blocks: (B:65:0x006d, B:67:0x0071, B:25:0x007e, B:29:0x00a8, B:58:0x00ac, B:33:0x00c6, B:31:0x00be, B:32:0x00ba, B:23:0x007a, B:63:0x009c), top: B:64:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be A[Catch: all -> 0x0076, TryCatch #1 {all -> 0x0076, blocks: (B:65:0x006d, B:67:0x0071, B:25:0x007e, B:29:0x00a8, B:58:0x00ac, B:33:0x00c6, B:31:0x00be, B:32:0x00ba, B:23:0x007a, B:63:0x009c), top: B:64:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(int i2) {
        android.net.ConnectivityManager.NetworkCallback networkCallback;
        cn.shuzilm.core.dl.AnonymousClass4 anonymousClass4;
        android.net.ConnectivityManager connectivityManager;
        java.util.concurrent.CountDownLatch countDownLatch;
        if (android.os.Build.VERSION.SDK_INT < 23 || p != 0) {
            return;
        }
        android.net.ConnectivityManager.NetworkCallback networkCallback2 = null;
        try {
            try {
                countDownLatch = new java.util.concurrent.CountDownLatch(3);
                connectivityManager = (android.net.ConnectivityManager) b.getSystemService("connectivity");
            } catch (java.lang.Exception unused) {
                return;
            }
        } catch (java.lang.Throwable unused2) {
            networkCallback = null;
            anonymousClass4 = null;
        }
        if (i2 == 0) {
            try {
            } catch (java.lang.Throwable unused3) {
                networkCallback = null;
                anonymousClass4 = null;
                networkCallback2 = connectivityManager;
                connectivityManager = networkCallback2;
                networkCallback2 = networkCallback;
                if (connectivityManager != null) {
                }
                if (connectivityManager != null) {
                }
            }
            if (q == 0) {
                if (r != 0) {
                }
                android.net.NetworkRequest build = new android.net.NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                anonymousClass4 = new cn.shuzilm.core.dl.AnonymousClass4(i2, countDownLatch);
                connectivityManager.requestNetwork(build, anonymousClass4);
                if (i2 == 0) {
                    try {
                    } catch (java.lang.Throwable unused4) {
                        networkCallback = networkCallback2;
                        networkCallback2 = connectivityManager;
                        connectivityManager = networkCallback2;
                        networkCallback2 = networkCallback;
                        if (connectivityManager != null && anonymousClass4 != null) {
                            connectivityManager.unregisterNetworkCallback(anonymousClass4);
                        }
                        if (connectivityManager != null || networkCallback2 == null) {
                            return;
                        }
                        connectivityManager.unregisterNetworkCallback(networkCallback2);
                        return;
                    }
                    if (o == 0) {
                        if (r != 0) {
                        }
                        android.net.NetworkRequest build2 = new android.net.NetworkRequest.Builder().addCapability(12).addTransportType(1).build();
                        cn.shuzilm.core.dl.AnonymousClass5 anonymousClass5 = new cn.shuzilm.core.dl.AnonymousClass5(i2, countDownLatch);
                        connectivityManager.requestNetwork(build2, anonymousClass5);
                        networkCallback2 = anonymousClass5;
                        if (o == 0) {
                            try {
                                new java.lang.Thread(new cn.shuzilm.core.dl.AnonymousClass6(i2, countDownLatch)).start();
                            } catch (java.lang.Exception unused5) {
                            }
                            countDownLatch.await(com.anythink.expressad.d.a.b.aC, java.util.concurrent.TimeUnit.MILLISECONDS);
                            if (connectivityManager != null && anonymousClass4 != null) {
                                connectivityManager.unregisterNetworkCallback(anonymousClass4);
                            }
                            if (connectivityManager != null || networkCallback2 == null) {
                                return;
                            }
                            connectivityManager.unregisterNetworkCallback(networkCallback2);
                            return;
                        }
                        cn.shuzilm.core.DUHelper.c(b, 203, "0");
                        countDownLatch.countDown();
                        countDownLatch.await(com.anythink.expressad.d.a.b.aC, java.util.concurrent.TimeUnit.MILLISECONDS);
                        if (connectivityManager != null) {
                            connectivityManager.unregisterNetworkCallback(anonymousClass4);
                        }
                        if (connectivityManager != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (i2 == 1 || r != 0) {
                    countDownLatch.countDown();
                    cn.shuzilm.core.DUHelper.c(b, 202, "0");
                    t = "0";
                    if (o == 0) {
                    }
                    countDownLatch.countDown();
                    countDownLatch.await(com.anythink.expressad.d.a.b.aC, java.util.concurrent.TimeUnit.MILLISECONDS);
                    if (connectivityManager != null) {
                    }
                    if (connectivityManager != null) {
                    }
                }
                android.net.NetworkRequest build22 = new android.net.NetworkRequest.Builder().addCapability(12).addTransportType(1).build();
                cn.shuzilm.core.dl.AnonymousClass5 anonymousClass52 = new cn.shuzilm.core.dl.AnonymousClass5(i2, countDownLatch);
                connectivityManager.requestNetwork(build22, anonymousClass52);
                networkCallback2 = anonymousClass52;
                if (o == 0) {
                }
                countDownLatch.countDown();
                countDownLatch.await(com.anythink.expressad.d.a.b.aC, java.util.concurrent.TimeUnit.MILLISECONDS);
                if (connectivityManager != null) {
                }
                if (connectivityManager != null) {
                }
            }
        }
        if ((i2 != 0 || q != 0 || o != 0) && (i2 != 1 || q != 0)) {
            countDownLatch.countDown();
            cn.shuzilm.core.DUHelper.c(b, 201, "0");
            f75s = "0";
            anonymousClass4 = null;
            if (i2 == 0) {
            }
            if (i2 == 1) {
            }
            countDownLatch.countDown();
            cn.shuzilm.core.DUHelper.c(b, 202, "0");
            t = "0";
            if (o == 0) {
            }
            countDownLatch.countDown();
            countDownLatch.await(com.anythink.expressad.d.a.b.aC, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (connectivityManager != null) {
            }
            if (connectivityManager != null) {
            }
        }
        android.net.NetworkRequest build3 = new android.net.NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        anonymousClass4 = new cn.shuzilm.core.dl.AnonymousClass4(i2, countDownLatch);
        connectivityManager.requestNetwork(build3, anonymousClass4);
        if (i2 == 0) {
        }
        if (i2 == 1) {
        }
        countDownLatch.countDown();
        cn.shuzilm.core.DUHelper.c(b, 202, "0");
        t = "0";
        if (o == 0) {
        }
        countDownLatch.countDown();
        countDownLatch.await(com.anythink.expressad.d.a.b.aC, java.util.concurrent.TimeUnit.MILLISECONDS);
        if (connectivityManager != null) {
        }
        if (connectivityManager != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.net.nsd.NsdManager nsdManager, android.net.nsd.NsdManager.DiscoveryListener discoveryListener) {
        try {
            nsdManager.stopServiceDiscovery(discoveryListener);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void b(java.lang.String str, int i2) {
        cn.shuzilm.core.dl.AnonymousClass1 anonymousClass1;
        try {
            anonymousClass1 = new cn.shuzilm.core.dl.AnonymousClass1();
            try {
                android.net.nsd.NsdServiceInfo nsdServiceInfo = new android.net.nsd.NsdServiceInfo();
                nsdServiceInfo.setServiceName(str);
                nsdServiceInfo.setServiceType(l);
                nsdServiceInfo.setPort(i2);
                c.registerService(nsdServiceInfo, 1, anonymousClass1);
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
            anonymousClass1 = null;
        }
        try {
            c.unregisterService(anonymousClass1);
        } catch (java.lang.Throwable unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(int i2) {
        synchronized (cn.shuzilm.core.dl.class) {
            if (cn.shuzilm.core.t.p(b, "android.permission.CHANGE_NETWORK_STATE")) {
                t();
                b(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(java.lang.String str, int i2) {
        synchronized (cn.shuzilm.core.dl.class) {
            try {
                cn.shuzilm.core.dl.AnonymousClass2 anonymousClass2 = new cn.shuzilm.core.dl.AnonymousClass2(i2);
                f = new org.json.JSONObject();
                c.discoverServices(str, 1, anonymousClass2);
                if (g == null) {
                    g = new java.util.Timer();
                }
                g.schedule(new cn.shuzilm.core.dl.sd(c, anonymousClass2, i2, str), 500L);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(java.lang.String str, java.lang.String str2) {
        synchronized (cn.shuzilm.core.dl.class) {
            try {
                if (str2.contains(".")) {
                    d.add(str + "." + str2.split("\\.")[0] + ".");
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void d(android.content.Context context, java.lang.String str, boolean z) {
        android.content.Context applicationContext;
        if (a > 0) {
            return;
        }
        try {
            applicationContext = context.getApplicationContext();
            b = applicationContext;
        } catch (java.lang.Throwable unused) {
        }
        if (applicationContext == null) {
            return;
        }
        new java.lang.Thread(new cn.shuzilm.core.dl.AnonymousClass7(z, str)).start();
        a++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(java.lang.String str, java.lang.String str2) {
        synchronized (cn.shuzilm.core.dl.class) {
            try {
                if (str2.equals(l) && str != null && str.contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    if (split.length >= 3) {
                        if ((split[1] + split[2]).equals(k + j)) {
                            i = 1;
                        }
                    }
                }
                f.put(java.lang.String.valueOf(f.length()), str);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(java.lang.String str) {
        java.util.LinkedList linkedList;
        try {
            l = h("TV^geaVn#TiXe#");
            org.json.JSONObject jSONObject = e;
            if (jSONObject != null && jSONObject.length() <= 0 && (linkedList = d) != null && linkedList.size() <= 0) {
                c = (android.net.nsd.NsdManager) b.getSystemService("servicediscovery");
                c("_service" + str + ".", 1);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String h(java.lang.String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            bytes[i2] = (byte) (bytes[i2] + 11);
        }
        return new java.lang.String(bytes);
    }

    public static synchronized void ia(android.content.Context context) {
        synchronized (cn.shuzilm.core.dl.class) {
            b = context;
            if (n == 0) {
                p = 0;
                m = "";
            }
            c(1);
            n++;
        }
    }

    private static int m() {
        int hashCode = (android.os.Build.DISPLAY + java.lang.String.valueOf(new java.util.Random().nextInt())).hashCode() % 227;
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode + 29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        try {
            if (h <= 0 && i == 0) {
                h = new java.util.Random().nextInt(20000) + com.google.android.exoplayer2.audio.MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
                java.lang.String str = com.umeng.analytics.pro.bo.aJ + java.lang.Long.toHexString(java.lang.System.currentTimeMillis()) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + k + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + j;
                b(str, h);
                e.put("sn", str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        cn.shuzilm.core.DUHelper.bm(b, e.toString());
    }

    private static java.lang.String p() {
        android.net.Network activeNetwork;
        java.lang.String str = "";
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return "";
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) b.getSystemService("connectivity");
        activeNetwork = connectivityManager.getActiveNetwork();
        android.net.LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
        if (linkProperties == null) {
            return "";
        }
        java.lang.String interfaceName = linkProperties.getInterfaceName();
        if (interfaceName != null && interfaceName.contains("wlan")) {
            java.util.List<android.net.LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
            int size = linkAddresses.size();
            for (int i2 = 0; i2 < size; i2++) {
                java.lang.String linkAddress = linkAddresses.get(i2).toString();
                if (linkAddress != null && linkAddress.contains(".") && !linkAddress.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                    str = linkAddress.substring(0, linkAddress.lastIndexOf(".") + 1);
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
        int p2;
        int m2 = m();
        try {
            if ((java.lang.System.currentTimeMillis() / 1000) - (b.getPackageManager().getPackageInfo(b.getPackageName(), 0).lastUpdateTime / 1000) < 35000) {
                m2 = 5;
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.String p3 = p();
            if ((p3 == null || p3 != "") && (p2 = cn.shuzilm.core.t.p(b)) != 0) {
                p3 = (p2 & 255) + "." + ((p2 >> 8) & 255) + "." + ((p2 >> 16) & 255) + ".";
            }
            if (p3 == null || p3 == "") {
                return;
            }
            if (p3.lastIndexOf(".") == p3.length() - 1) {
                for (int i2 = 1; i2 < m2; i2++) {
                    java.net.InetAddress.getByName(p3 + java.lang.String.valueOf(i2)).isReachable(60);
                }
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r() {
        int maxPeers;
        boolean isAvailable;
        int size;
        android.net.wifi.rtt.RangingRequest build;
        java.util.concurrent.Executor mainExecutor;
        if (cn.shuzilm.core.DUHelper.mPopu == 10001) {
            return -6;
        }
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 < 28) {
            return -1;
        }
        android.content.pm.PackageManager packageManager = b.getPackageManager();
        java.lang.String packageName = b.getPackageName();
        int checkPermission = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName);
        int checkPermission2 = packageManager.checkPermission("android.permission.CHANGE_WIFI_STATE", packageName);
        int checkPermission3 = packageManager.checkPermission("android.permission.ACCESS_WIFI_STATE", packageName);
        if (checkPermission == 0 && checkPermission2 == 0 && checkPermission3 == 0) {
            if (i2 > 32 && packageManager.checkPermission("android.permission.NEARBY_WIFI_DEVICES", packageName) != 0) {
                return -2;
            }
            maxPeers = android.net.wifi.rtt.RangingRequest.getMaxPeers();
            if (maxPeers <= 0) {
                return -1;
            }
            if (maxPeers > 2) {
                maxPeers--;
            }
            android.net.wifi.rtt.WifiRttManager wifiRttManager = (android.net.wifi.rtt.WifiRttManager) b.getSystemService("wifirtt");
            isAvailable = wifiRttManager.isAvailable();
            if (!isAvailable || !b.getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                return -3;
            }
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) b.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
            if (wifiManager.getWifiState() != 3) {
                return -3;
            }
            android.net.wifi.rtt.RangingRequest.Builder builder = new android.net.wifi.rtt.RangingRequest.Builder();
            java.util.List<android.net.wifi.ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults == null || (size = scanResults.size()) <= 0) {
                return -4;
            }
            if (size < maxPeers) {
                maxPeers = size;
            }
            for (int i3 = 0; i3 < maxPeers; i3++) {
                builder.addAccessPoint(scanResults.get(i3));
            }
            build = builder.build();
            mainExecutor = b.getMainExecutor();
            wifiRttManager.startRanging(build, mainExecutor, new cn.shuzilm.core.dl.AnonymousClass3());
            return 0;
        }
        return -2;
    }

    private static boolean s() {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) b.getSystemService("connectivity");
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(connectivityManager.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            return ((java.lang.Boolean) declaredMethod.invoke(connectivityManager, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    private static void t() {
        android.net.ConnectivityManager connectivityManager;
        android.net.Network activeNetwork;
        boolean z;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return;
        }
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) b.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        java.lang.String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null) {
            simOperator = "";
        }
        try {
            if (telephonyManager.getSimState() == 5 && s()) {
                q = 0;
            } else {
                q = 1;
            }
        } catch (java.lang.Exception unused) {
        }
        int p2 = cn.shuzilm.core.t.p(b);
        if (p2 != 0) {
            r = 0;
        } else {
            r = 1;
        }
        try {
            connectivityManager = (android.net.ConnectivityManager) b.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (activeNetwork == null) {
            p = 1;
            f75s = "0";
            t = "0";
            cn.shuzilm.core.DUHelper.c(b, 201, "0");
            cn.shuzilm.core.DUHelper.c(b, 202, "0");
            return;
        }
        android.net.LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
        if (linkProperties == null) {
            return;
        }
        java.util.List<android.net.LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
        if (linkAddresses.isEmpty()) {
            p = 1;
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator<android.net.LinkAddress> it = linkAddresses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                java.lang.String hostAddress = it.next().getAddress().getHostAddress();
                sb.append(hostAddress);
                if (!m.isEmpty() && m.contains(hostAddress)) {
                    p = 1;
                    z = true;
                    break;
                }
            }
            if (m.isEmpty()) {
                m = sb.toString();
                p = 0;
            }
            if (!z && !m.isEmpty()) {
                m = sb.toString();
                p = 0;
            }
        }
        android.net.ProxyInfo httpProxy = linkProperties.getHttpProxy();
        if (httpProxy == null || httpProxy.getHost() == null) {
            o = 1;
        } else {
            o = 0;
        }
        java.lang.String interfaceName = linkProperties.getInterfaceName();
        if (interfaceName != null && !interfaceName.isEmpty() && (interfaceName.contains("tun") || interfaceName.contains("ppp"))) {
            o = 0;
        }
        if (!v.isEmpty() && (!v.equals(simOperator) || f75s == null)) {
            p = 0;
        }
        v = simOperator;
        int i2 = u;
        if (i2 != 0 && (i2 != p2 || t == null)) {
            p = 0;
        }
        u = p2;
    }
}
