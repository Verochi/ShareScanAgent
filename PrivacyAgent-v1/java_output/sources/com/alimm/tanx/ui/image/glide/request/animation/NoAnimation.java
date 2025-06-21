package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public class NoAnimation<R> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<R> {
    private static final com.alimm.tanx.ui.image.glide.request.animation.NoAnimation<?> NO_ANIMATION = new com.alimm.tanx.ui.image.glide.request.animation.NoAnimation<>();
    private static final com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<?> NO_ANIMATION_FACTORY = new com.alimm.tanx.ui.image.glide.request.animation.NoAnimation.NoAnimationFactory();

    public static class NoAnimationFactory<R> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<R> {
        @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
        public com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<R> build(boolean z, boolean z2) {
            return com.alimm.tanx.ui.image.glide.request.animation.NoAnimation.NO_ANIMATION;
        }
    }

    public static <R> com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<R> get() {
        return NO_ANIMATION;
    }

    public static <R> com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<R> getFactory() {
        return (com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<R>) NO_ANIMATION_FACTORY;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
    public boolean animate(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter viewAdapter) {
        return false;
    }
}
