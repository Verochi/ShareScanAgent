package com.loc;

/* loaded from: classes23.dex */
public final class k {
    static com.amap.api.location.AMapLocation j;
    static long k;
    static java.lang.Object l = new java.lang.Object();
    static long q;
    static boolean t;
    static boolean u;
    public static volatile com.amap.api.location.AMapLocation y;
    android.os.Handler a;
    android.location.LocationManager b;
    com.amap.api.location.AMapLocationClientOption c;
    com.loc.ex f;
    private android.content.Context z;
    private java.lang.String A = null;
    private int B = 0;
    private boolean C = false;
    private long D = 0;
    long d = 0;
    boolean e = false;
    private int E = 0;
    int g = 240;
    int h = 80;
    com.amap.api.location.AMapLocation i = null;
    long m = 0;
    float n = 0.0f;
    java.lang.Object o = new java.lang.Object();
    java.lang.Object p = new java.lang.Object();
    com.amap.api.location.AMapLocationClientOption.GeoLanguage r = com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s, reason: collision with root package name */
    boolean f414s = true;
    long v = 0;
    int w = 0;
    android.location.LocationListener x = null;

    public static class a implements android.location.LocationListener {
        private com.loc.k a;

        public a(com.loc.k kVar) {
            this.a = kVar;
        }

