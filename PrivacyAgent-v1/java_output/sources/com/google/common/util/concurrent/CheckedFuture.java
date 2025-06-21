package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
@java.lang.Deprecated
@com.google.errorprone.annotations.CanIgnoreReturnValue
/* loaded from: classes22.dex */
public interface CheckedFuture<V, X extends java.lang.Exception> extends com.google.common.util.concurrent.ListenableFuture<V> {
    V checkedGet() throws java.lang.Exception;

    V checkedGet(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException, java.lang.Exception;
}
