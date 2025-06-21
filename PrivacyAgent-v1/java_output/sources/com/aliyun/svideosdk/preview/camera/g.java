package com.aliyun.svideosdk.preview.camera;

/* loaded from: classes12.dex */
public interface g {
    int a();

    int a(int i, int i2);

    void a(int i);

    void a(com.aliyun.svideosdk.a.a aVar);

    void a(com.aliyun.svideosdk.a.b bVar);

    void a(com.aliyun.svideosdk.a.c cVar);

    void a(boolean z);

    boolean a(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType);

    void b(int i);

    boolean b();

    android.hardware.Camera.CameraInfo c();

    int getCameraCount();

    float getCurrentExposureCompensationRatio();

    java.util.List<android.hardware.Camera.Size> getSupportedPictureSize();

    java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes();

    void release();

    void setCameraCaptureDataMode(int i);

    void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam);

    int setExposureCompensationRatio(float f);

    void setFocus(float f, float f2);

    void setFocus(android.graphics.Point point);

    void setFocusMode(int i);

    void setOnChoosePictureSizeCallBack(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback);

    int setPictureSize(int i, int i2);

    void setRotation(int i);

    void setShutterSound(boolean z);

    void setTakePicturePreview(boolean z);

    int setZoom(float f);

    int startPreview();

    int startPreviewAfterTakePicture();

    void stopPreview();

    int switchCamera();

    com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight();
}
