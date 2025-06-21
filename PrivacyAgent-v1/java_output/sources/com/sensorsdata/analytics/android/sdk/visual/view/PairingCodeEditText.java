package com.sensorsdata.analytics.android.sdk.visual.view;

/* loaded from: classes19.dex */
public class PairingCodeEditText extends android.widget.EditText implements com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface, android.text.TextWatcher {
    private static final int DEFAULT_CURSOR_DURATION = 400;
    private boolean isCursorShowing;
    private float mBottomLineHeight;
    private int mBottomNormalColor;
    private android.graphics.Paint mBottomNormalPaint;
    private int mBottomSelectedColor;
    private android.graphics.Paint mBottomSelectedPaint;
    private int mCurrentPosition;
    private int mCursorColor;
    private int mCursorDuration;
    private android.graphics.Paint mCursorPaint;
    private java.util.Timer mCursorTimer;
    private java.util.TimerTask mCursorTimerTask;
    private int mCursorWidth;
    private int mEachRectLength;
    private int mFigures;
    private android.graphics.Paint mNormalBackgroundPaint;
    private int mPairingCodeMargin;
    private int mSelectedBackgroundColor;
    private android.graphics.Paint mSelectedBackgroundPaint;
    private com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface.OnPairingCodeChangedListener onCodeChangedListener;

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditText$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.TimerTask {
        public AnonymousClass1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditText.this.isCursorShowing = !r0.isCursorShowing;
            com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditText.this.postInvalidate();
        }
    }

    public PairingCodeEditText(android.content.Context context) {
        this(context, null);
    }

    public PairingCodeEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PairingCodeEditText(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.mEachRectLength = 0;
        initAttrs();
        setBackgroundColor(getColor(android.R.color.transparent));
        initPaint();
        initCursorTimer();
        setFocusableInTouchMode(true);
        setSelection(getText().length());
        requestFocus();
        super.addTextChangedListener(this);
    }

    private int dp2px(int i) {
        return (int) android.util.TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private int getColor(int i) {
        return getContext().getResources().getColor(i);
    }

    public static int getScreenWidth(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    private void initAttrs() {
        this.mFigures = 4;
        this.mPairingCodeMargin = dp2px(10);
        this.mBottomSelectedColor = android.graphics.Color.parseColor("#00c48e");
        this.mBottomNormalColor = getColor(android.R.color.darker_gray);
        this.mBottomLineHeight = dp2px(2);
        this.mSelectedBackgroundColor = getColor(android.R.color.transparent);
        this.mCursorWidth = dp2px(1);
        this.mCursorColor = android.graphics.Color.parseColor("#00c48e");
        this.mCursorDuration = 400;
        setLayoutDirection(0);
    }

    private void initCursorTimer() {
        this.mCursorTimerTask = new com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditText.AnonymousClass1();
        this.mCursorTimer = new java.util.Timer();
    }

    private void initPaint() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mSelectedBackgroundPaint = paint;
        paint.setColor(this.mSelectedBackgroundColor);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.mNormalBackgroundPaint = paint2;
        paint2.setColor(getColor(android.R.color.transparent));
        this.mBottomSelectedPaint = new android.graphics.Paint();
        this.mBottomNormalPaint = new android.graphics.Paint();
        this.mBottomSelectedPaint.setColor(this.mBottomSelectedColor);
        this.mBottomNormalPaint.setColor(this.mBottomNormalColor);
        this.mBottomSelectedPaint.setStrokeWidth(this.mBottomLineHeight);
        this.mBottomNormalPaint.setStrokeWidth(this.mBottomLineHeight);
        android.graphics.Paint paint3 = new android.graphics.Paint();
        this.mCursorPaint = paint3;
        paint3.setAntiAlias(true);
        this.mCursorPaint.setColor(this.mCursorColor);
        this.mCursorPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        this.mCursorPaint.setStrokeWidth(this.mCursorWidth);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
        if (getText().length() != this.mFigures) {
            if (getText().length() > this.mFigures) {
                getText().delete(this.mFigures, getText().length());
            }
        } else {
            com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener = this.onCodeChangedListener;
            if (onPairingCodeChangedListener != null) {
                onPairingCodeChangedListener.onInputCompleted(getText());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
    }

    public void clearText() {
        getText().delete(0, getText().length());
    }

    public void hiddenKeyBord() {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mCursorTimer.scheduleAtFixedRate(this.mCursorTimerTask, 0L, this.mCursorDuration);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCursorTimer.cancel();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        this.mCurrentPosition = getText().length();
        int paddingLeft = (this.mEachRectLength - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i = 0; i < this.mFigures; i++) {
            canvas.save();
            int i2 = (paddingLeft * i) + (this.mPairingCodeMargin * i);
            int i3 = paddingLeft + i2;
            if (i == this.mCurrentPosition) {
                canvas.drawRect(i2, 0.0f, i3, measuredHeight, this.mSelectedBackgroundPaint);
            } else {
                canvas.drawRect(i2, 0.0f, i3, measuredHeight, this.mNormalBackgroundPaint);
            }
            canvas.restore();
        }
        java.lang.String obj = getText().toString();
        for (int i4 = 0; i4 < obj.length(); i4++) {
            canvas.save();
            float f = (paddingLeft * i4) + (this.mPairingCodeMargin * i4) + (paddingLeft / 2);
            android.text.TextPaint paint = getPaint();
            paint.setTextAlign(android.graphics.Paint.Align.CENTER);
            paint.setColor(getCurrentTextColor());
            android.graphics.Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f2 = measuredHeight - fontMetrics.bottom;
            float f3 = fontMetrics.top;
            canvas.drawText(java.lang.String.valueOf(obj.charAt(i4)), f, ((f2 + f3) / 2.0f) - f3, paint);
            canvas.restore();
        }
        for (int i5 = 0; i5 < this.mFigures; i5++) {
            canvas.save();
            float f4 = measuredHeight - (this.mBottomLineHeight / 2.0f);
            int i6 = (paddingLeft * i5) + (this.mPairingCodeMargin * i5);
            int i7 = paddingLeft + i6;
            if (i5 < this.mCurrentPosition) {
                canvas.drawLine(i6, f4, i7, f4, this.mBottomSelectedPaint);
            } else {
                canvas.drawLine(i6, f4, i7, f4, this.mBottomNormalPaint);
            }
            canvas.restore();
        }
        boolean isCursorVisible = isCursorVisible();
        if (this.isCursorShowing || !isCursorVisible || this.mCurrentPosition >= this.mFigures || !hasFocus()) {
            return;
        }
        canvas.save();
        int i8 = (this.mCurrentPosition * (this.mPairingCodeMargin + paddingLeft)) + (paddingLeft / 2);
        float f5 = i8;
        canvas.drawLine(f5, measuredHeight / 4, f5, measuredHeight - r1, this.mCursorPaint);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int size = android.view.View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = getScreenWidth(getContext());
        }
        int i3 = this.mPairingCodeMargin;
        int i4 = this.mFigures;
        this.mEachRectLength = (size - (i3 * (i4 - 1))) / i4;
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            size2 = this.mEachRectLength;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
        com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener = this.onCodeChangedListener;
        if (onPairingCodeChangedListener != null) {
            onPairingCodeChangedListener.onPairingCodeChanged(getText(), i, i2, i3);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface
    public void setBottomLineHeight(int i) {
        this.mBottomLineHeight = i;
        postInvalidate();
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface
    public void setBottomNormalColor(int i) {
        this.mBottomSelectedColor = getColor(i);
        postInvalidate();
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface
    public void setBottomSelectedColor(int i) {
        this.mBottomSelectedColor = getColor(i);
        postInvalidate();
    }

    @Override // android.widget.TextView
    public final void setCursorVisible(boolean z) {
        super.setCursorVisible(z);
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface
    public void setFigures(int i) {
        this.mFigures = i;
        postInvalidate();
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface
    public void setOnPairingCodeChangedListener(com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener) {
        this.onCodeChangedListener = onPairingCodeChangedListener;
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface
    public void setPairingCodeMargin(int i) {
        this.mPairingCodeMargin = i;
        postInvalidate();
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface
    public void setSelectedBackgroundColor(int i) {
        this.mSelectedBackgroundColor = getColor(i);
        postInvalidate();
    }

    public void showKeyBoard(android.content.Context context) {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 2);
        }
    }
}
