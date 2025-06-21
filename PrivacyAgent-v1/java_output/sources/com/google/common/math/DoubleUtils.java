package com.google.common.math;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class DoubleUtils {
    public static double a(java.math.BigInteger bigInteger) {
        java.math.BigInteger abs = bigInteger.abs();
        boolean z = true;
        int bitLength = abs.bitLength() - 1;
        if (bitLength < 63) {
            return bigInteger.longValue();
        }
        if (bitLength > 1023) {
            return bigInteger.signum() * Double.POSITIVE_INFINITY;
        }
        int i = (bitLength - 52) - 1;
        long longValue = abs.shiftRight(i).longValue();
        long j = (longValue >> 1) & 4503599627370495L;
        if ((longValue & 1) == 0 || ((j & 1) == 0 && abs.getLowestSetBit() >= i)) {
            z = false;
        }
        if (z) {
            j++;
        }
        return java.lang.Double.longBitsToDouble((((bitLength + 1023) << 52) + j) | (bigInteger.signum() & Long.MIN_VALUE));
    }

    public static double b(double d) {
        com.google.common.base.Preconditions.checkArgument(!java.lang.Double.isNaN(d));
        if (d > 0.0d) {
            return d;
        }
        return 0.0d;
    }

    public static long c(double d) {
        com.google.common.base.Preconditions.checkArgument(d(d), "not a normal value");
        int exponent = java.lang.Math.getExponent(d);
        long doubleToRawLongBits = java.lang.Double.doubleToRawLongBits(d) & 4503599627370495L;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    public static boolean d(double d) {
        return java.lang.Math.getExponent(d) <= 1023;
    }

    public static boolean e(double d) {
        return java.lang.Math.getExponent(d) >= -1022;
    }

    public static double f(double d) {
        return java.lang.Double.longBitsToDouble((java.lang.Double.doubleToRawLongBits(d) & 4503599627370495L) | 4607182418800017408L);
    }
}
