package com.otaliastudios.cameraview.overlay;

/* loaded from: classes19.dex */
public interface Overlay {

    public enum Target {
        PREVIEW,
        PICTURE_SNAPSHOT,
        VIDEO_SNAPSHOT
    }

    void drawOn(@androidx.annotation.NonNull com.otaliastudios.cameraview.overlay.Overlay.Target target, @androidx.annotation.NonNull android.graphics.Canvas canvas);

    boolean drawsOn(@androidx.annotation.NonNull com.otaliastudios.cameraview.overlay.Overlay.Target target);
}
