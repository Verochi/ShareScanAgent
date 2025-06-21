package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class MeterAction extends com.otaliastudios.cameraview.engine.action.ActionWrapper {
    public static final com.otaliastudios.cameraview.CameraLogger j = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.meter.MeterAction.class.getSimpleName());
    public java.util.List<com.otaliastudios.cameraview.engine.meter.BaseMeter> e;
    public com.otaliastudios.cameraview.engine.action.BaseAction f;
    public final com.otaliastudios.cameraview.metering.MeteringRegions g;
    public final com.otaliastudios.cameraview.engine.CameraEngine h;
    public final boolean i;

    public MeterAction(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.CameraEngine cameraEngine, @androidx.annotation.Nullable com.otaliastudios.cameraview.metering.MeteringRegions meteringRegions, boolean z) {
        this.g = meteringRegions;
        this.h = cameraEngine;
        this.i = z;
    }

    public final void a(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        java.util.List arrayList = new java.util.ArrayList();
        if (this.g != null) {
            com.otaliastudios.cameraview.engine.metering.Camera2MeteringTransform camera2MeteringTransform = new com.otaliastudios.cameraview.engine.metering.Camera2MeteringTransform(this.h.getAngles(), this.h.getPreview().getSurfaceSize(), this.h.getPreviewStreamSize(com.otaliastudios.cameraview.engine.offset.Reference.VIEW), this.h.getPreview().isCropping(), actionHolder.getCharacteristics(this), actionHolder.getBuilder(this));
            arrayList = this.g.transform(camera2MeteringTransform).get(Integer.MAX_VALUE, camera2MeteringTransform);
        }
        com.otaliastudios.cameraview.engine.meter.ExposureMeter exposureMeter = new com.otaliastudios.cameraview.engine.meter.ExposureMeter(arrayList, this.i);
        com.otaliastudios.cameraview.engine.meter.FocusMeter focusMeter = new com.otaliastudios.cameraview.engine.meter.FocusMeter(arrayList, this.i);
        com.otaliastudios.cameraview.engine.meter.WhiteBalanceMeter whiteBalanceMeter = new com.otaliastudios.cameraview.engine.meter.WhiteBalanceMeter(arrayList, this.i);
        this.e = java.util.Arrays.asList(exposureMeter, focusMeter, whiteBalanceMeter);
        this.f = com.otaliastudios.cameraview.engine.action.Actions.together(exposureMeter, focusMeter, whiteBalanceMeter);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.engine.action.BaseAction getAction() {
        return this.f;
    }

    public boolean isSuccessful() {
        java.util.Iterator<com.otaliastudios.cameraview.engine.meter.BaseMeter> it = this.e.iterator();
        while (it.hasNext()) {
            if (!it.next().isSuccessful()) {
                j.i("isSuccessful:", "returning false.");
                return false;
            }
        }
        j.i("isSuccessful:", "returning true.");
        return true;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = j;
        cameraLogger.w("onStart:", "initializing.");
        a(actionHolder);
        cameraLogger.w("onStart:", "initialized.");
        super.onStart(actionHolder);
    }
}
