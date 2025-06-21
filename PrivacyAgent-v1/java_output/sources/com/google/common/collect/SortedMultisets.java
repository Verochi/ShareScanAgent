package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class SortedMultisets {

    public static class ElementSet<E> extends com.google.common.collect.Multisets.ElementSet<E> implements java.util.SortedSet<E> {

        @com.google.j2objc.annotations.Weak
        public final com.google.common.collect.SortedMultiset<E> n;

        public ElementSet(com.google.common.collect.SortedMultiset<E> sortedMultiset) {
            this.n = sortedMultiset;
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.google.common.collect.SortedMultiset<E> a() {
            return this.n;
        }

        @Override // java.util.SortedSet
        public java.util.Comparator<? super E> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) com.google.common.collect.SortedMultisets.d(a().firstEntry());
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<E> headSet(E e) {
            return a().headMultiset(e, com.google.common.collect.BoundType.OPEN).elementSet();
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return com.google.common.collect.Multisets.e(a().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) com.google.common.collect.SortedMultisets.d(a().lastEntry());
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<E> subSet(E e, E e2) {
            return a().subMultiset(e, com.google.common.collect.BoundType.CLOSED, e2, com.google.common.collect.BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public java.util.SortedSet<E> tailSet(E e) {
            return a().tailMultiset(e, com.google.common.collect.BoundType.CLOSED).elementSet();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class NavigableElementSet<E> extends com.google.common.collect.SortedMultisets.ElementSet<E> implements java.util.NavigableSet<E> {
        public NavigableElementSet(com.google.common.collect.SortedMultiset<E> sortedMultiset) {
            super(sortedMultiset);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            return (E) com.google.common.collect.SortedMultisets.c(a().tailMultiset(e, com.google.common.collect.BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public java.util.Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> descendingSet() {
            return new com.google.common.collect.SortedMultisets.NavigableElementSet(a().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            return (E) com.google.common.collect.SortedMultisets.c(a().headMultiset(e, com.google.common.collect.BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> headSet(E e, boolean z) {
            return new com.google.common.collect.SortedMultisets.NavigableElementSet(a().headMultiset(e, com.google.common.collect.BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            return (E) com.google.common.collect.SortedMultisets.c(a().tailMultiset(e, com.google.common.collect.BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            return (E) com.google.common.collect.SortedMultisets.c(a().headMultiset(e, com.google.common.collect.BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) com.google.common.collect.SortedMultisets.c(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) com.google.common.collect.SortedMultisets.c(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return new com.google.common.collect.SortedMultisets.NavigableElementSet(a().subMultiset(e, com.google.common.collect.BoundType.forBoolean(z), e2, com.google.common.collect.BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableSet
        public java.util.NavigableSet<E> tailSet(E e, boolean z) {
            return new com.google.common.collect.SortedMultisets.NavigableElementSet(a().tailMultiset(e, com.google.common.collect.BoundType.forBoolean(z)));
        }
    }

    public static <E> E c(@org.checkerframework.checker.nullness.compatqual.NullableDecl com.google.common.collect.Multiset.Entry<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }

    public static <E> E d(com.google.common.collect.Multiset.Entry<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new java.util.NoSuchElementException();
    }
}
