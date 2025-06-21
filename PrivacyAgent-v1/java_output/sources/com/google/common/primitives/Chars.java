package com.google.common.primitives;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Chars {
    public static final int BYTES = 2;

    @com.google.common.annotations.GwtCompatible
    public static class CharArrayAsList extends java.util.AbstractList<java.lang.Character> implements java.util.RandomAccess, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        public CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        public CharArrayAsList(char[] cArr, int i, int i2) {
            this.array = cArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(java.lang.Object obj) {
            return (obj instanceof java.lang.Character) && com.google.common.primitives.Chars.c(this.array, ((java.lang.Character) obj).charValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.primitives.Chars.CharArrayAsList)) {
                return super.equals(obj);
            }
            com.google.common.primitives.Chars.CharArrayAsList charArrayAsList = (com.google.common.primitives.Chars.CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != charArrayAsList.array[charArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Character get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return java.lang.Character.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + com.google.common.primitives.Chars.hashCode(this.array[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(java.lang.Object obj) {
            int c;
            if (!(obj instanceof java.lang.Character) || (c = com.google.common.primitives.Chars.c(this.array, ((java.lang.Character) obj).charValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof java.lang.Character) || (d = com.google.common.primitives.Chars.d(this.array, ((java.lang.Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return d - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Character set(int i, java.lang.Character ch) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            char[] cArr = this.array;
            int i2 = this.start;
            char c = cArr[i2 + i];
            cArr[i2 + i] = ((java.lang.Character) com.google.common.base.Preconditions.checkNotNull(ch)).charValue();
            return java.lang.Character.valueOf(c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.List<java.lang.Character> subList(int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return java.util.Collections.emptyList();
            }
            char[] cArr = this.array;
            int i3 = this.start;
            return new com.google.common.primitives.Chars.CharArrayAsList(cArr, i + i3, i3 + i2);
        }

        public char[] toCharArray() {
            return java.util.Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(size() * 3);
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

    public enum LexicographicalComparator implements java.util.Comparator<char[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(char[] cArr, char[] cArr2) {
            int min = java.lang.Math.min(cArr.length, cArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = com.google.common.primitives.Chars.compare(cArr[i], cArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return cArr.length - cArr2.length;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Chars.lexicographicalComparator()";
        }
    }

    public static java.util.List<java.lang.Character> asList(char... cArr) {
        return cArr.length == 0 ? java.util.Collections.emptyList() : new com.google.common.primitives.Chars.CharArrayAsList(cArr);
    }

    public static int c(char[] cArr, char c, int i, int i2) {
        while (i < i2) {
            if (cArr[i] == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static char checkedCast(long j) {
        char c = (char) j;
        com.google.common.base.Preconditions.checkArgument(((long) c) == j, "Out of range: %s", j);
        return c;
    }

    public static int compare(char c, char c2) {
        return c - c2;
    }

    public static char[] concat(char[]... cArr) {
        int i = 0;
        for (char[] cArr2 : cArr) {
            i += cArr2.length;
        }
        char[] cArr3 = new char[i];
        int i2 = 0;
        for (char[] cArr4 : cArr) {
            java.lang.System.arraycopy(cArr4, 0, cArr3, i2, cArr4.length);
            i2 += cArr4.length;
        }
        return cArr3;
    }

    @com.google.common.annotations.Beta
    public static char constrainToRange(char c, char c2, char c3) {
        com.google.common.base.Preconditions.checkArgument(c2 <= c3, "min (%s) must be less than or equal to max (%s)", c2, c3);
        return c < c2 ? c2 : c < c3 ? c : c3;
    }

    public static boolean contains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static int d(char[] cArr, char c, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (cArr[i3] == c) {
                return i3;
            }
        }
        return -1;
    }

    public static char[] ensureCapacity(char[] cArr, int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        com.google.common.base.Preconditions.checkArgument(i2 >= 0, "Invalid padding: %s", i2);
        return cArr.length < i ? java.util.Arrays.copyOf(cArr, i + i2) : cArr;
    }

    @com.google.common.annotations.GwtIncompatible
    public static char fromByteArray(byte[] bArr) {
        com.google.common.base.Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @com.google.common.annotations.GwtIncompatible
    public static char fromBytes(byte b, byte b2) {
        return (char) ((b << 8) | (b2 & 255));
    }

    public static int hashCode(char c) {
        return c;
    }

    public static int indexOf(char[] cArr, char c) {
        return c(cArr, c, 0, cArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOf(char[] cArr, char[] cArr2) {
        com.google.common.base.Preconditions.checkNotNull(cArr, "array");
        com.google.common.base.Preconditions.checkNotNull(cArr2, com.umeng.ccg.a.A);
        if (cArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (cArr.length - cArr2.length) + 1) {
            for (int i2 = 0; i2 < cArr2.length; i2++) {
                if (cArr[i + i2] != cArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    public static java.lang.String join(java.lang.String str, char... cArr) {
        com.google.common.base.Preconditions.checkNotNull(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder((str.length() * (length - 1)) + length);
        sb.append(cArr[0]);
        for (int i = 1; i < length; i++) {
            sb.append(str);
            sb.append(cArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(char[] cArr, char c) {
        return d(cArr, c, 0, cArr.length);
    }

    public static java.util.Comparator<char[]> lexicographicalComparator() {
        return com.google.common.primitives.Chars.LexicographicalComparator.INSTANCE;
    }

    public static char max(char... cArr) {
        com.google.common.base.Preconditions.checkArgument(cArr.length > 0);
        char c = cArr[0];
        for (int i = 1; i < cArr.length; i++) {
            char c2 = cArr[i];
            if (c2 > c) {
                c = c2;
            }
        }
        return c;
    }

    public static char min(char... cArr) {
        com.google.common.base.Preconditions.checkArgument(cArr.length > 0);
        char c = cArr[0];
        for (int i = 1; i < cArr.length; i++) {
            char c2 = cArr[i];
            if (c2 < c) {
                c = c2;
            }
        }
        return c;
    }

    public static void reverse(char[] cArr) {
        com.google.common.base.Preconditions.checkNotNull(cArr);
        reverse(cArr, 0, cArr.length);
    }

    public static void reverse(char[] cArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(cArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, cArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            char c = cArr[i];
            cArr[i] = cArr[i3];
            cArr[i3] = c;
            i++;
        }
    }

    public static char saturatedCast(long j) {
        if (j > 65535) {
            return kotlin.jvm.internal.CharCompanionObject.MAX_VALUE;
        }
        if (j < 0) {
            return (char) 0;
        }
        return (char) j;
    }

    public static void sortDescending(char[] cArr) {
        com.google.common.base.Preconditions.checkNotNull(cArr);
        sortDescending(cArr, 0, cArr.length);
    }

    public static void sortDescending(char[] cArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(cArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, cArr.length);
        java.util.Arrays.sort(cArr, i, i2);
        reverse(cArr, i, i2);
    }

    public static char[] toArray(java.util.Collection<java.lang.Character> collection) {
        if (collection instanceof com.google.common.primitives.Chars.CharArrayAsList) {
            return ((com.google.common.primitives.Chars.CharArrayAsList) collection).toCharArray();
        }
        java.lang.Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = ((java.lang.Character) com.google.common.base.Preconditions.checkNotNull(array[i])).charValue();
        }
        return cArr;
    }

    @com.google.common.annotations.GwtIncompatible
    public static byte[] toByteArray(char c) {
        return new byte[]{(byte) (c >> '\b'), (byte) c};
    }
}
