package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class d<T> extends com.amap.api.col.s.b<T, java.lang.Object> {
    public int t;
    public java.util.List<java.lang.String> u;
    public java.util.List<com.amap.api.services.core.SuggestionCity> v;

    public d(android.content.Context context, T t) {
        super(context, t);
        this.t = 0;
        this.u = new java.util.ArrayList();
        this.v = new java.util.ArrayList();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.Object a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.v = com.amap.api.col.s.p.a(optJSONObject);
                this.u = com.amap.api.col.s.p.b(optJSONObject);
            }
            this.t = jSONObject.optInt(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
            if (this.b instanceof com.amap.api.services.busline.BusLineQuery) {
                return com.amap.api.services.busline.BusLineResult.createPagedResult((com.amap.api.services.busline.BusLineQuery) this.b, this.t, this.v, this.u, com.amap.api.col.s.p.f(jSONObject));
            }
            return com.amap.api.services.busline.BusStationResult.createPagedResult((com.amap.api.services.busline.BusStationQuery) this.b, this.t, this.v, this.u, com.amap.api.col.s.p.e(jSONObject));
        } catch (java.lang.Exception e) {
            com.amap.api.col.s.i.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("output=json");
        T t = this.b;
        if (t instanceof com.amap.api.services.busline.BusLineQuery) {
            com.amap.api.services.busline.BusLineQuery busLineQuery = (com.amap.api.services.busline.BusLineQuery) t;
            if (android.text.TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb.append("&extensions=base");
            } else {
                sb.append("&extensions=");
                sb.append(busLineQuery.getExtensions());
            }
            if (busLineQuery.getCategory() == com.amap.api.services.busline.BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(com.amap.api.col.s.b.b(((com.amap.api.services.busline.BusLineQuery) this.b).getQueryString()));
            } else {
                java.lang.String city = busLineQuery.getCity();
                if (!com.amap.api.col.s.p.f(city)) {
                    java.lang.String b = com.amap.api.col.s.b.b(city);
                    sb.append("&city=");
                    sb.append(b);
                }
                sb.append("&keywords=" + com.amap.api.col.s.b.b(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            com.amap.api.services.busline.BusStationQuery busStationQuery = (com.amap.api.services.busline.BusStationQuery) t;
            java.lang.String city2 = busStationQuery.getCity();
            if (!com.amap.api.col.s.p.f(city2)) {
                java.lang.String b2 = com.amap.api.col.s.b.b(city2);
                sb.append("&city=");
                sb.append(b2);
            }
            sb.append("&keywords=" + com.amap.api.col.s.b.b(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + com.amap.api.col.s.bi.f(this.e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        T t = this.b;
        return com.amap.api.col.s.h.a() + "/bus/" + (t instanceof com.amap.api.services.busline.BusLineQuery ? ((com.amap.api.services.busline.BusLineQuery) t).getCategory() == com.amap.api.services.busline.BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((com.amap.api.services.busline.BusLineQuery) this.b).getCategory() == com.amap.api.services.busline.BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "" : "stopname") + "?";
    }
}
