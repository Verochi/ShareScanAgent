package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class j extends com.amap.api.col.s.b<com.amap.api.services.route.DistanceSearch.DistanceQuery, com.amap.api.services.route.DistanceResult> {
    public final java.lang.String t;
    public final java.lang.String u;
    public final java.lang.String v;

    public j(android.content.Context context, com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.t = "/distance?";
        this.u = "|";
        this.v = ",";
    }

    public static com.amap.api.services.route.DistanceResult G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return com.amap.api.col.s.p.h(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return G(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(com.amap.api.col.s.bi.f(this.e));
        java.util.List<com.amap.api.services.core.LatLonPoint> origins = ((com.amap.api.services.route.DistanceSearch.DistanceQuery) this.b).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i = 0; i < size; i++) {
                com.amap.api.services.core.LatLonPoint latLonPoint = origins.get(i);
                if (latLonPoint != null) {
                    double a = com.amap.api.col.s.i.a(latLonPoint.getLatitude());
                    stringBuffer.append(com.amap.api.col.s.i.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a);
                    if (i < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        com.amap.api.services.core.LatLonPoint destination = ((com.amap.api.services.route.DistanceSearch.DistanceQuery) this.b).getDestination();
        if (destination != null) {
            double a2 = com.amap.api.col.s.i.a(destination.getLatitude());
            double a3 = com.amap.api.col.s.i.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a3);
            stringBuffer.append(",");
            stringBuffer.append(a2);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((com.amap.api.services.route.DistanceSearch.DistanceQuery) this.b).getType());
        if (android.text.TextUtils.isEmpty(((com.amap.api.services.route.DistanceSearch.DistanceQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((com.amap.api.services.route.DistanceSearch.DistanceQuery) this.b).getExtensions());
        }
        stringBuffer.append("&output=json");
        if (((com.amap.api.services.route.DistanceSearch.DistanceQuery) this.b).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((com.amap.api.services.route.DistanceSearch.DistanceQuery) this.b).getMode());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/distance?";
    }
}
