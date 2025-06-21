package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface Multiset<E> extends java.util.Collection<E> {

    public interface Entry<E> {
        boolean equals(java.lang.Object obj);

        int getCount();

        E getElement();

        int hashCode();

        java.lang.String toString();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    int add(@org.checkerframework.checker.nullness.compatqual.NullableDecl E e, int i);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean add(E e);

    boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @Override // java.util.Collection
    boolean containsAll(java.util.Collection<?> collection);

    int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("E") java.lang.Object obj);

    java.util.Set<E> elementSet();

    java.util.Set<com.google.common.collect.Multiset.Entry<E>> entrySet();

    boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    int hashCode();

    java.util.Iterator<E> iterator();

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl @com.google.errorprone.annotations.CompatibleWith("E") java.lang.Object obj, int i);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean removeAll(java.util.Collection<?> collection);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean retainAll(java.util.Collection<?> collection);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    int setCount(E e, int i);

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean setCount(E e, int i, int i2);

    int size();

    java.lang.String toString();
}
