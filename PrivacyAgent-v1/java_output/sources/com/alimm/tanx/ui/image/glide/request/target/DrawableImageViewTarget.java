package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public class DrawableImageViewTarget extends com.alimm.tanx.ui.image.glide.request.target.ImageViewTarget<android.graphics.drawable.Drawable> {
    public DrawableImageViewTarget(android.widget.ImageView imageView) {
        super(imageView);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.ImageViewTarget
    public void setResource(android.graphics.drawable.Drawable drawable) {
        ((android.widget.ImageView) this.view).setImageDrawable(drawable);
    }
}
