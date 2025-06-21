package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class ExposureMeter extends com.otaliastudios.cameraview.engine.meter.BaseMeter {
    public static final com.otaliastudios.cameraview.CameraLogger k = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.meter.ExposureMeter.class.getSimpleName());
    public boolean i;
    public boolean j;

    public ExposureMeter(@androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.MeteringRectangle> list, boolean z) {
        super(list, z);
        this.i = false;
        this.j = false;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkIsSupported(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        boolean z = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2;
        java.lang.Integer num = (java.lang.Integer) actionHolder.getBuilder(this).get(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE);
        boolean z2 = num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5);
        this.j = !z;
        boolean z3 = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue() > 0;
        this.i = z3;
        boolean z4 = z2 && (this.j || z3);
        k.i("checkIsSupported:", java.lang.Boolean.valueOf(z4), "trigger:", java.lang.Boolean.valueOf(this.j), "areas:", java.lang.Boolean.valueOf(this.i));
        return z4;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public boolean checkShouldSkip(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        android.hardware.camera2.TotalCaptureResult lastResult = actionHolder.getLastResult(this);
        if (lastResult == null) {
            k.i("checkShouldSkip: false - lastResult is null.");
            return false;
        }
        java.lang.Integer num = (java.lang.Integer) lastResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_STATE);
        boolean z = num != null && num.intValue() == 2;
        k.i("checkShouldSkip:", java.lang.Boolean.valueOf(z));
        return z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        java.lang.Integer num = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_STATE);
        java.lang.Integer num2 = (java.lang.Integer) totalCaptureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        k.i("onCaptureCompleted:", "aeState:", num, "aeTriggerState:", num2);
        if (num == null) {
            return;
        }
        if (getState() == 0) {
            int intValue = num.intValue();
            if (intValue != 2) {
                if (intValue == 3) {
                    setSuccessful(false);
                    setState(Integer.MAX_VALUE);
                } else if (intValue != 4) {
                    if (intValue == 5) {
                        setState(1);
                    }
                }
            }
            if (num2 != null && num2.intValue() == 1) {
                setSuccessful(true);
                setState(Integer.MAX_VALUE);
            }
        }
        if (getState() == 1) {
            int intValue2 = num.intValue();
            if (intValue2 != 2) {
                if (intValue2 == 3) {
                    setSuccessful(false);
                    setState(Integer.MAX_VALUE);
                    return;
                } else if (intValue2 != 4) {
                    return;
                }
            }
            setSuccessful(true);
            setState(Integer.MAX_VALUE);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void onCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
        super.onCompleted(actionHolder);
        actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, null);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    public void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.MeteringRectangle> list) {
        k.i("onStarted:", "with areas:", list);
        if (this.i && !list.isEmpty()) {
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AE_REGIONS, list.subList(0, java.lang.Math.min(((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue(), list.size())).toArray(new android.hardware.camera2.params.MeteringRectangle[0]));
        }
        if (this.j) {
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        actionHolder.applyBuilder(this);
        if (this.j) {
            setState(0);
        } else {
            setState(1);
        }
    }
}
