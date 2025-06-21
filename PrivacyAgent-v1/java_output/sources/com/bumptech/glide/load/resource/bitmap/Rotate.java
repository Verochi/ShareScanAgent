package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class Rotate extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {
    private static final java.lang.String ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = ID.getBytes(com.bumptech.glide.load.Key.CHARSET);
    private final int degreesToRotate;

    public Rotate(int i) {
        this.degreesToRotate = i;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.bumptech.glide.load.resource.bitmap.Rotate) && this.degreesToRotate == ((com.bumptech.glide.load.resource.bitmap.Rotate) obj).degreesToRotate;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return com.bumptech.glide.util.Util.hashCode(-950519196, com.bumptech.glide.util.Util.hashCode(this.degreesToRotate));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public android.graphics.Bitmap transform(@androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, @androidx.annotation.NonNull android.graphics.Bitmap bitmap, int i, int i2) {
        return com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImage(bitmap, this.degreesToRotate);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(java.nio.ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}
