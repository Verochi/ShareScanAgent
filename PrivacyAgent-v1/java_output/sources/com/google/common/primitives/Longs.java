package com.google.common.primitives;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    public static final class AsciiDigits {
        public static final byte[] a;

        static {
            byte[] bArr = new byte[128];
            java.util.Arrays.fill(bArr, (byte) -1);
            for (int i = 0; i <= 9; i++) {
                bArr[i + 48] = (byte) i;
            }
            for (int i2 = 0; i2 <= 26; i2++) {
                byte b = (byte) (i2 + 10);
                bArr[i2 + 65] = b;
                bArr[i2 + 97] = b;
            }
            a = bArr;
        }

        public static int a(char c) {
            if (c < 128) {
                return a[c];
            }
            return -1;
        }
    }

    public enum LexicographicalComparator implements java.util.Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = java.lang.Math.min(jArr.length, jArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = com.google.common.primitives.Longs.compare(jArr[i], jArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    @com.google.common.annotations.GwtCompatible
    public static class LongArrayAsList extends java.util.AbstractList<java.lang.Long> implements java.util.RandomAccess, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        public LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        public LongArrayAsList(long[] jArr, int i, int i2) {
            this.array = jArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(java.lang.Object obj) {
            return (obj instanceof java.lang.Long) && com.google.common.primitives.Longs.c(this.array, ((java.lang.Long) obj).longValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.primitives.Longs.LongArrayAsList)) {
                return super.equals(obj);
            }
            com.google.common.primitives.Longs.LongArrayAsList longArrayAsList = (com.google.common.primitives.Longs.LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != longArrayAsList.array[longArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Long get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return java.lang.Long.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + com.google.common.primitives.Longs.hashCode(this.array[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(java.lang.Object obj) {
            int c;
            if (!(obj instanceof java.lang.Long) || (c = com.google.common.primitives.Longs.c(this.array, ((java.lang.Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return c - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(java.lang.Object obj) {
            int d;
            if (!(obj instanceof java.lang.Long) || (d = com.google.common.primitives.Longs.d(this.array, ((java.lang.Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return d - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Long set(int i, java.lang.Long l) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            long[] jArr = this.array;
            int i2 = this.start;
            long j = jArr[i2 + i];
            jArr[i2 + i] = ((java.lang.Long) com.google.common.base.Preconditions.checkNotNull(l)).longValue();
            return java.lang.Long.valueOf(j);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.List<java.lang.Long> subList(int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return java.util.Collections.emptyList();
            }
            long[] jArr = this.array;
            int i3 = this.start;
            return new com.google.common.primitives.Longs.LongArrayAsList(jArr, i + i3, i3 + i2);
        }

        public long[] toLongArray() {
            return java.util.Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(size() * 10);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.array[i]);
            }
        }
    }

    public static final class LongConverter extends com.google.common.base.Converter<java.lang.String, java.lang.Long> implements java.io.Serializable {
        static final com.google.common.primitives.Longs.LongConverter INSTANCE = new com.google.common.primitives.Longs.LongConverter();
        private static final long serialVersionUID = 1;

        private LongConverter() {
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public java.lang.String doBackward(java.lang.Long l) {
            return l.toString();
        }

        @Override // com.google.common.base.Converter
        public java.lang.Long doForward(java.lang.String str) {
            return java.lang.Long.decode(str);
        }

        public java.lang.String toString() {
            return "Longs.stringConverter()";
        }
    }

    public static java.util.List<java.lang.Long> asList(long... jArr) {
        return jArr.length == 0 ? java.util.Collections.emptyList() : new com.google.common.primitives.Longs.LongArrayAsList(jArr);
    }

    public static int c(long[] jArr, long j, int i, int i2) {
        while (i < i2) {
            if (jArr[i] == j) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static long[] concat(long[]... jArr) {
        int i = 0;
        for (long[] jArr2 : jArr) {
            i += jArr2.length;
        }
        long[] jArr3 = new long[i];
        int i2 = 0;
        for (long[] jArr4 : jArr) {
            java.lang.System.arraycopy(jArr4, 0, jArr3, i2, jArr4.length);
            i2 += jArr4.length;
        }
        return jArr3;
    }

    @com.google.common.annotations.Beta
    public static long constrainToRange(long j, long j2, long j3) {
        com.google.common.base.Preconditions.checkArgument(j2 <= j3, "min (%s) must be less than or equal to max (%s)", j2, j3);
        return java.lang.Math.min(java.lang.Math.max(j, j2), j3);
    }

    public static boolean contains(long[] jArr, long j) {
        for (long j2 : jArr) {
            if (j2 == j) {
                return true;
            }
        }
        return false;
    }

    public static int d(long[] jArr, long j, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (jArr[i3] == j) {
                return i3;
            }
        }
        return -1;
    }

    public static long[] ensureCapacity(long[] jArr, int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        com.google.common.base.Preconditions.checkArgument(i2 >= 0, "Invalid padding: %s", i2);
        return jArr.length < i ? java.util.Arrays.copyOf(jArr, i + i2) : jArr;
    }

    public static long fromByteArray(byte[] bArr) {
        com.google.common.base.Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((b2 & 255) << 48) | ((b & 255) << 56) | ((b3 & 255) << 40) | ((b4 & 255) << 32) | ((b5 & 255) << 24) | ((b6 & 255) << 16) | ((b7 & 255) << 8) | (b8 & 255);
    }

    public static int hashCode(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int indexOf(long[] jArr, long j) {
        return c(jArr, j, 0, jArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOf(long[] jArr, long[] jArr2) {
        com.google.common.base.Preconditions.checkNotNull(jArr, "array");
        com.google.common.base.Preconditions.checkNotNull(jArr2, com.umeng.ccg.a.A);
        if (jArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (jArr.length - jArr2.length) + 1) {
            for (int i2 = 0; i2 < jArr2.length; i2++) {
                if (jArr[i + i2] != jArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    public static java.lang.String join(java.lang.String str, long... jArr) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            sb.append(str);
            sb.append(jArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return d(jArr, j, 0, jArr.length);
    }

    public static java.util.Comparator<long[]> lexicographicalComparator() {
        return com.google.common.primitives.Longs.LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        com.google.common.base.Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    public static long min(long... jArr) {
        com.google.common.base.Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 < j) {
                j = j2;
            }
        }
        return j;
    }

    public static void reverse(long[] jArr) {
        com.google.common.base.Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void reverse(long[] jArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(jArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, jArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            long j = jArr[i];
            jArr[i] = jArr[i3];
            jArr[i3] = j;
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
        java.util.Arrays.sort(jArr, i, i2);
        reverse(jArr, i, i2);
    }

    @com.google.common.annotations.Beta
    public static com.google.common.base.Converter<java.lang.String, java.lang.Long> stringConverter() {
        return com.google.common.primitives.Longs.LongConverter.INSTANCE;
    }

    public static long[] toArray(java.util.Collection<? extends java.lang.Number> collection) {
        if (collection instanceof com.google.common.primitives.Longs.LongArrayAsList) {
            return ((com.google.common.primitives.Longs.LongArrayAsList) collection).toLongArray();
        }
        java.lang.Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = ((java.lang.Number) com.google.common.base.Preconditions.checkNotNull(array[i])).longValue();
        }
        return jArr;
    }

    public static byte[] toByteArray(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
        }
        return bArr;
    }

    @com.google.common.annotations.Beta
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.lang.Long tryParse(java.lang.String str) {
        return tryParse(str, 10);
    }

    @com.google.common.annotations.Beta
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.lang.Long tryParse(java.lang.String str, int i) {
        if (((java.lang.String) com.google.common.base.Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i < 2 || i > 36) {
            throw new java.lang.IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i);
        }
        int i2 = str.charAt(0) == '-' ? 1 : 0;
        if (i2 == str.length()) {
            return null;
        }
        int i3 = i2 + 1;
        int a = com.google.common.primitives.Longs.AsciiDigits.a(str.charAt(i2));
        if (a < 0 || a >= i) {
            return null;
        }
        long j = -a;
        long j2 = i;
        long j3 = Long.MIN_VALUE / j2;
        while (i3 < str.length()) {
            int i4 = i3 + 1;
            int a2 = com.google.common.primitives.Longs.AsciiDigits.a(str.charAt(i3));
            if (a2 < 0 || a2 >= i || j < j3) {
                return null;
            }
            long j4 = j * j2;
            long j5 = a2;
            if (j4 < j5 - Long.MIN_VALUE) {
                return null;
            }
            j = j4 - j5;
            i3 = i4;
        }
        if (i2 != 0) {
            return java.lang.Long.valueOf(j);
        }
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return java.lang.Long.valueOf(-j);
    }
}
