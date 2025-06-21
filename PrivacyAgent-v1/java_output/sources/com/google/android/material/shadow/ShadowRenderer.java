package com.google.android.material.shadow;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class ShadowRenderer {
    private static final int COLOR_ALPHA_END = 0;
    private static final int COLOR_ALPHA_MIDDLE = 20;
    private static final int COLOR_ALPHA_START = 68;

    @androidx.annotation.NonNull
    private final android.graphics.Paint cornerShadowPaint;

    @androidx.annotation.NonNull
    private final android.graphics.Paint edgeShadowPaint;
    private final android.graphics.Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;

    @androidx.annotation.NonNull
    private final android.graphics.Paint shadowPaint;
    private int shadowStartColor;
    private android.graphics.Paint transparentPaint;
    private static final int[] edgeColors = new int[3];
    private static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    private static final int[] cornerColors = new int[4];
    private static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};

    public ShadowRenderer() {
        this(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
    }

    public ShadowRenderer(int i) {
        this.scratch = new android.graphics.Path();
        this.transparentPaint = new android.graphics.Paint();
        this.shadowPaint = new android.graphics.Paint();
        setShadowColor(i);
        this.transparentPaint.setColor(0);
        android.graphics.Paint paint = new android.graphics.Paint(4);
        this.cornerShadowPaint = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        this.edgeShadowPaint = new android.graphics.Paint(paint);
    }

    public void drawCornerShadow(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.Nullable android.graphics.Matrix matrix, @androidx.annotation.NonNull android.graphics.RectF rectF, int i, float f, float f2) {
        boolean z = f2 < 0.0f;
        android.graphics.Path path = this.scratch;
        if (z) {
            int[] iArr = cornerColors;
            iArr[0] = 0;
            iArr[1] = this.shadowEndColor;
            iArr[2] = this.shadowMiddleColor;
            iArr[3] = this.shadowStartColor;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f2);
            path.close();
            float f3 = -i;
            rectF.inset(f3, f3);
            int[] iArr2 = cornerColors;
            iArr2[0] = 0;
            iArr2[1] = this.shadowStartColor;
            iArr2[2] = this.shadowMiddleColor;
            iArr2[3] = this.shadowEndColor;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f4 = 1.0f - (i / width);
        float[] fArr = cornerPositions;
        fArr[1] = f4;
        fArr[2] = ((1.0f - f4) / 2.0f) + f4;
        this.cornerShadowPaint.setShader(new android.graphics.RadialGradient(rectF.centerX(), rectF.centerY(), width, cornerColors, fArr, android.graphics.Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, android.graphics.Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.transparentPaint);
        }
        canvas.drawArc(rectF, f, f2, true, this.cornerShadowPaint);
        canvas.restore();
    }

    public void drawEdgeShadow(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.Nullable android.graphics.Matrix matrix, @androidx.annotation.NonNull android.graphics.RectF rectF, int i) {
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int[] iArr = edgeColors;
        iArr[0] = this.shadowEndColor;
        iArr[1] = this.shadowMiddleColor;
        iArr[2] = this.shadowStartColor;
        android.graphics.Paint paint = this.edgeShadowPaint;
        float f = rectF.left;
        paint.setShader(new android.graphics.LinearGradient(f, rectF.top, f, rectF.bottom, iArr, edgePositions, android.graphics.Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.edgeShadowPaint);
        canvas.restore();
    }

    @androidx.annotation.NonNull
    public android.graphics.Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public void setShadowColor(int i) {
        this.shadowStartColor = androidx.core.graphics.ColorUtils.setAlphaComponent(i, 68);
        this.shadowMiddleColor = androidx.core.graphics.ColorUtils.setAlphaComponent(i, 20);
        this.shadowEndColor = androidx.core.graphics.ColorUtils.setAlphaComponent(i, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }
}
