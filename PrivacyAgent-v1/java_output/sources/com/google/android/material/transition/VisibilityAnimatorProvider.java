package com.google.android.material.transition;

/* loaded from: classes22.dex */
public interface VisibilityAnimatorProvider {
    @androidx.annotation.Nullable
    android.animation.Animator createAppear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view);

    @androidx.annotation.Nullable
    android.animation.Animator createDisappear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view);
}
