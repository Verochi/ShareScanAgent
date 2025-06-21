package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jf {
    private static int m = 200;
    private static boolean n = true;
    android.content.Context a;
    android.os.Handler f;
    com.autonavi.amap.mapcore.Inner_3dMap_locationOption i;
    com.amap.api.mapcore.util.iy b = null;
    com.amap.api.mapcore.util.jg c = null;
    com.amap.api.mapcore.util.jf.b d = null;
    android.os.Handler e = null;
    boolean g = false;
    boolean h = false;
    final int j = 500;
    final int k = 30;
    private org.json.JSONArray o = null;
    java.lang.Object l = new java.lang.Object();

    public class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            com.amap.api.mapcore.util.jf.this.b();
        }
    }

    public static class b extends android.os.HandlerThread {
        public b(java.lang.String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public jf(android.content.Context context, android.os.Handler handler) {
        this.a = null;
        this.f = null;
        this.i = null;
        try {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("Context参数不能为null");
            }
            this.a = context.getApplicationContext();
            this.f = handler;
            this.i = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption();
            f();
            e();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "<init>");
        }
    }

    private void a(com.autonavi.amap.mapcore.Inner_3dMap_location inner_3dMap_location) {
        try {
            if (n && inner_3dMap_location != null && inner_3dMap_location.getErrorCode() == 0 && inner_3dMap_location.getLocationType() == 1) {
                if (this.o == null) {
                    this.o = new org.json.JSONArray();
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.anythink.core.common.h.c.C, inner_3dMap_location.getLongitude());
                jSONObject.put("lat", inner_3dMap_location.getLatitude());
                jSONObject.put("type", 0);
                jSONObject.put("timestamp", com.amap.api.mapcore.util.ix.a());
                org.json.JSONArray put = this.o.put(jSONObject);
                this.o = put;
                if (put.length() >= m) {
                    h();
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "recordOfflineLocLog");
        }
    }

    private void e() {
        com.amap.api.mapcore.util.jf.b bVar = new com.amap.api.mapcore.util.jf.b("locServiceAction");
        this.d = bVar;
        bVar.setPriority(5);
        this.d.start();
        this.e = new com.amap.api.mapcore.util.jf.a(this.d.getLooper());
    }

    private void f() {
        try {
            if (this.i == null) {
                this.i = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption();
            }
            if (this.h) {
                return;
            }
            this.b = new com.amap.api.mapcore.util.iy(this.a);
            com.amap.api.mapcore.util.jg jgVar = new com.amap.api.mapcore.util.jg(this.a);
            this.c = jgVar;
            jgVar.a(this.i);
            g();
            this.h = true;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "init");
        }
    }

    private void g() {
        try {
            n = com.amap.api.mapcore.util.iw.b(this.a, "maploc", "ue");
            int a2 = com.amap.api.mapcore.util.iw.a(this.a, "maploc", "opn");
            m = a2;
            if (a2 > 500) {
                m = 500;
            }
            if (m < 30) {
                m = 30;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "getSPConfig");
        }
    }

    private synchronized void h() {
        try {
            org.json.JSONArray jSONArray = this.o;
            if (jSONArray != null && jSONArray.length() > 0) {
                com.amap.api.mapcore.util.hp.a(new com.amap.api.mapcore.util.ho(this.a, com.amap.api.mapcore.util.it.c(), this.o.toString()), this.a);
                this.o = null;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "writeOfflineLog");
        }
    }

    private void i() {
        synchronized (this.l) {
            android.os.Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.e = null;
        }
    }

    private void j() {
        synchronized (this.l) {
            android.os.Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
    }

    public final void a() {
        try {
            f();
            if (!this.i.getLocationMode().equals(com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && !this.g) {
                this.g = true;
                this.b.a();
            }
            android.os.Handler handler = this.e;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "getLocation");
        }
    }

    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.i = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.i = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption();
        }
        com.amap.api.mapcore.util.jg jgVar = this.c;
        if (jgVar != null) {
            jgVar.a(inner_3dMap_locationOption);
        }
    }

    public final void b() {
        try {
            if (this.i.getLocationMode().equals(com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && this.g) {
                this.b.b();
                this.g = false;
            }
            com.autonavi.amap.mapcore.Inner_3dMap_location d = this.b.c() ? this.b.d() : !this.i.getLocationMode().equals(com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors) ? this.c.a() : null;
            if (this.f != null && d != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.obj = d;
                obtain.what = 1;
                this.f.sendMessage(obtain);
            }
            a(d);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "doGetLocation");
        }
    }

    public final void c() {
        this.g = false;
        try {
            j();
            com.amap.api.mapcore.util.iy iyVar = this.b;
            if (iyVar != null) {
                iyVar.b();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "stopLocation");
        }
    }

    public final void d() {
        try {
            c();
            i();
            com.amap.api.mapcore.util.jf.b bVar = this.d;
            if (bVar != null) {
                try {
                    com.amap.api.mapcore.util.iv.a(bVar, (java.lang.Class<?>) android.os.HandlerThread.class, "quitSafely", new java.lang.Object[0]);
                } catch (java.lang.Throwable unused) {
                    this.d.quit();
                }
            }
            this.d = null;
            this.c.b();
            this.g = false;
            this.h = false;
            h();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationService", "destroy");
        }
    }
}
