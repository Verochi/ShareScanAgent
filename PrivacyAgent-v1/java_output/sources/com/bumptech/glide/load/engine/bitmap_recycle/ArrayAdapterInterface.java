package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
interface ArrayAdapterInterface<T> {
    int getArrayLength(T t);

    int getElementSizeInBytes();

    java.lang.String getTag();

    T newArray(int i);
}
