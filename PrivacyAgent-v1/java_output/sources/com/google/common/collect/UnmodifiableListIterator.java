package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class UnmodifiableListIterator<E> extends com.google.common.collect.UnmodifiableIterator<E> implements java.util.ListIterator<E> {
    @Override // java.util.ListIterator
    @java.lang.Deprecated
    public final void add(E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @java.lang.Deprecated
    public final void set(E e) {
        throw new java.lang.UnsupportedOperationException();
    }
}
