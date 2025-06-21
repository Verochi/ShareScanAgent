package com.google.android.material.chip;

/* loaded from: classes22.dex */
public class ChipDrawable extends com.google.android.material.shape.MaterialShapeDrawable implements android.graphics.drawable.Drawable.Callback, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate {
    private static final boolean DEBUG = false;
    private static final int MAX_CHIP_ICON_HEIGHT = 24;
    private static final java.lang.String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private int alpha;
    private boolean checkable;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable checkedIcon;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList checkedIconTint;
    private boolean checkedIconVisible;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable chipIcon;
    private float chipIconSize;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final android.graphics.Paint chipPaint;
    private float chipStartPadding;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList chipStrokeColor;
    private float chipStrokeWidth;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList chipSurfaceColor;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable closeIcon;

    @androidx.annotation.Nullable
    private java.lang.CharSequence closeIconContentDescription;
    private float closeIconEndPadding;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList closeIconTint;
    private boolean closeIconVisible;

    @androidx.annotation.Nullable
    private android.graphics.ColorFilter colorFilter;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList compatRippleColor;

    @androidx.annotation.NonNull
    private final android.content.Context context;
    private boolean currentChecked;

    @androidx.annotation.ColorInt
    private int currentChipBackgroundColor;

    @androidx.annotation.ColorInt
    private int currentChipStrokeColor;

    @androidx.annotation.ColorInt
    private int currentChipSurfaceColor;

    @androidx.annotation.ColorInt
    private int currentCompatRippleColor;

    @androidx.annotation.ColorInt
    private int currentCompositeSurfaceBackgroundColor;

    @androidx.annotation.ColorInt
    private int currentTextColor;

    @androidx.annotation.ColorInt
    private int currentTint;

    @androidx.annotation.Nullable
    private final android.graphics.Paint debugPaint;

    @androidx.annotation.NonNull
    private java.lang.ref.WeakReference<com.google.android.material.chip.ChipDrawable.Delegate> delegate;
    private final android.graphics.Paint.FontMetrics fontMetrics;
    private boolean hasChipIconTint;

    @androidx.annotation.Nullable
    private com.google.android.material.animation.MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final android.graphics.PointF pointF;
    private final android.graphics.RectF rectF;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList rippleColor;
    private final android.graphics.Path shapePath;
    private boolean shouldDrawText;

    @androidx.annotation.Nullable
    private com.google.android.material.animation.MotionSpec showMotionSpec;

    @androidx.annotation.Nullable
    private java.lang.CharSequence text;

    @androidx.annotation.NonNull
    private final com.google.android.material.internal.TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList tint;

    @androidx.annotation.Nullable
    private android.graphics.PorterDuffColorFilter tintFilter;

