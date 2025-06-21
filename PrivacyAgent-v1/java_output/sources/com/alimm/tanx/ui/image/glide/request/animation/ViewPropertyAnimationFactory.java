package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public class ViewPropertyAnimationFactory<R> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<R> {
    private com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation<R> animation;
    private final com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation.Animator animator;

    public ViewPropertyAnimationFactory(com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation.Animator animator) {
        this.animator = animator;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<R> build(boolean z, boolean z2) {
        if (z || !z2) {
            return com.alimm.tanx.ui.image.glide.request.animation.NoAnimation.get();
        }
        if (this.animation == null) {
            this.animation = new com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation<>(this.animator);
        }
        return this.animation;
    }
}
