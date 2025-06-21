package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunMixTrackLayoutParam {
    private float mCenterX;
    private float mCenterY;
    private float mHeightRatio;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam mMixBorderParam;
    private float mWidthRatio;

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam mMixBorderParam;
        private float mCenterX = 0.5f;
        private float mCenterY = 0.5f;
        private float mWidthRatio = 1.0f;
        private float mHeightRatio = 1.0f;

        public com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.Builder borderParam(com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam aliyunMixBorderParam) {
            this.mMixBorderParam = aliyunMixBorderParam;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam build() {
            return new com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam(this, null);
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.Builder centerX(float f) {
            if (f < 0.0f) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid centerX value " + f + ", centerX value has must be between 0 and 1!");
                f = 0.0f;
            } else if (f > 1.0f) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid centerX value " + f + ", centerX value has must be between 0 and 1!");
                f = 1.0f;
            }
            this.mCenterX = f;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.Builder centerY(float f) {
            if (f < 0.0f) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid centerY value " + f + ", centerY value has must be between 0 and 1!");
                f = 0.0f;
            } else if (f > 1.0f) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid centerY value " + f + ", centerY value has must be between 0 and 1!");
                f = 1.0f;
            }
            this.mCenterY = f;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.Builder heightRatio(float f) {
            if (f > 1.0f) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Height ratio must be larger than 0 and less than 1!");
                this.mHeightRatio = 1.0f;
            } else if (f > 0.0f) {
                this.mHeightRatio = f;
            } else {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Height ratio must be larger than 0 and less than 1!");
            }
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.Builder widthRatio(float f) {
            if (f > 1.0f) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Width ratio must be larger than 0 and less than 1!");
                this.mWidthRatio = 1.0f;
            } else if (f > 0.0f) {
                this.mWidthRatio = f;
            } else {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Width ratio must be larger than 0 and less than 1!");
            }
            return this;
        }
    }

    private AliyunMixTrackLayoutParam(com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.Builder builder) {
        this.mCenterX = builder.mCenterX;
        this.mCenterY = builder.mCenterY;
        this.mWidthRatio = builder.mWidthRatio;
        this.mHeightRatio = builder.mHeightRatio;
        this.mMixBorderParam = builder.mMixBorderParam;
    }

    public /* synthetic */ AliyunMixTrackLayoutParam(com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.Builder builder, com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.a aVar) {
        this(builder);
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    public float getHeightRatio() {
        return this.mHeightRatio;
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam getMixBorderParam() {
        return this.mMixBorderParam;
    }

    public float getWidthRatio() {
        return this.mWidthRatio;
    }
}
