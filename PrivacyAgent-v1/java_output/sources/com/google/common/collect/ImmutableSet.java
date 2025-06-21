package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public abstract class ImmutableSet<E> extends com.google.common.collect.ImmutableCollection<E> implements java.util.Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    @com.google.j2objc.annotations.RetainedWith
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.errorprone.annotations.concurrent.LazyInit
    private transient com.google.common.collect.ImmutableList<E> asList;

    public static class Builder<E> extends com.google.common.collect.ImmutableCollection.ArrayBasedBuilder<E> {

        @com.google.common.annotations.VisibleForTesting
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public java.lang.Object[] d;
        public int e;

        public Builder() {
            super(4);
        }

        public Builder(int i) {
            super(i);
            this.d = new java.lang.Object[com.google.common.collect.ImmutableSet.chooseTableSize(i)];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.ArrayBasedBuilder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableSet.Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.Builder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableSet.Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSet.Builder<E> add(E e) {
            com.google.common.base.Preconditions.checkNotNull(e);
            if (this.d != null && com.google.common.collect.ImmutableSet.chooseTableSize(this.b) <= this.d.length) {
                c(e);
                return this;
            }
            this.d = null;
            super.add((com.google.common.collect.ImmutableSet.Builder<E>) e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSet.Builder<E> add(E... eArr) {
            if (this.d != null) {
                for (E e : eArr) {
                    add((com.google.common.collect.ImmutableSet.Builder<E>) e);
                }
            } else {
                super.add((java.lang.Object[]) eArr);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSet.Builder<E> addAll(java.lang.Iterable<? extends E> iterable) {
            com.google.common.base.Preconditions.checkNotNull(iterable);
            if (this.d != null) {
                java.util.Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    add((com.google.common.collect.ImmutableSet.Builder<E>) it.next());
                }
            } else {
                super.addAll((java.lang.Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSet.Builder<E> addAll(java.util.Iterator<? extends E> it) {
            com.google.common.base.Preconditions.checkNotNull(it);
            while (it.hasNext()) {
                add((com.google.common.collect.ImmutableSet.Builder<E>) it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public com.google.common.collect.ImmutableSet<E> build() {
            com.google.common.collect.ImmutableSet<E> construct;
            int i = this.b;
            if (i == 0) {
                return com.google.common.collect.ImmutableSet.of();
            }
            if (i == 1) {
                return com.google.common.collect.ImmutableSet.of(this.a[0]);
            }
            if (this.d == null || com.google.common.collect.ImmutableSet.chooseTableSize(i) != this.d.length) {
                construct = com.google.common.collect.ImmutableSet.construct(this.b, this.a);
                this.b = construct.size();
            } else {
                java.lang.Object[] copyOf = com.google.common.collect.ImmutableSet.shouldTrim(this.b, this.a.length) ? java.util.Arrays.copyOf(this.a, this.b) : this.a;
                construct = new com.google.common.collect.RegularImmutableSet<>(copyOf, this.e, this.d, r5.length - 1, this.b);
            }
            this.c = true;
            this.d = null;
            return construct;
        }

        public final void c(E e) {
            int length = this.d.length - 1;
            int hashCode = e.hashCode();
            int c = com.google.common.collect.Hashing.c(hashCode);
            while (true) {
                int i = c & length;
                java.lang.Object[] objArr = this.d;
                java.lang.Object obj = objArr[i];
                if (obj == null) {
                    objArr[i] = e;
                    this.e += hashCode;
                    super.add((com.google.common.collect.ImmutableSet.Builder<E>) e);
                    return;
                } else if (obj.equals(e)) {
                    return;
                } else {
                    c = i + 1;
                }
            }
        }
    }

    public static class SerializedForm implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.lang.Object[] elements;

        public SerializedForm(java.lang.Object[] objArr) {
            this.elements = objArr;
        }

        public java.lang.Object readResolve() {
            return com.google.common.collect.ImmutableSet.copyOf(this.elements);
        }
    }

    public static <E> com.google.common.collect.ImmutableSet.Builder<E> builder() {
        return new com.google.common.collect.ImmutableSet.Builder<>();
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.ImmutableSet.Builder<E> builderWithExpectedSize(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "expectedSize");
        return new com.google.common.collect.ImmutableSet.Builder<>(i);
    }

    @com.google.common.annotations.VisibleForTesting
    static int chooseTableSize(int i) {
        int max = java.lang.Math.max(i, 2);
        if (max >= CUTOFF) {
            com.google.common.base.Preconditions.checkArgument(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = java.lang.Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> com.google.common.collect.ImmutableSet<E> construct(int i, java.lang.Object... objArr) {
        if (i == 0) {
            return of();
        }
        if (i == 1) {
            return of(objArr[0]);
        }
        int chooseTableSize = chooseTableSize(i);
        java.lang.Object[] objArr2 = new java.lang.Object[chooseTableSize];
        int i2 = chooseTableSize - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            java.lang.Object a = com.google.common.collect.ObjectArrays.a(objArr[i5], i5);
            int hashCode = a.hashCode();
            int c = com.google.common.collect.Hashing.c(hashCode);
            while (true) {
                int i6 = c & i2;
                java.lang.Object obj = objArr2[i6];
                if (obj == null) {
                    objArr[i4] = a;
                    objArr2[i6] = a;
                    i3 += hashCode;
                    i4++;
                    break;
                }
                if (obj.equals(a)) {
                    break;
                }
                c++;
            }
        }
        java.util.Arrays.fill(objArr, i4, i, (java.lang.Object) null);
        if (i4 == 1) {
            return new com.google.common.collect.SingletonImmutableSet(objArr[0], i3);
        }
        if (chooseTableSize(i4) < chooseTableSize / 2) {
            return construct(i4, objArr);
        }
        if (shouldTrim(i4, objArr.length)) {
            objArr = java.util.Arrays.copyOf(objArr, i4);
        }
        return new com.google.common.collect.RegularImmutableSet(objArr, i3, objArr2, i2, i4);
    }

    public static <E> com.google.common.collect.ImmutableSet<E> copyOf(java.lang.Iterable<? extends E> iterable) {
        return iterable instanceof java.util.Collection ? copyOf((java.util.Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> com.google.common.collect.ImmutableSet<E> copyOf(java.util.Collection<? extends E> collection) {
        if ((collection instanceof com.google.common.collect.ImmutableSet) && !(collection instanceof java.util.SortedSet)) {
            com.google.common.collect.ImmutableSet<E> immutableSet = (com.google.common.collect.ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        java.lang.Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> com.google.common.collect.ImmutableSet<E> copyOf(java.util.Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        return !it.hasNext() ? of((java.lang.Object) next) : new com.google.common.collect.ImmutableSet.Builder().add((com.google.common.collect.ImmutableSet.Builder) next).addAll((java.util.Iterator) it).build();
    }

    public static <E> com.google.common.collect.ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        return length != 0 ? length != 1 ? construct(eArr.length, (java.lang.Object[]) eArr.clone()) : of((java.lang.Object) eArr[0]) : of();
    }

    public static <E> com.google.common.collect.ImmutableSet<E> of() {
        return com.google.common.collect.RegularImmutableSet.EMPTY;
    }

    public static <E> com.google.common.collect.ImmutableSet<E> of(E e) {
        return new com.google.common.collect.SingletonImmutableSet(e);
    }

    public static <E> com.google.common.collect.ImmutableSet<E> of(E e, E e2) {
        return construct(2, e, e2);
    }

    public static <E> com.google.common.collect.ImmutableSet<E> of(E e, E e2, E e3) {
        return construct(3, e, e2, e3);
    }

    public static <E> com.google.common.collect.ImmutableSet<E> of(E e, E e2, E e3, E e4) {
        return construct(4, e, e2, e3, e4);
    }

    public static <E> com.google.common.collect.ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(5, e, e2, e3, e4, e5);
    }

    @java.lang.SafeVarargs
    public static <E> com.google.common.collect.ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        com.google.common.base.Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        java.lang.Object[] objArr = new java.lang.Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        java.lang.System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public com.google.common.collect.ImmutableList<E> asList() {
        com.google.common.collect.ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        com.google.common.collect.ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    public com.google.common.collect.ImmutableList<E> createAsList() {
        return com.google.common.collect.ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof com.google.common.collect.ImmutableSet) && isHashCodeFast() && ((com.google.common.collect.ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return com.google.common.collect.Sets.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return com.google.common.collect.Sets.b(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract com.google.common.collect.UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableSet.SerializedForm(toArray());
    }
}
