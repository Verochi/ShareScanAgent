package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
public final class MaterialFadeThrough extends com.google.android.material.transition.platform.MaterialVisibility<com.google.android.material.transition.platform.FadeThroughProvider> {
    private static final float DEFAULT_START_SCALE = 0.92f;

    @androidx.annotation.AttrRes
    private static final int DEFAULT_THEMED_DURATION_ATTR = com.google.android.material.R.attr.motionDurationLong1;

    @androidx.annotation.AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = com.google.android.material.R.attr.motionEasingStandard;

    public MaterialFadeThrough() {
        super(createPrimaryAnimatorProvider(), createSecondaryAnimatorProvider());
    }

    private static com.google.android.material.transition.platform.FadeThroughProvider createPrimaryAnimatorProvider() {
        return new com.google.android.material.transition.platform.FadeThroughProvider();
    }

    private static com.google.android.material.transition.platform.VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        com.google.android.material.transition.platform.ScaleProvider scaleProvider = new com.google.android.material.transition.platform.ScaleProvider();
        scaleProvider.setScaleOnDisappear(false);
        scaleProvider.setIncomingStartScale(DEFAULT_START_SCALE);
        return scaleProvider;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@androidx.annotation.NonNull com.google.android.material.transition.platform.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @androidx.annotation.AttrRes
    public int getDurationThemeAttrResId(boolean z) {
        return DEFAULT_THEMED_DURATION_ATTR;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @androidx.annotation.AttrRes
    public int getEasingThemeAttrResId(boolean z) {
        return DEFAULT_THEMED_EASING_ATTR;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ com.google.android.material.transition.platform.VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ android.animation.Animator onAppear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ android.animation.Animator onDisappear(android.view.ViewGroup viewGroup, android.view.View view, android.transition.TransitionValues transitionValues, android.transition.TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@androidx.annotation.NonNull com.google.android.material.transition.platform.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@androidx.annotation.Nullable com.google.android.material.transition.platform.VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }
}
