package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class TanxAdSlot implements com.alimm.tanx.core.utils.NotConfused, java.io.Serializable {
    private int adCount;
    private int adType;
    private boolean cacheUnderWifi;
    private boolean clickAdClose;
    private int expressViewWidth;
    private java.lang.String ext;
    private boolean feedBackDialog;
    private int height;
    private boolean isExpressRender;
    private com.alimm.tanx.core.request.TanxAdLoadType loadType;
    private java.lang.String mediaExtra;
    private java.lang.String mediaUid;
    private java.lang.String[] nativeTemplateId;
    private boolean notAutoPlay;
    private int orientation;
    private java.lang.String pid;
    private boolean playUnderWifi;
    private java.lang.String reqId;
    private com.alimm.tanx.core.ad.bean.RewardParam rewardParam;
    private java.lang.String userId;
    private com.alimm.tanx.core.ad.ad.reward.model.VideoParam videoParam;
    private int width;

    public static class Builder implements com.alimm.tanx.core.utils.NotConfused {
        private int adCount;
        private int adType;
        private boolean cacheUnderWifi;
        private int expressViewWidth;
        private int height;
        private boolean isExpressRender;
        private java.lang.String mediaUid;
        private java.lang.String[] nativeTemplateId;
        private boolean notAutoPlay;
        private java.lang.String pid;
        private boolean playUnderWifi;
        private com.alimm.tanx.core.ad.bean.RewardParam rewardParam;
        private int width;
        private boolean feedBackDialog = true;
        private com.alimm.tanx.core.ad.ad.reward.model.VideoParam videoParam = new com.alimm.tanx.core.ad.ad.reward.model.VideoParam();
        private java.lang.String userId = "defaultUser";
        private java.lang.String mediaExtra = "";
        private int orientation = 1;
        private boolean clickAdClose = false;
        private com.alimm.tanx.core.request.TanxAdLoadType loadType = com.alimm.tanx.core.request.TanxAdLoadType.PRELOAD;

        public Builder() {
            this.adCount = 1;
            this.adCount = 1;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder adCount(int i) {
            this.adCount = i;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder adSize(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        @java.lang.Deprecated
        public com.alimm.tanx.core.request.TanxAdSlot.Builder adType(int i) {
            this.adType = i;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot build() {
            return new com.alimm.tanx.core.request.TanxAdSlot(this);
        }

        public java.lang.String getMediaUid() {
            return this.mediaUid;
        }

        public com.alimm.tanx.core.ad.bean.RewardParam getRewardParam() {
            return this.rewardParam;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder isExpressRender(boolean z) {
            this.isExpressRender = z;
            return this;
        }

        @java.lang.Deprecated
        public com.alimm.tanx.core.request.TanxAdSlot.Builder nativeTemplateId(java.lang.String[] strArr) {
            this.nativeTemplateId = strArr;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder pid(java.lang.String str) {
            this.pid = str;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setCacheUnderWifi(boolean z) {
            this.cacheUnderWifi = z;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setClickAdClose(boolean z) {
            this.clickAdClose = z;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setExpressViewAcceptedSize(int i) {
            this.expressViewWidth = i;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setFeedBackDialog(boolean z) {
            this.feedBackDialog = z;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setLoadType(com.alimm.tanx.core.request.TanxAdLoadType tanxAdLoadType) {
            this.loadType = tanxAdLoadType;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setMediaExtra(java.lang.String str) {
            this.mediaExtra = str;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setMediaUid(java.lang.String str) {
            this.mediaUid = str;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setNotAutoPlay(boolean z) {
            this.notAutoPlay = z;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setPlayUnderWifi(boolean z) {
            this.playUnderWifi = z;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setRewardParam(com.alimm.tanx.core.ad.bean.RewardParam rewardParam) {
            this.rewardParam = rewardParam;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setUserId(java.lang.String str) {
            this.userId = str;
            return this;
        }

        public com.alimm.tanx.core.request.TanxAdSlot.Builder setVideoParam(com.alimm.tanx.core.ad.ad.reward.model.VideoParam videoParam) {
            this.videoParam = videoParam;
            return this;
        }
    }

    public TanxAdSlot() {
        this.userId = "defaultUser";
        this.mediaExtra = "";
        this.orientation = 1;
        this.feedBackDialog = true;
        this.clickAdClose = false;
        this.adCount = 1;
    }

    public TanxAdSlot(com.alimm.tanx.core.request.TanxAdSlot.Builder builder) {
        this.adCount = 1;
        this.userId = "defaultUser";
        this.mediaExtra = "";
        this.orientation = 1;
        this.feedBackDialog = true;
        this.clickAdClose = false;
        this.adType = builder.adType;
        this.pid = builder.pid;
        this.nativeTemplateId = builder.nativeTemplateId;
        this.adCount = java.lang.Math.max(builder.adCount, 1);
        this.width = builder.width;
        this.height = builder.height;
        this.reqId = uuid();
        this.expressViewWidth = builder.expressViewWidth;
        this.cacheUnderWifi = builder.cacheUnderWifi;
        this.playUnderWifi = builder.playUnderWifi;
        this.notAutoPlay = builder.notAutoPlay;
        this.videoParam = builder.videoParam;
        this.feedBackDialog = builder.feedBackDialog;
        this.clickAdClose = builder.clickAdClose;
        this.mediaUid = builder.mediaUid;
        this.loadType = builder.loadType;
        this.rewardParam = builder.rewardParam;
    }

    private void setAdSlot(int i) {
        setAdType(i);
        if (i == 1) {
            setNativeTemplateId(com.alimm.tanx.core.constant.TanxAdTemplateId.SPLASH_TEMPLATE);
            return;
        }
        if (i == 2) {
            setNativeTemplateId(com.alimm.tanx.core.constant.TanxAdTemplateId.FEED_TEMPLATE);
            return;
        }
        if (i == 3) {
            setNativeTemplateId(com.alimm.tanx.core.constant.TanxAdTemplateId.REWARD_VIDEO_TEMPLATE);
        } else if (i == 4) {
            setNativeTemplateId(com.alimm.tanx.core.constant.TanxAdTemplateId.REWARD_TEMPLATE);
        } else {
            if (i != 5) {
                return;
            }
            setNativeTemplateId(com.alimm.tanx.core.constant.TanxAdTemplateId.TABLE_SCREEN_TEMPLATE);
        }
    }

    private java.lang.String uuid() {
        return java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + (java.lang.System.currentTimeMillis() / 1000);
    }

    public void addAdSlot(int i) {
        setAdSlot(i);
        setExpressRender(false);
    }

    public void addTemplateAdSlot(int i) {
        setAdSlot(i);
        setExpressRender(true);
    }

    public int getAdCount() {
        return this.adCount;
    }

    public int getAdType() {
        return this.adType;
    }

    public int getExpressViewWidth() {
        return this.expressViewWidth;
    }

    public java.lang.String getExt() {
        return this.ext;
    }

    public int getHeight() {
        return this.height;
    }

    public com.alimm.tanx.core.request.TanxAdLoadType getLoadType() {
        return this.loadType;
    }

    public java.lang.String getMediaExtra() {
        return this.mediaExtra;
    }

    public java.lang.String getMediaUid() {
        return this.mediaUid;
    }

    public java.lang.String[] getNativeTemplateId() {
        return this.nativeTemplateId;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public java.lang.String getPid() {
        return this.pid;
    }

    public java.lang.String getReqId() {
        return this.reqId;
    }

    public com.alimm.tanx.core.ad.bean.RewardParam getRewardParam() {
        return this.rewardParam;
    }

    public java.lang.String getUserId() {
        return this.userId;
    }

    public com.alimm.tanx.core.ad.ad.reward.model.VideoParam getVideoParam() {
        return this.videoParam;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isCacheUnderWifi() {
        return this.cacheUnderWifi;
    }

    public boolean isClickAdClose() {
        return this.clickAdClose;
    }

    public boolean isExpressRender() {
        return this.isExpressRender;
    }

    public boolean isFeedBackDialog() {
        return this.feedBackDialog;
    }

    public boolean isNotAutoPlay() {
        return this.notAutoPlay;
    }

    public boolean isPlayUnderWifi() {
        return this.playUnderWifi;
    }

    public void setAdCount(int i) {
        this.adCount = i;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setCacheUnderWifi(boolean z) {
        this.cacheUnderWifi = z;
    }

    public void setClickAdClose(boolean z) {
        this.clickAdClose = z;
    }

    public void setExpressRender(boolean z) {
        this.isExpressRender = z;
    }

    public void setExpressViewWidth(int i) {
        this.expressViewWidth = i;
    }

    public void setExt(java.lang.String str) {
        this.ext = str;
    }

    public void setFeedBackDialog(boolean z) {
        this.feedBackDialog = z;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLoadType(com.alimm.tanx.core.request.TanxAdLoadType tanxAdLoadType) {
        this.loadType = tanxAdLoadType;
    }

    public void setMediaExtra(java.lang.String str) {
        this.mediaExtra = str;
    }

    public void setMediaUid(java.lang.String str) {
        this.mediaUid = str;
    }

    public void setNativeTemplateId(java.lang.String[] strArr) {
        this.nativeTemplateId = strArr;
    }

    public void setNotAutoPlay(boolean z) {
        this.notAutoPlay = z;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public void setPid(java.lang.String str) {
        this.pid = str;
    }

    public void setPlayUnderWifi(boolean z) {
        this.playUnderWifi = z;
    }

    public void setReqId(java.lang.String str) {
        this.reqId = str;
    }

    public void setRewardParam(com.alimm.tanx.core.ad.bean.RewardParam rewardParam) {
        this.rewardParam = rewardParam;
    }

    public void setUserId(java.lang.String str) {
        this.userId = str;
    }

    public void setVideoParam(com.alimm.tanx.core.ad.ad.reward.model.VideoParam videoParam) {
        this.videoParam = videoParam;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
