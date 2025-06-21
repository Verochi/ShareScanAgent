package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public class LruCache<T, Y> {
    private final java.util.LinkedHashMap<T, Y> cache = new java.util.LinkedHashMap<>(100, 0.75f, true);
    private int currentSize = 0;
    private final int initialMaxSize;
    private int maxSize;

    public LruCache(int i) {
        this.initialMaxSize = i;
        this.maxSize = i;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public boolean contains(T t) {
        return this.cache.containsKey(t);
    }

    public Y get(T t) {
        return this.cache.get(t);
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getSize(Y y) {
        return 1;
    }

    public void onItemEvicted(T t, Y y) {
    }

    public Y put(T t, Y y) {
        if (getSize(y) >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        Y put = this.cache.put(t, y);
        if (y != null) {
            this.currentSize += getSize(y);
        }
        if (put != null) {
            this.currentSize -= getSize(put);
        }
        evict();
        return put;
    }

    public Y remove(T t) {
        Y remove = this.cache.remove(t);
        if (remove != null) {
            this.currentSize -= getSize(remove);
        }
        return remove;
    }

    public void setSizeMultiplier(float f) {
        if (f < 0.0f) {
            throw new java.lang.IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = java.lang.Math.round(this.initialMaxSize * f);
        evict();
    }

    public void trimToSize(int i) {
        while (this.currentSize > i) {
            java.util.Map.Entry<T, Y> next = this.cache.entrySet().iterator().next();
            Y value = next.getValue();
            this.currentSize -= getSize(value);
            T key = next.getKey();
            this.cache.remove(key);
            onItemEvicted(key, value);
        }
    }
}
