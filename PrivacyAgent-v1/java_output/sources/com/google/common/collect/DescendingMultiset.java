package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class DescendingMultiset<E> extends com.google.common.collect.ForwardingMultiset<E> implements com.google.common.collect.SortedMultiset<E> {

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public transient java.util.Comparator<? super E> n;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public transient java.util.NavigableSet<E> t;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public transient java.util.Set<com.google.common.collect.Multiset.Entry<E>> u;

    /* renamed from: com.google.common.collect.DescendingMultiset$1EntrySetImpl, reason: invalid class name */
    public class C1EntrySetImpl extends com.google.common.collect.Multisets.EntrySet<E> {
        public C1EntrySetImpl() {
        }

        @Override // com.google.common.collect.Multisets.EntrySet
        public com.google.common.collect.Multiset<E> a() {
            return com.google.common.collect.DescendingMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> iterator() {
            return com.google.common.collect.DescendingMultiset.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.DescendingMultiset.this.l().entrySet().size();
        }
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public java.util.Comparator<? super E> comparator() {
        java.util.Comparator<? super E> comparator = this.n;
        if (comparator != null) {
            return comparator;
        }
        com.google.common.collect.Ordering reverse = com.google.common.collect.Ordering.from(l().comparator()).reverse();
        this.n = reverse;
        return reverse;
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public com.google.common.collect.Multiset<E> delegate() {
        return l();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> descendingMultiset() {
        return l();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public java.util.NavigableSet<E> elementSet() {
        java.util.NavigableSet<E> navigableSet = this.t;
        if (navigableSet != null) {
            return navigableSet;
        }
        com.google.common.collect.SortedMultisets.NavigableElementSet navigableElementSet = new com.google.common.collect.SortedMultisets.NavigableElementSet(this);
        this.t = navigableElementSet;
        return navigableElementSet;
    }

    public abstract java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator();

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet() {
        java.util.Set<com.google.common.collect.Multiset.Entry<E>> set = this.u;
        if (set != null) {
            return set;
        }
        java.util.Set<com.google.common.collect.Multiset.Entry<E>> k = k();
        this.u = k;
        return k;
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> firstEntry() {
        return l().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> headMultiset(E e, com.google.common.collect.BoundType boundType) {
        return l().tailMultiset(e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public java.util.Iterator<E> iterator() {
        return com.google.common.collect.Multisets.h(this);
    }

    public java.util.Set<com.google.common.collect.Multiset.Entry<E>> k() {
        return new com.google.common.collect.DescendingMultiset.C1EntrySetImpl();
    }

    public abstract com.google.common.collect.SortedMultiset<E> l();

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> lastEntry() {
        return l().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> pollFirstEntry() {
        return l().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> pollLastEntry() {
        return l().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> subMultiset(E e, com.google.common.collect.BoundType boundType, E e2, com.google.common.collect.BoundType boundType2) {
        return l().subMultiset(e2, boundType2, e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> tailMultiset(E e, com.google.common.collect.BoundType boundType) {
        return l().headMultiset(e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public java.lang.Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.common.collect.ForwardingObject
    public java.lang.String toString() {
        return entrySet().toString();
    }
}
