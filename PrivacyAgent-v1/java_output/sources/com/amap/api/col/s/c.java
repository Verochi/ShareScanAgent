package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class c extends com.amap.api.col.s.b<com.amap.api.services.route.RouteSearch.BusRouteQuery, com.amap.api.services.route.BusRouteResult> {
    public c(android.content.Context context, com.amap.api.services.route.RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    public static com.amap.api.services.route.BusRouteResult G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return com.amap.api.col.s.p.a(str);
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
        stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.BusRouteQuery) this.b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.BusRouteQuery) this.b).getFromAndTo().getTo()));
        java.lang.String city = ((com.amap.api.services.route.RouteSearch.BusRouteQuery) this.b).getCity();
        if (!com.amap.api.col.s.p.f(city)) {
            city = com.amap.api.col.s.b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.BusRouteQuery) this.b).getCity())) {
            java.lang.String b = com.amap.api.col.s.b.b(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&strategy=");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(((com.amap.api.services.route.RouteSearch.BusRouteQuery) this.b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((com.amap.api.services.route.RouteSearch.BusRouteQuery) this.b).getNightFlag());
        if (android.text.TextUtils.isEmpty(((com.amap.api.services.route.RouteSearch.BusRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.BusRouteQuery) this.b).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/direction/transit/integrated?";
    }
}
