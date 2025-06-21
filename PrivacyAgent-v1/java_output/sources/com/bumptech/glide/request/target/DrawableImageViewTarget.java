package com.bumptech.glide.request.target;

/* loaded from: classes.dex */
public class DrawableImageViewTarget extends com.bumptech.glide.request.target.ImageViewTarget<android.graphics.drawable.Drawable> {
    public DrawableImageViewTarget(android.widget.ImageView imageView) {
        super(imageView);
    }

    @java.lang.Deprecated
    public DrawableImageViewTarget(android.widget.ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        ((android.widget.ImageView) this.view).setImageDrawable(drawable);
    }
}
