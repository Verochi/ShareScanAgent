package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public class ViewPropertyAnimation<R> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<R> {
    private final com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation.Animator animator;

    public interface Animator {
        void animate(android.view.View view);
    }

    public ViewPropertyAnimation(com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation.Animator animator) {
        this.animator = animator;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
    public boolean animate(R r, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() == null) {
            return false;
        }
        this.animator.animate(viewAdapter.getView());
        return false;
    }
}
