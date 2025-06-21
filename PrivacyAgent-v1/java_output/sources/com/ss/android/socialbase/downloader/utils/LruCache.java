package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class LruCache<K, T> extends java.util.LinkedHashMap<K, T> {
    private static final int DEFAULT_SIZE = 4;
    private int mMaxSize;

    public LruCache() {
        this(4, 4);
    }

    public LruCache(int i, int i2) {
        this(i, i2, true);
    }

    public LruCache(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        setMaxSize(i2);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(java.util.Map.Entry<K, T> entry) {
        return size() > this.mMaxSize;
    }

    public void setMaxSize(int i) {
        this.mMaxSize = i;
    }
}
