package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface FutureCallback<V> {
    void onFailure(java.lang.Throwable th);

    void onSuccess(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v);
}
