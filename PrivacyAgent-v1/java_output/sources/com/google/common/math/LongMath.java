package com.google.common.math;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class LongMath {

    @com.google.common.annotations.VisibleForTesting
    public static final byte[] a = {19, com.google.common.base.Ascii.DC2, com.google.common.base.Ascii.DC2, com.google.common.base.Ascii.DC2, com.google.common.base.Ascii.DC2, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    @com.google.common.annotations.VisibleForTesting
    @com.google.common.annotations.GwtIncompatible
    public static final long[] b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    @com.google.common.annotations.VisibleForTesting
    @com.google.common.annotations.GwtIncompatible
    public static final long[] c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    public static final long[] d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    public static final int[] e = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 169, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    @com.google.common.annotations.VisibleForTesting
    public static final int[] f = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, com.anythink.expressad.foundation.g.a.aU, 214, 169, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    public static final long[][] g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class MillerRabinTester {
        private static final /* synthetic */ com.google.common.math.LongMath.MillerRabinTester[] $VALUES;
        public static final com.google.common.math.LongMath.MillerRabinTester LARGE;
        public static final com.google.common.math.LongMath.MillerRabinTester SMALL;

        /* renamed from: com.google.common.math.LongMath$MillerRabinTester$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.math.LongMath.MillerRabinTester {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j, long j2) {
                return (j * j) % j2;
            }
        }

        /* renamed from: com.google.common.math.LongMath$MillerRabinTester$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.math.LongMath.MillerRabinTester {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            private long plusMod(long j, long j2, long j3) {
                long j4 = j + j2;
                return j >= j3 - j2 ? j4 - j3 : j4;
            }

            private long times2ToThe32Mod(long j, long j2) {
                int i = 32;
                do {
                    int min = java.lang.Math.min(i, java.lang.Long.numberOfLeadingZeros(j));
                    j = com.google.common.primitives.UnsignedLongs.remainder(j << min, j2);
                    i -= min;
                } while (i > 0);
                return j;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j, long j2, long j3) {
                long j4 = j >>> 32;
                long j5 = j2 >>> 32;
                long j6 = j & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
                long j7 = j2 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
                long times2ToThe32Mod = times2ToThe32Mod(j4 * j5, j3) + (j4 * j7);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = com.google.common.primitives.UnsignedLongs.remainder(times2ToThe32Mod, j3);
                }
                java.lang.Long.signum(j6);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j5 * j6), j3), com.google.common.primitives.UnsignedLongs.remainder(j6 * j7, j3), j3);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
                long times2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                long j5 = j3 * j4 * 2;
                if (j5 < 0) {
                    j5 = com.google.common.primitives.UnsignedLongs.remainder(j5, j2);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j5, j2), com.google.common.primitives.UnsignedLongs.remainder(j4 * j4, j2), j2);
            }
        }

        static {
            com.google.common.math.LongMath.MillerRabinTester.AnonymousClass1 anonymousClass1 = new com.google.common.math.LongMath.MillerRabinTester.AnonymousClass1("SMALL", 0);
            SMALL = anonymousClass1;
            com.google.common.math.LongMath.MillerRabinTester.AnonymousClass2 anonymousClass2 = new com.google.common.math.LongMath.MillerRabinTester.AnonymousClass2("LARGE", 1);
            LARGE = anonymousClass2;
            $VALUES = new com.google.common.math.LongMath.MillerRabinTester[]{anonymousClass1, anonymousClass2};
        }

        private MillerRabinTester(java.lang.String str, int i) {
        }

        public /* synthetic */ MillerRabinTester(java.lang.String str, int i, com.google.common.math.LongMath.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        private long powMod(long j, long j2, long j3) {
            long j4 = 1;
            while (j2 != 0) {
                if ((j2 & 1) != 0) {
                    j4 = mulMod(j4, j, j3);
                }
                j = squareMod(j, j3);
                j2 >>= 1;
            }
            return j4;
        }

        public static boolean test(long j, long j2) {
            return (j2 <= 3037000499L ? SMALL : LARGE).testWitness(j, j2);
        }

        private boolean testWitness(long j, long j2) {
            long j3 = j2 - 1;
            int numberOfTrailingZeros = java.lang.Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> numberOfTrailingZeros;
            long j5 = j % j2;
            if (j5 == 0) {
                return true;
            }
            long powMod = powMod(j5, j4, j2);
            if (powMod == 1) {
                return true;
            }
            int i = 0;
            while (powMod != j3) {
                i++;
                if (i == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j2);
            }
            return true;
        }

        public static com.google.common.math.LongMath.MillerRabinTester valueOf(java.lang.String str) {
            return (com.google.common.math.LongMath.MillerRabinTester) java.lang.Enum.valueOf(com.google.common.math.LongMath.MillerRabinTester.class, str);
        }

        public static com.google.common.math.LongMath.MillerRabinTester[] values() {
            return (com.google.common.math.LongMath.MillerRabinTester[]) $VALUES.clone();
        }

        public abstract long mulMod(long j, long j2, long j3);

        public abstract long squareMod(long j, long j2);
    }

    public static boolean a(long j) {
        return ((long) ((int) j)) == j;
    }

    @com.google.common.annotations.VisibleForTesting
    public static int b(long j, long j2) {
        return (int) ((~(~(j - j2))) >>> 63);
    }

    public static long binomial(int i, int i2) {
        com.google.common.math.MathPreconditions.e(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, i);
        com.google.common.math.MathPreconditions.e("k", i2);
        com.google.common.base.Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        long j = 1;
        if (i2 == 0) {
            return 1L;
        }
        if (i2 == 1) {
            return i;
        }
        long[] jArr = d;
        if (i < jArr.length) {
            return jArr[i] / (jArr[i2] * jArr[i - i2]);
        }
        int[] iArr = e;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = f;
        if (i2 < iArr2.length && i <= iArr2[i2]) {
            int i3 = i - 1;
            long j2 = i;
            for (int i4 = 2; i4 <= i2; i4++) {
                j2 = (j2 * i3) / i4;
                i3--;
            }
            return j2;
        }
        long j3 = i;
        int log2 = log2(j3, java.math.RoundingMode.CEILING);
        int i5 = i - 1;
        int i6 = log2;
        long j4 = j3;
        int i7 = 2;
        long j5 = 1;
        while (i7 <= i2) {
            i6 += log2;
            if (i6 < 63) {
                j4 *= i5;
                j5 *= i7;
            } else {
                j = d(j, j4, j5);
                j4 = i5;
                j5 = i7;
                i6 = log2;
            }
            i7++;
            i5--;
        }
        return d(j, j4, j5);
    }

    @com.google.common.annotations.GwtIncompatible
    public static int c(long j) {
        byte b2 = a[java.lang.Long.numberOfLeadingZeros(j)];
        return b2 - b(j, b[b2]);
    }

    @com.google.common.annotations.Beta
    public static long ceilingPowerOfTwo(long j) {
        com.google.common.math.MathPreconditions.i("x", j);
        if (j <= com.google.common.primitives.Longs.MAX_POWER_OF_TWO) {
            return 1 << (-java.lang.Long.numberOfLeadingZeros(j - 1));
        }
        throw new java.lang.ArithmeticException("ceilingPowerOfTwo(" + j + ") is not representable as a long");
    }

    @com.google.common.annotations.GwtIncompatible
    public static long checkedAdd(long j, long j2) {
        long j3 = j + j2;
        com.google.common.math.MathPreconditions.c(((j ^ j2) < 0) | ((j ^ j3) >= 0), "checkedAdd", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        int numberOfLeadingZeros = java.lang.Long.numberOfLeadingZeros(j) + java.lang.Long.numberOfLeadingZeros(~j) + java.lang.Long.numberOfLeadingZeros(j2) + java.lang.Long.numberOfLeadingZeros(~j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        com.google.common.math.MathPreconditions.c(numberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
        com.google.common.math.MathPreconditions.c((j >= 0) | (j2 != Long.MIN_VALUE), "checkedMultiply", j, j2);
        long j3 = j * j2;
        com.google.common.math.MathPreconditions.c(j == 0 || j3 / j == j2, "checkedMultiply", j, j2);
        return j3;
    }

    @com.google.common.annotations.GwtIncompatible
    public static long checkedPow(long j, int i) {
        com.google.common.math.MathPreconditions.e("exponent", i);
        long j2 = 1;
        if (!(j >= -2) || !(j <= 2)) {
            long j3 = j;
            int i2 = i;
            while (i2 != 0) {
                if (i2 == 1) {
                    return checkedMultiply(j2, j3);
                }
                long checkedMultiply = (i2 & 1) != 0 ? checkedMultiply(j2, j3) : j2;
                int i3 = i2 >> 1;
                if (i3 > 0) {
                    com.google.common.math.MathPreconditions.c(-3037000499L <= j3 && j3 <= 3037000499L, "checkedPow", j3, i3);
                    j3 *= j3;
                }
                j2 = checkedMultiply;
                i2 = i3;
            }
            return j2;
        }
        int i4 = (int) j;
        if (i4 == -2) {
            com.google.common.math.MathPreconditions.c(i < 64, "checkedPow", j, i);
            return (i & 1) == 0 ? 1 << i : (-1) << i;
        }
        if (i4 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i4 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i4 == 1) {
            return 1L;
        }
        if (i4 != 2) {
            throw new java.lang.AssertionError();
        }
        com.google.common.math.MathPreconditions.c(i < 63, "checkedPow", j, i);
        return 1 << i;
    }

    @com.google.common.annotations.GwtIncompatible
    public static long checkedSubtract(long j, long j2) {
        long j3 = j - j2;
        com.google.common.math.MathPreconditions.c(((j ^ j2) >= 0) | ((j ^ j3) >= 0), "checkedSubtract", j, j2);
        return j3;
    }

    public static long d(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long gcd = gcd(j, j3);
        return (j / gcd) * (j2 / (j3 / gcd));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        if (r2 > 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        if (r10 > 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
    
        if (r10 < 0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long divide(long j, long j2, java.math.RoundingMode roundingMode) {
        com.google.common.base.Preconditions.checkNotNull(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        if (j4 == 0) {
            return j3;
        }
        int i = (int) ((j ^ j2) >> 63);
        int i2 = i | 1;
        switch (com.google.common.math.LongMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(j4 == 0);
                r9 = false;
                return !r9 ? j3 + i2 : j3;
            case 2:
                r9 = false;
                if (!r9) {
                }
                break;
            case 3:
                break;
            case 4:
                if (!r9) {
                }
                break;
            case 5:
                break;
            case 6:
            case 7:
            case 8:
                long abs = java.lang.Math.abs(j4);
                long abs2 = abs - (java.lang.Math.abs(j2) - abs);
                if (abs2 == 0) {
                    r9 = (((1 & j3) != 0) & (roundingMode == java.math.RoundingMode.HALF_EVEN)) | (roundingMode == java.math.RoundingMode.HALF_UP);
                }
                if (!r9) {
                }
                break;
            default:
                throw new java.lang.AssertionError();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static long factorial(int i) {
        com.google.common.math.MathPreconditions.e(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, i);
        long[] jArr = d;
        if (i < jArr.length) {
            return jArr[i];
        }
        return Long.MAX_VALUE;
    }

    @com.google.common.annotations.Beta
    public static long floorPowerOfTwo(long j) {
        com.google.common.math.MathPreconditions.i("x", j);
        return 1 << (63 - java.lang.Long.numberOfLeadingZeros(j));
    }

    public static long gcd(long j, long j2) {
        com.google.common.math.MathPreconditions.f("a", j);
        com.google.common.math.MathPreconditions.f("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int numberOfTrailingZeros = java.lang.Long.numberOfTrailingZeros(j);
        long j3 = j >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = java.lang.Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros2;
        while (j3 != j4) {
            long j5 = j3 - j4;
            long j6 = (j5 >> 63) & j5;
            long j7 = (j5 - j6) - j6;
            j4 += j6;
            j3 = j7 >> java.lang.Long.numberOfTrailingZeros(j7);
        }
        return j3 << java.lang.Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j) {
        return (j > 0) & ((j & (j - 1)) == 0);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static boolean isPrime(long j) {
        if (j < 2) {
            com.google.common.math.MathPreconditions.f(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, j);
            return false;
        }
        if (j == 2 || j == 3 || j == 5 || j == 7 || j == 11 || j == 13) {
            return true;
        }
        if (((1 << ((int) (j % 30))) & (-545925251)) != 0 || j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
            return false;
        }
        if (j < 289) {
            return true;
        }
        for (long[] jArr : g) {
            if (j <= jArr[0]) {
                for (int i = 1; i < jArr.length; i++) {
                    if (!com.google.common.math.LongMath.MillerRabinTester.test(jArr[i], j)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new java.lang.AssertionError();
    }

    @com.google.common.annotations.GwtIncompatible
    public static int log10(long j, java.math.RoundingMode roundingMode) {
        int b2;
        com.google.common.math.MathPreconditions.i("x", j);
        int c2 = c(j);
        long j2 = b[c2];
        switch (com.google.common.math.LongMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(j == j2);
            case 2:
            case 3:
                return c2;
            case 4:
            case 5:
                b2 = b(j2, j);
                return c2 + b2;
            case 6:
            case 7:
            case 8:
                b2 = b(c[c2], j);
                return c2 + b2;
            default:
                throw new java.lang.AssertionError();
        }
    }

    public static int log2(long j, java.math.RoundingMode roundingMode) {
        com.google.common.math.MathPreconditions.i("x", j);
        switch (com.google.common.math.LongMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - java.lang.Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = java.lang.Long.numberOfLeadingZeros(j);
                return (63 - numberOfLeadingZeros) + b((-5402926248376769404) >>> numberOfLeadingZeros, j);
            default:
                throw new java.lang.AssertionError("impossible");
        }
        return 63 - java.lang.Long.numberOfLeadingZeros(j);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    @com.google.common.annotations.GwtIncompatible
    public static int mod(long j, int i) {
        return (int) mod(j, i);
    }

    @com.google.common.annotations.GwtIncompatible
    public static long mod(long j, long j2) {
        if (j2 <= 0) {
            throw new java.lang.ArithmeticException("Modulus must be positive");
        }
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    @com.google.common.annotations.GwtIncompatible
    public static long pow(long j, int i) {
        com.google.common.math.MathPreconditions.e("exponent", i);
        if (-2 > j || j > 2) {
            long j2 = 1;
            while (i != 0) {
                if (i == 1) {
                    return j2 * j;
                }
                j2 *= (i & 1) == 0 ? 1L : j;
                j *= j;
                i >>= 1;
            }
            return j2;
        }
        int i2 = (int) j;
        if (i2 == -2) {
            if (i < 64) {
                return (i & 1) == 0 ? 1 << i : -(1 << i);
            }
            return 0L;
        }
        if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i2 == 1) {
            return 1L;
        }
        if (i2 != 2) {
            throw new java.lang.AssertionError();
        }
        if (i < 64) {
            return 1 << i;
        }
        return 0L;
    }

    @com.google.common.annotations.Beta
    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @com.google.common.annotations.Beta
    public static long saturatedMultiply(long j, long j2) {
        int numberOfLeadingZeros = java.lang.Long.numberOfLeadingZeros(j) + java.lang.Long.numberOfLeadingZeros(~j) + java.lang.Long.numberOfLeadingZeros(j2) + java.lang.Long.numberOfLeadingZeros(~j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        if ((numberOfLeadingZeros < 64) || ((j2 == Long.MIN_VALUE) & (j < 0))) {
            return j3;
        }
        long j4 = j * j2;
        return (j == 0 || j4 / j == j2) ? j4 : j3;
    }

    @com.google.common.annotations.Beta
    public static long saturatedPow(long j, int i) {
        com.google.common.math.MathPreconditions.e("exponent", i);
        long j2 = 1;
        if (!(j >= -2) || !(j <= 2)) {
            long j3 = ((j >>> 63) & i & 1) + Long.MAX_VALUE;
            while (i != 0) {
                if (i == 1) {
                    return saturatedMultiply(j2, j);
                }
                if ((i & 1) != 0) {
                    j2 = saturatedMultiply(j2, j);
                }
                i >>= 1;
                if (i > 0) {
                    if ((-3037000499L > j) || (j > 3037000499L)) {
                        return j3;
                    }
                    j *= j;
                }
            }
            return j2;
        }
        int i2 = (int) j;
        if (i2 == -2) {
            return i >= 64 ? (i & 1) + Long.MAX_VALUE : (i & 1) == 0 ? 1 << i : (-1) << i;
        }
        if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i2 == 1) {
            return 1L;
        }
        if (i2 != 2) {
            throw new java.lang.AssertionError();
        }
        if (i >= 63) {
            return Long.MAX_VALUE;
        }
        return 1 << i;
    }

    @com.google.common.annotations.Beta
    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) >= 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @com.google.common.annotations.GwtIncompatible
    public static long sqrt(long j, java.math.RoundingMode roundingMode) {
        com.google.common.math.MathPreconditions.f("x", j);
        if (a(j)) {
            return com.google.common.math.IntMath.sqrt((int) j, roundingMode);
        }
        long sqrt = (long) java.lang.Math.sqrt(j);
        long j2 = sqrt * sqrt;
        switch (com.google.common.math.LongMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(j2 == j);
                return sqrt;
            case 2:
            case 3:
                return j < j2 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j > j2 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                return (sqrt - (j >= j2 ? 0 : 1)) + b((r0 * r0) + r0, j);
            default:
                throw new java.lang.AssertionError();
        }
    }
}
