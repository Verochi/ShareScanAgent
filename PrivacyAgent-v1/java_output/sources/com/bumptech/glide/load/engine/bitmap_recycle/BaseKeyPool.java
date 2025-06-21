package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
abstract class BaseKeyPool<T extends com.bumptech.glide.load.engine.bitmap_recycle.Poolable> {
    private static final int MAX_SIZE = 20;
    private final java.util.Queue<T> keyPool = com.bumptech.glide.util.Util.createQueue(20);

    public abstract T create();

    public T get() {
        T poll = this.keyPool.poll();
        return poll == null ? create() : poll;
    }

    public void offer(T t) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t);
        }
    }
}
