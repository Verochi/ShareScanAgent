package com.aliyun.common.buffer;

/* loaded from: classes.dex */
public class ShareableByteBuffer extends com.aliyun.common.buffer.AbstractAtomicShareable<com.aliyun.common.buffer.ShareableByteBuffer> implements com.aliyun.common.buffer.ByteArrayHolder {
    private final java.nio.ByteBuffer _Data;

    public ShareableByteBuffer(com.aliyun.common.buffer.Recycler<com.aliyun.common.buffer.ShareableByteBuffer> recycler, int i, boolean z) {
        super(recycler);
        java.nio.ByteBuffer allocateDirect = z ? java.nio.ByteBuffer.allocateDirect(i) : java.nio.ByteBuffer.allocate(i);
        allocateDirect.position(0);
        allocateDirect.limit(0);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        this._Data = allocateDirect;
    }

    @Override // com.aliyun.common.buffer.ByteArrayHolder
    public byte[] getByteArray() {
        return this._Data.array();
    }

    public java.nio.ByteBuffer getData() {
        return this._Data;
    }

    @Override // com.aliyun.common.buffer.AbstractAtomicShareable, com.aliyun.common.ref.AbstractAtomicRefCounted
    public void onLastRef() {
        this.mRecycler.recycle(this);
    }
}
