package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jb implements com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase {
    android.content.Context a;
    java.util.ArrayList<com.autonavi.amap.mapcore.Inner_3dMap_locationListener> b = new java.util.ArrayList<>();
    java.lang.Object c = new java.lang.Object();
    android.os.Handler d = null;
    com.amap.api.mapcore.util.jb.a e = null;
    android.os.Handler f = null;
    com.autonavi.amap.mapcore.Inner_3dMap_locationOption g = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption();
    com.amap.api.mapcore.util.jf h = null;
    com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode i = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    boolean j = false;

    public static class a extends android.os.HandlerThread {
        com.amap.api.mapcore.util.jb a;

        public a(java.lang.String str, com.amap.api.mapcore.util.jb jbVar) {
            super(str);
            this.a = jbVar;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                com.amap.api.mapcore.util.jb jbVar = this.a;
                com.amap.api.mapcore.util.jb jbVar2 = this.a;
                jbVar.h = new com.amap.api.mapcore.util.jf(jbVar2.a, jbVar2.d);
                super.onLooperPrepared();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public jb(android.content.Context context) {
        this.a = null;
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Context参数不能为null");
        }
        this.a = context.getApplicationContext();
        e();
    }

    private android.os.Handler a(android.os.Looper looper) {
        com.amap.api.mapcore.util.jc jcVar;
        synchronized (this.c) {
            jcVar = new com.amap.api.mapcore.util.jc(looper, this);
            this.f = jcVar;
        }
        return jcVar;
    }

    private void a(int i) {
        synchronized (this.c) {
            android.os.Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(i);
            }
        }
    }

    private void a(int i, java.lang.Object obj, long j) {
        synchronized (this.c) {
            if (this.f != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = i;
                obtain.obj = obj;
                this.f.sendMessageDelayed(obtain, j);
            }
        }
    }

    private void e() {
        try {
            this.d = android.os.Looper.myLooper() == null ? new com.amap.api.mapcore.util.jd(this.a.getMainLooper(), this) : new com.amap.api.mapcore.util.jd(this);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "initResultHandler");
        }
        try {
            com.amap.api.mapcore.util.jb.a aVar = new com.amap.api.mapcore.util.jb.a("locaitonClientActionThread", this);
            this.e = aVar;
            aVar.setPriority(5);
            this.e.start();
            this.f = a(this.e.getLooper());
        } catch (java.lang.Throwable th2) {
            com.amap.api.mapcore.util.it.a(th2, "MapLocationManager", "initActionThreadAndActionHandler");
        }
    }

    private void f() {
        synchronized (this.c) {
            android.os.Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f = null;
        }
    }

    public final void a() {
        try {
            if (this.j) {
                return;
            }
            this.j = true;
            a(1005, null, 0L);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "doStartLocation");
        }
    }

    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_location inner_3dMap_location) {
        if (inner_3dMap_location != null) {
            try {
                if (com.amap.api.mapcore.util.ji.a(inner_3dMap_location)) {
                    com.amap.api.mapcore.util.iz.a = inner_3dMap_location;
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "callBackLocation");
                return;
            }
        }
        if (this.j) {
            if (!com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(inner_3dMap_location.getProvider())) {
                inner_3dMap_location.setProvider("lbs");
            }
            inner_3dMap_location.setAltitude(com.amap.api.mapcore.util.ix.b(inner_3dMap_location.getAltitude()));
            inner_3dMap_location.setBearing(com.amap.api.mapcore.util.ix.a(inner_3dMap_location.getBearing()));
            inner_3dMap_location.setSpeed(com.amap.api.mapcore.util.ix.a(inner_3dMap_location.getSpeed()));
            java.util.Iterator<com.autonavi.amap.mapcore.Inner_3dMap_locationListener> it = this.b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onLocationChanged(inner_3dMap_location);
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        if (this.g.isOnceLocation()) {
            c();
        }
    }

    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            if (inner_3dMap_locationListener == null) {
                throw new java.lang.IllegalArgumentException("listener参数不能为null");
            }
            if (this.b == null) {
                this.b = new java.util.ArrayList<>();
            }
            if (this.b.contains(inner_3dMap_locationListener)) {
                return;
            }
            this.b.add(inner_3dMap_locationListener);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "doSetLocationListener");
        }
    }

    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.g = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.g = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption();
        }
        com.amap.api.mapcore.util.jf jfVar = this.h;
        if (jfVar != null) {
            jfVar.a(this.g);
        }
        if (this.j && !this.i.equals(inner_3dMap_locationOption.getLocationMode())) {
            c();
            a();
        }
        this.i = this.g.getLocationMode();
    }

    public final void b() {
        try {
            com.amap.api.mapcore.util.jf jfVar = this.h;
            if (jfVar != null) {
                jfVar.a();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "doGetLocation");
                if (this.g.isOnceLocation()) {
                    return;
                }
                a(1005, null, this.g.getInterval() >= 1000 ? this.g.getInterval() : 1000L);
            } finally {
                if (!this.g.isOnceLocation()) {
                    a(1005, null, this.g.getInterval() >= 1000 ? this.g.getInterval() : 1000L);
                }
            }
        }
    }

    public final void b(com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (!this.b.isEmpty() && this.b.contains(inner_3dMap_locationListener)) {
                    this.b.remove(inner_3dMap_locationListener);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "doUnregisterListener");
                return;
            }
        }
        if (this.b.isEmpty()) {
            c();
        }
    }

    public final void c() {
        try {
            this.j = false;
            a(1004);
            a(1005);
            com.amap.api.mapcore.util.jf jfVar = this.h;
            if (jfVar != null) {
                jfVar.c();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "doStopLocation");
        }
    }

    public final void d() {
        c();
        com.amap.api.mapcore.util.jf jfVar = this.h;
        if (jfVar != null) {
            jfVar.d();
        }
        java.util.ArrayList<com.autonavi.amap.mapcore.Inner_3dMap_locationListener> arrayList = this.b;
        if (arrayList != null) {
            arrayList.clear();
            this.b = null;
        }
        f();
        com.amap.api.mapcore.util.jb.a aVar = this.e;
        if (aVar != null) {
            try {
                com.amap.api.mapcore.util.iv.a(aVar, (java.lang.Class<?>) android.os.HandlerThread.class, "quitSafely", new java.lang.Object[0]);
            } catch (java.lang.Throwable unused) {
                this.e.quit();
            }
        }
        this.e = null;
        android.os.Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.d = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void destroy() {
        try {
            a(1007, null, 0L);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final com.autonavi.amap.mapcore.Inner_3dMap_location getLastKnownLocation() {
        return com.amap.api.mapcore.util.iz.a;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void setLocationListener(com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1002, inner_3dMap_locationListener, 0L);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "setLocationListener");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void setLocationOption(com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            a(1001, inner_3dMap_locationOption, 0L);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "LocationClientManager", "setLocationOption");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void startLocation() {
        try {
            a(1004, null, 0L);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "startLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void stopLocation() {
        try {
            a(1006, null, 0L);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationManagerBase
    public final void unRegisterLocationListener(com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1003, inner_3dMap_locationListener, 0L);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationManager", "stopLocation");
        }
    }
}
