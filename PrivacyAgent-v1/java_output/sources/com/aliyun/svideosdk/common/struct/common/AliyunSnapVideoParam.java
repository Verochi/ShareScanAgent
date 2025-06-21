package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunSnapVideoParam {
    public static final java.lang.String BEAUTY_LEVEL = "beauty_level";
    public static final java.lang.String BEAUTY_STATUS = "beauty_status";
    public static final java.lang.String CAMERA_TYPE = "camera_type";
    public static final java.lang.String CROP_MODE = "crop_mode";
    public static final java.lang.String CROP_USE_GPU = "crop_use_gpu";
    public static final java.lang.String FILTER_LIST = "filter_list";
    public static final java.lang.String FLASH_TYPE = "falsh_type";
    public static final java.lang.String MAX_DURATION = "max_duration";
    public static final java.lang.String MAX_VIDEO_DURATION = "max_video_duration";
    public static final java.lang.String MIN_CROP_DURATION = "min_crop_duration";
    public static final java.lang.String MIN_DURATION = "min_duration";
    public static final java.lang.String MIN_VIDEO_DURATION = "min_video_duration";
    public static final java.lang.String NEED_CLIP = "need_clip";
    public static final java.lang.String NEED_RECORD = "need_record";
    public static final int RATIO_MODE_1_1 = 1;
    public static final int RATIO_MODE_3_4 = 0;
    public static final int RATIO_MODE_9_16 = 2;
    public static final java.lang.String RECORD_MODE = "record_mode";
    public static final int RECORD_MODE_AUTO = 2;
    public static final int RECORD_MODE_PRESS = 1;
    public static final int RECORD_MODE_TOUCH = 0;
    public static final int RESOLUTION_360P = 0;
    public static final int RESOLUTION_480P = 1;
    public static final int RESOLUTION_540P = 2;
    public static final int RESOLUTION_720P = 3;
    public static final com.aliyun.svideosdk.common.struct.common.VideoDisplayMode SCALE_CROP = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
    public static final com.aliyun.svideosdk.common.struct.common.VideoDisplayMode SCALE_FILL = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
    public static final java.lang.String SORT_MODE = "sort_mode";
    public static final int SORT_MODE_MERGE = 2;
    public static final int SORT_MODE_PHOTO = 1;
    public static final int SORT_MODE_VIDEO = 0;
    public static final java.lang.String VIDEO_BITRATE = "video_bitrate";
    public static final java.lang.String VIDEO_CODEC = "video_codec";
    public static final java.lang.String VIDEO_FRAMERATE = "video_framerate";
    public static final java.lang.String VIDEO_GOP = "video_gop";
    public static final java.lang.String VIDEO_QUALITY = "video_quality";
    public static final java.lang.String VIDEO_RATIO = "video_ratio";
    public static final java.lang.String VIDEO_RESOLUTION = "video_resolution";
    private int mBitrate;
    private java.lang.String[] mFilterList;
    private int mResolutionMode = 2;
    private int mRatioMode = 0;
    private boolean mNeedRecord = true;
    private com.aliyun.svideosdk.common.struct.common.VideoQuality mVideoQuality = com.aliyun.svideosdk.common.struct.common.VideoQuality.HD;
    private int mGop = 5;
    private int mFrameRate = 25;
    private int mMinVideoDuration = 2000;
    private int mMaxVideoDuration = 600000;
    private int mMinCropDuration = 2000;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode mScaleMode = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;
    private int mRecordMode = 2;
    private int mBeautyLevel = 80;
    private boolean mBeautyStatus = true;
    private com.aliyun.svideosdk.common.struct.recorder.CameraType mCameraType = com.aliyun.svideosdk.common.struct.recorder.CameraType.FRONT;
    private com.aliyun.svideosdk.common.struct.recorder.FlashType mFlashType = com.aliyun.svideosdk.common.struct.recorder.FlashType.OFF;
    private boolean mNeedClip = true;
    private int mMaxDuration = 30000;
    private int mMinDuration = 2000;
    private int mSortMode = 2;
    private boolean isCropUseGPU = false;
    private com.aliyun.svideosdk.common.struct.encoder.VideoCodecs mVideoCodec = com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE;

    @com.aliyun.Visible
    public static class Builder {
        private com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam mParam = new com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam();

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam build() {
            return this.mParam;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setBeautyLevel(int i) {
            this.mParam.setBeautyLevel(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setBeautyStatus(boolean z) {
            this.mParam.setBeautyStatus(z);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setCameraType(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType) {
            this.mParam.setCameraType(cameraType);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setCropMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            this.mParam.setScaleMode(videoDisplayMode);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setCropUseGPU(boolean z) {
            this.mParam.setCropUseGPU(z);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setFilterList(java.lang.String[] strArr) {
            this.mParam.setFilterList(strArr);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setFlashType(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType) {
            this.mParam.setFlashType(flashType);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setFrameRate(int i) {
            this.mParam.setFrameRate(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setGop(int i) {
            this.mParam.setGop(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setMaxDuration(int i) {
            this.mParam.setMaxDuration(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setMaxVideoDuration(int i) {
            this.mParam.setMaxVideoDuration(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setMinCropDuration(int i) {
            this.mParam.setMinCropDuration(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setMinDuration(int i) {
            this.mParam.setMinDuration(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setMinVideoDuration(int i) {
            this.mParam.setMinVideoDuration(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setNeedClip(boolean z) {
            this.mParam.setNeedClip(z);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setNeedRecord(boolean z) {
            this.mParam.setNeedRecord(z);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setRatioMode(int i) {
            this.mParam.setRatioMode(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setRecordMode(int i) {
            this.mParam.setRecordMode(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setResolutionMode(int i) {
            this.mParam.setResolutionMode(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setResulutionMode(int i) {
            this.mParam.setResolutionMode(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setSortMode(int i) {
            this.mParam.setSortMode(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setVideQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
            this.mParam.setVideoQuality(videoQuality);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setVideoBitrate(int i) {
            this.mParam.setVideoBitrate(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
            this.mParam.setVideoCodec(videoCodecs);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunSnapVideoParam.Builder setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
            this.mParam.setVideoQuality(videoQuality);
            return this;
        }
    }

    public int getBeautyLevel() {
        return this.mBeautyLevel;
    }

    public boolean getBeautyStatus() {
        return this.mBeautyStatus;
    }

    public com.aliyun.svideosdk.common.struct.recorder.CameraType getCameraType() {
        return this.mCameraType;
    }

    public java.lang.String[] getFilterList() {
        return this.mFilterList;
    }

    public com.aliyun.svideosdk.common.struct.recorder.FlashType getFlashType() {
        return this.mFlashType;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getGop() {
        return this.mGop;
    }

    public int getMaxDuration() {
        return this.mMaxDuration;
    }

    public int getMaxVideoDuration() {
        return this.mMaxVideoDuration;
    }

    public int getMinCropDuration() {
        return this.mMinCropDuration;
    }

    public int getMinDuration() {
        return this.mMinDuration;
    }

    public int getMinVideoDuration() {
        return this.mMinVideoDuration;
    }

    public int getRatioMode() {
        return this.mRatioMode;
    }

    public int getRecordMode() {
        return this.mRecordMode;
    }

    public int getResolutionMode() {
        return this.mResolutionMode;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode getScaleMode() {
        return this.mScaleMode;
    }

    public int getSortMode() {
        return this.mSortMode;
    }

    public int getVideoBitrate() {
        return this.mBitrate;
    }

    public com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getVideoCodec() {
        return this.mVideoCodec;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoQuality getVideoQuality() {
        return this.mVideoQuality;
    }

    public boolean isCropUseGPU() {
        return this.isCropUseGPU;
    }

    public boolean isNeedClip() {
        return this.mNeedClip;
    }

    public boolean isNeedRecord() {
        return this.mNeedRecord;
    }

    public void setBeautyLevel(int i) {
        this.mBeautyLevel = i;
    }

    public void setBeautyStatus(boolean z) {
        this.mBeautyStatus = z;
    }

    public void setCameraType(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType) {
        this.mCameraType = cameraType;
    }

    public void setCropUseGPU(boolean z) {
        this.isCropUseGPU = z;
    }

    public void setFilterList(java.lang.String[] strArr) {
        this.mFilterList = strArr;
    }

    public void setFlashType(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType) {
        this.mFlashType = flashType;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setGop(int i) {
        this.mGop = i;
    }

    public void setMaxDuration(int i) {
        this.mMaxDuration = i;
    }

    public void setMaxVideoDuration(int i) {
        this.mMaxVideoDuration = i;
    }

    public void setMinCropDuration(int i) {
        this.mMinCropDuration = i;
    }

    public void setMinDuration(int i) {
        this.mMinDuration = i;
    }

    public void setMinVideoDuration(int i) {
        this.mMinVideoDuration = i;
    }

    public void setNeedClip(boolean z) {
        this.mNeedClip = z;
    }

    public void setNeedRecord(boolean z) {
        this.mNeedRecord = z;
    }

    public void setRatioMode(int i) {
        this.mRatioMode = i;
    }

    public void setRecordMode(int i) {
        this.mRecordMode = i;
    }

    public void setResolutionMode(int i) {
        this.mResolutionMode = i;
    }

    public void setScaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        this.mScaleMode = videoDisplayMode;
    }

    public void setSortMode(int i) {
        this.mSortMode = i;
    }

    public void setVideoBitrate(int i) {
        this.mBitrate = i;
    }

    public void setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs videoCodecs) {
        this.mVideoCodec = videoCodecs;
    }

    public void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        this.mVideoQuality = videoQuality;
    }
}
