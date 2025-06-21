package com.google.common.primitives;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class UnsignedInts {

    public enum LexicographicalComparator implements java.util.Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = java.lang.Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < min; i++) {
                int i2 = iArr[i];
                int i3 = iArr2[i];
                if (i2 != i3) {
                    return com.google.common.primitives.UnsignedInts.compare(i2, i3);
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    public static int a(int i) {
        return i ^ Integer.MIN_VALUE;
    }

    public static int checkedCast(long j) {
        com.google.common.base.Preconditions.checkArgument((j >> 32) == 0, "out of range: %s", j);
        return (int) j;
    }

    public static int compare(int i, int i2) {
        return com.google.common.primitives.Ints.compare(a(i), a(i2));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int decode(java.lang.String str) {
        com.google.common.primitives.ParseRequest a = com.google.common.primitives.ParseRequest.a(str);
        try {
            return parseUnsignedInt(a.a, a.b);
        } catch (java.lang.NumberFormatException e) {
            java.lang.NumberFormatException numberFormatException = new java.lang.NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static int divide(int i, int i2) {
        return (int) (toLong(i) / toLong(i2));
    }

    public static java.lang.String join(java.lang.String str, int... iArr) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(iArr.length * 5);
        sb.append(toString(iArr[0]));
        for (int i = 1; i < iArr.length; i++) {
            sb.append(str);
            sb.append(toString(iArr[i]));
        }
        return sb.toString();
    }

    public static java.util.Comparator<int[]> lexicographicalComparator() {
        return com.google.common.primitives.UnsignedInts.LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        com.google.common.base.Preconditions.checkArgument(iArr.length > 0);
        int a = a(iArr[0]);
        for (int i = 1; i < iArr.length; i++) {
            int a2 = a(iArr[i]);
            if (a2 > a) {
                a = a2;
            }
        }
        return a(a);
    }

    public static int min(int... iArr) {
        com.google.common.base.Preconditions.checkArgument(iArr.length > 0);
        int a = a(iArr[0]);
        for (int i = 1; i < iArr.length; i++) {
            int a2 = a(iArr[i]);
            if (a2 < a) {
                a = a2;
            }
        }
        return a(a);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int parseUnsignedInt(java.lang.String str) {
        return parseUnsignedInt(str, 10);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static int parseUnsignedInt(java.lang.String str, int i) {
        com.google.common.base.Preconditions.checkNotNull(str);
        long parseLong = java.lang.Long.parseLong(str, i);
        if ((net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new java.lang.NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    public static int remainder(int i, int i2) {
        return (int) (toLong(i) % toLong(i2));
    }

    public static int saturatedCast(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            return -1;
        }
        return (int) j;
    }

    public static void sort(int[] iArr) {
        com.google.common.base.Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sort(int[] iArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(iArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, iArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            iArr[i3] = a(iArr[i3]);
        }
        java.util.Arrays.sort(iArr, i, i2);
        while (i < i2) {
            iArr[i] = a(iArr[i]);
            i++;
        }
    }

    public static void sortDescending(int[] iArr) {
        com.google.common.base.Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(iArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, iArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            iArr[i3] = Integer.MAX_VALUE ^ iArr[i3];
        }
        java.util.Arrays.sort(iArr, i, i2);
        while (i < i2) {
            iArr[i] = iArr[i] ^ Integer.MAX_VALUE;
            i++;
        }
    }

    public static long toLong(int i) {
        return i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
    }

    public static java.lang.String toString(int i) {
        return toString(i, 10);
    }

    public static java.lang.String toString(int i, int i2) {
        return java.lang.Long.toString(i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT, i2);
    }
}
