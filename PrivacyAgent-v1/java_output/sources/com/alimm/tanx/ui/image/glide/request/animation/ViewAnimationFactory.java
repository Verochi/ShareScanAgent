package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public class ViewAnimationFactory<R> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<R> {
    private final com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory animationFactory;
    private com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<R> glideAnimation;

    public static class ConcreteAnimationFactory implements com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory {
        private final android.view.animation.Animation animation;

        public ConcreteAnimationFactory(android.view.animation.Animation animation) {
            this.animation = animation;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public android.view.animation.Animation build() {
            return this.animation;
        }
    }

    public static class ResourceAnimationFactory implements com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory {
        private final int animationId;
        private final android.content.Context context;

        public ResourceAnimationFactory(android.content.Context context, int i) {
            this.context = context.getApplicationContext();
            this.animationId = i;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public android.view.animation.Animation build() {
            return android.view.animation.AnimationUtils.loadAnimation(this.context, this.animationId);
        }
    }

    public ViewAnimationFactory(android.content.Context context, int i) {
        this.animationFactory = new com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory.ResourceAnimationFactory(context, i);
    }

    public ViewAnimationFactory(android.view.animation.Animation animation) {
        this.animationFactory = new com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory.ConcreteAnimationFactory(animation);
    }

    public ViewAnimationFactory(com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<R> build(boolean z, boolean z2) {
        if (z || !z2) {
            return com.alimm.tanx.ui.image.glide.request.animation.NoAnimation.get();
        }
        if (this.glideAnimation == null) {
            this.glideAnimation = new com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation(this.animationFactory);
        }
        return this.glideAnimation;
    }
}
