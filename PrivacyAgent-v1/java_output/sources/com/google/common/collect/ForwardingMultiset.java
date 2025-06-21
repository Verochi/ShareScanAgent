package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingMultiset<E> extends com.google.common.collect.ForwardingCollection<E> implements com.google.common.collect.Multiset<E> {

    @com.google.common.annotations.Beta
    public class StandardElementSet extends com.google.common.collect.Multisets.ElementSet<E> {
        public StandardElementSet() {
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        public com.google.common.collect.Multiset<E> a() {
            return com.google.common.collect.ForwardingMultiset.this;
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return com.google.common.collect.Multisets.e(a().entrySet().iterator());
        }
    }

    @Override // com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int add(E e, int i) {
        return delegate().add(e, i);
    }

    @Override // com.google.common.collect.Multiset
    public int count(java.lang.Object obj) {
        return delegate().count(obj);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract com.google.common.collect.Multiset<E> delegate();

    public java.util.Set<E> elementSet() {
        return delegate().elementSet();
    }

    public java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int remove(java.lang.Object obj, int i) {
        return delegate().remove(obj, i);
    }

    @Override // com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int setCount(E e, int i) {
        return delegate().setCount(e, i);
    }

    @Override // com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        return delegate().setCount(e, i, i2);
    }

    public boolean standardAdd(E e) {
        add(e, 1);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    @com.google.common.annotations.Beta
    public boolean standardAddAll(java.util.Collection<? extends E> collection) {
        return com.google.common.collect.Multisets.c(this, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public void standardClear() {
        com.google.common.collect.Iterators.c(entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardContains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return count(obj) > 0;
    }

    @com.google.common.annotations.Beta
    public int standardCount(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        for (com.google.common.collect.Multiset.Entry<E> entry : entrySet()) {
            if (com.google.common.base.Objects.equal(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Multisets.f(this, obj);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public java.util.Iterator<E> standardIterator() {
        return com.google.common.collect.Multisets.h(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemove(java.lang.Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemoveAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Multisets.j(this, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRetainAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Multisets.k(this, collection);
    }

    public int standardSetCount(E e, int i) {
        return com.google.common.collect.Multisets.m(this, e, i);
    }

    public boolean standardSetCount(E e, int i, int i2) {
        return com.google.common.collect.Multisets.n(this, e, i, i2);
    }

    public int standardSize() {
        return com.google.common.collect.Multisets.i(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public java.lang.String standardToString() {
        return entrySet().toString();
    }
}
