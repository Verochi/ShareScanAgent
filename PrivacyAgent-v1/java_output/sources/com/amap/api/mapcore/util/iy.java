package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class iy {
    android.content.Context a;
    android.location.LocationManager b;
    java.lang.Object g;
    volatile long c = 0;
    volatile boolean d = false;
    boolean e = false;
    volatile com.autonavi.amap.mapcore.Inner_3dMap_location f = null;
    boolean h = false;
    boolean i = false;
    android.location.LocationListener j = new com.amap.api.mapcore.util.iy.AnonymousClass1();

    /* renamed from: com.amap.api.mapcore.util.iy$1, reason: invalid class name */
    public class AnonymousClass1 implements android.location.LocationListener {
        public AnonymousClass1() {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(android.location.Location location) {
            if (location == null) {
                return;
            }
            try {
                com.autonavi.amap.mapcore.Inner_3dMap_location inner_3dMap_location = new com.autonavi.amap.mapcore.Inner_3dMap_location(location);
                inner_3dMap_location.setProvider(com.amap.api.services.geocoder.GeocodeSearch.GPS);
                inner_3dMap_location.setLocationType(1);
                android.os.Bundle extras = location.getExtras();
                inner_3dMap_location.setSatellites(extras != null ? extras.getInt("satellites") : 0);
                inner_3dMap_location.setTime(com.amap.api.mapcore.util.iu.a(inner_3dMap_location.getTime(), java.lang.System.currentTimeMillis()));
                com.amap.api.mapcore.util.iy.this.f = inner_3dMap_location;
                com.amap.api.mapcore.util.iy.this.c = com.amap.api.mapcore.util.ix.b();
                com.amap.api.mapcore.util.iy.this.d = true;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "MAPGPSLocation", "onLocationChanged");
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(java.lang.String str) {
            try {
                if (com.amap.api.services.geocoder.GeocodeSearch.GPS.equals(str)) {
                    com.amap.api.mapcore.util.iy.this.d = false;
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(java.lang.String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(java.lang.String str, int i, android.os.Bundle bundle) {
        }
    }

    public iy(android.content.Context context) {
        this.g = null;
        if (context == null) {
            return;
        }
        this.a = context;
        e();
        try {
            if (this.g == null && !this.i) {
                this.g = this.h ? com.amap.api.maps.CoordinateConverter.class.getConstructor(android.content.Context.class).newInstance(context) : java.lang.Class.forName("com.amap.api.maps2d.CoordinateConverter").getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable unused) {
        }
        if (this.b == null) {
            this.b = (android.location.LocationManager) this.a.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
        }
    }

    private void e() {
        try {
            this.h = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    private void f() {
        try {
            android.os.Looper myLooper = android.os.Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.a.getMainLooper();
            }
            android.os.Looper looper = myLooper;
            try {
                this.b.sendExtraCommand(com.amap.api.services.geocoder.GeocodeSearch.GPS, "force_xtra_injection", new android.os.Bundle());
            } catch (java.lang.Throwable unused) {
            }
            this.b.requestLocationUpdates(com.amap.api.services.geocoder.GeocodeSearch.GPS, 800L, 0.0f, this.j, looper);
        } catch (java.lang.SecurityException unused2) {
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MAPGPSLocation", "requestLocationUpdates");
        }
    }

    private void g() {
        this.d = false;
        this.c = 0L;
        this.f = null;
    }

    public final void a() {
        if (this.e) {
            return;
        }
        f();
        this.e = true;
    }

    public final void b() {
        android.location.LocationListener locationListener;
        this.e = false;
        g();
        android.location.LocationManager locationManager = this.b;
        if (locationManager == null || (locationListener = this.j) == null) {
            return;
        }
        locationManager.removeUpdates(locationListener);
    }

    public final boolean c() {
        if (!this.d) {
            return false;
        }
        if (com.amap.api.mapcore.util.ix.b() - this.c <= 10000) {
            return true;
        }
        this.f = null;
        return false;
    }

    public final com.autonavi.amap.mapcore.Inner_3dMap_location d() {
        java.lang.Object a;
        java.lang.Object newInstance;
        if (this.f == null) {
            return null;
        }
        com.autonavi.amap.mapcore.Inner_3dMap_location m43clone = this.f.m43clone();
        if (m43clone != null && m43clone.getErrorCode() == 0) {
            try {
                if (this.g != null) {
                    if (com.amap.api.mapcore.util.it.a(m43clone.getLatitude(), m43clone.getLongitude())) {
                        java.lang.Object[] objArr = {"GPS"};
                        java.lang.Class[] clsArr = {java.lang.String.class};
                        if (this.h) {
                            a = com.amap.api.mapcore.util.iv.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr, (java.lang.Class<?>[]) clsArr);
                            com.amap.api.maps.model.LatLngCreator latLngCreator = com.amap.api.maps.model.LatLng.CREATOR;
                            java.lang.Class cls = java.lang.Double.TYPE;
                            newInstance = com.amap.api.maps.model.LatLng.class.getConstructor(cls, cls).newInstance(java.lang.Double.valueOf(m43clone.getLatitude()), java.lang.Double.valueOf(m43clone.getLongitude()));
                        } else {
                            a = com.amap.api.mapcore.util.iv.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr, (java.lang.Class<?>[]) clsArr);
                            java.lang.Class<?> cls2 = java.lang.Class.forName("com.amap.api.maps2d.model.LatLng");
                            java.lang.Class<?> cls3 = java.lang.Double.TYPE;
                            newInstance = cls2.getConstructor(cls3, cls3).newInstance(java.lang.Double.valueOf(m43clone.getLatitude()), java.lang.Double.valueOf(m43clone.getLongitude()));
                        }
                        com.amap.api.mapcore.util.iv.a(this.g, "coord", newInstance);
                        com.amap.api.mapcore.util.iv.a(this.g, "from", a);
                        java.lang.Object a2 = com.amap.api.mapcore.util.iv.a(this.g, "convert", new java.lang.Object[0]);
                        double doubleValue = ((java.lang.Double) a2.getClass().getDeclaredField("latitude").get(a2)).doubleValue();
                        double doubleValue2 = ((java.lang.Double) a2.getClass().getDeclaredField("longitude").get(a2)).doubleValue();
                        m43clone.setLatitude(doubleValue);
                        m43clone.setLongitude(doubleValue2);
                    }
                } else if (this.i && com.amap.api.mapcore.util.it.a(m43clone.getLatitude(), m43clone.getLongitude())) {
                    double[] a3 = com.autonavi.util.a.a(m43clone.getLongitude(), m43clone.getLatitude());
                    m43clone.setLatitude(a3[1]);
                    m43clone.setLongitude(a3[0]);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return m43clone;
    }
}
