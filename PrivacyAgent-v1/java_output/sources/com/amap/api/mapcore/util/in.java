package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class in {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;

    /* renamed from: s, reason: collision with root package name */
    public static java.util.HashMap<java.lang.String, java.lang.Long> f134s = new java.util.HashMap<>(36);
    public static long t = 0;
    static int u = 0;
    public static long w = 0;
    android.net.wifi.WifiManager a;
    android.content.Context i;
    java.util.ArrayList<android.net.wifi.ScanResult> b = new java.util.ArrayList<>();
    java.util.ArrayList<com.amap.api.mapcore.util.js> c = new java.util.ArrayList<>();
    boolean j = false;
    java.lang.StringBuilder k = null;
    boolean l = true;
    boolean m = true;
    boolean n = true;
    private volatile android.net.wifi.WifiInfo y = null;
    java.lang.String o = null;
    java.util.TreeMap<java.lang.Integer, android.net.wifi.ScanResult> p = null;
    public boolean q = true;
    public boolean r = false;
    android.net.ConnectivityManager v = null;
    private long z = 30000;
    volatile boolean x = false;

    public in(android.content.Context context, android.net.wifi.WifiManager wifiManager) {
        this.a = wifiManager;
        this.i = context;
    }

    private static boolean a(int i) {
        int i2 = 20;
        try {
            i2 = android.net.wifi.WifiManager.calculateSignalLevel(i, 20);
        } catch (java.lang.ArithmeticException e2) {
            com.amap.api.mapcore.util.it.a(e2, "Aps", "wifiSigFine");
        }
        return i2 > 0;
    }

    public static boolean a(android.net.wifi.WifiInfo wifiInfo) {
        return (wifiInfo == null || android.text.TextUtils.isEmpty(wifiInfo.getSSID()) || !com.amap.api.mapcore.util.ix.a(wifiInfo.getBSSID())) ? false : true;
    }

    private void d(boolean z) {
        java.lang.String valueOf;
        java.util.ArrayList<android.net.wifi.ScanResult> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (com.amap.api.mapcore.util.ix.b() - g > 3600000) {
            b();
        }
        if (this.p == null) {
            this.p = new java.util.TreeMap<>(java.util.Collections.reverseOrder());
        }
        this.p.clear();
        if (this.r && z) {
            try {
                this.c.clear();
            } catch (java.lang.Throwable unused) {
            }
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            android.net.wifi.ScanResult scanResult = this.b.get(i);
            if (com.amap.api.mapcore.util.ix.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                if (this.r && z) {
                    try {
                        com.amap.api.mapcore.util.js jsVar = new com.amap.api.mapcore.util.js(false);
                        jsVar.b = scanResult.SSID;
                        jsVar.d = scanResult.frequency;
                        jsVar.e = scanResult.timestamp;
                        jsVar.a = com.amap.api.mapcore.util.js.a(scanResult.BSSID);
                        jsVar.c = (short) scanResult.level;
                        short elapsedRealtime = (short) ((android.os.SystemClock.elapsedRealtime() - (scanResult.timestamp / 1000)) / 1000);
                        jsVar.g = elapsedRealtime;
                        if (elapsedRealtime < 0) {
                            jsVar.g = (short) 0;
                        }
                        jsVar.f = java.lang.System.currentTimeMillis();
                        this.c.add(jsVar);
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                if (!android.text.TextUtils.isEmpty(scanResult.SSID)) {
                    valueOf = "<unknown ssid>".equals(scanResult.SSID) ? "unkwn" : java.lang.String.valueOf(i);
                    this.p.put(java.lang.Integer.valueOf((scanResult.level * 25) + i), scanResult);
                }
                scanResult.SSID = valueOf;
                this.p.put(java.lang.Integer.valueOf((scanResult.level * 25) + i), scanResult);
            }
        }
        this.b.clear();
        java.util.Iterator<android.net.wifi.ScanResult> it = this.p.values().iterator();
        while (it.hasNext()) {
            this.b.add(it.next());
        }
        this.p.clear();
    }

    private void e(boolean z) {
        this.l = z;
        this.m = true;
        this.n = true;
        this.z = 30000L;
    }

    public static java.lang.String i() {
        return java.lang.String.valueOf(com.amap.api.mapcore.util.ix.b() - g);
    }

    private java.util.List<android.net.wifi.ScanResult> j() {
        android.net.wifi.WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                java.util.List<android.net.wifi.ScanResult> scanResults = wifiManager.getScanResults();
                java.util.HashMap<java.lang.String, java.lang.Long> hashMap = new java.util.HashMap<>(36);
                if (scanResults != null) {
                    for (android.net.wifi.ScanResult scanResult : scanResults) {
                        hashMap.put(scanResult.BSSID, java.lang.Long.valueOf(scanResult.timestamp));
                    }
                }
                if (f134s.isEmpty() || !f134s.equals(hashMap)) {
                    f134s = hashMap;
                    t = com.amap.api.mapcore.util.ix.b();
                }
                this.o = null;
                return scanResults;
            } catch (java.lang.SecurityException e2) {
                this.o = e2.getMessage();
            } catch (java.lang.Throwable th) {
                this.o = null;
                com.amap.api.mapcore.util.it.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private android.net.wifi.WifiInfo k() {
        try {
            android.net.wifi.WifiManager wifiManager = this.a;
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    private int l() {
        android.net.wifi.WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean m() {
        long b = com.amap.api.mapcore.util.ix.b() - d;
        if (b < 4900) {
            return false;
        }
        if (n() && b < 9900) {
            return false;
        }
        if (u > 1) {
            long j = this.z;
            if (j == 30000) {
                j = com.amap.api.mapcore.util.is.b() != -1 ? com.amap.api.mapcore.util.is.b() : 30000L;
            }
            if (android.os.Build.VERSION.SDK_INT >= 28 && b < j) {
                return false;
            }
        }
        if (this.a == null) {
            return false;
        }
        d = com.amap.api.mapcore.util.ix.b();
        int i = u;
        if (i < 2) {
            u = i + 1;
        }
        return this.a.startScan();
    }

    private boolean n() {
        if (this.v == null) {
            this.v = (android.net.ConnectivityManager) com.amap.api.mapcore.util.ix.a(this.i, "connectivity");
        }
        return a(this.v);
    }

    private boolean o() {
        if (this.a == null) {
            return false;
        }
        return com.amap.api.mapcore.util.ix.c(this.i);
    }

    private void p() {
        if (t()) {
            long b = com.amap.api.mapcore.util.ix.b();
            if (b - e >= 10000) {
                this.b.clear();
                h = g;
            }
            q();
            if (b - e >= 10000) {
                for (int i = 20; i > 0 && g == h; i--) {
                    try {
                        java.lang.Thread.sleep(150L);
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }
    }

    private void q() {
        if (t()) {
            try {
                if (m()) {
                    f = com.amap.api.mapcore.util.ix.b();
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void r() {
        java.util.List<android.net.wifi.ScanResult> list;
        if (h != g) {
            try {
                list = j();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "WifiManager", "updateScanResult");
                list = null;
            }
            h = g;
            if (list == null) {
                this.b.clear();
            } else {
                this.b.clear();
                this.b.addAll(list);
            }
        }
    }

    private void s() {
        int i;
        try {
            if (this.a == null) {
                return;
            }
            try {
                i = l();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "WifiManager", "onReceive part");
                i = 4;
            }
            if (this.b == null) {
                this.b = new java.util.ArrayList<>();
            }
            if (i == 0 || i == 1 || i == 4) {
                b();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean t() {
        boolean o = o();
        this.q = o;
        if (!o || !this.l) {
            return false;
        }
        if (f != 0) {
            if (com.amap.api.mapcore.util.ix.b() - f < 4900 || com.amap.api.mapcore.util.ix.b() - g < 1500) {
                return false;
            }
            com.amap.api.mapcore.util.ix.b();
        }
        return true;
    }

    public final java.util.ArrayList<android.net.wifi.ScanResult> a() {
        if (this.b == null) {
            return null;
        }
        java.util.ArrayList<android.net.wifi.ScanResult> arrayList = new java.util.ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void a(boolean z) {
        android.content.Context context = this.i;
        if (!com.amap.api.mapcore.util.is.a() || !this.n || this.a == null || context == null || !z || com.amap.api.mapcore.util.ix.c() <= 17) {
            return;
        }
        android.content.ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((java.lang.Integer) com.amap.api.mapcore.util.iv.a("android.provider.Settings$Global", "getInt", new java.lang.Object[]{contentResolver, "wifi_scan_always_enabled"}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.ContentResolver.class, java.lang.String.class})).intValue() == 0) {
                com.amap.api.mapcore.util.iv.a("android.provider.Settings$Global", "putInt", new java.lang.Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.ContentResolver.class, java.lang.String.class, java.lang.Integer.TYPE});
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final boolean a(android.net.ConnectivityManager connectivityManager) {
        android.net.wifi.WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (com.amap.api.mapcore.util.ix.a(connectivityManager.getActiveNetworkInfo()) == 1) {
                return a(wifiManager.getConnectionInfo());
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void b() {
        this.y = null;
        this.b.clear();
    }

    public final void b(boolean z) {
        if (z) {
            p();
        } else {
            q();
        }
        boolean z2 = false;
        if (this.x) {
            this.x = false;
            s();
        }
        r();
        if (com.amap.api.mapcore.util.ix.b() - g > com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
            this.b.clear();
        }
        e = com.amap.api.mapcore.util.ix.b();
        if (this.b.isEmpty()) {
            g = com.amap.api.mapcore.util.ix.b();
            java.util.List<android.net.wifi.ScanResult> j = j();
            if (j != null) {
                this.b.addAll(j);
                z2 = true;
            }
        }
        d(z2);
    }

    public final void c() {
        if (this.a != null && com.amap.api.mapcore.util.ix.b() - g > 4900) {
            g = com.amap.api.mapcore.util.ix.b();
        }
    }

    public final void c(boolean z) {
        e(z);
    }

    public final void d() {
        if (this.a == null) {
            return;
        }
        this.x = true;
    }

    public final boolean e() {
        return this.q;
    }

    public final android.net.wifi.WifiInfo f() {
        this.y = k();
        return this.y;
    }

    public final boolean g() {
        return this.j;
    }

    public final void h() {
        b();
        this.b.clear();
    }
}
