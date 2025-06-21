package com.amap.api.trace;

/* loaded from: classes12.dex */
public class TraceOverlay {
    public static final int TRACE_STATUS_FAILURE = 3;
    public static final int TRACE_STATUS_FINISH = 2;
    public static final int TRACE_STATUS_PREPARE = 4;
    public static final int TRACE_STATUS_PROCESSING = 1;
    private com.amap.api.maps.model.Polyline a;
    private com.amap.api.maps.model.PolylineOptions b;
    private com.amap.api.maps.AMap c;
    private java.util.List<com.amap.api.maps.model.LatLng> d;
    private int e;
    private int f;
    private int g;

    public TraceOverlay(com.amap.api.maps.AMap aMap) {
        this.d = new java.util.ArrayList();
        this.e = 4;
        this.c = aMap;
        a();
    }

    public TraceOverlay(com.amap.api.maps.AMap aMap, java.util.List<com.amap.api.maps.model.LatLng> list) {
        this.d = new java.util.ArrayList();
        this.e = 4;
        this.c = aMap;
        a();
        this.d = list;
        this.b.addAll(list);
        this.a = aMap.addPolyline(this.b);
    }

    private com.amap.api.maps.model.PolylineOptions a() {
        if (this.b == null) {
            com.amap.api.maps.model.PolylineOptions polylineOptions = new com.amap.api.maps.model.PolylineOptions();
            this.b = polylineOptions;
            polylineOptions.setCustomTexture(com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
            this.b.width(40.0f);
        }
        return this.b;
    }

    public void add(java.util.List<com.amap.api.maps.model.LatLng> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.d.addAll(list);
        a();
        if (this.a == null) {
            this.a = this.c.addPolyline(this.b);
        }
        com.amap.api.maps.model.Polyline polyline = this.a;
        if (polyline != null) {
            polyline.setPoints(this.d);
        }
    }

    public int getDistance() {
        return this.f;
    }

    public int getTraceStatus() {
        return this.e;
    }

    public int getWaitTime() {
        return this.g;
    }

    public void remove() {
        com.amap.api.maps.model.Polyline polyline = this.a;
        if (polyline != null) {
            polyline.remove();
        }
    }

    public void setDistance(int i) {
        this.f = i;
    }

    public void setProperCamera(java.util.List<com.amap.api.maps.model.LatLng> list) {
        com.amap.api.maps.model.LatLngBounds.Builder builder = com.amap.api.maps.model.LatLngBounds.builder();
        if (list == null || list.size() == 0) {
            return;
        }
        java.util.Iterator<com.amap.api.maps.model.LatLng> it = list.iterator();
        while (it.hasNext()) {
            builder.include(it.next());
        }
        try {
            this.c.moveCamera(com.amap.api.maps.CameraUpdateFactory.newLatLngBounds(builder.build(), 20));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTraceStatus(int i) {
        this.e = i;
    }

    public void setWaitTime(int i) {
        this.g = i;
    }

    public void zoopToSpan() {
        setProperCamera(this.b.getPoints());
    }
}
