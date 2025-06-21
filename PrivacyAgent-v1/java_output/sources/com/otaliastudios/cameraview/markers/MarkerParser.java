package com.otaliastudios.cameraview.markers;

/* loaded from: classes19.dex */
public class MarkerParser {
    public com.otaliastudios.cameraview.markers.AutoFocusMarker a;

    public MarkerParser(@androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        this.a = null;
        java.lang.String string = typedArray.getString(com.otaliastudios.cameraview.R.styleable.CameraView_cameraAutoFocusMarker);
        if (string != null) {
            try {
                this.a = (com.otaliastudios.cameraview.markers.AutoFocusMarker) java.lang.Class.forName(string).newInstance();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.markers.AutoFocusMarker getAutoFocusMarker() {
        return this.a;
    }
}
