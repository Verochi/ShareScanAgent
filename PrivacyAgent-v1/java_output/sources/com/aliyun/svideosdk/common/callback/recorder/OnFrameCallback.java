package com.aliyun.svideosdk.common.callback.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface OnFrameCallback {
    android.hardware.Camera.Size onChoosePreviewSize(java.util.List<android.hardware.Camera.Size> list, android.hardware.Camera.Size size);

    void onFrameBack(byte[] bArr, int i, int i2, android.hardware.Camera.CameraInfo cameraInfo);

    void openFailed();
}
