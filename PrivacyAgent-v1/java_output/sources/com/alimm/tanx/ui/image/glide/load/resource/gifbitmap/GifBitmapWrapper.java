package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

/* loaded from: classes.dex */
public class GifBitmapWrapper {
    private final com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> bitmapResource;
    private final com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> gifResource;

    public GifBitmapWrapper(com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource, com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resource2) {
        if (resource != null && resource2 != null) {
            throw new java.lang.IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (resource == null && resource2 == null) {
            throw new java.lang.IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.bitmapResource = resource;
        this.gifResource = resource2;
    }

    public com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> getBitmapResource() {
        return this.bitmapResource;
    }

    public com.alimm.tanx.ui.image.glide.load.engine.Resource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> getGifResource() {
        return this.gifResource;
    }

    public int getSize() {
        com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource = this.bitmapResource;
        return resource != null ? resource.getSize() : this.gifResource.getSize();
    }
}
