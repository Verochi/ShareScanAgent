package com.getui.gtc.extension.distribution.gbd.a.b;

/* loaded from: classes22.dex */
public final class b {
    static java.lang.String a = "GBD_BTA";
    private static com.getui.gtc.extension.distribution.gbd.a.b.b g;
    android.bluetooth.BluetoothAdapter c;
    volatile boolean e = false;
    final android.content.BroadcastReceiver f = new com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass1();
    final android.content.Context b = com.getui.gtc.extension.distribution.gbd.d.c.d;
    final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.c> d = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.b$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            try {
                if ("android.bluetooth.device.action.FOUND".equals(intent.getAction())) {
                    com.getui.gtc.extension.distribution.gbd.a.b.b.this.a((android.bluetooth.BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0), (android.bluetooth.BluetoothClass) intent.getParcelableExtra("android.bluetooth.device.extra.CLASS"), 0);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.b$2, reason: invalid class name */
    public class AnonymousClass2 implements android.bluetooth.BluetoothAdapter.LeScanCallback {
        public AnonymousClass2() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(android.bluetooth.BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice != null) {
                com.getui.gtc.extension.distribution.gbd.a.b.b.this.a(bluetoothDevice, i, com.getui.gtc.extension.distribution.gbd.j.a.b(bluetoothDevice), 0);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.b$3, reason: invalid class name */
    public class AnonymousClass3 extends android.bluetooth.le.ScanCallback {
        public AnonymousClass3() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onBatchScanResults(java.util.List<android.bluetooth.le.ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int i) {
            super.onScanFailed(i);
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.b.a, "BLE onScanFailed errorCode = ".concat(java.lang.String.valueOf(i)));
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int i, android.bluetooth.le.ScanResult scanResult) {
            if (scanResult == null || scanResult.getDevice() == null) {
                return;
            }
            android.bluetooth.BluetoothDevice device = scanResult.getDevice();
            com.getui.gtc.extension.distribution.gbd.a.b.b.this.a(device, scanResult.getRssi(), com.getui.gtc.extension.distribution.gbd.j.a.b(device), 0);
        }
    }

    private b() {
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.a.b.b a() {
        com.getui.gtc.extension.distribution.gbd.a.b.b bVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.a.b.b.class) {
            if (g == null) {
                g = new com.getui.gtc.extension.distribution.gbd.a.b.b();
            }
            bVar = g;
        }
        return bVar;
    }

    private void a(boolean z) {
        this.e = z;
    }

    private java.lang.String c() {
        return com.getui.gtc.extension.distribution.gbd.j.a.d(this.c);
    }

    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.c> d() {
        if (this.e) {
            return this.d;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e5 A[Catch: all -> 0x018d, TRY_LEAVE, TryCatch #4 {all -> 0x018d, blocks: (B:5:0x000b, B:7:0x000f, B:10:0x0017, B:12:0x0027, B:14:0x002d, B:15:0x0031, B:17:0x0037, B:20:0x003f, B:25:0x004b, B:27:0x0052, B:29:0x005a, B:32:0x0064, B:36:0x008b, B:38:0x00a1, B:39:0x00a9, B:41:0x00ba, B:43:0x00c6, B:47:0x00d4, B:49:0x00e5, B:52:0x012c, B:54:0x0134, B:55:0x0139, B:57:0x014a, B:61:0x015f, B:64:0x015c, B:69:0x0129, B:71:0x0169, B:76:0x0088, B:78:0x0185, B:35:0x0083, B:66:0x00f2, B:60:0x0157), top: B:4:0x000b, inners: #0, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        boolean z;
        try {
            this.c = com.getui.gtc.extension.distribution.gbd.j.a.a();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        try {
            android.bluetooth.BluetoothAdapter bluetoothAdapter = this.c;
            if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
                this.e = false;
                this.d.clear();
                java.util.Set<android.bluetooth.BluetoothDevice> a2 = com.getui.gtc.extension.distribution.gbd.j.a.a(this.c);
                if (a2 != null && !a2.isEmpty()) {
                    for (android.bluetooth.BluetoothDevice bluetoothDevice : a2) {
                        if (bluetoothDevice != null) {
                            a(bluetoothDevice, 0, com.getui.gtc.extension.distribution.gbd.j.a.b(bluetoothDevice), com.getui.gtc.extension.distribution.gbd.j.a.a(bluetoothDevice));
                        }
                    }
                }
                if (!(android.os.Build.VERSION.SDK_INT >= 29 ? com.getui.gtc.extension.distribution.gbd.n.l.k() : true)) {
                    this.e = true;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "not have l to scan bl.");
                    return;
                }
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction("android.bluetooth.device.action.FOUND");
                this.b.registerReceiver(this.f, intentFilter);
                this.c.startDiscovery();
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start scan bl for classic.");
                try {
                    java.lang.Thread.sleep(12000L);
                } catch (java.lang.Throwable th2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                }
                this.b.unregisterReceiver(this.f);
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "stop scan bl for classic.");
                boolean c = com.getui.gtc.extension.distribution.gbd.j.a.b(this.c) ? com.getui.gtc.extension.distribution.gbd.j.a.c(this.c) : true;
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "scan bl for classic end is ".concat(java.lang.String.valueOf(c)));
                if (c) {
                    int i = android.os.Build.VERSION.SDK_INT;
                    if (!com.getui.gtc.extension.distribution.gbd.n.l.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") && !com.getui.gtc.extension.distribution.gbd.n.l.a(this.b, "android.permission.ACCESS_FINE_LOCATION")) {
                        z = false;
                        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "have l pm: ".concat(java.lang.String.valueOf(z)));
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
                            if (this.c.isOffloadedScanBatchingSupported()) {
                                scanMode.setReportDelay(0L);
                            }
                            android.bluetooth.le.ScanSettings build = scanMode.build();
                            com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass3 anonymousClass3 = new com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass3();
                            android.bluetooth.le.BluetoothLeScanner bluetoothLeScanner = this.c.getBluetoothLeScanner();
                            if (bluetoothLeScanner != null) {
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start scan bl for ble.");
                                bluetoothLeScanner.startScan((java.util.List<android.bluetooth.le.ScanFilter>) null, build, anonymousClass3);
                                try {
                                    java.lang.Thread.sleep(10000L);
                                } catch (java.lang.Throwable th4) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                                }
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "stop scan bl for ble.");
                                bluetoothLeScanner.stopScan(anonymousClass3);
                            }
                        }
                    }
                    z = true;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "have l pm: ".concat(java.lang.String.valueOf(z)));
                    if (z) {
                    }
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "stop scan bl.");
                this.e = true;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.getui.gtc.extension.distribution.gbd.d.h.bg = currentTimeMillis;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(362, java.lang.String.valueOf(currentTimeMillis));
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "scan bl not safe or some errors.");
        } catch (java.lang.Throwable th5) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
        }
    }

    private static boolean f() {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return com.getui.gtc.extension.distribution.gbd.n.l.k();
        }
        return true;
    }

    @android.annotation.TargetApi(18)
    private void g() {
        com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass2 anonymousClass2 = new com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass2();
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start scan bl for ble in low version.");
        this.c.startLeScan(anonymousClass2);
        try {
            java.lang.Thread.sleep(10000L);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "stop scan bl for ble in low version.");
        this.c.stopLeScan(anonymousClass2);
    }

    @android.annotation.TargetApi(21)
    private void h() {
        android.bluetooth.le.ScanSettings.Builder scanMode = new android.bluetooth.le.ScanSettings.Builder().setScanMode(1);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            try {
                java.lang.Class<?> cls = scanMode.getClass();
                java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
                java.lang.reflect.Method method = cls.getMethod("setCallbackType", cls2);
                java.lang.reflect.Method method2 = scanMode.getClass().getMethod("setMatchMode", cls2);
                method.invoke(scanMode, 1);
                method2.invoke(scanMode, 2);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        if (this.c.isOffloadedScanBatchingSupported()) {
            scanMode.setReportDelay(0L);
        }
        android.bluetooth.le.ScanSettings build = scanMode.build();
        com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass3 anonymousClass3 = new com.getui.gtc.extension.distribution.gbd.a.b.b.AnonymousClass3();
        android.bluetooth.le.BluetoothLeScanner bluetoothLeScanner = this.c.getBluetoothLeScanner();
        if (bluetoothLeScanner != null) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start scan bl for ble.");
            bluetoothLeScanner.startScan((java.util.List<android.bluetooth.le.ScanFilter>) null, build, anonymousClass3);
            try {
                java.lang.Thread.sleep(10000L);
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "stop scan bl for ble.");
            bluetoothLeScanner.stopScan(anonymousClass3);
        }
    }

    private boolean i() {
        return this.e;
    }

    public final synchronized void a(android.bluetooth.BluetoothDevice bluetoothDevice, int i, android.bluetooth.BluetoothClass bluetoothClass, int i2) {
        if (bluetoothDevice == null) {
            return;
        }
        java.lang.String c = com.getui.gtc.extension.distribution.gbd.j.a.c(bluetoothDevice);
        java.lang.String d = com.getui.gtc.extension.distribution.gbd.j.a.d(bluetoothDevice);
        int e = com.getui.gtc.extension.distribution.gbd.j.a.e(bluetoothDevice);
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.c> concurrentHashMap = this.d;
        if (concurrentHashMap != null && concurrentHashMap.size() < 100 && !android.text.TextUtils.isEmpty(c) && !this.d.keySet().contains(c)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "scan: " + c + " " + d);
            com.getui.gtc.extension.distribution.gbd.c.c cVar = new com.getui.gtc.extension.distribution.gbd.c.c();
            cVar.c = c;
            cVar.d = d;
            cVar.a = i;
            cVar.b = bluetoothDevice.getType();
            cVar.f = e;
            cVar.g = i2;
            cVar.e = com.getui.gtc.extension.distribution.gbd.j.a.a(bluetoothClass);
            this.d.put(c, cVar);
        }
    }
}
