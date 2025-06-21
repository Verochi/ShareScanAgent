package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class FitCenter extends com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation {
    public FitCenter(android.content.Context context) {
        super(context);
    }

    public FitCenter(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        super(bitmapPool);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public java.lang.String getId() {
        return "FitCenter.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation
    public android.graphics.Bitmap transform(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap, int i, int i2) {
        return com.alimm.tanx.ui.image.glide.load.resource.bitmap.TransformationUtils.fitCenter(bitmap, bitmapPool, i, i2);
    }
}
