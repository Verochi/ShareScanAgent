package com.google.android.material.transition.platform;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
public final class SlideDistanceProvider implements com.google.android.material.transition.platform.VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @androidx.annotation.Px
    private int slideDistance = -1;
    private int slideEdge;

    /* renamed from: com.google.android.material.transition.platform.SlideDistanceProvider$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ float val$originalTranslation;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(android.view.View view, float f) {
            this.val$view = view;
            this.val$originalTranslation = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$view.setTranslationX(this.val$originalTranslation);
        }
    }

    /* renamed from: com.google.android.material.transition.platform.SlideDistanceProvider$2, reason: invalid class name */
    public static class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ float val$originalTranslation;
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass2(android.view.View view, float f) {
            this.val$view = view;
            this.val$originalTranslation = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            this.val$view.setTranslationY(this.val$originalTranslation);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i) {
        this.slideEdge = i;
    }

    private static android.animation.Animator createTranslationAppearAnimator(android.view.View view, android.view.View view2, int i, @androidx.annotation.Px int i2) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i == 3) {
            return createTranslationXAnimator(view2, i2 + translationX, translationX, translationX);
        }
        if (i == 5) {
            return createTranslationXAnimator(view2, translationX - i2, translationX, translationX);
        }
        if (i == 48) {
            return createTranslationYAnimator(view2, translationY - i2, translationY, translationY);
        }
        if (i == 80) {
            return createTranslationYAnimator(view2, i2 + translationY, translationY, translationY);
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view2, isRtl(view) ? i2 + translationX : translationX - i2, translationX, translationX);
        }
        if (i == 8388613) {
            return createTranslationXAnimator(view2, isRtl(view) ? translationX - i2 : i2 + translationX, translationX, translationX);
        }
        throw new java.lang.IllegalArgumentException("Invalid slide direction: " + i);
    }

    private static android.animation.Animator createTranslationDisappearAnimator(android.view.View view, android.view.View view2, int i, @androidx.annotation.Px int i2) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i == 3) {
            return createTranslationXAnimator(view2, translationX, translationX - i2, translationX);
        }
        if (i == 5) {
            return createTranslationXAnimator(view2, translationX, i2 + translationX, translationX);
        }
        if (i == 48) {
            return createTranslationYAnimator(view2, translationY, i2 + translationY, translationY);
        }
        if (i == 80) {
            return createTranslationYAnimator(view2, translationY, translationY - i2, translationY);
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view2, translationX, isRtl(view) ? translationX - i2 : i2 + translationX, translationX);
        }
        if (i == 8388613) {
            return createTranslationXAnimator(view2, translationX, isRtl(view) ? i2 + translationX : translationX - i2, translationX);
        }
        throw new java.lang.IllegalArgumentException("Invalid slide direction: " + i);
    }

    private static android.animation.Animator createTranslationXAnimator(android.view.View view, float f, float f2, float f3) {
        android.animation.ObjectAnimator ofPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(view, android.animation.PropertyValuesHolder.ofFloat((android.util.Property<?, java.lang.Float>) android.view.View.TRANSLATION_X, f, f2));
        ofPropertyValuesHolder.addListener(new com.google.android.material.transition.platform.SlideDistanceProvider.AnonymousClass1(view, f3));
        return ofPropertyValuesHolder;
    }

    private static android.animation.Animator createTranslationYAnimator(android.view.View view, float f, float f2, float f3) {
        android.animation.ObjectAnimator ofPropertyValuesHolder = android.animation.ObjectAnimator.ofPropertyValuesHolder(view, android.animation.PropertyValuesHolder.ofFloat((android.util.Property<?, java.lang.Float>) android.view.View.TRANSLATION_Y, f, f2));
        ofPropertyValuesHolder.addListener(new com.google.android.material.transition.platform.SlideDistanceProvider.AnonymousClass2(view, f3));
        return ofPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(android.content.Context context) {
        int i = this.slideDistance;
        return i != -1 ? i : context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(android.view.View view) {
        return androidx.core.view.ViewCompat.getLayoutDirection(view) == 1;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @androidx.annotation.Nullable
    public android.animation.Animator createAppear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @androidx.annotation.Nullable
    public android.animation.Animator createDisappear(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @androidx.annotation.Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@androidx.annotation.Px int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = i;
    }

    public void setSlideEdge(int i) {
        this.slideEdge = i;
    }
}
