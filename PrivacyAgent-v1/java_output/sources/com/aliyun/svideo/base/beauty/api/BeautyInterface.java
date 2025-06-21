package com.aliyun.svideo.base.beauty.api;

/* loaded from: classes.dex */
public interface BeautyInterface {
    void addDefaultBeautyLevelChangeListener(com.aliyun.svideo.base.beauty.api.OnDefaultBeautyLevelChangeListener onDefaultBeautyLevelChangeListener);

    com.aliyun.svideo.base.beauty.api.constant.BeautySDKType getSdkType();

    java.lang.String getVersion();

    void init(android.content.Context context, com.aliyun.svideo.base.beauty.api.IAliyunBeautyInitCallback iAliyunBeautyInitCallback);

    void initParams();

    void onFrameBack(byte[] bArr, int i, int i2, android.hardware.Camera.CameraInfo cameraInfo);

    int onTextureIdBack(int i, int i2, int i3, float[] fArr, int i4);

    void release();

    void setDebug(boolean z);

    void setDeviceOrientation(int i, int i2);

    void showControllerView(androidx.fragment.app.FragmentManager fragmentManager, com.aliyun.svideo.base.beauty.api.OnBeautyLayoutChangeListener onBeautyLayoutChangeListener);
}
