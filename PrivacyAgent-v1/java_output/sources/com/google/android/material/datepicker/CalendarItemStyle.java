package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
final class CalendarItemStyle {
    private final android.content.res.ColorStateList backgroundColor;

    @androidx.annotation.NonNull
    private final android.graphics.Rect insets;
    private final com.google.android.material.shape.ShapeAppearanceModel itemShape;
    private final android.content.res.ColorStateList strokeColor;
    private final int strokeWidth;
    private final android.content.res.ColorStateList textColor;

    private CalendarItemStyle(android.content.res.ColorStateList colorStateList, android.content.res.ColorStateList colorStateList2, android.content.res.ColorStateList colorStateList3, int i, com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel, @androidx.annotation.NonNull android.graphics.Rect rect) {
        androidx.core.util.Preconditions.checkArgumentNonnegative(rect.left);
        androidx.core.util.Preconditions.checkArgumentNonnegative(rect.top);
        androidx.core.util.Preconditions.checkArgumentNonnegative(rect.right);
        androidx.core.util.Preconditions.checkArgumentNonnegative(rect.bottom);
        this.insets = rect;
        this.textColor = colorStateList2;
        this.backgroundColor = colorStateList;
        this.strokeColor = colorStateList3;
        this.strokeWidth = i;
        this.itemShape = shapeAppearanceModel;
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.datepicker.CalendarItemStyle create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.StyleRes int i) {
        androidx.core.util.Preconditions.checkArgument(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.R.styleable.MaterialCalendarItem);
        android.graphics.Rect rect = new android.graphics.Rect(obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.MaterialCalendarItem_itemFillColor);
        android.content.res.ColorStateList colorStateList2 = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.MaterialCalendarItem_itemTextColor);
        android.content.res.ColorStateList colorStateList3 = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        com.google.android.material.shape.ShapeAppearanceModel build = com.google.android.material.shape.ShapeAppearanceModel.builder(context, obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        obtainStyledAttributes.recycle();
        return new com.google.android.material.datepicker.CalendarItemStyle(colorStateList, colorStateList2, colorStateList3, dimensionPixelSize, build, rect);
    }

    public int getBottomInset() {
        return this.insets.bottom;
    }

    public int getLeftInset() {
        return this.insets.left;
    }

    public int getRightInset() {
        return this.insets.right;
    }

    public int getTopInset() {
        return this.insets.top;
    }

    public void styleItem(@androidx.annotation.NonNull android.widget.TextView textView) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = new com.google.android.material.shape.MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.itemShape);
        materialShapeDrawable2.setShapeAppearanceModel(this.itemShape);
        materialShapeDrawable.setFillColor(this.backgroundColor);
        materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
        textView.setTextColor(this.textColor);
        android.graphics.drawable.RippleDrawable rippleDrawable = new android.graphics.drawable.RippleDrawable(this.textColor.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        android.graphics.Rect rect = this.insets;
        androidx.core.view.ViewCompat.setBackground(textView, new android.graphics.drawable.InsetDrawable((android.graphics.drawable.Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
