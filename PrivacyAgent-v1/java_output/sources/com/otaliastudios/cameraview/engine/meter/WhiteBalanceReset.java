package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class WhiteBalanceReset extends com.otaliastudios.cameraview.engine.meter.BaseReset {
    public static final com.otaliastudios.cameraview.CameraLogger f = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.meter.WhiteBalanceReset.class.getSimpleName());

    public WhiteBalanceReset() {
        super(true);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    public void onStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.Nullable android.hardware.camera2.params.MeteringRectangle meteringRectangle) {
        f.w("onStarted:", "with area:", meteringRectangle);
        int intValue = ((java.lang.Integer) readCharacteristic(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AWB_REGIONS, new android.hardware.camera2.params.MeteringRectangle[]{meteringRectangle});
            actionHolder.applyBuilder(this);
        }
        setState(Integer.MAX_VALUE);
    }
}
