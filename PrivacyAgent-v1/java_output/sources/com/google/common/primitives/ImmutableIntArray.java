package com.google.common.primitives;

@com.google.errorprone.annotations.Immutable
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class ImmutableIntArray implements java.io.Serializable {
    private static final com.google.common.primitives.ImmutableIntArray EMPTY = new com.google.common.primitives.ImmutableIntArray(new int[0]);
    private final int[] array;
    private final int end;
    private final transient int start;

    public static class AsList extends java.util.AbstractList<java.lang.Integer> implements java.util.RandomAccess, java.io.Serializable {
        private final com.google.common.primitives.ImmutableIntArray parent;

        private AsList(com.google.common.primitives.ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        public /* synthetic */ AsList(com.google.common.primitives.ImmutableIntArray immutableIntArray, com.google.common.primitives.ImmutableIntArray.AnonymousClass1 anonymousClass1) {
            this(immutableIntArray);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(java.lang.Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.primitives.ImmutableIntArray.AsList) {
                return this.parent.equals(((com.google.common.primitives.ImmutableIntArray.AsList) obj).parent);
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
                if (obj2 instanceof java.lang.Integer) {
                    int i2 = i + 1;
                    if (this.parent.array[i] == ((java.lang.Integer) obj2).intValue()) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Integer get(int i) {
            return java.lang.Integer.valueOf(this.parent.get(i));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(java.lang.Object obj) {
            if (obj instanceof java.lang.Integer) {
                return this.parent.indexOf(((java.lang.Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(java.lang.Object obj) {
            if (obj instanceof java.lang.Integer) {
                return this.parent.lastIndexOf(((java.lang.Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.List<java.lang.Integer> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            return this.parent.toString();
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static final class Builder {
        public int[] a;
        public int b = 0;

        public Builder(int i) {
            this.a = new int[i];
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
            int[] iArr = this.a;
            if (i2 > iArr.length) {
                int[] iArr2 = new int[b(iArr.length, i2)];
                java.lang.System.arraycopy(this.a, 0, iArr2, 0, this.b);
                this.a = iArr2;
            }
        }

        public com.google.common.primitives.ImmutableIntArray.Builder add(int i) {
            a(1);
            int[] iArr = this.a;
            int i2 = this.b;
            iArr[i2] = i;
            this.b = i2 + 1;
            return this;
        }

        public com.google.common.primitives.ImmutableIntArray.Builder addAll(com.google.common.primitives.ImmutableIntArray immutableIntArray) {
            a(immutableIntArray.length());
            java.lang.System.arraycopy(immutableIntArray.array, immutableIntArray.start, this.a, this.b, immutableIntArray.length());
            this.b += immutableIntArray.length();
            return this;
        }

        public com.google.common.primitives.ImmutableIntArray.Builder addAll(java.lang.Iterable<java.lang.Integer> iterable) {
            if (iterable instanceof java.util.Collection) {
                return addAll((java.util.Collection<java.lang.Integer>) iterable);
            }
            java.util.Iterator<java.lang.Integer> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().intValue());
            }
            return this;
        }

        public com.google.common.primitives.ImmutableIntArray.Builder addAll(java.util.Collection<java.lang.Integer> collection) {
            a(collection.size());
            for (java.lang.Integer num : collection) {
                int[] iArr = this.a;
                int i = this.b;
                this.b = i + 1;
                iArr[i] = num.intValue();
            }
            return this;
        }

        public com.google.common.primitives.ImmutableIntArray.Builder addAll(int[] iArr) {
            a(iArr.length);
            java.lang.System.arraycopy(iArr, 0, this.a, this.b, iArr.length);
            this.b += iArr.length;
            return this;
        }

        @com.google.errorprone.annotations.CheckReturnValue
        public com.google.common.primitives.ImmutableIntArray build() {
            return this.b == 0 ? com.google.common.primitives.ImmutableIntArray.EMPTY : new com.google.common.primitives.ImmutableIntArray(this.a, 0, this.b, null);
        }
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    private ImmutableIntArray(int[] iArr, int i, int i2) {
        this.array = iArr;
        this.start = i;
        this.end = i2;
    }

    public /* synthetic */ ImmutableIntArray(int[] iArr, int i, int i2, com.google.common.primitives.ImmutableIntArray.AnonymousClass1 anonymousClass1) {
        this(iArr, i, i2);
    }

    public static com.google.common.primitives.ImmutableIntArray.Builder builder() {
        return new com.google.common.primitives.ImmutableIntArray.Builder(10);
    }

    public static com.google.common.primitives.ImmutableIntArray.Builder builder(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new com.google.common.primitives.ImmutableIntArray.Builder(i);
    }

    public static com.google.common.primitives.ImmutableIntArray copyOf(java.lang.Iterable<java.lang.Integer> iterable) {
        return iterable instanceof java.util.Collection ? copyOf((java.util.Collection<java.lang.Integer>) iterable) : builder().addAll(iterable).build();
    }

    public static com.google.common.primitives.ImmutableIntArray copyOf(java.util.Collection<java.lang.Integer> collection) {
        return collection.isEmpty() ? EMPTY : new com.google.common.primitives.ImmutableIntArray(com.google.common.primitives.Ints.toArray(collection));
    }

    public static com.google.common.primitives.ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new com.google.common.primitives.ImmutableIntArray(java.util.Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static com.google.common.primitives.ImmutableIntArray of() {
        return EMPTY;
    }

    public static com.google.common.primitives.ImmutableIntArray of(int i) {
        return new com.google.common.primitives.ImmutableIntArray(new int[]{i});
    }

    public static com.google.common.primitives.ImmutableIntArray of(int i, int i2) {
        return new com.google.common.primitives.ImmutableIntArray(new int[]{i, i2});
    }

    public static com.google.common.primitives.ImmutableIntArray of(int i, int i2, int i3) {
        return new com.google.common.primitives.ImmutableIntArray(new int[]{i, i2, i3});
    }

    public static com.google.common.primitives.ImmutableIntArray of(int i, int i2, int i3, int i4) {
        return new com.google.common.primitives.ImmutableIntArray(new int[]{i, i2, i3, i4});
    }

    public static com.google.common.primitives.ImmutableIntArray of(int i, int i2, int i3, int i4, int i5) {
        return new com.google.common.primitives.ImmutableIntArray(new int[]{i, i2, i3, i4, i5});
    }

    public static com.google.common.primitives.ImmutableIntArray of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new com.google.common.primitives.ImmutableIntArray(new int[]{i, i2, i3, i4, i5, i6});
    }

    public static com.google.common.primitives.ImmutableIntArray of(int i, int... iArr) {
        com.google.common.base.Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i;
        java.lang.System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new com.google.common.primitives.ImmutableIntArray(iArr2);
    }

    public java.util.List<java.lang.Integer> asList() {
        return new com.google.common.primitives.ImmutableIntArray.AsList(this, null);
    }

    public boolean contains(int i) {
        return indexOf(i) >= 0;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.primitives.ImmutableIntArray)) {
            return false;
        }
        com.google.common.primitives.ImmutableIntArray immutableIntArray = (com.google.common.primitives.ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableIntArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i) {
        com.google.common.base.Preconditions.checkElementIndex(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + com.google.common.primitives.Ints.hashCode(this.array[i2]);
        }
        return i;
    }

    public int indexOf(int i) {
        for (int i2 = this.start; i2 < this.end; i2++) {
            if (this.array[i2] == i) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i) {
        int i2;
        int i3 = this.end;
        do {
            i3--;
            i2 = this.start;
            if (i3 < i2) {
                return -1;
            }
        } while (this.array[i3] != i);
        return i3 - i2;
    }

    public int length() {
        return this.end - this.start;
    }

    public java.lang.Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public com.google.common.primitives.ImmutableIntArray subArray(int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i3 = this.start;
        return new com.google.common.primitives.ImmutableIntArray(iArr, i + i3, i3 + i2);
    }

    public int[] toArray() {
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

    public com.google.common.primitives.ImmutableIntArray trimmed() {
        return isPartialView() ? new com.google.common.primitives.ImmutableIntArray(toArray()) : this;
    }

    public java.lang.Object writeReplace() {
        return trimmed();
    }
}
