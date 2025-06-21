package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class y extends com.amap.api.col.s.w<com.amap.api.col.s.ab, com.amap.api.services.poisearch.PoiResult> {
    public int t;
    public boolean u;
    public java.util.List<java.lang.String> v;
    public java.util.List<com.amap.api.services.core.SuggestionCity> w;

    public y(android.content.Context context, com.amap.api.col.s.ab abVar) {
        super(context, abVar);
        this.t = 0;
        this.u = false;
        this.v = new java.util.ArrayList();
        this.w = new java.util.ArrayList();
    }

    public static java.lang.String H(boolean z) {
        return z ? "distance" : "weight";
    }

    public static com.amap.api.col.s.af J() {
        com.amap.api.col.s.ae a = com.amap.api.col.s.ad.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (com.amap.api.col.s.af) a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java.lang.String G(boolean z) {
        java.util.List<com.amap.api.services.core.LatLonPoint> polyGonList;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("output=json");
        T t = this.b;
        if (((com.amap.api.col.s.ab) t).b != null) {
            if (((com.amap.api.col.s.ab) t).b.getShape().equals("Bound")) {
                if (z) {
                    double a = com.amap.api.col.s.i.a(((com.amap.api.col.s.ab) this.b).b.getCenter().getLongitude());
                    double a2 = com.amap.api.col.s.i.a(((com.amap.api.col.s.ab) this.b).b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a + "," + a2);
                }
                sb.append("&radius=");
                sb.append(((com.amap.api.col.s.ab) this.b).b.getRange());
                sb.append("&sortrule=");
                sb.append(H(((com.amap.api.col.s.ab) this.b).b.isDistanceSort()));
            } else if (((com.amap.api.col.s.ab) this.b).b.getShape().equals("Rectangle")) {
                com.amap.api.services.core.LatLonPoint lowerLeft = ((com.amap.api.col.s.ab) this.b).b.getLowerLeft();
                com.amap.api.services.core.LatLonPoint upperRight = ((com.amap.api.col.s.ab) this.b).b.getUpperRight();
                double a3 = com.amap.api.col.s.i.a(lowerLeft.getLatitude());
                double a4 = com.amap.api.col.s.i.a(lowerLeft.getLongitude());
                double a5 = com.amap.api.col.s.i.a(upperRight.getLatitude());
                sb.append("&polygon=" + a4 + "," + a3 + com.alipay.sdk.m.u.i.b + com.amap.api.col.s.i.a(upperRight.getLongitude()) + "," + a5);
            } else if (((com.amap.api.col.s.ab) this.b).b.getShape().equals("Polygon") && (polyGonList = ((com.amap.api.col.s.ab) this.b).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + com.amap.api.col.s.i.a(polyGonList));
            }
        }
        java.lang.String city = ((com.amap.api.col.s.ab) this.b).a.getCity();
        if (!com.amap.api.col.s.w.c(city)) {
            java.lang.String b = com.amap.api.col.s.b.b(city);
            sb.append("&city=");
            sb.append(b);
        }
        java.lang.String b2 = com.amap.api.col.s.b.b(((com.amap.api.col.s.ab) this.b).a.getQueryString());
        if (!com.amap.api.col.s.w.c(b2)) {
            sb.append("&keywords=");
            sb.append(b2);
        }
        sb.append("&offset=");
        sb.append(((com.amap.api.col.s.ab) this.b).a.getPageSize());
        sb.append("&page=");
        sb.append(((com.amap.api.col.s.ab) this.b).a.getPageNum());
        java.lang.String building = ((com.amap.api.col.s.ab) this.b).a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((com.amap.api.col.s.ab) this.b).a.getBuilding());
        }
        java.lang.String b3 = com.amap.api.col.s.b.b(((com.amap.api.col.s.ab) this.b).a.getCategory());
        if (!com.amap.api.col.s.w.c(b3)) {
            sb.append("&types=");
            sb.append(b3);
        }
        if (com.amap.api.col.s.w.c(((com.amap.api.col.s.ab) this.b).a.getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(((com.amap.api.col.s.ab) this.b).a.getExtensions());
        }
        sb.append("&key=");
        sb.append(com.amap.api.col.s.bi.f(this.e));
        if (((com.amap.api.col.s.ab) this.b).a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((com.amap.api.col.s.ab) this.b).a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.u) {
            if (((com.amap.api.col.s.ab) this.b).a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        T t2 = this.b;
        if (((com.amap.api.col.s.ab) t2).b == null && ((com.amap.api.col.s.ab) t2).a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(H(((com.amap.api.col.s.ab) this.b).a.isDistanceSort()));
            double a6 = com.amap.api.col.s.i.a(((com.amap.api.col.s.ab) this.b).a.getLocation().getLongitude());
            double a7 = com.amap.api.col.s.i.a(((com.amap.api.col.s.ab) this.b).a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a6 + "," + a7);
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.services.poisearch.PoiResult a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        org.json.JSONObject jSONObject;
        java.util.ArrayList<com.amap.api.services.core.PoiItem> arrayList = new java.util.ArrayList<>();
        if (str == null) {
            T t = this.b;
            return com.amap.api.services.poisearch.PoiResult.createPagedResult(((com.amap.api.col.s.ab) t).a, ((com.amap.api.col.s.ab) t).b, this.v, this.w, ((com.amap.api.col.s.ab) t).a.getPageSize(), this.t, arrayList);
        }
        try {
            jSONObject = new org.json.JSONObject(str);
            this.t = jSONObject.optInt(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
            arrayList = com.amap.api.col.s.p.c(jSONObject);
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (java.lang.Exception e2) {
            com.amap.api.col.s.i.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
        if (!jSONObject.has("suggestion")) {
            T t2 = this.b;
            return com.amap.api.services.poisearch.PoiResult.createPagedResult(((com.amap.api.col.s.ab) t2).a, ((com.amap.api.col.s.ab) t2).b, this.v, this.w, ((com.amap.api.col.s.ab) t2).a.getPageSize(), this.t, arrayList);
        }
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
        if (optJSONObject == null) {
            T t3 = this.b;
            return com.amap.api.services.poisearch.PoiResult.createPagedResult(((com.amap.api.col.s.ab) t3).a, ((com.amap.api.col.s.ab) t3).b, this.v, this.w, ((com.amap.api.col.s.ab) t3).a.getPageSize(), this.t, arrayList);
        }
        this.w = com.amap.api.col.s.p.a(optJSONObject);
        this.v = com.amap.api.col.s.p.b(optJSONObject);
        T t4 = this.b;
        return com.amap.api.services.poisearch.PoiResult.createPagedResult(((com.amap.api.col.s.ab) t4).a, ((com.amap.api.col.s.ab) t4).b, this.v, this.w, ((com.amap.api.col.s.ab) t4).a.getPageSize(), this.t, arrayList);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        return G(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.a
    public final com.amap.api.col.s.ad.b d() {
        com.amap.api.col.s.ad.b bVar = new com.amap.api.col.s.ad.b();
        if (this.u) {
            com.amap.api.col.s.af J = J();
            double l = J != null ? J.l() : 0.0d;
            bVar.a = h() + G(false) + "language=" + com.amap.api.services.core.ServiceSettings.getInstance().getLanguage();
            if (((com.amap.api.col.s.ab) this.b).b.getShape().equals("Bound")) {
                bVar.b = new com.amap.api.col.s.af.a(com.amap.api.col.s.i.a(((com.amap.api.col.s.ab) this.b).b.getCenter().getLatitude()), com.amap.api.col.s.i.a(((com.amap.api.col.s.ab) this.b).b.getCenter().getLongitude()), l);
            }
        } else {
            bVar.a = h() + a_() + "language=" + com.amap.api.services.core.ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        java.lang.String str = com.amap.api.col.s.h.a() + "/place";
        T t = this.b;
        if (((com.amap.api.col.s.ab) t).b == null) {
            return str + "/text?";
        }
        if (((com.amap.api.col.s.ab) t).b.getShape().equals("Bound")) {
            java.lang.String str2 = str + "/around?";
            this.u = true;
            return str2;
        }
        if (!((com.amap.api.col.s.ab) this.b).b.getShape().equals("Rectangle") && !((com.amap.api.col.s.ab) this.b).b.getShape().equals("Polygon")) {
            return str;
        }
        return str + "/polygon?";
    }
}
