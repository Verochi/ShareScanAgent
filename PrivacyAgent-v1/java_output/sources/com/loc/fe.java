package com.loc;

/* loaded from: classes23.dex */
public final class fe {
    public int a = 0;
    public double b = 0.0d;
    public double c = 0.0d;
    public long d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 63;
    public int h = 0;

    public final java.lang.String a() {
        org.json.JSONObject jSONObject;
        try {
            jSONObject = new org.json.JSONObject();
            jSONObject.put("time", this.d);
            jSONObject.put(com.anythink.core.common.h.c.C, this.c);
            jSONObject.put("lat", this.b);
            jSONObject.put("radius", this.e);
            jSONObject.put(com.amap.api.maps.model.MyLocationStyle.LOCATION_TYPE, this.a);
            jSONObject.put("reType", this.g);
            jSONObject.put("reSubType", this.h);
        } catch (java.lang.Throwable unused) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final void a(org.json.JSONObject jSONObject) {
        try {
            this.b = jSONObject.optDouble("lat", this.b);
            this.c = jSONObject.optDouble(com.anythink.core.common.h.c.C, this.c);
            this.a = jSONObject.optInt(com.amap.api.maps.model.MyLocationStyle.LOCATION_TYPE, this.a);
            this.g = jSONObject.optInt("reType", this.g);
            this.h = jSONObject.optInt("reSubType", this.h);
            this.e = jSONObject.optInt("radius", this.e);
            this.d = jSONObject.optLong("time", this.d);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "CoreUtil", "transformLocation");
        }
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.loc.fe.class == obj.getClass()) {
            com.loc.fe feVar = (com.loc.fe) obj;
            if (this.a == feVar.a && java.lang.Double.compare(feVar.b, this.b) == 0 && java.lang.Double.compare(feVar.c, this.c) == 0 && this.d == feVar.d && this.e == feVar.e && this.f == feVar.f && this.g == feVar.g && this.h == feVar.h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return java.util.Objects.hash(java.lang.Integer.valueOf(this.a), java.lang.Double.valueOf(this.b), java.lang.Double.valueOf(this.c), java.lang.Long.valueOf(this.d), java.lang.Integer.valueOf(this.e), java.lang.Integer.valueOf(this.f), java.lang.Integer.valueOf(this.g), java.lang.Integer.valueOf(this.h));
    }
}
