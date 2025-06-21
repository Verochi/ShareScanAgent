package com.otaliastudios.cameraview.engine.action;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public abstract class BaseAction implements com.otaliastudios.cameraview.engine.action.Action {
    public final java.util.List<com.otaliastudios.cameraview.engine.action.ActionCallback> a = new java.util.ArrayList();
    public int b;
    public com.otaliastudios.cameraview.engine.action.ActionHolder c;
    public boolean d;

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final void abort(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        actionHolder.removeAction(this);
        if (!isCompleted()) {
            onAbort(actionHolder);
            setState(Integer.MAX_VALUE);
        }
        this.d = false;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void addCallback(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionCallback actionCallback) {
        if (this.a.contains(actionCallback)) {
            return;
        }
        this.a.add(actionCallback);
        actionCallback.onActionStateChanged(this, getState());
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.engine.action.ActionHolder getHolder() {
        return this.c;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final int getState() {
        return this.b;
    }

    public boolean isCompleted() {
        return this.b == Integer.MAX_VALUE;
    }

    public void onAbort(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureProgressed(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.CaptureResult captureResult) {
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    @androidx.annotation.CallSuper
    public void onCaptureStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest) {
        if (this.d) {
            onStart(actionHolder);
            this.d = false;
        }
    }

    public void onCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
    }

    @androidx.annotation.CallSuper
    public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        this.c = actionHolder;
    }

    @androidx.annotation.NonNull
    public <T> T readCharacteristic(@androidx.annotation.NonNull android.hardware.camera2.CameraCharacteristics.Key<T> key, @androidx.annotation.NonNull T t) {
        T t2 = (T) this.c.getCharacteristics(this).get(key);
        return t2 == null ? t : t2;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void removeCallback(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionCallback actionCallback) {
        this.a.remove(actionCallback);
    }

    public final void setState(int i) {
        if (i != this.b) {
            this.b = i;
            java.util.Iterator<com.otaliastudios.cameraview.engine.action.ActionCallback> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActionStateChanged(this, this.b);
            }
            if (this.b == Integer.MAX_VALUE) {
                this.c.removeAction(this);
                onCompleted(this.c);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final void start(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        this.c = actionHolder;
        actionHolder.addAction(this);
        if (actionHolder.getLastResult(this) != null) {
            onStart(actionHolder);
        } else {
            this.d = true;
        }
    }
}
