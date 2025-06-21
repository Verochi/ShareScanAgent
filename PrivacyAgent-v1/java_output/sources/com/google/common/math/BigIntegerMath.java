package com.google.common.math;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class BigIntegerMath {

    @com.google.common.annotations.VisibleForTesting
    public static final java.math.BigInteger a = new java.math.BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    public static final double b = java.lang.Math.log(10.0d);
    public static final double c = java.lang.Math.log(2.0d);

    /* renamed from: com.google.common.math.BigIntegerMath$1, reason: invalid class name */
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

    @com.google.common.annotations.GwtIncompatible
    public static boolean a(java.math.BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }

    public static java.math.BigInteger b(java.util.List<java.math.BigInteger> list) {
        return c(list, 0, list.size());
    }

    public static java.math.BigInteger binomial(int i, int i2) {
        int i3;
        com.google.common.math.MathPreconditions.e(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, i);
        com.google.common.math.MathPreconditions.e("k", i2);
        int i4 = 1;
        com.google.common.base.Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = com.google.common.math.LongMath.e;
        if (i2 < iArr.length && i <= iArr[i2]) {
            return java.math.BigInteger.valueOf(com.google.common.math.LongMath.binomial(i, i2));
        }
        java.math.BigInteger bigInteger = java.math.BigInteger.ONE;
        long j = i;
        int log2 = com.google.common.math.LongMath.log2(j, java.math.RoundingMode.CEILING);
        long j2 = 1;
        while (true) {
            int i5 = log2;
            while (i4 < i2) {
                i3 = i - i4;
                i4++;
                i5 += log2;
                if (i5 >= 63) {
                    break;
                }
                j *= i3;
                j2 *= i4;
            }
            return bigInteger.multiply(java.math.BigInteger.valueOf(j)).divide(java.math.BigInteger.valueOf(j2));
            bigInteger = bigInteger.multiply(java.math.BigInteger.valueOf(j)).divide(java.math.BigInteger.valueOf(j2));
            j = i3;
            j2 = i4;
        }
    }

    public static java.math.BigInteger c(java.util.List<java.math.BigInteger> list, int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 0) {
            return java.math.BigInteger.ONE;
        }
        if (i3 == 1) {
            return list.get(i);
        }
        if (i3 == 2) {
            return list.get(i).multiply(list.get(i + 1));
        }
        if (i3 == 3) {
            return list.get(i).multiply(list.get(i + 1)).multiply(list.get(i + 2));
        }
        int i4 = (i2 + i) >>> 1;
        return c(list, i, i4).multiply(c(list, i4, i2));
    }

    @com.google.common.annotations.Beta
    public static java.math.BigInteger ceilingPowerOfTwo(java.math.BigInteger bigInteger) {
        return java.math.BigInteger.ZERO.setBit(log2(bigInteger, java.math.RoundingMode.CEILING));
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.math.BigInteger d(java.math.BigInteger bigInteger) {
        return com.google.common.math.DoubleMath.roundToBigInteger(java.lang.Math.sqrt(com.google.common.math.DoubleUtils.a(bigInteger)), java.math.RoundingMode.HALF_EVEN);
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.math.BigInteger divide(java.math.BigInteger bigInteger, java.math.BigInteger bigInteger2, java.math.RoundingMode roundingMode) {
        return new java.math.BigDecimal(bigInteger).divide(new java.math.BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.math.BigInteger e(java.math.BigInteger bigInteger) {
        java.math.BigInteger shiftLeft;
        int log2 = log2(bigInteger, java.math.RoundingMode.FLOOR);
        if (log2 < 1023) {
            shiftLeft = d(bigInteger);
        } else {
            int i = (log2 - 52) & (-2);
            shiftLeft = d(bigInteger.shiftRight(i)).shiftLeft(i >> 1);
        }
        java.math.BigInteger shiftRight = shiftLeft.add(bigInteger.divide(shiftLeft)).shiftRight(1);
        if (shiftLeft.equals(shiftRight)) {
            return shiftLeft;
        }
        while (true) {
            java.math.BigInteger shiftRight2 = shiftRight.add(bigInteger.divide(shiftRight)).shiftRight(1);
            if (shiftRight2.compareTo(shiftRight) >= 0) {
                return shiftRight;
            }
            shiftRight = shiftRight2;
        }
    }

    public static java.math.BigInteger factorial(int i) {
        com.google.common.math.MathPreconditions.e(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, i);
        long[] jArr = com.google.common.math.LongMath.d;
        if (i < jArr.length) {
            return java.math.BigInteger.valueOf(jArr[i]);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(com.google.common.math.IntMath.divide(com.google.common.math.IntMath.log2(i, java.math.RoundingMode.CEILING) * i, 64, java.math.RoundingMode.CEILING));
        int length = jArr.length;
        long j = jArr[length - 1];
        int numberOfTrailingZeros = java.lang.Long.numberOfTrailingZeros(j);
        long j2 = j >> numberOfTrailingZeros;
        int log2 = com.google.common.math.LongMath.log2(j2, java.math.RoundingMode.FLOOR) + 1;
        long j3 = length;
        int log22 = com.google.common.math.LongMath.log2(j3, java.math.RoundingMode.FLOOR) + 1;
        int i2 = 1 << (log22 - 1);
        while (j3 <= i) {
            if ((i2 & j3) != 0) {
                i2 <<= 1;
                log22++;
            }
            int numberOfTrailingZeros2 = java.lang.Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((log22 - numberOfTrailingZeros2) + log2 >= 64) {
                arrayList.add(java.math.BigInteger.valueOf(j2));
                j2 = 1;
            }
            j2 *= j4;
            log2 = com.google.common.math.LongMath.log2(j2, java.math.RoundingMode.FLOOR) + 1;
            j3++;
        }
        if (j2 > 1) {
            arrayList.add(java.math.BigInteger.valueOf(j2));
        }
        return b(arrayList).shiftLeft(numberOfTrailingZeros);
    }

    @com.google.common.annotations.Beta
    public static java.math.BigInteger floorPowerOfTwo(java.math.BigInteger bigInteger) {
        return java.math.BigInteger.ZERO.setBit(log2(bigInteger, java.math.RoundingMode.FLOOR));
    }

    public static boolean isPowerOfTwo(java.math.BigInteger bigInteger) {
        com.google.common.base.Preconditions.checkNotNull(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    @com.google.common.annotations.GwtIncompatible
    public static int log10(java.math.BigInteger bigInteger, java.math.RoundingMode roundingMode) {
        int i;
        com.google.common.math.MathPreconditions.j("x", bigInteger);
        if (a(bigInteger)) {
            return com.google.common.math.LongMath.log10(bigInteger.longValue(), roundingMode);
        }
        int log2 = (int) ((log2(bigInteger, java.math.RoundingMode.FLOOR) * c) / b);
        java.math.BigInteger pow = java.math.BigInteger.TEN.pow(log2);
        int compareTo = pow.compareTo(bigInteger);
        if (compareTo > 0) {
            do {
                log2--;
                pow = pow.divide(java.math.BigInteger.TEN);
                i = pow.compareTo(bigInteger);
            } while (i > 0);
        } else {
            java.math.BigInteger multiply = java.math.BigInteger.TEN.multiply(pow);
            int i2 = compareTo;
            int compareTo2 = multiply.compareTo(bigInteger);
            while (compareTo2 <= 0) {
                log2++;
                java.math.BigInteger multiply2 = java.math.BigInteger.TEN.multiply(multiply);
                int compareTo3 = multiply2.compareTo(bigInteger);
                java.math.BigInteger bigInteger2 = multiply;
                multiply = multiply2;
                pow = bigInteger2;
                i2 = compareTo2;
                compareTo2 = compareTo3;
            }
            i = i2;
        }
        switch (com.google.common.math.BigIntegerMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(i == 0);
            case 2:
            case 3:
                return log2;
            case 4:
            case 5:
                return pow.equals(bigInteger) ? log2 : log2 + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(pow.pow(2).multiply(java.math.BigInteger.TEN)) <= 0 ? log2 : log2 + 1;
            default:
                throw new java.lang.AssertionError();
        }
    }

    public static int log2(java.math.BigInteger bigInteger, java.math.RoundingMode roundingMode) {
        com.google.common.math.MathPreconditions.j("x", (java.math.BigInteger) com.google.common.base.Preconditions.checkNotNull(bigInteger));
        int bitLength = bigInteger.bitLength() - 1;
        switch (com.google.common.math.BigIntegerMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(isPowerOfTwo(bigInteger));
            case 2:
            case 3:
                return bitLength;
            case 4:
            case 5:
                return isPowerOfTwo(bigInteger) ? bitLength : bitLength + 1;
            case 6:
            case 7:
            case 8:
                return bitLength < 256 ? bigInteger.compareTo(a.shiftRight(256 - bitLength)) <= 0 ? bitLength : bitLength + 1 : bigInteger.pow(2).bitLength() + (-1) < (bitLength * 2) + 1 ? bitLength : bitLength + 1;
            default:
                throw new java.lang.AssertionError();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.math.BigInteger sqrt(java.math.BigInteger bigInteger, java.math.RoundingMode roundingMode) {
        com.google.common.math.MathPreconditions.g("x", bigInteger);
        if (a(bigInteger)) {
            return java.math.BigInteger.valueOf(com.google.common.math.LongMath.sqrt(bigInteger.longValue(), roundingMode));
        }
        java.math.BigInteger e = e(bigInteger);
        switch (com.google.common.math.BigIntegerMath.AnonymousClass1.a[roundingMode.ordinal()]) {
            case 1:
                com.google.common.math.MathPreconditions.k(e.pow(2).equals(bigInteger));
            case 2:
            case 3:
                return e;
            case 4:
            case 5:
                int intValue = e.intValue();
                return intValue * intValue == bigInteger.intValue() && e.pow(2).equals(bigInteger) ? e : e.add(java.math.BigInteger.ONE);
            case 6:
            case 7:
            case 8:
                return e.pow(2).add(e).compareTo(bigInteger) >= 0 ? e : e.add(java.math.BigInteger.ONE);
            default:
                throw new java.lang.AssertionError();
        }
    }
}
