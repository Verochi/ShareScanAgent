package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class AbstractSequentialIterator<T> extends com.google.common.collect.UnmodifiableIterator<T> {

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public T n;

    public AbstractSequentialIterator(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t) {
        this.n = t;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public abstract T computeNext(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.n != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        try {
            T t = this.n;
            this.n = computeNext(t);
            return t;
        } catch (java.lang.Throwable th) {
            this.n = computeNext(this.n);
            throw th;
        }
    }
}
