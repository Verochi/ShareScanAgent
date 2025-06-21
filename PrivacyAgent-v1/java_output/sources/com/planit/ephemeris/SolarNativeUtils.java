package com.planit.ephemeris;

/* loaded from: classes19.dex */
class SolarNativeUtils {
    static {
        java.lang.System.loadLibrary("moon");
    }

    public double[] a(com.planit.ephemeris.Moon.SolarData solarData) {
        com.planit.ephemeris.Sun.SunData sunData = solarData.sunData;
        return moon(sunData.latitude, sunData.longitude, sunData.year, sunData.month, sunData.day, sunData.hour, sunData.minute, sunData.second, sunData.timezone, sunData.function.ordinal());
    }

    public native double[] moon(double d, double d2, int i, int i2, int i3, int i4, int i5, double d3, double d4, int i6);
}
