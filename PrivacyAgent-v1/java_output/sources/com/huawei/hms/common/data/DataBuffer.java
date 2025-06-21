package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public interface DataBuffer<T> extends com.huawei.hms.common.api.Releasable, java.lang.Iterable<T> {
    @java.lang.Deprecated
    void close();

    T get(int i);

    int getCount();

    android.os.Bundle getMetadata();

    @java.lang.Deprecated
    boolean isClosed();

    java.util.Iterator<T> iterator();

    @Override // com.huawei.hms.common.api.Releasable
    void release();

    java.util.Iterator<T> singleRefIterator();
}
