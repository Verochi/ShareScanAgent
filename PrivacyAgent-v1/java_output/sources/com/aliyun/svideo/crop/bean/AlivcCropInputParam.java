package com.aliyun.svideo.crop.bean;

/* loaded from: classes.dex */
public class AlivcCropInputParam {
    public static final java.lang.String INTENT_KEY_ACTION = "mAction";
    public static final java.lang.String INTENT_KEY_CODECS = "mVideoCodecs";
    public static final java.lang.String INTENT_KEY_CROP_MODE = "mCropMode";
    public static final java.lang.String INTENT_KEY_FRAME_RATE = "mFrameRate";
    public static final java.lang.String INTENT_KEY_GOP = "mGop";
    public static final java.lang.String INTENT_KEY_MIN_DURATION = "mMinCropDuration";
    public static final java.lang.String INTENT_KEY_PATH = "mPath";
    public static final java.lang.String INTENT_KEY_QUALITY = "mQuality";
    public static final java.lang.String INTENT_KEY_RATIO_MODE = "mRatioMode";
    public static final java.lang.String INTENT_KEY_RESOLUTION_MODE = "mResolutionMode";
    public static final java.lang.String INTENT_KEY_USE_GPU = "isUseGPU";
    public static final int RATIO_MODE_1_1 = 1;
    public static final int RATIO_MODE_3_4 = 0;
    public static final int RATIO_MODE_9_16 = 2;
    public static final int RATIO_MODE_ORIGINAL = 3;
    public static final int RESOLUTION_360P = 0;
    public static final int RESOLUTION_480P = 1;
    public static final int RESOLUTION_540P = 2;
    public static final int RESOLUTION_720P = 3;
    private java.lang.String mPath;
    private int mResolutionMode = 3;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mCropMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality mQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodecs = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
    private int mGop = 250;
    private int mFrameRate = 30;
    private int mRatioMode = 2;
    private int mAction = 0;
    private int mMinCropDuration = 2000;
    private boolean isUseGPU = false;

    public static class Builder {
        com.aliyun.svideo.crop.bean.AlivcCropInputParam mParam = new com.aliyun.svideo.crop.bean.AlivcCropInputParam();

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam build() {
            return this.mParam;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setAction(int i) {
            this.mParam.mAction = i;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setCropMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            this.mParam.mCropMode = videoDisplayMode;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setFrameRate(int i) {
            this.mParam.mFrameRate = i;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setGop(int i) {
            this.mParam.mGop = i;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setMinCropDuration(int i) {
            this.mParam.mMinCropDuration = i;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setPath(java.lang.String str) {
            this.mParam.mPath = str;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
            this.mParam.mQuality = videoQuality;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setRatioMode(int i) {
            this.mParam.mRatioMode = i;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setResolutionMode(int i) {
            this.mParam.mResolutionMode = i;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setUseGPU(boolean z) {
            this.mParam.isUseGPU = z;
            return this;
        }

        public com.aliyun.svideo.crop.bean.AlivcCropInputParam.Builder setVideoCodecs(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
            this.mParam.mVideoCodecs = videoCodecs;
            return this;
        }
    }

    public int getAction() {
        return this.mAction;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getCropMode() {
        return this.mCropMode;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getMinCropDuration() {
        return this.mMinCropDuration;
    }

    public java.lang.String getPath() {
        return this.mPath;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getQuality() {
        return this.mQuality;
    }

    public int getRatioMode() {
        return this.mRatioMode;
    }

    public int getResolutionMode() {
        return this.mResolutionMode;
    }

    public com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getVideoCodecs() {
        return this.mVideoCodecs;
    }

    public boolean isUseGPU() {
        return this.isUseGPU;
    }

    public void setAction(int i) {
        this.mAction = i;
    }

    public void setCropDuration(int i) {
        this.mMinCropDuration = i;
    }

    public void setCropMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        this.mCropMode = videoDisplayMode;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setGop(int i) {
        this.mGop = i;
    }

    public void setPath(java.lang.String str) {
        this.mPath = str;
    }

    public void setQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        this.mQuality = videoQuality;
    }

    public void setRatioMode(int i) {
        this.mRatioMode = i;
    }

    public void setResolutionMode(int i) {
        this.mResolutionMode = i;
    }

    public void setUseGPU(boolean z) {
        this.isUseGPU = z;
    }

    public void setVideoCodecs(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
        this.mVideoCodecs = videoCodecs;
    }
}
