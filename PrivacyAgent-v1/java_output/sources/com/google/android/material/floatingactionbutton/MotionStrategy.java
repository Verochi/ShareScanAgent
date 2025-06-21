package com.google.android.material.floatingactionbutton;

/* loaded from: classes22.dex */
interface MotionStrategy {
    void addAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener);

    android.animation.AnimatorSet createAnimator();

    com.google.android.material.animation.MotionSpec getCurrentMotionSpec();

    @androidx.annotation.AnimatorRes
    int getDefaultMotionSpecResource();

    java.util.List<android.animation.Animator.AnimatorListener> getListeners();

    @androidx.annotation.Nullable
    com.google.android.material.animation.MotionSpec getMotionSpec();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(android.animation.Animator animator);

    void onChange(@androidx.annotation.Nullable com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void performNow();

    void removeAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener);

    void setMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec);

    boolean shouldCancel();
}
