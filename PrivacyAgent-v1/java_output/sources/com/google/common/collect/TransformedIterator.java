package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class TransformedIterator<F, T> implements java.util.Iterator<T> {
    public final java.util.Iterator<? extends F> n;

    public TransformedIterator(java.util.Iterator<? extends F> it) {
        this.n = (java.util.Iterator) com.google.common.base.Preconditions.checkNotNull(it);
    }

    public abstract T a(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.n.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.n.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.n.remove();
    }
}
