package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class ForwardingNavigableSet<E> extends com.google.common.collect.ForwardingSortedSet<E> implements java.util.NavigableSet<E> {

    @com.google.common.annotations.Beta
    public class StandardDescendingSet extends com.google.common.collect.Sets.DescendingSet<E> {
        public StandardDescendingSet() {
            super(com.google.common.collect.ForwardingNavigableSet.this);
        }
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return delegate().ceiling(e);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract java.util.NavigableSet<E> delegate();

    @Override // java.util.NavigableSet
    public java.util.Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public java.util.NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return delegate().floor(e);
    }

    @Override // java.util.NavigableSet
    public java.util.NavigableSet<E> headSet(E e, boolean z) {
        return delegate().headSet(e, z);
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return delegate().higher(e);
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return delegate().lower(e);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return delegate().pollLast();
    }

    public E standardCeiling(E e) {
        return (E) com.google.common.collect.Iterators.getNext(tailSet(e, true).iterator(), null);
    }

    public E standardFirst() {
        return iterator().next();
    }

    public E standardFloor(E e) {
        return (E) com.google.common.collect.Iterators.getNext(headSet(e, true).descendingIterator(), null);
    }

    public java.util.SortedSet<E> standardHeadSet(E e) {
        return headSet(e, false);
    }

    public E standardHigher(E e) {
        return (E) com.google.common.collect.Iterators.getNext(tailSet(e, false).iterator(), null);
    }

    public E standardLast() {
        return descendingIterator().next();
    }

    public E standardLower(E e) {
        return (E) com.google.common.collect.Iterators.getNext(headSet(e, false).descendingIterator(), null);
    }

    public E standardPollFirst() {
        return (E) com.google.common.collect.Iterators.k(iterator());
    }

    public E standardPollLast() {
        return (E) com.google.common.collect.Iterators.k(descendingIterator());
    }

    @com.google.common.annotations.Beta
    public java.util.NavigableSet<E> standardSubSet(E e, boolean z, E e2, boolean z2) {
        return tailSet(e, z).headSet(e2, z2);
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    public java.util.SortedSet<E> standardSubSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    public java.util.SortedSet<E> standardTailSet(E e) {
        return tailSet(e, true);
    }

    @Override // java.util.NavigableSet
    public java.util.NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return delegate().subSet(e, z, e2, z2);
    }

    @Override // java.util.NavigableSet
    public java.util.NavigableSet<E> tailSet(E e, boolean z) {
        return delegate().tailSet(e, z);
    }
}
