package com.google.common.math;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class MathPreconditions {
    public static void a(boolean z, double d, java.math.RoundingMode roundingMode) {
        if (z) {
            return;
        }
        throw new java.lang.ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
    }

    public static void b(boolean z, java.lang.String str, int i, int i2) {
        if (z) {
            return;
        }
        throw new java.lang.ArithmeticException("overflow: " + str + "(" + i + ", " + i2 + ")");
    }

    public static void c(boolean z, java.lang.String str, long j, long j2) {
        if (z) {
            return;
        }
        throw new java.lang.ArithmeticException("overflow: " + str + "(" + j + ", " + j2 + ")");
    }

    public static double d(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, double d) {
        if (d >= 0.0d) {
            return d;
        }
        throw new java.lang.IllegalArgumentException(str + " (" + d + ") must be >= 0");
    }

    public static int e(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i) {
        if (i >= 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(str + " (" + i + ") must be >= 0");
    }

    public static long f(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j) {
        if (j >= 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException(str + " (" + j + ") must be >= 0");
    }

    public static java.math.BigInteger g(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, java.math.BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new java.lang.IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    public static int h(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    public static long i(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, long j) {
        if (j > 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException(str + " (" + j + ") must be > 0");
    }

    public static java.math.BigInteger j(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, java.math.BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new java.lang.IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    public static void k(boolean z) {
        if (!z) {
            throw new java.lang.ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
