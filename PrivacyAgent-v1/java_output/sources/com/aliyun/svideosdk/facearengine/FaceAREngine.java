package com.aliyun.svideosdk.facearengine;

/* loaded from: classes12.dex */
public class FaceAREngine {
    private long mNativeHandle = 0;

    private native java.lang.Object nativeGetOrganLocation(long j);

    private native long nativeInitialize(byte[] bArr, int i, int i2, int i3);

    private native void nativeRelease(long j);

    private native int nativeRenderImageData(long j, byte[] bArr, int i, int i2, int i3);

    private native int nativeRenderVideoData(long j, byte[] bArr, int i, int i2, int i3);

    private native void nativeSetBuffingIntensity(long j, int i);

    private native void nativeSetEnLargeEyeIntensity(long j, float f);

    private native void nativeSetFaceReddenABGR(long j, int i);

    private native void nativeSetFaceReddenIntensity(long j, int i);

    private native void nativeSetFaceWhitenIntensity(long j, int i);

    private native void nativeSetMaxFaceCount(long j, int i);

    private native void nativeSetPullJawIntensity(long j, float f);

    private native int nativeSetRenderMode(long j, int i);

    private native void nativeSetRenderRotationAndSize(long j, int i, int i2, int i3);

    private native void nativeSetSlimIntensity(long j, float f);

    private native void nativeSwitchFaceDetect(long j, boolean z);

    public com.aliyun.svideosdk.facearengine.FaceAROrganLocation getFaceOrganLocation() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return (com.aliyun.svideosdk.facearengine.FaceAROrganLocation) nativeGetOrganLocation(j);
        }
        return null;
    }

    public int init(byte[] bArr, int i, int i2, int i3) {
        if (this.mNativeHandle != 0) {
            return -4;
        }
        long nativeInitialize = nativeInitialize(bArr, i, i2, i3);
        this.mNativeHandle = nativeInitialize;
        return nativeInitialize == 0 ? -4 : 0;
    }

    public void release() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeRelease(j);
        }
    }

    public int renderImageData(byte[] bArr, int i, int i2) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeRenderImageData(j, bArr, bArr.length, i, i2);
        }
        return 1073754196;
    }

    public int renderVideoData(byte[] bArr, int i, int i2) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeRenderVideoData(j, bArr, bArr.length, i, i2);
        }
        return 1073754196;
    }

    public void setBuffingIntensity(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetBuffingIntensity(j, i);
        }
    }

    public void setEnLargeEyeIntensity(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetEnLargeEyeIntensity(j, f);
        }
    }

    public void setFaceReddenABGR(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetFaceReddenABGR(j, i);
        }
    }

    public void setFaceReddenIntensity(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetFaceReddenIntensity(j, i);
        }
    }

    public void setFaceWhitenIntensity(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetFaceWhitenIntensity(j, i);
        }
    }

    public void setMaxFaceCount(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetMaxFaceCount(j, i);
        }
    }

    public void setPullJawIntensity(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetPullJawIntensity(j, f);
        }
    }

    public int setRenderMode(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeSetRenderMode(j, i);
        }
        return 1073754196;
    }

    public void setRenderRotationAndSize(int i, int i2, int i3) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetRenderRotationAndSize(j, i, i2, i3);
        }
    }

    public void setSlimIntensity(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetSlimIntensity(j, f);
        }
    }

    public void switchFaceDetect(boolean z) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSwitchFaceDetect(j, z);
        }
    }
}
