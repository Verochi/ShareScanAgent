package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingCollection<E> extends com.google.common.collect.ForwardingObject implements java.util.Collection<E> {
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean add(E e) {
        return delegate().add(e);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean addAll(java.util.Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(java.lang.Object obj) {
        return delegate().contains(obj);
    }

    public boolean containsAll(java.util.Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract java.util.Collection<E> delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public java.util.Iterator<E> iterator() {
        return delegate().iterator();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean remove(java.lang.Object obj) {
        return delegate().remove(obj);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean removeAll(java.util.Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean retainAll(java.util.Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(java.util.Collection<? extends E> collection) {
        return com.google.common.collect.Iterators.addAll(this, collection.iterator());
    }

    public void standardClear() {
        com.google.common.collect.Iterators.c(iterator());
    }

    public boolean standardContains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Iterators.contains(iterator(), obj);
    }

    public boolean standardContainsAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Collections2.c(this, collection);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        java.util.Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (com.google.common.base.Objects.equal(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Iterators.removeAll(iterator(), collection);
    }

    public boolean standardRetainAll(java.util.Collection<?> collection) {
        return com.google.common.collect.Iterators.retainAll(iterator(), collection);
    }

    public java.lang.Object[] standardToArray() {
        return toArray(new java.lang.Object[size()]);
    }

    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) com.google.common.collect.ObjectArrays.f(this, tArr);
    }

    public java.lang.String standardToString() {
        return com.google.common.collect.Collections2.i(this);
    }

    public java.lang.Object[] toArray() {
        return delegate().toArray();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }
}
