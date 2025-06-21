package com.google.android.material.resources;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class TextAppearance {
    private static final java.lang.String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private android.graphics.Typeface font;

    @androidx.annotation.Nullable
    public final java.lang.String fontFamily;

    @androidx.annotation.FontRes
    private final int fontFamilyResourceId;
    private boolean fontResolved = false;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;

    @androidx.annotation.Nullable
    public final android.content.res.ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;

    @androidx.annotation.Nullable
    public final android.content.res.ColorStateList textColor;

    @androidx.annotation.Nullable
    public final android.content.res.ColorStateList textColorHint;

    @androidx.annotation.Nullable
    public final android.content.res.ColorStateList textColorLink;
    public float textSize;
    public final int textStyle;
    public final int typeface;

    /* renamed from: com.google.android.material.resources.TextAppearance$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.core.content.res.ResourcesCompat.FontCallback {
        final /* synthetic */ com.google.android.material.resources.TextAppearanceFontCallback val$callback;

        public AnonymousClass1(com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
            this.val$callback = textAppearanceFontCallback;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i) {
            com.google.android.material.resources.TextAppearance.this.fontResolved = true;
            this.val$callback.onFontRetrievalFailed(i);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@androidx.annotation.NonNull android.graphics.Typeface typeface) {
            com.google.android.material.resources.TextAppearance textAppearance = com.google.android.material.resources.TextAppearance.this;
            textAppearance.font = android.graphics.Typeface.create(typeface, textAppearance.textStyle);
            com.google.android.material.resources.TextAppearance.this.fontResolved = true;
            this.val$callback.onFontRetrieved(com.google.android.material.resources.TextAppearance.this.font, false);
        }
    }

    /* renamed from: com.google.android.material.resources.TextAppearance$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.android.material.resources.TextAppearanceFontCallback {
        final /* synthetic */ com.google.android.material.resources.TextAppearanceFontCallback val$callback;
        final /* synthetic */ android.text.TextPaint val$textPaint;

        public AnonymousClass2(android.text.TextPaint textPaint, com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
            this.val$textPaint = textPaint;
            this.val$callback = textAppearanceFontCallback;
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i) {
            this.val$callback.onFontRetrievalFailed(i);
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(@androidx.annotation.NonNull android.graphics.Typeface typeface, boolean z) {
            com.google.android.material.resources.TextAppearance.this.updateTextPaintMeasureState(this.val$textPaint, typeface);
            this.val$callback.onFontRetrieved(typeface, z);
        }
    }

    public TextAppearance(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.StyleRes int i) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.R.styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(com.google.android.material.R.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.TextAppearance_android_textColor);
        this.textColorHint = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = com.google.android.material.resources.MaterialResources.getIndexWithValue(obtainStyledAttributes, com.google.android.material.R.styleable.TextAppearance_fontFamily, com.google.android.material.R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(com.google.android.material.R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        android.content.res.TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, com.google.android.material.R.styleable.MaterialTextAppearance);
        int i2 = com.google.android.material.R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(i2);
        this.letterSpacing = obtainStyledAttributes2.getFloat(i2, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void createFallbackFont() {
        java.lang.String str;
        if (this.font == null && (str = this.fontFamily) != null) {
            this.font = android.graphics.Typeface.create(str, this.textStyle);
        }
        if (this.font == null) {
            int i = this.typeface;
            if (i == 1) {
                this.font = android.graphics.Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.font = android.graphics.Typeface.SERIF;
            } else if (i != 3) {
                this.font = android.graphics.Typeface.DEFAULT;
            } else {
                this.font = android.graphics.Typeface.MONOSPACE;
            }
            this.font = android.graphics.Typeface.create(this.font, this.textStyle);
        }
    }

    private boolean shouldLoadFontSynchronously(android.content.Context context) {
        if (com.google.android.material.resources.TextAppearanceConfig.shouldLoadFontSynchronously()) {
            return true;
        }
        int i = this.fontFamilyResourceId;
        return (i != 0 ? androidx.core.content.res.ResourcesCompat.getCachedFont(context, i) : null) != null;
    }

    public android.graphics.Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.VisibleForTesting
    public android.graphics.Typeface getFont(@androidx.annotation.NonNull android.content.Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                android.graphics.Typeface font = androidx.core.content.res.ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                this.font = font;
                if (font != null) {
                    this.font = android.graphics.Typeface.create(font, this.textStyle);
                }
            } catch (android.content.res.Resources.NotFoundException | java.lang.UnsupportedOperationException unused) {
            } catch (java.lang.Exception unused2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Error loading font ");
                sb.append(this.fontFamily);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.text.TextPaint textPaint, @androidx.annotation.NonNull com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(textPaint, getFallbackFont());
        getFontAsync(context, new com.google.android.material.resources.TextAppearance.AnonymousClass2(textPaint, textAppearanceFontCallback));
    }

    public void getFontAsync(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            getFont(context);
        } else {
            createFallbackFont();
        }
        int i = this.fontFamilyResourceId;
        if (i == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            androidx.core.content.res.ResourcesCompat.getFont(context, i, new com.google.android.material.resources.TextAppearance.AnonymousClass1(textAppearanceFontCallback), null);
        } catch (android.content.res.Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (java.lang.Exception unused2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Error loading font ");
            sb.append(this.fontFamily);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    public void updateDrawState(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.text.TextPaint textPaint, @androidx.annotation.NonNull com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        android.content.res.ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        float f = this.shadowRadius;
        float f2 = this.shadowDx;
        float f3 = this.shadowDy;
        android.content.res.ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void updateMeasureState(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.text.TextPaint textPaint, @androidx.annotation.NonNull com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
        if (shouldLoadFontSynchronously(context)) {
            updateTextPaintMeasureState(textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(@androidx.annotation.NonNull android.text.TextPaint textPaint, @androidx.annotation.NonNull android.graphics.Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.textStyle;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }
}
