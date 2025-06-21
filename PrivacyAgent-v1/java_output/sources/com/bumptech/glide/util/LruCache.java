package com.bumptech.glide.util;

/* loaded from: classes.dex */
public class LruCache<T, Y> {
    private final java.util.Map<T, Y> cache = new java.util.LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public LruCache(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(@androidx.annotation.NonNull T t) {
        return this.cache.containsKey(t);
    }

    @androidx.annotation.Nullable
    public synchronized Y get(@androidx.annotation.NonNull T t) {
        return this.cache.get(t);
    }

    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public int getSize(@androidx.annotation.Nullable Y y) {
        return 1;
    }

    public void onItemEvicted(@androidx.annotation.NonNull T t, @androidx.annotation.Nullable Y y) {
    }

    @androidx.annotation.Nullable
    public synchronized Y put(@androidx.annotation.NonNull T t, @androidx.annotation.Nullable Y y) {
        long size = getSize(y);
        if (size >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += size;
        }
        Y put = this.cache.put(t, y);
        if (put != null) {
            this.currentSize -= getSize(put);
            if (!put.equals(y)) {
                onItemEvicted(t, put);
            }
        }
        evict();
        return put;
    }

    @androidx.annotation.Nullable
    public synchronized Y remove(@androidx.annotation.NonNull T t) {
        Y remove;
        remove = this.cache.remove(t);
        if (remove != null) {
            this.currentSize -= getSize(remove);
        }
        return remove;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f < 0.0f) {
            throw new java.lang.IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = java.lang.Math.round(this.initialMaxSize * f);
        evict();
    }

    public synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            java.util.Iterator<java.util.Map.Entry<T, Y>> it = this.cache.entrySet().iterator();
            java.util.Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.currentSize -= getSize(value);
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value);
        }
    }
}
