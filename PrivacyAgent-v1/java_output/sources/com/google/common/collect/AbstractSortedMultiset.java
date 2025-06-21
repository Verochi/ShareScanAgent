package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class AbstractSortedMultiset<E> extends com.google.common.collect.AbstractMultiset<E> implements com.google.common.collect.SortedMultiset<E> {

    @com.google.common.collect.GwtTransient
    final java.util.Comparator<? super E> comparator;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient com.google.common.collect.SortedMultiset<E> descendingMultiset;

    /* renamed from: com.google.common.collect.AbstractSortedMultiset$1DescendingMultisetImpl, reason: invalid class name */
    public class C1DescendingMultisetImpl extends com.google.common.collect.DescendingMultiset<E> {
        public C1DescendingMultisetImpl() {
        }

        @Override // com.google.common.collect.DescendingMultiset
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
            return com.google.common.collect.AbstractSortedMultiset.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.DescendingMultiset, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return com.google.common.collect.AbstractSortedMultiset.this.descendingIterator();
        }

        @Override // com.google.common.collect.DescendingMultiset
        public com.google.common.collect.SortedMultiset<E> l() {
            return com.google.common.collect.AbstractSortedMultiset.this;
        }
    }

    public AbstractSortedMultiset() {
        this(com.google.common.collect.Ordering.natural());
    }

    public AbstractSortedMultiset(java.util.Comparator<? super E> comparator) {
        this.comparator = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public java.util.Comparator<? super E> comparator() {
        return this.comparator;
    }

    public com.google.common.collect.SortedMultiset<E> createDescendingMultiset() {
        return new com.google.common.collect.AbstractSortedMultiset.C1DescendingMultisetImpl();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public java.util.NavigableSet<E> createElementSet() {
        return new com.google.common.collect.SortedMultisets.NavigableElementSet(this);
    }

    public abstract java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> descendingEntryIterator();

    java.util.Iterator<E> descendingIterator() {
        return com.google.common.collect.Multisets.h(descendingMultiset());
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> descendingMultiset() {
        com.google.common.collect.SortedMultiset<E> sortedMultiset = this.descendingMultiset;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        com.google.common.collect.SortedMultiset<E> createDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = createDescendingMultiset;
        return createDescendingMultiset;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public java.util.NavigableSet<E> elementSet() {
        return (java.util.NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> firstEntry() {
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> lastEntry() {
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> pollFirstEntry() {
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator = entryIterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        com.google.common.collect.Multiset.Entry<E> next = entryIterator.next();
        com.google.common.collect.Multiset.Entry<E> immutableEntry = com.google.common.collect.Multisets.immutableEntry(next.getElement(), next.getCount());
        entryIterator.remove();
        return immutableEntry;
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> pollLastEntry() {
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> descendingEntryIterator = descendingEntryIterator();
        if (!descendingEntryIterator.hasNext()) {
            return null;
        }
        com.google.common.collect.Multiset.Entry<E> next = descendingEntryIterator.next();
        com.google.common.collect.Multiset.Entry<E> immutableEntry = com.google.common.collect.Multisets.immutableEntry(next.getElement(), next.getCount());
        descendingEntryIterator.remove();
        return immutableEntry;
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> subMultiset(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, com.google.common.collect.BoundType boundType, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e2, com.google.common.collect.BoundType boundType2) {
        com.google.common.base.Preconditions.checkNotNull(boundType);
        com.google.common.base.Preconditions.checkNotNull(boundType2);
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }
}
