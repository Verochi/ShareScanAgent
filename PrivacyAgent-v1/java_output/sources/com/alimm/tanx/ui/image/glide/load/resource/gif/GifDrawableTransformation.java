package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifDrawableTransformation implements com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> wrapped;

    public GifDrawableTransformation(com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.wrapped = transformation;
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public java.lang.String getId() {
        return this.wrapped.getId();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resource, int i, int i2) {
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable gifDrawable = resource.get();
        android.graphics.Bitmap firstFrame = resource.get().getFirstFrame();
        android.graphics.Bitmap bitmap = this.wrapped.transform(new com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource(firstFrame, this.bitmapPool), i, i2).get();
        return !bitmap.equals(firstFrame) ? new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableResource(new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable(gifDrawable, bitmap, this.wrapped)) : resource;
    }
}
