package com.google.common.primitives;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Floats {
    public static final int BYTES = 4;

    @com.google.common.annotations.GwtCompatible
    public static class FloatArrayAsList extends java.util.AbstractList<java.lang.Float> implements java.util.RandomAccess, java.io.Serializable {
        private static final long serialVersionUID = 0;
        final float[] array;
        final int end;
        final int start;

        public FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        public FloatArrayAsList(float[] fArr, int i, int i2) {
            this.array = fArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(java.lang.Object obj) {
            return (obj instanceof java.lang.Float) && com.google.common.primitives.Floats.c(this.array, ((java.lang.Float) obj).floatValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof com.google.common.primitives.Floats.FloatArrayAsList)) {
                return super.equals(obj);
            }
            com.google.common.primitives.Floats.FloatArrayAsList floatArrayAsList = (com.google.common.primitives.Floats.FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != floatArrayAsList.array[floatArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Float get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return java.lang.Float.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + com.google.common.primitives.Floats.hashCode(this.array[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(java.lang.Object obj) {
            int c;
            if (!(obj instanceof java.lang.Float) || (c = com.google.common.primitives.Floats.c(this.array, ((java.lang.Float) obj).floatValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof java.lang.Float) || (d = com.google.common.primitives.Floats.d(this.array, ((java.lang.Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return d - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Float set(int i, java.lang.Float f) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            float[] fArr = this.array;
            int i2 = this.start;
            float f2 = fArr[i2 + i];
            fArr[i2 + i] = ((java.lang.Float) com.google.common.base.Preconditions.checkNotNull(f)).floatValue();
            return java.lang.Float.valueOf(f2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.List<java.lang.Float> subList(int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return java.util.Collections.emptyList();
            }
            float[] fArr = this.array;
            int i3 = this.start;
            return new com.google.common.primitives.Floats.FloatArrayAsList(fArr, i + i3, i3 + i2);
        }

        public float[] toFloatArray() {
            return java.util.Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(size() * 12);
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

    public static final class FloatConverter extends com.google.common.base.Converter<java.lang.String, java.lang.Float> implements java.io.Serializable {
        static final com.google.common.primitives.Floats.FloatConverter INSTANCE = new com.google.common.primitives.Floats.FloatConverter();
        private static final long serialVersionUID = 1;

        private FloatConverter() {
        }

        private java.lang.Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public java.lang.String doBackward(java.lang.Float f) {
            return f.toString();
        }

        @Override // com.google.common.base.Converter
        public java.lang.Float doForward(java.lang.String str) {
            return java.lang.Float.valueOf(str);
        }

        public java.lang.String toString() {
            return "Floats.stringConverter()";
        }
    }

    public enum LexicographicalComparator implements java.util.Comparator<float[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            int min = java.lang.Math.min(fArr.length, fArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = java.lang.Float.compare(fArr[i], fArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }

        @Override // java.lang.Enum
        public java.lang.String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    public static java.util.List<java.lang.Float> asList(float... fArr) {
        return fArr.length == 0 ? java.util.Collections.emptyList() : new com.google.common.primitives.Floats.FloatArrayAsList(fArr);
    }

    public static int c(float[] fArr, float f, int i, int i2) {
        while (i < i2) {
            if (fArr[i] == f) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int compare(float f, float f2) {
        return java.lang.Float.compare(f, f2);
    }

    public static float[] concat(float[]... fArr) {
        int i = 0;
        for (float[] fArr2 : fArr) {
            i += fArr2.length;
        }
        float[] fArr3 = new float[i];
        int i2 = 0;
        for (float[] fArr4 : fArr) {
            java.lang.System.arraycopy(fArr4, 0, fArr3, i2, fArr4.length);
            i2 += fArr4.length;
        }
        return fArr3;
    }

    @com.google.common.annotations.Beta
    public static float constrainToRange(float f, float f2, float f3) {
        com.google.common.base.Preconditions.checkArgument(f2 <= f3, "min (%s) must be less than or equal to max (%s)", java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3));
        return java.lang.Math.min(java.lang.Math.max(f, f2), f3);
    }

    public static boolean contains(float[] fArr, float f) {
        for (float f2 : fArr) {
            if (f2 == f) {
                return true;
            }
        }
        return false;
    }

    public static int d(float[] fArr, float f, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (fArr[i3] == f) {
                return i3;
            }
        }
        return -1;
    }

    public static float[] ensureCapacity(float[] fArr, int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        com.google.common.base.Preconditions.checkArgument(i2 >= 0, "Invalid padding: %s", i2);
        return fArr.length < i ? java.util.Arrays.copyOf(fArr, i + i2) : fArr;
    }

    public static int hashCode(float f) {
        return java.lang.Float.valueOf(f).hashCode();
    }

    public static int indexOf(float[] fArr, float f) {
        return c(fArr, f, 0, fArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int indexOf(float[] fArr, float[] fArr2) {
        com.google.common.base.Preconditions.checkNotNull(fArr, "array");
        com.google.common.base.Preconditions.checkNotNull(fArr2, com.umeng.ccg.a.A);
        if (fArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (fArr.length - fArr2.length) + 1) {
            for (int i2 = 0; i2 < fArr2.length; i2++) {
                if (fArr[i + i2] != fArr2[i2]) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    public static boolean isFinite(float f) {
        return Float.NEGATIVE_INFINITY < f && f < Float.POSITIVE_INFINITY;
    }

    public static java.lang.String join(java.lang.String str, float... fArr) {
        com.google.common.base.Preconditions.checkNotNull(str);
        if (fArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i = 1; i < fArr.length; i++) {
            sb.append(str);
            sb.append(fArr[i]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(float[] fArr, float f) {
        return d(fArr, f, 0, fArr.length);
    }

    public static java.util.Comparator<float[]> lexicographicalComparator() {
        return com.google.common.primitives.Floats.LexicographicalComparator.INSTANCE;
    }

    public static float max(float... fArr) {
        com.google.common.base.Preconditions.checkArgument(fArr.length > 0);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = java.lang.Math.max(f, fArr[i]);
        }
        return f;
    }

    public static float min(float... fArr) {
        com.google.common.base.Preconditions.checkArgument(fArr.length > 0);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = java.lang.Math.min(f, fArr[i]);
        }
        return f;
    }

    public static void reverse(float[] fArr) {
        com.google.common.base.Preconditions.checkNotNull(fArr);
        reverse(fArr, 0, fArr.length);
    }

    public static void reverse(float[] fArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(fArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, fArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            float f = fArr[i];
            fArr[i] = fArr[i3];
            fArr[i3] = f;
            i++;
        }
    }

    public static void sortDescending(float[] fArr) {
        com.google.common.base.Preconditions.checkNotNull(fArr);
        sortDescending(fArr, 0, fArr.length);
    }

    public static void sortDescending(float[] fArr, int i, int i2) {
        com.google.common.base.Preconditions.checkNotNull(fArr);
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, fArr.length);
        java.util.Arrays.sort(fArr, i, i2);
        reverse(fArr, i, i2);
    }

    @com.google.common.annotations.Beta
    public static com.google.common.base.Converter<java.lang.String, java.lang.Float> stringConverter() {
        return com.google.common.primitives.Floats.FloatConverter.INSTANCE;
    }

    public static float[] toArray(java.util.Collection<? extends java.lang.Number> collection) {
        if (collection instanceof com.google.common.primitives.Floats.FloatArrayAsList) {
            return ((com.google.common.primitives.Floats.FloatArrayAsList) collection).toFloatArray();
        }
        java.lang.Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = ((java.lang.Number) com.google.common.base.Preconditions.checkNotNull(array[i])).floatValue();
        }
        return fArr;
    }

    @com.google.common.annotations.Beta
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.common.annotations.GwtIncompatible
    public static java.lang.Float tryParse(java.lang.String str) {
        if (!com.google.common.primitives.Doubles.a.matcher(str).matches()) {
            return null;
        }
        try {
            return java.lang.Float.valueOf(java.lang.Float.parseFloat(str));
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }
}
