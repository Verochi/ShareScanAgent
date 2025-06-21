package com.otaliastudios.cameraview;

/* loaded from: classes19.dex */
public class CameraException extends java.lang.RuntimeException {
    public static final int REASON_DISCONNECTED = 3;
    public static final int REASON_FAILED_TO_CONNECT = 1;
    public static final int REASON_FAILED_TO_START_PREVIEW = 2;
    public static final int REASON_NO_CAMERA = 6;
    public static final int REASON_PICTURE_FAILED = 4;
    public static final int REASON_UNKNOWN = 0;
    public static final int REASON_VIDEO_FAILED = 5;
    private int reason;

    public CameraException(int i) {
        this.reason = i;
    }

    public CameraException(java.lang.Throwable th) {
        super(th);
        this.reason = 0;
    }

    public CameraException(java.lang.Throwable th, int i) {
        super(th);
        this.reason = i;
    }

    public int getReason() {
        return this.reason;
    }

    public boolean isUnrecoverable() {
        int reason = getReason();
        return reason == 1 || reason == 2 || reason == 3;
    }
}
