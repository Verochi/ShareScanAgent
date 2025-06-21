package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum VideoCodec implements com.otaliastudios.cameraview.controls.Control {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);

    private int value;
    static final com.otaliastudios.cameraview.controls.VideoCodec DEFAULT = DEVICE_DEFAULT;

    VideoCodec(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.VideoCodec fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.VideoCodec videoCodec : values()) {
            if (videoCodec.value() == i) {
                return videoCodec;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
