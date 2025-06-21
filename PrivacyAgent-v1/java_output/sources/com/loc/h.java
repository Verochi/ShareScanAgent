package com.loc;

/* loaded from: classes23.dex */
public final class h {
    static com.amap.api.location.AMapLocation j;
    static long k;
    static java.lang.Object l = new java.lang.Object();
    static long q;
    static boolean t;
    static boolean u;
    public static volatile com.amap.api.location.AMapLocation y;
    private android.location.GnssStatus.Callback F;
    android.os.Handler a;
    android.location.LocationManager b;
    com.amap.api.location.AMapLocationClientOption c;
    com.loc.ex f;
    private android.content.Context z;
    private long A = 0;
    long d = 0;
    boolean e = false;
    private int B = 0;
    int g = 240;
    int h = 80;
    com.amap.api.location.AMapLocation i = null;
    long m = 0;
    float n = 0.0f;
    java.lang.Object o = new java.lang.Object();
    java.lang.Object p = new java.lang.Object();
    private int C = 0;
    private android.location.GpsStatus D = null;
    private android.location.GpsStatus.Listener E = null;
    com.amap.api.location.AMapLocationClientOption.GeoLanguage r = com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s, reason: collision with root package name */
    boolean f413s = true;
    long v = 0;
    int w = 0;
    android.location.LocationListener x = null;
    private java.lang.String G = null;
    private boolean H = false;
    private int I = 0;
    private boolean J = false;

    /* renamed from: com.loc.h$1, reason: invalid class name */
    public class AnonymousClass1 extends android.location.GnssStatus.Callback {
        public AnonymousClass1() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i) {
            com.loc.h.l();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(android.location.GnssStatus gnssStatus) {
            com.loc.h.this.a(gnssStatus);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            com.loc.h.j();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            com.loc.h.this.k();
        }
    }

