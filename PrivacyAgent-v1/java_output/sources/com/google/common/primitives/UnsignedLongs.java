package com.google.common.primitives;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    public enum LexicographicalComparator implements java.util.Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = java.lang.Math.min(jArr.length, jArr2.length);
            for (int i = 0; i < min; i++) {
                long j = jArr[i];
                long j2 = jArr2[i];
                if (j != j2) {
                    return com.google.common.primitives.UnsignedLongs.compare(j, j2);
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    public static final class ParseOverflowDetection {
        public static final long[] a = new long[37];
        public static final int[] b = new int[37];
        public static final int[] c = new int[37];

        static {
            java.math.BigInteger bigInteger = new java.math.BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                long j = i;
                a[i] = com.google.common.primitives.UnsignedLongs.divide(-1L, j);
                b[i] = (int) com.google.common.primitives.UnsignedLongs.remainder(-1L, j);
                c[i] = bigInteger.toString(i).length() - 1;
            }
        }

        public static boolean a(long j, int i, int i2) {
            if (j < 0) {
                return true;
            }
            long j2 = a[i2];
            if (j < j2) {
                return false;
            }
            return j > j2 || i > b[i2];
        }
    }

    public static long a(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static int compare(long j, long j2) {
        return com.google.common.primitives.Longs.compare(a(j), a(j2));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long decode(java.lang.String str) {
        com.google.common.primitives.ParseRequest a = com.google.common.primitives.ParseRequest.a(str);
        try {
            return parseUnsignedLong(a.a, a.b);
        } catch (java.lang.NumberFormatException e) {
            java.lang.NumberFormatException numberFormatException = new java.lang.NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static long divide(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + (compare(j - (j3 * j2), j2) < 0 ? 0 : 1);
    }

    public static java.lang.String join(java.lang.String str, long... jArr) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i = 1; i < jArr.length; i++) {
            sb.append(str);
            sb.append(toString(jArr[i]));
        }
        return sb.toString();
    }

    public static java.util.Comparator<long[]> lexicographicalComparator() {
        return com.google.common.primitives.UnsignedLongs.LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        com.google.common.base.Preconditions.checkArgument(jArr.length > 0);
        long a = a(jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            long a2 = a(jArr[i]);
            if (a2 > a) {
                a = a2;
            }
        }
        return a(a);
    }

    public static long min(long... jArr) {
        com.google.common.base.Preconditions.checkArgument(jArr.length > 0);
        long a = a(jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            long a2 = a(jArr[i]);
            if (a2 < a) {
                a = a2;
            }
        }
        return a(a);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long parseUnsignedLong(java.lang.String str) {
        return parseUnsignedLong(str, 10);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static long parseUnsignedLong(java.lang.String str, int i) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new java.lang.NumberFormatException("empty string");
        }
        if (i < 2 || i > 36) {
            throw new java.lang.NumberFormatException("illegal radix: " + i);
        }
        int i2 = com.google.common.primitives.UnsignedLongs.ParseOverflowDetection.c[i] - 1;
        long j = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int digit = java.lang.Character.digit(str.charAt(i3), i);
            if (digit == -1) {
                throw new java.lang.NumberFormatException(str);
            }
            if (i3 > i2 && com.google.common.primitives.UnsignedLongs.ParseOverflowDetection.a(j, digit, i)) {
                throw new java.lang.NumberFormatException("Too large for unsigned long: " + str);
            }
            j = (j * i) + digit;
        }
        return j;
    }

    public static long remainder(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (compare(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static void sort(long[] jArr) {
        com.google.common.base.Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sort(long[] jArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(jArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, jArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            jArr[i3] = a(jArr[i3]);
        }
        java.util.Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = a(jArr[i]);
            i++;
        }
    }

    public static void sortDescending(long[] jArr) {
        com.google.common.base.Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(jArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, jArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            jArr[i3] = Long.MAX_VALUE ^ jArr[i3];
        }
        java.util.Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = jArr[i] ^ Long.MAX_VALUE;
            i++;
        }
    }

    public static java.lang.String toString(long j) {
        return toString(j, 10);
    }

    public static java.lang.String toString(long j, int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return java.lang.Long.toString(j, i);
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int numberOfTrailingZeros = java.lang.Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = java.lang.Character.forDigit(((int) j) & i3, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            long divide = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : divide(j, i);
            long j2 = i;
            int i4 = 63;
            cArr[63] = java.lang.Character.forDigit((int) (j - (divide * j2)), i);
            while (divide > 0) {
                i4--;
                cArr[i4] = java.lang.Character.forDigit((int) (divide % j2), i);
                divide /= j2;
            }
            i2 = i4;
        }
        return new java.lang.String(cArr, i2, 64 - i2);
    }
}
