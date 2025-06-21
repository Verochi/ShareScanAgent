package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface PeekingIterator<E> extends java.util.Iterator<E> {
    @Override // java.util.Iterator
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    E next();

    E peek();

    @Override // java.util.Iterator
    void remove();
}
