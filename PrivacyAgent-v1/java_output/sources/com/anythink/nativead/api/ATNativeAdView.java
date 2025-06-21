package com.anythink.nativead.api;

/* loaded from: classes12.dex */
public class ATNativeAdView extends android.widget.FrameLayout {
    private static final java.lang.String TAG = "ATNativeAdView";
    android.view.View mAdView;
    com.anythink.nativead.api.NativeAd.ImpressionEventListener mImpressionEventListener;
    boolean mIsInWindow;
    com.anythink.nativead.api.NativeAd mNativeAd;
    int mNativeAdId;

    public ATNativeAdView(android.content.Context context) {
        super(context);
    }

    public ATNativeAdView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATNativeAdView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void callbackImpression() {
        com.anythink.nativead.api.NativeAd.ImpressionEventListener impressionEventListener = this.mImpressionEventListener;
        if (impressionEventListener != null) {
            impressionEventListener.onImpression();
        }
    }

    public synchronized void attachNativeAd(com.anythink.nativead.api.NativeAd nativeAd) {
        this.mNativeAd = nativeAd;
    }

    public synchronized void clear() {
        com.anythink.nativead.api.NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            try {
                nativeAd.clear(this);
            } catch (java.lang.Throwable unused) {
            }
            this.mNativeAd = null;
        }
    }

    public void clearImpressionListener(int i) {
        if (this.mNativeAdId == i) {
            this.mImpressionEventListener = null;
        }
    }

    public void destory() {
        this.mImpressionEventListener = null;
    }

    public boolean isAttachInWindow() {
        return this.mIsInWindow;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsInWindow = true;
        if (getVisibility() == 0) {
            callbackImpression();
        }
        isHardwareAccelerated();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsInWindow = false;
    }

    @Override // android.view.View
    public void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0 && getVisibility() == 0) {
            callbackImpression();
        }
    }

    public void renderView(int i, android.view.View view, com.anythink.nativead.api.NativeAd.ImpressionEventListener impressionEventListener) {
        android.view.View view2 = this.mAdView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mAdView = view;
        this.mNativeAdId = i;
        this.mImpressionEventListener = impressionEventListener;
        addView(view);
        if (this.mIsInWindow && getVisibility() == 0) {
            callbackImpression();
        }
    }
}
