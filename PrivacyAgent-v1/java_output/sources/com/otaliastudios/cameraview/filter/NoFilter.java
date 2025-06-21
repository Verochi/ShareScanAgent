package com.otaliastudios.cameraview.filter;

/* loaded from: classes19.dex */
public final class NoFilter extends com.otaliastudios.cameraview.filter.BaseFilter {
    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return createDefaultFragmentShader();
    }
}
