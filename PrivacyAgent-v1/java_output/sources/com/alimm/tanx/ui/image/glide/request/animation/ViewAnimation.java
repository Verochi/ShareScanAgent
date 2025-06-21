package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public class ViewAnimation<R> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<R> {
    private final com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory animationFactory;

    public interface AnimationFactory {
        android.view.animation.Animation build();
    }

    public ViewAnimation(com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
    public boolean animate(R r, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter viewAdapter) {
        android.view.View view = viewAdapter.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.animationFactory.build());
        return false;
    }
}
