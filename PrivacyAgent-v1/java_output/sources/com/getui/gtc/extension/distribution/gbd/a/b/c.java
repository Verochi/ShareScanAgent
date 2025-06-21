package com.getui.gtc.extension.distribution.gbd.a.b;

import com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass3;

/* loaded from: classes22.dex */
public final class c implements com.getui.gtc.extension.distribution.gbd.a.a {
    protected static int a = 1;
    protected static int b = 0;
    protected static int c = -1;
    protected static int d = -2;
    protected static int e = -3;
    protected static int f = -4;
    protected static int g = -5;
    protected static int h = -6;
    protected static int i = -7;
    protected static int j = -8;
    protected static int k = -9;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;

    /* renamed from: s, reason: collision with root package name */
    public static final int f314s = 3;
    private static final java.lang.String t = "GBD_RLA";
    private static com.getui.gtc.extension.distribution.gbd.a.b.c u;
    private float A;
    private java.util.concurrent.ThreadPoolExecutor C;
    private android.content.Context v;
    private com.getui.gtc.extension.distribution.gbd.a.b.a x;
    private com.getui.gtc.extension.distribution.gbd.a.b.g y;
    private long z;
    private final java.lang.Object w = new java.lang.Object();
    private volatile boolean B = false;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<android.location.Location, java.lang.String> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public java.lang.String a(android.location.Location location) {
            try {
                return com.getui.gtc.extension.distribution.gbd.a.b.c.this.c(location);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return "";
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.c$2, reason: invalid class name */
    public class AnonymousClass2 extends com.getui.gtc.extension.distribution.gbd.f.f {
        public AnonymousClass2() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).storageCacheValidTime(0L);
        }
    }

    public class a implements java.lang.Runnable {
        private int b;

