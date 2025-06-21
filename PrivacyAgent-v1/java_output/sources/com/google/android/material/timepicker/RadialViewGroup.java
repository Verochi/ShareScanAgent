package com.google.android.material.timepicker;

/* loaded from: classes22.dex */
class RadialViewGroup extends androidx.constraintlayout.widget.ConstraintLayout {
    private static final java.lang.String SKIP_TAG = "skip";
    private com.google.android.material.shape.MaterialShapeDrawable background;
    private int radius;
    private final java.lang.Runnable updateLayoutParametersRunnable;

    /* renamed from: com.google.android.material.timepicker.RadialViewGroup$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.timepicker.RadialViewGroup.this.updateLayoutParams();
        }
    }

    public RadialViewGroup(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public RadialViewGroup(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.view.LayoutInflater.from(context).inflate(com.google.android.material.R.layout.material_radial_view_group, this);
        androidx.core.view.ViewCompat.setBackground(this, createBackground());
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.RadialViewGroup, i, 0);
        this.radius = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.updateLayoutParametersRunnable = new com.google.android.material.timepicker.RadialViewGroup.AnonymousClass1();
        obtainStyledAttributes.recycle();
    }

    private android.graphics.drawable.Drawable createBackground() {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        this.background = materialShapeDrawable;
        materialShapeDrawable.setCornerSize(new com.google.android.material.shape.RelativeCornerSize(0.5f));
        this.background.setFillColor(android.content.res.ColorStateList.valueOf(-1));
        return this.background;
    }

    private static boolean shouldSkipView(android.view.View view) {
        return "skip".equals(view.getTag());
    }

    private void updateLayoutParamsAsync() {
        android.os.Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.updateLayoutParametersRunnable);
            handler.post(this.updateLayoutParametersRunnable);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(androidx.core.view.ViewCompat.generateViewId());
        }
        updateLayoutParamsAsync();
    }

    @androidx.annotation.Dimension
    public int getRadius() {
        return this.radius;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(android.view.View view) {
        super.onViewRemoved(view);
        updateLayoutParamsAsync();
    }

    @Override // android.view.View
    public void setBackgroundColor(@androidx.annotation.ColorInt int i) {
        this.background.setFillColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setRadius(@androidx.annotation.Dimension int i) {
        this.radius = i;
        updateLayoutParams();
    }

    public void updateLayoutParams() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (shouldSkipView(getChildAt(i2))) {
                i++;
            }
        }
        androidx.constraintlayout.widget.ConstraintSet constraintSet = new androidx.constraintlayout.widget.ConstraintSet();
        constraintSet.clone(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = getChildAt(i3);
            int id = childAt.getId();
            int i4 = com.google.android.material.R.id.circle_center;
            if (id != i4 && !shouldSkipView(childAt)) {
                constraintSet.constrainCircle(childAt.getId(), i4, this.radius, f);
                f += 360.0f / (childCount - i);
            }
        }
        constraintSet.applyTo(this);
    }
}
