package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class AbstractCheckedFuture<V, X extends java.lang.Exception> extends com.google.common.util.concurrent.ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements com.google.common.util.concurrent.CheckedFuture<V, X> {
    public AbstractCheckedFuture(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture) {
        super(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.CheckedFuture
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V checkedGet() throws java.lang.Exception {
        try {
            return get();
        } catch (java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
            throw mapException(e);
        } catch (java.util.concurrent.CancellationException e2) {
            e = e2;
            throw mapException(e);
        } catch (java.util.concurrent.ExecutionException e3) {
            e = e3;
            throw mapException(e);
        }
    }

    @Override // com.google.common.util.concurrent.CheckedFuture
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V checkedGet(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException, java.lang.Exception {
        try {
            return get(j, timeUnit);
        } catch (java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
            throw mapException(e);
        } catch (java.util.concurrent.CancellationException e2) {
            e = e2;
            throw mapException(e);
        } catch (java.util.concurrent.ExecutionException e3) {
            e = e3;
            throw mapException(e);
        }
    }

    public abstract X mapException(java.lang.Exception exc);
}
