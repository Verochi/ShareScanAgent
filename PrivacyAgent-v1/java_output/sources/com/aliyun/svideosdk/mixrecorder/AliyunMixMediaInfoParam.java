package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunMixMediaInfoParam {
    private com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam mMixDisplayParam;
    private java.lang.String mMixVideoFilePath;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam mRecordDisplayParam;
    private long mStreamEndTimeMills;
    private long mStreamStartTimeMills;

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam mMixDisplayParam;
        private java.lang.String mMixVideoFilePath;
        private com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam mRecordDisplayParam;
        private long mStreamEndTimeMills;
        private long mStreamStartTimeMills;

        public com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam build() {
            return new com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam(this, null);
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam.Builder mixDisplayParam(com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam aliyunMixRecorderDisplayParam) {
            this.mMixDisplayParam = aliyunMixRecorderDisplayParam;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam.Builder mixVideoFilePath(java.lang.String str) {
            this.mMixVideoFilePath = str;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam.Builder recordDisplayParam(com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam aliyunMixRecorderDisplayParam) {
            this.mRecordDisplayParam = aliyunMixRecorderDisplayParam;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam.Builder streamEndTimeMills(long j) {
            this.mStreamEndTimeMills = j;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam.Builder streamStartTimeMills(long j) {
            this.mStreamStartTimeMills = j;
            return this;
        }
    }

    private AliyunMixMediaInfoParam(com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam.Builder builder) {
        this.mMixVideoFilePath = builder.mMixVideoFilePath;
        this.mStreamStartTimeMills = builder.mStreamStartTimeMills;
        this.mStreamEndTimeMills = builder.mStreamEndTimeMills;
        this.mRecordDisplayParam = builder.mRecordDisplayParam;
        this.mMixDisplayParam = builder.mMixDisplayParam;
    }

    public /* synthetic */ AliyunMixMediaInfoParam(com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam.Builder builder, com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam.a aVar) {
        this(builder);
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam getMixDisplayParam() {
        return this.mMixDisplayParam;
    }

    public java.lang.String getMixVideoFilePath() {
        return this.mMixVideoFilePath;
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam getRecordDisplayParam() {
        return this.mRecordDisplayParam;
    }

    public long getStreamEndTimeMills() {
        return this.mStreamEndTimeMills;
    }

    public long getStreamStartTimeMills() {
        return this.mStreamStartTimeMills;
    }
}
