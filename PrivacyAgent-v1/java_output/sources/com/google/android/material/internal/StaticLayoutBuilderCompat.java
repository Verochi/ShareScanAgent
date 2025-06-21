package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
final class StaticLayoutBuilderCompat {
    static final int DEFAULT_HYPHENATION_FREQUENCY;
    static final float DEFAULT_LINE_SPACING_ADD = 0.0f;
    static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.0f;
    private static final java.lang.String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final java.lang.String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final java.lang.String TEXT_DIR_CLASS_LTR = "LTR";
    private static final java.lang.String TEXT_DIR_CLASS_RTL = "RTL";

    @androidx.annotation.Nullable
    private static java.lang.reflect.Constructor<android.text.StaticLayout> constructor;
    private static boolean initialized;

    @androidx.annotation.Nullable
    private static java.lang.Object textDirection;
    private int end;
    private boolean isRtl;
    private final android.text.TextPaint paint;
    private java.lang.CharSequence source;
    private final int width;
    private int start = 0;
    private android.text.Layout.Alignment alignment = android.text.Layout.Alignment.ALIGN_NORMAL;
    private int maxLines = Integer.MAX_VALUE;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private int hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
    private boolean includePad = true;

    @androidx.annotation.Nullable
    private android.text.TextUtils.TruncateAt ellipsize = null;

    public static class StaticLayoutBuilderCompatException extends java.lang.Exception {
        public StaticLayoutBuilderCompatException(java.lang.Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        DEFAULT_HYPHENATION_FREQUENCY = android.os.Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    private StaticLayoutBuilderCompat(java.lang.CharSequence charSequence, android.text.TextPaint textPaint, int i) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i;
        this.end = charSequence.length();
    }

    private void createConstructorWithReflection() throws com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException {
        if (initialized) {
            return;
        }
        try {
            textDirection = this.isRtl && android.os.Build.VERSION.SDK_INT >= 23 ? android.text.TextDirectionHeuristics.RTL : android.text.TextDirectionHeuristics.LTR;
            java.lang.Class cls = java.lang.Integer.TYPE;
            java.lang.Class cls2 = java.lang.Float.TYPE;
            java.lang.reflect.Constructor<android.text.StaticLayout> declaredConstructor = android.text.StaticLayout.class.getDeclaredConstructor(java.lang.CharSequence.class, cls, cls, android.text.TextPaint.class, cls, android.text.Layout.Alignment.class, android.text.TextDirectionHeuristic.class, cls2, cls2, java.lang.Boolean.TYPE, android.text.TextUtils.TruncateAt.class, cls, cls);
            constructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
            initialized = true;
        } catch (java.lang.Exception e) {
            throw new com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException(e);
        }
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.internal.StaticLayoutBuilderCompat obtain(@androidx.annotation.NonNull java.lang.CharSequence charSequence, @androidx.annotation.NonNull android.text.TextPaint textPaint, @androidx.annotation.IntRange(from = 0) int i) {
        return new com.google.android.material.internal.StaticLayoutBuilderCompat(charSequence, textPaint, i);
    }

    public android.text.StaticLayout build() throws com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException {
        android.text.StaticLayout.Builder obtain;
        android.text.StaticLayout build;
        if (this.source == null) {
            this.source = "";
        }
        int max = java.lang.Math.max(0, this.width);
        java.lang.CharSequence charSequence = this.source;
        if (this.maxLines == 1) {
            charSequence = android.text.TextUtils.ellipsize(charSequence, this.paint, max, this.ellipsize);
        }
        int min = java.lang.Math.min(charSequence.length(), this.end);
        this.end = min;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            createConstructorWithReflection();
            try {
                return (android.text.StaticLayout) ((java.lang.reflect.Constructor) androidx.core.util.Preconditions.checkNotNull(constructor)).newInstance(charSequence, java.lang.Integer.valueOf(this.start), java.lang.Integer.valueOf(this.end), this.paint, java.lang.Integer.valueOf(max), this.alignment, androidx.core.util.Preconditions.checkNotNull(textDirection), java.lang.Float.valueOf(1.0f), java.lang.Float.valueOf(0.0f), java.lang.Boolean.valueOf(this.includePad), null, java.lang.Integer.valueOf(max), java.lang.Integer.valueOf(this.maxLines));
            } catch (java.lang.Exception e) {
                throw new com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException(e);
            }
        }
        if (this.isRtl && this.maxLines == 1) {
            this.alignment = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        }
        obtain = android.text.StaticLayout.Builder.obtain(charSequence, this.start, min, this.paint, max);
        obtain.setAlignment(this.alignment);
        obtain.setIncludePad(this.includePad);
        obtain.setTextDirection(this.isRtl ? android.text.TextDirectionHeuristics.RTL : android.text.TextDirectionHeuristics.LTR);
        android.text.TextUtils.TruncateAt truncateAt = this.ellipsize;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.maxLines);
        float f = this.lineSpacingAdd;
        if (f != 0.0f || this.lineSpacingMultiplier != 1.0f) {
            obtain.setLineSpacing(f, this.lineSpacingMultiplier);
        }
        if (this.maxLines > 1) {
            obtain.setHyphenationFrequency(this.hyphenationFrequency);
        }
        build = obtain.build();
        return build;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.StaticLayoutBuilderCompat setAlignment(@androidx.annotation.NonNull android.text.Layout.Alignment alignment) {
        this.alignment = alignment;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.StaticLayoutBuilderCompat setEllipsize(@androidx.annotation.Nullable android.text.TextUtils.TruncateAt truncateAt) {
        this.ellipsize = truncateAt;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.StaticLayoutBuilderCompat setEnd(@androidx.annotation.IntRange(from = 0) int i) {
        this.end = i;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.StaticLayoutBuilderCompat setHyphenationFrequency(int i) {
        this.hyphenationFrequency = i;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.StaticLayoutBuilderCompat setIncludePad(boolean z) {
        this.includePad = z;
        return this;
    }

    public com.google.android.material.internal.StaticLayoutBuilderCompat setIsRtl(boolean z) {
        this.isRtl = z;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.StaticLayoutBuilderCompat setLineSpacing(float f, float f2) {
        this.lineSpacingAdd = f;
        this.lineSpacingMultiplier = f2;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.StaticLayoutBuilderCompat setMaxLines(@androidx.annotation.IntRange(from = 0) int i) {
        this.maxLines = i;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.internal.StaticLayoutBuilderCompat setStart(@androidx.annotation.IntRange(from = 0) int i) {
        this.start = i;
        return this;
    }
}
