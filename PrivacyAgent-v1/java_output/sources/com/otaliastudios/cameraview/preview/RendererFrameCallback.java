package com.otaliastudios.cameraview.preview;

/* loaded from: classes19.dex */
public interface RendererFrameCallback {
    @com.otaliastudios.cameraview.preview.RendererThread
    void onRendererFilterChanged(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter);

    @com.otaliastudios.cameraview.preview.RendererThread
    void onRendererFrame(@androidx.annotation.NonNull android.graphics.SurfaceTexture surfaceTexture, int i, float f, float f2);

    @com.otaliastudios.cameraview.preview.RendererThread
    void onRendererTextureCreated(int i);
}
