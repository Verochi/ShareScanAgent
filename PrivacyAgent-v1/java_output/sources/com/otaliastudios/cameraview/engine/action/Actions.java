package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class Actions {
    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.engine.action.BaseAction sequence(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.BaseAction... baseActionArr) {
        return new com.otaliastudios.cameraview.engine.action.SequenceAction(java.util.Arrays.asList(baseActionArr));
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.engine.action.BaseAction timeout(long j, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.BaseAction baseAction) {
        return new com.otaliastudios.cameraview.engine.action.TimeoutAction(j, baseAction);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.engine.action.BaseAction together(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.BaseAction... baseActionArr) {
        return new com.otaliastudios.cameraview.engine.action.TogetherAction(java.util.Arrays.asList(baseActionArr));
    }
}
