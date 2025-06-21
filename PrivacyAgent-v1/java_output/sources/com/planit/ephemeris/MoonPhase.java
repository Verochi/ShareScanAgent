package com.planit.ephemeris;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'WaxingCrescent' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes19.dex */
public final class MoonPhase {
    private static final /* synthetic */ com.planit.ephemeris.MoonPhase[] $VALUES;
    public static final com.planit.ephemeris.MoonPhase Crescent;
    public static final com.planit.ephemeris.MoonPhase FirstQuarter;
    public static final com.planit.ephemeris.MoonPhase Full;
    public static final com.planit.ephemeris.MoonPhase Gibbous;
    public static final com.planit.ephemeris.MoonPhase LastQuarter;
    public static final com.planit.ephemeris.MoonPhase New;
    public static final com.planit.ephemeris.MoonPhase Quarter;
    public static final com.planit.ephemeris.MoonPhase WaningCrescent;
    public static final com.planit.ephemeris.MoonPhase WaningGibbous;
    public static final com.planit.ephemeris.MoonPhase WaxingCrescent;
    public static final com.planit.ephemeris.MoonPhase WaxingGibbous;
    int mIncrease;
    double mMax;
    double mMin;

    static {
        com.planit.ephemeris.MoonPhase moonPhase = new com.planit.ephemeris.MoonPhase("New", 0, 0.0d);
        New = moonPhase;
        double d = com.planit.ephemeris.SolarUtils.TOLERANCE;
        com.planit.ephemeris.MoonPhase moonPhase2 = new com.planit.ephemeris.MoonPhase("WaxingCrescent", 1, d, 50.0d - d, true);
        WaxingCrescent = moonPhase2;
        com.planit.ephemeris.MoonPhase moonPhase3 = new com.planit.ephemeris.MoonPhase("FirstQuarter", 2, 50.0d, true);
        FirstQuarter = moonPhase3;
        double d2 = com.planit.ephemeris.SolarUtils.TOLERANCE;
        com.planit.ephemeris.MoonPhase moonPhase4 = new com.planit.ephemeris.MoonPhase("WaxingGibbous", 3, d2 + 50.0d, 100.0d - d2, true);
        WaxingGibbous = moonPhase4;
        com.planit.ephemeris.MoonPhase moonPhase5 = new com.planit.ephemeris.MoonPhase("Full", 4, 100.0d);
        Full = moonPhase5;
        double d3 = com.planit.ephemeris.SolarUtils.TOLERANCE;
        com.planit.ephemeris.MoonPhase moonPhase6 = new com.planit.ephemeris.MoonPhase("WaningGibbous", 5, d3 + 50.0d, 100.0d - d3, false);
        WaningGibbous = moonPhase6;
        com.planit.ephemeris.MoonPhase moonPhase7 = new com.planit.ephemeris.MoonPhase("LastQuarter", 6, 50.0d, false);
        LastQuarter = moonPhase7;
        double d4 = com.planit.ephemeris.SolarUtils.TOLERANCE;
        com.planit.ephemeris.MoonPhase moonPhase8 = new com.planit.ephemeris.MoonPhase("WaningCrescent", 7, d4, 50.0d - d4, false);
        WaningCrescent = moonPhase8;
        com.planit.ephemeris.MoonPhase moonPhase9 = new com.planit.ephemeris.MoonPhase("Quarter", 8, 50.0d);
        Quarter = moonPhase9;
        com.planit.ephemeris.MoonPhase moonPhase10 = new com.planit.ephemeris.MoonPhase("Gibbous", 9, 52.5d, 97.5d);
        Gibbous = moonPhase10;
        com.planit.ephemeris.MoonPhase moonPhase11 = new com.planit.ephemeris.MoonPhase("Crescent", 10, 2.5d, 47.5d);
        Crescent = moonPhase11;
        $VALUES = new com.planit.ephemeris.MoonPhase[]{moonPhase, moonPhase2, moonPhase3, moonPhase4, moonPhase5, moonPhase6, moonPhase7, moonPhase8, moonPhase9, moonPhase10, moonPhase11};
    }

    private MoonPhase(java.lang.String str, int i, double d) {
        this.mMax = -1.0d;
        this.mIncrease = -1;
        this.mMin = d;
    }

    private MoonPhase(java.lang.String str, int i, double d, double d2) {
        this.mIncrease = -1;
        this.mMin = d;
        this.mMax = d2;
    }

    private MoonPhase(java.lang.String str, int i, double d, double d2, boolean z) {
        this.mMin = d;
        this.mMax = d2;
        this.mIncrease = z ? 1 : 0;
    }

    private MoonPhase(java.lang.String str, int i, double d, boolean z) {
        this.mMax = -1.0d;
        this.mMin = d;
        this.mIncrease = z ? 1 : 0;
    }

    public static com.planit.ephemeris.MoonPhase getMoonPhase(double d, double d2) {
        if (d == -1.0d) {
            d = com.planit.ephemeris.SolarUtils.getMoonPercentage(d2);
        }
        for (com.planit.ephemeris.MoonPhase moonPhase : values()) {
            if (moonPhase.match(d, d2 < 180.0d)) {
                return moonPhase;
            }
        }
        return null;
    }

    public static com.planit.ephemeris.MoonPhase valueOf(java.lang.String str) {
        return (com.planit.ephemeris.MoonPhase) java.lang.Enum.valueOf(com.planit.ephemeris.MoonPhase.class, str);
    }

    public static com.planit.ephemeris.MoonPhase[] values() {
        return (com.planit.ephemeris.MoonPhase[]) $VALUES.clone();
    }

    public boolean isIncrease() {
        return this.mIncrease == 1;
    }

    public boolean match(double d) {
        double d2 = this.mMin;
        if (d2 != -1.0d) {
            double d3 = this.mMax;
            if (d3 != -1.0d) {
                return d >= d2 && d < d3;
            }
        }
        return d2 != -1.0d && java.lang.Math.abs(d - d2) <= com.planit.ephemeris.SolarUtils.TOLERANCE;
    }

    public boolean match(double d, boolean z) {
        if (this.mIncrease == -1 && this.mMax == -1.0d && java.lang.Math.abs(d - this.mMin) <= com.planit.ephemeris.SolarUtils.TOLERANCE) {
            return true;
        }
        if (this.mMax == -1.0d && java.lang.Math.abs(d - this.mMin) <= com.planit.ephemeris.SolarUtils.TOLERANCE) {
            if (z == (this.mIncrease == 1)) {
                return true;
            }
        }
        if (d >= this.mMin && d < this.mMax) {
            if (z == (this.mIncrease == 1)) {
                return true;
            }
        }
        return false;
    }
}
