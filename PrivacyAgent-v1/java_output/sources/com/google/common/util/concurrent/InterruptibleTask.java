package com.google.common.util.concurrent;

@com.google.j2objc.annotations.ReflectionSupport(com.google.j2objc.annotations.ReflectionSupport.Level.FULL)
@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
abstract class InterruptibleTask<T> extends java.util.concurrent.atomic.AtomicReference<java.lang.Runnable> implements java.lang.Runnable {
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final java.lang.Runnable DONE = new com.google.common.util.concurrent.InterruptibleTask.DoNothingRunnable(null);
    private static final java.lang.Runnable INTERRUPTING = new com.google.common.util.concurrent.InterruptibleTask.DoNothingRunnable(null);
    private static final java.lang.Runnable PARKED = new com.google.common.util.concurrent.InterruptibleTask.DoNothingRunnable(null);

    public static final class DoNothingRunnable implements java.lang.Runnable {
        public DoNothingRunnable() {
        }

        public /* synthetic */ DoNothingRunnable(com.google.common.util.concurrent.InterruptibleTask.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public abstract void afterRanInterruptibly(@org.checkerframework.checker.nullness.compatqual.NullableDecl T t, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th);

    public final void interruptTask() {
        java.lang.Runnable runnable = get();
        if ((runnable instanceof java.lang.Thread) && compareAndSet(runnable, INTERRUPTING)) {
            try {
                ((java.lang.Thread) runnable).interrupt();
            } finally {
                if (getAndSet(DONE) == PARKED) {
                    java.util.concurrent.locks.LockSupport.unpark((java.lang.Thread) runnable);
                }
            }
        }
    }

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        T runInterruptibly;
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    runInterruptibly = runInterruptibly();
                } catch (java.lang.Throwable th) {
                    if (!compareAndSet(currentThread, DONE)) {
                        java.lang.Runnable runnable = get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            java.lang.Runnable runnable2 = INTERRUPTING;
                            if (runnable != runnable2 && runnable != PARKED) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                java.lang.Runnable runnable3 = PARKED;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                    z2 = java.lang.Thread.interrupted() || z2;
                                    java.util.concurrent.locks.LockSupport.park(this);
                                }
                            } else {
                                java.lang.Thread.yield();
                            }
                            runnable = get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        afterRanInterruptibly(null, th);
                        return;
                    }
                    return;
                }
            } else {
                runInterruptibly = null;
            }
            if (!compareAndSet(currentThread, DONE)) {
                java.lang.Runnable runnable4 = get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    java.lang.Runnable runnable5 = INTERRUPTING;
                    if (runnable4 != runnable5 && runnable4 != PARKED) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        java.lang.Runnable runnable6 = PARKED;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            z3 = java.lang.Thread.interrupted() || z3;
                            java.util.concurrent.locks.LockSupport.park(this);
                        }
                    } else {
                        java.lang.Thread.yield();
                    }
                    runnable4 = get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                afterRanInterruptibly(runInterruptibly, null);
            }
        }
    }

    public abstract T runInterruptibly() throws java.lang.Exception;

    public abstract java.lang.String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final java.lang.String toString() {
        java.lang.String str;
        java.lang.Runnable runnable = get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable == INTERRUPTING) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof java.lang.Thread) {
            str = "running=[RUNNING ON " + ((java.lang.Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + toPendingString();
    }
}
