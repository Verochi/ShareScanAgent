package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
abstract class AggregateFuture<InputT, OutputT> extends com.google.common.util.concurrent.AbstractFuture.TrustedFuture<OutputT> {
    public static final java.util.logging.Logger A = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.AggregateFuture.class.getName());

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public com.google.common.util.concurrent.AggregateFuture<InputT, OutputT>.RunningState z;

    public abstract class RunningState extends com.google.common.util.concurrent.AggregateFutureState implements java.lang.Runnable {
        public com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> w;
        public final boolean x;
        public final boolean y;

        /* renamed from: com.google.common.util.concurrent.AggregateFuture$RunningState$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ int n;
            public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture t;

            public AnonymousClass1(int i, com.google.common.util.concurrent.ListenableFuture listenableFuture) {
                this.n = i;
                this.t = listenableFuture;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.google.common.util.concurrent.AggregateFuture.RunningState.this.p(this.n, this.t);
                } finally {
                    com.google.common.util.concurrent.AggregateFuture.RunningState.this.m();
                }
            }
        }

        public RunningState(com.google.common.collect.ImmutableCollection<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
            super(immutableCollection.size());
            this.w = (com.google.common.collect.ImmutableCollection) com.google.common.base.Preconditions.checkNotNull(immutableCollection);
            this.x = z;
            this.y = z2;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState
        public final void e(java.util.Set<java.lang.Throwable> set) {
            if (com.google.common.util.concurrent.AggregateFuture.this.isCancelled()) {
                return;
            }
            com.google.common.util.concurrent.AggregateFuture.z(set, com.google.common.util.concurrent.AggregateFuture.this.tryInternalFastPathGetFailure());
        }

        public abstract void l(boolean z, int i, @org.checkerframework.checker.nullness.compatqual.NullableDecl InputT inputt);

        public final void m() {
            int f = f();
            com.google.common.base.Preconditions.checkState(f >= 0, "Less than 0 remaining futures");
            if (f == 0) {
                s();
            }
        }

        public abstract void n();

        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void o(java.lang.Throwable th) {
            boolean z;
            boolean z2;
            boolean z3;
            com.google.common.base.Preconditions.checkNotNull(th);
            if (this.x) {
                z = com.google.common.util.concurrent.AggregateFuture.this.setException(th);
                if (!z) {
                    z2 = com.google.common.util.concurrent.AggregateFuture.z(g(), th);
                    z3 = th instanceof java.lang.Error;
                    if (!((!z) & this.x & z2) && !z3) {
                        com.google.common.util.concurrent.AggregateFuture.A.log(java.util.logging.Level.SEVERE, z3 ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
                        return;
                    }
                    return;
                }
                t();
            } else {
                z = false;
            }
            z2 = true;
            z3 = th instanceof java.lang.Error;
            if (!(((!z) & this.x & z2) | z3)) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void p(int i, java.util.concurrent.Future<? extends InputT> future) {
            com.google.common.base.Preconditions.checkState(this.x || !com.google.common.util.concurrent.AggregateFuture.this.isDone() || com.google.common.util.concurrent.AggregateFuture.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                com.google.common.base.Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (this.x) {
                    if (future.isCancelled()) {
                        com.google.common.util.concurrent.AggregateFuture.this.z = null;
                        com.google.common.util.concurrent.AggregateFuture.this.cancel(false);
                    } else {
                        java.lang.Object done = com.google.common.util.concurrent.Futures.getDone(future);
                        if (this.y) {
                            l(this.x, i, done);
                        }
                    }
                } else if (this.y && !future.isCancelled()) {
                    l(this.x, i, com.google.common.util.concurrent.Futures.getDone(future));
                }
            } catch (java.util.concurrent.ExecutionException e) {
                o(e.getCause());
            } catch (java.lang.Throwable th) {
                o(th);
            }
        }

        public final void q() {
            if (this.w.isEmpty()) {
                n();
                return;
            }
            if (!this.x) {
                com.google.common.collect.UnmodifiableIterator<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> it = this.w.iterator();
                while (it.hasNext()) {
                    it.next().addListener(this, com.google.common.util.concurrent.MoreExecutors.directExecutor());
                }
                return;
            }
            com.google.common.collect.UnmodifiableIterator<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> it2 = this.w.iterator();
            int i = 0;
            while (it2.hasNext()) {
                com.google.common.util.concurrent.ListenableFuture<? extends InputT> next = it2.next();
                next.addListener(new com.google.common.util.concurrent.AggregateFuture.RunningState.AnonymousClass1(i, next), com.google.common.util.concurrent.MoreExecutors.directExecutor());
                i++;
            }
        }

        public void r() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            m();
        }

        public final void s() {
            if (this.y & (!this.x)) {
                com.google.common.collect.UnmodifiableIterator<? extends com.google.common.util.concurrent.ListenableFuture<? extends InputT>> it = this.w.iterator();
                int i = 0;
                while (it.hasNext()) {
                    p(i, it.next());
                    i++;
                }
            }
            n();
        }

        @com.google.errorprone.annotations.ForOverride
        @com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper
        public void t() {
            this.w = null;
        }
    }

    public static boolean z(java.util.Set<java.lang.Throwable> set, java.lang.Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public final void A(com.google.common.util.concurrent.AggregateFuture<InputT, OutputT>.RunningState runningState) {
        this.z = runningState;
        runningState.q();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        com.google.common.util.concurrent.AggregateFuture<InputT, OutputT>.RunningState runningState = this.z;
        if (runningState != null) {
            this.z = null;
            com.google.common.collect.ImmutableCollection immutableCollection = runningState.w;
            boolean wasInterrupted = wasInterrupted();
            if (wasInterrupted) {
                runningState.r();
            }
            if (isCancelled() && (immutableCollection != null)) {
                com.google.common.collect.UnmodifiableIterator it = immutableCollection.iterator();
                while (it.hasNext()) {
                    ((com.google.common.util.concurrent.ListenableFuture) it.next()).cancel(wasInterrupted);
                }
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public java.lang.String pendingToString() {
        com.google.common.collect.ImmutableCollection immutableCollection;
        com.google.common.util.concurrent.AggregateFuture<InputT, OutputT>.RunningState runningState = this.z;
        if (runningState == null || (immutableCollection = runningState.w) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + "]";
    }
}
