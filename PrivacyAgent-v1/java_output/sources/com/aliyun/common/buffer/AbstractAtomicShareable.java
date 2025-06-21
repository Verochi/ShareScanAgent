package com.aliyun.common.buffer;

/* loaded from: classes.dex */
public abstract class AbstractAtomicShareable<T> extends com.aliyun.common.ref.AbstractAtomicRefCounted {
    protected final com.aliyun.common.buffer.Recycler<T> mRecycler;

    public AbstractAtomicShareable(com.aliyun.common.buffer.Recycler<T> recycler) {
        this.mRecycler = recycler;
    }

    @Override // com.aliyun.common.ref.AbstractAtomicRefCounted
    public abstract void onLastRef();
}
