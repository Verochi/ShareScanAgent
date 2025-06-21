package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum AudioCodec implements com.otaliastudios.cameraview.controls.Control {
    DEVICE_DEFAULT(0),
    AAC(1),
    HE_AAC(2),
    AAC_ELD(3);

    private int value;
    static final com.otaliastudios.cameraview.controls.AudioCodec DEFAULT = DEVICE_DEFAULT;

    AudioCodec(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.AudioCodec fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.AudioCodec audioCodec : values()) {
            if (audioCodec.value() == i) {
                return audioCodec;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
