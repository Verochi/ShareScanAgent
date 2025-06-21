package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public class DBInnerIter<O> implements java.util.Iterator<O> {
    protected final com.huawei.hms.common.data.DataBuffer<O> dataBuffer;
    protected int index = -1;

    public DBInnerIter(com.huawei.hms.common.data.DataBuffer<O> dataBuffer) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(dataBuffer, "dataBuffer cannot be null");
        this.dataBuffer = dataBuffer;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index + 1 < this.dataBuffer.getCount();
    }

    @Override // java.util.Iterator
    public O next() {
        if (!hasNext()) {
            return null;
        }
        com.huawei.hms.common.data.DataBuffer<O> dataBuffer = this.dataBuffer;
        int i = this.index + 1;
        this.index = i;
        return dataBuffer.get(i);
    }
}
