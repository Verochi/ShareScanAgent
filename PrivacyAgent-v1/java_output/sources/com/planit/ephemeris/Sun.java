package com.planit.ephemeris;

/* loaded from: classes19.dex */
class Sun {

    public enum Params {
        SUN_PARAM_ZA,
        SUN_PARAM_ZA_INC,
        SUN_PARAM_ZA_RTS,
        SUN_PARAM_ALL,
        SUN_PARAM_ZA_NO_REFRACTION
    }

    public static class SunData {
        public double alpha;
        public double altitude;
        public double atmos_refract;
        public double azimuth;
        public double azimuth180;
        public double azm_rotation;
        public int day;
        public double delta;
        public double delta_t;
        public double delta_ut1;
        public double elevation;
        public com.planit.ephemeris.Sun.Params function;
        public int hour;
        public double incidence;
        public double latitude;
        public double longitude;
        public int minute;
        public int month;
        public double pressure;
        public double second;
        public double slope;
        public double sunrise;
        public double sunset;
        public double suntransit;
        public double temperature;
        public double timezone;
        public int year;
        public double zenith;

        public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
            return super.clone();
        }
    }
}
