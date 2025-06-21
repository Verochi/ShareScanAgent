package com.aliyun.svideo.base.widget.beauty.seekbar;

/* loaded from: classes.dex */
public class IndicatorSeekBar extends android.view.View implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener {
    private static final int CUSTOM_DRAWABLE_MAX_LIMITED_WIDTH = 30;
    private static final int GAP_BETWEEN_SEEK_BAR_AND_BELOW_TEXT = 3;
    private static final java.lang.String INSTANCE_STATE_KEY = "isb_instance_state";
    private float lastProgress;
    private com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder mBuilder;
    private android.content.Context mContext;
    private android.graphics.Rect mCoverRect;
    private float mCustomDrawableMaxHeight;
    private boolean mDrawAgain;
    private float mFaultTolerance;
    private com.aliyun.svideo.base.widget.beauty.seekbar.Indicator mIndicator;
    private boolean mIsTouching;
    private com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener mListener;
    private int[] mLocation;
    private int mMeasuredWidth;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams mRawParams;
    private android.graphics.Rect mRect;
    private float mScreenWidth;
    private float mSeekBlockLength;
    private float mSeekEnd;
    private float mSeekLength;
    private float mSeekStart;
    private android.graphics.Paint mStockPaint;
    private int mTextHeight;
    private java.util.ArrayList<java.lang.String> mTextList;
    private java.util.List<java.lang.Float> mTextLocationList;
    private android.text.TextPaint mTextPaint;
    private android.graphics.Bitmap mThumbDraw;
    private float mThumbRadius;
    private float mThumbTouchHeight;
    private float mThumbTouchRadius;
    private android.graphics.Bitmap mTickDraw;
    private float mTickRadius;
    private float mTouchX;
    private float mTrackY;
    private com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams p;

