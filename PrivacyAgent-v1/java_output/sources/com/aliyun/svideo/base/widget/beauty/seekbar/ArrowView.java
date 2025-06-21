package com.aliyun.svideo.base.widget.beauty.seekbar;

/* loaded from: classes.dex */
public class ArrowView extends android.view.View {
    private final int mHeight;
    private final android.graphics.Paint mPaint;
    private final android.graphics.Path mPath;
    private final int mWidth;

    public ArrowView(android.content.Context context) {
        this(context, null);
    }

    public ArrowView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int dp2px = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(context, 12.0f);
        this.mWidth = dp2px;
        int dp2px2 = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(context, 7.0f);
        this.mHeight = dp2px2;
        android.graphics.Path path = new android.graphics.Path();
        this.mPath = path;
        path.moveTo(0.0f, 0.0f);
        path.lineTo(dp2px, 0.0f);
        path.lineTo(dp2px / 2.0f, dp2px2);
        path.close();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void setColor(int i) {
        this.mPaint.setColor(i);
        invalidate();
    }
}
