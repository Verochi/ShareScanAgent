package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunMixOutputParam {
    private int mBitrate;
    private int mCrf;
    private int mFps;
    private int mGopSize;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixTrack mOutputAudioReferenceTrack;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixTrack mOutputDurationReferenceTrack;
    private int mOutputHeight;
    private java.lang.String mOutputPath;
    private int mOutputWidth;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality mVideoQuality;

    @com.aliyun.Visible
    public static final class Builder {
        private int mBitrate;
        private com.aliyun.svideosdk.mixrecorder.AliyunMixTrack mOutputAudioReferenceTrack;
        private com.aliyun.svideosdk.mixrecorder.AliyunMixTrack mOutputDurationReferenceTrack;
        private int mOutputHeight;
        private java.lang.String mOutputPath;
        private int mOutputWidth;
        private int mCrf = 23;
        private com.aliyun.svideosdk.common.struct.common.VideoQuality mVideoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.SSD;
        private int mFps = 30;
        private int mGopSize = 60;

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder bitrate(int i) {
            if (i < 200) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Invalid bitrate value ");
                sb.append(i);
                sb.append(", bitrate value has must be between ");
                sb.append(200);
                sb.append(" and ");
                sb.append(20000);
                i = 200;
            } else if (i > 20000) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Invalid bitrate value ");
                sb2.append(i);
                sb2.append(", bitrate value has must be between ");
                sb2.append(200);
                sb2.append(" and ");
                sb2.append(20000);
                i = 20000;
            }
            this.mBitrate = i;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam build() {
            return new com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam(this, null);
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder crf(int i) {
            if (i < com.aliyun.svideosdk.common.b.a.a) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Invalid crf value ");
                sb.append(i);
                sb.append(", crf value has must be between ");
                sb.append(com.aliyun.svideosdk.common.b.a.a);
                sb.append(" and ");
                sb.append(com.aliyun.svideosdk.common.b.a.b);
                i = com.aliyun.svideosdk.common.b.a.a;
            } else if (i > com.aliyun.svideosdk.common.b.a.b) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Invalid crf value ");
                sb2.append(i);
                sb2.append(", crf value has must be between ");
                sb2.append(com.aliyun.svideosdk.common.b.a.a);
                sb2.append(" and ");
                sb2.append(com.aliyun.svideosdk.common.b.a.b);
                i = com.aliyun.svideosdk.common.b.a.b;
            }
            this.mCrf = i;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder fps(int i) {
            if (i < 1) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Invalid fps value ");
                sb.append(i);
                sb.append(", fps value has must be between ");
                sb.append(1);
                sb.append(" and ");
                sb.append(120);
                i = 1;
            } else if (i > 120) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Invalid fps value ");
                sb2.append(i);
                sb2.append(", fps value has must be between ");
                sb2.append(1);
                sb2.append(" and ");
                sb2.append(120);
                i = 120;
            }
            this.mFps = i;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder gopSize(int i) {
            if (i < 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Invalid gop value ");
                sb.append(i);
                sb.append(", gop value has must be between ");
                sb.append(0);
                sb.append(" and ");
                sb.append(9000);
                i = 0;
            } else if (i > 9000) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Invalid gop value ");
                sb2.append(i);
                sb2.append(", gop value has must be between ");
                sb2.append(0);
                sb2.append(" and ");
                sb2.append(9000);
                i = 9000;
            }
            this.mGopSize = i;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder outputAudioReferenceTrack(com.aliyun.svideosdk.mixrecorder.AliyunMixTrack aliyunMixTrack) {
            aliyunMixTrack.setIsOutputAudioTrack(true);
            this.mOutputAudioReferenceTrack = aliyunMixTrack;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder outputDurationReferenceTrack(com.aliyun.svideosdk.mixrecorder.AliyunMixTrack aliyunMixTrack) {
            this.mOutputDurationReferenceTrack = aliyunMixTrack;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder outputHeight(int i) {
            if (i > 0) {
                this.mOutputHeight = i;
            }
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder outputPath(java.lang.String str) {
            this.mOutputPath = str;
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder outputWidth(int i) {
            if (i > 0) {
                this.mOutputWidth = i;
            }
            return this;
        }

        public com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder videoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
            if (videoQuality != null) {
                this.mVideoQuality = videoQuality;
            }
            return this;
        }
    }

    private AliyunMixOutputParam(com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder builder) {
        this.mOutputPath = builder.mOutputPath;
        this.mOutputDurationReferenceTrack = builder.mOutputDurationReferenceTrack;
        this.mOutputAudioReferenceTrack = builder.mOutputAudioReferenceTrack;
        this.mOutputWidth = builder.mOutputWidth;
        this.mOutputHeight = builder.mOutputHeight;
        this.mCrf = builder.mCrf;
        this.mBitrate = builder.mBitrate;
        this.mVideoQuality = builder.mVideoQuality;
        this.mFps = builder.mFps;
        this.mGopSize = builder.mGopSize;
    }

    public /* synthetic */ AliyunMixOutputParam(com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.Builder builder, com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam.a aVar) {
        this(builder);
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getCrf() {
        return this.mCrf;
    }

    public int getFps() {
        return this.mFps;
    }

    public int getGopSize() {
        return this.mGopSize;
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixTrack getOutputAudioReferenceTrack() {
        return this.mOutputAudioReferenceTrack;
    }

    public com.aliyun.svideosdk.mixrecorder.AliyunMixTrack getOutputDurationReferenceTrack() {
        return this.mOutputDurationReferenceTrack;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public java.lang.String getOutputPath() {
        return this.mOutputPath;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getVideoQuality() {
        return this.mVideoQuality;
    }
}
