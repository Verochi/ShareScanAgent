package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunMixStream {
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mDisplayMode;
    private java.lang.String mFilePath;
    private long mStreamEndTime;
    private int mStreamId;
    private long mStreamStartTime;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixTrack mTrack;

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mDisplayMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
        private java.lang.String mFilePath;
        private long mStreamEndTime;
        private long mStreamStartTime;

        public com.aliyun.svideosdk.mixrecorder.AliyunMixStream build() {
            return new com.aliyun.svideosdk.mixrecorder.AliyunMixStream(this, null);
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixStream.Builder displayMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            this.mDisplayMode = videoDisplayMode;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixStream.Builder filePath(java.lang.String str) {
            this.mFilePath = str;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixStream.Builder streamEndTime(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mStreamEndTime = timeUnit.toMillis(j);
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixStream.Builder streamEndTimeMills(long j) {
            this.mStreamEndTime = j;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixStream.Builder streamStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mStreamStartTime = timeUnit.toMillis(j);
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixStream.Builder streamStartTimeMills(long j) {
            this.mStreamStartTime = j;
            return this;
        }
    }

    private AliyunMixStream(com.aliyun.svideosdk.mixrecorder.AliyunMixStream.Builder builder) {
        this.mFilePath = builder.mFilePath;
        this.mStreamStartTime = builder.mStreamStartTime;
        this.mStreamEndTime = builder.mStreamEndTime;
        this.mDisplayMode = builder.mDisplayMode;
    }

    public /* synthetic */ AliyunMixStream(com.aliyun.svideosdk.mixrecorder.AliyunMixStream.Builder builder, com.aliyun.svideosdk.mixrecorder.AliyunMixStream.a aVar) {
        this(builder);
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getDisplayMode() {
        return this.mDisplayMode;
    }

    public java.lang.String getFilePath() {
        return this.mFilePath;
    }

    public long getStreamEndTimeMills() {
        return this.mStreamEndTime;
    }

    public int getStreamId() {
        return this.mStreamId;
    }

    public long getStreamStartTimeMills() {
        return this.mStreamStartTime;
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixTrack getTrack() {
        return this.mTrack;
    }

    public void setStreamId(int i) {
        this.mStreamId = i;
    }

    public void setTrack(com.aliyun.svideosdk.mixrecorder.AliyunMixTrack aliyunMixTrack) {
        this.mTrack = aliyunMixTrack;
    }
}
