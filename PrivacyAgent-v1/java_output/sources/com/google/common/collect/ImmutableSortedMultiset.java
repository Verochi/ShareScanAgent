package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ImmutableSortedMultiset<E> extends com.google.common.collect.ImmutableSortedMultisetFauxverideShim<E> implements com.google.common.collect.SortedMultiset<E> {

    @com.google.errorprone.annotations.concurrent.LazyInit
    transient com.google.common.collect.ImmutableSortedMultiset<E> descendingMultiset;

    public static class Builder<E> extends com.google.common.collect.ImmutableMultiset.Builder<E> {
        public final java.util.Comparator<? super E> d;

        @com.google.common.annotations.VisibleForTesting
        public E[] e;
        public int[] f;
        public int g;
        public boolean h;

        public Builder(java.util.Comparator<? super E> comparator) {
            super(true);
            this.d = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
            this.e = (E[]) new java.lang.Object[4];
            this.f = new int[4];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableCollection.Builder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableMultiset.Builder add(java.lang.Object obj) {
            return add((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMultiset.Builder<E> add(E e) {
            return addCopies((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) e, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMultiset.Builder<E> add(E... eArr) {
            for (E e : eArr) {
                add((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) e);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMultiset.Builder<E> addAll(java.lang.Iterable<? extends E> iterable) {
            if (iterable instanceof com.google.common.collect.Multiset) {
                for (com.google.common.collect.Multiset.Entry<E> entry : ((com.google.common.collect.Multiset) iterable).entrySet()) {
                    addCopies((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) entry.getElement(), entry.getCount());
                }
            } else {
                java.util.Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    add((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) it.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMultiset.Builder<E> addAll(java.util.Iterator<? extends E> it) {
            while (it.hasNext()) {
                add((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) it.next());
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableMultiset.Builder addCopies(java.lang.Object obj, int i) {
            return addCopies((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) obj, i);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMultiset.Builder<E> addCopies(E e, int i) {
            com.google.common.base.Preconditions.checkNotNull(e);
            com.google.common.collect.CollectPreconditions.b(i, "occurrences");
            if (i == 0) {
                return this;
            }
            e();
            E[] eArr = this.e;
            int i2 = this.g;
            eArr[i2] = e;
            this.f[i2] = i;
            this.g = i2 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public com.google.common.collect.ImmutableSortedMultiset<E> build() {
            d();
            int i = this.g;
            if (i == 0) {
                return com.google.common.collect.ImmutableSortedMultiset.emptyMultiset(this.d);
            }
            com.google.common.collect.RegularImmutableSortedSet regularImmutableSortedSet = (com.google.common.collect.RegularImmutableSortedSet) com.google.common.collect.ImmutableSortedSet.construct(this.d, i, this.e);
            long[] jArr = new long[this.g + 1];
            int i2 = 0;
            while (i2 < this.g) {
                int i3 = i2 + 1;
                jArr[i3] = jArr[i2] + this.f[i2];
                i2 = i3;
            }
            this.h = true;
            return new com.google.common.collect.RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.g);
        }

        public final void c(boolean z) {
            int i = this.g;
            if (i == 0) {
                return;
            }
            java.lang.Object[] objArr = (E[]) java.util.Arrays.copyOf(this.e, i);
            java.util.Arrays.sort(objArr, this.d);
            int i2 = 1;
            for (int i3 = 1; i3 < objArr.length; i3++) {
                if (this.d.compare((java.lang.Object) objArr[i2 - 1], (java.lang.Object) objArr[i3]) < 0) {
                    objArr[i2] = objArr[i3];
                    i2++;
                }
            }
            java.util.Arrays.fill(objArr, i2, this.g, (java.lang.Object) null);
            if (z) {
                int i4 = i2 * 4;
                int i5 = this.g;
                if (i4 > i5 * 3) {
                    objArr = (E[]) java.util.Arrays.copyOf(objArr, com.google.common.math.IntMath.saturatedAdd(i5, (i5 / 2) + 1));
                }
            }
            int[] iArr = new int[objArr.length];
            for (int i6 = 0; i6 < this.g; i6++) {
                int binarySearch = java.util.Arrays.binarySearch(objArr, 0, i2, this.e[i6], this.d);
                int i7 = this.f[i6];
                if (i7 >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + i7;
                } else {
                    iArr[binarySearch] = ~i7;
                }
            }
            this.e = (E[]) objArr;
            this.f = iArr;
            this.g = i2;
        }

        public final void d() {
            c(false);
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = this.g;
                if (i >= i3) {
                    java.util.Arrays.fill(this.e, i2, i3, (java.lang.Object) null);
                    java.util.Arrays.fill(this.f, i2, this.g, 0);
                    this.g = i2;
                    return;
                }
                int[] iArr = this.f;
                int i4 = iArr[i];
                if (i4 > 0) {
                    E[] eArr = this.e;
                    eArr[i2] = eArr[i];
                    iArr[i2] = i4;
                    i2++;
                }
                i++;
            }
        }

        public final void e() {
            int i = this.g;
            E[] eArr = this.e;
            if (i == eArr.length) {
                c(true);
            } else if (this.h) {
                this.e = (E[]) java.util.Arrays.copyOf(eArr, eArr.length);
            }
            this.h = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ com.google.common.collect.ImmutableMultiset.Builder setCount(java.lang.Object obj, int i) {
            return setCount((com.google.common.collect.ImmutableSortedMultiset.Builder<E>) obj, i);
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public com.google.common.collect.ImmutableSortedMultiset.Builder<E> setCount(E e, int i) {
            com.google.common.base.Preconditions.checkNotNull(e);
            com.google.common.collect.CollectPreconditions.b(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
            e();
            E[] eArr = this.e;
            int i2 = this.g;
            eArr[i2] = e;
            this.f[i2] = ~i;
            this.g = i2 + 1;
            return this;
        }
    }

    public static final class SerializedForm<E> implements java.io.Serializable {
        final java.util.Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public SerializedForm(com.google.common.collect.SortedMultiset<E> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = (E[]) new java.lang.Object[size];
            this.counts = new int[size];
            int i = 0;
            for (com.google.common.collect.Multiset.Entry<E> entry : sortedMultiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        public java.lang.Object readResolve() {
            int length = this.elements.length;
            com.google.common.collect.ImmutableSortedMultiset.Builder builder = new com.google.common.collect.ImmutableSortedMultiset.Builder(this.comparator);
            for (int i = 0; i < length; i++) {
                builder.addCopies((com.google.common.collect.ImmutableSortedMultiset.Builder) this.elements[i], this.counts[i]);
            }
            return builder.build();
        }
    }

    public static <E> com.google.common.collect.ImmutableSortedMultiset<E> copyOf(java.lang.Iterable<? extends E> iterable) {
        return copyOf(com.google.common.collect.Ordering.natural(), iterable);
    }

    public static <E> com.google.common.collect.ImmutableSortedMultiset<E> copyOf(java.util.Comparator<? super E> comparator, java.lang.Iterable<? extends E> iterable) {
        if (iterable instanceof com.google.common.collect.ImmutableSortedMultiset) {
            com.google.common.collect.ImmutableSortedMultiset<E> immutableSortedMultiset = (com.google.common.collect.ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new com.google.common.collect.ImmutableSortedMultiset.Builder(comparator).addAll((java.lang.Iterable) iterable).build();
    }

    public static <E> com.google.common.collect.ImmutableSortedMultiset<E> copyOf(java.util.Comparator<? super E> comparator, java.util.Iterator<? extends E> it) {
        com.google.common.base.Preconditions.checkNotNull(comparator);
        return new com.google.common.collect.ImmutableSortedMultiset.Builder(comparator).addAll((java.util.Iterator) it).build();
    }

    public static <E> com.google.common.collect.ImmutableSortedMultiset<E> copyOf(java.util.Iterator<? extends E> it) {
        return copyOf(com.google.common.collect.Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static com.google.common.collect.ImmutableSortedMultiset copyOf(java.lang.Comparable[] comparableArr) {
        return copyOf(com.google.common.collect.Ordering.natural(), java.util.Arrays.asList(comparableArr));
    }

    public static <E> com.google.common.collect.ImmutableSortedMultiset<E> copyOfSorted(com.google.common.collect.SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), com.google.common.collect.Lists.newArrayList(sortedMultiset.entrySet()));
    }

    private static <E> com.google.common.collect.ImmutableSortedMultiset<E> copyOfSortedEntries(java.util.Comparator<? super E> comparator, java.util.Collection<com.google.common.collect.Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(collection.size());
        long[] jArr = new long[collection.size() + 1];
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            builder.add((com.google.common.collect.ImmutableList.Builder) it.next().getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + r5.getCount();
            i = i2;
        }
        return new com.google.common.collect.RegularImmutableSortedMultiset(new com.google.common.collect.RegularImmutableSortedSet(builder.build(), comparator), jArr, 0, collection.size());
    }

    public static <E> com.google.common.collect.ImmutableSortedMultiset<E> emptyMultiset(java.util.Comparator<? super E> comparator) {
        return com.google.common.collect.Ordering.natural().equals(comparator) ? (com.google.common.collect.ImmutableSortedMultiset<E>) com.google.common.collect.RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new com.google.common.collect.RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends java.lang.Comparable<?>> com.google.common.collect.ImmutableSortedMultiset.Builder<E> naturalOrder() {
        return new com.google.common.collect.ImmutableSortedMultiset.Builder<>(com.google.common.collect.Ordering.natural());
    }

    public static <E> com.google.common.collect.ImmutableSortedMultiset<E> of() {
        return (com.google.common.collect.ImmutableSortedMultiset<E>) com.google.common.collect.RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static com.google.common.collect.ImmutableSortedMultiset of(java.lang.Comparable comparable) {
        return new com.google.common.collect.RegularImmutableSortedMultiset((com.google.common.collect.RegularImmutableSortedSet) com.google.common.collect.ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static com.google.common.collect.ImmutableSortedMultiset of(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
        return copyOf(com.google.common.collect.Ordering.natural(), java.util.Arrays.asList(comparable, comparable2));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static com.google.common.collect.ImmutableSortedMultiset of(java.lang.Comparable comparable, java.lang.Comparable comparable2, java.lang.Comparable comparable3) {
        return copyOf(com.google.common.collect.Ordering.natural(), java.util.Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static com.google.common.collect.ImmutableSortedMultiset of(java.lang.Comparable comparable, java.lang.Comparable comparable2, java.lang.Comparable comparable3, java.lang.Comparable comparable4) {
        return copyOf(com.google.common.collect.Ordering.natural(), java.util.Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static com.google.common.collect.ImmutableSortedMultiset of(java.lang.Comparable comparable, java.lang.Comparable comparable2, java.lang.Comparable comparable3, java.lang.Comparable comparable4, java.lang.Comparable comparable5) {
        return copyOf(com.google.common.collect.Ordering.natural(), java.util.Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static com.google.common.collect.ImmutableSortedMultiset of(java.lang.Comparable comparable, java.lang.Comparable comparable2, java.lang.Comparable comparable3, java.lang.Comparable comparable4, java.lang.Comparable comparable5, java.lang.Comparable comparable6, java.lang.Comparable... comparableArr) {
        java.util.ArrayList newArrayListWithCapacity = com.google.common.collect.Lists.newArrayListWithCapacity(comparableArr.length + 6);
        java.util.Collections.addAll(newArrayListWithCapacity, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        java.util.Collections.addAll(newArrayListWithCapacity, comparableArr);
        return copyOf(com.google.common.collect.Ordering.natural(), newArrayListWithCapacity);
    }

    public static <E> com.google.common.collect.ImmutableSortedMultiset.Builder<E> orderedBy(java.util.Comparator<E> comparator) {
        return new com.google.common.collect.ImmutableSortedMultiset.Builder<>(comparator);
    }

    public static <E extends java.lang.Comparable<?>> com.google.common.collect.ImmutableSortedMultiset.Builder<E> reverseOrder() {
        return new com.google.common.collect.ImmutableSortedMultiset.Builder<>(com.google.common.collect.Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final java.util.Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.ImmutableSortedMultiset<E> descendingMultiset() {
        com.google.common.collect.ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(com.google.common.collect.Ordering.from(comparator()).reverse()) : new com.google.common.collect.DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public abstract com.google.common.collect.ImmutableSortedSet<E> elementSet();

    public abstract com.google.common.collect.ImmutableSortedMultiset<E> headMultiset(E e, com.google.common.collect.BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset headMultiset(java.lang.Object obj, com.google.common.collect.BoundType boundType) {
        return headMultiset((com.google.common.collect.ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final com.google.common.collect.Multiset.Entry<E> pollFirstEntry() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @java.lang.Deprecated
    public final com.google.common.collect.Multiset.Entry<E> pollLastEntry() {
        throw new java.lang.UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.ImmutableSortedMultiset<E> subMultiset(E e, com.google.common.collect.BoundType boundType, E e2, com.google.common.collect.BoundType boundType2) {
        com.google.common.base.Preconditions.checkArgument(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return tailMultiset((com.google.common.collect.ImmutableSortedMultiset<E>) e, boundType).headMultiset((com.google.common.collect.ImmutableSortedMultiset<E>) e2, boundType2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset subMultiset(java.lang.Object obj, com.google.common.collect.BoundType boundType, java.lang.Object obj2, com.google.common.collect.BoundType boundType2) {
        return subMultiset((com.google.common.collect.BoundType) obj, boundType, (com.google.common.collect.BoundType) obj2, boundType2);
    }

    public abstract com.google.common.collect.ImmutableSortedMultiset<E> tailMultiset(E e, com.google.common.collect.BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ com.google.common.collect.SortedMultiset tailMultiset(java.lang.Object obj, com.google.common.collect.BoundType boundType) {
        return tailMultiset((com.google.common.collect.ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public java.lang.Object writeReplace() {
        return new com.google.common.collect.ImmutableSortedMultiset.SerializedForm(this);
    }
}
