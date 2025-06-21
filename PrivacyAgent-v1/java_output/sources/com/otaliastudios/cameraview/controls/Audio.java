package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum Audio implements com.otaliastudios.cameraview.controls.Control {
    OFF(0),
    ON(1),
    MONO(2),
    STEREO(3);

    private int value;
    static final com.otaliastudios.cameraview.controls.Audio DEFAULT = ON;

    Audio(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.Audio fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.Audio audio : values()) {
            if (audio.value() == i) {
                return audio;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
