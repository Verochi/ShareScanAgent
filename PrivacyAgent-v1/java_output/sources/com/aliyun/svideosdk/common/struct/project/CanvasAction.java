package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class CanvasAction {
    public static final float TOUCH_TOLERANCE = 4.0f;
    public android.graphics.Paint paint;
    public android.graphics.Path path;
    float tempX;
    float tempY;

    public CanvasAction(float f, float f2, android.graphics.Paint paint) {
        this.path = new android.graphics.Path();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        this.paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.paint.setStyle(android.graphics.Paint.Style.STROKE);
        this.path.moveTo(f, f2);
        this.path.lineTo(f, f2);
        this.tempX = f;
        this.tempY = f2;
    }

    public CanvasAction(android.graphics.Paint paint, android.graphics.Path path) {
        this.paint = paint;
        this.path = path;
    }

    public android.graphics.Paint getPaint() {
        return this.paint;
    }

    public android.graphics.Path getPath() {
        return this.path;
    }

    public void move(float f, float f2, android.graphics.Canvas canvas) {
        float abs = java.lang.Math.abs(f - this.tempX);
        float abs2 = java.lang.Math.abs(this.tempY - f2);
        if (abs >= 4.0f || abs2 >= 4.0f) {
            android.graphics.Path path = this.path;
            float f3 = this.tempX;
            float f4 = this.tempY;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.tempX = f;
            this.tempY = f2;
        }
        canvas.drawPath(this.path, this.paint);
    }

    public void point(float f, float f2, android.graphics.Canvas canvas) {
        canvas.drawPoint(f, f2, this.paint);
    }

    public void setPaint(android.graphics.Paint paint) {
        this.paint = paint;
    }

    public void setPath(android.graphics.Path path) {
        this.path = path;
    }
}
