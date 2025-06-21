package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTDrawFeedAd extends com.bytedance.sdk.openadsdk.TTFeedAd {

    public interface DrawVideoListener {
        void onClick();

        void onClickRetry();
    }

    void setCanInterruptVideoPlay(boolean z);

    void setDrawVideoListener(com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener drawVideoListener);

    void setPauseIcon(android.graphics.Bitmap bitmap, int i);
}