        /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.c$a$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            /* JADX WARN: Removed duplicated region for block: B:49:0x00e9 A[Catch: all -> 0x0191, TRY_LEAVE, TryCatch #0 {all -> 0x0191, blocks: (B:5:0x000f, B:7:0x0013, B:10:0x001b, B:12:0x002b, B:14:0x0031, B:15:0x0035, B:17:0x003b, B:20:0x0043, B:25:0x004f, B:27:0x0056, B:29:0x005e, B:32:0x0068, B:36:0x008f, B:38:0x00a5, B:39:0x00ad, B:41:0x00be, B:43:0x00ca, B:47:0x00d8, B:49:0x00e9, B:52:0x0130, B:54:0x0138, B:55:0x013d, B:57:0x014e, B:61:0x0163, B:64:0x0160, B:69:0x012d, B:71:0x016d, B:76:0x008c, B:78:0x0189, B:35:0x0087, B:66:0x00f6, B:60:0x015b), top: B:4:0x000f, inners: #1, #3, #4 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                boolean z;
                com.getui.gtc.extension.distribution.gbd.a.b.b a = com.getui.gtc.extension.distribution.gbd.a.b.b.a();
                try {
                    a.c = com.getui.gtc.extension.distribution.gbd.j.a.a();
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
                try {
                    android.bluetooth.BluetoothAdapter bluetoothAdapter = a.c;
                    if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
                        a.e = false;
                        a.d.clear();
                        java.util.Set<android.bluetooth.BluetoothDevice> a2 = com.getui.gtc.extension.distribution.gbd.j.a.a(a.c);
                        if (a2 != null && !a2.isEmpty()) {
                            for (android.bluetooth.BluetoothDevice bluetoothDevice : a2) {
                                if (bluetoothDevice != null) {
                                    a.a(bluetoothDevice, 0, com.getui.gtc.extension.distribution.gbd.j.a.b(bluetoothDevice), com.getui.gtc.extension.distribution.gbd.j.a.a(bluetoothDevice));
                                }
                            }
                        }
                        if (!(android.os.Build.VERSION.SDK_INT >= 29 ? com.getui.gtc.extension.distribution.gbd.n.l.k() : true)) {
                            a.e = true;
                            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "not have l to scan bl.");
                            return;
                        }
                        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                        intentFilter.addAction("android.bluetooth.device.action.FOUND");
                        a.b.registerReceiver(a.f, intentFilter);
                        a.c.startDiscovery();
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "start scan bl for classic.");
                        try {
                            java.lang.Thread.sleep(12000L);
                        } catch (java.lang.Throwable th2) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                        }
                        a.b.unregisterReceiver(a.f);
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "stop scan bl for classic.");
                        boolean c = com.getui.gtc.extension.distribution.gbd.j.a.b(a.c) ? com.getui.gtc.extension.distribution.gbd.j.a.c(a.c) : true;
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "scan bl for classic end is ".concat(java.lang.String.valueOf(c)));
                        if (c) {
                            int i = android.os.Build.VERSION.SDK_INT;
                            if (!com.getui.gtc.extension.distribution.gbd.n.l.a(a.b, "android.permission.ACCESS_COARSE_LOCATION") && !com.getui.gtc.extension.distribution.gbd.n.l.a(a.b, "android.permission.ACCESS_FINE_LOCATION")) {
                                z = false;
                                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "have l pm: ".concat(java.lang.String.valueOf(z)));
                                if (z) {
                                    android.bluetooth.le.ScanSettings.Builder scanMode = new android.bluetooth.le.ScanSettings.Builder().setScanMode(1);
                                    if (i >= 23) {
                                        try {
                                            java.lang.Class<?> cls = scanMode.getClass();
                                            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
                                            java.lang.reflect.Method method = cls.getMethod("setCallbackType", cls2);
                                            java.lang.reflect.Method method2 = scanMode.getClass().getMethod("setMatchMode", cls2);
                                            method.invoke(scanMode, 1);
                                            method2.invoke(scanMode, 2);
                                        } catch (java.lang.Throwable th3) {
                                            com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                                        }
                                    }
                                    if (a.c.isOffloadedScanBatchingSupported()) {
                                        scanMode.setReportDelay(0L);
                                    }
                                    android.bluetooth.le.ScanSettings build = scanMode.build();
                                    com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass3 anonymousClass3 = a.new AnonymousClass3();
                                    android.bluetooth.le.BluetoothLeScanner bluetoothLeScanner = a.c.getBluetoothLeScanner();
                                    if (bluetoothLeScanner != null) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "start scan bl for ble.");
                                        bluetoothLeScanner.startScan((java.util.List<android.bluetooth.le.ScanFilter>) null, build, anonymousClass3);
                                        try {
                                            java.lang.Thread.sleep(10000L);
                                        } catch (java.lang.Throwable th4) {
                                            com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                                        }
                                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "stop scan bl for ble.");
                                        bluetoothLeScanner.stopScan(anonymousClass3);
                                    }
                                }
                            }
                            z = true;
                            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "have l pm: ".concat(java.lang.String.valueOf(z)));
                            if (z) {
                            }
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "stop scan bl.");
                        a.e = true;
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        long currentTimeMillis = java.lang.System.currentTimeMillis();
                        com.getui.gtc.extension.distribution.gbd.d.h.bg = currentTimeMillis;
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a(362, java.lang.String.valueOf(currentTimeMillis));
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "scan bl not safe or some errors.");
                } catch (java.lang.Throwable th5) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
                }
            }
        }

        public a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.getui.gtc.extension.distribution.gbd.a.b.c.this.w) {
                try {
                    android.os.Process.setThreadPriority(10);
                    com.getui.gtc.extension.distribution.gbd.a.b.c.this.y.b = com.getui.gtc.extension.distribution.gbd.a.b.c.b.SCAN_END;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.c.t, "check bl safe = " + com.getui.gtc.extension.distribution.gbd.a.b.c.this.B + ", dyn/sta type = " + this.b);
                    if (this.b == 11 && com.getui.gtc.extension.distribution.gbd.a.b.c.this.B) {
                        java.lang.Thread thread = new java.lang.Thread(new com.getui.gtc.extension.distribution.gbd.a.b.c.a.AnonymousClass1());
                        thread.start();
                        try {
                            thread.join(30000L);
                        } catch (java.lang.Throwable th) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.c.t, "DoSampleThread ex =" + th.toString());
                        }
                    }
                    com.getui.gtc.extension.distribution.gbd.a.b.c.this.y.a(this.b);
                    com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_RLAdata", "wifi|type = " + com.getui.gtc.extension.distribution.gbd.a.b.c.this.y.b + "|" + this.b);
                } finally {
                }
            }
        }
    }

    public enum b {
        SCAN_START,
        SCAN_END
    }

    private c(android.content.Context context) {
        try {
            this.v = context;
            com.getui.gtc.extension.distribution.gbd.a.b.a aVar = new com.getui.gtc.extension.distribution.gbd.a.b.a(context);
            this.x = aVar;
            aVar.a = this;
            com.getui.gtc.extension.distribution.gbd.a.b.g gVar = new com.getui.gtc.extension.distribution.gbd.a.b.g(context);
            this.y = gVar;
            gVar.a = this;
            this.C = new java.util.concurrent.ThreadPoolExecutor(0, 2, 3L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque(2));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private static java.lang.String a(android.net.wifi.ScanResult scanResult) {
        if (scanResult == null) {
            return "";
        }
        try {
            java.lang.String str = scanResult.SSID;
            if (str == null) {
                return "";
            }
            return str.replace("|", "").replace("#", "").replace(",", "") + "#" + scanResult.BSSID + "#" + scanResult.level + "#" + scanResult.capabilities + "#" + (com.getui.gtc.extension.distribution.gbd.n.l.C() - (((android.os.SystemClock.elapsedRealtimeNanos() / 1000) / 1000) - (scanResult.timestamp / 1000)));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private static java.lang.String a(java.util.List<android.net.wifi.ScanResult> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(a(list.get(i2)));
                if (i2 < list.size() - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append("|");
        return sb.toString();
    }

    private java.lang.String a(java.util.List<android.net.wifi.ScanResult> list, android.location.Location location, int i2, int i3, java.util.concurrent.ConcurrentHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.c> concurrentHashMap, boolean z) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(t, "package data, 111");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
        com.getui.gtc.extension.distribution.gbd.c.d g2 = g();
        sb.append(format);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb.append("|");
        java.lang.String b2 = b(location);
        java.lang.String a2 = a(list);
        sb.append(b2);
        sb.append(g2.a);
        sb.append("|");
        sb.append(g2.b);
        sb.append("|");
        sb.append(g2.c);
        sb.append("|");
        sb.append(g2.d);
        sb.append("|");
        sb.append("|");
        sb.append(a2);
        sb.append("|");
        sb.append(i2);
        sb.append("|");
        sb.append(i());
        sb.append("|");
        sb.append(j());
        sb.append("|");
        sb.append(this.z);
        sb.append("|");
        sb.append(this.A);
        sb.append("|");
        sb.append("|");
        sb.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
        sb.append("|");
        sb.append(i3);
        sb.append("|");
        if (this.B) {
            sb.append(a(concurrentHashMap));
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.j.a.d(com.getui.gtc.extension.distribution.gbd.a.b.b.a().c));
        } else {
            sb.append("|");
        }
        sb.append("|");
        sb.append("-1");
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.l.b("111"));
        sb.append("|");
        if (z) {
            sb.append(com.getui.gtc.extension.distribution.gbd.n.l.h());
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.n.l.i());
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.n.o.c(com.getui.gtc.extension.distribution.gbd.d.c.d));
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.n.o.d());
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.j.a.b());
        } else {
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append("|");
        }
        sb.append("|");
        sb.append(g2.e);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.l.d() ? 1 : 0);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.l.q(com.getui.gtc.extension.distribution.gbd.d.c.d));
        sb.append("|");
        sb.append("|");
        sb.append("|");
        sb.append("|");
        java.lang.String sb2 = sb.toString();
        com.getui.gtc.extension.distribution.gbd.n.j.a(t, "f type:111 , content = ".concat(java.lang.String.valueOf(sb2)));
        return sb2;
    }

    private static java.lang.String a(java.util.concurrent.ConcurrentHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.c> concurrentHashMap) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.c>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                com.getui.gtc.extension.distribution.gbd.c.c value = it.next().getValue();
                sb.append(value.c);
                sb.append("#");
                sb.append(value.d);
                sb.append("#");
                sb.append(value.a);
                sb.append("#");
                sb.append(value.b);
                sb.append("#");
                sb.append(value.f);
                sb.append("#");
                sb.append(value.g);
                sb.append("#");
                sb.append(value.e);
                sb.append(",");
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            concurrentHashMap.clear();
        }
        return sb.toString();
    }

    private static void a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str, 111);
        com.getui.gtc.extension.distribution.gbd.n.j.a(t, "saveRALData: type = 111content = ".concat(java.lang.String.valueOf(str)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(t, "saveRALData: type = 111");
    }

    private java.lang.String b(android.location.Location location) {
        java.lang.String str;
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(t, "get li new");
            if (location != null) {
                boolean I = com.getui.gtc.extension.distribution.gbd.n.l.I();
                com.getui.gtc.extension.distribution.gbd.n.j.b(t, "get li new : ".concat(java.lang.String.valueOf(I)));
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(I, "loc", location, new com.getui.gtc.extension.distribution.gbd.a.b.c.AnonymousClass1());
            } else {
                str = c((android.location.Location) null);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            str = null;
        }
        return android.text.TextUtils.isEmpty(str) ? c((android.location.Location) null) : str;
    }

    private static void b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str, 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String c(android.location.Location location) {
        float accuracy;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (location == null) {
            sb.append("none");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            this.z = 0L;
            accuracy = 0.0f;
        } else {
            sb.append(location.getProvider());
            sb.append("|");
            sb.append(location.getLongitude());
            sb.append("|");
            sb.append(location.getLatitude());
            sb.append("|");
            sb.append(location.getAltitude());
            sb.append("|");
            this.z = (((location.getElapsedRealtimeNanos() - android.os.SystemClock.elapsedRealtimeNanos()) / 1000) / 1000) + com.getui.gtc.extension.distribution.gbd.n.l.C();
            accuracy = location.getAccuracy();
        }
        this.A = accuracy;
        return sb.toString();
    }

    public static com.getui.gtc.extension.distribution.gbd.a.b.c f() {
        if (u == null) {
            u = new com.getui.gtc.extension.distribution.gbd.a.b.c(com.getui.gtc.extension.distribution.gbd.d.c.d);
        }
        return u;
    }

    private static com.getui.gtc.extension.distribution.gbd.c.d g() {
        try {
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (com.getui.gtc.extension.distribution.gbd.n.l.l()) {
            android.content.Context context = com.getui.gtc.extension.distribution.gbd.d.c.d;
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.Boolean bool = (java.lang.Boolean) com.getui.gtc.extension.distribution.gbd.h.a.a(true, "sm", context, new com.getui.gtc.extension.distribution.gbd.n.ab.AnonymousClass1());
            if (bool != null && bool.booleanValue()) {
                if (com.getui.gtc.extension.distribution.gbd.d.d.t) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(t, "getCellInfoNew : gbd");
                    if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.a.f329s, com.getui.gtc.extension.distribution.gbd.f.e.a.t, com.getui.gtc.extension.distribution.gbd.d.h.bk, "cellInfo", "getCellInfoNew")) {
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        long currentTimeMillis = java.lang.System.currentTimeMillis();
                        com.getui.gtc.extension.distribution.gbd.d.h.bk = currentTimeMillis;
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a(365, java.lang.String.valueOf(currentTimeMillis));
                        return h();
                    }
                }
                com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.J, (com.getui.gtc.extension.distribution.gbd.f.f) null);
                com.getui.gtc.extension.distribution.gbd.n.j.b(t, "getCellInfoNew : gtc，".concat(java.lang.String.valueOf(a2)));
                if (android.text.TextUtils.isEmpty(a2)) {
                    return new com.getui.gtc.extension.distribution.gbd.c.d();
                }
                java.lang.String[] split = a2.split(",");
                if (split.length > 0) {
                    java.lang.String str = split[split.length - 1];
                    if (!android.text.TextUtils.isEmpty(str)) {
                        java.lang.String[] split2 = str.split("\\|");
                        if (split2.length == 4) {
                            com.getui.gtc.extension.distribution.gbd.c.d dVar = new com.getui.gtc.extension.distribution.gbd.c.d();
                            dVar.a = java.lang.Integer.parseInt(split2[0]);
                            dVar.b = java.lang.Integer.parseInt(split2[1]);
                            dVar.c = java.lang.Integer.parseInt(split2[2]);
                            dVar.d = java.lang.Long.parseLong(split2[3]);
                            return dVar;
                        }
                        if (split2.length >= 5) {
                            com.getui.gtc.extension.distribution.gbd.c.d dVar2 = new com.getui.gtc.extension.distribution.gbd.c.d();
                            dVar2.a = java.lang.Integer.parseInt(split2[0]);
                            dVar2.b = java.lang.Integer.parseInt(split2[1]);
                            dVar2.c = java.lang.Integer.parseInt(split2[2]);
                            dVar2.d = java.lang.Long.parseLong(split2[3]);
                            dVar2.e = java.lang.Integer.parseInt(split2[4]);
                            return dVar2;
                        }
                    }
                }
                return new com.getui.gtc.extension.distribution.gbd.c.d();
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(t, "getCellInfoNew : not collect");
        return new com.getui.gtc.extension.distribution.gbd.c.d();
    }

    private static com.getui.gtc.extension.distribution.gbd.c.d h() {
        java.util.List<android.telephony.CellInfo> allCellInfo = ((android.telephony.TelephonyManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getAllCellInfo();
        if (allCellInfo == null || allCellInfo.isEmpty()) {
            return new com.getui.gtc.extension.distribution.gbd.c.d();
        }
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (android.telephony.CellInfo cellInfo : allCellInfo) {
            if (cellInfo.isRegistered()) {
                if (cellInfo instanceof android.telephony.CellInfoGsm) {
                    android.telephony.CellIdentityGsm cellIdentity = ((android.telephony.CellInfoGsm) cellInfo).getCellIdentity();
                    i2 = cellIdentity.getMcc();
                    i3 = cellIdentity.getMnc();
                    i4 = cellIdentity.getLac();
                    j2 = cellIdentity.getCid();
                    i5 = 1;
                } else if (cellInfo instanceof android.telephony.CellInfoCdma) {
                    android.telephony.CellIdentityCdma cellIdentity2 = ((android.telephony.CellInfoCdma) cellInfo).getCellIdentity();
                    i3 = cellIdentity2.getSystemId();
                    i4 = cellIdentity2.getNetworkId();
                    j2 = cellIdentity2.getBasestationId();
                    i5 = 2;
                } else if (cellInfo instanceof android.telephony.CellInfoWcdma) {
                    android.telephony.CellIdentityWcdma cellIdentity3 = ((android.telephony.CellInfoWcdma) cellInfo).getCellIdentity();
                    i2 = cellIdentity3.getMcc();
                    i3 = cellIdentity3.getMnc();
                    i4 = cellIdentity3.getLac();
                    j2 = cellIdentity3.getCid();
                    i5 = 4;
                } else if (cellInfo instanceof android.telephony.CellInfoLte) {
                    android.telephony.CellIdentityLte cellIdentity4 = ((android.telephony.CellInfoLte) cellInfo).getCellIdentity();
                    i2 = cellIdentity4.getMcc();
                    i3 = cellIdentity4.getMnc();
                    i4 = cellIdentity4.getTac();
                    j2 = cellIdentity4.getCi();
                    i5 = 3;
                } else if ("android.telephony.CellInfoNr".equals(cellInfo.getClass().getName())) {
                    try {
                        java.lang.reflect.Method method = java.lang.Class.forName("android.telephony.CellInfoNr").getMethod("getCellIdentity", new java.lang.Class[0]);
                        java.lang.Class<?> cls = java.lang.Class.forName("android.telephony.CellIdentityNr");
                        java.lang.reflect.Method method2 = cls.getMethod("getMccString", new java.lang.Class[0]);
                        java.lang.reflect.Method method3 = cls.getMethod("getMncString", new java.lang.Class[0]);
                        java.lang.reflect.Method method4 = cls.getMethod("getTac", new java.lang.Class[0]);
                        java.lang.reflect.Method method5 = cls.getMethod("getNci", new java.lang.Class[0]);
                        java.lang.Object invoke = method.invoke(cellInfo, new java.lang.Object[0]);
                        java.lang.String str = (java.lang.String) method2.invoke(invoke, new java.lang.Object[0]);
                        java.lang.String str2 = (java.lang.String) method3.invoke(invoke, new java.lang.Object[0]);
                        i2 = java.lang.Integer.parseInt(str);
                        i3 = java.lang.Integer.parseInt(str2);
                        i4 = ((java.lang.Integer) method4.invoke(invoke, new java.lang.Object[0])).intValue();
                        j2 = ((java.lang.Long) method5.invoke(invoke, new java.lang.Object[0])).longValue();
                        i5 = 6;
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    }
                }
            }
        }
        com.getui.gtc.extension.distribution.gbd.c.d dVar = new com.getui.gtc.extension.distribution.gbd.c.d();
        dVar.a = i2;
        dVar.b = i3;
        dVar.c = i4;
        dVar.d = j2;
        dVar.e = i5;
        return dVar;
    }

    private int i() {
        try {
            android.content.Intent registerReceiver = this.v.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null && registerReceiver.getExtras() != null) {
                int i2 = registerReceiver.getExtras().getInt("status");
                if (i2 == 2) {
                    return 2;
                }
                if (i2 == 3 || i2 == 4) {
                    return 1;
                }
                return i2 != 5 ? 0 : 3;
            }
            return 0;
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
            return 0;
        }
    }

    private int j() {
        try {
            android.content.Intent registerReceiver = this.v.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null && registerReceiver.getExtras() != null) {
                int i2 = registerReceiver.getExtras().getInt("plugged");
                if (i2 == 1) {
                    return 1;
                }
                if (i2 != 2) {
                    return i2 != 4 ? 0 : 3;
                }
                return 2;
            }
            return 0;
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
            return 0;
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        a(12);
    }

    public final void a(int i2) {
        boolean z;
        try {
            if (com.getui.gtc.extension.distribution.gbd.n.l.c(111)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(t, "type 111 in type black list, return.");
                return;
            }
            if (!com.getui.gtc.extension.distribution.gbd.d.d.aQ) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(t, "doSample 11 not enable.");
                return;
            }
            boolean c2 = com.getui.gtc.extension.distribution.gbd.e.b.a().c();
            com.getui.gtc.extension.distribution.gbd.n.j.a(t, "doSample checkSafeStatus = " + c2 + ", dyn/sta type = " + i2);
            if (!c2) {
                this.y.b = com.getui.gtc.extension.distribution.gbd.a.b.c.b.SCAN_END;
                com.getui.gtc.extension.distribution.gbd.n.j.a(t, "doSample end : checkSafe not passed");
                return;
            }
            boolean z2 = true;
            boolean z3 = false;
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.aN) && !"none".equals(com.getui.gtc.extension.distribution.gbd.d.d.aN)) {
                java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.aN.split(",");
                java.lang.String w = com.getui.gtc.extension.distribution.gbd.n.l.w();
                int i3 = android.os.Build.VERSION.SDK_INT;
                for (java.lang.String str : split) {
                    java.lang.String[] split2 = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    if (split2.length != 1) {
                        if (split2.length == 2) {
                            int parseInt = java.lang.Integer.parseInt(split2[1]);
                            if (w.equalsIgnoreCase(split2[0]) && i3 >= parseInt) {
                                z = true;
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (w.equalsIgnoreCase(split2[0])) {
                            z = true;
                            break;
                        }
                    }
                }
            }
            z = false;
            com.getui.gtc.extension.distribution.gbd.n.j.a(t, "isInBrandBlackList: ".concat(java.lang.String.valueOf(z)));
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (i2 != 11 || currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.aG <= com.getui.gtc.extension.distribution.gbd.d.d.aD * 1000) {
                z2 = false;
            } else {
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.d.h.aG = currentTimeMillis;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(182, java.lang.String.valueOf(currentTimeMillis));
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(t, "isMatchBtInterval: ".concat(java.lang.String.valueOf(i2 == 11 ? java.lang.String.valueOf(z2) : org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE)));
            if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.a.c, com.getui.gtc.extension.distribution.gbd.f.e.a.d, com.getui.gtc.extension.distribution.gbd.d.h.bg, "lbs-net", "blue") && !z && z2 && com.getui.gtc.extension.distribution.gbd.n.l.G()) {
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                z3 = com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.L, "bl");
            }
            this.B = z3;
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.C;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.execute(new com.getui.gtc.extension.distribution.gbd.a.b.c.a(i2));
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            com.getui.gtc.extension.distribution.gbd.n.j.a(t, "type11 exception = " + th.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(android.location.Location location) {
        java.util.ArrayList arrayList;
        java.lang.String a2;
        if (com.getui.gtc.extension.distribution.gbd.d.h.i) {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.util.List list = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.b(com.getui.gtc.extension.distribution.gbd.d.d.aj, com.getui.gtc.extension.distribution.gbd.f.e.b.F, new com.getui.gtc.extension.distribution.gbd.a.b.c.AnonymousClass2());
            if (list != null && list.size() > 0) {
                arrayList = new java.util.ArrayList(list);
                com.getui.gtc.extension.distribution.gbd.n.j.b(t, "g l data.");
                a2 = a(arrayList, location, a, 13, null, false);
                if (a2 == null) {
                    if (com.getui.gtc.extension.distribution.gbd.d.d.D) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(t, "instant report gps.");
                        b(a2);
                        return;
                    } else {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(t, "not instant report gps.");
                        a(a2);
                        return;
                    }
                }
                return;
            }
        }
        arrayList = null;
        com.getui.gtc.extension.distribution.gbd.n.j.b(t, "g l data.");
        a2 = a(arrayList, location, a, 13, null, false);
        if (a2 == null) {
        }
    }

    public final void a(java.util.List<android.net.wifi.ScanResult> list, int i2, int i3) {
        if (com.getui.gtc.extension.distribution.gbd.d.c.e == null) {
            return;
        }
        boolean z = i3 == 11;
        android.location.Location a2 = this.x.a(false);
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.c> concurrentHashMap = null;
        if (z) {
            com.getui.gtc.extension.distribution.gbd.a.b.b a3 = com.getui.gtc.extension.distribution.gbd.a.b.b.a();
            if (a3.e) {
                concurrentHashMap = a3.d;
            }
        }
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.c> concurrentHashMap2 = concurrentHashMap;
        if (a2 == null && ((list == null || list.isEmpty()) && ((concurrentHashMap2 == null || concurrentHashMap2.isEmpty()) && !z))) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(t, "no collect data.");
            return;
        }
        java.lang.String a4 = a(list, a2, i2, i3, concurrentHashMap2, z);
        if (a4 != null) {
            if (com.getui.gtc.extension.distribution.gbd.n.l.d(111)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(t, "instant r 111");
                b(a4);
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.b(t, "not instant r, responseCode = ".concat(java.lang.String.valueOf(i2)));
                a(a4);
            }
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 111;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return "* * * * *";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return "* * * * *";
    }
}
