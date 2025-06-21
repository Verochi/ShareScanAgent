package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class je extends com.autonavi.amap.mapcore.Inner_3dMap_location {
    boolean a;
    private java.lang.String b;
    private java.lang.String c;
    private int d;
    private java.lang.String e;
    private java.lang.String f;
    private org.json.JSONObject g;
    private java.lang.String h;
    private java.lang.String i;
    private long j;
    private java.lang.String k;

    public je(java.lang.String str) {
        super(str);
        this.b = null;
        this.c = "";
        this.e = "";
        this.f = "new";
        this.g = null;
        this.h = "";
        this.a = true;
        this.i = "";
        this.j = 0L;
        this.k = null;
    }

    public final java.lang.String a() {
        return this.b;
    }

    public final void a(java.lang.String str) {
        this.b = str;
    }

    public final java.lang.String b() {
        return this.c;
    }

    public final void b(java.lang.String str) {
        this.c = str;
    }

    public final int c() {
        return this.d;
    }

    public final void c(java.lang.String str) {
        int i;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (getProvider().equals(com.amap.api.services.geocoder.GeocodeSearch.GPS)) {
                this.d = 0;
                return;
            } else if (str.equals("0")) {
                this.d = 0;
                return;
            } else if (str.equals("1")) {
                i = 1;
                this.d = i;
            }
        }
        i = -1;
        this.d = i;
    }

    public final java.lang.String d() {
        return this.e;
    }

    public final void d(java.lang.String str) {
        this.e = str;
    }

    public final org.json.JSONObject e() {
        return this.g;
    }

    public final void e(java.lang.String str) {
        this.desc = str;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final void setFloor(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                java.lang.Integer.parseInt(str);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "MapLocationModel", "setFloor");
                str = null;
            }
        }
        this.floor = str;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final org.json.JSONObject toJson(int i) {
        try {
            org.json.JSONObject json = super.toJson(i);
            if (i == 1) {
                json.put("retype", this.e);
                json.put("cens", this.i);
                json.put("poiid", this.buildingId);
                json.put("floor", this.floor);
                json.put("coord", this.d);
                json.put("mcell", this.h);
                json.put("desc", this.desc);
                json.put("address", getAddress());
                if (this.g != null && com.amap.api.mapcore.util.ix.a(json, "offpct")) {
                    json.put("offpct", this.g.getString("offpct"));
                }
            } else if (i != 2 && i != 3) {
                return json;
            }
            json.put("type", this.f);
            json.put("isReversegeo", this.a);
            return json;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationModel", "toStr");
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_location
    public final java.lang.String toStr(int i) {
        org.json.JSONObject jSONObject;
        try {
            jSONObject = super.toJson(i);
            jSONObject.put("nb", this.k);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapLocationModel", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
