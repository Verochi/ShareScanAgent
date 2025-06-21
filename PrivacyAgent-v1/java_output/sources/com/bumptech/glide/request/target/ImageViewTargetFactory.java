package com.bumptech.glide.request.target;

/* loaded from: classes.dex */
public class ImageViewTargetFactory {
    @androidx.annotation.NonNull
    public <Z> com.bumptech.glide.request.target.ViewTarget<android.widget.ImageView, Z> buildTarget(@androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull java.lang.Class<Z> cls) {
        if (android.graphics.Bitmap.class.equals(cls)) {
            return new com.bumptech.glide.request.target.BitmapImageViewTarget(imageView);
        }
        if (android.graphics.drawable.Drawable.class.isAssignableFrom(cls)) {
            return new com.bumptech.glide.request.target.DrawableImageViewTarget(imageView);
        }
        throw new java.lang.IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
