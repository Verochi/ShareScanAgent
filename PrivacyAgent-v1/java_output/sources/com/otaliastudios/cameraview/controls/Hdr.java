package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum Hdr implements com.otaliastudios.cameraview.controls.Control {
    OFF(0),
    ON(1);

    private int value;
    static final com.otaliastudios.cameraview.controls.Hdr DEFAULT = OFF;

    Hdr(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.Hdr fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.Hdr hdr : values()) {
            if (hdr.value() == i) {
                return hdr;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
