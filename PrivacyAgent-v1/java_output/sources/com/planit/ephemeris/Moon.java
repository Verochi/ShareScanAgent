package com.planit.ephemeris;

/* loaded from: classes19.dex */
class Moon {

    public static class MoonData {
        public double alpha;
        public double alpha_prime;
        public double altitude;
        public double azimuth;
        public double azimuth180;
        public double cap_delta;
        public double del_alpha;
        public double delta;
        public double delta_prime;
        public double h;
        public double h_prime;
        public double pa;
        public double zenith;
    }

    public enum Params {
        MOON_PARAM_NO_IRR,
        MOON_PARAM_ALL
    }

    public static class SolarData {
        public com.planit.ephemeris.Moon.Params function;
        public com.planit.ephemeris.Moon.MoonData moonData;
        public com.planit.ephemeris.Sun.SunData sunData;
    }
}
