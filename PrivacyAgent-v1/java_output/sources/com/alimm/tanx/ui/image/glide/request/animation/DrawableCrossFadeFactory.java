package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public class DrawableCrossFadeFactory<T extends android.graphics.drawable.Drawable> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<T> {
    private static final int DEFAULT_DURATION_MS = 300;
    private final com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory<T> animationFactory;
    private final int duration;
    private com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeViewAnimation<T> firstResourceAnimation;
    private com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeViewAnimation<T> secondResourceAnimation;

    public static class DefaultAnimationFactory implements com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory {
        private final int duration;

        public DefaultAnimationFactory(int i) {
            this.duration = i;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public android.view.animation.Animation build() {
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.duration);
            return alphaAnimation;
        }
    }

    public DrawableCrossFadeFactory() {
        this(300);
    }

    public DrawableCrossFadeFactory(int i) {
        this.animationFactory = new com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory<>(new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory.DefaultAnimationFactory(i));
        this.duration = i;
    }

    public DrawableCrossFadeFactory(android.content.Context context, int i, int i2) {
        this.animationFactory = new com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory<>(context, i);
        this.duration = i2;
    }

    public DrawableCrossFadeFactory(android.view.animation.Animation animation, int i) {
        this.animationFactory = new com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory<>(animation);
        this.duration = i;
    }

    public DrawableCrossFadeFactory(com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory<T> viewAnimationFactory, int i) {
        this.animationFactory = viewAnimationFactory;
        this.duration = i;
    }

    private com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<T> getFirstResourceAnimation() {
        if (this.firstResourceAnimation == null) {
            this.firstResourceAnimation = new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, true), this.duration);
        }
        return this.firstResourceAnimation;
    }

    private com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<T> getSecondResourceAnimation() {
        if (this.secondResourceAnimation == null) {
            this.secondResourceAnimation = new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, false), this.duration);
        }
        return this.secondResourceAnimation;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<T> build(boolean z, boolean z2) {
        return z ? com.alimm.tanx.ui.image.glide.request.animation.NoAnimation.get() : z2 ? getFirstResourceAnimation() : getSecondResourceAnimation();
    }
}
