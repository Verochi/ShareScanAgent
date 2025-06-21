package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AbstractIndexedListIterator<E> extends com.google.common.collect.UnmodifiableListIterator<E> {
    public final int n;
    public int t;

    public AbstractIndexedListIterator(int i) {
        this(i, 0);
    }

    public AbstractIndexedListIterator(int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndex(i2, i);
        this.n = i;
        this.t = i2;
    }

    public abstract E a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.t < this.n;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.t > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        int i = this.t;
        this.t = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.t;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new java.util.NoSuchElementException();
        }
        int i = this.t - 1;
        this.t = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.t - 1;
    }
}
