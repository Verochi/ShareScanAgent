package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class es {
    private static volatile com.amap.api.mapcore.util.es b;
    private java.util.Map<java.lang.String, com.amap.api.mapcore.util.es.a> a;

    public class a {
        private int b;
        private int c;
        private int e;
        private java.util.HashMap<java.lang.Integer, java.util.List<com.amap.api.maps.model.LatLng>> g;
        private int d = 0;
        private int f = 0;
        private java.util.List<com.amap.api.maps.model.LatLng> h = new java.util.ArrayList();

        public a(int i, int i2, int i3, java.util.HashMap<java.lang.Integer, java.util.List<com.amap.api.maps.model.LatLng>> hashMap) {
            this.b = 0;
            this.c = 0;
            this.e = 0;
            this.b = i2;
            this.g = hashMap;
            this.c = i;
            this.e = i3;
        }

        private void a(android.os.Handler handler, java.util.List<com.amap.api.maps.model.LatLng> list) {
            android.os.Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.d;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("lineID", this.c);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.d++;
            this.f++;
        }

        private void b(android.os.Handler handler) {
            if (this.f <= 0) {
                com.amap.api.mapcore.util.es.a(handler, this.c, com.amap.api.trace.LBSTraceClient.MIN_GRASP_POINT_ERROR);
                return;
            }
            int a = com.amap.api.mapcore.util.ep.a(this.h);
            android.os.Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = this.h;
            obtainMessage.what = 101;
            obtainMessage.arg1 = a;
            obtainMessage.arg2 = this.e;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("lineID", this.c);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        }

        public final java.util.HashMap<java.lang.Integer, java.util.List<com.amap.api.maps.model.LatLng>> a() {
            return this.g;
        }

        public final void a(android.os.Handler handler) {
            java.util.List<com.amap.api.maps.model.LatLng> list;
            for (int i = this.d; i <= this.b && (list = this.g.get(java.lang.Integer.valueOf(i))) != null; i++) {
                this.h.addAll(list);
                a(handler, list);
            }
            if (this.d == this.b + 1) {
                b(handler);
            }
        }
    }

    public es() {
        this.a = null;
        this.a = java.util.Collections.synchronizedMap(new java.util.HashMap());
    }

    public static com.amap.api.mapcore.util.es a() {
        if (b == null) {
            synchronized (com.amap.api.mapcore.util.es.class) {
                if (b == null) {
                    b = new com.amap.api.mapcore.util.es();
                }
            }
        }
        return b;
    }

    public static void a(android.os.Handler handler, int i, java.lang.String str) {
        android.os.Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("lineID", i);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }

    public final synchronized com.amap.api.mapcore.util.es.a a(java.lang.String str) {
        java.util.Map<java.lang.String, com.amap.api.mapcore.util.es.a> map = this.a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final synchronized void a(java.lang.String str, int i, int i2, int i3) {
        java.util.Map<java.lang.String, com.amap.api.mapcore.util.es.a> map = this.a;
        if (map != null) {
            map.put(str, new com.amap.api.mapcore.util.es.a(i, i2, i3, new java.util.HashMap(16)));
        }
    }

    public final synchronized void a(java.lang.String str, int i, java.util.List<com.amap.api.maps.model.LatLng> list) {
        java.util.Map<java.lang.String, com.amap.api.mapcore.util.es.a> map = this.a;
        if (map != null) {
            map.get(str).a().put(java.lang.Integer.valueOf(i), list);
        }
    }
}