    /* renamed from: com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.this.requestLayout();
        }
    }

    public static class Builder {
        com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar;
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams p;

        public Builder(android.content.Context context) {
            this.p = new com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams(context);
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar apply() {
            this.indicatorSeekBar.apply(this.p);
            return this.indicatorSeekBar;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar build() {
            return new com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar(this);
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder clearPadding(boolean z) {
            this.p.mClearPadding = z;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder forbidUserToSeek(boolean z) {
            this.p.mForbidUserSeek = z;
            return this;
        }

        public android.content.Context getContext() {
            return this.p.mContext;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder hideBothEndsTicks(boolean z) {
            this.p.mTickHideBothEnds = z;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder hideTickOnThumbLeft(boolean z) {
            this.p.mTickOnThumbLeftHide = z;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder isFloatProgress(boolean z) {
            this.p.mIsFloatProgress = z;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder isRoundedTrackCorner(boolean z) {
            this.p.mTrackRoundedCorners = z;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setBackgroundTrackColor(@androidx.annotation.ColorInt int i) {
            this.p.mBackgroundTrackColor = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setBackgroundTrackSize(int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mBackgroundTrackSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(builderParams.mContext, i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorColor(@androidx.annotation.ColorInt int i) {
            this.p.mIndicatorColor = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorCustomLayout(@androidx.annotation.LayoutRes int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mIndicatorType = 3;
            builderParams.mIndicatorCustomView = android.view.View.inflate(builderParams.mContext, i, null);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorCustomTopContentLayout(@androidx.annotation.LayoutRes int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mIndicatorCustomTopContentView = android.view.View.inflate(builderParams.mContext, i, null);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorCustomTopContentView(@androidx.annotation.NonNull android.view.View view) {
            this.p.mIndicatorCustomTopContentView = view;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorCustomView(@androidx.annotation.NonNull android.view.View view) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mIndicatorType = 3;
            builderParams.mIndicatorCustomView = view;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorStay(boolean z) {
            this.p.mIndicatorStay = z;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorTextColor(@androidx.annotation.ColorInt int i) {
            this.p.mIndicatorTextColor = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorTextSize(int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mIndicatorTextSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.sp2px(builderParams.mContext, i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setIndicatorType(int i) {
            this.p.mIndicatorType = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setLeftEndText(java.lang.String str) {
            this.p.mLeftEndText = str;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setMax(float f) {
            this.p.mMax = f;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setMin(float f) {
            this.p.mMin = f;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setParams(com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams) {
            this.p = builderParams;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setProgress(float f) {
            this.p.mProgress = f;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setProgressTrackColor(@androidx.annotation.ColorInt int i) {
            this.p.mProgressTrackColor = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setProgressTrackSize(int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mProgressTrackSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(builderParams.mContext, i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setRightEndText(java.lang.String str) {
            this.p.mRightEndText = str;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setSeekBar(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar) {
            this.indicatorSeekBar = indicatorSeekBar;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setSeekBarType(int i) {
            this.p.mSeekBarType = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTextArray(@androidx.annotation.ArrayRes int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mTextArray = builderParams.mContext.getResources().getStringArray(i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTextArray(java.lang.CharSequence[] charSequenceArr) {
            this.p.mTextArray = charSequenceArr;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTextColor(@androidx.annotation.ColorInt int i) {
            this.p.mTextColor = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTextSize(int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mTextSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.sp2px(builderParams.mContext, i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTextTypeface(android.graphics.Typeface typeface) {
            this.p.mTextTypeface = typeface;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setThumbColor(@androidx.annotation.ColorInt int i) {
            this.p.mThumbColor = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setThumbDrawable(@androidx.annotation.DrawableRes int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mThumbDrawable = builderParams.mContext.getResources().getDrawable(i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setThumbDrawable(android.graphics.drawable.Drawable drawable) {
            this.p.mThumbDrawable = drawable;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setThumbWidth(int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mThumbSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(builderParams.mContext, i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTickColor(@androidx.annotation.ColorInt int i) {
            this.p.mTickColor = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTickDrawable(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            this.p.mTickDrawable = drawable;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTickDrawableId(@androidx.annotation.DrawableRes int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mTickDrawable = builderParams.mContext.getResources().getDrawable(i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTickNum(int i) {
            this.p.mTickNum = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTickSize(int i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            builderParams.mTickSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(builderParams.mContext, i);
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder setTickType(int i) {
            this.p.mTickType = i;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder showIndicator(boolean z) {
            this.p.mShowIndicator = z;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder thumbProgressStay(boolean z) {
            this.p.mThumbProgressStay = z;
            return this;
        }

        public com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder touchToSeek(boolean z) {
            this.p.mTouchToSeek = z;
            return this;
        }
    }

    public interface OnSeekBarChangeListener {
        void onProgressChanged(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar, int i, float f, boolean z);

        void onSectionChanged(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar, int i, java.lang.String str, boolean z);

        void onStartTrackingTouch(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar, int i);

        void onStopTrackingTouch(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar);
    }

    public IndicatorSeekBar(android.content.Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorSeekBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFaultTolerance = -1.0f;
        this.mScreenWidth = -1.0f;
        this.mContext = context;
        initAttrs(context, attributeSet);
        this.mRawParams = new com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams(this.mContext).copy(this.p);
        initData();
    }

    public IndicatorSeekBar(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder builder) {
        super(builder.getContext(), null, 0);
        this.mFaultTolerance = -1.0f;
        this.mScreenWidth = -1.0f;
        android.content.Context context = builder.getContext();
        this.mContext = context;
        this.mBuilder = builder;
        this.p = builder.p;
        this.mRawParams = new com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams(context).copy(this.p);
        initData();
    }

    private float adjustTouchX(android.view.MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int i = this.mPaddingLeft;
        if (x >= i) {
            float x2 = motionEvent.getX();
            int i2 = this.mMeasuredWidth;
            int i3 = this.mPaddingRight;
            if (x2 <= i2 - i3) {
                return motionEvent.getX();
            }
            i = i2 - i3;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apply(com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams) {
        if (builderParams == null) {
            throw new java.lang.NullPointerException(" BuilderParams can not be a null value. ");
        }
        this.mRawParams.copy(builderParams);
        this.p.copy(builderParams);
        initData();
        initSeekBarInfo();
        setProgress(builderParams.mProgress);
        requestLayout();
        com.aliyun.svideo.base.widget.beauty.seekbar.Indicator indicator = this.mIndicator;
        if (indicator != null) {
            if (indicator.isShowing()) {
                this.mIndicator.forceHide();
            }
            this.mIndicator.initIndicator();
            if (builderParams.mIndicatorStay) {
                if (this.mIndicator.isShowing()) {
                    this.mIndicator.update();
                } else {
                    this.mIndicator.show();
                }
            }
        }
    }

    private void calculateProgress() {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        this.lastProgress = builderParams.mProgress;
        float f = builderParams.mMin;
        builderParams.mProgress = f + (((builderParams.mMax - f) * (this.mTouchX - this.mPaddingLeft)) / this.mSeekLength);
    }

    private void calculateProgressTouchX() {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        float f = builderParams.mProgress;
        float f2 = builderParams.mMin;
        calculateTouchX((((f - f2) * this.mSeekLength) / (builderParams.mMax - f2)) + this.mPaddingLeft);
    }

    private void calculateTouchX(float f) {
        this.mTouchX = (this.mSeekBlockLength * java.lang.Math.round((f - this.mPaddingLeft) / this.mSeekBlockLength)) + this.mPaddingLeft;
    }

    private void checkIndicatorLoc() {
        com.aliyun.svideo.base.widget.beauty.seekbar.Indicator indicator = this.mIndicator;
        if (indicator != null) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            if (builderParams.mShowIndicator) {
                if (!builderParams.mIndicatorStay) {
                    indicator.forceHide();
                } else if (indicator.isShowing()) {
                    this.mIndicator.update();
                } else {
                    this.mIndicator.show();
                }
            }
        }
    }

    private void drawText(android.graphics.Canvas canvas) {
        int i = this.p.mSeekBarType;
        if (i == 0 || i == 2 || this.mTextList.size() == 0) {
            return;
        }
        this.mStockPaint.setColor(this.p.mTickColor);
        java.lang.String allText = getAllText();
        this.mTextPaint.getTextBounds(allText, 0, allText.length(), this.mRect);
        int round = java.lang.Math.round(this.mRect.height() - this.mTextPaint.descent());
        int dp2px = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 3.0f);
        for (int i2 = 0; i2 < this.mTextList.size(); i2++) {
            java.lang.String stringText = getStringText(i2);
            this.mTextPaint.getTextBounds(stringText, 0, stringText.length(), this.mRect);
            if (i2 == 0) {
                canvas.drawText(stringText, this.mTextLocationList.get(i2).floatValue() + (this.mRect.width() / 2.0f), this.mPaddingTop + this.mCustomDrawableMaxHeight + round + dp2px, this.mTextPaint);
            } else if (i2 == this.mTextList.size() - 1) {
                canvas.drawText(stringText, this.mTextLocationList.get(i2).floatValue() - (this.mRect.width() / 2.0f), this.mPaddingTop + this.mCustomDrawableMaxHeight + round + dp2px, this.mTextPaint);
            } else {
                int i3 = this.p.mSeekBarType;
                if (i3 != 1 && i3 != 4) {
                    canvas.drawText(stringText, this.mTextLocationList.get(i2).floatValue(), this.mPaddingTop + this.mCustomDrawableMaxHeight + round + dp2px, this.mTextPaint);
                }
            }
        }
    }

    private void drawThumb(android.graphics.Canvas canvas, float f) {
        this.mStockPaint.setColor(this.p.mThumbColor);
        android.graphics.drawable.Drawable drawable = this.p.mThumbDrawable;
        if (drawable == null) {
            canvas.drawCircle(f + (r0.mBackgroundTrackSize / 2.0f), this.mTrackY, this.mIsTouching ? this.mThumbTouchRadius : this.mThumbRadius, this.mStockPaint);
            return;
        }
        if (this.mThumbDraw == null) {
            this.mThumbDraw = getBitmapDraw(drawable, true);
        }
        canvas.drawBitmap(this.mThumbDraw, f - (r0.getWidth() / 2.0f), this.mTrackY - (this.mThumbDraw.getHeight() / 2.0f), this.mStockPaint);
    }

    private void drawThumbText(android.graphics.Canvas canvas, float f) {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        int i = builderParams.mSeekBarType;
        if ((i == 0 || i == 2) && builderParams.mThumbProgressStay) {
            canvas.drawText(getProgressString(builderParams.mProgress), f + (this.p.mBackgroundTrackSize / 2.0f), this.mPaddingTop + this.mThumbTouchHeight + this.mRect.height() + com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 2.0f), this.mTextPaint);
        }
    }

    private void drawTicks(android.graphics.Canvas canvas, float f) {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        int i = builderParams.mSeekBarType;
        if (i == 0 || i == 1 || builderParams.mTickType == 0 || this.mTextLocationList.size() == 0) {
            return;
        }
        this.mStockPaint.setColor(this.p.mTickColor);
        for (int i2 = 0; i2 < this.mTextLocationList.size(); i2++) {
            float floatValue = this.mTextLocationList.get(i2).floatValue();
            if (getThumbPosOnTick() != i2) {
                com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams2 = this.p;
                if ((!builderParams2.mTickOnThumbLeftHide || f < floatValue) && (!builderParams2.mTickHideBothEnds || (i2 != 0 && i2 != this.mTextLocationList.size() - 1))) {
                    int dp2px = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 1.0f);
                    com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams3 = this.p;
                    android.graphics.drawable.Drawable drawable = builderParams3.mTickDrawable;
                    if (drawable != null) {
                        if (this.mTickDraw == null) {
                            this.mTickDraw = getBitmapDraw(drawable, false);
                        }
                        if (this.p.mTickType == 1) {
                            canvas.drawBitmap(this.mTickDraw, (floatValue - (r2.getWidth() / 2.0f)) + dp2px, this.mTrackY - (this.mTickDraw.getHeight() / 2.0f), this.mStockPaint);
                        } else {
                            canvas.drawBitmap(this.mTickDraw, floatValue - (r1.getWidth() / 2.0f), this.mTrackY - (this.mTickDraw.getHeight() / 2.0f), this.mStockPaint);
                        }
                    } else {
                        int i3 = builderParams3.mTickType;
                        if (i3 == 2) {
                            canvas.drawCircle(floatValue, this.mTrackY, this.mTickRadius, this.mStockPaint);
                        } else if (i3 == 1) {
                            int i4 = f >= floatValue ? builderParams3.mProgressTrackSize : builderParams3.mBackgroundTrackSize;
                            float f2 = dp2px;
                            float f3 = this.mTrackY;
                            float f4 = i4 / 2.0f;
                            canvas.drawRect(floatValue - f2, (f3 - f4) - 0.5f, floatValue + f2, f3 + f4 + 0.5f, this.mStockPaint);
                        }
                    }
                }
            }
        }
    }

    @androidx.annotation.NonNull
    private java.lang.String getAllText() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("j");
        java.lang.CharSequence[] charSequenceArr = this.p.mTextArray;
        if (charSequenceArr != null) {
            for (java.lang.CharSequence charSequence : charSequenceArr) {
                sb.append(charSequence);
            }
        }
        return sb.toString();
    }

    private android.graphics.Bitmap getBitmapDraw(android.graphics.drawable.Drawable drawable, boolean z) {
        int intrinsicHeight;
        if (drawable == null) {
            return null;
        }
        int dp2px = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 30.0f);
        if (drawable.getIntrinsicWidth() > dp2px) {
            int i = z ? this.p.mThumbSize : this.p.mTickSize;
            intrinsicHeight = getHeightByRatio(drawable, i);
            if (i > dp2px) {
                intrinsicHeight = getHeightByRatio(drawable, dp2px);
            } else {
                dp2px = i;
            }
        } else {
            dp2px = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(dp2px, intrinsicHeight, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private int getHeightByRatio(android.graphics.drawable.Drawable drawable, int i) {
        return java.lang.Math.round(((i * 1.0f) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
    }

    private int getProgress(float f) {
        return java.lang.Math.round(f);
    }

    private float getProgressFloat(int i) {
        return java.math.BigDecimal.valueOf(this.p.mProgress).setScale(i, 4).floatValue();
    }

    private float getProgressFloat(int i, float f) {
        return java.math.BigDecimal.valueOf(f).setScale(i, 4).floatValue();
    }

    private java.lang.String getProgressString(float f) {
        return this.p.mIsFloatProgress ? java.lang.String.valueOf(getProgressFloat(2, f)) : java.lang.String.valueOf(getProgress(f));
    }

    @androidx.annotation.NonNull
    private java.lang.String getStringText(int i) {
        java.lang.CharSequence[] charSequenceArr = this.p.mTextArray;
        if (charSequenceArr == null) {
            return this.mTextList.get(i) + "";
        }
        if (i >= charSequenceArr.length) {
            return " ";
        }
        return ((java.lang.Object) this.p.mTextArray[i]) + "";
    }

    private float getThumbX() {
        float f;
        float f2 = this.mTouchX;
        int i = this.p.mBackgroundTrackSize;
        float f3 = f2 - (i / 2.0f);
        if (f3 > this.mSeekStart) {
            int i2 = this.mMeasuredWidth;
            int i3 = this.mPaddingRight;
            if (f3 < (i2 - i3) - (i / 2.0f)) {
                return f3;
            }
            f = i2 - i3;
        } else {
            if (f3 > this.mPaddingLeft) {
                return f3 + (i / 2.0f);
            }
            f = getPaddingLeft();
            i = this.p.mBackgroundTrackSize;
        }
        return f - (i / 2.0f);
    }

    private void initAttrs(android.content.Context context, android.util.AttributeSet attributeSet) {
        this.p = new com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams(context);
        if (attributeSet == null) {
            return;
        }
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.base.R.styleable.IndicatorSeekBar);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        builderParams.mSeekBarType = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_seek_bar_type, builderParams.mSeekBarType);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams2 = this.p;
        builderParams2.mMax = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_max, builderParams2.mMax);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams3 = this.p;
        builderParams3.mMin = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_min, builderParams3.mMin);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams4 = this.p;
        builderParams4.mProgress = obtainStyledAttributes.getFloat(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_progress, builderParams4.mProgress);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams5 = this.p;
        builderParams5.mClearPadding = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_clear_default_padding, builderParams5.mClearPadding);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams6 = this.p;
        builderParams6.mForbidUserSeek = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_forbid_user_seek, builderParams6.mForbidUserSeek);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams7 = this.p;
        builderParams7.mIsFloatProgress = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_progress_value_float, builderParams7.mIsFloatProgress);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams8 = this.p;
        builderParams8.mTouchToSeek = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_touch_to_seek, builderParams8.mTouchToSeek);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams9 = this.p;
        builderParams9.mBackgroundTrackSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_track_background_bar_size, builderParams9.mBackgroundTrackSize);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams10 = this.p;
        builderParams10.mProgressTrackSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_track_progress_bar_size, builderParams10.mProgressTrackSize);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams11 = this.p;
        builderParams11.mBackgroundTrackColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_track_background_bar_color, builderParams11.mBackgroundTrackColor);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams12 = this.p;
        builderParams12.mProgressTrackColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_track_progress_bar_color, builderParams12.mProgressTrackColor);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams13 = this.p;
        builderParams13.mTrackRoundedCorners = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_track_rounded_corners, builderParams13.mTrackRoundedCorners);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams14 = this.p;
        builderParams14.mThumbColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_thumb_color, builderParams14.mThumbColor);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams15 = this.p;
        builderParams15.mThumbSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_thumb_width, builderParams15.mThumbSize);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams16 = this.p;
        builderParams16.mThumbProgressStay = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_thumb_progress_stay, builderParams16.mThumbProgressStay);
        this.p.mThumbDrawable = obtainStyledAttributes.getDrawable(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_thumb_drawable);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams17 = this.p;
        builderParams17.mIndicatorType = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_indicator_type, builderParams17.mIndicatorType);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams18 = this.p;
        builderParams18.mIndicatorColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_indicator_color, builderParams18.mIndicatorColor);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams19 = this.p;
        builderParams19.mIndicatorTextColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_indicator_text_color, builderParams19.mIndicatorTextColor);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams20 = this.p;
        builderParams20.mShowIndicator = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_show_indicator, builderParams20.mShowIndicator);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams21 = this.p;
        builderParams21.mIndicatorStay = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_indicator_stay, builderParams21.mIndicatorStay);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams22 = this.p;
        builderParams22.mIndicatorTextSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_indicator_text_size, builderParams22.mIndicatorTextSize);
        int resourceId = obtainStyledAttributes.getResourceId(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_indicator_custom_layout, 0);
        if (resourceId > 0) {
            this.p.mIndicatorCustomView = android.view.View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_indicator_custom_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.p.mIndicatorCustomTopContentView = android.view.View.inflate(this.mContext, resourceId2, null);
        }
        this.p.mTickDrawable = obtainStyledAttributes.getDrawable(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_tick_drawable);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams23 = this.p;
        builderParams23.mTickNum = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_tick_num, builderParams23.mTickNum);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams24 = this.p;
        builderParams24.mTickColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_tick_color, builderParams24.mTickColor);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams25 = this.p;
        builderParams25.mTickType = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_tick_type, builderParams25.mTickType);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams26 = this.p;
        builderParams26.mTickHideBothEnds = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_tick_both_end_hide, builderParams26.mTickHideBothEnds);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams27 = this.p;
        builderParams27.mTickOnThumbLeftHide = obtainStyledAttributes.getBoolean(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_tick_on_thumb_left_hide, builderParams27.mTickOnThumbLeftHide);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams28 = this.p;
        builderParams28.mTickSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_tick_size, builderParams28.mTickSize);
        this.p.mTextArray = obtainStyledAttributes.getTextArray(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_text_array);
        this.p.mLeftEndText = obtainStyledAttributes.getString(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_text_left_end);
        this.p.mRightEndText = obtainStyledAttributes.getString(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_text_right_end);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams29 = this.p;
        builderParams29.mTextSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_text_size, builderParams29.mTextSize);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams30 = this.p;
        builderParams30.mTextColor = obtainStyledAttributes.getColor(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_text_color, builderParams30.mTextColor);
        int i = obtainStyledAttributes.getInt(com.aliyun.svideo.base.R.styleable.IndicatorSeekBar_isb_text_typeface, 0);
        if (i == 1) {
            this.p.mTextTypeface = android.graphics.Typeface.MONOSPACE;
        } else if (i == 2) {
            this.p.mTextTypeface = android.graphics.Typeface.SANS_SERIF;
        } else if (i == 3) {
            this.p.mTextTypeface = android.graphics.Typeface.SERIF;
        } else {
            this.p.mTextTypeface = android.graphics.Typeface.DEFAULT;
        }
        obtainStyledAttributes.recycle();
    }

    private void initData() {
        java.util.List<java.lang.Float> list = this.mTextLocationList;
        if (list == null) {
            this.mTextLocationList = new java.util.ArrayList();
        } else {
            list.clear();
        }
        java.util.ArrayList<java.lang.String> arrayList = this.mTextList;
        if (arrayList == null) {
            this.mTextList = new java.util.ArrayList<>();
        } else {
            arrayList.clear();
        }
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        float f = builderParams.mMax;
        float f2 = builderParams.mMin;
        if (f < f2) {
            builderParams.mMax = f2;
        }
        if (builderParams.mProgress < f2) {
            builderParams.mProgress = f2;
        }
        float f3 = builderParams.mProgress;
        float f4 = builderParams.mMax;
        if (f3 > f4) {
            builderParams.mProgress = f4;
        }
        int i = builderParams.mBackgroundTrackSize;
        int i2 = builderParams.mProgressTrackSize;
        if (i > i2) {
            builderParams.mBackgroundTrackSize = i2;
        }
        if (builderParams.mTickNum < 0) {
            builderParams.mTickNum = 0;
        }
        if (builderParams.mTickNum > 100) {
            builderParams.mTickNum = 100;
        }
        if (builderParams.mLeftEndText == null) {
            if (builderParams.mIsFloatProgress) {
                builderParams.mLeftEndText = this.p.mMin + "";
            } else {
                builderParams.mLeftEndText = java.lang.Math.round(this.p.mMin) + "";
            }
        }
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams2 = this.p;
        if (builderParams2.mRightEndText == null) {
            if (builderParams2.mIsFloatProgress) {
                builderParams2.mRightEndText = this.p.mMax + "";
            } else {
                builderParams2.mRightEndText = java.lang.Math.round(this.p.mMax) + "";
            }
        }
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams3 = this.p;
        if (builderParams3.mTickDrawable != null) {
            builderParams3.mTickType = 1;
        }
        if (builderParams3.mThumbDrawable == null) {
            float f5 = builderParams3.mThumbSize / 2.0f;
            this.mThumbRadius = f5;
            float f6 = f5 * 1.2f;
            this.mThumbTouchRadius = f6;
            this.mThumbTouchHeight = f6 * 2.0f;
        } else {
            int dp2px = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 30.0f);
            int i3 = this.p.mThumbSize;
            if (i3 > dp2px) {
                this.mThumbRadius = dp2px / 2.0f;
            } else {
                this.mThumbRadius = i3 / 2.0f;
            }
            float f7 = this.mThumbRadius;
            this.mThumbTouchRadius = f7;
            this.mThumbTouchHeight = f7 * 2.0f;
        }
        if (this.p.mTickDrawable == null) {
            this.mTickRadius = r0.mTickSize / 2.0f;
        } else {
            int dp2px2 = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 30.0f);
            int i4 = this.p.mTickSize;
            if (i4 > dp2px2) {
                this.mTickRadius = dp2px2 / 2.0f;
            } else {
                this.mTickRadius = i4 / 2.0f;
            }
        }
        float f8 = this.mThumbTouchRadius;
        float f9 = this.mTickRadius;
        if (f8 >= f9) {
            this.mCustomDrawableMaxHeight = this.mThumbTouchHeight;
        } else {
            this.mCustomDrawableMaxHeight = f9 * 2.0f;
        }
        initStrokePaint();
        initDefaultPadding();
        if (noTick()) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams4 = this.p;
            float f10 = builderParams4.mMax;
            float f11 = builderParams4.mMin;
            if (f10 - f11 > 100.0f) {
                builderParams4.mTickNum = java.lang.Math.round(f10 - f11);
            } else {
                builderParams4.mTickNum = 100;
            }
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams5 = this.p;
            if (builderParams5.mIsFloatProgress) {
                builderParams5.mTickNum *= 10;
            }
        } else {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams6 = this.p;
            int i5 = builderParams6.mTickNum;
            builderParams6.mTickNum = i5 >= 2 ? i5 - 1 : 2;
        }
        if (needDrawText()) {
            initTextPaint();
            this.mTextPaint.setTypeface(this.p.mTextTypeface);
            this.mTextPaint.getTextBounds("jf1", 0, 3, this.mRect);
            this.mTextHeight = 0;
            this.mTextHeight = 0 + this.mRect.height() + com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 6.0f);
        }
        this.lastProgress = this.p.mProgress;
    }

    private void initDefaultPadding() {
        if (this.p.mClearPadding) {
            return;
        }
        int dp2px = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 16.0f);
        if (getPaddingLeft() == 0) {
            setPadding(dp2px, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (getPaddingRight() == 0) {
            setPadding(getPaddingLeft(), getPaddingTop(), dp2px, getPaddingBottom());
        }
    }

    private void initDefaultTextArray(java.util.ArrayList<java.lang.String> arrayList) {
        if (this.p.mTextArray != null) {
            return;
        }
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            charSequenceArr[i] = arrayList.get(i);
        }
        this.p.mTextArray = charSequenceArr;
    }

    private void initEndTexts() {
        if (this.mTextList.size() == 0) {
            java.lang.String str = this.p.mLeftEndText;
            if (str != null) {
                this.mTextList.add(str);
                this.mTextLocationList.add(java.lang.Float.valueOf(this.mPaddingLeft));
            }
            java.lang.String str2 = this.p.mRightEndText;
            if (str2 != null) {
                this.mTextList.add(str2);
                this.mTextLocationList.add(java.lang.Float.valueOf(this.mMeasuredWidth - this.mPaddingRight));
                return;
            }
            return;
        }
        if (this.mTextList.size() != 1) {
            java.lang.String str3 = this.p.mLeftEndText;
            if (str3 != null) {
                this.mTextList.set(0, str3);
            }
            if (this.p.mLeftEndText != null) {
                java.util.ArrayList<java.lang.String> arrayList = this.mTextList;
                arrayList.set(arrayList.size() - 1, this.p.mRightEndText);
                return;
            }
            return;
        }
        java.lang.String str4 = this.p.mLeftEndText;
        if (str4 != null) {
            this.mTextList.set(0, str4);
        }
        java.lang.String str5 = this.p.mRightEndText;
        if (str5 != null) {
            this.mTextList.add(str5);
            this.mTextLocationList.add(java.lang.Float.valueOf(this.mMeasuredWidth - this.mPaddingRight));
        }
    }

    private void initLocationListData() {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        int i = builderParams.mSeekBarType;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            initEndTexts();
            return;
        }
        if (builderParams.mTickNum > 1) {
            this.mTextLocationList.clear();
            this.mTextList.clear();
            for (int i2 = 0; i2 < this.p.mTickNum + 1; i2++) {
                float f = this.mSeekBlockLength * i2;
                this.mTextLocationList.add(java.lang.Float.valueOf(this.mPaddingLeft + f));
                com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams2 = this.p;
                float f2 = builderParams2.mMin;
                this.mTextList.add(getProgressString(f2 + (((builderParams2.mMax - f2) * f) / this.mSeekLength)));
            }
            initEndTexts();
            initDefaultTextArray(this.mTextList);
        }
    }

    private void initScreenWidth() {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.WindowManager windowManager = (android.view.WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
        }
    }

    private void initSeekBarInfo() {
        this.mMeasuredWidth = getMeasuredWidth();
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        this.mPaddingTop = paddingTop;
        int i = this.mMeasuredWidth;
        int i2 = this.mPaddingLeft;
        float f = (i - i2) - this.mPaddingRight;
        this.mSeekLength = f;
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        this.mSeekBlockLength = f / builderParams.mTickNum;
        float f2 = this.mThumbTouchRadius;
        float f3 = this.mTickRadius;
        if (f2 >= f3) {
            this.mTrackY = paddingTop + f2;
        } else {
            this.mTrackY = paddingTop + f3;
        }
        this.mSeekStart = builderParams.mTrackRoundedCorners ? i2 + (builderParams.mBackgroundTrackSize / 2.0f) : i2;
        this.mSeekEnd = (i - r4) - (builderParams.mBackgroundTrackSize / 2.0f);
        initLocationListData();
    }

    private void initStrokePaint() {
        if (this.mStockPaint == null) {
            this.mStockPaint = new android.graphics.Paint();
        }
        if (this.p.mTrackRoundedCorners) {
            this.mStockPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        }
        this.mStockPaint.setAntiAlias(true);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        int i = builderParams.mBackgroundTrackSize;
        if (i > builderParams.mProgressTrackSize) {
            builderParams.mProgressTrackSize = i;
        }
    }

    private void initTextPaint() {
        if (this.mTextPaint == null) {
            android.text.TextPaint textPaint = new android.text.TextPaint();
            this.mTextPaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.p.mTextSize);
            this.mTextPaint.setColor(this.p.mTextColor);
        }
        if (this.mRect == null) {
            this.mRect = new android.graphics.Rect();
        }
    }

    private boolean isTouchSeekBar(float f, float f2) {
        if (this.mFaultTolerance == -1.0f) {
            this.mFaultTolerance = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 5.0f);
        }
        float f3 = this.mPaddingLeft;
        float f4 = this.mFaultTolerance;
        boolean z = f >= f3 - (f4 * 2.0f) && f <= ((float) (this.mMeasuredWidth - this.mPaddingRight)) + (2.0f * f4);
        float f5 = this.mTrackY;
        float f6 = this.mThumbTouchRadius;
        return z && ((f2 > ((f5 - f6) - f4) ? 1 : (f2 == ((f5 - f6) - f4) ? 0 : -1)) >= 0 && (f2 > ((f5 + f6) + f4) ? 1 : (f2 == ((f5 + f6) + f4) ? 0 : -1)) <= 0);
    }

    private boolean needDrawText() {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        int i = builderParams.mSeekBarType;
        return i == 1 || i == 3 || i == 4 || builderParams.mThumbProgressStay;
    }

    private boolean noTick() {
        int i = this.p.mSeekBarType;
        return i == 0 || i == 1;
    }

    private void refreshSeekBar(android.view.MotionEvent motionEvent, boolean z) {
        calculateTouchX(adjustTouchX(motionEvent));
        calculateProgress();
        this.mIsTouching = true;
        if (!z) {
            if (this.lastProgress != this.p.mProgress) {
                setListener(true);
                invalidate();
                if (this.p.mShowIndicator) {
                    this.mIndicator.update(this.mTouchX);
                    return;
                }
                return;
            }
            return;
        }
        if (this.lastProgress != this.p.mProgress) {
            setListener(true);
        }
        invalidate();
        if (this.p.mShowIndicator) {
            if (this.mIndicator.isShowing()) {
                this.mIndicator.update(this.mTouchX);
            } else {
                this.mIndicator.show(this.mTouchX);
            }
        }
    }

    private void setListener(boolean z) {
        com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.mListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(this, getProgress(), getProgressFloat(), z);
            if (this.p.mSeekBarType > 1) {
                int thumbPosOnTick = getThumbPosOnTick();
                java.lang.CharSequence[] charSequenceArr = this.p.mTextArray;
                if (charSequenceArr == null || thumbPosOnTick >= charSequenceArr.length) {
                    this.mListener.onSectionChanged(this, thumbPosOnTick, "", z);
                } else {
                    this.mListener.onSectionChanged(this, thumbPosOnTick, java.lang.String.valueOf(charSequenceArr[thumbPosOnTick]), z);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void forbidUserToSeek(boolean z) {
        this.p.mForbidUserSeek = z;
    }

    public synchronized com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder getBuilder() {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams;
        if (this.mBuilder == null) {
            this.mBuilder = new com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.Builder(this.mContext);
        }
        builderParams = this.mRawParams;
        builderParams.mProgress = this.p.mProgress;
        return this.mBuilder.setParams(builderParams).setSeekBar(this);
    }

    public com.aliyun.svideo.base.widget.beauty.seekbar.Indicator getIndicator() {
        return this.mIndicator;
    }

    public float getMax() {
        return this.p.mMax;
    }

    public float getMin() {
        return this.p.mMin;
    }

    public int getProgress() {
        return java.lang.Math.round(this.p.mProgress);
    }

    public synchronized float getProgressFloat() {
        return getProgressFloat(1);
    }

    public java.lang.String getProgressString() {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        if (builderParams.mSeekBarType != 3) {
            return getProgressString(builderParams.mProgress);
        }
        int thumbPosOnTick = getThumbPosOnTick();
        java.lang.CharSequence[] charSequenceArr = this.p.mTextArray;
        return thumbPosOnTick >= charSequenceArr.length ? "" : java.lang.String.valueOf(charSequenceArr[thumbPosOnTick]);
    }

    public java.lang.CharSequence[] getTextArray() {
        return this.p.mTextArray;
    }

    public int getThumbPosOnTick() {
        if (this.p.mSeekBarType > 1) {
            return java.lang.Math.round((this.mTouchX - this.mPaddingLeft) / this.mSeekBlockLength);
        }
        return -1;
    }

    public float getTouchX() {
        calculateProgressTouchX();
        return this.mTouchX;
    }

    public boolean isCover() {
        if (this.mCoverRect == null) {
            this.mCoverRect = new android.graphics.Rect();
        }
        if (getGlobalVisibleRect(this.mCoverRect) && this.mCoverRect.width() >= getMeasuredWidth() && this.mCoverRect.height() >= getMeasuredHeight()) {
            if (this.mScreenWidth < 0.0f) {
                initScreenWidth();
            }
            if (this.mScreenWidth > 0.0f) {
                android.graphics.Rect rect = this.mCoverRect;
                int i = rect.left;
                int i2 = rect.top;
                if (this.mLocation == null) {
                    this.mLocation = new int[2];
                }
                getLocationInWindow(this.mLocation);
                int[] iArr = this.mLocation;
                if (i == iArr[0] && i2 == iArr[1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTouchThumb(float f) {
        float touchX = getTouchX();
        int i = this.p.mThumbSize;
        return touchX - (((float) i) / 2.0f) <= f && f <= touchX + (((float) i) / 2.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        if (builderParams.mIndicatorStay && builderParams.mShowIndicator) {
            getViewTreeObserver().addOnGlobalLayoutListener(this);
            getViewTreeObserver().addOnScrollChangedListener(this);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.aliyun.svideo.base.widget.beauty.seekbar.Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.forceHide();
        }
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        if (builderParams.mIndicatorStay && builderParams.mShowIndicator) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
            getViewTreeObserver().removeOnScrollChangedListener(this);
        }
    }

    @Override // android.view.View
    public synchronized void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.mStockPaint.setColor(this.p.mProgressTrackColor);
        if (!this.mDrawAgain) {
            com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
            float f = builderParams.mProgress;
            float f2 = builderParams.mMin;
            calculateTouchX((((f - f2) * this.mSeekLength) / (builderParams.mMax - f2)) + this.mPaddingLeft);
            this.mDrawAgain = true;
        }
        float thumbX = getThumbX();
        this.mStockPaint.setStrokeWidth(this.p.mProgressTrackSize);
        float f3 = this.mSeekStart;
        float f4 = this.mTrackY;
        canvas.drawLine(f3, f4, thumbX, f4, this.mStockPaint);
        this.mStockPaint.setStrokeWidth(this.p.mBackgroundTrackSize);
        this.mStockPaint.setColor(this.p.mBackgroundTrackColor);
        float f5 = thumbX + this.mThumbRadius;
        float f6 = this.mTrackY;
        canvas.drawLine(f5, f6, this.mSeekEnd, f6, this.mStockPaint);
        drawTicks(canvas, thumbX);
        drawText(canvas);
        drawThumbText(canvas, thumbX);
        drawThumb(canvas, thumbX);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams2 = this.p;
        if (builderParams2.mShowIndicator && builderParams2.mIndicatorStay && !this.mIndicator.isShowing() && !isCover()) {
            calculateProgressTouchX();
            this.mIndicator.show(this.mTouchX);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        checkIndicatorLoc();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(android.view.View.resolveSize(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 170.0f), i), java.lang.Math.round(this.mCustomDrawableMaxHeight + 0.5f + getPaddingTop() + getPaddingBottom()) + this.mTextHeight);
        initSeekBarInfo();
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        if (builderParams.mShowIndicator && this.mIndicator == null) {
            this.mIndicator = new com.aliyun.svideo.base.widget.beauty.seekbar.Indicator(this.mContext, this, builderParams);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof android.os.Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        android.os.Bundle bundle = (android.os.Bundle) parcelable;
        this.p.mProgress = bundle.getFloat("isb_progress");
        super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE_KEY));
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(INSTANCE_STATE_KEY, super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.p.mProgress);
        return bundle;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        checkIndicatorLoc();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.AnonymousClass1());
        checkIndicatorLoc();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
    
        if (r0 != 3) goto L33;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    refreshSeekBar(motionEvent, false);
                }
            }
            com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.mListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStopTrackingTouch(this);
            }
            this.mIsTouching = false;
            invalidate();
            if (this.p.mShowIndicator) {
                this.mIndicator.hide();
            }
        } else {
            performClick();
            float x = motionEvent.getX();
            if (isTouchSeekBar(x, motionEvent.getY()) && !this.p.mForbidUserSeek && isEnabled() && (this.p.mTouchToSeek || isTouchThumb(x))) {
                com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = this.mListener;
                if (onSeekBarChangeListener2 != null) {
                    onSeekBarChangeListener2.onStartTrackingTouch(this, getThumbPosOnTick());
                }
                refreshSeekBar(motionEvent, true);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        com.aliyun.svideo.base.widget.beauty.seekbar.Indicator indicator;
        super.onVisibilityChanged(view, i);
        if (this.p.mShowIndicator) {
            if ((8 == i || 4 == i) && (indicator = this.mIndicator) != null) {
                indicator.forceHide();
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public synchronized void setCustomIndicator(@androidx.annotation.LayoutRes int i) {
        this.mIndicator.setCustomIndicator(android.view.View.inflate(this.mContext, i, null));
    }

    public synchronized void setCustomIndicator(@androidx.annotation.NonNull android.view.View view) {
        this.mIndicator.setCustomIndicator(view);
    }

    public synchronized void setCustomIndicator(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.IdRes int i) {
        android.view.View findViewById = view.findViewById(i);
        if (findViewById == null) {
            throw new java.lang.IllegalArgumentException(" can not find the textView in topContentView by progressTextViewId. ");
        }
        if (!(findViewById instanceof android.widget.TextView)) {
            throw new java.lang.ClassCastException(" the view identified by progressTextViewId can not be cast to TextView. ");
        }
        this.mIndicator.setProgressTextView((android.widget.TextView) findViewById);
        this.mIndicator.setCustomIndicator(view);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z == isEnabled()) {
            return;
        }
        super.setEnabled(z);
        if (isEnabled()) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.3f);
        }
        if (!this.p.mIndicatorStay || getIndicator() == null) {
            return;
        }
        getIndicator().forceHide();
    }

    public void setFloatProgress(boolean z) {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.mRawParams;
        if (builderParams != null) {
            builderParams.mIsFloatProgress = z;
            this.p.copy(builderParams);
        }
    }

    public void setIndicatorGap(int i) {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        if (builderParams.mShowIndicator && this.mIndicator == null) {
            com.aliyun.svideo.base.widget.beauty.seekbar.Indicator indicator = new com.aliyun.svideo.base.widget.beauty.seekbar.Indicator(this.mContext, this, builderParams);
            this.mIndicator = indicator;
            indicator.setGap(i);
        }
    }

    public synchronized void setMax(float f) {
        com.aliyun.svideo.base.widget.beauty.seekbar.Indicator indicator;
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.mRawParams;
        if (f < builderParams.mMin) {
            builderParams.mMin = f;
        }
        builderParams.mMax = f;
        this.p.copy(builderParams);
        initData();
        requestLayout();
        initLocationListData();
        if (this.p.mIndicatorStay && (indicator = this.mIndicator) != null && indicator.isShowing()) {
            this.mIndicator.update();
        }
    }

    public synchronized void setMin(float f) {
        com.aliyun.svideo.base.widget.beauty.seekbar.Indicator indicator;
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.mRawParams;
        if (f > builderParams.mMax) {
            builderParams.mMax = f;
        }
        builderParams.mMin = f;
        this.p.copy(builderParams);
        initData();
        requestLayout();
        initLocationListData();
        if (this.p.mIndicatorStay && (indicator = this.mIndicator) != null && indicator.isShowing()) {
            this.mIndicator.update();
        }
    }

    public void setOnSeekChangeListener(@androidx.annotation.NonNull com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.mListener = onSeekBarChangeListener;
    }

    public synchronized void setProgress(float f) {
        com.aliyun.svideo.base.widget.beauty.seekbar.Indicator indicator;
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        float f2 = builderParams.mMin;
        if (f < f2) {
            builderParams.mProgress = f2;
        } else {
            float f3 = builderParams.mMax;
            if (f > f3) {
                builderParams.mProgress = f3;
            } else {
                builderParams.mProgress = f;
            }
        }
        setListener(false);
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams2 = this.p;
        float f4 = builderParams2.mProgress;
        float f5 = builderParams2.mMin;
        calculateTouchX((((f4 - f5) * this.mSeekLength) / (builderParams2.mMax - f5)) + this.mPaddingLeft);
        initSeekBarInfo();
        postInvalidate();
        if (this.p.mIndicatorStay && (indicator = this.mIndicator) != null && indicator.isShowing()) {
            this.mIndicator.update();
        }
    }

    public void setTextArray(@androidx.annotation.ArrayRes int i) {
        this.p.mTextArray = this.mContext.getResources().getStringArray(i);
        invalidate();
    }

    public void setTextArray(@androidx.annotation.NonNull java.lang.CharSequence[] charSequenceArr) {
        this.p.mTextArray = charSequenceArr;
        invalidate();
    }

    public void setThumbDrawable(android.graphics.drawable.Drawable drawable) {
        this.p.mThumbDrawable = drawable;
        invalidate();
    }
}
