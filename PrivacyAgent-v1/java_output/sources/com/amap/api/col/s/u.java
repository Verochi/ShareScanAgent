package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class u extends com.amap.api.col.s.b<com.amap.api.services.nearby.NearbySearch.NearbyQuery, com.amap.api.services.nearby.NearbySearchResult> {
    public android.content.Context t;
    public com.amap.api.services.nearby.NearbySearch.NearbyQuery u;

    public u(android.content.Context context, com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.t = context;
        this.u = nearbyQuery;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.services.nearby.NearbySearchResult a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            boolean z = true;
            if (this.u.getType() != 1) {
                z = false;
            }
            java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> a = com.amap.api.col.s.p.a(jSONObject, z);
            com.amap.api.services.nearby.NearbySearchResult nearbySearchResult = new com.amap.api.services.nearby.NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(a);
            return nearbySearchResult;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(com.amap.api.col.s.bi.f(this.t));
        com.amap.api.services.core.LatLonPoint centerPoint = this.u.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.u.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.u.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.u.getTimeRange());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.c() + "/nearby/around";
    }
}
