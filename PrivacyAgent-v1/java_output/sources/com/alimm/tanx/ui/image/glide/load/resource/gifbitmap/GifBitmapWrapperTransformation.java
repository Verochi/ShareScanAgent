package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

/* loaded from: classes.dex */
public class GifBitmapWrapperTransformation implements com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> {
    private final com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> bitmapTransformation;
    private final com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> gifDataTransformation;

    public GifBitmapWrapperTransformation(com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation, com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> transformation2) {
        this.bitmapTransformation = transformation;
        this.gifDataTransformation = transformation2;
    }

    public GifBitmapWrapperTransformation(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation gifDrawableTransformation = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation(transformation, bitmapPool);
        this.bitmapTransformation = transformation;
        this.gifDataTransformation = gifDrawableTransformation;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public java.lang.String getId() {
        return this.bitmapTransformation.getId();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> transform(com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> resource, int i, int i2) {
        com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> transformation;
        com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap> transformation2;
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> bitmapResource = resource.get().getBitmapResource();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> gifResource = resource.get().getGifResource();
        if (bitmapResource != null && (transformation2 = this.bitmapTransformation) != null) {
            com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> transform = transformation2.transform(bitmapResource, i, i2);
            return !bitmapResource.equals(transform) ? new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResource(new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper(transform, resource.get().getGifResource())) : resource;
        }
        if (gifResource == null || (transformation = this.gifDataTransformation) == null) {
            return resource;
        }
        com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> transform2 = transformation.transform(gifResource, i, i2);
        return !gifResource.equals(transform2) ? new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperResource(new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper(resource.get().getBitmapResource(), transform2)) : resource;
    }
}
