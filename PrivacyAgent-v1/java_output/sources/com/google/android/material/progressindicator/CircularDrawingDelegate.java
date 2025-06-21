package com.google.android.material.progressindicator;

/* loaded from: classes22.dex */
final class CircularDrawingDelegate extends com.google.android.material.progressindicator.DrawingDelegate<com.google.android.material.progressindicator.CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(@androidx.annotation.NonNull com.google.android.material.progressindicator.CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcDirectionFactor = 1;
    }

    private void drawRoundedEnd(android.graphics.Canvas canvas, android.graphics.Paint paint, float f, float f2, float f3, boolean z, android.graphics.RectF rectF) {
        float f4 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f3);
        float f5 = f / 2.0f;
        float f6 = f4 * f2;
        canvas.drawRect((this.adjustedRadius - f5) + f2, java.lang.Math.min(0.0f, this.arcDirectionFactor * f6), (this.adjustedRadius + f5) - f2, java.lang.Math.max(0.0f, f6 * this.arcDirectionFactor), paint);
        canvas.translate((this.adjustedRadius - f5) + f2, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f4) * 90.0f * this.arcDirectionFactor, true, paint);
        canvas.translate(f - (f2 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f4 * 90.0f * this.arcDirectionFactor, true, paint);
        canvas.restore();
    }

    private int getSize() {
        S s2 = this.spec;
        return ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).indicatorSize + (((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).indicatorInset * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        S s2 = this.spec;
        float f2 = (((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).indicatorSize / 2.0f) + ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) s2).indicatorInset;
        canvas.translate(f2, f2);
        canvas.rotate(-90.0f);
        float f3 = -f2;
        canvas.clipRect(f3, f3, f2, f2);
        this.arcDirectionFactor = ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).indicatorDirection == 0 ? 1 : -1;
        this.displayedTrackThickness = ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) r5).trackThickness * f;
        this.displayedCornerRadius = ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) r5).trackCornerRadius * f;
        this.adjustedRadius = (((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) r5).indicatorSize - ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) r5).trackThickness) / 2.0f;
        if ((this.drawable.isShowing() && ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (this.drawable.isHiding() && ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
            this.adjustedRadius += ((1.0f - f) * ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        } else if ((this.drawable.isShowing() && ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            this.adjustedRadius -= ((1.0f - f) * ((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f2, @androidx.annotation.ColorInt int i) {
        if (f == f2) {
            return;
        }
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeCap(android.graphics.Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.displayedTrackThickness);
        int i2 = this.arcDirectionFactor;
        float f3 = f * 360.0f * i2;
        float f4 = (f2 >= f ? f2 - f : (f2 + 1.0f) - f) * 360.0f * i2;
        float f5 = this.adjustedRadius;
        canvas.drawArc(new android.graphics.RectF(-f5, -f5, f5, f5), f3, f4, false, paint);
        if (this.displayedCornerRadius <= 0.0f || java.lang.Math.abs(f4) >= 360.0f) {
            return;
        }
        paint.setStyle(android.graphics.Paint.Style.FILL);
        float f6 = this.displayedCornerRadius;
        android.graphics.RectF rectF = new android.graphics.RectF(-f6, -f6, f6, f6);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f3, true, rectF);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f3 + f4, false, rectF);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint) {
        int compositeARGBWithAlpha = com.google.android.material.color.MaterialColors.compositeARGBWithAlpha(((com.google.android.material.progressindicator.CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeCap(android.graphics.Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f = this.adjustedRadius;
        canvas.drawArc(new android.graphics.RectF(-f, -f, f, f), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }
}
