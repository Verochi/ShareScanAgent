package com.igexin.base.scheduler;

/* loaded from: classes22.dex */
final class b extends java.util.concurrent.ScheduledThreadPoolExecutor {
    private static final java.util.concurrent.atomic.AtomicLong b = new java.util.concurrent.atomic.AtomicLong();
    com.igexin.base.scheduler.b.InterfaceC0367b a;

    public class a<V> extends java.util.concurrent.FutureTask<V> implements java.util.concurrent.RunnableScheduledFuture<V> {
        private com.igexin.base.scheduler.BaseTask b;
        private long c;
        private volatile long d;
        private final long e;
        private final int f;

        public a(com.igexin.base.scheduler.BaseTask baseTask, long j) {
            super(baseTask, null);
            this.b = baseTask;
            this.d = com.igexin.base.scheduler.b.a(com.igexin.base.scheduler.b.this, baseTask.getInitDelay(), java.util.concurrent.TimeUnit.MILLISECONDS);
            this.e = baseTask.getPeriod();
            this.f = baseTask.getTaskLevel();
            this.c = j;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(java.util.concurrent.Delayed delayed) {
            java.util.concurrent.Delayed delayed2 = delayed;
            if (delayed2 == this) {
                return 0;
            }
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS;
            long delay = getDelay(timeUnit);
            long delay2 = delayed2.getDelay(timeUnit);
            if (delayed2 instanceof com.igexin.base.scheduler.b.a) {
                com.igexin.base.scheduler.b.a aVar = (com.igexin.base.scheduler.b.a) delayed2;
                int i = this.f - aVar.f;
                if (delay <= 0 && delay2 <= 0) {
                    if (i > 0) {
                        return -1;
                    }
                    if (i < 0) {
                        return 1;
                    }
                }
                long j = delay - delay2;
                if (j > 0) {
                    return 1;
                }
                if (j < 0 || i > 0) {
                    return -1;
                }
                if (i < 0) {
                    return 1;
                }
                long j2 = this.c - aVar.c;
                if (j2 < 0) {
                    return -1;
                }
                if (j2 > 0) {
                    return 1;
                }
            }
            long j3 = delay - delay2;
            if (j3 < 0) {
                return -1;
            }
            return j3 > 0 ? 1 : 0;
        }

        @Override // java.util.concurrent.FutureTask
        public final void done() {
            this.b.setIsRunning(false);
            com.igexin.base.scheduler.b.a(com.igexin.base.scheduler.b.this, this.b);
            try {
                get();
                this.b.done();
            } catch (java.lang.Throwable th) {
                if (th instanceof java.util.concurrent.CancellationException) {
                    this.b.onCancel();
                } else {
                    this.b.onException(th);
                }
            }
        }

        @Override // java.util.concurrent.Delayed
        public final long getDelay(java.util.concurrent.TimeUnit timeUnit) {
            return timeUnit.convert(this.d - java.lang.System.nanoTime(), java.util.concurrent.TimeUnit.NANOSECONDS);
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public final boolean isPeriodic() {
            return this.e != 0;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            boolean isPeriodic = isPeriodic();
            if (com.igexin.base.scheduler.b.super.isShutdown()) {
                cancel(false);
                return;
            }
            if (!isPeriodic) {
                super.run();
                return;
            }
            if (super.runAndReset()) {
                long convert = java.util.concurrent.TimeUnit.NANOSECONDS.convert(this.e, java.util.concurrent.TimeUnit.MILLISECONDS);
                if (convert > 0) {
                    this.d += convert;
                } else {
                    this.d = com.igexin.base.scheduler.b.this.a(-convert);
                }
                com.igexin.base.scheduler.b.super.getQueue().add(this);
            }
        }
    }

    /* renamed from: com.igexin.base.scheduler.b$b, reason: collision with other inner class name */
    public interface InterfaceC0367b {
        void a(com.igexin.base.scheduler.BaseTask baseTask);
    }

    public b() {
        super(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j) {
        java.util.concurrent.Delayed delayed;
        long nanoTime = java.lang.System.nanoTime();
        if (j >= kotlin.time.DurationKt.MAX_MILLIS && (delayed = (java.util.concurrent.Delayed) super.getQueue().peek()) != null) {
            long delay = delayed.getDelay(java.util.concurrent.TimeUnit.NANOSECONDS);
            if (delay < 0 && j - delay < 0) {
                j = delay + Long.MAX_VALUE;
            }
        }
        return nanoTime + j;
    }

    public static /* synthetic */ long a(com.igexin.base.scheduler.b bVar, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j < 0) {
            j = 0;
        }
        return bVar.a(timeUnit.toNanos(j));
    }

    public static /* synthetic */ void a(com.igexin.base.scheduler.b bVar, com.igexin.base.scheduler.BaseTask baseTask) {
        com.igexin.base.scheduler.b.InterfaceC0367b interfaceC0367b = bVar.a;
        if (interfaceC0367b != null) {
            interfaceC0367b.a(baseTask);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public final <V> java.util.concurrent.RunnableScheduledFuture<V> decorateTask(java.lang.Runnable runnable, java.util.concurrent.RunnableScheduledFuture<V> runnableScheduledFuture) {
        com.igexin.base.scheduler.BaseTask baseTask = (com.igexin.base.scheduler.BaseTask) runnable;
        com.igexin.base.scheduler.b.a aVar = new com.igexin.base.scheduler.b.a(baseTask, b.getAndIncrement());
        baseTask.bind(aVar);
        return aVar;
    }
}
