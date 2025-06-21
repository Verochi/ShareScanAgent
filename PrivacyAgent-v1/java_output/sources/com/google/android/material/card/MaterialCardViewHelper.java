package com.google.android.material.card;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    private static final double COS_45 = java.lang.Math.cos(java.lang.Math.toRadians(45.0d));
    private static final int DEFAULT_STROKE_VALUE = -1;

    @androidx.annotation.NonNull
    private final com.google.android.material.shape.MaterialShapeDrawable bgDrawable;
    private boolean checkable;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable checkedIcon;

    @androidx.annotation.Dimension
    private int checkedIconMargin;

    @androidx.annotation.Dimension
    private int checkedIconSize;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList checkedIconTint;

    @androidx.annotation.Nullable
    private android.graphics.drawable.LayerDrawable clickableForegroundDrawable;

    @androidx.annotation.Nullable
    private com.google.android.material.shape.MaterialShapeDrawable compatRippleDrawable;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable fgDrawable;

    @androidx.annotation.NonNull
    private final com.google.android.material.shape.MaterialShapeDrawable foregroundContentDrawable;

    @androidx.annotation.Nullable
    private com.google.android.material.shape.MaterialShapeDrawable foregroundShapeDrawable;

    @androidx.annotation.NonNull
    private final com.google.android.material.card.MaterialCardView materialCardView;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList rippleColor;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable rippleDrawable;

    @androidx.annotation.Nullable
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList strokeColor;

    @androidx.annotation.Dimension
    private int strokeWidth;

    @androidx.annotation.NonNull
    private final android.graphics.Rect userContentPadding = new android.graphics.Rect();
    private boolean isBackgroundOverwritten = false;

    /* renamed from: com.google.android.material.card.MaterialCardViewHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends android.graphics.drawable.InsetDrawable {
        public AnonymousClass1(android.graphics.drawable.Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(android.graphics.Rect rect) {
            return false;
        }
    }

    public MaterialCardViewHelper(@androidx.annotation.NonNull com.google.android.material.card.MaterialCardView materialCardView, android.util.AttributeSet attributeSet, int i, @androidx.annotation.StyleRes int i2) {
        this.materialCardView = materialCardView;
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i, i2);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        com.google.android.material.shape.ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        android.content.res.TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.CardView, i, com.google.android.material.R.style.CardView);
        int i3 = com.google.android.material.R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i3)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(i3, 0.0f));
        }
        this.foregroundContentDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        obtainStyledAttributes.recycle();
    }

    private float calculateActualCornerPadding() {
        return java.lang.Math.max(java.lang.Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), java.lang.Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(com.google.android.material.shape.CornerTreatment cornerTreatment, float f) {
        if (cornerTreatment instanceof com.google.android.material.shape.RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * f);
        }
        if (cornerTreatment instanceof com.google.android.material.shape.CutCornerTreatment) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    private float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private boolean canClipToOutline() {
        return this.bgDrawable.isRoundRect();
    }

    @androidx.annotation.NonNull
    private android.graphics.drawable.Drawable createCheckedIconLayer() {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        android.graphics.drawable.Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            stateListDrawable.addState(CHECKED_STATE_SET, drawable);
        }
        return stateListDrawable;
    }

    @androidx.annotation.NonNull
    private android.graphics.drawable.Drawable createCompatRippleDrawable() {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        com.google.android.material.shape.MaterialShapeDrawable createForegroundShapeDrawable = createForegroundShapeDrawable();
        this.compatRippleDrawable = createForegroundShapeDrawable;
        createForegroundShapeDrawable.setFillColor(this.rippleColor);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, this.compatRippleDrawable);
        return stateListDrawable;
    }

    @androidx.annotation.NonNull
    private android.graphics.drawable.Drawable createForegroundRippleDrawable() {
        if (!com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
            return createCompatRippleDrawable();
        }
        this.foregroundShapeDrawable = createForegroundShapeDrawable();
        return new android.graphics.drawable.RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
    }

    @androidx.annotation.NonNull
    private com.google.android.material.shape.MaterialShapeDrawable createForegroundShapeDrawable() {
        return new com.google.android.material.shape.MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    @androidx.annotation.NonNull
    private android.graphics.drawable.Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, createCheckedIconLayer()});
            this.clickableForegroundDrawable = layerDrawable;
            layerDrawable.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap() && this.materialCardView.getUseCompatPadding()) {
            return (float) ((1.0d - COS_45) * this.materialCardView.getCardViewRadius());
        }
        return 0.0f;
    }

    @androidx.annotation.NonNull
    private android.graphics.drawable.Drawable insetDrawable(android.graphics.drawable.Drawable drawable) {
        int i;
        int i2;
        if (this.materialCardView.getUseCompatPadding()) {
            i2 = (int) java.lang.Math.ceil(calculateVerticalBackgroundPadding());
            i = (int) java.lang.Math.ceil(calculateHorizontalBackgroundPadding());
        } else {
            i = 0;
            i2 = 0;
        }
        return new com.google.android.material.card.MaterialCardViewHelper.AnonymousClass1(drawable, i, i2, i, i2);
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding();
    }

    private void updateInsetForeground(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT < 23 || !(this.materialCardView.getForeground() instanceof android.graphics.drawable.InsetDrawable)) {
            this.materialCardView.setForeground(insetDrawable(drawable));
        } else {
            ((android.graphics.drawable.InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        }
    }

    private void updateRippleColor() {
        android.graphics.drawable.Drawable drawable;
        if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.rippleDrawable) != null) {
            ((android.graphics.drawable.RippleDrawable) drawable).setColor(this.rippleColor);
            return;
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.rippleColor);
        }
    }

    @androidx.annotation.RequiresApi(api = 23)
    public void forceRippleRedraw() {
        android.graphics.drawable.Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            android.graphics.Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    @androidx.annotation.NonNull
    public com.google.android.material.shape.MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    public android.content.res.ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    public android.content.res.ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @androidx.annotation.Dimension
    public int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    @androidx.annotation.Dimension
    public int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    @androidx.annotation.FloatRange(from = COS_45, to = 1.0d)
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @androidx.annotation.ColorInt
    public int getStrokeColor() {
        android.content.res.ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    @androidx.annotation.Dimension
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    @androidx.annotation.NonNull
    public android.graphics.Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void loadFromAttributes(@androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = colorStateList;
        if (colorStateList == null) {
            this.strokeColor = android.content.res.ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z = typedArray.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = z;
        this.materialCardView.setLongClickable(z);
        this.checkedIconTint = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(com.google.android.material.resources.MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0));
        android.content.res.ColorStateList colorStateList2 = com.google.android.material.resources.MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = colorStateList2;
        if (colorStateList2 == null) {
            this.rippleColor = android.content.res.ColorStateList.valueOf(com.google.android.material.color.MaterialColors.getColor(this.materialCardView, com.google.android.material.R.attr.colorControlHighlight));
        }
        setCardForegroundColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        android.graphics.drawable.Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.fgDrawable = clickableForeground;
        this.materialCardView.setForeground(insetDrawable(clickableForeground));
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.clickableForegroundDrawable != null) {
            int i5 = this.checkedIconMargin;
            int i6 = this.checkedIconSize;
            int i7 = (i - i5) - i6;
            int i8 = (i2 - i5) - i6;
            if (this.materialCardView.getUseCompatPadding()) {
                i8 -= (int) java.lang.Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
                i7 -= (int) java.lang.Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
            }
            int i9 = i8;
            int i10 = this.checkedIconMargin;
            if (androidx.core.view.ViewCompat.getLayoutDirection(this.materialCardView) == 1) {
                i4 = i7;
                i3 = i10;
            } else {
                i3 = i7;
                i4 = i10;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i3, this.checkedIconMargin, i4, i9);
        }
    }

    public void setBackgroundOverwritten(boolean z) {
        this.isBackgroundOverwritten = z;
    }

    public void setCardBackgroundColor(android.content.res.ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    public void setCardForegroundColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = android.content.res.ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.checkable = z;
    }

    public void setCheckedIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.checkedIcon = drawable;
        if (drawable != null) {
            android.graphics.drawable.Drawable wrap = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable.mutate());
            this.checkedIcon = wrap;
            androidx.core.graphics.drawable.DrawableCompat.setTintList(wrap, this.checkedIconTint);
        }
        if (this.clickableForegroundDrawable != null) {
            this.clickableForegroundDrawable.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, createCheckedIconLayer());
        }
    }

    public void setCheckedIconMargin(@androidx.annotation.Dimension int i) {
        this.checkedIconMargin = i;
    }

    public void setCheckedIconSize(@androidx.annotation.Dimension int i) {
        this.checkedIconSize = i;
    }

    public void setCheckedIconTint(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        android.graphics.drawable.Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    public void setCornerRadius(float f) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    public void setProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.bgDrawable.setInterpolation(f);
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f);
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f);
        }
    }

    public void setRippleColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    public void setShapeAppearanceModel(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        this.bgDrawable.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable3 = this.compatRippleDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public void setStrokeColor(android.content.res.ColorStateList colorStateList) {
        if (this.strokeColor == colorStateList) {
            return;
        }
        this.strokeColor = colorStateList;
        updateStroke();
    }

    public void setStrokeWidth(@androidx.annotation.Dimension int i) {
        if (i == this.strokeWidth) {
            return;
        }
        this.strokeWidth = i;
        updateStroke();
    }

    public void setUserContentPadding(int i, int i2, int i3, int i4) {
        this.userContentPadding.set(i, i2, i3, i4);
        updateContentPadding();
    }

    public void updateClickable() {
        android.graphics.drawable.Drawable drawable = this.fgDrawable;
        android.graphics.drawable.Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.fgDrawable = clickableForeground;
        if (drawable != clickableForeground) {
            updateInsetForeground(clickableForeground);
        }
    }

    public void updateContentPadding() {
        int calculateActualCornerPadding = (int) ((shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f) - getParentCardViewCalculatedCornerPadding());
        com.google.android.material.card.MaterialCardView materialCardView = this.materialCardView;
        android.graphics.Rect rect = this.userContentPadding;
        materialCardView.setAncestorContentPadding(rect.left + calculateActualCornerPadding, rect.top + calculateActualCornerPadding, rect.right + calculateActualCornerPadding, rect.bottom + calculateActualCornerPadding);
    }

    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    public void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    public void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
}
