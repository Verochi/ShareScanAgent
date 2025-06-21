package com.google.android.material.imageview;

/* loaded from: classes22.dex */
public class ShapeableImageView extends androidx.appcompat.widget.AppCompatImageView implements com.google.android.material.shape.Shapeable {
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_ShapeableImageView;
    private static final int UNDEFINED_PADDING = Integer.MIN_VALUE;
    private final android.graphics.Paint borderPaint;

    @androidx.annotation.Dimension
    private int bottomContentPadding;
    private final android.graphics.Paint clearPaint;
    private final android.graphics.RectF destination;

    @androidx.annotation.Dimension
    private int endContentPadding;
    private boolean hasAdjustedPaddingAfterLayoutDirectionResolved;

    @androidx.annotation.Dimension
    private int leftContentPadding;
    private android.graphics.Path maskPath;
    private final android.graphics.RectF maskRect;
    private final android.graphics.Path path;
    private final com.google.android.material.shape.ShapeAppearancePathProvider pathProvider;

    @androidx.annotation.Dimension
    private int rightContentPadding;

    @androidx.annotation.Nullable
    private com.google.android.material.shape.MaterialShapeDrawable shadowDrawable;
    private com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel;

    @androidx.annotation.Dimension
    private int startContentPadding;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList strokeColor;

    @androidx.annotation.Dimension
    private float strokeWidth;

    @androidx.annotation.Dimension
    private int topContentPadding;

    @android.annotation.TargetApi(21)
    public class OutlineProvider extends android.view.ViewOutlineProvider {
        private final android.graphics.Rect rect = new android.graphics.Rect();

        public OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(android.view.View view, android.graphics.Outline outline) {
            if (com.google.android.material.imageview.ShapeableImageView.this.shapeAppearanceModel == null) {
                return;
            }
            if (com.google.android.material.imageview.ShapeableImageView.this.shadowDrawable == null) {
                com.google.android.material.imageview.ShapeableImageView.this.shadowDrawable = new com.google.android.material.shape.MaterialShapeDrawable(com.google.android.material.imageview.ShapeableImageView.this.shapeAppearanceModel);
            }
            com.google.android.material.imageview.ShapeableImageView.this.destination.round(this.rect);
            com.google.android.material.imageview.ShapeableImageView.this.shadowDrawable.setBounds(this.rect);
            com.google.android.material.imageview.ShapeableImageView.this.shadowDrawable.getOutline(outline);
        }
    }

    public ShapeableImageView(android.content.Context context) {
        this(context, null, 0);
    }

