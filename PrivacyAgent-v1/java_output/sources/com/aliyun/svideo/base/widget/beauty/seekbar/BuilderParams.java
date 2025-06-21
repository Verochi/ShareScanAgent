package com.aliyun.svideo.base.widget.beauty.seekbar;

/* loaded from: classes.dex */
class BuilderParams {
    int mBackgroundTrackSize;
    android.content.Context mContext;
    int mIndicatorTextSize;
    int mProgressTrackSize;
    int mTextSize;
    int mThumbSize;
    int mTickSize;
    int mSeekBarType = 0;
    float mMax = 100.0f;
    float mMin = 0.0f;
    float mProgress = 0.0f;
    boolean mClearPadding = false;
    boolean mIsFloatProgress = false;
    boolean mForbidUserSeek = false;
    boolean mTouchToSeek = true;
    int mIndicatorType = 0;
    boolean mShowIndicator = true;
    boolean mIndicatorStay = false;
    int mIndicatorColor = android.graphics.Color.parseColor("#FF4081");
    int mIndicatorTextColor = android.graphics.Color.parseColor("#FFFFFF");
    android.view.View mIndicatorCustomView = null;
    android.view.View mIndicatorCustomTopContentView = null;
    int mBackgroundTrackColor = android.graphics.Color.parseColor("#D7D7D7");
    int mProgressTrackColor = android.graphics.Color.parseColor("#FF4081");
    boolean mTrackRoundedCorners = true;
    int mTickNum = 5;
    int mTickType = 1;
    int mTickColor = android.graphics.Color.parseColor("#FF4081");
    boolean mTickHideBothEnds = false;
    boolean mTickOnThumbLeftHide = false;
    android.graphics.drawable.Drawable mTickDrawable = null;
    int mTextColor = android.graphics.Color.parseColor("#FF4081");
    java.lang.String mLeftEndText = null;
    java.lang.String mRightEndText = null;
    java.lang.CharSequence[] mTextArray = null;
    android.graphics.Typeface mTextTypeface = android.graphics.Typeface.DEFAULT;
    int mThumbColor = android.graphics.Color.parseColor("#FF4081");
    android.graphics.drawable.Drawable mThumbDrawable = null;
    boolean mThumbProgressStay = false;

    public BuilderParams(android.content.Context context) {
        this.mContext = context;
        this.mIndicatorTextSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.sp2px(context, 13.0f);
        this.mBackgroundTrackSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 2.0f);
        this.mProgressTrackSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 2.0f);
        this.mTickSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 10.0f);
        this.mTextSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.sp2px(this.mContext, 13.0f);
        this.mThumbSize = com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorUtils.dp2px(this.mContext, 14.0f);
    }

    public com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams copy(com.aliyun.svideo.base.widget.beauty.seekbar.BuilderParams builderParams) {
        this.mContext = builderParams.mContext;
        this.mSeekBarType = builderParams.mSeekBarType;
        this.mMax = builderParams.mMax;
        this.mMin = builderParams.mMin;
        this.mProgress = builderParams.mProgress;
        this.mClearPadding = builderParams.mClearPadding;
        this.mIsFloatProgress = builderParams.mIsFloatProgress;
        this.mForbidUserSeek = builderParams.mForbidUserSeek;
        this.mTouchToSeek = builderParams.mTouchToSeek;
        this.mIndicatorType = builderParams.mIndicatorType;
        this.mShowIndicator = builderParams.mShowIndicator;
        this.mIndicatorStay = builderParams.mIndicatorStay;
        this.mIndicatorColor = builderParams.mIndicatorColor;
        this.mIndicatorTextColor = builderParams.mIndicatorTextColor;
        this.mIndicatorTextSize = builderParams.mIndicatorTextSize;
        this.mIndicatorCustomView = builderParams.mIndicatorCustomView;
        this.mIndicatorCustomTopContentView = builderParams.mIndicatorCustomTopContentView;
        this.mBackgroundTrackSize = builderParams.mBackgroundTrackSize;
        this.mProgressTrackSize = builderParams.mProgressTrackSize;
        this.mBackgroundTrackColor = builderParams.mBackgroundTrackColor;
        this.mProgressTrackColor = builderParams.mProgressTrackColor;
        this.mTrackRoundedCorners = builderParams.mTrackRoundedCorners;
        this.mTickNum = builderParams.mTickNum;
        this.mTickType = builderParams.mTickType;
        this.mTickSize = builderParams.mTickSize;
        this.mTickColor = builderParams.mTickColor;
        this.mTickHideBothEnds = builderParams.mTickHideBothEnds;
        this.mTickOnThumbLeftHide = builderParams.mTickOnThumbLeftHide;
        this.mTickDrawable = builderParams.mTickDrawable;
        this.mTextSize = builderParams.mTextSize;
        this.mTextColor = builderParams.mTextColor;
        this.mLeftEndText = builderParams.mLeftEndText;
        this.mRightEndText = builderParams.mRightEndText;
        this.mTextArray = builderParams.mTextArray;
        this.mTextTypeface = builderParams.mTextTypeface;
        this.mThumbColor = builderParams.mThumbColor;
        this.mThumbSize = builderParams.mThumbSize;
        this.mThumbDrawable = builderParams.mThumbDrawable;
        this.mThumbProgressStay = builderParams.mThumbProgressStay;
        return this;
    }
}
