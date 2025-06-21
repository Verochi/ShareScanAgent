package com.bumptech.glide.load.resource.gif;

/* loaded from: classes.dex */
public class GifDrawableResource extends com.bumptech.glide.load.resource.drawable.DrawableResource<com.bumptech.glide.load.resource.gif.GifDrawable> {
    public GifDrawableResource(com.bumptech.glide.load.resource.gif.GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @androidx.annotation.NonNull
    public java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> getResourceClass() {
        return com.bumptech.glide.load.resource.gif.GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return ((com.bumptech.glide.load.resource.gif.GifDrawable) this.drawable).getSize();
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((com.bumptech.glide.load.resource.gif.GifDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        ((com.bumptech.glide.load.resource.gif.GifDrawable) this.drawable).stop();
        ((com.bumptech.glide.load.resource.gif.GifDrawable) this.drawable).recycle();
    }
}
