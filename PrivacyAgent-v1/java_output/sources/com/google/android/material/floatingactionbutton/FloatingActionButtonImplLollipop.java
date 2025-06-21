package com.google.android.material.floatingactionbutton;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes22.dex */
class FloatingActionButtonImplLollipop extends com.google.android.material.floatingactionbutton.FloatingActionButtonImpl {

    public static class AlwaysStatefulMaterialShapeDrawable extends com.google.android.material.shape.MaterialShapeDrawable {
        public AlwaysStatefulMaterialShapeDrawable(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public FloatingActionButtonImplLollipop(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, com.google.android.material.shadow.ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @androidx.annotation.NonNull
    private android.animation.Animator createElevationAnimator(float f, float f2) {
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.play(android.animation.ObjectAnimator.ofFloat(this.view, "elevation", f).setDuration(0L)).with(android.animation.ObjectAnimator.ofFloat(this.view, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.floatingactionbutton.BorderDrawable createBorderDrawable(int i, android.content.res.ColorStateList colorStateList) {
        android.content.Context context = this.view.getContext();
        com.google.android.material.floatingactionbutton.BorderDrawable borderDrawable = new com.google.android.material.floatingactionbutton.BorderDrawable((com.google.android.material.shape.ShapeAppearanceModel) androidx.core.util.Preconditions.checkNotNull(this.shapeAppearance));
        borderDrawable.setGradientColors(androidx.core.content.ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_top_outer_color), androidx.core.content.ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_top_inner_color), androidx.core.content.ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_end_inner_color), androidx.core.content.ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_end_outer_color));
        borderDrawable.setBorderWidth(i);
        borderDrawable.setBorderTint(colorStateList);
        return borderDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    @androidx.annotation.NonNull
    public com.google.android.material.shape.MaterialShapeDrawable createShapeDrawable() {
        return new com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop.AlwaysStatefulMaterialShapeDrawable((com.google.android.material.shape.ShapeAppearanceModel) androidx.core.util.Preconditions.checkNotNull(this.shapeAppearance));
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void getPadding(@androidx.annotation.NonNull android.graphics.Rect rect) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled()) {
            super.getPadding(rect);
        } else if (shouldExpandBoundsForA11y()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void initializeBackgroundDrawable(android.content.res.ColorStateList colorStateList, @androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode, android.content.res.ColorStateList colorStateList2, int i) {
        android.graphics.drawable.Drawable drawable;
        com.google.android.material.shape.MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
        this.shapeDrawable = createShapeDrawable;
        createShapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (i > 0) {
            this.borderDrawable = createBorderDrawable(i, colorStateList);
            drawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{(android.graphics.drawable.Drawable) androidx.core.util.Preconditions.checkNotNull(this.borderDrawable), (android.graphics.drawable.Drawable) androidx.core.util.Preconditions.checkNotNull(this.shapeDrawable)});
        } else {
            this.borderDrawable = null;
            drawable = this.shapeDrawable;
        }
        android.graphics.drawable.RippleDrawable rippleDrawable = new android.graphics.drawable.RippleDrawable(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, null);
        this.rippleDrawable = rippleDrawable;
        this.contentBackground = rippleDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onCompatShadowChanged() {
        updatePadding();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onDrawableStateChanged(int[] iArr) {
        if (android.os.Build.VERSION.SDK_INT == 21) {
            if (!this.view.isEnabled()) {
                this.view.setElevation(0.0f);
                this.view.setTranslationZ(0.0f);
                return;
            }
            this.view.setElevation(this.elevation);
            if (this.view.isPressed()) {
                this.view.setTranslationZ(this.pressedTranslationZ);
            } else if (this.view.isFocused() || this.view.isHovered()) {
                this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
            } else {
                this.view.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void onElevationsChanged(float f, float f2, float f3) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i == 21) {
            this.view.refreshDrawableState();
        } else {
            android.animation.StateListAnimator stateListAnimator = new android.animation.StateListAnimator();
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(f, f3));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(android.animation.ObjectAnimator.ofFloat(this.view, "elevation", f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton = this.view;
                arrayList.add(android.animation.ObjectAnimator.ofFloat(floatingActionButton, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(android.animation.ObjectAnimator.ofFloat(this.view, (android.util.Property<com.google.android.material.floatingactionbutton.FloatingActionButton, java.lang.Float>) android.view.View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((android.animation.Animator[]) arrayList.toArray(new android.animation.Animator[0]));
            animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ENABLED_STATE_SET, animatorSet);
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
            this.view.setStateListAnimator(stateListAnimator);
        }
        if (shouldAddPadding()) {
            updatePadding();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public boolean requirePreDrawListener() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void setRippleColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable = this.rippleDrawable;
        if (drawable instanceof android.graphics.drawable.RippleDrawable) {
            ((android.graphics.drawable.RippleDrawable) drawable).setColor(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else {
            super.setRippleColor(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public boolean shouldAddPadding() {
        return this.shadowViewDelegate.isCompatPaddingEnabled() || !shouldExpandBoundsForA11y();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void updateFromViewRotation() {
    }
}
