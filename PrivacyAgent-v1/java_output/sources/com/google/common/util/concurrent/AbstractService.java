package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class AbstractService implements com.google.common.util.concurrent.Service {
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> h = new com.google.common.util.concurrent.AbstractService.AnonymousClass1();
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> i = new com.google.common.util.concurrent.AbstractService.AnonymousClass2();
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> j;
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> k;
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> l;
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> m;
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> n;
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> o;
    public final com.google.common.util.concurrent.Monitor a = new com.google.common.util.concurrent.Monitor();
    public final com.google.common.util.concurrent.Monitor.Guard b = new com.google.common.util.concurrent.AbstractService.IsStartableGuard();
    public final com.google.common.util.concurrent.Monitor.Guard c = new com.google.common.util.concurrent.AbstractService.IsStoppableGuard();
    public final com.google.common.util.concurrent.Monitor.Guard d = new com.google.common.util.concurrent.AbstractService.HasReachedRunningGuard();
    public final com.google.common.util.concurrent.Monitor.Guard e = new com.google.common.util.concurrent.AbstractService.IsStoppedGuard();
    public final com.google.common.util.concurrent.ListenerCallQueue<com.google.common.util.concurrent.Service.Listener> f = new com.google.common.util.concurrent.ListenerCallQueue<>();
    public volatile com.google.common.util.concurrent.AbstractService.StateSnapshot g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(com.google.common.util.concurrent.Service.State.NEW);

    /* renamed from: com.google.common.util.concurrent.AbstractService$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> {
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(com.google.common.util.concurrent.Service.Listener listener) {
            listener.starting();
        }

        public java.lang.String toString() {
            return "starting()";
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractService$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> {
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(com.google.common.util.concurrent.Service.Listener listener) {
            listener.running();
        }

        public java.lang.String toString() {
            return "running()";
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractService$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> {
        public final /* synthetic */ com.google.common.util.concurrent.Service.State a;

        public AnonymousClass3(com.google.common.util.concurrent.Service.State state) {
            this.a = state;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(com.google.common.util.concurrent.Service.Listener listener) {
            listener.terminated(this.a);
        }

        public java.lang.String toString() {
            return "terminated({from = " + this.a + "})";
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractService$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> {
        public final /* synthetic */ com.google.common.util.concurrent.Service.State a;

        public AnonymousClass4(com.google.common.util.concurrent.Service.State state) {
            this.a = state;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(com.google.common.util.concurrent.Service.Listener listener) {
            listener.stopping(this.a);
        }

        public java.lang.String toString() {
            return "stopping({from = " + this.a + "})";
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractService$5, reason: invalid class name */
    public class AnonymousClass5 implements com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> {
        public final /* synthetic */ com.google.common.util.concurrent.Service.State a;
        public final /* synthetic */ java.lang.Throwable b;

        public AnonymousClass5(com.google.common.util.concurrent.Service.State state, java.lang.Throwable th) {
            this.a = state;
            this.b = th;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(com.google.common.util.concurrent.Service.Listener listener) {
            listener.failed(this.a, this.b);
        }

        public java.lang.String toString() {
            return "failed({from = " + this.a + ", cause = " + this.b + "})";
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractService$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.common.util.concurrent.Service.State.values().length];
            a = iArr;
            try {
                iArr[com.google.common.util.concurrent.Service.State.NEW.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.google.common.util.concurrent.Service.State.STARTING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.google.common.util.concurrent.Service.State.RUNNING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.google.common.util.concurrent.Service.State.STOPPING.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.google.common.util.concurrent.Service.State.TERMINATED.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.google.common.util.concurrent.Service.State.FAILED.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    public final class HasReachedRunningGuard extends com.google.common.util.concurrent.Monitor.Guard {
        public HasReachedRunningGuard() {
            super(com.google.common.util.concurrent.AbstractService.this.a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return com.google.common.util.concurrent.AbstractService.this.state().compareTo(com.google.common.util.concurrent.Service.State.RUNNING) >= 0;
        }
    }

    public final class IsStartableGuard extends com.google.common.util.concurrent.Monitor.Guard {
        public IsStartableGuard() {
            super(com.google.common.util.concurrent.AbstractService.this.a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return com.google.common.util.concurrent.AbstractService.this.state() == com.google.common.util.concurrent.Service.State.NEW;
        }
    }

    public final class IsStoppableGuard extends com.google.common.util.concurrent.Monitor.Guard {
        public IsStoppableGuard() {
            super(com.google.common.util.concurrent.AbstractService.this.a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return com.google.common.util.concurrent.AbstractService.this.state().compareTo(com.google.common.util.concurrent.Service.State.RUNNING) <= 0;
        }
    }

    public final class IsStoppedGuard extends com.google.common.util.concurrent.Monitor.Guard {
        public IsStoppedGuard() {
            super(com.google.common.util.concurrent.AbstractService.this.a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return com.google.common.util.concurrent.AbstractService.this.state().isTerminal();
        }
    }

    public static final class StateSnapshot {
        public final com.google.common.util.concurrent.Service.State a;
        public final boolean b;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final java.lang.Throwable c;

        public StateSnapshot(com.google.common.util.concurrent.Service.State state) {
            this(state, false, null);
        }

        public StateSnapshot(com.google.common.util.concurrent.Service.State state, boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
            com.google.common.base.Preconditions.checkArgument(!z || state == com.google.common.util.concurrent.Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            com.google.common.base.Preconditions.checkArgument(!((state == com.google.common.util.concurrent.Service.State.FAILED) ^ (th != null)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.a = state;
            this.b = z;
            this.c = th;
        }

        public com.google.common.util.concurrent.Service.State a() {
            return (this.b && this.a == com.google.common.util.concurrent.Service.State.STARTING) ? com.google.common.util.concurrent.Service.State.STOPPING : this.a;
        }

        public java.lang.Throwable b() {
            com.google.common.util.concurrent.Service.State state = this.a;
            com.google.common.base.Preconditions.checkState(state == com.google.common.util.concurrent.Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", state);
            return this.c;
        }
    }

    static {
        com.google.common.util.concurrent.Service.State state = com.google.common.util.concurrent.Service.State.STARTING;
        j = i(state);
        com.google.common.util.concurrent.Service.State state2 = com.google.common.util.concurrent.Service.State.RUNNING;
        k = i(state2);
        l = j(com.google.common.util.concurrent.Service.State.NEW);
        m = j(state);
        n = j(state2);
        o = j(com.google.common.util.concurrent.Service.State.STOPPING);
    }

    public static com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> i(com.google.common.util.concurrent.Service.State state) {
        return new com.google.common.util.concurrent.AbstractService.AnonymousClass4(state);
    }

    public static com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.Service.Listener> j(com.google.common.util.concurrent.Service.State state) {
        return new com.google.common.util.concurrent.AbstractService.AnonymousClass3(state);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(com.google.common.util.concurrent.Service.Listener listener, java.util.concurrent.Executor executor) {
        this.f.b(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.a.enterWhenUninterruptibly(this.d);
        try {
            b(com.google.common.util.concurrent.Service.State.RUNNING);
        } finally {
            this.a.leave();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j2, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        if (this.a.enterWhenUninterruptibly(this.d, j2, timeUnit)) {
            try {
                b(com.google.common.util.concurrent.Service.State.RUNNING);
            } finally {
                this.a.leave();
            }
        } else {
            throw new java.util.concurrent.TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.a.enterWhenUninterruptibly(this.e);
        try {
            b(com.google.common.util.concurrent.Service.State.TERMINATED);
        } finally {
            this.a.leave();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j2, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        if (this.a.enterWhenUninterruptibly(this.e, j2, timeUnit)) {
            try {
                b(com.google.common.util.concurrent.Service.State.TERMINATED);
            } finally {
                this.a.leave();
            }
        } else {
            throw new java.util.concurrent.TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + state());
        }
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy("monitor")
    public final void b(com.google.common.util.concurrent.Service.State state) {
        com.google.common.util.concurrent.Service.State state2 = state();
        if (state2 != state) {
            if (state2 == com.google.common.util.concurrent.Service.State.FAILED) {
                throw new java.lang.IllegalStateException("Expected the service " + this + " to be " + state + ", but the service has FAILED", failureCause());
            }
            throw new java.lang.IllegalStateException("Expected the service " + this + " to be " + state + ", but was " + state2);
        }
    }

    public final void c() {
        if (this.a.isOccupiedByCurrentThread()) {
            return;
        }
        this.f.c();
    }

    public final void d(com.google.common.util.concurrent.Service.State state, java.lang.Throwable th) {
        this.f.d(new com.google.common.util.concurrent.AbstractService.AnonymousClass5(state, th));
    }

    @com.google.errorprone.annotations.ForOverride
    public void doCancelStart() {
    }

    @com.google.errorprone.annotations.ForOverride
    public abstract void doStart();

    @com.google.errorprone.annotations.ForOverride
    public abstract void doStop();

    public final void e() {
        this.f.d(i);
    }

    public final void f() {
        this.f.d(h);
    }

    @Override // com.google.common.util.concurrent.Service
    public final java.lang.Throwable failureCause() {
        return this.g.b();
    }

    public final void g(com.google.common.util.concurrent.Service.State state) {
        if (state == com.google.common.util.concurrent.Service.State.STARTING) {
            this.f.d(j);
        } else {
            if (state != com.google.common.util.concurrent.Service.State.RUNNING) {
                throw new java.lang.AssertionError();
            }
            this.f.d(k);
        }
    }

    public final void h(com.google.common.util.concurrent.Service.State state) {
        switch (com.google.common.util.concurrent.AbstractService.AnonymousClass6.a[state.ordinal()]) {
            case 1:
                this.f.d(l);
                return;
            case 2:
                this.f.d(m);
                return;
            case 3:
                this.f.d(n);
                return;
            case 4:
                this.f.d(o);
                return;
            case 5:
            case 6:
                throw new java.lang.AssertionError();
            default:
                return;
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return state() == com.google.common.util.concurrent.Service.State.RUNNING;
    }

    public final void notifyFailed(java.lang.Throwable th) {
        com.google.common.base.Preconditions.checkNotNull(th);
        this.a.enter();
        try {
            com.google.common.util.concurrent.Service.State state = state();
            int i2 = com.google.common.util.concurrent.AbstractService.AnonymousClass6.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3 || i2 == 4) {
                    this.g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(com.google.common.util.concurrent.Service.State.FAILED, false, th);
                    d(state, th);
                } else if (i2 != 5) {
                }
                return;
            }
            throw new java.lang.IllegalStateException("Failed while in state:" + state, th);
        } finally {
            this.a.leave();
            c();
        }
    }

    public final void notifyStarted() {
        this.a.enter();
        try {
            if (this.g.a == com.google.common.util.concurrent.Service.State.STARTING) {
                if (this.g.b) {
                    this.g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(com.google.common.util.concurrent.Service.State.STOPPING);
                    doStop();
                } else {
                    this.g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(com.google.common.util.concurrent.Service.State.RUNNING);
                    e();
                }
                return;
            }
            java.lang.IllegalStateException illegalStateException = new java.lang.IllegalStateException("Cannot notifyStarted() when the service is " + this.g.a);
            notifyFailed(illegalStateException);
            throw illegalStateException;
        } finally {
            this.a.leave();
            c();
        }
    }

    public final void notifyStopped() {
        this.a.enter();
        try {
            com.google.common.util.concurrent.Service.State state = state();
            switch (com.google.common.util.concurrent.AbstractService.AnonymousClass6.a[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    throw new java.lang.IllegalStateException("Cannot notifyStopped() when the service is " + state);
                case 2:
                case 3:
                case 4:
                    this.g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(com.google.common.util.concurrent.Service.State.TERMINATED);
                    h(state);
                    break;
            }
        } finally {
            this.a.leave();
            c();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.util.concurrent.Service startAsync() {
        if (!this.a.enterIf(this.b)) {
            throw new java.lang.IllegalStateException("Service " + this + " has already been started");
        }
        try {
            this.g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(com.google.common.util.concurrent.Service.State.STARTING);
            f();
            doStart();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final com.google.common.util.concurrent.Service.State state() {
        return this.g.a();
    }

    @Override // com.google.common.util.concurrent.Service
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final com.google.common.util.concurrent.Service stopAsync() {
        if (this.a.enterIf(this.c)) {
            try {
                com.google.common.util.concurrent.Service.State state = state();
                switch (com.google.common.util.concurrent.AbstractService.AnonymousClass6.a[state.ordinal()]) {
                    case 1:
                        this.g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(com.google.common.util.concurrent.Service.State.TERMINATED);
                        h(com.google.common.util.concurrent.Service.State.NEW);
                        break;
                    case 2:
                        com.google.common.util.concurrent.Service.State state2 = com.google.common.util.concurrent.Service.State.STARTING;
                        this.g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(state2, true, null);
                        g(state2);
                        doCancelStart();
                        break;
                    case 3:
                        this.g = new com.google.common.util.concurrent.AbstractService.StateSnapshot(com.google.common.util.concurrent.Service.State.STOPPING);
                        g(com.google.common.util.concurrent.Service.State.RUNNING);
                        doStop();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        throw new java.lang.AssertionError("isStoppable is incorrectly implemented, saw: " + state);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return this;
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }
}
