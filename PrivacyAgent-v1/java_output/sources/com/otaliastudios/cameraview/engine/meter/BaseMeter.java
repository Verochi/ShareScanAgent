package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public abstract class BaseMeter extends com.otaliastudios.cameraview.engine.action.BaseAction {
    public static final com.otaliastudios.cameraview.CameraLogger h = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.meter.BaseMeter.class.getSimpleName());
    public final java.util.List<android.hardware.camera2.params.MeteringRectangle> e;
    public boolean f;
    public boolean g;

    public BaseMeter(@androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.MeteringRectangle> list, boolean z) {
        this.e = list;
        this.g = z;
    }

    public abstract boolean checkIsSupported(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder);

    public abstract boolean checkShouldSkip(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder);

    public boolean isSuccessful() {
        return this.f;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onStart(actionHolder);
        boolean z = this.g && checkShouldSkip(actionHolder);
        if (checkIsSupported(actionHolder) && !z) {
            h.i("onStart:", "supported and not skipped. Dispatching onStarted.");
            onStarted(actionHolder, this.e);
        } else {
            h.i("onStart:", "not supported or skipped. Dispatching COMPLETED state.");
            setSuccessful(true);
            setState(Integer.MAX_VALUE);
        }
    }

    public abstract void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.MeteringRectangle> list);

    public void setSuccessful(boolean z) {
        this.f = z;
    }
}
