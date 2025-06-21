package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class eb {
    android.content.Context a;
    com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase b = null;
    java.lang.Object c = null;
    boolean d = false;
    com.amap.api.mapcore.util.iz e;
    com.amap.api.mapcore.util.fh f;

    public eb(android.content.Context context) {
        this.e = null;
        this.f = null;
        try {
            this.f = com.amap.api.mapcore.util.ji.a();
        } catch (java.lang.Throwable unused) {
        }
        this.e = new com.amap.api.mapcore.util.iz();
        a(context);
    }

    private void a(android.content.Context context) {
        android.content.pm.ServiceInfo serviceInfo;
        try {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("Context参数不能为null");
            }
            this.a = context.getApplicationContext();
            try {
                try {
                    serviceInfo = this.a.getPackageManager().getServiceInfo(new android.content.ComponentName(this.a, "com.amap.api.location.APSService"), 128);
                } catch (java.lang.Throwable unused) {
                    serviceInfo = null;
                }
                if (serviceInfo != null) {
                    this.d = true;
                }
            } catch (java.lang.Throwable unused2) {
                this.d = false;
            }
            if (this.d) {
                this.c = new com.amap.api.location.AMapLocationClient(this.a);
            } else {
                this.b = b(this.a);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "AMapLocationClient", "AMapLocationClient 1");
        }
    }

    private static com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase b(android.content.Context context) {
        return new com.amap.api.mapcore.util.jb(context);
    }

    public final void a() {
        try {
            if (this.d) {
                ((com.amap.api.location.AMapLocationClient) this.c).startLocation();
            } else {
                this.b.startLocation();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            if (this.d) {
                this.e.a(this.c, inner_3dMap_locationListener);
            } else {
                this.b.setLocationListener(inner_3dMap_locationListener);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "AMapLocationClient", "setLocationListener");
        }
    }

    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            if (inner_3dMap_locationOption == null) {
                throw new java.lang.IllegalArgumentException("LocationManagerOption参数不能为null");
            }
            if (this.d) {
                com.amap.api.mapcore.util.iz.a(this.c, inner_3dMap_locationOption);
            } else {
                this.b.setLocationOption(inner_3dMap_locationOption);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "AMapLocationClient", "setLocationOption");
        }
    }

    public final void b() {
        try {
            if (this.d) {
                ((com.amap.api.location.AMapLocationClient) this.c).stopLocation();
            } else {
                this.b.stopLocation();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public final void c() {
        try {
            if (this.d) {
                ((com.amap.api.location.AMapLocationClient) this.c).onDestroy();
            } else {
                this.b.destroy();
            }
            if (this.e != null) {
                this.e = null;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "AMapLocationClient", "onDestroy");
        }
    }
}
