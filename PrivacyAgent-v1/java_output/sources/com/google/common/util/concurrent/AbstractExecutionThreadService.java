package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class AbstractExecutionThreadService implements com.google.common.util.concurrent.Service {
    public static final java.util.logging.Logger b = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.AbstractExecutionThreadService.class.getName());
    public final com.google.common.util.concurrent.Service a = new com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1();

    /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.util.concurrent.AbstractService {

        /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1$1, reason: invalid class name and collision with other inner class name */
        public class C03541 implements com.google.common.base.Supplier<java.lang.String> {
            public C03541() {
            }

            @Override // com.google.common.base.Supplier
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.lang.String get() {
                return com.google.common.util.concurrent.AbstractExecutionThreadService.this.serviceName();
            }
        }

        /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.google.common.util.concurrent.AbstractExecutionThreadService.this.startUp();
                    com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1.this.notifyStarted();
                    if (com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1.this.isRunning()) {
                        try {
                            com.google.common.util.concurrent.AbstractExecutionThreadService.this.run();
                        } catch (java.lang.Throwable th) {
                            try {
                                com.google.common.util.concurrent.AbstractExecutionThreadService.this.shutDown();
                            } catch (java.lang.Exception e) {
                                com.google.common.util.concurrent.AbstractExecutionThreadService.b.log(java.util.logging.Level.WARNING, "Error while attempting to shut down the service after failure.", (java.lang.Throwable) e);
                            }
                            com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1.this.notifyFailed(th);
                            return;
                        }
                    }
                    com.google.common.util.concurrent.AbstractExecutionThreadService.this.shutDown();
                    com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1.this.notifyStopped();
                } catch (java.lang.Throwable th2) {
                    com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1.this.notifyFailed(th2);
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            com.google.common.util.concurrent.MoreExecutors.e(com.google.common.util.concurrent.AbstractExecutionThreadService.this.executor(), new com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1.C03541()).execute(new com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass1.AnonymousClass2());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            com.google.common.util.concurrent.AbstractExecutionThreadService.this.triggerShutdown();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public java.lang.String toString() {
            return com.google.common.util.concurrent.AbstractExecutionThreadService.this.toString();
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.concurrent.Executor {
        public AnonymousClass2() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            com.google.common.util.concurrent.MoreExecutors.c(com.google.common.util.concurrent.AbstractExecutionThreadService.this.serviceName(), runnable).start();
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

    public java.util.concurrent.Executor executor() {
        return new com.google.common.util.concurrent.AbstractExecutionThreadService.AnonymousClass2();
    }

    @Override // com.google.common.util.concurrent.Service
    public final java.lang.Throwable failureCause() {
        return this.a.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.a.isRunning();
    }

    public abstract void run() throws java.lang.Exception;

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

    public void triggerShutdown() {
    }
}
