package com.aliyun.common.media;

/* loaded from: classes.dex */
public class ShareableBitmap extends com.aliyun.common.buffer.AbstractAtomicShareable<com.aliyun.common.media.ShareableBitmap> {
    private boolean isDataUsed;
    private final android.graphics.Bitmap mData;

    public ShareableBitmap(android.graphics.Bitmap bitmap) {
        super(null);
        this.mData = bitmap;
    }

    public ShareableBitmap(com.aliyun.common.buffer.Recycler<com.aliyun.common.media.ShareableBitmap> recycler, int i, int i2) {
        super(recycler);
        this.mData = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_4444);
    }

    public android.graphics.Bitmap getData() {
        this.isDataUsed = true;
        return this.mData;
    }

    public boolean isDataUsed() {
        return this.isDataUsed;
    }

    @Override // com.aliyun.common.buffer.AbstractAtomicShareable, com.aliyun.common.ref.AbstractAtomicRefCounted
    public void onLastRef() {
        com.aliyun.common.buffer.Recycler<T> recycler = this.mRecycler;
        if (recycler != 0) {
            recycler.recycle(this);
        } else {
            if (this.mData.isRecycled()) {
                return;
            }
            this.mData.recycle();
        }
    }

    public void setDataUsed(boolean z) {
        this.isDataUsed = z;
    }
}
