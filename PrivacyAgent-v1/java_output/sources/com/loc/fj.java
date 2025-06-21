package com.loc;

/* loaded from: classes23.dex */
public final class fj {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;
    public static java.util.HashMap<java.lang.String, java.lang.Long> v = new java.util.HashMap<>(36);
    public static long w = 0;
    static int x = 0;
    public static long z = 0;
    private com.loc.eu E;
    android.net.wifi.WifiManager a;
    android.content.Context i;
    com.loc.fh t;
    java.util.ArrayList<com.loc.ei> b = new java.util.ArrayList<>();
    java.util.ArrayList<com.loc.ei> c = new java.util.ArrayList<>();
    boolean j = false;
    java.lang.StringBuilder k = null;
    boolean l = true;
    boolean m = true;
    boolean n = true;
    private volatile com.loc.fi B = null;
    java.lang.String o = null;
    java.util.TreeMap<java.lang.Integer, com.loc.ei> p = null;
    public boolean q = true;
    public boolean r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f408s = false;
    private java.lang.String C = "";
    long u = 0;
    android.net.ConnectivityManager y = null;
    private long D = 30000;
    volatile boolean A = false;

    public fj(android.content.Context context, android.net.wifi.WifiManager wifiManager, android.os.Handler handler) {
        this.a = wifiManager;
        this.i = context;
        com.loc.fh fhVar = new com.loc.fh(context, "wifiAgee", handler);
        this.t = fhVar;
        fhVar.a();
    }

