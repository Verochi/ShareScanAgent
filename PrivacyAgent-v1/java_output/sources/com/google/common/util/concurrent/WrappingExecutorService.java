package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
abstract class WrappingExecutorService implements java.util.concurrent.ExecutorService {
    public final java.util.concurrent.ExecutorService n;

    /* renamed from: com.google.common.util.concurrent.WrappingExecutorService$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.util.concurrent.Callable n;

        public AnonymousClass1(java.util.concurrent.Callable callable) {
            this.n = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.n.call();
            } catch (java.lang.Exception e) {
                com.google.common.base.Throwables.throwIfUnchecked(e);
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    public WrappingExecutorService(java.util.concurrent.ExecutorService executorService) {
        this.n = (java.util.concurrent.ExecutorService) com.google.common.base.Preconditions.checkNotNull(executorService);
    }

    public java.lang.Runnable a(java.lang.Runnable runnable) {
        return new com.google.common.util.concurrent.WrappingExecutorService.AnonymousClass1(b(java.util.concurrent.Executors.callable(runnable, null)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        return this.n.awaitTermination(j, timeUnit);
    }

    public abstract <T> java.util.concurrent.Callable<T> b(java.util.concurrent.Callable<T> callable);

    public final <T> com.google.common.collect.ImmutableList<java.util.concurrent.Callable<T>> c(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) {
        com.google.common.collect.ImmutableList.Builder builder = com.google.common.collect.ImmutableList.builder();
        java.util.Iterator<? extends java.util.concurrent.Callable<T>> it = collection.iterator();
        while (it.hasNext()) {
            builder.add((com.google.common.collect.ImmutableList.Builder) b(it.next()));
        }
        return builder.build();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(java.lang.Runnable runnable) {
        this.n.execute(a(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) throws java.lang.InterruptedException {
        return this.n.invokeAll(c(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        return this.n.invokeAll(c(collection), j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        return (T) this.n.invokeAny(c(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        return (T) this.n.invokeAny(c(collection), j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.n.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.n.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.n.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final java.util.List<java.lang.Runnable> shutdownNow() {
        return this.n.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final java.util.concurrent.Future<?> submit(java.lang.Runnable runnable) {
        return this.n.submit(a(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> java.util.concurrent.Future<T> submit(java.lang.Runnable runnable, T t) {
        return this.n.submit(a(runnable), t);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> java.util.concurrent.Future<T> submit(java.util.concurrent.Callable<T> callable) {
        return this.n.submit(b((java.util.concurrent.Callable) com.google.common.base.Preconditions.checkNotNull(callable)));
    }
}
