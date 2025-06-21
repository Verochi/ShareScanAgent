package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class UnmodifiableIterator<E> implements java.util.Iterator<E> {
    @Override // java.util.Iterator
    @java.lang.Deprecated
    public final void remove() {
        throw new java.lang.UnsupportedOperationException();
    }
}
