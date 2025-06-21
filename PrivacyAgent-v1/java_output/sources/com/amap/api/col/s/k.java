package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class k extends com.amap.api.col.s.b<com.amap.api.services.district.DistrictSearchQuery, com.amap.api.services.district.DistrictResult> {
    public k(android.content.Context context, com.amap.api.services.district.DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.services.district.DistrictResult a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        org.json.JSONArray optJSONArray;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.amap.api.services.district.DistrictResult districtResult = new com.amap.api.services.district.DistrictResult((com.amap.api.services.district.DistrictSearchQuery) this.b, arrayList);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT));
            optJSONArray = jSONObject.optJSONArray("districts");
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (java.lang.Exception e2) {
            com.amap.api.col.s.i.a(e2, "DistrictServerHandler", "paseJSONException");
        }
        if (optJSONArray == null) {
            return districtResult;
        }
        com.amap.api.col.s.p.a(optJSONArray, arrayList, null);
        return districtResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((com.amap.api.services.district.DistrictSearchQuery) this.b).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((com.amap.api.services.district.DistrictSearchQuery) this.b).getPageSize());
        if (((com.amap.api.services.district.DistrictSearchQuery) this.b).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((com.amap.api.services.district.DistrictSearchQuery) this.b).checkKeyWords()) {
            java.lang.String b = com.amap.api.col.s.b.b(((com.amap.api.services.district.DistrictSearchQuery) this.b).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&key=" + com.amap.api.col.s.bi.f(this.e));
        stringBuffer.append("&subdistrict=" + java.lang.String.valueOf(((com.amap.api.services.district.DistrictSearchQuery) this.b).getSubDistrict()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/config/district?";
    }
}
