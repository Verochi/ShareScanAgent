package com.jd.ad.sdk.dl.baseinfo;

/* loaded from: classes23.dex */
public class JADLocation {
    private double lat;
    private double lon;
    private double radius;

    public JADLocation() {
        this.lat = -1.0d;
        this.lon = -1.0d;
        this.radius = -1.0d;
    }

    public JADLocation(double d, double d2, double d3) {
        this.lat = d;
        this.lon = d2;
        this.radius = d3;
    }

    public static com.jd.ad.sdk.dl.baseinfo.JADLocation parseJSON(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return new com.jd.ad.sdk.dl.baseinfo.JADLocation();
        }
        com.jd.ad.sdk.dl.baseinfo.JADLocation jADLocation = new com.jd.ad.sdk.dl.baseinfo.JADLocation();
        jADLocation.setLatitude(jSONObject.optDouble("lat"));
        jADLocation.setLongitude(jSONObject.optDouble(com.anythink.core.common.h.c.C));
        jADLocation.setRadius(jSONObject.optDouble("radius"));
        return jADLocation;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public double getRadius() {
        return this.radius;
    }

    public boolean isValid() {
        return (java.lang.Double.compare(this.lat, -1.0d) == 0 && java.lang.Double.compare(this.lon, -1.0d) == 0 && java.lang.Double.compare(this.radius, -1.0d) == 0) ? false : true;
    }

    public void setLatitude(double d) {
        this.lat = d;
    }

    public void setLongitude(double d) {
        this.lon = d;
    }

    public void setRadius(double d) {
        this.radius = d;
    }

    @androidx.annotation.NonNull
    public double[] toDoubleArray() {
        return new double[]{this.lat, this.lon, this.radius};
    }

    public org.json.JSONObject toJSONObject() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("lat", java.lang.Double.valueOf(this.lat));
            jSONObject.putOpt(com.anythink.core.common.h.c.C, java.lang.Double.valueOf(this.lon));
            jSONObject.putOpt("radius", java.lang.Double.valueOf(this.radius));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("JADLocation{lat=");
        jad_an.append(this.lat);
        jad_an.append(", lon=");
        jad_an.append(this.lon);
        jad_an.append(", radius=");
        jad_an.append(this.radius);
        jad_an.append('}');
        return jad_an.toString();
    }
}
