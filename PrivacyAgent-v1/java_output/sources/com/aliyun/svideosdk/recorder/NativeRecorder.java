package com.aliyun.svideosdk.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class NativeRecorder extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader {
    private static final int DEFAULT_LAYOUT_ID = com.aliyun.svideosdk.c.a.DEFAULT_LAYER.a();
    private static final java.lang.String TAG = com.aliyun.svideosdk.recorder.NativeRecorder.class.getSimpleName();
    private long mNativeHandle;
    private com.aliyun.svideosdk.common.AliyunStickerManager mStickerManager;

    @com.aliyun.Visible
    public interface CallBack {
        void onDuration(long j);

        void onEncoderInfoBack(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9);

        void onError(int i);

        void onExit(int i, long j, long j2);
    }

    @com.aliyun.Visible
    public interface ScreenshotCallback {
        void onScreenshot(int i, int i2, byte[] bArr, int i3);
    }

    @com.aliyun.Visible
    public interface TextureCallback {
        int onDestroyTexture();

        int onPostTexture(int i, int i2, int i3);

        int onPreTexture(int i, int i2, int i3);
    }

    public NativeRecorder(long j) {
        this(j, false);
    }

    public NativeRecorder(long j, boolean z) {
        long prepare = prepare(j, z);
        this.mNativeHandle = prepare;
        if (prepare == 0) {
            nativeInitError();
        }
    }

    public static native void cancel(long j);

    public static native int clearBackground(long j);

    public static native int createTexture(long j);

    public static native int nativeAddAudioBuffer(long j, long j2, byte[] bArr, int i);

    public static native int nativeAddSource(long j, long j2);

    public static native int nativeAddVideoBuffer(long j, long j2, int i);

    public static native int nativeAddVideoBufferBitmap(long j, long j2, android.graphics.Bitmap bitmap);

    public static native void nativeDestroyGlobalStickerManager(long j);

    public static native long nativeGetGlobalStickerManager();

    private void nativeInitError() {
    }

    public static native int nativeRemoveSource(long j, long j2);

    public static native int nativeUpdateGlobalStickers(long j, long j2);

    public static native int nativeUpdateSource(long j, long j2);

    public static native long prepare(long j, boolean z);

    public static native void release(long j);

    public static native int seek(long j, long j2);

    public static native int setBackground(long j, long j2, android.graphics.Bitmap bitmap, int i);

    public static native void setCallback(long j, java.lang.Object obj);

    public static native void setParam(long j, int i, int i2);

    public static native void setScreenshotCallback(long j, java.lang.Object obj);

    public static native void setTextureCallback(long j, long j2, java.lang.Object obj);

    public static native void setVideoSize(long j, int i, int i2);

    public static native int setVideoTempo(long j, float f);

    public static native int start(long j, java.lang.String str, long j2);

    public static native int startPreview(long j);

    public static native int stitchPart(long j, java.lang.String[] strArr, int i, java.lang.String str);

    public static native int stop(long j);

    public static native void takePhoto(long j, long j2);

    public int addAudioBuffer(com.aliyun.svideosdk.common.AliyunRecordBaseSource aliyunRecordBaseSource, byte[] bArr, int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeAddAudioBuffer(j, aliyunRecordBaseSource.getNativeHandle(), bArr, i);
        }
        nativeInitError();
        return -1;
    }

    public int addSource(com.aliyun.svideosdk.common.AliyunRecordBaseSource aliyunRecordBaseSource) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeAddSource(j, aliyunRecordBaseSource.getNativeHandle());
        }
        nativeInitError();
        return -1;
    }

    public void addVideoBuffer(com.aliyun.svideosdk.common.AliyunRecordVideoSource aliyunRecordVideoSource, int i) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            nativeAddVideoBuffer(j, aliyunRecordVideoSource.getNativeHandle(), i);
        }
    }

    public void addVideoBufferBitmap(com.aliyun.svideosdk.common.AliyunRecordVideoSource aliyunRecordVideoSource, android.graphics.Bitmap bitmap) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            nativeAddVideoBufferBitmap(j, aliyunRecordVideoSource.getNativeHandle(), bitmap);
        }
    }

    public void cancel() {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            cancel(j);
        }
    }

    public int clearBackground() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return clearBackground(j);
        }
        nativeInitError();
        return -1;
    }

    public int createTexture() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return createTexture(j);
        }
        nativeInitError();
        return -1;
    }

    public com.aliyun.svideosdk.common.AliyunStickerManager getGlobalStickerManager() {
        if (this.mStickerManager == null) {
            this.mStickerManager = new com.aliyun.svideosdk.common.AliyunStickerManager(nativeGetGlobalStickerManager());
        }
        return this.mStickerManager;
    }

    public void release() {
        if (this.mNativeHandle == 0) {
            nativeInitError();
            return;
        }
        releaseGlobalStickerManager();
        release(this.mNativeHandle);
        this.mNativeHandle = 0L;
    }

    public void releaseGlobalStickerManager() {
        com.aliyun.svideosdk.common.AliyunStickerManager aliyunStickerManager = this.mStickerManager;
        if (aliyunStickerManager != null) {
            nativeDestroyGlobalStickerManager(aliyunStickerManager.getNativeHandle());
            this.mStickerManager.setNativeHandle(0L);
            this.mStickerManager = null;
        }
    }

    public int removeSource(com.aliyun.svideosdk.common.AliyunRecordBaseSource aliyunRecordBaseSource) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeRemoveSource(j, aliyunRecordBaseSource.getNativeHandle());
        }
        nativeInitError();
        return -1;
    }

    public int seek(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            return seek(j2, j);
        }
        nativeInitError();
        return -1;
    }

    public int setBackground(long j, android.graphics.Bitmap bitmap, int i) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            return setBackground(j2, j, bitmap, i);
        }
        nativeInitError();
        return -1;
    }

    public void setCallback(java.lang.Object obj) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setCallback(j, obj);
        }
    }

    public void setParam(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setParam(j, i, i2);
        }
    }

    public void setScreenshotCallback(com.aliyun.svideosdk.recorder.NativeRecorder.ScreenshotCallback screenshotCallback) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setScreenshotCallback(j, screenshotCallback);
        }
    }

    public void setTextureCallback(com.aliyun.svideosdk.common.AliyunRecordVideoSource aliyunRecordVideoSource, com.aliyun.svideosdk.recorder.NativeRecorder.TextureCallback textureCallback) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setTextureCallback(j, aliyunRecordVideoSource.getNativeHandle(), textureCallback);
        }
    }

    public void setVideoSize(int i, int i2) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            setVideoSize(j, i, i2);
        }
    }

    public int setVideoTempo(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return setVideoTempo(j, f);
        }
        nativeInitError();
        return -1;
    }

    public int start(java.lang.String str) {
        return start(str, -1L);
    }

    public int start(java.lang.String str, long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            return start(j2, str, j);
        }
        nativeInitError();
        return -1;
    }

    public int startPreview() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return startPreview(j);
        }
        nativeInitError();
        return -1;
    }

    public int stitchPart(java.lang.String[] strArr, int i, java.lang.String str) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return stitchPart(j, strArr, i, str);
        }
        nativeInitError();
        return -1;
    }

    public int stop() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return stop(j);
        }
        nativeInitError();
        return -1;
    }

    public void takePhoto(com.aliyun.svideosdk.common.AliyunRecordVideoSource aliyunRecordVideoSource) {
        long j = this.mNativeHandle;
        if (j == 0) {
            nativeInitError();
        } else {
            takePhoto(j, aliyunRecordVideoSource.getNativeHandle());
        }
    }

    public void updateGlobalStickers() {
        com.aliyun.svideosdk.common.AliyunStickerManager aliyunStickerManager = this.mStickerManager;
        if (aliyunStickerManager != null) {
            nativeUpdateGlobalStickers(this.mNativeHandle, aliyunStickerManager.getNativeHandle());
        }
    }

    public int updateSource(com.aliyun.svideosdk.common.AliyunRecordBaseSource aliyunRecordBaseSource) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeUpdateSource(j, aliyunRecordBaseSource.getNativeHandle());
        }
        nativeInitError();
        return -1;
    }
}
