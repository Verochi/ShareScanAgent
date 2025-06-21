package com.aliyun.svideosdk.common.struct.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class CameraParam {
    public static final int FOCUS_MODE_AUTO = 1;
    public static final int FOCUS_MODE_CONTINUE = 0;
    private java.lang.String flashType;
    private float zoomRatio;
    private int focusMode = 0;
    private float exposureCompensation = 0.5f;

    public float getExposureCompensationRatio() {
        return this.exposureCompensation;
    }

    public java.lang.String getFlashType() {
        return this.flashType;
    }

    public int getFocusMode() {
        return this.focusMode;
    }

    public float getZoomRatio() {
        return this.zoomRatio;
    }

    public void setExposureCompensationRatio(float f) {
        this.exposureCompensation = f;
    }

    public void setFlashType(java.lang.String str) {
        this.flashType = str;
    }

    public void setFocusMode(int i) {
        this.focusMode = i;
    }

    public void setZoomRatio(float f) {
        this.zoomRatio = f;
    }
}
