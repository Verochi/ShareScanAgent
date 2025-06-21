package com.amap.api.col.s;

/* loaded from: classes12.dex */
final class af extends com.amap.api.col.s.ae {
    public double j;

    public static class a {
        public com.amap.api.services.core.LatLonPoint a;
        public double b;

        public a(double d, double d2, double d3) {
            this.a = null;
            this.b = 0.0d;
            this.a = new com.amap.api.services.core.LatLonPoint(d, d2);
            this.b = d3;
        }

        public final boolean a(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.amap.api.col.s.af.a.class == obj.getClass()) {
                com.amap.api.services.core.LatLonPoint latLonPoint = this.a;
                com.amap.api.col.s.af.a aVar = (com.amap.api.col.s.af.a) obj;
                if (latLonPoint == aVar.a) {
                    return true;
                }
                if (latLonPoint != null && com.amap.api.col.s.i.a(latLonPoint, r3) <= aVar.b) {
                    return true;
                }
            }
            return false;
        }
    }

    public af(java.lang.String... strArr) {
        super(strArr);
        this.j = 0.0d;
    }

    @Override // com.amap.api.col.s.ae
    public final void c(com.amap.api.col.s.ad.a aVar) {
        super.c(aVar);
        if (aVar != null) {
            this.j = aVar.h();
        }
    }

    @Override // com.amap.api.col.s.ae
    public final boolean f(java.util.LinkedHashMap<com.amap.api.col.s.ad.b, java.lang.Object> linkedHashMap, com.amap.api.col.s.ad.b bVar) {
        java.lang.String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.f(linkedHashMap, bVar);
            }
            for (com.amap.api.col.s.ad.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.a) != null && str.equals(bVar.a)) {
                    java.lang.Object obj = bVar2.b;
                    if ((obj instanceof com.amap.api.col.s.af.a) && ((com.amap.api.col.s.af.a) obj).a(bVar.b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.amap.api.col.s.ae
    public final java.lang.Object g(java.util.LinkedHashMap<com.amap.api.col.s.ad.b, java.lang.Object> linkedHashMap, com.amap.api.col.s.ad.b bVar) {
        java.lang.String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.g(linkedHashMap, bVar);
            }
            for (com.amap.api.col.s.ad.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.a) != null && str.equals(bVar.a)) {
                    java.lang.Object obj = bVar2.b;
                    if ((obj instanceof com.amap.api.col.s.af.a) && ((com.amap.api.col.s.af.a) obj).a(bVar.b)) {
                        return linkedHashMap.get(bVar2);
                    }
                }
            }
        }
        return null;
    }

    @Override // com.amap.api.col.s.ae
    public final java.lang.Object k(java.util.LinkedHashMap<com.amap.api.col.s.ad.b, java.lang.Object> linkedHashMap, com.amap.api.col.s.ad.b bVar) {
        com.amap.api.col.s.ad.b bVar2;
        java.lang.String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.k(linkedHashMap, bVar);
            }
            java.util.Iterator<com.amap.api.col.s.ad.b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = it.next();
                if (bVar2 != null && (str = bVar2.a) != null && str.equals(bVar.a)) {
                    java.lang.Object obj = bVar2.b;
                    if ((obj instanceof com.amap.api.col.s.af.a) && ((com.amap.api.col.s.af.a) obj).a(bVar.b)) {
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                return linkedHashMap.remove(bVar2);
            }
        }
        return null;
    }

    public final double l() {
        return this.j;
    }
}
