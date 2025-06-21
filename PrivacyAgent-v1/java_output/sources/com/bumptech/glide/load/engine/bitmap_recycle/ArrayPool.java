package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 65536;

    void clearMemory();

    <T> T get(int i, java.lang.Class<T> cls);

    <T> T getExact(int i, java.lang.Class<T> cls);

    <T> void put(T t);

    @java.lang.Deprecated
    <T> void put(T t, java.lang.Class<T> cls);

    void trimMemory(int i);
}
