package com.otaliastudios.cameraview.markers;

/* loaded from: classes19.dex */
public interface AutoFocusMarker extends com.otaliastudios.cameraview.markers.Marker {
    void onAutoFocusEnd(@androidx.annotation.NonNull com.otaliastudios.cameraview.markers.AutoFocusTrigger autoFocusTrigger, boolean z, @androidx.annotation.NonNull android.graphics.PointF pointF);

    void onAutoFocusStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.markers.AutoFocusTrigger autoFocusTrigger, @androidx.annotation.NonNull android.graphics.PointF pointF);
}
