package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public class ImageViewTargetFactory {
    public <Z> com.alimm.tanx.ui.image.glide.request.target.Target<Z> buildTarget(android.widget.ImageView imageView, java.lang.Class<Z> cls) {
        if (com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable.class.isAssignableFrom(cls)) {
            return new com.alimm.tanx.ui.image.glide.request.target.GlideDrawableImageViewTarget(imageView);
        }
        if (android.graphics.Bitmap.class.equals(cls)) {
            return new com.alimm.tanx.ui.image.glide.request.target.BitmapImageViewTarget(imageView);
        }
        if (android.graphics.drawable.Drawable.class.isAssignableFrom(cls)) {
            return new com.alimm.tanx.ui.image.glide.request.target.DrawableImageViewTarget(imageView);
        }
        throw new java.lang.IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
