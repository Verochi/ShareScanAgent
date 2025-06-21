package com.aliyun.common.buffer;

/* loaded from: classes.dex */
public class ByteBufferAllocator implements com.aliyun.common.buffer.Allocator<com.aliyun.common.buffer.ShareableByteBuffer> {
    private final boolean _Direct;
    private final int _Size;

    public ByteBufferAllocator(int i, boolean z) {
        this._Size = i;
        this._Direct = z;
    }

    @Override // com.aliyun.common.buffer.Allocator
    public com.aliyun.common.buffer.ShareableByteBuffer allocate(com.aliyun.common.buffer.Recycler<com.aliyun.common.buffer.ShareableByteBuffer> recycler, com.aliyun.common.buffer.ShareableByteBuffer shareableByteBuffer) {
        if (shareableByteBuffer == null) {
            return new com.aliyun.common.buffer.ShareableByteBuffer(recycler, this._Size, this._Direct);
        }
        shareableByteBuffer.reset();
        return shareableByteBuffer;
    }

    public int getSize() {
        return this._Size;
    }

    @Override // com.aliyun.common.buffer.Allocator
    public void recycle(com.aliyun.common.buffer.ShareableByteBuffer shareableByteBuffer) {
    }

    @Override // com.aliyun.common.buffer.Allocator
    public void release(com.aliyun.common.buffer.ShareableByteBuffer shareableByteBuffer) {
    }
}
