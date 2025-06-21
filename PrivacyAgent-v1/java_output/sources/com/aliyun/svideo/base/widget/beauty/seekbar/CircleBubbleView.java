package com.aliyun.svideo.base.widget.beauty.seekbar;

/* loaded from: classes.dex */
class CircleBubbleView extends android.view.View {
    private android.content.Context mContext;
    private int mIndicatorColor;
    private float mIndicatorHeight;
    private int mIndicatorTextColor;
    private int mIndicatorTextSize;
    private float mIndicatorWidth;
    private android.graphics.Paint mPaint;
    private android.graphics.Path mPath;
    private java.lang.String mProgress;
    private float mTextHeight;

    public CircleBubbleView(android.content.Context context) {
        this(context, (android.util.AttributeSet) null);
    }

    public CircleBubbleView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleBubbleView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init("100");
    }

    public CircleBubbleView(com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams, java.lang.String str) {
        super(builderParams.mContext, null, 0);
        this.mContext = builderParams.mContext;
        this.mIndicatorTextSize = builderParams.mIndicatorTextSize;
        this.mIndicatorTextColor = builderParams.mIndicatorTextColor;
        this.mIndicatorColor = builderParams.mIndicatorColor;
        init(str);
    }

    private void init(java.lang.String str) {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.mPaint.setTextSize(this.mIndicatorTextSize);
        this.mPaint.getTextBounds(str, 0, str.length(), new android.graphics.Rect());
        this.mIndicatorWidth = r0.width() + com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 4.0f);
        float dp2px = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 36.0f);
        if (this.mIndicatorWidth < dp2px) {
            this.mIndicatorWidth = dp2px;
        }
        this.mTextHeight = r0.height();
        this.mIndicatorHeight = this.mIndicatorWidth * 1.2f;
        initPath();
    }

    private void initPath() {
        this.mPath = new android.graphics.Path();
        float f = this.mIndicatorWidth;
        this.mPath.arcTo(new android.graphics.RectF(0.0f, 0.0f, f, f), 135.0f, 270.0f);
        this.mPath.lineTo(this.mIndicatorWidth / 2.0f, this.mIndicatorHeight);
        this.mPath.close();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorColor);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPaint.setColor(this.mIndicatorTextColor);
        canvas.drawText(this.mProgress, this.mIndicatorWidth / 2.0f, (this.mIndicatorHeight / 2.0f) + (this.mTextHeight / 4.0f), this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.mIndicatorWidth, (int) this.mIndicatorHeight);
    }

    public void setProgress(java.lang.String str) {
        this.mProgress = str;
        invalidate();
    }
}
