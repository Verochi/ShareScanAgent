package com.otaliastudios.cameraview.engine.orchestrator;

/* loaded from: classes19.dex */
public enum CameraState {
    OFF(0),
    ENGINE(1),
    BIND(2),
    PREVIEW(3);

    private int mState;

    CameraState(int i) {
        this.mState = i;
    }

    public boolean isAtLeast(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState) {
        return this.mState >= cameraState.mState;
    }
}
