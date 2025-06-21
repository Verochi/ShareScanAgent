package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum Mode implements com.otaliastudios.cameraview.controls.Control {
    PICTURE(0),
    VIDEO(1);

    private int value;
    static final com.otaliastudios.cameraview.controls.Mode DEFAULT = PICTURE;

    Mode(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.Mode fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.Mode mode : values()) {
            if (mode.value() == i) {
                return mode;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
