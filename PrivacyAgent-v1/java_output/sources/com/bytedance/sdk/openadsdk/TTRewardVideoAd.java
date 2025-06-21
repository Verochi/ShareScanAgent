package com.bytedance.sdk.openadsdk;

/* loaded from: classes31.dex */
public interface TTRewardVideoAd extends com.bytedance.sdk.openadsdk.TTClientBidding {
    public static final java.lang.String REWARD_EXTRA_KEY_ERROR_CODE = "reward_extra_key_error_code";
    public static final java.lang.String REWARD_EXTRA_KEY_ERROR_MSG = "reward_extra_key_error_msg";
    public static final java.lang.String REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD = "reward_extra_key_has_video_complete_reward";
    public static final java.lang.String REWARD_EXTRA_KEY_IS_SERVER_VERIFY = "reward_extra_key_is_server_verify";
    public static final java.lang.String REWARD_EXTRA_KEY_REWARD_AMOUNT = "reward_extra_key_reward_amount";
    public static final java.lang.String REWARD_EXTRA_KEY_REWARD_NAME = "reward_extra_key_reward_name";
    public static final java.lang.String REWARD_EXTRA_KEY_REWARD_PROPOSE = "reward_extra_key_reward_propose";
    public static final int REWARD_TYPE_CLICK_LANDING = 4;
    public static final int REWARD_TYPE_DEFAULT = 0;
    public static final int REWARD_TYPE_INTERACT = 1;
    public static final int REWARD_TYPE_PLAYABLE = 3;
    public static final int REWARD_TYPE_VIDEO_COMPLETE = 2;

    /* loaded from: classes22.dex */
    public interface RewardAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onRewardArrived(boolean z, int i, android.os.Bundle bundle);

        @java.lang.Deprecated
        void onRewardVerify(boolean z, int i, java.lang.String str, int i2, java.lang.String str2);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError();
    }

    /* loaded from: classes22.dex */
    public interface RewardAdPlayAgainController {
        public static final java.lang.String KEY_PLAY_AGAIN_ALLOW = "play_again_allow";
        public static final java.lang.String KEY_PLAY_AGAIN_REWARD_AMOUNT = "play_again_reward_amount";
        public static final java.lang.String KEY_PLAY_AGAIN_REWARD_NAME = "play_again_reward_name";

        public interface Callback {
            void onConditionReturn(android.os.Bundle bundle);
        }

        void getPlayAgainCondition(int i, com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback callback);
    }

    long getExpirationTimestamp();

    int getInteractionType();

    java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo();

    int getRewardVideoAdType();

    void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener);

    void setRewardAdInteractionListener(com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener);

    void setRewardPlayAgainController(com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController);

    void setRewardPlayAgainInteractionListener(com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener);

    @java.lang.Deprecated
    void setShowDownLoadBar(boolean z);

    void showRewardVideoAd(android.app.Activity activity);

    void showRewardVideoAd(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTAdConstant.RitScenes ritScenes, java.lang.String str);
}
