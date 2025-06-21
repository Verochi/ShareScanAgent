package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum Flash implements com.otaliastudios.cameraview.controls.Control {
    OFF(0),
    ON(1),
    AUTO(2),
    TORCH(3);

    private int value;
    static final com.otaliastudios.cameraview.controls.Flash DEFAULT = OFF;

    Flash(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.Flash fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.Flash flash : values()) {
            if (flash.value() == i) {
                return flash;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
