package com.loc;

/* loaded from: classes23.dex */
public final class ey extends com.amap.api.location.AMapLocation {
    protected java.lang.String d;
    boolean e;
    java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private int i;
    private java.lang.String j;
    private int k;
    private java.lang.String l;
    private org.json.JSONObject m;
    private java.lang.String n;
    private java.lang.String o;
    private java.lang.String p;

    public ey(java.lang.String str) {
        super(str);
        this.d = "";
        this.g = null;
        this.h = "";
        this.j = "";
        this.k = 0;
        this.l = "new";
        this.m = null;
        this.n = "";
        this.e = true;
        this.f = java.lang.String.valueOf(com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.o = "";
        this.p = null;
    }

    private void i(java.lang.String str) {
        this.n = str;
    }

    private void j(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String[] split = str.split("\\*");
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            java.lang.String str2 = split[i];
            if (!android.text.TextUtils.isEmpty(str2)) {
                java.lang.String[] split2 = str2.split(",");
                setLongitude(com.loc.gd.c(split2[0]));
                setLatitude(com.loc.gd.c(split2[1]));
                setAccuracy(com.loc.gd.e(split2[2]));
                break;
            }
            i++;
        }
        this.o = str;
    }

    public final java.lang.String a() {
        return this.g;
    }

    public final void a(int i) {
        this.k = i;
    }

    public final void a(java.lang.String str) {
        this.g = str;
    }

    public final void a(org.json.JSONObject jSONObject) {
        this.m = jSONObject;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final java.lang.String b() {
        return this.h;
    }

    public final void b(java.lang.String str) {
        this.h = str;
    }

    public final void b(org.json.JSONObject jSONObject) {
        try {
            com.loc.fv.a(this, jSONObject);
            e(jSONObject.optString("type", this.l));
            d(jSONObject.optString("retype", this.j));
            j(jSONObject.optString("cens", this.o));
            g(jSONObject.optString("desc", this.d));
            c(jSONObject.optString("coord", java.lang.String.valueOf(this.i)));
            i(jSONObject.optString("mcell", this.n));
            a(jSONObject.optBoolean("isReversegeo", this.e));
            f(jSONObject.optString("geoLanguage", this.f));
            if (com.loc.gd.a(jSONObject, "poiid")) {
                setBuildingId(jSONObject.optString("poiid"));
            }
            if (com.loc.gd.a(jSONObject, "pid")) {
                setBuildingId(jSONObject.optString("pid"));
            }
            if (com.loc.gd.a(jSONObject, "floor")) {
                setFloor(jSONObject.optString("floor"));
            }
            if (com.loc.gd.a(jSONObject, "flr")) {
                setFloor(jSONObject.optString("flr"));
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AmapLoc", "AmapLoc");
        }
    }

    public final int c() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(java.lang.String str) {
        int i;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (str.equals("0")) {
                i = 0;
            } else if (str.equals("1")) {
                i = 1;
            }
            this.i = i;
            super.setCoordType(this.i != 0 ? "WGS84" : "GCJ02");
        }
        i = -1;
        this.i = i;
        super.setCoordType(this.i != 0 ? "WGS84" : "GCJ02");
    }

    public final java.lang.String d() {
        return this.j;
    }

    public final void d(java.lang.String str) {
        this.j = str;
    }

    public final java.lang.String e() {
        return this.l;
    }

    public final void e(java.lang.String str) {
        this.l = str;
    }

    public final org.json.JSONObject f() {
        return this.m;
    }

    public final void f(java.lang.String str) {
        this.f = str;
    }

    public final java.lang.String g() {
        return this.n;
    }

    public final void g(java.lang.String str) {
        this.d = str;
    }

    public final com.loc.ey h() {
        java.lang.String g = g();
        if (android.text.TextUtils.isEmpty(g)) {
            return null;
        }
        java.lang.String[] split = g.split(",");
        if (split.length != 3) {
            return null;
        }
        com.loc.ey eyVar = new com.loc.ey("");
        eyVar.setProvider(getProvider());
        eyVar.setLongitude(com.loc.gd.c(split[0]));
        eyVar.setLatitude(com.loc.gd.c(split[1]));
        eyVar.setAccuracy(com.loc.gd.d(split[2]));
        eyVar.setCityCode(getCityCode());
        eyVar.setAdCode(getAdCode());
        eyVar.setCountry(getCountry());
        eyVar.setProvince(getProvince());
        eyVar.setCity(getCity());
        eyVar.setTime(getTime());
        eyVar.e(e());
        eyVar.c(java.lang.String.valueOf(c()));
        if (com.loc.gd.a(eyVar)) {
            return eyVar;
        }
        return null;
    }

    public final void h(java.lang.String str) {
        this.p = str;
    }

    public final boolean i() {
        return this.e;
    }

    public final java.lang.String j() {
        return this.f;
    }

    public final java.lang.String k() {
        return this.p;
    }

    public final int l() {
        return this.k;
    }

    @Override // com.amap.api.location.AMapLocation
    public final org.json.JSONObject toJson(int i) {
        try {
            org.json.JSONObject json = super.toJson(i);
            if (i == 1) {
                json.put("retype", this.j);
                json.put("cens", this.o);
                json.put("coord", this.i);
                json.put("mcell", this.n);
                json.put("desc", this.d);
                json.put("address", getAddress());
                if (this.m != null && com.loc.gd.a(json, "offpct")) {
                    json.put("offpct", this.m.getString("offpct"));
                }
            } else if (i != 2 && i != 3) {
                return json;
            }
            json.put("type", this.l);
            json.put("isReversegeo", this.e);
            json.put("geoLanguage", this.f);
            return json;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    @Override // com.amap.api.location.AMapLocation
    public final java.lang.String toStr() {
        return toStr(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public final java.lang.String toStr(int i) {
        org.json.JSONObject jSONObject;
        try {
            jSONObject = toJson(i);
            jSONObject.put("nb", this.p);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
