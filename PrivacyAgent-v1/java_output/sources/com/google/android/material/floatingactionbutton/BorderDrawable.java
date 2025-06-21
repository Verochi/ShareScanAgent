package com.google.android.material.floatingactionbutton;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
class BorderDrawable extends android.graphics.drawable.Drawable {
    private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList borderTint;

    @androidx.annotation.Dimension
    float borderWidth;

    @androidx.annotation.ColorInt
    private int bottomInnerStrokeColor;

    @androidx.annotation.ColorInt
    private int bottomOuterStrokeColor;

    @androidx.annotation.ColorInt
    private int currentBorderTintColor;

    @androidx.annotation.NonNull
    private final android.graphics.Paint paint;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;

    @androidx.annotation.ColorInt
    private int topInnerStrokeColor;

    @androidx.annotation.ColorInt
    private int topOuterStrokeColor;
    private final com.google.android.material.shape.ShapeAppearancePathProvider pathProvider = com.google.android.material.shape.ShapeAppearancePathProvider.getInstance();
    private final android.graphics.Path shapePath = new android.graphics.Path();
    private final android.graphics.Rect rect = new android.graphics.Rect();
    private final android.graphics.RectF rectF = new android.graphics.RectF();
    private final android.graphics.RectF boundsRectF = new android.graphics.RectF();
    private final com.google.android.material.floatingactionbutton.BorderDrawable.BorderState state = new com.google.android.material.floatingactionbutton.BorderDrawable.BorderState(this, null);
    private boolean invalidateShader = true;

    public class BorderState extends android.graphics.drawable.Drawable.ConstantState {
        private BorderState() {
        }

        public /* synthetic */ BorderState(com.google.android.material.floatingactionbutton.BorderDrawable borderDrawable, com.google.android.material.floatingactionbutton.BorderDrawable.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable newDrawable() {
            return com.google.android.material.floatingactionbutton.BorderDrawable.this;
        }
    }

    public BorderDrawable(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setStyle(android.graphics.Paint.Style.STROKE);
    }

    @androidx.annotation.NonNull
    private android.graphics.Shader createGradientShader() {
        copyBounds(this.rect);
        float height = this.borderWidth / r0.height();
        return new android.graphics.LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{androidx.core.graphics.ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor), androidx.core.graphics.ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor), androidx.core.graphics.ColorUtils.compositeColors(androidx.core.graphics.ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor), androidx.core.graphics.ColorUtils.compositeColors(androidx.core.graphics.ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor), androidx.core.graphics.ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor), androidx.core.graphics.ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, android.graphics.Shader.TileMode.CLAMP);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (this.invalidateShader) {
            this.paint.setShader(createGradientShader());
            this.invalidateShader = false;
        }
        float strokeWidth = this.paint.getStrokeWidth() / 2.0f;
        copyBounds(this.rect);
        this.rectF.set(this.rect);
        float min = java.lang.Math.min(this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF()), this.rectF.width() / 2.0f);
        if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
            this.rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.rectF, min, min, this.paint);
        }
    }

    @androidx.annotation.NonNull
    public android.graphics.RectF getBoundsAsRectF() {
        this.boundsRectF.set(getBounds());
        return this.boundsRectF;
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.borderWidth > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @android.annotation.TargetApi(21)
    public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) {
        if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
            outline.setRoundRect(getBounds(), this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF()));
            return;
        }
        copyBounds(this.rect);
        this.rectF.set(this.rect);
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.rectF, this.shapePath);
        if (this.shapePath.isConvex()) {
            outline.setConvexPath(this.shapePath);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@androidx.annotation.NonNull android.graphics.Rect rect) {
        if (!this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
            return true;
        }
        int round = java.lang.Math.round(this.borderWidth);
        rect.set(round, round, round, round);
        return true;
    }

    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        android.content.res.ColorStateList colorStateList = this.borderTint;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        this.invalidateShader = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        android.content.res.ColorStateList colorStateList = this.borderTint;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.currentBorderTintColor)) != this.currentBorderTintColor) {
            this.invalidateShader = true;
            this.currentBorderTintColor = colorForState;
        }
        if (this.invalidateShader) {
            invalidateSelf();
        }
        return this.invalidateShader;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@androidx.annotation.IntRange(from = 0, to = 255) int i) {
        this.paint.setAlpha(i);
        invalidateSelf();
    }

    public void setBorderTint(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.currentBorderTintColor = colorStateList.getColorForState(getState(), this.currentBorderTintColor);
        }
        this.borderTint = colorStateList;
        this.invalidateShader = true;
        invalidateSelf();
    }

    public void setBorderWidth(@androidx.annotation.Dimension float f) {
        if (this.borderWidth != f) {
            this.borderWidth = f;
            this.paint.setStrokeWidth(f * DRAW_STROKE_WIDTH_MULTIPLE);
            this.invalidateShader = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setGradientColors(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2, @androidx.annotation.ColorInt int i3, @androidx.annotation.ColorInt int i4) {
        this.topOuterStrokeColor = i;
        this.topInnerStrokeColor = i2;
        this.bottomOuterStrokeColor = i3;
        this.bottomInnerStrokeColor = i4;
    }

    public void setShapeAppearanceModel(com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        invalidateSelf();
    }
}
