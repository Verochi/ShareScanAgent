package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public interface AsyncCallable<V> {
    com.google.common.util.concurrent.ListenableFuture<V> call() throws java.lang.Exception;
}
