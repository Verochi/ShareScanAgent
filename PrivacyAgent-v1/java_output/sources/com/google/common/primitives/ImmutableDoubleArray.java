package com.google.common.primitives;

@com.google.errorprone.annotations.Immutable
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class ImmutableDoubleArray implements java.io.Serializable {
    private static final com.google.common.primitives.ImmutableDoubleArray EMPTY = new com.google.common.primitives.ImmutableDoubleArray(new double[0]);
    private final double[] array;
    private final int end;
    private final transient int start;

    public static class AsList extends java.util.AbstractList<java.lang.Double> implements java.util.RandomAccess, java.io.Serializable {
        private final com.google.common.primitives.ImmutableDoubleArray parent;

        private AsList(com.google.common.primitives.ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }

        public /* synthetic */ AsList(com.google.common.primitives.ImmutableDoubleArray immutableDoubleArray, com.google.common.primitives.ImmutableDoubleArray.AnonymousClass1 anonymousClass1) {
            this(immutableDoubleArray);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(java.lang.Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.primitives.ImmutableDoubleArray.AsList) {
                return this.parent.equals(((com.google.common.primitives.ImmutableDoubleArray.AsList) obj).parent);
            }
            if (!(obj instanceof java.util.List)) {
                return false;
            }
            java.util.List list = (java.util.List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i = this.parent.start;
            for (java.lang.Object obj2 : list) {
                if (obj2 instanceof java.lang.Double) {
                    int i2 = i + 1;
                    if (com.google.common.primitives.ImmutableDoubleArray.areEqual(this.parent.array[i], ((java.lang.Double) obj2).doubleValue())) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Double get(int i) {
            return java.lang.Double.valueOf(this.parent.get(i));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(java.lang.Object obj) {
            if (obj instanceof java.lang.Double) {
                return this.parent.indexOf(((java.lang.Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(java.lang.Object obj) {
            if (obj instanceof java.lang.Double) {
                return this.parent.lastIndexOf(((java.lang.Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.List<java.lang.Double> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            return this.parent.toString();
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static final class Builder {
        public double[] a;
        public int b = 0;

        public Builder(int i) {
            this.a = new double[i];
        }

        public static int b(int i, int i2) {
            if (i2 < 0) {
                throw new java.lang.AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = i + (i >> 1) + 1;
            if (i3 < i2) {
                i3 = java.lang.Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        public final void a(int i) {
            int i2 = this.b + i;
            double[] dArr = this.a;
            if (i2 > dArr.length) {
                double[] dArr2 = new double[b(dArr.length, i2)];
                java.lang.System.arraycopy(this.a, 0, dArr2, 0, this.b);
                this.a = dArr2;
            }
        }

        public com.google.common.primitives.ImmutableDoubleArray.Builder add(double d) {
            a(1);
            double[] dArr = this.a;
            int i = this.b;
            dArr[i] = d;
            this.b = i + 1;
            return this;
        }

        public com.google.common.primitives.ImmutableDoubleArray.Builder addAll(com.google.common.primitives.ImmutableDoubleArray immutableDoubleArray) {
            a(immutableDoubleArray.length());
            java.lang.System.arraycopy(immutableDoubleArray.array, immutableDoubleArray.start, this.a, this.b, immutableDoubleArray.length());
            this.b += immutableDoubleArray.length();
            return this;
        }

        public com.google.common.primitives.ImmutableDoubleArray.Builder addAll(java.lang.Iterable<java.lang.Double> iterable) {
            if (iterable instanceof java.util.Collection) {
                return addAll((java.util.Collection<java.lang.Double>) iterable);
            }
            java.util.Iterator<java.lang.Double> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().doubleValue());
            }
            return this;
        }

        public com.google.common.primitives.ImmutableDoubleArray.Builder addAll(java.util.Collection<java.lang.Double> collection) {
            a(collection.size());
            for (java.lang.Double d : collection) {
                double[] dArr = this.a;
                int i = this.b;
                this.b = i + 1;
                dArr[i] = d.doubleValue();
            }
            return this;
        }

        public com.google.common.primitives.ImmutableDoubleArray.Builder addAll(double[] dArr) {
            a(dArr.length);
            java.lang.System.arraycopy(dArr, 0, this.a, this.b, dArr.length);
            this.b += dArr.length;
            return this;
        }

        @com.google.errorprone.annotations.CheckReturnValue
        public com.google.common.primitives.ImmutableDoubleArray build() {
            return this.b == 0 ? com.google.common.primitives.ImmutableDoubleArray.EMPTY : new com.google.common.primitives.ImmutableDoubleArray(this.a, 0, this.b, null);
        }
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    private ImmutableDoubleArray(double[] dArr, int i, int i2) {
        this.array = dArr;
        this.start = i;
        this.end = i2;
    }

    public /* synthetic */ ImmutableDoubleArray(double[] dArr, int i, int i2, com.google.common.primitives.ImmutableDoubleArray.AnonymousClass1 anonymousClass1) {
        this(dArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean areEqual(double d, double d2) {
        return java.lang.Double.doubleToLongBits(d) == java.lang.Double.doubleToLongBits(d2);
    }

    public static com.google.common.primitives.ImmutableDoubleArray.Builder builder() {
        return new com.google.common.primitives.ImmutableDoubleArray.Builder(10);
    }

    public static com.google.common.primitives.ImmutableDoubleArray.Builder builder(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new com.google.common.primitives.ImmutableDoubleArray.Builder(i);
    }

    public static com.google.common.primitives.ImmutableDoubleArray copyOf(java.lang.Iterable<java.lang.Double> iterable) {
        return iterable instanceof java.util.Collection ? copyOf((java.util.Collection<java.lang.Double>) iterable) : builder().addAll(iterable).build();
    }

    public static com.google.common.primitives.ImmutableDoubleArray copyOf(java.util.Collection<java.lang.Double> collection) {
        return collection.isEmpty() ? EMPTY : new com.google.common.primitives.ImmutableDoubleArray(com.google.common.primitives.Doubles.toArray(collection));
    }

    public static com.google.common.primitives.ImmutableDoubleArray copyOf(double[] dArr) {
        return dArr.length == 0 ? EMPTY : new com.google.common.primitives.ImmutableDoubleArray(java.util.Arrays.copyOf(dArr, dArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static com.google.common.primitives.ImmutableDoubleArray of() {
        return EMPTY;
    }

    public static com.google.common.primitives.ImmutableDoubleArray of(double d) {
        return new com.google.common.primitives.ImmutableDoubleArray(new double[]{d});
    }

    public static com.google.common.primitives.ImmutableDoubleArray of(double d, double d2) {
        return new com.google.common.primitives.ImmutableDoubleArray(new double[]{d, d2});
    }

    public static com.google.common.primitives.ImmutableDoubleArray of(double d, double d2, double d3) {
        return new com.google.common.primitives.ImmutableDoubleArray(new double[]{d, d2, d3});
    }

    public static com.google.common.primitives.ImmutableDoubleArray of(double d, double d2, double d3, double d4) {
        return new com.google.common.primitives.ImmutableDoubleArray(new double[]{d, d2, d3, d4});
    }

    public static com.google.common.primitives.ImmutableDoubleArray of(double d, double d2, double d3, double d4, double d5) {
        return new com.google.common.primitives.ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5});
    }

    public static com.google.common.primitives.ImmutableDoubleArray of(double d, double d2, double d3, double d4, double d5, double d6) {
        return new com.google.common.primitives.ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5, d6});
    }

    public static com.google.common.primitives.ImmutableDoubleArray of(double d, double... dArr) {
        com.google.common.base.Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d;
        java.lang.System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new com.google.common.primitives.ImmutableDoubleArray(dArr2);
    }

    public java.util.List<java.lang.Double> asList() {
        return new com.google.common.primitives.ImmutableDoubleArray.AsList(this, null);
    }

    public boolean contains(double d) {
        return indexOf(d) >= 0;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.primitives.ImmutableDoubleArray)) {
            return false;
        }
        com.google.common.primitives.ImmutableDoubleArray immutableDoubleArray = (com.google.common.primitives.ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (!areEqual(get(i), immutableDoubleArray.get(i))) {
                return false;
            }
        }
        return true;
    }

    public double get(int i) {
        com.google.common.base.Preconditions.checkElementIndex(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + com.google.common.primitives.Doubles.hashCode(this.array[i2]);
        }
        return i;
    }

    public int indexOf(double d) {
        for (int i = this.start; i < this.end; i++) {
            if (areEqual(this.array[i], d)) {
                return i - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d) {
        int i = this.end;
        do {
            i--;
            if (i < this.start) {
                return -1;
            }
        } while (!areEqual(this.array[i], d));
        return i - this.start;
    }

    public int length() {
        return this.end - this.start;
    }

    public java.lang.Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public com.google.common.primitives.ImmutableDoubleArray subArray(int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i3 = this.start;
        return new com.google.common.primitives.ImmutableDoubleArray(dArr, i + i3, i3 + i2);
    }

    public double[] toArray() {
        return java.util.Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public java.lang.String toString() {
        if (isEmpty()) {
            return "[]";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length() * 5);
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

    public com.google.common.primitives.ImmutableDoubleArray trimmed() {
        return isPartialView() ? new com.google.common.primitives.ImmutableDoubleArray(toArray()) : this;
    }

    public java.lang.Object writeReplace() {
        return trimmed();
    }
}
