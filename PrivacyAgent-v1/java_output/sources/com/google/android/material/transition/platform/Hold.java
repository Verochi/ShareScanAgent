package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
public final class Hold extends android.transition.Visibility {
    @Override // android.transition.Visibility
    @androidx.annotation.NonNull
    public android.animation.Animator onAppear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.transition.TransitionValues transitionValues, @androidx.annotation.Nullable android.transition.TransitionValues transitionValues2) {
        return android.animation.ValueAnimator.ofFloat(0.0f);
    }

    @Override // android.transition.Visibility
    @androidx.annotation.NonNull
    public android.animation.Animator onDisappear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.transition.TransitionValues transitionValues, @androidx.annotation.Nullable android.transition.TransitionValues transitionValues2) {
        return android.animation.ValueAnimator.ofFloat(0.0f);
    }
}
