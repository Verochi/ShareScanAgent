package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class g extends com.amap.api.col.s.e<com.amap.api.services.cloud.CloudSearch.Query, com.amap.api.services.cloud.CloudResult> {
    public int t;

    public g(android.content.Context context, com.amap.api.services.cloud.CloudSearch.Query query) {
        super(context, query);
        this.t = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private java.lang.String D() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String filterString = ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getFilterString();
        java.lang.String filterNumString = ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getFilterNumString();
        stringBuffer.append(filterString);
        if (!com.amap.api.col.s.i.a(filterString) && !com.amap.api.col.s.i.a(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }

    public static java.lang.String F(java.lang.String str) {
        return str != null ? str.replace("&&", "%26%26") : str;
    }

    public static java.lang.String G(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static java.lang.String J(java.lang.String str) {
        return str != null ? str.replace("%26%26", "&&") : str;
    }

    public static java.lang.String K(java.lang.String str) {
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "ut", "sPa");
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        str = F(str);
        java.lang.String[] split = str.split("&");
        java.util.Arrays.sort(split);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.String str2 : split) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        java.lang.String J = J(stringBuffer.toString());
        if (J.length() > 1) {
            return (java.lang.String) J.subSequence(0, J.length() - 1);
        }
        return str;
    }

    public static java.lang.String f(java.util.Map<java.lang.String, java.lang.String> map) {
        return K(G(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private java.lang.String j() {
        return ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getSortingrules() != null ? ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getSortingrules().toString() : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.services.cloud.CloudResult a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        java.util.ArrayList<com.amap.api.services.cloud.CloudItem> arrayList = null;
        if (str == null || str.equals("")) {
            T t = this.b;
            return com.amap.api.services.cloud.CloudResult.createPagedResult((com.amap.api.services.cloud.CloudSearch.Query) t, this.t, ((com.amap.api.services.cloud.CloudSearch.Query) t).getBound(), ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getPageSize(), null);
        }
        try {
            arrayList = I(new org.json.JSONObject(str));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        T t2 = this.b;
        return com.amap.api.services.cloud.CloudResult.createPagedResult((com.amap.api.services.cloud.CloudSearch.Query) t2, this.t, ((com.amap.api.services.cloud.CloudSearch.Query) t2).getBound(), ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getPageSize(), arrayList);
    }

    public final java.util.ArrayList<com.amap.api.services.cloud.CloudItem> I(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.util.ArrayList<com.amap.api.services.cloud.CloudItem> arrayList = new java.util.ArrayList<>();
        org.json.JSONArray a = com.amap.api.col.s.e.a(jSONObject);
        if (a == null) {
            return arrayList;
        }
        this.t = com.amap.api.col.s.e.b(jSONObject);
        for (int i = 0; i < a.length(); i++) {
            org.json.JSONObject optJSONObject = a.optJSONObject(i);
            com.amap.api.services.cloud.CloudItemDetail c = com.amap.api.col.s.e.c(optJSONObject);
            com.amap.api.col.s.e.a(c, optJSONObject);
            arrayList.add(c);
        }
        return arrayList;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("key", com.amap.api.col.s.bi.f(this.e));
        hashtable.put("output", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
        if (((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound() != null) {
            if (((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getShape().equals("Bound")) {
                hashtable.put("center", com.amap.api.col.s.i.a(((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getCenter().getLongitude()) + "," + com.amap.api.col.s.i.a(((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getCenter().getLatitude()));
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getRange());
                hashtable.put("radius", sb.toString());
            } else if (((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getShape().equals("Rectangle")) {
                com.amap.api.services.core.LatLonPoint lowerLeft = ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getLowerLeft();
                com.amap.api.services.core.LatLonPoint upperRight = ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getUpperRight();
                double a = com.amap.api.col.s.i.a(lowerLeft.getLatitude());
                double a2 = com.amap.api.col.s.i.a(lowerLeft.getLongitude());
                double a3 = com.amap.api.col.s.i.a(upperRight.getLatitude());
                hashtable.put("polygon", a2 + "," + a + com.alipay.sdk.m.u.i.b + com.amap.api.col.s.i.a(upperRight.getLongitude()) + "," + a3);
            } else if (((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getShape().equals("Polygon")) {
                java.util.List<com.amap.api.services.core.LatLonPoint> polyGonList = ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", com.amap.api.col.s.i.a(polyGonList, com.alipay.sdk.m.u.i.b));
                }
            } else if (((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getShape().equals(com.amap.api.services.cloud.CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getTableID());
        if (!com.amap.api.col.s.i.a(j())) {
            hashtable.put("sortrule", j());
        }
        java.lang.String D = D();
        if (!com.amap.api.col.s.i.a(D)) {
            hashtable.put("filter", D);
        }
        java.lang.String queryString = ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getQueryString();
        if (queryString == null || "".equals(queryString)) {
            hashtable.put("keywords", "");
        } else {
            hashtable.put("keywords", queryString);
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(((com.amap.api.services.cloud.CloudSearch.Query) this.b).getPageSize());
        hashtable.put("pageSize", sb2.toString());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(((com.amap.api.services.cloud.CloudSearch.Query) this.b).getPageNum());
        hashtable.put("pageNum", sb3.toString());
        java.lang.String a4 = com.amap.api.col.s.bl.a();
        java.lang.String a5 = com.amap.api.col.s.bl.a(this.e, a4, f(hashtable));
        hashtable.put("ts", a4);
        hashtable.put("scode", a5);
        return hashtable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        java.lang.String str = com.amap.api.col.s.h.d() + "/datasearch";
        java.lang.String shape = ((com.amap.api.services.cloud.CloudSearch.Query) this.b).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        }
        if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon";
        }
        if (!shape.equals(com.amap.api.services.cloud.CloudSearch.SearchBound.LOCAL_SHAPE)) {
            return str;
        }
        return str + "/local";
    }
}
