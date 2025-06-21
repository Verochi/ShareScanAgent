package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
abstract class DrawingDelegate<S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec> {
    protected com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    public DrawingDelegate(S s2) {
        this.spec = s2;
    }

    public abstract void adjustCanvas(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f);

    public abstract void fillIndicator(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2, @androidx.annotation.ColorInt int i);

    public abstract void fillTrack(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint);

    public abstract int getPreferredHeight();

    public abstract int getPreferredWidth();

    public void registerDrawable(@androidx.annotation.NonNull com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
        this.drawable = drawableWithAnimatedVisibilityChange;
    }

    public void validateSpecAndAdjustCanvas(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.spec.validateSpec();
        adjustCanvas(canvas, f);
    }
}
