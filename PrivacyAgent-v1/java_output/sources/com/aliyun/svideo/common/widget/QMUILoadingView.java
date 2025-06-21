package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class QMUILoadingView extends android.view.View {
    private static final int DEGREE_PER_LINE = 30;
    private static final int LINE_COUNT = 12;
    private int mAnimateValue;
    private android.animation.ValueAnimator mAnimator;
    private android.graphics.Paint mPaint;
    private int mPaintColor;
    private int mSize;
    private android.animation.ValueAnimator.AnimatorUpdateListener mUpdateListener;

    /* renamed from: com.aliyun.svideo.common.widget.QMUILoadingView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.aliyun.svideo.common.widget.QMUILoadingView.this.mAnimateValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            com.aliyun.svideo.common.widget.QMUILoadingView.this.invalidate();
        }
    }

    public QMUILoadingView(android.content.Context context) {
        this(context, null);
    }

    public QMUILoadingView(android.content.Context context, int i, int i2) {
        super(context);
        this.mAnimateValue = 0;
        this.mUpdateListener = new com.aliyun.svideo.common.widget.QMUILoadingView.AnonymousClass1();
        this.mSize = i;
        this.mPaintColor = i2;
        initPaint();
    }

    public QMUILoadingView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.aliyun.svideo.common.R.attr.LoadingStyle);
    }

    public QMUILoadingView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAnimateValue = 0;
        this.mUpdateListener = new com.aliyun.svideo.common.widget.QMUILoadingView.AnonymousClass1();
        android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.aliyun.svideo.common.R.styleable.LoadingView, i, 0);
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.common.R.styleable.LoadingView_loading_view_size, com.aliyun.svideo.common.utils.DensityUtils.dip2px(context, 32.0f));
        this.mPaintColor = obtainStyledAttributes.getInt(com.aliyun.svideo.common.R.styleable.LoadingView_android_color, -1);
        obtainStyledAttributes.recycle();
        initPaint();
    }

    private void drawLoading(android.graphics.Canvas canvas, int i) {
        int i2 = this.mSize;
        int i3 = i2 / 12;
        int i4 = i2 / 6;
        this.mPaint.setStrokeWidth(i3);
        int i5 = this.mSize;
        canvas.rotate(i, i5 / 2, i5 / 2);
        int i6 = this.mSize;
        canvas.translate(i6 / 2, i6 / 2);
        int i7 = 0;
        while (i7 < 12) {
            canvas.rotate(30.0f);
            i7++;
            this.mPaint.setAlpha((int) ((i7 * 255.0f) / 12.0f));
            int i8 = i3 / 2;
            canvas.translate(0.0f, ((-this.mSize) / 2) + i8);
            canvas.drawLine(0.0f, 0.0f, 0.0f, i4, this.mPaint);
            canvas.translate(0.0f, (this.mSize / 2) - i8);
        }
    }

    private void initPaint() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setColor(this.mPaintColor);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        drawLoading(canvas, this.mAnimateValue * 30);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.mSize;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    public void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            start();
        } else {
            stop();
        }
    }

    public void setColor(int i) {
        this.mPaintColor = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setSize(int i) {
        this.mSize = i;
        requestLayout();
    }

    public void start() {
        android.animation.ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            if (valueAnimator.isStarted()) {
                return;
            }
            this.mAnimator.start();
            return;
        }
        android.animation.ValueAnimator ofInt = android.animation.ValueAnimator.ofInt(0, 11);
        this.mAnimator = ofInt;
        ofInt.addUpdateListener(this.mUpdateListener);
        this.mAnimator.setDuration(600L);
        this.mAnimator.setRepeatMode(1);
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.setInterpolator(new android.view.animation.LinearInterpolator());
        this.mAnimator.start();
    }

    public void stop() {
        android.animation.ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.mUpdateListener);
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
    }
}
