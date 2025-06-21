package com.google.common.base;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class FinalizableWeakReference<T> extends java.lang.ref.WeakReference<T> implements com.google.common.base.FinalizableReference {
    public FinalizableWeakReference(T t, com.google.common.base.FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.n);
        finalizableReferenceQueue.c();
    }
}
