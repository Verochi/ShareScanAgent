package com.aliyun.svideosdk.multirecorder.config;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunVideoRecorderConfig {
    private final int crf;
    private final int encoderFps;
    private final int fps;
    private final int gop;
    private final java.lang.String outputPath;
    private final int videoBitrate;
    private final com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs;
    private final int videoHeight;
    private final com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality;
    private final int videoWidth;

    @com.aliyun.Visible
    public static class Builder {
        private int crf;
        private int encoderFps;
        private int fps;
        private int gop;
        private java.lang.String outputPath;
        private int videoBitrate;
        private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs;
        private int videoHeight;
        private com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality;
        private int videoWidth;

        private Builder() {
            this.videoWidth = 0;
            this.videoHeight = 0;
            this.outputPath = null;
            this.fps = 30;
            this.videoCodecs = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
            this.crf = com.aliyun.svideosdk.common.b.a.c;
            this.encoderFps = 30;
            this.videoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
            this.gop = 125;
            this.videoBitrate = 0;
        }

        public /* synthetic */ Builder(com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.a aVar) {
            this();
        }

        private void check() {
            if (this.videoWidth == 0 || this.videoHeight == 0) {
                throw new java.lang.IllegalArgumentException("Should set videoWidth and videoHeight");
            }
            if (this.outputPath == null) {
                throw new java.lang.IllegalArgumentException("Should set outputPath");
            }
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig build() {
            check();
            return new com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig(this, null);
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder crf(int i) {
            if (i >= com.aliyun.svideosdk.common.b.a.a && i <= com.aliyun.svideosdk.common.b.a.b) {
                this.crf = i;
                return this;
            }
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid crf value " + i + ", crf must be between " + com.aliyun.svideosdk.common.b.a.a + " and " + com.aliyun.svideosdk.common.b.a.b);
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder encoderFps(int i) {
            if (i >= 1 && i <= 120) {
                this.encoderFps = i;
                return this;
            }
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid encoderFps value " + i + ", encoderFps must be between 1 and 120");
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder fps(int i) {
            int i2 = this.crf;
            if (i2 >= 1 && i2 <= 120) {
                this.fps = i;
                return this;
            }
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid fps value " + i + ", fps must be between 1 and 120");
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder gop(int i) {
            if (i >= 0 && i <= 9000) {
                this.gop = i;
                return this;
            }
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid gop value " + i + ", gop value must be between 0 and 9000");
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder outputPath(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("outputPath should not be empty!");
            }
            this.outputPath = str;
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder videoBitrate(int i) {
            if (i >= 200 && i <= 20000) {
                this.videoBitrate = i;
                return this;
            }
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid video bitrate value " + i + ", video bitrate must be between 200 and 20000");
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder videoCodecs(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
            if (videoCodecs == null) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid VideoCodecs");
                return this;
            }
            this.videoCodecs = videoCodecs;
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder videoHeight(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("videoHeight must be greater than 0!");
            }
            this.videoHeight = i;
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder videoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
            if (videoQuality == null) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid VideoQuality");
                return this;
            }
            this.videoQuality = videoQuality;
            return this;
        }

        public com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder videoWidth(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("videoWidth must be grate than 0!");
            }
            this.videoWidth = i;
            return this;
        }
    }

    private AliyunVideoRecorderConfig(com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder builder) {
        this.videoWidth = builder.videoWidth;
        this.videoHeight = builder.videoHeight;
        this.outputPath = builder.outputPath;
        this.fps = builder.fps;
        this.videoCodecs = builder.videoCodecs;
        this.crf = builder.crf;
        this.encoderFps = builder.encoderFps;
        this.videoQuality = builder.videoQuality;
        this.gop = builder.gop;
        this.videoBitrate = builder.videoBitrate;
    }

    public /* synthetic */ AliyunVideoRecorderConfig(com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder builder, com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.a aVar) {
        this(builder);
    }

    public static com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder builder() {
        return new com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig.Builder(null);
    }

    public int getCrf() {
        return this.crf;
    }

    public int getEncoderFps() {
        return this.encoderFps;
    }

    public int getFps() {
        return this.fps;
    }

    public int getGop() {
        return this.gop;
    }

    public java.lang.String getOutputPath() {
        return this.outputPath;
    }

    public int getVideoBitrate() {
        return this.videoBitrate;
    }

    public com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getVideoCodecs() {
        return this.videoCodecs;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getVideoQuality() {
        return this.videoQuality;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }
}
