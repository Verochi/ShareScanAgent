package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum Facing implements com.otaliastudios.cameraview.controls.Control {
    BACK(0),
    FRONT(1);

    private int value;

    Facing(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.Facing DEFAULT(@androidx.annotation.Nullable android.content.Context context) {
        if (context == null) {
            return BACK;
        }
        com.otaliastudios.cameraview.controls.Facing facing = BACK;
        if (com.otaliastudios.cameraview.CameraUtils.hasCameraFacing(context, facing)) {
            return facing;
        }
        com.otaliastudios.cameraview.controls.Facing facing2 = FRONT;
        return com.otaliastudios.cameraview.CameraUtils.hasCameraFacing(context, facing2) ? facing2 : facing;
    }

    @androidx.annotation.Nullable
    public static com.otaliastudios.cameraview.controls.Facing fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.Facing facing : values()) {
            if (facing.value() == i) {
                return facing;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
