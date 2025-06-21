package com.bumptech.glide.request.transition;

/* loaded from: classes.dex */
public class DrawableCrossFadeTransition implements com.bumptech.glide.request.transition.Transition<android.graphics.drawable.Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(android.graphics.drawable.Drawable drawable, com.bumptech.glide.request.transition.Transition.ViewAdapter viewAdapter) {
        android.graphics.drawable.Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new android.graphics.drawable.ColorDrawable(0);
        }
        android.graphics.drawable.TransitionDrawable transitionDrawable = new android.graphics.drawable.TransitionDrawable(new android.graphics.drawable.Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.isCrossFadeEnabled);
        transitionDrawable.startTransition(this.duration);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