    public ShapeableImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShapeableImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r0), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        this.pathProvider = com.google.android.material.shape.ShapeAppearancePathProvider.getInstance();
        this.path = new android.graphics.Path();
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = false;
        android.content.Context context2 = getContext();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.clearPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        this.destination = new android.graphics.RectF();
        this.maskRect = new android.graphics.RectF();
        this.maskPath = new android.graphics.Path();
        android.content.res.TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ShapeableImageView, i, i2);
        this.strokeColor = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.ShapeableImageView_strokeColor);
        this.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ShapeableImageView_contentPadding, 0);
        this.leftContentPadding = dimensionPixelSize;
        this.topContentPadding = dimensionPixelSize;
        this.rightContentPadding = dimensionPixelSize;
        this.bottomContentPadding = dimensionPixelSize;
        this.leftContentPadding = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.topContentPadding = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.rightContentPadding = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.bottomContentPadding = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.startContentPadding = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.endContentPadding = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        obtainStyledAttributes.recycle();
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.borderPaint = paint2;
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.shapeAppearanceModel = com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i, i2).build();
        setOutlineProvider(new com.google.android.material.imageview.ShapeableImageView.OutlineProvider());
    }

    private void drawStroke(android.graphics.Canvas canvas) {
        if (this.strokeColor == null) {
            return;
        }
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int colorForState = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth <= 0.0f || colorForState == 0) {
            return;
        }
        this.borderPaint.setColor(colorForState);
        canvas.drawPath(this.path, this.borderPaint);
    }

    private boolean isContentPaddingRelative() {
        return (this.startContentPadding == Integer.MIN_VALUE && this.endContentPadding == Integer.MIN_VALUE) ? false : true;
    }

    private boolean isRtl() {
        return getLayoutDirection() == 1;
    }

    private void updateShapeMask(int i, int i2) {
        this.destination.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, i, i2);
        this.maskPath.addRect(this.maskRect, android.graphics.Path.Direction.CCW);
    }

    @androidx.annotation.Dimension
    public int getContentPaddingBottom() {
        return this.bottomContentPadding;
    }

    @androidx.annotation.Dimension
    public final int getContentPaddingEnd() {
        int i = this.endContentPadding;
        return i != Integer.MIN_VALUE ? i : isRtl() ? this.leftContentPadding : this.rightContentPadding;
    }

    @androidx.annotation.Dimension
    public int getContentPaddingLeft() {
        int i;
        int i2;
        if (isContentPaddingRelative()) {
            if (isRtl() && (i2 = this.endContentPadding) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!isRtl() && (i = this.startContentPadding) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.leftContentPadding;
    }

    @androidx.annotation.Dimension
    public int getContentPaddingRight() {
        int i;
        int i2;
        if (isContentPaddingRelative()) {
            if (isRtl() && (i2 = this.startContentPadding) != Integer.MIN_VALUE) {
                return i2;
            }
            if (!isRtl() && (i = this.endContentPadding) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.rightContentPadding;
    }

    @androidx.annotation.Dimension
    public final int getContentPaddingStart() {
        int i = this.startContentPadding;
        return i != Integer.MIN_VALUE ? i : isRtl() ? this.rightContentPadding : this.leftContentPadding;
    }

    @androidx.annotation.Dimension
    public int getContentPaddingTop() {
        return this.topContentPadding;
    }

    @Override // android.view.View
    @androidx.annotation.Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @androidx.annotation.Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @androidx.annotation.Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @androidx.annotation.Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @androidx.annotation.Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @androidx.annotation.Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.Shapeable
    @androidx.annotation.NonNull
    public com.google.android.material.shape.ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    @androidx.annotation.Dimension
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.maskPath, this.clearPaint);
        drawStroke(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.hasAdjustedPaddingAfterLayoutDirectionResolved && isLayoutDirectionResolved()) {
            this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
            if (isPaddingRelative() || isContentPaddingRelative()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateShapeMask(i, i2);
    }

    public void setContentPadding(@androidx.annotation.Dimension int i, @androidx.annotation.Dimension int i2, @androidx.annotation.Dimension int i3, @androidx.annotation.Dimension int i4) {
        this.startContentPadding = Integer.MIN_VALUE;
        this.endContentPadding = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.leftContentPadding) + i, (super.getPaddingTop() - this.topContentPadding) + i2, (super.getPaddingRight() - this.rightContentPadding) + i3, (super.getPaddingBottom() - this.bottomContentPadding) + i4);
        this.leftContentPadding = i;
        this.topContentPadding = i2;
        this.rightContentPadding = i3;
        this.bottomContentPadding = i4;
    }

    @androidx.annotation.RequiresApi(17)
    public void setContentPaddingRelative(@androidx.annotation.Dimension int i, @androidx.annotation.Dimension int i2, @androidx.annotation.Dimension int i3, @androidx.annotation.Dimension int i4) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i, (super.getPaddingTop() - this.topContentPadding) + i2, (super.getPaddingEnd() - getContentPaddingEnd()) + i3, (super.getPaddingBottom() - this.bottomContentPadding) + i4);
        this.leftContentPadding = isRtl() ? i3 : i;
        this.topContentPadding = i2;
        if (!isRtl()) {
            i = i3;
        }
        this.rightContentPadding = i;
        this.bottomContentPadding = i4;
    }

    @Override // android.view.View
    public void setPadding(@androidx.annotation.Dimension int i, @androidx.annotation.Dimension int i2, @androidx.annotation.Dimension int i3, @androidx.annotation.Dimension int i4) {
        super.setPadding(i + getContentPaddingLeft(), i2 + getContentPaddingTop(), i3 + getContentPaddingRight(), i4 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(@androidx.annotation.Dimension int i, @androidx.annotation.Dimension int i2, @androidx.annotation.Dimension int i3, @androidx.annotation.Dimension int i4) {
        super.setPaddingRelative(i + getContentPaddingStart(), i2 + getContentPaddingTop(), i3 + getContentPaddingEnd(), i4 + getContentPaddingBottom());
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@androidx.annotation.NonNull com.google.android.material.shape.ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = this.shadowDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        updateShapeMask(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.strokeColor = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@androidx.annotation.ColorRes int i) {
        setStrokeColor(androidx.appcompat.content.res.AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setStrokeWidth(@androidx.annotation.Dimension float f) {
        if (this.strokeWidth != f) {
            this.strokeWidth = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@androidx.annotation.DimenRes int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }
}
