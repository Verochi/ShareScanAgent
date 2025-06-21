package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class IndexedImmutableSet<E> extends com.google.common.collect.ImmutableSet<E> {

    /* renamed from: com.google.common.collect.IndexedImmutableSet$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.ImmutableList<E> {
        public AnonymousClass1() {
        }

        @Override // java.util.List
        public E get(int i) {
            return (E) com.google.common.collect.IndexedImmutableSet.this.get(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return com.google.common.collect.IndexedImmutableSet.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.collect.IndexedImmutableSet.this.size();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    @com.google.common.annotations.GwtIncompatible
    public int copyIntoArray(java.lang.Object[] objArr, int i) {
        return asList().copyIntoArray(objArr, i);
    }

    @Override // com.google.common.collect.ImmutableSet
    public com.google.common.collect.ImmutableList<E> createAsList() {
        return new com.google.common.collect.IndexedImmutableSet.AnonymousClass1();
    }

    public abstract E get(int i);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public com.google.common.collect.UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }
}
