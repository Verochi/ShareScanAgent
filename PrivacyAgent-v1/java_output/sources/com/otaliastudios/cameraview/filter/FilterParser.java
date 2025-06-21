package com.otaliastudios.cameraview.filter;

/* loaded from: classes19.dex */
public class FilterParser {
    public com.otaliastudios.cameraview.filter.Filter a;

    public FilterParser(@androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        this.a = null;
        try {
            this.a = (com.otaliastudios.cameraview.filter.Filter) java.lang.Class.forName(typedArray.getString(com.otaliastudios.cameraview.R.styleable.CameraView_cameraFilter)).newInstance();
        } catch (java.lang.Exception unused) {
            this.a = new com.otaliastudios.cameraview.filter.NoFilter();
        }
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.filter.Filter getFilter() {
        return this.a;
    }
}
