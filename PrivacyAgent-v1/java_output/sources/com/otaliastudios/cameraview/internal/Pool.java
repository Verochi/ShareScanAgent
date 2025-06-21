package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class Pool<T> {
    public static final com.otaliastudios.cameraview.CameraLogger f = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.internal.Pool.class.getSimpleName());
    public int a;
    public int b;
    public java.util.concurrent.LinkedBlockingQueue<T> c;
    public com.otaliastudios.cameraview.internal.Pool.Factory<T> d;
    public final java.lang.Object e = new java.lang.Object();

    public interface Factory<T> {
        T create();
    }

    public Pool(int i, @androidx.annotation.NonNull com.otaliastudios.cameraview.internal.Pool.Factory<T> factory) {
        this.a = i;
        this.c = new java.util.concurrent.LinkedBlockingQueue<>(i);
        this.d = factory;
    }

    public final int activeCount() {
        int i;
        synchronized (this.e) {
            i = this.b;
        }
        return i;
    }

    @androidx.annotation.CallSuper
    public void clear() {
        synchronized (this.e) {
            this.c.clear();
        }
    }

    public final int count() {
        int activeCount;
        synchronized (this.e) {
            activeCount = activeCount() + recycledCount();
        }
        return activeCount;
    }

    @androidx.annotation.Nullable
    public T get() {
        synchronized (this.e) {
            T poll = this.c.poll();
            if (poll != null) {
                this.b++;
                f.v("GET - Reusing recycled item.", this);
                return poll;
            }
            if (isEmpty()) {
                f.v("GET - Returning null. Too much items requested.", this);
                return null;
            }
            this.b++;
            f.v("GET - Creating a new item.", this);
            return this.d.create();
        }
    }

    public boolean isEmpty() {
        boolean z;
        synchronized (this.e) {
            z = count() >= this.a;
        }
        return z;
    }

    public void recycle(@androidx.annotation.NonNull T t) {
        synchronized (this.e) {
            f.v("RECYCLE - Recycling item.", this);
            int i = this.b - 1;
            this.b = i;
            if (i < 0) {
                throw new java.lang.IllegalStateException("Trying to recycle an item which makes activeCount < 0. This means that this or some previous items being recycled were not coming from this pool, or some item was recycled more than once. " + this);
            }
            if (!this.c.offer(t)) {
                throw new java.lang.IllegalStateException("Trying to recycle an item while the queue is full. This means that this or some previous items being recycled were not coming from this pool, or some item was recycled more than once. " + this);
            }
        }
    }

    public final int recycledCount() {
        int size;
        synchronized (this.e) {
            size = this.c.size();
        }
        return size;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return getClass().getSimpleName() + " - count:" + count() + ", active:" + activeCount() + ", recycled:" + recycledCount();
    }
}
