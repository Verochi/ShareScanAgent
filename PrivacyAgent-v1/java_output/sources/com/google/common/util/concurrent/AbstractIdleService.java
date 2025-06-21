package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class AbstractIdleService implements com.google.common.util.concurrent.Service {
    public final com.google.common.base.Supplier<java.lang.String> a = new com.google.common.util.concurrent.AbstractIdleService.ThreadNameSupplier(this, null);
    public final com.google.common.util.concurrent.Service b = new com.google.common.util.concurrent.AbstractIdleService.DelegateService(this, null);

    /* renamed from: com.google.common.util.concurrent.AbstractIdleService$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Executor {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            com.google.common.util.concurrent.MoreExecutors.c((java.lang.String) com.google.common.util.concurrent.AbstractIdleService.this.a.get(), runnable).start();
        }
    }

    public final class DelegateService extends com.google.common.util.concurrent.AbstractService {

        /* renamed from: com.google.common.util.concurrent.AbstractIdleService$DelegateService$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.google.common.util.concurrent.AbstractIdleService.this.startUp();
                    com.google.common.util.concurrent.AbstractIdleService.DelegateService.this.notifyStarted();
                } catch (java.lang.Throwable th) {
                    com.google.common.util.concurrent.AbstractIdleService.DelegateService.this.notifyFailed(th);
                }
            }
        }

        /* renamed from: com.google.common.util.concurrent.AbstractIdleService$DelegateService$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.google.common.util.concurrent.AbstractIdleService.this.shutDown();
                    com.google.common.util.concurrent.AbstractIdleService.DelegateService.this.notifyStopped();
                } catch (java.lang.Throwable th) {
                    com.google.common.util.concurrent.AbstractIdleService.DelegateService.this.notifyFailed(th);
                }
            }
        }

        public DelegateService() {
        }

        public /* synthetic */ DelegateService(com.google.common.util.concurrent.AbstractIdleService abstractIdleService, com.google.common.util.concurrent.AbstractIdleService.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            com.google.common.util.concurrent.MoreExecutors.e(com.google.common.util.concurrent.AbstractIdleService.this.executor(), com.google.common.util.concurrent.AbstractIdleService.this.a).execute(new com.google.common.util.concurrent.AbstractIdleService.DelegateService.AnonymousClass1());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            com.google.common.util.concurrent.MoreExecutors.e(com.google.common.util.concurrent.AbstractIdleService.this.executor(), com.google.common.util.concurrent.AbstractIdleService.this.a).execute(new com.google.common.util.concurrent.AbstractIdleService.DelegateService.AnonymousClass2());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public java.lang.String toString() {
            return com.google.common.util.concurrent.AbstractIdleService.this.toString();
        }
    }

    public final class ThreadNameSupplier implements com.google.common.base.Supplier<java.lang.String> {
        public ThreadNameSupplier() {
        }

        public /* synthetic */ ThreadNameSupplier(com.google.common.util.concurrent.AbstractIdleService abstractIdleService, com.google.common.util.concurrent.AbstractIdleService.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String get() {
            return com.google.common.util.concurrent.AbstractIdleService.this.serviceName() + " " + com.google.common.util.concurrent.AbstractIdleService.this.state();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(com.google.common.util.concurrent.Service.Listener listener, java.util.concurrent.Executor executor) {
        this.b.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.b.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        this.b.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.b.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        this.b.awaitTerminated(j, timeUnit);
    }

    public java.util.concurrent.Executor executor() {
        return new com.google.common.util.concurrent.AbstractIdleService.AnonymousClass1();
    }

    @Override // com.google.common.util.concurrent.Service
    public final java.lang.Throwable failureCause() {
        return this.b.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.b.isRunning();
    }

    public java.lang.String serviceName() {
        return getClass().getSimpleName();
    }

    public abstract void shutDown() throws java.lang.Exception;

    @Override // com.google.common.util.concurrent.Service
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.util.concurrent.Service startAsync() {
        this.b.startAsync();
        return this;
    }

    public abstract void startUp() throws java.lang.Exception;

    @Override // com.google.common.util.concurrent.Service
    public final com.google.common.util.concurrent.Service.State state() {
        return this.b.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.util.concurrent.Service stopAsync() {
        this.b.stopAsync();
        return this;
    }

    public java.lang.String toString() {
        return serviceName() + " [" + state() + "]";
    }
}
