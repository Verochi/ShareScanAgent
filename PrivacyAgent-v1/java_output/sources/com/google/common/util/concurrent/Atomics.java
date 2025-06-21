package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Atomics {
    public static <V> java.util.concurrent.atomic.AtomicReference<V> newReference() {
        return new java.util.concurrent.atomic.AtomicReference<>();
    }

    public static <V> java.util.concurrent.atomic.AtomicReference<V> newReference(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v) {
        return new java.util.concurrent.atomic.AtomicReference<>(v);
    }

    public static <E> java.util.concurrent.atomic.AtomicReferenceArray<E> newReferenceArray(int i) {
        return new java.util.concurrent.atomic.AtomicReferenceArray<>(i);
    }

    public static <E> java.util.concurrent.atomic.AtomicReferenceArray<E> newReferenceArray(E[] eArr) {
        return new java.util.concurrent.atomic.AtomicReferenceArray<>(eArr);
    }
}
