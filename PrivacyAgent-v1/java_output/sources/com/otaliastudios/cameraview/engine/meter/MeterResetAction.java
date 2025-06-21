package com.otaliastudios.cameraview.engine.meter;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class MeterResetAction extends com.otaliastudios.cameraview.engine.action.ActionWrapper {
    public final com.otaliastudios.cameraview.engine.action.BaseAction e = com.otaliastudios.cameraview.engine.action.Actions.together(new com.otaliastudios.cameraview.engine.meter.ExposureReset(), new com.otaliastudios.cameraview.engine.meter.FocusReset(), new com.otaliastudios.cameraview.engine.meter.WhiteBalanceReset());

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.engine.action.BaseAction getAction() {
        return this.e;
    }
}
