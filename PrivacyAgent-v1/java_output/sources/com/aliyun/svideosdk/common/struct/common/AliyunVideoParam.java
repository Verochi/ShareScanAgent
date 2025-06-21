package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunVideoParam implements java.io.Serializable {
    private static final long serialVersionUID = 5802703421083731345L;
    private int mBitrate;
    private int mFrameRate;
    private int mGop;
    private int mOutputHeight;
    private int mOutputWidth;
    private int mCrf = 23;
    private float mScaleRate = 1.0f;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality mVideoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mScaleMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;

    @com.aliyun.Visible
    public static class Builder {
        private com.aliyun.svideosdk.common.struct.common.AliyunVideoParam mVideoParam = new com.aliyun.svideosdk.common.struct.common.AliyunVideoParam();

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder bitrate(int i) {
            this.mVideoParam.setBitrate(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam build() {
            return this.mVideoParam;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder crf(int i) {
            this.mVideoParam.setCrf(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder frameRate(int i) {
            this.mVideoParam.setFrameRate(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder gop(int i) {
            this.mVideoParam.setGop(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder outputHeight(int i) {
            this.mVideoParam.setOutputHeight(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder outputWidth(int i) {
            this.mVideoParam.setOutputWidth(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder scaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            this.mVideoParam.setScaleMode(videoDisplayMode);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder scaleRate(float f) {
            this.mVideoParam.setScaleRate(f);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder videoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
            this.mVideoParam.setVideoCodec(videoCodecs);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder videoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
            this.mVideoParam.setVideoQuality(videoQuality);
            return this;
        }
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getCrf() {
        return this.mCrf;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getScaleMode() {
        com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode = this.mScaleMode;
        return videoDisplayMode == null ? com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL : videoDisplayMode;
    }

    public float getScaleRate() {
        return this.mScaleRate;
    }

    public com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getVideoQuality() {
        com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality = this.mVideoQuality;
        return videoQuality == null ? com.aliyun.svideosdk.common.struct.common.VideoQuality.HD : videoQuality;
    }

    public void setBitrate(int i) {
        this.mBitrate = i;
    }

    public void setCrf(int i) {
        this.mCrf = i;
    }

    public void setFrameRate(int i) {
        if (i > 120) {
            i = 120;
        } else if (i <= 0) {
            i = 1;
        }
        this.mFrameRate = i;
    }

    public void setGop(int i) {
        this.mGop = i;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setScaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        this.mScaleMode = videoDisplayMode;
    }

    public void setScaleRate(float f) {
        this.mScaleRate = f;
    }

    public void setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
        this.mVideoCodec = videoCodecs;
    }

    public void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        this.mVideoQuality = videoQuality;
    }
}
