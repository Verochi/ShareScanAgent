package com.bumptech.glide.load.resource.drawable;

/* loaded from: classes.dex */
public final class DrawableTransitionOptions extends com.bumptech.glide.TransitionOptions<com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions, android.graphics.drawable.Drawable> {
    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions with(@androidx.annotation.NonNull com.bumptech.glide.request.transition.TransitionFactory<android.graphics.drawable.Drawable> transitionFactory) {
        return new com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions().transition(transitionFactory);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions withCrossFade() {
        return new com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions().crossFade();
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions withCrossFade(int i) {
        return new com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions().crossFade(i);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions withCrossFade(@androidx.annotation.NonNull com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder builder) {
        return new com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions().crossFade(builder);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions withCrossFade(@androidx.annotation.NonNull com.bumptech.glide.request.transition.DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions crossFade() {
        return crossFade(new com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder());
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions crossFade(int i) {
        return crossFade(new com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder(i));
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions crossFade(@androidx.annotation.NonNull com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder builder) {
        return crossFade(builder.build());
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions crossFade(@androidx.annotation.NonNull com.bumptech.glide.request.transition.DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transition(drawableCrossFadeFactory);
    }
}
