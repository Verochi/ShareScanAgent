package com.google.android.material.floatingactionbutton;

/* loaded from: classes22.dex */
abstract class BaseMotionStrategy implements com.google.android.material.floatingactionbutton.MotionStrategy {
    private final android.content.Context context;

    @androidx.annotation.Nullable
    private com.google.android.material.animation.MotionSpec defaultMotionSpec;

    @androidx.annotation.NonNull
    private final com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton fab;
    private final java.util.ArrayList<android.animation.Animator.AnimatorListener> listeners = new java.util.ArrayList<>();

    @androidx.annotation.Nullable
    private com.google.android.material.animation.MotionSpec motionSpec;
    private final com.google.android.material.floatingactionbutton.AnimatorTracker tracker;

    /* renamed from: com.google.android.material.floatingactionbutton.BaseMotionStrategy$1, reason: invalid class name */
    public class AnonymousClass1 extends android.util.Property<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton, java.lang.Float> {
        public AnonymousClass1(java.lang.Class cls, java.lang.String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public java.lang.Float get(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            return java.lang.Float.valueOf(com.google.android.material.animation.AnimationUtils.lerp(0.0f, 1.0f, (android.graphics.Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / android.graphics.Color.alpha(extendedFloatingActionButton.originalTextCsl.getColorForState(extendedFloatingActionButton.getDrawableState(), com.google.android.material.floatingactionbutton.BaseMotionStrategy.this.fab.originalTextCsl.getDefaultColor()))));
        }

        @Override // android.util.Property
        public void set(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, java.lang.Float f) {
            int colorForState = extendedFloatingActionButton.originalTextCsl.getColorForState(extendedFloatingActionButton.getDrawableState(), com.google.android.material.floatingactionbutton.BaseMotionStrategy.this.fab.originalTextCsl.getDefaultColor());
            android.content.res.ColorStateList valueOf = android.content.res.ColorStateList.valueOf(android.graphics.Color.argb((int) (com.google.android.material.animation.AnimationUtils.lerp(0.0f, android.graphics.Color.alpha(colorForState) / 255.0f, f.floatValue()) * 255.0f), android.graphics.Color.red(colorForState), android.graphics.Color.green(colorForState), android.graphics.Color.blue(colorForState)));
            if (f.floatValue() == 1.0f) {
                extendedFloatingActionButton.silentlyUpdateTextColor(extendedFloatingActionButton.originalTextCsl);
            } else {
                extendedFloatingActionButton.silentlyUpdateTextColor(valueOf);
            }
        }
    }

    public BaseMotionStrategy(@androidx.annotation.NonNull com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.AnimatorTracker animatorTracker) {
        this.fab = extendedFloatingActionButton;
        this.context = extendedFloatingActionButton.getContext();
        this.tracker = animatorTracker;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void addAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public android.animation.AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    @androidx.annotation.NonNull
    public android.animation.AnimatorSet createAnimator(@androidx.annotation.NonNull com.google.android.material.animation.MotionSpec motionSpec) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (motionSpec.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec.getAnimator("opacity", this.fab, android.view.View.ALPHA));
        }
        if (motionSpec.hasPropertyValues("scale")) {
            arrayList.add(motionSpec.getAnimator("scale", this.fab, android.view.View.SCALE_Y));
            arrayList.add(motionSpec.getAnimator("scale", this.fab, android.view.View.SCALE_X));
        }
        if (motionSpec.hasPropertyValues("width")) {
            arrayList.add(motionSpec.getAnimator("width", this.fab, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec.hasPropertyValues("height")) {
            arrayList.add(motionSpec.getAnimator("height", this.fab, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.HEIGHT));
        }
        if (motionSpec.hasPropertyValues("paddingStart")) {
            arrayList.add(motionSpec.getAnimator("paddingStart", this.fab, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.PADDING_START));
        }
        if (motionSpec.hasPropertyValues("paddingEnd")) {
            arrayList.add(motionSpec.getAnimator("paddingEnd", this.fab, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.PADDING_END));
        }
        if (motionSpec.hasPropertyValues("labelOpacity")) {
            arrayList.add(motionSpec.getAnimator("labelOpacity", this.fab, new com.google.android.material.floatingactionbutton.BaseMotionStrategy.AnonymousClass1(java.lang.Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        com.google.android.material.animation.AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final com.google.android.material.animation.MotionSpec getCurrentMotionSpec() {
        com.google.android.material.animation.MotionSpec motionSpec = this.motionSpec;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.defaultMotionSpec == null) {
            this.defaultMotionSpec = com.google.android.material.animation.MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
        }
        return (com.google.android.material.animation.MotionSpec) androidx.core.util.Preconditions.checkNotNull(this.defaultMotionSpec);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @androidx.annotation.NonNull
    public final java.util.List<android.animation.Animator.AnimatorListener> getListeners() {
        return this.listeners;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @androidx.annotation.CallSuper
    public void onAnimationCancel() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @androidx.annotation.CallSuper
    public void onAnimationEnd() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @androidx.annotation.CallSuper
    public void onAnimationStart(android.animation.Animator animator) {
        this.tracker.onNextAnimationStart(animator);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void removeAnimationListener(@androidx.annotation.NonNull android.animation.Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void setMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.motionSpec = motionSpec;
    }
}
