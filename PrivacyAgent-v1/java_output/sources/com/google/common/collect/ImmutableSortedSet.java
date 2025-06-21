package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public abstract class ImmutableSortedSet<E> extends com.google.common.collect.ImmutableSortedSetFauxverideShim<E> implements java.util.NavigableSet<E>, com.google.common.collect.SortedIterable<E> {
    final transient java.util.Comparator<? super E> comparator;

    @com.google.common.annotations.GwtIncompatible
    @com.google.errorprone.annotations.concurrent.LazyInit
    transient com.google.common.collect.ImmutableSortedSet<E> descendingSet;

    public static final class Builder<E> extends com.google.common.collect.ImmutableSet.Builder<E> {
        public final java.util.Comparator<? super E> f;

        public Builder(java.util.Comparator<? super E> comparator) {
            this.f = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.ArrayBasedBuilder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableSortedSet.Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.Builder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableSortedSet.Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableSet.Builder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableSortedSet.Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedSet.Builder<E> add(E e) {
            super.add((com.google.common.collect.ImmutableSortedSet.Builder<E>) e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedSet.Builder<E> add(E... eArr) {
            super.add((java.lang.Object[]) eArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedSet.Builder<E> addAll(java.lang.Iterable<? extends E> iterable) {
            super.addAll((java.lang.Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedSet.Builder<E> addAll(java.util.Iterator<? extends E> it) {
            super.addAll((java.util.Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public com.google.common.collect.ImmutableSortedSet<E> build() {
            com.google.common.collect.ImmutableSortedSet<E> construct = com.google.common.collect.ImmutableSortedSet.construct(this.f, this.b, this.a);
            this.b = construct.size();
            this.c = true;
            return construct;
        }
    }

    public static class SerializedForm<E> implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        final java.util.Comparator<? super E> comparator;
        final java.lang.Object[] elements;

        public SerializedForm(java.util.Comparator<? super E> comparator, java.lang.Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public java.lang.Object readResolve() {
            return new com.google.common.collect.ImmutableSortedSet.Builder(this.comparator).add(this.elements).build();
        }
    }

    public ImmutableSortedSet(java.util.Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> com.google.common.collect.ImmutableSortedSet<E> construct(java.util.Comparator<? super E> comparator, int i, E... eArr) {
        if (i == 0) {
            return emptySet(comparator);
        }
        com.google.common.collect.ObjectArrays.c(eArr, i);
        java.util.Arrays.sort(eArr, 0, i, comparator);
        int i2 = 1;
        for (int i3 = 1; i3 < i; i3++) {
            defpackage.a aVar = (java.lang.Object) eArr[i3];
            if (comparator.compare(aVar, (java.lang.Object) eArr[i2 - 1]) != 0) {
                eArr[i2] = aVar;
                i2++;
            }
        }
        java.util.Arrays.fill(eArr, i2, i, (java.lang.Object) null);
        if (i2 < eArr.length / 2) {
            eArr = (E[]) java.util.Arrays.copyOf(eArr, i2);
        }
        return new com.google.common.collect.RegularImmutableSortedSet(com.google.common.collect.ImmutableList.asImmutableList(eArr, i2), comparator);
    }

    public static <E> com.google.common.collect.ImmutableSortedSet<E> copyOf(java.lang.Iterable<? extends E> iterable) {
        return copyOf(com.google.common.collect.Ordering.natural(), iterable);
    }

    public static <E> com.google.common.collect.ImmutableSortedSet<E> copyOf(java.util.Collection<? extends E> collection) {
        return copyOf((java.util.Comparator) com.google.common.collect.Ordering.natural(), (java.util.Collection) collection);
    }

    public static <E> com.google.common.collect.ImmutableSortedSet<E> copyOf(java.util.Comparator<? super E> comparator, java.lang.Iterable<? extends E> iterable) {
        com.google.common.base.Preconditions.checkNotNull(comparator);
        if (com.google.common.collect.SortedIterables.b(comparator, iterable) && (iterable instanceof com.google.common.collect.ImmutableSortedSet)) {
            com.google.common.collect.ImmutableSortedSet<E> immutableSortedSet = (com.google.common.collect.ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        java.lang.Object[] f = com.google.common.collect.Iterables.f(iterable);
        return construct(comparator, f.length, f);
    }

    public static <E> com.google.common.collect.ImmutableSortedSet<E> copyOf(java.util.Comparator<? super E> comparator, java.util.Collection<? extends E> collection) {
        return copyOf((java.util.Comparator) comparator, (java.lang.Iterable) collection);
    }

    public static <E> com.google.common.collect.ImmutableSortedSet<E> copyOf(java.util.Comparator<? super E> comparator, java.util.Iterator<? extends E> it) {
        return new com.google.common.collect.ImmutableSortedSet.Builder(comparator).addAll((java.util.Iterator) it).build();
    }

    public static <E> com.google.common.collect.ImmutableSortedSet<E> copyOf(java.util.Iterator<? extends E> it) {
        return copyOf(com.google.common.collect.Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static com.google.common.collect.ImmutableSortedSet copyOf(java.lang.Comparable[] comparableArr) {
        return construct(com.google.common.collect.Ordering.natural(), comparableArr.length, (java.lang.Object[]) comparableArr.clone());
    }

    public static <E> com.google.common.collect.ImmutableSortedSet<E> copyOfSorted(java.util.SortedSet<E> sortedSet) {
        java.util.Comparator a = com.google.common.collect.SortedIterables.a(sortedSet);
        com.google.common.collect.ImmutableList copyOf = com.google.common.collect.ImmutableList.copyOf((java.util.Collection) sortedSet);
        return copyOf.isEmpty() ? emptySet(a) : new com.google.common.collect.RegularImmutableSortedSet(copyOf, a);
    }

    public static <E> com.google.common.collect.RegularImmutableSortedSet<E> emptySet(java.util.Comparator<? super E> comparator) {
        return com.google.common.collect.Ordering.natural().equals(comparator) ? (com.google.common.collect.RegularImmutableSortedSet<E>) com.google.common.collect.RegularImmutableSortedSet.NATURAL_EMPTY_SET : new com.google.common.collect.RegularImmutableSortedSet<>(com.google.common.collect.ImmutableList.of(), comparator);
    }

    public static <E extends java.lang.Comparable<?>> com.google.common.collect.ImmutableSortedSet.Builder<E> naturalOrder() {
        return new com.google.common.collect.ImmutableSortedSet.Builder<>(com.google.common.collect.Ordering.natural());
    }

    public static <E> com.google.common.collect.ImmutableSortedSet<E> of() {
        return com.google.common.collect.RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static com.google.common.collect.ImmutableSortedSet of(java.lang.Comparable comparable) {
        return new com.google.common.collect.RegularImmutableSortedSet(com.google.common.collect.ImmutableList.of(comparable), com.google.common.collect.Ordering.natural());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static com.google.common.collect.ImmutableSortedSet of(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
        return construct(com.google.common.collect.Ordering.natural(), 2, comparable, comparable2);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static com.google.common.collect.ImmutableSortedSet of(java.lang.Comparable comparable, java.lang.Comparable comparable2, java.lang.Comparable comparable3) {
        return construct(com.google.common.collect.Ordering.natural(), 3, comparable, comparable2, comparable3);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static com.google.common.collect.ImmutableSortedSet of(java.lang.Comparable comparable, java.lang.Comparable comparable2, java.lang.Comparable comparable3, java.lang.Comparable comparable4) {
        return construct(com.google.common.collect.Ordering.natural(), 4, comparable, comparable2, comparable3, comparable4);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static com.google.common.collect.ImmutableSortedSet of(java.lang.Comparable comparable, java.lang.Comparable comparable2, java.lang.Comparable comparable3, java.lang.Comparable comparable4, java.lang.Comparable comparable5) {
        return construct(com.google.common.collect.Ordering.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static com.google.common.collect.ImmutableSortedSet of(java.lang.Comparable comparable, java.lang.Comparable comparable2, java.lang.Comparable comparable3, java.lang.Comparable comparable4, java.lang.Comparable comparable5, java.lang.Comparable comparable6, java.lang.Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        java.lang.Comparable[] comparableArr2 = new java.lang.Comparable[length];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        java.lang.System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return construct(com.google.common.collect.Ordering.natural(), length, comparableArr2);
    }

    public static <E> com.google.common.collect.ImmutableSortedSet.Builder<E> orderedBy(java.util.Comparator<E> comparator) {
        return new com.google.common.collect.ImmutableSortedSet.Builder<>(comparator);
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.InvalidObjectException {
        throw new java.io.InvalidObjectException("Use SerializedForm");
    }

    public static <E extends java.lang.Comparable<?>> com.google.common.collect.ImmutableSortedSet.Builder<E> reverseOrder() {
        return new com.google.common.collect.ImmutableSortedSet.Builder<>(java.util.Collections.reverseOrder());
    }

    public static int unsafeCompare(java.util.Comparator<?> comparator, java.lang.Object obj, java.lang.Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @com.google.common.annotations.GwtIncompatible
    public E ceiling(E e) {
        return (E) com.google.common.collect.Iterables.getFirst(tailSet((com.google.common.collect.ImmutableSortedSet<E>) e, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.SortedIterable
    public java.util.Comparator<? super E> comparator() {
        return this.comparator;
    }

    @com.google.common.annotations.GwtIncompatible
    public abstract com.google.common.collect.ImmutableSortedSet<E> createDescendingSet();

    @Override // java.util.NavigableSet
    @com.google.common.annotations.GwtIncompatible
    public abstract com.google.common.collect.UnmodifiableIterator<E> descendingIterator();

    @Override // java.util.NavigableSet
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ImmutableSortedSet<E> descendingSet() {
        com.google.common.collect.ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        com.google.common.collect.ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    public E first() {
        return iterator().next();
    }

    @com.google.common.annotations.GwtIncompatible
    public E floor(E e) {
        return (E) com.google.common.collect.Iterators.getNext(headSet((com.google.common.collect.ImmutableSortedSet<E>) e, true).descendingIterator(), null);
    }

    public com.google.common.collect.ImmutableSortedSet<E> headSet(E e) {
        return headSet((com.google.common.collect.ImmutableSortedSet<E>) e, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ImmutableSortedSet<E> headSet(E e, boolean z) {
        return headSetImpl(com.google.common.base.Preconditions.checkNotNull(e), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    public /* bridge */ /* synthetic */ java.util.NavigableSet headSet(java.lang.Object obj, boolean z) {
        return headSet((com.google.common.collect.ImmutableSortedSet<E>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ java.util.SortedSet headSet(java.lang.Object obj) {
        return headSet((com.google.common.collect.ImmutableSortedSet<E>) obj);
    }

    public abstract com.google.common.collect.ImmutableSortedSet<E> headSetImpl(E e, boolean z);

    @com.google.common.annotations.GwtIncompatible
    public E higher(E e) {
        return (E) com.google.common.collect.Iterables.getFirst(tailSet((com.google.common.collect.ImmutableSortedSet<E>) e, false), null);
    }

    public abstract int indexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract com.google.common.collect.UnmodifiableIterator<E> iterator();

    public E last() {
        return descendingIterator().next();
    }

    @com.google.common.annotations.GwtIncompatible
    public E lower(E e) {
        return (E) com.google.common.collect.Iterators.getNext(headSet((com.google.common.collect.ImmutableSortedSet<E>) e, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public final E pollFirst() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.GwtIncompatible
    @java.lang.Deprecated
    public final E pollLast() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public com.google.common.collect.ImmutableSortedSet<E> subSet(E e, E e2) {
        return subSet((boolean) e, true, (boolean) e2, false);
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ImmutableSortedSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        com.google.common.base.Preconditions.checkNotNull(e);
        com.google.common.base.Preconditions.checkNotNull(e2);
        com.google.common.base.Preconditions.checkArgument(this.comparator.compare(e, e2) <= 0);
        return subSetImpl(e, z, e2, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    public /* bridge */ /* synthetic */ java.util.NavigableSet subSet(java.lang.Object obj, boolean z, java.lang.Object obj2, boolean z2) {
        return subSet((boolean) obj, z, (boolean) obj2, z2);
    }

    public abstract com.google.common.collect.ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2);

    public com.google.common.collect.ImmutableSortedSet<E> tailSet(E e) {
        return tailSet((com.google.common.collect.ImmutableSortedSet<E>) e, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    public com.google.common.collect.ImmutableSortedSet<E> tailSet(E e, boolean z) {
        return tailSetImpl(com.google.common.base.Preconditions.checkNotNull(e), z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.google.common.annotations.GwtIncompatible
    public /* bridge */ /* synthetic */ java.util.NavigableSet tailSet(java.lang.Object obj, boolean z) {
        return tailSet((com.google.common.collect.ImmutableSortedSet<E>) obj, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ java.util.SortedSet tailSet(java.lang.Object obj) {
        return tailSet((com.google.common.collect.ImmutableSortedSet<E>) obj);
    }

    public abstract com.google.common.collect.ImmutableSortedSet<E> tailSetImpl(E e, boolean z);

    public int unsafeCompare(java.lang.Object obj, java.lang.Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableSortedSet.SerializedForm(this.comparator, toArray());
    }
}
