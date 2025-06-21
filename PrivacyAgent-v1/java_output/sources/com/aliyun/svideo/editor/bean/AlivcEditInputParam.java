package com.aliyun.svideo.editor.bean;

/* loaded from: classes12.dex */
public class AlivcEditInputParam {
    public static final java.lang.String INTENT_KEY_CODEC = "mVideoCodec";
    public static final java.lang.String INTENT_KEY_DE_NOISE = "mHasDeNoise";
    public static final java.lang.String INTENT_KEY_DRAFT_PATH = "draftPath";
    public static final java.lang.String INTENT_KEY_FRAME = "mFrame";
    public static final java.lang.String INTENT_KEY_GET_MEDIA = "get_media";
    public static final java.lang.String INTENT_KEY_GOP = "mGop";
    public static final java.lang.String INTENT_KEY_HORIZONTAL_FLIP = "horizontalFlip";
    public static final java.lang.String INTENT_KEY_IS_MIX = "isMixRecord";
    public static final java.lang.String INTENT_KEY_MEDIA_INFO = "mediaInfos";
    public static final java.lang.String INTENT_KEY_NEED_TRANSCODE = "mNeedTrancode";
    public static final java.lang.String INTENT_KEY_OUTPUT_HEIGHT = "OutputHeight";
    public static final java.lang.String INTENT_KEY_OUTPUT_WIDTH = "OutputWidth";
    public static final java.lang.String INTENT_KEY_QUALITY = "mVideoQuality";
    public static final java.lang.String INTENT_KEY_RATION_MODE = "mRatioMode";
    public static final java.lang.String INTENT_KEY_REPLACE_MUSIC = "canReplaceMusic";
    public static final java.lang.String INTENT_KEY_RESOLUTION_MODE = "mResolutionMode";
    public static final java.lang.String INTENT_KEY_TAIL_ANIMATION = "mHasTailAnimation";
    public static final java.lang.String INTENT_KEY_WATER_MARK = "hasWaterMark";
    public static final java.lang.String INTETN_KEY_CRF = "mCrf";
    public static final java.lang.String INTETN_KEY_SCANLE_MODE = "mScaleMode";
    public static final java.lang.String INTETN_KEY_SCANLE_RATE = "mScaleRate";
    public static final int RATIO_MODE_1_1 = 1;
    public static final int RATIO_MODE_3_4 = 0;
    public static final int RATIO_MODE_9_16 = 2;
    public static final int RATIO_MODE_ORIGINAL = 3;
    public static final int RESOLUTION_360P = 0;
    public static final int RESOLUTION_480P = 1;
    public static final int RESOLUTION_540P = 2;
    public static final int RESOLUTION_720P = 3;
    private int bitRate;
    private boolean canReplaceMusic;
    private boolean hasWaterMark;
    private int height;
    private boolean horizontalFlip;
    private boolean isMixRecorder;
    private int mCrf;
    private int mFrameRate;
    private int mGop;
    private boolean mHasDeNoise;
    private boolean mHasTailAnimation;
    private boolean mNeedTrancode;
    private int mRatio;
    private int mResolutionMode;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mScaleMode;
    private float mScaleRate;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodec;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality mVideoQuality;
    private java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> mediaInfos;
    private java.lang.String orientation;
    private int width;

