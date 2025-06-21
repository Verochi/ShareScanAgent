package com.aliyun.svideosdk.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIRecorder {
    @java.lang.Deprecated
    int addImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    @java.lang.Deprecated
    int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    @java.lang.Deprecated
    int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z);

    int applyAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int applyBackgroundMusic(com.aliyun.svideosdk.common.struct.effect.EffectStream effectStream);

    int applyFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    void cancelRecording();

    @java.lang.Deprecated
    void destroy();

    int finishRecording();

    android.net.Uri finishRecordingForEdit();

    com.aliyun.common.log.struct.AliyunLogInfo getAliyunLogInfo();

    int getBeautyLevel();

    int getCameraCount();

    com.aliyun.svideosdk.recorder.AliyunIClipManager getClipManager();

    float getCurrentExposureCompensationRatio();

    com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager getPasterManager();

    java.util.List<android.hardware.Camera.Size> getSupportedPictureSize();

    java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes();

    void needFaceTrackInternal(boolean z);

    void release();

    void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int removeBackgroundMusic();

    int removeFilter();

    @java.lang.Deprecated
    void removeImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    @java.lang.Deprecated
    void removePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    int resizePreviewSize(int i, int i2);

    void setBeautyLevel(int i);

    @java.lang.Deprecated
    void setBeautyStatus(boolean z);

    void setCamera(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType);

    void setCameraCaptureDataMode(int i);

    void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam);

    void setDisplayView(android.view.SurfaceView surfaceView);

    @java.lang.Deprecated
    int setEffectView(float f, float f2, float f3, float f4, com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase);

    int setExposureCompensationRatio(float f);

    void setFaceDetectRotation(int i);

    void setFaceTrackInternalMaxFaceCount(int i);

    int setFaceTrackInternalModelPath(java.lang.String str);

    int setFaces(float[][] fArr);

    void setFocus(float f, float f2);

    @java.lang.Deprecated
    void setFocus(android.graphics.Point point);

    void setFocusMode(int i);

    @java.lang.Deprecated
    int setGop(int i);

    void setIsAutoClearClipVideos(boolean z);

    boolean setLight(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType);

    void setMediaInfo(com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo);

    @java.lang.Deprecated
    void setMusic(java.lang.String str, long j, long j2);

    void setMute(boolean z);

    void setOnAudioCallback(com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack onAudioCallBack);

    void setOnChoosePictureSizeCallBack(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void setOnEncoderInfoCallback(com.aliyun.svideosdk.common.callback.recorder.OnEncoderInfoCallback onEncoderInfoCallback);

    void setOnFaceDetectInfoListener(com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener onFaceDetectInfoListener);

    void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback);

    void setOnRecordCallback(com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback);

    void setOnTextureIdCallback(com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback onTextureIdCallback);

    int setOutputPath(java.lang.String str);

    int setPictureSize(android.hardware.Camera.Size size);

    int setPictureSize(com.aliyun.common.utils.Size size);

    void setRate(float f);

    void setRecordRotation(int i);

    void setRotation(int i);

    void setShutterSound(boolean z);

    void setTakePicturePreview(boolean z);

    @java.lang.Deprecated
    int setVideoBitrate(int i);

    int setVideoFlipH(boolean z);

    @java.lang.Deprecated
    void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality);

    int setZoom(float f);

    int startPreview();

    int startPreviewAfterTakePicture();

    int startRecording();

    void stopPreview();

    int stopRecording();

    int switchCamera();

    com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight();

    @java.lang.Deprecated
    void takePhoto(boolean z);

    @java.lang.Deprecated
    void takePicture(boolean z);

    void takePicture(boolean z, com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback onPictureCallback);

    void takeSnapshot(boolean z, com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback onPictureCallback);

    int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    java.lang.String version();
}
