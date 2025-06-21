package com.hbzhou.open.flowcamera.listener;

/* loaded from: classes22.dex */
public interface FlowCameraListener {
    void captureSuccess(@androidx.annotation.NonNull java.io.File file);

    void onError(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.Throwable th);

    void recordSuccess(@androidx.annotation.NonNull java.io.File file, int i);
}