        public final void a() {
            this.a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(android.location.Location location) {
            try {
                new java.lang.StringBuilder("tid=").append(java.lang.Thread.currentThread().getId());
                com.loc.fx.a();
                com.loc.k kVar = this.a;
                if (kVar != null) {
                    kVar.a(location);
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(java.lang.String str) {
            try {
                com.loc.k kVar = this.a;
                if (kVar != null) {
                    kVar.a(str);
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
                com.loc.k kVar = this.a;
                if (kVar != null) {
                    kVar.a(i);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public k(android.content.Context context, android.os.Handler handler) {
        this.f = null;
        this.z = context;
        this.a = handler;
        try {
            this.b = (android.location.LocationManager) context.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "NetworkLocation", "<init>");
        }
        this.f = new com.loc.ex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            try {
                this.d = 0L;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void a(int i, int i2, java.lang.String str, long j2) {
        try {
            if (this.a == null || this.c.getLocationMode() != com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
                return;
            }
            android.os.Message obtain = android.os.Message.obtain();
            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation("");
            aMapLocation.setProvider("network");
            aMapLocation.setErrorCode(i2);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(12);
            obtain.obj = aMapLocation;
            obtain.what = i;
            this.a.sendMessageDelayed(obtain, j2);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.location.Location location) {
        android.os.Handler handler = this.a;
        if (handler != null) {
            handler.removeMessages(17);
        }
        if (location == null) {
            return;
        }
        try {
            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation(location);
            if (com.loc.gd.a(aMapLocation)) {
                aMapLocation.setProvider("network");
                aMapLocation.setLocationType(12);
                if (!this.e && com.loc.gd.a(aMapLocation)) {
                    com.loc.gb.a(this.z, com.loc.gd.b() - this.D, com.loc.fv.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.e = true;
                }
                e(aMapLocation);
                com.amap.api.location.AMapLocation f = f(aMapLocation);
                a(f);
                b(f);
                synchronized (this.o) {
                    a(f, y);
                }
                try {
                    if (com.loc.gd.a(f)) {
                        if (this.i != null) {
                            this.m = location.getTime() - this.i.getTime();
                            this.n = com.loc.gd.a(this.i, f);
                        }
                        synchronized (this.p) {
                            this.i = f.m13clone();
                        }
                        this.A = null;
                        this.C = false;
                        this.B = 0;
                    }
                } catch (java.lang.Throwable th) {
                    com.loc.fv.a(th, "NetworkLocation", "onLocationChangedLast");
                }
                c(f);
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "NetworkLocation", "onLocationChanged");
        }
    }

    private void a(com.amap.api.location.AMapLocation aMapLocation) {
        if (com.loc.gd.a(aMapLocation)) {
            this.d = com.loc.gd.b();
            synchronized (l) {
                k = com.loc.gd.b();
                j = aMapLocation.m13clone();
            }
            this.E++;
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
            if ("network".equalsIgnoreCase(str)) {
                this.d = 0L;
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
                u = allProviders.contains("network");
            }
            t = true;
            return u;
        } catch (java.lang.Throwable th) {
            new java.lang.StringBuilder("NetworkLocation | hasProvider error: ").append(th.getMessage());
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
                obtain.what = 14;
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
            java.util.ArrayList<java.lang.String> b2 = com.loc.gd.b(this.A);
            if (b.size() < 8 || b2.size() < 8) {
                return false;
            }
            return com.loc.gd.a(this.A, str);
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private void c(com.amap.api.location.AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving.equals(this.c.getLocationMode())) {
            if (this.c.getLocationMode().equals(com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving) && this.c.getDeviceModeDistanceFilter() > 0.0f) {
                d(aMapLocation);
            } else if (com.loc.gd.b() - this.v >= this.c.getInterval() - 200) {
                this.v = com.loc.gd.b();
                d(aMapLocation);
            }
        }
    }

    private void d() {
        android.location.LocationManager locationManager;
        java.lang.String str;
        long j2;
        float f;
        android.location.LocationListener locationListener;
        if (this.b == null) {
            return;
        }
        try {
            e();
            this.f414s = true;
            android.os.Looper myLooper = android.os.Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.z.getMainLooper();
            }
            android.os.Looper looper = myLooper;
            this.D = com.loc.gd.b();
            if (!a(this.b)) {
                com.loc.fx.a();
                a(17, 13, "no network provider#1402", 0L);
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
                this.x = new com.loc.k.a(this);
            }
            if (!this.c.getLocationMode().equals(com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving) || this.c.getDeviceModeDistanceFilter() <= 0.0f) {
                locationManager = this.b;
                str = "network";
                j2 = 900;
                f = 0.0f;
                locationListener = this.x;
            } else {
                locationManager = this.b;
                str = "network";
                j2 = this.c.getInterval();
                f = this.c.getDeviceModeDistanceFilter();
                locationListener = this.x;
            }
            locationManager.requestLocationUpdates(str, j2, f, locationListener, looper);
            a(17, 13, "no enough satellites#1401", this.c.getHttpTimeOut());
        } catch (java.lang.SecurityException e) {
            com.loc.fx.a();
            this.f414s = false;
            com.loc.gb.a((java.lang.String) null, 2121);
            a(15, 12, e.getMessage() + "#1201", 0L);
        } catch (java.lang.Throwable th2) {
            new java.lang.StringBuilder("NetworkLocation | requestLocationUpdates error: ").append(th2.getMessage());
            com.loc.fx.a();
            com.loc.fv.a(th2, "NetworkLocation", "requestLocationUpdates part2");
        }
    }

    private void d(com.amap.api.location.AMapLocation aMapLocation) {
        if (this.a != null) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 15;
            this.a.sendMessage(obtain);
        }
    }

    private void e() {
        if (com.loc.gd.b() - k > 5000 || !com.loc.gd.a(j)) {
            return;
        }
        if (this.c.isMockEnable() || !j.isMock()) {
            this.d = com.loc.gd.b();
            c(j);
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

    private com.amap.api.location.AMapLocation f(com.amap.api.location.AMapLocation aMapLocation) {
        if (!com.loc.gd.a(aMapLocation) || this.E < 3) {
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095  */
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
                int i = this.B + 1;
                this.B = i;
                if (this.A == null && i >= 2) {
                    this.C = true;
                }
                j2 = speed > 5.0f ? 10000L : 15000L;
            } else {
                if (!android.text.TextUtils.isEmpty(this.A)) {
                    this.C = false;
                    this.B = 0;
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
                if (this.A == null && this.B >= 2) {
                    this.A = str;
                }
                com.amap.api.location.AMapLocation m13clone = this.i.m13clone();
                m13clone.setTrustedLevel(2);
                return m13clone;
            }
            if (this.C && b(str)) {
                com.amap.api.location.AMapLocation m13clone2 = this.i.m13clone();
                m13clone2.setTrustedLevel(3);
                return m13clone2;
            }
            this.A = null;
            this.B = 0;
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
                ((com.loc.k.a) this.x).a();
                this.x = null;
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.removeMessages(17);
            }
        } catch (java.lang.Throwable unused2) {
        }
        this.D = 0L;
        this.v = 0L;
        this.d = 0L;
        this.E = 0;
        this.w = 0;
        this.f.a();
        this.i = null;
        this.m = 0L;
        this.n = 0.0f;
        this.A = null;
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
                com.loc.fv.a(th, "NetworkLocation", "setLastGeoLocation");
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
        d();
    }

    public final boolean b() {
        com.amap.api.location.AMapLocationClientOption aMapLocationClientOption = this.c;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || com.loc.gd.b() - this.d <= 300000) ? false : true;
    }

    public final boolean c() {
        return com.loc.gd.b() - this.d <= 2800;
    }
}
