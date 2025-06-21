package com.aliyun.thumbnail;

/* loaded from: classes12.dex */
public class ThumbnailBitmapInfo {
    private long[] mPositionRange;
    private android.graphics.Bitmap mThumbnailBitmap;

    public long[] getPositionRange() {
        return this.mPositionRange;
    }

    public android.graphics.Bitmap getThumbnailBitmap() {
        return this.mThumbnailBitmap;
    }

    public void setPositionRange(long[] jArr) {
        this.mPositionRange = jArr;
    }

    public void setThumbnailBitmap(android.graphics.Bitmap bitmap) {
        this.mThumbnailBitmap = bitmap;
    }
}
