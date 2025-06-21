package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class JdkFutureAdapters {

    public static class ListenableFutureAdapter<V> extends com.google.common.util.concurrent.ForwardingFuture<V> implements com.google.common.util.concurrent.ListenableFuture<V> {
        public static final java.util.concurrent.ThreadFactory w;
        public static final java.util.concurrent.Executor x;
        public final java.util.concurrent.Executor n;
        public final com.google.common.util.concurrent.ExecutionList t;
        public final java.util.concurrent.atomic.AtomicBoolean u;
        public final java.util.concurrent.Future<V> v;

        /* renamed from: com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(com.google.common.util.concurrent.JdkFutureAdapters.ListenableFutureAdapter.this.v);
                } catch (java.lang.Throwable unused) {
                }
                com.google.common.util.concurrent.JdkFutureAdapters.ListenableFutureAdapter.this.t.execute();
            }
        }

        static {
            java.util.concurrent.ThreadFactory build = new com.google.common.util.concurrent.ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            w = build;
            x = java.util.concurrent.Executors.newCachedThreadPool(build);
        }

        public ListenableFutureAdapter(java.util.concurrent.Future<V> future) {
            this(future, x);
        }

        public ListenableFutureAdapter(java.util.concurrent.Future<V> future, java.util.concurrent.Executor executor) {
            this.t = new com.google.common.util.concurrent.ExecutionList();
            this.u = new java.util.concurrent.atomic.AtomicBoolean(false);
            this.v = (java.util.concurrent.Future) com.google.common.base.Preconditions.checkNotNull(future);
            this.n = (java.util.concurrent.Executor) com.google.common.base.Preconditions.checkNotNull(executor);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
            this.t.add(runnable, executor);
            if (this.u.compareAndSet(false, true)) {
                if (this.v.isDone()) {
                    this.t.execute();
                } else {
                    this.n.execute(new com.google.common.util.concurrent.JdkFutureAdapters.ListenableFutureAdapter.AnonymousClass1());
                }
            }
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public java.util.concurrent.Future<V> delegate() {
            return this.v;
        }
    }

    public static <V> com.google.common.util.concurrent.ListenableFuture<V> listenInPoolThread(java.util.concurrent.Future<V> future) {
        return future instanceof com.google.common.util.concurrent.ListenableFuture ? (com.google.common.util.concurrent.ListenableFuture) future : new com.google.common.util.concurrent.JdkFutureAdapters.ListenableFutureAdapter(future);
    }

    public static <V> com.google.common.util.concurrent.ListenableFuture<V> listenInPoolThread(java.util.concurrent.Future<V> future, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(executor);
        return future instanceof com.google.common.util.concurrent.ListenableFuture ? (com.google.common.util.concurrent.ListenableFuture) future : new com.google.common.util.concurrent.JdkFutureAdapters.ListenableFutureAdapter(future, executor);
    }
}
