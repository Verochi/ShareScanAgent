package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class TransformedListIterator<F, T> extends com.google.common.collect.TransformedIterator<F, T> implements java.util.ListIterator<T> {
    public TransformedListIterator(java.util.ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new java.lang.UnsupportedOperationException();
    }

    public final java.util.ListIterator<? extends F> b() {
        return com.google.common.collect.Iterators.a(this.n);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(T t) {
        throw new java.lang.UnsupportedOperationException();
    }
}
