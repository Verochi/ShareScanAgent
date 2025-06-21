package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class WheelView extends android.view.View {
    private static final int DEFAULT_DIVIDER_COLOR = -695533;
    private static final int DEFAULT_DIVIDER_HEIGHT = 2;
    private static final int DEFAULT_DIVIDER_MARGIN_HORIZONTAL = 0;
    private static final int DEFAULT_INTERVAL_REVISE_DURATION = 300;
    private static final int DEFAULT_ITEM_PADDING_DP_H = 5;
    private static final int DEFAULT_ITEM_PADDING_DP_V = 2;
    private static final int DEFAULT_MARGIN_END_OF_HINT_DP = 8;
    private static final int DEFAULT_MARGIN_START_OF_HINT_DP = 8;
    private static final int DEFAULT_MAX_SCROLL_BY_INDEX_DURATION = 600;
    private static final int DEFAULT_MIN_SCROLL_BY_INDEX_DURATION = 300;
    private static final int DEFAULT_SHOW_COUNT = 3;
    private static final int DEFAULT_TEXT_COLOR_NORMAL = -13421773;
    private static final int DEFAULT_TEXT_COLOR_SELECTED = -695533;
    private static final int DEFAULT_TEXT_SIZE_HINT_SP = 14;
    private static final int DEFAULT_TEXT_SIZE_NORMAL_SP = 14;
    private static final int DEFAULT_TEXT_SIZE_SELECTED_SP = 16;
    private static final int HANDLER_INTERVAL_REFRESH = 30;
    private static final int HANDLER_WHAT_LISTENER_VALUE_CHANGED = 2;
    private static final int HANDLER_WHAT_REFRESH = 1;
    private float currY;
    private float dividerY0;
    private float dividerY1;
    private float downY;
    private float downYGlobal;
    private java.lang.String mAlterHint;
    private java.lang.CharSequence[] mAlterTextArrayWithMeasureHint;
    private java.lang.CharSequence[] mAlterTextArrayWithoutMeasureHint;
    private int mCurrDrawFirstItemIndex;
    private int mCurrDrawFirstItemY;
    private int mCurrDrawGlobalY;
    private boolean mCurrentItemIndexEffect;
    private java.lang.String[] mDisplayedValues;
    private int mDividerColor;
    private int mDividerHeight;
    private int mDividerIndex0;
    private int mDividerIndex1;
    private int mDividerMarginL;
    private int mDividerMarginR;
    private java.lang.String mEmptyItemHint;
    private boolean mFlagMayPress;
    private float mFriction;
    private android.os.Handler mHandler;
    private android.os.Handler mHandlerLayout;
    private android.os.HandlerThread mHandlerThread;
    private boolean mHasInit;
    private java.lang.String mHintText;
    private int mItemHeight;
    private int mItemPaddingHorizental;
    private int mItemPaddingVertical;
    private int mMarginEndOfHint;
    private int mMarginStartOfHint;
    private int mMaxHeightOfDisplayedValues;
    private int mMaxShowIndex;
    private int mMaxValue;
    private int mMaxWidthOfAlterArrayWithMeasureHint;
    private int mMaxWidthOfAlterArrayWithoutMeasureHint;
    private int mMaxWidthOfDisplayedValues;
    private int mMinShowIndex;
    private int mMinValue;
    private int mMiniVerlocityFling;
    private int mNotWrapLimitYBottom;
    private int mNotWrapLimitYTop;
    private com.aliyun.svideo.common.widget.WheelView.OnScrollListener mOnScrollListener;
    private com.aliyun.svideo.common.widget.WheelView.OnValueChangeListener mOnValueChangeListener;
    private com.aliyun.svideo.common.widget.WheelView.OnValueChangeListenerRelativeToRaw mOnValueChangeListenerRaw;
    private android.graphics.Paint mPaintDivider;
    private android.graphics.Paint mPaintHint;
    private android.graphics.Paint mPaintText;
    private boolean mPendingWrapToLinear;
    private int mPrivPickedIndex;
    private int mScaledTouchSlop;
    private int mScrollState;
    private androidx.core.widget.ScrollerCompat mScroller;
    private int mShowCount;
    private boolean mShowDivider;
    private int mSpecModeH;
    private int mSpecModeW;
    private int mTextColorHint;
    private int mTextColorNormal;
    private int mTextColorSelected;
    private int mTextSizeHint;
    private float mTextSizeHintCenterYOffset;
    private int mTextSizeNormal;
    private float mTextSizeNormalCenterYOffset;
    private int mTextSizeSelected;
    private float mTextSizeSelectedCenterYOffset;
    private android.view.VelocityTracker mVelocityTracker;
    private float mViewCenterX;
    private int mViewHeight;
    private int mViewWidth;
    private int mWidthOfAlterHint;
    private int mWidthOfHintText;
    private boolean mWrapSelectorWheel;
    private boolean mWrapSelectorWheelCheck;

    /* renamed from: com.aliyun.svideo.common.widget.WheelView$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int willPickIndexByGlobalY;
            int i;
            java.lang.Object obj;
            int i2 = message.what;
            int i3 = 0;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                com.aliyun.svideo.common.widget.WheelView.this.onScrollStateChange(0);
                if (message.arg1 != message.arg2 && ((obj = message.obj) == null || !(obj instanceof java.lang.Boolean) || ((java.lang.Boolean) obj).booleanValue())) {
                    if (com.aliyun.svideo.common.widget.WheelView.this.mOnValueChangeListener != null) {
                        com.aliyun.svideo.common.widget.WheelView.OnValueChangeListener onValueChangeListener = com.aliyun.svideo.common.widget.WheelView.this.mOnValueChangeListener;
                        com.aliyun.svideo.common.widget.WheelView wheelView = com.aliyun.svideo.common.widget.WheelView.this;
                        onValueChangeListener.onValueChange(wheelView, message.arg1 + wheelView.mMinValue, message.arg2 + com.aliyun.svideo.common.widget.WheelView.this.mMinValue);
                    }
                    if (com.aliyun.svideo.common.widget.WheelView.this.mOnValueChangeListenerRaw != null) {
                        com.aliyun.svideo.common.widget.WheelView.OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw = com.aliyun.svideo.common.widget.WheelView.this.mOnValueChangeListenerRaw;
                        com.aliyun.svideo.common.widget.WheelView wheelView2 = com.aliyun.svideo.common.widget.WheelView.this;
                        onValueChangeListenerRelativeToRaw.onValueChangeRelativeToRaw(wheelView2, message.arg1, message.arg2, wheelView2.mDisplayedValues);
                    }
                }
                com.aliyun.svideo.common.widget.WheelView.this.mPrivPickedIndex = message.arg2;
                if (com.aliyun.svideo.common.widget.WheelView.this.mPendingWrapToLinear) {
                    com.aliyun.svideo.common.widget.WheelView.this.mPendingWrapToLinear = false;
                    com.aliyun.svideo.common.widget.WheelView.this.internalSetWrapToLinear();
                    return;
                }
                return;
            }
            if (!com.aliyun.svideo.common.widget.WheelView.this.mScroller.isFinished()) {
                if (com.aliyun.svideo.common.widget.WheelView.this.mScrollState == 0) {
                    com.aliyun.svideo.common.widget.WheelView.this.onScrollStateChange(1);
                }
                com.aliyun.svideo.common.widget.WheelView.this.mHandler.sendMessageDelayed(com.aliyun.svideo.common.widget.WheelView.this.getMsg(1, 0, 0, message.obj), 30L);
                return;
            }
            if (com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawFirstItemY != 0) {
                if (com.aliyun.svideo.common.widget.WheelView.this.mScrollState == 0) {
                    com.aliyun.svideo.common.widget.WheelView.this.onScrollStateChange(1);
                }
                if (com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawFirstItemY < (-com.aliyun.svideo.common.widget.WheelView.this.mItemHeight) / 2) {
                    i = (int) (((com.aliyun.svideo.common.widget.WheelView.this.mItemHeight + com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawFirstItemY) * 300.0f) / com.aliyun.svideo.common.widget.WheelView.this.mItemHeight);
                    com.aliyun.svideo.common.widget.WheelView.this.mScroller.startScroll(0, com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawGlobalY, 0, com.aliyun.svideo.common.widget.WheelView.this.mItemHeight + com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawFirstItemY, i * 2);
                    com.aliyun.svideo.common.widget.WheelView wheelView3 = com.aliyun.svideo.common.widget.WheelView.this;
                    willPickIndexByGlobalY = wheelView3.getWillPickIndexByGlobalY(wheelView3.mCurrDrawGlobalY + com.aliyun.svideo.common.widget.WheelView.this.mItemHeight + com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawFirstItemY);
                } else {
                    i = (int) (((-com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawFirstItemY) * 300.0f) / com.aliyun.svideo.common.widget.WheelView.this.mItemHeight);
                    com.aliyun.svideo.common.widget.WheelView.this.mScroller.startScroll(0, com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawGlobalY, 0, com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawFirstItemY, i * 2);
                    com.aliyun.svideo.common.widget.WheelView wheelView4 = com.aliyun.svideo.common.widget.WheelView.this;
                    willPickIndexByGlobalY = wheelView4.getWillPickIndexByGlobalY(wheelView4.mCurrDrawGlobalY + com.aliyun.svideo.common.widget.WheelView.this.mCurrDrawFirstItemY);
                }
                i3 = i;
                com.aliyun.svideo.common.widget.WheelView.this.postInvalidate();
            } else {
                com.aliyun.svideo.common.widget.WheelView.this.onScrollStateChange(0);
                com.aliyun.svideo.common.widget.WheelView wheelView5 = com.aliyun.svideo.common.widget.WheelView.this;
                willPickIndexByGlobalY = wheelView5.getWillPickIndexByGlobalY(wheelView5.mCurrDrawGlobalY);
            }
            android.os.Handler handler = com.aliyun.svideo.common.widget.WheelView.this.mHandler;
            com.aliyun.svideo.common.widget.WheelView wheelView6 = com.aliyun.svideo.common.widget.WheelView.this;
            handler.sendMessageDelayed(wheelView6.getMsg(2, wheelView6.mPrivPickedIndex, willPickIndexByGlobalY, message.obj), i3 * 2);
        }
    }

    /* renamed from: com.aliyun.svideo.common.widget.WheelView$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.Handler {
        public AnonymousClass2() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            com.aliyun.svideo.common.widget.WheelView.this.requestLayout();
        }
    }

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(com.aliyun.svideo.common.widget.WheelView wheelView, int i);
    }

    public interface OnValueChangeListener {
        void onValueChange(com.aliyun.svideo.common.widget.WheelView wheelView, int i, int i2);
    }

    public interface OnValueChangeListenerRelativeToRaw {
        void onValueChangeRelativeToRaw(com.aliyun.svideo.common.widget.WheelView wheelView, int i, int i2, java.lang.String[] strArr);
    }

    public WheelView(android.content.Context context) {
        this(context, null);
    }

    public WheelView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextColorNormal = DEFAULT_TEXT_COLOR_NORMAL;
        this.mTextColorSelected = -695533;
        this.mTextColorHint = -695533;
        this.mTextSizeNormal = 0;
        this.mTextSizeSelected = 0;
        this.mTextSizeHint = 0;
        this.mWidthOfHintText = 0;
        this.mWidthOfAlterHint = 0;
        this.mMarginStartOfHint = 0;
        this.mMarginEndOfHint = 0;
        this.mItemPaddingVertical = 0;
        this.mItemPaddingHorizental = 0;
        this.mDividerColor = -695533;
        this.mDividerHeight = 2;
        this.mDividerMarginL = 0;
        this.mDividerMarginR = 0;
        this.mShowCount = 3;
        this.mDividerIndex0 = 0;
        this.mDividerIndex1 = 0;
        this.mMinShowIndex = -1;
        this.mMaxShowIndex = -1;
        this.mMinValue = 0;
        this.mMaxValue = 0;
        this.mMaxWidthOfDisplayedValues = 0;
        this.mMaxHeightOfDisplayedValues = 0;
        this.mMaxWidthOfAlterArrayWithMeasureHint = 0;
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = 0;
        this.mPrivPickedIndex = 0;
        this.mMiniVerlocityFling = 150;
        this.mScaledTouchSlop = 8;
        this.mFriction = 1.0f;
        this.mTextSizeNormalCenterYOffset = 0.0f;
        this.mTextSizeSelectedCenterYOffset = 0.0f;
        this.mTextSizeHintCenterYOffset = 0.0f;
        this.mShowDivider = true;
        this.mWrapSelectorWheel = true;
        this.mCurrentItemIndexEffect = false;
        this.mHasInit = false;
        this.mWrapSelectorWheelCheck = true;
        this.mPendingWrapToLinear = false;
        this.mPaintDivider = new android.graphics.Paint();
        this.mPaintText = new android.graphics.Paint();
        this.mPaintHint = new android.graphics.Paint();
        this.mScrollState = 0;
        this.downYGlobal = 0.0f;
        this.downY = 0.0f;
        this.currY = 0.0f;
        this.mFlagMayPress = false;
        this.mCurrDrawFirstItemIndex = 0;
        this.mCurrDrawFirstItemY = 0;
        this.mCurrDrawGlobalY = 0;
        this.mSpecModeW = 0;
        this.mSpecModeH = 0;
        initAttr(context, attributeSet);
        init(context);
    }

    private void click(android.view.MotionEvent motionEvent) {
        float y = motionEvent.getY();
        for (int i = 0; i < this.mShowCount; i++) {
            int i2 = this.mItemHeight;
            if (i2 * i <= y && y < i2 * (i + 1)) {
                clickItem(i);
                return;
            }
        }
    }

    private void clickItem(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.mShowCount)) {
            return;
        }
        scrollByIndexSmoothly(i - (i2 / 2));
    }

    private java.lang.String[] convertCharSequenceArrayToStringArray(java.lang.CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return null;
        }
        java.lang.String[] strArr = new java.lang.String[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = charSequenceArr[i].toString();
        }
        return strArr;
    }

    private void correctPositionByDefaultValue(int i, boolean z) {
        int i2 = i - ((this.mShowCount - 1) / 2);
        this.mCurrDrawFirstItemIndex = i2;
        int indexByRawIndex = getIndexByRawIndex(i2, getOneRecycleSize(), z);
        this.mCurrDrawFirstItemIndex = indexByRawIndex;
        int i3 = this.mItemHeight;
        if (i3 == 0) {
            this.mCurrentItemIndexEffect = true;
        } else {
            this.mCurrDrawGlobalY = indexByRawIndex * i3;
        }
    }

    private int dp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void drawContent(android.graphics.Canvas canvas) {
        float f;
        float f2;
        float f3;
        int i;
        float f4 = 0.0f;
        int i2 = 0;
        while (i2 < this.mShowCount + 1) {
            float f5 = this.mCurrDrawFirstItemY + (this.mItemHeight * i2);
            int indexByRawIndex = getIndexByRawIndex(this.mCurrDrawFirstItemIndex + i2, getOneRecycleSize(), this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
            int i3 = this.mShowCount;
            if (i2 == i3 / 2) {
                f3 = (this.mCurrDrawFirstItemY + r0) / this.mItemHeight;
                i = getEvaluateColor(f3, this.mTextColorNormal, this.mTextColorSelected);
                f = getEvaluateSize(f3, this.mTextSizeNormal, this.mTextSizeSelected);
                f2 = getEvaluateSize(f3, this.mTextSizeNormalCenterYOffset, this.mTextSizeSelectedCenterYOffset);
            } else if (i2 == (i3 / 2) + 1) {
                float f6 = 1.0f - f4;
                int evaluateColor = getEvaluateColor(f6, this.mTextColorNormal, this.mTextColorSelected);
                float evaluateSize = getEvaluateSize(f6, this.mTextSizeNormal, this.mTextSizeSelected);
                float evaluateSize2 = getEvaluateSize(f6, this.mTextSizeNormalCenterYOffset, this.mTextSizeSelectedCenterYOffset);
                f3 = f4;
                i = evaluateColor;
                f = evaluateSize;
                f2 = evaluateSize2;
            } else {
                int i4 = this.mTextColorNormal;
                f = this.mTextSizeNormal;
                f2 = this.mTextSizeNormalCenterYOffset;
                f3 = f4;
                i = i4;
            }
            this.mPaintText.setColor(i);
            this.mPaintText.setTextSize(f);
            if (indexByRawIndex >= 0 && indexByRawIndex < getOneRecycleSize()) {
                canvas.drawText(this.mDisplayedValues[indexByRawIndex + this.mMinShowIndex].toString(), this.mViewCenterX, f5 + (this.mItemHeight / 2) + f2, this.mPaintText);
            } else if (!android.text.TextUtils.isEmpty(this.mEmptyItemHint)) {
                canvas.drawText(this.mEmptyItemHint, this.mViewCenterX, f5 + (this.mItemHeight / 2) + f2, this.mPaintText);
            }
            i2++;
            f4 = f3;
        }
    }

    private void drawHint(android.graphics.Canvas canvas) {
        if (android.text.TextUtils.isEmpty(this.mHintText)) {
            return;
        }
        canvas.drawText(this.mHintText, this.mViewCenterX + ((this.mMaxWidthOfDisplayedValues + this.mWidthOfHintText) / 2) + this.mMarginStartOfHint, ((this.dividerY0 + this.dividerY1) / 2.0f) + this.mTextSizeHintCenterYOffset, this.mPaintHint);
    }

    private void drawLine(android.graphics.Canvas canvas) {
        if (this.mShowDivider) {
            canvas.drawLine(getPaddingLeft() + this.mDividerMarginL, this.dividerY0, (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR, this.dividerY0, this.mPaintDivider);
            canvas.drawLine(getPaddingLeft() + this.mDividerMarginL, this.dividerY1, (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR, this.dividerY1, this.mPaintDivider);
        }
    }

    private int getEvaluateColor(float f, int i, int i2) {
        int i3 = (i & androidx.core.view.ViewCompat.MEASURED_STATE_MASK) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        return ((int) (((i & 255) >>> 0) + ((((i2 & 255) >>> 0) - r9) * f))) | (((int) (i3 + (((((-16777216) & i2) >>> 24) - i3) * f))) << 24) | (((int) (i4 + ((((16711680 & i2) >>> 16) - i4) * f))) << 16) | (((int) (i5 + ((((65280 & i2) >>> 8) - i5) * f))) << 8);
    }

    private float getEvaluateSize(float f, float f2, float f3) {
        return f2 + ((f3 - f2) * f);
    }

    private int getIndexByRawIndex(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (!z) {
            return i;
        }
        int i3 = i % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    private int getMaxWidthOfTextArray(java.lang.CharSequence[] charSequenceArr, android.graphics.Paint paint) {
        if (charSequenceArr == null) {
            return 0;
        }
        int i = 0;
        for (java.lang.CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i = java.lang.Math.max(getTextWidth(charSequence, paint), i);
            }
        }
        return i;
    }

    private android.os.Message getMsg(int i) {
        return getMsg(i, 0, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.os.Message getMsg(int i, int i2, int i3, java.lang.Object obj) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    private float getTextCenterYOffset(android.graphics.Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return java.lang.Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private int getTextWidth(java.lang.CharSequence charSequence, android.graphics.Paint paint) {
        if (android.text.TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        return (int) (paint.measureText(charSequence.toString()) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWillPickIndexByGlobalY(int i) {
        int i2 = this.mItemHeight;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        int i3 = (i / i2) + (this.mShowCount / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            z = true;
        }
        int indexByRawIndex = getIndexByRawIndex(i3, oneRecycleSize, z);
        if (indexByRawIndex >= 0 && indexByRawIndex < getOneRecycleSize()) {
            return indexByRawIndex + this.mMinShowIndex;
        }
        throw new java.lang.IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + indexByRawIndex + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.mWrapSelectorWheel);
    }

    private void inflateDisplayedValuesIfNull() {
        if (this.mDisplayedValues == null) {
            this.mDisplayedValues = new java.lang.String[]{"0"};
        }
    }

    private void init(android.content.Context context) {
        this.mScroller = androidx.core.widget.ScrollerCompat.create(context);
        this.mMiniVerlocityFling = android.view.ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.mScaledTouchSlop = android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.mTextSizeNormal == 0) {
            this.mTextSizeNormal = sp2px(context, 14.0f);
        }
        if (this.mTextSizeSelected == 0) {
            this.mTextSizeSelected = sp2px(context, 16.0f);
        }
        if (this.mTextSizeHint == 0) {
            this.mTextSizeHint = sp2px(context, 14.0f);
        }
        if (this.mMarginStartOfHint == 0) {
            this.mMarginStartOfHint = dp2px(context, 8.0f);
        }
        if (this.mMarginEndOfHint == 0) {
            this.mMarginEndOfHint = dp2px(context, 8.0f);
        }
        this.mPaintDivider.setColor(this.mDividerColor);
        this.mPaintDivider.setAntiAlias(true);
        this.mPaintDivider.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaintDivider.setStrokeWidth(this.mDividerHeight);
        this.mPaintText.setColor(this.mTextColorNormal);
        this.mPaintText.setAntiAlias(true);
        this.mPaintText.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.mPaintHint.setColor(this.mTextColorHint);
        this.mPaintHint.setAntiAlias(true);
        this.mPaintHint.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.mPaintHint.setTextSize(this.mTextSizeHint);
        int i = this.mShowCount;
        if (i % 2 == 0) {
            this.mShowCount = i + 1;
        }
        if (this.mMinShowIndex == -1 || this.mMaxShowIndex == -1) {
            updateValueForInit();
        }
        initHandler();
    }

    private void initAttr(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.common.R.styleable.WheelView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_ShowCount) {
                this.mShowCount = obtainStyledAttributes.getInt(index, 3);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_DividerColor) {
                this.mDividerColor = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_DividerHeight) {
                this.mDividerHeight = obtainStyledAttributes.getDimensionPixelSize(index, 2);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_DividerMarginLeft) {
                this.mDividerMarginL = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_DividerMarginRight) {
                this.mDividerMarginR = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_TextArray) {
                this.mDisplayedValues = convertCharSequenceArrayToStringArray(obtainStyledAttributes.getTextArray(index));
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_TextColorNormal) {
                this.mTextColorNormal = obtainStyledAttributes.getColor(index, DEFAULT_TEXT_COLOR_NORMAL);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_TextColorSelected) {
                this.mTextColorSelected = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_TextColorHint) {
                this.mTextColorHint = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_TextSizeNormal) {
                this.mTextSizeNormal = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 14.0f));
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_TextSizeSelected) {
                this.mTextSizeSelected = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 16.0f));
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_TextSizeHint) {
                this.mTextSizeHint = obtainStyledAttributes.getDimensionPixelSize(index, sp2px(context, 14.0f));
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_MinValue) {
                this.mMinShowIndex = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_MaxValue) {
                this.mMaxShowIndex = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_WrapSelectorWheel) {
                this.mWrapSelectorWheel = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_ShowDivider) {
                this.mShowDivider = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_HintText) {
                this.mHintText = obtainStyledAttributes.getString(index);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_AlternativeHint) {
                this.mAlterHint = obtainStyledAttributes.getString(index);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_EmptyItemHint) {
                this.mEmptyItemHint = obtainStyledAttributes.getString(index);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_MarginStartOfHint) {
                this.mMarginStartOfHint = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 8.0f));
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_MarginEndOfHint) {
                this.mMarginEndOfHint = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 8.0f));
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_ItemPaddingVertical) {
                this.mItemPaddingVertical = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 2.0f));
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_ItemPaddingHorizental) {
                this.mItemPaddingHorizental = obtainStyledAttributes.getDimensionPixelSize(index, dp2px(context, 5.0f));
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_AlternativeTextArrayWithMeasureHint) {
                this.mAlterTextArrayWithMeasureHint = obtainStyledAttributes.getTextArray(index);
            } else if (index == com.aliyun.svideo.common.R.styleable.WheelView_npv_AlternativeTextArrayWithoutMeasureHint) {
                this.mAlterTextArrayWithoutMeasureHint = obtainStyledAttributes.getTextArray(index);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void initHandler() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("HandlerThread-For-Refreshing");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new com.aliyun.svideo.common.widget.WheelView.AnonymousClass1(this.mHandlerThread.getLooper());
        this.mHandlerLayout = new com.aliyun.svideo.common.widget.WheelView.AnonymousClass2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSetWrapToLinear() {
        correctPositionByDefaultValue(getPickedIndexRelativeToRaw() - this.mMinShowIndex, false);
        this.mWrapSelectorWheel = false;
        postInvalidate();
    }

    private boolean isStringEqual(java.lang.String str, java.lang.String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private int limitY(int i) {
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            return i;
        }
        int i2 = this.mNotWrapLimitYBottom;
        return (i >= i2 && i <= (i2 = this.mNotWrapLimitYTop)) ? i : i2;
    }

    private int measureHeight(int i) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        this.mSpecModeH = mode;
        int size = android.view.View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + (this.mShowCount * (this.mMaxHeightOfDisplayedValues + (this.mItemPaddingVertical * 2)));
        return mode == Integer.MIN_VALUE ? java.lang.Math.min(paddingTop, size) : paddingTop;
    }

    private int measureWidth(int i) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        this.mSpecModeW = mode;
        int size = android.view.View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + java.lang.Math.max(this.mMaxWidthOfAlterArrayWithMeasureHint, java.lang.Math.max(this.mMaxWidthOfDisplayedValues, this.mMaxWidthOfAlterArrayWithoutMeasureHint) + (((java.lang.Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) != 0 ? this.mMarginStartOfHint : 0) + java.lang.Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) + (java.lang.Math.max(this.mWidthOfHintText, this.mWidthOfAlterHint) == 0 ? 0 : this.mMarginEndOfHint) + (this.mItemPaddingHorizental * 2)) * 2));
        return mode == Integer.MIN_VALUE ? java.lang.Math.min(paddingLeft, size) : paddingLeft;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScrollStateChange(int i) {
        if (this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        com.aliyun.svideo.common.widget.WheelView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChange(this, i);
        }
    }

    private int refineValueByLimit(int i, int i2, int i3, boolean z) {
        return z ? i > i3 ? (((i - i3) % getOneRecycleSize()) + i2) - 1 : i < i2 ? ((i - i2) % getOneRecycleSize()) + i3 + 1 : i : i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void releaseVelocityTracker() {
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void scrollByIndexSmoothly(int i) {
        scrollByIndexSmoothly(i, true);
    }

    private void scrollByIndexSmoothly(int i, boolean z) {
        int pickedIndexRelativeToRaw;
        int pickedIndexRelativeToRaw2;
        int i2;
        int i3;
        if ((!this.mWrapSelectorWheel || !this.mWrapSelectorWheelCheck) && ((pickedIndexRelativeToRaw2 = (pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw()) + i) > (i2 = this.mMaxShowIndex) || pickedIndexRelativeToRaw2 < (i2 = this.mMinShowIndex))) {
            i = i2 - pickedIndexRelativeToRaw;
        }
        int i4 = this.mCurrDrawFirstItemY;
        int i5 = this.mItemHeight;
        if (i4 < (-i5) / 2) {
            int i6 = i5 + i4;
            int i7 = (int) (((i4 + i5) * 300.0f) / i5);
            i3 = i < 0 ? (-i7) - (i * 300) : i7 + (i * 300);
            i4 = i6;
        } else {
            int i8 = (int) (((-i4) * 300.0f) / i5);
            i3 = i < 0 ? i8 - (i * 300) : i8 + (i * 300);
        }
        int i9 = i4 + (i * i5);
        if (i3 < 300) {
            i3 = 300;
        }
        if (i3 > 600) {
            i3 = 600;
        }
        this.mScroller.startScroll(0, this.mCurrDrawGlobalY, 0, i9, i3);
        if (z) {
            this.mHandler.sendMessageDelayed(getMsg(1), i3 / 4);
        } else {
            this.mHandler.sendMessageDelayed(getMsg(1, 0, 0, new java.lang.Boolean(z)), i3 / 4);
        }
        postInvalidate();
    }

    private int sp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private void stopScrolling() {
        androidx.core.widget.ScrollerCompat scrollerCompat = this.mScroller;
        if (scrollerCompat == null || scrollerCompat.isFinished()) {
            return;
        }
        this.mScroller.abortAnimation();
        postInvalidate();
    }

    private void updateContent(java.lang.String[] strArr) {
        this.mDisplayedValues = strArr;
        updateWrapStateByContent();
    }

    private void updateContentAndIndex(java.lang.String[] strArr) {
        this.mMinShowIndex = 0;
        this.mMaxShowIndex = strArr.length - 1;
        this.mDisplayedValues = strArr;
        updateWrapStateByContent();
    }

    private void updateDividerAttr() {
        int i = this.mShowCount / 2;
        this.mDividerIndex0 = i;
        this.mDividerIndex1 = i + 1;
        int i2 = this.mViewHeight;
        this.dividerY0 = (i * i2) / r0;
        this.dividerY1 = (r2 * i2) / r0;
        if (this.mDividerMarginL < 0) {
            this.mDividerMarginL = 0;
        }
        if (this.mDividerMarginR < 0) {
            this.mDividerMarginR = 0;
        }
        if (this.mDividerMarginL + this.mDividerMarginR != 0 && getPaddingLeft() + this.mDividerMarginL >= (this.mViewWidth - getPaddingRight()) - this.mDividerMarginR) {
            int paddingLeft = getPaddingLeft() + this.mDividerMarginL + getPaddingRight();
            int i3 = this.mDividerMarginR;
            int i4 = (paddingLeft + i3) - this.mViewWidth;
            int i5 = this.mDividerMarginL;
            float f = i4;
            this.mDividerMarginL = (int) (i5 - ((i5 * f) / (i5 + i3)));
            this.mDividerMarginR = (int) (i3 - ((f * i3) / (r2 + i3)));
        }
    }

    private void updateFontAttr() {
        int i = this.mTextSizeNormal;
        int i2 = this.mItemHeight;
        if (i > i2) {
            this.mTextSizeNormal = i2;
        }
        if (this.mTextSizeSelected > i2) {
            this.mTextSizeSelected = i2;
        }
        android.graphics.Paint paint = this.mPaintHint;
        if (paint == null) {
            throw new java.lang.IllegalArgumentException("mPaintHint should not be null.");
        }
        paint.setTextSize(this.mTextSizeHint);
        this.mTextSizeHintCenterYOffset = getTextCenterYOffset(this.mPaintHint.getFontMetrics());
        this.mWidthOfHintText = getTextWidth(this.mHintText, this.mPaintHint);
        android.graphics.Paint paint2 = this.mPaintText;
        if (paint2 == null) {
            throw new java.lang.IllegalArgumentException("mPaintText should not be null.");
        }
        paint2.setTextSize(this.mTextSizeSelected);
        this.mTextSizeSelectedCenterYOffset = getTextCenterYOffset(this.mPaintText.getFontMetrics());
        this.mPaintText.setTextSize(this.mTextSizeNormal);
        this.mTextSizeNormalCenterYOffset = getTextCenterYOffset(this.mPaintText.getFontMetrics());
    }

    private void updateMaxHeightOfDisplayedValues() {
        float textSize = this.mPaintText.getTextSize();
        this.mPaintText.setTextSize(this.mTextSizeSelected);
        this.mMaxHeightOfDisplayedValues = (int) ((this.mPaintText.getFontMetrics().bottom - this.mPaintText.getFontMetrics().top) + 0.5d);
        this.mPaintText.setTextSize(textSize);
    }

    private void updateMaxWHOfDisplayedValues(boolean z) {
        updateMaxWidthOfDisplayedValues();
        updateMaxHeightOfDisplayedValues();
        if (z) {
            if (this.mSpecModeW == Integer.MIN_VALUE || this.mSpecModeH == Integer.MIN_VALUE) {
                this.mHandlerLayout.sendEmptyMessage(0);
            }
        }
    }

    private void updateMaxWidthOfDisplayedValues() {
        float textSize = this.mPaintText.getTextSize();
        this.mPaintText.setTextSize(this.mTextSizeSelected);
        this.mMaxWidthOfDisplayedValues = getMaxWidthOfTextArray(this.mDisplayedValues, this.mPaintText);
        this.mMaxWidthOfAlterArrayWithMeasureHint = getMaxWidthOfTextArray(this.mAlterTextArrayWithMeasureHint, this.mPaintText);
        this.mMaxWidthOfAlterArrayWithoutMeasureHint = getMaxWidthOfTextArray(this.mAlterTextArrayWithoutMeasureHint, this.mPaintText);
        this.mPaintText.setTextSize(this.mTextSizeHint);
        this.mWidthOfAlterHint = getTextWidth(this.mAlterHint, this.mPaintText);
        this.mPaintText.setTextSize(textSize);
    }

    private void updateNotWrapYLimit() {
        this.mNotWrapLimitYTop = 0;
        this.mNotWrapLimitYBottom = (-this.mShowCount) * this.mItemHeight;
        if (this.mDisplayedValues != null) {
            int oneRecycleSize = getOneRecycleSize();
            int i = this.mShowCount;
            int i2 = this.mItemHeight;
            this.mNotWrapLimitYTop = ((oneRecycleSize - (i / 2)) - 1) * i2;
            this.mNotWrapLimitYBottom = (-(i / 2)) * i2;
        }
    }

    private void updateValue() {
        inflateDisplayedValuesIfNull();
        updateWrapStateByContent();
        this.mMinShowIndex = 0;
        this.mMaxShowIndex = this.mDisplayedValues.length - 1;
    }

    private void updateValueForInit() {
        inflateDisplayedValuesIfNull();
        updateWrapStateByContent();
        if (this.mMinShowIndex == -1) {
            this.mMinShowIndex = 0;
        }
        if (this.mMaxShowIndex == -1) {
            this.mMaxShowIndex = this.mDisplayedValues.length - 1;
        }
        setMinAndMaxShowIndex(this.mMinShowIndex, this.mMaxShowIndex, false);
    }

    private void updateWrapStateByContent() {
        this.mWrapSelectorWheelCheck = this.mDisplayedValues.length > this.mShowCount;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mItemHeight != 0 && this.mScroller.computeScrollOffset()) {
            this.mCurrDrawGlobalY = this.mScroller.getCurrY();
            int floor = (int) java.lang.Math.floor(r0 / this.mItemHeight);
            this.mCurrDrawFirstItemIndex = floor;
            this.mCurrDrawFirstItemY = -(this.mCurrDrawGlobalY - (floor * this.mItemHeight));
            postInvalidate();
        }
    }

    public java.lang.String getContentByCurrValue() {
        return this.mDisplayedValues[getValue() - this.mMinValue];
    }

    public java.lang.String[] getDisplayedValues() {
        return this.mDisplayedValues;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public int getOneRecycleSize() {
        return (this.mMaxShowIndex - this.mMinShowIndex) + 1;
    }

    public int getPickedIndexRelativeToRaw() {
        int i = this.mCurrDrawFirstItemY;
        if (i == 0) {
            return getWillPickIndexByGlobalY(this.mCurrDrawGlobalY);
        }
        int i2 = this.mItemHeight;
        return i < (-i2) / 2 ? getWillPickIndexByGlobalY(this.mCurrDrawGlobalY + i2 + i) : getWillPickIndexByGlobalY(this.mCurrDrawGlobalY + i);
    }

    public int getRawContentSize() {
        java.lang.String[] strArr = this.mDisplayedValues;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public int getValue() {
        return getPickedIndexRelativeToRaw() + this.mMinValue;
    }

    public boolean getWrapSelectorWheel() {
        return this.mWrapSelectorWheel;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        return this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandlerThread.quit();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        drawContent(canvas);
        drawLine(canvas);
        drawHint(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updateMaxWHOfDisplayedValues(false);
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewWidth = i;
        this.mViewHeight = i2;
        this.mItemHeight = i2 / this.mShowCount;
        this.mViewCenterX = ((i + getPaddingLeft()) - getPaddingRight()) / 2.0f;
        boolean z = false;
        if (getOneRecycleSize() > 1) {
            if (this.mHasInit) {
                i5 = getValue() - this.mMinValue;
            } else if (this.mCurrentItemIndexEffect) {
                i5 = this.mCurrDrawFirstItemIndex + ((this.mShowCount - 1) / 2);
            }
            if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
                z = true;
            }
            correctPositionByDefaultValue(i5, z);
            updateFontAttr();
            updateNotWrapYLimit();
            updateDividerAttr();
            this.mHasInit = true;
        }
        i5 = 0;
        if (this.mWrapSelectorWheel) {
            z = true;
        }
        correctPositionByDefaultValue(i5, z);
        updateFontAttr();
        updateNotWrapYLimit();
        updateDividerAttr();
        this.mHasInit = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        if (r1 < r3) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mItemHeight == 0) {
            return true;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = android.view.VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        this.currY = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mFlagMayPress = true;
            this.mHandler.removeMessages(1);
            stopScrolling();
            this.downY = this.currY;
            this.downYGlobal = this.mCurrDrawGlobalY;
            onScrollStateChange(0);
        } else if (action != 1) {
            if (action == 2) {
                float f = this.downY - this.currY;
                if (this.mFlagMayPress) {
                    int i = this.mScaledTouchSlop;
                    if ((-i) < f) {
                    }
                }
                this.mFlagMayPress = false;
                this.mCurrDrawGlobalY = limitY((int) (this.downYGlobal + f));
                int floor = (int) java.lang.Math.floor(r1 / this.mItemHeight);
                this.mCurrDrawFirstItemIndex = floor;
                this.mCurrDrawFirstItemY = -(this.mCurrDrawGlobalY - (floor * this.mItemHeight));
                invalidate();
                onScrollStateChange(1);
            } else if (action == 3) {
                this.downYGlobal = this.mCurrDrawGlobalY;
                stopScrolling();
                this.mHandler.sendMessageDelayed(getMsg(1), 0L);
            }
        } else if (this.mFlagMayPress) {
            click(motionEvent);
        } else {
            android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000);
            int yVelocity = (int) (velocityTracker.getYVelocity() * this.mFriction);
            if (java.lang.Math.abs(yVelocity) > this.mMiniVerlocityFling) {
                this.mScroller.fling(0, this.mCurrDrawGlobalY, 0, -yVelocity, Integer.MIN_VALUE, Integer.MAX_VALUE, limitY(Integer.MIN_VALUE), limitY(Integer.MAX_VALUE));
                invalidate();
                onScrollStateChange(2);
            }
            this.mHandler.sendMessageDelayed(getMsg(1), 0L);
            releaseVelocityTracker();
        }
        return true;
    }

    public void refreshByNewDisplayedValues(java.lang.String[] strArr) {
        int minValue = getMinValue();
        int maxValue = (getMaxValue() - minValue) + 1;
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > maxValue) {
            setDisplayedValues(strArr);
            setMaxValue(length);
        } else {
            setMaxValue(length);
            setDisplayedValues(strArr);
        }
    }

    public void setDisplayedValues(java.lang.String[] strArr) {
        stopScrolling();
        if (strArr == null) {
            throw new java.lang.IllegalArgumentException("newDisplayedValues should not be null.");
        }
        if ((this.mMaxValue - this.mMinValue) + 1 <= strArr.length) {
            updateContent(strArr);
            updateMaxWHOfDisplayedValues(true);
            this.mPrivPickedIndex = this.mMinShowIndex + 0;
            correctPositionByDefaultValue(0, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
            postInvalidate();
            this.mHandlerLayout.sendEmptyMessage(0);
            return;
        }
        throw new java.lang.IllegalArgumentException("mMaxValue - mMinValue + 1 should not be larger than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.mMaxValue - this.mMinValue) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
    }

    public void setDisplayedValues(java.lang.String[] strArr, boolean z) {
        setDisplayedValuesAndPickedIndex(strArr, 0, z);
    }

    public void setDisplayedValuesAndPickedIndex(java.lang.String[] strArr, int i, boolean z) {
        stopScrolling();
        if (strArr == null) {
            throw new java.lang.IllegalArgumentException("newDisplayedValues should not be null.");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("pickedIndex should not be negative, now pickedIndex is " + i);
        }
        updateContent(strArr);
        updateMaxWHOfDisplayedValues(true);
        updateNotWrapYLimit();
        updateValue();
        this.mPrivPickedIndex = this.mMinShowIndex + i;
        correctPositionByDefaultValue(i, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
        if (z) {
            this.mHandler.sendMessageDelayed(getMsg(1), 0L);
            postInvalidate();
        }
    }

    public void setDividerColor(int i) {
        if (this.mDividerColor == i) {
            return;
        }
        this.mDividerColor = i;
        this.mPaintDivider.setColor(i);
        postInvalidate();
    }

    public void setFriction(float f) {
        if (f > 0.0f) {
            android.view.ViewConfiguration.get(getContext());
            this.mFriction = android.view.ViewConfiguration.getScrollFriction() / f;
        } else {
            throw new java.lang.IllegalArgumentException("you should set a a positive float friction, now friction is " + f);
        }
    }

    public void setHintText(java.lang.String str) {
        if (isStringEqual(this.mHintText, str)) {
            return;
        }
        this.mHintText = str;
        this.mTextSizeHintCenterYOffset = getTextCenterYOffset(this.mPaintHint.getFontMetrics());
        this.mWidthOfHintText = getTextWidth(this.mHintText, this.mPaintHint);
        this.mHandlerLayout.sendEmptyMessage(0);
    }

    public void setHintTextColor(int i) {
        if (this.mTextColorHint == i) {
            return;
        }
        this.mTextColorHint = i;
        this.mPaintHint.setColor(i);
        postInvalidate();
    }

    public void setMaxValue(int i) {
        java.lang.String[] strArr = this.mDisplayedValues;
        if (strArr == null) {
            throw new java.lang.NullPointerException("mDisplayedValues should not be null");
        }
        int i2 = this.mMinValue;
        if ((i - i2) + 1 > strArr.length) {
            throw new java.lang.IllegalArgumentException("(maxValue - mMinValue + 1) should not be larger than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.mMinValue) + 1) + " and mDisplayedValues.length is " + this.mDisplayedValues.length);
        }
        this.mMaxValue = i;
        int i3 = this.mMinShowIndex;
        int i4 = (i - i2) + i3;
        this.mMaxShowIndex = i4;
        setMinAndMaxShowIndex(i3, i4);
        updateNotWrapYLimit();
    }

    public void setMinAndMaxShowIndex(int i, int i2) {
        setMinAndMaxShowIndex(i, i2, true);
    }

    public void setMinAndMaxShowIndex(int i, int i2, boolean z) {
        if (i > i2) {
            throw new java.lang.IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
        }
        java.lang.String[] strArr = this.mDisplayedValues;
        if (strArr == null) {
            throw new java.lang.IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i);
        }
        if (i > strArr.length - 1) {
            throw new java.lang.IllegalArgumentException("minShowIndex should not be larger than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.mDisplayedValues.length - 1) + " minShowIndex is " + i);
        }
        if (i2 < 0) {
            throw new java.lang.IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i2);
        }
        if (i2 > strArr.length - 1) {
            throw new java.lang.IllegalArgumentException("maxShowIndex should not be larger than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.mDisplayedValues.length - 1) + " maxShowIndex is " + i2);
        }
        this.mMinShowIndex = i;
        this.mMaxShowIndex = i2;
        if (z) {
            this.mPrivPickedIndex = i + 0;
            correctPositionByDefaultValue(0, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
            postInvalidate();
        }
    }

    public void setMinValue(int i) {
        this.mMinValue = i;
        this.mMinShowIndex = 0;
        updateNotWrapYLimit();
    }

    public void setNormalTextColor(int i) {
        if (this.mTextColorNormal == i) {
            return;
        }
        this.mTextColorNormal = i;
        postInvalidate();
    }

    public void setOnScrollListener(com.aliyun.svideo.common.widget.WheelView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public void setOnValueChangedListener(com.aliyun.svideo.common.widget.WheelView.OnValueChangeListener onValueChangeListener) {
        this.mOnValueChangeListener = onValueChangeListener;
    }

    public void setOnValueChangedListenerRelativeToRaw(com.aliyun.svideo.common.widget.WheelView.OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw) {
        this.mOnValueChangeListenerRaw = onValueChangeListenerRelativeToRaw;
    }

    public void setPickedIndexRelativeToMin(int i) {
        if (i < 0 || i >= getOneRecycleSize()) {
            return;
        }
        this.mPrivPickedIndex = this.mMinShowIndex + i;
        correctPositionByDefaultValue(i, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
        postInvalidate();
    }

    public void setPickedIndexRelativeToRaw(int i) {
        int i2 = this.mMinShowIndex;
        if (i2 <= -1 || i2 > i || i > this.mMaxShowIndex) {
            return;
        }
        this.mPrivPickedIndex = i;
        correctPositionByDefaultValue(i - i2, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
        postInvalidate();
    }

    public void setSelectedTextColor(int i) {
        if (this.mTextColorSelected == i) {
            return;
        }
        this.mTextColorSelected = i;
        postInvalidate();
    }

    public void setValue(int i) {
        int i2 = this.mMinValue;
        if (i < i2) {
            throw new java.lang.IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
        }
        if (i <= this.mMaxValue) {
            setPickedIndexRelativeToRaw(i - i2);
            return;
        }
        throw new java.lang.IllegalArgumentException("should not set a value larger than mMaxValue, value is " + i);
    }

    public void setWrapSelectorWheel(boolean z) {
        if (this.mWrapSelectorWheel != z) {
            if (z) {
                this.mWrapSelectorWheel = z;
                updateWrapStateByContent();
                postInvalidate();
            } else if (this.mScrollState == 0) {
                internalSetWrapToLinear();
            } else {
                this.mPendingWrapToLinear = true;
            }
        }
    }

    public void smoothScrollToValue(int i) {
        smoothScrollToValue(getValue(), i, true);
    }

    public void smoothScrollToValue(int i, int i2) {
        smoothScrollToValue(i, i2, true);
    }

    public void smoothScrollToValue(int i, int i2, boolean z) {
        int i3;
        int refineValueByLimit = refineValueByLimit(i, this.mMinValue, this.mMaxValue, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
        int refineValueByLimit2 = refineValueByLimit(i2, this.mMinValue, this.mMaxValue, this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck);
        if (this.mWrapSelectorWheel && this.mWrapSelectorWheelCheck) {
            i3 = refineValueByLimit2 - refineValueByLimit;
            int oneRecycleSize = getOneRecycleSize() / 2;
            if (i3 < (-oneRecycleSize) || oneRecycleSize < i3) {
                int oneRecycleSize2 = getOneRecycleSize();
                i3 = i3 > 0 ? i3 - oneRecycleSize2 : i3 + oneRecycleSize2;
            }
        } else {
            i3 = refineValueByLimit2 - refineValueByLimit;
        }
        setValue(refineValueByLimit);
        if (refineValueByLimit == refineValueByLimit2) {
            return;
        }
        scrollByIndexSmoothly(i3, z);
    }

    public void smoothScrollToValue(int i, boolean z) {
        smoothScrollToValue(getValue(), i, z);
    }
}
