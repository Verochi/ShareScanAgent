package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunMixBorderParam {
    private int mBorderColor;
    private int mBorderWidth;
    private float mCornerRadius;

    @com.aliyun.Visible
    public static final class Builder {
        private int mBorderColor;
        private int mBorderWidth;
        private float mCornerRadius;
        private int mTrackId;

        public com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam.Builder borderColor(int i) {
            this.mBorderColor = i;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam.Builder borderWidth(int i) {
            this.mBorderWidth = i;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam build() {
            return new com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam(this);
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam.Builder cornerRadius(float f) {
            this.mCornerRadius = f;
            return this;
        }
    }

    public AliyunMixBorderParam(com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam.Builder builder) {
        this.mBorderWidth = builder.mBorderWidth;
        this.mBorderColor = builder.mBorderColor;
        this.mCornerRadius = builder.mCornerRadius;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }
}
