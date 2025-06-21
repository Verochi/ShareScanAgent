package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class FanProgressBar extends android.view.View {
    private static final float DEFAULT_INTERNAL_ALPHA = 1.0f;
    private static final int DEFAULT_INTERNAL_RADIUS = 10;
    private static final float DEFAULT_MAX_PROGRESS = 100.0f;
    private static final float DEFAULT_OUT_ALPHA = 1.0f;
    private static final int DEFAULT_OUT_RADIUS = 10;
    private static final float DEFAULT_START_ANGLE = -90.0f;
    private static final int DIRECTION_CLOCKWISE = 1;
    private static final int DIRECTION_COUNTERCLOCKWISE = -1;
    private static final int EMPTY_INIT = 0;
    private static final int FILL_INIT = 1;
    private static final int MATCH_PARENT = -1;
    private float mCenterX;
    private float mCenterY;
    private int mInitStyle;
    private int mInternalAlpha;
    private int mInternalBackgroundColor;
    private int mInternalDirection;
    private android.graphics.Paint mInternalPaint;
    private int mInternalRadius;
    private float mMaxProgress;
    private int mOutAlpha;
    private int mOutBackgroundColor;
    private int mOutDirection;
    private android.graphics.Paint mOutPaint;
    private int mOutRadius;
    private float mProgress;
    private float mStartAngle;
    private int offsetX;
    private int offsetY;

    public FanProgressBar(android.content.Context context) {
        super(context);
        this.mMaxProgress = 100.0f;
        this.mInternalRadius = 10;
        this.mOutRadius = 10;
        this.mInternalBackgroundColor = -1;
        this.mOutBackgroundColor = -1;
        this.mStartAngle = DEFAULT_START_ANGLE;
        this.mInternalAlpha = 255;
        this.mOutAlpha = 255;
        this.mCenterX = 10;
        this.mCenterY = 10;
        this.mOutDirection = 1;
        this.mInternalDirection = 1;
        initPaint();
    }

    public FanProgressBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxProgress = 100.0f;
        this.mInternalRadius = 10;
        this.mOutRadius = 10;
        this.mInternalBackgroundColor = -1;
        this.mOutBackgroundColor = -1;
        this.mStartAngle = DEFAULT_START_ANGLE;
        this.mInternalAlpha = 255;
        this.mOutAlpha = 255;
        this.mCenterX = 10;
        this.mCenterY = 10;
        this.mOutDirection = 1;
        this.mInternalDirection = 1;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar);
        try {
            this.mMaxProgress = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_circleMaxProgress, 100.0f);
            this.mProgress = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_circleProgress, 0.0f);
            this.mInternalRadius = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_internalRadius, 10);
            this.mOutRadius = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_outRadius, 10);
            this.mInternalBackgroundColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_internalBackgroundColor, -1);
            this.mOutBackgroundColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_outBackgroundColor, -1);
            this.mStartAngle = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_startAngle, DEFAULT_START_ANGLE);
            this.mInternalAlpha = (int) (obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_internalAlpha, 1.0f) * 255.0f);
            this.mOutAlpha = (int) (obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_outAlpha, 1.0f) * 255.0f);
            this.mCenterX = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_centerX, 2.1474836E9f);
            this.mCenterY = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_centerY, 2.1474836E9f);
            this.mOutDirection = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_outDirection, 1);
            this.mInternalDirection = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_internalDirection, 1);
            this.mInitStyle = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_initStyle, 0);
            obtainStyledAttributes.recycle();
            initPaint();
        } catch (java.lang.Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public FanProgressBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxProgress = 100.0f;
        this.mInternalRadius = 10;
        this.mOutRadius = 10;
        this.mInternalBackgroundColor = -1;
        this.mOutBackgroundColor = -1;
        this.mStartAngle = DEFAULT_START_ANGLE;
        this.mInternalAlpha = 255;
        this.mOutAlpha = 255;
        this.mCenterX = 10;
        this.mCenterY = 10;
        this.mOutDirection = 1;
        this.mInternalDirection = 1;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar);
        try {
            this.mMaxProgress = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_circleMaxProgress, 100.0f);
            this.mProgress = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_circleProgress, 0.0f);
            this.mInternalRadius = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_internalRadius, 10);
            this.mOutRadius = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_outRadius, 10);
            this.mInternalBackgroundColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_internalBackgroundColor, -1);
            this.mOutBackgroundColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_outBackgroundColor, -1);
            this.mStartAngle = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_startAngle, DEFAULT_START_ANGLE);
            this.mInternalAlpha = (int) (obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_internalAlpha, 1.0f) * 255.0f);
            this.mOutAlpha = (int) (obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_outAlpha, 1.0f) * 255.0f);
            this.mCenterX = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_centerX, 2.1474836E9f);
            this.mCenterY = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_centerY, 2.1474836E9f);
            this.mOutDirection = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_outDirection, 1);
            this.mInternalDirection = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.QuViewFanProgressBar_internalDirection, 1);
            obtainStyledAttributes.recycle();
            initPaint();
        } catch (java.lang.Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void initPaint() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mInternalPaint = paint;
        paint.setAlpha(this.mInternalAlpha);
        this.mInternalPaint.setColor(this.mInternalBackgroundColor);
        this.mInternalPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mInternalPaint.setAntiAlias(true);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.mOutPaint = paint2;
        paint2.setColor(this.mOutBackgroundColor);
        this.mOutPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mOutPaint.setAntiAlias(true);
        this.mOutPaint.setAlpha(this.mOutAlpha);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        float f = this.mInitStyle == 0 ? this.mProgress : this.mMaxProgress - this.mProgress;
        float f2 = this.mMaxProgress;
        if (f == f2) {
            int i = this.mOutRadius;
            if (i > 0) {
                canvas.drawCircle(this.mCenterX, this.mCenterY, i, this.mOutPaint);
            }
            int i2 = this.mInternalRadius;
            if (i2 > 0) {
                canvas.drawCircle(this.mCenterX, this.mCenterY, i2, this.mInternalPaint);
                return;
            }
            return;
        }
        if (f == 0.0f) {
            canvas.drawColor(0);
            return;
        }
        float f3 = -((f * 360.0f) / f2);
        if (f3 != 0.0f) {
            float f4 = this.mOutDirection == 1 ? f3 : -f3;
            if (this.mOutRadius > 0) {
                android.graphics.RectF rectF = new android.graphics.RectF();
                float f5 = this.mCenterX;
                int i3 = this.offsetX;
                int i4 = this.mOutRadius;
                rectF.left = (i3 + f5) - i4;
                rectF.right = f5 + i3 + i4;
                float f6 = this.mCenterY;
                int i5 = this.offsetY;
                rectF.top = (i5 + f6) - i4;
                rectF.bottom = f6 + i5 + i4;
                canvas.drawArc(rectF, this.mStartAngle, f4, false, this.mOutPaint);
            }
            if (this.mInternalDirection != 1) {
                f3 = -f3;
            }
            float f7 = f3;
            if (this.mInternalRadius > 0) {
                android.graphics.RectF rectF2 = new android.graphics.RectF();
                float f8 = this.mCenterX;
                int i6 = this.mInternalRadius;
                rectF2.left = f8 - i6;
                rectF2.right = f8 + i6;
                float f9 = this.mCenterY;
                rectF2.top = f9 - i6;
                rectF2.bottom = f9 + i6;
                canvas.drawArc(rectF2, this.mStartAngle, f7, true, this.mInternalPaint);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mInternalRadius == -1) {
            this.mInternalRadius = getMeasuredWidth() / 2;
        }
        if (this.mOutRadius == -1) {
            this.mOutRadius = getMeasuredWidth() / 2;
        }
        if (this.mCenterX == 2.1474836E9f) {
            this.mCenterX = this.mOutRadius;
        }
        if (this.mCenterY == 2.1474836E9f) {
            this.mCenterY = this.mOutRadius;
        }
    }

    public void setInternalAlpha(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        int i = (int) (f * 255.0f);
        if (this.mInternalAlpha != i) {
            this.mInternalAlpha = i;
            invalidate();
        }
    }

    public void setInternalRadius(int i) {
        if (this.mInternalRadius != i) {
            this.mInternalRadius = i;
            invalidate();
        }
    }

    public void setOffset(int i, int i2) {
        this.offsetX = i;
        this.offsetY = i2;
    }

    public void setOutAlpha(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        int i = (int) (f * 255.0f);
        if (i != this.mOutAlpha) {
            this.mOutAlpha = i;
            invalidate();
        }
    }

    public void setOutRadius(int i) {
        if (this.mOutRadius != i) {
            this.mOutRadius = i;
            invalidate();
        }
    }

    public void setOutStrokeWidth(int i) {
        android.graphics.Paint paint = this.mOutPaint;
        if (paint != null) {
            paint.setStrokeWidth(i);
        }
    }

    public void setProgress(float f) {
        if (this.mProgress != f) {
            this.mProgress = f;
            float f2 = this.mMaxProgress;
            if (f > f2) {
                this.mProgress = f2;
            } else if (f == 0.0f) {
                this.mProgress = 0.0f;
            }
            invalidate();
        }
    }
}
