package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum PictureFormat implements com.otaliastudios.cameraview.controls.Control {
    JPEG(0),
    DNG(1);

    private int value;
    static final com.otaliastudios.cameraview.controls.PictureFormat DEFAULT = JPEG;

    PictureFormat(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.PictureFormat fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.PictureFormat pictureFormat : values()) {
            if (pictureFormat.value() == i) {
                return pictureFormat;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
