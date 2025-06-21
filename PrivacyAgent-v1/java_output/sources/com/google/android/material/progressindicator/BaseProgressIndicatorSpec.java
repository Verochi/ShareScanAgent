package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;

    @androidx.annotation.NonNull
    public int[] indicatorColors = new int[0];
    public int showAnimationBehavior;

    @androidx.annotation.ColorInt
    public int trackColor;

    @androidx.annotation.Px
    public int trackCornerRadius;

    @androidx.annotation.Px
    public int trackThickness;

    public BaseProgressIndicatorSpec(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_progress_track_thickness);
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.BaseProgressIndicator, i, i2, new int[0]);
        this.trackThickness = com.google.android.material.resources.MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, com.google.android.material.R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.trackCornerRadius = java.lang.Math.min(com.google.android.material.resources.MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, com.google.android.material.R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.trackThickness / 2);
        this.showAnimationBehavior = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.hideAnimationBehavior = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        loadIndicatorColors(context, obtainStyledAttributes);
        loadTrackColor(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void loadIndicatorColors(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        int i = com.google.android.material.R.styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i)) {
            this.indicatorColors = new int[]{com.google.android.material.color.MaterialColors.getColor(context, com.google.android.material.R.attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(i).type != 1) {
            this.indicatorColors = new int[]{typedArray.getColor(i, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i, -1));
        this.indicatorColors = intArray;
        if (intArray.length == 0) {
            throw new java.lang.IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void loadTrackColor(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        int i = com.google.android.material.R.styleable.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i)) {
            this.trackColor = typedArray.getColor(i, -1);
            return;
        }
        this.trackColor = this.indicatorColors[0];
        android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float f = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.trackColor = com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(this.trackColor, (int) (f * 255.0f));
    }

    public boolean isHideAnimationEnabled() {
        return this.hideAnimationBehavior != 0;
    }

    public boolean isShowAnimationEnabled() {
        return this.showAnimationBehavior != 0;
    }

    public abstract void validateSpec();
}
