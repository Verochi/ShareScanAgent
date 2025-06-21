package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class CircularColorView extends android.view.View {
    private int color;
    private android.graphics.Paint mPaint;
    private int strokeColor;

    public CircularColorView(android.content.Context context) {
        this(context, null);
    }

    public CircularColorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularColorView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void drawBlackStroke(android.graphics.Canvas canvas) {
        float applyDimension = android.util.TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics());
        this.mPaint.setStrokeWidth(applyDimension);
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        this.mPaint.setColor(android.graphics.Color.parseColor("#33ffffff"));
        canvas.drawOval(new android.graphics.RectF(getLeft() + applyDimension, getTop() + applyDimension, getRight() - applyDimension, getBottom() - applyDimension), this.mPaint);
    }

    private void drawCircleStroke(android.graphics.Canvas canvas) {
        float applyDimension = android.util.TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.mPaint.setStrokeWidth(applyDimension);
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        this.mPaint.setColor(this.strokeColor);
        float applyDimension2 = applyDimension - android.util.TypedValue.applyDimension(1, 1.6f, getResources().getDisplayMetrics());
        canvas.drawOval(new android.graphics.RectF(getLeft() + applyDimension2, getTop() + applyDimension2, getRight() - applyDimension2, getBottom() - applyDimension2), this.mPaint);
    }

    private void drawWhiteStroke(android.graphics.Canvas canvas) {
        float applyDimension = android.util.TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics());
        this.mPaint.setStrokeWidth(applyDimension);
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.mPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        this.mPaint.setColor(-1);
        canvas.drawOval(new android.graphics.RectF(getLeft() + applyDimension, getTop() + applyDimension, getRight() - applyDimension, getBottom() - applyDimension), this.mPaint);
    }

    private void init() {
        this.mPaint = new android.graphics.Paint(1);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("left : ");
        sb.append(getLeft());
        sb.append(" right : ");
        sb.append(getRight());
        sb.append(" top : ");
        sb.append(getTop());
        sb.append(" bottom : ");
        sb.append(getBottom());
        canvas.drawOval(new android.graphics.RectF(getLeft(), getTop(), getRight(), getBottom()), this.mPaint);
        int i = this.strokeColor;
        if (i != 0) {
            if (i == -16777216) {
                drawWhiteStroke(canvas);
                return;
            } else {
                drawCircleStroke(canvas);
                return;
            }
        }
        int i2 = this.color;
        if (i2 == -16777216) {
            drawWhiteStroke(canvas);
        } else if (i2 == android.graphics.Color.parseColor("#121212")) {
            drawBlackStroke(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    public void setCircularColor(int i) {
        this.color = i;
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
    }

    public void setStrokeColorResources(int i) {
        setStrokeColor(getResources().getColor(i));
    }
}
