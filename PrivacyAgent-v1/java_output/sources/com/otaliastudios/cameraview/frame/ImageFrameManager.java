package com.otaliastudios.cameraview.frame;

@androidx.annotation.RequiresApi(19)
/* loaded from: classes19.dex */
public class ImageFrameManager extends com.otaliastudios.cameraview.frame.FrameManager<android.media.Image> {
    public ImageFrameManager(int i) {
        super(i, android.media.Image.class);
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    @androidx.annotation.NonNull
    public android.media.Image onCloneFrameData(@androidx.annotation.NonNull android.media.Image image) {
        throw new java.lang.RuntimeException("Cannot freeze() an Image Frame. Please consider using the frame synchronously in your process() method, which also gives better performance.");
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    public void onFrameDataReleased(@androidx.annotation.NonNull android.media.Image image, boolean z) {
        try {
            image.close();
        } catch (java.lang.Exception unused) {
        }
    }
}
