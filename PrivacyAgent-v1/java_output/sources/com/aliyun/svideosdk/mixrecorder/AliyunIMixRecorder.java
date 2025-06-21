package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIMixRecorder {
    @java.lang.Deprecated
    int addImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    @java.lang.Deprecated
    int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    @java.lang.Deprecated
    int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z);

    int applyAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int applyFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int cancelFinishing();

    int deleteLastPart();

    int finishRecording();

    int getBeautyLevel();

    int getCameraCount();

    com.aliyun.svideosdk.recorder.AliyunIClipManager getClipManager();

    float getCurrentExposureCompensationRatio();

    com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager getPasterManager();

    void needFaceTrackInternal(boolean z);

    void release();

    void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int removeFilter();

    @java.lang.Deprecated
    void removeImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    @java.lang.Deprecated
    void removePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    void setBackgroundColor(int i);

    void setBackgroundImage(android.graphics.Bitmap bitmap, int i);

    void setBackgroundImage(java.lang.String str, int i);

    void setBeautyLevel(int i);

    @java.lang.Deprecated
    void setBeautyStatus(boolean z);

    void setCamera(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType);

    void setCameraCaptureDataMode(int i);

    void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam);

    int setDisplayView(android.view.SurfaceView surfaceView, android.view.SurfaceView surfaceView2);

    @java.lang.Deprecated
    int setEffectView(float f, float f2, float f3, float f4, com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase);

    int setExposureCompensationRatio(float f);

    void setFaceDetectRotation(int i);

    void setFaceTrackInternalMaxFaceCount(int i);

    int setFaceTrackInternalModelPath(java.lang.String str);

    int setFaces(float[][] fArr);

    void setFocus(float f, float f2);

    void setFocusMode(int i);

    @java.lang.Deprecated
    int setGop(int i);

    void setIsAutoClearClipVideos(boolean z);

    boolean setLight(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType);

    void setMixAudioAecType(com.aliyun.svideosdk.mixrecorder.MixAudioAecType mixAudioAecType);

    void setMixAudioSource(com.aliyun.svideosdk.mixrecorder.MixAudioSourceType mixAudioSourceType);

    void setMixAudioWeight(int i, int i2);

    int setMixMediaInfo(com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam aliyunMixMediaInfoParam, com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo);

    void setMixedBorderParam(com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam aliyunMixBorderParam);

    void setOnAudioCallback(com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack onAudioCallBack);

    void setOnChoosePictureSizeCallBack(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void setOnFaceDetectInfoListener(com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener onFaceDetectInfoListener);

    void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback);

    void setOnRecordCallback(com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback);

    void setOnTextureIdCallback(com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback onTextureIdCallback);

    int setOutputPath(java.lang.String str);

    int setRate(float f);

    void setRecordBorderParam(com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam aliyunMixBorderParam);

    void setRecordRotation(int i);

    void setRotation(int i);

    @java.lang.Deprecated
    int setVideoBitrate(int i);

    @java.lang.Deprecated
    void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality);

    int setZoom(float f);

    int startPreview();

    int startRecording();

    void stopPreview();

    int stopRecording();

    int switchCamera();

    com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight();

    int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);
}
