package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class ImmutableCollection<E> extends java.util.AbstractCollection<E> implements java.io.Serializable {
    private static final java.lang.Object[] EMPTY_ARRAY = new java.lang.Object[0];

    public static abstract class ArrayBasedBuilder<E> extends com.google.common.collect.ImmutableCollection.Builder<E> {
        public java.lang.Object[] a;
        public int b;
        public boolean c;

        public ArrayBasedBuilder(int i) {
            com.google.common.collect.CollectPreconditions.b(i, "initialCapacity");
            this.a = new java.lang.Object[i];
            this.b = 0;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableCollection.ArrayBasedBuilder<E> add(E e) {
            com.google.common.base.Preconditions.checkNotNull(e);
            b(this.b + 1);
            java.lang.Object[] objArr = this.a;
            int i = this.b;
            this.b = i + 1;
            objArr[i] = e;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.Builder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableCollection.ArrayBasedBuilder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableCollection.Builder<E> add(E... eArr) {
            com.google.common.collect.ObjectArrays.b(eArr);
            b(this.b + eArr.length);
            java.lang.System.arraycopy(eArr, 0, this.a, this.b, eArr.length);
            this.b += eArr.length;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableCollection.Builder<E> addAll(java.lang.Iterable<? extends E> iterable) {
            if (iterable instanceof java.util.Collection) {
                java.util.Collection collection = (java.util.Collection) iterable;
                b(this.b + collection.size());
                if (collection instanceof com.google.common.collect.ImmutableCollection) {
                    this.b = ((com.google.common.collect.ImmutableCollection) collection).copyIntoArray(this.a, this.b);
                    return this;
                }
            }
            super.addAll(iterable);
            return this;
        }

        public final void b(int i) {
            java.lang.Object[] objArr = this.a;
            if (objArr.length < i) {
                this.a = java.util.Arrays.copyOf(objArr, com.google.common.collect.ImmutableCollection.Builder.a(objArr.length, i));
                this.c = false;
            } else if (this.c) {
                this.a = (java.lang.Object[]) objArr.clone();
                this.c = false;
            }
        }
    }

    public static abstract class Builder<E> {
        public static int a(int i, int i2) {
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

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public abstract com.google.common.collect.ImmutableCollection.Builder<E> add(E e);

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableCollection.Builder<E> add(E... eArr) {
            for (E e : eArr) {
                add((com.google.common.collect.ImmutableCollection.Builder<E>) e);
            }
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableCollection.Builder<E> addAll(java.lang.Iterable<? extends E> iterable) {
            java.util.Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                add((com.google.common.collect.ImmutableCollection.Builder<E>) it.next());
            }
            return this;
        }

        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableCollection.Builder<E> addAll(java.util.Iterator<? extends E> it) {
            while (it.hasNext()) {
                add((com.google.common.collect.ImmutableCollection.Builder<E>) it.next());
            }
            return this;
        }

        public abstract com.google.common.collect.ImmutableCollection<E> build();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final boolean add(E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final boolean addAll(java.util.Collection<? extends E> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    public com.google.common.collect.ImmutableList<E> asList() {
        return isEmpty() ? com.google.common.collect.ImmutableList.of() : com.google.common.collect.ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @java.lang.Deprecated
    public final void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int copyIntoArray(java.lang.Object[] objArr, int i) {
        com.google.common.collect.UnmodifiableIterator<E> it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    public java.lang.Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new java.lang.UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new java.lang.UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract com.google.common.collect.UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final boolean remove(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final boolean removeAll(java.util.Collection<?> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final boolean retainAll(java.util.Collection<?> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final java.lang.Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.Preconditions.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            java.lang.Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) com.google.common.collect.Platform.a(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) com.google.common.collect.ObjectArrays.newArray(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableList.SerializedForm(toArray());
    }
}
