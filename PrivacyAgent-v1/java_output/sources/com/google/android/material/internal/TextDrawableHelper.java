package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class TextDrawableHelper {

    @androidx.annotation.Nullable
    private com.google.android.material.resources.TextAppearance textAppearance;
    private float textWidth;
    private final android.text.TextPaint textPaint = new android.text.TextPaint(1);
    private final com.google.android.material.resources.TextAppearanceFontCallback fontCallback = new com.google.android.material.internal.TextDrawableHelper.AnonymousClass1();
    private boolean textWidthDirty = true;

    @androidx.annotation.Nullable
    private java.lang.ref.WeakReference<com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate> delegate = new java.lang.ref.WeakReference<>(null);

    /* renamed from: com.google.android.material.internal.TextDrawableHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.material.resources.TextAppearanceFontCallback {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i) {
            com.google.android.material.internal.TextDrawableHelper.this.textWidthDirty = true;
            com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate textDrawableDelegate = (com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate) com.google.android.material.internal.TextDrawableHelper.this.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(@androidx.annotation.NonNull android.graphics.Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            com.google.android.material.internal.TextDrawableHelper.this.textWidthDirty = true;
            com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate textDrawableDelegate = (com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate) com.google.android.material.internal.TextDrawableHelper.this.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }
    }

    public interface TextDrawableDelegate {
        @androidx.annotation.NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);

        void onTextSizeChange();
    }

    public TextDrawableHelper(@androidx.annotation.Nullable com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate textDrawableDelegate) {
        setDelegate(textDrawableDelegate);
    }

    private float calculateTextWidth(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.textPaint.measureText(charSequence, 0, charSequence.length());
    }

    @androidx.annotation.Nullable
    public com.google.android.material.resources.TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    @androidx.annotation.NonNull
    public android.text.TextPaint getTextPaint() {
        return this.textPaint;
    }

    public float getTextWidth(java.lang.String str) {
        if (!this.textWidthDirty) {
            return this.textWidth;
        }
        float calculateTextWidth = calculateTextWidth(str);
        this.textWidth = calculateTextWidth;
        this.textWidthDirty = false;
        return calculateTextWidth;
    }

    public boolean isTextWidthDirty() {
        return this.textWidthDirty;
    }

    public void setDelegate(@androidx.annotation.Nullable com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate textDrawableDelegate) {
        this.delegate = new java.lang.ref.WeakReference<>(textDrawableDelegate);
    }

    public void setTextAppearance(@androidx.annotation.Nullable com.google.android.material.resources.TextAppearance textAppearance, android.content.Context context) {
        if (this.textAppearance != textAppearance) {
            this.textAppearance = textAppearance;
            if (textAppearance != null) {
                textAppearance.updateMeasureState(context, this.textPaint, this.fontCallback);
                com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate textDrawableDelegate = this.delegate.get();
                if (textDrawableDelegate != null) {
                    this.textPaint.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.updateDrawState(context, this.textPaint, this.fontCallback);
                this.textWidthDirty = true;
            }
            com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate textDrawableDelegate2 = this.delegate.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.onTextSizeChange();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void setTextWidthDirty(boolean z) {
        this.textWidthDirty = z;
    }

    public void updateTextPaintDrawState(android.content.Context context) {
        this.textAppearance.updateDrawState(context, this.textPaint, this.fontCallback);
    }
}
