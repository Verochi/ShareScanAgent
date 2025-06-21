package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
public class HashMultiset<E> extends com.google.common.collect.AbstractMapBasedMultiset<E> {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 0;

    public HashMultiset(int i) {
        super(i);
    }

    public static <E> com.google.common.collect.HashMultiset<E> create() {
        return create(3);
    }

    public static <E> com.google.common.collect.HashMultiset<E> create(int i) {
        return new com.google.common.collect.HashMultiset<>(i);
    }

    public static <E> com.google.common.collect.HashMultiset<E> create(java.lang.Iterable<? extends E> iterable) {
        com.google.common.collect.HashMultiset<E> create = create(com.google.common.collect.Multisets.g(iterable));
        com.google.common.collect.Iterables.addAll(create, iterable);
        return create;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ java.util.Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ java.util.Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset
    public void init(int i) {
        this.backingMap = new com.google.common.collect.ObjectCountHashMap<>(i);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }
}
