package com.bumptech.glide.request.target;

/* loaded from: classes.dex */
public class DrawableThumbnailImageViewTarget extends com.bumptech.glide.request.target.ThumbnailImageViewTarget<android.graphics.drawable.Drawable> {
    public DrawableThumbnailImageViewTarget(android.widget.ImageView imageView) {
        super(imageView);
    }

    @java.lang.Deprecated
    public DrawableThumbnailImageViewTarget(android.widget.ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public android.graphics.drawable.Drawable getDrawable(android.graphics.drawable.Drawable drawable) {
        return drawable;
    }
}
