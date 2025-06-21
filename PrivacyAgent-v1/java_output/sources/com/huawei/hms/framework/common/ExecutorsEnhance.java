package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ExecutorsEnhance {

    public static class DelegatedExecutorService extends java.util.concurrent.AbstractExecutorService {
        private final java.util.concurrent.ExecutorService executorService;

        public DelegatedExecutorService(java.util.concurrent.ExecutorService executorService) {
            this.executorService = executorService;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            return this.executorService.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            this.executorService.execute(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) throws java.lang.InterruptedException {
            return this.executorService.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            return this.executorService.invokeAll(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
            return (T) this.executorService.invokeAny(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> collection, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
            return (T) this.executorService.invokeAny(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.executorService.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.executorService.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.executorService.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public java.util.List<java.lang.Runnable> shutdownNow() {
            return this.executorService.shutdownNow();
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public java.util.concurrent.Future<?> submit(java.lang.Runnable runnable) {
            return this.executorService.submit(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> java.util.concurrent.Future<T> submit(java.lang.Runnable runnable, T t) {
            return this.executorService.submit(runnable, t);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> java.util.concurrent.Future<T> submit(java.util.concurrent.Callable<T> callable) {
            return this.executorService.submit(callable);
        }
    }

    public static class FinalizableDelegatedExecutorService extends com.huawei.hms.framework.common.ExecutorsEnhance.DelegatedExecutorService {
        public FinalizableDelegatedExecutorService(java.util.concurrent.ExecutorService executorService) {
            super(executorService);
        }

        public void finalize() {
            super.shutdown();
        }
    }

    public static java.util.concurrent.ExecutorService newSingleThreadExecutor(java.util.concurrent.ThreadFactory threadFactory) {
        return new com.huawei.hms.framework.common.ExecutorsEnhance.FinalizableDelegatedExecutorService(new com.huawei.hms.framework.common.ThreadPoolExcutorEnhance(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), threadFactory));
    }
}
