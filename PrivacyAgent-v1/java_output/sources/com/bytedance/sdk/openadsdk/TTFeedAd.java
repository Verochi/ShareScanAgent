package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTFeedAd extends com.bytedance.sdk.openadsdk.TTNativeAd {

    public interface CustomizeVideo {
        java.lang.String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i, int i2);
    }

    public interface VideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd);

        void onVideoAdContinuePlay(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd);

        void onVideoAdPaused(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd);

        void onVideoError(int i, int i2);

        void onVideoLoad(com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd);
    }

    public interface VideoRewardListener {
        void onFeedRewardCountDown(int i);
    }

    int getAdViewHeight();

    int getAdViewWidth();

    com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo getCustomVideo();

    double getVideoDuration();

    void setVideoAdListener(com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener videoAdListener);

    void setVideoRewardListener(com.bytedance.sdk.openadsdk.TTFeedAd.VideoRewardListener videoRewardListener);
}
