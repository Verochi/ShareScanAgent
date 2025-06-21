package com.alimm.tanx.ui.image.glide.load.engine.executor;

/* loaded from: classes.dex */
public class FifoPriorityThreadPoolExecutor extends java.util.concurrent.ThreadPoolExecutor {
    private static final java.lang.String TAG = "PriorityExecutor";
    private final java.util.concurrent.atomic.AtomicInteger ordering;
    private final com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy uncaughtThrowableStrategy;

    public static class DefaultThreadFactory implements java.util.concurrent.ThreadFactory {
        int threadNum = 0;

        /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor$DefaultThreadFactory$1, reason: invalid class name */
        public class AnonymousClass1 extends java.lang.Thread {
            public AnonymousClass1(java.lang.Runnable runnable, java.lang.String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                android.os.Process.setThreadPriority(10);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("fifo-pool-thread-");
            tanxu_do2.append(this.threadNum);
            com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.DefaultThreadFactory.AnonymousClass1 anonymousClass1 = new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.DefaultThreadFactory.AnonymousClass1(runnable, tanxu_do2.toString());
            this.threadNum++;
            return anonymousClass1;
        }
    }

    public static class LoadTask<T> extends java.util.concurrent.FutureTask<T> implements java.lang.Comparable<com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.LoadTask<?>> {
        private final int order;
        private final int priority;

        public LoadTask(java.lang.Runnable runnable, T t, int i) {
            super(runnable, t);
            if (!(runnable instanceof com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized)) {
                throw new java.lang.IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.priority = ((com.alimm.tanx.ui.image.glide.load.engine.executor.Prioritized) runnable).getPriority();
            this.order = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.LoadTask<?> loadTask) {
            int i = this.priority - loadTask.priority;
            return i == 0 ? this.order - loadTask.order : i;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.LoadTask)) {
                return false;
            }
            com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.LoadTask loadTask = (com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.LoadTask) obj;
            return this.order == loadTask.order && this.priority == loadTask.priority;
        }

        public int hashCode() {
            return (this.priority * 31) + this.order;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static class UncaughtThrowableStrategy {
        private static final /* synthetic */ com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy[] $VALUES;
        public static final com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy IGNORE;
        public static final com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy LOG;
        public static final com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy THROW;

        /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            public void handle(java.lang.Throwable th) {
            }
        }

        /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor$UncaughtThrowableStrategy$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy
            public void handle(java.lang.Throwable th) {
                throw new java.lang.RuntimeException(th);
            }
        }

        static {
            com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy uncaughtThrowableStrategy = new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy("IGNORE", 0);
            IGNORE = uncaughtThrowableStrategy;
            com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.AnonymousClass1 anonymousClass1 = new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.AnonymousClass1("LOG", 1);
            LOG = anonymousClass1;
            com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.AnonymousClass2 anonymousClass2 = new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.AnonymousClass2("THROW", 2);
            THROW = anonymousClass2;
            $VALUES = new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy[]{uncaughtThrowableStrategy, anonymousClass1, anonymousClass2};
        }

        private UncaughtThrowableStrategy(java.lang.String str, int i) {
        }

        public /* synthetic */ UncaughtThrowableStrategy(java.lang.String str, int i, com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.AnonymousClass1 anonymousClass1) {
        }

        public static com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy valueOf(java.lang.String str) {
            return (com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy) java.lang.Enum.valueOf(com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.class, str);
        }

        public static com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy[] values() {
            return (com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy[]) $VALUES.clone();
        }

        public void handle(java.lang.Throwable th) {
        }
    }

    public FifoPriorityThreadPoolExecutor(int i) {
        this(i, com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy.LOG);
    }

    public FifoPriorityThreadPoolExecutor(int i, int i2, long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.ThreadFactory threadFactory, com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(i, i2, j, timeUnit, new java.util.concurrent.PriorityBlockingQueue(), threadFactory);
        this.ordering = new java.util.concurrent.atomic.AtomicInteger();
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }

    public FifoPriorityThreadPoolExecutor(int i, com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(i, i, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.DefaultThreadFactory(), uncaughtThrowableStrategy);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof java.util.concurrent.Future)) {
            java.util.concurrent.Future future = (java.util.concurrent.Future) runnable;
            if (!future.isDone() || future.isCancelled()) {
                return;
            }
            try {
                future.get();
            } catch (java.lang.InterruptedException e) {
                this.uncaughtThrowableStrategy.handle(e);
            } catch (java.util.concurrent.ExecutionException e2) {
                this.uncaughtThrowableStrategy.handle(e2);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.lang.Runnable runnable, T t) {
        return new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor.LoadTask(runnable, t, this.ordering.getAndIncrement());
    }
}
