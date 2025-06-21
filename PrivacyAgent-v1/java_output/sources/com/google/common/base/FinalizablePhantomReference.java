package com.google.common.base;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class FinalizablePhantomReference<T> extends java.lang.ref.PhantomReference<T> implements com.google.common.base.FinalizableReference {
    public FinalizablePhantomReference(T t, com.google.common.base.FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.n);
        finalizableReferenceQueue.c();
    }
}
