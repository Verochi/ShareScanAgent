package com.aliyun.svideo.base;

/* loaded from: classes.dex */
public class AlivcSvideoEditParam {
    public static final int ACTION_SELECT_TIME = 1;
    public static final int ACTION_TRANSCODE = 0;
    public static final java.lang.String CROP_ACTION = "action";
    public static final java.lang.String INTENT_PARAM_KEY_ENTRANCE = "entrance";
    public static final int RATIO_MODE_1_1 = 1;
    public static final int RATIO_MODE_3_4 = 0;
    public static final int RATIO_MODE_9_16 = 2;
    public static final int RATIO_MODE_ORIGINAL = 3;
    public static final int RESOLUTION_360P = 0;
    public static final int RESOLUTION_480P = 1;
    public static final int RESOLUTION_540P = 2;
    public static final int RESOLUTION_720P = 3;
    public static final java.lang.String TAIL_ANIMATION = "tail_animation";
    public static final java.lang.String VIDEO_CODEC = "video_codexc";
    public static final java.lang.String VIDEO_CROP_MODE = "crop_mode";
    public static final java.lang.String VIDEO_DURATION = "video_duration";
    public static final java.lang.String VIDEO_FRAMERATE = "video_framerate";
    public static final java.lang.String VIDEO_GOP = "video_gop";
    public static final java.lang.String VIDEO_PATH = "video_path";
    public static final java.lang.String VIDEO_QUALITY = "video_quality";
    public static final java.lang.String VIDEO_RATIO = "video_ratio";
    public static final java.lang.String VIDEO_RESOLUTION = "video_RESOLUTION";
    private java.lang.String entrance;
    private boolean hasTailAnimation;
    private boolean isOpenCrop;
    private int mCropAction;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mCropMode;
    private int mFrameRate;
    private int mGop;
    private int mRatio;
    private int mResolutionMode;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodec;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality mVideoQuality;
    private com.aliyun.svideo.media.MediaInfo mediaInfo;

    public static class Build {
        private com.aliyun.svideo.base.AlivcSvideoEditParam param = new com.aliyun.svideo.base.AlivcSvideoEditParam(null);

        public com.aliyun.svideo.base.AlivcSvideoEditParam build() {
            return this.param;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setCropMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            this.param.mCropMode = videoDisplayMode;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setEntrance(java.lang.String str) {
            this.param.entrance = str;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setFrameRate(int i) {
            this.param.mFrameRate = i;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setGop(int i) {
            this.param.mGop = i;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setHasTailAnimation(boolean z) {
            this.param.hasTailAnimation = z;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setIsOpenCrop(boolean z) {
            this.param.isOpenCrop = z;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setMediaInfo(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            this.param.mediaInfo = mediaInfo;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setRatio(int i) {
            this.param.mRatio = i;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setResolutionMode(int i) {
            this.param.mResolutionMode = i;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
            this.param.mVideoCodec = videoCodecs;
            return this;
        }

        public com.aliyun.svideo.base.AlivcSvideoEditParam.Build setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
            this.param.mVideoQuality = videoQuality;
            return this;
        }
    }

    private AlivcSvideoEditParam() {
        this.mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
        this.mGop = 250;
        this.mFrameRate = 30;
        this.mRatio = 2;
        this.mVideoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
        this.mResolutionMode = 3;
        this.mCropMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
        this.entrance = "svideo";
        this.mCropAction = 1;
    }

    public /* synthetic */ AlivcSvideoEditParam(defpackage.i8 i8Var) {
        this();
    }

    private float getMediaRatio(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        float f;
        float f2;
        int i = 0;
        if (mediaInfo.mimeType.startsWith("video") || mediaInfo.filePath.endsWith("gif") || mediaInfo.filePath.endsWith("GIF")) {
            com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
            nativeParser.init(mediaInfo.filePath);
            float f3 = 9.0f;
            float f4 = 16.0f;
            try {
                f3 = java.lang.Float.parseFloat(nativeParser.getValue(6));
                f4 = java.lang.Integer.parseInt(nativeParser.getValue(7));
                i = java.lang.Integer.parseInt(nativeParser.getValue(14));
            } catch (java.lang.Exception unused) {
            }
            f = f3;
            nativeParser.release();
            nativeParser.dispose();
            f2 = f4;
        } else {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(mediaInfo.filePath, options);
            f = options.outWidth;
            f2 = options.outHeight;
        }
        float f5 = f / f2;
        return (i == 90 || i == 270) ? 1.0f / f5 : f5;
    }

    public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam generateVideoParam() {
        return new com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder().frameRate(this.mFrameRate).gop(this.mGop).crf(0).videoQuality(this.mVideoQuality).scaleMode(this.mCropMode).outputWidth(getVideoWidth()).outputHeight(getVideoHeight(this.mediaInfo)).videoCodec(this.mVideoCodec).build();
    }

    public int getCropAction() {
        return this.mCropAction;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getCropMode() {
        return this.mCropMode;
    }

    public java.lang.String getEntrance() {
        return this.entrance;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getGop() {
        return this.mGop;
    }

    public com.aliyun.svideo.media.MediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    public int getRatio() {
        return this.mRatio;
    }

    public int getResolutionMode() {
        return this.mResolutionMode;
    }

    public com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public int getVideoHeight(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        int videoWidth = getVideoWidth();
        int i = this.mRatio;
        if (i == 0) {
            return (videoWidth * 4) / 3;
        }
        if (i == 1) {
            return videoWidth;
        }
        if (i != 2 && i == 3 && mediaInfo != null) {
            return (int) (videoWidth / getMediaRatio(mediaInfo));
        }
        return (videoWidth * 16) / 9;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getVideoQuality() {
        return this.mVideoQuality;
    }

    public int getVideoWidth() {
        int i = this.mResolutionMode;
        return i != 0 ? i != 1 ? (i == 2 || i != 3) ? 540 : 720 : com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH : com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
    }

    public boolean isHasTailAnimation() {
        return this.hasTailAnimation;
    }

    public boolean isOpenCrop() {
        return this.isOpenCrop;
    }

    public void setCropAction(int i) {
        this.mCropAction = i;
    }

    public void setCropMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        this.mCropMode = videoDisplayMode;
    }

    public void setEntrance(java.lang.String str) {
        this.entrance = str;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setGop(int i) {
        this.mGop = i;
    }

    public void setHasTailAnimation(boolean z) {
        this.hasTailAnimation = z;
    }

    public void setMediaInfo(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public void setRatio(int i) {
        this.mRatio = i;
    }

    public void setResolutionMode(int i) {
        this.mResolutionMode = i;
    }

    public void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        this.mVideoQuality = videoQuality;
    }
}
