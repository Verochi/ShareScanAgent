package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Monitor {
    public final boolean a;
    public final java.util.concurrent.locks.ReentrantLock b;

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public com.google.common.util.concurrent.Monitor.Guard c;

    @com.google.common.annotations.Beta
    public static abstract class Guard {

        @com.google.j2objc.annotations.Weak
        public final com.google.common.util.concurrent.Monitor a;
        public final java.util.concurrent.locks.Condition b;

        @com.google.errorprone.annotations.concurrent.GuardedBy("monitor.lock")
        public int c = 0;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        @com.google.errorprone.annotations.concurrent.GuardedBy("monitor.lock")
        public com.google.common.util.concurrent.Monitor.Guard d;

        public Guard(com.google.common.util.concurrent.Monitor monitor) {
            this.a = (com.google.common.util.concurrent.Monitor) com.google.common.base.Preconditions.checkNotNull(monitor, "monitor");
            this.b = monitor.b.newCondition();
        }

        public abstract boolean isSatisfied();
    }

    public Monitor() {
        this(false);
    }

    public Monitor(boolean z) {
        this.c = null;
        this.a = z;
        this.b = new java.util.concurrent.locks.ReentrantLock(z);
    }

    public static long g(long j) {
        if (j <= 0) {
            return 0L;
        }
        long nanoTime = java.lang.System.nanoTime();
        if (nanoTime == 0) {
            return 1L;
        }
        return nanoTime;
    }

    public static long i(long j, long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 - (java.lang.System.nanoTime() - j);
    }

    public static long l(long j, java.util.concurrent.TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        long j2 = 0;
        if (nanos > 0) {
            j2 = 6917529027641081853L;
            if (nanos <= 6917529027641081853L) {
                return nanos;
            }
        }
        return j2;
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void b(com.google.common.util.concurrent.Monitor.Guard guard, boolean z) throws java.lang.InterruptedException {
        if (z) {
            k();
        }
        e(guard);
        do {
            try {
                guard.b.await();
            } finally {
                f(guard);
            }
        } while (!guard.isSatisfied());
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final boolean c(com.google.common.util.concurrent.Monitor.Guard guard, long j, boolean z) throws java.lang.InterruptedException {
        boolean z2 = true;
        while (j > 0) {
            if (z2) {
                if (z) {
                    try {
                        k();
                    } finally {
                        if (!z2) {
                            f(guard);
                        }
                    }
                }
                e(guard);
                z2 = false;
            }
            j = guard.b.awaitNanos(j);
            if (guard.isSatisfied()) {
                if (!z2) {
                    f(guard);
                }
                return true;
            }
        }
        return false;
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void d(com.google.common.util.concurrent.Monitor.Guard guard, boolean z) {
        if (z) {
            k();
        }
        e(guard);
        do {
            try {
                guard.b.awaitUninterruptibly();
            } finally {
                f(guard);
            }
        } while (!guard.isSatisfied());
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void e(com.google.common.util.concurrent.Monitor.Guard guard) {
        int i = guard.c;
        guard.c = i + 1;
        if (i == 0) {
            guard.d = this.c;
            this.c = guard;
        }
    }

    public void enter() {
        this.b.lock();
    }

    public boolean enter(long j, java.util.concurrent.TimeUnit timeUnit) {
        boolean tryLock;
        long l = l(j, timeUnit);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        boolean z = true;
        if (!this.a && reentrantLock.tryLock()) {
            return true;
        }
        boolean interrupted = java.lang.Thread.interrupted();
        try {
            long nanoTime = java.lang.System.nanoTime();
            long j2 = l;
            while (true) {
                try {
                    try {
                        tryLock = reentrantLock.tryLock(j2, java.util.concurrent.TimeUnit.NANOSECONDS);
                        break;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (z) {
                            java.lang.Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (java.lang.InterruptedException unused) {
                    j2 = i(nanoTime, l);
                    interrupted = true;
                }
            }
            if (interrupted) {
                java.lang.Thread.currentThread().interrupt();
            }
            return tryLock;
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = interrupted;
        }
    }

    public boolean enterIf(com.google.common.util.concurrent.Monitor.Guard guard) {
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            boolean isSatisfied = guard.isSatisfied();
            if (!isSatisfied) {
            }
            return isSatisfied;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean enterIf(com.google.common.util.concurrent.Monitor.Guard guard, long j, java.util.concurrent.TimeUnit timeUnit) {
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        if (!enter(j, timeUnit)) {
            return false;
        }
        try {
            boolean isSatisfied = guard.isSatisfied();
            if (!isSatisfied) {
            }
            return isSatisfied;
        } finally {
            this.b.unlock();
        }
    }

    public boolean enterIfInterruptibly(com.google.common.util.concurrent.Monitor.Guard guard) throws java.lang.InterruptedException {
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        reentrantLock.lockInterruptibly();
        try {
            boolean isSatisfied = guard.isSatisfied();
            if (!isSatisfied) {
            }
            return isSatisfied;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean enterIfInterruptibly(com.google.common.util.concurrent.Monitor.Guard guard, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        if (!reentrantLock.tryLock(j, timeUnit)) {
            return false;
        }
        try {
            boolean isSatisfied = guard.isSatisfied();
            if (!isSatisfied) {
            }
            return isSatisfied;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void enterInterruptibly() throws java.lang.InterruptedException {
        this.b.lockInterruptibly();
    }

    public boolean enterInterruptibly(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        return this.b.tryLock(j, timeUnit);
    }

    public void enterWhen(com.google.common.util.concurrent.Monitor.Guard guard) throws java.lang.InterruptedException {
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        try {
            if (guard.isSatisfied()) {
                return;
            }
            b(guard, isHeldByCurrentThread);
        } catch (java.lang.Throwable th) {
            leave();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (c(r11, r0, r3) != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean enterWhen(com.google.common.util.concurrent.Monitor.Guard guard, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        long g;
        long l = l(j, timeUnit);
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        boolean z = false;
        try {
            if (!this.a) {
                if (java.lang.Thread.interrupted()) {
                    throw new java.lang.InterruptedException();
                }
                if (reentrantLock.tryLock()) {
                    g = 0;
                    if (!guard.isSatisfied()) {
                        if (g != 0) {
                            l = i(g, l);
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    return z;
                }
            }
            if (!guard.isSatisfied()) {
            }
            z = true;
            if (!z) {
            }
            return z;
        } catch (java.lang.Throwable th) {
            if (!isHeldByCurrentThread) {
                try {
                    k();
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw th;
        }
        g = g(l);
        if (!reentrantLock.tryLock(j, timeUnit)) {
            return false;
        }
    }

    public void enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor.Guard guard) {
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            if (guard.isSatisfied()) {
                return;
            }
            d(guard, isHeldByCurrentThread);
        } catch (java.lang.Throwable th) {
            leave();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[Catch: all -> 0x0073, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0073, blocks: (B:5:0x0012, B:7:0x001a, B:22:0x004b, B:32:0x0059, B:33:0x005c, B:34:0x0023, B:37:0x0028, B:13:0x0030, B:17:0x003b, B:18:0x0045, B:27:0x0041), top: B:4:0x0012, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean enterWhenUninterruptibly(com.google.common.util.concurrent.Monitor.Guard guard, long j, java.util.concurrent.TimeUnit timeUnit) {
        long g;
        long i;
        long l = l(j, timeUnit);
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        boolean interrupted = java.lang.Thread.interrupted();
        try {
            boolean z = true;
            if (!this.a && reentrantLock.tryLock()) {
                g = 0;
                while (!guard.isSatisfied()) {
                    try {
                        if (g == 0) {
                            g = g(l);
                            i = l;
                        } else {
                            i = i(g, l);
                        }
                        z = c(guard, i, isHeldByCurrentThread);
                    } catch (java.lang.InterruptedException unused) {
                        isHeldByCurrentThread = false;
                        interrupted = true;
                    } catch (java.lang.Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                if (!z) {
                    reentrantLock.unlock();
                }
                if (interrupted) {
                    java.lang.Thread.currentThread().interrupt();
                }
                return z;
            }
            g = g(l);
            long j2 = l;
            while (true) {
                try {
                    try {
                        break;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        interrupted = true;
                        if (interrupted) {
                            java.lang.Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (java.lang.InterruptedException unused2) {
                    j2 = i(g, l);
                    interrupted = true;
                }
            }
            if (!reentrantLock.tryLock(j2, java.util.concurrent.TimeUnit.NANOSECONDS)) {
                if (interrupted) {
                    java.lang.Thread.currentThread().interrupt();
                }
                return false;
            }
            while (!guard.isSatisfied()) {
            }
            if (!z) {
            }
            if (interrupted) {
            }
            return z;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void f(com.google.common.util.concurrent.Monitor.Guard guard) {
        int i = guard.c - 1;
        guard.c = i;
        if (i == 0) {
            com.google.common.util.concurrent.Monitor.Guard guard2 = this.c;
            com.google.common.util.concurrent.Monitor.Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.d;
            }
            if (guard3 == null) {
                this.c = guard2.d;
            } else {
                guard3.d = guard2.d;
            }
            guard2.d = null;
        }
    }

    public int getOccupiedDepth() {
        return this.b.getHoldCount();
    }

    public int getQueueLength() {
        return this.b.getQueueLength();
    }

    public int getWaitQueueLength(com.google.common.util.concurrent.Monitor.Guard guard) {
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        this.b.lock();
        try {
            return guard.c;
        } finally {
            this.b.unlock();
        }
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final boolean h(com.google.common.util.concurrent.Monitor.Guard guard) {
        try {
            return guard.isSatisfied();
        } catch (java.lang.Throwable th) {
            j();
            throw th;
        }
    }

    public boolean hasQueuedThread(java.lang.Thread thread) {
        return this.b.hasQueuedThread(thread);
    }

    public boolean hasQueuedThreads() {
        return this.b.hasQueuedThreads();
    }

    public boolean hasWaiters(com.google.common.util.concurrent.Monitor.Guard guard) {
        return getWaitQueueLength(guard) > 0;
    }

    public boolean isFair() {
        return this.a;
    }

    public boolean isOccupied() {
        return this.b.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.b.isHeldByCurrentThread();
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void j() {
        for (com.google.common.util.concurrent.Monitor.Guard guard = this.c; guard != null; guard = guard.d) {
            guard.b.signalAll();
        }
    }

    @com.google.errorprone.annotations.concurrent.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void k() {
        for (com.google.common.util.concurrent.Monitor.Guard guard = this.c; guard != null; guard = guard.d) {
            if (h(guard)) {
                guard.b.signal();
                return;
            }
        }
    }

    public void leave() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                k();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean tryEnter() {
        return this.b.tryLock();
    }

    public boolean tryEnterIf(com.google.common.util.concurrent.Monitor.Guard guard) {
        if (guard.a != this) {
            throw new java.lang.IllegalMonitorStateException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.b;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            boolean isSatisfied = guard.isSatisfied();
            if (!isSatisfied) {
            }
            return isSatisfied;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void waitFor(com.google.common.util.concurrent.Monitor.Guard guard) throws java.lang.InterruptedException {
        if (!(guard.a == this) || !this.b.isHeldByCurrentThread()) {
            throw new java.lang.IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return;
        }
        b(guard, true);
    }

    public boolean waitFor(com.google.common.util.concurrent.Monitor.Guard guard, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        long l = l(j, timeUnit);
        if (!(guard.a == this) || !this.b.isHeldByCurrentThread()) {
            throw new java.lang.IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return true;
        }
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        return c(guard, l, true);
    }

    public void waitForUninterruptibly(com.google.common.util.concurrent.Monitor.Guard guard) {
        if (!(guard.a == this) || !this.b.isHeldByCurrentThread()) {
            throw new java.lang.IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return;
        }
        d(guard, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean waitForUninterruptibly(com.google.common.util.concurrent.Monitor.Guard guard, long j, java.util.concurrent.TimeUnit timeUnit) {
        long l = l(j, timeUnit);
        boolean z = true;
        if (!(guard.a == this) || !this.b.isHeldByCurrentThread()) {
            throw new java.lang.IllegalMonitorStateException();
        }
        if (guard.isSatisfied()) {
            return true;
        }
        long g = g(l);
        boolean interrupted = java.lang.Thread.interrupted();
        long j2 = l;
        boolean z2 = true;
        while (true) {
            try {
                try {
                    boolean c = c(guard, j2, z2);
                    if (interrupted) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                    return c;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (z) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (java.lang.InterruptedException unused) {
                if (guard.isSatisfied()) {
                    java.lang.Thread.currentThread().interrupt();
                    return true;
                }
                j2 = i(g, l);
                interrupted = true;
                z2 = false;
            } catch (java.lang.Throwable th2) {
                th = th2;
                z = interrupted;
                if (z) {
                }
                throw th;
            }
        }
    }
}
