package com.google.common.primitives;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;

    @com.google.common.annotations.VisibleForTesting
    public static class LexicographicalComparatorHolder {
        public static final java.lang.String a = com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
        public static final java.util.Comparator<byte[]> b = a();

        public enum PureJavaComparator implements java.util.Comparator<byte[]> {
            INSTANCE;

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = java.lang.Math.min(bArr.length, bArr2.length);
                for (int i = 0; i < min; i++) {
                    int compare = com.google.common.primitives.UnsignedBytes.compare(bArr[i], bArr2[i]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public java.lang.String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        @com.google.common.annotations.VisibleForTesting
        public enum UnsafeComparator implements java.util.Comparator<byte[]> {
            INSTANCE;

            static final boolean BIG_ENDIAN = java.nio.ByteOrder.nativeOrder().equals(java.nio.ByteOrder.BIG_ENDIAN);
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final sun.misc.Unsafe theUnsafe;

            /* renamed from: com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1, reason: invalid class name */
            public static class AnonymousClass1 implements java.security.PrivilegedExceptionAction<sun.misc.Unsafe> {
                @Override // java.security.PrivilegedExceptionAction
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public sun.misc.Unsafe run() throws java.lang.Exception {
                    for (java.lang.reflect.Field field : sun.misc.Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        java.lang.Object obj = field.get(null);
                        if (sun.misc.Unsafe.class.isInstance(obj)) {
                            return (sun.misc.Unsafe) sun.misc.Unsafe.class.cast(obj);
                        }
                    }
                    throw new java.lang.NoSuchFieldError("the Unsafe");
                }
            }

            static {
                sun.misc.Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                int arrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
                if (!"64".equals(java.lang.System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new java.lang.Error();
                }
            }

            private static sun.misc.Unsafe getUnsafe() {
                try {
                    try {
                        return sun.misc.Unsafe.getUnsafe();
                    } catch (java.security.PrivilegedActionException e) {
                        throw new java.lang.RuntimeException("Could not initialize intrinsics", e.getCause());
                    }
                } catch (java.lang.SecurityException unused) {
                    return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.AnonymousClass1());
                }
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = java.lang.Math.min(bArr.length, bArr2.length);
                int i = min & (-8);
                int i2 = 0;
                while (i2 < i) {
                    sun.misc.Unsafe unsafe = theUnsafe;
                    int i3 = BYTE_ARRAY_BASE_OFFSET;
                    long j = i2;
                    long j2 = unsafe.getLong(bArr, i3 + j);
                    long j3 = unsafe.getLong(bArr2, i3 + j);
                    if (j2 != j3) {
                        if (BIG_ENDIAN) {
                            return com.google.common.primitives.UnsignedLongs.compare(j2, j3);
                        }
                        int numberOfTrailingZeros = java.lang.Long.numberOfTrailingZeros(j2 ^ j3) & (-8);
                        return ((int) ((j2 >>> numberOfTrailingZeros) & 255)) - ((int) ((j3 >>> numberOfTrailingZeros) & 255));
                    }
                    i2 += 8;
                }
                while (i2 < min) {
                    int compare = com.google.common.primitives.UnsignedBytes.compare(bArr[i2], bArr2[i2]);
                    if (compare != 0) {
                        return compare;
                    }
                    i2++;
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public java.lang.String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        public static java.util.Comparator<byte[]> a() {
            try {
                return (java.util.Comparator) java.lang.Class.forName(a).getEnumConstants()[0];
            } catch (java.lang.Throwable unused) {
                return com.google.common.primitives.UnsignedBytes.b();
            }
        }
    }

    public static byte a(byte b) {
        return (byte) (b ^ 128);
    }

    @com.google.common.annotations.VisibleForTesting
    public static java.util.Comparator<byte[]> b() {
        return com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static byte checkedCast(long j) {
        com.google.common.base.Preconditions.checkArgument((j >> 8) == 0, "out of range: %s", j);
        return (byte) j;
    }

    public static int compare(byte b, byte b2) {
        return toInt(b) - toInt(b2);
    }

    public static java.lang.String join(java.lang.String str, byte... bArr) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * (str.length() + 3));
        sb.append(toInt(bArr[0]));
        for (int i = 1; i < bArr.length; i++) {
            sb.append(str);
            sb.append(toString(bArr[i]));
        }
        return sb.toString();
    }

    public static java.util.Comparator<byte[]> lexicographicalComparator() {
        return com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.b;
    }

    public static byte max(byte... bArr) {
        com.google.common.base.Preconditions.checkArgument(bArr.length > 0);
        int i = toInt(bArr[0]);
        for (int i2 = 1; i2 < bArr.length; i2++) {
            int i3 = toInt(bArr[i2]);
            if (i3 > i) {
                i = i3;
            }
        }
        return (byte) i;
    }

    public static byte min(byte... bArr) {
        com.google.common.base.Preconditions.checkArgument(bArr.length > 0);
        int i = toInt(bArr[0]);
        for (int i2 = 1; i2 < bArr.length; i2++) {
            int i3 = toInt(bArr[i2]);
            if (i3 < i) {
                i = i3;
            }
        }
        return (byte) i;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public static byte parseUnsignedByte(java.lang.String str) {
        return parseUnsignedByte(str, 10);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public static byte parseUnsignedByte(java.lang.String str, int i) {
        int parseInt = java.lang.Integer.parseInt((java.lang.String) com.google.common.base.Preconditions.checkNotNull(str), i);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        throw new java.lang.NumberFormatException("out of range: " + parseInt);
    }

    public static byte saturatedCast(long j) {
        if (j > toInt((byte) -1)) {
            return (byte) -1;
        }
        if (j < 0) {
            return (byte) 0;
        }
        return (byte) j;
    }

    public static void sort(byte[] bArr) {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        sort(bArr, 0, bArr.length);
    }

    public static void sort(byte[] bArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, bArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            bArr[i3] = a(bArr[i3]);
        }
        java.util.Arrays.sort(bArr, i, i2);
        while (i < i2) {
            bArr[i] = a(bArr[i]);
            i++;
        }
    }

    public static void sortDescending(byte[] bArr) {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, bArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ Byte.MAX_VALUE);
        }
        java.util.Arrays.sort(bArr, i, i2);
        while (i < i2) {
            bArr[i] = (byte) (bArr[i] ^ Byte.MAX_VALUE);
            i++;
        }
    }

    public static int toInt(byte b) {
        return b & 255;
    }

    @com.google.common.annotations.Beta
    public static java.lang.String toString(byte b) {
        return toString(b, 10);
    }

    @com.google.common.annotations.Beta
    public static java.lang.String toString(byte b, int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        return java.lang.Integer.toString(toInt(b), i);
    }
}
