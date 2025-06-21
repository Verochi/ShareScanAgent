package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class ServiceManager {
    public static final java.util.logging.Logger c = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.ServiceManager.class.getName());
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.ServiceManager.Listener> d = new com.google.common.util.concurrent.ServiceManager.AnonymousClass1();
    public static final com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.ServiceManager.Listener> e = new com.google.common.util.concurrent.ServiceManager.AnonymousClass2();
    public final com.google.common.util.concurrent.ServiceManager.ServiceManagerState a;
    public final com.google.common.collect.ImmutableList<com.google.common.util.concurrent.Service> b;

    /* renamed from: com.google.common.util.concurrent.ServiceManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.ServiceManager.Listener> {
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(com.google.common.util.concurrent.ServiceManager.Listener listener) {
            listener.healthy();
        }

        public java.lang.String toString() {
            return "healthy()";
        }
    }

    /* renamed from: com.google.common.util.concurrent.ServiceManager$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.ServiceManager.Listener> {
        @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
        public void call(com.google.common.util.concurrent.ServiceManager.Listener listener) {
            listener.stopped();
        }

        public java.lang.String toString() {
            return "stopped()";
        }
    }

    public static final class EmptyServiceManagerWarning extends java.lang.Throwable {
        private EmptyServiceManagerWarning() {
        }

        public /* synthetic */ EmptyServiceManagerWarning(com.google.common.util.concurrent.ServiceManager.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @com.google.common.annotations.Beta
    public static abstract class Listener {
        public void failure(com.google.common.util.concurrent.Service service) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    public static final class NoOpService extends com.google.common.util.concurrent.AbstractService {
        public NoOpService() {
        }

        public /* synthetic */ NoOpService(com.google.common.util.concurrent.ServiceManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStart() {
            notifyStarted();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            notifyStopped();
        }
    }

    public static final class ServiceListener extends com.google.common.util.concurrent.Service.Listener {
        public final com.google.common.util.concurrent.Service a;
        public final java.lang.ref.WeakReference<com.google.common.util.concurrent.ServiceManager.ServiceManagerState> b;

        public ServiceListener(com.google.common.util.concurrent.Service service, java.lang.ref.WeakReference<com.google.common.util.concurrent.ServiceManager.ServiceManagerState> weakReference) {
            this.a = service;
            this.b = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(com.google.common.util.concurrent.Service.State state, java.lang.Throwable th) {
            com.google.common.util.concurrent.ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                if (!(this.a instanceof com.google.common.util.concurrent.ServiceManager.NoOpService)) {
                    com.google.common.util.concurrent.ServiceManager.c.log(java.util.logging.Level.SEVERE, "Service " + this.a + " has failed in the " + state + " state.", th);
                }
                serviceManagerState.n(this.a, state, com.google.common.util.concurrent.Service.State.FAILED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            com.google.common.util.concurrent.ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.a, com.google.common.util.concurrent.Service.State.STARTING, com.google.common.util.concurrent.Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            com.google.common.util.concurrent.ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.a, com.google.common.util.concurrent.Service.State.NEW, com.google.common.util.concurrent.Service.State.STARTING);
                if (this.a instanceof com.google.common.util.concurrent.ServiceManager.NoOpService) {
                    return;
                }
                com.google.common.util.concurrent.ServiceManager.c.log(java.util.logging.Level.FINE, "Starting {0}.", this.a);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(com.google.common.util.concurrent.Service.State state) {
            com.google.common.util.concurrent.ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.a, state, com.google.common.util.concurrent.Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(com.google.common.util.concurrent.Service.State state) {
            com.google.common.util.concurrent.ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
            if (serviceManagerState != null) {
                if (!(this.a instanceof com.google.common.util.concurrent.ServiceManager.NoOpService)) {
                    com.google.common.util.concurrent.ServiceManager.c.log(java.util.logging.Level.FINE, "Service {0} has terminated. Previous state was: {1}", new java.lang.Object[]{this.a, state});
                }
                serviceManagerState.n(this.a, state, com.google.common.util.concurrent.Service.State.TERMINATED);
            }
        }
    }

    public static final class ServiceManagerState {
        public final com.google.common.util.concurrent.Monitor a = new com.google.common.util.concurrent.Monitor();

        @com.google.errorprone.annotations.concurrent.GuardedBy("monitor")
        public final com.google.common.collect.SetMultimap<com.google.common.util.concurrent.Service.State, com.google.common.util.concurrent.Service> b;

        @com.google.errorprone.annotations.concurrent.GuardedBy("monitor")
        public final com.google.common.collect.Multiset<com.google.common.util.concurrent.Service.State> c;

        @com.google.errorprone.annotations.concurrent.GuardedBy("monitor")
        public final java.util.Map<com.google.common.util.concurrent.Service, com.google.common.base.Stopwatch> d;

        @com.google.errorprone.annotations.concurrent.GuardedBy("monitor")
        public boolean e;

        @com.google.errorprone.annotations.concurrent.GuardedBy("monitor")
        public boolean f;
        public final int g;
        public final com.google.common.util.concurrent.Monitor.Guard h;
        public final com.google.common.util.concurrent.Monitor.Guard i;
        public final com.google.common.util.concurrent.ListenerCallQueue<com.google.common.util.concurrent.ServiceManager.Listener> j;

        /* renamed from: com.google.common.util.concurrent.ServiceManager$ServiceManagerState$1, reason: invalid class name */
        public class AnonymousClass1 implements com.google.common.base.Function<java.util.Map.Entry<com.google.common.util.concurrent.Service, java.lang.Long>, java.lang.Long> {
            public AnonymousClass1() {
            }

            @Override // com.google.common.base.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public java.lang.Long apply(java.util.Map.Entry<com.google.common.util.concurrent.Service, java.lang.Long> entry) {
                return entry.getValue();
            }
        }

        /* renamed from: com.google.common.util.concurrent.ServiceManager$ServiceManagerState$2, reason: invalid class name */
        public class AnonymousClass2 implements com.google.common.util.concurrent.ListenerCallQueue.Event<com.google.common.util.concurrent.ServiceManager.Listener> {
            public final /* synthetic */ com.google.common.util.concurrent.Service a;

            public AnonymousClass2(com.google.common.util.concurrent.Service service) {
                this.a = service;
            }

            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(com.google.common.util.concurrent.ServiceManager.Listener listener) {
                listener.failure(this.a);
            }

            public java.lang.String toString() {
                return "failed({service=" + this.a + "})";
            }
        }

        public final class AwaitHealthGuard extends com.google.common.util.concurrent.Monitor.Guard {
            public AwaitHealthGuard() {
                super(com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this.a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @com.google.errorprone.annotations.concurrent.GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                int count = com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this.c.count(com.google.common.util.concurrent.Service.State.RUNNING);
                com.google.common.util.concurrent.ServiceManager.ServiceManagerState serviceManagerState = com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this;
                return count == serviceManagerState.g || serviceManagerState.c.contains(com.google.common.util.concurrent.Service.State.STOPPING) || com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this.c.contains(com.google.common.util.concurrent.Service.State.TERMINATED) || com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this.c.contains(com.google.common.util.concurrent.Service.State.FAILED);
            }
        }

        public final class StoppedGuard extends com.google.common.util.concurrent.Monitor.Guard {
            public StoppedGuard() {
                super(com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this.a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @com.google.errorprone.annotations.concurrent.GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                return com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this.c.count(com.google.common.util.concurrent.Service.State.TERMINATED) + com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this.c.count(com.google.common.util.concurrent.Service.State.FAILED) == com.google.common.util.concurrent.ServiceManager.ServiceManagerState.this.g;
            }
        }

        public ServiceManagerState(com.google.common.collect.ImmutableCollection<com.google.common.util.concurrent.Service> immutableCollection) {
            com.google.common.collect.SetMultimap<com.google.common.util.concurrent.Service.State, com.google.common.util.concurrent.Service> build = com.google.common.collect.MultimapBuilder.enumKeys(com.google.common.util.concurrent.Service.State.class).linkedHashSetValues().build();
            this.b = build;
            this.c = build.keys();
            this.d = com.google.common.collect.Maps.newIdentityHashMap();
            this.h = new com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AwaitHealthGuard();
            this.i = new com.google.common.util.concurrent.ServiceManager.ServiceManagerState.StoppedGuard();
            this.j = new com.google.common.util.concurrent.ListenerCallQueue<>();
            this.g = immutableCollection.size();
            build.putAll(com.google.common.util.concurrent.Service.State.NEW, immutableCollection);
        }

        public void a(com.google.common.util.concurrent.ServiceManager.Listener listener, java.util.concurrent.Executor executor) {
            this.j.b(listener, executor);
        }

        public void b() {
            this.a.enterWhenUninterruptibly(this.h);
            try {
                f();
            } finally {
                this.a.leave();
            }
        }

        public void c(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
            this.a.enter();
            try {
                if (this.a.waitForUninterruptibly(this.h, j, timeUnit)) {
                    f();
                    return;
                }
                throw new java.util.concurrent.TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + com.google.common.collect.Multimaps.filterKeys((com.google.common.collect.SetMultimap) this.b, com.google.common.base.Predicates.in(com.google.common.collect.ImmutableSet.of(com.google.common.util.concurrent.Service.State.NEW, com.google.common.util.concurrent.Service.State.STARTING))));
            } finally {
                this.a.leave();
            }
        }

        public void d() {
            this.a.enterWhenUninterruptibly(this.i);
            this.a.leave();
        }

        public void e(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
            this.a.enter();
            try {
                if (this.a.waitForUninterruptibly(this.i, j, timeUnit)) {
                    return;
                }
                throw new java.util.concurrent.TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + com.google.common.collect.Multimaps.filterKeys((com.google.common.collect.SetMultimap) this.b, com.google.common.base.Predicates.not(com.google.common.base.Predicates.in(java.util.EnumSet.of(com.google.common.util.concurrent.Service.State.TERMINATED, com.google.common.util.concurrent.Service.State.FAILED)))));
            } finally {
                this.a.leave();
            }
        }

        @com.google.errorprone.annotations.concurrent.GuardedBy("monitor")
        public void f() {
            com.google.common.collect.Multiset<com.google.common.util.concurrent.Service.State> multiset = this.c;
            com.google.common.util.concurrent.Service.State state = com.google.common.util.concurrent.Service.State.RUNNING;
            if (multiset.count(state) == this.g) {
                return;
            }
            throw new java.lang.IllegalStateException("Expected to be healthy after starting. The following services are not running: " + com.google.common.collect.Multimaps.filterKeys((com.google.common.collect.SetMultimap) this.b, com.google.common.base.Predicates.not(com.google.common.base.Predicates.equalTo(state))));
        }

        public void g() {
            com.google.common.base.Preconditions.checkState(!this.a.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.j.c();
        }

        public void h(com.google.common.util.concurrent.Service service) {
            this.j.d(new com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass2(service));
        }

        public void i() {
            this.j.d(com.google.common.util.concurrent.ServiceManager.d);
        }

        public void j() {
            this.j.d(com.google.common.util.concurrent.ServiceManager.e);
        }

        public void k() {
            this.a.enter();
            try {
                if (!this.f) {
                    this.e = true;
                    return;
                }
                java.util.ArrayList newArrayList = com.google.common.collect.Lists.newArrayList();
                com.google.common.collect.UnmodifiableIterator<com.google.common.util.concurrent.Service> it = l().values().iterator();
                while (it.hasNext()) {
                    com.google.common.util.concurrent.Service next = it.next();
                    if (next.state() != com.google.common.util.concurrent.Service.State.NEW) {
                        newArrayList.add(next);
                    }
                }
                throw new java.lang.IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + newArrayList);
            } finally {
                this.a.leave();
            }
        }

        public com.google.common.collect.ImmutableMultimap<com.google.common.util.concurrent.Service.State, com.google.common.util.concurrent.Service> l() {
            com.google.common.collect.ImmutableSetMultimap.Builder builder = com.google.common.collect.ImmutableSetMultimap.builder();
            this.a.enter();
            try {
                for (java.util.Map.Entry<com.google.common.util.concurrent.Service.State, com.google.common.util.concurrent.Service> entry : this.b.entries()) {
                    if (!(entry.getValue() instanceof com.google.common.util.concurrent.ServiceManager.NoOpService)) {
                        builder.put((java.util.Map.Entry) entry);
                    }
                }
                this.a.leave();
                return builder.build();
            } catch (java.lang.Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        public com.google.common.collect.ImmutableMap<com.google.common.util.concurrent.Service, java.lang.Long> m() {
            this.a.enter();
            try {
                java.util.ArrayList newArrayListWithCapacity = com.google.common.collect.Lists.newArrayListWithCapacity(this.d.size());
                for (java.util.Map.Entry<com.google.common.util.concurrent.Service, com.google.common.base.Stopwatch> entry : this.d.entrySet()) {
                    com.google.common.util.concurrent.Service key = entry.getKey();
                    com.google.common.base.Stopwatch value = entry.getValue();
                    if (!value.isRunning() && !(key instanceof com.google.common.util.concurrent.ServiceManager.NoOpService)) {
                        newArrayListWithCapacity.add(com.google.common.collect.Maps.immutableEntry(key, java.lang.Long.valueOf(value.elapsed(java.util.concurrent.TimeUnit.MILLISECONDS))));
                    }
                }
                this.a.leave();
                java.util.Collections.sort(newArrayListWithCapacity, com.google.common.collect.Ordering.natural().onResultOf(new com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass1()));
                return com.google.common.collect.ImmutableMap.copyOf(newArrayListWithCapacity);
            } catch (java.lang.Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        public void n(com.google.common.util.concurrent.Service service, com.google.common.util.concurrent.Service.State state, com.google.common.util.concurrent.Service.State state2) {
            com.google.common.base.Preconditions.checkNotNull(service);
            com.google.common.base.Preconditions.checkArgument(state != state2);
            this.a.enter();
            try {
                this.f = true;
                if (this.e) {
                    com.google.common.base.Preconditions.checkState(this.b.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                    com.google.common.base.Preconditions.checkState(this.b.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                    com.google.common.base.Stopwatch stopwatch = this.d.get(service);
                    if (stopwatch == null) {
                        stopwatch = com.google.common.base.Stopwatch.createStarted();
                        this.d.put(service, stopwatch);
                    }
                    com.google.common.util.concurrent.Service.State state3 = com.google.common.util.concurrent.Service.State.RUNNING;
                    if (state2.compareTo(state3) >= 0 && stopwatch.isRunning()) {
                        stopwatch.stop();
                        if (!(service instanceof com.google.common.util.concurrent.ServiceManager.NoOpService)) {
                            com.google.common.util.concurrent.ServiceManager.c.log(java.util.logging.Level.FINE, "Started {0} in {1}.", new java.lang.Object[]{service, stopwatch});
                        }
                    }
                    com.google.common.util.concurrent.Service.State state4 = com.google.common.util.concurrent.Service.State.FAILED;
                    if (state2 == state4) {
                        h(service);
                    }
                    if (this.c.count(state3) == this.g) {
                        i();
                    } else if (this.c.count(com.google.common.util.concurrent.Service.State.TERMINATED) + this.c.count(state4) == this.g) {
                        j();
                    }
                }
            } finally {
                this.a.leave();
                g();
            }
        }

        public void o(com.google.common.util.concurrent.Service service) {
            this.a.enter();
            try {
                if (this.d.get(service) == null) {
                    this.d.put(service, com.google.common.base.Stopwatch.createStarted());
                }
            } finally {
                this.a.leave();
            }
        }
    }

    public ServiceManager(java.lang.Iterable<? extends com.google.common.util.concurrent.Service> iterable) {
        com.google.common.collect.ImmutableList<com.google.common.util.concurrent.Service> copyOf = com.google.common.collect.ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            c.log(java.util.logging.Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (java.lang.Throwable) new com.google.common.util.concurrent.ServiceManager.EmptyServiceManagerWarning(null));
            copyOf = com.google.common.collect.ImmutableList.of(new com.google.common.util.concurrent.ServiceManager.NoOpService(null));
        }
        com.google.common.util.concurrent.ServiceManager.ServiceManagerState serviceManagerState = new com.google.common.util.concurrent.ServiceManager.ServiceManagerState(copyOf);
        this.a = serviceManagerState;
        this.b = copyOf;
        java.lang.ref.WeakReference weakReference = new java.lang.ref.WeakReference(serviceManagerState);
        com.google.common.collect.UnmodifiableIterator<com.google.common.util.concurrent.Service> it = copyOf.iterator();
        while (it.hasNext()) {
            com.google.common.util.concurrent.Service next = it.next();
            next.addListener(new com.google.common.util.concurrent.ServiceManager.ServiceListener(next, weakReference), com.google.common.util.concurrent.MoreExecutors.directExecutor());
            com.google.common.base.Preconditions.checkArgument(next.state() == com.google.common.util.concurrent.Service.State.NEW, "Can only manage NEW services, %s", next);
        }
        this.a.k();
    }

    public void addListener(com.google.common.util.concurrent.ServiceManager.Listener listener) {
        this.a.a(listener, com.google.common.util.concurrent.MoreExecutors.directExecutor());
    }

    public void addListener(com.google.common.util.concurrent.ServiceManager.Listener listener, java.util.concurrent.Executor executor) {
        this.a.a(listener, executor);
    }

    public void awaitHealthy() {
        this.a.b();
    }

    public void awaitHealthy(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        this.a.c(j, timeUnit);
    }

    public void awaitStopped() {
        this.a.d();
    }

    public void awaitStopped(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        this.a.e(j, timeUnit);
    }

    public boolean isHealthy() {
        com.google.common.collect.UnmodifiableIterator<com.google.common.util.concurrent.Service> it = this.b.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    public com.google.common.collect.ImmutableMultimap<com.google.common.util.concurrent.Service.State, com.google.common.util.concurrent.Service> servicesByState() {
        return this.a.l();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.util.concurrent.ServiceManager startAsync() {
        com.google.common.collect.UnmodifiableIterator<com.google.common.util.concurrent.Service> it = this.b.iterator();
        while (it.hasNext()) {
            com.google.common.util.concurrent.Service next = it.next();
            com.google.common.util.concurrent.Service.State state = next.state();
            com.google.common.base.Preconditions.checkState(state == com.google.common.util.concurrent.Service.State.NEW, "Service %s is %s, cannot start it.", next, state);
        }
        com.google.common.collect.UnmodifiableIterator<com.google.common.util.concurrent.Service> it2 = this.b.iterator();
        while (it2.hasNext()) {
            com.google.common.util.concurrent.Service next2 = it2.next();
            try {
                this.a.o(next2);
                next2.startAsync();
            } catch (java.lang.IllegalStateException e2) {
                c.log(java.util.logging.Level.WARNING, "Unable to start Service " + next2, (java.lang.Throwable) e2);
            }
        }
        return this;
    }

    public com.google.common.collect.ImmutableMap<com.google.common.util.concurrent.Service, java.lang.Long> startupTimes() {
        return this.a.m();
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public com.google.common.util.concurrent.ServiceManager stopAsync() {
        com.google.common.collect.UnmodifiableIterator<com.google.common.util.concurrent.Service> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().stopAsync();
        }
        return this;
    }

    public java.lang.String toString() {
        return com.google.common.base.MoreObjects.toStringHelper((java.lang.Class<?>) com.google.common.util.concurrent.ServiceManager.class).add("services", com.google.common.collect.Collections2.filter(this.b, com.google.common.base.Predicates.not(com.google.common.base.Predicates.instanceOf(com.google.common.util.concurrent.ServiceManager.NoOpService.class)))).toString();
    }
}
