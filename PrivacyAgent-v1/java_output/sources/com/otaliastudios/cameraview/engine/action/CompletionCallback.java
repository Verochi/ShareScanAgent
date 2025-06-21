package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public abstract class CompletionCallback implements com.otaliastudios.cameraview.engine.action.ActionCallback {
    public abstract void onActionCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action);

    @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
    public final void onActionStateChanged(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action, int i) {
        if (i == Integer.MAX_VALUE) {
            onActionCompleted(action);
        }
    }
}
