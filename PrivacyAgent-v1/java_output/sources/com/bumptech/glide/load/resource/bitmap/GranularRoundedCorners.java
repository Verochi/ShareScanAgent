package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class GranularRoundedCorners extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {
    private static final java.lang.String ID = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";
    private static final byte[] ID_BYTES = ID.getBytes(com.bumptech.glide.load.Key.CHARSET);
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    public GranularRoundedCorners(float f, float f2, float f3, float f4) {
        this.topLeft = f;
        this.topRight = f2;
        this.bottomRight = f3;
        this.bottomLeft = f4;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners)) {
            return false;
        }
        com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners granularRoundedCorners = (com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners) obj;
        return this.topLeft == granularRoundedCorners.topLeft && this.topRight == granularRoundedCorners.topRight && this.bottomRight == granularRoundedCorners.bottomRight && this.bottomLeft == granularRoundedCorners.bottomLeft;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return com.bumptech.glide.util.Util.hashCode(this.bottomLeft, com.bumptech.glide.util.Util.hashCode(this.bottomRight, com.bumptech.glide.util.Util.hashCode(this.topRight, com.bumptech.glide.util.Util.hashCode(-2013597734, com.bumptech.glide.util.Util.hashCode(this.topLeft)))));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public android.graphics.Bitmap transform(@androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, @androidx.annotation.NonNull android.graphics.Bitmap bitmap, int i, int i2) {
        return com.bumptech.glide.load.resource.bitmap.TransformationUtils.roundedCorners(bitmapPool, bitmap, this.topLeft, this.topRight, this.bottomRight, this.bottomLeft);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(java.nio.ByteBuffer.allocate(16).putFloat(this.topLeft).putFloat(this.topRight).putFloat(this.bottomRight).putFloat(this.bottomLeft).array());
    }
}
