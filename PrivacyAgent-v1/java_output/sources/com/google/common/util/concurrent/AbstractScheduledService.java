package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class AbstractScheduledService implements com.google.common.util.concurrent.Service {
    public static final java.util.logging.Logger b = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.AbstractScheduledService.class.getName());
    public final com.google.common.util.concurrent.AbstractService a = new com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate(this, null);

    /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.util.concurrent.Service.Listener {
        public final /* synthetic */ java.util.concurrent.ScheduledExecutorService a;

        public AnonymousClass1(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(com.google.common.util.concurrent.Service.State state, java.lang.Throwable th) {
            this.a.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(com.google.common.util.concurrent.Service.State state) {
            this.a.shutdown();
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$1ThreadFactoryImpl, reason: invalid class name */
    public class C1ThreadFactoryImpl implements java.util.concurrent.ThreadFactory {
        public C1ThreadFactoryImpl() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return com.google.common.util.concurrent.MoreExecutors.c(com.google.common.util.concurrent.AbstractScheduledService.this.serviceName(), runnable);
        }
    }

    @com.google.common.annotations.Beta
    public static abstract class CustomScheduler extends com.google.common.util.concurrent.AbstractScheduledService.Scheduler {

        public class ReschedulableCallable extends com.google.common.util.concurrent.ForwardingFuture<java.lang.Void> implements java.util.concurrent.Callable<java.lang.Void> {
            public final java.lang.Runnable n;
            public final java.util.concurrent.ScheduledExecutorService t;
            public final com.google.common.util.concurrent.AbstractService u;
            public final java.util.concurrent.locks.ReentrantLock v = new java.util.concurrent.locks.ReentrantLock();

            @org.checkerframework.checker.nullness.compatqual.NullableDecl
            @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
            public java.util.concurrent.Future<java.lang.Void> w;

            public ReschedulableCallable(com.google.common.util.concurrent.AbstractService abstractService, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, java.lang.Runnable runnable) {
                this.n = runnable;
                this.t = scheduledExecutorService;
                this.u = abstractService;
            }

            @Override // java.util.concurrent.Callable
            public java.lang.Void call() throws java.lang.Exception {
                this.n.run();
                k();
                return null;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                this.v.lock();
                try {
                    return this.w.cancel(z);
                } finally {
                    this.v.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
            public java.util.concurrent.Future<java.lang.Void> delegate() {
                throw new java.lang.UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean isCancelled() {
                this.v.lock();
                try {
                    return this.w.isCancelled();
                } finally {
                    this.v.unlock();
                }
            }

            public void k() {
                try {
                    com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule nextSchedule = com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.this.getNextSchedule();
                    this.v.lock();
                    try {
                        java.util.concurrent.Future<java.lang.Void> future = this.w;
                        if (future == null || !future.isCancelled()) {
                            this.w = this.t.schedule(this, nextSchedule.a, nextSchedule.b);
                        }
                        this.v.unlock();
                        th = null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        this.v.unlock();
                    }
                    if (th != null) {
                        this.u.notifyFailed(th);
                    }
                } catch (java.lang.Throwable th2) {
                    this.u.notifyFailed(th2);
                }
            }
        }

        @com.google.common.annotations.Beta
        public static final class Schedule {
            public final long a;
            public final java.util.concurrent.TimeUnit b;

            public Schedule(long j, java.util.concurrent.TimeUnit timeUnit) {
                this.a = j;
                this.b = (java.util.concurrent.TimeUnit) com.google.common.base.Preconditions.checkNotNull(timeUnit);
            }
        }

        public CustomScheduler() {
            super(null);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        public final java.util.concurrent.Future<?> a(com.google.common.util.concurrent.AbstractService abstractService, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, java.lang.Runnable runnable) {
            com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.ReschedulableCallable reschedulableCallable = new com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.ReschedulableCallable(abstractService, scheduledExecutorService, runnable);
            reschedulableCallable.k();
            return reschedulableCallable;
        }

        public abstract com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule getNextSchedule() throws java.lang.Exception;
    }

    public static abstract class Scheduler {

        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$Scheduler$1, reason: invalid class name */
        public static class AnonymousClass1 extends com.google.common.util.concurrent.AbstractScheduledService.Scheduler {
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ java.util.concurrent.TimeUnit c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
                super(null);
                this.a = j;
                this.b = j2;
                this.c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public java.util.concurrent.Future<?> a(com.google.common.util.concurrent.AbstractService abstractService, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, java.lang.Runnable runnable) {
                return scheduledExecutorService.scheduleWithFixedDelay(runnable, this.a, this.b, this.c);
            }
        }

        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$Scheduler$2, reason: invalid class name */
        public static class AnonymousClass2 extends com.google.common.util.concurrent.AbstractScheduledService.Scheduler {
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ java.util.concurrent.TimeUnit c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
                super(null);
                this.a = j;
                this.b = j2;
                this.c = timeUnit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public java.util.concurrent.Future<?> a(com.google.common.util.concurrent.AbstractService abstractService, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, java.lang.Runnable runnable) {
                return scheduledExecutorService.scheduleAtFixedRate(runnable, this.a, this.b, this.c);
            }
        }

        public Scheduler() {
        }

        public /* synthetic */ Scheduler(com.google.common.util.concurrent.AbstractScheduledService.AnonymousClass1 anonymousClass1) {
            this();
        }

        public static com.google.common.util.concurrent.AbstractScheduledService.Scheduler newFixedDelaySchedule(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.base.Preconditions.checkNotNull(timeUnit);
            com.google.common.base.Preconditions.checkArgument(j2 > 0, "delay must be > 0, found %s", j2);
            return new com.google.common.util.concurrent.AbstractScheduledService.Scheduler.AnonymousClass1(j, j2, timeUnit);
        }

        public static com.google.common.util.concurrent.AbstractScheduledService.Scheduler newFixedRateSchedule(long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
            com.google.common.base.Preconditions.checkNotNull(timeUnit);
            com.google.common.base.Preconditions.checkArgument(j2 > 0, "period must be > 0, found %s", j2);
            return new com.google.common.util.concurrent.AbstractScheduledService.Scheduler.AnonymousClass2(j, j2, timeUnit);
        }

        public abstract java.util.concurrent.Future<?> a(com.google.common.util.concurrent.AbstractService abstractService, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, java.lang.Runnable runnable);
    }

    public final class ServiceDelegate extends com.google.common.util.concurrent.AbstractService {

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public volatile java.util.concurrent.Future<?> p;

        @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
        public volatile java.util.concurrent.ScheduledExecutorService q;
        public final java.util.concurrent.locks.ReentrantLock r;

        /* renamed from: s, reason: collision with root package name */
        public final java.lang.Runnable f372s;

        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.base.Supplier<java.lang.String> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.base.Supplier
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.lang.String get() {
                return com.google.common.util.concurrent.AbstractScheduledService.this.serviceName() + " " + com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.state();
            }
        }

        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.r.lock();
                try {
                    com.google.common.util.concurrent.AbstractScheduledService.this.startUp();
                    com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate serviceDelegate = com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this;
                    serviceDelegate.p = com.google.common.util.concurrent.AbstractScheduledService.this.scheduler().a(com.google.common.util.concurrent.AbstractScheduledService.this.a, com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.q, com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.f372s);
                    com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.notifyStarted();
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.r.lock();
                    try {
                        if (com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.state() != com.google.common.util.concurrent.Service.State.STOPPING) {
                            return;
                        }
                        com.google.common.util.concurrent.AbstractScheduledService.this.shutDown();
                        com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.r.unlock();
                        com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.notifyStopped();
                    } finally {
                        com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.r.unlock();
                    }
                } catch (java.lang.Throwable th) {
                    com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.notifyFailed(th);
                }
            }
        }

        public class Task implements java.lang.Runnable {
            public Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.r.lock();
                try {
                } finally {
                    try {
                    } finally {
                    }
                }
                if (com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.this.p.isCancelled()) {
                    return;
                }
                com.google.common.util.concurrent.AbstractScheduledService.this.runOneIteration();
            }
        }

        public ServiceDelegate() {
            this.r = new java.util.concurrent.locks.ReentrantLock();
            this.f372s = new com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.Task();
        }

        public /* synthetic */ ServiceDelegate(com.google.common.util.concurrent.AbstractScheduledService abstractScheduledService, com.google.common.util.concurrent.AbstractScheduledService.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            this.q = com.google.common.util.concurrent.MoreExecutors.f(com.google.common.util.concurrent.AbstractScheduledService.this.executor(), new com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.AnonymousClass1());
            this.q.execute(new com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.AnonymousClass2());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            this.p.cancel(false);
            this.q.execute(new com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.AnonymousClass3());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public java.lang.String toString() {
            return com.google.common.util.concurrent.AbstractScheduledService.this.toString();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(com.google.common.util.concurrent.Service.Listener listener, java.util.concurrent.Executor executor) {
        this.a.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.a.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        this.a.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.a.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        this.a.awaitTerminated(j, timeUnit);
    }

    public java.util.concurrent.ScheduledExecutorService executor() {
        java.util.concurrent.ScheduledExecutorService newSingleThreadScheduledExecutor = java.util.concurrent.Executors.newSingleThreadScheduledExecutor(new com.google.common.util.concurrent.AbstractScheduledService.C1ThreadFactoryImpl());
        addListener(new com.google.common.util.concurrent.AbstractScheduledService.AnonymousClass1(newSingleThreadScheduledExecutor), com.google.common.util.concurrent.MoreExecutors.directExecutor());
        return newSingleThreadScheduledExecutor;
    }

    @Override // com.google.common.util.concurrent.Service
    public final java.lang.Throwable failureCause() {
        return this.a.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.a.isRunning();
    }

    public abstract void runOneIteration() throws java.lang.Exception;

    public abstract com.google.common.util.concurrent.AbstractScheduledService.Scheduler scheduler();

    public java.lang.String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() throws java.lang.Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.util.concurrent.Service startAsync() {
        this.a.startAsync();
        return this;
    }

    public void startUp() throws java.lang.Exception {
    }

    @Override // com.google.common.util.concurrent.Service
    public final com.google.common.util.concurrent.Service.State state() {
        return this.a.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.util.concurrent.Service stopAsync() {
        this.a.stopAsync();
        return this;
    }

    public java.lang.String toString() {
        return serviceName() + " [" + state() + "]";
    }
}
