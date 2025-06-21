package com.otaliastudios.cameraview.filter;

/* loaded from: classes19.dex */
public interface Filter {
    @androidx.annotation.NonNull
    com.otaliastudios.cameraview.filter.Filter copy();

    void draw(long j, @androidx.annotation.NonNull float[] fArr);

    @androidx.annotation.NonNull
    java.lang.String getFragmentShader();

    @androidx.annotation.NonNull
    java.lang.String getVertexShader();

    void onCreate(int i);

    void onDestroy();

    void setSize(int i, int i2);
}
