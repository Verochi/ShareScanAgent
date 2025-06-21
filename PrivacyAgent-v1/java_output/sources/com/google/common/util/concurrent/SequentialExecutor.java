package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class SequentialExecutor implements java.util.concurrent.Executor {
    public static final java.util.logging.Logger x = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.SequentialExecutor.class.getName());
    public final java.util.concurrent.Executor n;

    @com.google.errorprone.annotations.concurrent.GuardedBy("queue")
    public final java.util.Deque<java.lang.Runnable> t = new java.util.ArrayDeque();

    @com.google.errorprone.annotations.concurrent.GuardedBy("queue")
    public com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState u = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE;

    @com.google.errorprone.annotations.concurrent.GuardedBy("queue")
    public long v = 0;
    public final com.google.common.util.concurrent.SequentialExecutor.QueueWorker w = new com.google.common.util.concurrent.SequentialExecutor.QueueWorker(this, null);

    /* renamed from: com.google.common.util.concurrent.SequentialExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.Runnable n;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.n = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.n.run();
        }
    }

    public final class QueueWorker implements java.lang.Runnable {
        public QueueWorker() {
        }

        public /* synthetic */ QueueWorker(com.google.common.util.concurrent.SequentialExecutor sequentialExecutor, com.google.common.util.concurrent.SequentialExecutor.AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0050, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
        
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        
            com.google.common.util.concurrent.SequentialExecutor.x.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            boolean z = false;
            boolean z2 = false;
            while (true) {
                try {
                    synchronized (com.google.common.util.concurrent.SequentialExecutor.this.t) {
                        if (!z) {
                            com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState workerRunningState = com.google.common.util.concurrent.SequentialExecutor.this.u;
                            com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState workerRunningState2 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING;
                            if (workerRunningState != workerRunningState2) {
                                com.google.common.util.concurrent.SequentialExecutor.d(com.google.common.util.concurrent.SequentialExecutor.this);
                                com.google.common.util.concurrent.SequentialExecutor.this.u = workerRunningState2;
                                z = true;
                            }
                        }
                        java.lang.Runnable runnable = (java.lang.Runnable) com.google.common.util.concurrent.SequentialExecutor.this.t.poll();
                        if (runnable == null) {
                            com.google.common.util.concurrent.SequentialExecutor.this.u = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE;
                        }
                    }
                    if (z2) {
                        java.lang.Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                } finally {
                    if (z2) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (java.lang.Error e) {
                synchronized (com.google.common.util.concurrent.SequentialExecutor.this.t) {
                    com.google.common.util.concurrent.SequentialExecutor.this.u = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }
    }

    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public SequentialExecutor(java.util.concurrent.Executor executor) {
        this.n = (java.util.concurrent.Executor) com.google.common.base.Preconditions.checkNotNull(executor);
    }

    public static /* synthetic */ long d(com.google.common.util.concurrent.SequentialExecutor sequentialExecutor) {
        long j = sequentialExecutor.v;
        sequentialExecutor.v = 1 + j;
        return j;
    }

    @Override // java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState workerRunningState;
        com.google.common.base.Preconditions.checkNotNull(runnable);
        synchronized (this.t) {
            com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState workerRunningState2 = this.u;
            if (workerRunningState2 != com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUED)) {
                long j = this.v;
                com.google.common.util.concurrent.SequentialExecutor.AnonymousClass1 anonymousClass1 = new com.google.common.util.concurrent.SequentialExecutor.AnonymousClass1(runnable);
                this.t.add(anonymousClass1);
                com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState workerRunningState3 = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING;
                this.u = workerRunningState3;
                try {
                    this.n.execute(this.w);
                    if (this.u != workerRunningState3) {
                        return;
                    }
                    synchronized (this.t) {
                        if (this.v == j && this.u == workerRunningState3) {
                            this.u = workerRunningState;
                        }
                    }
                    return;
                } catch (java.lang.Error | java.lang.RuntimeException e) {
                    synchronized (this.t) {
                        com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState workerRunningState4 = this.u;
                        if ((workerRunningState4 != com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE && workerRunningState4 != com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING) || !this.t.removeLastOccurrence(anonymousClass1)) {
                            r0 = false;
                        }
                        if (!(e instanceof java.util.concurrent.RejectedExecutionException) || r0) {
                            throw e;
                        }
                    }
                    return;
                }
            }
            this.t.add(runnable);
        }
    }
}
