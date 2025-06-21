package com.google.android.material.floatingactionbutton;

/* loaded from: classes22.dex */
class AnimatorTracker {

    @androidx.annotation.Nullable
    private android.animation.Animator currentAnimator;

    public void cancelCurrent() {
        android.animation.Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void clear() {
        this.currentAnimator = null;
    }

    public void onNextAnimationStart(android.animation.Animator animator) {
        cancelCurrent();
        this.currentAnimator = animator;
    }
}
