package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public class SensorsDataGPSLocation {
    private java.lang.String coordinate;
    private long latitude;
    private long longitude;

    public final class CoordinateType {
        public static final java.lang.String BD09 = "BD09";
        public static final java.lang.String GCJ02 = "GCJ02";
        public static final java.lang.String WGS84 = "WGS84";

        public CoordinateType() {
        }
    }

    public java.lang.String getCoordinate() {
        return this.coordinate;
    }

    public long getLatitude() {
        return this.latitude;
    }

    public long getLongitude() {
        return this.longitude;
    }

    public void setCoordinate(java.lang.String str) {
        this.coordinate = str;
    }

    public void setLatitude(long j) {
        this.latitude = j;
    }

    public void setLongitude(long j) {
        this.longitude = j;
    }

    public void toJSON(org.json.JSONObject jSONObject) {
        try {
            jSONObject.put("$latitude", this.latitude);
            jSONObject.put("$longitude", this.longitude);
            jSONObject.put("$geo_coordinate_system", this.coordinate);
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
