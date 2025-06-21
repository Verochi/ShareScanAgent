package com.alimm.tanx.ui.image.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifDrawableResource extends com.alimm.tanx.ui.image.glide.load.resource.drawable.DrawableResource<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> {
    public GifDrawableResource(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(((com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable) this.drawable).getFirstFrame()) + ((com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable) this.drawable).getData().length;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        ((com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable) this.drawable).stop();
        ((com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable) this.drawable).recycle();
    }
}
