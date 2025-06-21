package com.google.android.material.tooltip;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class TooltipDrawable extends com.google.android.material.shape.MaterialShapeDrawable implements com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate {

    @androidx.annotation.StyleRes
    private static final int DEFAULT_STYLE = com.google.android.material.R.style.Widget_MaterialComponents_Tooltip;

    @androidx.annotation.AttrRes
    private static final int DEFAULT_THEME_ATTR = com.google.android.material.R.attr.tooltipStyle;
    private int arrowSize;

    @androidx.annotation.NonNull
    private final android.view.View.OnLayoutChangeListener attachedViewLayoutChangeListener;

    @androidx.annotation.NonNull
    private final android.content.Context context;

    @androidx.annotation.NonNull
    private final android.graphics.Rect displayFrame;

    @androidx.annotation.Nullable
    private final android.graphics.Paint.FontMetrics fontMetrics;
    private float labelOpacity;
    private int layoutMargin;
    private int locationOnScreenX;
    private int minHeight;
    private int minWidth;
    private int padding;

    @androidx.annotation.Nullable
    private java.lang.CharSequence text;

    @androidx.annotation.NonNull
    private final com.google.android.material.internal.TextDrawableHelper textDrawableHelper;
    private final float tooltipPivotX;
    private float tooltipPivotY;
    private float tooltipScaleX;
    private float tooltipScaleY;

    /* renamed from: com.google.android.material.tooltip.TooltipDrawable$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnLayoutChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            com.google.android.material.tooltip.TooltipDrawable.this.updateLocationOnScreen(view);
        }
    }

    private TooltipDrawable(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        super(context, attributeSet, i, i2);
        this.fontMetrics = new android.graphics.Paint.FontMetrics();
        com.google.android.material.internal.TextDrawableHelper textDrawableHelper = new com.google.android.material.internal.TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        this.attachedViewLayoutChangeListener = new com.google.android.material.tooltip.TooltipDrawable.AnonymousClass1();
        this.displayFrame = new android.graphics.Rect();
        this.tooltipScaleX = 1.0f;
        this.tooltipScaleY = 1.0f;
        this.tooltipPivotX = 0.5f;
        this.tooltipPivotY = 0.5f;
        this.labelOpacity = 1.0f;
        this.context = context;
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        textDrawableHelper.getTextPaint().setTextAlign(android.graphics.Paint.Align.CENTER);
    }

    private float calculatePointerOffset() {
        int i;
        if (((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin < 0) {
            i = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
        } else {
            if (((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin <= 0) {
                return 0.0f;
            }
            i = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        }
        return i;
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        android.graphics.Paint.FontMetrics fontMetrics = this.fontMetrics;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float calculateTextOriginAndAlignment(@androidx.annotation.NonNull android.graphics.Rect rect) {
        return rect.centerY() - calculateTextCenterFromBaseline();
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.tooltip.TooltipDrawable create(@androidx.annotation.NonNull android.content.Context context) {
        return createFromAttributes(context, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.tooltip.TooltipDrawable createFromAttributes(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        return createFromAttributes(context, attributeSet, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.tooltip.TooltipDrawable createFromAttributes(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        com.google.android.material.tooltip.TooltipDrawable tooltipDrawable = new com.google.android.material.tooltip.TooltipDrawable(context, attributeSet, i, i2);
        tooltipDrawable.loadFromAttributes(attributeSet, i, i2);
        return tooltipDrawable;
    }

    private com.google.android.material.shape.EdgeTreatment createMarkerEdge() {
        float f = -calculatePointerOffset();
        float width = ((float) (getBounds().width() - (this.arrowSize * java.lang.Math.sqrt(2.0d)))) / 2.0f;
        return new com.google.android.material.shape.OffsetEdgeTreatment(new com.google.android.material.shape.MarkerEdgeTreatment(this.arrowSize), java.lang.Math.min(java.lang.Math.max(f, -width), width));
    }

    private void drawText(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        if (this.text == null) {
            return;
        }
        int calculateTextOriginAndAlignment = (int) calculateTextOriginAndAlignment(getBounds());
        if (this.textDrawableHelper.getTextAppearance() != null) {
            this.textDrawableHelper.getTextPaint().drawableState = getState();
            this.textDrawableHelper.updateTextPaintDrawState(this.context);
            this.textDrawableHelper.getTextPaint().setAlpha((int) (this.labelOpacity * 255.0f));
        }
        java.lang.CharSequence charSequence = this.text;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), calculateTextOriginAndAlignment, this.textDrawableHelper.getTextPaint());
    }

    private float getTextWidth() {
        java.lang.CharSequence charSequence = this.text;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.textDrawableHelper.getTextWidth(charSequence.toString());
    }

    private void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, com.google.android.material.R.styleable.Tooltip, i, i2, new int[0]);
        this.arrowSize = this.context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
        setText(obtainStyledAttributes.getText(com.google.android.material.R.styleable.Tooltip_android_text));
        setTextAppearance(com.google.android.material.resources.MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Tooltip_android_textAppearance));
        setFillColor(android.content.res.ColorStateList.valueOf(obtainStyledAttributes.getColor(com.google.android.material.R.styleable.Tooltip_backgroundTint, com.google.android.material.color.MaterialColors.layer(androidx.core.graphics.ColorUtils.setAlphaComponent(com.google.android.material.color.MaterialColors.getColor(this.context, android.R.attr.colorBackground, com.google.android.material.tooltip.TooltipDrawable.class.getCanonicalName()), 229), androidx.core.graphics.ColorUtils.setAlphaComponent(com.google.android.material.color.MaterialColors.getColor(this.context, com.google.android.material.R.attr.colorOnBackground, com.google.android.material.tooltip.TooltipDrawable.class.getCanonicalName()), com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE)))));
        setStrokeColor(android.content.res.ColorStateList.valueOf(com.google.android.material.color.MaterialColors.getColor(this.context, com.google.android.material.R.attr.colorSurface, com.google.android.material.tooltip.TooltipDrawable.class.getCanonicalName())));
        this.padding = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Tooltip_android_padding, 0);
        this.minWidth = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Tooltip_android_minWidth, 0);
        this.minHeight = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Tooltip_android_minHeight, 0);
        this.layoutMargin = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Tooltip_android_layout_margin, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocationOnScreen(@androidx.annotation.NonNull android.view.View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.locationOnScreenX = iArr[0];
        view.getWindowVisibleDisplayFrame(this.displayFrame);
    }

    public void detachView(@androidx.annotation.Nullable android.view.View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        canvas.save();
        float calculatePointerOffset = calculatePointerOffset();
        float f = (float) (-((this.arrowSize * java.lang.Math.sqrt(2.0d)) - this.arrowSize));
        canvas.scale(this.tooltipScaleX, this.tooltipScaleY, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.tooltipPivotY));
        canvas.translate(calculatePointerOffset, f);
        super.draw(canvas);
        drawText(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) java.lang.Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), this.minHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) java.lang.Math.max((this.padding * 2) + getTextWidth(), this.minWidth);
    }

    public int getLayoutMargin() {
        return this.layoutMargin;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getText() {
        return this.text;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.resources.TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public int getTextPadding() {
        return this.padding;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setLayoutMargin(@androidx.annotation.Px int i) {
        this.layoutMargin = i;
        invalidateSelf();
    }

    public void setMinHeight(@androidx.annotation.Px int i) {
        this.minHeight = i;
        invalidateSelf();
    }

    public void setMinWidth(@androidx.annotation.Px int i) {
        this.minWidth = i;
        invalidateSelf();
    }

    public void setRelativeToView(@androidx.annotation.Nullable android.view.View view) {
        if (view == null) {
            return;
        }
        updateLocationOnScreen(view);
        view.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void setRevealFraction(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.tooltipPivotY = 1.2f;
        this.tooltipScaleX = f;
        this.tooltipScaleY = f;
        this.labelOpacity = com.google.android.material.animation.AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, f);
        invalidateSelf();
    }

    public void setText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.equals(this.text, charSequence)) {
            return;
        }
        this.text = charSequence;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
    }

    public void setTextAppearance(@androidx.annotation.Nullable com.google.android.material.resources.TextAppearance textAppearance) {
        this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
    }

    public void setTextAppearanceResource(@androidx.annotation.StyleRes int i) {
        setTextAppearance(new com.google.android.material.resources.TextAppearance(this.context, i));
    }

    public void setTextPadding(@androidx.annotation.Px int i) {
        this.padding = i;
        invalidateSelf();
    }

    public void setTextResource(@androidx.annotation.StringRes int i) {
        setText(this.context.getResources().getString(i));
    }
}
