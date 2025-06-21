package com.alimm.tanx.ui.image.glide.request.animation;

/* loaded from: classes.dex */
public class DrawableCrossFadeViewAnimation<T extends android.graphics.drawable.Drawable> implements com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<T> {
    private final com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<T> defaultAnimation;
    private final int duration;

    public DrawableCrossFadeViewAnimation(com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<T> glideAnimation, int i) {
        this.defaultAnimation = glideAnimation;
        this.duration = i;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
    public boolean animate(T t, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter viewAdapter) {
        android.graphics.drawable.Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            this.defaultAnimation.animate(t, viewAdapter);
            return false;
        }
        android.graphics.drawable.TransitionDrawable transitionDrawable = new android.graphics.drawable.TransitionDrawable(new android.graphics.drawable.Drawable[]{currentDrawable, t});
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(this.duration);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
