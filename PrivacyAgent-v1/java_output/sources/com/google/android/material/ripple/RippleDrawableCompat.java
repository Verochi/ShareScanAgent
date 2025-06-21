package com.google.android.material.ripple;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class RippleDrawableCompat extends android.graphics.drawable.Drawable implements com.google.android.material.shape.Shapeable, androidx.core.graphics.drawable.TintAwareDrawable {
    private com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState drawableState;

    public static final class RippleDrawableCompatState extends android.graphics.drawable.Drawable.ConstantState {

        @androidx.annotation.NonNull
        com.google.android.material.shape.MaterialShapeDrawable delegate;
        boolean shouldDrawDelegate;

        public RippleDrawableCompatState(@androidx.annotation.NonNull com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState rippleDrawableCompatState) {
            this.delegate = (com.google.android.material.shape.MaterialShapeDrawable) rippleDrawableCompatState.delegate.getConstantState().newDrawable();
            this.shouldDrawDelegate = rippleDrawableCompatState.shouldDrawDelegate;
        }

        public RippleDrawableCompatState(com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable) {
            this.delegate = materialShapeDrawable;
            this.shouldDrawDelegate = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public com.google.android.material.ripple.RippleDrawableCompat newDrawable() {
            return new com.google.android.material.ripple.RippleDrawableCompat(new com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState(this), null);
        }
    }

    private RippleDrawableCompat(com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState rippleDrawableCompatState) {
        this.drawableState = rippleDrawableCompatState;
    }

    public /* synthetic */ RippleDrawableCompat(com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState rippleDrawableCompatState, com.google.android.material.ripple.RippleDrawableCompat.AnonymousClass1 anonymousClass1) {
        this(rippleDrawableCompatState);
    }

    public RippleDrawableCompat(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this(new com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState(new com.google.android.material.shape.MaterialShapeDrawable(shapeAppearanceModel)));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState rippleDrawableCompatState = this.drawableState;
        if (rippleDrawableCompatState.shouldDrawDelegate) {
            rippleDrawableCompatState.delegate.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.drawableState.delegate.getOpacity();
    }

    @Override // com.google.android.material.shape.Shapeable
    @androidx.annotation.NonNull
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.delegate.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.NonNull
    public com.google.android.material.ripple.RippleDrawableCompat mutate() {
        this.drawableState = new com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@androidx.annotation.NonNull android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        this.drawableState.delegate.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@androidx.annotation.NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.drawableState.delegate.setState(iArr)) {
            onStateChange = true;
        }
        boolean shouldDrawRippleCompat = com.google.android.material.ripple.RippleUtils.shouldDrawRippleCompat(iArr);
        com.google.android.material.ripple.RippleDrawableCompat.RippleDrawableCompatState rippleDrawableCompatState = this.drawableState;
        if (rippleDrawableCompatState.shouldDrawDelegate == shouldDrawRippleCompat) {
            return onStateChange;
        }
        rippleDrawableCompatState.shouldDrawDelegate = shouldDrawRippleCompat;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.drawableState.delegate.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        this.drawableState.delegate.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.delegate.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@androidx.annotation.ColorInt int i) {
        this.drawableState.delegate.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.drawableState.delegate.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        this.drawableState.delegate.setTintMode(mode);
    }
}
