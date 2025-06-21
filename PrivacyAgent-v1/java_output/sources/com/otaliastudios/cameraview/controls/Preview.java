package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public enum Preview implements com.otaliastudios.cameraview.controls.Control {
    SURFACE(0),
    TEXTURE(1),
    GL_SURFACE(2);

    private int value;
    static final com.otaliastudios.cameraview.controls.Preview DEFAULT = GL_SURFACE;

    Preview(int i) {
        this.value = i;
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.controls.Preview fromValue(int i) {
        for (com.otaliastudios.cameraview.controls.Preview preview : values()) {
            if (preview.value() == i) {
                return preview;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
