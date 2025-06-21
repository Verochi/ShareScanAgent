package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum WhiteBalance implements com.otaliastudios.cameraview.controls.Control {
    AUTO(0),
    INCANDESCENT(1),
    FLUORESCENT(2),
    DAYLIGHT(3),
    CLOUDY(4);

    private int value;
    static final com.otaliastudios.cameraview.controls.WhiteBalance DEFAULT = AUTO;

    WhiteBalance(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.WhiteBalance fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance : values()) {
            if (whiteBalance.value() == i) {
                return whiteBalance;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
