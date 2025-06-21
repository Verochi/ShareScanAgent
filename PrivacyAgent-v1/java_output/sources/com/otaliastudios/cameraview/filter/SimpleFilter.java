package com.otaliastudios.cameraview.filter;

/* loaded from: classes19.dex */
public final class SimpleFilter extends com.otaliastudios.cameraview.filter.BaseFilter {
    public final java.lang.String e;

    public SimpleFilter(@androidx.annotation.NonNull java.lang.String str) {
        this.e = str;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.filter.BaseFilter onCopy() {
        return new com.otaliastudios.cameraview.filter.SimpleFilter(this.e);
    }
}
