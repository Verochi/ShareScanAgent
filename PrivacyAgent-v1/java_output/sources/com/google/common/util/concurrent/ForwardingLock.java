package com.google.common.util.concurrent;

/* loaded from: classes22.dex */
abstract class ForwardingLock implements java.util.concurrent.locks.Lock {
    public abstract java.util.concurrent.locks.Lock a();

    @Override // java.util.concurrent.locks.Lock
    public void lock() {
        a().lock();
    }

    @Override // java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws java.lang.InterruptedException {
        a().lockInterruptibly();
    }

    @Override // java.util.concurrent.locks.Lock
    public java.util.concurrent.locks.Condition newCondition() {
        return a().newCondition();
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock() {
        return a().tryLock();
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        return a().tryLock(j, timeUnit);
    }

    @Override // java.util.concurrent.locks.Lock
    public void unlock() {
        a().unlock();
    }
}