    public static class Builder {
        private com.aliyun.svideo.editor.bean.AlivcEditInputParam mParam = new com.aliyun.svideo.editor.bean.AlivcEditInputParam(null);

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder addMediaInfo(com.aliyun.svideo.media.MediaInfo mediaInfo) {
            this.mParam.mediaInfos.add(mediaInfo);
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder addMediaInfos(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
            this.mParam.mediaInfos.addAll(list);
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam build() {
            return this.mParam;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setBitRate(int i) {
            this.mParam.bitRate = i;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setCanReplaceMusic(boolean z) {
            this.mParam.canReplaceMusic = z;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setCrf(int i) {
            this.mParam.mCrf = i;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setDeNoise(boolean z) {
            this.mParam.mHasDeNoise = z;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setFrameRate(int i) {
            this.mParam.mFrameRate = i;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setGop(int i) {
            this.mParam.mGop = i;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setHasTailAnimation(boolean z) {
            this.mParam.mHasTailAnimation = z;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setHasWaterMark(boolean z) {
            this.mParam.hasWaterMark = z;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setHorizontalFlip(boolean z) {
            this.mParam.horizontalFlip = z;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setIsMixRecorder(boolean z) {
            this.mParam.isMixRecorder = z;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setNeedTranscode(boolean z) {
            this.mParam.mNeedTrancode = z;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setRatio(int i) {
            this.mParam.mRatio = i;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setResolutionMode(int i) {
            this.mParam.mResolutionMode = i;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setScaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            this.mParam.mScaleMode = videoDisplayMode;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setScaleRate(float f) {
            this.mParam.mScaleRate = f;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
            this.mParam.mVideoCodec = videoCodecs;
            return this;
        }

        public com.aliyun.svideo.editor.bean.AlivcEditInputParam.Builder setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
            this.mParam.mVideoQuality = videoQuality;
            return this;
        }
    }

    private AlivcEditInputParam() {
        this.mHasDeNoise = false;
        this.mNeedTrancode = false;
        this.hasWaterMark = true;
        this.horizontalFlip = false;
        this.mediaInfos = new java.util.ArrayList<>();
        this.mCrf = 23;
        this.mScaleRate = 1.0f;
        this.mResolutionMode = 3;
        this.mRatio = 2;
        this.mGop = 250;
        this.mFrameRate = 30;
        this.mVideoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
        this.mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;
    }

    public /* synthetic */ AlivcEditInputParam(defpackage.f8 f8Var) {
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

    public int geOutputtVideoHeight() {
        int outputVideoWidth = getOutputVideoWidth();
        int i = this.mRatio;
        if (i == 0) {
            return (outputVideoWidth * 4) / 3;
        }
        if (i == 1) {
            return outputVideoWidth;
        }
        if (i != 2 && i == 3) {
            java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> arrayList = this.mediaInfos;
            return (arrayList == null || arrayList.size() <= 0) ? (outputVideoWidth * 16) / 9 : (int) (outputVideoWidth / getMediaRatio(this.mediaInfos.get(0)));
        }
        return (outputVideoWidth * 16) / 9;
    }

    public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam generateMixVideoParam() {
        return new com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder().frameRate(this.mFrameRate).gop(this.mGop).crf(this.mCrf).videoQuality(this.mVideoQuality).scaleMode(this.mScaleMode).scaleRate(this.mScaleRate).outputWidth(720).outputHeight(com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH).videoCodec(this.mVideoCodec).build();
    }

    public com.aliyun.svideosdk.common.struct.common.AliyunVideoParam generateVideoParam() {
        return new com.aliyun.svideosdk.common.struct.common.AliyunVideoParam.Builder().frameRate(this.mFrameRate).gop(this.mGop).crf(this.mCrf).videoQuality(this.mVideoQuality).scaleMode(this.mScaleMode).scaleRate(this.mScaleRate).bitrate(this.bitRate).outputWidth(getOutputVideoWidth()).outputHeight(geOutputtVideoHeight()).videoCodec(this.mVideoCodec).build();
    }

    public int getCrf() {
        return this.mCrf;
    }

    public boolean getDeNoise() {
        return this.mHasDeNoise;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getHeight() {
        return this.height;
    }

    public java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> getMediaInfos() {
        return this.mediaInfos;
    }

    public java.lang.String getOrientation() {
        return this.orientation;
    }

    public int getOutputVideoWidth() {
        int i = this.mResolutionMode;
        return i != 0 ? i != 1 ? (i == 2 || i != 3) ? 540 : 720 : com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH : com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
    }

    public int getRatio() {
        return this.mRatio;
    }

    public int getResolutionMode() {
        return this.mResolutionMode;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getScaleMode() {
        return this.mScaleMode;
    }

    public float getScaleRate() {
        return this.mScaleRate;
    }

    public com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getVideoQuality() {
        return this.mVideoQuality;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isCanReplaceMusic() {
        return this.canReplaceMusic;
    }

    public boolean isHasTailAnimation() {
        return this.mHasTailAnimation;
    }

    public boolean isHasWaterMark() {
        return this.hasWaterMark;
    }

    public boolean isHorizontalFlip() {
        return this.horizontalFlip;
    }

    public boolean isMixRecorder() {
        return this.isMixRecorder;
    }

    public boolean isNeedTrancode() {
        return this.mNeedTrancode;
    }

    public void setBitrate(int i) {
        this.bitRate = i;
    }

    public void setCanReplaceMusic(boolean z) {
        this.canReplaceMusic = z;
    }

    public void setCrf(int i) {
        this.mCrf = i;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setGop(int i) {
        this.mGop = i;
    }

    public void setHasTailAnimation(boolean z) {
        this.mHasTailAnimation = z;
    }

    public void setHasWaterMark(boolean z) {
        this.hasWaterMark = z;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setMediaInfos(java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> arrayList) {
        this.mediaInfos = arrayList;
    }

    public void setOrientation(java.lang.String str) {
        this.orientation = str;
    }

    public void setRatio(int i) {
        this.mRatio = i;
    }

    public void setResolutionMode(int i) {
        this.mResolutionMode = i;
    }

    public void setScaleRate(float f) {
        this.mScaleRate = f;
    }

    public void setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
        this.mVideoCodec = videoCodecs;
    }

    public void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        this.mVideoQuality = videoQuality;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setmScaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        this.mScaleMode = videoDisplayMode;
    }

    public void setsMixRecorder(boolean z) {
        this.isMixRecorder = z;
    }
}
