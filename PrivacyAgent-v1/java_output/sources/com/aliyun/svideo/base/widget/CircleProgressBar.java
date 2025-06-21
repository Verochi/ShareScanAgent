package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class CircleProgressBar extends android.view.View {
    private boolean hasBgColor;
    private boolean isFilled;
    private int mBackgroundColor;
    private float mBackgroundHeight;
    private float mBackgroundWidth;
    private android.graphics.Paint mBgPaint;
    private android.graphics.Paint mFillPaint;
    private android.graphics.RectF mOval;
    private android.graphics.Paint mPaint;
    private int mProgress;
    private int mProgressColor;
    private float mProgressThickness;
    private float mProgressWidth;
    private int mStrokeWidth;
    private int progressThicknessColor;

    public CircleProgressBar(android.content.Context context) {
        this(context, null);
    }

    public CircleProgressBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.base.R.styleable.QuViewCircleProgressBar);
        this.mBackgroundWidth = obtainStyledAttributes.getDimension(com.aliyun.svideo.base.R.styleable.QuViewCircleProgressBar_backgroundWidth, this.mBackgroundWidth);
        this.mBackgroundHeight = obtainStyledAttributes.getDimension(com.aliyun.svideo.base.R.styleable.QuViewCircleProgressBar_backgroundHeight, this.mBackgroundHeight);
        this.mProgressWidth = obtainStyledAttributes.getDimension(com.aliyun.svideo.base.R.styleable.QuViewCircleProgressBar_progressWidth, this.mProgressWidth);
        this.mProgressThickness = obtainStyledAttributes.getDimension(com.aliyun.svideo.base.R.styleable.QuViewCircleProgressBar_progressThickness, this.mProgressThickness);
        this.mBackgroundColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.QuViewCircleProgressBar_backgroundColor, this.mBackgroundColor);
        this.mProgressColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.QuViewCircleProgressBar_progressColor, this.mProgressColor);
        this.progressThicknessColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.QuViewCircleProgressBar_progressThicknessColor, this.progressThicknessColor);
        obtainStyledAttributes.recycle();
        instantiate();
    }

    private void instantiate() {
        this.mProgress = 0;
        this.mStrokeWidth = (int) this.mProgressThickness;
        float f = this.mBackgroundWidth;
        float f2 = this.mProgressWidth;
        float f3 = (f - f2) / 2.0f;
        float f4 = (this.mBackgroundHeight - f2) / 2.0f;
        this.mOval = new android.graphics.RectF(f3, f4, f3 + f2, f2 + f4);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.mBgPaint = paint2;
        paint2.setAntiAlias(true);
        this.mBgPaint.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint3 = new android.graphics.Paint();
        this.mFillPaint = paint3;
        paint3.setAntiAlias(true);
        this.mFillPaint.setStyle(android.graphics.Paint.Style.FILL);
    }

    public void isFilled(boolean z) {
        this.isFilled = z;
    }

    public void isProgressBackGround(boolean z) {
        this.hasBgColor = z;
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int i = this.progressThicknessColor;
        if (i == 0) {
            this.mPaint.setColor(getResources().getColor(android.R.color.transparent));
            this.mFillPaint.setColor(getResources().getColor(android.R.color.transparent));
        } else {
            this.mPaint.setColor(i);
            this.mFillPaint.setColor(this.progressThicknessColor);
        }
        if (this.isFilled) {
            canvas.drawArc(this.mOval, 270.0f, 360.0f, true, this.mFillPaint);
        } else {
            canvas.drawArc(this.mOval, 270.0f, 360.0f, false, this.mPaint);
        }
        if (this.hasBgColor) {
            int i2 = this.mBackgroundColor;
            if (i2 == 0) {
                this.mBgPaint.setColor(getResources().getColor(android.R.color.transparent));
            } else {
                this.mBgPaint.setColor(i2);
            }
            float f = this.mBackgroundWidth;
            canvas.drawCircle(f / 2.0f, f / 2.0f, this.mProgressWidth / 2.0f, this.mBgPaint);
        }
        if (this.mProgress > 0) {
            this.mPaint.setAlpha(0);
            int i3 = this.mProgressColor;
            if (i3 == 0) {
                this.mPaint.setColor(getResources().getColor(android.R.color.white));
                this.mFillPaint.setColor(getResources().getColor(android.R.color.white));
            } else {
                this.mPaint.setColor(i3);
                this.mFillPaint.setColor(this.mProgressColor);
            }
            if (this.isFilled) {
                canvas.drawArc(this.mOval, 270.0f, (this.mProgress * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) / 100, true, this.mFillPaint);
            } else {
                canvas.drawArc(this.mOval, 270.0f, (this.mProgress * com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) / 100, false, this.mPaint);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setBackgroundWidth(int i, int i2) {
        this.mBackgroundWidth = i;
        this.mBackgroundHeight = i2;
        instantiate();
    }

    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }

    public void setProgressThickness(int i) {
        this.mProgressThickness = i;
        instantiate();
    }

    public void setProgressThicknessColor(int i) {
        this.progressThicknessColor = i;
    }

    public void setProgressWidth(int i) {
        this.mProgressWidth = i;
        instantiate();
    }
}
