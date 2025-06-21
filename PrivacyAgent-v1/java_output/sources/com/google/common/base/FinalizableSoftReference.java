package com.google.common.base;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class FinalizableSoftReference<T> extends java.lang.ref.SoftReference<T> implements com.google.common.base.FinalizableReference {
    public FinalizableSoftReference(T t, com.google.common.base.FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.n);
        finalizableReferenceQueue.c();
    }
}
