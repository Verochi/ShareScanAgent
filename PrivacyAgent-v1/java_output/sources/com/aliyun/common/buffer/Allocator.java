package com.aliyun.common.buffer;

/* loaded from: classes.dex */
public interface Allocator<T> {
    T allocate(com.aliyun.common.buffer.Recycler<T> recycler, T t);

    void recycle(T t);

    void release(T t);
}
