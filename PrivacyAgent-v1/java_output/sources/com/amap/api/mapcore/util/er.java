package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class er implements com.amap.api.maps.LocationSource.OnLocationChangedListener, com.amap.api.trace.LBSTraceBase {
    private android.content.Context b;
    private com.amap.api.maps.CoordinateConverter c;
    private com.amap.api.mapcore.util.ii d;
    private com.amap.api.mapcore.util.ii e;
    private com.amap.api.trace.TraceStatusListener h;
    private com.amap.api.mapcore.util.ak i;
    private com.amap.api.mapcore.util.er.c n;
    private long f = 2000;
    private int g = 5;
    private java.util.List<com.amap.api.trace.TraceLocation> j = new java.util.ArrayList();
    private int k = 0;
    private int l = 0;
    private long m = 0;
    private com.amap.api.trace.TraceLocation o = null;
    private java.util.List<com.amap.api.maps.model.LatLng> p = new java.util.ArrayList();
    private java.util.List<com.amap.api.maps.model.LatLng> q = new java.util.ArrayList();
    private java.util.List<com.amap.api.maps.model.LatLng> r = new java.util.ArrayList();
    int a = java.lang.Runtime.getRuntime().availableProcessors();

    /* renamed from: s, reason: collision with root package name */
    private java.util.concurrent.BlockingQueue<java.lang.Runnable> f127s = new java.util.concurrent.LinkedBlockingQueue();
    private java.util.concurrent.BlockingQueue<java.lang.Runnable> t = new java.util.concurrent.LinkedBlockingQueue();

    public class a extends com.amap.api.mapcore.util.ij {
        private int c;
        private int d;
        private java.util.List<com.amap.api.trace.TraceLocation> e;
        private com.amap.api.trace.TraceListener h;
        private java.util.List<com.amap.api.trace.TraceLocation> b = new java.util.ArrayList();
        private java.lang.String g = com.amap.api.mapcore.util.dd.a();

        /* renamed from: com.amap.api.mapcore.util.er$a$1, reason: invalid class name */
        public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
            final /* synthetic */ com.amap.api.mapcore.util.eq a;

            public AnonymousClass1(com.amap.api.mapcore.util.eq eqVar) {
                this.a = eqVar;
            }

            @Override // com.amap.api.mapcore.util.ij
            public final void runTask() {
                this.a.run();
            }
        }

        public a(int i, java.util.List<com.amap.api.trace.TraceLocation> list, int i2, com.amap.api.trace.TraceListener traceListener) {
            this.c = i2;
            this.d = i;
            this.e = list;
            this.h = traceListener;
        }

        private int a() {
            java.util.List<com.amap.api.trace.TraceLocation> list = this.e;
            int i = 0;
            if (list != null && list.size() != 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (com.amap.api.trace.TraceLocation traceLocation : this.e) {
                    if (traceLocation != null) {
                        if (traceLocation.getSpeed() < 0.01d) {
                            arrayList.add(traceLocation);
                        } else {
                            i += a(arrayList);
                            arrayList.clear();
                        }
                    }
                }
            }
            return i;
        }

        private static int a(java.util.List<com.amap.api.trace.TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            com.amap.api.trace.TraceLocation traceLocation = list.get(0);
            com.amap.api.trace.TraceLocation traceLocation2 = list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            return (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            try {
                com.amap.api.mapcore.util.er.this.n.a(this.h);
                int a = a();
                java.util.List<com.amap.api.trace.TraceLocation> list = this.e;
                if (list != null && list.size() >= 2) {
                    java.util.Iterator<com.amap.api.trace.TraceLocation> it = this.e.iterator();
                    while (it.hasNext()) {
                        com.amap.api.trace.TraceLocation copy = it.next().copy();
                        if (copy != null && copy.getLatitude() > 0.0d && copy.getLongitude() > 0.0d) {
                            this.b.add(copy);
                        }
                    }
                    int size = (this.b.size() - 2) / 500;
                    com.amap.api.mapcore.util.es.a().a(this.g, this.d, size, a);
                    int i = 500;
                    int i2 = 0;
                    while (i2 <= size) {
                        if (i2 == size) {
                            i = this.b.size();
                        }
                        int i3 = i;
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (int i4 = 0; i4 < i3; i4++) {
                            com.amap.api.trace.TraceLocation remove = this.b.remove(0);
                            if (remove != null) {
                                int i5 = this.c;
                                if (i5 != 1) {
                                    if (i5 == 3) {
                                        com.amap.api.mapcore.util.er.this.c.from(com.amap.api.maps.CoordinateConverter.CoordType.BAIDU);
                                    } else if (i5 == 2) {
                                        com.amap.api.mapcore.util.er.this.c.from(com.amap.api.maps.CoordinateConverter.CoordType.GPS);
                                    }
                                    com.amap.api.mapcore.util.er.this.c.coord(new com.amap.api.maps.model.LatLng(remove.getLatitude(), remove.getLongitude()));
                                    com.amap.api.maps.model.LatLng convert = com.amap.api.mapcore.util.er.this.c.convert();
                                    if (convert != null) {
                                        remove.setLatitude(convert.latitude);
                                        remove.setLongitude(convert.longitude);
                                    }
                                }
                                arrayList.add(remove);
                            }
                        }
                        if (arrayList.size() >= 2 && arrayList.size() <= 500) {
                            com.amap.api.mapcore.util.er.this.e.a(new com.amap.api.mapcore.util.er.a.AnonymousClass1(new com.amap.api.mapcore.util.eq(com.amap.api.mapcore.util.er.this.b, com.amap.api.mapcore.util.er.this.n, arrayList, this.g, this.d, i2)));
                            i2++;
                            try {
                                java.lang.Thread.sleep(50L);
                            } catch (java.lang.InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        i = i3;
                    }
                    return;
                }
                com.amap.api.mapcore.util.es.a();
                com.amap.api.mapcore.util.es.a(com.amap.api.mapcore.util.er.this.n, this.d, com.amap.api.trace.LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class b implements com.amap.api.trace.TraceListener {
        private final java.util.List<com.amap.api.trace.TraceLocation> b;

        public b(java.util.List<com.amap.api.trace.TraceLocation> list) {
            this.b = list;
        }

        private void a(int i, java.util.List<com.amap.api.maps.model.LatLng> list) {
            try {
                synchronized (com.amap.api.mapcore.util.er.this.r) {
                    com.amap.api.mapcore.util.er.this.r.clear();
                    com.amap.api.mapcore.util.er.this.r.addAll(list);
                }
                com.amap.api.mapcore.util.er.this.q.clear();
                if (i == 0) {
                    com.amap.api.mapcore.util.er.this.q.addAll(com.amap.api.mapcore.util.er.this.r);
                } else {
                    com.amap.api.mapcore.util.er.this.q.addAll(com.amap.api.mapcore.util.er.this.p);
                    com.amap.api.mapcore.util.er.this.q.addAll(com.amap.api.mapcore.util.er.this.r);
                }
                com.amap.api.mapcore.util.er.this.h.onTraceStatus(com.amap.api.mapcore.util.er.this.j, com.amap.api.mapcore.util.er.this.q, com.amap.api.trace.LBSTraceClient.TRACE_SUCCESS);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onFinished(int i, java.util.List<com.amap.api.maps.model.LatLng> list, int i2, int i3) {
            a(i, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onRequestFailed(int i, java.lang.String str) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (com.amap.api.mapcore.util.er.this.r != null) {
                arrayList.addAll(com.amap.api.mapcore.util.er.this.r);
            }
            java.util.List<com.amap.api.trace.TraceLocation> list = this.b;
            if (list != null) {
                int size = list.size();
                if (this.b.size() > com.amap.api.mapcore.util.er.this.g) {
                    for (int i2 = size - com.amap.api.mapcore.util.er.this.g; i2 < size; i2++) {
                        com.amap.api.trace.TraceLocation traceLocation = this.b.get(i2);
                        if (traceLocation != null) {
                            arrayList.add(new com.amap.api.maps.model.LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onTraceProcessing(int i, int i2, java.util.List<com.amap.api.maps.model.LatLng> list) {
        }
    }

    public static class c extends android.os.Handler {
        private com.amap.api.trace.TraceListener a;

        public c(android.os.Looper looper) {
            super(looper);
        }

        public final void a(com.amap.api.trace.TraceListener traceListener) {
            this.a = traceListener;
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            android.os.Bundle data;
            try {
                if (this.a == null || (data = message.getData()) == null) {
                    return;
                }
                int i = data.getInt("lineID");
                switch (message.what) {
                    case 100:
                        this.a.onTraceProcessing(i, message.arg1, (java.util.List) message.obj);
                        break;
                    case 101:
                        this.a.onFinished(i, (java.util.List) message.obj, message.arg1, message.arg2);
                        break;
                    case 102:
                        this.a.onRequestFailed(i, (java.lang.String) message.obj);
                        break;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public er(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = new com.amap.api.maps.CoordinateConverter(applicationContext);
        this.n = new com.amap.api.mapcore.util.er.c(android.os.Looper.getMainLooper());
        com.amap.api.mapcore.util.fb.a().a(this.b);
        this.d = com.amap.api.mapcore.util.dk.a(this.a * 2, this.f127s, "AMapTraceManagerProcess");
        this.e = com.amap.api.mapcore.util.dk.a(this.a * 2, this.t, "AMapTraceManagerRequest");
    }

    private static double a(double d, double d2, double d3, double d4) {
        double d5 = d > d3 ? d - d3 : d3 - d;
        double d6 = d2 > d4 ? d2 - d4 : d4 - d2;
        return java.lang.Math.sqrt((d5 * d5) + (d6 * d6));
    }

    private void a() {
        int size = this.j.size();
        if (size < this.g) {
            return;
        }
        if (size <= 50) {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.j);
            queryProcessedTrace(0, arrayList, 1, new com.amap.api.mapcore.util.er.b(arrayList));
            return;
        }
        int i = size - 50;
        if (i < 0) {
            return;
        }
        a(new java.util.ArrayList(this.j.subList(i - this.g, i)));
        java.util.ArrayList arrayList2 = new java.util.ArrayList(this.j.subList(i, size));
        queryProcessedTrace(i, arrayList2, 1, new com.amap.api.mapcore.util.er.b(arrayList2));
    }

    private void a(java.util.List<com.amap.api.trace.TraceLocation> list) {
        com.amap.api.mapcore.util.er erVar = this;
        synchronized (erVar.r) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                if (erVar.r.size() <= 0) {
                    return;
                }
                com.amap.api.maps.model.LatLng latLng = null;
                double d = 0.0d;
                com.amap.api.trace.TraceLocation traceLocation = null;
                double d2 = 0.0d;
                for (com.amap.api.trace.TraceLocation traceLocation2 : list) {
                    if (traceLocation2 != null) {
                        if (traceLocation != null) {
                            double a2 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                            if (a2 <= 100.0d) {
                                d2 += a2;
                            }
                        }
                        traceLocation = traceLocation2;
                    }
                }
                java.util.Iterator<com.amap.api.maps.model.LatLng> it = erVar.r.iterator();
                while (it.hasNext()) {
                    com.amap.api.maps.model.LatLng next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        if (latLng == null) {
                            erVar.p.add(next);
                            it.remove();
                        } else {
                            java.util.Iterator<com.amap.api.maps.model.LatLng> it2 = it;
                            try {
                                d += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                if (d >= d2) {
                                    break;
                                }
                                erVar = this;
                                erVar.p.add(next);
                                it2.remove();
                                it = it2;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        latLng = next;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    private static boolean a(com.amap.api.trace.TraceLocation traceLocation, com.amap.api.trace.TraceLocation traceLocation2) {
        return traceLocation != null && traceLocation.getLatitude() == traceLocation2.getLatitude() && traceLocation.getLongitude() == traceLocation2.getLongitude();
    }

    private void b() {
        com.amap.api.mapcore.util.ak akVar = this.i;
        if (akVar != null) {
            akVar.deactivate();
            this.i = null;
        }
    }

    private void c() {
        this.f127s.clear();
        this.t.clear();
        java.util.List<com.amap.api.trace.TraceLocation> list = this.j;
        if (list != null) {
            synchronized (list) {
                java.util.List<com.amap.api.trace.TraceLocation> list2 = this.j;
                if (list2 != null) {
                    list2.clear();
                }
                this.l = 0;
                this.k = 0;
                this.m = 0L;
                this.o = null;
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void destroy() {
        try {
            stopTrace();
            com.amap.api.mapcore.util.ii iiVar = this.d;
            if (iiVar != null) {
                iiVar.d();
                this.d = null;
            }
            com.amap.api.mapcore.util.ii iiVar2 = this.e;
            if (iiVar2 != null) {
                iiVar2.d();
                this.e = null;
            }
            this.j = null;
            this.h = null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        this.b = null;
        this.c = null;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(android.location.Location location) {
        com.amap.api.trace.TraceStatusListener traceStatusListener;
        if (this.h != null) {
            try {
                if (java.lang.System.currentTimeMillis() - this.m >= 30000 && (traceStatusListener = this.h) != null) {
                    traceStatusListener.onTraceStatus(null, null, com.amap.api.trace.LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.m = java.lang.System.currentTimeMillis();
                android.os.Bundle extras = location.getExtras();
                int i = extras.getInt("errorCode");
                if (i != 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("Locate failed [errorCode:\"");
                    sb.append(i);
                    sb.append("\"  errorInfo:");
                    sb.append(extras.getString(com.amap.api.maps.model.MyLocationStyle.ERROR_INFO));
                    sb.append("\"]");
                    return;
                }
                synchronized (this.j) {
                    com.amap.api.trace.TraceLocation traceLocation = new com.amap.api.trace.TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    if (a(this.o, traceLocation)) {
                        return;
                    }
                    this.j.add(traceLocation);
                    this.o = traceLocation;
                    int i2 = this.k + 1;
                    this.k = i2;
                    if (i2 == this.g) {
                        this.l += i2;
                        a();
                        this.k = 0;
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void queryProcessedTrace(int i, java.util.List<com.amap.api.trace.TraceLocation> list, int i2, com.amap.api.trace.TraceListener traceListener) {
        try {
            this.d.a(new com.amap.api.mapcore.util.er.a(i, list, i2, traceListener));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setLocationInterval(long j) {
        this.f = j;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setTraceStatusInterval(int i) {
        this.g = java.lang.Math.max(i, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void startTrace(com.amap.api.trace.TraceStatusListener traceStatusListener) {
        if (this.b == null) {
            return;
        }
        this.m = java.lang.System.currentTimeMillis();
        this.h = traceStatusListener;
        if (this.i == null) {
            com.amap.api.mapcore.util.ak akVar = new com.amap.api.mapcore.util.ak(this.b);
            this.i = akVar;
            akVar.a(this.f);
            this.i.activate(this);
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void stopTrace() {
        b();
        c();
    }
}
