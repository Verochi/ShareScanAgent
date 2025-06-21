package com.aliyun.svideo.base.widget.pagerecyclerview;

/* loaded from: classes.dex */
public class PageIndicatorView extends android.widget.LinearLayout {
    private int dotSize;
    private java.util.List<android.view.View> indicatorViews;
    private android.content.Context mContext;
    private int mNormalResID;
    private int mSelectedResID;
    private int margins;

    public PageIndicatorView(android.content.Context context) {
        this(context, null);
    }

    public PageIndicatorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.base.R.styleable.PageIndicatorView);
        try {
            this.mSelectedResID = obtainStyledAttributes.getResourceId(com.aliyun.svideo.base.R.styleable.PageIndicatorView_pi_SelectedBackground, android.R.drawable.presence_online);
            this.mNormalResID = obtainStyledAttributes.getResourceId(com.aliyun.svideo.base.R.styleable.PageIndicatorView_pi_NormalBackground, android.R.drawable.presence_invisible);
            this.margins = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.PageIndicatorView_pi_Margin, com.aliyun.svideo.base.widget.pagerecyclerview.DimensionConvert.dip2px(context, 5.0f));
            this.dotSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.PageIndicatorView_pi_DotSize, com.aliyun.svideo.base.widget.pagerecyclerview.DimensionConvert.dip2px(context, 6.0f));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PageIndicatorView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.dotSize = 0;
        this.margins = 0;
        this.mSelectedResID = android.R.drawable.presence_online;
        this.mNormalResID = android.R.drawable.presence_invisible;
        this.indicatorViews = null;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.base.R.styleable.PageIndicatorView);
        try {
            this.mSelectedResID = obtainStyledAttributes.getResourceId(com.aliyun.svideo.base.R.styleable.PageIndicatorView_pi_SelectedBackground, android.R.drawable.presence_online);
            this.mNormalResID = obtainStyledAttributes.getResourceId(com.aliyun.svideo.base.R.styleable.PageIndicatorView_pi_NormalBackground, android.R.drawable.presence_invisible);
            this.margins = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.PageIndicatorView_pi_Margin, com.aliyun.svideo.base.widget.pagerecyclerview.DimensionConvert.dip2px(context, 5.0f));
            this.dotSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.PageIndicatorView_pi_DotSize, com.aliyun.svideo.base.widget.pagerecyclerview.DimensionConvert.dip2px(context, 4.0f));
            obtainStyledAttributes.recycle();
            init(context);
        } catch (java.lang.Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void init(android.content.Context context) {
        this.mContext = context;
        setGravity(17);
        setOrientation(0);
        this.dotSize = com.aliyun.svideo.base.widget.pagerecyclerview.DimensionConvert.dip2px(context, this.dotSize);
        this.margins = com.aliyun.svideo.base.widget.pagerecyclerview.DimensionConvert.dip2px(context, this.margins);
    }

    public void initIndicator(int i) {
        java.util.List<android.view.View> list = this.indicatorViews;
        if (list == null) {
            this.indicatorViews = new java.util.ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        int i2 = this.dotSize;
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(i2, i2);
        int i3 = this.margins;
        layoutParams.setMargins(i3, i3, i3, i3);
        for (int i4 = 0; i4 < i; i4++) {
            android.view.View view = new android.view.View(this.mContext);
            view.setBackgroundResource(this.mNormalResID);
            addView(view, layoutParams);
            this.indicatorViews.add(view);
        }
        if (this.indicatorViews.size() > 0) {
            this.indicatorViews.get(0).setBackgroundResource(this.mSelectedResID);
        }
    }

    public void setSelectedPage(int i) {
        if (this.indicatorViews != null) {
            for (int i2 = 0; i2 < this.indicatorViews.size(); i2++) {
                if (i2 == i) {
                    this.indicatorViews.get(i2).setBackgroundResource(this.mSelectedResID);
                } else {
                    this.indicatorViews.get(i2).setBackgroundResource(this.mNormalResID);
                }
            }
        }
    }
}
