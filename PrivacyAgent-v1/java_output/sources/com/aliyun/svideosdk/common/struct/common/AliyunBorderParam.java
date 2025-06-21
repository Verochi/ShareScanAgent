package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunBorderParam {
    private int mBorderColor;
    private int mBorderWidth;
    private float mCorner;
    private float mCornerRadius;

    @com.aliyun.Visible
    public static final class Builder {
        private int mBorderColor;
        private int mBorderWidth;
        private float mCorner;
        private float mCornerRadius = -1.0f;

        public com.aliyun.svideosdk.common.struct.common.AliyunBorderParam.Builder borderColor(int i) {
            this.mBorderColor = i;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunBorderParam.Builder borderWidth(int i) {
            this.mBorderWidth = i;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunBorderParam build() {
            return new com.aliyun.svideosdk.common.struct.common.AliyunBorderParam(this);
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunBorderParam.Builder corner(float f) {
            this.mCorner = f;
            return this;
        }

        @java.lang.Deprecated
        public com.aliyun.svideosdk.common.struct.common.AliyunBorderParam.Builder cornerRadius(float f) {
            this.mCornerRadius = f;
            return this;
        }
    }

    public AliyunBorderParam(com.aliyun.svideosdk.common.struct.common.AliyunBorderParam.Builder builder) {
        this.mBorderWidth = builder.mBorderWidth;
        this.mBorderColor = builder.mBorderColor;
        this.mCornerRadius = builder.mCornerRadius;
        this.mCorner = builder.mCorner;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public float getCorner() {
        return this.mCorner;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }
}
