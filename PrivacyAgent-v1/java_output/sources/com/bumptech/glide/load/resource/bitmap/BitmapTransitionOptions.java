package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class BitmapTransitionOptions extends com.bumptech.glide.TransitionOptions<com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions, android.graphics.Bitmap> {
    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions with(@androidx.annotation.NonNull com.bumptech.glide.request.transition.TransitionFactory<android.graphics.Bitmap> transitionFactory) {
        return new com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions().transition(transitionFactory);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions withCrossFade() {
        return new com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions().crossFade();
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions withCrossFade(int i) {
        return new com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions().crossFade(i);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions withCrossFade(@androidx.annotation.NonNull com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder builder) {
        return new com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions().crossFade(builder);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions withCrossFade(@androidx.annotation.NonNull com.bumptech.glide.request.transition.DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions withWrapped(@androidx.annotation.NonNull com.bumptech.glide.request.transition.TransitionFactory<android.graphics.drawable.Drawable> transitionFactory) {
        return new com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions().transitionUsing(transitionFactory);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions crossFade() {
        return crossFade(new com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder());
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions crossFade(int i) {
        return crossFade(new com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder(i));
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions crossFade(@androidx.annotation.NonNull com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder builder) {
        return transitionUsing(builder.build());
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions crossFade(@androidx.annotation.NonNull com.bumptech.glide.request.transition.DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transitionUsing(drawableCrossFadeFactory);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions transitionUsing(@androidx.annotation.NonNull com.bumptech.glide.request.transition.TransitionFactory<android.graphics.drawable.Drawable> transitionFactory) {
        return transition(new com.bumptech.glide.request.transition.BitmapTransitionFactory(transitionFactory));
    }
}
