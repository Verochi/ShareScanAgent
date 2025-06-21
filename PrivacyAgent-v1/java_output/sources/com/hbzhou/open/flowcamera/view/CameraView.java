package com.hbzhou.open.flowcamera.view;

/* loaded from: classes22.dex */
public interface CameraView {
    void confirmState(int i);

    boolean handlerFoucs(float f, float f2);

    void playVideo(android.graphics.Bitmap bitmap, java.lang.String str);

    void resetState(int i);

    void setTip(java.lang.String str);

    void showPicture(android.graphics.Bitmap bitmap, boolean z);

    void startPreviewCallback();

    void stopVideo();
}
