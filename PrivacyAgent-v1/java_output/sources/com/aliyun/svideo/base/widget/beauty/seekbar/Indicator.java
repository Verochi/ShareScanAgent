package com.aliyun.svideo.base.widget.beauty.seekbar;

/* loaded from: classes.dex */
public class Indicator {
    private final android.content.Context mContext;
    private int mGap;
    private android.widget.PopupWindow mIndicator;
    private com.aliyun.svideo.base.widget.beauty.seekbar.ArrowView mIndicatorArrow;
    private android.widget.TextView mIndicatorText;
    private android.view.View mIndicatorView;
    private int[] mLocation = new int[2];
    private final com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar mSeekBar;
    private android.widget.LinearLayout mTopContentView;
    private final int mWindowWidth;
    private com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams p;

    public Indicator(android.content.Context context, com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar, com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams) {
        this.mContext = context;
        this.mSeekBar = indicatorSeekBar;
        this.p = builderParams;
        initIndicator();
        this.mWindowWidth = getWindowWidth();
        this.mGap = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(context, 2.0f);
    }

    private void adjustArrow(float f) {
        int i = this.p.mIndicatorType;
        if (i == 3 || i == 2) {
            return;
        }
        if (getIndicatorScreenX() + f < this.mIndicator.getContentView().getMeasuredWidth() / 2) {
            setMargin(-((int) (((this.mIndicator.getContentView().getMeasuredWidth() / 2) - r0) - f)), -1, -1, -1);
        } else if ((this.mWindowWidth - r0) - f < this.mIndicator.getContentView().getMeasuredWidth() / 2) {
            setMargin((int) ((this.mIndicator.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - r0) - f)), -1, -1, -1);
        } else {
            setMargin(0, 0, 0, 0);
        }
    }

    @androidx.annotation.NonNull
    private android.graphics.drawable.GradientDrawable getGradientDrawable() {
        android.graphics.drawable.GradientDrawable gradientDrawable = this.p.mIndicatorType == 1 ? (android.graphics.drawable.GradientDrawable) this.mContext.getResources().getDrawable(com.aliyun.svideo.base.R.drawable.isb_indicator_square_corners) : (android.graphics.drawable.GradientDrawable) this.mContext.getResources().getDrawable(com.aliyun.svideo.base.R.drawable.isb_indicator_rounded_corners);
        gradientDrawable.setColor(this.p.mIndicatorColor);
        return gradientDrawable;
    }

    private int getIndicatorScreenX() {
        this.mSeekBar.getLocationOnScreen(this.mLocation);
        return this.mLocation[0];
    }

    private int getWindowWidth() {
        android.view.WindowManager windowManager = (android.view.WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private void setMargin(int i, int i2, int i3, int i4) {
        com.aliyun.svideo.base.widget.beauty.seekbar.ArrowView arrowView = this.mIndicatorArrow;
        if (arrowView != null && (arrowView.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams)) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.mIndicatorArrow.getLayoutParams();
            if (i == -1) {
                i = marginLayoutParams.leftMargin;
            }
            if (i2 == -1) {
                i2 = marginLayoutParams.topMargin;
            }
            if (i3 == -1) {
                i3 = marginLayoutParams.rightMargin;
            }
            if (i4 == -1) {
                i4 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mIndicatorArrow.requestLayout();
        }
    }

    public java.lang.String checkHolderText() {
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        int i = builderParams.mSeekBarType;
        if (i == 0 || i == 1) {
            java.lang.String valueOf = java.lang.String.valueOf(builderParams.mMax);
            java.lang.String valueOf2 = java.lang.String.valueOf(this.p.mMin);
            return valueOf.getBytes().length > valueOf2.getBytes().length ? valueOf : valueOf2;
        }
        java.lang.CharSequence[] charSequenceArr = builderParams.mTextArray;
        if (charSequenceArr == null) {
            return "100";
        }
        java.lang.String str = "j";
        for (java.lang.CharSequence charSequence : charSequenceArr) {
            if (charSequence.length() > str.length()) {
                str = ((java.lang.Object) charSequence) + "";
            }
        }
        return str;
    }

    public void forceHide() {
        if (this.mIndicator.isShowing()) {
            this.mIndicator.dismiss();
        }
    }

    public android.view.View getmContentView() {
        return this.mIndicator.getContentView();
    }

    public void hide() {
        if (!this.mIndicator.isShowing() || this.p.mIndicatorStay) {
            return;
        }
        this.mIndicator.dismiss();
    }

    public void initIndicator() {
        android.view.View findViewById;
        com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams = this.p;
        int i = builderParams.mIndicatorType;
        if (i == 3) {
            android.view.View view = builderParams.mIndicatorCustomView;
            if (view != null) {
                this.mIndicatorView = view;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById = this.mIndicatorView.findViewById(identifier)) != null) {
                    if (!(findViewById instanceof android.widget.TextView)) {
                        throw new java.lang.ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                    }
                    android.widget.TextView textView = (android.widget.TextView) findViewById;
                    this.mIndicatorText = textView;
                    textView.setText(java.lang.String.valueOf(this.mSeekBar.getProgress()));
                    this.mIndicatorText.setTextSize(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.px2sp(this.mContext, this.p.mIndicatorTextSize));
                    this.mIndicatorText.setTextColor(this.p.mIndicatorTextColor);
                }
            }
        } else if (2 == i) {
            com.aliyun.svideo.base.widget.beauty.seekbar.CircleBubbleView circleBubbleView = new com.aliyun.svideo.base.widget.beauty.seekbar.CircleBubbleView(this.p, checkHolderText());
            this.mIndicatorView = circleBubbleView;
            circleBubbleView.setProgress(java.lang.String.valueOf(this.mSeekBar.getProgress()));
        } else {
            android.view.View inflate = android.view.View.inflate(this.mContext, com.aliyun.svideo.base.R.layout.aliyun_isb_indicator, null);
            this.mIndicatorView = inflate;
            this.mTopContentView = (android.widget.LinearLayout) inflate.findViewById(com.aliyun.svideo.base.R.id.indicator_container);
            com.aliyun.svideo.base.widget.beauty.seekbar.ArrowView arrowView = (com.aliyun.svideo.base.widget.beauty.seekbar.ArrowView) this.mIndicatorView.findViewById(com.aliyun.svideo.base.R.id.indicator_arrow);
            this.mIndicatorArrow = arrowView;
            arrowView.setColor(this.p.mIndicatorColor);
            android.widget.TextView textView2 = (android.widget.TextView) this.mIndicatorView.findViewById(com.aliyun.svideo.base.R.id.isb_progress);
            this.mIndicatorText = textView2;
            textView2.setText(java.lang.String.valueOf(this.mSeekBar.getProgress()));
            this.mIndicatorText.setTextSize(com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.px2sp(this.mContext, this.p.mIndicatorTextSize));
            this.mIndicatorText.setTextColor(this.p.mIndicatorTextColor);
            this.mTopContentView.setBackground(getGradientDrawable());
            if (this.p.mIndicatorCustomTopContentView != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                android.view.View view2 = this.p.mIndicatorCustomTopContentView;
                if (identifier2 <= 0) {
                    setIndicatorTopContentView(view2);
                } else if (view2.findViewById(identifier2) != null) {
                    setIndicatorTopContentView(view2, identifier2);
                } else {
                    setIndicatorTopContentView(view2);
                }
            }
        }
        android.view.View view3 = this.mIndicatorView;
        if (view3 != null) {
            view3.measure(0, 0);
            this.mIndicator = new android.widget.PopupWindow(this.mIndicatorView, -2, -2, false);
        }
    }

    public boolean isShowing() {
        return this.mIndicator.isShowing();
    }

    public void setCustomIndicator(@androidx.annotation.NonNull android.view.View view) {
        this.mIndicator.setContentView(view);
    }

    public void setGap(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(i);
        sb.append("....");
        sb.append(this.mGap);
        this.mGap = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, i);
    }

    public void setIndicatorTopContentLayout(@androidx.annotation.LayoutRes int i) {
        this.mTopContentView.removeAllViews();
        android.view.View inflate = android.view.View.inflate(this.mContext, i, null);
        inflate.setBackground(getGradientDrawable());
        this.mTopContentView.addView(inflate);
    }

    public void setIndicatorTopContentView(@androidx.annotation.NonNull android.view.View view) {
        this.mTopContentView.removeAllViews();
        view.setBackground(getGradientDrawable());
        this.mTopContentView.addView(view);
    }

    public void setIndicatorTopContentView(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.IdRes int i) {
        android.view.View findViewById = view.findViewById(i);
        if (findViewById == null) {
            throw new java.lang.IllegalArgumentException(" can not find the TextView in indicator topContentView by id: " + i);
        }
        if (!(findViewById instanceof android.widget.TextView)) {
            throw new java.lang.ClassCastException(" the view identified by progressTextViewId can not be cast to TextView. ");
        }
        this.mIndicatorText = (android.widget.TextView) findViewById;
        this.mTopContentView.removeAllViews();
        view.setBackground(getGradientDrawable());
        this.mTopContentView.addView(view);
    }

    public void setProgressTextView(@androidx.annotation.NonNull android.widget.TextView textView) {
        this.mIndicatorText = textView;
    }

    public void show() {
        if (!this.mSeekBar.isEnabled() || this.mSeekBar.getVisibility() != 0 || isShowing() || this.mSeekBar.isCover()) {
            return;
        }
        show(this.mSeekBar.getTouchX());
    }

    public void show(float f) {
        if (!this.mIndicator.isShowing() && this.mSeekBar.isEnabled() && this.mSeekBar.getVisibility() == 0) {
            android.view.View view = this.mIndicatorView;
            if (view instanceof com.aliyun.svideo.base.widget.beauty.seekbar.CircleBubbleView) {
                ((com.aliyun.svideo.base.widget.beauty.seekbar.CircleBubbleView) view).setProgress(this.mSeekBar.getProgressString());
            } else {
                android.widget.TextView textView = this.mIndicatorText;
                if (textView != null) {
                    textView.setText(this.mSeekBar.getProgressString());
                    this.mIndicator.getContentView().measure(0, 0);
                }
            }
            this.mIndicator.showAsDropDown(this.mSeekBar, (int) (f - (r0.getContentView().getMeasuredWidth() / 2.0f)), -(((this.mSeekBar.getMeasuredHeight() + this.mIndicator.getContentView().getMeasuredHeight()) - this.mSeekBar.getPaddingTop()) + this.mGap));
            adjustArrow(f);
        }
    }

    public void update() {
        if (this.mSeekBar.isEnabled() && this.mSeekBar.getVisibility() == 0) {
            if (this.mSeekBar.isCover()) {
                forceHide();
            } else if (this.mSeekBar.getVisibility() == 0) {
                if (isShowing()) {
                    update(this.mSeekBar.getTouchX());
                } else {
                    show(this.mSeekBar.getTouchX());
                }
            }
        }
    }

    public void update(float f) {
        if (this.mSeekBar.isEnabled() && this.mSeekBar.getVisibility() == 0) {
            android.view.View view = this.mIndicatorView;
            if (view instanceof com.aliyun.svideo.base.widget.beauty.seekbar.CircleBubbleView) {
                ((com.aliyun.svideo.base.widget.beauty.seekbar.CircleBubbleView) view).setProgress(this.mSeekBar.getProgressString());
            } else {
                android.widget.TextView textView = this.mIndicatorText;
                if (textView != null) {
                    textView.setText(this.mSeekBar.getProgressString());
                    this.mIndicator.getContentView().measure(0, 0);
                }
            }
            this.mIndicator.update(this.mSeekBar, (int) (f - (r2.getContentView().getMeasuredWidth() / 2)), -(((this.mSeekBar.getMeasuredHeight() + this.mIndicator.getContentView().getMeasuredHeight()) - this.mSeekBar.getPaddingTop()) + this.mGap), -1, -1);
            adjustArrow(f);
        }
    }
}
