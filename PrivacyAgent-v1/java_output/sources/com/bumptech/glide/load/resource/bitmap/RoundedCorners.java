package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class RoundedCorners extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {
    private static final java.lang.String ID = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = ID.getBytes(com.bumptech.glide.load.Key.CHARSET);
    private final int roundingRadius;

    public RoundedCorners(int i) {
        com.bumptech.glide.util.Preconditions.checkArgument(i > 0, "roundingRadius must be greater than 0.");
        this.roundingRadius = i;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.bumptech.glide.load.resource.bitmap.RoundedCorners) && this.roundingRadius == ((com.bumptech.glide.load.resource.bitmap.RoundedCorners) obj).roundingRadius;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return com.bumptech.glide.util.Util.hashCode(-569625254, com.bumptech.glide.util.Util.hashCode(this.roundingRadius));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public android.graphics.Bitmap transform(@androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, @androidx.annotation.NonNull android.graphics.Bitmap bitmap, int i, int i2) {
        return com.bumptech.glide.load.resource.bitmap.TransformationUtils.roundedCorners(bitmapPool, bitmap, this.roundingRadius);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(java.nio.ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
