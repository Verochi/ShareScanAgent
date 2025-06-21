package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class eq extends com.amap.api.mapcore.util.eo<java.util.List<com.amap.api.trace.TraceLocation>, java.util.List<com.amap.api.maps.model.LatLng>> implements java.lang.Runnable {
    private java.util.List<com.amap.api.trace.TraceLocation> j;
    private android.os.Handler k;
    private int l;
    private int m;
    private java.lang.String n;

    public eq(android.content.Context context, android.os.Handler handler, java.util.List<com.amap.api.trace.TraceLocation> list, java.lang.String str, int i, int i2) {
        super(context, list);
        this.j = list;
        this.k = handler;
        this.m = i;
        this.l = i2;
        this.n = str;
    }

    private static java.util.List<com.amap.api.maps.model.LatLng> b(java.lang.String str) throws com.amap.api.mapcore.util.em {
        org.json.JSONObject jSONObject;
        org.json.JSONArray optJSONArray;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null && optJSONArray.length() != 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                arrayList.add(new com.amap.api.maps.model.LatLng(java.lang.Double.parseDouble(optJSONObject.optString("y")), java.lang.Double.parseDouble(optJSONObject.optString("x"))));
            }
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.amap.api.mapcore.util.eo, com.amap.api.mapcore.util.en
    public final /* synthetic */ java.lang.Object a(java.lang.String str) throws com.amap.api.mapcore.util.em {
        return b(str);
    }

    @Override // com.amap.api.mapcore.util.eo, com.amap.api.mapcore.util.en
    public final java.lang.String c() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        long j = 0;
        for (int i = 0; i < this.j.size(); i++) {
            com.amap.api.trace.TraceLocation traceLocation = this.j.get(i);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i == 0) {
                    if (time == 0) {
                        time = (java.lang.System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (time != 0) {
                        long j2 = time - j;
                        if (j2 >= 1000) {
                            jSONObject.put("tm", j2 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        ((com.amap.api.mapcore.util.en) this).h = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getIPV6URL() {
        return com.amap.api.mapcore.util.dl.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        java.lang.String str = "key=" + com.amap.api.mapcore.util.ev.f(((com.amap.api.mapcore.util.en) this).g);
        java.lang.String a = com.amap.api.mapcore.util.ey.a();
        return "http://restsdk.amap.com/v4/grasproad/driving?" + str + "&ts=".concat(java.lang.String.valueOf(a)) + "&scode=".concat(java.lang.String.valueOf(com.amap.api.mapcore.util.ey.a(((com.amap.api.mapcore.util.en) this).g, a, str)));
    }

    @Override // com.amap.api.mapcore.util.hi
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new java.util.ArrayList();
        try {
            try {
                com.amap.api.mapcore.util.es.a().a(this.n, this.l, d());
                com.amap.api.mapcore.util.es.a().a(this.n).a(this.k);
            } catch (com.amap.api.mapcore.util.em e) {
                com.amap.api.mapcore.util.es.a();
                com.amap.api.mapcore.util.es.a(this.k, this.m, e.a());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
