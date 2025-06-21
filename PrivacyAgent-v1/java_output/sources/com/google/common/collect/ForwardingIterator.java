package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class ForwardingIterator<T> extends com.google.common.collect.ForwardingObject implements java.util.Iterator<T> {
    @Override // com.google.common.collect.ForwardingObject
    public abstract java.util.Iterator<T> delegate();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return delegate().hasNext();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public T next() {
        return delegate().next();
    }

    public void remove() {
        delegate().remove();
    }
}
