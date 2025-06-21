package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum Engine implements com.otaliastudios.cameraview.controls.Control {
    CAMERA1(0),
    CAMERA2(1);

    private int value;
    static final com.otaliastudios.cameraview.controls.Engine DEFAULT = CAMERA1;

    Engine(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.Engine fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.Engine engine : values()) {
            if (engine.value() == i) {
                return engine;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
