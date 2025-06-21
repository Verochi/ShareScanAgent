package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class CircleCrop extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {
    private static final java.lang.String ID = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = ID.getBytes(com.bumptech.glide.load.Key.CHARSET);
    private static final int VERSION = 1;

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        return obj instanceof com.bumptech.glide.load.resource.bitmap.CircleCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1101716364;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public android.graphics.Bitmap transform(@androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, @androidx.annotation.NonNull android.graphics.Bitmap bitmap, int i, int i2) {
        return com.bumptech.glide.load.resource.bitmap.TransformationUtils.circleCrop(bitmapPool, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
