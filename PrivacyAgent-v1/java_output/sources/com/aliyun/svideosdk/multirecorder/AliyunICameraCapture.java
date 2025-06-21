package com.aliyun.svideosdk.multirecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunICameraCapture extends com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture {
    int addImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z);

    int applyAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int applyFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    int getBeautyLevel();

    int getCameraCount();

    float getCurrentExposureCompensationRatio();

    java.util.List<android.hardware.Camera.Size> getSupportedPictureSize();

    java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes();

    void needFaceTrackInternal(boolean z);

    void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);

    void removeFilter();

    void removeImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    void removePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    int resizePreviewSize(int i, int i2);

    void setAutoPreviewAfterTakePhoto(boolean z);

    void setBeautyLevel(int i);

    void setBeautyStatus(boolean z);

    void setCamera(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType);

    void setCameraCaptureDataMode(int i);

    void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam);

    void setDisplayView(android.view.SurfaceView surfaceView);

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

    boolean setLight(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType);

    void setOnChoosePictureSizeCallBack(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void setOnFaceDetectInfoListener(com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener onFaceDetectInfoListener);

    void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback);

    void setOnTextureIdCallback(com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback onTextureIdCallback);

    void setOutputFlip(boolean z);

    int setPictureSize(int i, int i2);

    void setRecordRotation(int i);

    void setRotation(int i);

    void setShutterSound(boolean z);

    int setZoom(float f);

    void snapshot(boolean z, com.aliyun.svideosdk.multirecorder.OnPictureCallback onPictureCallback);

    int startPreviewAfterTakePicture();

    int switchCamera();

    com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight();

    void takePhoto(boolean z, com.aliyun.svideosdk.multirecorder.OnPictureCallback onPictureCallback);

    int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter);
}
