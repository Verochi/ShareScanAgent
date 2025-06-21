package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public class BitmapTransitionFactory extends com.bumptech.glide.request.transition.BitmapContainerTransitionFactory<android.graphics.Bitmap> {
    public BitmapTransitionFactory(@androidx.annotation.NonNull com.bumptech.glide.request.transition.TransitionFactory<android.graphics.drawable.Drawable> transitionFactory) {
        super(transitionFactory);
    }

    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    @androidx.annotation.NonNull
    public android.graphics.Bitmap getBitmap(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
        return bitmap;
    }
}
