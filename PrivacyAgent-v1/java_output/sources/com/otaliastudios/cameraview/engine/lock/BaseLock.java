package com.otaliastudios.cameraview.engine.lock;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public abstract class BaseLock extends com.otaliastudios.cameraview.engine.action.BaseAction {
    public abstract boolean checkIsSupported(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder);

    public abstract boolean checkShouldSkip(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder);

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onStart(actionHolder);
        boolean checkShouldSkip = checkShouldSkip(actionHolder);
        if (!checkIsSupported(actionHolder) || checkShouldSkip) {
            setState(Integer.MAX_VALUE);
        } else {
            onStarted(actionHolder);
        }
    }

    public abstract void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder);
}
