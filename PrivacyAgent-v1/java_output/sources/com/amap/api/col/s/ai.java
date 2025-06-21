package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ai extends com.amap.api.col.s.b<com.amap.api.services.route.RouteSearch.RideRouteQuery, com.amap.api.services.route.RideRouteResult> {
    public ai(android.content.Context context, com.amap.api.services.route.RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    public static com.amap.api.services.route.RideRouteResult G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return com.amap.api.col.s.p.g(str);
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
        stringBuffer.append("&origin=");
        stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.RideRouteQuery) this.b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.RideRouteQuery) this.b).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (android.text.TextUtils.isEmpty(((com.amap.api.services.route.RouteSearch.RideRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.RideRouteQuery) this.b).getExtensions());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.b() + "/direction/bicycling?";
    }
}
