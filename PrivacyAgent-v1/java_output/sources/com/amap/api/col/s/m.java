package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class m extends com.amap.api.col.s.b<com.amap.api.services.route.RouteSearch.DriveRouteQuery, com.amap.api.services.route.DriveRouteResult> {
    public m(android.content.Context context, com.amap.api.services.route.RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    public static com.amap.api.services.route.DriveRouteResult G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return com.amap.api.col.s.p.b(str);
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
        if (((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getFrom()));
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getTo()));
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getDestinationPoiID());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getOriginType());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getDestinationType());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getPlateProvince());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getMode());
        stringBuffer.append(sb.toString());
        if (android.text.TextUtils.isEmpty(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getExtensions());
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getCarType());
        stringBuffer.append(sb2.toString());
        if (((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getPassedPointStr());
        }
        if (((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getAvoidpolygonsStr());
        }
        if (((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(com.amap.api.col.s.b.b(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.DriveRouteQuery) this.b).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/direction/driving?";
    }
}
