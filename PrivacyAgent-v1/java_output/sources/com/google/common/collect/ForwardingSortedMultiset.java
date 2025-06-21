package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class ForwardingSortedMultiset<E> extends com.google.common.collect.ForwardingMultiset<E> implements com.google.common.collect.SortedMultiset<E> {

    public abstract class StandardDescendingMultiset extends com.google.common.collect.DescendingMultiset<E> {
        public StandardDescendingMultiset() {
        }

        @Override // com.google.common.collect.DescendingMultiset
        public com.google.common.collect.SortedMultiset<E> l() {
            return com.google.common.collect.ForwardingSortedMultiset.this;
        }
    }

    public class StandardElementSet extends com.google.common.collect.SortedMultisets.NavigableElementSet<E> {
        public StandardElementSet() {
            super(com.google.common.collect.ForwardingSortedMultiset.this);
        }
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public java.util.Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract com.google.common.collect.SortedMultiset<E> delegate();

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public java.util.NavigableSet<E> elementSet() {
        return delegate().elementSet();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> headMultiset(E e, com.google.common.collect.BoundType boundType) {
        return delegate().headMultiset(e, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.Multiset.Entry<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public com.google.common.collect.Multiset.Entry<E> standardFirstEntry() {
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        com.google.common.collect.Multiset.Entry<E> next = it.next();
        return com.google.common.collect.Multisets.immutableEntry(next.getElement(), next.getCount());
    }

    public com.google.common.collect.Multiset.Entry<E> standardLastEntry() {
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        com.google.common.collect.Multiset.Entry<E> next = it.next();
        return com.google.common.collect.Multisets.immutableEntry(next.getElement(), next.getCount());
    }

    public com.google.common.collect.Multiset.Entry<E> standardPollFirstEntry() {
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        com.google.common.collect.Multiset.Entry<E> next = it.next();
        com.google.common.collect.Multiset.Entry<E> immutableEntry = com.google.common.collect.Multisets.immutableEntry(next.getElement(), next.getCount());
        it.remove();
        return immutableEntry;
    }

    public com.google.common.collect.Multiset.Entry<E> standardPollLastEntry() {
        java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        com.google.common.collect.Multiset.Entry<E> next = it.next();
        com.google.common.collect.Multiset.Entry<E> immutableEntry = com.google.common.collect.Multisets.immutableEntry(next.getElement(), next.getCount());
        it.remove();
        return immutableEntry;
    }

    public com.google.common.collect.SortedMultiset<E> standardSubMultiset(E e, com.google.common.collect.BoundType boundType, E e2, com.google.common.collect.BoundType boundType2) {
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> subMultiset(E e, com.google.common.collect.BoundType boundType, E e2, com.google.common.collect.BoundType boundType2) {
        return delegate().subMultiset(e, boundType, e2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public com.google.common.collect.SortedMultiset<E> tailMultiset(E e, com.google.common.collect.BoundType boundType) {
        return delegate().tailMultiset(e, boundType);
    }
}
