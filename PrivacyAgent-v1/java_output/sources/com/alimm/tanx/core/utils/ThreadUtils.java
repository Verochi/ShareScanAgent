package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public final class ThreadUtils implements com.alimm.tanx.core.utils.NotConfused {
    private static final byte TYPE_CACHED = -2;
    private static final byte TYPE_CPU = -8;
    private static final byte TYPE_IO = -4;
    private static final byte TYPE_SINGLE = -1;
    private static java.util.concurrent.Executor sDeliver;
    private static final android.os.Handler HANDLER = new android.os.Handler(android.os.Looper.getMainLooper());
    private static final java.util.Map<java.lang.Integer, java.util.Map<java.lang.Integer, java.util.concurrent.ExecutorService>> TYPE_PRIORITY_POOLS = new java.util.HashMap();
    private static final java.util.Map<com.alimm.tanx.core.utils.ThreadUtils.Task, java.util.concurrent.ExecutorService> TASK_POOL_MAP = new java.util.concurrent.ConcurrentHashMap();
    private static final int CPU_COUNT = java.lang.Runtime.getRuntime().availableProcessors();
    private static final java.util.Timer TIMER = new java.util.Timer();

    /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.TimerTask {
        final /* synthetic */ java.util.concurrent.ExecutorService tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.utils.ThreadUtils.Task tanxc_if;

        public AnonymousClass1(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task task) {
            this.tanxc_do = executorService;
            this.tanxc_if = task;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.tanxc_do.execute(this.tanxc_if);
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.util.TimerTask {
        final /* synthetic */ java.util.concurrent.ExecutorService tanxc_do;
        final /* synthetic */ com.alimm.tanx.core.utils.ThreadUtils.Task tanxc_if;

        public AnonymousClass2(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task task) {
            this.tanxc_do = executorService;
            this.tanxc_if = task;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.tanxc_do.execute(this.tanxc_if);
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.util.concurrent.Executor {
        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            com.alimm.tanx.core.utils.ThreadUtils.runOnUiThread(runnable);
        }
    }

    public static final class LinkedBlockingQueue4Util extends java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> implements com.alimm.tanx.core.utils.NotConfused {
        private int mCapacity;
        private volatile com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util mPool;

        public LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        public LinkedBlockingQueue4Util(int i) {
            this.mCapacity = i;
        }

        public LinkedBlockingQueue4Util(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(java.lang.Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer((com.alimm.tanx.core.utils.ThreadUtils.LinkedBlockingQueue4Util) runnable);
            }
            return false;
        }
    }

    public static abstract class SimpleTask<T> extends com.alimm.tanx.core.utils.ThreadUtils.Task<T> {
        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onCancel() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onCancel: ");
            sb.append(java.lang.Thread.currentThread());
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onFail(java.lang.Throwable th) {
        }
    }

    public static class SyncValue<T> implements com.alimm.tanx.core.utils.NotConfused {
        private T mValue;
        private java.util.concurrent.CountDownLatch mLatch = new java.util.concurrent.CountDownLatch(1);
        private java.util.concurrent.atomic.AtomicBoolean mFlag = new java.util.concurrent.atomic.AtomicBoolean();

        public T getValue() {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await();
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.mValue;
        }

        public T getValue(long j, java.util.concurrent.TimeUnit timeUnit, T t) {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await(j, timeUnit);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                    return t;
                }
            }
            return this.mValue;
        }

        public void setValue(T t) {
            if (this.mFlag.compareAndSet(false, true)) {
                this.mValue = t;
                this.mLatch.countDown();
            }
        }
    }

    public static abstract class Task<T> implements com.alimm.tanx.core.utils.NotConfused, java.lang.Runnable {
        private static final int CANCELLED = 4;
        private static final int COMPLETING = 3;
        private static final int EXCEPTIONAL = 2;
        private static final int INTERRUPTED = 5;
        private static final int NEW = 0;
        private static final int RUNNING = 1;
        private static final int TIMEOUT = 6;
        private java.util.concurrent.Executor deliver;
        private volatile boolean isSchedule;
        private com.alimm.tanx.core.utils.ThreadUtils.Task.OnTimeoutListener mTimeoutListener;
        private long mTimeoutMillis;
        private java.util.Timer mTimer;
        private volatile java.lang.Thread runner;
        private final java.util.concurrent.atomic.AtomicInteger state = new java.util.concurrent.atomic.AtomicInteger(0);

        /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$Task$1, reason: invalid class name */
        public class AnonymousClass1 extends java.util.TimerTask {
            public AnonymousClass1() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (com.alimm.tanx.core.utils.ThreadUtils.Task.this.isDone() || com.alimm.tanx.core.utils.ThreadUtils.Task.this.mTimeoutListener == null) {
                    return;
                }
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.timeout();
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.mTimeoutListener.onTimeout();
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.onDone();
            }
        }

        /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$Task$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Object tanxc_do;

            public AnonymousClass2(java.lang.Object obj) {
                this.tanxc_do = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.onSuccess(this.tanxc_do);
            }
        }

        /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$Task$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Object tanxc_do;

            public AnonymousClass3(java.lang.Object obj) {
                this.tanxc_do = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.onSuccess(this.tanxc_do);
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.onDone();
            }
        }

        /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$Task$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Throwable tanxc_do;

            public AnonymousClass4(java.lang.Throwable th) {
                this.tanxc_do = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.onFail(this.tanxc_do);
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.onDone();
            }
        }

        /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$Task$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.onCancel();
                com.alimm.tanx.core.utils.ThreadUtils.Task.this.onDone();
            }
        }

        public interface OnTimeoutListener {
            void onTimeout();
        }

        private java.util.concurrent.Executor getDeliver() {
            java.util.concurrent.Executor executor = this.deliver;
            return executor == null ? com.alimm.tanx.core.utils.ThreadUtils.getGlobalDeliver() : executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchedule(boolean z) {
            this.isSchedule = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeout() {
            synchronized (this.state) {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(6);
                if (this.runner != null) {
                    this.runner.interrupt();
                }
            }
        }

        public void cancel() {
            cancel(true);
        }

        public void cancel(boolean z) {
            synchronized (this.state) {
                if (this.state.get() > 1) {
                    return;
                }
                this.state.set(4);
                if (z && this.runner != null) {
                    this.runner.interrupt();
                }
                getDeliver().execute(new com.alimm.tanx.core.utils.ThreadUtils.Task.AnonymousClass5());
            }
        }

        public abstract T doInBackground() throws java.lang.Throwable;

        public boolean isCanceled() {
            return this.state.get() >= 4;
        }

        public boolean isDone() {
            return this.state.get() > 1;
        }

        public abstract void onCancel();

        public void onDone() {
            com.alimm.tanx.core.utils.ThreadUtils.TASK_POOL_MAP.remove(this);
            java.util.Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
                this.mTimeoutListener = null;
            }
        }

        public abstract void onFail(java.lang.Throwable th);

        public abstract void onSuccess(T t);

        @Override // java.lang.Runnable
        public void run() {
            if (this.isSchedule) {
                if (this.runner == null) {
                    if (!this.state.compareAndSet(0, 1)) {
                        return;
                    } else {
                        this.runner = java.lang.Thread.currentThread();
                    }
                } else if (this.state.get() != 1) {
                    return;
                }
            } else {
                if (!this.state.compareAndSet(0, 1)) {
                    return;
                }
                this.runner = java.lang.Thread.currentThread();
                if (this.mTimeoutListener != null) {
                    java.util.Timer timer = new java.util.Timer();
                    this.mTimer = timer;
                    timer.schedule(new com.alimm.tanx.core.utils.ThreadUtils.Task.AnonymousClass1(), this.mTimeoutMillis);
                }
            }
            try {
                T doInBackground = doInBackground();
                if (this.isSchedule) {
                    if (this.state.get() != 1) {
                        return;
                    }
                    getDeliver().execute(new com.alimm.tanx.core.utils.ThreadUtils.Task.AnonymousClass2(doInBackground));
                } else if (this.state.compareAndSet(1, 3)) {
                    getDeliver().execute(new com.alimm.tanx.core.utils.ThreadUtils.Task.AnonymousClass3(doInBackground));
                }
            } catch (java.lang.InterruptedException unused) {
                this.state.compareAndSet(4, 5);
            } catch (java.lang.Throwable th) {
                if (this.state.compareAndSet(1, 2)) {
                    getDeliver().execute(new com.alimm.tanx.core.utils.ThreadUtils.Task.AnonymousClass4(th));
                }
            }
        }

        public com.alimm.tanx.core.utils.ThreadUtils.Task<T> setDeliver(java.util.concurrent.Executor executor) {
            this.deliver = executor;
            return this;
        }

        public com.alimm.tanx.core.utils.ThreadUtils.Task<T> setTimeout(long j, com.alimm.tanx.core.utils.ThreadUtils.Task.OnTimeoutListener onTimeoutListener) {
            this.mTimeoutMillis = j;
            this.mTimeoutListener = onTimeoutListener;
            return this;
        }
    }

    public static final class ThreadPoolExecutor4Util extends java.util.concurrent.ThreadPoolExecutor implements com.alimm.tanx.core.utils.NotConfused {
        private final java.util.concurrent.atomic.AtomicInteger mSubmittedCount;
        private com.alimm.tanx.core.utils.ThreadUtils.LinkedBlockingQueue4Util mWorkQueue;

        public ThreadPoolExecutor4Util(int i, int i2, long j, java.util.concurrent.TimeUnit timeUnit, com.alimm.tanx.core.utils.ThreadUtils.LinkedBlockingQueue4Util linkedBlockingQueue4Util, java.util.concurrent.ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.mSubmittedCount = new java.util.concurrent.atomic.AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.mWorkQueue = linkedBlockingQueue4Util;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static java.util.concurrent.ExecutorService createPool(int i, int i2) {
            if (i == -8) {
                return new com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util(com.alimm.tanx.core.utils.ThreadUtils.CPU_COUNT + 1, (com.alimm.tanx.core.utils.ThreadUtils.CPU_COUNT * 2) + 1, 30L, java.util.concurrent.TimeUnit.SECONDS, new com.alimm.tanx.core.utils.ThreadUtils.LinkedBlockingQueue4Util(true), new com.alimm.tanx.core.utils.ThreadUtils.UtilsThreadFactory("cpu", i2));
            }
            if (i == -4) {
                return new com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util((com.alimm.tanx.core.utils.ThreadUtils.CPU_COUNT * 2) + 1, (com.alimm.tanx.core.utils.ThreadUtils.CPU_COUNT * 2) + 1, 30L, java.util.concurrent.TimeUnit.SECONDS, new com.alimm.tanx.core.utils.ThreadUtils.LinkedBlockingQueue4Util(), new com.alimm.tanx.core.utils.ThreadUtils.UtilsThreadFactory("io", i2));
            }
            if (i == -2) {
                return new com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util(0, 128, 60L, java.util.concurrent.TimeUnit.SECONDS, new com.alimm.tanx.core.utils.ThreadUtils.LinkedBlockingQueue4Util(true), new com.alimm.tanx.core.utils.ThreadUtils.UtilsThreadFactory("cached", i2));
            }
            if (i == -1) {
                return new com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new com.alimm.tanx.core.utils.ThreadUtils.LinkedBlockingQueue4Util(), new com.alimm.tanx.core.utils.ThreadUtils.UtilsThreadFactory("single", i2));
            }
            return new com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util(i, i, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new com.alimm.tanx.core.utils.ThreadUtils.LinkedBlockingQueue4Util(), new com.alimm.tanx.core.utils.ThreadUtils.UtilsThreadFactory("fixed(" + i + ")", i2));
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(java.lang.Runnable runnable, java.lang.Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.mSubmittedCount.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (java.util.concurrent.RejectedExecutionException unused) {
                this.mWorkQueue.offer(runnable);
            } catch (java.lang.Throwable unused2) {
                this.mSubmittedCount.decrementAndGet();
            }
        }
    }

    public static final class UtilsThreadFactory extends java.util.concurrent.atomic.AtomicLong implements com.alimm.tanx.core.utils.NotConfused, java.util.concurrent.ThreadFactory {
        private static final java.util.concurrent.atomic.AtomicInteger POOL_NUMBER = new java.util.concurrent.atomic.AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final java.lang.String namePrefix;
        private final int priority;

        /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$UtilsThreadFactory$1, reason: invalid class name */
        public class AnonymousClass1 extends java.lang.Thread {
            public AnonymousClass1(java.lang.Runnable runnable, java.lang.String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (java.lang.Throwable unused) {
                }
            }
        }

        /* renamed from: com.alimm.tanx.core.utils.ThreadUtils$UtilsThreadFactory$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Thread.UncaughtExceptionHandler {
            public AnonymousClass2() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                java.lang.System.out.println(th);
            }
        }

        public UtilsThreadFactory(java.lang.String str, int i) {
            this(str, i, false);
        }

        public UtilsThreadFactory(java.lang.String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            com.alimm.tanx.core.utils.ThreadUtils.UtilsThreadFactory.AnonymousClass1 anonymousClass1 = new com.alimm.tanx.core.utils.ThreadUtils.UtilsThreadFactory.AnonymousClass1(runnable, this.namePrefix + getAndIncrement());
            anonymousClass1.setDaemon(this.isDaemon);
            anonymousClass1.setUncaughtExceptionHandler(new com.alimm.tanx.core.utils.ThreadUtils.UtilsThreadFactory.AnonymousClass2());
            anonymousClass1.setPriority(this.priority);
            return anonymousClass1;
        }
    }

    public static void cancel(com.alimm.tanx.core.utils.ThreadUtils.Task task) {
        if (task == null) {
            return;
        }
        task.cancel();
    }

    public static void cancel(java.util.List<com.alimm.tanx.core.utils.ThreadUtils.Task> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (com.alimm.tanx.core.utils.ThreadUtils.Task task : list) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    public static void cancel(java.util.concurrent.ExecutorService executorService) {
        if (executorService instanceof com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util) {
            for (java.util.Map.Entry<com.alimm.tanx.core.utils.ThreadUtils.Task, java.util.concurrent.ExecutorService> entry : TASK_POOL_MAP.entrySet()) {
                if (entry.getValue() == executorService) {
                    cancel(entry.getKey());
                }
            }
        }
    }

    public static void cancel(com.alimm.tanx.core.utils.ThreadUtils.Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return;
        }
        for (com.alimm.tanx.core.utils.ThreadUtils.Task task : taskArr) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    private static <T> void execute(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task) {
        execute(executorService, task, 0L, 0L, null);
    }

    private static <T> void execute(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        java.util.Map<com.alimm.tanx.core.utils.ThreadUtils.Task, java.util.concurrent.ExecutorService> map = TASK_POOL_MAP;
        synchronized (map) {
            if (map.get(task) != null) {
                return;
            }
            map.put(task, executorService);
            if (j2 != 0) {
                task.setSchedule(true);
                TIMER.scheduleAtFixedRate(new com.alimm.tanx.core.utils.ThreadUtils.AnonymousClass2(executorService, task), timeUnit.toMillis(j), timeUnit.toMillis(j2));
            } else if (j == 0) {
                executorService.execute(task);
            } else {
                TIMER.schedule(new com.alimm.tanx.core.utils.ThreadUtils.AnonymousClass1(executorService, task), timeUnit.toMillis(j));
            }
        }
    }

    private static <T> void executeAtFixedRate(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        execute(executorService, task, j, j2, timeUnit);
    }

    public static <T> void executeByCached(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task) {
        execute(getPoolByTypeAndPriority(-2), task);
    }

    public static <T> void executeByCached(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, int i) {
        execute(getPoolByTypeAndPriority(-2, i), task);
    }

    public static <T> void executeByCachedAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, j, j2, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i), task, j, j2, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCachedAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-2), task, j, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeWithDelay(getPoolByTypeAndPriority(-2, i), task, j, timeUnit);
    }

    public static <T> void executeByCpu(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task) {
        execute(getPoolByTypeAndPriority(-8), task);
    }

    public static <T> void executeByCpu(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, int i) {
        execute(getPoolByTypeAndPriority(-8, i), task);
    }

    public static <T> void executeByCpuAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, j, j2, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i), task, j, j2, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i), task, 0L, j, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-8), task, j, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeWithDelay(getPoolByTypeAndPriority(-8, i), task, j, timeUnit);
    }

    public static <T> void executeByCustom(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task) {
        execute(executorService, task);
    }

    public static <T> void executeByCustomAtFixRate(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, j, j2, timeUnit);
    }

    public static <T> void executeByCustomAtFixRate(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, 0L, j, timeUnit);
    }

    public static <T> void executeByCustomWithDelay(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeWithDelay(executorService, task, j, timeUnit);
    }

    public static <T> void executeByFixed(int i, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task) {
        execute(getPoolByTypeAndPriority(i), task);
    }

    public static <T> void executeByFixed(int i, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, int i2) {
        execute(getPoolByTypeAndPriority(i, i2), task);
    }

    public static <T> void executeByFixedAtFixRate(int i, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i), task, j, j2, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(i, i2), task, j, j2, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i), task, 0L, j, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(int i, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i2) {
        executeAtFixedRate(getPoolByTypeAndPriority(i, i2), task, 0L, j, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(int i, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(i), task, j, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(int i, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i2) {
        executeWithDelay(getPoolByTypeAndPriority(i, i2), task, j, timeUnit);
    }

    public static <T> void executeByIo(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task) {
        execute(getPoolByTypeAndPriority(-4), task);
    }

    public static <T> void executeByIo(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, int i) {
        execute(getPoolByTypeAndPriority(-4, i), task);
    }

    public static <T> void executeByIoAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, j, j2, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i), task, j, j2, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, 0L, j, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i), task, 0L, j, timeUnit);
    }

    public static <T> void executeByIoWithDelay(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-4), task, j, timeUnit);
    }

    public static <T> void executeByIoWithDelay(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeWithDelay(getPoolByTypeAndPriority(-4, i), task, j, timeUnit);
    }

    public static <T> void executeBySingle(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task) {
        execute(getPoolByTypeAndPriority(-1), task);
    }

    public static <T> void executeBySingle(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, int i) {
        execute(getPoolByTypeAndPriority(-1, i), task);
    }

    public static <T> void executeBySingleAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, j, j2, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, long j2, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i), task, j, j2, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, 0L, j, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i), task, 0L, j, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-1), task, j, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit, int i) {
        executeWithDelay(getPoolByTypeAndPriority(-1, i), task, j, timeUnit);
    }

    private static <T> void executeWithDelay(java.util.concurrent.ExecutorService executorService, com.alimm.tanx.core.utils.ThreadUtils.Task<T> task, long j, java.util.concurrent.TimeUnit timeUnit) {
        execute(executorService, task, j, 0L, timeUnit);
    }

    public static java.util.concurrent.ExecutorService getCachedPool() {
        return getPoolByTypeAndPriority(-2);
    }

    public static java.util.concurrent.ExecutorService getCachedPool(int i) {
        return getPoolByTypeAndPriority(-2, i);
    }

    public static java.util.concurrent.ExecutorService getCpuPool() {
        return getPoolByTypeAndPriority(-8);
    }

    public static java.util.concurrent.ExecutorService getCpuPool(int i) {
        return getPoolByTypeAndPriority(-8, i);
    }

    public static java.util.concurrent.ExecutorService getFixedPool(int i) {
        return getPoolByTypeAndPriority(i);
    }

    public static java.util.concurrent.ExecutorService getFixedPool(int i, int i2) {
        return getPoolByTypeAndPriority(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.concurrent.Executor getGlobalDeliver() {
        if (sDeliver == null) {
            sDeliver = new com.alimm.tanx.core.utils.ThreadUtils.AnonymousClass3();
        }
        return sDeliver;
    }

    public static java.util.concurrent.ExecutorService getIoPool() {
        return getPoolByTypeAndPriority(-4);
    }

    public static java.util.concurrent.ExecutorService getIoPool(int i) {
        return getPoolByTypeAndPriority(-4, i);
    }

    public static android.os.Handler getMainHandler() {
        return HANDLER;
    }

    private static java.util.concurrent.ExecutorService getPoolByTypeAndPriority(int i) {
        return getPoolByTypeAndPriority(i, 5);
    }

    private static java.util.concurrent.ExecutorService getPoolByTypeAndPriority(int i, int i2) {
        java.util.concurrent.ExecutorService executorService;
        java.util.Map<java.lang.Integer, java.util.Map<java.lang.Integer, java.util.concurrent.ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            java.util.Map<java.lang.Integer, java.util.concurrent.ExecutorService> map2 = map.get(java.lang.Integer.valueOf(i));
            if (map2 == null) {
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
                executorService = com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util.createPool(i, i2);
                concurrentHashMap.put(java.lang.Integer.valueOf(i2), executorService);
                map.put(java.lang.Integer.valueOf(i), concurrentHashMap);
            } else {
                executorService = map2.get(java.lang.Integer.valueOf(i2));
                if (executorService == null) {
                    executorService = com.alimm.tanx.core.utils.ThreadUtils.ThreadPoolExecutor4Util.createPool(i, i2);
                    map2.put(java.lang.Integer.valueOf(i2), executorService);
                }
            }
        }
        return executorService;
    }

    public static java.util.concurrent.ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static java.util.concurrent.ExecutorService getSinglePool(int i) {
        return getPoolByTypeAndPriority(-1, i);
    }

    public static boolean isMainThread() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }

    public static void runOnUiThread(java.lang.Runnable runnable) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }

    public static void runOnUiThreadDelayed(java.lang.Runnable runnable, long j) {
        HANDLER.postDelayed(runnable, j);
    }

    public static void setDeliver(java.util.concurrent.Executor executor) {
        sDeliver = executor;
    }
}
