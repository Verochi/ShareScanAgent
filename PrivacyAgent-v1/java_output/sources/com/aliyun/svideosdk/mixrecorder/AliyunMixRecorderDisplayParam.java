package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunMixRecorderDisplayParam {
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mDisplayMode;
    private int mLayoutLevel;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam mLayoutParam;

    @com.aliyun.Visible
    public static final class Builder {
        private int mLayoutLevel;
        private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mDisplayMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
        private com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam mLayoutParam = new com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam.Builder().build();

        public com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam build() {
            return new com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam(this, null);
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam.Builder displayMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            this.mDisplayMode = videoDisplayMode;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam.Builder layoutLevel(int i) {
            this.mLayoutLevel = i;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam.Builder layoutParam(com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam aliyunMixTrackLayoutParam) {
            this.mLayoutParam = aliyunMixTrackLayoutParam;
            return this;
        }
    }

    private AliyunMixRecorderDisplayParam(com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam.Builder builder) {
        this.mDisplayMode = builder.mDisplayMode;
        this.mLayoutLevel = builder.mLayoutLevel;
        this.mLayoutParam = builder.mLayoutParam;
    }

    public /* synthetic */ AliyunMixRecorderDisplayParam(com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam.Builder builder, com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam.a aVar) {
        this(builder);
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getDisplayMode() {
        return this.mDisplayMode;
    }

    public int getLayoutLevel() {
        return this.mLayoutLevel;
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam getLayoutParam() {
        return this.mLayoutParam;
    }
}
