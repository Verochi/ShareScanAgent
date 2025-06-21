package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
abstract class MaterialVisibility<P extends com.google.android.material.transition.platform.VisibilityAnimatorProvider> extends android.transition.Visibility {
    private final java.util.List<com.google.android.material.transition.platform.VisibilityAnimatorProvider> additionalAnimatorProviders = new java.util.ArrayList();
    private final P primaryAnimatorProvider;

    @androidx.annotation.Nullable
    private com.google.android.material.transition.platform.VisibilityAnimatorProvider secondaryAnimatorProvider;

    public MaterialVisibility(P p, @androidx.annotation.Nullable com.google.android.material.transition.platform.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    private static void addAnimatorIfNeeded(java.util.List<android.animation.Animator> list, @androidx.annotation.Nullable com.google.android.material.transition.platform.VisibilityAnimatorProvider visibilityAnimatorProvider, android.view.ViewGroup viewGroup, android.view.View view, boolean z) {
        if (visibilityAnimatorProvider == null) {
            return;
        }
        android.animation.Animator createAppear = z ? visibilityAnimatorProvider.createAppear(viewGroup, view) : visibilityAnimatorProvider.createDisappear(viewGroup, view);
        if (createAppear != null) {
            list.add(createAppear);
        }
    }

    private android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view, boolean z) {
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        addAnimatorIfNeeded(arrayList, this.primaryAnimatorProvider, viewGroup, view, z);
        addAnimatorIfNeeded(arrayList, this.secondaryAnimatorProvider, viewGroup, view, z);
        java.util.Iterator<com.google.android.material.transition.platform.VisibilityAnimatorProvider> it = this.additionalAnimatorProviders.iterator();
        while (it.hasNext()) {
            addAnimatorIfNeeded(arrayList, it.next(), viewGroup, view, z);
        }
        maybeApplyThemeValues(viewGroup.getContext(), z);
        com.google.android.material.animation.AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private void maybeApplyThemeValues(@androidx.annotation.NonNull android.content.Context context, boolean z) {
        com.google.android.material.transition.platform.TransitionUtils.maybeApplyThemeDuration(this, context, getDurationThemeAttrResId(z));
        com.google.android.material.transition.platform.TransitionUtils.maybeApplyThemeInterpolator(this, context, getEasingThemeAttrResId(z), getDefaultEasingInterpolator(z));
    }

    public void addAdditionalAnimatorProvider(@androidx.annotation.NonNull com.google.android.material.transition.platform.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.additionalAnimatorProviders.add(visibilityAnimatorProvider);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    @androidx.annotation.NonNull
    public android.animation.TimeInterpolator getDefaultEasingInterpolator(boolean z) {
        return com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    @androidx.annotation.AttrRes
    public int getDurationThemeAttrResId(boolean z) {
        return 0;
    }

    @androidx.annotation.AttrRes
    public int getEasingThemeAttrResId(boolean z) {
        return 0;
    }

    @androidx.annotation.NonNull
    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.transition.platform.VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    @Override // android.transition.Visibility
    public android.animation.Animator onAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }

    public boolean removeAdditionalAnimatorProvider(@androidx.annotation.NonNull com.google.android.material.transition.platform.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.additionalAnimatorProviders.remove(visibilityAnimatorProvider);
    }

    public void setSecondaryAnimatorProvider(@androidx.annotation.Nullable com.google.android.material.transition.platform.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }
}
