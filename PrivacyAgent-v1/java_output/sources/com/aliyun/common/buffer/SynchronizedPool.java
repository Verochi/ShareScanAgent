package com.aliyun.common.buffer;

/* loaded from: classes.dex */
public class SynchronizedPool<T> implements com.aliyun.common.buffer.Recycler<T>, com.aliyun.common.ref.Releasable {
    private final com.aliyun.common.buffer.Allocator<T> _Allocator;
    private final java.util.ArrayList<T> _Cache;
    private int _Limit;
    private final com.aliyun.common.buffer.SynchronizedPool.OnBufferAvailableListener _OnBufferAvailableListener;

    public interface OnBufferAvailableListener {
        void onBufferAvailable(com.aliyun.common.buffer.SynchronizedPool<?> synchronizedPool);
    }

    public SynchronizedPool(com.aliyun.common.buffer.Allocator<T> allocator) {
        this(allocator, null, -1);
    }

    public SynchronizedPool(com.aliyun.common.buffer.Allocator<T> allocator, com.aliyun.common.buffer.SynchronizedPool.OnBufferAvailableListener onBufferAvailableListener, int i) {
        this._Cache = new java.util.ArrayList<>();
        this._Allocator = allocator;
        this._OnBufferAvailableListener = onBufferAvailableListener;
        this._Limit = i;
    }

    public synchronized T allocate() {
        if (!this._Cache.isEmpty()) {
            return this._Allocator.allocate(this, this._Cache.remove(r0.size() - 1));
        }
        int i = this._Limit;
        if (i == 0) {
            return null;
        }
        if (i > 0) {
            this._Limit = i - 1;
        }
        return this._Allocator.allocate(this, null);
    }

    public com.aliyun.common.buffer.Allocator<T> getAllocator() {
        return this._Allocator;
    }

    @Override // com.aliyun.common.buffer.Recycler
    public void recycle(T t) {
        boolean z;
        com.aliyun.common.buffer.SynchronizedPool.OnBufferAvailableListener onBufferAvailableListener;
        synchronized (this) {
            z = this._Limit == 0 && this._Cache.isEmpty();
            this._Cache.add(t);
        }
        if (!z || (onBufferAvailableListener = this._OnBufferAvailableListener) == null) {
            return;
        }
        onBufferAvailableListener.onBufferAvailable(this);
    }

    @Override // com.aliyun.common.ref.Releasable
    public synchronized void release() {
        java.util.Iterator<T> it = this._Cache.iterator();
        while (it.hasNext()) {
            this._Allocator.release(it.next());
        }
    }
}
