package com.google.common.primitives;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    public enum LexicographicalComparator implements java.util.Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = java.lang.Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = com.google.common.primitives.SignedBytes.compare(bArr[i], bArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    public static byte checkedCast(long j) {
        byte b = (byte) j;
        com.google.common.base.Preconditions.checkArgument(((long) b) == j, "Out of range: %s", j);
        return b;
    }

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static java.lang.String join(java.lang.String str, byte... bArr) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 5);
        sb.append((int) bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            sb.append(str);
            sb.append((int) bArr[i]);
        }
        return sb.toString();
    }

    public static java.util.Comparator<byte[]> lexicographicalComparator() {
        return com.google.common.primitives.SignedBytes.LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        com.google.common.base.Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    public static byte min(byte... bArr) {
        com.google.common.base.Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    public static byte saturatedCast(long j) {
        if (j > 127) {
            return Byte.MAX_VALUE;
        }
        if (j < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) j;
    }

    public static void sortDescending(byte[] bArr) {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, bArr.length);
        java.util.Arrays.sort(bArr, i, i2);
        com.google.common.primitives.Bytes.reverse(bArr, i, i2);
    }
}
