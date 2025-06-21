package com.google.android.material.appbar;

/* loaded from: classes22.dex */
public class MaterialToolbar extends androidx.appcompat.widget.Toolbar {
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Toolbar;

    @androidx.annotation.Nullable
    private java.lang.Integer navigationIconTint;
    private boolean subtitleCentered;
    private boolean titleCentered;

    public MaterialToolbar(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public MaterialToolbar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialToolbar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r4), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        android.content.Context context2 = getContext();
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialToolbar, i, i2, new int[0]);
        int i3 = com.google.android.material.R.styleable.MaterialToolbar_navigationIconTint;
        if (obtainStyledAttributes.hasValue(i3)) {
            setNavigationIconTint(obtainStyledAttributes.getColor(i3, -1));
        }
        this.titleCentered = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialToolbar_titleCentered, false);
        this.subtitleCentered = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialToolbar_subtitleCentered, false);
        obtainStyledAttributes.recycle();
        initBackground(context2);
    }

    private android.util.Pair<java.lang.Integer, java.lang.Integer> calculateTitleBoundLimits(@androidx.annotation.Nullable android.widget.TextView textView, @androidx.annotation.Nullable android.widget.TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            android.view.View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new android.util.Pair<>(java.lang.Integer.valueOf(paddingLeft), java.lang.Integer.valueOf(paddingRight));
    }

    private void initBackground(android.content.Context context) {
        android.graphics.drawable.Drawable background = getBackground();
        if (background == null || (background instanceof android.graphics.drawable.ColorDrawable)) {
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(background != null ? ((android.graphics.drawable.ColorDrawable) background).getColor() : 0));
            materialShapeDrawable.initializeElevationOverlay(context);
            materialShapeDrawable.setElevation(androidx.core.view.ViewCompat.getElevation(this));
            androidx.core.view.ViewCompat.setBackground(this, materialShapeDrawable);
        }
    }

    private void layoutTitleCenteredHorizontally(android.view.View view, android.util.Pair<java.lang.Integer, java.lang.Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int max = java.lang.Math.max(java.lang.Math.max(((java.lang.Integer) pair.first).intValue() - i, 0), java.lang.Math.max(i2 - ((java.lang.Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i += max;
            i2 -= max;
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i, view.getTop(), i2, view.getBottom());
    }

    private void maybeCenterTitleViews() {
        if (this.titleCentered || this.subtitleCentered) {
            android.widget.TextView titleTextView = com.google.android.material.internal.ToolbarUtils.getTitleTextView(this);
            android.widget.TextView subtitleTextView = com.google.android.material.internal.ToolbarUtils.getSubtitleTextView(this);
            if (titleTextView == null && subtitleTextView == null) {
                return;
            }
            android.util.Pair<java.lang.Integer, java.lang.Integer> calculateTitleBoundLimits = calculateTitleBoundLimits(titleTextView, subtitleTextView);
            if (this.titleCentered && titleTextView != null) {
                layoutTitleCenteredHorizontally(titleTextView, calculateTitleBoundLimits);
            }
            if (!this.subtitleCentered || subtitleTextView == null) {
                return;
            }
            layoutTitleCenteredHorizontally(subtitleTextView, calculateTitleBoundLimits);
        }
    }

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable maybeTintNavigationIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == null || this.navigationIconTint == null) {
            return drawable;
        }
        android.graphics.drawable.Drawable wrap = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable);
        androidx.core.graphics.drawable.DrawableCompat.setTint(wrap, this.navigationIconTint.intValue());
        return wrap;
    }

    public boolean isSubtitleCentered() {
        return this.subtitleCentered;
    }

    public boolean isTitleCentered() {
        return this.titleCentered;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        maybeCenterTitleViews();
    }

    @Override // android.view.View
    @androidx.annotation.RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    public void setNavigationIconTint(@androidx.annotation.ColorInt int i) {
        this.navigationIconTint = java.lang.Integer.valueOf(i);
        android.graphics.drawable.Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.subtitleCentered != z) {
            this.subtitleCentered = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.titleCentered != z) {
            this.titleCentered = z;
            requestLayout();
        }
    }
}
