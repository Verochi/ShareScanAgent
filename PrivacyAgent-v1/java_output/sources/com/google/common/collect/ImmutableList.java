package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public abstract class ImmutableList<E> extends com.google.common.collect.ImmutableCollection<E> implements java.util.List<E>, java.util.RandomAccess {
    private static final com.google.common.collect.UnmodifiableListIterator<java.lang.Object> EMPTY_ITR = new com.google.common.collect.ImmutableList.Itr(com.google.common.collect.RegularImmutableList.EMPTY, 0);

    public static final class Builder<E> extends com.google.common.collect.ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        public Builder(int i) {
            super(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.ArrayBasedBuilder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableList.Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.Builder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableList.Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableList.Builder<E> add(E e) {
            super.add((com.google.common.collect.ImmutableList.Builder<E>) e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableList.Builder<E> add(E... eArr) {
            super.add((java.lang.Object[]) eArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableList.Builder<E> addAll(java.lang.Iterable<? extends E> iterable) {
            super.addAll((java.lang.Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableList.Builder<E> addAll(java.util.Iterator<? extends E> it) {
            super.addAll((java.util.Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public com.google.common.collect.ImmutableList<E> build() {
            this.c = true;
            return com.google.common.collect.ImmutableList.asImmutableList(this.a, this.b);
        }
    }

    public static class Itr<E> extends com.google.common.collect.AbstractIndexedListIterator<E> {
        public final com.google.common.collect.ImmutableList<E> u;

        public Itr(com.google.common.collect.ImmutableList<E> immutableList, int i) {
            super(immutableList.size(), i);
            this.u = immutableList;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public E a(int i) {
            return this.u.get(i);
        }
    }

    public static class ReverseImmutableList<E> extends com.google.common.collect.ImmutableList<E> {
        private final transient com.google.common.collect.ImmutableList<E> forwardList;

        public ReverseImmutableList(com.google.common.collect.ImmutableList<E> immutableList) {
            this.forwardList = immutableList;
        }

        private int reverseIndex(int i) {
            return (size() - 1) - i;
        }

        private int reversePosition(int i) {
            return size() - i;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            return this.forwardList.contains(obj);
        }

        @Override // java.util.List
        public E get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, size());
            return this.forwardList.get(reverseIndex(i));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int lastIndexOf = this.forwardList.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return reverseIndex(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.forwardList.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ java.util.Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            int indexOf = this.forwardList.indexOf(obj);
            if (indexOf >= 0) {
                return reverseIndex(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ java.util.ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ java.util.ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        @Override // com.google.common.collect.ImmutableList
        public com.google.common.collect.ImmutableList<E> reverse() {
            return this.forwardList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public com.google.common.collect.ImmutableList<E> subList(int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, size());
            return this.forwardList.subList(reversePosition(i2), reversePosition(i)).reverse();
        }
    }

    public static class SerializedForm implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.lang.Object[] elements;

        public SerializedForm(java.lang.Object[] objArr) {
            this.elements = objArr;
        }

        public java.lang.Object readResolve() {
            return com.google.common.collect.ImmutableList.copyOf(this.elements);
        }
    }

    public class SubList extends com.google.common.collect.ImmutableList<E> {
        final transient int length;
        final transient int offset;

        public SubList(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        @Override // java.util.List
        public E get(int i) {
            com.google.common.base.Preconditions.checkElementIndex(i, this.length);
            return com.google.common.collect.ImmutableList.this.get(i + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public java.lang.Object[] internalArray() {
            return com.google.common.collect.ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayEnd() {
            return com.google.common.collect.ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayStart() {
            return com.google.common.collect.ImmutableList.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ java.util.Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ java.util.ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ java.util.ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public com.google.common.collect.ImmutableList<E> subList(int i, int i2) {
            com.google.common.base.Preconditions.checkPositionIndexes(i, i2, this.length);
            com.google.common.collect.ImmutableList immutableList = com.google.common.collect.ImmutableList.this;
            int i3 = this.offset;
            return immutableList.subList(i + i3, i2 + i3);
        }
    }

    public static <E> com.google.common.collect.ImmutableList<E> asImmutableList(java.lang.Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> com.google.common.collect.ImmutableList<E> asImmutableList(java.lang.Object[] objArr, int i) {
        return i == 0 ? of() : new com.google.common.collect.RegularImmutableList(objArr, i);
    }

    public static <E> com.google.common.collect.ImmutableList.Builder<E> builder() {
        return new com.google.common.collect.ImmutableList.Builder<>();
    }

    @com.google.common.annotations.Beta
    public static <E> com.google.common.collect.ImmutableList.Builder<E> builderWithExpectedSize(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "expectedSize");
        return new com.google.common.collect.ImmutableList.Builder<>(i);
    }

    private static <E> com.google.common.collect.ImmutableList<E> construct(java.lang.Object... objArr) {
        return asImmutableList(com.google.common.collect.ObjectArrays.b(objArr));
    }

    public static <E> com.google.common.collect.ImmutableList<E> copyOf(java.lang.Iterable<? extends E> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        return iterable instanceof java.util.Collection ? copyOf((java.util.Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> com.google.common.collect.ImmutableList<E> copyOf(java.util.Collection<? extends E> collection) {
        if (!(collection instanceof com.google.common.collect.ImmutableCollection)) {
            return construct(collection.toArray());
        }
        com.google.common.collect.ImmutableList<E> asList = ((com.google.common.collect.ImmutableCollection) collection).asList();
        return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
    }

    public static <E> com.google.common.collect.ImmutableList<E> copyOf(java.util.Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        return !it.hasNext() ? of((java.lang.Object) next) : new com.google.common.collect.ImmutableList.Builder().add((com.google.common.collect.ImmutableList.Builder) next).addAll((java.util.Iterator) it).build();
    }

    public static <E> com.google.common.collect.ImmutableList<E> copyOf(E[] eArr) {
        return eArr.length == 0 ? of() : construct((java.lang.Object[]) eArr.clone());
    }

    public static <E> com.google.common.collect.ImmutableList<E> of() {
        return (com.google.common.collect.ImmutableList<E>) com.google.common.collect.RegularImmutableList.EMPTY;
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e) {
        return construct(e);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2) {
        return construct(e, e2);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3) {
        return construct(e, e2, e3);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4) {
        return construct(e, e2, e3, e4);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(e, e2, e3, e4, e5);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6) {
        return construct(e, e2, e3, e4, e5, e6);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        return construct(e, e2, e3, e4, e5, e6, e7);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
    }

    @java.lang.SafeVarargs
    public static <E> com.google.common.collect.ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E... eArr) {
        com.google.common.base.Preconditions.checkArgument(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        java.lang.Object[] objArr = new java.lang.Object[eArr.length + 12];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        objArr[6] = e7;
        objArr[7] = e8;
        objArr[8] = e9;
        objArr[9] = e10;
        objArr[10] = e11;
        objArr[11] = e12;
        java.lang.System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return construct(objArr);
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.InvalidObjectException {
        throw new java.io.InvalidObjectException("Use SerializedForm");
    }

    public static <E extends java.lang.Comparable<? super E>> com.google.common.collect.ImmutableList<E> sortedCopyOf(java.lang.Iterable<? extends E> iterable) {
        java.lang.Comparable[] comparableArr = (java.lang.Comparable[]) com.google.common.collect.Iterables.g(iterable, new java.lang.Comparable[0]);
        com.google.common.collect.ObjectArrays.b(comparableArr);
        java.util.Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    public static <E> com.google.common.collect.ImmutableList<E> sortedCopyOf(java.util.Comparator<? super E> comparator, java.lang.Iterable<? extends E> iterable) {
        com.google.common.base.Preconditions.checkNotNull(comparator);
        java.lang.Object[] f = com.google.common.collect.Iterables.f(iterable);
        com.google.common.collect.ObjectArrays.b(f);
        java.util.Arrays.sort(f, comparator);
        return asImmutableList(f);
    }

    @Override // java.util.List
    @java.lang.Deprecated
    public final void add(int i, E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final boolean addAll(int i, java.util.Collection<? extends E> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final com.google.common.collect.ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(java.lang.Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Lists.d(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return -1;
        }
        return com.google.common.collect.Lists.f(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public com.google.common.collect.UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null) {
            return -1;
        }
        return com.google.common.collect.Lists.h(this, obj);
    }

    @Override // java.util.List
    public com.google.common.collect.UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public com.google.common.collect.UnmodifiableListIterator<E> listIterator(int i) {
        com.google.common.base.Preconditions.checkPositionIndex(i, size());
        return isEmpty() ? (com.google.common.collect.UnmodifiableListIterator<E>) EMPTY_ITR : new com.google.common.collect.ImmutableList.Itr(this, i);
    }

    @Override // java.util.List
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final E remove(int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    public com.google.common.collect.ImmutableList<E> reverse() {
        return size() <= 1 ? this : new com.google.common.collect.ImmutableList.ReverseImmutableList(this);
    }

    @Override // java.util.List
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final E set(int i, E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List
    public com.google.common.collect.ImmutableList<E> subList(int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? of() : subListUnchecked(i, i2);
    }

    public com.google.common.collect.ImmutableList<E> subListUnchecked(int i, int i2) {
        return new com.google.common.collect.ImmutableList.SubList(i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableList.SerializedForm(toArray());
    }
}
