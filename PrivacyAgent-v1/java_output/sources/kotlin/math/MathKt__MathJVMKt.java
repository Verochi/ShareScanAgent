package kotlin.math;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0000H\u0007\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0000H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\rH\u0007\u001a\u0010\u0010\u0007\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\rH\u0007\u001a\u0010\u0010\b\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\rH\u0007\u001a\f\u0010\n\u001a\u00020\t*\u00020\rH\u0007\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\rH\u0007\"\u001e\u0010\u0012\u001a\u00020\t*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0012\u001a\u00020\t*\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u000e\u0010\u0013¨\u0006\u0015"}, d2 = {"", "x", "asinh", "acosh", "atanh", "base", "log", "log2", "truncate", "", "roundToInt", "", "roundToLong", "", "getSign", "(I)I", "getSign$annotations", "(I)V", "sign", "(J)I", "(J)V", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/math/MathKt")
/* loaded from: classes14.dex */
public class MathKt__MathJVMKt extends kotlin.math.MathKt__MathHKt {
    @kotlin.SinceKotlin(version = "1.2")
    public static final double acosh(double d) {
        if (d < 1.0d) {
            return Double.NaN;
        }
        if (d > kotlin.math.Constants.upper_taylor_2_bound) {
            return java.lang.Math.log(d) + kotlin.math.Constants.LN2;
        }
        double d2 = 1;
        double d3 = d - d2;
        if (d3 >= kotlin.math.Constants.taylor_n_bound) {
            return java.lang.Math.log(d + java.lang.Math.sqrt((d * d) - d2));
        }
        double sqrt = java.lang.Math.sqrt(d3);
        if (sqrt >= kotlin.math.Constants.taylor_2_bound) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * java.lang.Math.sqrt(2.0d);
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final double asinh(double d) {
        double d2 = kotlin.math.Constants.taylor_n_bound;
        if (d < d2) {
            return d <= (-d2) ? -asinh(-d) : java.lang.Math.abs(d) >= kotlin.math.Constants.taylor_2_bound ? d - (((d * d) * d) / 6) : d;
        }
        if (d <= kotlin.math.Constants.upper_taylor_n_bound) {
            return java.lang.Math.log(d + java.lang.Math.sqrt((d * d) + 1));
        }
        if (d > kotlin.math.Constants.upper_taylor_2_bound) {
            return java.lang.Math.log(d) + kotlin.math.Constants.LN2;
        }
        double d3 = d * 2;
        return java.lang.Math.log(d3 + (1 / d3));
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final double atanh(double d) {
        if (java.lang.Math.abs(d) < kotlin.math.Constants.taylor_n_bound) {
            return java.lang.Math.abs(d) > kotlin.math.Constants.taylor_2_bound ? d + (((d * d) * d) / 3) : d;
        }
        double d2 = 1;
        return java.lang.Math.log((d2 + d) / (d2 - d)) / 2;
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float f) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    public static int getSign(int i) {
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static int getSign(long j) {
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getSign$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getSign$annotations(float f) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(long j) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getUlp$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    public static /* synthetic */ void getUlp$annotations(float f) {
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final double log(double d, double d2) {
        if (d2 <= 0.0d) {
            return Double.NaN;
        }
        if (d2 == 1.0d) {
            return Double.NaN;
        }
        return java.lang.Math.log(d) / java.lang.Math.log(d2);
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final float log(float f, float f2) {
        if (f2 <= 0.0f) {
            return Float.NaN;
        }
        if (f2 == 1.0f) {
            return Float.NaN;
        }
        return (float) (java.lang.Math.log(f) / java.lang.Math.log(f2));
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final double log2(double d) {
        return java.lang.Math.log(d) / kotlin.math.Constants.LN2;
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final float log2(float f) {
        return (float) (java.lang.Math.log(f) / kotlin.math.Constants.LN2);
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static int roundToInt(double d) {
        if (java.lang.Double.isNaN(d)) {
            throw new java.lang.IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) java.lang.Math.round(d);
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static int roundToInt(float f) {
        if (java.lang.Float.isNaN(f)) {
            throw new java.lang.IllegalArgumentException("Cannot round NaN value.");
        }
        return java.lang.Math.round(f);
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static long roundToLong(double d) {
        if (java.lang.Double.isNaN(d)) {
            throw new java.lang.IllegalArgumentException("Cannot round NaN value.");
        }
        return java.lang.Math.round(d);
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final long roundToLong(float f) {
        long roundToLong;
        roundToLong = roundToLong(f);
        return roundToLong;
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final double truncate(double d) {
        return (java.lang.Double.isNaN(d) || java.lang.Double.isInfinite(d)) ? d : d > 0.0d ? java.lang.Math.floor(d) : java.lang.Math.ceil(d);
    }

    @kotlin.SinceKotlin(version = "1.2")
    public static final float truncate(float f) {
        if (java.lang.Float.isNaN(f) || java.lang.Float.isInfinite(f)) {
            return f;
        }
        return (float) (f > 0.0f ? java.lang.Math.floor(f) : java.lang.Math.ceil(f));
    }
}
