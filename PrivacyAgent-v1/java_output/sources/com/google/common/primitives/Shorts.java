package com.google.common.primitives;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    public enum LexicographicalComparator implements java.util.Comparator<short[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(short[] sArr, short[] sArr2) {
            int min = java.lang.Math.min(sArr.length, sArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = com.google.common.primitives.Shorts.compare(sArr[i], sArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return sArr.length - sArr2.length;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    @com.google.common.annotations.GwtCompatible
    public static class ShortArrayAsList extends java.util.AbstractList<java.lang.Short> implements java.util.RandomAccess, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        public ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        public ShortArrayAsList(short[] sArr, int i, int i2) {
            this.array = sArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return (obj instanceof java.lang.Short) && com.google.common.primitives.Shorts.c(this.array, ((java.lang.Short) obj).shortValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.primitives.Shorts.ShortArrayAsList)) {
                return super.equals(obj);
            }
            com.google.common.primitives.Shorts.ShortArrayAsList shortArrayAsList = (com.google.common.primitives.Shorts.ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != shortArrayAsList.array[shortArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Short get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return java.lang.Short.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + com.google.common.primitives.Shorts.hashCode(this.array[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int c;
            if (!(obj instanceof java.lang.Short) || (c = com.google.common.primitives.Shorts.c(this.array, ((java.lang.Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return c - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int d;
            if (!(obj instanceof java.lang.Short) || (d = com.google.common.primitives.Shorts.d(this.array, ((java.lang.Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return d - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Short set(int i, java.lang.Short sh) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            short[] sArr = this.array;
            int i2 = this.start;
            short s2 = sArr[i2 + i];
            sArr[i2 + i] = ((java.lang.Short) com.google.common.base.Preconditions.checkNotNull(sh)).shortValue();
            return java.lang.Short.valueOf(s2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.List<java.lang.Short> subList(int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return java.util.Collections.emptyList();
            }
            short[] sArr = this.array;
            int i3 = this.start;
            return new com.google.common.primitives.Shorts.ShortArrayAsList(sArr, i + i3, i3 + i2);
        }

        public short[] toShortArray() {
            return java.util.Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(size() * 6);
            sb.append('[');
            sb.append((int) this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.array[i]);
            }
        }
    }

    public static final class ShortConverter extends com.google.common.base.Converter<java.lang.String, java.lang.Short> implements java.io.Serializable {
        static final com.google.common.primitives.Shorts.ShortConverter INSTANCE = new com.google.common.primitives.Shorts.ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public java.lang.String doBackward(java.lang.Short sh) {
            return sh.toString();
        }

        @Override // com.google.common.base.Converter
        public java.lang.Short doForward(java.lang.String str) {
            return java.lang.Short.decode(str);
        }

        public java.lang.String toString() {
            return "Shorts.stringConverter()";
        }
    }

    public static java.util.List<java.lang.Short> asList(short... sArr) {
        return sArr.length == 0 ? java.util.Collections.emptyList() : new com.google.common.primitives.Shorts.ShortArrayAsList(sArr);
    }

    public static int c(short[] sArr, short s2, int i, int i2) {
        while (i < i2) {
            if (sArr[i] == s2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static short checkedCast(long j) {
        short s2 = (short) j;
        com.google.common.base.Preconditions.checkArgument(((long) s2) == j, "Out of range: %s", j);
        return s2;
    }

    public static int compare(short s2, short s3) {
        return s2 - s3;
    }

    public static short[] concat(short[]... sArr) {
        int i = 0;
        for (short[] sArr2 : sArr) {
            i += sArr2.length;
        }
        short[] sArr3 = new short[i];
        int i2 = 0;
        for (short[] sArr4 : sArr) {
            java.lang.System.arraycopy(sArr4, 0, sArr3, i2, sArr4.length);
            i2 += sArr4.length;
        }
        return sArr3;
    }

    @com.google.common.annotations.Beta
    public static short constrainToRange(short s2, short s3, short s4) {
        com.google.common.base.Preconditions.checkArgument(s3 <= s4, "min (%s) must be less than or equal to max (%s)", (int) s3, (int) s4);
        return s2 < s3 ? s3 : s2 < s4 ? s2 : s4;
    }

    public static boolean contains(short[] sArr, short s2) {
        for (short s3 : sArr) {
            if (s3 == s2) {
                return true;
            }
        }
        return false;
    }

    public static int d(short[] sArr, short s2, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (sArr[i3] == s2) {
                return i3;
            }
        }
        return -1;
    }

    public static short[] ensureCapacity(short[] sArr, int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        com.google.common.base.Preconditions.checkArgument(i2 >= 0, "Invalid padding: %s", i2);
        return sArr.length < i ? java.util.Arrays.copyOf(sArr, i + i2) : sArr;
    }

    @com.google.common.annotations.GwtIncompatible
    public static short fromByteArray(byte[] bArr) {
        com.google.common.base.Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @com.google.common.annotations.GwtIncompatible
    public static short fromBytes(byte b, byte b2) {
        return (short) ((b << 8) | (b2 & 255));
    }

    public static int hashCode(short s2) {
        return s2;
    }

    public static int indexOf(short[] sArr, short s2) {
        return c(sArr, s2, 0, sArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOf(short[] sArr, short[] sArr2) {
        com.google.common.base.Preconditions.checkNotNull(sArr, "array");
        com.google.common.base.Preconditions.checkNotNull(sArr2, com.umeng.ccg.a.A);
        if (sArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (sArr.length - sArr2.length) + 1) {
            for (int i2 = 0; i2 < sArr2.length; i2++) {
                if (sArr[i + i2] != sArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    public static java.lang.String join(java.lang.String str, short... sArr) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(sArr.length * 6);
        sb.append((int) sArr[0]);
        for (int i = 1; i < sArr.length; i++) {
            sb.append(str);
            sb.append((int) sArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(short[] sArr, short s2) {
        return d(sArr, s2, 0, sArr.length);
    }

    public static java.util.Comparator<short[]> lexicographicalComparator() {
        return com.google.common.primitives.Shorts.LexicographicalComparator.INSTANCE;
    }

    public static short max(short... sArr) {
        com.google.common.base.Preconditions.checkArgument(sArr.length > 0);
        short s2 = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s3 = sArr[i];
            if (s3 > s2) {
                s2 = s3;
            }
        }
        return s2;
    }

    public static short min(short... sArr) {
        com.google.common.base.Preconditions.checkArgument(sArr.length > 0);
        short s2 = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s3 = sArr[i];
            if (s3 < s2) {
                s2 = s3;
            }
        }
        return s2;
    }

    public static void reverse(short[] sArr) {
        com.google.common.base.Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static void reverse(short[] sArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(sArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, sArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            short s2 = sArr[i];
            sArr[i] = sArr[i3];
            sArr[i3] = s2;
            i++;
        }
    }

    public static short saturatedCast(long j) {
        return j > 32767 ? kotlin.jvm.internal.ShortCompanionObject.MAX_VALUE : j < -32768 ? kotlin.jvm.internal.ShortCompanionObject.MIN_VALUE : (short) j;
    }

    public static void sortDescending(short[] sArr) {
        com.google.common.base.Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    public static void sortDescending(short[] sArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(sArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, sArr.length);
        java.util.Arrays.sort(sArr, i, i2);
        reverse(sArr, i, i2);
    }

    @com.google.common.annotations.Beta
    public static com.google.common.base.Converter<java.lang.String, java.lang.Short> stringConverter() {
        return com.google.common.primitives.Shorts.ShortConverter.INSTANCE;
    }

    public static short[] toArray(java.util.Collection<? extends java.lang.Number> collection) {
        if (collection instanceof com.google.common.primitives.Shorts.ShortArrayAsList) {
            return ((com.google.common.primitives.Shorts.ShortArrayAsList) collection).toShortArray();
        }
        java.lang.Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = ((java.lang.Number) com.google.common.base.Preconditions.checkNotNull(array[i])).shortValue();
        }
        return sArr;
    }

    @com.google.common.annotations.GwtIncompatible
    public static byte[] toByteArray(short s2) {
        return new byte[]{(byte) (s2 >> 8), (byte) s2};
    }
}
