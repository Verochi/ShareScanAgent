package com.otaliastudios.cameraview.preview;

/* loaded from: classes19.dex */
public interface FilterCameraPreview {
    @androidx.annotation.NonNull
    com.otaliastudios.cameraview.filter.Filter getCurrentFilter();

    void setFilter(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter);
}
