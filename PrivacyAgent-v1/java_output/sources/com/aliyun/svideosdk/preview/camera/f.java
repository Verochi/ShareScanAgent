package com.aliyun.svideosdk.preview.camera;

/* loaded from: classes12.dex */
public interface f {
    int a();

    int a(int i, int i2, int i3);

    void a(float f, float f2);

    void a(int i);

    void a(android.graphics.Point point);

    void a(com.aliyun.svideosdk.a.a aVar);

    void a(com.aliyun.svideosdk.a.b bVar);

    void a(com.aliyun.svideosdk.a.c cVar);

    void a(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback);

    void a(boolean z);

    boolean a(java.lang.String str);

    boolean b();

    android.hardware.Camera.CameraInfo c();

    void d();

    int getCameraCount();

    float getCurrentExposureCompensationRatio();

    java.util.List<android.hardware.Camera.Size> getSupportedPictureSize();

    java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes();

    int release();

    void setCameraCaptureDataMode(int i);

    void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam);

    int setExposureCompensationRatio(float f);

    void setFocusMode(int i);

    void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback);

    int setPictureSize(int i, int i2);

    void setRotation(int i);

    void setShutterSound(boolean z);

    void setTakePicturePreview(boolean z);

    int setZoom(float f);

    int startPreviewAfterTakePicture();

    int switchCamera();
}