    /* renamed from: com.loc.h$2, reason: invalid class name */
    public class AnonymousClass2 implements android.location.GpsStatus.Listener {
        public AnonymousClass2() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            try {
                com.loc.h hVar = com.loc.h.this;
                android.location.LocationManager locationManager = hVar.b;
                if (locationManager == null) {
                    return;
                }
                hVar.D = locationManager.getGpsStatus(hVar.D);
                if (i == 1) {
                    com.loc.h.j();
                    return;
                }
                if (i == 2) {
                    com.loc.h.this.k();
                } else if (i == 3) {
                    com.loc.h.l();
                } else {
                    if (i != 4) {
                        return;
                    }
                    com.loc.h.this.m();
                }
            } catch (java.lang.Throwable th) {
                new java.lang.StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
                com.loc.fx.a();
                com.loc.fv.a(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    }

    public static class a implements android.location.LocationListener {
        private com.loc.h a;

        public a(com.loc.h hVar) {
            this.a = hVar;
        }

        public final void a() {
            this.a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(android.location.Location location) {
            try {
                new java.lang.StringBuilder("tid=").append(java.lang.Thread.currentThread().getId());
                com.loc.fx.a();
                com.loc.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(location);
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(java.lang.String str) {
            try {
                com.loc.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str);
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(java.lang.String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(java.lang.String str, int i, android.os.Bundle bundle) {
            try {
                com.loc.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(i);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public h(android.content.Context context, android.os.Handler handler) {
        this.f = null;
        this.z = context;
        this.a = handler;
        try {
            this.b = (android.location.LocationManager) context.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GpsLocation", "<init>");
        }
        this.f = new com.loc.ex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            try {
                this.d = 0L;
                this.C = 0;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void a(int i, int i2, java.lang.String str, long j2) {
        try {
            if (this.a == null || this.c.getLocationMode() != com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            android.os.Message obtain = android.os.Message.obtain();
            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation("");
            aMapLocation.setProvider(com.amap.api.services.geocoder.GeocodeSearch.GPS);
            aMapLocation.setErrorCode(i2);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i;
            this.a.sendMessageDelayed(obtain, j2);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.location.GnssStatus gnssStatus) {
        int satelliteCount;
        boolean usedInFix;
        int i = 0;
        if (gnssStatus != null) {
            try {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    satelliteCount = gnssStatus.getSatelliteCount();
                    int i2 = 0;
                    while (i < satelliteCount) {
                        try {
                            usedInFix = gnssStatus.usedInFix(i);
                            if (usedInFix) {
                                i2++;
                            }
                            i++;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            i = i2;
                            com.loc.fv.a(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                            this.C = i;
                        }
                    }
                    i = i2;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        this.C = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.location.Location location) {
        android.os.Handler handler = this.a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation(location);
            if (com.loc.gd.a(aMapLocation)) {
                aMapLocation.setProvider(com.amap.api.services.geocoder.GeocodeSearch.GPS);
                aMapLocation.setLocationType(1);
                if (!this.e && com.loc.gd.a(aMapLocation)) {
                    com.loc.gb.a(this.z, com.loc.gd.b() - this.A, com.loc.fv.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.e = true;
                }
                if (com.loc.gd.a(aMapLocation, this.C)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.c.isMockEnable()) {
                        int i = this.w;
                        if (i <= 3) {
                            this.w = i + 1;
                            return;
                        }
                        com.loc.gb.a((java.lang.String) null, 2152);
                        aMapLocation.setErrorCode(15);
                        aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
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
                } else {
                    this.w = 0;
                }
                aMapLocation.setSatellites(this.C);
                e(aMapLocation);
                f(aMapLocation);
                h(aMapLocation);
                com.amap.api.location.AMapLocation g = g(aMapLocation);
                a(g);
                b(g);
                synchronized (this.o) {
                    a(g, y);
                }
                try {
                    if (com.loc.gd.a(g)) {
                        if (this.i != null) {
                            this.m = location.getTime() - this.i.getTime();
                            this.n = com.loc.gd.a(this.i, g);
                        }
                        synchronized (this.p) {
                            this.i = g.m13clone();
                        }
                        this.G = null;
                        this.H = false;
                        this.I = 0;
                    }
                } catch (java.lang.Throwable th) {
                    com.loc.fv.a(th, "GpsLocation", "onLocationChangedLast");
                }
                c(g);
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "GpsLocation", "onLocationChanged");
        }
    }

    private void a(com.amap.api.location.AMapLocation aMapLocation) {
        if (com.loc.gd.a(aMapLocation)) {
            this.d = com.loc.gd.b();
            synchronized (l) {
                k = com.loc.gd.b();
                j = aMapLocation.m13clone();
            }
            this.B++;
        }
    }

    private void a(com.amap.api.location.AMapLocation aMapLocation, com.amap.api.location.AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.c.isNeedAddress() || com.loc.gd.a(aMapLocation, aMapLocation2) >= this.g) {
            return;
        }
        com.loc.fv.a(aMapLocation, aMapLocation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
        try {
            if (com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                this.d = 0L;
                this.C = 0;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static boolean a(android.location.LocationManager locationManager) {
        try {
            if (t) {
                return u;
            }
            java.util.List<java.lang.String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                u = false;
            } else {
                u = allProviders.contains(com.amap.api.services.geocoder.GeocodeSearch.GPS);
            }
            t = true;
            return u;
        } catch (java.lang.Throwable th) {
            new java.lang.StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
            com.loc.fx.a();
            return u;
        }
    }

    private void b(com.amap.api.location.AMapLocation aMapLocation) {
        android.os.Handler handler;
        if (com.loc.gd.a(aMapLocation) && this.a != null) {
            long b = com.loc.gd.b();
            if (this.c.getInterval() <= 8000 || b - this.v > this.c.getInterval() - 8000) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble(com.anythink.core.common.h.c.C, aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                android.os.Message obtain = android.os.Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.o) {
                    if (y == null) {
                        handler = this.a;
                    } else if (com.loc.gd.a(aMapLocation, y) > this.h) {
                        handler = this.a;
                    }
                    handler.sendMessage(obtain);
                }
            }
        }
    }

    private boolean b(java.lang.String str) {
        try {
            java.util.ArrayList<java.lang.String> b = com.loc.gd.b(str);
            java.util.ArrayList<java.lang.String> b2 = com.loc.gd.b(this.G);
            if (b.size() < 8 || b2.size() < 8) {
                return false;
            }
            return com.loc.gd.a(this.G, str);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private void c(com.amap.api.location.AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.c.getLocationMode())) {
            if (this.c.getLocationMode().equals(com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.c.getDeviceModeDistanceFilter() > 0.0f) {
                d(aMapLocation);
            } else if (com.loc.gd.b() - this.v >= this.c.getInterval() - 200) {
                this.v = com.loc.gd.b();
                d(aMapLocation);
            }
        }
    }

    private void d(com.amap.api.location.AMapLocation aMapLocation) {
        if (this.a != null) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.a.sendMessage(obtain);
        }
    }

    private void e(com.amap.api.location.AMapLocation aMapLocation) {
        try {
            if (!com.loc.fv.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.c.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType("WGS84");
                return;
            }
            com.amap.api.location.DPoint a2 = com.loc.fy.a(this.z, new com.amap.api.location.DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(a2.getLatitude());
            aMapLocation.setLongitude(a2.getLongitude());
            aMapLocation.setOffset(this.c.isOffset());
            aMapLocation.setCoordType("GCJ02");
        } catch (java.lang.Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
        }
    }

    private void f(com.amap.api.location.AMapLocation aMapLocation) {
        try {
            int i = this.C;
            if (i >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (i == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private com.amap.api.location.AMapLocation g(com.amap.api.location.AMapLocation aMapLocation) {
        if (!com.loc.gd.a(aMapLocation) || this.B < 3) {
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

    private static void h(com.amap.api.location.AMapLocation aMapLocation) {
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

    private void i() {
        android.location.LocationManager locationManager;
        java.lang.String str;
        long j2;
        float f;
        android.location.LocationListener locationListener;
        if (this.b == null) {
            return;
        }
        try {
            n();
            this.f413s = true;
            android.os.Looper myLooper = android.os.Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.z.getMainLooper();
            }
            android.os.Looper looper = myLooper;
            this.A = com.loc.gd.b();
            if (!a(this.b)) {
                com.loc.fx.a();
                a(8, 14, "no gps provider#1402", 0L);
                return;
            }
            try {
                if (com.loc.gd.a() - q >= 259200000) {
                    if (com.loc.gd.c(this.z, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                        this.b.sendExtraCommand(com.amap.api.services.geocoder.GeocodeSearch.GPS, "force_xtra_injection", null);
                        q = com.loc.gd.a();
                        android.content.SharedPreferences.Editor a2 = com.loc.gc.a(this.z, "pref");
                        com.loc.gc.a(a2, "lagt", q);
                        com.loc.gc.a(a2);
                        com.loc.fx.a();
                    } else {
                        com.loc.fv.a(new java.lang.Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                    }
                }
            } catch (java.lang.Throwable th) {
                new java.lang.StringBuilder("GpsLocation | sendExtraCommand error: ").append(th.getMessage());
                com.loc.fx.a();
            }
            if (this.x == null) {
                this.x = new com.loc.h.a(this);
            }
            if (!this.c.getLocationMode().equals(com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors) || this.c.getDeviceModeDistanceFilter() <= 0.0f) {
                locationManager = this.b;
                str = com.amap.api.services.geocoder.GeocodeSearch.GPS;
                j2 = 900;
                f = 0.0f;
                locationListener = this.x;
            } else {
                locationManager = this.b;
                str = com.amap.api.services.geocoder.GeocodeSearch.GPS;
                j2 = this.c.getInterval();
                f = this.c.getDeviceModeDistanceFilter();
                locationListener = this.x;
            }
            locationManager.requestLocationUpdates(str, j2, f, locationListener, looper);
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                com.loc.h.AnonymousClass1 anonymousClass1 = new com.loc.h.AnonymousClass1();
                this.F = anonymousClass1;
                this.b.registerGnssStatusCallback(anonymousClass1);
            } else {
                com.loc.h.AnonymousClass2 anonymousClass2 = new com.loc.h.AnonymousClass2();
                this.E = anonymousClass2;
                this.b.addGpsStatusListener(anonymousClass2);
                com.loc.fx.a();
            }
            a(8, 14, "no enough satellites#1401", this.c.getHttpTimeOut());
        } catch (java.lang.SecurityException e) {
            com.loc.fx.a();
            this.f413s = false;
            com.loc.gb.a((java.lang.String) null, 2121);
            a(2, 12, e.getMessage() + "#1201", 0L);
        } catch (java.lang.Throwable th2) {
            new java.lang.StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th2.getMessage());
            com.loc.fx.a();
            com.loc.fv.a(th2, "GpsLocation", "requestLocationUpdates part2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        com.loc.fx.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.loc.fx.a();
        this.C = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        com.loc.fx.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        java.lang.Iterable<android.location.GpsSatellite> satellites;
        int i = 0;
        try {
            android.location.GpsStatus gpsStatus = this.D;
            if (gpsStatus != null && (satellites = gpsStatus.getSatellites()) != null) {
                java.util.Iterator<android.location.GpsSatellite> it = satellites.iterator();
                int maxSatellites = this.D.getMaxSatellites();
                while (it.hasNext() && i < maxSatellites) {
                    if (it.next().usedInFix()) {
                        i++;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        this.C = i;
    }

    private void n() {
        if (com.loc.gd.b() - k > 5000 || !com.loc.gd.a(j)) {
            return;
        }
        if (this.c.isMockEnable() || !j.isMock()) {
            this.d = com.loc.gd.b();
            c(j);
        }
    }

    private static boolean o() {
        try {
            return ((java.lang.Boolean) com.loc.fz.a(com.loc.y.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), com.loc.y.c("UaXNOYXZpU3RhcnRlZA=="), (java.lang.Object[]) null, (java.lang.Class<?>[]) null)).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private com.amap.api.location.AMapLocation p() {
        float f;
        float f2;
        try {
            if (com.loc.gd.a(this.i) && com.loc.fu.k() && o()) {
                org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) com.loc.fz.a(com.loc.y.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), com.loc.y.c("UZ2V0TmF2aUxvY2F0aW9u"), (java.lang.Object[]) null, (java.lang.Class<?>[]) null));
                long optLong = jSONObject.optLong("time");
                if (!this.J) {
                    this.J = true;
                    com.loc.gb.a("useNaviLoc", "use NaviLoc");
                }
                if (com.loc.gd.a() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble("lat", 0.0d);
                    double optDouble2 = jSONObject.optDouble("lng", 0.0d);
                    float f3 = 0.0f;
                    try {
                        f = java.lang.Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (java.lang.NumberFormatException unused) {
                        f = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f2 = java.lang.Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (java.lang.NumberFormatException unused2) {
                        f2 = 0.0f;
                    }
                    try {
                        f3 = (java.lang.Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (java.lang.NumberFormatException unused3) {
                    }
                    com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f2);
                    aMapLocation.setSpeed(f3);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType("GCJ02");
                    if (com.loc.gd.a(aMapLocation, this.i) <= 300.0f) {
                        synchronized (this.p) {
                            this.i.setLongitude(optDouble2);
                            this.i.setLatitude(optDouble);
                            this.i.setAccuracy(f);
                            this.i.setBearing(f2);
                            this.i.setSpeed(f3);
                            this.i.setTime(optLong);
                            this.i.setCoordType("GCJ02");
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (java.lang.Throwable unused4) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation aMapLocation, java.lang.String str) {
        long j2;
        long b;
        if (this.i == null) {
            return aMapLocation;
        }
        if ((!this.c.isMockEnable() && this.i.isMock()) || !com.loc.gd.a(this.i)) {
            return aMapLocation;
        }
        com.amap.api.location.AMapLocation p = p();
        if (p != null && com.loc.gd.a(p)) {
            p.setTrustedLevel(2);
            return p;
        }
        float speed = this.i.getSpeed();
        if (speed == 0.0f) {
            long j3 = this.m;
            if (j3 > 0 && j3 < 8) {
                float f = this.n;
                if (f > 0.0f) {
                    speed = f / j3;
                }
            }
        }
        if (aMapLocation != null && com.loc.gd.a(aMapLocation)) {
            if (aMapLocation.getAccuracy() < 200.0f) {
                int i = this.I + 1;
                this.I = i;
                if (this.G == null && i >= 2) {
                    this.H = true;
                }
                j2 = speed > 5.0f ? 10000L : 15000L;
            } else {
                if (!android.text.TextUtils.isEmpty(this.G)) {
                    this.H = false;
                    this.I = 0;
                }
                if (speed > 5.0f) {
                    j2 = com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
                }
            }
            b = com.loc.gd.b() - this.d;
            if (b <= 30000) {
                return aMapLocation;
            }
            if (b < j2) {
                if (this.G == null && this.I >= 2) {
                    this.G = str;
                }
                com.amap.api.location.AMapLocation m13clone = this.i.m13clone();
                m13clone.setTrustedLevel(2);
                return m13clone;
            }
            if (this.H && b(str)) {
                com.amap.api.location.AMapLocation m13clone2 = this.i.m13clone();
                m13clone2.setTrustedLevel(3);
                return m13clone2;
            }
            this.G = null;
            this.I = 0;
            synchronized (this.p) {
                this.i = null;
            }
            this.m = 0L;
            this.n = 0.0f;
            return aMapLocation;
        }
        j2 = 30000;
        b = com.loc.gd.b() - this.d;
        if (b <= 30000) {
        }
    }

    public final void a() {
        android.location.LocationManager locationManager = this.b;
        if (locationManager == null) {
            return;
        }
        try {
            android.location.LocationListener locationListener = this.x;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((com.loc.h.a) this.x).a();
                this.x = null;
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            android.location.GpsStatus.Listener listener = this.E;
            if (listener != null) {
                this.b.removeGpsStatusListener(listener);
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            android.location.GnssStatus.Callback callback = this.F;
            if (callback != null) {
                this.b.unregisterGnssStatusCallback(callback);
            }
        } catch (java.lang.Throwable unused3) {
        }
        try {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.removeMessages(8);
            }
        } catch (java.lang.Throwable unused4) {
        }
        this.C = 0;
        this.A = 0L;
        this.v = 0L;
        this.d = 0L;
        this.B = 0;
        this.w = 0;
        this.f.a();
        this.i = null;
        this.m = 0L;
        this.n = 0.0f;
        this.G = null;
        this.J = false;
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
                synchronized (this.o) {
                    y = aMapLocation;
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    public final void a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        this.c = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.c = new com.amap.api.location.AMapLocationClientOption();
        }
        try {
            q = com.loc.gc.a(this.z, "pref", "lagt", q);
        } catch (java.lang.Throwable unused) {
        }
        i();
    }

    public final void b(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        android.os.Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new com.amap.api.location.AMapLocationClientOption();
        }
        this.c = aMapLocationClientOption;
        if (aMapLocationClientOption.getLocationMode() != com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.a) != null) {
            handler.removeMessages(8);
        }
        if (this.r != this.c.getGeoLanguage()) {
            synchronized (this.o) {
                y = null;
            }
        }
        this.r = this.c.getGeoLanguage();
    }

    public final boolean b() {
        return com.loc.gd.b() - this.d <= 2800;
    }

    public final void c() {
        this.w = 0;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public final int d() {
        android.location.LocationManager locationManager = this.b;
        if (locationManager == null || !a(locationManager)) {
            return 1;
        }
        int i = android.provider.Settings.Secure.getInt(this.z.getContentResolver(), "location_mode", 0);
        if (i == 0) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        return !this.f413s ? 4 : 0;
    }

    public final int e() {
        return this.C;
    }

    public final boolean f() {
        com.amap.api.location.AMapLocationClientOption aMapLocationClientOption = this.c;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || com.loc.gd.b() - this.d <= 300000) ? false : true;
    }
}
