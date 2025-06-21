package com.getui.gtc.dim.bean;

/* loaded from: classes22.dex */
public class GtLocation implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.getui.gtc.dim.bean.GtLocation> CREATOR = new com.getui.gtc.dim.bean.GtLocation.AnonymousClass1();
    private float accuracy;
    private double altitude;
    private long elapsedRealtimeNanos;
    private boolean hasAccuracy;
    private double latitude;
    private double longitude;
    private java.lang.String provider;
    private long time;

    /* renamed from: com.getui.gtc.dim.bean.GtLocation$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.getui.gtc.dim.bean.GtLocation> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.getui.gtc.dim.bean.GtLocation createFromParcel(android.os.Parcel parcel) {
            return new com.getui.gtc.dim.bean.GtLocation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.getui.gtc.dim.bean.GtLocation[] newArray(int i) {
            return new com.getui.gtc.dim.bean.GtLocation[i];
        }
    }

    private GtLocation() {
    }

    public GtLocation(android.location.Location location) {
        this.hasAccuracy = location.hasAccuracy();
        this.accuracy = location.getAccuracy();
        this.time = location.getTime();
        this.provider = location.getProvider();
        this.longitude = location.getLongitude();
        this.latitude = location.getLatitude();
        this.elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
        this.altitude = location.getAltitude();
    }

    public GtLocation(android.os.Parcel parcel) {
        this.hasAccuracy = parcel.readByte() != 0;
        this.time = parcel.readLong();
        this.provider = parcel.readString();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.elapsedRealtimeNanos = parcel.readLong();
        this.altitude = parcel.readDouble();
        this.accuracy = parcel.readFloat();
    }

    public static com.getui.gtc.dim.bean.GtLocation parseJson(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.getui.gtc.dim.bean.GtLocation gtLocation = new com.getui.gtc.dim.bean.GtLocation();
            gtLocation.hasAccuracy = jSONObject.optBoolean("hasAccuracy", false);
            gtLocation.time = jSONObject.optLong("time", 0L);
            gtLocation.provider = jSONObject.optString(com.umeng.analytics.pro.f.M, "");
            gtLocation.longitude = jSONObject.optDouble("longitude", 0.0d);
            gtLocation.latitude = jSONObject.optDouble("latitude", 0.0d);
            gtLocation.elapsedRealtimeNanos = jSONObject.optLong("elapsedRealtimeNanos", 0L);
            gtLocation.altitude = jSONObject.optDouble("altitude", 0.0d);
            try {
                gtLocation.accuracy = java.lang.Float.parseFloat(jSONObject.optString("accuracy", "0"));
            } catch (java.lang.Throwable unused) {
            }
            return gtLocation;
        } catch (org.json.JSONException e) {
            com.getui.gtc.dim.e.b.b(e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float distanceTo(double d, double d2) {
        double d3 = this.latitude;
        double d4 = (0.017453292519943295d * d2) - (this.longitude * 0.017453292519943295d);
        double atan = java.lang.Math.atan(java.lang.Math.tan(d3 * 0.017453292519943295d) * 0.996647189328169d);
        double atan2 = java.lang.Math.atan(java.lang.Math.tan(d * 0.017453292519943295d) * 0.996647189328169d);
        double cos = java.lang.Math.cos(atan);
        double cos2 = java.lang.Math.cos(atan2);
        double sin = java.lang.Math.sin(atan);
        double sin2 = java.lang.Math.sin(atan2);
        double d5 = cos * cos2;
        double d6 = sin * sin2;
        double d7 = d4;
        int i = 0;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        while (true) {
            if (i >= 20) {
                break;
            }
            double cos3 = java.lang.Math.cos(d7);
            double sin3 = java.lang.Math.sin(d7);
            double d11 = cos2 * sin3;
            double d12 = (cos * sin2) - ((sin * cos2) * cos3);
            double d13 = sin;
            double sqrt = java.lang.Math.sqrt((d11 * d11) + (d12 * d12));
            double d14 = sin2;
            double d15 = d6 + (cos3 * d5);
            d10 = java.lang.Math.atan2(sqrt, d15);
            double d16 = sqrt == 0.0d ? 0.0d : (sin3 * d5) / sqrt;
            double d17 = 1.0d - (d16 * d16);
            double d18 = d17 == 0.0d ? 0.0d : d15 - ((d6 * 2.0d) / d17);
            double d19 = 0.006739496756586903d * d17;
            double d20 = ((d19 / 16384.0d) * (((((320.0d - (175.0d * d19)) * d19) - 768.0d) * d19) + 4096.0d)) + 1.0d;
            double d21 = (d19 / 1024.0d) * ((d19 * (((74.0d - (47.0d * d19)) * d19) - 128.0d)) + 256.0d);
            double d22 = 2.0955066698943685E-4d * d17 * (((4.0d - (d17 * 3.0d)) * 0.0033528106718309896d) + 4.0d);
            double d23 = d18 * d18;
            double d24 = d21 * sqrt * (d18 + ((d21 / 4.0d) * ((((d23 * 2.0d) - 1.0d) * d15) - ((((d21 / 6.0d) * d18) * (((sqrt * 4.0d) * sqrt) - 3.0d)) * ((d23 * 4.0d) - 3.0d)))));
            double d25 = d4 + ((1.0d - d22) * 0.0033528106718309896d * d16 * (d10 + (sqrt * d22 * (d18 + (d22 * d15 * (((2.0d * d18) * d18) - 1.0d))))));
            if (java.lang.Math.abs((d25 - d7) / d25) < 1.0E-12d) {
                d8 = d24;
                d9 = d20;
                break;
            }
            i++;
            sin = d13;
            sin2 = d14;
            d8 = d24;
            d7 = d25;
            d9 = d20;
        }
        return (float) (d9 * 6356752.3142d * (d10 - d8));
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public long getElapsedRealtimeNanos() {
        return this.elapsedRealtimeNanos;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public java.lang.String getProvider() {
        return this.provider;
    }

    public long getTime() {
        return this.time;
    }

    public boolean hasAccuracy() {
        return this.hasAccuracy;
    }

    public java.lang.String toJsonString() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("hasAccuracy", this.hasAccuracy);
            jSONObject.put("time", this.time);
            jSONObject.put(com.umeng.analytics.pro.f.M, this.provider);
            jSONObject.put("longitude", this.longitude);
            jSONObject.put("latitude", this.latitude);
            jSONObject.put("elapsedRealtimeNanos", this.elapsedRealtimeNanos);
            jSONObject.put("altitude", this.altitude);
            jSONObject.put("accuracy", java.lang.String.valueOf(this.accuracy));
            return jSONObject.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.hasAccuracy ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.time);
        parcel.writeString(this.provider);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeLong(this.elapsedRealtimeNanos);
        parcel.writeDouble(this.altitude);
        parcel.writeFloat(this.accuracy);
    }
}
