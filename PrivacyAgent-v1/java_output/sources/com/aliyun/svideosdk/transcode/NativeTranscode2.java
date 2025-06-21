package com.aliyun.svideosdk.transcode;

/* loaded from: classes12.dex */
public class NativeTranscode2 extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader {
    long jniHandle = nativeCreate();

    public interface TranscodeCallback {
        void onError(int i);

        void onExit();

        void onProgress(int i);
    }

    private native long nativeCreate();

    private native void nativeDispose(long j);

    private static native long nativeGetDuration(long j);

    private static native int nativeInit(long j, java.lang.Object obj);

    private native void nativeSetExtraParam(long j, int i, int i2);

    private static native int nativeStart(long j);

    private static native void nativeStop(long j);

    private native void nativeUninit(long j);

    public void cancel() {
        long j = this.jniHandle;
        if (j != 0) {
            nativeStop(j);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid Jni Handle ");
        sb.append(this.jniHandle);
    }

    public void dispose() {
        long j = this.jniHandle;
        if (j != 0) {
            nativeDispose(j);
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Invalid Jni Handle ");
            sb.append(this.jniHandle);
        }
        this.jniHandle = 0L;
    }

    public long getDuration() {
        long j = this.jniHandle;
        if (j != 0) {
            return nativeGetDuration(j);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid Jni Handle ");
        sb.append(this.jniHandle);
        return 0L;
    }

    public int init(com.aliyun.svideosdk.transcode.NativeTranscode2InitStruct nativeTranscode2InitStruct) {
        long j = this.jniHandle;
        if (j != 0) {
            return nativeInit(j, nativeTranscode2InitStruct);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid Jni Handle ");
        sb.append(this.jniHandle);
        return -4;
    }

    public void setExtraParam(int i, int i2) {
        long j = this.jniHandle;
        if (j != 0) {
            nativeSetExtraParam(j, i, i2);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid Jni Handle ");
        sb.append(this.jniHandle);
    }

    public int start() {
        long j = this.jniHandle;
        if (j != 0) {
            return nativeStart(j);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid Jni Handle ");
        sb.append(this.jniHandle);
        return -4;
    }

    public void uninit() {
        long j = this.jniHandle;
        if (j != 0) {
            nativeUninit(j);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Invalid Jni Handle ");
        sb.append(this.jniHandle);
    }
}
