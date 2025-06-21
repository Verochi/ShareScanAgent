package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum Grid implements com.otaliastudios.cameraview.controls.Control {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);

    private int value;
    static final com.otaliastudios.cameraview.controls.Grid DEFAULT = OFF;

    Grid(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.Grid fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.Grid grid : values()) {
            if (grid.value() == i) {
                return grid;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
