package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class MoreExecutors {

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$1, reason: invalid class name */
    final class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.util.concurrent.BlockingQueue n;
        public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture t;

        @Override // java.lang.Runnable
        public void run() {
            this.n.add(this.t);
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.concurrent.Executor {
        public final /* synthetic */ java.util.concurrent.Executor n;
        public final /* synthetic */ com.google.common.base.Supplier t;

        public AnonymousClass2(java.util.concurrent.Executor executor, com.google.common.base.Supplier supplier) {
            this.n = executor;
            this.t = supplier;
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            this.n.execute(com.google.common.util.concurrent.Callables.b(runnable, this.t));
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$3, reason: invalid class name */
    final class AnonymousClass3 extends com.google.common.util.concurrent.WrappingExecutorService {
        public final /* synthetic */ com.google.common.base.Supplier t;

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public java.lang.Runnable a(java.lang.Runnable runnable) {
            return com.google.common.util.concurrent.Callables.b(runnable, this.t);
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public <T> java.util.concurrent.Callable<T> b(java.util.concurrent.Callable<T> callable) {
            return com.google.common.util.concurrent.Callables.c(callable, this.t);
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$4, reason: invalid class name */
    public static class AnonymousClass4 extends com.google.common.util.concurrent.WrappingScheduledExecutorService {
        public final /* synthetic */ com.google.common.base.Supplier u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(java.util.concurrent.ScheduledExecutorService scheduledExecutorService, com.google.common.base.Supplier supplier) {
            super(scheduledExecutorService);
            this.u = supplier;
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public java.lang.Runnable a(java.lang.Runnable runnable) {
            return com.google.common.util.concurrent.Callables.b(runnable, this.u);
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public <T> java.util.concurrent.Callable<T> b(java.util.concurrent.Callable<T> callable) {
            return com.google.common.util.concurrent.Callables.c(callable, this.u);
        }
    }

    /* renamed from: com.google.common.util.concurrent.MoreExecutors$5, reason: invalid class name */
    public static class AnonymousClass5 implements java.util.concurrent.Executor {
        public boolean n = true;
        public final /* synthetic */ java.util.concurrent.Executor t;
        public final /* synthetic */ com.google.common.util.concurrent.AbstractFuture u;

        /* renamed from: com.google.common.util.concurrent.MoreExecutors$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ java.lang.Runnable n;

            public AnonymousClass1(java.lang.Runnable runnable) {
                this.n = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.google.common.util.concurrent.MoreExecutors.AnonymousClass5.this.n = false;
                this.n.run();
            }
        }

        public AnonymousClass5(java.util.concurrent.Executor executor, com.google.common.util.concurrent.AbstractFuture abstractFuture) {
            this.t = executor;
            this.u = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            try {
                this.t.execute(new com.google.common.util.concurrent.MoreExecutors.AnonymousClass5.AnonymousClass1(runnable));
            } catch (java.util.concurrent.RejectedExecutionException e) {
                if (this.n) {
                    this.u.setException(e);
                }
            }
        }
    }

    @com.google.common.annotations.VisibleForTesting
    @com.google.common.annotations.GwtIncompatible
    public static class Application {

        /* renamed from: com.google.common.util.concurrent.MoreExecutors$Application$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ java.util.concurrent.ExecutorService n;
            public final /* synthetic */ long t;
            public final /* synthetic */ java.util.concurrent.TimeUnit u;

            public AnonymousClass1(java.util.concurrent.ExecutorService executorService, long j, java.util.concurrent.TimeUnit timeUnit) {
                this.n = executorService;
                this.t = j;
                this.u = timeUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.n.shutdown();
                    this.n.awaitTermination(this.t, this.u);
                } catch (java.lang.InterruptedException unused) {
                }
            }
        }

        public final void a(java.util.concurrent.ExecutorService executorService, long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.base.Preconditions.checkNotNull(executorService);
            com.google.common.base.Preconditions.checkNotNull(timeUnit);
            b(com.google.common.util.concurrent.MoreExecutors.c("DelayedShutdownHook-for-" + executorService, new com.google.common.util.concurrent.MoreExecutors.Application.AnonymousClass1(executorService, j, timeUnit)));
        }

        @com.google.common.annotations.VisibleForTesting
        public void b(java.lang.Thread thread) {
            java.lang.Runtime.getRuntime().addShutdownHook(thread);
        }

        public final java.util.concurrent.ExecutorService c(java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
            return d(threadPoolExecutor, 120L, java.util.concurrent.TimeUnit.SECONDS);
        }

        public final java.util.concurrent.ExecutorService d(java.util.concurrent.ThreadPoolExecutor threadPoolExecutor, long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.util.concurrent.MoreExecutors.g(threadPoolExecutor);
            java.util.concurrent.ExecutorService unconfigurableExecutorService = java.util.concurrent.Executors.unconfigurableExecutorService(threadPoolExecutor);
            a(threadPoolExecutor, j, timeUnit);
            return unconfigurableExecutorService;
        }

        public final java.util.concurrent.ScheduledExecutorService e(java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return f(scheduledThreadPoolExecutor, 120L, java.util.concurrent.TimeUnit.SECONDS);
        }

        public final java.util.concurrent.ScheduledExecutorService f(java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.util.concurrent.MoreExecutors.g(scheduledThreadPoolExecutor);
            java.util.concurrent.ScheduledExecutorService unconfigurableScheduledExecutorService = java.util.concurrent.Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            a(scheduledThreadPoolExecutor, j, timeUnit);
            return unconfigurableScheduledExecutorService;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static final class DirectExecutorService extends com.google.common.util.concurrent.AbstractListeningExecutorService {
        public final java.lang.Object n;

        @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
        public int t;

        @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
        public boolean u;

        public DirectExecutorService() {
            this.n = new java.lang.Object();
            this.t = 0;
            this.u = false;
        }

        public /* synthetic */ DirectExecutorService(com.google.common.util.concurrent.MoreExecutors.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a() {
            synchronized (this.n) {
                int i = this.t - 1;
                this.t = i;
                if (i == 0) {
                    this.n.notifyAll();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            long nanos = timeUnit.toNanos(j);
            synchronized (this.n) {
                while (true) {
                    if (this.u && this.t == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long nanoTime = java.lang.System.nanoTime();
                    java.util.concurrent.TimeUnit.NANOSECONDS.timedWait(this.n, nanos);
                    nanos -= java.lang.System.nanoTime() - nanoTime;
                }
            }
        }

        public final void b() {
            synchronized (this.n) {
                if (this.u) {
                    throw new java.util.concurrent.RejectedExecutionException("Executor already shutdown");
                }
                this.t++;
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            b();
            try {
                runnable.run();
            } finally {
                a();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            boolean z;
            synchronized (this.n) {
                z = this.u;
            }
            return z;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            boolean z;
            synchronized (this.n) {
                z = this.u && this.t == 0;
            }
            return z;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            synchronized (this.n) {
                this.u = true;
                if (this.t == 0) {
                    this.n.notifyAll();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public java.util.List<java.lang.Runnable> shutdownNow() {
            shutdown();
            return java.util.Collections.emptyList();
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static class ListeningDecorator extends com.google.common.util.concurrent.AbstractListeningExecutorService {
        public final java.util.concurrent.ExecutorService n;

        public ListeningDecorator(java.util.concurrent.ExecutorService executorService) {
            this.n = (java.util.concurrent.ExecutorService) com.google.common.base.Preconditions.checkNotNull(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            return this.n.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(java.lang.Runnable runnable) {
            this.n.execute(runnable);
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
    }

    @com.google.common.annotations.GwtIncompatible
    public static final class ScheduledListeningDecorator extends com.google.common.util.concurrent.MoreExecutors.ListeningDecorator implements com.google.common.util.concurrent.ListeningScheduledExecutorService {
        public final java.util.concurrent.ScheduledExecutorService t;

        public static final class ListenableScheduledTask<V> extends com.google.common.util.concurrent.ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements com.google.common.util.concurrent.ListenableScheduledFuture<V> {
            public final java.util.concurrent.ScheduledFuture<?> t;

            public ListenableScheduledTask(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture, java.util.concurrent.ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.t = scheduledFuture;
            }

            @Override // java.lang.Comparable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compareTo(java.util.concurrent.Delayed delayed) {
                return this.t.compareTo(delayed);
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.t.cancel(z);
                }
                return cancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(java.util.concurrent.TimeUnit timeUnit) {
                return this.t.getDelay(timeUnit);
            }
        }

        @com.google.common.annotations.GwtIncompatible
        public static final class NeverSuccessfulListenableFutureTask extends com.google.common.util.concurrent.AbstractFuture.TrustedFuture<java.lang.Void> implements java.lang.Runnable {
            public final java.lang.Runnable z;

            public NeverSuccessfulListenableFutureTask(java.lang.Runnable runnable) {
                this.z = (java.lang.Runnable) com.google.common.base.Preconditions.checkNotNull(runnable);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.z.run();
                } catch (java.lang.Throwable th) {
                    setException(th);
                    throw com.google.common.base.Throwables.propagate(th);
                }
            }
        }

        public ScheduledListeningDecorator(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.t = (java.util.concurrent.ScheduledExecutorService) com.google.common.base.Preconditions.checkNotNull(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public com.google.common.util.concurrent.ListenableScheduledFuture<?> schedule(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.util.concurrent.TrustedListenableFutureTask x = com.google.common.util.concurrent.TrustedListenableFutureTask.x(runnable, null);
            return new com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.ListenableScheduledTask(x, this.t.schedule(x, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> com.google.common.util.concurrent.ListenableScheduledFuture<V> schedule(java.util.concurrent.Callable<V> callable, long j, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.util.concurrent.TrustedListenableFutureTask y = com.google.common.util.concurrent.TrustedListenableFutureTask.y(callable);
            return new com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.ListenableScheduledTask(y, this.t.schedule(y, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public com.google.common.util.concurrent.ListenableScheduledFuture<?> scheduleAtFixedRate(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.NeverSuccessfulListenableFutureTask(runnable);
            return new com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.t.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public com.google.common.util.concurrent.ListenableScheduledFuture<?> scheduleWithFixedDelay(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.NeverSuccessfulListenableFutureTask(runnable);
            return new com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator.ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.t.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static void addDelayedShutdownHook(java.util.concurrent.ExecutorService executorService, long j, java.util.concurrent.TimeUnit timeUnit) {
        new com.google.common.util.concurrent.MoreExecutors.Application().a(executorService, j, timeUnit);
    }

    @com.google.common.annotations.GwtIncompatible
    public static boolean b() {
        if (java.lang.System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            return java.lang.Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]) != null;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.lang.Thread c(java.lang.String str, java.lang.Runnable runnable) {
        com.google.common.base.Preconditions.checkNotNull(str);
        com.google.common.base.Preconditions.checkNotNull(runnable);
        java.lang.Thread newThread = platformThreadFactory().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (java.lang.SecurityException unused) {
        }
        return newThread;
    }

    public static java.util.concurrent.Executor d(java.util.concurrent.Executor executor, com.google.common.util.concurrent.AbstractFuture<?> abstractFuture) {
        com.google.common.base.Preconditions.checkNotNull(executor);
        com.google.common.base.Preconditions.checkNotNull(abstractFuture);
        return executor == directExecutor() ? executor : new com.google.common.util.concurrent.MoreExecutors.AnonymousClass5(executor, abstractFuture);
    }

    public static java.util.concurrent.Executor directExecutor() {
        return com.google.common.util.concurrent.DirectExecutor.INSTANCE;
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.util.concurrent.Executor e(java.util.concurrent.Executor executor, com.google.common.base.Supplier<java.lang.String> supplier) {
        com.google.common.base.Preconditions.checkNotNull(executor);
        com.google.common.base.Preconditions.checkNotNull(supplier);
        return b() ? executor : new com.google.common.util.concurrent.MoreExecutors.AnonymousClass2(executor, supplier);
    }

    @com.google.common.annotations.GwtIncompatible
    public static java.util.concurrent.ScheduledExecutorService f(java.util.concurrent.ScheduledExecutorService scheduledExecutorService, com.google.common.base.Supplier<java.lang.String> supplier) {
        com.google.common.base.Preconditions.checkNotNull(scheduledExecutorService);
        com.google.common.base.Preconditions.checkNotNull(supplier);
        return b() ? scheduledExecutorService : new com.google.common.util.concurrent.MoreExecutors.AnonymousClass4(scheduledExecutorService, supplier);
    }

    @com.google.common.annotations.GwtIncompatible
    public static void g(java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new com.google.common.util.concurrent.ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static java.util.concurrent.ExecutorService getExitingExecutorService(java.util.concurrent.ThreadPoolExecutor threadPoolExecutor) {
        return new com.google.common.util.concurrent.MoreExecutors.Application().c(threadPoolExecutor);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static java.util.concurrent.ExecutorService getExitingExecutorService(java.util.concurrent.ThreadPoolExecutor threadPoolExecutor, long j, java.util.concurrent.TimeUnit timeUnit) {
        return new com.google.common.util.concurrent.MoreExecutors.Application().d(threadPoolExecutor, j, timeUnit);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static java.util.concurrent.ScheduledExecutorService getExitingScheduledExecutorService(java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new com.google.common.util.concurrent.MoreExecutors.Application().e(scheduledThreadPoolExecutor);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static java.util.concurrent.ScheduledExecutorService getExitingScheduledExecutorService(java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, java.util.concurrent.TimeUnit timeUnit) {
        return new com.google.common.util.concurrent.MoreExecutors.Application().f(scheduledThreadPoolExecutor, j, timeUnit);
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.util.concurrent.ListeningExecutorService listeningDecorator(java.util.concurrent.ExecutorService executorService) {
        if (executorService instanceof com.google.common.util.concurrent.ListeningExecutorService) {
            return (com.google.common.util.concurrent.ListeningExecutorService) executorService;
        }
        return executorService instanceof java.util.concurrent.ScheduledExecutorService ? new com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator((java.util.concurrent.ScheduledExecutorService) executorService) : new com.google.common.util.concurrent.MoreExecutors.ListeningDecorator(executorService);
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.util.concurrent.ListeningScheduledExecutorService listeningDecorator(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof com.google.common.util.concurrent.ListeningScheduledExecutorService ? (com.google.common.util.concurrent.ListeningScheduledExecutorService) scheduledExecutorService : new com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator(scheduledExecutorService);
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.util.concurrent.ListeningExecutorService newDirectExecutorService() {
        return new com.google.common.util.concurrent.MoreExecutors.DirectExecutorService(null);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static java.util.concurrent.Executor newSequentialExecutor(java.util.concurrent.Executor executor) {
        return new com.google.common.util.concurrent.SequentialExecutor(executor);
    }

    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static java.util.concurrent.ThreadFactory platformThreadFactory() {
        if (!b()) {
            return java.util.concurrent.Executors.defaultThreadFactory();
        }
        try {
            return (java.util.concurrent.ThreadFactory) java.lang.Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.ClassNotFoundException e) {
            e = e;
            throw new java.lang.RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (java.lang.IllegalAccessException e2) {
            e = e2;
            throw new java.lang.RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (java.lang.NoSuchMethodException e3) {
            e = e3;
            throw new java.lang.RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            throw com.google.common.base.Throwables.propagate(e4.getCause());
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    @com.google.common.annotations.GwtIncompatible
    public static boolean shutdownAndAwaitTermination(java.util.concurrent.ExecutorService executorService, long j, java.util.concurrent.TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j) / 2;
        executorService.shutdown();
        try {
            java.util.concurrent.TimeUnit timeUnit2 = java.util.concurrent.TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }
}
