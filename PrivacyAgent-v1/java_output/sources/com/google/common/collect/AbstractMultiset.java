package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractMultiset<E> extends java.util.AbstractCollection<E> implements com.google.common.collect.Multiset<E> {

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<E> elementSet;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    private transient java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet;

    public class ElementSet extends com.google.common.collect.Multisets.ElementSet<E> {
        public ElementSet() {
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        public com.google.common.collect.Multiset<E> a() {
            return com.google.common.collect.AbstractMultiset.this;
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return com.google.common.collect.AbstractMultiset.this.elementIterator();
        }
    }

    public class EntrySet extends com.google.common.collect.Multisets.EntrySet<E> {
        public EntrySet() {
        }

        @Override // com.google.common.collect.Multisets.EntrySet
        public com.google.common.collect.Multiset<E> a() {
            return com.google.common.collect.AbstractMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> iterator() {
            return com.google.common.collect.AbstractMultiset.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.collect.AbstractMultiset.this.distinctElements();
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int add(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final boolean add(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e) {
        add(e, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final boolean addAll(java.util.Collection<? extends E> collection) {
        return com.google.common.collect.Multisets.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return count(obj) > 0;
    }

    public java.util.Set<E> createElementSet() {
        return new com.google.common.collect.AbstractMultiset.ElementSet();
    }

    public java.util.Set<com.google.common.collect.Multiset.Entry<E>> createEntrySet() {
        return new com.google.common.collect.AbstractMultiset.EntrySet();
    }

    public abstract int distinctElements();

    public abstract java.util.Iterator<E> elementIterator();

    @Override // com.google.common.collect.Multiset
    public java.util.Set<E> elementSet() {
        java.util.Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        java.util.Set<E> createElementSet = createElementSet();
        this.elementSet = createElementSet;
        return createElementSet;
    }

    public abstract java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator();

    @Override // com.google.common.collect.Multiset
    public java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet() {
        java.util.Set<com.google.common.collect.Multiset.Entry<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        java.util.Set<com.google.common.collect.Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Multisets.f(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final boolean removeAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Multisets.j(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final boolean retainAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Multisets.k(this, collection);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int setCount(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i) {
        return com.google.common.collect.Multisets.m(this, e, i);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean setCount(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i, int i2) {
        return com.google.common.collect.Multisets.n(this, e, i, i2);
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public final java.lang.String toString() {
        return entrySet().toString();
    }
}
