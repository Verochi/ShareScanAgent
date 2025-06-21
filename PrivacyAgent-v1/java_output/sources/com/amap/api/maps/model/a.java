package com.amap.api.maps.model;

/* loaded from: classes12.dex */
final class a {
    private final com.amap.api.mapcore.util.cu a;
    private final int b;
    private java.util.List<com.amap.api.maps.model.WeightedLatLng> c;
    private java.util.List<com.amap.api.maps.model.a> d;

    private a(double d, double d2, double d3, double d4, int i) {
        this(new com.amap.api.mapcore.util.cu(d, d2, d3, d4), i);
    }

    public a(com.amap.api.mapcore.util.cu cuVar) {
        this(cuVar, 0);
    }

    private a(com.amap.api.mapcore.util.cu cuVar, int i) {
        this.d = null;
        this.a = cuVar;
        this.b = i;
    }

    private void a() {
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        this.d = arrayList;
        com.amap.api.mapcore.util.cu cuVar = this.a;
        arrayList.add(new com.amap.api.maps.model.a(cuVar.a, cuVar.e, cuVar.b, cuVar.f, this.b + 1));
        java.util.List<com.amap.api.maps.model.a> list = this.d;
        com.amap.api.mapcore.util.cu cuVar2 = this.a;
        list.add(new com.amap.api.maps.model.a(cuVar2.e, cuVar2.c, cuVar2.b, cuVar2.f, this.b + 1));
        java.util.List<com.amap.api.maps.model.a> list2 = this.d;
        com.amap.api.mapcore.util.cu cuVar3 = this.a;
        list2.add(new com.amap.api.maps.model.a(cuVar3.a, cuVar3.e, cuVar3.f, cuVar3.d, this.b + 1));
        java.util.List<com.amap.api.maps.model.a> list3 = this.d;
        com.amap.api.mapcore.util.cu cuVar4 = this.a;
        list3.add(new com.amap.api.maps.model.a(cuVar4.e, cuVar4.c, cuVar4.f, cuVar4.d, this.b + 1));
        java.util.List<com.amap.api.maps.model.WeightedLatLng> list4 = this.c;
        this.c = null;
        for (com.amap.api.maps.model.WeightedLatLng weightedLatLng : list4) {
            a(weightedLatLng.getPoint().x, weightedLatLng.getPoint().y, weightedLatLng);
        }
    }

    private void a(double d, double d2, com.amap.api.maps.model.WeightedLatLng weightedLatLng) {
        java.util.List<com.amap.api.maps.model.a> list = this.d;
        if (list == null) {
            if (this.c == null) {
                this.c = new java.util.ArrayList();
            }
            this.c.add(weightedLatLng);
            if (this.c.size() <= 50 || this.b >= 40) {
                return;
            }
            a();
            return;
        }
        com.amap.api.mapcore.util.cu cuVar = this.a;
        if (d2 < cuVar.f) {
            if (d < cuVar.e) {
                list.get(0).a(d, d2, weightedLatLng);
                return;
            } else {
                list.get(1).a(d, d2, weightedLatLng);
                return;
            }
        }
        if (d < cuVar.e) {
            list.get(2).a(d, d2, weightedLatLng);
        } else {
            list.get(3).a(d, d2, weightedLatLng);
        }
    }

    private void a(com.amap.api.mapcore.util.cu cuVar, java.util.Collection<com.amap.api.maps.model.WeightedLatLng> collection) {
        if (this.a.a(cuVar)) {
            java.util.List<com.amap.api.maps.model.a> list = this.d;
            if (list != null) {
                java.util.Iterator<com.amap.api.maps.model.a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(cuVar, collection);
                }
            } else if (this.c != null) {
                if (cuVar.b(this.a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (com.amap.api.maps.model.WeightedLatLng weightedLatLng : this.c) {
                    if (cuVar.a(weightedLatLng.getPoint())) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }

    public final java.util.Collection<com.amap.api.maps.model.WeightedLatLng> a(com.amap.api.mapcore.util.cu cuVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        a(cuVar, arrayList);
        return arrayList;
    }

    public final void a(com.amap.api.maps.model.WeightedLatLng weightedLatLng) {
        com.autonavi.amap.mapcore.DPoint point = weightedLatLng.getPoint();
        if (this.a.a(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }
}
