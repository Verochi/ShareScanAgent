package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class ExecutionList {
    public static final java.util.logging.Logger c = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.ExecutionList.class.getName());

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    @com.google.errorprone.annotations.concurrent.GuardedBy("this")
    public com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair a;

    @com.google.errorprone.annotations.concurrent.GuardedBy("this")
    public boolean b;

    public static final class RunnableExecutorPair {
        public final java.lang.Runnable a;
        public final java.util.concurrent.Executor b;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair c;

        public RunnableExecutorPair(java.lang.Runnable runnable, java.util.concurrent.Executor executor, com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair runnableExecutorPair) {
            this.a = runnable;
            this.b = executor;
            this.c = runnableExecutorPair;
        }
    }

    public static void a(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
        try {
            executor.execute(runnable);
        } catch (java.lang.RuntimeException e) {
            c.log(java.util.logging.Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (java.lang.Throwable) e);
        }
    }

    public void add(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
        com.google.common.base.Preconditions.checkNotNull(runnable, "Runnable was null.");
        com.google.common.base.Preconditions.checkNotNull(executor, "Executor was null.");
        synchronized (this) {
            if (this.b) {
                a(runnable, executor);
            } else {
                this.a = new com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair(runnable, executor, this.a);
            }
        }
    }

    public void execute() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair runnableExecutorPair = this.a;
            com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair runnableExecutorPair2 = null;
            this.a = null;
            while (runnableExecutorPair != null) {
                com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair runnableExecutorPair3 = runnableExecutorPair.c;
                runnableExecutorPair.c = runnableExecutorPair2;
                runnableExecutorPair2 = runnableExecutorPair;
                runnableExecutorPair = runnableExecutorPair3;
            }
            while (runnableExecutorPair2 != null) {
                a(runnableExecutorPair2.a, runnableExecutorPair2.b);
                runnableExecutorPair2 = runnableExecutorPair2.c;
            }
        }
    }
}
