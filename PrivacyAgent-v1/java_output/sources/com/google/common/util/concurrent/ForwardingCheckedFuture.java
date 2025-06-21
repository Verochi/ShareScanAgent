package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class ForwardingCheckedFuture<V, X extends java.lang.Exception> extends com.google.common.util.concurrent.ForwardingListenableFuture<V> implements com.google.common.util.concurrent.CheckedFuture<V, X> {

    @com.google.common.annotations.Beta
    @java.lang.Deprecated
    public static abstract class SimpleForwardingCheckedFuture<V, X extends java.lang.Exception> extends com.google.common.util.concurrent.ForwardingCheckedFuture<V, X> {
        public final com.google.common.util.concurrent.CheckedFuture<V, X> n;

        public SimpleForwardingCheckedFuture(com.google.common.util.concurrent.CheckedFuture<V, X> checkedFuture) {
            this.n = (com.google.common.util.concurrent.CheckedFuture) com.google.common.base.Preconditions.checkNotNull(checkedFuture);
        }

        @Override // com.google.common.util.concurrent.ForwardingCheckedFuture, com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public final com.google.common.util.concurrent.CheckedFuture<V, X> delegate() {
            return this.n;
        }
    }

    @Override // com.google.common.util.concurrent.CheckedFuture
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V checkedGet() throws java.lang.Exception {
        return delegate().checkedGet();
    }

    @Override // com.google.common.util.concurrent.CheckedFuture
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V checkedGet(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException, java.lang.Exception {
        return delegate().checkedGet(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    public abstract com.google.common.util.concurrent.CheckedFuture<V, X> delegate();
}
