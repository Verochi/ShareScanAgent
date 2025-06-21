package com.aliyun.common.ref;

/* loaded from: classes.dex */
public abstract class AbstractAtomicRefCounted implements com.aliyun.common.ref.Releasable {
    private final java.util.concurrent.atomic.AtomicInteger mRefCount;

    public AbstractAtomicRefCounted() {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger();
        this.mRefCount = atomicInteger;
        atomicInteger.set(1);
    }

    public abstract void onLastRef();

    public final void ref() {
        com.aliyun.common.utils.Assert.assertGreaterThan(this.mRefCount.incrementAndGet(), 1);
    }

    @Override // com.aliyun.common.ref.Releasable
    public final void release() {
        int decrementAndGet = this.mRefCount.decrementAndGet();
        if (decrementAndGet == 0) {
            onLastRef();
        } else {
            com.aliyun.common.utils.Assert.assertGreaterThan(decrementAndGet, 0);
        }
    }

    public void reset() {
        com.aliyun.common.utils.Assert.assertEquals(0, this.mRefCount.get());
        this.mRefCount.set(1);
    }
}
