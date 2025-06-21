package com.google.common.primitives;

@com.google.errorprone.annotations.Immutable
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class ImmutableLongArray implements java.io.Serializable {
    private static final com.google.common.primitives.ImmutableLongArray EMPTY = new com.google.common.primitives.ImmutableLongArray(new long[0]);
    private final long[] array;
    private final int end;
    private final transient int start;

    public static class AsList extends java.util.AbstractList<java.lang.Long> implements java.util.RandomAccess, java.io.Serializable {
        private final com.google.common.primitives.ImmutableLongArray parent;

        private AsList(com.google.common.primitives.ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
        }

        public /* synthetic */ AsList(com.google.common.primitives.ImmutableLongArray immutableLongArray, com.google.common.primitives.ImmutableLongArray.AnonymousClass1 anonymousClass1) {
            this(immutableLongArray);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(java.lang.Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.primitives.ImmutableLongArray.AsList) {
                return this.parent.equals(((com.google.common.primitives.ImmutableLongArray.AsList) obj).parent);
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
                if (obj2 instanceof java.lang.Long) {
                    int i2 = i + 1;
                    if (this.parent.array[i] == ((java.lang.Long) obj2).longValue()) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public java.lang.Long get(int i) {
            return java.lang.Long.valueOf(this.parent.get(i));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(java.lang.Object obj) {
            if (obj instanceof java.lang.Long) {
                return this.parent.indexOf(((java.lang.Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(java.lang.Object obj) {
            if (obj instanceof java.lang.Long) {
                return this.parent.lastIndexOf(((java.lang.Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public java.util.List<java.lang.Long> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection
        public java.lang.String toString() {
            return this.parent.toString();
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static final class Builder {
        public long[] a;
        public int b = 0;

        public Builder(int i) {
            this.a = new long[i];
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
            long[] jArr = this.a;
            if (i2 > jArr.length) {
                long[] jArr2 = new long[b(jArr.length, i2)];
                java.lang.System.arraycopy(this.a, 0, jArr2, 0, this.b);
                this.a = jArr2;
            }
        }

        public com.google.common.primitives.ImmutableLongArray.Builder add(long j) {
            a(1);
            long[] jArr = this.a;
            int i = this.b;
            jArr[i] = j;
            this.b = i + 1;
            return this;
        }

        public com.google.common.primitives.ImmutableLongArray.Builder addAll(com.google.common.primitives.ImmutableLongArray immutableLongArray) {
            a(immutableLongArray.length());
            java.lang.System.arraycopy(immutableLongArray.array, immutableLongArray.start, this.a, this.b, immutableLongArray.length());
            this.b += immutableLongArray.length();
            return this;
        }

        public com.google.common.primitives.ImmutableLongArray.Builder addAll(java.lang.Iterable<java.lang.Long> iterable) {
            if (iterable instanceof java.util.Collection) {
                return addAll((java.util.Collection<java.lang.Long>) iterable);
            }
            java.util.Iterator<java.lang.Long> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().longValue());
            }
            return this;
        }

        public com.google.common.primitives.ImmutableLongArray.Builder addAll(java.util.Collection<java.lang.Long> collection) {
            a(collection.size());
            for (java.lang.Long l : collection) {
                long[] jArr = this.a;
                int i = this.b;
                this.b = i + 1;
                jArr[i] = l.longValue();
            }
            return this;
        }

        public com.google.common.primitives.ImmutableLongArray.Builder addAll(long[] jArr) {
            a(jArr.length);
            java.lang.System.arraycopy(jArr, 0, this.a, this.b, jArr.length);
            this.b += jArr.length;
            return this;
        }

        @com.google.errorprone.annotations.CheckReturnValue
        public com.google.common.primitives.ImmutableLongArray build() {
            return this.b == 0 ? com.google.common.primitives.ImmutableLongArray.EMPTY : new com.google.common.primitives.ImmutableLongArray(this.a, 0, this.b, null);
        }
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    private ImmutableLongArray(long[] jArr, int i, int i2) {
        this.array = jArr;
        this.start = i;
        this.end = i2;
    }

    public /* synthetic */ ImmutableLongArray(long[] jArr, int i, int i2, com.google.common.primitives.ImmutableLongArray.AnonymousClass1 anonymousClass1) {
        this(jArr, i, i2);
    }

    public static com.google.common.primitives.ImmutableLongArray.Builder builder() {
        return new com.google.common.primitives.ImmutableLongArray.Builder(10);
    }

    public static com.google.common.primitives.ImmutableLongArray.Builder builder(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new com.google.common.primitives.ImmutableLongArray.Builder(i);
    }

    public static com.google.common.primitives.ImmutableLongArray copyOf(java.lang.Iterable<java.lang.Long> iterable) {
        return iterable instanceof java.util.Collection ? copyOf((java.util.Collection<java.lang.Long>) iterable) : builder().addAll(iterable).build();
    }

    public static com.google.common.primitives.ImmutableLongArray copyOf(java.util.Collection<java.lang.Long> collection) {
        return collection.isEmpty() ? EMPTY : new com.google.common.primitives.ImmutableLongArray(com.google.common.primitives.Longs.toArray(collection));
    }

    public static com.google.common.primitives.ImmutableLongArray copyOf(long[] jArr) {
        return jArr.length == 0 ? EMPTY : new com.google.common.primitives.ImmutableLongArray(java.util.Arrays.copyOf(jArr, jArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static com.google.common.primitives.ImmutableLongArray of() {
        return EMPTY;
    }

    public static com.google.common.primitives.ImmutableLongArray of(long j) {
        return new com.google.common.primitives.ImmutableLongArray(new long[]{j});
    }

    public static com.google.common.primitives.ImmutableLongArray of(long j, long j2) {
        return new com.google.common.primitives.ImmutableLongArray(new long[]{j, j2});
    }

    public static com.google.common.primitives.ImmutableLongArray of(long j, long j2, long j3) {
        return new com.google.common.primitives.ImmutableLongArray(new long[]{j, j2, j3});
    }

    public static com.google.common.primitives.ImmutableLongArray of(long j, long j2, long j3, long j4) {
        return new com.google.common.primitives.ImmutableLongArray(new long[]{j, j2, j3, j4});
    }

    public static com.google.common.primitives.ImmutableLongArray of(long j, long j2, long j3, long j4, long j5) {
        return new com.google.common.primitives.ImmutableLongArray(new long[]{j, j2, j3, j4, j5});
    }

    public static com.google.common.primitives.ImmutableLongArray of(long j, long j2, long j3, long j4, long j5, long j6) {
        return new com.google.common.primitives.ImmutableLongArray(new long[]{j, j2, j3, j4, j5, j6});
    }

    public static com.google.common.primitives.ImmutableLongArray of(long j, long... jArr) {
        com.google.common.base.Preconditions.checkArgument(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j;
        java.lang.System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new com.google.common.primitives.ImmutableLongArray(jArr2);
    }

    public java.util.List<java.lang.Long> asList() {
        return new com.google.common.primitives.ImmutableLongArray.AsList(this, null);
    }

    public boolean contains(long j) {
        return indexOf(j) >= 0;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.common.primitives.ImmutableLongArray)) {
            return false;
        }
        com.google.common.primitives.ImmutableLongArray immutableLongArray = (com.google.common.primitives.ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableLongArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public long get(int i) {
        com.google.common.base.Preconditions.checkElementIndex(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + com.google.common.primitives.Longs.hashCode(this.array[i2]);
        }
        return i;
    }

    public int indexOf(long j) {
        for (int i = this.start; i < this.end; i++) {
            if (this.array[i] == j) {
                return i - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(long j) {
        int i;
        int i2 = this.end;
        do {
            i2--;
            i = this.start;
            if (i2 < i) {
                return -1;
            }
        } while (this.array[i2] != j);
        return i2 - i;
    }

    public int length() {
        return this.end - this.start;
    }

    public java.lang.Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public com.google.common.primitives.ImmutableLongArray subArray(int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        long[] jArr = this.array;
        int i3 = this.start;
        return new com.google.common.primitives.ImmutableLongArray(jArr, i + i3, i3 + i2);
    }

    public long[] toArray() {
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

    public com.google.common.primitives.ImmutableLongArray trimmed() {
        return isPartialView() ? new com.google.common.primitives.ImmutableLongArray(toArray()) : this;
    }

    public java.lang.Object writeReplace() {
        return trimmed();
    }
}
