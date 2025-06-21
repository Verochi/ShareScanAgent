package com.google.common.math;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class DoubleMath {
    public static final double a = java.lang.Math.log(2.0d);

    @com.google.common.annotations.VisibleForTesting
    public static final double[] b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* renamed from: com.google.common.math.DoubleMath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[java.math.RoundingMode.values().length];
            a = iArr;
            try {
                iArr[java.math.RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[java.math.RoundingMode.FLOOR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[java.math.RoundingMode.CEILING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[java.math.RoundingMode.DOWN.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[java.math.RoundingMode.UP.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[java.math.RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[java.math.RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[java.math.RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    public static double a(double d) {
        com.google.common.base.Preconditions.checkArgument(com.google.common.math.DoubleUtils.d(d));
        return d;
    }

    @com.google.common.annotations.GwtIncompatible
    public static double b(double d, java.math.RoundingMode roundingMode) {
        if (!com.google.common.math.DoubleUtils.d(d)) {
            throw new java.lang.ArithmeticException("input is infinite or NaN");
        }
        switch (com.google.common.math.DoubleMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(isMathematicalInteger(d));
                return d;
            case 2:
                return (d >= 0.0d || isMathematicalInteger(d)) ? d : ((long) d) - 1;
            case 3:
                return (d <= 0.0d || isMathematicalInteger(d)) ? d : ((long) d) + 1;
            case 4:
                return d;
            case 5:
                if (isMathematicalInteger(d)) {
                    return d;
                }
                return ((long) d) + (d > 0.0d ? 1 : -1);
            case 6:
                return java.lang.Math.rint(d);
            case 7:
                double rint = java.lang.Math.rint(d);
                return java.lang.Math.abs(d - rint) == 0.5d ? d + java.lang.Math.copySign(0.5d, d) : rint;
            case 8:
                double rint2 = java.lang.Math.rint(d);
                return java.lang.Math.abs(d - rint2) == 0.5d ? d : rint2;
            default:
                throw new java.lang.AssertionError();
        }
    }

    public static double factorial(int i) {
        com.google.common.math.MathPreconditions.e(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, i);
        if (i > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d = 1.0d;
        for (int i2 = (i & (-16)) + 1; i2 <= i; i2++) {
            d *= i2;
        }
        return d * b[i >> 4];
    }

    public static int fuzzyCompare(double d, double d2, double d3) {
        if (fuzzyEquals(d, d2, d3)) {
            return 0;
        }
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        return com.google.common.primitives.Booleans.compare(java.lang.Double.isNaN(d), java.lang.Double.isNaN(d2));
    }

    public static boolean fuzzyEquals(double d, double d2, double d3) {
        com.google.common.math.MathPreconditions.d("tolerance", d3);
        return java.lang.Math.copySign(d - d2, 1.0d) <= d3 || d == d2 || (java.lang.Double.isNaN(d) && java.lang.Double.isNaN(d2));
    }

    @com.google.common.annotations.GwtIncompatible
    public static boolean isMathematicalInteger(double d) {
        return com.google.common.math.DoubleUtils.d(d) && (d == 0.0d || 52 - java.lang.Long.numberOfTrailingZeros(com.google.common.math.DoubleUtils.c(d)) <= java.lang.Math.getExponent(d));
    }

    @com.google.common.annotations.GwtIncompatible
    public static boolean isPowerOfTwo(double d) {
        if (d <= 0.0d || !com.google.common.math.DoubleUtils.d(d)) {
            return false;
        }
        long c = com.google.common.math.DoubleUtils.c(d);
        return (c & (c - 1)) == 0;
    }

    public static double log2(double d) {
        return java.lang.Math.log(d) / a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int log2(double d, java.math.RoundingMode roundingMode) {
        boolean isPowerOfTwo;
        com.google.common.base.Preconditions.checkArgument(d > 0.0d && com.google.common.math.DoubleUtils.d(d), "x must be positive and finite");
        int exponent = java.lang.Math.getExponent(d);
        if (!com.google.common.math.DoubleUtils.e(d)) {
            return log2(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (com.google.common.math.DoubleMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(isPowerOfTwo(d));
                return !r2 ? exponent + 1 : exponent;
            case 2:
                if (!r2) {
                }
                break;
            case 3:
                r2 = !isPowerOfTwo(d);
                if (!r2) {
                }
                break;
            case 4:
                r2 = exponent < 0;
                isPowerOfTwo = isPowerOfTwo(d);
                r2 &= !isPowerOfTwo;
                if (!r2) {
                }
                break;
            case 5:
                r2 = exponent >= 0;
                isPowerOfTwo = isPowerOfTwo(d);
                r2 &= !isPowerOfTwo;
                if (!r2) {
                }
                break;
            case 6:
            case 7:
            case 8:
                double f = com.google.common.math.DoubleUtils.f(d);
                if (f * f > 2.0d) {
                    r2 = true;
                }
                if (!r2) {
                }
                break;
            default:
                throw new java.lang.AssertionError();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static double mean(java.lang.Iterable<? extends java.lang.Number> iterable) {
        return mean(iterable.iterator());
    }

    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static double mean(java.util.Iterator<? extends java.lang.Number> it) {
        com.google.common.base.Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double a2 = a(it.next().doubleValue());
        long j = 1;
        while (it.hasNext()) {
            j++;
            a2 += (a(it.next().doubleValue()) - a2) / j;
        }
        return a2;
    }

    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public static double mean(double... dArr) {
        com.google.common.base.Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double a2 = a(dArr[0]);
        long j = 1;
        for (int i = 1; i < dArr.length; i++) {
            a(dArr[i]);
            j++;
            a2 += (dArr[i] - a2) / j;
        }
        return a2;
    }

    @java.lang.Deprecated
    public static double mean(int... iArr) {
        com.google.common.base.Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j = 0;
        for (int i : iArr) {
            j += i;
        }
        return j / iArr.length;
    }

    @java.lang.Deprecated
    public static double mean(long... jArr) {
        com.google.common.base.Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d = jArr[0];
        long j = 1;
        for (int i = 1; i < jArr.length; i++) {
            j++;
            d += (jArr[i] - d) / j;
        }
        return d;
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.math.BigInteger roundToBigInteger(double d, java.math.RoundingMode roundingMode) {
        double b2 = b(d, roundingMode);
        if ((b2 < 9.223372036854776E18d) && ((-9.223372036854776E18d) - b2 < 1.0d)) {
            return java.math.BigInteger.valueOf((long) b2);
        }
        java.math.BigInteger shiftLeft = java.math.BigInteger.valueOf(com.google.common.math.DoubleUtils.c(b2)).shiftLeft(java.lang.Math.getExponent(b2) - 52);
        return b2 < 0.0d ? shiftLeft.negate() : shiftLeft;
    }

    @com.google.common.annotations.GwtIncompatible
    public static int roundToInt(double d, java.math.RoundingMode roundingMode) {
        double b2 = b(d, roundingMode);
        com.google.common.math.MathPreconditions.a((b2 > -2.147483649E9d) & (b2 < 2.147483648E9d), d, roundingMode);
        return (int) b2;
    }

    @com.google.common.annotations.GwtIncompatible
    public static long roundToLong(double d, java.math.RoundingMode roundingMode) {
        double b2 = b(d, roundingMode);
        com.google.common.math.MathPreconditions.a(((-9.223372036854776E18d) - b2 < 1.0d) & (b2 < 9.223372036854776E18d), d, roundingMode);
        return (long) b2;
    }
}
