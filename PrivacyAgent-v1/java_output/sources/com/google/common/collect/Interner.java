package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface Interner<E> {
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    E intern(E e);
}
