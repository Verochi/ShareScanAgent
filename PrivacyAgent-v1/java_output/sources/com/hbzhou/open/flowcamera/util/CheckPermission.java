package com.hbzhou.open.flowcamera.util;

/* loaded from: classes22.dex */
public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;

    public static int getRecordState() {
        int minBufferSize = android.media.AudioRecord.getMinBufferSize(44100, 16, 2);
        android.media.AudioRecord audioRecord = new android.media.AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                return -1;
            }
            if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                return -2;
            }
            audioRecord.stop();
            audioRecord.release();
            return 1;
        } catch (java.lang.Exception unused) {
            audioRecord.release();
            return -2;
        }
    }

    public static synchronized boolean isCameraUseable(int i) {
        boolean z;
        synchronized (com.hbzhou.open.flowcamera.util.CheckPermission.class) {
            android.hardware.Camera camera = null;
            try {
                try {
                    try {
                        camera = android.hardware.Camera.open(i);
                        camera.setParameters(camera.getParameters());
                        camera.release();
                        z = true;
                    } finally {
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    if (camera != null) {
                        camera.release();
                    }
                    z = false;
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