    @androidx.annotation.Nullable
    private android.graphics.PorterDuff.Mode tintMode;
    private android.text.TextUtils.TruncateAt truncateAt;
    private boolean useCompatRipple;
    private static final int[] DEFAULT_STATE = {android.R.attr.state_enabled};
    private static final android.graphics.drawable.ShapeDrawable closeIconRippleMask = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.OvalShape());

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    private ChipDrawable(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        super(context, attributeSet, i, i2);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new android.graphics.Paint(1);
        this.fontMetrics = new android.graphics.Paint.FontMetrics();
        this.rectF = new android.graphics.RectF();
        this.pointF = new android.graphics.PointF();
        this.shapePath = new android.graphics.Path();
        this.alpha = 255;
        this.tintMode = android.graphics.PorterDuff.Mode.SRC_IN;
        this.delegate = new java.lang.ref.WeakReference<>(null);
        initializeElevationOverlay(context);
        this.context = context;
        com.google.android.material.internal.TextDrawableHelper textDrawableHelper = new com.google.android.material.internal.TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        this.text = "";
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        int[] iArr = DEFAULT_STATE;
        setState(iArr);
        setCloseIconState(iArr);
        this.shouldDrawText = true;
        if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
            closeIconRippleMask.setTint(-1);
        }
    }

    private void applyChildDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(drawable, androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.closeIcon) {
            if (drawable.isStateful()) {
                drawable.setState(getCloseIconState());
            }
            androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, this.closeIconTint);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        android.graphics.drawable.Drawable drawable2 = this.chipIcon;
        if (drawable == drawable2 && this.hasChipIconTint) {
            androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable2, this.chipIconTint);
        }
    }

    private void calculateChipIconBounds(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        rectF.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f = this.chipStartPadding + this.iconStartPadding;
            float currentChipIconWidth = getCurrentChipIconWidth();
            if (androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + currentChipIconWidth;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - currentChipIconWidth;
            }
            float currentChipIconHeight = getCurrentChipIconHeight();
            float exactCenterY = rect.exactCenterY() - (currentChipIconHeight / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + currentChipIconHeight;
        }
    }

    private void calculateChipTouchBounds(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        rectF.set(rect);
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    private void calculateCloseIconBounds(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        rectF.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding;
            if (androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.closeIconSize;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.closeIconSize;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.closeIconSize;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    private void calculateCloseIconTouchBounds(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        rectF.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void calculateTextBounds(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.graphics.RectF rectF) {
        rectF.setEmpty();
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            float calculateCloseIconWidth = this.chipEndPadding + calculateCloseIconWidth() + this.textEndPadding;
            if (androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + calculateChipIconWidth;
                rectF.right = rect.right - calculateCloseIconWidth;
            } else {
                rectF.left = rect.left + calculateCloseIconWidth;
                rectF.right = rect.right - calculateChipIconWidth;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        android.graphics.Paint.FontMetrics fontMetrics = this.fontMetrics;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean canShowCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.checkable;
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.chip.ChipDrawable createFromAttributes(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        com.google.android.material.chip.ChipDrawable chipDrawable = new com.google.android.material.chip.ChipDrawable(context, attributeSet, i, i2);
        chipDrawable.loadFromAttributes(attributeSet, i, i2);
        return chipDrawable;
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.chip.ChipDrawable createFromResource(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.XmlRes int i) {
        android.util.AttributeSet parseDrawableXml = com.google.android.material.drawable.DrawableUtils.parseDrawableXml(context, i, "chip");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = com.google.android.material.R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return createFromAttributes(context, parseDrawableXml, com.google.android.material.R.attr.chipStandaloneStyle, styleAttribute);
    }

    private void drawCheckedIcon(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        if (showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            android.graphics.RectF rectF = this.rectF;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawChipBackground(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        if (this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(rect);
        canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
    }

    private void drawChipIcon(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        if (showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            android.graphics.RectF rectF = this.rectF;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawChipStroke(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        if (this.chipStrokeWidth <= 0.0f || this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipStrokeColor);
        this.chipPaint.setStyle(android.graphics.Paint.Style.STROKE);
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColorFilter(getTintColorFilter());
        }
        android.graphics.RectF rectF = this.rectF;
        float f = rect.left;
        float f2 = this.chipStrokeWidth;
        rectF.set(f + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        canvas.drawRoundRect(this.rectF, f3, f3, this.chipPaint);
    }

    private void drawChipSurface(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        if (this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipSurfaceColor);
        this.chipPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.rectF.set(rect);
        canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
    }

    private void drawCloseIcon(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        if (showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            android.graphics.RectF rectF = this.rectF;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
            } else {
                this.closeIcon.draw(canvas);
            }
            canvas.translate(-f, -f2);
        }
    }

    private void drawCompatRipple(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.rectF.set(rect);
        if (!this.isShapeThemingEnabled) {
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        } else {
            calculatePathForSize(new android.graphics.RectF(rect), this.shapePath);
            super.drawShape(canvas, this.chipPaint, this.shapePath, getBoundsAsRectF());
        }
    }

    private void drawDebug(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        android.graphics.Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setColor(androidx.core.graphics.ColorUtils.setAlphaComponent(androidx.core.view.ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(rect, this.debugPaint);
            if (showsChipIcon() || showsCheckedIcon()) {
                calculateChipIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            if (this.text != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.debugPaint);
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            this.debugPaint.setColor(androidx.core.graphics.ColorUtils.setAlphaComponent(androidx.core.internal.view.SupportMenu.CATEGORY_MASK, 127));
            calculateChipTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(androidx.core.graphics.ColorUtils.setAlphaComponent(-16711936, 127));
            calculateCloseIconTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
        }
    }

    private void drawText(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Rect rect) {
        if (this.text != null) {
            android.graphics.Paint.Align calculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
            calculateTextBounds(rect, this.rectF);
            if (this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
            }
            this.textDrawableHelper.getTextPaint().setTextAlign(calculateTextOriginAndAlignment);
            int i = 0;
            boolean z = java.lang.Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) > java.lang.Math.round(this.rectF.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.rectF);
            }
            java.lang.CharSequence charSequence = this.text;
            if (z && this.truncateAt != null) {
                charSequence = android.text.TextUtils.ellipsize(charSequence, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
            }
            java.lang.CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            android.graphics.PointF pointF = this.pointF;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.textDrawableHelper.getTextPaint());
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    private float getCurrentChipIconHeight() {
        android.graphics.drawable.Drawable drawable = this.currentChecked ? this.checkedIcon : this.chipIcon;
        float f = this.chipIconSize;
        if (f <= 0.0f && drawable != null) {
            f = (float) java.lang.Math.ceil(com.google.android.material.internal.ViewUtils.dpToPx(this.context, 24));
            if (drawable.getIntrinsicHeight() <= f) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f;
    }

    private float getCurrentChipIconWidth() {
        android.graphics.drawable.Drawable drawable = this.currentChecked ? this.checkedIcon : this.chipIcon;
        float f = this.chipIconSize;
        return (f > 0.0f || drawable == null) ? f : drawable.getIntrinsicWidth();
    }

    @androidx.annotation.Nullable
    private android.graphics.ColorFilter getTintColorFilter() {
        android.graphics.ColorFilter colorFilter = this.colorFilter;
        return colorFilter != null ? colorFilter : this.tintFilter;
    }

    private static boolean hasState(@androidx.annotation.Nullable int[] iArr, @androidx.annotation.AttrRes int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStateful(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean isStateful(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean isStateful(@androidx.annotation.Nullable com.google.android.material.resources.TextAppearance textAppearance) {
        android.content.res.ColorStateList colorStateList;
        return (textAppearance == null || (colorStateList = textAppearance.textColor) == null || !colorStateList.isStateful()) ? false : true;
    }

    private void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, com.google.android.material.R.styleable.Chip, i, i2, new int[0]);
        this.isShapeThemingEnabled = obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        setChipSurfaceColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_chipSurfaceColor));
        setChipBackgroundColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, 0.0f));
        int i3 = com.google.android.material.R.styleable.Chip_chipCornerRadius;
        if (obtainStyledAttributes.hasValue(i3)) {
            setChipCornerRadius(obtainStyledAttributes.getDimension(i3, 0.0f));
        }
        setChipStrokeColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_rippleColor));
        setText(obtainStyledAttributes.getText(com.google.android.material.R.styleable.Chip_android_text));
        com.google.android.material.resources.TextAppearance textAppearance = com.google.android.material.resources.MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_android_textAppearance);
        textAppearance.textSize = obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_android_textSize, textAppearance.textSize);
        setTextAppearance(textAppearance);
        int i4 = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            setEllipsize(android.text.TextUtils.TruncateAt.START);
        } else if (i4 == 2) {
            setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
        } else if (i4 == 3) {
            setEllipsize(android.text.TextUtils.TruncateAt.END);
        }
        setChipIconVisible(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconVisible") == null) {
            setChipIconVisible(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        }
        setChipIcon(com.google.android.material.resources.MaterialResources.getDrawable(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_chipIcon));
        int i5 = com.google.android.material.R.styleable.Chip_chipIconTint;
        if (obtainStyledAttributes.hasValue(i5)) {
            setChipIconTint(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, obtainStyledAttributes, i5));
        }
        setChipIconSize(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, -1.0f));
        setCloseIconVisible(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconVisible") == null) {
            setCloseIconVisible(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        }
        setCloseIcon(com.google.android.material.resources.MaterialResources.getDrawable(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_closeIcon));
        setCloseIconTint(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_closeIconTint));
        setCloseIconSize(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") == null) {
            setCheckedIconVisible(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        }
        setCheckedIcon(com.google.android.material.resources.MaterialResources.getDrawable(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_checkedIcon));
        int i6 = com.google.android.material.R.styleable.Chip_checkedIconTint;
        if (obtainStyledAttributes.hasValue(i6)) {
            setCheckedIconTint(com.google.android.material.resources.MaterialResources.getColorStateList(this.context, obtainStyledAttributes, i6));
        }
        setShowMotionSpec(com.google.android.material.animation.MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_showMotionSpec));
        setHideMotionSpec(com.google.android.material.animation.MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        setChipStartPadding(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean onStateChange(@androidx.annotation.NonNull int[] iArr, @androidx.annotation.NonNull int[] iArr2) {
        boolean z;
        int colorForState;
        boolean onStateChange = super.onStateChange(iArr);
        android.content.res.ColorStateList colorStateList = this.chipSurfaceColor;
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(colorStateList != null ? colorStateList.getColorForState(iArr, this.currentChipSurfaceColor) : 0);
        boolean z2 = true;
        if (this.currentChipSurfaceColor != compositeElevationOverlayIfNeeded) {
            this.currentChipSurfaceColor = compositeElevationOverlayIfNeeded;
            onStateChange = true;
        }
        android.content.res.ColorStateList colorStateList2 = this.chipBackgroundColor;
        int compositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.currentChipBackgroundColor) : 0);
        if (this.currentChipBackgroundColor != compositeElevationOverlayIfNeeded2) {
            this.currentChipBackgroundColor = compositeElevationOverlayIfNeeded2;
            onStateChange = true;
        }
        int layer = com.google.android.material.color.MaterialColors.layer(compositeElevationOverlayIfNeeded, compositeElevationOverlayIfNeeded2);
        if ((this.currentCompositeSurfaceBackgroundColor != layer) | (getFillColor() == null)) {
            this.currentCompositeSurfaceBackgroundColor = layer;
            setFillColor(android.content.res.ColorStateList.valueOf(layer));
            onStateChange = true;
        }
        android.content.res.ColorStateList colorStateList3 = this.chipStrokeColor;
        int colorForState2 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.currentChipStrokeColor) : 0;
        if (this.currentChipStrokeColor != colorForState2) {
            this.currentChipStrokeColor = colorForState2;
            onStateChange = true;
        }
        int colorForState3 = (this.compatRippleColor == null || !com.google.android.material.ripple.RippleUtils.shouldDrawRippleCompat(iArr)) ? 0 : this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
        if (this.currentCompatRippleColor != colorForState3) {
            this.currentCompatRippleColor = colorForState3;
            if (this.useCompatRipple) {
                onStateChange = true;
            }
        }
        int colorForState4 = (this.textDrawableHelper.getTextAppearance() == null || this.textDrawableHelper.getTextAppearance().textColor == null) ? 0 : this.textDrawableHelper.getTextAppearance().textColor.getColorForState(iArr, this.currentTextColor);
        if (this.currentTextColor != colorForState4) {
            this.currentTextColor = colorForState4;
            onStateChange = true;
        }
        boolean z3 = hasState(getState(), android.R.attr.state_checked) && this.checkable;
        if (this.currentChecked != z3 && this.checkedIcon != null) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.currentChecked = z3;
            if (calculateChipIconWidth != calculateChipIconWidth()) {
                onStateChange = true;
                z = true;
                android.content.res.ColorStateList colorStateList4 = this.tint;
                colorForState = colorStateList4 == null ? colorStateList4.getColorForState(iArr, this.currentTint) : 0;
                if (this.currentTint == colorForState) {
                    this.currentTint = colorForState;
                    this.tintFilter = com.google.android.material.drawable.DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
                } else {
                    z2 = onStateChange;
                }
                if (isStateful(this.chipIcon)) {
                    z2 |= this.chipIcon.setState(iArr);
                }
                if (isStateful(this.checkedIcon)) {
                    z2 |= this.checkedIcon.setState(iArr);
                }
                if (isStateful(this.closeIcon)) {
                    int[] iArr3 = new int[iArr.length + iArr2.length];
                    java.lang.System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    java.lang.System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                    z2 |= this.closeIcon.setState(iArr3);
                }
                if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE && isStateful(this.closeIconRipple)) {
                    z2 |= this.closeIconRipple.setState(iArr2);
                }
                if (z2) {
                    invalidateSelf();
                }
                if (z) {
                    onSizeChange();
                }
                return z2;
            }
            onStateChange = true;
        }
        z = false;
        android.content.res.ColorStateList colorStateList42 = this.tint;
        if (colorStateList42 == null) {
        }
        if (this.currentTint == colorForState) {
        }
        if (isStateful(this.chipIcon)) {
        }
        if (isStateful(this.checkedIcon)) {
        }
        if (isStateful(this.closeIcon)) {
        }
        if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
            z2 |= this.closeIconRipple.setState(iArr2);
        }
        if (z2) {
        }
        if (z) {
        }
        return z2;
    }

    private void setChipSurfaceColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.chipSurfaceColor != colorStateList) {
            this.chipSurfaceColor = colorStateList;
            onStateChange(getState());
        }
    }

    private boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    private boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    private boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    private void unapplyChildDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void updateCompatRippleColor() {
        this.compatRippleColor = this.useCompatRipple ? com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(this.rippleColor) : null;
    }

    @android.annotation.TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new android.graphics.drawable.RippleDrawable(com.google.android.material.ripple.RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    public float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + getCurrentChipIconWidth() + this.iconEndPadding;
        }
        return 0.0f;
    }

    public float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    @androidx.annotation.NonNull
    public android.graphics.Paint.Align calculateTextOriginAndAlignment(@androidx.annotation.NonNull android.graphics.Rect rect, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        pointF.set(0.0f, 0.0f);
        android.graphics.Paint.Align align = android.graphics.Paint.Align.LEFT;
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            if (androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + calculateChipIconWidth;
                align = android.graphics.Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - calculateChipIconWidth;
                align = android.graphics.Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - calculateTextCenterFromBaseline();
        }
        return align;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        android.graphics.Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.alpha;
        int saveLayerAlpha = i < 255 ? com.google.android.material.canvas.CanvasCompat.saveLayerAlpha(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        drawChipSurface(canvas, bounds);
        drawChipBackground(canvas, bounds);
        if (this.isShapeThemingEnabled) {
            super.draw(canvas);
        }
        drawChipStroke(canvas, bounds);
        drawCompatRipple(canvas, bounds);
        drawChipIcon(canvas, bounds);
        drawCheckedIcon(canvas, bounds);
        if (this.shouldDrawText) {
            drawText(canvas, bounds);
        }
        drawCloseIcon(canvas, bounds);
        drawDebug(canvas, bounds);
        if (this.alpha < 255) {
            canvas.restoreToCount(saveLayerAlpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        return this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getChipIcon() {
        android.graphics.drawable.Drawable drawable = this.chipIcon;
        if (drawable != null) {
            return androidx.core.graphics.drawable.DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        calculateChipTouchBounds(getBounds(), rectF);
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getCloseIcon() {
        android.graphics.drawable.Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return androidx.core.graphics.drawable.DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    @androidx.annotation.NonNull
    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        calculateCloseIconTouchBounds(getBounds(), rectF);
    }

    @Override // android.graphics.drawable.Drawable
    @androidx.annotation.Nullable
    public android.graphics.ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public android.text.TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return java.lang.Math.min(java.lang.Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(getText().toString()) + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
    }

    @androidx.annotation.Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @android.annotation.TargetApi(21)
    public void getOutline(@androidx.annotation.NonNull android.graphics.Outline outline) {
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        android.graphics.Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        } else {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.animation.MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getText() {
        return this.text;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.resources.TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @java.lang.Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @java.lang.Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @java.lang.Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    public boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor) || (this.useCompatRipple && isStateful(this.compatRippleColor)) || isStateful(this.textDrawableHelper.getTextAppearance()) || canShowCheckedIcon() || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(this.chipIcon, i);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(this.checkedIcon, i);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(this.closeIcon, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public void onSizeChange() {
        com.google.android.material.chip.ChipDrawable.Delegate delegate = this.delegate.get();
        if (delegate != null) {
            delegate.onChipDrawableSizeChange();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(@androidx.annotation.NonNull int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, getCloseIconState());
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable, long j) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckableResource(@androidx.annotation.BoolRes int i) {
        setCheckable(this.context.getResources().getBoolean(i));
    }

    public void setCheckedIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @java.lang.Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @java.lang.Deprecated
    public void setCheckedIconEnabledResource(@androidx.annotation.BoolRes int i) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setCheckedIconResource(@androidx.annotation.DrawableRes int i) {
        setCheckedIcon(androidx.appcompat.content.res.AppCompatResources.getDrawable(this.context, i));
    }

    public void setCheckedIconTint(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (canShowCheckedIcon()) {
                androidx.core.graphics.drawable.DrawableCompat.setTintList(this.checkedIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCheckedIconTintResource(@androidx.annotation.ColorRes int i) {
        setCheckedIconTint(androidx.appcompat.content.res.AppCompatResources.getColorStateList(this.context, i));
    }

    public void setCheckedIconVisible(@androidx.annotation.BoolRes int i) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipBackgroundColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipBackgroundColorResource(@androidx.annotation.ColorRes int i) {
        setChipBackgroundColor(androidx.appcompat.content.res.AppCompatResources.getColorStateList(this.context, i));
    }

    @java.lang.Deprecated
    public void setChipCornerRadius(float f) {
        if (this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f));
        }
    }

    @java.lang.Deprecated
    public void setChipCornerRadiusResource(@androidx.annotation.DimenRes int i) {
        setChipCornerRadius(this.context.getResources().getDimension(i));
    }

    public void setChipEndPadding(float f) {
        if (this.chipEndPadding != f) {
            this.chipEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipEndPaddingResource(@androidx.annotation.DimenRes int i) {
        setChipEndPadding(this.context.getResources().getDimension(i));
    }

    public void setChipIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable chipIcon = getChipIcon();
        if (chipIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIcon = drawable != null ? androidx.core.graphics.drawable.DrawableCompat.wrap(drawable).mutate() : null;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @java.lang.Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @java.lang.Deprecated
    public void setChipIconEnabledResource(@androidx.annotation.BoolRes int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(@androidx.annotation.DrawableRes int i) {
        setChipIcon(androidx.appcompat.content.res.AppCompatResources.getDrawable(this.context, i));
    }

    public void setChipIconSize(float f) {
        if (this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(@androidx.annotation.DimenRes int i) {
        setChipIconSize(this.context.getResources().getDimension(i));
    }

    public void setChipIconTint(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                androidx.core.graphics.drawable.DrawableCompat.setTintList(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconTintResource(@androidx.annotation.ColorRes int i) {
        setChipIconTint(androidx.appcompat.content.res.AppCompatResources.getColorStateList(this.context, i));
    }

    public void setChipIconVisible(@androidx.annotation.BoolRes int i) {
        setChipIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipMinHeight(float f) {
        if (this.chipMinHeight != f) {
            this.chipMinHeight = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipMinHeightResource(@androidx.annotation.DimenRes int i) {
        setChipMinHeight(this.context.getResources().getDimension(i));
    }

    public void setChipStartPadding(float f) {
        if (this.chipStartPadding != f) {
            this.chipStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPaddingResource(@androidx.annotation.DimenRes int i) {
        setChipStartPadding(this.context.getResources().getDimension(i));
    }

    public void setChipStrokeColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeColorResource(@androidx.annotation.ColorRes int i) {
        setChipStrokeColor(androidx.appcompat.content.res.AppCompatResources.getColorStateList(this.context, i));
    }

    public void setChipStrokeWidth(float f) {
        if (this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            if (this.isShapeThemingEnabled) {
                super.setStrokeWidth(f);
            }
            invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(@androidx.annotation.DimenRes int i) {
        setChipStrokeWidth(this.context.getResources().getDimension(i));
    }

    public void setCloseIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable closeIcon = getCloseIcon();
        if (closeIcon != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            this.closeIcon = drawable != null ? androidx.core.graphics.drawable.DrawableCompat.wrap(drawable).mutate() : null;
            if (com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE) {
                updateFrameworkCloseIconRipple();
            }
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (this.closeIconContentDescription != charSequence) {
            this.closeIconContentDescription = androidx.core.text.BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    @java.lang.Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @java.lang.Deprecated
    public void setCloseIconEnabledResource(@androidx.annotation.BoolRes int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        if (this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(@androidx.annotation.DimenRes int i) {
        setCloseIconEndPadding(this.context.getResources().getDimension(i));
    }

    public void setCloseIconResource(@androidx.annotation.DrawableRes int i) {
        setCloseIcon(androidx.appcompat.content.res.AppCompatResources.getDrawable(this.context, i));
    }

    public void setCloseIconSize(float f) {
        if (this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(@androidx.annotation.DimenRes int i) {
        setCloseIconSize(this.context.getResources().getDimension(i));
    }

    public void setCloseIconStartPadding(float f) {
        if (this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(@androidx.annotation.DimenRes int i) {
        setCloseIconStartPadding(this.context.getResources().getDimension(i));
    }

    public boolean setCloseIconState(@androidx.annotation.NonNull int[] iArr) {
        if (java.util.Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    public void setCloseIconTint(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                androidx.core.graphics.drawable.DrawableCompat.setTintList(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconTintResource(@androidx.annotation.ColorRes int i) {
        setCloseIconTint(androidx.appcompat.content.res.AppCompatResources.getColorStateList(this.context, i));
    }

    public void setCloseIconVisible(@androidx.annotation.BoolRes int i) {
        setCloseIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        if (this.colorFilter != colorFilter) {
            this.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    public void setDelegate(@androidx.annotation.Nullable com.google.android.material.chip.ChipDrawable.Delegate delegate) {
        this.delegate = new java.lang.ref.WeakReference<>(delegate);
    }

    public void setEllipsize(@androidx.annotation.Nullable android.text.TextUtils.TruncateAt truncateAt) {
        this.truncateAt = truncateAt;
    }

    public void setHideMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(@androidx.annotation.AnimatorRes int i) {
        setHideMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(this.context, i));
    }

    public void setIconEndPadding(float f) {
        if (this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(@androidx.annotation.DimenRes int i) {
        setIconEndPadding(this.context.getResources().getDimension(i));
    }

    public void setIconStartPadding(float f) {
        if (this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(@androidx.annotation.DimenRes int i) {
        setIconStartPadding(this.context.getResources().getDimension(i));
    }

    public void setMaxWidth(@androidx.annotation.Px int i) {
        this.maxWidth = i;
    }

    public void setRippleColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public void setRippleColorResource(@androidx.annotation.ColorRes int i) {
        setRippleColor(androidx.appcompat.content.res.AppCompatResources.getColorStateList(this.context, i));
    }

    public void setShouldDrawText(boolean z) {
        this.shouldDrawText = z;
    }

    public void setShowMotionSpec(@androidx.annotation.Nullable com.google.android.material.animation.MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(@androidx.annotation.AnimatorRes int i) {
        setShowMotionSpec(com.google.android.material.animation.MotionSpec.createFromResource(this.context, i));
    }

    public void setText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (android.text.TextUtils.equals(this.text, charSequence)) {
            return;
        }
        this.text = charSequence;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
        onSizeChange();
    }

    public void setTextAppearance(@androidx.annotation.Nullable com.google.android.material.resources.TextAppearance textAppearance) {
        this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
    }

    public void setTextAppearanceResource(@androidx.annotation.StyleRes int i) {
        setTextAppearance(new com.google.android.material.resources.TextAppearance(this.context, i));
    }

    public void setTextEndPadding(float f) {
        if (this.textEndPadding != f) {
            this.textEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextEndPaddingResource(@androidx.annotation.DimenRes int i) {
        setTextEndPadding(this.context.getResources().getDimension(i));
    }

    public void setTextResource(@androidx.annotation.StringRes int i) {
        setText(this.context.getResources().getString(i));
    }

    public void setTextSize(@androidx.annotation.Dimension float f) {
        com.google.android.material.resources.TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.textSize = f;
            this.textDrawableHelper.getTextPaint().setTextSize(f);
            onTextSizeChange();
        }
    }

    public void setTextStartPadding(float f) {
        if (this.textStartPadding != f) {
            this.textStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPaddingResource(@androidx.annotation.DimenRes int i) {
        setTextStartPadding(this.context.getResources().getDimension(i));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = com.google.android.material.drawable.DrawableUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z) {
        if (this.useCompatRipple != z) {
            this.useCompatRipple = z;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Runnable runnable) {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
