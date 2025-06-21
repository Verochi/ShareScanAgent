package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingList<E> extends com.google.common.collect.ForwardingCollection<E> implements java.util.List<E> {
    public void add(int i, E e) {
        delegate().add(i, e);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean addAll(int i, java.util.Collection<? extends E> collection) {
        return delegate().addAll(i, collection);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract java.util.List<E> delegate();

    @Override // java.util.Collection, java.util.List
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.List
    public E get(int i) {
        return delegate().get(i);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.List
    public int indexOf(java.lang.Object obj) {
        return delegate().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(java.lang.Object obj) {
        return delegate().lastIndexOf(obj);
    }

    @Override // java.util.List
    public java.util.ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    public java.util.ListIterator<E> listIterator(int i) {
        return delegate().listIterator(i);
    }

    @Override // java.util.List
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E remove(int i) {
        return delegate().remove(i);
    }

    @Override // java.util.List
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public E set(int i, E e) {
        return delegate().set(i, e);
    }

    public boolean standardAdd(E e) {
        add(size(), e);
        return true;
    }

    public boolean standardAddAll(int i, java.lang.Iterable<? extends E> iterable) {
        return com.google.common.collect.Lists.a(this, i, iterable);
    }

    @com.google.common.annotations.Beta
    public boolean standardEquals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Lists.d(this, obj);
    }

    @com.google.common.annotations.Beta
    public int standardHashCode() {
        return com.google.common.collect.Lists.e(this);
    }

    public int standardIndexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Lists.f(this, obj);
    }

    public java.util.Iterator<E> standardIterator() {
        return listIterator();
    }

    public int standardLastIndexOf(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return com.google.common.collect.Lists.h(this, obj);
    }

    public java.util.ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @com.google.common.annotations.Beta
    public java.util.ListIterator<E> standardListIterator(int i) {
        return com.google.common.collect.Lists.j(this, i);
    }

    @com.google.common.annotations.Beta
    public java.util.List<E> standardSubList(int i, int i2) {
        return com.google.common.collect.Lists.k(this, i, i2);
    }

    @Override // java.util.List
    public java.util.List<E> subList(int i, int i2) {
        return delegate().subList(i, i2);
    }
}
