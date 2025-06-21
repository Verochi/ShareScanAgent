package com.google.common.math;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class IntMath {

    @com.google.common.annotations.VisibleForTesting
    public static final byte[] a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    @com.google.common.annotations.VisibleForTesting
    public static final int[] b = {1, 10, 100, 1000, 10000, 100000, 1000000, com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION, 100000000, com.airbnb.lottie.utils.Utils.SECOND_IN_NANOS};

    @com.google.common.annotations.VisibleForTesting
    public static final int[] c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    public static final int[] d = {1, 1, 2, 6, 24, 120, 720, com.qq.e.comm.constants.ErrorCode.VIDEO_DURATION_ERROR, 40320, 362880, 3628800, 39916800, 479001600};

    @com.google.common.annotations.VisibleForTesting
    public static int[] e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
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
                a[java.math.RoundingMode.DOWN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[java.math.RoundingMode.FLOOR.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[java.math.RoundingMode.UP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[java.math.RoundingMode.CEILING.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[java.math.RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[java.math.RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[java.math.RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static int a(int i, int i2) {
        return (~(~(i - i2))) >>> 31;
    }

    public static int b(int i) {
        byte b2 = a[java.lang.Integer.numberOfLeadingZeros(i)];
        return b2 - a(i, b[b2]);
    }

    public static int binomial(int i, int i2) {
        com.google.common.math.MathPreconditions.e(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, i);
        com.google.common.math.MathPreconditions.e("k", i2);
        int i3 = 0;
        com.google.common.base.Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = e;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Integer.MAX_VALUE;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return i;
        }
        long j = 1;
        while (i3 < i2) {
            long j2 = j * (i - i3);
            i3++;
            j = j2 / i3;
        }
        return (int) j;
    }

    public static int c(int i) {
        return (int) java.lang.Math.sqrt(i);
    }

    @com.google.common.annotations.Beta
    public static int ceilingPowerOfTwo(int i) {
        com.google.common.math.MathPreconditions.h("x", i);
        if (i <= 1073741824) {
            return 1 << (-java.lang.Integer.numberOfLeadingZeros(i - 1));
        }
        throw new java.lang.ArithmeticException("ceilingPowerOfTwo(" + i + ") not representable as an int");
    }

    public static int checkedAdd(int i, int i2) {
        long j = i + i2;
        int i3 = (int) j;
        com.google.common.math.MathPreconditions.b(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    public static int checkedMultiply(int i, int i2) {
        long j = i * i2;
        int i3 = (int) j;
        com.google.common.math.MathPreconditions.b(j == ((long) i3), "checkedMultiply", i, i2);
        return i3;
    }

    public static int checkedPow(int i, int i2) {
        com.google.common.math.MathPreconditions.e("exponent", i2);
        if (i == -2) {
            com.google.common.math.MathPreconditions.b(i2 < 32, "checkedPow", i, i2);
            return (i2 & 1) == 0 ? 1 << i2 : (-1) << i2;
        }
        if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        }
        if (i == 0) {
            return i2 == 0 ? 1 : 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            com.google.common.math.MathPreconditions.b(i2 < 31, "checkedPow", i, i2);
            return 1 << i2;
        }
        int i3 = 1;
        while (i2 != 0) {
            if (i2 == 1) {
                return checkedMultiply(i3, i);
            }
            if ((i2 & 1) != 0) {
                i3 = checkedMultiply(i3, i);
            }
            i2 >>= 1;
            if (i2 > 0) {
                com.google.common.math.MathPreconditions.b((-46340 <= i) & (i <= 46340), "checkedPow", i, i2);
                i *= i;
            }
        }
        return i3;
    }

    public static int checkedSubtract(int i, int i2) {
        long j = i - i2;
        int i3 = (int) j;
        com.google.common.math.MathPreconditions.b(j == ((long) i3), "checkedSubtract", i, i2);
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r1 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        if (r5 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        if (r5 < 0) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int divide(int i, int i2, java.math.RoundingMode roundingMode) {
        com.google.common.base.Preconditions.checkNotNull(roundingMode);
        if (i2 == 0) {
            throw new java.lang.ArithmeticException("/ by zero");
        }
        int i3 = i / i2;
        int i4 = i - (i2 * i3);
        if (i4 == 0) {
            return i3;
        }
        int i5 = ((i ^ i2) >> 31) | 1;
        switch (com.google.common.math.IntMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(i4 == 0);
                r2 = false;
                return !r2 ? i3 + i5 : i3;
            case 2:
                r2 = false;
                if (!r2) {
                }
                break;
            case 3:
                break;
            case 4:
                if (!r2) {
                }
                break;
            case 5:
                break;
            case 6:
            case 7:
            case 8:
                int abs = java.lang.Math.abs(i4);
                int abs2 = abs - (java.lang.Math.abs(i2) - abs);
                if (abs2 == 0) {
                    if (roundingMode != java.math.RoundingMode.HALF_UP) {
                        break;
                    }
                    if (!r2) {
                    }
                }
                break;
            default:
                throw new java.lang.AssertionError();
        }
    }

    public static int factorial(int i) {
        com.google.common.math.MathPreconditions.e(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, i);
        int[] iArr = d;
        if (i < iArr.length) {
            return iArr[i];
        }
        return Integer.MAX_VALUE;
    }

    @com.google.common.annotations.Beta
    public static int floorPowerOfTwo(int i) {
        com.google.common.math.MathPreconditions.h("x", i);
        return java.lang.Integer.highestOneBit(i);
    }

    public static int gcd(int i, int i2) {
        com.google.common.math.MathPreconditions.e("a", i);
        com.google.common.math.MathPreconditions.e("b", i2);
        if (i == 0) {
            return i2;
        }
        if (i2 == 0) {
            return i;
        }
        int numberOfTrailingZeros = java.lang.Integer.numberOfTrailingZeros(i);
        int i3 = i >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = java.lang.Integer.numberOfTrailingZeros(i2);
        int i4 = i2 >> numberOfTrailingZeros2;
        while (i3 != i4) {
            int i5 = i3 - i4;
            int i6 = (i5 >> 31) & i5;
            int i7 = (i5 - i6) - i6;
            i4 += i6;
            i3 = i7 >> java.lang.Integer.numberOfTrailingZeros(i7);
        }
        return i3 << java.lang.Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(int i) {
        return (i > 0) & ((i & (i + (-1))) == 0);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static boolean isPrime(int i) {
        return com.google.common.math.LongMath.isPrime(i);
    }

    @com.google.common.annotations.GwtIncompatible
    public static int log10(int i, java.math.RoundingMode roundingMode) {
        int a2;
        com.google.common.math.MathPreconditions.h("x", i);
        int b2 = b(i);
        int i2 = b[b2];
        switch (com.google.common.math.IntMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(i == i2);
            case 2:
            case 3:
                return b2;
            case 4:
            case 5:
                a2 = a(i2, i);
                return b2 + a2;
            case 6:
            case 7:
            case 8:
                a2 = a(c[b2], i);
                return b2 + a2;
            default:
                throw new java.lang.AssertionError();
        }
    }

    public static int log2(int i, java.math.RoundingMode roundingMode) {
        com.google.common.math.MathPreconditions.h("x", i);
        switch (com.google.common.math.IntMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(isPowerOfTwo(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - java.lang.Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = java.lang.Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + a((-1257966797) >>> numberOfLeadingZeros, i);
            default:
                throw new java.lang.AssertionError();
        }
        return 31 - java.lang.Integer.numberOfLeadingZeros(i);
    }

    public static int mean(int i, int i2) {
        return (i & i2) + ((i ^ i2) >> 1);
    }

    public static int mod(int i, int i2) {
        if (i2 > 0) {
            int i3 = i % i2;
            return i3 >= 0 ? i3 : i3 + i2;
        }
        throw new java.lang.ArithmeticException("Modulus " + i2 + " must be > 0");
    }

    @com.google.common.annotations.GwtIncompatible
    public static int pow(int i, int i2) {
        com.google.common.math.MathPreconditions.e("exponent", i2);
        if (i == -2) {
            if (i2 < 32) {
                return (i2 & 1) == 0 ? 1 << i2 : -(1 << i2);
            }
            return 0;
        }
        if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        }
        if (i == 0) {
            return i2 == 0 ? 1 : 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            if (i2 < 32) {
                return 1 << i2;
            }
            return 0;
        }
        int i3 = 1;
        while (i2 != 0) {
            if (i2 == 1) {
                return i * i3;
            }
            i3 *= (i2 & 1) == 0 ? 1 : i;
            i *= i;
            i2 >>= 1;
        }
        return i3;
    }

    @com.google.common.annotations.Beta
    public static int saturatedAdd(int i, int i2) {
        return com.google.common.primitives.Ints.saturatedCast(i + i2);
    }

    @com.google.common.annotations.Beta
    public static int saturatedMultiply(int i, int i2) {
        return com.google.common.primitives.Ints.saturatedCast(i * i2);
    }

    @com.google.common.annotations.Beta
    public static int saturatedPow(int i, int i2) {
        com.google.common.math.MathPreconditions.e("exponent", i2);
        if (i == -2) {
            return i2 >= 32 ? (i2 & 1) + Integer.MAX_VALUE : (i2 & 1) == 0 ? 1 << i2 : (-1) << i2;
        }
        if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        }
        if (i == 0) {
            return i2 == 0 ? 1 : 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            if (i2 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << i2;
        }
        int i3 = ((i >>> 31) & i2 & 1) + Integer.MAX_VALUE;
        int i4 = 1;
        while (i2 != 0) {
            if (i2 == 1) {
                return saturatedMultiply(i4, i);
            }
            if ((i2 & 1) != 0) {
                i4 = saturatedMultiply(i4, i);
            }
            i2 >>= 1;
            if (i2 > 0) {
                if ((-46340 > i) || (i > 46340)) {
                    return i3;
                }
                i *= i;
            }
        }
        return i4;
    }

    @com.google.common.annotations.Beta
    public static int saturatedSubtract(int i, int i2) {
        return com.google.common.primitives.Ints.saturatedCast(i - i2);
    }

    @com.google.common.annotations.GwtIncompatible
    public static int sqrt(int i, java.math.RoundingMode roundingMode) {
        int a2;
        com.google.common.math.MathPreconditions.e("x", i);
        int c2 = c(i);
        switch (com.google.common.math.IntMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(c2 * c2 == i);
            case 2:
            case 3:
                return c2;
            case 4:
            case 5:
                a2 = a(c2 * c2, i);
                return c2 + a2;
            case 6:
            case 7:
            case 8:
                a2 = a((c2 * c2) + c2, i);
                return c2 + a2;
            default:
                throw new java.lang.AssertionError();
        }
    }
}
