package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public abstract class ImageViewTarget<Z> extends com.alimm.tanx.ui.image.glide.request.target.ViewTarget<android.widget.ImageView, Z> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter {
    public ImageViewTarget(android.widget.ImageView imageView) {
        super(imageView);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter
    public android.graphics.drawable.Drawable getCurrentDrawable() {
        return ((android.widget.ImageView) this.view).getDrawable();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
        ((android.widget.ImageView) this.view).setImageDrawable(drawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadFailed(java.lang.Exception exc, android.graphics.drawable.Drawable drawable) {
        ((android.widget.ImageView) this.view).setImageDrawable(drawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadStarted(android.graphics.drawable.Drawable drawable) {
        ((android.widget.ImageView) this.view).setImageDrawable(drawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onResourceReady(Z z, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super Z> glideAnimation) {
        if (glideAnimation == null || !glideAnimation.animate(z, this)) {
            setResource(z);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter
    public void setDrawable(android.graphics.drawable.Drawable drawable) {
        ((android.widget.ImageView) this.view).setImageDrawable(drawable);
    }

    public abstract void setResource(Z z);
}
