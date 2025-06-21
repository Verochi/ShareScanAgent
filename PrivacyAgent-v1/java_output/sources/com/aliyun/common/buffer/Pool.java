package com.aliyun.common.buffer;

/* loaded from: classes.dex */
public class Pool<T> implements com.aliyun.common.buffer.Recycler<T>, com.aliyun.common.ref.Releasable {
    private final com.aliyun.common.buffer.Allocator<T> _Allocator;
    private final java.util.ArrayList<T> _Cache = new java.util.ArrayList<>();

    public Pool(com.aliyun.common.buffer.Allocator<T> allocator) {
        this._Allocator = allocator;
    }

    public T allocate() {
        T remove;
        if (this._Cache.isEmpty()) {
            remove = null;
        } else {
            remove = this._Cache.remove(r0.size() - 1);
        }
        return this._Allocator.allocate(this, remove);
    }

    public com.aliyun.common.buffer.Allocator<T> getAllocator() {
        return this._Allocator;
    }

    @Override // com.aliyun.common.buffer.Recycler
    public void recycle(T t) {
        this._Cache.add(t);
    }

    @Override // com.aliyun.common.ref.Releasable
    public void release() {
        java.util.Iterator<T> it = this._Cache.iterator();
        while (it.hasNext()) {
            this._Allocator.release(it.next());
        }
    }
}
