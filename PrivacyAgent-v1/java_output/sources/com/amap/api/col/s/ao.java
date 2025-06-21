package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ao extends com.amap.api.col.s.b<com.amap.api.services.route.RouteSearch.TruckRouteQuery, com.amap.api.services.route.TruckRouteRestult> {
    public final java.lang.String t;
    public final java.lang.String u;
    public final java.lang.String v;

    public ao(android.content.Context context, com.amap.api.services.route.RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
        this.t = "/direction/truck?";
        this.u = "|";
        this.v = ",";
    }

    public static com.amap.api.services.route.TruckRouteRestult G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return com.amap.api.col.s.p.i(str);
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
        if (((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getFrom()));
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getTo()));
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getDestinationPoiID());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getOriginType());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getDestinationType());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getPlateProvince());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getMode());
        if (((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getTruckAxis());
        if (android.text.TextUtils.isEmpty(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.TruckRouteQuery) this.b).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.b() + "/direction/truck?";
    }
}
