package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public interface SortedMultiset<E> extends com.google.common.collect.SortedMultisetBridge<E>, com.google.common.collect.SortedIterable<E> {
    java.util.Comparator<? super E> comparator();

    com.google.common.collect.SortedMultiset<E> descendingMultiset();

    @Override // com.google.common.collect.Multiset
    java.util.NavigableSet<E> elementSet();

    @Override // com.google.common.collect.Multiset
    /* synthetic */ java.util.SortedSet<E> elementSet();

    @Override // com.google.common.collect.Multiset
    java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet();

    com.google.common.collect.Multiset.Entry<E> firstEntry();

    com.google.common.collect.SortedMultiset<E> headMultiset(E e, com.google.common.collect.BoundType boundType);

    @Override // com.google.common.collect.Multiset, java.util.Collection, java.lang.Iterable
    java.util.Iterator<E> iterator();

    com.google.common.collect.Multiset.Entry<E> lastEntry();

    com.google.common.collect.Multiset.Entry<E> pollFirstEntry();

    com.google.common.collect.Multiset.Entry<E> pollLastEntry();

    com.google.common.collect.SortedMultiset<E> subMultiset(E e, com.google.common.collect.BoundType boundType, E e2, com.google.common.collect.BoundType boundType2);

    com.google.common.collect.SortedMultiset<E> tailMultiset(E e, com.google.common.collect.BoundType boundType);
}
