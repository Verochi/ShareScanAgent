package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public abstract class BitmapTransformation implements com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> {
    private com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public BitmapTransformation(android.content.Context context) {
        this(com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool());
    }

    public BitmapTransformation(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    public abstract android.graphics.Bitmap transform(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap, int i, int i2);

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public final com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource, int i, int i2) {
        if (com.alimm.tanx.ui.image.glide.util.Util.isValidDimensions(i, i2)) {
            android.graphics.Bitmap bitmap = resource.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            android.graphics.Bitmap transform = transform(this.bitmapPool, bitmap, i, i2);
            return bitmap.equals(transform) ? resource : com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource.obtain(transform, this.bitmapPool);
        }
        throw new java.lang.IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
