package com.google.android.material.transition;

/* loaded from: classes22.dex */
public final class Hold extends androidx.transition.Visibility {
    @Override // androidx.transition.Visibility
    @androidx.annotation.NonNull
    public android.animation.Animator onAppear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues2) {
        return android.animation.ValueAnimator.ofFloat(0.0f);
    }

    @Override // androidx.transition.Visibility
    @androidx.annotation.NonNull
    public android.animation.Animator onDisappear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues, @androidx.annotation.Nullable androidx.transition.TransitionValues transitionValues2) {
        return android.animation.ValueAnimator.ofFloat(0.0f);
    }
}
