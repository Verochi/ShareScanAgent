package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunLayoutParam {
    private final float centerX;
    private final float centerY;
    private final com.aliyun.svideosdk.common.struct.common.VideoDisplayMode displayMode;
    private final float heightRatio;
    private final int layoutLevel;
    private final float widthRatio;

    @com.aliyun.Visible
    public static final class Builder {
        private float centerX;
        private float centerY;
        private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode displayMode;
        private float heightRatio;
        private int layoutLevel;
        private float widthRatio;

        private Builder() {
            this.centerX = 0.5f;
            this.centerY = 0.5f;
            this.widthRatio = 1.0f;
            this.heightRatio = 1.0f;
            this.layoutLevel = 1;
            this.displayMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
        }

        public /* synthetic */ Builder(com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.AnonymousClass1 anonymousClass1) {
            this();
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam build() {
            return new com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam(this, null);
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder centerX(float f) {
            if (f >= 0.0f && f <= 1.0f) {
                this.centerX = f;
                return this;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("centerX ");
            sb.append(f);
            sb.append(" is invalid");
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder centerY(float f) {
            if (f >= 0.0f && f <= 1.0f) {
                this.centerY = f;
                return this;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("centerY ");
            sb.append(f);
            sb.append(" is invalid");
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder displayMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            if (videoDisplayMode == null) {
                return this;
            }
            this.displayMode = videoDisplayMode;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder heightRatio(float f) {
            if (f >= 0.0f && f <= 1.0f) {
                this.heightRatio = f;
                return this;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("heightRatio ");
            sb.append(f);
            sb.append(" is invalid");
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder layoutLevel(int i) {
            this.layoutLevel = i;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder widthRatio(float f) {
            if (f >= 0.0f && f <= 1.0f) {
                this.widthRatio = f;
                return this;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("widthRatio ");
            sb.append(f);
            sb.append(" is invalid");
            return this;
        }
    }

    private AliyunLayoutParam(com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder builder) {
        this.centerX = builder.centerX;
        this.centerY = builder.centerY;
        this.widthRatio = builder.widthRatio;
        this.heightRatio = builder.heightRatio;
        this.layoutLevel = builder.layoutLevel;
        this.displayMode = builder.displayMode;
    }

    public /* synthetic */ AliyunLayoutParam(com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder builder, com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder builder() {
        return new com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam.Builder(null);
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getDisplayMode() {
        return this.displayMode;
    }

    public float getHeightRatio() {
        return this.heightRatio;
    }

    public int getLayoutLevel() {
        return this.layoutLevel;
    }

    public float getWidthRatio() {
        return this.widthRatio;
    }
}
