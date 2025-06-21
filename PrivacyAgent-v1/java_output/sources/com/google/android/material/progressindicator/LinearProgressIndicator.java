package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
public final class LinearProgressIndicator extends com.google.android.material.progressindicator.BaseProgressIndicator<com.google.android.material.progressindicator.LinearProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_LinearProgressIndicator;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndeterminateAnimationType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public LinearProgressIndicator(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i) {
        super(context, attributeSet, i, DEF_STYLE_RES);
        initializeDrawables();
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(com.google.android.material.progressindicator.IndeterminateDrawable.createLinearDrawable(getContext(), (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec));
        setProgressDrawable(com.google.android.material.progressindicator.DeterminateDrawable.createLinearDrawable(getContext(), (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public com.google.android.material.progressindicator.LinearProgressIndicatorSpec createSpec(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        return new com.google.android.material.progressindicator.LinearProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndeterminateAnimationType() {
        return ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        S s2 = this.spec;
        com.google.android.material.progressindicator.LinearProgressIndicatorSpec linearProgressIndicatorSpec = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) s2;
        boolean z2 = true;
        if (((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) s2).indicatorDirection != 1 && ((androidx.core.view.ViewCompat.getLayoutDirection(this) != 1 || ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec).indicatorDirection != 2) && (androidx.core.view.ViewCompat.getLayoutDirection(this) != 0 || ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec).indicatorDirection != 3))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        com.google.android.material.progressindicator.IndeterminateDrawable<com.google.android.material.progressindicator.LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        com.google.android.material.progressindicator.DeterminateDrawable<com.google.android.material.progressindicator.LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void setIndeterminateAnimationType(int i) {
        if (((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType == i) {
            return;
        }
        if (visibleToUser() && isIndeterminate()) {
            throw new java.lang.IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s2 = this.spec;
        ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) s2).indeterminateAnimationType = i;
        ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) s2).validateSpec();
        if (i == 0) {
            getIndeterminateDrawable().setAnimatorDelegate(new com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec));
        } else {
            getIndeterminateDrawable().setAnimatorDelegate(new com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate(getContext(), (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@androidx.annotation.NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    public void setIndicatorDirection(int i) {
        S s2 = this.spec;
        ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) s2).indicatorDirection = i;
        com.google.android.material.progressindicator.LinearProgressIndicatorSpec linearProgressIndicatorSpec = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) s2;
        boolean z = true;
        if (i != 1 && ((androidx.core.view.ViewCompat.getLayoutDirection(this) != 1 || ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec).indicatorDirection != 2) && (androidx.core.view.ViewCompat.getLayoutDirection(this) != 0 || i != 3))) {
            z = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i, boolean z) {
        S s2 = this.spec;
        if (s2 != 0 && ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) s2).indeterminateAnimationType == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i, z);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        ((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }
}
