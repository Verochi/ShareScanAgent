package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public class SingleRefDBInnerIter<T> extends com.huawei.hms.common.data.DBInnerIter<T> {
    public SingleRefDBInnerIter(com.huawei.hms.common.data.DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.huawei.hms.common.data.DBInnerIter, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            return null;
        }
        int i = this.index + 1;
        this.index = i;
        if (i == 0) {
            com.huawei.hms.common.internal.Preconditions.checkState(this.dataBuffer.get(0) instanceof com.huawei.hms.common.data.DataBufferRef, "DataBuffer reference of type " + this.dataBuffer.get(0).getClass() + " is not movable");
            ((com.huawei.hms.common.data.DataBufferRef) this.dataBuffer.get(0)).getWindowIndex(this.index);
        }
        return (T) this.dataBuffer.get(0);
    }
}
