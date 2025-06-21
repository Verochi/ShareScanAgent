package com.google.common.util.concurrent;

/* loaded from: classes22.dex */
abstract class ForwardingCondition implements java.util.concurrent.locks.Condition {
    public abstract java.util.concurrent.locks.Condition a();

    @Override // java.util.concurrent.locks.Condition
    public void await() throws java.lang.InterruptedException {
        a().await();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean await(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        return a().await(j, timeUnit);
    }

    @Override // java.util.concurrent.locks.Condition
    public long awaitNanos(long j) throws java.lang.InterruptedException {
        return a().awaitNanos(j);
    }

    @Override // java.util.concurrent.locks.Condition
    public void awaitUninterruptibly() {
        a().awaitUninterruptibly();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean awaitUntil(java.util.Date date) throws java.lang.InterruptedException {
        return a().awaitUntil(date);
    }

    @Override // java.util.concurrent.locks.Condition
    public void signal() {
        a().signal();
    }

    @Override // java.util.concurrent.locks.Condition
    public void signalAll() {
        a().signalAll();
    }
}
