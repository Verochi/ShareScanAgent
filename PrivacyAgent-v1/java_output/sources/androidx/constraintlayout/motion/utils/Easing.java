package androidx.constraintlayout.motion.utils;

/* loaded from: classes.dex */
public class Easing {
    private static final java.lang.String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final java.lang.String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final java.lang.String LINEAR = "cubic(1, 1, 0, 0)";
    private static final java.lang.String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    java.lang.String str = "identity";
    static androidx.constraintlayout.motion.utils.Easing sDefault = new androidx.constraintlayout.motion.utils.Easing();
    private static final java.lang.String STANDARD_NAME = "standard";
    private static final java.lang.String ACCELERATE_NAME = "accelerate";
    private static final java.lang.String DECELERATE_NAME = "decelerate";
    private static final java.lang.String LINEAR_NAME = "linear";
    public static java.lang.String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static class CubicEasing extends androidx.constraintlayout.motion.utils.Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;
        double x1;
        double x2;
        double y1;
        double y2;

        public CubicEasing(double d, double d2, double d3, double d4) {
            setup(d, d2, d3, d4);
        }

        public CubicEasing(java.lang.String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.x1 = java.lang.Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.y1 = java.lang.Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.x2 = java.lang.Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.y2 = java.lang.Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        private double getDiffX(double d) {
            double d2 = 1.0d - d;
            double d3 = this.x1;
            double d4 = this.x2;
            return (d2 * 3.0d * d2 * d3) + (d2 * 6.0d * d * (d4 - d3)) + (3.0d * d * d * (1.0d - d4));
        }

        private double getDiffY(double d) {
            double d2 = 1.0d - d;
            double d3 = this.y1;
            double d4 = this.y2;
            return (d2 * 3.0d * d2 * d3) + (d2 * 6.0d * d * (d4 - d3)) + (3.0d * d * d * (1.0d - d4));
        }

        private double getX(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.x1 * d2 * d3 * d) + (this.x2 * d3 * d * d) + (d * d * d);
        }

        private double getY(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.y1 * d2 * d3 * d) + (this.y2 * d3 * d * d) + (d * d * d);
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > error) {
                d2 *= 0.5d;
                d3 = getX(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double x = getX(d4);
            double d5 = d3 + d2;
            double x2 = getX(d5);
            double y = getY(d4);
            return (((getY(d5) - y) * (d - x)) / (x2 - x)) + y;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > d_error) {
                d2 *= 0.5d;
                d3 = getX(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d3 + d2;
            return (getY(d5) - getY(d4)) / (getX(d5) - getX(d4));
        }

        public void setup(double d, double d2, double d3, double d4) {
            this.x1 = d;
            this.y1 = d2;
            this.x2 = d3;
            this.y2 = d4;
        }
    }

    public static androidx.constraintlayout.motion.utils.Easing getInterpolator(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new androidx.constraintlayout.motion.utils.Easing.CubicEasing(str);
        }
        switch (str) {
            case "accelerate":
                return new androidx.constraintlayout.motion.utils.Easing.CubicEasing(ACCELERATE);
            case "decelerate":
                return new androidx.constraintlayout.motion.utils.Easing.CubicEasing(DECELERATE);
            case "linear":
                return new androidx.constraintlayout.motion.utils.Easing.CubicEasing(LINEAR);
            case "standard":
                return new androidx.constraintlayout.motion.utils.Easing.CubicEasing(STANDARD);
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
                sb.append(java.util.Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public java.lang.String toString() {
        return this.str;
    }
}
