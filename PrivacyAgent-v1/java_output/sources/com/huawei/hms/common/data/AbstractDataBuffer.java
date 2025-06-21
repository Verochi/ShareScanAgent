package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public abstract class AbstractDataBuffer<T> extends com.huawei.hms.support.api.client.Result implements com.huawei.hms.common.data.DataBuffer<T> {
    protected final com.huawei.hms.common.data.DataHolder mDataHolder;

    public AbstractDataBuffer(com.huawei.hms.common.data.DataHolder dataHolder) {
        this.mDataHolder = dataHolder;
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    @java.lang.Deprecated
    public final void close() {
        release();
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public abstract T get(int i);

    @Override // com.huawei.hms.common.data.DataBuffer
    public int getCount() {
        com.huawei.hms.common.data.DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public android.os.Bundle getMetadata() {
        return this.mDataHolder.getMetadata();
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    @java.lang.Deprecated
    public boolean isClosed() {
        com.huawei.hms.common.data.DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return true;
        }
        return dataHolder.isClosed();
    }

    @Override // com.huawei.hms.common.data.DataBuffer, java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return new com.huawei.hms.common.data.DBInnerIter(this);
    }

    @Override // com.huawei.hms.common.data.DataBuffer, com.huawei.hms.common.api.Releasable
    public void release() {
        com.huawei.hms.common.data.DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public java.util.Iterator<T> singleRefIterator() {
        return new com.huawei.hms.common.data.SingleRefDBInnerIter(this);
    }
}
