package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class ListenerCallQueue<L> {
    public static final java.util.logging.Logger b = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.ListenerCallQueue.class.getName());
    public final java.util.List<com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue<L>> a = java.util.Collections.synchronizedList(new java.util.ArrayList());

    public interface Event<L> {
        void call(L l);
    }

    public static final class PerListenerQueue<L> implements java.lang.Runnable {
        public final L n;
        public final java.util.concurrent.Executor t;

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public final java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue.Event<L>> u = com.google.common.collect.Queues.newArrayDeque();

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public final java.util.Queue<java.lang.Object> v = com.google.common.collect.Queues.newArrayDeque();

        @com.google.errorprone.annotations.concurrent.GuardedBy("this")
        public boolean w;

        public PerListenerQueue(L l, java.util.concurrent.Executor executor) {
            this.n = (L) com.google.common.base.Preconditions.checkNotNull(l);
            this.t = (java.util.concurrent.Executor) com.google.common.base.Preconditions.checkNotNull(executor);
        }

        public synchronized void a(com.google.common.util.concurrent.ListenerCallQueue.Event<L> event, java.lang.Object obj) {
            this.u.add(event);
            this.v.add(obj);
        }

        public void b() {
            boolean z;
            synchronized (this) {
                if (this.w) {
                    z = false;
                } else {
                    z = true;
                    this.w = true;
                }
            }
            if (z) {
                try {
                    this.t.execute(this);
                } catch (java.lang.RuntimeException e) {
                    synchronized (this) {
                        this.w = false;
                        com.google.common.util.concurrent.ListenerCallQueue.b.log(java.util.logging.Level.SEVERE, "Exception while running callbacks for " + this.n + " on " + this.t, (java.lang.Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            r2.call(r9.n);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            com.google.common.util.concurrent.ListenerCallQueue.b.log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.n + " " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x005b  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            java.lang.Throwable th;
            boolean z;
            while (true) {
                boolean z2 = true;
                try {
                    synchronized (this) {
                        try {
                            com.google.common.base.Preconditions.checkState(this.w);
                            com.google.common.util.concurrent.ListenerCallQueue.Event<L> poll = this.u.poll();
                            java.lang.Object poll2 = this.v.poll();
                            if (poll == null) {
                                this.w = false;
                                try {
                                    return;
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    z = false;
                                    while (true) {
                                        try {
                                            throw th;
                                        } catch (java.lang.Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                }
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            z = true;
                        }
                    }
                    try {
                        throw th;
                    } catch (java.lang.Throwable th5) {
                        boolean z3 = z;
                        th = th5;
                        z2 = z3;
                        if (z2) {
                            synchronized (this) {
                                this.w = false;
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    if (z2) {
                    }
                    throw th;
                }
            }
        }
    }

    public void b(L l, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(l, com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        com.google.common.base.Preconditions.checkNotNull(executor, "executor");
        this.a.add(new com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue<>(l, executor));
    }

    public void c() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).b();
        }
    }

    public void d(com.google.common.util.concurrent.ListenerCallQueue.Event<L> event) {
        e(event, event);
    }

    public final void e(com.google.common.util.concurrent.ListenerCallQueue.Event<L> event, java.lang.Object obj) {
        com.google.common.base.Preconditions.checkNotNull(event, "event");
        com.google.common.base.Preconditions.checkNotNull(obj, "label");
        synchronized (this.a) {
            java.util.Iterator<com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue<L>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(event, obj);
            }
        }
    }
}
