package androidx.appcompat.app;

/* loaded from: classes.dex */
class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static androidx.appcompat.app.TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    public static androidx.appcompat.app.TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new androidx.appcompat.app.TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j, double d, double d2) {
        double d3 = (0.01720197f * ((j - UTC_2000) / 8.64E7f)) + 6.24006f;
        double sin = (java.lang.Math.sin(d3) * 0.03341960161924362d) + d3 + (java.lang.Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (java.lang.Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = java.lang.Math.round((r3 - J0) - r7) + J0 + ((-d2) / 360.0d) + (java.lang.Math.sin(d3) * 0.0053d) + (java.lang.Math.sin(2.0d * sin) * (-0.0069d));
        double asin = java.lang.Math.asin(java.lang.Math.sin(sin) * java.lang.Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * d;
        double sin2 = (java.lang.Math.sin(-0.10471975803375244d) - (java.lang.Math.sin(d4) * java.lang.Math.sin(asin))) / (java.lang.Math.cos(d4) * java.lang.Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.state = 1;
            this.sunset = -1L;
            this.sunrise = -1L;
        } else {
            if (sin2 <= -1.0d) {
                this.state = 0;
                this.sunset = -1L;
                this.sunrise = -1L;
                return;
            }
            double acos = (float) (java.lang.Math.acos(sin2) / 6.283185307179586d);
            this.sunset = java.lang.Math.round((round + acos) * 8.64E7d) + UTC_2000;
            long round2 = java.lang.Math.round((round - acos) * 8.64E7d) + UTC_2000;
            this.sunrise = round2;
            if (round2 >= j || this.sunset <= j) {
                this.state = 1;
            } else {
                this.state = 0;
            }
        }
    }
}
