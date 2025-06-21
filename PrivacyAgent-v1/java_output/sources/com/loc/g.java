package com.loc;

/* loaded from: classes23.dex */
public final class g {
    public static volatile com.amap.api.location.AMapLocation a = null;
    private static java.lang.String b = "CoarseLocation";
    private static long q;
    private static boolean r;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f412s;
    private static boolean t;
    private static boolean u;
    private com.loc.ex f;
    private android.os.Handler j;
    private android.content.Context k;
    private android.location.LocationManager n;
    private com.amap.api.location.AMapLocationClientOption o;
    private long c = 0;
    private boolean d = false;
    private int e = 0;
    private int g = 240;
    private int h = 80;
    private int i = 0;
    private long l = 0;
    private int m = 0;
    private java.lang.Object p = new java.lang.Object();
    private boolean v = true;
    private com.amap.api.location.AMapLocationClientOption.GeoLanguage w = com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT;
    private android.location.LocationListener x = null;

    public static class a implements android.location.LocationListener {
        private com.loc.g a;

        public a(com.loc.g gVar) {
            this.a = gVar;
        }

        public final void a() {
            this.a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(android.location.Location location) {
            try {
                com.loc.g gVar = this.a;
                if (gVar != null) {
                    gVar.a(location);
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(java.lang.String str) {
            try {
                com.loc.g gVar = this.a;
                if (gVar != null) {
                    gVar.g();
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(java.lang.String str) {
            if (com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                com.loc.fx.a();
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(java.lang.String str, int i, android.os.Bundle bundle) {
            try {
                com.loc.g gVar = this.a;
                if (gVar != null) {
                    gVar.a(i);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public g(android.content.Context context, android.os.Handler handler) {
        this.f = null;
        this.k = context;
        this.j = handler;
        try {
            this.n = (android.location.LocationManager) context.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, b, "<init>");
        }
        this.f = new com.loc.ex();
    }

    private static com.loc.ey a(int i, java.lang.String str) {
        com.loc.ey eyVar = new com.loc.ey("");
        eyVar.setErrorCode(i);
        eyVar.setLocationDetail(str);
        return eyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            try {
                com.loc.fx.a();
                this.i = 0;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void a(int i, java.lang.String str, long j) {
        try {
            if (this.j != null) {
                android.os.Message obtain = android.os.Message.obtain();
                com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation("");
                aMapLocation.setErrorCode(20);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(11);
                obtain.obj = aMapLocation;
                obtain.what = i;
                this.j.sendMessageDelayed(obtain, j);
            }
        } catch (java.lang.Throwable unused) {
            com.loc.fx.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079 A[Catch: all -> 0x00e8, TryCatch #3 {all -> 0x00e8, blocks: (B:8:0x000c, B:11:0x0018, B:14:0x0026, B:15:0x002d, B:17:0x0037, B:19:0x003d, B:20:0x0057, B:26:0x0073, B:28:0x0079, B:30:0x0088, B:32:0x008d, B:34:0x00b9, B:36:0x00bf, B:37:0x00da, B:41:0x00e1, B:46:0x00e7, B:47:0x00bd, B:39:0x00db, B:40:0x00e0), top: B:7:0x000c, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bd A[Catch: all -> 0x00e8, TryCatch #3 {all -> 0x00e8, blocks: (B:8:0x000c, B:11:0x0018, B:14:0x0026, B:15:0x002d, B:17:0x0037, B:19:0x003d, B:20:0x0057, B:26:0x0073, B:28:0x0079, B:30:0x0088, B:32:0x008d, B:34:0x00b9, B:36:0x00bf, B:37:0x00da, B:41:0x00e1, B:46:0x00e7, B:47:0x00bd, B:39:0x00db, B:40:0x00e0), top: B:7:0x000c, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(android.location.Location location) {
        java.lang.Boolean bool;
        android.os.Handler handler = this.j;
        if (handler != null) {
            handler.removeMessages(100);
        }
        if (location == null) {
            return;
        }
        try {
            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation(location);
            if (com.loc.gd.a(aMapLocation)) {
                aMapLocation.setProvider(com.amap.api.services.geocoder.GeocodeSearch.GPS.equals(location.getProvider()) ? "gps_coarse" : "network_coarse");
                aMapLocation.setLocationType(11);
                if (!this.d && com.loc.gd.a(aMapLocation)) {
                    com.loc.gb.b(this.k, com.loc.gd.b() - this.c, com.loc.fv.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.d = true;
                }
                java.lang.Boolean bool2 = java.lang.Boolean.FALSE;
                try {
                    bool = (java.lang.Boolean) com.loc.fz.a(location, "isFromMockProvider", new java.lang.Object[0]);
                    try {
                        "CoarseLocation | isFromMock=".concat(java.lang.String.valueOf(bool));
                        com.loc.fx.a();
                    } catch (java.lang.Throwable unused) {
                        bool2 = bool;
                        bool = bool2;
                        if (bool.booleanValue()) {
                        }
                        int b2 = b(location);
                        this.i = b2;
                        aMapLocation.setSatellites(b2);
                        e(aMapLocation);
                        g(aMapLocation);
                        com.amap.api.location.AMapLocation f = f(aMapLocation);
                        a(f);
                        b(f);
                        synchronized (this.p) {
                        }
                    }
                } catch (java.lang.Throwable unused2) {
                }
                if (bool.booleanValue()) {
                    this.m = 0;
                } else {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.o.isMockEnable()) {
                        int i = this.m;
                        if (i <= 3) {
                            this.m = i + 1;
                            return;
                        }
                        com.loc.gb.a((java.lang.String) null, 2152);
                        aMapLocation.setErrorCode(15);
                        aMapLocation.setLocationDetail("CoarseLocation has been mocked!#2007");
                        aMapLocation.setLatitude(0.0d);
                        aMapLocation.setLongitude(0.0d);
                        aMapLocation.setAltitude(0.0d);
                        aMapLocation.setSpeed(0.0f);
                        aMapLocation.setAccuracy(0.0f);
                        aMapLocation.setBearing(0.0f);
                        aMapLocation.setExtras(null);
                        c(aMapLocation);
                        return;
                    }
                }
                int b22 = b(location);
                this.i = b22;
                aMapLocation.setSatellites(b22);
                e(aMapLocation);
                g(aMapLocation);
                com.amap.api.location.AMapLocation f2 = f(aMapLocation);
                a(f2);
                b(f2);
                synchronized (this.p) {
                    a(f2, a);
                }
                c(f2);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "CoarseLocation", "onLocationChanged");
        }
    }

    private void a(com.amap.api.location.AMapLocation aMapLocation) {
        if (com.loc.gd.a(aMapLocation)) {
            this.e++;
        }
    }

    private void a(com.amap.api.location.AMapLocation aMapLocation, com.amap.api.location.AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.o.isNeedAddress() || com.loc.gd.a(aMapLocation, aMapLocation2) >= this.g) {
            return;
        }
        com.loc.fv.a(aMapLocation, aMapLocation2);
    }

    private static boolean a(android.location.LocationManager locationManager) {
        try {
            if (r) {
                return f412s;
            }
            java.util.List<java.lang.String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                f412s = false;
            } else {
                f412s = allProviders.contains(com.amap.api.services.geocoder.GeocodeSearch.GPS);
            }
            r = true;
            return f412s;
        } catch (java.lang.Throwable th) {
            new java.lang.StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            com.loc.fx.a();
            return f412s;
        }
    }

    private static int b(android.location.Location location) {
        android.os.Bundle extras = location.getExtras();
        int i = extras != null ? extras.getInt("satellites") : 0;
        com.loc.fx.b();
        return i;
    }

    private void b(com.amap.api.location.AMapLocation aMapLocation) {
        android.os.Handler handler;
        if (com.loc.gd.a(aMapLocation) && this.j != null) {
            long b2 = com.loc.gd.b();
            if (this.o.getInterval() <= 8000 || b2 - this.l > this.o.getInterval() - 8000) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble(com.anythink.core.common.h.c.C, aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                android.os.Message obtain = android.os.Message.obtain();
                obtain.setData(bundle);
                obtain.what = 102;
                synchronized (this.p) {
                    if (a == null) {
                        handler = this.j;
                    } else if (com.loc.gd.a(aMapLocation, a) > this.h) {
                        handler = this.j;
                    }
                    handler.sendMessage(obtain);
                }
            }
        }
    }

    private static boolean b(android.location.LocationManager locationManager) {
        try {
            if (t) {
                return u;
            }
            boolean isProviderEnabled = locationManager.isProviderEnabled("network");
            u = isProviderEnabled;
            t = true;
            return isProviderEnabled;
        } catch (java.lang.Throwable th) {
            new java.lang.StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            com.loc.fx.a();
            return u;
        }
    }

    private void c(com.amap.api.location.AMapLocation aMapLocation) {
        if (this.o.getLocationMode().equals(com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.o.getDeviceModeDistanceFilter() > 0.0f) {
            d(aMapLocation);
        } else if (com.loc.gd.b() - this.l >= this.o.getInterval() - 200) {
            this.l = com.loc.gd.b();
            d(aMapLocation);
        }
    }

    private boolean c() {
        boolean z = true;
        try {
            if (com.loc.gd.c() >= 28) {
                if (this.n == null) {
                    this.n = (android.location.LocationManager) this.k.getApplicationContext().getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
                }
                z = ((java.lang.Boolean) com.loc.fz.a(this.n, "isLocationEnabled", new java.lang.Object[0])).booleanValue();
            }
            if (com.loc.gd.c() >= 24 && com.loc.gd.c() < 28) {
                if (android.provider.Settings.Secure.getInt(this.k.getContentResolver(), "location_mode", 0) == 0) {
                    return false;
                }
            }
        } catch (java.lang.Throwable unused) {
            com.loc.fx.a();
        }
        return z;
    }

    private void d() {
        c(a(12, "定位服务没有开启，请在设置中打开定位服务开关#1206"));
    }

    private void d(com.amap.api.location.AMapLocation aMapLocation) {
        if (this.j != null) {
            com.loc.fx.a();
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 101;
            this.j.sendMessage(obtain);
        }
    }

    private void e() {
        c(a(20, "模糊权限下不支持连续定位#2006"));
    }

    private void e(com.amap.api.location.AMapLocation aMapLocation) {
        try {
            if (!com.loc.fv.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.o.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType("WGS84");
                return;
            }
            com.amap.api.location.DPoint a2 = com.loc.fy.a(this.k, new com.amap.api.location.DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(a2.getLatitude());
            aMapLocation.setLongitude(a2.getLongitude());
            aMapLocation.setOffset(this.o.isOffset());
            aMapLocation.setCoordType("GCJ02");
        } catch (java.lang.Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
            new java.lang.StringBuilder("CoarseLocation | offset error: ").append(th.getMessage());
            com.loc.fx.a();
        }
    }

    private com.amap.api.location.AMapLocation f(com.amap.api.location.AMapLocation aMapLocation) {
        if (!com.loc.gd.a(aMapLocation) || this.e < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.f.a(aMapLocation);
    }

    private void f() {
        if (this.n == null) {
            return;
        }
        try {
            this.v = true;
            android.os.Looper myLooper = android.os.Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.k.getMainLooper();
            }
            this.c = com.loc.gd.b();
            if (b(this.n)) {
                if (this.x == null) {
                    this.x = new com.loc.g.a(this);
                }
                this.n.requestLocationUpdates("network", this.o.getInterval(), this.o.getDeviceModeDistanceFilter(), this.x, myLooper);
            }
            if (a(this.n)) {
                try {
                    if (com.loc.gd.a() - q >= 259200000) {
                        if (com.loc.gd.c(this.k, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.n.sendExtraCommand(com.amap.api.services.geocoder.GeocodeSearch.GPS, "force_xtra_injection", null);
                            q = com.loc.gd.a();
                            android.content.SharedPreferences.Editor a2 = com.loc.gc.a(this.k, "pref");
                            com.loc.gc.a(a2, "lagt", q);
                            com.loc.gc.a(a2);
                            com.loc.fx.a();
                        } else {
                            com.loc.fv.a(new java.lang.Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");
                        }
                    }
                } catch (java.lang.Throwable th) {
                    new java.lang.StringBuilder("CoarseLocation | sendExtraCommand error: ").append(th.getMessage());
                    com.loc.fx.a();
                }
                if (this.x == null) {
                    this.x = new com.loc.g.a(this);
                }
                this.n.requestLocationUpdates(com.amap.api.services.geocoder.GeocodeSearch.GPS, this.o.getInterval(), this.o.getDeviceModeDistanceFilter(), this.x, myLooper);
                com.loc.fx.a();
            }
            if (f412s || u) {
                a(100, "系统返回定位结果超时#2002", this.o.getHttpTimeOut());
            }
            if (f412s || u) {
                return;
            }
            com.loc.fx.a();
            a(100, "系统定位当前不可用#2003", 0L);
        } catch (java.lang.SecurityException e) {
            com.loc.fx.a();
            this.v = false;
            com.loc.gb.a((java.lang.String) null, 2121);
            a(101, e.getMessage() + "#2004", 0L);
        } catch (java.lang.Throwable th2) {
            new java.lang.StringBuilder("CoarseLocation | requestLocationUpdates error: ").append(th2.getMessage());
            com.loc.fx.a();
            com.loc.fv.a(th2, "CoarseLocation", "requestLocationUpdates part2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.loc.fx.a();
            this.i = 0;
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void g(com.amap.api.location.AMapLocation aMapLocation) {
        if (com.loc.gd.a(aMapLocation) && com.loc.fu.s()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long a2 = com.loc.fw.a(time, currentTimeMillis, com.loc.fu.t());
            if (a2 != time) {
                aMapLocation.setTime(a2);
                com.loc.gb.a(time, currentTimeMillis);
            }
        }
    }

    public final void a() {
        com.loc.fx.a();
        android.location.LocationManager locationManager = this.n;
        if (locationManager == null) {
            return;
        }
        try {
            android.location.LocationListener locationListener = this.x;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((com.loc.g.a) this.x).a();
                this.x = null;
                com.loc.fx.a();
            }
        } catch (java.lang.Throwable th) {
            new java.lang.StringBuilder("CoarseLocation | removeUpdates error ").append(th.getMessage());
            com.loc.fx.a();
        }
        try {
            android.os.Handler handler = this.j;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (java.lang.Throwable unused) {
        }
        this.i = 0;
        this.c = 0L;
        this.l = 0L;
        this.e = 0;
        this.m = 0;
        this.f.a();
    }

    public final void a(android.os.Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(com.amap.api.location.AMapLocation.class.getClassLoader());
                this.g = bundle.getInt("I_MAX_GEO_DIS");
                this.h = bundle.getInt("I_MIN_GEO_DIS");
                com.amap.api.location.AMapLocation aMapLocation = (com.amap.api.location.AMapLocation) bundle.getParcelable("loc");
                if (android.text.TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.p) {
                    a = aMapLocation;
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "CoarseLocation", "setLastGeoLocation");
            }
        }
    }

    public final void a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        this.o = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.o = new com.amap.api.location.AMapLocationClientOption();
        }
        new java.lang.StringBuilder("option: ").append(this.o.toString());
        com.loc.fx.a();
        if (!this.o.isOnceLocation()) {
            e();
        } else if (!c()) {
            d();
        } else {
            try {
                q = com.loc.gc.a(this.k, "pref", "lagt", q);
            } catch (java.lang.Throwable unused) {
            }
            f();
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public final int b() {
        android.location.LocationManager locationManager = this.n;
        if (locationManager == null || !a(locationManager)) {
            return 1;
        }
        int i = android.provider.Settings.Secure.getInt(this.k.getContentResolver(), "location_mode", 0);
        if (i == 0) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        return !this.v ? 4 : 0;
    }

    public final void b(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new com.amap.api.location.AMapLocationClientOption();
        }
        this.o = aMapLocationClientOption;
        new java.lang.StringBuilder("option: ").append(this.o.toString());
        com.loc.fx.a();
        this.j.removeMessages(100);
        if (this.w != this.o.getGeoLanguage()) {
            synchronized (this.p) {
                a = null;
            }
        }
        this.w = this.o.getGeoLanguage();
    }
}
