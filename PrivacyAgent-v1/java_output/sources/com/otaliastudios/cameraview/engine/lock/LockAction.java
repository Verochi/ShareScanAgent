package com.otaliastudios.cameraview.engine.lock;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class LockAction extends com.otaliastudios.cameraview.engine.action.ActionWrapper {
    public final com.otaliastudios.cameraview.engine.action.BaseAction e = com.otaliastudios.cameraview.engine.action.Actions.together(new com.otaliastudios.cameraview.engine.lock.ExposureLock(), new com.otaliastudios.cameraview.engine.lock.FocusLock(), new com.otaliastudios.cameraview.engine.lock.WhiteBalanceLock());

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.engine.action.BaseAction getAction() {
        return this.e;
    }
}
