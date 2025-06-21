package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class CenterCrop extends com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation {
    public CenterCrop(android.content.Context context) {
        super(context);
    }

    public CenterCrop(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        super(bitmapPool);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public java.lang.String getId() {
        return "CenterCrop.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation
    public android.graphics.Bitmap transform(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap, int i, int i2) {
        android.graphics.Bitmap bitmap2 = bitmapPool.get(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Bitmap centerCrop = com.alimm.tanx.ui.image.glide.load.resource.bitmap.TransformationUtils.centerCrop(bitmap2, bitmap, i, i2);
        if (bitmap2 != null && bitmap2 != centerCrop && !bitmapPool.put(bitmap2)) {
            bitmap2.recycle();
        }
        return centerCrop;
    }
}
