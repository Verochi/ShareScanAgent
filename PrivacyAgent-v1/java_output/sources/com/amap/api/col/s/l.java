package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class l extends com.amap.api.col.s.b<com.amap.api.services.route.RouteSearch.DrivePlanQuery, com.amap.api.services.route.DriveRoutePlanResult> {
    public l(android.content.Context context, com.amap.api.services.route.RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    public static com.amap.api.services.route.DriveRoutePlanResult G(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return com.amap.api.col.s.p.j(str);
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
        if (((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getFrom()));
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getTo()));
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getDestinationPoiID());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getOriginType());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getDestinationType());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getPlateProvince());
            }
            if (!com.amap.api.col.s.p.f(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFromAndTo().getPlateNumber());
            }
        }
        if (((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&cartype=");
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getCarType());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&firsttime=");
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getFirstTime());
        stringBuffer.append(sb3.toString());
        stringBuffer.append("&interval=");
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getInterval());
        stringBuffer.append(sb4.toString());
        stringBuffer.append("&count=");
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(((com.amap.api.services.route.RouteSearch.DrivePlanQuery) this.b).getCount());
        stringBuffer.append(sb5.toString());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.b() + "/etd/driving?";
    }
}
