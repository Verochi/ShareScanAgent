package com.anythink.splashad.api;

/* loaded from: classes12.dex */
public class ATSplashSkipInfo {
    public static final java.lang.String TAG = "ATSplashSkipInfo";
    com.anythink.splashad.api.ATSplashSkipAdListener mATSplashSkipAdListener;
    long mCallbackInterval;
    android.view.ViewGroup mContainer;
    long mCountDownDuration;
    android.view.View mSkipView;

    public ATSplashSkipInfo(android.view.View view, long j, long j2, com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener) {
        this.mSkipView = view;
        this.mCountDownDuration = j;
        this.mCallbackInterval = j2;
        this.mATSplashSkipAdListener = aTSplashSkipAdListener;
        if (j < 2000) {
            this.mCountDownDuration = 2000L;
        }
        long j3 = this.mCallbackInterval;
        if (j3 <= 0) {
            this.mCallbackInterval = 1000L;
        } else if (j3 < 20) {
            this.mCallbackInterval = 20L;
        }
    }

    public ATSplashSkipInfo(android.view.View view, com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener) {
        this(view, 5000L, 1000L, aTSplashSkipAdListener);
    }

    public boolean canUseCustomSkipView() {
        return this.mSkipView != null;
    }

    public void destroy() {
        android.view.View view = this.mSkipView;
        if (view != null) {
            view.setOnClickListener(null);
            this.mSkipView = null;
        }
        this.mATSplashSkipAdListener = null;
    }

    public com.anythink.splashad.api.ATSplashSkipAdListener getATSplashSkipAdListener() {
        return this.mATSplashSkipAdListener;
    }

    public long getCallbackInterval() {
        return this.mCallbackInterval;
    }

    public android.view.ViewGroup getContainer() {
        return this.mContainer;
    }

    public long getCountDownDuration() {
        return this.mCountDownDuration;
    }

    public android.view.View getSkipView() {
        return this.mSkipView;
    }

    public void setContainer(android.view.ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }
}
