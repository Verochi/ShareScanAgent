package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
public final class CircularProgressIndicator extends com.google.android.material.progressindicator.BaseProgressIndicator<com.google.android.material.progressindicator.CircularProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_CircularProgressIndicator;
    public static final int INDICATOR_DIRECTION_CLOCKWISE = 0;
    public static final int INDICATOR_DIRECTION_COUNTERCLOCKWISE = 1;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public CircularProgressIndicator(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i) {
        super(context, attributeSet, i, DEF_STYLE_RES);
        initializeDrawables();
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(com.google.android.material.progressindicator.IndeterminateDrawable.createCircularDrawable(getContext(), (com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec));
        setProgressDrawable(com.google.android.material.progressindicator.DeterminateDrawable.createCircularDrawable(getContext(), (com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public com.google.android.material.progressindicator.CircularProgressIndicatorSpec createSpec(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
        return new com.google.android.material.progressindicator.CircularProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndicatorDirection() {
        return ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @androidx.annotation.Px
    public int getIndicatorInset() {
        return ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).indicatorInset;
    }

    @androidx.annotation.Px
    public int getIndicatorSize() {
        return ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).indicatorSize;
    }

    public void setIndicatorDirection(int i) {
        ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).indicatorDirection = i;
        invalidate();
    }

    public void setIndicatorInset(@androidx.annotation.Px int i) {
        S s2 = this.spec;
        if (((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).indicatorInset != i) {
            ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).indicatorInset = i;
            invalidate();
        }
    }

    public void setIndicatorSize(@androidx.annotation.Px int i) {
        int max = java.lang.Math.max(i, getTrackThickness() * 2);
        S s2 = this.spec;
        if (((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).indicatorSize != max) {
            ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).indicatorSize = max;
            ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).validateSpec();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).validateSpec();
    }
}