    private void A() {
        int i;
        try {
            if (this.a == null) {
                return;
            }
            try {
                i = t();
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "OPENSDK_WMW", "cwsc");
                i = 4;
            }
            if (this.b == null) {
                this.b = new java.util.ArrayList<>();
            }
            if (i == 0 || i == 1 || i == 4) {
                g();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void B() {
        try {
            if (com.loc.gd.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.r = this.a.isWifiEnabled();
            }
        } catch (java.lang.Throwable unused) {
            com.loc.fx.b();
        }
    }

    private boolean C() {
        this.q = w();
        B();
        if (!this.q || !this.l) {
            return false;
        }
        if (f != 0) {
            if (com.loc.gd.b() - f < 4900 || com.loc.gd.b() - g < 1500) {
                return false;
            }
            com.loc.gd.b();
        }
        return true;
    }

    private static boolean a(int i) {
        int i2 = 20;
        try {
            i2 = android.net.wifi.WifiManager.calculateSignalLevel(i, 20);
        } catch (java.lang.ArithmeticException e2) {
            com.loc.fv.a(e2, "Aps", "wifiSigFine");
        }
        return i2 > 0;
    }

    public static boolean a(com.loc.fi fiVar) {
        if (fiVar == null) {
            return false;
        }
        return fiVar.d();
    }

    public static long b() {
        return ((com.loc.gd.b() - w) / 1000) + 1;
    }

    private void d(boolean z2) {
        java.lang.String valueOf;
        java.util.ArrayList<com.loc.ei> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (com.loc.gd.b() - g > 3600000) {
            g();
        }
        if (this.p == null) {
            this.p = new java.util.TreeMap<>(java.util.Collections.reverseOrder());
        }
        this.p.clear();
        if (this.f408s && z2) {
            try {
                this.c.clear();
            } catch (java.lang.Throwable unused) {
            }
        }
        int size = this.b.size();
        this.u = 0L;
        for (int i = 0; i < size; i++) {
            com.loc.ei eiVar = this.b.get(i);
            if (eiVar.h) {
                this.u = eiVar.f;
            }
            if (com.loc.gd.a(com.loc.ei.a(eiVar.a)) && (size <= 20 || a(eiVar.c))) {
                if (this.f408s && z2) {
                    this.c.add(eiVar);
                }
                if (!android.text.TextUtils.isEmpty(eiVar.b)) {
                    valueOf = "<unknown ssid>".equals(eiVar.b) ? "unkwn" : java.lang.String.valueOf(i);
                    this.p.put(java.lang.Integer.valueOf((eiVar.c * 25) + i), eiVar);
                }
                eiVar.b = valueOf;
                this.p.put(java.lang.Integer.valueOf((eiVar.c * 25) + i), eiVar);
            }
        }
        this.b.clear();
        java.util.Iterator<com.loc.ei> it = this.p.values().iterator();
        while (it.hasNext()) {
            this.b.add(it.next());
        }
        this.p.clear();
    }

    public static java.lang.String q() {
        return java.lang.String.valueOf(com.loc.gd.b() - g);
    }

    private java.util.List<com.loc.ei> s() {
        java.util.List<android.net.wifi.ScanResult> list;
        if (this.a != null) {
            try {
                if (com.loc.gd.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    list = this.a.getScanResults();
                } else {
                    com.loc.fv.a(new java.lang.Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    list = null;
                }
                java.util.HashMap<java.lang.String, java.lang.Long> hashMap = new java.util.HashMap<>(36);
                if (list != null) {
                    for (android.net.wifi.ScanResult scanResult : list) {
                        hashMap.put(scanResult.BSSID, java.lang.Long.valueOf(scanResult.timestamp));
                    }
                }
                if (v.isEmpty() || !v.equals(hashMap)) {
                    v = hashMap;
                    w = com.loc.gd.b();
                }
                this.o = null;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                this.C = "";
                this.B = n();
                if (a(this.B)) {
                    this.C = this.B.a();
                }
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        android.net.wifi.ScanResult scanResult2 = list.get(i);
                        com.loc.ei eiVar = new com.loc.ei(!android.text.TextUtils.isEmpty(this.C) && this.C.equals(scanResult2.BSSID));
                        eiVar.b = scanResult2.SSID;
                        eiVar.d = scanResult2.frequency;
                        eiVar.e = scanResult2.timestamp;
                        eiVar.a = com.loc.ei.a(scanResult2.BSSID);
                        eiVar.c = (short) scanResult2.level;
                        short elapsedRealtime = (short) ((android.os.SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        eiVar.g = elapsedRealtime;
                        if (elapsedRealtime < 0) {
                            eiVar.g = (short) 0;
                        }
                        eiVar.f = com.loc.gd.b();
                        arrayList.add(eiVar);
                    }
                }
                this.t.a((java.util.List) arrayList);
                return arrayList;
            } catch (java.lang.SecurityException e2) {
                this.o = e2.getMessage();
            } catch (java.lang.Throwable th) {
                this.o = null;
                com.loc.fv.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private int t() {
        android.net.wifi.WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean u() {
        long b = com.loc.gd.b() - d;
        if (b < 4900) {
            return false;
        }
        if (v() && b < 9900) {
            return false;
        }
        if (x > 1) {
            long j = this.D;
            if (j == 30000) {
                j = com.loc.fu.o() != -1 ? com.loc.fu.o() : 30000L;
            }
            if (android.os.Build.VERSION.SDK_INT >= 28 && b < j) {
                return false;
            }
        }
        if (this.a != null) {
            d = com.loc.gd.b();
            int i = x;
            if (i < 2) {
                x = i + 1;
            }
            if (com.loc.gd.c(this.i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                return this.a.startScan();
            }
            com.loc.fv.a(new java.lang.Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        }
        return false;
    }

    private boolean v() {
        if (this.y == null) {
            this.y = (android.net.ConnectivityManager) com.loc.gd.a(this.i, "connectivity");
        }
        return a(this.y);
    }

    private boolean w() {
        if (this.a == null) {
            return false;
        }
        return com.loc.gd.g(this.i);
    }

    private void x() {
        if (C()) {
            long b = com.loc.gd.b();
            if (b - e >= 10000) {
                this.b.clear();
                h = g;
            }
            y();
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

    private void y() {
        if (C()) {
            try {
                if (u()) {
                    f = com.loc.gd.b();
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void z() {
        java.util.List<com.loc.ei> list;
        if (h != g) {
            try {
                list = s();
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "WifiManager", "updateScanResult");
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

    public final java.util.ArrayList<com.loc.ei> a() {
        if (!this.f408s) {
            return this.c;
        }
        b(true);
        return this.c;
    }

    public final void a(com.loc.eu euVar) {
        this.E = euVar;
    }

    public final void a(boolean z2) {
        android.content.Context context = this.i;
        if (!com.loc.fu.n() || !this.n || this.a == null || context == null || !z2 || com.loc.gd.c() <= 17) {
            return;
        }
        android.content.ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((java.lang.Integer) com.loc.fz.a("android.provider.Settings$Global", "getInt", new java.lang.Object[]{contentResolver, "wifi_scan_always_enabled"}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.ContentResolver.class, java.lang.String.class})).intValue() == 0) {
                com.loc.fz.a("android.provider.Settings$Global", "putInt", new java.lang.Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.ContentResolver.class, java.lang.String.class, java.lang.Integer.TYPE});
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final void a(boolean z2, boolean z3, boolean z4, long j) {
        this.l = z2;
        this.m = z3;
        this.n = z4;
        if (j < 10000) {
            this.D = 10000L;
        } else {
            this.D = j;
        }
    }

    public final boolean a(android.net.ConnectivityManager connectivityManager) {
        try {
            if (com.loc.gd.a(connectivityManager.getActiveNetworkInfo()) == 1) {
                return a(n());
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void b(boolean z2) {
        if (z2) {
            x();
        } else {
            y();
        }
        boolean z3 = false;
        if (this.A) {
            this.A = false;
            A();
        }
        z();
        if (com.loc.gd.b() - g > com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
            this.b.clear();
        }
        e = com.loc.gd.b();
        if (this.b.isEmpty()) {
            g = com.loc.gd.b();
            java.util.List<com.loc.ei> s2 = s();
            if (s2 != null) {
                this.b.addAll(s2);
                z3 = true;
            }
        }
        d(z3);
    }

    public final android.net.wifi.WifiInfo c() {
        try {
            if (this.a == null) {
                return null;
            }
            if (com.loc.gd.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                return this.a.getConnectionInfo();
            }
            com.loc.fv.a(new java.lang.Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
            return null;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final void c(boolean z2) {
        g();
        this.b.clear();
        this.t.a(z2);
    }

    public final java.lang.String d() {
        return this.o;
    }

    public final java.util.ArrayList<com.loc.ei> e() {
        if (this.b == null) {
            return null;
        }
        java.util.ArrayList<com.loc.ei> arrayList = new java.util.ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void f() {
        try {
            this.f408s = true;
            java.util.List<com.loc.ei> s2 = s();
            if (s2 != null) {
                this.b.clear();
                this.b.addAll(s2);
            }
            d(true);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void g() {
        this.B = null;
        this.b.clear();
    }

    public final void h() {
        this.B = null;
    }

    public final void i() {
        z = java.lang.System.currentTimeMillis();
        com.loc.eu euVar = this.E;
        if (euVar != null) {
            euVar.b();
        }
    }

    public final void j() {
        if (this.a != null && com.loc.gd.b() - g > 4900) {
            g = com.loc.gd.b();
        }
    }

    public final void k() {
        if (this.a == null) {
            return;
        }
        this.A = true;
    }

    public final boolean l() {
        return this.q;
    }

    public final boolean m() {
        return this.r;
    }

    public final com.loc.fi n() {
        B();
        if (!m()) {
            return null;
        }
        if (this.B == null) {
            this.B = new com.loc.fi(c());
        }
        return this.B;
    }

    public final boolean o() {
        return this.j;
    }

    public final java.lang.String p() {
        boolean z2;
        java.lang.String str;
        java.lang.StringBuilder sb = this.k;
        if (sb == null) {
            this.k = new java.lang.StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.j = false;
        int size = this.b.size();
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i < size) {
            java.lang.String a = com.loc.ei.a(this.b.get(i).a);
            if (!this.m && !"<unknown ssid>".equals(this.b.get(i).b)) {
                z3 = true;
            }
            if (android.text.TextUtils.isEmpty(this.C) || !this.C.equals(a)) {
                z2 = z4;
                str = "nb";
            } else {
                str = com.umeng.analytics.pro.bo.Q;
                z2 = true;
            }
            this.k.append(java.lang.String.format(java.util.Locale.US, "#%s,%s", a, str));
            i++;
            z4 = z2;
        }
        if (this.b.size() == 0) {
            z3 = true;
        }
        if (!this.m && !z3) {
            this.j = true;
        }
        if (!z4 && !android.text.TextUtils.isEmpty(this.C)) {
            java.lang.StringBuilder sb2 = this.k;
            sb2.append("#");
            sb2.append(this.C);
            this.k.append(",access");
        }
        return this.k.toString();
    }

    public final long r() {
        return this.u;
    }
}
